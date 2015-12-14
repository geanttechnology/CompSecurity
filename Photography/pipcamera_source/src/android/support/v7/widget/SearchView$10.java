// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.view.View;

// Referenced classes of package android.support.v7.widget:
//            SearchView

class a
    implements android.view.stener
{

    final SearchView a;

    public void onClick(View view)
    {
        if (view != SearchView.access$400(a)) goto _L2; else goto _L1
_L1:
        SearchView.access$500(a);
_L4:
        return;
_L2:
        if (view == SearchView.access$600(a))
        {
            SearchView.access$700(a);
            return;
        }
        if (view == SearchView.access$800(a))
        {
            SearchView.access$900(a);
            return;
        }
        if (view != SearchView.access$1000(a))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!SearchView.access$1100()) goto _L4; else goto _L3
_L3:
        SearchView.access$1200(a);
        return;
        if (view != SearchView.access$1300(a)) goto _L4; else goto _L5
_L5:
        SearchView.access$1400(a);
        return;
    }

    (SearchView searchview)
    {
        a = searchview;
        super();
    }
}
