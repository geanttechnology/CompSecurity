// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.os.Bundle;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.fragments.UserListFragment;
import com.poshmark.utils.TextClickListener;

// Referenced classes of package com.poshmark.ui.customviews:
//            PMTextView

class this._cls0
    implements TextClickListener
{

    final PMTextView this$0;

    public void onClick(String s)
    {
        Bundle bundle = new Bundle();
        bundle.putString("MODE", com.poshmark.ui.fragments.ent.USER_LIST_MODE.LIKES_MODE.name());
        bundle.putString("ID", s);
        ((PMActivity)getContext()).launchFragment(bundle, com/poshmark/ui/fragments/UserListFragment, null);
    }

    t()
    {
        this$0 = PMTextView.this;
        super();
    }
}
