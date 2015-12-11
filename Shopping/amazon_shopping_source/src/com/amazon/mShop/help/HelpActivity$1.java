// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.help;

import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.model.auth.UserListener;

// Referenced classes of package com.amazon.mShop.help:
//            HelpActivity

class this._cls0
    implements UserListener
{

    final HelpActivity this$0;

    public void userSignedIn(User user)
    {
        HelpActivity.access$000(HelpActivity.this, getCurrentView());
    }

    public void userSignedOut()
    {
    }

    public void userUpdated(User user)
    {
        HelpActivity.access$000(HelpActivity.this, getCurrentView());
    }

    ner()
    {
        this$0 = HelpActivity.this;
        super();
    }
}
