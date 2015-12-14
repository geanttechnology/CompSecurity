// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.bs;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import com.socialin.android.util.c;
import java.nio.ByteBuffer;

// Referenced classes of package myobfuscated.bs:
//            c

public class a extends myobfuscated.bs.c
{

    public static final String a = myobfuscated/bs/a.getSimpleName();
    private Bitmap b;

    private a(int i, ByteBuffer bytebuffer)
    {
        if (bytebuffer == null)
        {
            throw new NullPointerException();
        } else
        {
            b = c.a(96, 96, android.graphics.Bitmap.Config.ALPHA_8, a);
            b.copyPixelsFromBuffer(bytebuffer);
            return;
        }
    }

    public static a a(ByteBuffer bytebuffer)
    {
        return new a(0, bytebuffer);
    }

    public final void a(Canvas canvas, Matrix matrix, Paint paint)
    {
        canvas.drawBitmap(b, matrix, paint);
    }

    static 
    {
        new Rect(0, 0, 96, 96);
    }
}
