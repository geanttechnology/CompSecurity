// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;

final class bkj extends bkf
{

    bkj(String s, int i)
    {
        super(s, 3);
    }

    public final HttpUriRequest a(Uri uri)
    {
        return new HttpPut(uri.toString());
    }
}
