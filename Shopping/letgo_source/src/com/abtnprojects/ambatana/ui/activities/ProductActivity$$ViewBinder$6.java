// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities;

import android.view.View;
import butterknife.internal.DebouncingOnClickListener;

// Referenced classes of package com.abtnprojects.ambatana.ui.activities:
//            ProductActivity

class a extends DebouncingOnClickListener
{

    final ProductActivity a;
    final ContainerClicked b;

    public void doClick(View view)
    {
        a.onProductOwnerContainerClicked();
    }

    ( , ProductActivity productactivity)
    {
        b = ;
        a = productactivity;
        super();
    }
}
