// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.collages;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import com.picsart.studio.PicsartContext;
import com.socialin.android.util.ModernAsyncTask;
import com.socialin.android.util.w;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import myobfuscated.f.m;

// Referenced classes of package com.picsart.collages:
//            CollageCreatorView, a, CollageImage, f

final class <init> extends ModernAsyncTask
{

    private String a;
    private Activity b;
    private f c;
    private CollageCreatorView d;

    private transient Void a()
    {
        CollageCreatorView.c(d, PicsartContext.a.getMaxCollageSaveSize());
        CollageCreatorView.d(d, PicsartContext.a.getMaxCollageSaveSize());
        int j = PicsartContext.a.getMaxCollageSaveSize();
        float f2;
        float f3;
        Object obj1;
        Exception exception2;
        Object obj2;
        Object obj3;
        a a2;
        Exception exception3;
        int i;
        int k;
        int l;
        if (CollageCreatorView.F(d) != null && !CollageCreatorView.F(d).isRecycled())
        {
            CollageCreatorView.F(d).recycle();
            Object obj = w.a(CollageCreatorView.G(d));
            i = j;
            if (Math.min(((android.graphics.) (obj)).outWidth, ((android.graphics.) (obj)).outHeight) < j)
            {
                i = Math.min(((android.graphics.) (obj)).outWidth, ((android.graphics.) (obj)).outHeight);
                CollageCreatorView.c(d, i);
                CollageCreatorView.d(d, i);
            }
            float f1 = (float)i / (float)Math.min(((android.graphics.) (obj)).outWidth, ((android.graphics.) (obj)).outHeight);
            a a1;
            try
            {
                CollageCreatorView.b(d, w.a(CollageCreatorView.G(d), (int)((float)((android.graphics.) (obj)).outWidth * f1), (int)(f1 * (float)((android.graphics.) (obj)).outHeight), ((android.graphics.) (obj)).outWidth, ((android.graphics.) (obj)).outHeight, m.d(CollageCreatorView.G(d))));
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
        } else
        {
            i = j;
        }
        if (CollageCreatorView.H(d))
        {
            obj = w.a(CollageCreatorView.G(d));
            CollageCreatorView.c(d, ((android.graphics.) (obj)).outWidth);
            CollageCreatorView.d(d, ((android.graphics.) (obj)).outHeight);
            i = Math.max(CollageCreatorView.I(d), CollageCreatorView.J(d));
        } else
        if (CollageCreatorView.K(d) > 1.0F)
        {
            CollageCreatorView.d(d, (int)((float)CollageCreatorView.I(d) / CollageCreatorView.K(d)));
        } else
        {
            CollageCreatorView.c(d, (int)((float)CollageCreatorView.J(d) * CollageCreatorView.K(d)));
        }
        obj = CollageCreatorView.l(d).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            a1 = (a)((Iterator) (obj)).next();
            if (a1.d != null && !a1.d.isRecycled())
            {
                a1.d.recycle();
            }
        } while (true);
        f2 = d.b();
        f3 = (float)i / f2;
        obj2 = Bitmap.createBitmap(CollageCreatorView.I(d), CollageCreatorView.J(d), android.graphics._fld88);
        obj3 = new Canvas(((Bitmap) (obj2)));
        if (!CollageCreatorView.H(d))
        {
            if (CollageCreatorView.F(d) == null || CollageCreatorView.F(d).isRecycled())
            {
                ((Canvas) (obj3)).drawRect(new RectF(0.0F, 0.0F, CollageCreatorView.L(d).width() * f3, CollageCreatorView.L(d).height() * f3), CollageCreatorView.M(d));
            } else
            {
                j = (CollageCreatorView.I(d) - CollageCreatorView.F(d).getWidth()) / 2;
                k = (CollageCreatorView.J(d) - CollageCreatorView.F(d).getHeight()) / 2;
                ((Canvas) (obj3)).drawBitmap(CollageCreatorView.F(d), j, k, CollageCreatorView.M(d));
                ((Canvas) (obj3)).save();
                ((Canvas) (obj3)).scale(f3, f3);
                ((Canvas) (obj3)).restore();
                CollageCreatorView.F(d).recycle();
                j = (int)((a)CollageCreatorView.l(d).get(0)).o;
                try
                {
                    CollageCreatorView.b(d, w.a(CollageCreatorView.G(d), j, j, m.d(CollageCreatorView.G(d))));
                }
                catch (Exception exception1)
                {
                    exception1.printStackTrace();
                }
            }
        }
        ((Canvas) (obj3)).save();
        ((Canvas) (obj3)).scale(f3, f3);
        k = CollageCreatorView.l(d).size();
        j = 0;
        if (j >= k)
        {
            break MISSING_BLOCK_LABEL_1062;
        }
        a2 = (a)CollageCreatorView.l(d).get(j);
        if (a2.x != null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (CollageCreatorView.H(d))
        {
            a2.a(((Canvas) (obj3)), CollageCreatorView.N(d) + CollageCreatorView.O(d), CollageCreatorView.N(d) + CollageCreatorView.O(d));
        }
_L4:
        j++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_556;
_L1:
label0:
        {
            if (a2.x.isFromBuffer() || a2.x.getPath() != null)
            {
                break label0;
            }
            if (CollageCreatorView.H(d))
            {
                a2.a(((Canvas) (obj3)), CollageCreatorView.N(d) + CollageCreatorView.O(d), CollageCreatorView.N(d) + CollageCreatorView.O(d));
            }
        }
        continue; /* Loop/switch isn't completed */
        if ((a2.e.width() * a2.e.height()) / (float)(i * i) > 0.25F)
        {
            f2 = 2.0F;
        } else
        {
            f2 = 1.5F;
        }
        l = (int)(f2 * (float)PicsartContext.a.getMaxCollageSaveSize());
        if (!a2.x.isFromBuffer())
        {
            break MISSING_BLOCK_LABEL_1028;
        }
        obj1 = w.a(a2.x.getBufferData(), l, l, a2.w);
_L5:
        a2.a(((Bitmap) (obj1)), true, a2.x, false);
        a2.a(((Canvas) (obj3)), CollageCreatorView.N(d) + CollageCreatorView.O(d), CollageCreatorView.N(d) + CollageCreatorView.O(d));
        if (a2.d != null)
        {
            a2.d.recycle();
        }
        if (true) goto _L4; else goto _L3
_L3:
        try
        {
            obj1 = w.a(a2.x.getPath(), l, l, a2.w);
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception2)
        {
            exception2.printStackTrace();
            exception2 = null;
        }
          goto _L5
        if (true) goto _L4; else goto _L6
_L6:
        ((Canvas) (obj3)).restore();
        if (CollageCreatorView.H(d))
        {
            new Rect(0, 0, i, i);
            ((Canvas) (obj3)).drawBitmap(CollageCreatorView.F(d), 0.0F, 0.0F, CollageCreatorView.M(d));
            ((Canvas) (obj3)).save();
            ((Canvas) (obj3)).scale(f3, f3);
            ((Canvas) (obj3)).restore();
            CollageCreatorView.F(d).recycle();
            i = (int)((a)CollageCreatorView.l(d).get(0)).o;
            try
            {
                CollageCreatorView.b(d, w.a(CollageCreatorView.G(d), i, i, 0));
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception2)
            {
                exception2.printStackTrace();
            }
        }
        w.a(new File(a), ((Bitmap) (obj2)), android.graphics..JPEG, b);
        ((Bitmap) (obj2)).recycle();
        i = 0;
        if (i >= k) goto _L8; else goto _L7
_L7:
        obj2 = (a)CollageCreatorView.l(d).get(i);
        if (((a) (obj2)).x == null) goto _L10; else goto _L9
_L9:
        obj3 = ((a) (obj2)).x;
        exception2 = ((a) (obj2)).i;
        if (((a) (obj2)).s != null)
        {
            ((a) (obj2)).s.cancel(true);
        }
        obj2.x = ((CollageImage) (obj3));
        if (exception2 != null)
        {
            obj2.i = exception2;
        }
        if (obj3 == null) goto _L12; else goto _L11
_L11:
        j = ((a) (obj2)).t.a();
        if (!((CollageImage) (obj3)).isFromBuffer()) goto _L14; else goto _L13
_L13:
        exception2 = w.a(((CollageImage) (obj3)).getBufferData(), j, j, ((CollageImage) (obj3)).getDegree());
        (new StringBuilder("loaded size  = ")).append(exception2.getWidth()).append(" ").append(exception2.getHeight());
_L16:
        ((a) (obj2)).a(exception2, true, ((CollageImage) (obj3)), false);
        ((a) (obj2)).c();
        obj2.v = false;
_L10:
        i++;
        break MISSING_BLOCK_LABEL_1215;
_L14:
        exception2 = w.a(((CollageImage) (obj3)).getPath(), j, j, ((CollageImage) (obj3)).getDegree());
        try
        {
            (new StringBuilder("loaded size  = ")).append(exception2.getWidth()).append(" ").append(exception2.getHeight());
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception3) { }
        continue; /* Loop/switch isn't completed */
_L12:
        ((a) (obj2)).a(null, true, ((CollageImage) (obj3)), true);
        obj2.v = false;
        if (true) goto _L10; else goto _L8
_L8:
        return null;
        continue; /* Loop/switch isn't completed */
        exception2;
        exception2 = null;
        if (true) goto _L16; else goto _L15
_L15:
    }

    protected final Object doInBackground(Object aobj[])
    {
        return a();
    }

    protected final void onPostExecute(Object obj)
    {
        super.onPostExecute((Void)obj);
        CollageCreatorView.h(d, false);
        d.invalidate();
        if (c != null)
        {
            c.a(a);
        }
    }

    protected final void onPreExecute()
    {
        CollageCreatorView.h(d, true);
        super.onPreExecute();
    }

    pe(CollageCreatorView collagecreatorview, String s, Activity activity, f f1)
    {
        d = collagecreatorview;
        a = s;
        b = activity;
        c = f1;
        super();
    }
}
