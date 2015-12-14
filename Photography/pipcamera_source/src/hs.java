// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.Log;
import com.crashlytics.android.Crashlytics;
import com.fotoable.fotoproedit.activity.font.FontOnlineInfo;
import com.fotoable.fotoproedit.activity.font.FontTextLabelInfo;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.pipcamera.application.PIPCameraApplication;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class hs
{

    private static hs f = null;
    private String a;
    private String b;
    private ArrayList c;
    private ArrayList d;
    private ArrayList e;
    private tm g;
    private String h;

    private hs()
    {
        a = "FontTextManager";
        b = "textbg";
        h = "textbgsavefilename";
        f();
        g();
        if (g == null)
        {
            g = new tm(PIPCameraApplication.b().c(), "textBg");
        }
        h();
    }

    private Rect a(JSONObject jsonobject)
    {
        int l = kv.e(jsonobject, "x");
        int i1 = kv.e(jsonobject, "y");
        return new Rect(l, i1, kv.e(jsonobject, "w") + l, kv.e(jsonobject, "h") + i1);
    }

    private FontOnlineInfo a(String s, boolean flag)
    {
        int l;
        boolean flag1;
        flag1 = true;
        l = 0;
        if (!flag) goto _L2; else goto _L1
_L1:
        Object obj;
        FontOnlineInfo fontonlineinfo;
        JSONObject jsonobject;
        FontTextLabelInfo fonttextlabelinfo;
        try
        {
            obj = a((new StringBuilder()).append(s).append("/conf.json").toString());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
          goto _L3
_L2:
        obj = b((new StringBuilder()).append(s).append("/conf.json").toString());
          goto _L3
_L12:
        fontonlineinfo = new FontOnlineInfo();
        fontonlineinfo.icon = (new StringBuilder()).append(s).append("/").append(kv.a(((JSONObject) (obj)), "iconName")).toString();
        fontonlineinfo.viewW = kv.e(((JSONObject) (obj)), "containerW");
        fontonlineinfo.viewH = kv.e(((JSONObject) (obj)), "containerH");
        fontonlineinfo.resId = kv.e(((JSONObject) (obj)), "rid");
        fontonlineinfo.folderName = s;
        if (!flag)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        fontonlineinfo.isLocalOnlineRes = flag;
        fontonlineinfo.hasBg = true;
        obj = kv.b(((JSONObject) (obj)), "decorations");
        if (obj == null) goto _L5; else goto _L4
_L4:
        if (((JSONArray) (obj)).length() <= 0) goto _L5; else goto _L6
_L6:
        if (l >= ((JSONArray) (obj)).length()) goto _L5; else goto _L7
_L7:
        jsonobject = kv.a(((JSONArray) (obj)), l);
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_342;
        }
        fonttextlabelinfo = new FontTextLabelInfo();
        kv.e(jsonobject, "viewType");
        JVM INSTR tableswitch 0 1: default 339
    //                   0 274
    //                   1 285;
           goto _L8 _L9 _L10
_L8:
        fonttextlabelinfo.s = a(kv.c(jsonobject, "size"));
        fontonlineinfo.labelArray.add(fonttextlabelinfo);
        break MISSING_BLOCK_LABEL_342;
_L9:
        fonttextlabelinfo.u = com.fotoable.fotoproedit.activity.font.FontTextLabelInfo.TEXTBGVIEWTYPE.LABEL;
        continue; /* Loop/switch isn't completed */
_L10:
        fonttextlabelinfo.u = com.fotoable.fotoproedit.activity.font.FontTextLabelInfo.TEXTBGVIEWTYPE.IMAGEBG;
        fonttextlabelinfo.t = (new StringBuilder()).append(s).append("/").append(kv.a(jsonobject, "image")).toString();
        if (true) goto _L8; else goto _L5
_L5:
        return fontonlineinfo;
_L3:
        if (obj != null) goto _L12; else goto _L11
_L11:
        return null;
        l++;
          goto _L6
    }

    public static hs a()
    {
        if (f != null) goto _L2; else goto _L1
_L1:
        hs;
        JVM INSTR monitorenter ;
        f = new hs();
        hs;
        JVM INSTR monitorexit ;
_L2:
        return f;
        Exception exception;
        exception;
        hs;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static String a(hs hs1)
    {
        return hs1.a;
    }

    private JSONObject a(String s)
    {
        try
        {
            s = PIPCameraApplication.a.getAssets().open(s);
            byte abyte0[] = new byte[s.available()];
            s.read(abyte0);
            s.close();
            s = new JSONObject(new String(abyte0));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Crashlytics.logException(s);
            return null;
        }
        return s;
    }

    private JSONObject b(String s)
    {
        BufferedReader bufferedreader;
        StringBuffer stringbuffer;
        s = new FileReader(s);
        bufferedreader = new BufferedReader(s);
        stringbuffer = new StringBuffer();
_L1:
        String s1 = bufferedreader.readLine();
label0:
        {
            if (s1 == null)
            {
                break label0;
            }
            try
            {
                stringbuffer.append(s1);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                Crashlytics.logException(s);
                return null;
            }
        }
          goto _L1
        bufferedreader.close();
        s.close();
        s = stringbuffer.toString();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_100;
        }
        int l = s.length();
        if (l > 0)
        {
            try
            {
                s = new JSONObject(s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return null;
            }
            return s;
        }
        return null;
    }

    static tm b(hs hs1)
    {
        return hs1.g;
    }

    private void b(FontOnlineInfo fontonlineinfo)
    {
        boolean flag1 = false;
        if (e != null && e.size() > 0)
        {
            int l = 0;
            do
            {
label0:
                {
                    boolean flag = flag1;
                    if (l < e.size())
                    {
                        if (((FontOnlineInfo)e.get(l)).resId != fontonlineinfo.resId)
                        {
                            break label0;
                        }
                        e.set(l, fontonlineinfo);
                        flag = true;
                    }
                    if (!flag)
                    {
                        e.add(fontonlineinfo);
                    }
                    return;
                }
                l++;
            } while (true);
        } else
        {
            e.add(fontonlineinfo);
            return;
        }
    }

    static String c(hs hs1)
    {
        return hs1.h;
    }

    private ArrayList f()
    {
        d = new ArrayList();
        Object obj = a("textstyleRes.json");
        if (obj != null)
        {
            obj = kv.b(((JSONObject) (obj)), "data");
            if (obj != null && ((JSONArray) (obj)).length() > 0)
            {
                int l = 0;
                while (l < ((JSONArray) (obj)).length()) 
                {
                    JSONObject jsonobject = kv.a(((JSONArray) (obj)), l);
                    if (jsonobject != null)
                    {
                        try
                        {
                            FontTextLabelInfo fonttextlabelinfo = new FontTextLabelInfo();
                            if (kv.a(jsonobject, "textColor") != null)
                            {
                                fonttextlabelinfo.j = Color.parseColor((new StringBuilder()).append("#").append(kv.a(jsonobject, "textColor")).toString());
                            }
                            if (kv.a(jsonobject, "strokeColor") != null)
                            {
                                fonttextlabelinfo.h = Color.parseColor((new StringBuilder()).append("#").append(kv.a(jsonobject, "strokeColor")).toString());
                            }
                            if (kv.a(jsonobject, "shadowColor") != null)
                            {
                                fonttextlabelinfo.e = Color.parseColor((new StringBuilder()).append("#").append(kv.a(jsonobject, "shadowColor")).toString());
                            }
                            if (kv.a(jsonobject, "textureImage") != null)
                            {
                                fonttextlabelinfo.i = kv.a(jsonobject, "textureImage");
                            }
                            fonttextlabelinfo.g = kv.f(jsonobject, "strokeSize");
                            fonttextlabelinfo.d = kv.f(jsonobject, "shadowSize");
                            fonttextlabelinfo.a = kv.e(jsonobject, "infoflag");
                            fonttextlabelinfo.o = kv.d(jsonobject, "isImageTexture");
                            fonttextlabelinfo.n = kv.d(jsonobject, "isLinearImg");
                            fonttextlabelinfo.f = kv.d(jsonobject, "needGuassShadow");
                            d.add(fonttextlabelinfo);
                        }
                        catch (Exception exception)
                        {
                            exception.printStackTrace();
                        }
                    }
                    l++;
                }
            }
        }
        return d;
    }

    private ArrayList g()
    {
        c = new ArrayList();
        for (int l = 0; l < ia.a().a.size(); l++)
        {
            ml ml1 = (ml)ia.a().a.get(l);
            FontTextLabelInfo fonttextlabelinfo2 = new FontTextLabelInfo();
            fonttextlabelinfo2.o = false;
            fonttextlabelinfo2.j = ml1.a();
            c.add(fonttextlabelinfo2);
        }

        for (int i1 = 0; i1 < 51; i1++)
        {
            FontTextLabelInfo fonttextlabelinfo = new FontTextLabelInfo();
            String s = (new StringBuilder()).append("textRes/gradientH/gr_text_gradient_").append(i1).append(".png").toString();
            fonttextlabelinfo.n = true;
            fonttextlabelinfo.i = s;
            fonttextlabelinfo.o = true;
            c.add(fonttextlabelinfo);
        }

        for (int j1 = 0; j1 < 47; j1++)
        {
            FontTextLabelInfo fonttextlabelinfo1 = new FontTextLabelInfo();
            String s1 = (new StringBuilder()).append("textRes/texture/gr_text_texture_").append(j1).append(".jpg").toString();
            fonttextlabelinfo1.n = false;
            fonttextlabelinfo1.i = s1;
            fonttextlabelinfo1.o = true;
            c.add(fonttextlabelinfo1);
        }

        return c;
    }

    private void h()
    {
        k();
        if (e == null)
        {
            Log.e("test", "bgarray null");
        } else
        {
            Log.e("test", (new StringBuilder()).append("bgarray size1 ").append(e.size()).toString());
        }
        if (e == null)
        {
            e = new ArrayList();
            j();
            a(e);
        } else
        {
            boolean flag1 = e();
            Log.e("test", (new StringBuilder()).append("repair ").append(flag1).append("size ").append(e.size()).toString());
            boolean flag = flag1;
            if (i())
            {
                Log.e("test", (new StringBuilder()).append("check ").append(flag1).append("size ").append(e.size()).toString());
                flag = true;
            }
            j();
            Log.e("test", (new StringBuilder()).append("bgarray size2 ").append(e.size()).toString());
            if (flag)
            {
                a(e);
                return;
            }
        }
    }

    private boolean i()
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (e != null)
        {
            flag = flag1;
            if (e.size() > 0)
            {
                ArrayList arraylist = new ArrayList();
                for (int l = 0; l < e.size(); l++)
                {
                    FontOnlineInfo fontonlineinfo = (FontOnlineInfo)e.get(l);
                    if (!a(fontonlineinfo))
                    {
                        arraylist.add(fontonlineinfo);
                    }
                }

                flag = flag1;
                if (arraylist.size() > 0)
                {
                    e.removeAll(arraylist);
                    flag = true;
                }
            }
        }
        return flag;
    }

    private void j()
    {
        int i1 = 100;
        for (int l = 1; l <= 11;)
        {
            FontOnlineInfo fontonlineinfo = a(String.format("textbgRes/%d", new Object[] {
                Integer.valueOf(l)
            }), true);
            int j1 = i1;
            if (fontonlineinfo != null)
            {
                fontonlineinfo.resId = i1;
                j1 = i1 + 1;
                b(fontonlineinfo);
            }
            l++;
            i1 = j1;
        }

    }

    private void k()
    {
        Object obj = g.a(h, new ahq());
        if (obj == null) goto _L2; else goto _L1
_L1:
        Gson gson;
        obj = (String)obj;
        gson = new Gson();
        e = (ArrayList)gson.fromJson(((String) (obj)), (new TypeToken() {

            final hs a;

            
            {
                a = hs.this;
                super();
            }
        }).getType());
        obj = new ArrayList();
        int l = 0;
_L10:
        if (l >= e.size()) goto _L4; else goto _L3
_L3:
        FontOnlineInfo fontonlineinfo = (FontOnlineInfo)e.get(l);
        if (fontonlineinfo.icon == null || fontonlineinfo.icon != null && fontonlineinfo.icon.length() == 0)
        {
            ((List) (obj)).add(fontonlineinfo);
        }
          goto _L5
_L4:
        if (obj == null) goto _L2; else goto _L6
_L6:
        if (((List) (obj)).size() <= 0) goto _L2; else goto _L7
_L7:
        l = 0;
_L8:
        if (l >= ((List) (obj)).size())
        {
            break; /* Loop/switch isn't completed */
        }
        e.remove(((List) (obj)).get(l));
        l++;
        if (true) goto _L8; else goto _L2
        Object obj1;
        obj1;
        g.a(h);
_L2:
        return;
        obj1;
        g.a(h);
        return;
_L5:
        l++;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public FontOnlineInfo a(int l, boolean flag)
    {
        if (!flag)
        {
            String s = d().a();
            String s2 = String.format("%s_%d", new Object[] {
                b, Integer.valueOf(l)
            });
            s = (new StringBuilder()).append(s).append("/").append(s2).toString();
            Log.e("test", (new StringBuilder()).append(s).append(", islocal ").append(flag).toString());
            return a(s, flag);
        } else
        {
            String s1 = String.format("textbgRes/%d", new Object[] {
                Integer.valueOf(l - 99)
            });
            Log.e("test", (new StringBuilder()).append(s1).append(", islocal ").append(flag).toString());
            return a(s1, flag);
        }
    }

    public void a(List list)
    {
        list = new ArrayList(list);
        ht;
        JVM INSTR monitorenter ;
        (new ht(this, list)).execute(new Void[0]);
        ht;
        JVM INSTR monitorexit ;
        return;
        list;
        ht;
        JVM INSTR monitorexit ;
        throw list;
    }

    public boolean a(int l)
    {
        for (Iterator iterator = e.iterator(); iterator.hasNext();)
        {
            if (((FontOnlineInfo)iterator.next()).resId == l)
            {
                return true;
            }
        }

        return false;
    }

    public boolean a(FontOnlineInfo fontonlineinfo)
    {
_L2:
        return false;
        if (fontonlineinfo == null || fontonlineinfo.labelArray == null || fontonlineinfo.labelArray.size() <= 0) goto _L2; else goto _L1
_L1:
        int l = 0;
label0:
        do
        {
label1:
            {
                if (l >= fontonlineinfo.labelArray.size())
                {
                    break label1;
                }
                FontTextLabelInfo fonttextlabelinfo = (FontTextLabelInfo)fontonlineinfo.labelArray.get(l);
                if (fonttextlabelinfo.u == com.fotoable.fotoproedit.activity.font.FontTextLabelInfo.TEXTBGVIEWTYPE.IMAGEBG && (fonttextlabelinfo.t == null || fonttextlabelinfo.t.length() <= 0) || fonttextlabelinfo.s == null)
                {
                    break label0;
                }
                l++;
            }
        } while (true);
        if (true) goto _L2; else goto _L3
_L3:
        return true;
    }

    public ArrayList b()
    {
        return d;
    }

    public ArrayList c()
    {
        return c;
    }

    public tm d()
    {
        return g;
    }

    public boolean e()
    {
        int l;
        boolean flag;
        l = 0;
        flag = false;
_L2:
        FontOnlineInfo fontonlineinfo;
        if (l >= e.size())
        {
            break; /* Loop/switch isn't completed */
        }
        fontonlineinfo = (FontOnlineInfo)e.get(l);
        int i1;
        if (a(fontonlineinfo))
        {
            break MISSING_BLOCK_LABEL_82;
        }
        i1 = fontonlineinfo.resId;
        FontOnlineInfo fontonlineinfo1;
        boolean flag1;
        if (!fontonlineinfo.isLocalOnlineRes)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        fontonlineinfo1 = a(i1, flag1);
        fontonlineinfo1.resId = fontonlineinfo.resId;
        e.set(l, fontonlineinfo1);
        flag = true;
_L3:
        l++;
        if (true) goto _L2; else goto _L1
        Exception exception;
        exception;
        exception.printStackTrace();
          goto _L3
        exception;
        exception.printStackTrace();
_L1:
        return flag;
    }

}
