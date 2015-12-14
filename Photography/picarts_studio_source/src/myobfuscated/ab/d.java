// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ab;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import com.bumptech.glide.load.h;
import java.nio.ByteBuffer;
import java.util.List;
import myobfuscated.f.m;
import myobfuscated.p.a;
import myobfuscated.s.g;

// Referenced classes of package myobfuscated.ab:
//            k, e, i, j

public class d extends Drawable
    implements Animatable, k
{

    final e a;
    boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private int f;
    private int g;
    private boolean h;
    private Paint i;
    private Rect j;

    public d(Context context, a a1, g g1, h h1, int l, int i1, Bitmap bitmap)
    {
        this(new e(context, new i(context, a1, l, i1, h1, bitmap)));
    }

    d(e e1)
    {
        e = true;
        g = -1;
        a = (e)m.a(e1, "Argument must not be null");
    }

    private void c()
    {
label0:
        {
            if (a.a.a.g.c != 1)
            {
                if (c)
                {
                    break label0;
                }
                c = true;
                i l = a.a;
                if (l.h)
                {
                    throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
                }
                boolean flag = l.c.isEmpty();
                if (l.c.contains(this))
                {
                    throw new IllegalStateException("Cannot subscribe twice in a row");
                }
                l.c.add(this);
                if (flag && !l.e)
                {
                    l.e = true;
                    l.h = false;
                    l.b();
                }
            }
            invalidateSelf();
        }
    }

    private void d()
    {
        c = false;
        i l = a.a;
        l.c.remove(this);
        if (l.c.isEmpty())
        {
            l.e = false;
        }
    }

    private Rect e()
    {
        if (j == null)
        {
            j = new Rect();
        }
        return j;
    }

    private Paint f()
    {
        if (i == null)
        {
            i = new Paint(2);
        }
        return i;
    }

    public final ByteBuffer a()
    {
        return a.a.a.a.asReadOnlyBuffer();
    }

    public final void b()
    {
        if (android.os.Build.VERSION.SDK_INT >= 11 && getCallback() == null)
        {
            stop();
            invalidateSelf();
        } else
        {
            invalidateSelf();
            i l = a.a;
            int i1;
            if (l.g != null)
            {
                i1 = l.g.a;
            } else
            {
                i1 = -1;
            }
            if (i1 == a.a.a.g.c - 1)
            {
                f = f + 1;
            }
            if (g != -1 && f >= g)
            {
                stop();
                return;
            }
        }
    }

    public void draw(Canvas canvas)
    {
        if (b)
        {
            return;
        }
        if (h)
        {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), e());
            h = false;
        }
        canvas.drawBitmap(a.a.a(), null, e(), f());
    }

    public android.graphics.drawable.Drawable.ConstantState getConstantState()
    {
        return a;
    }

    public int getIntrinsicHeight()
    {
        return a.a.a().getHeight();
    }

    public int getIntrinsicWidth()
    {
        return a.a.a().getWidth();
    }

    public int getOpacity()
    {
        return -2;
    }

    public boolean isRunning()
    {
        return c;
    }

    protected void onBoundsChange(Rect rect)
    {
        super.onBoundsChange(rect);
        h = true;
    }

    public void setAlpha(int l)
    {
        f().setAlpha(l);
    }

    public void setColorFilter(ColorFilter colorfilter)
    {
        f().setColorFilter(colorfilter);
    }

    public boolean setVisible(boolean flag, boolean flag1)
    {
        e = flag;
        if (flag) goto _L2; else goto _L1
_L1:
        d();
_L4:
        return super.setVisible(flag, flag1);
_L2:
        if (d)
        {
            c();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void start()
    {
        d = true;
        f = 0;
        if (e)
        {
            c();
        }
    }

    public void stop()
    {
        d = false;
        d();
    }
}
