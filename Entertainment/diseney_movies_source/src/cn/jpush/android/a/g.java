// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.a;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import cn.jpush.android.util.x;

// Referenced classes of package cn.jpush.android.a:
//            h

public final class g
{

    private static final String z[];
    public double a;
    public double b;
    private Context c;
    private LocationManager d;
    private Location e;
    private String f;
    private long g;
    private final LocationListener h = new h(this);

    public g(Context context)
    {
        c = context;
        context = z[1];
        d = (LocationManager)c.getSystemService(context);
    }

    private void a(Location location)
    {
        if (location != null)
        {
            try
            {
                a = location.getLatitude();
                b = location.getLongitude();
                g = System.currentTimeMillis();
                f = String.format(z[0], new Object[] {
                    Double.valueOf(a), Double.valueOf(b), Double.valueOf(location.getAltitude()), Float.valueOf(location.getBearing()), Float.valueOf(location.getAccuracy())
                });
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Location location)
            {
                location.getMessage();
            }
            x.f();
        }
        f = "";
    }

    static void a(g g1, Location location)
    {
        g1.a(location);
    }

    public final boolean a()
    {
        return d.isProviderEnabled(z[2]);
    }

    public final void b()
    {
        Object obj = new Criteria();
        ((Criteria) (obj)).setAccuracy(1);
        ((Criteria) (obj)).setAltitudeRequired(false);
        ((Criteria) (obj)).setBearingRequired(false);
        ((Criteria) (obj)).setCostAllowed(true);
        ((Criteria) (obj)).setPowerRequirement(1);
        obj = d.getBestProvider(((Criteria) (obj)), true);
        e = d.getLastKnownLocation(((String) (obj)));
        if (e != null)
        {
            a(e);
        }
        d.requestLocationUpdates(((String) (obj)), 2000L, 10F, h);
    }

    public final void c()
    {
        d.removeUpdates(h);
    }

    public final String d()
    {
        return f;
    }

    public final long e()
    {
        return g;
    }

    static 
    {
        Object obj1;
        String as2[];
        int i;
        int j;
        as2 = new String[3];
        obj1 = "\nZDfgSB\ra?S\024F`1K]N+1\020\024\\%)T\036\004%q\024\031Z%)T\036\004%r\022\033\n=6\027\005";
        i = -1;
        j = 0;
_L10:
        Object obj;
        String as[];
        int k;
        int l;
        int i1;
        int j1;
        obj = as2;
        obj1 = ((String) (obj1)).toCharArray();
        k = obj1.length;
        if (k > 1)
        {
            break MISSING_BLOCK_LABEL_281;
        }
        l = 0;
        as = ((String []) (obj));
        i1 = j;
        obj = obj1;
        j1 = i;
_L9:
        j = l;
_L7:
        int k1;
        obj1 = obj;
        k1 = obj1[l];
        j % 5;
        JVM INSTR tableswitch 0 3: default 96
    //                   0 253
    //                   1 260
    //                   2 267
    //                   3 274;
           goto _L1 _L2 _L3 _L4 _L5
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        i = 19;
_L11:
label0:
        {
            obj1[l] = (char)(i ^ k1);
            j++;
            if (k != 0)
            {
                break label0;
            }
            l = k;
        }
        if (true) goto _L7; else goto _L6
        String as1[];
        int l1;
        i = k;
        as1 = as;
        l1 = i1;
        obj1 = obj;
        k1 = j1;
_L12:
        j1 = k1;
        obj = obj1;
        i1 = l1;
        as = as1;
        k = i;
        l = j;
        if (i > j) goto _L9; else goto _L8
_L8:
        obj = (new String(((char []) (obj1)))).intern();
        switch (k1)
        {
        default:
            as1[l1] = ((String) (obj));
            obj1 = "\035\027Kfg\030\027F";
            j = 1;
            i = 0;
            break;

        case 0: // '\0'
            as1[l1] = ((String) (obj));
            j = 2;
            obj1 = "\026\b[";
            i = 1;
            break;

        case 1: // '\001'
            as1[l1] = ((String) (obj));
            z = as2;
            return;
        }
          goto _L10
_L6:
        i = 113;
          goto _L11
_L3:
        i = 120;
          goto _L11
_L4:
        i = 40;
          goto _L11
_L5:
        i = 7;
          goto _L11
        boolean flag = false;
        k1 = i;
        l1 = j;
        as1 = ((String []) (obj));
        i = k;
        j = ((flag) ? 1 : 0);
          goto _L12
    }
}
