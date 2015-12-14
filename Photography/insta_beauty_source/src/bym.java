// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.opengl.GLES20;

class bym
    implements Runnable
{

    final byi a;

    bym(byi byi1)
    {
        a = byi1;
        super();
    }

    public void run()
    {
        GLES20.glDeleteTextures(1, new int[] {
            byi.b(a)
        }, 0);
        byi.a(a, -1);
    }
}
