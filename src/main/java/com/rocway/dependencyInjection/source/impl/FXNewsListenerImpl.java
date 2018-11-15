package com.rocway.dependencyInjection.source.impl;

import com.rocway.dependencyInjection.source.FXNewsBean;
import com.rocway.dependencyInjection.source.IFXNewsListener;

public class FXNewsListenerImpl implements IFXNewsListener {
    @Override
    public String[] getAvalableNewsIds() {
        return new String[]{"news_one", "news_first"};
    }

    @Override
    public FXNewsBean getNewsbyPK(String newsId) {
        System.out.println("news from " + newsId);
        return new FXNewsBean();
    }
}
