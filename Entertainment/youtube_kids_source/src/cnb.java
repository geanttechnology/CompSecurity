// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.SharedPreferences;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;

public final class cnb
{

    public final SharedPreferences a;
    public final boolean b;

    public cnb(SharedPreferences sharedpreferences, boolean flag)
    {
        a = (SharedPreferences)b.a(sharedpreferences);
        b = flag;
        if (d())
        {
            sharedpreferences.edit().remove("medialib_diagnostics_enabled").apply();
        }
    }

    private static MediaCodecInfo[] f()
    {
        int i = 0;
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            return (new MediaCodecList(0)).getCodecInfos();
        }
        MediaCodecInfo amediacodecinfo[];
        for (amediacodecinfo = new MediaCodecInfo[MediaCodecList.getCodecCount()]; i < amediacodecinfo.length; i++)
        {
            amediacodecinfo[i] = MediaCodecList.getCodecInfoAt(i);
        }

        return amediacodecinfo;
    }

    public Enum a(String s, Class class1, Enum enum, boolean flag)
    {
        if (flag)
        {
            return enum;
        }
        s = a.getString(s, enum.name());
        try
        {
            s = Enum.valueOf(class1, s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return enum;
        }
        return s;
    }

    public final boolean a()
    {
        if (android.os.Build.VERSION.SDK_INT < 16)
        {
            return false;
        }
        String s = String.valueOf("h264_main_profile_supported");
        String s1 = String.valueOf(android.os.Build.VERSION.RELEASE);
        if (s1.length() != 0)
        {
            s = s.concat(s1);
        } else
        {
            s = new String(s);
        }
        if (a.contains(s))
        {
            return a.getBoolean(s, false);
        }
        boolean flag;
        try
        {
            flag = aob.a(2, 64);
        }
        catch (aod aod1)
        {
            return false;
        }
        a.edit().putBoolean(s, flag).apply();
        return flag;
    }

    public final boolean b()
    {
        boolean flag1 = false;
        String s = String.valueOf("vp9_supported");
        String s1 = String.valueOf(android.os.Build.VERSION.RELEASE);
        if (s1.length() != 0)
        {
            s = s.concat(s1);
        } else
        {
            s = new String(s);
        }
        if (a.contains(s))
        {
            return a.getBoolean(s, false);
        }
        MediaCodecInfo amediacodecinfo[];
        int i;
        int j;
        try
        {
            amediacodecinfo = f();
        }
        catch (Exception exception)
        {
            return false;
        }
        j = amediacodecinfo.length;
        i = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i < j)
                {
                    if (!amediacodecinfo[i].getName().contains("vp9.decode"))
                    {
                        break label0;
                    }
                    flag = true;
                }
                a.edit().putBoolean(s, flag).apply();
                return flag;
            }
            i++;
        } while (true);
    }

    public final bws c()
    {
        bws bws1 = bws.d;
        boolean flag;
        if (!b)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return (bws)a("exo_player_activation_type", bws, bws1, flag);
    }

    public final boolean d()
    {
        return a.getBoolean("medialib_diagnostics_enabled", false);
    }

    public final int[] e()
    {
        String as[] = a.getString("medialib_diagnostic_bandwidth_throttling_parameters", "").split(",");
        int ai[] = new int[as.length];
        int i = 0;
        while (i < ai.length) 
        {
            try
            {
                ai[i] = Integer.valueOf(as[i]).intValue();
            }
            catch (NumberFormatException numberformatexception) { }
            i++;
        }
        return ai;
    }
}
