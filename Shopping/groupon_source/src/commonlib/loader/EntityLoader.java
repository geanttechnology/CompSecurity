// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package commonlib.loader;

import android.content.AsyncTaskLoader;
import android.content.Context;
import com.google.inject.Key;
import com.google.inject.name.Names;
import com.squareup.otto.Bus;
import commonlib.loader.event.UpdateEvent;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

public abstract class EntityLoader extends AsyncTaskLoader
{

    private Object entity;
    private Class eventClass;
    private Bus globalBus;
    protected Object listener;

    public EntityLoader(Class class1, Class class2, Context context)
    {
        super(context);
        listener = new Object() {

            final EntityLoader this$0;

            public void onEvent(UpdateEvent updateevent)
            {
                if (updateevent.getClass() == eventClass && shouldReload(updateevent))
                {
                    forceLoad();
                }
            }

            
            {
                this$0 = EntityLoader.this;
                super();
            }
        };
        eventClass = class2;
    }

    public void deliverResult(Object obj)
    {
        if (isReset() && obj != null)
        {
            onReleaseResources(obj);
        }
        Object obj1 = entity;
        entity = obj;
        if (isStarted())
        {
            super.deliverResult(obj);
        }
        if (obj1 != null)
        {
            onReleaseResources(obj1);
        }
    }

    public void onCanceled(Object obj)
    {
        super.onCanceled(obj);
        onReleaseResources(obj);
    }

    protected void onReleaseResources(Object obj)
    {
    }

    protected void onReset()
    {
        super.onReset();
        onStopLoading();
        if (entity != null)
        {
            onReleaseResources(entity);
            entity = null;
        }
        if (globalBus != null)
        {
            globalBus.unregister(listener);
            globalBus = null;
        }
    }

    protected void onStartLoading()
    {
        if (entity != null)
        {
            deliverResult(entity);
        }
        if (globalBus == null)
        {
            globalBus = (Bus)RoboGuice.getInjector(getContext()).getInstance(Key.get(com/squareup/otto/Bus, Names.named("GlobalEventManager")));
            globalBus.register(listener);
        }
        if (takeContentChanged() || entity == null)
        {
            forceLoad();
        }
    }

    protected void onStopLoading()
    {
        cancelLoad();
    }

    protected abstract boolean shouldReload(UpdateEvent updateevent);

}
