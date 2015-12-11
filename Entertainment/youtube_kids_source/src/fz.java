// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class fz extends Dialog
{

    private final ir a;
    private final ga b;
    private ip c;
    private ArrayList d;
    private gb e;
    private ListView f;
    private boolean g;

    public fz(Context context)
    {
        this(context, 0);
    }

    public fz(Context context, int i)
    {
        super(a.a(context, true), i);
        c = ip.c;
        a = ir.a(getContext());
        b = new ga(this);
    }

    public final void a()
    {
        if (!g) goto _L2; else goto _L1
_L1:
        ArrayList arraylist;
        int i;
        d.clear();
        arraylist = d;
        ir ir1 = a;
        arraylist.addAll(ir.a());
        arraylist = d;
        i = arraylist.size();
_L5:
        int j = i - 1;
        if (i <= 0) goto _L4; else goto _L3
_L3:
        if (!a((iz)arraylist.get(j)))
        {
            arraylist.remove(j);
            i = j;
        } else
        {
            i = j;
        }
        if (true) goto _L5; else goto _L4
_L4:
        Collections.sort(d, gc.a);
        e.notifyDataSetChanged();
_L2:
    }

    public final void a(ip ip1)
    {
        if (ip1 == null)
        {
            throw new IllegalArgumentException("selector must not be null");
        }
        if (!c.equals(ip1))
        {
            c = ip1;
            if (g)
            {
                a.a(b);
                a.a(ip1, b, 1);
            }
            a();
        }
    }

    public boolean a(iz iz1)
    {
        return !iz1.b() && iz1.e && iz1.a(c);
    }

    public void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        g = true;
        a.a(c, b, 1);
        a();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        getWindow().requestFeature(3);
        setContentView(0x7f040044);
        setTitle(0x7f0b0168);
        getWindow().setFeatureDrawableResource(3, a.a(getContext(), 0x7f01007c));
        d = new ArrayList();
        e = new gb(this, getContext(), d);
        f = (ListView)findViewById(0x7f10014e);
        f.setAdapter(e);
        f.setOnItemClickListener(e);
        f.setEmptyView(findViewById(0x1020004));
    }

    public void onDetachedFromWindow()
    {
        g = false;
        a.a(b);
        super.onDetachedFromWindow();
    }
}
