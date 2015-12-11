// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.drm.java.service.workflow;

import com.comcast.playerplatform.drm.java.client.SecurityTokenType;
import com.comcast.playerplatform.drm.java.event.AbstractDrmEventListener;

// Referenced classes of package com.comcast.playerplatform.drm.java.service.workflow:
//            AbstractDRMWorkflow

class this._cls0 extends AbstractDrmEventListener
{

    final AbstractDRMWorkflow this$0;

    public void deProvisionComplete()
    {
        super.deProvisionComplete();
    }

    public void internalDRMError(SecurityTokenType securitytokentype, String s, String s1)
    {
        sendDrmFailure((new StringBuilder()).append(s).append(".").append("7005").toString(), s1, "");
    }

    public void provisionComplete()
    {
        super.provisionComplete();
    }

    public void serverSecurityError(SecurityTokenType securitytokentype, String s, String s1, String s2)
    {
        sendDrmFailure((new StringBuilder()).append(s).append(".").append("7005").toString(), s1, s2);
    }

    public void sessionCreated()
    {
        validate();
    }

    public void unprovisionedError()
    {
        sendDrmFailure("3329.412.7005", "Unable to retrieve Session Token. Device is not provisioned", "");
    }

    ()
    {
        this$0 = AbstractDRMWorkflow.this;
        super();
    }
}
