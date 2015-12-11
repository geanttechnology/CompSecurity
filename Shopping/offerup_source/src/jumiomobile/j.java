// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.hardware.Camera;

// Referenced classes of package jumiomobile:
//            g

class j
    implements android.hardware.Camera.AutoFocusCallback
{

    final g a;

    j(g g1)
    {
        a = g1;
        super();
    }

    public void onAutoFocus(boolean flag, Camera camera)
    {
        g.b(a, false);
    }
}
