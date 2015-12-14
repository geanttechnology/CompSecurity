// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.dialogs;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.cyberlink.youcammakeup.a;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.dialogs:
//            y, w

public class v extends a
{

    private String a;
    private String b;
    private String c;
    private Boolean d;
    private Boolean e;
    private Boolean f;
    private Boolean g;
    private Boolean h;
    private int i;
    private View j;
    private View k;
    private View l;
    private TextView m;
    private View n;
    private View o;
    private Button p;
    private Button q;
    private CheckBox r;
    private w s;

    public v()
    {
        a = "";
        b = "";
        c = "";
        d = Boolean.valueOf(true);
        e = Boolean.valueOf(true);
        f = Boolean.valueOf(true);
        g = Boolean.valueOf(true);
        h = Boolean.valueOf(false);
        i = 8;
    }

    static w a(v v1)
    {
        return v1.s;
    }

    static Boolean a(v v1, Boolean boolean1)
    {
        v1.h = boolean1;
        return boolean1;
    }

    static CheckBox b(v v1)
    {
        return v1.r;
    }

    public void a(int i1)
    {
        i = i1;
        if (r != null)
        {
            r.setVisibility(i1);
        }
    }

    public void a(Drawable drawable, String s1)
    {
        a = s1;
    }

    public void a(w w)
    {
        if (w != null)
        {
            s = w;
        }
    }

    public void a(y y1)
    {
        if (y1 != null)
        {
            d = Boolean.valueOf(y1.a);
            b = y1.e;
            f = Boolean.valueOf(y1.c);
            e = Boolean.valueOf(y1.b);
            c = y1.f;
            g = Boolean.valueOf(y1.d);
            h = Boolean.valueOf(y1.g);
        }
    }

    public void a(boolean flag)
    {
        h = Boolean.valueOf(flag);
        if (r != null)
        {
            r.setChecked(flag);
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        l = layoutinflater.inflate(0x7f030155, viewgroup, false);
        m = (TextView)l.findViewById(0x7f0c056d);
        p = (Button)l.findViewById(0x7f0c056f);
        q = (Button)l.findViewById(0x7f0c056e);
        j = l.findViewById(0x7f0c061c);
        k = l.findViewById(0x7f0c061e);
        n = l.findViewById(0x7f0c061d);
        o = l.findViewById(0x7f0c061f);
        r = (CheckBox)l.findViewById(0x7f0c061b);
        setCancelable(false);
        return l;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        p.setOnClickListener(null);
        q.setOnClickListener(null);
        l = null;
        m = null;
        p = null;
        q = null;
        s = null;
    }

    public void onStart()
    {
        super.onStart();
        if (a != null && !a.equals(""))
        {
            m.setVisibility(0);
            m.setText(a);
        } else
        {
            m.setVisibility(4);
        }
        if (p != null && n != null)
        {
            if (d.booleanValue())
            {
                n.setVisibility(0);
            } else
            {
                n.setVisibility(8);
            }
            p.setEnabled(f.booleanValue());
            p.setText(b);
        }
        if (q != null && o != null)
        {
            if (e.booleanValue())
            {
                o.setVisibility(0);
            } else
            {
                o.setVisibility(8);
            }
            q.setEnabled(g.booleanValue());
            q.setText(c);
        }
        if (j != null && k != null)
        {
            if (e.booleanValue())
            {
                j.setVisibility(8);
                k.setVisibility(0);
            } else
            {
                j.setVisibility(0);
                k.setVisibility(8);
            }
        }
        p.setOnClickListener(new android.view.View.OnClickListener() {

            final v a;

            public void onClick(View view)
            {
                if (com.cyberlink.youcammakeup.widgetpool.dialogs.v.a(a) != null)
                {
                    boolean flag = v.b(a).isChecked();
                    com.cyberlink.youcammakeup.widgetpool.dialogs.v.a(a).a(flag);
                }
            }

            
            {
                a = v.this;
                super();
            }
        });
        q.setOnClickListener(new android.view.View.OnClickListener() {

            final v a;

            public void onClick(View view)
            {
                if (com.cyberlink.youcammakeup.widgetpool.dialogs.v.a(a) != null)
                {
                    boolean flag = v.b(a).isChecked();
                    com.cyberlink.youcammakeup.widgetpool.dialogs.v.a(a).b(flag);
                }
            }

            
            {
                a = v.this;
                super();
            }
        });
        r.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final v a;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                com.cyberlink.youcammakeup.widgetpool.dialogs.v.a(a, Boolean.valueOf(flag));
            }

            
            {
                a = v.this;
                super();
            }
        });
        a(i);
        a(h.booleanValue());
    }
}
