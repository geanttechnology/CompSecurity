// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;

import android.content.Context;
import com.cyberlink.uma.UMA;
import com.cyberlink.uma.g;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.pf.common.utility.m;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.youcammakeup.clflurry:
//            BaseEvent

public class b
{

    public static String a()
    {
        String s;
        String s1;
label0:
        {
            s1 = Globals.d().getString(0x7f07073e);
            if (s1 == null || s1.isEmpty())
            {
                return null;
            }
            String s2 = z.h();
            if (s2 != null)
            {
                s = s2;
                if (!s2.isEmpty())
                {
                    break label0;
                }
            }
            z.d(s1);
            s = s1;
        }
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("sr_no_ori", s);
            jsonobject.put("sr_no_cur", s1);
        }
        catch (Exception exception)
        {
            m.e("CLFlurryAgentHelper", (new StringBuilder()).append("GetPreloadPropertyString(), error. e=").append(exception).toString());
        }
        return jsonobject.toString();
    }

    public static void a(Context context)
    {
        String s = a();
        if (s == null || s.isEmpty())
        {
            m.b("CLFlurryAgentHelper", "init(), warning. property string is null");
            UMA.a(context, "https://clad.cyberlink.com", "75edfca17dfbe875e63a66633ed6b00e30adcb92");
            return;
        } else
        {
            m.b("CLFlurryAgentHelper", (new StringBuilder()).append("init(), info. propertyString=").append(s).toString());
            UMA.a(context, "https://clad.cyberlink.com", "75edfca17dfbe875e63a66633ed6b00e30adcb92", s);
            return;
        }
    }

    public static void a(BaseEvent.EventName eventname)
    {
        if (d())
        {
            return;
        } else
        {
            UMA.a(eventname.a());
            return;
        }
    }

    public static void a(BaseEvent baseevent)
    {
        if (d())
        {
            return;
        }
        m.b("CLFlurryAgentHelper", (new StringBuilder()).append("recordEvent name=").append(baseevent.a()).toString());
        if (baseevent.b() == null)
        {
            m.d("CLFlurryAgentHelper", "Parameters is null");
            UMA.a(baseevent.a());
            return;
        } else
        {
            UMA.a(baseevent.a(), baseevent.b(), baseevent.c());
            return;
        }
    }

    public static String b(Context context)
    {
        return g.a(context);
    }

    public static void b()
    {
        if (d())
        {
            return;
        } else
        {
            UMA.a();
            return;
        }
    }

    public static void c()
    {
        if (d())
        {
            return;
        } else
        {
            UMA.b();
            return;
        }
    }

    private static boolean d()
    {
        Globals.d();
        boolean flag = Globals.u();
        if (!flag);
        return flag;
    }
}
