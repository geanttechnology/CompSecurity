// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package amazon.communication.rmr;

import amazon.communication.Message;

// Referenced classes of package amazon.communication.rmr:
//            RmrRequest, RmrResponseException

public interface RmrResponseHandler
{

    public abstract void onError(RmrRequest rmrrequest, RmrResponseException rmrresponseexception);

    public abstract void onFinish(RmrRequest rmrrequest);

    public abstract void onResponse(RmrRequest rmrrequest, Message message);

    public abstract void onStart(RmrRequest rmrrequest);
}
