package com.rocway.dependencyInjection.source;

public class NewsProvider {

    private IFXNewsListener newsListener;
    private IFXNewsPersister newsPersister;

    public NewsProvider() {

    }

    public NewsProvider(IFXNewsListener newsListener, IFXNewsPersister newsPersister) {
        this.newsListener = newsListener;
        this.newsPersister = newsPersister;
    }

    public void setNewsListener(IFXNewsListener newsListener) {
        this.newsListener = newsListener;
    }

    public void setNewsPersister(IFXNewsPersister newsPersister) {
        this.newsPersister = newsPersister;
    }

    public void getAndPersistNews() {
        String[] newsIds = newsListener.getAvalableNewsIds();
        if (newsIds != null) {
            for (String newsId : newsIds) {
                FXNewsBean newsBean = newsListener.getNewsbyPK(newsId);
                newsPersister.persistNews(newsBean);
            }
        }
    }
}
