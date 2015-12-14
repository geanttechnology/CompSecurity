// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.collageComposer;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Color;
import com.pf.common.utility.m;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.collageComposer:
//            q, o, s, t, 
//            u, r

public class v
{

    public Context a;
    String b;

    public v(Context context)
    {
        b = "CollageTemplateParser";
        a = context;
    }

    private int a(String s1)
    {
        if (s1 == null)
        {
            return 0;
        } else
        {
            return Integer.parseInt(s1);
        }
    }

    private int b(String s1)
    {
        if (s1 == null)
        {
            return 0;
        } else
        {
            return Color.parseColor(s1);
        }
    }

    private q c(String s1)
    {
        if (s1 != null)
        {
            if ((s1 = s1.split(",")).length == 4)
            {
                q q1 = new q();
                q1.a = a(s1[0]);
                q1.b = a(s1[1]);
                q1.c = a(s1[2]);
                q1.d = a(s1[3]);
                return q1;
            }
        }
        return null;
    }

    public o a(String s1, String s2)
    {
        o o1;
        boolean flag;
        flag = false;
        m.e(b, "parseTemplate");
        o1 = new o();
        s2 = s1.concat(s2);
        if (s1.indexOf("assets://") != 0) goto _L2; else goto _L1
_L1:
        s2 = a.getAssets().open(s2.substring("assets://".length()));
_L13:
        String s3 = s2;
        Object obj = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(s2);
        s3 = s2;
        ((Document) (obj)).getDocumentElement().normalize();
        s3 = s2;
        obj = (Element)((Document) (obj)).getElementsByTagName("collage").item(0);
        s3 = s2;
        Object obj1 = ((Element) (obj)).getAttribute("guid");
        s3 = s2;
        o1.b = s1;
        s3 = s2;
        o1.a = UUID.fromString(((String) (obj1)));
        s3 = s2;
        o1.c = ((Element) (obj)).getAttribute("thumbImage");
        s3 = s2;
        o1.d = ((Element) (obj)).getAttribute("bgImage");
        s3 = s2;
        o1.h = b(((Element) (obj)).getAttribute("bgColor"));
        s3 = s2;
        o1.e = ((Element) (obj)).getAttribute("coverImage");
        s3 = s2;
        o1.f = ((Element) (obj)).getAttribute("coverMask");
        s3 = s2;
        o1.g = ((Element) (obj)).getAttribute("globalMask");
        s3 = s2;
        o1.i = a(((Element) (obj)).getAttribute("width"));
        s3 = s2;
        o1.j = a(((Element) (obj)).getAttribute("height"));
        s3 = s2;
        o1.k = ((Element) (obj)).getAttribute("type");
        s3 = s2;
        s1 = ((Element) (obj)).getChildNodes();
        s3 = s2;
        m.e(b, (new StringBuilder()).append("childNodes number ").append(s1.getLength()).toString());
        s3 = s2;
        o1.l = new ArrayList();
        int i = 0;
_L23:
        s3 = s2;
        if (i >= s1.getLength()) goto _L4; else goto _L3
_L3:
        s3 = s2;
        obj = s1.item(i);
        s3 = s2;
        if (((Node) (obj)).getNodeType() != 1) goto _L6; else goto _L5
_L5:
        s3 = s2;
        obj1 = (Element)obj;
        s3 = s2;
        m.e(b, (new StringBuilder()).append("Node name ").append(((Element) (obj1)).getNodeName()).toString());
        s3 = s2;
        if (!((Element) (obj1)).getNodeName().equals("image")) goto _L8; else goto _L7
_L7:
        s3 = s2;
        if (!((Element) (obj1)).getAttribute("type").equals("dynamic")) goto _L10; else goto _L9
_L9:
        s3 = s2;
        obj = new s();
        s3 = s2;
        obj.a = c(((Element) (obj1)).getAttribute("layout"));
        s3 = s2;
        obj.b = a(((Element) (obj1)).getAttribute("zIndex"));
        s3 = s2;
        obj1 = ((Element) (obj1)).getElementsByTagName("imageMask");
        int j = 0;
_L12:
        s3 = s2;
        if (j >= ((NodeList) (obj1)).getLength())
        {
            break; /* Loop/switch isn't completed */
        }
        s3 = s2;
        Element element = (Element)((NodeList) (obj1)).item(j);
        s3 = s2;
        t t1 = new t();
        s3 = s2;
        t1.a = element.getAttribute("src");
        s3 = s2;
        t1.b = c(element.getAttribute("layout"));
        s3 = s2;
        ((s) (obj)).c.add(t1);
        j++;
        if (true) goto _L12; else goto _L11
_L2:
        s2 = new FileInputStream(s2);
          goto _L13
        s2;
        s1 = null;
_L24:
        s2.printStackTrace();
        i = ((flag) ? 1 : 0);
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_681;
        }
        s1.close();
        i = ((flag) ? 1 : 0);
_L17:
        if (i != 0)
        {
            return o1;
        } else
        {
            return null;
        }
_L11:
        s3 = s2;
        o1.l.add(obj);
          goto _L6
_L10:
        s3 = s2;
        obj = new u();
        s3 = s2;
        obj.a = c(((Element) (obj1)).getAttribute("layout"));
        s3 = s2;
        obj.b = a(((Element) (obj1)).getAttribute("zIndex"));
        s3 = s2;
        obj.c = "<TODO>";
        s3 = s2;
        o1.l.add(obj);
          goto _L6
_L8:
        s3 = s2;
        if (!((Element) (obj1)).getNodeName().equals("text")) goto _L6; else goto _L14
_L14:
        s3 = s2;
        if (!((Element) (obj1)).getAttribute("type").equals("datetime")) goto _L6; else goto _L15
_L15:
        s3 = s2;
        obj = new r();
        s3 = s2;
        obj.a = c(((Element) (obj1)).getAttribute("layout"));
        s3 = s2;
        obj.b = a(((Element) (obj1)).getAttribute("zIndex"));
        s3 = s2;
        obj.c = ((Element) (obj1)).getAttribute("fontFamily");
        s3 = s2;
        obj.d = ((Element) (obj1)).getAttribute("fontStyle");
        s3 = s2;
        obj.e = ((Element) (obj1)).getAttribute("format");
        s3 = s2;
        obj.f = a(((Element) (obj1)).getAttribute("size"));
        s3 = s2;
        obj.g = b(((Element) (obj1)).getAttribute("color"));
        s3 = s2;
        obj.h = ((Element) (obj1)).getAttribute("align");
        s3 = s2;
        o1.l.add(obj);
          goto _L6
        s1;
_L22:
        s3 = s2;
        s1.printStackTrace();
        i = ((flag) ? 1 : 0);
        if (s2 == null) goto _L17; else goto _L16
_L16:
        s2.close();
        i = ((flag) ? 1 : 0);
          goto _L17
        s1;
        s1.printStackTrace();
        i = ((flag) ? 1 : 0);
          goto _L17
_L4:
        s3 = s2;
        s2.close();
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_1057;
        }
        s2.close();
        i = 1;
          goto _L17
        i = 0;
          goto _L17
        s1;
        s1.printStackTrace();
        i = 1;
          goto _L17
        s1;
        s1.printStackTrace();
        i = ((flag) ? 1 : 0);
          goto _L17
        s1;
        s2 = null;
_L21:
        s3 = s2;
        s1.printStackTrace();
        i = ((flag) ? 1 : 0);
        if (s2 == null) goto _L17; else goto _L18
_L18:
        s2.close();
        i = ((flag) ? 1 : 0);
          goto _L17
        s1;
        s1.printStackTrace();
        i = ((flag) ? 1 : 0);
          goto _L17
        s1;
        s3 = null;
_L20:
        if (s3 != null)
        {
            try
            {
                s3.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s2)
            {
                s2.printStackTrace();
            }
        }
        throw s1;
        s1;
        continue; /* Loop/switch isn't completed */
        s2;
        s3 = s1;
        s1 = s2;
        if (true) goto _L20; else goto _L19
_L19:
        s1;
          goto _L21
        s1;
        s2 = null;
          goto _L22
_L6:
        i++;
          goto _L23
        ParserConfigurationException parserconfigurationexception;
        parserconfigurationexception;
        s1 = s2;
        s2 = parserconfigurationexception;
          goto _L24
    }
}
