// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.analytics.AnalyticsConfig;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package u.aly:
//            k, bj, u, af, 
//            aw, y, z, bi, 
//            bv

public class v
{

    private static final String a = "session_start_time";
    private static final String b = "session_end_time";
    private static final String c = "session_id";
    private static final String f = "activities";
    private final String d = "a_start_time";
    private final String e = "a_end_time";

    public v()
    {
    }

    private String a(Context context, SharedPreferences sharedpreferences)
    {
        k k1 = k.a(context);
        String s = b(context);
        context = a(context);
        sharedpreferences = sharedpreferences.edit();
        sharedpreferences.putString("session_id", s);
        sharedpreferences.putLong("session_start_time", System.currentTimeMillis());
        sharedpreferences.putLong("session_end_time", 0L);
        sharedpreferences.commit();
        if (context != null)
        {
            k1.a(context);
            return s;
        } else
        {
            k1.a(null);
            return s;
        }
    }

    private void a(SharedPreferences sharedpreferences)
    {
        sharedpreferences = sharedpreferences.edit();
        sharedpreferences.remove("session_start_time");
        sharedpreferences.remove("session_end_time");
        sharedpreferences.remove("session_id");
        sharedpreferences.remove("a_start_time");
        sharedpreferences.remove("a_end_time");
        sharedpreferences.putString("activities", "");
        sharedpreferences.commit();
    }

    private boolean b(SharedPreferences sharedpreferences)
    {
        long l = sharedpreferences.getLong("a_start_time", 0L);
        long l1 = sharedpreferences.getLong("a_end_time", 0L);
        long l2 = System.currentTimeMillis();
        if (l != 0L && l2 - l < AnalyticsConfig.kContinueSessionMillis)
        {
            bj.b("MobclickAgent", "onResume called before onPause");
        } else
        if (l2 - l1 > AnalyticsConfig.kContinueSessionMillis)
        {
            return true;
        }
        return false;
    }

    public af a(Context context)
    {
        SharedPreferences sharedpreferences = u.a(context);
        String s = sharedpreferences.getString("session_id", null);
        if (s == null)
        {
            return null;
        }
        long l2 = sharedpreferences.getLong("session_start_time", 0L);
        long l3 = sharedpreferences.getLong("session_end_time", 0L);
        long l = 0L;
        if (l3 != 0L)
        {
            long l1 = l3 - l2;
            l = l1;
            if (Math.abs(l1) > 0x5265c00L)
            {
                l = 0L;
            }
        }
        af af1 = new af();
        af1.a(s);
        af1.a(l2);
        af1.b(l3);
        af1.c(l);
        double ad[] = AnalyticsConfig.getLocation();
        if (ad != null)
        {
            aw aw1 = new aw(ad[0], ad[1], System.currentTimeMillis());
            if (af1.y())
            {
                af1.a(aw1);
            } else
            {
                af1.b(Arrays.asList(new aw[] {
                    aw1
                }));
            }
        }
        context = y.a(context);
        if (context != null)
        {
            af1.a(context);
        }
        context = z.a(sharedpreferences);
        if (context != null && context.size() > 0)
        {
            af1.a(context);
        }
        a(sharedpreferences);
        return af1;
    }

    public String b(Context context)
    {
        String s = bi.f(context);
        context = AnalyticsConfig.getAppkey(context);
        long l = System.currentTimeMillis();
        if (context == null)
        {
            throw new RuntimeException("Appkey is null or empty, Please check AndroidManifest.xml");
        } else
        {
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append(l).append(context).append(s);
            return bv.a(stringbuilder.toString());
        }
    }

    public void c(Context context)
    {
        SharedPreferences sharedpreferences = u.a(context);
        if (sharedpreferences == null)
        {
            return;
        }
        if (b(sharedpreferences))
        {
            context = a(context, sharedpreferences);
            bj.a("MobclickAgent", (new StringBuilder("Start new session: ")).append(context).toString());
        } else
        {
            context = sharedpreferences.getString("session_id", null);
            bj.a("MobclickAgent", (new StringBuilder("Extend current session: ")).append(context).toString());
        }
        context = sharedpreferences.edit();
        context.putLong("a_start_time", System.currentTimeMillis());
        context.putLong("a_end_time", 0L);
        context.commit();
    }

    public void d(Context context)
    {
        context = u.a(context);
        if (context == null)
        {
            return;
        }
        if (context.getLong("a_start_time", 0L) == 0L && AnalyticsConfig.ACTIVITY_DURATION_OPEN)
        {
            bj.b("MobclickAgent", "onPause called before onResume");
            return;
        } else
        {
            long l = System.currentTimeMillis();
            context = context.edit();
            context.putLong("a_start_time", 0L);
            context.putLong("a_end_time", l);
            context.putLong("session_end_time", l);
            context.commit();
            return;
        }
    }
}
