package com.rocway.dependencyInjection.source.impl;

import com.rocway.dependencyInjection.source.FXNewsBean;
import com.rocway.dependencyInjection.source.IFXNewsPersister;

public class FXNewsPersisterImpl implements IFXNewsPersister {
    @Override
    public boolean persistNews(FXNewsBean newsBean) {
        return false;
    }
}
