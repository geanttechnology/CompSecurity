// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package amazon.communication.srr;

import amazon.communication.MissingCredentialsException;
import amazon.communication.RequestFailedException;
import amazon.communication.TimeoutException;
import org.apache.http.HttpResponse;

// Referenced classes of package amazon.communication.srr:
//            SrrRequest

public interface SrrManager
{

    public abstract HttpResponse makeRequestSync(SrrRequest srrrequest)
        throws TimeoutException, RequestFailedException, MissingCredentialsException;
}
