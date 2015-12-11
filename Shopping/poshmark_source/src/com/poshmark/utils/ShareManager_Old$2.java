// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.support.v4.app.FragmentActivity;
import com.poshmark.ui.fragments.PMFragment;

// Referenced classes of package com.poshmark.utils:
//            ShareManager_Old

class this._cls0
    implements com.poshmark.ui.customviews.ogressDialogAutoDismissListener
{

    final ShareManager_Old this$0;

    public void dialogDismissed()
    {
        ShareManager_Old.access$200(ShareManager_Old.this).getActivity().finish();
    }

    y()
    {
        this$0 = ShareManager_Old.this;
        super();
    }
}
