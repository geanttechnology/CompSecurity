// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;

public abstract class bzn extends cpd
{

    private static final bnq b = (new bnr()).a("/errors", new bzt()).a("/errors/error", new bzs()).a("/errors/error/domain", new bzr()).a("/errors/error/code", new bzq()).a("/errors/error/location", new bzp()).a("/errors/error/internalReason", new bzo()).a();

    public bzn(bns bns1)
    {
        super(bns1);
    }

    public static bzn a(bns bns1)
    {
        return new bzu(bns1);
    }

    protected final HttpResponseException a(HttpResponse httpresponse)
    {
        Object obj;
        int i;
        obj = httpresponse.getStatusLine();
        i = ((StatusLine) (obj)).getStatusCode();
        obj = ((StatusLine) (obj)).getReasonPhrase();
        Object obj1 = httpresponse.getFirstHeader("Content-Type");
        boolean flag;
        if ((i == 400 || i == 401 || i == 403 || i == 503) && obj1 != null && ((Header) (obj1)).getValue().contains("xml"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_148;
        }
        obj1 = httpresponse.getEntity().getContent();
        obj1 = (ArrayList)a.a(((java.io.InputStream) (obj1)), b);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_148;
        }
        if (((ArrayList) (obj1)).size() == 0)
        {
            break MISSING_BLOCK_LABEL_148;
        }
        obj1 = new bzv(i, ((String) (obj)), ((java.util.List) (obj1)));
        return ((HttpResponseException) (obj1));
        Exception exception;
        exception;
        if (i == 401 && "NoLinkedYouTubeAccount".equals(obj))
        {
            return bzv.a(i, ((String) (obj)));
        } else
        {
            return super.a(httpresponse);
        }
    }

}
