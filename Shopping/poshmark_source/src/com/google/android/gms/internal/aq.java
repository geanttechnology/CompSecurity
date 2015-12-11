// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            as, at, ar, da, 
//            dd, m, l, cy, 
//            db, bo, h

public final class aq
{

    public static final ar lW = new ar() {

        public void a(dd dd1, Map map)
        {
            map = (String)map.get("urls");
            if (map == null)
            {
                da.w("URLs missing in canOpenURLs GMSG.");
                return;
            }
            String as1[] = map.split(",");
            HashMap hashmap = new HashMap();
            PackageManager packagemanager = dd1.getContext().getPackageManager();
            int j = as1.length;
            int i = 0;
            while (i < j) 
            {
                String s = as1[i];
                map = s.split(";", 2);
                String s1 = map[0].trim();
                boolean flag;
                if (map.length > 1)
                {
                    map = map[1].trim();
                } else
                {
                    map = "android.intent.action.VIEW";
                }
                if (packagemanager.resolveActivity(new Intent(map, Uri.parse(s1)), 0x10000) != null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                hashmap.put(s, Boolean.valueOf(flag));
                i++;
            }
            dd1.a("openableURLs", hashmap);
        }

    };
    public static final ar lX = new ar() {

        public void a(dd dd1, Map map)
        {
            String s;
            s = (String)map.get("u");
            if (s == null)
            {
                da.w("URL missing from click GMSG.");
                return;
            }
            map = Uri.parse(s);
            Object obj = dd1.bc();
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_59;
            }
            if (!((l) (obj)).a(map))
            {
                break MISSING_BLOCK_LABEL_59;
            }
            obj = ((l) (obj)).a(map, dd1.getContext());
            map = ((Map) (obj));
_L2:
            map = map.toString();
            (new cy(dd1.getContext(), dd1.bd().pU, map)).start();
            return;
            m m1;
            m1;
            da.w((new StringBuilder()).append("Unable to append parameter to URL: ").append(s).toString());
            if (true) goto _L2; else goto _L1
_L1:
        }

    };
    public static final ar lY = new ar() {

        public void a(dd dd1, Map map)
        {
            dd1 = dd1.ba();
            if (dd1 == null)
            {
                da.w("A GMSG tried to close something that wasn't an overlay.");
                return;
            } else
            {
                dd1.close();
                return;
            }
        }

    };
    public static final ar lZ = new ar() {

        public void a(dd dd1, Map map)
        {
            dd1 = dd1.ba();
            if (dd1 == null)
            {
                da.w("A GMSG tried to use a custom close button on something that wasn't an overlay.");
                return;
            } else
            {
                dd1.g("1".equals(map.get("custom_close")));
                return;
            }
        }

    };
    public static final ar ma = new ar() {

        public void a(dd dd1, Map map)
        {
            map = (String)map.get("u");
            if (map == null)
            {
                da.w("URL missing from httpTrack GMSG.");
                return;
            } else
            {
                (new cy(dd1.getContext(), dd1.bd().pU, map)).start();
                return;
            }
        }

    };
    public static final ar mb = new ar() {

        public void a(dd dd, Map map)
        {
            da.u((new StringBuilder()).append("Received log message: ").append((String)map.get("string")).toString());
        }

    };
    public static final ar mc = new as();
    public static final ar md = new ar() {

        public void a(dd dd1, Map map)
        {
            String s = (String)map.get("tx");
            String s1 = (String)map.get("ty");
            map = (String)map.get("td");
            int i;
            int j;
            int k;
            try
            {
                i = Integer.parseInt(s);
                j = Integer.parseInt(s1);
                k = Integer.parseInt(map);
                dd1 = dd1.bc();
            }
            // Misplaced declaration of an exception variable
            catch (dd dd1)
            {
                da.w("Could not parse touch parameters from gmsg.");
                return;
            }
            if (dd1 == null)
            {
                break MISSING_BLOCK_LABEL_80;
            }
            dd1.y().a(i, j, k);
        }

    };
    public static final ar me = new at();

}
