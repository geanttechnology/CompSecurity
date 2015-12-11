// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.favseller;

import com.ebay.common.model.favseller.FavoriteSeller;
import com.ebay.common.model.favseller.FavoriteSellers;
import com.ebay.common.util.EbayDateFormat;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.ErrorMessageElement;
import java.text.ParseException;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;

// Referenced classes of package com.ebay.common.net.api.favseller:
//            GetFavoriteSellers

private final class <init> extends com.ebay.nautilus.kernel.util.ent
{

    final this._cls1 this$1;

    public com.ebay.nautilus.kernel.util.ent get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("ack".equals(s1))
        {
            return new AckElement(this._cls1.this.<init>);
        }
        if ("version".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetFavoriteSellers.GetResponse.RootElement.ResponseElement this$2;

                public void text(String s3)
                    throws SAXException
                {
                    fs.version = s3;
                }

            
            {
                this$2 = GetFavoriteSellers.GetResponse.RootElement.ResponseElement.this;
                super();
            }
            };
        }
        if ("timestamp".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetFavoriteSellers.GetResponse.RootElement.ResponseElement this$2;

                public void text(String s3)
                    throws SAXException
                {
                    try
                    {
                        fs.timestamp = EbayDateFormat.parse(s3);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (String s3)
                    {
                        throw new SAXNotRecognizedException(s3.getLocalizedMessage());
                    }
                }

            
            {
                this$2 = GetFavoriteSellers.GetResponse.RootElement.ResponseElement.this;
                super();
            }
            };
        }
        if ("errorMessage".equals(s1))
        {
            return new ErrorMessageElement(_fld2, "http://www.ebay.com/marketplace/mobile/v1/services");
        }
        if ("seller".equals(s1))
        {
            s = new FavoriteSeller();
            _fld2.favSellersList.add(s);
            return new nit>(this._cls1.this, s);
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
