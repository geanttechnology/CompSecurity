// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import bo.app.cs;
import bo.app.ep;
import bo.app.n;
import com.appboy.Constants;
import java.util.Locale;
import java.util.Map;
import myobfuscated.i.a;
import myobfuscated.i.c;

// Referenced classes of package myobfuscated.d:
//            a

public class b extends myobfuscated.d.a
{

    private static final String a;
    private final Context b;

    public b(Context context)
    {
        super(context);
        b = context;
    }

    private int a(n n1)
    {
        if (n1.equals(n.b))
        {
            n1 = "com_appboy_push_large_notification_icon";
        } else
        {
            n1 = "com_appboy_push_small_notification_icon";
        }
        if (mConfigurationCache.containsKey(n1))
        {
            return ((Integer)mConfigurationCache.get(n1)).intValue();
        } else
        {
            int i1 = b.getResources().getIdentifier(n1, "drawable", myobfuscated.i.c.a(b));
            mConfigurationCache.put(n1, Integer.valueOf(i1));
            return i1;
        }
    }

    public final String a()
    {
        if ("STAGING".equals(getStringValue("com_appboy_server_target", "PROD").toUpperCase(Locale.US)))
        {
            return "https://sondheim.appboy.com/api/v2/";
        } else
        {
            return "https://dev.appboy.com/api/v2/";
        }
    }

    public final cs b()
    {
        Object obj1;
        cs cs1;
        cs1 = (cs)mConfigurationCache.get("com_appboy_api_key");
        obj1 = cs1;
        if (cs1 != null) goto _L2; else goto _L1
_L1:
        Object obj = b.getSharedPreferences("com_appboy_override_configuration_cache", 0).getString("com_appboy_api_key", null);
        if (obj == null) goto _L4; else goto _L3
_L3:
        myobfuscated.i.a.a(a, "Found an override api key.  Using it to configure Appboy.");
_L7:
        obj1 = cs1;
        if (obj != null)
        {
            obj1 = new cs(((String) (obj)));
            mConfigurationCache.put("com_appboy_api_key", obj1);
        }
_L2:
        int i1;
        int j1;
        if (obj1 == null)
        {
            myobfuscated.i.a.c(a, "****************************************************");
            myobfuscated.i.a.c(a, "**                                                **");
            myobfuscated.i.a.c(a, "**                 !! WARNING !!                  **");
            myobfuscated.i.a.c(a, "**                                                **");
            myobfuscated.i.a.c(a, "**     No API key set in res/values/appboy.xml    **");
            myobfuscated.i.a.c(a, "** No cached API Key found from Appboy.configure  **");
            myobfuscated.i.a.c(a, "**         Appboy functionality disabled          **");
            myobfuscated.i.a.c(a, "**                                                **");
            myobfuscated.i.a.c(a, "****************************************************");
            throw new RuntimeException("Unable to read the Appboy API key from the res/values/appboy.xml file. See log for more details.");
        } else
        {
            return ((cs) (obj1));
        }
_L4:
        obj = Locale.getDefault();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_322;
        }
        obj1 = readStringArrayResourceValue("com_appboy_locale_api_key_map", null);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_322;
        }
        j1 = obj1.length;
        i1 = 0;
_L8:
        if (i1 >= j1) goto _L6; else goto _L5
_L5:
        String s = obj1[i1];
        if (ep.a(s, ",") != 1)
        {
            continue; /* Loop/switch isn't completed */
        }
        String as[] = s.split(",");
        if (as.length != 2)
        {
            continue; /* Loop/switch isn't completed */
        }
        String s1 = as[0].trim().toLowerCase();
        boolean flag = s1.equals(((Locale) (obj)).toString().toLowerCase());
        if (!s1.equals(((Locale) (obj)).getCountry().toLowerCase()) && !flag)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = as[1].trim();
_L9:
        if (obj != null)
        {
            myobfuscated.i.a.a(a, "Found a locale that matches the current locale in appboy.xml.  Using the associated api key");
        } else
        {
            obj = readStringResourceValue("com_appboy_api_key", null);
        }
          goto _L7
        i1++;
          goto _L8
_L6:
        obj = null;
          goto _L9
    }

    public final boolean c()
    {
        return getBooleanValue("com_appboy_push_gcm_messaging_registration_enabled", false);
    }

    public final boolean d()
    {
        return getBooleanValue("com_appboy_push_adm_messaging_registration_enabled", false);
    }

    public final boolean e()
    {
        boolean flag = false;
        if (!getBooleanValue("com_appboy_disable_location_collection", false))
        {
            flag = true;
        }
        return flag;
    }

    public final boolean f()
    {
        return getBooleanValue("com_appboy_enable_background_location_collection", false);
    }

    public final long g()
    {
        return 1000L * (long)getIntValue("com_appboy_location_update_time_interval", -1);
    }

    public final float h()
    {
        return (float)getIntValue("com_appboy_location_update_distance", -1);
    }

    public final int i()
    {
        return a(n.a);
    }

    public final int j()
    {
        return a(n.b);
    }

    public final int k()
    {
        if (mConfigurationCache.containsKey("version_code"))
        {
            return ((Integer)mConfigurationCache.get("version_code")).intValue();
        }
        int i1;
        try
        {
            String s = myobfuscated.i.c.a(b);
            i1 = b.getPackageManager().getPackageInfo(s, 0).versionCode;
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            myobfuscated.i.a.c(a, "Unable to read the version code.");
            i1 = -1;
        }
        mConfigurationCache.put("version_code", Integer.valueOf(i1));
        return i1;
    }

    public final String l()
    {
        return getStringValue("com_appboy_push_gcm_sender_id", null);
    }

    public final int m()
    {
        String s;
        int i1;
        i1 = 0;
        if (mConfigurationCache.containsKey("application_icon"))
        {
            return ((Integer)mConfigurationCache.get("application_icon")).intValue();
        }
        s = b.getPackageName();
        int j1 = b.getPackageManager().getApplicationInfo(s, 0).icon;
        i1 = j1;
_L2:
        mConfigurationCache.put("application_icon", Integer.valueOf(i1));
        return i1;
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        myobfuscated.i.a.c(a, String.format("Cannot find package named %s", new Object[] {
            s
        }));
        j1 = b.getPackageManager().getApplicationInfo(b.getPackageName(), 0).icon;
        i1 = j1;
        continue; /* Loop/switch isn't completed */
        namenotfoundexception;
        myobfuscated.i.a.c(a, String.format("Cannot find package named %s", new Object[] {
            s
        }));
        if (true) goto _L2; else goto _L1
_L1:
    }

    static 
    {
        a = String.format("%s.%s", new Object[] {
            Constants.APPBOY_LOG_TAG_PREFIX, myobfuscated/d/b.getName()
        });
    }
}
