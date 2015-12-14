// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import android.net.Uri;
import com.cyberlink.beautycircle.model.Post;
import com.perfectcorp.model.Model;

// Referenced classes of package com.cyberlink.beautycircle.utility:
//            ab

public class ShareSource
{

    public Model a;
    public Long b;
    public String c;
    public String d;
    public String e;
    public Uri f;
    public ShareSource g;
    public String h;
    public String i;
    public ab j;

    public static ShareSource a(com.cyberlink.beautycircle.model.o o)
    {
        ShareSource sharesource = new <init>();
        class ShareSource extends Enum
        {

            public static final ShareSource a;
            public static final ShareSource b;
            public static final ShareSource c;
            private static final ShareSource d[];

            public static ShareSource valueOf(String s)
            {
                return (ShareSource)Enum.valueOf(com/cyberlink/beautycircle/utility/ShareOutUtils$ShareInfo$ShareSource, s);
            }

            public static ShareSource[] values()
            {
                return (ShareSource[])d.clone();
            }

            static 
            {
                a = new ShareSource("BrandEvent", 0);
                b = new ShareSource("Contest", 1);
                c = new ShareSource("Post", 2);
                d = (new ShareSource[] {
                    a, b, c
                });
            }

            private ShareSource(String s, int k)
            {
                super(s, k);
            }
        }

        sharesource.g = ShareSource.b;
        sharesource.b = o.b;
        sharesource.c = o.e;
        sharesource.d = o.riptionForFacebook;
        sharesource.e = o.eURL;
        sharesource.f = o.bnail;
        return sharesource.a();
    }

    public static a a(com.cyberlink.beautycircle.model.o.a a1)
    {
        a a2 = new <init>();
        a2.g = ShareSource.a;
        a2.b = a1.b;
        a2.c = a1.le;
        a2.d = a1.cription;
        a2.e = "QUERY_DEEPLINK";
        a2.f = a1.geUrl;
        return a2.a();
    }

    public static a a(Post post)
    {
        a a1 = new <init>();
        a1.g = ShareSource.c;
        a1.a = post;
        a1.b = post.postId;
        a1.c = post.title;
        a1.d = post.content;
        a1.e = "QUERY_POST_DEEPLINK";
        a1.f = post.b();
        return a1.a();
    }

    public a a()
    {
        if (d != null)
        {
            d = d.replaceAll("\\<(/?[^\\>]+)\\>", "");
        }
        return this;
    }

    public ShareSource()
    {
    }
}
