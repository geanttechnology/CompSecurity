// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.toolbar;

import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.MakeupMode;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.toolbar:
//            c, TopToolBar, b

public abstract class a extends c
{

    public a()
    {
    }

    private void j()
    {
        View view = getView();
        view.findViewById(a()).setOnClickListener(new android.view.View.OnClickListener() {

            final a a;

            public void onClick(View view1)
            {
                a.c();
            }

            
            {
                a = a.this;
                super();
            }
        });
        view.findViewById(b()).setOnClickListener(new android.view.View.OnClickListener() {

            final a a;

            public void onClick(View view1)
            {
                a.d();
            }

            
            {
                a = a.this;
                super();
            }
        });
    }

    private void k()
    {
        View view = getView();
        view.findViewById(a()).setOnClickListener(null);
        view.findViewById(b()).setOnClickListener(null);
    }

    protected abstract int a();

    protected abstract void a(b b1);

    protected abstract int b();

    protected abstract void b(b b1);

    protected void c()
    {
        a(new b() {

            final a a;

            public void a()
            {
                StatusManager.j().a(MakeupMode.g);
                a.e().a(Boolean.valueOf(false));
            }

            public void b()
            {
            }

            
            {
                a = a.this;
                super();
            }
        });
    }

    protected void d()
    {
        b(new b() {

            final a a;

            public void a()
            {
            }

            public void b()
            {
                StatusManager.j().a(MakeupMode.g);
                a.e().a(Boolean.valueOf(false));
            }

            
            {
                a = a.this;
                super();
            }
        });
    }

    protected TopToolBar e()
    {
        Object obj = getFragmentManager();
        if (obj != null)
        {
            obj = ((FragmentManager) (obj)).findFragmentById(0x7f0c00be);
            if (obj instanceof TopToolBar)
            {
                return (TopToolBar)obj;
            }
        }
        return null;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        j();
    }

    public void onDestroyView()
    {
        k();
        super.onDestroyView();
    }
}
