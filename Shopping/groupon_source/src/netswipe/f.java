// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import android.hardware.Camera;

// Referenced classes of package netswipe:
//            dh, c

class f
    implements android.hardware.Camera.AutoFocusCallback
{

    final c a;

    f(c c1)
    {
        a = c1;
        super();
    }

    public void onAutoFocus(boolean flag, Camera camera)
    {
        dh.b("focus finished");
        c.a(a, false);
    }
}
