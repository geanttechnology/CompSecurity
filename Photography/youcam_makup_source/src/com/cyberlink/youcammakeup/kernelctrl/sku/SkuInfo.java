// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.sku;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.database.more.i.d;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.a.g;
import com.cyberlink.youcammakeup.utility.av;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.sku:
//            h, f, c, a, 
//            b

public class SkuInfo
{

    private static String a = "SkuInfo";
    private Map A;
    private String B;
    private String C;
    private String D;
    private String E;
    private av F;
    private String G;
    private Map H;
    private d b;
    private Map c;
    private Map d;
    private Map e;
    private Map f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private d k;
    private String l;
    private String m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;
    private String s;
    private String t;
    private av u;
    private av v;
    private Map w;
    private Map x;
    private Map y;
    private Map z;

    public SkuInfo(d d1, boolean flag, d d2)
    {
        i = false;
        b = d1;
        j = flag;
        k = d2;
        l = null;
        m = null;
        n = null;
        o = null;
        p = null;
        q = null;
        r = null;
        s = null;
        t = null;
        H = null;
        c = new HashMap();
        d = new HashMap();
        e = new HashMap();
        f = new HashMap();
        w = new HashMap();
        x = new HashMap();
        y = new HashMap();
        z = new HashMap();
        A = new HashMap();
        c.put(DownloadType.b, Boolean.valueOf(false));
        d.put(DownloadType.b, Integer.valueOf(h.a));
        e.put(DownloadType.b, new f(this, DownloadType.b, new c(this), null));
        c.put(DownloadType.a, Boolean.valueOf(false));
        d.put(DownloadType.a, Integer.valueOf(h.a));
        e.put(DownloadType.a, new f(this, DownloadType.a, new a(this), new g()));
        c.put(DownloadType.c, Boolean.valueOf(false));
        d.put(DownloadType.c, Integer.valueOf(h.a));
        e.put(DownloadType.c, new f(this, DownloadType.c, new b(this), null));
        for (d1 = e.keySet().iterator(); d1.hasNext(); ((f)e.get(d2)).a())
        {
            d2 = (DownloadType)d1.next();
        }

    }

    static d a(SkuInfo skuinfo)
    {
        return skuinfo.b;
    }

    static String a(SkuInfo skuinfo, String s1, String s2)
    {
        return skuinfo.c(s1, s2);
    }

    private void a(DownloadType downloadtype)
    {
        c.put(downloadtype, Boolean.valueOf(false));
        com.cyberlink.youcammakeup.kernelctrl.sku.h.b().a(b.a(), b.d());
    }

    private void a(DownloadType downloadtype, String s1)
    {
        boolean flag3 = true;
        c.put(downloadtype, Boolean.valueOf(true));
        f.put(downloadtype, s1);
        if (!g)
        {
            boolean flag;
            boolean flag1;
            boolean flag2;
            if (c.containsKey(DownloadType.a))
            {
                flag1 = ((Boolean)c.get(DownloadType.a)).booleanValue();
            } else
            {
                flag1 = false;
            }
            if (c.containsKey(DownloadType.b))
            {
                flag2 = ((Boolean)c.get(DownloadType.b)).booleanValue();
            } else
            {
                flag2 = false;
            }
            if (flag1 && flag2)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            g = flag1;
            if (g && !i)
            {
                com.cyberlink.youcammakeup.kernelctrl.sku.h.b().a(b.b(), b.a());
            }
        }
        if (!h)
        {
            downloadtype = c.keySet().iterator();
            flag = true;
            while (downloadtype.hasNext()) 
            {
                s1 = (DownloadType)downloadtype.next();
                if (flag && ((Boolean)c.get(s1)).booleanValue())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
            }
            if (g && flag)
            {
                flag1 = flag3;
            } else
            {
                flag1 = false;
            }
            h = flag1;
            if (h && !i)
            {
                com.cyberlink.youcammakeup.kernelctrl.sku.h.b().a(b.b(), b.a(), b.d());
            }
        }
    }

    static void a(SkuInfo skuinfo, DownloadType downloadtype)
    {
        skuinfo.a(downloadtype);
    }

    static void a(SkuInfo skuinfo, DownloadType downloadtype, String s1)
    {
        skuinfo.a(downloadtype, s1);
    }

    static void a(SkuInfo skuinfo, File file)
    {
        skuinfo.a(file);
    }

    private void a(File file)
    {
        if (file.isDirectory())
        {
            File afile[] = file.listFiles();
            int j1 = afile.length;
            for (int i1 = 0; i1 < j1; i1++)
            {
                File file1 = afile[i1];
                file1.delete();
                a(file1);
            }

        }
        file.delete();
    }

    private void a(String s1, String s2)
    {
        Object obj;
        l = c(s1, "logo.png");
        m = c(s1, "look.png");
        n = c(s1, "menu.png");
        o = c(s1, "menu_popup_n.png");
        p = c(s1, "consultation_16to9.jpg");
        q = c(s1, "consultation_4to3.jpg");
        obj = null;
        s2 = new FileInputStream(s2);
        int l1;
        obj = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(s2);
        ((Document) (obj)).getDocumentElement().normalize();
        obj = ((Document) (obj)).getElementsByTagName("skus");
        l1 = ((NodeList) (obj)).getLength();
        int i1 = 0;
_L20:
        if (i1 >= l1) goto _L2; else goto _L1
_L1:
        NodeList nodelist;
        int i2;
        nodelist = ((Element)((NodeList) (obj)).item(i1)).getChildNodes();
        i2 = nodelist.getLength();
        int j1 = 0;
_L26:
        if (j1 >= i2) goto _L4; else goto _L3
_L3:
        Object obj1 = nodelist.item(j1);
        if (((Node) (obj1)).getNodeType() == 1 && ((Node) (obj1)).getNodeName().equals("sku")) goto _L6; else goto _L5
_L6:
        obj1 = (Element)obj1;
        if (!((Element) (obj1)).getAttribute("guid").equals(b.d())) goto _L5; else goto _L7
_L7:
        int j2;
        obj1 = ((Element) (obj1)).getChildNodes();
        j2 = ((NodeList) (obj1)).getLength();
        int k1 = 0;
_L27:
        if (k1 >= j2) goto _L5; else goto _L8
_L8:
        Object obj2 = ((NodeList) (obj1)).item(k1);
        if (!((Node) (obj2)).getNodeName().equals("image")) goto _L10; else goto _L9
_L9:
        Object obj3;
        Object obj4;
        obj3 = (Element)obj2;
        obj4 = ((Element) (obj3)).getAttribute("name");
        obj2 = c(s1, ((Element) (obj3)).getAttribute("path"));
        if (((String) (obj4)).equals("logo"))
        {
            l = ((String) (obj2));
            break MISSING_BLOCK_LABEL_1213;
        }
        if (((String) (obj4)).equals("look"))
        {
            m = ((String) (obj2));
            break MISSING_BLOCK_LABEL_1213;
        }
          goto _L11
        s1;
_L25:
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_381;
        }
        s2.close();
_L14:
        return;
_L11:
        if (((String) (obj4)).equals("menu"))
        {
            n = ((String) (obj2));
            break MISSING_BLOCK_LABEL_1213;
        }
          goto _L12
        s1;
_L24:
        if (s2 == null) goto _L14; else goto _L13
_L13:
        try
        {
            s2.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            return;
        }
_L12:
        if (((String) (obj4)).equals("menu_popup_n"))
        {
            o = ((String) (obj2));
            break MISSING_BLOCK_LABEL_1213;
        }
          goto _L15
        s1;
_L23:
        if (s2 == null) goto _L14; else goto _L16
_L16:
        try
        {
            s2.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            return;
        }
_L15:
        if (((String) (obj4)).equals("consultation_16to9"))
        {
            p = ((String) (obj2));
            break MISSING_BLOCK_LABEL_1213;
        }
          goto _L17
        s1;
_L22:
        if (s2 == null) goto _L14; else goto _L18
_L18:
        try
        {
            s2.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            return;
        }
_L17:
        if (((String) (obj4)).equals("consultation_4to3"))
        {
            q = ((String) (obj2));
            break MISSING_BLOCK_LABEL_1213;
        }
          goto _L19
        s1;
_L21:
        if (s2 != null)
        {
            try
            {
                s2.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s2) { }
        }
        throw s1;
_L19:
        if (((String) (obj4)).equals("item_thumbnail"))
        {
            obj3 = ((Element) (obj3)).getAttribute("item_guid");
            w.put(obj3, obj2);
            break MISSING_BLOCK_LABEL_1213;
        }
        if (((String) (obj4)).equals("item_palette_thumbnail"))
        {
            obj3 = ((Element) (obj3)).getAttribute("item_guid");
            x.put(obj3, obj2);
        }
        break MISSING_BLOCK_LABEL_1213;
_L10:
        if (!((Node) (obj2)).getNodeName().equals("button"))
        {
            break MISSING_BLOCK_LABEL_786;
        }
        obj2 = (Element)obj2;
        obj3 = ((Element) (obj2)).getAttribute("name");
        obj4 = ((Element) (obj2)).getAttribute("action");
        if (((String) (obj3)).equals("room_promo_icon"))
        {
            r = ((String) (obj4));
            break MISSING_BLOCK_LABEL_1213;
        }
        if (!((String) (obj3)).equals("product_left"))
        {
            break MISSING_BLOCK_LABEL_721;
        }
        s = ((String) (obj4));
        obj2 = ((Element) (obj2)).getChildNodes().item(0);
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_1213;
        }
        if (((Node) (obj2)).getNodeName().equals("title"))
        {
            u = av.a(((Node) (obj2)));
        }
        break MISSING_BLOCK_LABEL_1213;
        if (!((String) (obj3)).equals("product_right"))
        {
            break MISSING_BLOCK_LABEL_1213;
        }
        t = ((String) (obj4));
        obj2 = ((Element) (obj2)).getChildNodes().item(0);
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_1213;
        }
        if (((Node) (obj2)).getNodeName().equals("title"))
        {
            v = av.a(((Node) (obj2)));
        }
        break MISSING_BLOCK_LABEL_1213;
        if (((Node) (obj2)).getNodeName().equals("input"))
        {
            obj4 = (Element)obj2;
            obj2 = ((Element) (obj4)).getAttribute("name");
            obj3 = ((Element) (obj4)).getAttribute("item_guid");
            obj4 = ((Element) (obj4)).getAttribute("hidden");
            if ("item_intensity_slider".equals(obj2))
            {
                A.put(obj3, Boolean.valueOf(Boolean.parseBoolean(((String) (obj4)))));
            }
            break MISSING_BLOCK_LABEL_1213;
        }
        if (!((Node) (obj2)).getNodeName().equals("display_color"))
        {
            break MISSING_BLOCK_LABEL_953;
        }
        obj3 = (Element)obj2;
        obj2 = ((Element) (obj3)).getAttribute("item_guid");
        obj3 = ((Element) (obj3)).getAttribute("color_list");
        if (obj2 == null || obj3 == null)
        {
            break MISSING_BLOCK_LABEL_1213;
        }
        y.put(obj2, obj3);
        break MISSING_BLOCK_LABEL_1213;
        if (!((Node) (obj2)).getNodeName().equals("text"))
        {
            break MISSING_BLOCK_LABEL_1213;
        }
        obj4 = (Element)obj2;
        obj2 = ((Element) (obj4)).getAttribute("name");
        if (((String) (obj2)).equals("item_name"))
        {
            obj3 = ((Element) (obj4)).getAttribute("item_guid");
            obj4 = ((Element) (obj4)).getAttribute("value");
            if (!z.containsKey(obj3))
            {
                z.put(obj3, new HashMap());
            }
            ((Map)z.get(obj3)).put(obj2, obj4);
            break MISSING_BLOCK_LABEL_1213;
        }
        if (b != null)
        {
            obj3 = ((Element) (obj4)).getAttribute("path");
            obj3 = b.a(((String) (obj3)));
            if (H == null)
            {
                H = new HashMap();
            }
            H.put(obj2, obj3);
        }
        break MISSING_BLOCK_LABEL_1213;
_L4:
        i1++;
          goto _L20
_L2:
        if (s2 != null)
        {
            try
            {
                s2.close();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s1)
            {
                return;
            }
        }
          goto _L14
        s1;
        return;
        s1;
        s2 = null;
          goto _L21
        s1;
        s2 = null;
          goto _L22
        s1;
        s2 = null;
          goto _L23
        s1;
        s2 = null;
          goto _L24
        s1;
        s2 = ((String) (obj));
          goto _L25
_L5:
        j1++;
          goto _L26
        k1++;
          goto _L27
    }

    static void b(SkuInfo skuinfo, String s1, String s2)
    {
        skuinfo.a(s1, s2);
    }

    private void b(String s1, String s2)
    {
        Object obj;
        B = c(s1, "logo.png");
        C = c(s1, "try_16to9.jpg");
        D = c(s1, "try_4to3.jpg");
        obj = null;
        s2 = new FileInputStream(s2);
        int l1;
        obj = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(s2);
        ((Document) (obj)).getDocumentElement().normalize();
        obj = ((Document) (obj)).getElementsByTagName("skus");
        l1 = ((NodeList) (obj)).getLength();
        int i1 = 0;
_L18:
        if (i1 >= l1) goto _L2; else goto _L1
_L1:
        NodeList nodelist;
        int i2;
        nodelist = ((Element)((NodeList) (obj)).item(i1)).getChildNodes();
        i2 = nodelist.getLength();
        int j1 = 0;
_L26:
        if (j1 >= i2) goto _L4; else goto _L3
_L3:
        Object obj1 = nodelist.item(j1);
        if (((Node) (obj1)).getNodeType() == 1 && ((Node) (obj1)).getNodeName().equals("sku")) goto _L6; else goto _L5
_L6:
        obj1 = (Element)obj1;
        if (!((Element) (obj1)).getAttribute("guid").equals(b.d())) goto _L5; else goto _L7
_L7:
        int j2;
        obj1 = ((Element) (obj1)).getChildNodes();
        j2 = ((NodeList) (obj1)).getLength();
        int k1 = 0;
_L27:
        if (k1 >= j2) goto _L5; else goto _L8
_L8:
        Object obj2 = ((NodeList) (obj1)).item(k1);
        if (!((Node) (obj2)).getNodeName().equals("image")) goto _L10; else goto _L9
_L9:
        Object obj3;
        obj3 = (Element)obj2;
        obj2 = ((Element) (obj3)).getAttribute("name");
        obj3 = c(s1, ((Element) (obj3)).getAttribute("path"));
        if (((String) (obj2)).equals("logo"))
        {
            B = ((String) (obj3));
            break MISSING_BLOCK_LABEL_610;
        }
        if (((String) (obj2)).equals("try_16to9"))
        {
            C = ((String) (obj3));
            break MISSING_BLOCK_LABEL_610;
        }
          goto _L11
        s1;
_L25:
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_345;
        }
        s2.close();
_L13:
        return;
_L11:
        if (((String) (obj2)).equals("try_4to3"))
        {
            D = ((String) (obj3));
        }
        break MISSING_BLOCK_LABEL_610;
        s1;
_L24:
        if (s2 == null) goto _L13; else goto _L12
_L12:
        try
        {
            s2.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            return;
        }
_L10:
        String s3;
        if (!((Node) (obj2)).getNodeName().equals("button"))
        {
            break MISSING_BLOCK_LABEL_610;
        }
        obj2 = (Element)obj2;
        obj3 = ((Element) (obj2)).getAttribute("name");
        s3 = ((Element) (obj2)).getAttribute("action");
        if (!((String) (obj3)).equals("product_right")) goto _L15; else goto _L14
_L14:
        E = s3;
        obj2 = ((Element) (obj2)).getChildNodes().item(0);
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_610;
        }
        if (((Node) (obj2)).getNodeName().equals("title"))
        {
            F = av.a(((Node) (obj2)));
        }
        break MISSING_BLOCK_LABEL_610;
        s1;
_L23:
        if (s2 == null) goto _L13; else goto _L16
_L16:
        try
        {
            s2.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            return;
        }
_L15:
        if (((String) (obj3)).equals("product_try_it"))
        {
            G = s3;
        }
        break MISSING_BLOCK_LABEL_610;
        s1;
_L22:
        if (s2 == null) goto _L13; else goto _L17
_L17:
        try
        {
            s2.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            return;
        }
_L4:
        i1++;
          goto _L18
_L2:
        if (s2 == null) goto _L13; else goto _L19
_L19:
        try
        {
            s2.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            return;
        }
        s1;
        s2 = null;
_L21:
        if (s2 != null)
        {
            try
            {
                s2.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s2) { }
        }
        throw s1;
        s1;
        return;
        s1;
        if (true) goto _L21; else goto _L20
_L20:
        s1;
        s2 = null;
          goto _L22
        s1;
        s2 = null;
          goto _L23
        s1;
        s2 = null;
          goto _L24
        s1;
        s2 = ((String) (obj));
          goto _L25
_L5:
        j1++;
          goto _L26
        k1++;
          goto _L27
    }

    static boolean b(SkuInfo skuinfo)
    {
        return skuinfo.j;
    }

    static d c(SkuInfo skuinfo)
    {
        return skuinfo.k;
    }

    private String c(String s1, String s2)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(s1);
        stringbuilder.append(Globals.c);
        stringbuilder.append(s2);
        return stringbuilder.toString();
    }

    static void c(SkuInfo skuinfo, String s1, String s2)
    {
        skuinfo.b(s1, s2);
    }

    private String f(String s1)
    {
        if (H == null)
        {
            return "";
        }
        if (!H.containsKey(s1))
        {
            return "";
        } else
        {
            return (String)H.get(s1);
        }
    }

    public d a()
    {
        return b;
    }

    public String a(String s1)
    {
        if (w.containsKey(s1))
        {
            return (String)w.get(s1);
        } else
        {
            return "";
        }
    }

    public String b(String s1)
    {
        if (x.containsKey(s1))
        {
            return (String)x.get(s1);
        } else
        {
            return "";
        }
    }

    public void b()
    {
        i = true;
    }

    public String c()
    {
        return l;
    }

    public String c(String s1)
    {
        if (y.containsKey(s1))
        {
            return (String)y.get(s1);
        } else
        {
            return "";
        }
    }

    public String d()
    {
        return m;
    }

    public boolean d(String s1)
    {
        if (A.containsKey(s1))
        {
            return ((Boolean)A.get(s1)).booleanValue();
        } else
        {
            return false;
        }
    }

    public String e()
    {
        return n;
    }

    public String e(String s1)
    {
        if (z == null || !z.containsKey(s1))
        {
            return "";
        }
        s1 = (Map)z.get(s1);
        if (s1 == null || !s1.containsKey("item_name"))
        {
            return "";
        } else
        {
            return (String)s1.get("item_name");
        }
    }

    public String f()
    {
        return o;
    }

    public String g()
    {
        DisplayMetrics displaymetrics = Globals.d().getResources().getDisplayMetrics();
        float f1 = (float)displaymetrics.heightPixels / (float)displaymetrics.widthPixels;
        float f2 = Math.abs(1.777778F - f1);
        if (Math.abs(1.333333F - f1) < f2)
        {
            return q;
        } else
        {
            return p;
        }
    }

    public String h()
    {
        return r;
    }

    public String i()
    {
        return s;
    }

    public String j()
    {
        return t;
    }

    public av k()
    {
        return u;
    }

    public av l()
    {
        return v;
    }

    public String m()
    {
        return B;
    }

    public String n()
    {
        return E;
    }

    public av o()
    {
        return F;
    }

    public String p()
    {
        return G;
    }

    public String q()
    {
        DisplayMetrics displaymetrics = Globals.d().getResources().getDisplayMetrics();
        float f1 = (float)displaymetrics.heightPixels / (float)displaymetrics.widthPixels;
        float f2 = Math.abs(1.777778F - f1);
        if (Math.abs(1.333333F - f1) < f2)
        {
            return D;
        } else
        {
            return C;
        }
    }

    public void r()
    {
        if (!((Boolean)c.get(DownloadType.b)).booleanValue())
        {
            ((f)e.get(DownloadType.b)).b();
        }
        if (!((Boolean)c.get(DownloadType.a)).booleanValue())
        {
            ((f)e.get(DownloadType.a)).b();
        }
        if (!((Boolean)c.get(DownloadType.c)).booleanValue())
        {
            ((f)e.get(DownloadType.c)).b();
        }
    }

    public String s()
    {
        return f("menu");
    }

    public String t()
    {
        return f("menu_popup_n");
    }

    public String u()
    {
        return f("look");
    }


    private class DownloadType extends Enum
    {

        public static final DownloadType a;
        public static final DownloadType b;
        public static final DownloadType c;
        private static final DownloadType d[];

        public static DownloadType valueOf(String s1)
        {
            return (DownloadType)Enum.valueOf(com/cyberlink/youcammakeup/kernelctrl/sku/SkuInfo$DownloadType, s1);
        }

        public static DownloadType[] values()
        {
            return (DownloadType[])d.clone();
        }

        static 
        {
            a = new DownloadType("Content_Zip", 0);
            b = new DownloadType("Image_Zip", 1);
            c = new DownloadType("DFP_Zip", 2);
            d = (new DownloadType[] {
                a, b, c
            });
        }

        private DownloadType(String s1, int i1)
        {
            super(s1, i1);
        }
    }

}
