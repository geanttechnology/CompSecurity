// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.activity;

import android.content.res.Resources;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.ListView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.picsart.studio.utils.c;
import com.picsart.studio.utils.d;
import com.picsart.studio.utils.e;
import com.socialin.android.util.Utils;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.picsart.studio.activity:
//            MapActivity, a

final class b extends AsyncTask
{

    private double a;
    private double b;
    private MapActivity c;

    protected final Object doInBackground(Object aobj[])
    {
        return com.picsart.studio.utils.c.a(c.getApplicationContext(), a, b);
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (List)obj;
        super.onPostExecute(obj);
        c.b(true);
        c.a(false);
        com.picsart.studio.activity.MapActivity.d(c).clear();
        MapActivity.a(c).clear();
        if (obj == null || ((List) (obj)).isEmpty())
        {
            Utils.a(c, 0x7f08022f);
            return;
        }
        if (com.picsart.studio.activity.MapActivity.e(c) == null) goto _L2; else goto _L1
_L1:
        ((List) (obj)).add(0, com.picsart.studio.activity.MapActivity.e(c));
_L4:
        obj = ((List) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            d d1 = (d)((Iterator) (obj)).next();
            MapActivity.a(c).add(d1);
            if (d1.i)
            {
                LatLng latlng = new LatLng((double)d1.d.a / 1000000D, (double)d1.d.b / 1000000D);
                com.picsart.studio.activity.MapActivity.d(c).addMarker((new MarkerOptions()).position(latlng).title(d1.b));
            }
        } while (true);
        break; /* Loop/switch isn't completed */
_L2:
        if (MapActivity.f(c) != null)
        {
            MapActivity.b(c, ((List) (obj)));
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (com.picsart.studio.activity.MapActivity.c(c).getFooterViewsCount() == 0)
        {
            obj = new ImageView(c);
            ((ImageView) (obj)).setImageDrawable(c.getResources().getDrawable(0x7f0205c9));
            ((ImageView) (obj)).setPadding(0, (int)Utils.a(12F, c), 0, 0);
            com.picsart.studio.activity.MapActivity.c(c).addFooterView(((android.view.View) (obj)), null, false);
        }
        com.picsart.studio.activity.MapActivity.c(c).setAdapter(MapActivity.a(c));
        com.picsart.studio.activity.MapActivity.d(c).moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(a, b), 3F));
        com.picsart.studio.activity.MapActivity.d(c).animateCamera(CameraUpdateFactory.zoomTo(13F), 2000, null);
        return;
    }

    protected final void onPreExecute()
    {
        c.b(false);
        c.a(true);
    }

    tory(MapActivity mapactivity, double d1, double d2)
    {
        c = mapactivity;
        a = d1;
        b = d2;
        super();
    }
}
