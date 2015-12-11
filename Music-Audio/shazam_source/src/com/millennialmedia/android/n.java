// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import java.lang.ref.WeakReference;
import java.util.Map;

// Referenced classes of package com.millennialmedia.android:
//            ai, ac, ab, aj, 
//            OverlaySettings, al, ao, ak, 
//            d, e

class n extends ai
{

    private static final String a = com/millennialmedia/android/n.getName();

    n()
    {
    }

    private aj a(Map map)
    {
        Object obj = (String)map.get("url");
        Context context = (Context)b.get();
        if (obj != null && context != null)
        {
            obj = new Intent("android.intent.action.VIEW", Uri.parse(((String) (obj))));
            long l = a((String)map.get("PROPERTY_EXPANDING"));
            an.a.a(context, "browser", l);
            au.b.b(context, ((Intent) (obj)));
            map = ac.a(l);
            if (map != null && !((ab) (map)).j)
            {
                an.a.d(map);
            }
            return aj.a("Success.");
        } else
        {
            return null;
        }
    }

    private aj b(Map map)
    {
        Object obj = (String)map.get("PROPERTY_BANNER_TYPE");
        if (obj != null && !Boolean.parseBoolean(((String) (obj))))
        {
            return aj.b("Cannot expand a non banner ad");
        }
        String s = (String)map.get("url");
        String s5 = (String)map.get("transparent");
        String s6 = (String)map.get("useCustomClose");
        String s7 = (String)map.get("transition");
        obj = (String)map.get("orientation");
        String s1 = (String)map.get("transitionDuration");
        String s2 = (String)map.get("height");
        String s3 = (String)map.get("width");
        String s4 = (String)map.get("modal");
        String s8 = (String)map.get("PROPERTY_EXPANDING");
        String s9 = (String)map.get("allowOrientationChange");
        Context context = (Context)b.get();
        if (context != null)
        {
            OverlaySettings overlaysettings = new OverlaySettings();
            if (s != null)
            {
                overlaysettings.h = s;
            }
            if (s8 != null)
            {
                overlaysettings.r = (int)Float.parseFloat(s8);
            }
            if (s5 != null)
            {
                overlaysettings.b = Boolean.parseBoolean(s5);
            }
            if (s6 != null)
            {
                overlaysettings.a = Boolean.parseBoolean(s6);
            }
            if (s7 != null)
            {
                overlaysettings.f = s7;
            }
            if (s9 != null)
            {
                overlaysettings.l = Boolean.parseBoolean(s9);
            }
            if (obj == null)
            {
                obj = (String)map.get("forceOrientation");
            }
            if (obj != null)
            {
                overlaysettings.g = ((String) (obj));
            }
            if (s2 != null)
            {
                overlaysettings.i = (int)Float.parseFloat(s2);
            }
            if (s3 != null)
            {
                overlaysettings.j = (int)Float.parseFloat(s3);
            }
            if (s4 != null)
            {
                overlaysettings.k = Boolean.parseBoolean(s4);
            }
            long l;
            if (s1 != null)
            {
                try
                {
                    overlaysettings.c = Long.parseLong(s1) * 1000L;
                }
                catch (Exception exception)
                {
                    al.a(a, "Problem converting transitionDuration", exception);
                }
            }
            obj = new Intent();
            if (s != null)
            {
                ((Intent) (obj)).setData(Uri.parse(s));
            }
            ((Intent) (obj)).putExtra("settings", overlaysettings);
            ((Intent) (obj)).putExtra("internalId", overlaysettings.r);
            au.b.a(context, ((Intent) (obj)));
            l = a((String)map.get("PROPERTY_EXPANDING"));
            an.a.a(context, l);
            if (ac.a(l) != null)
            {
                an.a.d(ac.a(l));
            }
            return aj.a("Success.");
        } else
        {
            return null;
        }
    }

    final aj a(String s, Map map)
    {
        Object obj1 = null;
        if (!"close".equals(s)) goto _L2; else goto _L1
_L1:
        Object obj;
        s = (ao)c.get();
        if (s != null)
        {
            s.f().a();
            s = aj.a("Success.");
        } else
        {
            s = null;
        }
        obj = s;
_L12:
        return ((aj) (obj));
_L2:
        if ("expandToExternalBrowser".equals(s))
        {
            return a(map);
        }
        if ("expandWithProperties".equals(s))
        {
            return b(map);
        }
        if ("open".equals(s))
        {
            return a(map);
        }
        if (!"setOrientation".equals(s))
        {
            break MISSING_BLOCK_LABEL_355;
        }
        s = (String)map.get("forceOrientation");
        obj = b();
        if (obj == null) goto _L4; else goto _L3
_L3:
        if ("none".equals(s)) goto _L6; else goto _L5
_L5:
        if (!"portrait".equals(s)) goto _L8; else goto _L7
_L7:
        ((d) (obj)).a.g = "portrait";
        ((d) (obj)).a.l = false;
        ((d) (obj)).a(1);
        s = aj.a("portrait");
_L10:
        if (s != null)
        {
            boolean flag;
            if (((aj) (s)).c == 1 && (((aj) (s)).d instanceof String))
            {
                obj = (String)((aj) (s)).d;
                if (((String) (obj)).contains("portrait") || ((String) (obj)).contains("landscape"))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
            } else
            {
                flag = false;
            }
            if (flag)
            {
                break; /* Loop/switch isn't completed */
            }
        }
        s = (String)map.get("allowOrientationChange");
        obj = obj1;
        if (s != null)
        {
            map = b();
            obj = obj1;
            if (map != null)
            {
                map.a(Boolean.parseBoolean(s));
                return aj.a("Success.");
            }
        }
        continue; /* Loop/switch isn't completed */
_L8:
        if ("landscape".equals(s))
        {
            ((d) (obj)).a.g = "landscape";
            ((d) (obj)).a.l = false;
            ((d) (obj)).a(0);
            s = aj.a("landscape");
            continue; /* Loop/switch isn't completed */
        }
          goto _L4
_L6:
        if ("none".equals(s))
        {
            ((d) (obj)).a(true);
            s = aj.a("none");
            continue; /* Loop/switch isn't completed */
        }
_L4:
        s = null;
        if (true) goto _L10; else goto _L9
_L9:
        break; /* Loop/switch isn't completed */
        obj = obj1;
        if ("useCustomClose".equals(s))
        {
            s = (ao)c.get();
            map = (String)map.get("useCustomClose");
            obj = obj1;
            if (map != null)
            {
                obj = obj1;
                if (s != null)
                {
                    s = s.h();
                    obj = obj1;
                    if (s != null)
                    {
                        s.a(Boolean.parseBoolean(map));
                        return aj.a("Success.");
                    }
                }
            }
        }
        if (true) goto _L12; else goto _L11
_L11:
        return s;
    }

}
