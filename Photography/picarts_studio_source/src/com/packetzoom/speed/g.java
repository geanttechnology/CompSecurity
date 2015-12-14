// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.packetzoom.speed;

import android.app.Activity;
import android.os.Bundle;
import java.util.Timer;

// Referenced classes of package com.packetzoom.speed:
//            i, PacketZoomClient, e, Session, 
//            h

class g
    implements android.app.Application.ActivityLifecycleCallbacks
{

    private int a_int_fld;
    private i a_com_packetzoom_speed_i_fld;
    private Timer a_java_util_Timer_fld;

    g()
    {
        a_java_util_Timer_fld = new Timer();
        a_com_packetzoom_speed_i_fld = i.b;
    }

    static int a(g g1)
    {
        return g1.a_int_fld;
    }

    static i a(g g1, i j)
    {
        g1.a_com_packetzoom_speed_i_fld = j;
        return j;
    }

    public void onActivityCreated(Activity activity, Bundle bundle)
    {
        e.a(PacketZoomClient.a(), (new StringBuilder("onActivityCreated: ")).append(activity.getClass().getName()).toString());
    }

    public void onActivityDestroyed(Activity activity)
    {
        e.a(PacketZoomClient.a(), (new StringBuilder("onActivityDestroyed: ")).append(activity.getClass().getName()).toString());
    }

    public void onActivityPaused(Activity activity)
    {
        e.a(PacketZoomClient.a(), (new StringBuilder("onActivityPaused: ")).append(activity.getClass().getName()).toString());
    }

    public void onActivityResumed(Activity activity)
    {
        e.a(PacketZoomClient.a(), (new StringBuilder("onActivityResumed: ")).append(activity.getClass().getName()).toString());
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle)
    {
        e.a(PacketZoomClient.a(), (new StringBuilder("onActivitySaveInstanceState: ")).append(activity.getClass().getName()).toString());
    }

    public void onActivityStarted(Activity activity)
    {
        a_int_fld = a_int_fld + 1;
        if (a_com_packetzoom_speed_i_fld == i.a)
        {
            e.a(PacketZoomClient.a(), "### foreground state");
            a_com_packetzoom_speed_i_fld = i.b;
            if (PacketZoomClient.a() != null && PacketZoomClient.a != null)
            {
                PacketZoomClient.a.a();
            }
        }
        e.a(PacketZoomClient.a(), (new StringBuilder("onActivityStarted refCount: ")).append(a_int_fld).toString());
    }

    public void onActivityStopped(Activity activity)
    {
        int j = a_int_fld - 1;
        a_int_fld = j;
        if (j == 0)
        {
            e.a(PacketZoomClient.a(), "no visible activities: starting bg timer");
            a_java_util_Timer_fld.schedule(new h(this), 2000L);
        }
        e.a(PacketZoomClient.a(), (new StringBuilder("onActivityStopped refCount ")).append(a_int_fld).toString());
    }
}
