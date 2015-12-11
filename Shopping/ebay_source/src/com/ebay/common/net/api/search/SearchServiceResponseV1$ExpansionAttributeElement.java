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
//            SearchServiceResponseV1

private class expansionResult extends com.ebay.nautilus.kernel.util.
{

    public String attributeName;
    public String attributeValue;
    private final apply expansionResult;
    final SearchServiceResponseV1 this$0;

    private void apply()
    {
        if (!TextUtils.isEmpty(attributeName) && !TextUtils.isEmpty(attributeValue)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (attributeName.equals("is_auto_run"))
        {
            expansionResult.expansionResult = Boolean.parseBoolean(attributeValue);
            return;
        }
        if (!attributeName.equals("recovery_type"))
        {
            break; /* Loop/switch isn't completed */
        }
        expansionResult.expansionResult = attributeValue;
        if ("spell_check".equals(attributeValue) || "category_constraint".equals(attributeValue) || "spell_auto_correct".equals(attributeValue))
        {
            expansionResult.expansionResult = true;
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (attributeName.equals("abriged_match_count") || attributeName.equals("abridged_match_count"))
        {
            expansionResult. = Long.parseLong(attributeValue);
            return;
        }
        if (attributeName.equals("instance_name"))
        {
            expansionResult.expansionResult = attributeValue;
            return;
        }
        if (attributeName.equals("match_count"))
        {
            expansionResult.expansionResult = Long.parseLong(attributeValue);
            return;
        }
        if (attributeName.equals("promoted_to_primary"))
        {
            expansionResult.expansionResult = attributeValue.equals("full");
            return;
        }
        if (attributeName.equals("meta_attribute_names"))
        {
            expansionResult. = attributeValue.split(",");
            applyMetaAttributes();
            return;
        }
        if (attributeName.equals("meta_attribute_values"))
        {
            expansionResult.s = attributeValue.split(",");
            applyMetaAttributes();
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    private void applyMetaAttributes()
    {
_L2:
        return;
        if (expansionResult. == null || expansionResult.s == null || expansionResult..length != expansionResult.s.length) goto _L2; else goto _L1
_L1:
        int i = 0;
_L4:
        if (i >= expansionResult..length) goto _L2; else goto _L3
_L3:
        String s;
        String s1;
        s1 = expansionResult.[i];
        s = expansionResult.s[i];
        if (s1.equals("original_user_query"))
        {
            break MISSING_BLOCK_LABEL_98;
        }
        Object obj = s;
        if (!s1.equals("correction"))
        {
            break MISSING_BLOCK_LABEL_105;
        }
        obj = URLDecoder.decode(s, "UTF-8");
_L5:
        expansionResult.expansionResult.put(s1, obj);
        i++;
          goto _L4
          goto _L2
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        unsupportedencodingexception = s;
          goto _L5
    }

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("name".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final SearchServiceResponseV1.ExpansionAttributeElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    attributeName = s3;
                    apply();
                }

            
            {
                this$1 = SearchServiceResponseV1.ExpansionAttributeElement.this;
                super();
            }
            };
        }
        if ("value".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final SearchServiceResponseV1.ExpansionAttributeElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    attributeValue = s3;
                    apply();
                }

            
            {
                this$1 = SearchServiceResponseV1.ExpansionAttributeElement.this;
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
        this$0 = SearchServiceResponseV1.this;
        super();
        expansionResult = _pcls1;
    }
}
