// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package amazon.communication.authentication;

import amazon.communication.MissingCredentialsException;
import org.apache.http.client.methods.HttpRequestBase;

// Referenced classes of package amazon.communication.authentication:
//            SigningException, RequestContext

public interface RequestSigner
{

    public abstract void signRequest(HttpRequestBase httprequestbase, RequestContext requestcontext)
        throws SigningException, MissingCredentialsException;
}
