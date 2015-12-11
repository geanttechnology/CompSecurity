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

    private Uri a;

    static Uri a( )
    {
        return .a;
    }

    public volatile a a(ShareMedia sharemedia)
    {
        return a((ShareVideo)sharemedia);
    }

    public a a(Uri uri)
    {
        a = uri;
        return this;
    }

    public a a(Parcel parcel)
    {
        return a((ShareVideo)parcel.readParcelable(com/facebook/share/model/ShareVideo.getClassLoader()));
    }

    public a a(ShareVideo sharevideo)
    {
        if (sharevideo == null)
        {
            return this;
        } else
        {
            return ((a)super.a(sharevideo)).a(sharevideo.b());
        }
    }

    public ShareVideo a()
    {
        return new ShareVideo(this, null);
    }

    public ()
    {
    }
}
