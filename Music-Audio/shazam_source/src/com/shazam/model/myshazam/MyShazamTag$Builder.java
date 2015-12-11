// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.myshazam;

import com.shazam.model.TrackStyle;
import com.shazam.model.post.Post;
import com.shazam.model.preview.PreviewViewData;
import com.shazam.model.store.Store;

// Referenced classes of package com.shazam.model.myshazam:
//            MyShazamTag

public static class 
{

    public String artUrl;
    public String artistsDescription;
    public boolean isFull;
    public Post post;
    public PreviewViewData previewViewData;
    public boolean publishable;
    public String requestId;
    public Store store;
    public Long timestamp;
    public String trackId;
    public String trackKey;
    public TrackStyle trackStyle;
    public String trackTitle;

    public static  a()
    {
        return new <init>();
    }

    static String a(<init> <init>1)
    {
        return <init>1.requestId;
    }

    static String b(requestId requestid)
    {
        return requestid.trackId;
    }

    static String c(trackId trackid)
    {
        return trackid.artistsDescription;
    }

    static Long d(artistsDescription artistsdescription)
    {
        return artistsdescription.timestamp;
    }

    static String e(timestamp timestamp1)
    {
        return timestamp1.trackTitle;
    }

    static String f(trackTitle tracktitle)
    {
        return tracktitle.artUrl;
    }

    static PreviewViewData g(artUrl arturl)
    {
        return arturl.previewViewData;
    }

    static Store h(previewViewData previewviewdata)
    {
        return previewviewdata.store;
    }

    static boolean i(store store1)
    {
        return store1.isFull;
    }

    static Post j(isFull isfull)
    {
        return isfull.post;
    }

    static TrackStyle k(post post1)
    {
        return post1.trackStyle;
    }

    static boolean l(trackStyle trackstyle)
    {
        return trackstyle.publishable;
    }

    static String m(publishable publishable1)
    {
        return publishable1.trackKey;
    }

    public final MyShazamTag b()
    {
        return new MyShazamTag(this, null);
    }

    public ()
    {
    }
}
