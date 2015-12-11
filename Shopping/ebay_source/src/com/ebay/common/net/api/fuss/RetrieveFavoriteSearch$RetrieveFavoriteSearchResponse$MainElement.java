// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.fuss;

import com.ebay.common.model.search.SavedSearch;
import java.util.Locale;
import java.util.TreeMap;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.fuss:
//            RetrieveFavoriteSearch

private final class <init> extends com.ebay.nautilus.kernel.util.init>
{

    private boolean idParsed;
    private boolean nameParsed;
    private final SavedSearch savedSearch;
    final idParsed this$1;

    public com.ebay.nautilus.kernel.util.init> get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("searchId".equals(s1))
        {
            idParsed = true;
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final RetrieveFavoriteSearch.RetrieveFavoriteSearchResponse.MainElement this$2;

                public void text(String s3)
                    throws SAXException
                {
                    savedSearch.id = s3;
                }

            
            {
                this$2 = RetrieveFavoriteSearch.RetrieveFavoriteSearchResponse.MainElement.this;
                super();
            }
            };
        }
        if ("searchName".equals(s1))
        {
            nameParsed = true;
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final RetrieveFavoriteSearch.RetrieveFavoriteSearchResponse.MainElement this$2;

                public void text(String s3)
                    throws SAXException
                {
                    savedSearch.name = s3;
                }

            
            {
                this$2 = RetrieveFavoriteSearch.RetrieveFavoriteSearchResponse.MainElement.this;
                super();
            }
            };
        }
        if (idParsed && nameParsed)
        {
            nameParsed(this._cls1.this).put((new StringBuilder()).append(savedSearch.name.toLowerCase(Locale.getDefault())).append(savedSearch.id).toString(), savedSearch);
            nameParsed = false;
            idParsed = false;
        }
        return super.dParsed(s, s1, s2, attributes);
    }


    private _cls2.this._cls2()
    {
        this$1 = this._cls1.this;
        super();
        savedSearch = new SavedSearch(RetrieveFavoriteSearch.access$600(this._cls1.this.savedSearch), 25);
        idParsed = false;
        nameParsed = false;
    }

    nameParsed(nameParsed nameparsed1)
    {
        this();
    }
}
