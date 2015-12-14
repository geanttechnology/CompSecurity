// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.aw;

import android.opengl.GLES20;
import java.nio.FloatBuffer;

// Referenced classes of package myobfuscated.aw:
//            d

final class it>
    implements Runnable
{

    private int a;
    private float b[];

    public final void run()
    {
        GLES20.glUniform2fv(a, 1, FloatBuffer.wrap(b));
    }

    _cls0(int i, float af[])
    {
        a = i;
        b = af;
        super();
    }
}
