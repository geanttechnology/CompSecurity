// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package amazon.communication;

import amazon.communication.identity.EndpointIdentity;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;

// Referenced classes of package amazon.communication:
//            RequestFailedException

public interface ResponseHandler
{

    public abstract void onError(HttpRequestBase httprequestbase, RequestFailedException requestfailedexception);

    public abstract void onResponse(EndpointIdentity endpointidentity, HttpResponse httpresponse, int i, List list);
}
