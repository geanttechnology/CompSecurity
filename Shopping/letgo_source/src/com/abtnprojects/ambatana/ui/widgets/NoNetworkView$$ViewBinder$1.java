// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.widgets;

import android.view.View;
import butterknife.internal.DebouncingOnClickListener;

// Referenced classes of package com.abtnprojects.ambatana.ui.widgets:
//            NoNetworkView

class a extends DebouncingOnClickListener
{

    final NoNetworkView a;
    final  b;

    public void doClick(View view)
    {
        a.onRetryPressed();
    }

    ( , NoNetworkView nonetworkview)
    {
        b = ;
        a = nonetworkview;
        super();
    }
}
