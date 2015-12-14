// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.cyberlink.youcammakeup.utility.c;
import com.pf.common.utility.m;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            k, l, i, ah, 
//            j

public class CameraShotAnimationVeiw extends View
{

    private AnimatorSet a;
    private ValueAnimator b;
    private boolean c;
    private int d;
    private int e;
    private final int f[] = {
        0x7f0208bb, 0x7f0208bc, 0x7f0208bd, 0x7f0208be, 0x7f0208bf, 0x7f0208c0, 0x7f0208c1, 0
    };
    private Bitmap g[];
    private l h[];
    private i i;
    private ah j;

    public CameraShotAnimationVeiw(Context context)
    {
        super(context);
        a = new AnimatorSet();
        c = true;
        d = -1;
        e = -1;
        e();
    }

    public CameraShotAnimationVeiw(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = new AnimatorSet();
        c = true;
        d = -1;
        e = -1;
        e();
    }

    public CameraShotAnimationVeiw(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        a = new AnimatorSet();
        c = true;
        d = -1;
        e = -1;
        e();
    }

    static int a(CameraShotAnimationVeiw camerashotanimationveiw, int i1)
    {
        camerashotanimationveiw.d = i1;
        return i1;
    }

    private long a(int i1)
    {
        return (long)(66.666666666666671D * (double)i1);
    }

    static i a(CameraShotAnimationVeiw camerashotanimationveiw)
    {
        return camerashotanimationveiw.i;
    }

    static void a(CameraShotAnimationVeiw camerashotanimationveiw, boolean flag)
    {
        camerashotanimationveiw.setStarSequenceLoop(flag);
    }

    static int b(CameraShotAnimationVeiw camerashotanimationveiw, int i1)
    {
        camerashotanimationveiw.e = i1;
        return i1;
    }

    static ah b(CameraShotAnimationVeiw camerashotanimationveiw)
    {
        return camerashotanimationveiw.j;
    }

    static boolean b(CameraShotAnimationVeiw camerashotanimationveiw, boolean flag)
    {
        camerashotanimationveiw.c = flag;
        return flag;
    }

    static boolean c(CameraShotAnimationVeiw camerashotanimationveiw)
    {
        return camerashotanimationveiw.c;
    }

    static int d(CameraShotAnimationVeiw camerashotanimationveiw)
    {
        return camerashotanimationveiw.d;
    }

    private void e()
    {
        if (isInEditMode())
        {
            return;
        } else
        {
            ObjectAnimator objectanimator = ObjectAnimator.ofFloat(this, "alpha", new float[] {
                0.0F, 0.9F
            });
            objectanimator.setDuration(a(4));
            objectanimator.setInterpolator(new LinearInterpolator());
            objectanimator.addListener(new j() {

                final CameraShotAnimationVeiw a;

                public void onAnimationStart(Animator animator)
                {
                    a.setAlpha(0.0F);
                    a.setBackgroundColor(-1);
                    if (CameraShotAnimationVeiw.a(a) != null)
                    {
                        CameraShotAnimationVeiw.a(a).a();
                    }
                }

            
            {
                a = CameraShotAnimationVeiw.this;
                super(CameraShotAnimationVeiw.this);
            }
            });
            ObjectAnimator objectanimator1 = ObjectAnimator.ofFloat(this, "alpha", new float[] {
                0.6F, 0.0F
            });
            objectanimator1.setDuration(a(3));
            objectanimator1.setInterpolator(new LinearInterpolator());
            objectanimator1.addListener(new j() {

                final CameraShotAnimationVeiw a;

                public void onAnimationEnd(Animator animator)
                {
                    a.setAlpha(1.0F);
                    a.setBackgroundColor(0);
                }

            
            {
                a = CameraShotAnimationVeiw.this;
                super(CameraShotAnimationVeiw.this);
            }
            });
            ValueAnimator valueanimator = ValueAnimator.ofInt(new int[] {
                0
            });
            valueanimator.setDuration(a(1));
            valueanimator.setInterpolator(new LinearInterpolator());
            int ai[] = com.cyberlink.youcammakeup.utility.c.b(1, 17);
            b = ValueAnimator.ofInt(ai);
            b.setDuration(a(ai.length));
            b.setRepeatCount(-1);
            b.setInterpolator(new LinearInterpolator());
            b.addUpdateListener(new k(this));
            b.addListener(new j() {

                final CameraShotAnimationVeiw a;

                public void onAnimationEnd(Animator animator)
                {
                    CameraShotAnimationVeiw.a(a, -1);
                    CameraShotAnimationVeiw.b(a, -1);
                }

                public void onAnimationRepeat(Animator animator)
                {
                    CameraShotAnimationVeiw.a(a, true);
                }

                public void onAnimationStart(Animator animator)
                {
                    if (CameraShotAnimationVeiw.b(a) != null && !com.cyberlink.youcammakeup.camera.CameraShotAnimationVeiw.c(a))
                    {
                        CameraShotAnimationVeiw.b(a).a(4);
                    }
                }

            
            {
                a = CameraShotAnimationVeiw.this;
                super(CameraShotAnimationVeiw.this);
            }
            });
            a.playSequentially(new Animator[] {
                objectanimator, objectanimator1, valueanimator, b
            });
            a.addListener(new j() {

                final CameraShotAnimationVeiw a;

                public void onAnimationEnd(Animator animator)
                {
                    CameraShotAnimationVeiw.b(a, true);
                    a.invalidate();
                }

            
            {
                a = CameraShotAnimationVeiw.this;
                super(CameraShotAnimationVeiw.this);
            }
            });
            a();
            f();
            return;
        }
    }

    static int[] e(CameraShotAnimationVeiw camerashotanimationveiw)
    {
        return camerashotanimationveiw.f;
    }

    private void f()
    {
        h = new l[8];
        h[0] = new l(this, 781, 454, 0.6F, 1);
        h[1] = new l(this, 228, 292, 1.0F, 2);
        h[2] = new l(this, 171, 1135, 0.8F, 3);
        h[3] = new l(this, 737, 1063, 0.5F, 6);
        h[4] = new l(this, 28, 752, 0.75F, 7);
        h[5] = new l(this, 802, 721, 0.6F, 10);
        h[6] = new l(this, 360, 445, 0.5F, 12);
        h[7] = new l(this, 708, 1238, 0.65F, 13);
    }

    private void setStarSequenceLoop(boolean flag)
    {
        for (int i1 = 0; i1 < h.length; i1++)
        {
            h[i1].a(flag);
        }

    }

    public void a()
    {
        if (g == null)
        {
            int j1 = f.length;
            g = new Bitmap[j1];
            int i1 = 0;
            while (i1 < j1) 
            {
                if (f[i1] == 0)
                {
                    g[i1] = null;
                } else
                {
                    try
                    {
                        g[i1] = BitmapFactory.decodeResource(getResources(), f[i1]);
                    }
                    catch (android.content.res.Resources.NotFoundException notfoundexception)
                    {
                        g[i1] = null;
                        m.b("CameraShotAnimationVeiw", (new StringBuilder()).append("Exception happened e=").append(notfoundexception.toString()).toString());
                    }
                }
                i1++;
            }
        }
    }

    public void b()
    {
        if (g == null)
        {
            return;
        }
        for (int i1 = 0; i1 < f.length; i1++)
        {
            if (g[i1] != null)
            {
                g[i1].recycle();
                g[i1] = null;
            }
        }

        g = null;
    }

    public void c()
    {
        setStarSequenceLoop(false);
        a.cancel();
        c = false;
        a.start();
    }

    public void d()
    {
        c = true;
        d = -1;
        e = -1;
        b.end();
    }

    protected void onDraw(Canvas canvas)
    {
        if (c || e < 0 || g == null)
        {
            return;
        }
        canvas.save();
        canvas.translate((float)getWidth() / 2.0F, (float)getHeight() / 2.0F);
        for (int i1 = 0; i1 < h.length; i1++)
        {
            l l1 = h[i1];
            int j1 = l1.a(e);
            if (j1 != -1 && g[j1] != null)
            {
                canvas.drawBitmap(g[j1], null, l.a(l1), null);
            }
        }

        canvas.restore();
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        super.onSizeChanged(i1, j1, k1, l1);
        if (!isInEditMode())
        {
            k1 = 0;
            while (k1 < h.length) 
            {
                h[k1].a(i1, j1);
                k1++;
            }
        }
    }

    public void setOnAnimationStartListener(i i1)
    {
        i = i1;
    }

    public void setSoundPlayer(ah ah)
    {
        j = ah;
    }

    public void setStarRepeatCount(int i1)
    {
        b.setRepeatCount(i1);
    }
}
