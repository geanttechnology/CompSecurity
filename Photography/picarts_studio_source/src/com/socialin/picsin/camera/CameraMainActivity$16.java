// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera;

import android.content.DialogInterface;

// Referenced classes of package com.socialin.picsin.camera:
//            CameraMainActivity

final class a
    implements android.content.kListener
{

    private boolean a;
    private CameraMainActivity b;

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        if (a)
        {
            b.finish();
        }
    }

    (CameraMainActivity cameramainactivity, boolean flag)
    {
        b = cameramainactivity;
        a = flag;
        super();
    }
}
