// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.AsyncTask;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.poshmark.application.PMApplication;
import com.poshmark.controllers.GlobalDbController;
import com.poshmark.data_model.models.Brand;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

// Referenced classes of package com.poshmark.db:
//            AllBrandsModel, PMDbContentProvider

public class AllBrandsUpdater extends AsyncTask
    implements TraceFieldInterface
{

    public Trace _nr_trace;
    boolean clearAllRows;
    AllBrandsModel data;

    public AllBrandsUpdater(AllBrandsModel allbrandsmodel, boolean flag)
    {
        clearAllRows = false;
        clearAllRows = flag;
        data = allbrandsmodel;
    }

    private void bulkInsertToBrandsTable(AllBrandsModel allbrandsmodel)
    {
        int j = allbrandsmodel.data.size();
        ContentValues acontentvalues[] = new ContentValues[j];
        for (int i = 0; i < j; i++)
        {
            Brand brand = (Brand)allbrandsmodel.data.get(i);
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("canonical_name", brand.canonical_name);
            contentvalues.put("description", "Dummy Description");
            contentvalues.put("following", Integer.valueOf(1));
            acontentvalues[i] = contentvalues;
        }

        PMApplication.getContext().getContentResolver().bulkInsert(PMDbContentProvider.CONTENT_URI_BRANDS, acontentvalues);
        updateTimeStamp("brands", allbrandsmodel.meta.updated_at);
    }

    private void cleanupCursor(Cursor cursor)
    {
        if (cursor != null)
        {
            cursor.close();
        }
    }

    private void populateDb(AllBrandsModel allbrandsmodel)
    {
        Cursor cursor = PMApplication.getContext().getContentResolver().query(PMDbContentProvider.CONTENT_URI_BRANDS, null, " SELECT * from brands", null, null);
        if (cursor == null || cursor.getCount() != 0) goto _L2; else goto _L1
_L1:
        Object obj = allbrandsmodel;
        if (allbrandsmodel != null) goto _L4; else goto _L3
_L3:
        obj = (new GsonBuilder()).create();
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(PMApplication.getContext().getResources().getAssets().open("listing_meta/allBrands.json"), "UTF-8"));
        if (obj instanceof Gson) goto _L6; else goto _L5
_L5:
        obj = ((Gson) (obj)).fromJson(bufferedreader, com/poshmark/db/AllBrandsModel);
_L7:
        obj = (AllBrandsModel)obj;
_L4:
        bulkInsertToBrandsTable(((AllBrandsModel) (obj)));
_L2:
        cleanupCursor(cursor);
        return;
_L6:
        obj = GsonInstrumentation.fromJson((Gson)obj, bufferedreader, com/poshmark/db/AllBrandsModel);
          goto _L7
        Object obj1;
        obj1;
        ((FileNotFoundException) (obj1)).printStackTrace();
        obj1 = allbrandsmodel;
          goto _L4
        obj1;
        ((IOException) (obj1)).printStackTrace();
        obj1 = allbrandsmodel;
          goto _L4
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
        TraceMachine.enterMethod(_nr_trace, "AllBrandsUpdater#doInBackground", null);
_L1:
        aobj = doInBackground((Void[])aobj);
        TraceMachine.exitMethod();
        TraceMachine.unloadTraceContext(this);
        return ((Object) (aobj));
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "AllBrandsUpdater#doInBackground", null);
          goto _L1
    }

    protected transient Void doInBackground(Void avoid[])
    {
        synchronized (GlobalDbController.getGlobalDbController().getMutex())
        {
            if (clearAllRows)
            {
                PMApplication.getContext().getContentResolver().delete(PMDbContentProvider.CONTENT_URI_BRANDS, null, null);
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
