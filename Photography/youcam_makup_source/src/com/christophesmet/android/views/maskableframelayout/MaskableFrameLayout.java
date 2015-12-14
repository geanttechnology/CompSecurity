// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.christophesmet.android.views.maskableframelayout;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.cyberlink.youcammakeup.j;
import com.pf.common.utility.m;

public class MaskableFrameLayout extends FrameLayout
{

    private Handler a;
    private Drawable b;
    private Bitmap c;
    private Paint d;
    private PorterDuffXfermode e;

    public MaskableFrameLayout(Context context)
    {
        super(context);
        b = null;
        c = null;
        d = null;
        e = null;
    }

    public MaskableFrameLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        b = null;
        c = null;
        d = null;
        e = null;
        a(context, attributeset);
    }

    public MaskableFrameLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        b = null;
        c = null;
        d = null;
        e = null;
        a(context, attributeset);
    }

    static Bitmap a(MaskableFrameLayout maskableframelayout, Drawable drawable)
    {
        return maskableframelayout.b(drawable);
    }

    private Paint a()
    {
        Paint paint = new Paint(1);
        paint.setXfermode(e);
        return paint;
    }

    private PorterDuffXfermode a(int i)
    {
        i;
        JVM INSTR tableswitch 0 17: default 88
    //                   0 127
    //                   1 139
    //                   2 174
    //                   3 181
    //                   4 188
    //                   5 195
    //                   6 202
    //                   7 209
    //                   8 216
    //                   9 223
    //                   10 230
    //                   11 242
    //                   12 277
    //                   13 284
    //                   14 291
    //                   15 298
    //                   16 305
    //                   17 312;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19
_L1:
        android.graphics.PorterDuff.Mode mode = android.graphics.PorterDuff.Mode.DST_IN;
_L21:
        a((new StringBuilder()).append("Mode is ").append(mode.toString()).toString());
        return new PorterDuffXfermode(mode);
_L2:
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            mode = android.graphics.PorterDuff.Mode.ADD;
        } else
        {
            a((new StringBuilder()).append("MODE_ADD is not supported on api lvl ").append(android.os.Build.VERSION.SDK_INT).toString());
        }
_L3:
        mode = android.graphics.PorterDuff.Mode.CLEAR;
        continue; /* Loop/switch isn't completed */
_L4:
        mode = android.graphics.PorterDuff.Mode.DARKEN;
        continue; /* Loop/switch isn't completed */
_L5:
        mode = android.graphics.PorterDuff.Mode.DST;
        continue; /* Loop/switch isn't completed */
_L6:
        mode = android.graphics.PorterDuff.Mode.DST_ATOP;
        continue; /* Loop/switch isn't completed */
_L7:
        mode = android.graphics.PorterDuff.Mode.DST_IN;
        continue; /* Loop/switch isn't completed */
_L8:
        mode = android.graphics.PorterDuff.Mode.DST_OUT;
        continue; /* Loop/switch isn't completed */
_L9:
        mode = android.graphics.PorterDuff.Mode.DST_OVER;
        continue; /* Loop/switch isn't completed */
_L10:
        mode = android.graphics.PorterDuff.Mode.LIGHTEN;
        continue; /* Loop/switch isn't completed */
_L11:
        mode = android.graphics.PorterDuff.Mode.MULTIPLY;
        continue; /* Loop/switch isn't completed */
_L12:
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            mode = android.graphics.PorterDuff.Mode.OVERLAY;
        } else
        {
            a((new StringBuilder()).append("MODE_OVERLAY is not supported on api lvl ").append(android.os.Build.VERSION.SDK_INT).toString());
        }
_L13:
        mode = android.graphics.PorterDuff.Mode.SCREEN;
        continue; /* Loop/switch isn't completed */
_L14:
        mode = android.graphics.PorterDuff.Mode.SRC;
        continue; /* Loop/switch isn't completed */
_L15:
        mode = android.graphics.PorterDuff.Mode.SRC_ATOP;
        continue; /* Loop/switch isn't completed */
_L16:
        mode = android.graphics.PorterDuff.Mode.SRC_IN;
        continue; /* Loop/switch isn't completed */
_L17:
        mode = android.graphics.PorterDuff.Mode.SRC_OUT;
        continue; /* Loop/switch isn't completed */
_L18:
        mode = android.graphics.PorterDuff.Mode.SRC_OVER;
        continue; /* Loop/switch isn't completed */
_L19:
        mode = android.graphics.PorterDuff.Mode.XOR;
        if (true) goto _L21; else goto _L20
_L20:
    }

    private Drawable a(TypedArray typedarray)
    {
        return typedarray.getDrawable(0);
    }

    static Drawable a(MaskableFrameLayout maskableframelayout)
    {
        return maskableframelayout.b;
    }

    private void a(int i, int k)
    {
        if (i > 0 && k > 0)
        {
            if (b != null)
            {
                a(b(b));
            }
            return;
        } else
        {
            a("Width and height must be higher than 0");
            return;
        }
    }

    private void a(Context context, AttributeSet attributeset)
    {
        a = new Handler();
        setDrawingCacheEnabled(true);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            setLayerType(1, null);
        }
        d = a();
        context = context.getTheme();
        if (context == null) goto _L2; else goto _L1
_L1:
        context = context.obtainStyledAttributes(attributeset, j.MaskableLayout, 0, 0);
        a(a(((TypedArray) (context))));
        e = a(context.getInteger(1, 0));
        a(b);
        if (context != null)
        {
            context.recycle();
        }
_L4:
        b();
        return;
        attributeset;
        if (context != null)
        {
            context.recycle();
        }
        throw attributeset;
_L2:
        a("Couldn't load theme, mask in xml won't be loaded.");
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void a(Bitmap bitmap)
    {
        if (bitmap != null)
        {
            if (c != null && !c.isRecycled())
            {
                c.recycle();
            }
            c = bitmap;
        }
    }

    private void a(Drawable drawable)
    {
        if (drawable != null)
        {
            b = drawable;
            if (b instanceof AnimationDrawable)
            {
                b.setCallback(this);
            }
            return;
        } else
        {
            a("Are you sure you don't want to provide a mask ?");
            return;
        }
    }

    static void a(MaskableFrameLayout maskableframelayout, Bitmap bitmap)
    {
        maskableframelayout.a(bitmap);
    }

    static void a(MaskableFrameLayout maskableframelayout, String s)
    {
        maskableframelayout.a(s);
    }

    private void a(String s)
    {
        m.b("MaskableFrameLayout", s);
    }

    private Bitmap b(Drawable drawable)
    {
        if (drawable != null)
        {
            if (getMeasuredWidth() > 0 && getMeasuredHeight() > 0)
            {
                Bitmap bitmap = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), android.graphics.Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                drawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
                drawable.draw(canvas);
                return bitmap;
            } else
            {
                a("Can't create a mask with height 0 or width 0. Or the layout has no children and is wrap content");
                return null;
            }
        } else
        {
            a("No bitmap mask loaded, view will NOT be masked !");
            return null;
        }
    }

    private void b()
    {
        ViewTreeObserver viewtreeobserver = getViewTreeObserver();
        if (viewtreeobserver != null && viewtreeobserver.isAlive())
        {
            viewtreeobserver.addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener(viewtreeobserver) {

                final ViewTreeObserver a;
                final MaskableFrameLayout b;

                public void onGlobalLayout()
                {
                    ViewTreeObserver viewtreeobserver2 = a;
                    ViewTreeObserver viewtreeobserver1 = viewtreeobserver2;
                    if (!viewtreeobserver2.isAlive())
                    {
                        viewtreeobserver1 = b.getViewTreeObserver();
                    }
                    if (viewtreeobserver1 != null)
                    {
                        if (android.os.Build.VERSION.SDK_INT >= 16)
                        {
                            viewtreeobserver1.removeOnGlobalLayoutListener(this);
                        } else
                        {
                            viewtreeobserver1.removeGlobalOnLayoutListener(this);
                        }
                    } else
                    {
                        MaskableFrameLayout.a(b, "GlobalLayoutListener not removed as ViewTreeObserver is not valid");
                    }
                    MaskableFrameLayout.a(b, MaskableFrameLayout.a(b, MaskableFrameLayout.a(b)));
                }

            
            {
                b = MaskableFrameLayout.this;
                a = viewtreeobserver;
                super();
            }
            });
        }
    }

    protected void dispatchDraw(Canvas canvas)
    {
        super.dispatchDraw(canvas);
        if (c != null && d != null)
        {
            d.setXfermode(e);
            canvas.drawBitmap(c, 0.0F, 0.0F, d);
            d.setXfermode(null);
            return;
        } else
        {
            a("Mask or paint is null ...");
            return;
        }
    }

    public Drawable getDrawableMask()
    {
        return b;
    }

    public void invalidateDrawable(Drawable drawable)
    {
        if (drawable != null)
        {
            a(drawable);
            a(b(drawable));
            invalidate();
        }
    }

    protected void onSizeChanged(int i, int k, int l, int i1)
    {
        super.onSizeChanged(i, k, l, i1);
        a(i, k);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long l)
    {
        if (drawable != null && runnable != null)
        {
            a.postAtTime(runnable, l);
        }
    }

    public void setMask(int i)
    {
        Resources resources = getResources();
        if (resources != null)
        {
            setMask(resources.getDrawable(i));
            return;
        } else
        {
            a("Unable to load resources, mask will not be loaded as drawable");
            return;
        }
    }

    public void setMask(Drawable drawable)
    {
        a(drawable);
        a(b(b));
        invalidate();
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable)
    {
        if (drawable != null && runnable != null)
        {
            a.removeCallbacks(runnable);
        }
    }
}
