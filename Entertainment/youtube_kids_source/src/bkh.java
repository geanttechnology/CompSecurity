// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

final class bkh extends bkf
{

    bkh(String s, int i)
    {
        super(s, 1);
    }

    public final HttpUriRequest a(Uri uri)
    {
        return new HttpGet(uri.toString());
    }
}
