// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shopping;

import com.ebay.nautilus.domain.data.VariationPictureSet;
import java.util.ArrayList;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shopping:
//            GetSingleItemResponse

class val.vps extends com.ebay.nautilus.kernel.util.ictureSet._cls2
{

    final val.vps this$2;
    final VariationPictureSet val$vps;

    public void text(String s)
        throws SAXException
    {
        val$vps.pictureUrls.add(s);
    }

    ()
    {
        this$2 = final_;
        val$vps = VariationPictureSet.this;
        super();
    }
}
