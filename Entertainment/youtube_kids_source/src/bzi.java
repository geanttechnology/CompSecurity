// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import java.util.Map;

public final class bzi extends cqy
{

    bzi(Uri uri, Map map, byte abyte0[])
    {
        Uri uri1 = uri;
        if ("http".equalsIgnoreCase(uri.getScheme()))
        {
            boolean flag;
            if ("stage.gdata.youtube.com".equalsIgnoreCase(uri.getHost()) || "dev.gdata.youtube.com".equalsIgnoreCase(uri.getHost()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            uri1 = uri;
            if (!flag)
            {
                uri1 = uri.buildUpon().scheme("https").build();
            }
        }
        super(uri1, map, abyte0);
    }

    public static bzi a(Uri uri)
    {
        return new bzi(uri, null, null);
    }

    public static bzi a(Uri uri, bzi bzi1)
    {
        b.a(bzi1);
        return new bzi(uri, bzi1.b, a(((cqy) (bzi1))));
    }

    public final bzi b(Uri uri)
    {
        b.a(uri);
        return new bzi(uri, b, a(this));
    }
}
