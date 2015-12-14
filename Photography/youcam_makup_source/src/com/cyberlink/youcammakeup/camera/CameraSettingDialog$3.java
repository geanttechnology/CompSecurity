// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import android.view.View;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            CameraSettingDialog, h

class a
    implements android.view.ameraSettingDialog._cls3
{

    final CameraSettingDialog a;

    public void onClick(View view)
    {
        boolean flag;
        boolean flag4;
        boolean flag5;
        boolean flag6;
        flag4 = true;
        flag5 = true;
        flag6 = true;
        flag = true;
        if (view != CameraSettingDialog.a(a)) goto _L2; else goto _L1
_L1:
        tting tting = tting.a;
        view = tting;
        if (CameraSettingDialog.b(a))
        {
            a.a(CameraSettingDialog.c(a));
            CameraSettingDialog.a(a, false);
            view = tting;
        }
_L4:
        CameraSettingDialog.a(a, view);
        CameraSettingDialog.n(a);
        if (CameraSettingDialog.o(a) != null)
        {
            CameraSettingDialog.o(a).a(view);
        }
        return;
_L2:
        if (view == CameraSettingDialog.d(a))
        {
            tting tting1 = tting.b;
            view = tting1;
            if (CameraSettingDialog.b(a))
            {
                a.a(CameraSettingDialog.c(a));
                CameraSettingDialog.a(a, false);
                view = tting1;
            }
        } else
        if (view == CameraSettingDialog.e(a))
        {
            tting tting2 = tting.c;
            view = tting2;
            if (CameraSettingDialog.b(a))
            {
                a.a(CameraSettingDialog.c(a));
                CameraSettingDialog.a(a, false);
                view = tting2;
            }
        } else
        if (view == CameraSettingDialog.f(a))
        {
            view = tting.d;
            CameraSettingDialog camerasettingdialog = a;
            if (CameraSettingDialog.g(a))
            {
                flag = false;
            }
            camerasettingdialog.a(flag);
        } else
        if (view == CameraSettingDialog.h(a))
        {
            view = tting.e;
            CameraSettingDialog camerasettingdialog1 = a;
            boolean flag1;
            if (!CameraSettingDialog.i(a))
            {
                flag1 = flag4;
            } else
            {
                flag1 = false;
            }
            CameraSettingDialog.b(camerasettingdialog1, flag1);
        } else
        if (view == CameraSettingDialog.j(a))
        {
            view = tting.f;
            CameraSettingDialog camerasettingdialog2 = a;
            boolean flag2;
            if (!CameraSettingDialog.k(a))
            {
                flag2 = flag5;
            } else
            {
                flag2 = false;
            }
            CameraSettingDialog.c(camerasettingdialog2, flag2);
        } else
        if (view == CameraSettingDialog.l(a))
        {
            view = tting.g;
            CameraSettingDialog camerasettingdialog3 = a;
            boolean flag3;
            if (!CameraSettingDialog.m(a))
            {
                flag3 = flag6;
            } else
            {
                flag3 = false;
            }
            CameraSettingDialog.d(camerasettingdialog3, flag3);
        } else
        {
            view = null;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    tting(CameraSettingDialog camerasettingdialog)
    {
        a = camerasettingdialog;
        super();
    }
}
