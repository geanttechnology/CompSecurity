// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;

// Referenced classes of package com.abtnprojects.ambatana.ui.fragments:
//            AbstractProductDeleteConfirmationFragment

public class ProductDeleteOrSoldConfirmationFragment extends AbstractProductDeleteConfirmationFragment
{

    public ProductDeleteOrSoldConfirmationFragment()
    {
    }

    public View a(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f040062, viewgroup, false);
    }

    public void a(Bundle bundle)
    {
        super.a(bundle);
        a(1, 0);
    }

    public void a(View view, Bundle bundle)
    {
        super.a(view, bundle);
        ButterKnife.bind(this, view);
    }

    void onSoldClicked()
    {
        a();
        if (aj != null)
        {
            aj.d("product-delete");
        }
    }
}
