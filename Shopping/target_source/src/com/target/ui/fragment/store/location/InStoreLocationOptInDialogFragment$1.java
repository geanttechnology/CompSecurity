// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.store.location;

import android.widget.CompoundButton;
import com.target.ui.fragment.store.location.b.a;

// Referenced classes of package com.target.ui.fragment.store.location:
//            InStoreLocationOptInDialogFragment

class this._cls0
    implements android.widget.r
{

    final InStoreLocationOptInDialogFragment this$0;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        if (com.target.ui.fragment.store.location.InStoreLocationOptInDialogFragment.a(InStoreLocationOptInDialogFragment.this) == null)
        {
            return;
        } else
        {
            com.target.ui.fragment.store.location.InStoreLocationOptInDialogFragment.a(InStoreLocationOptInDialogFragment.this).a(flag);
            return;
        }
    }

    ()
    {
        this$0 = InStoreLocationOptInDialogFragment.this;
        super();
    }
}
