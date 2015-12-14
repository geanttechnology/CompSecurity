// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity;


// Referenced classes of package com.pipcamera.activity:
//            PIPCameraActivity

class a
    implements com.fotoable.adbuttonlib.uttonClickedLisener
{

    final PIPCameraActivity a;

    public void onAdButtonClicked(String s)
    {
        PIPCameraActivity.a(a, s);
    }

    dButtonClickedLisener(PIPCameraActivity pipcameraactivity)
    {
        a = pipcameraactivity;
        super();
    }
}
