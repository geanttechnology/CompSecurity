// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.share.model;

import android.os.Parcel;

// Referenced classes of package com.facebook.share.model:
//            ShareOpenGraphAction, ShareOpenGraphValueContainer

public static final class ainer.a extends ainer.a
{

    public ainer.a a(Parcel parcel)
    {
        return a((ShareOpenGraphAction)parcel.readParcelable(com/facebook/share/model/ShareOpenGraphAction.getClassLoader()));
    }

    public a a(ShareOpenGraphAction shareopengraphaction)
    {
        if (shareopengraphaction == null)
        {
            return this;
        } else
        {
            return ((ainer)super.a(shareopengraphaction)).a(shareopengraphaction.a());
        }
    }

    public a a(String s)
    {
        a("og:type", s);
        return this;
    }

    public ShareOpenGraphAction a()
    {
        return new ShareOpenGraphAction(this, null);
    }

    public volatile ainer.a a(ShareOpenGraphValueContainer shareopengraphvaluecontainer)
    {
        return a((ShareOpenGraphAction)shareopengraphvaluecontainer);
    }

    public ainer.a()
    {
    }
}
