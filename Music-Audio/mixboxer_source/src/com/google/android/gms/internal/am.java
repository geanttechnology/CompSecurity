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
//            ao, ap, an, ct, 
//            cw, i, h, cr, 
//            cu, bk, d

public final class am
{

    public static final an fn = new an() {

        public void a(cw cw1, Map map)
        {
            map = (String)map.get("urls");
            if (map == null)
            {
                ct.v("URLs missing in canOpenURLs GMSG.");
                return;
            }
            String as[] = map.split(",");
            HashMap hashmap = new HashMap();
            PackageManager packagemanager = cw1.getContext().getPackageManager();
            int j = as.length;
            int i = 0;
            while (i < j) 
            {
                String s = as[i];
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
            cw1.a("openableURLs", hashmap);
        }

    };
    public static final an fo = new an() {

        public void a(cw cw1, Map map)
        {
            String s;
            s = (String)map.get("u");
            if (s == null)
            {
                ct.v("URL missing from click GMSG.");
                return;
            }
            map = Uri.parse(s);
            Object obj = cw1.aD();
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_59;
            }
            if (!((h) (obj)).a(map))
            {
                break MISSING_BLOCK_LABEL_59;
            }
            obj = ((h) (obj)).a(map, cw1.getContext());
            map = ((Map) (obj));
_L2:
            map = map.toString();
            (new cr(cw1.getContext(), cw1.aE().iJ, map)).start();
            return;
            i j;
            j;
            ct.v((new StringBuilder()).append("Unable to append parameter to URL: ").append(s).toString());
            if (true) goto _L2; else goto _L1
_L1:
        }

    };
    public static final an fp = new an() {

        public void a(cw cw1, Map map)
        {
            cw1 = cw1.aB();
            if (cw1 == null)
            {
                ct.v("A GMSG tried to close something that wasn't an overlay.");
                return;
            } else
            {
                cw1.close();
                return;
            }
        }

    };
    public static final an fq = new an() {

        public void a(cw cw1, Map map)
        {
            cw1 = cw1.aB();
            if (cw1 == null)
            {
                ct.v("A GMSG tried to use a custom close button on something that wasn't an overlay.");
                return;
            } else
            {
                cw1.g("1".equals(map.get("custom_close")));
                return;
            }
        }

    };
    public static final an fr = new an() {

        public void a(cw cw1, Map map)
        {
            map = (String)map.get("u");
            if (map == null)
            {
                ct.v("URL missing from httpTrack GMSG.");
                return;
            } else
            {
                (new cr(cw1.getContext(), cw1.aE().iJ, map)).start();
                return;
            }
        }

    };
    public static final an fs = new an() {

        public void a(cw cw, Map map)
        {
            ct.t((new StringBuilder()).append("Received log message: ").append((String)map.get("string")).toString());
        }

    };
    public static final an ft = new ao();
    public static final an fu = new an() {

        public void a(cw cw1, Map map)
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
                cw1 = cw1.aD();
            }
            // Misplaced declaration of an exception variable
            catch (cw cw1)
            {
                ct.v("Could not parse touch parameters from gmsg.");
                return;
            }
            if (cw1 == null)
            {
                break MISSING_BLOCK_LABEL_80;
            }
            cw1.g().a(i, j, k);
        }

    };
    public static final an fv = new ap();

}
