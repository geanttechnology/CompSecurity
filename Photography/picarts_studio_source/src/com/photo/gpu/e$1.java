// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.photo.gpu;

import android.opengl.GLES20;
import myobfuscated.aw.d;

// Referenced classes of package com.photo.gpu:
//            e

final class init>
    implements Runnable
{

    private d a;
    private e b;

    public final void run()
    {
        d d1 = e.a(b);
        e.a(b, a);
        if (d1 != null)
        {
            d1.d();
        }
        e.a(b).c();
        GLES20.glUseProgram(e.a(b).a);
        e.a(b).a(e.b(b), e.c(b));
    }

    S20(e e1, d d1)
    {
        b = e1;
        a = d1;
        super();
    }
}
