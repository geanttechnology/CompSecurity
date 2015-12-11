// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.share.model;

import android.os.Parcel;

// Referenced classes of package com.facebook.share.model:
//            AppGroupCreationContent

static final class 
    implements android.os.tionContent._cls1
{

    public AppGroupCreationContent a(Parcel parcel)
    {
        return new AppGroupCreationContent(parcel);
    }

    public AppGroupCreationContent[] a(int i)
    {
        return new AppGroupCreationContent[i];
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
