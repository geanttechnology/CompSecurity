// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package amazon.communication.srr;

import amazon.communication.CommunicationManager;
import amazon.communication.authentication.AccountRequestContext;
import amazon.communication.authentication.RequestContext;
import amazon.communication.connection.Policy;

// Referenced classes of package amazon.communication.srr:
//            TCommSrrManager

public class DeviceTCommSrrManager extends TCommSrrManager
{

    public DeviceTCommSrrManager(CommunicationManager communicationmanager, Policy policy)
    {
        super(communicationmanager, policy);
    }

    protected boolean isAnonymousCredentialsAllowed(RequestContext requestcontext)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (requestcontext != null)
        {
            flag = flag1;
            if (requestcontext instanceof AccountRequestContext)
            {
                flag = flag1;
                if (((AccountRequestContext)requestcontext).getDirectedId() == null)
                {
                    flag = true;
                }
            }
        }
        return flag;
    }
}
