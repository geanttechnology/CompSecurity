// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ka
{

    private Context a;
    private String b;
    private String c;
    private String d;
    private String e;
    private View f;
    private String g;
    private boolean h;
    private CheckBox i;
    private android.content.DialogInterface.OnClickListener j;
    private android.content.DialogInterface.OnClickListener k;
    private android.widget.CompoundButton.OnCheckedChangeListener l;

    public ka(Context context)
    {
        i = null;
        a = context;
    }

    static android.content.DialogInterface.OnClickListener a(ka ka1)
    {
        return ka1.j;
    }

    static android.content.DialogInterface.OnClickListener b(ka ka1)
    {
        return ka1.k;
    }

    static android.widget.CompoundButton.OnCheckedChangeListener c(ka ka1)
    {
        return ka1.l;
    }

    public jz a()
    {
        Object obj;
        obj = (LayoutInflater)a.getSystemService("layout_inflater");
        jz jz1 = new jz(a, 0x7f0a0081);
        obj = ((LayoutInflater) (obj)).inflate(0x7f030037, null);
        jz1.addContentView(((View) (obj)), new android.view.ViewGroup.LayoutParams(-1, -2));
        if (b != null)
        {
            ((TextView)((View) (obj)).findViewById(0x7f0c002d)).setText(b);
        } else
        {
            ((View) (obj)).findViewById(0x7f0c0111).setVisibility(8);
        }
        if (d != null)
        {
            ((TextView)((View) (obj)).findViewById(0x7f0c0116)).setText(d);
            if (j != null)
            {
                ((TextView)((View) (obj)).findViewById(0x7f0c0116)).setOnClickListener(new android.view.View.OnClickListener(jz1) {

                    final jz a;
                    final ka b;

                    public void onClick(View view)
                    {
                        ka.a(b).onClick(a, -1);
                        a.hide();
                    }

            
            {
                b = ka.this;
                a = jz1;
                super();
            }
                });
            }
        } else
        {
            ((View) (obj)).findViewById(0x7f0c0116).setVisibility(8);
        }
        if (e != null)
        {
            ((TextView)((View) (obj)).findViewById(0x7f0c0117)).setText(e);
            if (k != null)
            {
                ((TextView)((View) (obj)).findViewById(0x7f0c0117)).setOnClickListener(new android.view.View.OnClickListener(jz1) {

                    final jz a;
                    final ka b;

                    public void onClick(View view)
                    {
                        ka.b(b).onClick(a, -2);
                        a.hide();
                    }

            
            {
                b = ka.this;
                a = jz1;
                super();
            }
                });
            }
        } else
        {
            ((View) (obj)).findViewById(0x7f0c0117).setVisibility(8);
        }
        if (h)
        {
            i = (CheckBox)((View) (obj)).findViewById(0x7f0c0115);
            if (l != null)
            {
                i.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

                    final ka a;

                    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
                    {
                        ka.c(a).onCheckedChanged(compoundbutton, flag);
                    }

            
            {
                a = ka.this;
                super();
            }
                });
            }
        } else
        {
            ((View) (obj)).findViewById(0x7f0c0114).setVisibility(8);
        }
        if (c == null) goto _L2; else goto _L1
_L1:
        ((TextView)((View) (obj)).findViewById(0x7f0c0113)).setText(c);
_L4:
        jz1.setContentView(((View) (obj)));
        return jz1;
_L2:
        if (f != null)
        {
            ((LinearLayout)((View) (obj)).findViewById(0x7f0c0112)).removeAllViews();
            ((LinearLayout)((View) (obj)).findViewById(0x7f0c0112)).addView(f, new android.view.ViewGroup.LayoutParams(-2, -2));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public ka a(String s)
    {
        c = s;
        return this;
    }

    public ka a(String s, android.content.DialogInterface.OnClickListener onclicklistener)
    {
        d = s;
        j = onclicklistener;
        return this;
    }

    public ka a(String s, android.widget.CompoundButton.OnCheckedChangeListener oncheckedchangelistener)
    {
        g = s;
        l = oncheckedchangelistener;
        return this;
    }

    public ka a(boolean flag)
    {
        h = flag;
        return this;
    }

    public ka b(String s)
    {
        b = s;
        return this;
    }

    public ka b(String s, android.content.DialogInterface.OnClickListener onclicklistener)
    {
        e = s;
        k = onclicklistener;
        return this;
    }
}
