// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.activity;

import android.os.AsyncTask;
import com.google.android.gms.maps.GoogleMap;
import com.picsart.studio.utils.c;
import com.picsart.studio.utils.d;
import com.picsart.studio.utils.e;
import java.util.List;

// Referenced classes of package com.picsart.studio.activity:
//            MapActivity, a

final class d extends AsyncTask
{

    private boolean a;
    private double b;
    private double c;
    private String d;
    private MapActivity e;

    protected final Object doInBackground(Object aobj[])
    {
        return com.picsart.studio.utils.c.a(b, c, d);
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (List)obj;
        super.onPostExecute(obj);
        e.b(true);
        e.a(false);
        if (obj == null || ((List) (obj)).isEmpty()) goto _L2; else goto _L1
_L1:
        if (!a) goto _L4; else goto _L3
_L3:
        MapActivity.a(e, (double)((d)((List) (obj)).get(0)).d.a / 1000000D, (double)((d)((List) (obj)).get(0)).d.b / 1000000D);
_L6:
        return;
_L4:
        MapActivity.a(e, ((List) (obj)));
        return;
_L2:
        if (a)
        {
            com.picsart.studio.activity.MapActivity.d(e).clear();
            MapActivity.a(e).clear();
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected final void onPreExecute()
    {
        MapActivity mapactivity = e;
        boolean flag;
        if (!a)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mapactivity.b(flag);
        e.a(true);
    }

    (MapActivity mapactivity, boolean flag, double d1, double d2, String s)
    {
        e = mapactivity;
        a = flag;
        b = d1;
        c = d2;
        d = s;
        super();
    }
}
