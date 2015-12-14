// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.opengl.GLES20;

class byl
    implements Runnable
{

    final byh a;
    final byi b;

    byl(byi byi1, byh byh1)
    {
        b = byi1;
        a = byh1;
        super();
    }

    public void run()
    {
        byh byh1 = byi.d(b);
        byi.a(b, a);
        if (byh1 != null)
        {
            byh1.g();
        }
        byi.d(b).e();
        GLES20.glUseProgram(byi.d(b).i());
        byi.d(b).b(byi.g(b), byi.h(b));
    }
}
