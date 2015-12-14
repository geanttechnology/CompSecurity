// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cm;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.util.Log;
import android.util.TypedValue;
import com.socialin.android.photo.imgop.ImageOpCommon;
import com.socialin.android.util.ModernAsyncTask;
import com.socialin.android.util.c;
import com.socialin.android.util.w;
import java.nio.ByteBuffer;
import myobfuscated.ay.e;
import myobfuscated.az.b;

// Referenced classes of package myobfuscated.cm:
//            b

public final class a extends ModernAsyncTask
{

    private myobfuscated.cj.c a;
    private myobfuscated.cj.c b;
    private int c;
    private myobfuscated.cm.b d;
    private Context e;
    private Bitmap f;

    public a(Context context, Bitmap bitmap, myobfuscated.cj.c c1, myobfuscated.cj.c c2, int i, myobfuscated.cm.b b1)
    {
        e = context;
        f = bitmap;
        a = c1;
        b = c2;
        c = i;
        d = b1;
    }

    private transient Object[] a()
    {
        Object obj = myobfuscated.az.b.b(e);
        if (obj != null)
        {
            ((b) (obj)).a(e);
        }
        if (f != null && !f.isRecycled())
        {
            Log.e("ex1", "sourceBitmap != null && !sourceBitmap.isRecycled()");
            obj = com.socialin.android.util.c.b(f, android.graphics.Bitmap.Config.ARGB_8888);
        } else
        {
            Log.e("ex1", "load from buffer");
            Object obj1;
            Bitmap bitmap;
            myobfuscated.cj.a a1;
            ByteBuffer bytebuffer;
            int i;
            if (b != null)
            {
                obj1 = b.c;
                obj = b.a;
                i = b.b;
            } else
            if (a != null)
            {
                obj1 = a.c;
                obj = a.a;
                i = a.b;
            } else
            {
                i = 0;
                obj = null;
                obj1 = null;
            }
            obj = myobfuscated.ay.e.a(((java.util.HashMap) (obj1)), ((String) (obj)), i, c);
        }
        if (obj != null)
        {
            if ((bitmap = myobfuscated.ay.e.a(((Bitmap) (obj)))) != null)
            {
label0:
                {
                    a1 = myobfuscated.cj.a.a();
                    obj = a1.a(bitmap.getWidth() * bitmap.getHeight() * 4);
                    ((ByteBuffer) (obj)).rewind();
                    bitmap.copyPixelsToBuffer(((java.nio.Buffer) (obj)));
                    bytebuffer = ImageOpCommon.getAlphaChannel(((ByteBuffer) (obj)), bitmap.getWidth(), bitmap.getHeight());
                    ImageOpCommon.changeBufferAlphaChannelWithAlpha(((java.nio.Buffer) (obj)), bitmap.getWidth() * bitmap.getHeight(), 255);
                    ((ByteBuffer) (obj)).rewind();
                    bitmap.copyPixelsFromBuffer(((java.nio.Buffer) (obj)));
                    a1.a(((ByteBuffer) (obj)));
                    i = (int)TypedValue.applyDimension(1, 55F, e.getResources().getDisplayMetrics());
                    if (b == null)
                    {
                        obj = w.a(new Matrix(), bitmap, i, i, false);
                    } else
                    {
                        obj = myobfuscated.ay.e.a(a.c, a.a, a.b, i * i);
                    }
                    if (obj == null)
                    {
                        com.socialin.android.util.c.a(bitmap);
                        a1.a(bytebuffer);
                        return null;
                    }
                    if (((Bitmap) (obj)).getWidth() <= i)
                    {
                        obj1 = obj;
                        if (((Bitmap) (obj)).getHeight() <= i)
                        {
                            break label0;
                        }
                    }
                    obj1 = w.a(new Matrix(), ((Bitmap) (obj)), i, i, false);
                }
                if (obj1 == null)
                {
                    com.socialin.android.util.c.a(bitmap);
                    a1.a(bytebuffer);
                    return null;
                } else
                {
                    return (new Object[] {
                        bitmap, obj1, bytebuffer
                    });
                }
            }
        }
        return null;
    }

    protected final Object doInBackground(Object aobj[])
    {
        return ((Object) (a()));
    }

    protected final void onPostExecute(Object obj)
    {
        boolean flag = true;
        ByteBuffer bytebuffer = null;
        Object aobj[] = (Object[])obj;
        Bitmap bitmap;
        if (aobj != null)
        {
            obj = (Bitmap)aobj[0];
            bitmap = (Bitmap)aobj[1];
            bytebuffer = (ByteBuffer)aobj[2];
        } else
        {
            bitmap = null;
            flag = false;
            obj = null;
        }
        if (d != null)
        {
            d.a(((Bitmap) (obj)), bitmap, bytebuffer, flag);
        }
    }
}
