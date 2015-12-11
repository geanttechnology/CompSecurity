// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import com.jirbo.adcolony.ah;
import com.jirbo.adcolony.ai;
import com.jirbo.adcolony.q;
import com.smule.android.c.aa;
import com.smule.android.c.w;
import com.smule.android.f.g;
import com.smule.android.network.core.b;
import com.smule.android.network.managers.UserManager;
import com.smule.android.network.managers.ap;
import com.smule.android.network.managers.d;
import com.smule.pianoandroid.magicpiano.MagicApplication;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.smule.pianoandroid.utils:
//            n

public class a
{

    public static final String a = MagicApplication.getContext().getString(0x7f0c0021);
    public static final String b = MagicApplication.getContext().getString(0x7f0c0022);
    private static final String c = com/smule/pianoandroid/utils/a.getName();
    private static boolean d = false;
    private static final String e[] = {
        a, b
    };

    public a()
    {
    }

    public static Bundle a(Map map)
    {
        boolean flag = true;
        Object obj = UserManager.n().w();
        String s = UserManager.n().x();
        Bundle bundle = new Bundle();
        bundle.putString("version", com.smule.android.network.core.b.d().h());
        bundle.putInt("sessions", n.a());
        int i;
        if (ap.a().b())
        {
            i = 1;
        } else
        {
            i = 0;
        }
        bundle.putInt("is_subs", i);
        if (UserManager.n().h())
        {
            i = 1;
        } else
        {
            i = 0;
        }
        bundle.putInt("is_reg", i);
        if (obj != null)
        {
            i = Integer.parseInt(((String) (obj)));
        } else
        {
            i = 0;
        }
        bundle.putInt("test_id", i);
        if (s != null)
        {
            i = Integer.parseInt(s);
        } else
        {
            i = 0;
        }
        bundle.putInt("group_id", i);
        if (com.smule.android.a.b != null)
        {
            bundle.putString("aifa", com.smule.android.a.b);
        }
        obj = "minipiano_android";
        if (a())
        {
            obj = (new StringBuilder()).append("minipiano_android").append(" sing_google").toString();
        }
        s = ((String) (obj));
        if (b())
        {
            s = (new StringBuilder()).append(((String) (obj))).append(" autorap_goog").toString();
        }
        bundle.putString("used", s);
        bundle.putInt("inst_days", n.a(UserManager.n().j().longValue()));
        if (com.smule.pianoandroid.f.b.a())
        {
            obj = "claimed";
        } else
        {
            obj = "unclaimed";
        }
        bundle.putString("fb_reward", ((String) (obj)));
        if (com.smule.android.facebook.a.a().c())
        {
            i = 1;
        } else
        {
            i = 0;
        }
        bundle.putInt("is_fb", i);
        if (map != null)
        {
            for (map = map.entrySet().iterator(); map.hasNext(); bundle.putString((String)((java.util.Map.Entry) (obj)).getKey(), (String)((java.util.Map.Entry) (obj)).getValue()))
            {
                obj = (java.util.Map.Entry)map.next();
            }

        }
        if (ap.a().d())
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        bundle.putInt("is_trial", i);
        aa.c(c, (new StringBuilder()).append("Custom parameters : ").append(bundle).toString());
        return bundle;
    }

    public static void a(Activity activity)
    {
        if (!d)
        {
            long l = UserManager.n().c();
            if (l != 0L)
            {
                q.a(Long.toString(l));
            } else
            {
                aa.b(c, "Player id is null when configuring AdColony");
            }
            q.b(g.a(activity));
            q.a(activity, (new StringBuilder()).append("skippable,version:").append(activity.getString(0x7f0c002f)).append(",store:google").toString(), MagicApplication.getAdColonyAppID(), e);
            q.a(new ah() {

                public void a(ai ai1)
                {
                    if (ai1.a())
                    {
                        com.smule.android.network.managers.d.a().a(12);
                    }
                }

            });
            d = true;
        }
    }

    public static boolean a()
    {
        return a("com.smule.singandroid");
    }

    public static boolean a(String s)
    {
        Object obj = MagicApplication.getContext().getPackageManager();
        try
        {
            obj = ((PackageManager) (obj)).getApplicationInfo(s, 0);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        aa.a(c, (new StringBuilder()).append("App ").append(s).append(" installed in ").append(((ApplicationInfo) (obj)).dataDir).toString());
        return true;
        aa.a(c, (new StringBuilder()).append("No info for app ").append(s).toString());
        return false;
    }

    public static boolean b()
    {
        return a("com.smule.autorap");
    }

    public static Map c()
    {
        boolean flag = true;
        String s2 = UserManager.n().w();
        String s1 = UserManager.n().x();
        HashMap hashmap = new HashMap();
        hashmap.put("app_version", com.smule.android.network.core.b.d().h());
        hashmap.put("session_count", Long.toString(w.c()));
        String s;
        int i;
        if (UserManager.n().h())
        {
            i = 1;
        } else
        {
            i = 0;
        }
        hashmap.put("is_registered", Integer.toString(i));
        if (ap.a().b())
        {
            i = 1;
        } else
        {
            i = 0;
        }
        hashmap.put("is_subs", Integer.toString(i));
        hashmap.put("install_days", Integer.toString(n.a(UserManager.n().j().longValue())));
        if (com.smule.android.facebook.a.a().c())
        {
            i = 1;
        } else
        {
            i = 0;
        }
        hashmap.put("is_facebook", Integer.toString(i));
        if (com.smule.pianoandroid.f.b.a())
        {
            s = "claimed";
        } else
        {
            s = "unclaimed";
        }
        hashmap.put("fb_reward", s);
        if (s2 != null)
        {
            s = s2;
        } else
        {
            s = "0";
        }
        hashmap.put("test_id", s);
        if (s1 != null)
        {
            s = s1;
        } else
        {
            s = "0";
        }
        hashmap.put("group_id", s);
        if (a())
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        hashmap.put("used_sing_google", Integer.toString(i));
        hashmap.put("model", (new StringBuilder()).append(Build.MANUFACTURER).append(" ").append(Build.MODEL).toString());
        return hashmap;
    }

    static String d()
    {
        return c;
    }

}
