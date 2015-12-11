// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.registry.adapter;

import android.view.View;
import com.target.ui.util.u;
import java.util.List;

// Referenced classes of package com.target.ui.view.registry.adapter:
//            RegistryRefineSortSelectorAdapter

private class <init>
    implements android.view.eSortSelectorAdapter.b
{

    final RegistryRefineSortSelectorAdapter this$0;

    public void onClick(View view)
    {
        com.target.ui.model.registry.l l;
        view = (ewHolder)u.a(view.getTag(), com/target/ui/view/registry/adapter/RegistryRefineSortSelectorAdapter$ViewHolder);
        if (view == null)
        {
            return;
        }
        RegistryRefineSortSelectorAdapter.a(RegistryRefineSortSelectorAdapter.this, RegistryRefineSortSelectorAdapter.a(RegistryRefineSortSelectorAdapter.this));
        RegistryRefineSortSelectorAdapter.b(RegistryRefineSortSelectorAdapter.this, ((ewHolder) (view)).position);
        l = (com.target.ui.model.registry.l)RegistryRefineSortSelectorAdapter.b(RegistryRefineSortSelectorAdapter.this).get(RegistryRefineSortSelectorAdapter.a(RegistryRefineSortSelectorAdapter.this));
        if (RegistryRefineSortSelectorAdapter.c(RegistryRefineSortSelectorAdapter.this) != -1)
        {
            view = (com.target.ui.model.registry.l)RegistryRefineSortSelectorAdapter.b(RegistryRefineSortSelectorAdapter.this).get(RegistryRefineSortSelectorAdapter.c(RegistryRefineSortSelectorAdapter.this));
        } else
        {
            view = null;
        }
        if (RegistryRefineSortSelectorAdapter.a(RegistryRefineSortSelectorAdapter.this) == RegistryRefineSortSelectorAdapter.c(RegistryRefineSortSelectorAdapter.this)) goto _L2; else goto _L1
_L1:
        if (RegistryRefineSortSelectorAdapter.d(RegistryRefineSortSelectorAdapter.this) != null)
        {
            if (view != null)
            {
                RegistryRefineSortSelectorAdapter.d(RegistryRefineSortSelectorAdapter.this).b(view);
            }
            RegistryRefineSortSelectorAdapter.a(RegistryRefineSortSelectorAdapter.this, l);
            RegistryRefineSortSelectorAdapter.d(RegistryRefineSortSelectorAdapter.this).a(l);
        }
_L4:
        notifyDataSetInvalidated();
        return;
_L2:
        RegistryRefineSortSelectorAdapter.b(RegistryRefineSortSelectorAdapter.this, -1);
        if (RegistryRefineSortSelectorAdapter.d(RegistryRefineSortSelectorAdapter.this) != null)
        {
            RegistryRefineSortSelectorAdapter.a(RegistryRefineSortSelectorAdapter.this, null);
            RegistryRefineSortSelectorAdapter.d(RegistryRefineSortSelectorAdapter.this).b(l);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private ewHolder()
    {
        this$0 = RegistryRefineSortSelectorAdapter.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
