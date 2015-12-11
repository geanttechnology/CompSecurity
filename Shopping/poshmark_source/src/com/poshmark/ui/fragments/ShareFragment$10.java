// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.view.View;
import com.poshmark.utils.ShareManager;

// Referenced classes of package com.poshmark.ui.fragments:
//            ShareFragment

class this._cls0
    implements android.view.ner
{

    final ShareFragment this$0;

    public void onClick(View view)
    {
        shareManager.setShareType(com.poshmark.utils.E_TYPE.DEFAULT);
        shareManager.shareToFollowers();
    }

    ()
    {
        this$0 = ShareFragment.this;
        super();
    }
}
