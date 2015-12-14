// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity;

import com.fotoable.global.NewAlertDialogFragment;

// Referenced classes of package com.pipcamera.activity:
//            PIPCameraActivity

class a
    implements Runnable
{

    final NewAlertDialogFragment a;
    final PIPCameraActivity b;

    public void run()
    {
        a.show(b.getSupportFragmentManager(), "PIPCameraActivity");
    }

    (PIPCameraActivity pipcameraactivity, NewAlertDialogFragment newalertdialogfragment)
    {
        b = pipcameraactivity;
        a = newalertdialogfragment;
        super();
    }
}
