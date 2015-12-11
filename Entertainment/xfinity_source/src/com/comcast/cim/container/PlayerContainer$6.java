// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.container;

import com.comcast.cim.cmasl.http.request.signing.RequestSigner;
import com.comcast.cim.cmasl.http.request.signing.RequestSignerFactory;
import com.comcast.cim.http.signing.OAuthRequestSigner;

// Referenced classes of package com.comcast.cim.container:
//            PlayerContainer

class this._cls0
    implements RequestSignerFactory
{

    final PlayerContainer this$0;

    public RequestSigner create(String s, String s1)
    {
        return new OAuthRequestSigner(s, s1);
    }

    equestSigner()
    {
        this$0 = PlayerContainer.this;
        super();
    }
}
