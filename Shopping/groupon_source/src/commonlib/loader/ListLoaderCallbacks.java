// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package commonlib.loader;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.content.Loader;
import android.os.Bundle;
import com.google.inject.Key;
import com.google.inject.name.Names;
import com.squareup.otto.Bus;
import commonlib.adapter.JavaAdapter;
import commonlib.loader.event.UpdateEvent;
import java.util.Collections;
import java.util.List;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

public abstract class ListLoaderCallbacks
    implements android.app.LoaderManager.LoaderCallbacks
{
    public static abstract class ListLoader extends AsyncTaskLoader
    {

        private List entities;
        private Class eventClass;
        private Bus globalBus;
        protected Object listener;

        public volatile void deliverResult(Object obj)
        {
            deliverResult((List)obj);
        }

        public void deliverResult(List list)
        {
            if (isReset() && list != null)
            {
                onReleaseResources(list);
            }
            List list1 = entities;
            entities = list;
            if (isStarted())
            {
                super.deliverResult(list);
            }
            if (list1 != null)
            {
                onReleaseResources(list1);
            }
        }

        public volatile void onCanceled(Object obj)
        {
            onCanceled((List)obj);
        }

        public void onCanceled(List list)
        {
            super.onCanceled(list);
            onReleaseResources(list);
        }

        protected void onReleaseResources(List list)
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

        protected abstract boolean shouldReload(UpdateEvent updateevent);


        public ListLoader(Class class1, Class class2, Context context)
        {
            super(context);
            listener = new _cls1();
            eventClass = class2;
        }
    }


    protected JavaAdapter listAdapter;

    public ListLoaderCallbacks(JavaAdapter javaadapter)
    {
        listAdapter = javaadapter;
    }

    public abstract Loader onCreateLoader(int i, Bundle bundle);

    public volatile void onLoadFinished(Loader loader, Object obj)
    {
        onLoadFinished(loader, (List)obj);
    }

    public void onLoadFinished(Loader loader, List list)
    {
        listAdapter.setList(list);
    }

    public void onLoaderReset(Loader loader)
    {
        listAdapter.setList(Collections.EMPTY_LIST);
    }

    // Unreferenced inner class commonlib/loader/ListLoaderCallbacks$ListLoader$1

/* anonymous class */
    class ListLoader._cls1
    {

        final ListLoader this$0;

        public void onEvent(UpdateEvent updateevent)
        {
            if (updateevent.getClass() == eventClass && shouldReload(updateevent))
            {
                forceLoad();
            }
        }

            
            {
                this$0 = ListLoader.this;
                super();
            }
    }

}
