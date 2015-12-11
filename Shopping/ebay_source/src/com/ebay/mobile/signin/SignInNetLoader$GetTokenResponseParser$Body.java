// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.signin;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.mobile.signin:
//            SignInNetLoader

static final class owner extends com.ebay.nautilus.kernel.util.
{

    owner owner;

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if (s1.equals("authenticateResponse"))
        {
            return new esponse(owner);
        } else
        {
            return super.(s, s1, s2, attributes);
        }
    }

    protected esponse(esponse esponse)
    {
        owner = esponse;
    }
}
