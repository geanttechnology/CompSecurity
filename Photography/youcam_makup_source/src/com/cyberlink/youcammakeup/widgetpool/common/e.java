// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.cyberlink.youcammakeup.kernelctrl.ag;
import com.cyberlink.youcammakeup.widgetpool.panel.c.u;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.common:
//            f, j, h, g, 
//            i

public class e extends FrameLayout
    implements Checkable
{

    private final String a = "CameraEffectGridItem";
    private ImageView b;
    private View c;
    private View d;
    private View e;
    private TextView f;
    private View g;
    private View h;
    private View i;
    private View j;
    private View k;
    private ProgressBar l;
    private f m;
    private android.view.View.OnClickListener n;
    private View o;

    public e(Context context, android.view.View.OnClickListener onclicklistener)
    {
        super(context);
        context = LayoutInflater.from(context).inflate(0x7f0300e8, this);
        n = onclicklistener;
        a(context);
    }

    static View a(e e1)
    {
        return e1.k;
    }

    private void a(View view)
    {
        g = view.findViewById(0x7f0c051f);
        h = view.findViewById(0x7f0c051b);
        b = (ImageView)view.findViewById(0x7f0c0520);
        b.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
        c = view.findViewById(0x7f0c0528);
        d = view.findViewById(0x7f0c0521);
        e = view.findViewById(0x7f0c051e);
        f = (TextView)view.findViewById(0x7f0c0527);
        i = view.findViewById(0x7f0c0522);
        j = view.findViewById(0x7f0c0526);
        k = view.findViewById(0x7f0c0523);
        l = (ProgressBar)view.findViewById(0x7f0c0524);
        o = view.findViewById(0x7f0c0525);
        i.setOnClickListener(new android.view.View.OnClickListener() {

            final e a;

            public void onClick(View view1)
            {
                if (!e.d(a).isEnabled())
                {
                    return;
                } else
                {
                    a.c(false);
                    e.e(a).onClick(a);
                    return;
                }
            }

            
            {
                a = e.this;
                super();
            }
        });
    }

    static View b(e e1)
    {
        return e1.j;
    }

    static View c(e e1)
    {
        return e1.o;
    }

    static View d(e e1)
    {
        return e1.i;
    }

    static android.view.View.OnClickListener e(e e1)
    {
        return e1.n;
    }

    public void a()
    {
        m = m.a();
    }

    public void a(ag ag, u u1)
    {
        if (b != null)
        {
            u1.a(ag, b);
        }
    }

    public void a(boolean flag)
    {
        int i1;
        if (flag)
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        d.setVisibility(i1);
    }

    public void a(boolean flag, boolean flag1)
    {
        if (!flag)
        {
            m = new j(this);
            return;
        }
        if (flag1)
        {
            m = new h(this);
            return;
        } else
        {
            m = new g(this);
            return;
        }
    }

    public void b(boolean flag)
    {
        int i1;
        if (flag)
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        if (e != null)
        {
            e.setVisibility(i1);
        }
    }

    public boolean b()
    {
        return m instanceof i;
    }

    public void c(boolean flag)
    {
        int i1;
        if (flag)
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        i.setVisibility(i1);
    }

    public boolean getCurViewStateDownloadable()
    {
        return !(m instanceof h);
    }

    public int getImageHeight()
    {
        return ((android.widget.FrameLayout.LayoutParams)b.getLayoutParams()).height;
    }

    public int getImageWidth()
    {
        return ((android.widget.FrameLayout.LayoutParams)b.getLayoutParams()).width;
    }

    public boolean isChecked()
    {
        return isSelected();
    }

    public void setChecked(boolean flag)
    {
        setSelected(flag);
    }

    public void setMoreBtnView(boolean flag)
    {
        if (flag)
        {
            h.setVisibility(0);
            g.setVisibility(8);
            return;
        } else
        {
            h.setVisibility(8);
            g.setVisibility(0);
            return;
        }
    }

    public void setName(CharSequence charsequence)
    {
        f.setText(charsequence);
    }

    public void setProgress(int i1)
    {
        while (!b() || i1 < 0 || i1 > 100) 
        {
            return;
        }
        if (k.getVisibility() != 0)
        {
            k.setVisibility(0);
        }
        l.setProgress(i1);
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
