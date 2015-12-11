// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.pds;

import android.text.TextUtils;
import com.ebay.nautilus.domain.data.PdsSearchItemAttribute;
import com.ebay.nautilus.domain.data.PdsViewItemAttribute;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.pds:
//            PdsGetAttributesResponse

class this._cls2 extends com.ebay.nautilus.kernel.util.alue._cls1
{

    final tributeId this$2;

    public void text(String s)
        throws SAXException
    {
        if (TextUtils.isEmpty(s))
        {
            break MISSING_BLOCK_LABEL_156;
        }
        s = s.split("\\?");
        if (s.length != 3)
        {
            break MISSING_BLOCK_LABEL_139;
        }
        if ("10297".equals(tributeId))
        {
            recentlyViewedItems.add(new PdsViewItemAttribute(s[2]));
            return;
        }
        boolean flag = "10203".equals(tributeId);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_156;
        }
        s = PdsSearchItemAttribute.parseSearchItem(s[2]);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_156;
        }
        recentSearches.add(s);
        return;
        s;
        try
        {
            s.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        if (PdsGetAttributesResponse.logTag.attributeId)
        {
            PdsGetAttributesResponse.logTag.attributeId("Unknown format for attribute value");
            return;
        }
        break MISSING_BLOCK_LABEL_156;
        if (PdsGetAttributesResponse.logTag.attributeId)
        {
            PdsGetAttributesResponse.logTag.attributeId("Unknown format for attribute value");
        }
    }

    ()
    {
        this$2 = this._cls2.this;
        super();
    }
}
