// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.poshmark.application.PMApplication;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.controllers.GlobalDbController;
import com.poshmark.controllers.RecentBrandsController;
import com.poshmark.data_model.models.MetaItem;
import com.poshmark.utils.DateUtils;
import com.poshmark.utils.MetaItemList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

// Referenced classes of package com.poshmark.db:
//            PMDbContentProvider, AllBrandsModel

public class RecentBrandsUpdater extends AsyncTask
    implements TraceFieldInterface
{

    private static final List DEFAULT_RECENT_BRANDS = new ArrayList(Arrays.asList(new String[] {
        "Tory Burch", "Michael Kors", "Coach", "Louis Vuitton", "Gucci", "kate spade", "J. Crew", "Steve Madden", "Juicy Couture", "Free People", 
        "lululemon athletica"
    }));
    public Trace _nr_trace;
    boolean clearAllRows;
    AllBrandsModel data;

    public RecentBrandsUpdater()
    {
        clearAllRows = false;
    }

    private void cleanupCursor(Cursor cursor)
    {
        if (cursor != null)
        {
            cursor.close();
        }
    }

    private void populateRecentsDb()
    {
        Object obj1 = PMApplicationSession.GetPMSession().getUserId();
        Object obj = String.format("select * from recent_brands WHERE user='%s' ORDER BY insert_dtm COLLATE NOCASE DESC", new Object[] {
            obj1
        });
        obj = PMApplication.getContext().getContentResolver().query(PMDbContentProvider.CONTENT_URI_RECENTS_BRANDS, null, ((String) (obj)), null, null);
        if (obj != null && ((Cursor) (obj)).getCount() == 0)
        {
            ContentValues contentvalues;
            for (ListIterator listiterator = DEFAULT_RECENT_BRANDS.listIterator(DEFAULT_RECENT_BRANDS.size()); listiterator.hasPrevious(); PMApplication.getContext().getContentResolver().insert(PMDbContentProvider.CONTENT_URI_RECENTS_BRANDS, contentvalues))
            {
                String s = DateUtils.getTimeStampStringFromUTCDate(new Date());
                String s1 = (String)listiterator.previous();
                contentvalues = new ContentValues();
                contentvalues.put("canonical_name", s1);
                contentvalues.put("user", ((String) (obj1)));
                contentvalues.put("insert_dtm", s);
            }

            obj1 = RecentBrandsController.globalRecentBrandsController();
            Object obj2 = ((RecentBrandsController) (obj1)).retrieveRecentBrands(true);
            if (obj2 != null)
            {
                MetaItem metaitem;
                for (obj2 = ((MetaItemList) (obj2)).iterator(); ((Iterator) (obj2)).hasNext(); GlobalDbController.getGlobalDbController().addBrandToRecents(metaitem))
                {
                    metaitem = (MetaItem)((Iterator) (obj2)).next();
                }

                ((RecentBrandsController) (obj1)).clearGlobalRecentBrandsPref();
            }
        }
        cleanupCursor(((Cursor) (obj)));
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
        TraceMachine.enterMethod(_nr_trace, "RecentBrandsUpdater#doInBackground", null);
_L1:
        aobj = doInBackground((Void[])aobj);
        TraceMachine.exitMethod();
        TraceMachine.unloadTraceContext(this);
        return ((Object) (aobj));
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "RecentBrandsUpdater#doInBackground", null);
          goto _L1
    }

    protected transient Void doInBackground(Void avoid[])
    {
        synchronized (GlobalDbController.getGlobalDbController().getMutex())
        {
            populateRecentsDb();
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
