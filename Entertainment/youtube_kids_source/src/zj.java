// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.apps.youtube.kids.ui.InterstitialLayout;
import com.google.android.apps.youtube.kids.ui.ScrollingSectionListGridView;
import java.util.HashMap;
import java.util.Map;

public abstract class zj extends xn
    implements bxe
{

    InterstitialLayout h;
    public bov i;
    public ScrollingSectionListGridView j;
    private FrameLayout k;
    private View l;
    private Handler m;

    public zj()
    {
    }

    static View a(zj zj1)
    {
        return zj1.l;
    }

    public final void a(int i1, boolean flag)
    {
        k();
        InterstitialLayout interstitiallayout = h;
        View view = interstitiallayout.a(interstitiallayout.c);
        interstitiallayout.a(i1, view, 0x7f100138);
        Button button = (Button)view.findViewById(0x7f100139);
        button.setOnClickListener(new afm(interstitiallayout));
        button.setVisibility(0);
        interstitiallayout.a(view);
    }

    public final void a(afv afv)
    {
        ScrollingSectionListGridView scrollingsectionlistgridview = j;
        blu blu = d().c();
        HashMap hashmap = new HashMap();
        hashmap.put(eda, new zz());
        hashmap.put(dfu, new wf());
        scrollingsectionlistgridview.a(blu, new aco(hashmap, this, c().F()), afv, getResources().getInteger(0x7f0e000a), i, this);
    }

    public final void a(btk btk, boolean flag)
    {
        j.d.a(btk, flag);
    }

    public final void a(byb byb)
    {
        h.d = byb;
    }

    public final blu j()
    {
        return d().c();
    }

    void k()
    {
        k.setVisibility(8);
        h.setVisibility(0);
    }

    public final void l()
    {
        k();
        InterstitialLayout interstitiallayout = h;
        interstitiallayout.a(interstitiallayout.a(interstitiallayout.a));
    }

    public final void m()
    {
        h.setVisibility(8);
        k.setVisibility(0);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        i = c().N();
        h = (InterstitialLayout)findViewById(0x7f1000b3);
        k = (FrameLayout)findViewById(0x7f1000b4);
        l = findViewById(0x7f1000ba);
        m = new Handler();
    }

    protected void onRestart()
    {
        super.onRestart();
        if (j.d.a() > 0)
        {
            boolean flag;
            if (android.os.Build.VERSION.SDK_INT == 20 || android.os.Build.VERSION.SDK_INT == 21)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                l.setVisibility(0);
                m.postDelayed(new zk(this), 100L);
            }
        }
    }
}
