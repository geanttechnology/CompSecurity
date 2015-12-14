// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.flurry.android.FlurryAgent;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCameraNew;

class ln
    implements rg
{

    final lm a;

    ln(lm lm1)
    {
        a = lm1;
        super();
    }

    public void a()
    {
        FlurryAgent.logEvent("camera_setting_correct_click");
        ActivityCameraNew.q(a.a);
    }

    public void a(boolean flag)
    {
        ActivityCameraNew.d(a.a, flag);
        FlurryAgent.logEvent("camera_setting_delay_click");
        pt.a(pt.i, a.a, flag);
    }

    public void b(boolean flag)
    {
        ActivityCameraNew.e(a.a, flag);
        FlurryAgent.logEvent("camera_setting_screen_capture_click");
        pt.a(pt.j, a.a, flag);
    }

    public void c(boolean flag)
    {
        ActivityCameraNew.f(a.a, flag);
        FlurryAgent.logEvent("camera_setting_intelligentBeauty_click");
        pt.a(pt.t, a.a, flag);
    }
}
