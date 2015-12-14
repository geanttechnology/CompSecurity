// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

public class api
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

    public api(Context context)
    {
        i = null;
        a = context;
    }

    static android.content.DialogInterface.OnClickListener a(api api1)
    {
        return api1.j;
    }

    static android.content.DialogInterface.OnClickListener b(api api1)
    {
        return api1.k;
    }

    static android.widget.CompoundButton.OnCheckedChangeListener c(api api1)
    {
        return api1.l;
    }

    public aph a()
    {
        Object obj;
        obj = (LayoutInflater)a.getSystemService("layout_inflater");
        aph aph1 = new aph(a, 0x7f0a0083);
        obj = ((LayoutInflater) (obj)).inflate(0x7f030051, null);
        aph1.addContentView(((View) (obj)), new android.view.ViewGroup.LayoutParams(-1, -2));
        if (b != null)
        {
            ((TextView)((View) (obj)).findViewById(0x7f0d0034)).setText(b);
        } else
        {
            ((View) (obj)).findViewById(0x7f0d01d7).setVisibility(8);
        }
        if (d != null)
        {
            ((TextView)((View) (obj)).findViewById(0x7f0d01db)).setText(d);
            if (j != null)
            {
                ((TextView)((View) (obj)).findViewById(0x7f0d01db)).setOnClickListener(new apj(this, aph1));
            }
        } else
        {
            ((View) (obj)).findViewById(0x7f0d01db).setVisibility(8);
        }
        if (e != null)
        {
            ((TextView)((View) (obj)).findViewById(0x7f0d01dc)).setText(e);
            if (k != null)
            {
                ((TextView)((View) (obj)).findViewById(0x7f0d01dc)).setOnClickListener(new apk(this, aph1));
            }
        } else
        {
            ((View) (obj)).findViewById(0x7f0d01dc).setVisibility(8);
        }
        if (h)
        {
            i = (CheckBox)((View) (obj)).findViewById(0x7f0d01da);
            if (l != null)
            {
                i.setOnCheckedChangeListener(new apl(this));
            }
        } else
        {
            ((View) (obj)).findViewById(0x7f0d01d9).setVisibility(8);
        }
        if (c == null) goto _L2; else goto _L1
_L1:
        ((TextView)((View) (obj)).findViewById(0x7f0d01d8)).setText(c);
_L4:
        aph1.setContentView(((View) (obj)));
        return aph1;
_L2:
        if (f != null)
        {
            ((LinearLayout)((View) (obj)).findViewById(0x7f0d01b4)).removeAllViews();
            ((LinearLayout)((View) (obj)).findViewById(0x7f0d01b4)).addView(f, new android.view.ViewGroup.LayoutParams(-2, -2));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public api a(String s)
    {
        c = s;
        return this;
    }

    public api a(String s, android.content.DialogInterface.OnClickListener onclicklistener)
    {
        d = s;
        j = onclicklistener;
        return this;
    }

    public api a(String s, android.widget.CompoundButton.OnCheckedChangeListener oncheckedchangelistener)
    {
        g = s;
        l = oncheckedchangelistener;
        return this;
    }

    public api a(boolean flag)
    {
        h = flag;
        return this;
    }

    public api b(String s)
    {
        b = s;
        return this;
    }

    public api b(String s, android.content.DialogInterface.OnClickListener onclicklistener)
    {
        e = s;
        k = onclicklistener;
        return this;
    }
}
