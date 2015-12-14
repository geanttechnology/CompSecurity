// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import android.content.DialogInterface;
import android.view.KeyEvent;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            CameraSettingDialog

class a
    implements android.content.istener
{

    final CameraSettingDialog a;

    public boolean onKey(DialogInterface dialoginterface, int i, KeyEvent keyevent)
    {
        return i == 27 || i == 24 || i == 25;
    }

    (CameraSettingDialog camerasettingdialog)
    {
        a = camerasettingdialog;
        super();
    }
}
