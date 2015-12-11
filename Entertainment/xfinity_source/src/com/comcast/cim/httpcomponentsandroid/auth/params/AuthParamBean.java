// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.auth.params;

import com.comcast.cim.httpcomponentsandroid.params.HttpAbstractParamBean;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.auth.params:
//            AuthParams

public class AuthParamBean extends HttpAbstractParamBean
{

    public void setCredentialCharset(String s)
    {
        AuthParams.setCredentialCharset(params, s);
    }
}
