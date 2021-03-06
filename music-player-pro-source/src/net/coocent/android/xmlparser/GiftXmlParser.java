// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.coocent.android.xmlparser;

import android.content.Context;
import java.io.InputStream;
import java.util.ArrayList;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

// Referenced classes of package net.coocent.android.xmlparser:
//            GiftEntity

public class GiftXmlParser
{
    private class GiftParserHandler extends DefaultHandler
    {

        private GiftEntity currentGift;
        private ArrayList giftList;
        private String tagName;
        final GiftXmlParser this$0;

        public void characters(char ac[], int i, int j)
            throws SAXException
        {
            ac = new String(ac, i, j);
            if ("packagename".equals(tagName))
            {
                currentGift.setPackagename(ac);
            } else
            {
                if ("title".equals(tagName))
                {
                    currentGift.setTitle(ac);
                    return;
                }
                if ("icon_imagePath".equals(tagName))
                {
                    currentGift.setIcon_imagePath((new StringBuilder("http://www.coocent.net/coocentPromotion/yonggift/")).append(ac).toString());
                    return;
                }
            }
        }

        public void endElement(String s, String s1, String s2)
            throws SAXException
        {
            if ("gift".equals(s1) && !currentGift.getPackagename().equals(mContext.getPackageName()))
            {
                giftList.add(currentGift);
            }
            tagName = null;
        }

        public void startDocument()
            throws SAXException
        {
            giftList = new ArrayList();
        }

        public void startElement(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("gift".equals(s1))
            {
                currentGift = new GiftEntity();
                currentGift.setId(Integer.parseInt(attributes.getValue("id")));
            }
            tagName = s1;
        }


        private GiftParserHandler()
        {
            this$0 = GiftXmlParser.this;
            super();
        }

        GiftParserHandler(GiftParserHandler giftparserhandler)
        {
            this();
        }
    }


    private Context mContext;

    public GiftXmlParser(Context context)
    {
        mContext = context;
    }

    public ArrayList parse(InputStream inputstream)
        throws Exception
    {
        Object obj = null;
        if (inputstream != null)
        {
            obj = SAXParserFactory.newInstance().newSAXParser();
            GiftParserHandler giftparserhandler = new GiftParserHandler(null);
            ((SAXParser) (obj)).parse(inputstream, giftparserhandler);
            obj = giftparserhandler.giftList;
        }
        return ((ArrayList) (obj));
    }

}
