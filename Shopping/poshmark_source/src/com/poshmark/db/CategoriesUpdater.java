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
import com.poshmark.data_model.models.Catalog;
import com.poshmark.data_model.models.PMColor;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

// Referenced classes of package com.poshmark.db:
//            PMDbContentProvider

public class CategoriesUpdater extends AsyncTask
    implements TraceFieldInterface
{

    public Trace _nr_trace;
    boolean clearAllRows;
    Catalog data;

    public CategoriesUpdater(Catalog catalog, boolean flag)
    {
        clearAllRows = false;
        clearAllRows = flag;
        data = catalog;
    }

    private void bulkInsertAllCategoryInfo(Catalog catalog)
    {
        if (catalog != null)
        {
            List list = catalog.getCategoryList();
            if (list != null)
            {
                int k = list.size();
                ContentValues acontentvalues[] = new ContentValues[k];
                for (int i = 0; i < k; i++)
                {
                    com.poshmark.data_model.models.Catalog.Entry entry1 = (com.poshmark.data_model.models.Catalog.Entry)list.get(i);
                    ContentValues contentvalues = new ContentValues();
                    contentvalues.put("_id", entry1.id);
                    contentvalues.put("canonical_name", entry1.display);
                    acontentvalues[i] = contentvalues;
                }

                PMApplication.getContext().getContentResolver().bulkInsert(PMDbContentProvider.CONTENT_URI_CATEGORY, acontentvalues);
                for (int j = 0; j < k; j++)
                {
                    com.poshmark.data_model.models.Catalog.Entry entry = (com.poshmark.data_model.models.Catalog.Entry)list.get(j);
                    insertSizesForCategory(entry.sizes, entry.id);
                    insertStyleTagsForCategory(entry.category_features, entry.id);
                }

                insertColors(catalog.colors);
                updateTimeStamp("category", catalog.updated_at);
            }
        }
    }

    private void insertColors(List list)
    {
        if (list != null)
        {
            int j = list.size();
            ContentValues acontentvalues[] = new ContentValues[j];
            for (int i = 0; i < j; i++)
            {
                PMColor pmcolor = (PMColor)list.get(i);
                ContentValues contentvalues = new ContentValues();
                contentvalues.put("_id", pmcolor.name);
                contentvalues.put("rgb", pmcolor.rgb);
                acontentvalues[i] = contentvalues;
            }

            PMApplication.getContext().getContentResolver().bulkInsert(PMDbContentProvider.CONTENT_URI_COLORS, acontentvalues);
        }
    }

    private void insertSizesForCategory(List list, String s)
    {
        if (list != null)
        {
            int j = list.size();
            ContentValues acontentvalues[] = new ContentValues[j];
            for (int i = 0; i < j; i++)
            {
                com.poshmark.data_model.models.Catalog.Size size = (com.poshmark.data_model.models.Catalog.Size)list.get(i);
                ContentValues contentvalues = new ContentValues();
                contentvalues.put("_id", s);
                contentvalues.put("short_name", size.shortName);
                contentvalues.put("long_name", size.longName);
                acontentvalues[i] = contentvalues;
            }

            PMApplication.getContext().getContentResolver().bulkInsert(PMDbContentProvider.CONTENT_URI_CATEGORY_SIZES, acontentvalues);
        }
    }

    private void insertStyleTagsForCategory(List list, String s)
    {
        if (list != null)
        {
            int j = list.size();
            ContentValues acontentvalues[] = new ContentValues[j];
            for (int i = 0; i < j; i++)
            {
                com.poshmark.data_model.models.Catalog.Entry entry = (com.poshmark.data_model.models.Catalog.Entry)list.get(i);
                ContentValues contentvalues = new ContentValues();
                contentvalues.put("_id", entry.id);
                contentvalues.put("name", entry.display);
                contentvalues.put("category_id", s);
                acontentvalues[i] = contentvalues;
            }

            PMApplication.getContext().getContentResolver().bulkInsert(PMDbContentProvider.CONTENT_URI_CATEGORY_STYLE_TAGS, acontentvalues);
        }
    }

    private void populateDb(Catalog catalog)
    {
        Object obj = PMApplication.getContext().getContentResolver().query(PMDbContentProvider.CONTENT_URI_CATEGORY, null, " SELECT * from category", null, null);
        if (obj == null || ((Cursor) (obj)).getCount() != 0) goto _L2; else goto _L1
_L1:
        obj = catalog;
        if (catalog != null) goto _L4; else goto _L3
_L3:
        obj = (new GsonBuilder()).create();
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(PMApplication.getContext().getResources().getAssets().open("listing_meta/categories.json"), "UTF-8"));
        if (obj instanceof Gson) goto _L6; else goto _L5
_L5:
        obj = ((Gson) (obj)).fromJson(bufferedreader, com/poshmark/data_model/models/Catalog);
_L7:
        obj = (Catalog)obj;
_L4:
        bulkInsertAllCategoryInfo(((Catalog) (obj)));
_L2:
        return;
_L6:
        obj = GsonInstrumentation.fromJson((Gson)obj, bufferedreader, com/poshmark/data_model/models/Catalog);
          goto _L7
        Object obj1;
        obj1;
        ((FileNotFoundException) (obj1)).printStackTrace();
        obj1 = catalog;
          goto _L4
        obj1;
        ((IOException) (obj1)).printStackTrace();
        obj1 = catalog;
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
        TraceMachine.enterMethod(_nr_trace, "CategoriesUpdater#doInBackground", null);
_L1:
        aobj = doInBackground((Void[])aobj);
        TraceMachine.exitMethod();
        TraceMachine.unloadTraceContext(this);
        return ((Object) (aobj));
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "CategoriesUpdater#doInBackground", null);
          goto _L1
    }

    protected transient Void doInBackground(Void avoid[])
    {
        synchronized (GlobalDbController.getGlobalDbController().getMutex())
        {
            if (clearAllRows)
            {
                PMApplication.getContext().getContentResolver().delete(PMDbContentProvider.CONTENT_URI_CATEGORY, null, null);
                PMApplication.getContext().getContentResolver().delete(PMDbContentProvider.CONTENT_URI_CATEGORY_SIZES, null, null);
                PMApplication.getContext().getContentResolver().delete(PMDbContentProvider.CONTENT_URI_CATEGORY_STYLE_TAGS, null, null);
                PMApplication.getContext().getContentResolver().delete(PMDbContentProvider.CONTENT_URI_CATEGORY_STYLE_TAGS, null, null);
                PMApplication.getContext().getContentResolver().delete(PMDbContentProvider.CONTENT_URI_COLORS, null, null);
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
