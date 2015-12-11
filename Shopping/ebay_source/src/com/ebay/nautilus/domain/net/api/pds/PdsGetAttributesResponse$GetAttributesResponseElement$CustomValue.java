// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.pds;

import android.text.TextUtils;
import com.ebay.nautilus.domain.data.PdsSearchItemAttribute;
import com.ebay.nautilus.domain.data.PdsViewItemAttribute;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.pds:
//            PdsGetAttributesResponse

private final class attributeId extends com.ebay.nautilus.kernel.util.mValue
{

    final String attributeId;
    final attributeId this$1;

    public com.ebay.nautilus.kernel.util.mValue get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("rawValue".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final PdsGetAttributesResponse.GetAttributesResponseElement.CustomValue this$2;

                public void text(String s3)
                    throws SAXException
                {
                    if (TextUtils.isEmpty(s3))
                    {
                        break MISSING_BLOCK_LABEL_156;
                    }
                    s3 = s3.split("\\?");
                    if (s3.length != 3)
                    {
                        break MISSING_BLOCK_LABEL_139;
                    }
                    if ("10297".equals(attributeId))
                    {
                        recentlyViewedItems.add(new PdsViewItemAttribute(s3[2]));
                        return;
                    }
                    boolean flag = "10203".equals(attributeId);
                    if (!flag)
                    {
                        break MISSING_BLOCK_LABEL_156;
                    }
                    s3 = PdsSearchItemAttribute.parseSearchItem(s3[2]);
                    if (s3 == null)
                    {
                        break MISSING_BLOCK_LABEL_156;
                    }
                    recentSearches.add(s3);
                    return;
                    s3;
                    try
                    {
                        s3.printStackTrace();
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (String s3) { }
                    if (PdsGetAttributesResponse.logTag.isLoggable)
                    {
                        PdsGetAttributesResponse.logTag.logAsError("Unknown format for attribute value");
                        return;
                    }
                    break MISSING_BLOCK_LABEL_156;
                    if (PdsGetAttributesResponse.logTag.isLoggable)
                    {
                        PdsGetAttributesResponse.logTag.logAsError("Unknown format for attribute value");
                    }
                }

            
            {
                this$2 = PdsGetAttributesResponse.GetAttributesResponseElement.CustomValue.this;
                super();
            }
            };
        } else
        {
            return super.mValue(s, s1, s2, attributes);
        }
    }

    _cls1.this._cls2(String s)
    {
        this$1 = this._cls1.this;
        super();
        attributeId = s;
    }
}
