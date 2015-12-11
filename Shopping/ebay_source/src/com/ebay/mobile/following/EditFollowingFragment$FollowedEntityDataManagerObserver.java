// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.following;

import com.ebay.common.model.followinterest.FollowType;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.kernel.content.ResultStatus;

// Referenced classes of package com.ebay.mobile.following:
//            EditFollowingFragment

private class <init> extends com.ebay.common.content.dm.init>
{

    final EditFollowingFragment this$0;

    public void onCollectionFollowed(Content content)
    {
        EditFollowingFragment.this.onCollectionFollowed(content);
    }

    public void onFollowDeleted(FollowType followtype, String s, ResultStatus resultstatus)
    {
        EditFollowingFragment.this.onFollowDeleted(followtype, s, resultstatus);
    }

    public void onUserFollowed(Content content)
    {
        EditFollowingFragment.this.onUserFollowed(content);
    }

    private ()
    {
        this$0 = EditFollowingFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
