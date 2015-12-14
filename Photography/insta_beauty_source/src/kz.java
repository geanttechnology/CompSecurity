// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.flurry.android.FlurryAgent;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCamera;

public class kz
    implements rg
{

    final ActivityCamera a;

    public kz(ActivityCamera activitycamera)
    {
        a = activitycamera;
        super();
    }

    public void a()
    {
        FlurryAgent.logEvent("camera_setting_correct_click");
        ActivityCamera.b(a);
    }

    public void a(boolean flag)
    {
        FlurryAgent.logEvent("camera_setting_delay_click");
        pt.a(pt.i, a, flag);
    }

    public void b(boolean flag)
    {
        FlurryAgent.logEvent("camera_setting_screen_capture_click");
        pt.a(pt.j, a, flag);
    }

    public void c(boolean flag)
    {
        FlurryAgent.logEvent("camera_setting_intelligentBeauty_click");
        pt.a(pt.t, a, flag);
    }
}
