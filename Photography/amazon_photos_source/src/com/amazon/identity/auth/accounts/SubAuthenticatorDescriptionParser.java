// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.content.res.XmlResourceParser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            InvalidSubAuthenticatorDefinitionException, SubAuthenticatorDescription

public class SubAuthenticatorDescriptionParser
{
    private static class Parser
    {

        private String mDeviceType;
        private boolean mIsDMS;
        private boolean mIsMultipleAccountAware;
        private final List mTokenTypes;
        private XmlResourceParser mXmlParser;

        private void assertNodeName(String s)
            throws InvalidSubAuthenticatorDefinitionException
        {
            if (!mXmlParser.getName().equals(s))
            {
                throw new InvalidSubAuthenticatorDefinitionException();
            } else
            {
                return;
            }
        }

        private void moveNextAndCheck(int i)
            throws InvalidSubAuthenticatorDefinitionException, IOException, XmlPullParserException
        {
            int j;
            if (i == 2 || i == 3)
            {
                j = mXmlParser.nextTag();
            } else
            {
                j = mXmlParser.next();
            }
            if (j != i)
            {
                throw new InvalidSubAuthenticatorDefinitionException();
            } else
            {
                return;
            }
        }

        private void startNode(String s)
            throws InvalidSubAuthenticatorDefinitionException, IOException, XmlPullParserException
        {
            moveNextAndCheck(2);
            assertNodeName(s);
        }

        public SubAuthenticatorDescription parse(String s, String s1, XmlResourceParser xmlresourceparser)
            throws InvalidSubAuthenticatorDefinitionException
        {
            mXmlParser = xmlresourceparser;
            try
            {
                moveNextAndCheck(0);
                startNode("account-sub-authenticator");
                if (!mXmlParser.getAttributeValue(null, "accountType").equals("com.amazon.account"))
                {
                    throw new InvalidSubAuthenticatorDefinitionException();
                }
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new InvalidSubAuthenticatorDefinitionException(s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new InvalidSubAuthenticatorDefinitionException(s);
            }
            xmlresourceparser = mXmlParser.getAttributeValue(null, "type");
            if (xmlresourceparser == null)
            {
                break MISSING_BLOCK_LABEL_219;
            }
            if (!xmlresourceparser.equals("DMS"))
            {
                break MISSING_BLOCK_LABEL_219;
            }
            mIsDMS = true;
_L2:
            if (mXmlParser.next() == 3)
            {
                break MISSING_BLOCK_LABEL_282;
            }
            xmlresourceparser = mXmlParser.getName();
            moveNextAndCheck(4);
            if (!xmlresourceparser.equals("device-type"))
            {
                break; /* Loop/switch isn't completed */
            }
            mDeviceType = mXmlParser.getText();
_L3:
            moveNextAndCheck(3);
            if (true) goto _L2; else goto _L1
_L1:
            if (!xmlresourceparser.equals("multiple-account-aware"))
            {
                break MISSING_BLOCK_LABEL_211;
            }
            xmlresourceparser = mXmlParser.getText();
            boolean flag;
            if ("true".equalsIgnoreCase(xmlresourceparser) || "yes".equalsIgnoreCase(xmlresourceparser) || "1".equalsIgnoreCase(xmlresourceparser))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            mIsMultipleAccountAware = flag;
              goto _L3
            throw new InvalidSubAuthenticatorDefinitionException();
            startNode("token-types");
            for (; mXmlParser.nextTag() != 3; mTokenTypes.add(xmlresourceparser))
            {
                assertNodeName("token-type");
                xmlresourceparser = mXmlParser.getAttributeValue(null, "name");
                moveNextAndCheck(3);
            }

            assertNodeName("token-types");
            if (!mXmlParser.getName().equals("account-sub-authenticator"))
            {
                moveNextAndCheck(3);
            }
            moveNextAndCheck(1);
            if (mIsDMS)
            {
                return SubAuthenticatorDescription.createDMSSubAuthenticatorDescription(s, s1, mDeviceType, mIsMultipleAccountAware);
            }
            s = SubAuthenticatorDescription.createNonDMSSubAuthenticatorDescription(s, s1, mTokenTypes);
            return s;
        }

        private Parser()
        {
            mTokenTypes = new ArrayList();
        }

        Parser(byte byte0)
        {
            this();
        }
    }


    public SubAuthenticatorDescriptionParser()
    {
    }

    public SubAuthenticatorDescription parse(String s, String s1, XmlResourceParser xmlresourceparser)
        throws InvalidSubAuthenticatorDefinitionException
    {
        if (s == null || xmlresourceparser == null)
        {
            throw new IllegalArgumentException("The package name and xml parser parameter cannot be null");
        } else
        {
            return (new Parser((byte)0)).parse(s, s1, xmlresourceparser);
        }
    }
}
