// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpUriRequest;

final class bkl extends bkf
{

    bkl(String s, int i)
    {
        super(s, 5);
    }

    public final HttpUriRequest a(Uri uri)
    {
        return new HttpDelete(uri.toString());
    }
}
