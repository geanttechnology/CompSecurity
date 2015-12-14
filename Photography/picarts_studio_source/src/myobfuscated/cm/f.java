// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cm;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.util.Log;
import com.photo.effect.Effect;
import com.socialin.android.photo.effects.factory.b;
import com.socialin.android.util.FileUtils;
import com.socialin.android.util.ModernAsyncTask;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeoutException;
import myobfuscated.ay.e;
import myobfuscated.cj.c;
import myobfuscated.f.m;

// Referenced classes of package myobfuscated.cm:
//            d, c, g

public final class f extends ModernAsyncTask
{

    private Context a;
    private Effect b;
    private d c;
    private boolean d;
    private ArrayList e;
    private String f;
    private g g;
    private int h;

    public f(Context context, Effect effect, d d1, boolean flag, ArrayList arraylist, String s, int i, 
            g g1)
    {
        a = context;
        b = effect;
        c = d1;
        d = flag;
        e = arraylist;
        f = s;
        h = i;
        g = g1;
    }

    private transient Object[] a()
    {
        Object obj;
        Bitmap bitmap;
        Point point;
        Bitmap bitmap1;
        Bitmap bitmap2;
        ByteBuffer bytebuffer;
        ByteBuffer bytebuffer1;
        Point point1;
        ByteBuffer bytebuffer2;
        long l;
        boolean flag1;
        bitmap = c.a;
        bitmap1 = c.b;
        bitmap2 = c.d;
        point = c.e;
        point1 = c.f;
        bytebuffer = c.g;
        bytebuffer1 = c.i;
        bytebuffer2 = c.h;
        obj = c.k;
        flag1 = true;
        l = System.currentTimeMillis();
        Log.e("ex1", "applyEffect max size doinbackground");
        Log.e("ex1", (new StringBuilder("applyEffect = ")).append(d).toString());
        if (!d) goto _L2; else goto _L1
_L1:
        boolean flag;
        Log.e("ex1", (new StringBuilder("origSize = ")).append(point.x).append(" : ").append(point.y).toString());
        boolean flag2 = false;
        flag1 = false;
        flag = flag2;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_253;
        }
        flag = flag2;
        if (!b.d())
        {
            break MISSING_BLOCK_LABEL_253;
        }
        flag = flag1;
        flag1 = b.a(a, obj, bitmap, bitmap);
        flag = flag1;
        Log.e("ex1", "renderScript apply");
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_249;
        }
        flag = flag1;
        bytebuffer1.position(0);
        flag = flag1;
        bitmap.copyPixelsToBuffer(bytebuffer1);
        flag = flag1;
_L3:
        Object obj1;
        IOException ioexception;
        if (!flag && b.f())
        {
            obj1 = b.a(a, bitmap, null);
            if (obj1 != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                bytebuffer1.position(0);
                ((Bitmap) (obj1)).copyPixelsToBuffer(bytebuffer1);
            }
            Log.e("ex1", "bitmap apply");
        } else
        {
            obj1 = bitmap;
        }
        flag1 = flag;
        if (!flag)
        {
            flag1 = flag;
            if (b.e())
            {
                flag1 = b.a(a, bytebuffer, bytebuffer1, point.x, point.y, false, -1);
                if (flag1)
                {
                    bytebuffer1.rewind();
                    ((Bitmap) (obj1)).copyPixelsFromBuffer(bytebuffer1);
                }
                Log.e("ex1", "native apply");
            }
        }
        bytebuffer.rewind();
        bitmap.copyPixelsFromBuffer(bytebuffer);
_L2:
        if (flag1)
        {
            obj1 = com.socialin.android.photo.effects.factory.b.a(h);
            Log.e("ex1", (new StringBuilder("selectedBendModeIndex = ")).append(h).toString());
            if (obj1 != null)
            {
                Log.e("ex1", "porderDuffMode != null");
                myobfuscated.cm.c.a(bitmap.getWidth(), bitmap.getHeight(), bytebuffer, bytebuffer1, bytebuffer1, ((android.graphics.Xfermode) (obj1)));
            }
            obj1 = m.a(b, point1, point, e, bytebuffer, bytebuffer1, bytebuffer2);
        } else
        {
            obj1 = null;
        }
        if (obj1 != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_520;
        }
        ((ByteBuffer) (obj1)).position(0);
        FileUtils.a(f, ((ByteBuffer) (obj1)));
        flag = true;
_L4:
        if (flag)
        {
            ((ByteBuffer) (obj1)).position(0);
            bitmap.copyPixelsFromBuffer(((java.nio.Buffer) (obj1)));
            bytebuffer.rewind();
            bitmap.copyPixelsToBuffer(bytebuffer);
            myobfuscated.ay.e.a(bitmap, bitmap2, bitmap1);
        }
        if (obj1 != null && obj1 != bytebuffer1)
        {
            myobfuscated.ay.e.a(((ByteBuffer) (obj1)));
        }
        obj1 = null;
        if (flag)
        {
            obj1 = new HashMap();
            ((HashMap) (obj1)).put("width", Integer.valueOf(point.x));
            ((HashMap) (obj1)).put("height", Integer.valueOf(point.y));
            ((HashMap) (obj1)).put("path", f);
            obj1 = new c(null, 0, ((HashMap) (obj1)));
        }
        return (new Object[] {
            Boolean.valueOf(flag), obj1, new Long(System.currentTimeMillis() - l)
        });
        obj1;
        ((TimeoutException) (obj1)).printStackTrace();
          goto _L3
        ioexception;
        flag = false;
          goto _L4
    }

    protected final Object doInBackground(Object aobj[])
    {
        return ((Object) (a()));
    }

    protected final void onPostExecute(Object obj)
    {
        obj = ((Object) ((Object[])obj));
        boolean flag = ((Boolean)obj[0]).booleanValue();
        c c1 = (c)obj[1];
        long l = ((Long)obj[2]).longValue();
        if (g != null)
        {
            g.a(b, c1, flag, l);
        }
        Log.e("ex1", (new StringBuilder("applyMaxSize onPostExecute succes = ")).append(flag).toString());
    }
}
