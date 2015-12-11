// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.details;

import com.shazam.model.follow.FollowData;
import com.shazam.model.preview.PreviewViewData;
import com.shazam.model.store.Stores;

// Referenced classes of package com.shazam.model.details:
//            InteractiveInfo

public static class 
{

    public FollowData followData;
    public PreviewViewData previewViewData;
    public Stores stores;

    public static  a()
    {
        return new <init>();
    }

    static Stores a(<init> <init>1)
    {
        return <init>1.stores;
    }

    static PreviewViewData b(stores stores1)
    {
        return stores1.previewViewData;
    }

    static FollowData c(previewViewData previewviewdata)
    {
        return previewviewdata.followData;
    }

    public final InteractiveInfo b()
    {
        return new InteractiveInfo(this, null);
    }

    public ()
    {
    }
}
