// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Point;
import android.os.AsyncTask;
import android.os.Environment;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.database.more.DatabaseUpgradeHelper;
import com.cyberlink.youcammakeup.database.more.d.a;
import com.cyberlink.youcammakeup.database.more.d.b;
import com.cyberlink.youcammakeup.database.more.h.c;
import com.cyberlink.youcammakeup.database.more.h.d;
import com.cyberlink.youcammakeup.database.more.h.f;
import com.cyberlink.youcammakeup.database.more.i.e;
import com.cyberlink.youcammakeup.database.more.makeup.MakeupItemMetadata;
import com.cyberlink.youcammakeup.h;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import com.pf.common.utility.m;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

// Referenced classes of package com.cyberlink.youcammakeup.utility:
//            ap, av, ao, an, 
//            as, au, at, ba, 
//            SkuTemplateUtils, aw, bs, br, 
//            bt, BeautyMode, bq, bp, 
//            bu, ax, ar

public class bo
{

    public static final String a = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getAbsolutePath()).append("/cyberlink/ymk/testcontent.config").toString();
    public static final String b = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getAbsolutePath()).append("/cyberlink/ymk/puretestcontent.config").toString();
    public static final String c = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getAbsolutePath()).append("/cyberlink/ymk/looks/").toString();
    protected static float d = 0.0F;
    protected static final String e[] = {
        "eye_brow", "eye_shadow", "eye_line", "eye_lash", "eye_contact", "eye_lid", "lipstick", "blush", "skin_toner", "wig", 
        "eye_wear", "hair_band", "necklace", "earrings", "hair_dye", "face_art", "mustache"
    };
    public static final AssetManager f = Globals.d().getAssets();
    private static String g = null;
    private static String h = null;
    private static String i = null;
    private static String j = null;
    private static String k = null;
    private static aw l = null;

    static ao A(String s1)
    {
        a a1;
        BeautyMode beautymode;
        String s2;
        ap ap1;
        List list;
        int i1;
        int j1;
        a1 = com.cyberlink.youcammakeup.h.m().a(s1);
        beautymode = b(a1.d());
        s2 = a1.c();
        list = x(a1.f());
        ap1 = new ap();
        i1 = d(a1.h());
        j1 = d(a1.i());
        JSONObject jsonobject;
        jsonobject = new JSONObject(a1.l());
        s1 = jsonobject.optString("palette_guid");
        if (s1.equals(""))
        {
            s1 = null;
        }
        ap1.a = s1;
        ap1.b = c(jsonobject.optString("version"));
_L2:
        if (ap1.a != null && !f(ap1.a))
        {
            s1 = new com.cyberlink.youcammakeup.database.more.g.a(ap1.a, a1.f(), list.size(), com.cyberlink.youcammakeup.utility.av.b(new av()).toString(), "", com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.a.name(), ap1.b, 0, false, "", "", a1.d(), "", "", "", "");
            com.cyberlink.youcammakeup.h.j().a(s1);
        }
        list = x(a1.f());
        if (s2 != null)
        {
            s1 = v(s2);
        } else
        {
            s1 = null;
        }
        return new ao(beautymode, s2, list, s1, i1, j1, a1.j(), ap1);
        s1;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static void B(String s1)
    {
        g = s1;
    }

    static boolean C(String s1)
    {
        return D(s1);
    }

    private static boolean D(String s1)
    {
        if (s1 != null)
        {
            if (s1.equalsIgnoreCase("wig"))
            {
                return true;
            }
            if (s1.equalsIgnoreCase("mustache"))
            {
                return true;
            }
        }
        return false;
    }

    public static as a(MakeupItemMetadata makeupitemmetadata)
    {
        boolean flag = true;
        av av1 = new av();
        av1.o = makeupitemmetadata.c();
        an an1 = new an();
        an1.o = makeupitemmetadata.e();
        String s1 = makeupitemmetadata.f().toString();
        String s2 = makeupitemmetadata.g().toString();
        if (makeupitemmetadata.k())
        {
            flag = false;
        }
        return new as(makeupitemmetadata.m(), s1, s2, Float.valueOf(1.0F).floatValue(), av1, an1, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.b, Boolean.valueOf(true), new ArrayList(), Boolean.valueOf(true), makeupitemmetadata, Boolean.valueOf(flag));
    }

    static at a(com.cyberlink.youcammakeup.database.more.b.a a1)
    {
        int ai[];
        Object obj;
        com.cyberlink.youcammakeup.kernelctrl.sku.h h1;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        boolean flag;
        boolean flag1;
        h1 = com.cyberlink.youcammakeup.kernelctrl.sku.h.b();
        k2 = Color.parseColor((new StringBuilder()).append("#").append(a1.b()).toString());
        l2 = Integer.parseInt(a1.c());
        l1 = 0;
        i2 = 0;
        flag1 = false;
        j2 = 0;
        obj = a1.d();
        ai = null;
        k1 = l1;
        j1 = i2;
        flag = flag1;
        i1 = j2;
        obj = new JSONObject(((String) (obj)));
        k1 = l1;
        j1 = i2;
        flag = flag1;
        i1 = j2;
        l1 = d(((JSONObject) (obj)).optString("level_max"));
        k1 = l1;
        j1 = i2;
        flag = flag1;
        i1 = j2;
        i2 = d(((JSONObject) (obj)).optString("level_default"));
        k1 = l1;
        j1 = i2;
        flag = flag1;
        i1 = j2;
        flag1 = ((JSONObject) (obj)).optBoolean("is_shimmer", false);
        k1 = l1;
        j1 = i2;
        flag = flag1;
        i1 = j2;
        j2 = d(((JSONObject) (obj)).optString("shimmer_intensity"));
        k1 = l1;
        j1 = i2;
        flag = flag1;
        i1 = j2;
        int ai1[] = com.cyberlink.youcammakeup.utility.au.b(((JSONObject) (obj)).optString("engine_color", ""));
        ai = ai1;
        i1 = j2;
        flag = flag1;
        j1 = i2;
        k1 = l1;
_L1:
        ai1 = a1.e();
        if (ai1 != null)
        {
            a1 = com.cyberlink.youcammakeup.h.x().b(ai1);
        } else
        {
            a1 = null;
        }
        if (a1 == null)
        {
            break MISSING_BLOCK_LABEL_422;
        }
        if (h1.m(a1.a(), a1.e()))
        {
            return new at(k2, l2, ai1, k1, j1, flag, i1, ai);
        }
        break MISSING_BLOCK_LABEL_320;
        ai1;
        com.pf.common.utility.m.e("TemplateUtils", ai1.toString());
          goto _L1
        e e1 = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().a(a1.e(), a1.a(), ai1);
        String s1 = a1.a();
        String s2 = a1.b();
        String s3;
        if (a1.c().isEmpty())
        {
            ai1 = null;
        } else
        {
            ai1 = a1.c();
        }
        s3 = a1.d();
        a1 = a1.e();
        if (e1 != null)
        {
            flag = e1.e();
        } else
        {
            flag = false;
        }
        return new ba(s1, s2, ai1, s3, a1, k2, l2, k1, j1, flag, ai);
        if (ai1.equals(""))
        {
            return new at(k2, l2, null, k1, j1, flag, i1, ai);
        } else
        {
            return new at(k2, l2, ai1, k1, j1, flag, i1, ai);
        }
    }

    static aw a(String s1, Boolean boolean1)
    {
        aw aw1 = null;
        if ("default_original_hair_dye".equalsIgnoreCase(s1))
        {
            aw1 = t();
        } else
        {
            com.cyberlink.youcammakeup.database.more.g.a a1 = com.cyberlink.youcammakeup.h.j().a(s1);
            if (a1 != null)
            {
                ArrayList arraylist = new ArrayList();
                s1 = ((List)com.cyberlink.youcammakeup.h.n().a(s1, null)).iterator();
                do
                {
                    if (!s1.hasNext())
                    {
                        break;
                    }
                    String s2 = (String)s1.next();
                    if (!arraylist.contains(s2))
                    {
                        arraylist.add(s2);
                    }
                } while (true);
                int i1 = a1.c();
                s1 = PanelDataCenter.SourceType.valueOf(a1.f());
                Boolean boolean2 = Boolean.valueOf(a1.j());
                float f1 = a1.i();
                av av1 = com.cyberlink.youcammakeup.utility.av.a(a1.d());
                String s3 = a1.e();
                String s4 = a1.h();
                String s5 = a1.k();
                String s6 = com.cyberlink.youcammakeup.utility.SkuTemplateUtils.a(b(a1.g()));
                com.cyberlink.youcammakeup.kernelctrl.sku.h h1 = com.cyberlink.youcammakeup.kernelctrl.sku.h.b();
                if (!boolean1.booleanValue() && h1.m(s5, s6))
                {
                    s1 = new aw(a1.a(), a1.b(), i1, arraylist, av1, s3, null, s1, f1, boolean2, null);
                } else
                {
                    s1 = new aw(a1.a(), a1.b(), i1, arraylist, av1, s3, s4, s1, f1, boolean2, s5);
                }
                return s1;
            }
        }
        return aw1;
    }

    public static br a(String s1, String s2, PanelDataCenter.SourceType sourcetype)
    {
        sourcetype = new bs();
        sourcetype.d = com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.b;
        sourcetype.b = s1;
        sourcetype.c = s2;
        s1 = new br();
        (new bt(sourcetype, s1)).a();
        if (((br) (s1)).c == null)
        {
            a(((br) (s1)));
        }
        return s1;
    }

    public static String a(BeautyMode beautymode)
    {
        if (beautymode == com.cyberlink.youcammakeup.utility.BeautyMode.m)
        {
            return "eye_lash";
        }
        if (beautymode == BeautyMode.l)
        {
            return "eye_line";
        }
        if (beautymode == BeautyMode.n)
        {
            return "eye_shadow";
        }
        if (beautymode == BeautyMode.r)
        {
            return "eye_brow";
        }
        if (beautymode == BeautyMode.s)
        {
            return "eye_contact";
        }
        if (beautymode == com.cyberlink.youcammakeup.utility.BeautyMode.a)
        {
            return "blush";
        }
        if (beautymode == com.cyberlink.youcammakeup.utility.BeautyMode.b)
        {
            return "skin_toner";
        }
        if (beautymode == BeautyMode.v)
        {
            return "lipstick";
        }
        if (beautymode == BeautyMode.o)
        {
            return "eye_enlarge";
        }
        if (beautymode == BeautyMode.p)
        {
            return "eye_bag";
        }
        if (beautymode == BeautyMode.t)
        {
            return "eye_lid";
        }
        if (beautymode == com.cyberlink.youcammakeup.utility.BeautyMode.c)
        {
            return "anti_shine";
        }
        if (beautymode == com.cyberlink.youcammakeup.utility.BeautyMode.d)
        {
            return "skin_smooth";
        }
        if (beautymode == BeautyMode.g)
        {
            return "face_contour";
        }
        if (beautymode == com.cyberlink.youcammakeup.utility.BeautyMode.h)
        {
            return "face_reshaper";
        }
        if (beautymode == com.cyberlink.youcammakeup.utility.BeautyMode.f)
        {
            return "nose_enhancement";
        }
        if (beautymode == BeautyMode.w)
        {
            return "teeth_whitener";
        }
        if (beautymode == BeautyMode.q)
        {
            return "red_eye_Removal";
        }
        if (beautymode == com.cyberlink.youcammakeup.utility.BeautyMode.e)
        {
            return "blemish_removal";
        }
        if (beautymode == BeautyMode.x)
        {
            return "wig";
        }
        if (beautymode == com.cyberlink.youcammakeup.utility.BeautyMode.z)
        {
            return "eye_wear";
        }
        if (beautymode == BeautyMode.A)
        {
            return "hair_band";
        }
        if (beautymode == BeautyMode.B)
        {
            return "necklace";
        }
        if (beautymode == BeautyMode.C)
        {
            return "earrings";
        }
        if (beautymode == BeautyMode.y)
        {
            return "hair_dye";
        }
        if (beautymode == BeautyMode.j)
        {
            return "face_art";
        }
        if (beautymode == BeautyMode.k)
        {
            return "mustache";
        } else
        {
            return "eye_enlarge";
        }
    }

    static String a(aw aw1, String s1, List list)
    {
        if (aw1 != null && list != null && list.size() >= aw1.b()) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        String s2;
        String s3;
        boolean flag;
        int k1;
        s2 = UUID.randomUUID().toString();
        s1 = UUID.randomUUID().toString();
        s3 = com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.c.name();
        k1 = aw1.b();
        int i1 = 0;
        flag = true;
        while (i1 < aw1.b()) 
        {
            Object obj = com.cyberlink.youcammakeup.utility.au.a(0, 0, ((at)list.get(i1)).k(), ((at)list.get(i1)).j(), "");
            obj = new com.cyberlink.youcammakeup.database.more.b.a(s1, "eye_shadow", e(((at)list.get(i1)).i()), "0", s3, ((JSONObject) (obj)).toString(), "", "");
            if (com.cyberlink.youcammakeup.h.i().a(((com.cyberlink.youcammakeup.database.more.b.a) (obj))) == null)
            {
                flag = false;
            }
            i1++;
        }
        if (!flag) goto _L1; else goto _L3
_L3:
        boolean flag1;
        float f1 = aw1.j();
        s1 = new com.cyberlink.youcammakeup.database.more.g.a(s2, s1, k1, "", aw1.e(), s3, Float.valueOf(f1).floatValue(), 0, false, "", "", "eye_shadow", "", "", "", "");
        if (com.cyberlink.youcammakeup.h.j().a(s1) != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag) goto _L1; else goto _L4
_L4:
        aw1 = c(aw1.a(), ((PanelDataCenter.SourceType) (null)));
        list = MotionControlHelper.e().c();
        if (list != null) goto _L6; else goto _L5
_L5:
        flag1 = false;
        com.pf.common.utility.m.e("TemplateUtils", "addCustomPalette: null intensity list.");
_L8:
        Iterator iterator;
        String s4;
        List list1;
        int j1;
        if (flag1)
        {
            aw1 = s2;
        } else
        {
            aw1 = null;
        }
        return aw1;
_L6:
        iterator = aw1.iterator();
        do
        {
            flag1 = flag;
            if (!iterator.hasNext())
            {
                continue;
            }
            s4 = (String)iterator.next();
            list1 = (List)list.get(s4);
            if (list1 != null)
            {
                aw1 = "";
                for (j1 = 0; j1 < list1.size(); j1++)
                {
                    s1 = aw1;
                    if (j1 > 0)
                    {
                        s1 = (new StringBuilder()).append(aw1).append(", ").toString();
                    }
                    aw1 = (new StringBuilder()).append(s1).append(list1.get(j1)).toString();
                }

            } else
            {
                aw1 = "";
            }
            if (!aw1.equals(""))
            {
                aw1 = new com.cyberlink.youcammakeup.database.more.h.e(s4, s2, s3, null, null, k1, aw1);
                if (com.cyberlink.youcammakeup.h.n().a(aw1) == null)
                {
                    flag = false;
                }
            } else
            {
                com.pf.common.utility.m.e("TemplateUtils", "addCustomPalette: null intensities.");
                flag = false;
            }
        } while (true);
        if (true) goto _L8; else goto _L7
_L7:
    }

    static String a(String s1, av av1, String s2, List list)
    {
        String s3 = com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.c.name();
        Iterator iterator;
        if (s1 == null)
        {
            s1 = UUID.randomUUID().toString();
        }
        iterator = list.iterator();
        for (int i1 = 0; iterator.hasNext(); i1++)
        {
            ao ao1 = (ao)iterator.next();
            String s4 = UUID.randomUUID().toString();
            String s5 = UUID.randomUUID().toString();
            String s6 = a(ao1.a());
            Object obj = ao1.f().iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                list = (at)((Iterator) (obj)).next();
                Object obj1 = com.cyberlink.youcammakeup.utility.au.a(list.f(), list.g(), list.k(), list.j(), com.cyberlink.youcammakeup.utility.au.a(list.l()));
                String s7 = e(list.i());
                int j1 = list.d();
                obj1 = ((JSONObject) (obj1)).toString();
                if (list instanceof ba)
                {
                    list = ((ba)list).h();
                } else
                {
                    list = "";
                }
                list = new com.cyberlink.youcammakeup.database.more.b.a(s5, s6, s7, String.valueOf(j1), s3, ((String) (obj1)), list, "");
                com.cyberlink.youcammakeup.h.i().a(list);
            }
            list = a(ao1.g(), ao1.h());
            obj = com.cyberlink.youcammakeup.utility.ap.a(ao1.c(), ao1.d(), "", "");
            list = new a(s4, s1, ao1.b(), s6, String.valueOf(ao1.e()), s5, list.toString(), String.valueOf(i1), ((JSONObject) (obj)).toString(), ao1.i(), "");
            com.cyberlink.youcammakeup.h.m().a(list);
        }

        list = com.cyberlink.youcammakeup.utility.an.b(new an()).toString();
        av1 = new com.cyberlink.youcammakeup.database.more.d.e(s1, 14F, com.cyberlink.youcammakeup.utility.av.b(av1).toString(), list, s2, "", s3, com.cyberlink.youcammakeup.utility.PanelDataCenter.SupportMode.c.name(), false, "", "", "", "", 0, 0, 0);
        com.cyberlink.youcammakeup.h.k().a(av1);
        return s1;
    }

    static String a(String s1, Float float1)
    {
        if (s1 == null || float1 == null || float1.floatValue() >= 5F)
        {
            return s1;
        } else
        {
            return s1.replace("thumb/", "thumb_android/");
        }
    }

    static Collection a(BeautyMode beautymode, PanelDataCenter.SourceType sourcetype, int i1)
    {
        return com.cyberlink.youcammakeup.h.j().a(a(beautymode), sourcetype.name(), i1);
    }

    static Collection a(List list, BeautyMode beautymode)
    {
        return com.cyberlink.youcammakeup.h.j().a(list, a(beautymode));
    }

    static List a(BeautyMode beautymode, PanelDataCenter.SourceType sourcetype)
    {
        String s1 = a(beautymode);
        d d1 = com.cyberlink.youcammakeup.h.f();
        if (sourcetype != null)
        {
            beautymode = sourcetype.name();
        } else
        {
            beautymode = null;
        }
        return (List)d1.a(s1, beautymode);
    }

    static transient List a(BeautyMode beautymode, PanelDataCenter.SourceType asourcetype[])
    {
        String as1[] = new String[asourcetype.length];
        for (int i1 = 0; i1 < as1.length; i1++)
        {
            as1[i1] = asourcetype[i1].name();
        }

        return a(com.cyberlink.youcammakeup.h.i().a(a(beautymode), as1));
    }

    static List a(PanelDataCenter.SourceType sourcetype)
    {
        ArrayList arraylist = new ArrayList();
        for (sourcetype = ((List)com.cyberlink.youcammakeup.h.k().b(sourcetype.name())).iterator(); sourcetype.hasNext(); arraylist.add(com.cyberlink.youcammakeup.utility.av.a((String)sourcetype.next()))) { }
        return arraylist;
    }

    public static transient List a(PanelDataCenter.SourceType sourcetype, PanelDataCenter.SupportMode asupportmode[])
    {
        String as1[] = new String[asupportmode.length];
        for (int i1 = 0; i1 < asupportmode.length; i1++)
        {
            as1[i1] = asupportmode[i1].name();
        }

        asupportmode = com.cyberlink.youcammakeup.h.k();
        if (sourcetype != null)
        {
            sourcetype = sourcetype.name();
        } else
        {
            sourcetype = null;
        }
        return (List)asupportmode.a(sourcetype, as1);
    }

    static transient List a(String s1, PanelDataCenter.SourceType asourcetype[])
    {
        String as1[] = new String[asourcetype.length];
        for (int i1 = 0; i1 < asourcetype.length; i1++)
        {
            as1[i1] = asourcetype[i1].name();
        }

        asourcetype = new ArrayList();
        s1 = ((List)com.cyberlink.youcammakeup.h.l().a(s1, as1)).iterator();
        do
        {
            if (!s1.hasNext())
            {
                break;
            }
            String s2 = (String)s1.next();
            if (h(s2))
            {
                asourcetype.add(s2);
            }
        } while (true);
        return asourcetype;
    }

    static List a(List list)
    {
        ArrayList arraylist = new ArrayList();
        for (list = list.iterator(); list.hasNext(); arraylist.add(a((com.cyberlink.youcammakeup.database.more.b.a)list.next()))) { }
        return arraylist;
    }

    public static transient List a(PanelDataCenter.SourceType asourcetype[])
    {
        String as1[] = new String[asourcetype.length];
        for (int i1 = 0; i1 < asourcetype.length; i1++)
        {
            as1[i1] = asourcetype[i1].name();
        }

        return (List)com.cyberlink.youcammakeup.h.k().a(as1);
    }

    protected static Map a(Node node)
    {
        PanelDataCenter.LocaleEnum alocaleenum[] = PanelDataCenter.LocaleEnum.values();
        HashMap hashmap = new HashMap();
        node = (Element)node;
        int j1 = alocaleenum.length;
        int i1 = 0;
        while (i1 < j1) 
        {
            PanelDataCenter.LocaleEnum localeenum = alocaleenum[i1];
            NodeList nodelist = node.getElementsByTagName(localeenum.name());
            if (nodelist.getLength() > 0)
            {
                hashmap.put(localeenum, nodelist.item(0).getTextContent().trim());
            } else
            {
                hashmap.put(localeenum, "");
            }
            i1++;
        }
        return hashmap;
    }

    protected static JSONObject a(int i1, int j1)
    {
        String s1;
        String s2;
        if (i1 > 0)
        {
            s1 = String.valueOf(i1);
        } else
        {
            s1 = "";
        }
        if (j1 > 0)
        {
            s2 = String.valueOf(j1);
        } else
        {
            s2 = "";
        }
        return a(s1, s2);
    }

    protected static JSONObject a(String s1, String s2)
    {
        JSONObject jsonobject = new JSONObject();
        if (s1 == null)
        {
            s1 = "";
        }
        try
        {
            jsonobject.put("intensity", s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            return jsonobject;
        }
        if (s2 == null)
        {
            s2 = "";
        }
        jsonobject.put("hidden_intensity", s2);
        return jsonobject;
    }

    protected static JSONObject a(NodeList nodelist)
    {
        PanelDataCenter.LocaleEnum alocaleenum[];
        JSONObject jsonobject;
        alocaleenum = PanelDataCenter.LocaleEnum.values();
        jsonobject = com.cyberlink.youcammakeup.utility.av.b(new av());
        if (nodelist.getLength() <= 0) goto _L2; else goto _L1
_L1:
        int i1;
        int j1;
        nodelist = (Element)nodelist.item(0);
        j1 = alocaleenum.length;
        i1 = 0;
_L8:
        if (i1 >= j1) goto _L2; else goto _L3
_L3:
        PanelDataCenter.LocaleEnum localeenum = alocaleenum[i1];
        NodeList nodelist1 = nodelist.getElementsByTagName(localeenum.name());
        if (nodelist1.getLength() <= 0) goto _L5; else goto _L4
_L4:
        jsonobject.put(localeenum.name(), nodelist1.item(0).getTextContent().trim());
          goto _L6
_L5:
        try
        {
            jsonobject.put(localeenum.name(), "");
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            com.pf.common.utility.m.e("TemplateUtils", (new StringBuilder()).append("[extractLookNameToJSON] error occur on assign a name to JSON from a field: ").append(localeenum.name()).append(illegalargumentexception.toString()).toString());
        }
        catch (DOMException domexception)
        {
            com.pf.common.utility.m.e("TemplateUtils", (new StringBuilder()).append("[extractLookNameToJSON] error occur on assign a name to JSON from a field: ").append(localeenum.name()).append(domexception.toString()).toString());
        }
        catch (JSONException jsonexception)
        {
            com.pf.common.utility.m.e("TemplateUtils", (new StringBuilder()).append("[extractLookNameToJSON] error occur on assign a name to JSON from a field: ").append(localeenum.name()).append(jsonexception.toString()).toString());
        }
          goto _L6
_L2:
        return jsonobject;
_L6:
        i1++;
        if (true) goto _L8; else goto _L7
_L7:
    }

    protected static void a(br br1)
    {
        com.cyberlink.youcammakeup.database.more.h.e e1;
        for (Iterator iterator = br1.b.e.iterator(); iterator.hasNext(); com.cyberlink.youcammakeup.h.n().a(e1))
        {
            e1 = (com.cyberlink.youcammakeup.database.more.h.e)iterator.next();
        }

        com.cyberlink.youcammakeup.database.more.h.a a1;
        for (Iterator iterator1 = br1.b.f.iterator(); iterator1.hasNext(); com.cyberlink.youcammakeup.h.o().a(a1))
        {
            a1 = (com.cyberlink.youcammakeup.database.more.h.a)iterator1.next();
        }

        c c2;
        for (Iterator iterator2 = br1.b.g.iterator(); iterator2.hasNext(); com.cyberlink.youcammakeup.h.f().a(c2))
        {
            c2 = (c)iterator2.next();
        }

        com.cyberlink.youcammakeup.database.more.g.a a2;
        for (Iterator iterator3 = br1.b.h.iterator(); iterator3.hasNext(); com.cyberlink.youcammakeup.h.j().a(a2))
        {
            a2 = (com.cyberlink.youcammakeup.database.more.g.a)iterator3.next();
        }

        com.cyberlink.youcammakeup.database.more.e.a a3;
        for (Iterator iterator4 = br1.b.k.iterator(); iterator4.hasNext(); com.cyberlink.youcammakeup.h.g().a(a3))
        {
            a3 = (com.cyberlink.youcammakeup.database.more.e.a)iterator4.next();
        }

        com.cyberlink.youcammakeup.database.more.k.a a4;
        for (Iterator iterator5 = br1.b.l.iterator(); iterator5.hasNext(); com.cyberlink.youcammakeup.h.h().a(a4))
        {
            a4 = (com.cyberlink.youcammakeup.database.more.k.a)iterator5.next();
        }

        com.cyberlink.youcammakeup.database.more.b.a a5;
        for (Iterator iterator6 = br1.b.i.iterator(); iterator6.hasNext(); com.cyberlink.youcammakeup.h.i().a(a5))
        {
            a5 = (com.cyberlink.youcammakeup.database.more.b.a)iterator6.next();
        }

        com.cyberlink.youcammakeup.database.more.b.a a6;
        for (Iterator iterator7 = br1.b.j.iterator(); iterator7.hasNext(); com.cyberlink.youcammakeup.h.i().a(a6))
        {
            a6 = (com.cyberlink.youcammakeup.database.more.b.a)iterator7.next();
        }

        com.cyberlink.youcammakeup.database.more.d.e e2;
        for (Iterator iterator8 = br1.b.m.iterator(); iterator8.hasNext(); com.cyberlink.youcammakeup.h.k().a(e2))
        {
            e2 = (com.cyberlink.youcammakeup.database.more.d.e)iterator8.next();
        }

        com.cyberlink.youcammakeup.database.more.d.c c3;
        for (Iterator iterator9 = br1.b.o.iterator(); iterator9.hasNext(); com.cyberlink.youcammakeup.h.l().a(c3))
        {
            c3 = (com.cyberlink.youcammakeup.database.more.d.c)iterator9.next();
        }

        a a7;
        for (Iterator iterator10 = br1.b.n.iterator(); iterator10.hasNext(); com.cyberlink.youcammakeup.h.m().a(a7))
        {
            a7 = (a)iterator10.next();
        }

        com.cyberlink.youcammakeup.database.more.c.a a8;
        for (Iterator iterator11 = br1.b.p.iterator(); iterator11.hasNext(); com.cyberlink.youcammakeup.h.p().a(a8))
        {
            a8 = (com.cyberlink.youcammakeup.database.more.c.a)iterator11.next();
        }

        com.cyberlink.youcammakeup.database.more.j.a a9;
        for (Iterator iterator12 = br1.b.q.iterator(); iterator12.hasNext(); com.cyberlink.youcammakeup.h.q().a(a9))
        {
            a9 = (com.cyberlink.youcammakeup.database.more.j.a)iterator12.next();
        }

        com.cyberlink.youcammakeup.database.more.g.c c1;
        for (br1 = br1.b.r.iterator(); br1.hasNext(); com.cyberlink.youcammakeup.h.r().a(c1))
        {
            c1 = (com.cyberlink.youcammakeup.database.more.g.c)br1.next();
        }

    }

    public static void a(bu bu1)
    {
        ArrayList arraylist = new ArrayList();
        bs bs1 = new bs();
        bs1.b = "assets://makeup/";
        bs1.c = "makeup_template.xml";
        arraylist.add(bs1);
        (new bp(arraylist, bu1)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    static void a(String s1, PanelDataCenter.SourceType sourcetype)
    {
        Object obj1 = com.cyberlink.youcammakeup.h.n();
        Object obj;
        f f1;
        if (sourcetype != null)
        {
            obj = sourcetype.name();
        } else
        {
            obj = null;
        }
        obj1 = (List)((f) (obj1)).c(s1, ((String) (obj)));
        f1 = com.cyberlink.youcammakeup.h.n();
        if (sourcetype != null)
        {
            obj = sourcetype.name();
        } else
        {
            obj = null;
        }
        f1.e(s1, ((String) (obj)));
        obj = ((List) (obj1)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            String s2 = (String)((Iterator) (obj)).next();
            f f2 = com.cyberlink.youcammakeup.h.n();
            if (sourcetype != null)
            {
                s1 = sourcetype.name();
            } else
            {
                s1 = null;
            }
            if (((List)f2.a(s2, s1)).size() == 0)
            {
                s1 = a(s2, Boolean.valueOf(false));
                if (sourcetype == null)
                {
                    com.cyberlink.youcammakeup.h.j().f(s2);
                } else
                if (s1 != null && s1.g() == sourcetype)
                {
                    com.cyberlink.youcammakeup.h.j().f(s2);
                }
            }
        } while (true);
    }

    public static boolean a()
    {
        boolean flag = (new File(a)).exists();
        if (flag)
        {
            com.pf.common.utility.m.b("TemplateUtils", "test content");
            return flag;
        } else
        {
            com.pf.common.utility.m.b("TemplateUtils", "released content");
            return flag;
        }
    }

    static boolean a(bq bq1, String s1)
    {
        return b(bq1, s1);
    }

    public static boolean a(String s1)
    {
        boolean flag;
        boolean flag1;
        flag1 = false;
        flag = flag1;
        if (s1 == null) goto _L2; else goto _L1
_L1:
        if (!s1.equals("")) goto _L4; else goto _L3
_L3:
        flag = flag1;
_L2:
        return flag;
_L4:
        if (s1.indexOf("assets://") != 0)
        {
            break MISSING_BLOCK_LABEL_104;
        }
        s1 = f.open(s1.substring("assets://".length()));
label0:
        {
            if (s1 == null)
            {
                break label0;
            }
            flag = true;
            if (s1 != null)
            {
                try
                {
                    s1.close();
                }
                // Misplaced declaration of an exception variable
                catch (String s1)
                {
                    com.pf.common.utility.m.e("TemplateUtils", s1.toString());
                    return true;
                }
                return true;
            }
        }
          goto _L2
        flag = flag1;
        if (s1 == null) goto _L2; else goto _L5
_L5:
        try
        {
            s1.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            com.pf.common.utility.m.e("TemplateUtils", s1.toString());
            return false;
        }
        return false;
        flag = (new File(s1)).exists();
        flag1 = flag;
        flag = flag1;
        if (false)
        {
            try
            {
                throw new NullPointerException();
            }
            // Misplaced declaration of an exception variable
            catch (String s1)
            {
                com.pf.common.utility.m.e("TemplateUtils", s1.toString());
            }
            return flag1;
        }
          goto _L2
        s1;
        com.pf.common.utility.m.e("TemplateUtils", s1.toString());
        flag = flag1;
        if (true) goto _L2; else goto _L6
_L6:
        try
        {
            throw new NullPointerException();
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            com.pf.common.utility.m.e("TemplateUtils", s1.toString());
        }
        return false;
        Exception exception;
        exception;
        if (false)
        {
            try
            {
                throw new NullPointerException();
            }
            // Misplaced declaration of an exception variable
            catch (String s1)
            {
                com.pf.common.utility.m.e("TemplateUtils", s1.toString());
            }
        }
        throw exception;
    }

    public static boolean a(String s1, boolean flag)
    {
        return com.cyberlink.youcammakeup.h.k().a(s1, String.valueOf(flag));
    }

    static boolean a(NodeList nodelist, int i1)
    {
        if (nodelist != null && i1 <= nodelist.getLength() - 1) goto _L2; else goto _L1
_L1:
        boolean flag;
        return false;
_L2:
        if (!(flag = nodelist.item(i1).getTextContent().trim().equalsIgnoreCase("1"))) goto _L1; else goto _L3
_L3:
        return true;
        nodelist;
        com.pf.common.utility.m.e("TemplateUtils", (new StringBuilder()).append("getIsShimmer() fail. idx=").append(i1).toString());
        return false;
    }

    static int b(NodeList nodelist, int i1)
    {
        if (nodelist == null || i1 > nodelist.getLength() - 1)
        {
            return 0;
        }
        int j1;
        try
        {
            j1 = Integer.parseInt(nodelist.item(i1).getTextContent().trim());
        }
        // Misplaced declaration of an exception variable
        catch (NodeList nodelist)
        {
            com.pf.common.utility.m.e("TemplateUtils", (new StringBuilder()).append("getShimmerIntensity() fail. idx=").append(i1).toString());
            return 0;
        }
        return j1;
    }

    public static BeautyMode b(String s1)
    {
        if (s1.equals("eye_lash"))
        {
            return com.cyberlink.youcammakeup.utility.BeautyMode.m;
        }
        if (s1.equals("eye_line"))
        {
            return BeautyMode.l;
        }
        if (s1.equals("eye_shadow"))
        {
            return BeautyMode.n;
        }
        if (s1.equals("eye_brow"))
        {
            return BeautyMode.r;
        }
        if (s1.equals("eye_contact"))
        {
            return BeautyMode.s;
        }
        if (s1.equals("blush"))
        {
            return com.cyberlink.youcammakeup.utility.BeautyMode.a;
        }
        if (s1.equals("skin_toner"))
        {
            return com.cyberlink.youcammakeup.utility.BeautyMode.b;
        }
        if (s1.equals("lipstick"))
        {
            return BeautyMode.v;
        }
        if (s1.equals("eye_enlarge"))
        {
            return BeautyMode.o;
        }
        if (s1.equals("eye_sparkle"))
        {
            return BeautyMode.u;
        }
        if (s1.equals("eye_bag"))
        {
            return BeautyMode.p;
        }
        if (s1.equals("eye_lid"))
        {
            return BeautyMode.t;
        }
        if (s1.equals("anti_shine"))
        {
            return com.cyberlink.youcammakeup.utility.BeautyMode.c;
        }
        if (s1.equals("skin_smooth"))
        {
            return com.cyberlink.youcammakeup.utility.BeautyMode.d;
        }
        if (s1.equals("face_contour"))
        {
            return BeautyMode.g;
        }
        if (s1.equals("nose_enhancement"))
        {
            return com.cyberlink.youcammakeup.utility.BeautyMode.f;
        }
        if (s1.equals("face_reshaper"))
        {
            return com.cyberlink.youcammakeup.utility.BeautyMode.h;
        }
        if (s1.equals("teeth_whitener"))
        {
            return BeautyMode.w;
        }
        if (s1.equals("red_eye_Removal"))
        {
            return BeautyMode.q;
        }
        if (s1.equals("blemish_removal"))
        {
            return com.cyberlink.youcammakeup.utility.BeautyMode.e;
        }
        if (s1.equals("wig"))
        {
            return BeautyMode.x;
        }
        if (s1.equals("eye_wear"))
        {
            return com.cyberlink.youcammakeup.utility.BeautyMode.z;
        }
        if (s1.equals("hair_band"))
        {
            return BeautyMode.A;
        }
        if (s1.equals("necklace"))
        {
            return BeautyMode.B;
        }
        if (s1.equals("earrings"))
        {
            return BeautyMode.C;
        }
        if (s1.equals("hair_dye"))
        {
            return BeautyMode.y;
        }
        if (s1.equals("face_art"))
        {
            return BeautyMode.j;
        }
        if (s1.equals("mustache"))
        {
            return BeautyMode.k;
        } else
        {
            return BeautyMode.o;
        }
    }

    static List b(BeautyMode beautymode)
    {
        beautymode = a(beautymode);
        return (List)com.cyberlink.youcammakeup.h.f().c(beautymode);
    }

    static List b(BeautyMode beautymode, PanelDataCenter.SourceType sourcetype)
    {
        String s1 = a(beautymode);
        d d1 = com.cyberlink.youcammakeup.h.f();
        if (sourcetype != null)
        {
            beautymode = sourcetype.name();
        } else
        {
            beautymode = null;
        }
        return (List)d1.b(s1, beautymode);
    }

    static List b(String s1, String s2)
    {
        int i1 = 0;
        ArrayList arraylist = new ArrayList();
        s1 = com.cyberlink.youcammakeup.h.n().d(s1, s2);
        if (s1 != null)
        {
            if (s1.equals(""))
            {
                s1 = new String[0];
            } else
            {
                s1 = s1.split(",");
            }
            for (; i1 < s1.length; i1++)
            {
                arraylist.add(Integer.valueOf(Integer.parseInt(s1[i1].trim())));
            }

        }
        return arraylist;
    }

    protected static JSONObject b(NodeList nodelist)
    {
        PanelDataCenter.LocaleEnum alocaleenum[];
        JSONObject jsonobject;
        alocaleenum = PanelDataCenter.LocaleEnum.values();
        jsonobject = com.cyberlink.youcammakeup.utility.an.b(new an());
        if (nodelist.getLength() <= 0) goto _L2; else goto _L1
_L1:
        int i1;
        int j1;
        nodelist = (Element)nodelist.item(0);
        j1 = alocaleenum.length;
        i1 = 0;
_L8:
        if (i1 >= j1) goto _L2; else goto _L3
_L3:
        PanelDataCenter.LocaleEnum localeenum = alocaleenum[i1];
        NodeList nodelist1 = nodelist.getElementsByTagName(localeenum.name());
        if (nodelist1.getLength() <= 0) goto _L5; else goto _L4
_L4:
        jsonobject.put(localeenum.name(), nodelist1.item(0).getTextContent().trim());
          goto _L6
_L5:
        try
        {
            jsonobject.put(localeenum.name(), "");
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            com.pf.common.utility.m.e("TemplateUtils", (new StringBuilder()).append("[extractLookNameToJSON] error occur on assign a description to JSON from a field: ").append(localeenum.name()).append(illegalargumentexception.toString()).toString());
        }
        catch (DOMException domexception)
        {
            com.pf.common.utility.m.e("TemplateUtils", (new StringBuilder()).append("[extractLookNameToJSON] error occur on assign a description to JSON from a field: ").append(localeenum.name()).append(domexception.toString()).toString());
        }
        catch (JSONException jsonexception)
        {
            com.pf.common.utility.m.e("TemplateUtils", (new StringBuilder()).append("[extractLookNameToJSON] error occur on assign a description to JSON from a field: ").append(localeenum.name()).append(jsonexception.toString()).toString());
        }
          goto _L6
_L2:
        return jsonobject;
_L6:
        i1++;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public static void b(bu bu1)
    {
        ArrayList arraylist = new ArrayList();
        String as1[] = d();
        if (as1 != null)
        {
            for (int i1 = 0; i1 < as1.length; i1++)
            {
                bs bs1 = new bs();
                String s1 = as1[i1];
                bs1.b = (new StringBuilder()).append(c).append(s1).append(File.separator).toString();
                bs1.c = "makeup_template.xml";
                arraylist.add(bs1);
            }

            (new bp(arraylist, bu1)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else
        if (bu1 != null)
        {
            bu1.a(null);
            return;
        }
    }

    static void b(String s1, PanelDataCenter.SourceType sourcetype)
    {
        Object obj1 = com.cyberlink.youcammakeup.h.n();
        Object obj;
        f f1;
        if (sourcetype != null)
        {
            obj = sourcetype.name();
        } else
        {
            obj = null;
        }
        obj1 = (List)((f) (obj1)).a(s1, ((String) (obj)));
        f1 = com.cyberlink.youcammakeup.h.n();
        if (sourcetype != null)
        {
            obj = sourcetype.name();
        } else
        {
            obj = null;
        }
        f1.f(s1, ((String) (obj)));
        obj = ((List) (obj1)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            String s2 = (String)((Iterator) (obj)).next();
            f f2 = com.cyberlink.youcammakeup.h.n();
            if (sourcetype != null)
            {
                s1 = sourcetype.name();
            } else
            {
                s1 = null;
            }
            if (((List)f2.c(s2, s1)).size() == 0)
            {
                s1 = r(s2);
                if (sourcetype == null)
                {
                    com.cyberlink.youcammakeup.h.f().d(s2);
                } else
                if (s1 != null && s1.d() == sourcetype)
                {
                    com.cyberlink.youcammakeup.h.f().d(s2);
                }
            }
        } while (true);
    }

    public static boolean b()
    {
        boolean flag = (new File(b)).exists();
        if (flag)
        {
            com.pf.common.utility.m.b("TemplateUtils", "pure test content");
            return flag;
        } else
        {
            com.pf.common.utility.m.b("TemplateUtils", "released content");
            return flag;
        }
    }

    private static boolean b(bq bq1, String s1)
    {
        for (bq1 = bq1.h.iterator(); bq1.hasNext();)
        {
            if (((com.cyberlink.youcammakeup.database.more.g.a)bq1.next()).a().equals(s1))
            {
                return true;
            }
        }

        return false;
    }

    public static boolean b(String s1, boolean flag)
    {
        return com.cyberlink.youcammakeup.h.f().c(s1, String.valueOf(flag));
    }

    public static float c()
    {
        float f1;
        Object obj;
        obj = null;
        f1 = 1.0F;
        Object obj1 = Globals.d().getAssets().open("assets://makeup/makeup_template.xml".substring("assets://".length()));
        obj = obj1;
        obj1 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(((InputStream) (obj)));
        ((Document) (obj1)).getDocumentElement().normalize();
        obj1 = ((Element)((Document) (obj1)).getElementsByTagName("makeup").item(0)).getAttribute("content_version");
        if (((String) (obj1)).equals("")) goto _L2; else goto _L1
_L1:
        float f2 = c(((String) (obj1)));
        f1 = f2;
_L3:
        if (obj != null)
        {
            try
            {
                ((InputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                return f1;
            }
        }
_L5:
        return f1;
_L2:
        f1 = 1.0F;
          goto _L3
        Object obj2;
        obj2;
_L12:
        if (obj == null) goto _L5; else goto _L4
_L4:
        try
        {
            ((InputStream) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return 1.0F;
        }
        return 1.0F;
        obj;
        obj = null;
_L11:
        if (obj == null) goto _L5; else goto _L6
_L6:
        try
        {
            ((InputStream) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return 1.0F;
        }
        return 1.0F;
        obj;
        obj = null;
_L10:
        if (obj == null) goto _L5; else goto _L7
_L7:
        try
        {
            ((InputStream) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return 1.0F;
        }
        return 1.0F;
        obj2;
        obj = null;
_L9:
        if (obj != null)
        {
            try
            {
                ((InputStream) (obj)).close();
            }
            catch (IOException ioexception) { }
        }
        throw obj2;
        obj2;
        if (true) goto _L9; else goto _L8
_L8:
        obj2;
          goto _L10
          goto _L5
        obj2;
          goto _L11
        obj2;
          goto _L12
    }

    public static float c(String s1)
    {
        if (s1 == null || s1.equals(""))
        {
            return 0.0F;
        } else
        {
            return Float.parseFloat(s1);
        }
    }

    static Collection c(BeautyMode beautymode)
    {
        beautymode = a(beautymode);
        return com.cyberlink.youcammakeup.h.m().f(beautymode);
    }

    static Collection c(BeautyMode beautymode, PanelDataCenter.SourceType sourcetype)
    {
        return com.cyberlink.youcammakeup.h.j().b(a(beautymode), sourcetype.toString());
    }

    static List c(String s1, PanelDataCenter.SourceType sourcetype)
    {
        f f1 = com.cyberlink.youcammakeup.h.n();
        if (sourcetype != null)
        {
            sourcetype = sourcetype.name();
        } else
        {
            sourcetype = null;
        }
        return (List)f1.a(s1, sourcetype);
    }

    static boolean c(String s1, String s2)
    {
        com.cyberlink.youcammakeup.database.more.d.e e1 = com.cyberlink.youcammakeup.h.k().a(s1);
        if (e1 == null)
        {
            return false;
        } else
        {
            s2 = new com.cyberlink.youcammakeup.database.more.d.e(e1.a(), e1.b(), s2, e1.d(), e1.e(), e1.f(), e1.g(), e1.h(), e1.i(), e1.j(), "", "", "", 0, 0, 0);
            return com.cyberlink.youcammakeup.h.k().a(s1, s2);
        }
    }

    public static boolean c(String s1, boolean flag)
    {
        return com.cyberlink.youcammakeup.h.j().c(s1, String.valueOf(flag));
    }

    public static int d(String s1)
    {
        if (s1 == null || s1.equals(""))
        {
            return 0;
        } else
        {
            return Integer.parseInt(s1);
        }
    }

    static at d(BeautyMode beautymode, PanelDataCenter.SourceType sourcetype)
    {
        beautymode = com.cyberlink.youcammakeup.h.i().a(a(beautymode), sourcetype.name());
        if (beautymode == null)
        {
            return new at(0);
        } else
        {
            return a(beautymode);
        }
    }

    static List d(String s1, PanelDataCenter.SourceType sourcetype)
    {
        f f1 = com.cyberlink.youcammakeup.h.n();
        if (sourcetype != null)
        {
            sourcetype = sourcetype.name();
        } else
        {
            sourcetype = null;
        }
        return (List)f1.b(s1, sourcetype);
    }

    public static void d(BeautyMode beautymode)
    {
        Object obj = a(beautymode);
        List list = (List)com.cyberlink.youcammakeup.h.j().a(((String) (obj)), com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.a.name());
        List list1 = (List)com.cyberlink.youcammakeup.h.j().a(((String) (obj)), com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.b.name());
        obj = (List)com.cyberlink.youcammakeup.h.j().a(((String) (obj)), com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.d.name());
        int i1;
        int j1;
        int k1;
        if (list != null)
        {
            i1 = list.size();
        } else
        {
            i1 = -1;
        }
        if (list1 != null)
        {
            j1 = list1.size();
        } else
        {
            j1 = -1;
        }
        if (obj != null)
        {
            k1 = ((List) (obj)).size();
        } else
        {
            k1 = -1;
        }
        beautymode = (new StringBuilder()).append("logFabricPalettesSize, BeautyMode = ").append(String.valueOf(beautymode)).append(", default guid size = ").append(String.valueOf(i1)).append(", download guid size = ").append(String.valueOf(j1)).append(", sku guid size = ").append(String.valueOf(k1)).toString();
        Globals.d().e(beautymode);
    }

    public static String[] d()
    {
        return (new File(c)).list();
    }

    static at e(String s1, PanelDataCenter.SourceType sourcetype)
    {
        com.cyberlink.youcammakeup.database.more.h.b b1 = com.cyberlink.youcammakeup.h.o();
        if (sourcetype != null)
        {
            sourcetype = sourcetype.name();
        } else
        {
            sourcetype = null;
        }
        s1 = (List)b1.a(s1, sourcetype);
        if (s1.size() != 0)
        {
            if ((s1 = com.cyberlink.youcammakeup.h.i().a((String)s1.get(0))).size() != 0)
            {
                return a((com.cyberlink.youcammakeup.database.more.b.a)s1.get(0));
            }
        }
        return null;
    }

    public static String e(String s1)
    {
        if (s1.length() == 6)
        {
            return s1.toUpperCase(Locale.getDefault());
        }
        if (s1.length() != 8)
        {
            return "000000";
        } else
        {
            return s1.substring(2).toUpperCase(Locale.getDefault());
        }
    }

    public static void e()
    {
        Object obj2 = (List)com.cyberlink.youcammakeup.h.k().a(new String[] {
            com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.a.name()
        });
        Object obj1 = (List)com.cyberlink.youcammakeup.h.f().b(com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.a.name());
        Object obj = (List)com.cyberlink.youcammakeup.h.j().c(com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.a.name());
        String s3;
        for (obj2 = ((List) (obj2)).iterator(); ((Iterator) (obj2)).hasNext(); com.cyberlink.youcammakeup.h.k().c(s3))
        {
            s3 = (String)((Iterator) (obj2)).next();
        }

        String s2;
        for (obj1 = ((List) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); a(s2, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.a))
        {
            s2 = (String)((Iterator) (obj1)).next();
            com.cyberlink.youcammakeup.h.f().d(s2);
        }

        String s1;
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); b(s1, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.a))
        {
            s1 = (String)((Iterator) (obj)).next();
            com.cyberlink.youcammakeup.h.j().f(s1);
        }

        com.cyberlink.youcammakeup.h.i().c(com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.a.name());
        com.cyberlink.youcammakeup.h.o().a(com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.a.name());
    }

    static ax f()
    {
        return new ax("default_original_eye_contact", Float.valueOf(1.0F), BeautyMode.s, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.a, Boolean.valueOf(false), "assets://makeup/eyecontact/thumb/patten_eyecontact_00.png", "assets://makeup/eyecontact/texture_eyecontact.png", null, null, null, null, new av());
    }

    static String f(String s1, PanelDataCenter.SourceType sourcetype)
    {
        f f1 = com.cyberlink.youcammakeup.h.n();
        if (sourcetype != null)
        {
            sourcetype = sourcetype.name();
        } else
        {
            sourcetype = null;
        }
        s1 = (List)f1.c(s1, sourcetype);
        if (s1.size() == 0)
        {
            return null;
        } else
        {
            return (String)s1.get(0);
        }
    }

    public static boolean f(String s1)
    {
        return com.cyberlink.youcammakeup.h.j().e(s1);
    }

    static ax g()
    {
        BeautyMode beautymode = BeautyMode.x;
        PanelDataCenter.SourceType sourcetype = com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.a;
        String s1;
        if (o() == null)
        {
            s1 = "assets://makeup/wig/thumb/patten_wig_00.jpg";
        } else
        {
            s1 = o();
        }
        return new ax("default_original_wig", Float.valueOf(1.0F), beautymode, sourcetype, Boolean.valueOf(false), s1, "assets://makeup/wig/texture_hair_frame.png", null, null, null, null, new av());
    }

    public static boolean g(String s1)
    {
        return com.cyberlink.youcammakeup.h.f().a(s1) != null;
    }

    static ax h()
    {
        BeautyMode beautymode = com.cyberlink.youcammakeup.utility.BeautyMode.z;
        PanelDataCenter.SourceType sourcetype = com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.a;
        String s1;
        if (p() == null)
        {
            s1 = "assets://makeup/wig/thumb/sunglasses_model_00.jpg";
        } else
        {
            s1 = p();
        }
        return new ax("default_original_eye_wear", Float.valueOf(1.0F), beautymode, sourcetype, Boolean.valueOf(false), s1, "assets://makeup/wig/texture_hair_frame.png", null, null, null, null, new av());
    }

    public static boolean h(String s1)
    {
        return com.cyberlink.youcammakeup.h.k().a(s1) != null;
    }

    static ax i()
    {
        BeautyMode beautymode = BeautyMode.A;
        PanelDataCenter.SourceType sourcetype = com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.a;
        String s1;
        if (q() == null)
        {
            s1 = "assets://makeup/wig/thumb/sunglasses_model_00.jpg";
        } else
        {
            s1 = q();
        }
        return new ax("default_original_hair_band", Float.valueOf(1.0F), beautymode, sourcetype, Boolean.valueOf(false), s1, "assets://makeup/wig/texture_hair_frame.png", null, null, null, null, new av());
    }

    static boolean i(String s1)
    {
        return com.cyberlink.youcammakeup.h.m().c(s1).size() > 0;
    }

    static ax j()
    {
        BeautyMode beautymode = BeautyMode.B;
        PanelDataCenter.SourceType sourcetype = com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.a;
        String s1;
        if (r() == null)
        {
            s1 = "assets://makeup/wig/thumb/sunglasses_model_00.jpg";
        } else
        {
            s1 = r();
        }
        return new ax("default_original_necklace", Float.valueOf(1.0F), beautymode, sourcetype, Boolean.valueOf(false), s1, "assets://makeup/wig/texture_hair_frame.png", null, null, null, null, new av());
    }

    static boolean j(String s1)
    {
        for (s1 = k(s1).iterator(); s1.hasNext();)
        {
            if (z((String)s1.next()).f() != com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.a)
            {
                return true;
            }
        }

        return false;
    }

    static ax k()
    {
        BeautyMode beautymode = BeautyMode.C;
        PanelDataCenter.SourceType sourcetype = com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.a;
        String s1;
        if (s() == null)
        {
            s1 = "assets://makeup/wig/thumb/sunglasses_model_00.jpg";
        } else
        {
            s1 = s();
        }
        return new ax("default_original_earrings", Float.valueOf(1.0F), beautymode, sourcetype, Boolean.valueOf(false), s1, "assets://makeup/wig/texture_hair_frame.png", null, null, null, null, new av());
    }

    static List k(String s1)
    {
        return (List)com.cyberlink.youcammakeup.h.m().e(s1);
    }

    static ax l()
    {
        return new ax("default_original_double_eyelid", Float.valueOf(1.0F), BeautyMode.t, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.a, Boolean.valueOf(false), "assets://makeup/eyebrow/thumb/patten_eyebrow_general", null, null, null, null, null, new av());
    }

    static void l(String s1)
    {
        com.cyberlink.youcammakeup.h.f().d(s1);
        a(s1, ((PanelDataCenter.SourceType) (null)));
        com.cyberlink.youcammakeup.h.c().b(s1);
    }

    static ax m()
    {
        BeautyMode beautymode = BeautyMode.j;
        PanelDataCenter.SourceType sourcetype = com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.a;
        String s1;
        if (o() == null)
        {
            s1 = "assets://makeup/wig/thumb/patten_wig_00.jpg";
        } else
        {
            s1 = o();
        }
        return new ax("default_original_face_art", Float.valueOf(1.0F), beautymode, sourcetype, Boolean.valueOf(false), s1, null, null, null, null, null, new av());
    }

    static void m(String s1)
    {
        com.cyberlink.youcammakeup.h.j().f(s1);
        b(s1, ((PanelDataCenter.SourceType) (null)));
        com.cyberlink.youcammakeup.h.c().b(s1);
    }

    static ax n()
    {
        BeautyMode beautymode = BeautyMode.k;
        PanelDataCenter.SourceType sourcetype = com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.a;
        String s1;
        if (o() == null)
        {
            s1 = "assets://makeup/wig/thumb/patten_wig_00.jpg";
        } else
        {
            s1 = o();
        }
        return new ax("default_original_mustache", Float.valueOf(1.0F), beautymode, sourcetype, Boolean.valueOf(false), s1, null, null, null, null, null, new av());
    }

    static void n(String s1)
    {
        com.cyberlink.youcammakeup.h.k().c(s1);
        com.cyberlink.youcammakeup.h.c().b(s1);
    }

    public static String o()
    {
        return g;
    }

    static void o(String s1)
    {
        String s2;
        for (s1 = ((List)com.cyberlink.youcammakeup.h.m().b(s1)).iterator(); s1.hasNext(); l(com.cyberlink.youcammakeup.h.m().a(s2).c()))
        {
            s2 = (String)s1.next();
        }

    }

    public static String p()
    {
        return h;
    }

    static void p(String s1)
    {
        for (s1 = ((List)com.cyberlink.youcammakeup.h.m().d(s1)).iterator(); s1.hasNext(); n((String)s1.next())) { }
    }

    public static String q()
    {
        return i;
    }

    static Collection q(String s1)
    {
        return com.cyberlink.youcammakeup.h.j().d(s1);
    }

    static ax r(String s1)
    {
        Object obj;
        Object obj1;
        obj = null;
        obj1 = StatusManager.j().s();
        if (obj1 != BeautyMode.s || !"default_original_eye_contact".equalsIgnoreCase(s1)) goto _L2; else goto _L1
_L1:
        obj = f();
_L4:
        return ((ax) (obj));
_L2:
        if (obj1 == BeautyMode.x && "default_original_wig".equalsIgnoreCase(s1))
        {
            return g();
        }
        if (obj1 == com.cyberlink.youcammakeup.utility.BeautyMode.z && "default_original_eye_wear".equalsIgnoreCase(s1))
        {
            return h();
        }
        if (obj1 == BeautyMode.B && "default_original_necklace".equalsIgnoreCase(s1))
        {
            return j();
        }
        if (obj1 == BeautyMode.A && "default_original_hair_band".equalsIgnoreCase(s1))
        {
            return i();
        }
        if (obj1 == BeautyMode.C && "default_original_earrings".equalsIgnoreCase(s1))
        {
            return k();
        }
        if (obj1 == BeautyMode.t && "default_original_double_eyelid".equalsIgnoreCase(s1))
        {
            return l();
        }
        if (obj1 == BeautyMode.j && "default_original_face_art".equalsIgnoreCase(s1))
        {
            return m();
        }
        if (obj1 == BeautyMode.k && "default_original_mustache".equalsIgnoreCase(s1))
        {
            return n();
        }
        obj1 = com.cyberlink.youcammakeup.h.f().a(s1);
        if (obj1 == null) goto _L4; else goto _L3
_L3:
        float f1;
        BeautyMode beautymode;
        String s2;
        PanelDataCenter.SourceType sourcetype;
        String s3;
        String s4;
        av av1;
        List list;
        String s5;
        String s6;
        boolean flag;
        beautymode = b(((c) (obj1)).b());
        s2 = ((c) (obj1)).d();
        sourcetype = PanelDataCenter.SourceType.valueOf(((c) (obj1)).e());
        flag = ((c) (obj1)).j();
        s3 = ((c) (obj1)).g();
        s4 = ((c) (obj1)).h();
        s6 = ((c) (obj1)).i();
        av1 = com.cyberlink.youcammakeup.utility.av.a(((c) (obj1)).c());
        list = (List)com.cyberlink.youcammakeup.h.n().c(s1, null);
        f1 = ((c) (obj1)).f();
        s5 = ((c) (obj1)).k();
        obj = com.cyberlink.youcammakeup.utility.PanelDataCenter.LipstickProfile.LipstickType.e;
        obj1 = com.cyberlink.youcammakeup.utility.PanelDataCenter.LipstickProfile.a((new JSONObject(s6)).optString("lipstick_type"));
        obj = obj1;
_L6:
        return new ax(s1, Float.valueOf(f1), beautymode, sourcetype, Boolean.valueOf(flag), s2, s3, s4, list, s5, new PanelDataCenter.LipstickProfile(((PanelDataCenter.LipstickProfile.LipstickType) (obj))), av1);
        JSONException jsonexception;
        jsonexception;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static String r()
    {
        return j;
    }

    public static String s()
    {
        return k;
    }

    static List s(String s1)
    {
        ArrayList arraylist = new ArrayList();
        s1 = (List)com.cyberlink.youcammakeup.h.n().c(s1, null);
        if (s1 != null)
        {
            for (s1 = s1.iterator(); s1.hasNext(); arraylist.add(a((String)s1.next(), Boolean.valueOf(false)))) { }
        }
        return arraylist;
    }

    static ar t(String s1)
    {
        s1 = com.cyberlink.youcammakeup.h.q().a(s1);
        if (s1 == null)
        {
            return new ar(null, 0, 0, 0);
        } else
        {
            return new ar(s1.a(), Integer.parseInt(s1.b()), Integer.parseInt(s1.c()), 0);
        }
    }

    public static aw t()
    {
        if (l == null)
        {
            l = new aw("default_original_hair_dye", "", 0, new ArrayList(), null, null, null, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.a, 0.0F, Boolean.valueOf(false), null);
        }
        return l;
    }

    static ar u(String s1)
    {
        s1 = com.cyberlink.youcammakeup.h.r().a(s1);
        if (s1 == null)
        {
            return null;
        } else
        {
            return new ar(s1.a(), s1.b(), s1.c(), s1.d());
        }
    }

    public static void u()
    {
        Object obj = new ArrayList();
        ((List) (obj)).add(new com.cyberlink.youcammakeup.database.more.d.c("look_thumb_17", "Natural", "Party", null, null, null, null));
        ((List) (obj)).add(new com.cyberlink.youcammakeup.database.more.d.c("look_thumb_22", "Natural", "Party", null, null, null, null));
        ((List) (obj)).add(new com.cyberlink.youcammakeup.database.more.d.c("look_thumb_21", "Natural", "Daily", null, null, null, null));
        ((List) (obj)).add(new com.cyberlink.youcammakeup.database.more.d.c("look_thumb_19", "Natural", "Party", null, null, null, null));
        ((List) (obj)).add(new com.cyberlink.youcammakeup.database.more.d.c("look_thumb_10", "Natural", "Party", null, null, null, null));
        ((List) (obj)).add(new com.cyberlink.youcammakeup.database.more.d.c("look_thumb_09", "Natural", "Daily", null, null, null, null));
        ((List) (obj)).add(new com.cyberlink.youcammakeup.database.more.d.c("look_thumb_18", "Natural", "Daily", null, null, null, null));
        ((List) (obj)).add(new com.cyberlink.youcammakeup.database.more.d.c("look_thumb_20", "Natural", "Daily", null, null, null, null));
        ((List) (obj)).add(new com.cyberlink.youcammakeup.database.more.d.c("look_thumb_32", "Costume", "Halloween", null, null, null, null));
        ((List) (obj)).add(new com.cyberlink.youcammakeup.database.more.d.c("look_thumb_28", "Costume", "Halloween", null, null, null, null));
        ((List) (obj)).add(new com.cyberlink.youcammakeup.database.more.d.c("look_thumb_25", "Costume", "Celebrity", null, null, null, null));
        ((List) (obj)).add(new com.cyberlink.youcammakeup.database.more.d.c("look_thumb_30", "Costume", "Halloween", null, null, null, null));
        ((List) (obj)).add(new com.cyberlink.youcammakeup.database.more.d.c("look_thumb_24", "Costume", "Halloween", null, null, null, null));
        ((List) (obj)).add(new com.cyberlink.youcammakeup.database.more.d.c("look_thumb_31", "Costume", "Halloween", null, null, null, null));
        ((List) (obj)).add(new com.cyberlink.youcammakeup.database.more.d.c("look_20141120_thumb_05", "Costume", "Holidays", null, null, null, null));
        ((List) (obj)).add(new com.cyberlink.youcammakeup.database.more.d.c("look_20141120_thumb_02", "Costume", "Holidays", null, null, null, null));
        ((List) (obj)).add(new com.cyberlink.youcammakeup.database.more.d.c("look_20141120_thumb_03", "Costume", "Holidays", null, null, null, null));
        ((List) (obj)).add(new com.cyberlink.youcammakeup.database.more.d.c("look_20141120_thumb_07", "Costume", "Holidays", null, null, null, null));
        ((List) (obj)).add(new com.cyberlink.youcammakeup.database.more.d.c("look_20141120_thumb_04", "Costume", "Holidays", null, null, null, null));
        ((List) (obj)).add(new com.cyberlink.youcammakeup.database.more.d.c("look_20141120_thumb_08", "Costume", "Holidays", null, null, null, null));
        ((List) (obj)).add(new com.cyberlink.youcammakeup.database.more.d.c("look_20141120_thumb_01", "Costume", "Celebrity", null, null, null, null));
        ((List) (obj)).add(new com.cyberlink.youcammakeup.database.more.d.c("look_20150115_thumb_10", "Costume", "Valentine", null, null, null, null));
        ((List) (obj)).add(new com.cyberlink.youcammakeup.database.more.d.c("look_20150115_thumb_14", "Costume", "Valentine", null, null, null, null));
        ((List) (obj)).add(new com.cyberlink.youcammakeup.database.more.d.c("look_20150115_thumb_09", "Costume", "Valentine", null, null, null, null));
        ((List) (obj)).add(new com.cyberlink.youcammakeup.database.more.d.c("look_20150115_thumb_13", "Costume", "Valentine", null, null, null, null));
        ((List) (obj)).add(new com.cyberlink.youcammakeup.database.more.d.c("look_20150115_thumb_12", "Costume", "Valentine", null, null, null, null));
        ((List) (obj)).add(new com.cyberlink.youcammakeup.database.more.d.c("look_20150210_thumb_05", "Costume", "Celebrity", null, null, null, null));
        ((List) (obj)).add(new com.cyberlink.youcammakeup.database.more.d.c("look_20150210_thumb_04", "Costume", "Celebrity", null, null, null, null));
        ((List) (obj)).add(new com.cyberlink.youcammakeup.database.more.d.c("look_20150210_thumb_03", "Costume", "Celebrity", null, null, null, null));
        ((List) (obj)).add(new com.cyberlink.youcammakeup.database.more.d.c("look_20150115_thumb_01", "Costume", "Chinese Style", null, null, null, null));
        ((List) (obj)).add(new com.cyberlink.youcammakeup.database.more.d.c("look_20150115_thumb_02", "Costume", "Chinese Style", null, null, null, null));
        ((List) (obj)).add(new com.cyberlink.youcammakeup.database.more.d.c("look_20150115_thumb_05", "Costume", "Chinese Style", null, null, null, null));
        ((List) (obj)).add(new com.cyberlink.youcammakeup.database.more.d.c("look_20150115_thumb_08", "Costume", "Chinese Style", null, null, null, null));
        ((List) (obj)).add(new com.cyberlink.youcammakeup.database.more.d.c("look_20150115_thumb_04", "Costume", "Chinese Style", null, null, null, null));
        ((List) (obj)).add(new com.cyberlink.youcammakeup.database.more.d.c("look_20150115_thumb_03", "Costume", "Chinese Style", null, null, null, null));
        ((List) (obj)).add(new com.cyberlink.youcammakeup.database.more.d.c("look_20150210_thumb_01", "Costume", "Celebrity", null, null, null, null));
        ((List) (obj)).add(new com.cyberlink.youcammakeup.database.more.d.c("look_20141120_thumb_06", "Costume", "Holidays", null, null, null, null));
        ((List) (obj)).add(new com.cyberlink.youcammakeup.database.more.d.c("look_20150115_thumb_11", "Costume", "Valentine", null, null, null, null));
        ((List) (obj)).add(new com.cyberlink.youcammakeup.database.more.d.c("look_20150115_thumb_06", "Costume", "Chinese Style", null, null, null, null));
        ((List) (obj)).add(new com.cyberlink.youcammakeup.database.more.d.c("look_thumb_23", "Costume", "Celebrity", null, null, null, null));
        ((List) (obj)).add(new com.cyberlink.youcammakeup.database.more.d.c("look_thumb_26", "Costume", "Celebrity", null, null, null, null));
        ((List) (obj)).add(new com.cyberlink.youcammakeup.database.more.d.c("look_20150210_thumb_02", "Costume", "Celebrity", null, null, null, null));
        ((List) (obj)).add(new com.cyberlink.youcammakeup.database.more.d.c("look_thumb_04", "Natural", "Work", null, null, null, null));
        ((List) (obj)).add(new com.cyberlink.youcammakeup.database.more.d.c("look_thumb_15", "Natural", "Dating", null, null, null, null));
        ((List) (obj)).add(new com.cyberlink.youcammakeup.database.more.d.c("look_thumb_01", "Natural", "Work", null, null, null, null));
        ((List) (obj)).add(new com.cyberlink.youcammakeup.database.more.d.c("look_thumb_11", "Natural", "Daily", null, null, null, null));
        ((List) (obj)).add(new com.cyberlink.youcammakeup.database.more.d.c("look_thumb_12", "Natural", "Dating", null, null, null, null));
        ((List) (obj)).add(new com.cyberlink.youcammakeup.database.more.d.c("look_thumb_14", "Natural", "Daily", null, null, null, null));
        ((List) (obj)).add(new com.cyberlink.youcammakeup.database.more.d.c("look_thumb_07", "Natural", "Daily", null, null, null, null));
        ((List) (obj)).add(new com.cyberlink.youcammakeup.database.more.d.c("look_thumb_03", "Natural", "Party", null, null, null, null));
        ((List) (obj)).add(new com.cyberlink.youcammakeup.database.more.d.c("look_thumb_08", "Natural", "Party", null, null, null, null));
        ((List) (obj)).add(new com.cyberlink.youcammakeup.database.more.d.c("look_thumb_16", "Natural", "Work", null, null, null, null));
        ((List) (obj)).add(new com.cyberlink.youcammakeup.database.more.d.c("look_thumb_06", "Natural", "Party", null, null, null, null));
        ((List) (obj)).add(new com.cyberlink.youcammakeup.database.more.d.c("look_thumb_05", "Natural", "Dating", null, null, null, null));
        ((List) (obj)).add(new com.cyberlink.youcammakeup.database.more.d.c("look_thumb_02", "Natural", "Dating", null, null, null, null));
        ((List) (obj)).add(new com.cyberlink.youcammakeup.database.more.d.c("look_20150313_thumb_01", "Costume", "Celebrity", null, null, null, null));
        ((List) (obj)).add(new com.cyberlink.youcammakeup.database.more.d.c("look_20150313_thumb_02", "Costume", "Celebrity", null, null, null, null));
        ((List) (obj)).add(new com.cyberlink.youcammakeup.database.more.d.c("look_20150313_thumb_03", "Costume", "Spring", null, null, null, null));
        ((List) (obj)).add(new com.cyberlink.youcammakeup.database.more.d.c("look_20150313_thumb_04", "Costume", "Spring", null, null, null, null));
        com.cyberlink.youcammakeup.database.more.d.c c2;
        for (Iterator iterator = ((List) (obj)).iterator(); iterator.hasNext(); com.cyberlink.youcammakeup.h.l().b(c2.a()))
        {
            c2 = (com.cyberlink.youcammakeup.database.more.d.c)iterator.next();
        }

        com.cyberlink.youcammakeup.database.more.d.c c1;
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); com.cyberlink.youcammakeup.h.l().a(c1))
        {
            c1 = (com.cyberlink.youcammakeup.database.more.d.c)((Iterator) (obj)).next();
        }

    }

    static List v(String s1)
    {
        ArrayList arraylist;
        Iterator iterator;
        s1 = com.cyberlink.youcammakeup.h.g().a(s1);
        arraylist = new ArrayList();
        iterator = s1.iterator();
_L2:
        String s2;
        String s3;
        PanelDataCenter.Mask.Position position;
        PanelDataCenter.Mask.EyeShadowSide eyeshadowside;
        String s4;
        String s5;
        String s6;
        String s7;
        String s8;
        PanelDataCenter.Mask.Position position1;
        PanelDataCenter.Mask.EyeShadowSide eyeshadowside1;
        String s9;
        String s12;
        String s13;
        Point point;
        Point point1;
        Point point2;
        Point point3;
        Point point4;
        Point point5;
        Point point6;
        Point point7;
        Point point8;
        Point point9;
        Point point10;
        Point point11;
        Point point12;
        Point point13;
        Point point14;
        Point point15;
        Point point16;
        Point point17;
        Point point18;
        String s14;
        String s15;
        int i1;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        s1 = (com.cyberlink.youcammakeup.database.more.e.a)iterator.next();
        s12 = s1.a();
        s13 = s1.b();
        s5 = "";
        s6 = "";
        s7 = "";
        s9 = s1.d();
        position1 = com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask.Position.e;
        point = new Point();
        point1 = new Point();
        point2 = new Point();
        point3 = new Point();
        eyeshadowside1 = com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask.EyeShadowSide.a;
        point4 = new Point();
        point5 = new Point();
        point6 = new Point();
        point7 = new Point();
        point8 = new Point();
        point9 = new Point();
        point10 = new Point();
        point11 = new Point();
        point12 = new Point();
        point13 = new Point();
        point14 = new Point();
        point15 = new Point();
        point16 = new Point();
        point17 = new Point();
        point18 = new Point();
        s8 = "";
        s14 = s1.e();
        s15 = s1.f();
        i1 = Integer.valueOf(s1.c()).intValue();
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        Object obj = new JSONObject(s9);
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        String s10 = ((JSONObject) (obj)).optString("position");
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        s9 = ((JSONObject) (obj)).optString("eyeshadowside");
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        s5 = ((JSONObject) (obj)).optString("shapesrc");
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        s6 = ((JSONObject) (obj)).optString("imagesrc");
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        s7 = ((JSONObject) (obj)).optString("secondsrc");
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        String as1[] = ((JSONObject) (obj)).optString("eyeleft").split(",");
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        String as2[] = ((JSONObject) (obj)).optString("eyetop").split(",");
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        String as3[] = ((JSONObject) (obj)).optString("eyeright").split(",");
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        String as5[] = ((JSONObject) (obj)).optString("eyebottom").split(",");
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        String as6[] = ((JSONObject) (obj)).optString("browhead").split(",");
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        String as7[] = ((JSONObject) (obj)).optString("browtop").split(",");
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        String as8[] = ((JSONObject) (obj)).optString("browtail").split(",");
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        String as9[] = ((JSONObject) (obj)).optString("basicbrowhead").split(",");
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        String as10[] = ((JSONObject) (obj)).optString("basicbrowtop").split(",");
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        String as11[] = ((JSONObject) (obj)).optString("basicbrowtail").split(",");
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        String as12[] = ((JSONObject) (obj)).optString("basiceyehead").split(",");
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        String as13[] = ((JSONObject) (obj)).optString("basiceyetop").split(",");
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        String as14[] = ((JSONObject) (obj)).optString("basiceyetail").split(",");
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        String as15[] = ((JSONObject) (obj)).optString("modelanchorleft").split(",");
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        String as16[] = ((JSONObject) (obj)).optString("modelanchorright").split(",");
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        String as17[] = ((JSONObject) (obj)).optString("modelanchorlefttop").split(",");
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        String as18[] = ((JSONObject) (obj)).optString("modelanchorleftbottom").split(",");
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        String as19[] = ((JSONObject) (obj)).optString("modelanchorrighttop").split(",");
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        String as4[] = ((JSONObject) (obj)).optString("modelanchorrightbottom").split(",");
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        s8 = ((JSONObject) (obj)).optString("eyewearwidth");
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        position1 = com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask.a(s10);
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        eyeshadowside1 = com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask.b(s9);
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        if (as1.length != 2)
        {
            break MISSING_BLOCK_LABEL_1325;
        }
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        point.x = Integer.parseInt(as1[0]);
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        point.y = Integer.parseInt(as1[1]);
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        if (as2.length != 2)
        {
            break MISSING_BLOCK_LABEL_1416;
        }
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        point1.x = Integer.parseInt(as2[0]);
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        point1.y = Integer.parseInt(as2[1]);
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        if (as3.length != 2)
        {
            break MISSING_BLOCK_LABEL_1507;
        }
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        point2.x = Integer.parseInt(as3[0]);
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        point2.y = Integer.parseInt(as3[1]);
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        if (as5.length != 2)
        {
            break MISSING_BLOCK_LABEL_1598;
        }
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        point3.x = Integer.parseInt(as5[0]);
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        point3.y = Integer.parseInt(as5[1]);
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        if (as6.length != 2)
        {
            break MISSING_BLOCK_LABEL_1689;
        }
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        point4.x = Integer.parseInt(as6[0]);
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        point4.y = Integer.parseInt(as6[1]);
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        if (as7.length != 2)
        {
            break MISSING_BLOCK_LABEL_1780;
        }
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        point5.x = Integer.parseInt(as7[0]);
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        point5.y = Integer.parseInt(as7[1]);
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        if (as8.length != 2)
        {
            break MISSING_BLOCK_LABEL_1871;
        }
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        point6.x = Integer.parseInt(as8[0]);
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        point6.y = Integer.parseInt(as8[1]);
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        if (as9.length != 2)
        {
            break MISSING_BLOCK_LABEL_1962;
        }
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        point7.x = Integer.parseInt(as9[0]);
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        point7.y = Integer.parseInt(as9[1]);
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        if (as10.length != 2)
        {
            break MISSING_BLOCK_LABEL_2053;
        }
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        point8.x = Integer.parseInt(as10[0]);
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        point8.y = Integer.parseInt(as10[1]);
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        if (as11.length != 2)
        {
            break MISSING_BLOCK_LABEL_2144;
        }
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        point9.x = Integer.parseInt(as11[0]);
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        point9.y = Integer.parseInt(as11[1]);
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        if (as12.length != 2)
        {
            break MISSING_BLOCK_LABEL_2235;
        }
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        point10.x = Integer.parseInt(as12[0]);
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        point10.y = Integer.parseInt(as12[1]);
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        if (as13.length != 2)
        {
            break MISSING_BLOCK_LABEL_2326;
        }
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        point11.x = Integer.parseInt(as13[0]);
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        point11.y = Integer.parseInt(as13[1]);
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        if (as14.length != 2)
        {
            break MISSING_BLOCK_LABEL_2417;
        }
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        point12.x = Integer.parseInt(as14[0]);
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        point12.y = Integer.parseInt(as14[1]);
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        if (as15.length != 2)
        {
            break MISSING_BLOCK_LABEL_2508;
        }
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        point13.x = Integer.parseInt(as15[0]);
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        point13.y = Integer.parseInt(as15[1]);
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        if (as16.length != 2)
        {
            break MISSING_BLOCK_LABEL_2599;
        }
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        point14.x = Integer.parseInt(as16[0]);
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        point14.y = Integer.parseInt(as16[1]);
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        if (as17.length != 2)
        {
            break MISSING_BLOCK_LABEL_2690;
        }
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        point15.x = Integer.parseInt(as17[0]);
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        point15.y = Integer.parseInt(as17[1]);
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        if (as18.length != 2)
        {
            break MISSING_BLOCK_LABEL_2781;
        }
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        point16.x = Integer.parseInt(as18[0]);
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        point16.y = Integer.parseInt(as18[1]);
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        if (as19.length != 2)
        {
            break MISSING_BLOCK_LABEL_2872;
        }
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        point17.x = Integer.parseInt(as19[0]);
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        point17.y = Integer.parseInt(as19[1]);
        PanelDataCenter.Mask.Position position2;
        PanelDataCenter.Mask.EyeShadowSide eyeshadowside2;
        String s11;
        s9 = s5;
        s10 = s6;
        obj = s7;
        position2 = position1;
        eyeshadowside2 = eyeshadowside1;
        s11 = s8;
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        if (as4.length != 2)
        {
            break MISSING_BLOCK_LABEL_3011;
        }
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        point18.x = Integer.parseInt(as4[0]);
        s1 = s5;
        s2 = s6;
        s3 = s7;
        position = position1;
        eyeshadowside = eyeshadowside1;
        s4 = s8;
        point18.y = Integer.parseInt(as4[1]);
        s11 = s8;
        eyeshadowside2 = eyeshadowside1;
        position2 = position1;
        obj = s7;
        s10 = s6;
        s9 = s5;
_L3:
        arraylist.add(new PanelDataCenter.Mask(s12, s13, s9, s10, ((String) (obj)), position2, point, point1, point2, point3, eyeshadowside2, point4, point5, point6, point7, point8, point9, point10, point11, point12, point13, point14, point15, point16, point17, point18, s11, i1, s14, s15));
        if (true) goto _L2; else goto _L1
        JSONException jsonexception;
        jsonexception;
        com.pf.common.utility.m.e("TemplateUtils", jsonexception.toString());
        s9 = s1;
        s10 = s2;
        obj = s3;
        position2 = position;
        eyeshadowside2 = eyeshadowside;
        s11 = s4;
          goto _L3
_L1:
        return arraylist;
    }

    public static void v()
    {
        if (!com.cyberlink.youcammakeup.kernelctrl.z.p())
        {
            SQLiteDatabase sqlitedatabase = com.cyberlink.youcammakeup.h.b();
            sqlitedatabase.execSQL("Delete from ColorInfo where Source is NULL");
            sqlitedatabase.execSQL("Delete from PaletteInfo where GUID is NULL");
            com.cyberlink.youcammakeup.h.m().b();
            com.cyberlink.youcammakeup.h.m().a();
            com.cyberlink.youcammakeup.kernelctrl.z.s();
        }
        if (!com.cyberlink.youcammakeup.kernelctrl.z.q())
        {
            com.cyberlink.youcammakeup.h.m().a();
            com.cyberlink.youcammakeup.h.o().a();
            com.cyberlink.youcammakeup.kernelctrl.z.t();
        }
        if (!com.cyberlink.youcammakeup.kernelctrl.z.r())
        {
            DatabaseUpgradeHelper.a(com.cyberlink.youcammakeup.h.b(), com.cyberlink.youcammakeup.database.more.DatabaseUpgradeHelper.UpgradeType.b);
            com.cyberlink.youcammakeup.h.m().a();
            com.cyberlink.youcammakeup.h.o().a();
            com.cyberlink.youcammakeup.kernelctrl.z.u();
        }
    }

    private static as w()
    {
        av av1 = new av();
        an an1 = new an();
        av1.o = "Original";
        return new as("default_original_looks", "assets://makeup/thumb/original_looks.jpg", "", 1.0F, av1, an1, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.a, Boolean.valueOf(false), new ArrayList());
    }

    static List w(String s1)
    {
        ArrayList arraylist;
        Iterator iterator;
        s1 = com.cyberlink.youcammakeup.h.h().a(s1);
        arraylist = new ArrayList();
        iterator = s1.iterator();
_L2:
        String s2;
        PanelDataCenter.TattooMask.TattooPosition tattooposition;
        PanelDataCenter.TattooMask.TattooEyeShadowSide tattooeyeshadowside;
        PanelDataCenter.TattooMask.TattooEyeShadowSide tattooeyeshadowside1;
        PanelDataCenter.TattooMask.TattooBlendMode tattooblendmode;
        String s3;
        String s4;
        PanelDataCenter.TattooMask.TattooPosition tattooposition1;
        PanelDataCenter.TattooMask.TattooEyeShadowSide tattooeyeshadowside2;
        PanelDataCenter.TattooMask.TattooEyeShadowSide tattooeyeshadowside3;
        PanelDataCenter.TattooMask.TattooBlendMode tattooblendmode1;
        Object obj;
        String s6;
        String s7;
        Point point;
        Point point1;
        Point point2;
        Point point3;
        Point point4;
        Point point5;
        Point point6;
        int i1;
        int j1;
        int l1;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        s1 = (com.cyberlink.youcammakeup.database.more.k.a)iterator.next();
        s6 = s1.a();
        s7 = s1.b();
        s3 = "";
        s4 = "";
        obj = s1.d();
        tattooposition1 = com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask.TattooPosition.e;
        point = new Point();
        point1 = new Point();
        point2 = new Point();
        point3 = new Point();
        tattooeyeshadowside2 = com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask.TattooEyeShadowSide.a;
        point4 = new Point();
        point5 = new Point();
        point6 = new Point();
        l1 = Integer.valueOf(s1.c()).intValue();
        tattooeyeshadowside3 = com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask.TattooEyeShadowSide.a;
        tattooblendmode1 = com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask.TattooBlendMode.b;
        j1 = 0;
        s1 = s3;
        s2 = s4;
        tattooposition = tattooposition1;
        tattooeyeshadowside = tattooeyeshadowside2;
        tattooeyeshadowside1 = tattooeyeshadowside3;
        tattooblendmode = tattooblendmode1;
        i1 = j1;
        obj = new JSONObject(((String) (obj)));
        s1 = s3;
        s2 = s4;
        tattooposition = tattooposition1;
        tattooeyeshadowside = tattooeyeshadowside2;
        tattooeyeshadowside1 = tattooeyeshadowside3;
        tattooblendmode = tattooblendmode1;
        i1 = j1;
        String s9 = ((JSONObject) (obj)).optString("position");
        s1 = s3;
        s2 = s4;
        tattooposition = tattooposition1;
        tattooeyeshadowside = tattooeyeshadowside2;
        tattooeyeshadowside1 = tattooeyeshadowside3;
        tattooblendmode = tattooblendmode1;
        i1 = j1;
        String s8 = ((JSONObject) (obj)).optString("eyeshadowside");
        s1 = s3;
        s2 = s4;
        tattooposition = tattooposition1;
        tattooeyeshadowside = tattooeyeshadowside2;
        tattooeyeshadowside1 = tattooeyeshadowside3;
        tattooblendmode = tattooblendmode1;
        i1 = j1;
        Object obj1 = ((JSONObject) (obj)).optString("side");
        s1 = s3;
        s2 = s4;
        tattooposition = tattooposition1;
        tattooeyeshadowside = tattooeyeshadowside2;
        tattooeyeshadowside1 = tattooeyeshadowside3;
        tattooblendmode = tattooblendmode1;
        i1 = j1;
        String s5 = ((JSONObject) (obj)).optString("blend_mode");
        s1 = s3;
        s2 = s4;
        tattooposition = tattooposition1;
        tattooeyeshadowside = tattooeyeshadowside2;
        tattooeyeshadowside1 = tattooeyeshadowside3;
        tattooblendmode = tattooblendmode1;
        i1 = j1;
        s3 = ((JSONObject) (obj)).optString("shapesrc");
        s1 = s3;
        s2 = s4;
        tattooposition = tattooposition1;
        tattooeyeshadowside = tattooeyeshadowside2;
        tattooeyeshadowside1 = tattooeyeshadowside3;
        tattooblendmode = tattooblendmode1;
        i1 = j1;
        s4 = ((JSONObject) (obj)).optString("imagesrc");
        s1 = s3;
        s2 = s4;
        tattooposition = tattooposition1;
        tattooeyeshadowside = tattooeyeshadowside2;
        tattooeyeshadowside1 = tattooeyeshadowside3;
        tattooblendmode = tattooblendmode1;
        i1 = j1;
        String as1[] = ((JSONObject) (obj)).optString("eyeleft").split(",");
        s1 = s3;
        s2 = s4;
        tattooposition = tattooposition1;
        tattooeyeshadowside = tattooeyeshadowside2;
        tattooeyeshadowside1 = tattooeyeshadowside3;
        tattooblendmode = tattooblendmode1;
        i1 = j1;
        String as2[] = ((JSONObject) (obj)).optString("eyetop").split(",");
        s1 = s3;
        s2 = s4;
        tattooposition = tattooposition1;
        tattooeyeshadowside = tattooeyeshadowside2;
        tattooeyeshadowside1 = tattooeyeshadowside3;
        tattooblendmode = tattooblendmode1;
        i1 = j1;
        String as3[] = ((JSONObject) (obj)).optString("eyeright").split(",");
        s1 = s3;
        s2 = s4;
        tattooposition = tattooposition1;
        tattooeyeshadowside = tattooeyeshadowside2;
        tattooeyeshadowside1 = tattooeyeshadowside3;
        tattooblendmode = tattooblendmode1;
        i1 = j1;
        String as5[] = ((JSONObject) (obj)).optString("eyebottom").split(",");
        s1 = s3;
        s2 = s4;
        tattooposition = tattooposition1;
        tattooeyeshadowside = tattooeyeshadowside2;
        tattooeyeshadowside1 = tattooeyeshadowside3;
        tattooblendmode = tattooblendmode1;
        i1 = j1;
        String as6[] = ((JSONObject) (obj)).optString("browhead").split(",");
        s1 = s3;
        s2 = s4;
        tattooposition = tattooposition1;
        tattooeyeshadowside = tattooeyeshadowside2;
        tattooeyeshadowside1 = tattooeyeshadowside3;
        tattooblendmode = tattooblendmode1;
        i1 = j1;
        String as7[] = ((JSONObject) (obj)).optString("browtop").split(",");
        s1 = s3;
        s2 = s4;
        tattooposition = tattooposition1;
        tattooeyeshadowside = tattooeyeshadowside2;
        tattooeyeshadowside1 = tattooeyeshadowside3;
        tattooblendmode = tattooblendmode1;
        i1 = j1;
        String as4[] = ((JSONObject) (obj)).optString("browtail").split(",");
        s1 = s3;
        s2 = s4;
        tattooposition = tattooposition1;
        tattooeyeshadowside = tattooeyeshadowside2;
        tattooeyeshadowside1 = tattooeyeshadowside3;
        tattooblendmode = tattooblendmode1;
        i1 = j1;
        tattooposition1 = com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask.a(s9);
        s1 = s3;
        s2 = s4;
        tattooposition = tattooposition1;
        tattooeyeshadowside = tattooeyeshadowside2;
        tattooeyeshadowside1 = tattooeyeshadowside3;
        tattooblendmode = tattooblendmode1;
        i1 = j1;
        tattooeyeshadowside2 = com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask.b(s8);
        s1 = s3;
        s2 = s4;
        tattooposition = tattooposition1;
        tattooeyeshadowside = tattooeyeshadowside2;
        tattooeyeshadowside1 = tattooeyeshadowside3;
        tattooblendmode = tattooblendmode1;
        i1 = j1;
        tattooeyeshadowside3 = com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask.b(((String) (obj1)));
        s1 = s3;
        s2 = s4;
        tattooposition = tattooposition1;
        tattooeyeshadowside = tattooeyeshadowside2;
        tattooeyeshadowside1 = tattooeyeshadowside3;
        tattooblendmode = tattooblendmode1;
        i1 = j1;
        tattooblendmode1 = com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask.c(s5);
        s1 = s3;
        s2 = s4;
        tattooposition = tattooposition1;
        tattooeyeshadowside = tattooeyeshadowside2;
        tattooeyeshadowside1 = tattooeyeshadowside3;
        tattooblendmode = tattooblendmode1;
        i1 = j1;
        j1 = Integer.parseInt(((JSONObject) (obj)).optString("intensity"));
        s1 = s3;
        s2 = s4;
        tattooposition = tattooposition1;
        tattooeyeshadowside = tattooeyeshadowside2;
        tattooeyeshadowside1 = tattooeyeshadowside3;
        tattooblendmode = tattooblendmode1;
        i1 = j1;
        if (as1.length != 2)
        {
            break MISSING_BLOCK_LABEL_953;
        }
        s1 = s3;
        s2 = s4;
        tattooposition = tattooposition1;
        tattooeyeshadowside = tattooeyeshadowside2;
        tattooeyeshadowside1 = tattooeyeshadowside3;
        tattooblendmode = tattooblendmode1;
        i1 = j1;
        point.x = Integer.parseInt(as1[0]);
        s1 = s3;
        s2 = s4;
        tattooposition = tattooposition1;
        tattooeyeshadowside = tattooeyeshadowside2;
        tattooeyeshadowside1 = tattooeyeshadowside3;
        tattooblendmode = tattooblendmode1;
        i1 = j1;
        point.y = Integer.parseInt(as1[1]);
        s1 = s3;
        s2 = s4;
        tattooposition = tattooposition1;
        tattooeyeshadowside = tattooeyeshadowside2;
        tattooeyeshadowside1 = tattooeyeshadowside3;
        tattooblendmode = tattooblendmode1;
        i1 = j1;
        if (as2.length != 2)
        {
            break MISSING_BLOCK_LABEL_1056;
        }
        s1 = s3;
        s2 = s4;
        tattooposition = tattooposition1;
        tattooeyeshadowside = tattooeyeshadowside2;
        tattooeyeshadowside1 = tattooeyeshadowside3;
        tattooblendmode = tattooblendmode1;
        i1 = j1;
        point1.x = Integer.parseInt(as2[0]);
        s1 = s3;
        s2 = s4;
        tattooposition = tattooposition1;
        tattooeyeshadowside = tattooeyeshadowside2;
        tattooeyeshadowside1 = tattooeyeshadowside3;
        tattooblendmode = tattooblendmode1;
        i1 = j1;
        point1.y = Integer.parseInt(as2[1]);
        s1 = s3;
        s2 = s4;
        tattooposition = tattooposition1;
        tattooeyeshadowside = tattooeyeshadowside2;
        tattooeyeshadowside1 = tattooeyeshadowside3;
        tattooblendmode = tattooblendmode1;
        i1 = j1;
        if (as3.length != 2)
        {
            break MISSING_BLOCK_LABEL_1159;
        }
        s1 = s3;
        s2 = s4;
        tattooposition = tattooposition1;
        tattooeyeshadowside = tattooeyeshadowside2;
        tattooeyeshadowside1 = tattooeyeshadowside3;
        tattooblendmode = tattooblendmode1;
        i1 = j1;
        point2.x = Integer.parseInt(as3[0]);
        s1 = s3;
        s2 = s4;
        tattooposition = tattooposition1;
        tattooeyeshadowside = tattooeyeshadowside2;
        tattooeyeshadowside1 = tattooeyeshadowside3;
        tattooblendmode = tattooblendmode1;
        i1 = j1;
        point2.y = Integer.parseInt(as3[1]);
        s1 = s3;
        s2 = s4;
        tattooposition = tattooposition1;
        tattooeyeshadowside = tattooeyeshadowside2;
        tattooeyeshadowside1 = tattooeyeshadowside3;
        tattooblendmode = tattooblendmode1;
        i1 = j1;
        if (as5.length != 2)
        {
            break MISSING_BLOCK_LABEL_1262;
        }
        s1 = s3;
        s2 = s4;
        tattooposition = tattooposition1;
        tattooeyeshadowside = tattooeyeshadowside2;
        tattooeyeshadowside1 = tattooeyeshadowside3;
        tattooblendmode = tattooblendmode1;
        i1 = j1;
        point3.x = Integer.parseInt(as5[0]);
        s1 = s3;
        s2 = s4;
        tattooposition = tattooposition1;
        tattooeyeshadowside = tattooeyeshadowside2;
        tattooeyeshadowside1 = tattooeyeshadowside3;
        tattooblendmode = tattooblendmode1;
        i1 = j1;
        point3.y = Integer.parseInt(as5[1]);
        s1 = s3;
        s2 = s4;
        tattooposition = tattooposition1;
        tattooeyeshadowside = tattooeyeshadowside2;
        tattooeyeshadowside1 = tattooeyeshadowside3;
        tattooblendmode = tattooblendmode1;
        i1 = j1;
        if (as6.length != 2)
        {
            break MISSING_BLOCK_LABEL_1365;
        }
        s1 = s3;
        s2 = s4;
        tattooposition = tattooposition1;
        tattooeyeshadowside = tattooeyeshadowside2;
        tattooeyeshadowside1 = tattooeyeshadowside3;
        tattooblendmode = tattooblendmode1;
        i1 = j1;
        point4.x = Integer.parseInt(as6[0]);
        s1 = s3;
        s2 = s4;
        tattooposition = tattooposition1;
        tattooeyeshadowside = tattooeyeshadowside2;
        tattooeyeshadowside1 = tattooeyeshadowside3;
        tattooblendmode = tattooblendmode1;
        i1 = j1;
        point4.y = Integer.parseInt(as6[1]);
        s1 = s3;
        s2 = s4;
        tattooposition = tattooposition1;
        tattooeyeshadowside = tattooeyeshadowside2;
        tattooeyeshadowside1 = tattooeyeshadowside3;
        tattooblendmode = tattooblendmode1;
        i1 = j1;
        if (as7.length != 2)
        {
            break MISSING_BLOCK_LABEL_1468;
        }
        s1 = s3;
        s2 = s4;
        tattooposition = tattooposition1;
        tattooeyeshadowside = tattooeyeshadowside2;
        tattooeyeshadowside1 = tattooeyeshadowside3;
        tattooblendmode = tattooblendmode1;
        i1 = j1;
        point5.x = Integer.parseInt(as7[0]);
        s1 = s3;
        s2 = s4;
        tattooposition = tattooposition1;
        tattooeyeshadowside = tattooeyeshadowside2;
        tattooeyeshadowside1 = tattooeyeshadowside3;
        tattooblendmode = tattooblendmode1;
        i1 = j1;
        point5.y = Integer.parseInt(as7[1]);
        PanelDataCenter.TattooMask.TattooEyeShadowSide tattooeyeshadowside4;
        PanelDataCenter.TattooMask.TattooEyeShadowSide tattooeyeshadowside5;
        PanelDataCenter.TattooMask.TattooBlendMode tattooblendmode2;
        int k1;
        obj = s3;
        s5 = s4;
        obj1 = tattooposition1;
        tattooeyeshadowside4 = tattooeyeshadowside2;
        tattooeyeshadowside5 = tattooeyeshadowside3;
        tattooblendmode2 = tattooblendmode1;
        k1 = j1;
        s1 = s3;
        s2 = s4;
        tattooposition = tattooposition1;
        tattooeyeshadowside = tattooeyeshadowside2;
        tattooeyeshadowside1 = tattooeyeshadowside3;
        tattooblendmode = tattooblendmode1;
        i1 = j1;
        if (as4.length != 2)
        {
            break MISSING_BLOCK_LABEL_1627;
        }
        s1 = s3;
        s2 = s4;
        tattooposition = tattooposition1;
        tattooeyeshadowside = tattooeyeshadowside2;
        tattooeyeshadowside1 = tattooeyeshadowside3;
        tattooblendmode = tattooblendmode1;
        i1 = j1;
        point6.x = Integer.parseInt(as4[0]);
        s1 = s3;
        s2 = s4;
        tattooposition = tattooposition1;
        tattooeyeshadowside = tattooeyeshadowside2;
        tattooeyeshadowside1 = tattooeyeshadowside3;
        tattooblendmode = tattooblendmode1;
        i1 = j1;
        point6.y = Integer.parseInt(as4[1]);
        k1 = j1;
        tattooblendmode2 = tattooblendmode1;
        tattooeyeshadowside5 = tattooeyeshadowside3;
        tattooeyeshadowside4 = tattooeyeshadowside2;
        obj1 = tattooposition1;
        s5 = s4;
        obj = s3;
_L3:
        arraylist.add(new PanelDataCenter.TattooMask(s6, s7, ((String) (obj)), s5, ((PanelDataCenter.TattooMask.TattooPosition) (obj1)), point, point1, point2, point3, tattooeyeshadowside4, point4, point5, point6, l1, tattooeyeshadowside5, tattooblendmode2, k1));
        if (true) goto _L2; else goto _L1
        JSONException jsonexception;
        jsonexception;
        com.pf.common.utility.m.e("TemplateUtils", jsonexception.toString());
        obj = s1;
        s5 = s2;
        obj1 = tattooposition;
        tattooeyeshadowside4 = tattooeyeshadowside;
        tattooeyeshadowside5 = tattooeyeshadowside1;
        tattooblendmode2 = tattooblendmode;
        k1 = i1;
          goto _L3
_L1:
        return arraylist;
    }

    private static as x()
    {
        av av1 = new av();
        an an1 = new an();
        av1.o = "Switcher";
        return new as("default_switcher_looks", "assets://makeup/thumb/original_looks.jpg", "", 1.0F, av1, an1, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.a, Boolean.valueOf(false), new ArrayList());
    }

    static List x(String s1)
    {
        return a(com.cyberlink.youcammakeup.h.i().a(s1));
    }

    static String y(String s1)
    {
        return com.cyberlink.youcammakeup.h.l().a(s1);
    }

    public static as z(String s1)
    {
        if (s1 == null)
        {
            return w();
        }
        if (s1.equals("default_original_looks"))
        {
            return w();
        }
        if (s1.equals("default_switcher_looks"))
        {
            return x();
        }
        com.cyberlink.youcammakeup.database.more.d.e e1 = com.cyberlink.youcammakeup.h.k().a(s1);
        if (e1 == null)
        {
            return w();
        }
        Object obj = (List)com.cyberlink.youcammakeup.h.m().b(s1);
        PanelDataCenter.SourceType sourcetype = PanelDataCenter.SourceType.valueOf(e1.g());
        boolean flag = e1.i();
        ArrayList arraylist = new ArrayList();
        av av1 = com.cyberlink.youcammakeup.utility.av.a(e1.c());
        an an1 = com.cyberlink.youcammakeup.utility.an.a(e1.d());
        float f1 = e1.b();
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); arraylist.add(A((String)((Iterator) (obj)).next()))) { }
        return new as(s1, e1.e(), e1.f(), f1, av1, an1, sourcetype, Boolean.valueOf(flag), arraylist);
    }

}
