// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.signin;

import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.ErrorMessageElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.mobile.signin:
//            SignInNetLoader

static final class owner extends com.ebay.nautilus.kernel.util._cls0
{

    owner owner;

    public com.ebay.nautilus.kernel.util._cls0 get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if (s1.equals("token"))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final SignInNetLoader.GetTokenResponseParser.AuthResponse this$0;

                public void text(String s7)
                    throws SAXException
                {
                    owner.token = s7;
                }

            
            {
                this$0 = SignInNetLoader.GetTokenResponseParser.AuthResponse.this;
                super();
            }
            };
        }
        if (!s1.equals("properties")) goto _L2; else goto _L1
_L1:
        String s3;
        String s4;
        s3 = null;
        s4 = null;
        int j = attributes.getLength();
        int i = 0;
        while (i < j) 
        {
            String s6 = attributes.getLocalName(i);
            String s5;
            if (s6.equals("name"))
            {
                s5 = attributes.getValue(i);
            } else
            {
                s5 = s3;
                if (s6.equals("value"))
                {
                    s4 = attributes.getValue(i);
                    s5 = s3;
                }
            }
            i++;
            s3 = s5;
        }
        if (!"email".equals(s3)) goto _L4; else goto _L3
_L3:
        owner.owner = s4;
_L5:
        return super._mth0(s, s1, s2, attributes);
_L4:
        if ("username".equals(s3))
        {
            owner.owner = s4;
        } else
        if ("MgIdRef".equals(s3))
        {
            owner.owner = s4;
        } else
        if ("actorId".equals(s3))
        {
            owner.owner = s4;
        }
        if (true) goto _L5; else goto _L2
_L2:
        if (s1.equals("ack"))
        {
            return new AckElement(owner);
        }
        if (s1.equals("timestamp"))
        {
            return new TimestampElement(owner);
        }
        if (s1.equals("errorMessage"))
        {
            return new ErrorMessageElement(owner, "http://www.ebay.com/marketplace/security/v1/services");
        } else
        {
            return super._mth0(s, s1, s2, attributes);
        }
    }

    protected _cls1.this._cls0(_cls1.this._cls0 _pcls0)
    {
        owner = _pcls0;
    }
}
