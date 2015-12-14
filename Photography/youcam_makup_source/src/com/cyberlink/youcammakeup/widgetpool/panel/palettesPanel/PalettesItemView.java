// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cyberlink.youcammakeup.widgetpool.common.p;
import com.cyberlink.youcammakeup.widgetpool.common.r;

public class PalettesItemView extends RelativeLayout
    implements Checkable
{

    android.view.View.OnClickListener a = new android.view.View.OnClickListener() {

        final PalettesItemView a;

        public void onClick(View view)
        {
            if (PalettesItemView.a(a) != null)
            {
                PalettesItemView.a(a).onClick(a);
            }
        }

            
            {
                a = PalettesItemView.this;
                super();
            }
    };
    android.view.View.OnLongClickListener b = new android.view.View.OnLongClickListener() {

        final PalettesItemView a;

        public boolean onLongClick(View view)
        {
            if (PalettesItemView.b(a) != null)
            {
                PalettesItemView.b(a).onLongClick(a);
            }
            return true;
        }

            
            {
                a = PalettesItemView.this;
                super();
            }
    };
    android.view.View.OnClickListener c = new android.view.View.OnClickListener() {

        final PalettesItemView a;

        public void onClick(View view)
        {
            if (PalettesItemView.c(a) != null)
            {
                view = (p)a.getTag();
                PalettesItemView.c(a).a(a, ((p) (view)).a, ((p) (view)).b);
            }
        }

            
            {
                a = PalettesItemView.this;
                super();
            }
    };
    private View d;
    private View e;
    private ImageView f;
    private ImageView g;
    private ImageView h;
    private ImageView i;
    private View j;
    private View k;
    private View l;
    private View m;
    private TextView n;
    private android.view.View.OnClickListener o;
    private android.view.View.OnLongClickListener p;
    private r q;
    private int r;

    public PalettesItemView(Context context, int i1)
    {
        super(context);
        r = -1;
        ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(i1, this);
        a(i1);
    }

    public PalettesItemView(Context context, AttributeSet attributeset, int i1)
    {
        this(context, 0);
    }

    static android.view.View.OnClickListener a(PalettesItemView palettesitemview)
    {
        return palettesitemview.o;
    }

    static android.view.View.OnLongClickListener b(PalettesItemView palettesitemview)
    {
        return palettesitemview.p;
    }

    static r c(PalettesItemView palettesitemview)
    {
        return palettesitemview.q;
    }

    private int d(boolean flag)
    {
        if (r != 0x7f0301fe) goto _L2; else goto _L1
_L1:
        if (!flag) goto _L4; else goto _L3
_L3:
        return 0x7f0202d9;
_L4:
        return 0x7f0202d8;
_L2:
        if (r == 0x7f0301fd)
        {
            return !flag ? 0x7f0202da : 0x7f0202db;
        }
        if (r == 0x7f0301f8)
        {
            return !flag ? 0x7f0202dc : 0x7f0202dd;
        }
        if (!flag)
        {
            return 0x7f0202d8;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    public void a(int i1)
    {
        r = i1;
        d = findViewById(0x7f0c0898);
        e = findViewById(0x7f0c0899);
        f = (ImageView)findViewById(0x7f0c089a);
        g = (ImageView)findViewById(0x7f0c089d);
        h = (ImageView)findViewById(0x7f0c089e);
        i = (ImageView)findViewById(0x7f0c08c7);
        l = findViewById(0x7f0c089c);
        m = findViewById(0x7f0c089b);
        j = findViewById(0x7f0c08c6);
        k = findViewById(0x7f0c08c8);
        n = (TextView)findViewById(0x7f0c08c9);
        d.setOnClickListener(a);
        d.setOnLongClickListener(b);
        k.setOnClickListener(c);
    }

    public void a(boolean flag)
    {
        if (flag)
        {
            j.setVisibility(0);
            e.setVisibility(4);
            return;
        } else
        {
            j.setVisibility(4);
            e.setVisibility(0);
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
        k.setVisibility(i1);
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
        m.setVisibility(i1);
    }

    public boolean isChecked()
    {
        return false;
    }

    public void setChecked(boolean flag)
    {
        setSelected(flag);
    }

    public void setColorFour(int i1)
    {
        if (i != null)
        {
            i.setBackgroundColor(i1);
        }
    }

    public void setColorIsShimmerFour(boolean flag)
    {
        if (i != null)
        {
            i.setImageResource(d(flag));
        }
    }

    public void setColorIsShimmerOne(boolean flag)
    {
        if (f != null)
        {
            f.setImageResource(d(flag));
        }
    }

    public void setColorIsShimmerThree(boolean flag)
    {
        if (h != null)
        {
            h.setImageResource(d(flag));
        }
    }

    public void setColorIsShimmerTwo(boolean flag)
    {
        if (g != null)
        {
            g.setImageResource(d(flag));
        }
    }

    public void setColorOne(int i1)
    {
        if (f != null)
        {
            f.setBackgroundColor(i1);
        }
    }

    public void setColorThree(int i1)
    {
        if (h != null)
        {
            h.setBackgroundColor(i1);
        }
    }

    public void setColorTwo(int i1)
    {
        if (g != null)
        {
            g.setBackgroundColor(i1);
        }
    }

    public void setEnabled(boolean flag)
    {
        super.setEnabled(flag);
        l.setEnabled(flag);
    }

    public void setName(String s)
    {
        if (n == null)
        {
            return;
        }
        android.widget.LinearLayout.LayoutParams layoutparams1 = (android.widget.LinearLayout.LayoutParams)n.getLayoutParams();
        android.widget.LinearLayout.LayoutParams layoutparams = layoutparams1;
        if (layoutparams1 == null)
        {
            layoutparams = new android.widget.LinearLayout.LayoutParams(0, 0);
        }
        if (s == null)
        {
            layoutparams.height = 0;
        } else
        {
            layoutparams.height = -2;
        }
        layoutparams.width = 0;
        n.setLayoutParams(layoutparams);
        n.setText(s);
    }

    public void setOnClickListener(android.view.View.OnClickListener onclicklistener)
    {
        o = onclicklistener;
        d.setOnClickListener(a);
    }

    public void setOnDeleteListener(r r1)
    {
        q = r1;
    }

    public void setOnLongClickListener(android.view.View.OnLongClickListener onlongclicklistener)
    {
        p = onlongclicklistener;
        d.setOnLongClickListener(b);
    }

    public void toggle()
    {
    }
}
