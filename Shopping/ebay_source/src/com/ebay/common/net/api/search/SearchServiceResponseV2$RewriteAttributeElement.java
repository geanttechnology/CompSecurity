// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            SearchServiceResponseV2

private class expansionResult extends com.ebay.nautilus.kernel.util.
{

    public String attributeName;
    public String attributeValue;
    private final apply expansionResult;
    final SearchServiceResponseV2 this$0;

    private void apply()
    {
        String s;
        byte byte0;
        if (TextUtils.isEmpty(attributeName) || TextUtils.isEmpty(attributeValue))
        {
            return;
        }
        s = attributeName;
        byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 9: default 116
    //                   -2110750945: 298
    //                   -1483000135: 268
    //                   -1382665227: 240
    //                   -214023765: 283
    //                   -90002480: 226
    //                   704031600: 184
    //                   1566183812: 212
    //                   1972125092: 198
    //                   1972790805: 254;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L1:
        break; /* Loop/switch isn't completed */
_L2:
        break MISSING_BLOCK_LABEL_298;
_L11:
        switch (byte0)
        {
        default:
            return;

        case 0: // '\0'
            expansionResult.expansionResult = Boolean.parseBoolean(attributeValue);
            return;

        case 1: // '\001'
            expansionResult.expansionResult = attributeValue;
            return;

        case 2: // '\002'
        case 3: // '\003'
            expansionResult.nt = Long.parseLong(attributeValue);
            return;

        case 4: // '\004'
            expansionResult.expansionResult = attributeValue;
            return;

        case 5: // '\005'
            expansionResult.expansionResult = Long.parseLong(attributeValue);
            return;

        case 6: // '\006'
            expansionResult.y = attributeValue.equals("full");
            return;

        case 7: // '\007'
            expansionResult.es = attributeValue.split(",");
            applyMetaAttributes();
            return;

        case 8: // '\b'
            expansionResult.ues = attributeValue.split(",");
            break;
        }
        break MISSING_BLOCK_LABEL_421;
_L7:
        if (s.equals("is_auto_run"))
        {
            byte0 = 0;
        }
          goto _L11
_L9:
        if (s.equals("recovery_type"))
        {
            byte0 = 1;
        }
          goto _L11
_L8:
        if (s.equals("abriged_match_count"))
        {
            byte0 = 2;
        }
          goto _L11
_L6:
        if (s.equals("abridged_match_count"))
        {
            byte0 = 3;
        }
          goto _L11
_L4:
        if (s.equals("instance_name"))
        {
            byte0 = 4;
        }
          goto _L11
_L10:
        if (s.equals("match_count"))
        {
            byte0 = 5;
        }
          goto _L11
_L3:
        if (s.equals("promoted_to_primary"))
        {
            byte0 = 6;
        }
          goto _L11
_L5:
        if (s.equals("meta_attribute_names"))
        {
            byte0 = 7;
        }
          goto _L11
        if (s.equals("meta_attribute_values"))
        {
            byte0 = 8;
        }
          goto _L11
        applyMetaAttributes();
        return;
    }

    private void applyMetaAttributes()
    {
_L2:
        return;
        if (expansionResult.es == null || expansionResult.ues == null || expansionResult.es.length != expansionResult.ues.length) goto _L2; else goto _L1
_L1:
        int i = 0;
_L4:
        if (i >= expansionResult.es.length)
        {
            break; /* Loop/switch isn't completed */
        }
        String s2 = expansionResult.es[i];
        String s1 = expansionResult.ues[i];
        String s;
        try
        {
            if (s2.equals("original_user_query"))
            {
                break MISSING_BLOCK_LABEL_98;
            }
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            throw new IllegalStateException("Unsupported encoding: ISO-8859-1");
        }
        s = s1;
        if (!s2.equals("correction"))
        {
            break MISSING_BLOCK_LABEL_105;
        }
        s = URLDecoder.decode(s1, "UTF-8");
        expansionResult.expansionResult.put(s2, s);
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        if (true) goto _L2; else goto _L5
_L5:
    }

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("name".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final SearchServiceResponseV2.RewriteAttributeElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    attributeName = s3;
                    apply();
                }

            
            {
                this$1 = SearchServiceResponseV2.RewriteAttributeElement.this;
                super();
            }
            };
        }
        if ("value".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final SearchServiceResponseV2.RewriteAttributeElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    attributeValue = s3;
                    apply();
                }

            
            {
                this$1 = SearchServiceResponseV2.RewriteAttributeElement.this;
                super();
            }
            };
        } else
        {
            return super.(s, s1, s2, attributes);
        }
    }


    public _cls2.this._cls1(_cls2.this._cls1 _pcls1)
    {
        this$0 = SearchServiceResponseV2.this;
        super();
        expansionResult = _pcls1;
    }
}
