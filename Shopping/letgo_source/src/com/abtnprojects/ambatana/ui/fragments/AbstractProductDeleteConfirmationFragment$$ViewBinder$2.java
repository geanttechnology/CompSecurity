// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.fragments;

import android.view.View;
import butterknife.internal.DebouncingOnClickListener;

// Referenced classes of package com.abtnprojects.ambatana.ui.fragments:
//            AbstractProductDeleteConfirmationFragment

class a extends DebouncingOnClickListener
{

    final AbstractProductDeleteConfirmationFragment a;
    final d b;

    public void doClick(View view)
    {
        a.onCancelClicked();
    }

    ( , AbstractProductDeleteConfirmationFragment abstractproductdeleteconfirmationfragment)
    {
        b = ;
        a = abstractproductdeleteconfirmationfragment;
        super();
    }
}
