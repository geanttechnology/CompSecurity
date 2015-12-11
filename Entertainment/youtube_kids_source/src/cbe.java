// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import org.apache.http.Header;
import org.apache.http.HttpResponse;

public final class cbe extends coo
{

    public cbe()
    {
    }

    private Uri e(HttpResponse httpresponse)
    {
        c(httpresponse);
        httpresponse = httpresponse.getFirstHeader("Location");
        if (httpresponse == null)
        {
            throw new bnn("Location header not present");
        } else
        {
            return Uri.parse(httpresponse.getValue());
        }
    }

    public final Object a_(Object obj)
    {
        return e((HttpResponse)obj);
    }

    public final Object b(HttpResponse httpresponse)
    {
        return e(httpresponse);
    }
}
