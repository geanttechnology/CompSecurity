// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.share.internal;

import android.os.Parcel;

// Referenced classes of package com.facebook.share.internal:
//            ShareFeedContent

static final class 
    implements android.os.areFeedContent._cls1
{

    public ShareFeedContent a(Parcel parcel)
    {
        return new ShareFeedContent(parcel);
    }

    public ShareFeedContent[] a(int i)
    {
        return new ShareFeedContent[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public Object[] newArray(int i)
    {
        return a(i);
    }

    ()
    {
    }
}
