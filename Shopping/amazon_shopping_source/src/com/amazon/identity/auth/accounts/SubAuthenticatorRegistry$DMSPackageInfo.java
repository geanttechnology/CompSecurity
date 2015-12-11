// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.content.res.XmlResourceParser;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            SubAuthenticatorRegistry

private static class mParser
{

    private String mPackageName;
    private XmlResourceParser mParser;

    public String getPackageName()
    {
        return mPackageName;
    }

    public XmlResourceParser getParser()
    {
        return mParser;
    }

    public (String s, XmlResourceParser xmlresourceparser)
    {
        mPackageName = s;
        mParser = xmlresourceparser;
    }
}
