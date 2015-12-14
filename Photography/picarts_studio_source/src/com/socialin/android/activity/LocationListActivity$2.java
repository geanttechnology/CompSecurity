// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.activity;

import android.os.AsyncTask;
import com.picsart.studio.utils.c;
import com.picsart.studio.utils.d;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.socialin.android.activity:
//            LocationListActivity, c

final class a extends AsyncTask
{

    private LocationListActivity a;

    protected final Object doInBackground(Object aobj[])
    {
        aobj = (Double[])aobj;
        return c.a(a.getApplicationContext(), ((Double) (aobj[0])).doubleValue(), ((Double) (aobj[1])).doubleValue());
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (List)obj;
        super.onPostExecute(obj);
        if (obj != null)
        {
            LocationListActivity.access$100(a);
            d d1;
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); LocationListActivity.access$000(a).add(new com.socialin.android.activity.c(d1.b, d1.h)))
            {
                d1 = (d)((Iterator) (obj)).next();
            }

        }
    }

    cationAdapter(LocationListActivity locationlistactivity)
    {
        a = locationlistactivity;
        super();
    }
}
