// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import java.io.UnsupportedEncodingException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;

public final class bdg
    implements cot
{

    private final boolean a;
    private final bdh b;

    public bdg(bdh bdh1, boolean flag)
    {
        a = flag;
        b = bdh1;
    }

    private HttpUriRequest a(Uri uri)
    {
        uri = b.a(uri);
        if (!a)
        {
            return bkf.a.a(uri);
        }
        Object obj = uri.getQuery();
        uri = new HttpPost(uri.buildUpon().clearQuery().build().toString());
        try
        {
            obj = new StringEntity(((String) (obj)));
            ((StringEntity) (obj)).setContentType("application/x-www-form-urlencoded");
            uri.setEntity(((org.apache.http.HttpEntity) (obj)));
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            bmo.b("UnsupportedEncodingException encountered when generating ad request");
            return uri;
        }
        return uri;
    }

    public final volatile Object a(Object obj)
    {
        return a((Uri)obj);
    }
}
