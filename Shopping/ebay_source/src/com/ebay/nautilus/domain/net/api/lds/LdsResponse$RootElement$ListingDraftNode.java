// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.lds;

import com.ebay.nautilus.domain.data.ListingDraft;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.lds:
//            LdsResponse

private final class <init> extends com.ebay.nautilus.kernel.util.ftNode
{

    final this._cls1 this$1;

    public com.ebay.nautilus.kernel.util.ftNode get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("field".equals(s1) || "metadata".equals(s1) || "recommendation".equals(s1))
        {
            return new <init>(this._cls1.this, s1);
        }
        if ("listing".equals(s1) && LdsResponse.access$400(_fld1).equals("publishListingDraftResponse"))
        {
            return new >(this._cls1.this, null);
        }
        if ("draftId".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final LdsResponse.RootElement.ListingDraftNode this$2;

                public void text(String s3)
                    throws SAXException
                {
                    draft.id = s3;
                }

            
            {
                this$2 = LdsResponse.RootElement.ListingDraftNode.this;
                super();
            }
            };
        }
        if ("listingMode".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final LdsResponse.RootElement.ListingDraftNode this$2;

                public void text(String s3)
                    throws SAXException
                {
                    draft.listingMode = s3;
                }

            
            {
                this$2 = LdsResponse.RootElement.ListingDraftNode.this;
                super();
            }
            };
        }
        if ("fees".equals(s1))
        {
            return new _cls2(this._cls1.this, null);
        }
        if ("lookUpFees".equals(s1))
        {
            return new (this._cls1.this, null);
        } else
        {
            return super._mth1(s, s1, s2, attributes);
        }
    }

    private _cls2.this._cls2()
    {
        this$1 = this._cls1.this;
        super();
    }

    this._cls1(this._cls1 _pcls1_1)
    {
        this();
    }
}
