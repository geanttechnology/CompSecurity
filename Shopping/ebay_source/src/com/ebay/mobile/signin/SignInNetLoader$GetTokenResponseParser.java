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

private static final class response extends com.ebay.nautilus.kernel.util.e
{
    static final class AuthResponse extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        SignInNetLoader.GetTokenResponse owner;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if (s1.equals("token"))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final AuthResponse this$0;

                    public void text(String s)
                        throws SAXException
                    {
                        owner.token = s;
                    }

            
            {
                this$0 = AuthResponse.this;
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
            owner.email = s4;
_L5:
            return super.get(s, s1, s2, attributes);
_L4:
            if ("username".equals(s3))
            {
                owner.userId = s4;
            } else
            if ("MgIdRef".equals(s3))
            {
                owner.machineGroupId = s4;
            } else
            if ("actorId".equals(s3))
            {
                owner.actorId = s4;
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
                return super.get(s, s1, s2, attributes);
            }
        }

        protected AuthResponse(SignInNetLoader.GetTokenResponse gettokenresponse)
        {
            owner = gettokenresponse;
        }
    }

    static final class Body extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        SignInNetLoader.GetTokenResponse owner;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if (s1.equals("authenticateResponse"))
            {
                return new AuthResponse(owner);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        protected Body(SignInNetLoader.GetTokenResponse gettokenresponse)
        {
            owner = gettokenresponse;
        }
    }


    public final response response;

    public com.ebay.nautilus.kernel.util.ner get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("http://www.w3.org/2003/05/soap-envelope".equals(s) && "Body".equals(s1))
        {
            return new Body(response);
        } else
        {
            return super.e(s, s1, s2, attributes);
        }
    }

    protected Body.owner(Body.owner owner)
    {
        response = owner;
    }
}
