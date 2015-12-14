// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.common.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.ag;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.at;

public class f extends FrameLayout
    implements Checkable
{

    private static int j = 80;
    private static int k = 230;
    protected View a;
    protected View b;
    protected View c;
    protected View d;
    protected TextView e;
    protected View f;
    protected View g;
    private ImageView h;
    private at i;

    public f(Context context, BeautyMode beautymode)
    {
        super(context);
        i = null;
        a(context, beautymode);
    }

    private void setBackgroundV16Minus(Drawable drawable)
    {
        if (c != null)
        {
            c.setBackgroundDrawable(drawable);
        }
    }

    private void setBackgroundV16Plus(Drawable drawable)
    {
        if (c != null)
        {
            c.setBackground(drawable);
        }
    }

    protected int a(BeautyMode beautymode)
    {
        class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[BeautyMode.values().length];
                try
                {
                    a[BeautyMode.k.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    a[BeautyMode.x.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    a[BeautyMode.n.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    a[BeautyMode.r.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    a[BeautyMode.l.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[BeautyMode.m.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[BeautyMode.b.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[BeautyMode.y.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[BeautyMode.a.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1.a[beautymode.ordinal()])
        {
        default:
            return 0x7f0300f7;

        case 1: // '\001'
        case 2: // '\002'
            return 0x7f0300ff;

        case 3: // '\003'
            return 0x7f0300fc;

        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
            return 0x7f0300fa;

        case 8: // '\b'
            return 0x7f0300fd;

        case 9: // '\t'
            return 0x7f0300f9;
        }
    }

    protected void a(Context context, BeautyMode beautymode)
    {
        b = (ViewGroup)((LayoutInflater)context.getSystemService("layout_inflater")).inflate(a(beautymode), this);
        if (isInEditMode())
        {
            return;
        }
        c = b.findViewById(0x7f0c054a);
        a = b.findViewById(0x7f0c0549);
        h = (ImageView)b.findViewById(0x7f0c0550);
        d = b.findViewById(0x7f0c054e);
        e = (TextView)b.findViewById(0x7f0c054d);
        if (StatusManager.j().s() == BeautyMode.b)
        {
            e.setTextColor(0xff000000);
        }
        f = b.findViewById(0x7f0c0551);
        g = b.findViewById(0x7f0c054f);
    }

    public void a(ag ag1, String s)
    {
        if (h != null)
        {
            h.setImageBitmap(null);
            ag1.a(s, h);
        }
    }

    public void a(boolean flag)
    {
        if (d != null)
        {
            View view = d;
            int l;
            if (flag)
            {
                l = 0;
            } else
            {
                l = 8;
            }
            view.setVisibility(l);
        }
    }

    public void b(boolean flag)
    {
        byte byte0 = 8;
        if (f != null && g != null)
        {
            View view = f;
            int l;
            if (flag)
            {
                l = 0;
            } else
            {
                l = 8;
            }
            view.setVisibility(l);
            view = g;
            if (flag)
            {
                l = 8;
            } else
            {
                l = 0;
            }
            view.setVisibility(l);
            if (c != null)
            {
                View view1 = c;
                if (flag)
                {
                    l = byte0;
                } else
                {
                    l = 0;
                }
                view1.setVisibility(l);
            }
        }
    }

    public at getColor()
    {
        return i;
    }

    public boolean isChecked()
    {
        return isSelected();
    }

    public void setChecked(boolean flag)
    {
        setSelected(flag);
    }

    public void setColor(at at1)
    {
        BeautyMode beautymode;
label0:
        {
            i = at1;
            setTextColorByShadeColor(at1);
            beautymode = StatusManager.j().s();
            if (a != null && at1 != null)
            {
                if (beautymode != BeautyMode.k)
                {
                    break label0;
                }
                a.setBackgroundColor(Color.argb(204, at1.a().intValue(), at1.b().intValue(), at1.c().intValue()));
            }
            return;
        }
        if (beautymode == BeautyMode.a)
        {
            a.setBackgroundColor(Color.rgb(at1.a().intValue(), at1.b().intValue(), at1.c().intValue()));
            return;
        }
        if (beautymode == BeautyMode.r || beautymode == BeautyMode.l || beautymode == BeautyMode.m || beautymode == BeautyMode.b)
        {
            a.setBackgroundColor(Color.rgb(at1.a().intValue(), at1.b().intValue(), at1.c().intValue()));
            return;
        } else
        {
            a.setBackgroundColor(Color.rgb(at1.a().intValue(), at1.b().intValue(), at1.c().intValue()));
            return;
        }
    }

    public void setColorNumber(String s)
    {
        if (e != null)
        {
            e.setText(s);
        }
    }

    public void setImage(Bitmap bitmap)
    {
        setImage(((Drawable) (new BitmapDrawable(Globals.d().getResources(), bitmap))));
    }

    public void setImage(Drawable drawable)
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            setBackgroundV16Plus(drawable);
            return;
        } else
        {
            setBackgroundV16Minus(drawable);
            return;
        }
    }

    public void setTextColorByShadeColor(at at1)
    {
        BeautyMode beautymode = StatusManager.j().s();
        if (e != null)
        {
            int l;
            if (beautymode == BeautyMode.b)
            {
                if (at1 != null && at1.a().intValue() <= j && at1.b().intValue() <= j && at1.c().intValue() <= j)
                {
                    l = Color.rgb(200, 200, 200);
                } else
                {
                    l = 0xff000000;
                }
            } else
            if (at1 != null && at1.a().intValue() >= k && at1.b().intValue() >= k && at1.c().intValue() >= k)
            {
                l = Color.rgb(138, 138, 138);
            } else
            {
                l = -1;
            }
            e.setTextColor(l);
        }
    }

    public void toggle()
    {
        boolean flag;
        if (!isSelected())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setSelected(flag);
    }

}
