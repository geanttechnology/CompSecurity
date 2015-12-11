// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.os.AsyncTask;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.poshmark.application.PMApplication;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.controllers.GlobalDbController;
import com.poshmark.data_model.models.Brand;
import java.util.List;

// Referenced classes of package com.poshmark.db:
//            AllBrandsModel, PMDbContentProvider

public class FollowingBrandsUpdater extends AsyncTask
    implements TraceFieldInterface
{

    public Trace _nr_trace;
    boolean clearAllRows;
    AllBrandsModel data;

    public FollowingBrandsUpdater(AllBrandsModel allbrandsmodel, boolean flag)
    {
        clearAllRows = false;
        clearAllRows = flag;
        data = allbrandsmodel;
    }

    private void bulkInsertToBrandsTable(AllBrandsModel allbrandsmodel)
    {
        String s = PMApplicationSession.GetPMSession().getUserId();
        int j = allbrandsmodel.data.size();
        ContentValues acontentvalues[] = new ContentValues[j];
        for (int i = 0; i < j; i++)
        {
            Brand brand = (Brand)allbrandsmodel.data.get(i);
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("canonical_name", brand.canonical_name);
            contentvalues.put("user", s);
            acontentvalues[i] = contentvalues;
        }

        PMApplication.getContext().getContentResolver().bulkInsert(PMDbContentProvider.CONTENT_URI_FOLLOWING_BRANDS, acontentvalues);
        updateTimeStamp(s, allbrandsmodel.meta.updated_at);
    }

    private void populateDb(AllBrandsModel allbrandsmodel)
    {
        bulkInsertToBrandsTable(allbrandsmodel);
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
        TraceMachine.enterMethod(_nr_trace, "FollowingBrandsUpdater#doInBackground", null);
_L1:
        aobj = doInBackground((Void[])aobj);
        TraceMachine.exitMethod();
        TraceMachine.unloadTraceContext(this);
        return ((Object) (aobj));
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "FollowingBrandsUpdater#doInBackground", null);
          goto _L1
    }

    protected transient Void doInBackground(Void avoid[])
    {
        synchronized (GlobalDbController.getGlobalDbController().getMutex())
        {
            if (clearAllRows)
            {
                PMApplication.getContext().getContentResolver().delete(PMDbContentProvider.CONTENT_URI_FOLLOWING_BRANDS, "user=?", new String[] {
                    PMApplicationSession.GetPMSession().getUserId()
                });
                PMApplication.getContext().getContentResolver().delete(PMDbContentProvider.CONTENT_URI_TIMESTAMPS, "tag=?", new String[] {
                    PMApplicationSession.GetPMSession().getUserId()
                });
            }
            populateDb(data);
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

    public void updateTimeStamp(String s, String s1)
    {
        PMApplication.getContext().getContentResolver().delete(PMDbContentProvider.CONTENT_URI_TIMESTAMPS, "tag=?", new String[] {
            s
        });
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("last_update_dtm", s1);
        contentvalues.put("tag", s);
        PMApplication.getContext().getContentResolver().insert(PMDbContentProvider.CONTENT_URI_TIMESTAMPS, contentvalues);
    }
}
