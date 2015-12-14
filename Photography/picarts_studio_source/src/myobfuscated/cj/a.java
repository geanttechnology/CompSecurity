// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cj;

import android.util.Log;
import com.socialin.android.photo.imgop.ImageOpCommon;
import java.nio.ByteBuffer;

public final class a
{

    private static a b;
    public int a;
    private int c;

    public a()
    {
        a = 0;
        c = 0;
    }

    public static a a()
    {
        if (b == null)
        {
            b = new a();
        }
        return b;
    }

    public final ByteBuffer a(int i)
    {
        a = a + 1;
        c = c + i;
        Log.e("ex1", (new StringBuilder("allocatedBuffersCount = ")).append(a).toString());
        return ImageOpCommon.allocNativeBuffer(i);
    }

    public final void a(ByteBuffer bytebuffer)
    {
        if (bytebuffer != null)
        {
            a = a - 1;
            Log.e("ex1", (new StringBuilder("allocatedBuffersCount = ")).append(a).toString());
            c = c - bytebuffer.capacity();
            ImageOpCommon.freeNativeBuffer(bytebuffer);
        }
    }
}
