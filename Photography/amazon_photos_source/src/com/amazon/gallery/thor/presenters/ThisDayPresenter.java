// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.presenters;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.thor.interactors.ThisDayInteractor;
import com.amazon.gallery.thor.thisday.ThisDayViewCollection;
import com.amazon.gallery.thor.view.AsyncDataLoadingView;

public class ThisDayPresenter
    implements com.amazon.gallery.thor.interactors.ThisDayInteractor.ThisDayDataObserver
{

    private final ThisDayInteractor interactor;
    private final Handler resultReporter = new Handler();
    private AsyncDataLoadingView view;

    public ThisDayPresenter(AsyncDataLoadingView asyncdataloadingview, Context context, MediaItemDao mediaitemdao)
    {
        view = asyncdataloadingview;
        interactor = new ThisDayInteractor(context, mediaitemdao);
    }

    public void loadDataAsync(int i, boolean flag)
    {
        interactor.registerDataObserver(this);
        view.onStartLoadData();
        interactor.loadDataAsync(i, flag);
    }

    public void onDataRefreshed(final ThisDayViewCollection data)
    {
        resultReporter.post(new Runnable() {

            final ThisDayPresenter this$0;
            final ThisDayViewCollection val$data;

            public void run()
            {
                view.onDataLoaded(data);
            }

            
            {
                this$0 = ThisDayPresenter.this;
                data = thisdayviewcollection;
                super();
            }
        });
    }

    public void onViewCreated(Bundle bundle)
    {
        interactor.start();
    }

    public void onViewDestroyed()
    {
        interactor.stop();
    }

    public void onViewPaused()
    {
        interactor.unregisterDataObserver(this);
    }

    public void onViewResumed()
    {
    }

    public void updateView(AsyncDataLoadingView asyncdataloadingview)
    {
        view = asyncdataloadingview;
    }

}
