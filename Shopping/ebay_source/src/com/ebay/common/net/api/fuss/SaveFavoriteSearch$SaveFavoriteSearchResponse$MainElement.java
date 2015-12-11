// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.fuss;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.fuss:
//            SaveFavoriteSearch

private final class <init> extends com.ebay.nautilus.kernel.util.init>
{

    public String id;
    boolean idParsed;
    final idParsed this$0;

    public com.ebay.nautilus.kernel.util.init> get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("searchId".equals(s1))
        {
            idParsed = true;
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final SaveFavoriteSearch.SaveFavoriteSearchResponse.MainElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    id = s3;
                }

            
            {
                this$1 = SaveFavoriteSearch.SaveFavoriteSearchResponse.MainElement.this;
                super();
            }
            };
        }
        if (idParsed)
        {
            idParsed(this._cls0.this, id);
            idParsed = false;
        }
        return super.dParsed(s, s1, s2, attributes);
    }

    private _cls1.this._cls1()
    {
        this$0 = this._cls0.this;
        super();
        idParsed = false;
    }

    idParsed(idParsed idparsed1)
    {
        this();
    }
}
