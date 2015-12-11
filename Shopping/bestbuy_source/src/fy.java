// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Xml;
import com.bestbuy.android.api.lib.models.capi.lookup.GiftCard;
import java.io.IOException;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class fy
{

    private static final String a = fy.getSimpleName();

    public fy()
    {
    }

    public static GiftCard a(ft ft1, String s, String s1)
    {
        Object obj = null;
        ft1 = a(ft1);
        ft1 = (new StringBuilder()).append(ft1.a()).append("/commerce/giftcard?apiKey=").append(ft1.b()).toString();
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Element element = document.createElement("balance-query");
        document.appendChild(element);
        Element element1 = document.createElement("gift-card");
        element1.setAttribute("card-num", s);
        element1.setAttribute("pin", s1);
        element.appendChild(element1);
        s = gw.b(ft1, null, null, hb.a(document), "application/xml");
        ft1 = obj;
        if (s != null)
        {
            ft1 = a(s);
        }
        return ft1;
    }

    private static GiftCard a(String s)
    {
        GiftCard giftcard;
        XmlPullParser xmlpullparser;
        giftcard = new GiftCard();
        xmlpullparser = Xml.newPullParser();
        int j;
        xmlpullparser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
        xmlpullparser.setInput(new StringReader(s));
        j = xmlpullparser.getEventType();
        int k = 0;
_L16:
        if (j == 1 || k != 0) goto _L2; else goto _L1
_L1:
        s = xmlpullparser.getName();
        int i = k;
        j;
        JVM INSTR tableswitch 0 3: default 288
    //                   0 292
    //                   1 316
    //                   2 100
    //                   3 244;
           goto _L3 _L4 _L5 _L6 _L7
_L6:
        i = k;
        if (!s.equals("gift-card")) goto _L4; else goto _L8
_L8:
        j = xmlpullparser.getAttributeCount();
        i = 0;
_L19:
        if (i >= j) goto _L10; else goto _L9
_L9:
        String s1;
        s = xmlpullparser.getAttributeName(i);
        s1 = xmlpullparser.getAttributeValue(i);
        if (!s.equals("card-num")) goto _L12; else goto _L11
_L11:
        giftcard.setCardNumber(s1);
          goto _L13
_L12:
        if (s.equals("currency"))
        {
            giftcard.setCurrency(s1);
        }
          goto _L13
        s;
        gs.a(a, s);
_L2:
        return giftcard;
_L10:
        s = xmlpullparser.nextText();
        i = k;
        if (s == null) goto _L4; else goto _L14
_L14:
        i = k;
        if (s.isEmpty()) goto _L4; else goto _L15
_L15:
        giftcard.setValue(Double.parseDouble(s));
        i = k;
          goto _L4
        s;
        gs.a(a, s);
        return giftcard;
_L7:
        i = k;
        if (s.equals("gift-card"))
        {
            i = 1;
        }
          goto _L4
_L18:
        j = xmlpullparser.next();
        k = i;
          goto _L16
        s;
        gs.a(a, s);
        return giftcard;
_L3:
        i = k;
_L4:
        if (i == 0) goto _L18; else goto _L17
_L17:
        j = 1;
        k = i;
          goto _L16
_L13:
        i++;
          goto _L19
_L5:
        i = 1;
          goto _L4
    }

    private static fz a(ft ft1)
    {
        if (ft1 == ft.a)
        {
            return fz.a;
        }
        if (ft1 == ft.b)
        {
            return fz.e;
        }
        if (ft1 == ft.e)
        {
            return fz.b;
        }
        if (ft1 == ft.g)
        {
            return fz.c;
        }
        if (ft1 == ft.h)
        {
            return fz.d;
        } else
        {
            return fz.a;
        }
    }

}
