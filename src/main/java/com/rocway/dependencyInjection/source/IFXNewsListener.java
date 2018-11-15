package com.rocway.dependencyInjection.source;

public interface IFXNewsListener {

    String[] getAvalableNewsIds();

    FXNewsBean getNewsbyPK(String newsId);


}
