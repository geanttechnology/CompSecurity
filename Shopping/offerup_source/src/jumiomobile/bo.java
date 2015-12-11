// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

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

// Referenced classes of package jumiomobile:
//            be

public class bo extends View
{

    private Bitmap a;
    private Matrix b;
    private Matrix c;
    private int d;
    private int e;
    private boolean f;
    private boolean g;
    private boolean h;
    private RelativeLayout i;
    private int j;

    public bo(Context context)
    {
        super(context);
        a = null;
        b = null;
        c = null;
        f = false;
        g = false;
        h = false;
        j = 0;
    }

    private Bitmap a(Bitmap bitmap)
    {
        Bitmap bitmap1 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        Object obj = RenderScript.create(getContext());
        ScriptIntrinsicBlur scriptintrinsicblur = ScriptIntrinsicBlur.create(((RenderScript) (obj)), Element.U8_4(((RenderScript) (obj))));
        Allocation allocation = Allocation.createFromBitmap(((RenderScript) (obj)), bitmap, android.renderscript.Allocation.MipmapControl.MIPMAP_NONE, 4);
        obj = Allocation.createFromBitmap(((RenderScript) (obj)), bitmap1);
        scriptintrinsicblur.setRadius(10F);
        scriptintrinsicblur.setInput(allocation);
        scriptintrinsicblur.forEach(((Allocation) (obj)));
        ((Allocation) (obj)).copyTo(bitmap1);
        be.b(bitmap);
        return bitmap1;
    }

    private void a(int k, int l, Matrix matrix)
    {
        float f1 = 90F;
        int i1 = l;
        if (i != null)
        {
            i1 = l;
            if (matrix == null)
            {
                l += i.getRootView().getHeight() - i.getHeight();
                i1 = l;
                if (h)
                {
                    i1 = l - j;
                }
            }
        }
        b = new Matrix();
        if (g)
        {
            Matrix matrix1 = b;
            if (h)
            {
                f1 = 0.0F;
            }
            matrix1.postRotate(f1, 0.0F, 0.0F);
            if (!h)
            {
                b.postTranslate(a.getHeight(), 0.0F);
                b.postScale((float)k / (float)a.getHeight(), (float)i1 / (float)a.getWidth());
            } else
            {
                b.postScale((float)k / (float)a.getWidth(), (float)i1 / (float)a.getHeight());
            }
        } else
        {
            Matrix matrix2 = b;
            if (!h)
            {
                f1 = 0.0F;
            }
            matrix2.postRotate(f1, 0.0F, 0.0F);
            if (!h)
            {
                b.postScale((float)k / (float)a.getWidth(), (float)i1 / (float)a.getHeight());
            } else
            {
                b.postTranslate(a.getHeight(), 0.0F);
                b.postScale((float)k / (float)a.getHeight(), (float)i1 / (float)a.getWidth());
            }
        }
        if (matrix != null)
        {
            b.postConcat(matrix);
        }
    }

    private void b(Bitmap bitmap)
    {
        int i10 = bitmap.getWidth();
        int j10 = bitmap.getHeight();
        int ai[] = new int[i10 * j10];
        bitmap.getPixels(ai, 0, i10, 0, 0, i10, j10);
        int l10 = i10 - 1;
        int k10 = j10 - 1;
        int k = i10 * j10;
        int ai1[] = new int[k];
        int ai2[] = new int[k];
        int ai3[] = new int[k];
        int ai4[] = new int[Math.max(i10, j10)];
        int ai5[] = new int[43264];
        for (int l = 0; l < 43264; l++)
        {
            ai5[l] = l / 169;
        }

        int ai6[][] = (int[][])Array.newInstance(Integer.TYPE, new int[] {
            25, 3
        });
        int i6 = 0;
        int k6 = 0;
        for (int k5 = 0; k5 < j10; k5++)
        {
            int i1 = 0;
            int i2 = 0;
            int k2 = 0;
            int i3 = 0;
            int k3 = 0;
            int i7 = -12;
            int i4 = 0;
            int k4 = 0;
            int i5 = 0;
            int k1 = 0;
            while (i7 <= 12) 
            {
                int l7 = ai[Math.min(l10, Math.max(i7, 0)) + k6];
                int ai7[] = ai6[i7 + 12];
                ai7[0] = l7 >> 16 & 0xff;
                ai7[1] = l7 >> 8 & 0xff;
                ai7[2] = l7 & 0xff;
                l7 = 13 - Math.abs(i7);
                i5 += ai7[0] * l7;
                k4 += ai7[1] * l7;
                i4 += l7 * ai7[2];
                if (i7 > 0)
                {
                    i2 += ai7[0];
                    k1 += ai7[1];
                    i1 += ai7[2];
                } else
                {
                    k3 += ai7[0];
                    i3 += ai7[1];
                    k2 += ai7[2];
                }
                i7++;
            }
            byte byte0 = 12;
            boolean flag = false;
            int i8 = i5;
            i7 = k4;
            i5 = i4;
            i4 = ((flag) ? 1 : 0);
            k4 = byte0;
            for (; i4 < i10; i4++)
            {
                ai1[k6] = ai5[i8];
                ai2[k6] = ai5[i7];
                ai3[k6] = ai5[i5];
                int ai8[] = ai6[((k4 - 12) + 25) % 25];
                int j11 = ai8[0];
                int k9 = ai8[1];
                int i9 = ai8[2];
                if (k5 == 0)
                {
                    ai4[i4] = Math.min(i4 + 12 + 1, l10);
                }
                int k11 = ai[ai4[i4] + i6];
                ai8[0] = k11 >> 16 & 0xff;
                ai8[1] = k11 >> 8 & 0xff;
                ai8[2] = k11 & 0xff;
                i2 += ai8[0];
                k1 += ai8[1];
                i1 += ai8[2];
                i8 = (i8 - k3) + i2;
                i7 = (i7 - i3) + k1;
                i5 = (i5 - k2) + i1;
                k4 = (k4 + 1) % 25;
                ai8 = ai6[k4 % 25];
                k3 = (k3 - j11) + ai8[0];
                i3 = (i3 - k9) + ai8[1];
                k2 = (k2 - i9) + ai8[2];
                i2 -= ai8[0];
                k1 -= ai8[1];
                i1 -= ai8[2];
                k6++;
            }

            i6 += i10;
        }

        for (int j1 = 0; j1 < i10; j1++)
        {
            int j4 = 0;
            int j3 = 0;
            int l1 = 0;
            int j2 = 0;
            int l2 = 0;
            int j6 = -12;
            int l4 = 0;
            int j5 = 0;
            int l5 = 0;
            int l6 = i10 * -12;
            int l3 = 0;
            while (j6 <= 12) 
            {
                int j7 = Math.max(0, l6) + j1;
                int ai9[] = ai6[j6 + 12];
                ai9[0] = ai1[j7];
                ai9[1] = ai2[j7];
                ai9[2] = ai3[j7];
                int j8 = 13 - Math.abs(j6);
                l5 += ai1[j7] * j8;
                j5 += ai2[j7] * j8;
                j7 = l4 + ai3[j7] * j8;
                if (j6 > 0)
                {
                    j3 += ai9[0];
                    l3 += ai9[1];
                    j4 += ai9[2];
                } else
                {
                    l2 += ai9[0];
                    j2 += ai9[1];
                    l1 += ai9[2];
                }
                l4 = l6;
                if (j6 < k10)
                {
                    l4 = l6 + i10;
                }
                j6++;
                l6 = l4;
                l4 = j7;
            }
            boolean flag1 = false;
            byte byte1 = 12;
            j6 = j4;
            l6 = l3;
            int k7 = j3;
            int k8 = l1;
            j3 = j2;
            j2 = j1;
            l1 = ((flag1) ? 1 : 0);
            j4 = byte1;
            l3 = l2;
            l2 = k8;
            for (; l1 < j10; l1++)
            {
                ai[j2] = 0xff000000 & ai[j2] | ai5[l5] << 16 | ai5[j5] << 8 | ai5[l4];
                int ai10[] = ai6[((j4 - 12) + 25) % 25];
                int l9 = ai10[0];
                int j9 = ai10[1];
                int l8 = ai10[2];
                if (j1 == 0)
                {
                    ai4[l1] = Math.min(l1 + 13, k10) * i10;
                }
                int i11 = ai4[l1] + j1;
                ai10[0] = ai1[i11];
                ai10[1] = ai2[i11];
                ai10[2] = ai3[i11];
                k7 += ai10[0];
                l6 += ai10[1];
                j6 += ai10[2];
                l5 = (l5 - l3) + k7;
                j5 = (j5 - j3) + l6;
                l4 = (l4 - l2) + j6;
                j4 = (j4 + 1) % 25;
                ai10 = ai6[j4];
                l3 = (l3 - l9) + ai10[0];
                j3 = (j3 - j9) + ai10[1];
                l2 = (l2 - l8) + ai10[2];
                k7 -= ai10[0];
                l6 -= ai10[1];
                j6 -= ai10[2];
                j2 += i10;
            }

        }

        bitmap.setPixels(ai, 0, i10, 0, 0, i10, j10);
    }

    public void a()
    {
        be.b(a);
        a = null;
        invalidate();
        setVisibility(8);
        f = false;
    }

    public void a(Bitmap bitmap, Matrix matrix, boolean flag)
    {
        if (f || bitmap == null)
        {
            return;
        }
        f = true;
        g = flag;
        h = flag;
        Bitmap bitmap1 = be.a(bitmap, bitmap.getWidth() / 3, bitmap.getHeight() / 3);
        if (android.os.Build.VERSION.SDK_INT > 16)
        {
            bitmap1 = a(bitmap1);
        } else
        {
            b(bitmap1);
        }
        a = be.a(bitmap1);
        c = matrix;
        d = bitmap.getWidth();
        e = bitmap.getHeight();
        a(d, e, c);
        be.b(bitmap1);
    }

    public void a(boolean flag)
    {
        if (!f || b == null)
        {
            return;
        } else
        {
            h = flag;
            return;
        }
    }

    public void b()
    {
        AlphaAnimation alphaanimation = new AlphaAnimation(0.0F, 1.0F);
        alphaanimation.setDuration(500L);
        setAnimation(alphaanimation);
        setVisibility(0);
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (a != null)
        {
            canvas.drawBitmap(a, b, null);
        }
    }

    protected void onSizeChanged(int k, int l, int i1, int j1)
    {
label0:
        {
            if (a != null && i1 != 0 && j1 != 0)
            {
                if (g != h)
                {
                    break label0;
                }
                a(d, e, c);
            }
            return;
        }
        a(k, l, ((Matrix) (null)));
    }

    public void setActionBarHeight(int k)
    {
        j = k;
    }

    public void setRootRelativeLayout(RelativeLayout relativelayout)
    {
        i = relativelayout;
    }
}
