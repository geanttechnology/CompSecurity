// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;

// Referenced classes of package com.facebook.share.model:
//            ShareVideo, ShareMedia

public static final class  extends 
{

    private Uri localUrl;

    public ShareVideo build()
    {
        return new ShareVideo(this, null);
    }

    public volatile  readFrom(ShareMedia sharemedia)
    {
        return readFrom((ShareVideo)sharemedia);
    }

    public readFrom readFrom(Parcel parcel)
    {
        return readFrom((ShareVideo)parcel.readParcelable(com/facebook/share/model/ShareVideo.getClassLoader()));
    }

    public readFrom readFrom(ShareVideo sharevideo)
    {
        if (sharevideo == null)
        {
            return this;
        } else
        {
            return ((readFrom)super.readFrom(sharevideo)).setLocalUrl(sharevideo.getLocalUrl());
        }
    }

    public Url setLocalUrl(Uri uri)
    {
        localUrl = uri;
        return this;
    }


    public ()
    {
    }
}
