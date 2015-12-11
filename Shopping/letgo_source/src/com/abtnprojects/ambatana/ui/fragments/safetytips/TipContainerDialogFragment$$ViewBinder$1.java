// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.fragments.safetytips;

import android.view.View;
import butterknife.internal.DebouncingOnClickListener;

// Referenced classes of package com.abtnprojects.ambatana.ui.fragments.safetytips:
//            TipContainerDialogFragment

class a extends DebouncingOnClickListener
{

    final TipContainerDialogFragment a;
    final a b;

    public void doClick(View view)
    {
        a.onPrevTap(view);
    }

    ( , TipContainerDialogFragment tipcontainerdialogfragment)
    {
        b = ;
        a = tipcontainerdialogfragment;
        super();
    }
}
