// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.db;

import android.os.AsyncTask;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.poshmark.controllers.GlobalDbController;
import com.poshmark.controllers.SavedSearchController;
import com.poshmark.data_model.models.SuggestedSearchItem;
import java.util.Iterator;
import java.util.List;

public class SavedSearchesUpdater extends AsyncTask
    implements TraceFieldInterface
{

    public Trace _nr_trace;

    public SavedSearchesUpdater()
    {
    }

    private void populateDb()
    {
        SavedSearchController savedsearchcontroller = SavedSearchController.getGlobalSavedSearchController();
        Object obj = savedsearchcontroller.getAllSavedSearches();
        if (obj != null && ((List) (obj)).size() > 0)
        {
            SuggestedSearchItem suggestedsearchitem;
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); GlobalDbController.getGlobalDbController().addNewSearchToSavedSearches(suggestedsearchitem.kw))
            {
                suggestedsearchitem = (SuggestedSearchItem)((Iterator) (obj)).next();
            }

            savedsearchcontroller.clearAll();
            savedsearchcontroller.commit();
        }
    }

    public void _nr_setTrace(Trace trace)
    {
        try
        {
            _nr_trace = trace;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Trace trace)
        {
            return;
        }
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        TraceMachine.enterMethod(_nr_trace, "SavedSearchesUpdater#doInBackground", null);
_L1:
        aobj = doInBackground((Void[])aobj);
        TraceMachine.exitMethod();
        TraceMachine.unloadTraceContext(this);
        return ((Object) (aobj));
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "SavedSearchesUpdater#doInBackground", null);
          goto _L1
    }

    protected transient Void doInBackground(Void avoid[])
    {
        synchronized (GlobalDbController.getGlobalDbController().getMutex())
        {
            populateDb();
        }
        return null;
        exception;
        avoid;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected void onPreExecute()
    {
    }
}
