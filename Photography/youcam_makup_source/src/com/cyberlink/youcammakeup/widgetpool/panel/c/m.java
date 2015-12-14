// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.cyberlink.youcammakeup.utility.at;
import java.util.List;

public class m extends FrameLayout
    implements Checkable
{

    private final int a;
    private List b;
    private ImageView c;
    private ImageView d;
    private ImageView e;
    private View f;
    private boolean g;

    public m(Context context, int i)
    {
        super(context);
        g = false;
        a = i;
        context = LayoutInflater.from(context);
        if (a())
        {
            context.inflate(0x7f0301f2, this);
            return;
        }
        if (i != 1) goto _L2; else goto _L1
_L1:
        context.inflate(0x7f0301f3, this);
_L4:
        b();
        return;
_L2:
        if (i == 2)
        {
            context.inflate(0x7f0301f5, this);
        } else
        if (i == 3 || i == 4)
        {
            context.inflate(0x7f0301f4, this);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void b()
    {
        c = (ImageView)findViewById(0x7f0c089a);
        d = (ImageView)findViewById(0x7f0c089d);
        e = (ImageView)findViewById(0x7f0c089e);
        f = (ImageView)findViewById(0x7f0c089b);
    }

    public void a(boolean flag)
    {
        if (f == null)
        {
            return;
        }
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        f.setVisibility(i);
    }

    public boolean a()
    {
        return a < 1 || a > 4;
    }

    public List getColors()
    {
        return b;
    }

    public boolean isChecked()
    {
        return isSelected();
    }

    public void setChecked(boolean flag)
    {
        setSelected(flag);
    }

    public void setColors(List list)
    {
label0:
        {
            b = list;
            int j = list.size();
            int i;
            if (a == 2)
            {
                i = 0x7f0202d9;
            } else
            {
                i = 0x7f0202db;
            }
            if (j >= 3 && e != null)
            {
                at at1 = (at)list.get(2);
                e.setBackgroundColor(at1.e() | 0xff000000);
                if (at1.k())
                {
                    e.setImageResource(i);
                } else
                {
                    e.setImageResource(0x7f0202da);
                }
            }
            if (j >= 2 && d != null)
            {
                at1 = (at)list.get(1);
                d.setBackgroundColor(at1.e() | 0xff000000);
                if (at1.k())
                {
                    d.setImageResource(i);
                } else
                {
                    d.setImageResource(0x7f0202d8);
                }
            }
            if (j >= 1 && c != null)
            {
                list = (at)list.get(0);
                c.setBackgroundColor(list.e() | 0xff000000);
                if (!list.k())
                {
                    break label0;
                }
                c.setImageResource(i);
            }
            return;
        }
        c.setImageResource(0x7f0202d8);
    }

    public void setShimmer(boolean flag)
    {
        if (g != flag)
        {
            g = flag;
            if (!a())
            {
                int i;
                if (flag)
                {
                    if (a == 2)
                    {
                        i = 0x7f0202d9;
                    } else
                    {
                        i = 0x7f0202db;
                    }
                } else
                if (a == 2)
                {
                    i = 0x7f0202d8;
                } else
                {
                    i = 0x7f0202da;
                }
                if (e != null)
                {
                    e.setImageResource(i);
                }
                if (d != null)
                {
                    d.setImageResource(i);
                }
                if (c != null)
                {
                    c.setImageResource(i);
                    return;
                }
            }
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
