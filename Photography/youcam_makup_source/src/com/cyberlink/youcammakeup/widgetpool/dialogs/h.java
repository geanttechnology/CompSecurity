// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.dialogs;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cyberlink.youcammakeup.a;
import com.cyberlink.youcammakeup.utility.bd;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.dialogs:
//            i

public class h extends a
{

    boolean a;
    boolean b;
    private View c;
    private View d;
    private View e;
    private i f;

    public h()
    {
        a = false;
        b = false;
    }

    static i a(h h1)
    {
        return h1.f;
    }

    public void a(i i)
    {
        f = i;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        e = c.findViewById(0x7f0c0591);
        d = c.findViewById(0x7f0c0590);
        e.setOnClickListener(new android.view.View.OnClickListener() {

            final h a;

            public void onClick(View view)
            {
                a.b = false;
                a.dismiss();
            }

            
            {
                a = h.this;
                super();
            }
        });
        d.setSelected(true);
        d.setOnClickListener(new android.view.View.OnClickListener() {

            final h a;

            public void onClick(View view)
            {
                a.b = true;
                a.dismiss();
                bd.a(a.getActivity(), "com.cyberlink.youperfect", "ymk", "downloadycpdialog");
            }

            
            {
                a = h.this;
                super();
            }
        });
        a(new android.content.DialogInterface.OnDismissListener() {

            final h a;

            public void onDismiss(DialogInterface dialoginterface)
            {
                if (!a.a)
                {
                    a.a = true;
                    if (com.cyberlink.youcammakeup.widgetpool.dialogs.h.a(a) != null)
                    {
                        com.cyberlink.youcammakeup.widgetpool.dialogs.h.a(a).a(a.b);
                    }
                }
            }

            
            {
                a = h.this;
                super();
            }
        });
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        c = layoutinflater.inflate(0x7f03018b, viewgroup);
        return c;
    }
}
