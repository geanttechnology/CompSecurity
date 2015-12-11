// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.commonlib.loader;

import android.content.AsyncTaskLoader;
import android.content.Context;
import com.google.inject.Key;
import com.google.inject.name.Names;
import com.groupon.v3.loader.UniversalListLoadResultData;
import com.groupon.v3.processor.BackgroundDataProcessor;
import com.squareup.otto.Bus;
import commonlib.loader.event.UpdateEvent;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

// Referenced classes of package com.groupon.v3.commonlib.loader:
//            ListLoaderCallbacksV3

public static abstract class eventClass extends AsyncTaskLoader
{

    protected BackgroundDataProcessor backgroundDataProcessors[];
    protected Class dataClass;
    protected UniversalListLoadResultData entities;
    protected Class eventClass;
    private Bus globalBus;
    protected Object listener;

    public void deliverResult(UniversalListLoadResultData universallistloadresultdata)
    {
        if (isReset() && universallistloadresultdata != null)
        {
            onReleaseResources(universallistloadresultdata);
        }
        UniversalListLoadResultData universallistloadresultdata1 = entities;
        entities = universallistloadresultdata;
        if (isStarted())
        {
            super.deliverResult(universallistloadresultdata);
        }
        if (universallistloadresultdata1 != null)
        {
            onReleaseResources(universallistloadresultdata1);
        }
    }

    public volatile void deliverResult(Object obj)
    {
        deliverResult((UniversalListLoadResultData)obj);
    }

    public void onCanceled(UniversalListLoadResultData universallistloadresultdata)
    {
        super.onCanceled(universallistloadresultdata);
        onReleaseResources(universallistloadresultdata);
    }

    public volatile void onCanceled(Object obj)
    {
        onCanceled((UniversalListLoadResultData)obj);
    }

    protected void onReleaseResources(UniversalListLoadResultData universallistloadresultdata)
    {
    }

    protected void onReset()
    {
        super.onReset();
        onStopLoading();
        if (entities != null)
        {
            onReleaseResources(entities);
            entities = null;
        }
        if (globalBus != null)
        {
            globalBus.unregister(listener);
            globalBus = null;
        }
    }

    protected void onStartLoading()
    {
        if (entities != null)
        {
            deliverResult(entities);
        }
        if (globalBus == null)
        {
            globalBus = (Bus)RoboGuice.getInjector(getContext()).getInstance(Key.get(com/squareup/otto/Bus, Names.named("GlobalEventManager")));
            globalBus.register(listener);
        }
        if (takeContentChanged() || entities == null)
        {
            forceLoad();
        }
    }

    protected void onStopLoading()
    {
        cancelLoad();
    }

    public void setBackgroundDataProcessors(BackgroundDataProcessor abackgrounddataprocessor[])
    {
        backgroundDataProcessors = abackgrounddataprocessor;
    }

    protected abstract boolean shouldReload(UpdateEvent updateevent);

    public _cls1.this._cls0(Class class1, Class class2, Context context)
    {
        super(context);
        listener = new Object() {

            final ListLoaderCallbacksV3.ListLoader this$0;

            public void onEvent(UpdateEvent updateevent)
            {
                if (updateevent.getClass() == eventClass && shouldReload(updateevent))
                {
                    forceLoad();
                }
            }

            
            {
                this$0 = ListLoaderCallbacksV3.ListLoader.this;
                super();
            }
        };
        dataClass = class1;
        eventClass = class2;
    }
}
