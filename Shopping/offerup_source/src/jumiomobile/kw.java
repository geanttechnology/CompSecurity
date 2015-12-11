// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

// Referenced classes of package jumiomobile:
//            kv, kt, gs, mf, 
//            mk

class kw
    implements android.view.View.OnClickListener
{

    final kv a;

    kw(kv kv1)
    {
        a = kv1;
        super();
    }

    public void onClick(View view)
    {
        if (kt.b(a.a).J())
        {
            kt.c(a.a).findViewById(mf.at).setVisibility(0);
            kt.c(a.a).findViewById(mf.ap).setEnabled(false);
            kt.c(a.a).findViewById(mf.ao).setEnabled(false);
            kt.a(a.a, kt.c(a.a).findViewById(mf.ap), 400);
            kt.a(a.a, kt.c(a.a).findViewById(mf.ao), 400);
            ((TextView)kt.c(a.a).findViewById(mf.am)).setText(mk.a(a.a.getActivity(), "infobar_extraction_in_progress"));
            ((TextView)kt.c(a.a).findViewById(mf.am)).setGravity(19);
        }
        kt.b(a.a).C();
    }
}
