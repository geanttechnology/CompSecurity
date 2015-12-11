// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view;

import android.view.View;
import cdflynn.android.library.crossview.CrossView;

// Referenced classes of package com.target.ui.view:
//            AddActionView

private class rossView
{

    private final CrossView crossView;
    final AddActionView this$0;

    static CrossView a(rossView rossview)
    {
        return rossview.crossView;
    }

    rossView(View view)
    {
        this$0 = AddActionView.this;
        super();
        crossView = (CrossView)view.findViewById(0x7f1002f2);
    }
}
