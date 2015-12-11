// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;

public final class bdh
    implements cot
{

    private bdi a;

    public bdh(bdi bdi1)
    {
        a = bdi1;
    }

    public final Uri a(Uri uri)
    {
        b.a(uri);
        bdi bdi1 = a;
        Uri uri1 = uri;
        if (bdi1.a(uri))
        {
            uri1 = bnf.a(uri).a("sdkv", bdi1.a).a("video_format", bdi1.c()).a("output", "xml_vast2").a.build();
        }
        return uri1;
    }

    public final volatile Object a(Object obj)
    {
        return a((Uri)obj);
    }
}
