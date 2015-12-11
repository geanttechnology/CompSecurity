// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import java.lang.reflect.Array;

// Referenced classes of package netswipe:
//            db

public class at extends View
{

    private Bitmap a;
    private Matrix b;
    private boolean c;
    private boolean d;
    private boolean e;
    private RelativeLayout f;
    private int g;

    public at(Context context)
    {
        super(context);
        c = false;
        d = false;
        e = false;
        g = 0;
    }

    private Bitmap a(Bitmap bitmap)
    {
        Bitmap bitmap1 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        Object obj = RenderScript.create(getContext());
        ScriptIntrinsicBlur scriptintrinsicblur = ScriptIntrinsicBlur.create(((RenderScript) (obj)), Element.U8_4(((RenderScript) (obj))));
        Allocation allocation = Allocation.createFromBitmap(((RenderScript) (obj)), bitmap, android.renderscript.Allocation.MipmapControl.MIPMAP_NONE, 4);
        obj = Allocation.createFromBitmap(((RenderScript) (obj)), bitmap1);
        scriptintrinsicblur.setRadius(10F);
        scriptintrinsicblur.setInput(allocation);
        scriptintrinsicblur.forEach(((Allocation) (obj)));
        ((Allocation) (obj)).copyTo(bitmap1);
        db.b(bitmap);
        return bitmap1;
    }

    private void a(int i, int j)
    {
        float f1 = 90F;
        int k = j;
        if (f != null)
        {
            j += f.getRootView().getHeight() - f.getHeight();
            k = j;
            if (e)
            {
                k = j - g;
            }
        }
        b = new Matrix();
        if (d)
        {
            Matrix matrix = b;
            if (e)
            {
                f1 = 0.0F;
            }
            matrix.postRotate(f1, 0.0F, 0.0F);
            if (!e)
            {
                b.postTranslate(a.getHeight(), 0.0F);
                b.postScale((float)i / (float)a.getHeight(), (float)k / (float)a.getWidth());
                return;
            } else
            {
                b.postScale((float)i / (float)a.getWidth(), (float)k / (float)a.getHeight());
                return;
            }
        }
        Matrix matrix1 = b;
        if (!e)
        {
            f1 = 0.0F;
        }
        matrix1.postRotate(f1, 0.0F, 0.0F);
        if (!e)
        {
            b.postScale((float)i / (float)a.getWidth(), (float)k / (float)a.getHeight());
            return;
        } else
        {
            b.postTranslate(a.getHeight(), 0.0F);
            b.postScale((float)i / (float)a.getHeight(), (float)k / (float)a.getWidth());
            return;
        }
    }

    private void b(Bitmap bitmap)
    {
        int j10 = bitmap.getWidth();
        int k10 = bitmap.getHeight();
        int ai[] = new int[j10 * k10];
        bitmap.getPixels(ai, 0, j10, 0, 0, j10, k10);
        int l9 = j10 - 1;
        int l10 = k10 - 1;
        int i = j10 * k10;
        int ai1[] = new int[i];
        int ai2[] = new int[i];
        int ai3[] = new int[i];
        int ai4[] = new int[Math.max(j10, k10)];
        int ai5[] = new int[43264];
        for (int j = 0; j < 43264; j++)
        {
            ai5[j] = j / 169;
        }

        int ai6[][] = (int[][])Array.newInstance(Integer.TYPE, new int[] {
            25, 3
        });
        int k5 = 0;
        int i6 = 0;
        for (int i5 = 0; i5 < k10; i5++)
        {
            int k = 0;
            int k1 = 0;
            int i2 = 0;
            int k2 = 0;
            int i3 = 0;
            int k6 = -12;
            int k3 = 0;
            int i4 = 0;
            int k4 = 0;
            int i1 = 0;
            while (k6 <= 12) 
            {
                int j7 = ai[Math.min(l9, Math.max(k6, 0)) + i6];
                int ai7[] = ai6[k6 + 12];
                ai7[0] = (0xff0000 & j7) >> 16;
                ai7[1] = (0xff00 & j7) >> 8;
                ai7[2] = j7 & 0xff;
                j7 = 13 - Math.abs(k6);
                k4 += ai7[0] * j7;
                i4 += ai7[1] * j7;
                k3 += j7 * ai7[2];
                if (k6 > 0)
                {
                    k1 += ai7[0];
                    i1 += ai7[1];
                    k += ai7[2];
                } else
                {
                    i3 += ai7[0];
                    k2 += ai7[1];
                    i2 += ai7[2];
                }
                k6++;
            }
            byte byte0 = 12;
            boolean flag = false;
            int k7 = k4;
            k6 = i4;
            k4 = k3;
            k3 = ((flag) ? 1 : 0);
            i4 = byte0;
            for (; k3 < j10; k3++)
            {
                ai1[i6] = ai5[k7];
                ai2[i6] = ai5[k6];
                ai3[i6] = ai5[k4];
                int ai8[] = ai6[((i4 - 12) + 25) % 25];
                int i11 = ai8[0];
                int j9 = ai8[1];
                int k8 = ai8[2];
                if (i5 == 0)
                {
                    ai4[k3] = Math.min(k3 + 12 + 1, l9);
                }
                int j11 = ai[ai4[k3] + k5];
                ai8[0] = (0xff0000 & j11) >> 16;
                ai8[1] = (0xff00 & j11) >> 8;
                ai8[2] = j11 & 0xff;
                k1 += ai8[0];
                i1 += ai8[1];
                k += ai8[2];
                k7 = (k7 - i3) + k1;
                k6 = (k6 - k2) + i1;
                k4 = (k4 - i2) + k;
                i4 = (i4 + 1) % 25;
                ai8 = ai6[i4 % 25];
                i3 = (i3 - i11) + ai8[0];
                k2 = (k2 - j9) + ai8[1];
                i2 = (i2 - k8) + ai8[2];
                k1 -= ai8[0];
                i1 -= ai8[1];
                k -= ai8[2];
                i6++;
            }

            k5 += j10;
        }

        for (int l = 0; l < j10; l++)
        {
            int l3 = 0;
            int j6 = j10 * -12;
            int l2 = 0;
            int j1 = 0;
            int l1 = 0;
            int j2 = 0;
            int l5 = -12;
            int j4 = 0;
            int l4 = 0;
            int j5 = 0;
            int j3 = 0;
            while (l5 <= 12) 
            {
                int l6 = Math.max(0, j6) + l;
                int ai9[] = ai6[l5 + 12];
                ai9[0] = ai1[l6];
                ai9[1] = ai2[l6];
                ai9[2] = ai3[l6];
                int l7 = 13 - Math.abs(l5);
                j5 += ai1[l6] * l7;
                l4 += ai2[l6] * l7;
                l6 = j4 + ai3[l6] * l7;
                if (l5 > 0)
                {
                    l2 += ai9[0];
                    j3 += ai9[1];
                    l3 += ai9[2];
                } else
                {
                    j2 += ai9[0];
                    l1 += ai9[1];
                    j1 += ai9[2];
                }
                j4 = j6;
                if (l5 < l10)
                {
                    j4 = j6 + j10;
                }
                l5++;
                j6 = j4;
                j4 = l6;
            }
            boolean flag1 = false;
            int i8 = l;
            byte byte1 = 12;
            l5 = l3;
            j6 = j3;
            int i7 = l2;
            int l8 = j1;
            l2 = l1;
            j1 = ((flag1) ? 1 : 0);
            l1 = i8;
            l3 = byte1;
            j3 = j2;
            j2 = l8;
            for (; j1 < k10; j1++)
            {
                ai[l1] = 0xff000000 & ai[l1] | ai5[j5] << 16 | ai5[l4] << 8 | ai5[j4];
                int ai10[] = ai6[((l3 - 12) + 25) % 25];
                int k9 = ai10[0];
                int i9 = ai10[1];
                int j8 = ai10[2];
                if (l == 0)
                {
                    ai4[j1] = Math.min(j1 + 13, l10) * j10;
                }
                int i10 = ai4[j1] + l;
                ai10[0] = ai1[i10];
                ai10[1] = ai2[i10];
                ai10[2] = ai3[i10];
                i7 += ai10[0];
                j6 += ai10[1];
                l5 += ai10[2];
                j5 = (j5 - j3) + i7;
                l4 = (l4 - l2) + j6;
                j4 = (j4 - j2) + l5;
                l3 = (l3 + 1) % 25;
                ai10 = ai6[l3];
                j3 = (j3 - k9) + ai10[0];
                l2 = (l2 - i9) + ai10[1];
                j2 = (j2 - j8) + ai10[2];
                i7 -= ai10[0];
                j6 -= ai10[1];
                l5 -= ai10[2];
                l1 += j10;
            }

        }

        bitmap.setPixels(ai, 0, j10, 0, 0, j10, k10);
    }

    public void a()
    {
        db.b(a);
        a = null;
        invalidate();
        setVisibility(8);
        c = false;
    }

    public void a(Bitmap bitmap, boolean flag)
    {
        if (c || bitmap == null)
        {
            return;
        }
        c = true;
        d = flag;
        e = flag;
        Bitmap bitmap1 = db.a(bitmap, bitmap.getWidth() / 3, bitmap.getHeight() / 3);
        if (android.os.Build.VERSION.SDK_INT > 16)
        {
            bitmap1 = a(bitmap1);
        } else
        {
            b(bitmap1);
        }
        a = db.a(bitmap1);
        a(bitmap.getWidth(), bitmap.getHeight());
        bitmap = new AlphaAnimation(0.0F, 1.0F);
        bitmap.setDuration(500L);
        setAnimation(bitmap);
        setVisibility(0);
        db.b(bitmap1);
    }

    public void a(boolean flag)
    {
        if (!c || b == null)
        {
            return;
        } else
        {
            e = flag;
            return;
        }
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (a != null)
        {
            canvas.drawBitmap(a, b, null);
        }
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        if (a != null && k != 0 && l != 0)
        {
            a(i, j);
        }
    }

    public void setActionBarHeight(int i)
    {
        g = i;
    }

    public void setRootRelativeLayout(RelativeLayout relativelayout)
    {
        f = relativelayout;
    }
}
