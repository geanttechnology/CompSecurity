// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.registry.adapter;

import android.view.View;
import com.target.ui.util.u;
import java.util.List;

// Referenced classes of package com.target.ui.view.registry.adapter:
//            RegistryRefineEventSelectorAdapter

private class <init>
    implements android.view.EventSelectorAdapter.b
{

    final RegistryRefineEventSelectorAdapter this$0;

    public void onClick(View view)
    {
        com.target.ui.model.registry.l l;
        view = (ewHolder)u.a(view.getTag(), com/target/ui/view/registry/adapter/RegistryRefineEventSelectorAdapter$ViewHolder);
        if (view == null)
        {
            return;
        }
        RegistryRefineEventSelectorAdapter.a(RegistryRefineEventSelectorAdapter.this, RegistryRefineEventSelectorAdapter.a(RegistryRefineEventSelectorAdapter.this));
        RegistryRefineEventSelectorAdapter.b(RegistryRefineEventSelectorAdapter.this, ((ewHolder) (view)).position);
        l = (com.target.ui.model.registry.l)RegistryRefineEventSelectorAdapter.b(RegistryRefineEventSelectorAdapter.this).get(RegistryRefineEventSelectorAdapter.a(RegistryRefineEventSelectorAdapter.this));
        if (RegistryRefineEventSelectorAdapter.c(RegistryRefineEventSelectorAdapter.this) != -1)
        {
            view = (com.target.ui.model.registry.l)RegistryRefineEventSelectorAdapter.b(RegistryRefineEventSelectorAdapter.this).get(RegistryRefineEventSelectorAdapter.c(RegistryRefineEventSelectorAdapter.this));
        } else
        {
            view = null;
        }
        if (RegistryRefineEventSelectorAdapter.a(RegistryRefineEventSelectorAdapter.this) == RegistryRefineEventSelectorAdapter.c(RegistryRefineEventSelectorAdapter.this)) goto _L2; else goto _L1
_L1:
        if (RegistryRefineEventSelectorAdapter.d(RegistryRefineEventSelectorAdapter.this) != null)
        {
            if (view != null)
            {
                RegistryRefineEventSelectorAdapter.d(RegistryRefineEventSelectorAdapter.this).b(view);
            }
            RegistryRefineEventSelectorAdapter.a(RegistryRefineEventSelectorAdapter.this, l);
            RegistryRefineEventSelectorAdapter.d(RegistryRefineEventSelectorAdapter.this).a(l);
        }
_L4:
        notifyDataSetInvalidated();
        return;
_L2:
        RegistryRefineEventSelectorAdapter.b(RegistryRefineEventSelectorAdapter.this, -1);
        if (RegistryRefineEventSelectorAdapter.d(RegistryRefineEventSelectorAdapter.this) != null)
        {
            RegistryRefineEventSelectorAdapter.a(RegistryRefineEventSelectorAdapter.this, null);
            RegistryRefineEventSelectorAdapter.d(RegistryRefineEventSelectorAdapter.this).b(l);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private ewHolder()
    {
        this$0 = RegistryRefineEventSelectorAdapter.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
