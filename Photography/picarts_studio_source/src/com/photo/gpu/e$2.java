// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.photo.gpu;

import android.opengl.GLES20;

// Referenced classes of package com.photo.gpu:
//            e

final class init>
    implements Runnable
{

    private e a;

    public final void run()
    {
        GLES20.glDeleteTextures(1, new int[] {
            e.d(a)
        }, 0);
        e.a(a, -1);
    }

    S20(e e1)
    {
        a = e1;
        super();
    }
}
