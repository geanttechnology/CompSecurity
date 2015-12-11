// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.aspects.activities;

import com.shazam.g.b;

// Referenced classes of package com.shazam.android.aspects.activities:
//            FollowersCountActivityAspect

private class <init>
    implements b
{

    final FollowersCountActivityAspect this$0;

    public void onDataFailedToLoad()
    {
    }

    public void onDataFetched(Integer integer)
    {
        FollowersCountActivityAspect.access$100(FollowersCountActivityAspect.this, integer.intValue());
    }

    public volatile void onDataFetched(Object obj)
    {
        onDataFetched((Integer)obj);
    }

    public void onUnauthorized()
    {
        com.shazam.android.activities.b.b.b(FollowersCountActivityAspect.access$200(FollowersCountActivityAspect.this));
    }

    private ()
    {
        this$0 = FollowersCountActivityAspect.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
