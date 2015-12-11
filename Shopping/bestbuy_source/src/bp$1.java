// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.widget.LinearLayout;
import java.util.HashMap;

class lang.Object
    implements android.view.OnClickListener
{

    final bp a;

    public void onClick(View view)
    {
        view = new HashMap();
        view.put("bb.prevPageLink", lu.aV);
        view.put("bb.callBB", "1");
        lu.b(lu.aW, view);
        if (a.c())
        {
            a.a();
            return;
        } else
        {
            bp.a(a).setEnabled(false);
            return;
        }
    }

    >(bp bp1)
    {
        a = bp1;
        super();
    }
}
