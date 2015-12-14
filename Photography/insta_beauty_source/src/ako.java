// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Color;
import com.crashlytics.android.Crashlytics;
import com.fotoable.fotoproedit.activity.font.FontTextLabelInfo;
import com.instabeauty.application.InstaBeautyApplication;
import java.io.InputStream;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class ako
{

    private static ako e = null;
    private String a;
    private String b;
    private ArrayList c;
    private ArrayList d;
    private bgd f;
    private String g;

    public ako()
    {
        a = "FontTextManager";
        b = "textbg";
        g = "textbgsavefilename";
        e();
        f();
        if (f == null)
        {
            f = new bgd(InstaBeautyApplication.a().b(), "textBg");
        }
    }

    public static ako a()
    {
        if (e != null) goto _L2; else goto _L1
_L1:
        ako;
        JVM INSTR monitorenter ;
        e = new ako();
        ako;
        JVM INSTR monitorexit ;
_L2:
        return e;
        Exception exception;
        exception;
        ako;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private JSONObject a(String s)
    {
        try
        {
            s = InstaBeautyApplication.a.getAssets().open(s);
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

    private ArrayList e()
    {
        d = new ArrayList();
        Object obj = a("textstyleRes.json");
        if (obj != null)
        {
            obj = aqn.b(((JSONObject) (obj)), "data");
            if (obj != null && ((JSONArray) (obj)).length() > 0)
            {
                int i = 0;
                while (i < ((JSONArray) (obj)).length()) 
                {
                    JSONObject jsonobject = aqn.a(((JSONArray) (obj)), i);
                    if (jsonobject != null)
                    {
                        try
                        {
                            FontTextLabelInfo fonttextlabelinfo = new FontTextLabelInfo();
                            if (aqn.a(jsonobject, "textColor") != null)
                            {
                                fonttextlabelinfo.j = Color.parseColor((new StringBuilder()).append("#").append(aqn.a(jsonobject, "textColor")).toString());
                            }
                            if (aqn.a(jsonobject, "strokeColor") != null)
                            {
                                fonttextlabelinfo.h = Color.parseColor((new StringBuilder()).append("#").append(aqn.a(jsonobject, "strokeColor")).toString());
                            }
                            if (aqn.a(jsonobject, "shadowColor") != null)
                            {
                                fonttextlabelinfo.e = Color.parseColor((new StringBuilder()).append("#").append(aqn.a(jsonobject, "shadowColor")).toString());
                            }
                            if (aqn.a(jsonobject, "textureImage") != null)
                            {
                                fonttextlabelinfo.i = aqn.a(jsonobject, "textureImage");
                            }
                            fonttextlabelinfo.g = aqn.f(jsonobject, "strokeSize");
                            fonttextlabelinfo.d = aqn.f(jsonobject, "shadowSize");
                            fonttextlabelinfo.a = aqn.e(jsonobject, "infoflag");
                            fonttextlabelinfo.o = aqn.d(jsonobject, "isImageTexture");
                            fonttextlabelinfo.n = aqn.d(jsonobject, "isLinearImg");
                            fonttextlabelinfo.f = aqn.d(jsonobject, "needGuassShadow");
                            d.add(fonttextlabelinfo);
                        }
                        catch (Exception exception)
                        {
                            exception.printStackTrace();
                        }
                    }
                    i++;
                }
            }
        }
        return d;
    }

    private ArrayList f()
    {
        c = new ArrayList();
        for (int i = 0; i < akw.a().a.size(); i++)
        {
            ams ams1 = (ams)akw.a().a.get(i);
            FontTextLabelInfo fonttextlabelinfo2 = new FontTextLabelInfo();
            fonttextlabelinfo2.o = false;
            fonttextlabelinfo2.j = ams1.a();
            c.add(fonttextlabelinfo2);
        }

        for (int j = 0; j < 51; j++)
        {
            FontTextLabelInfo fonttextlabelinfo = new FontTextLabelInfo();
            String s = (new StringBuilder()).append("textRes/gradientH/gr_text_gradient_").append(j).append(".png").toString();
            fonttextlabelinfo.n = true;
            fonttextlabelinfo.i = s;
            fonttextlabelinfo.o = true;
            c.add(fonttextlabelinfo);
        }

        for (int k = 0; k < 47; k++)
        {
            FontTextLabelInfo fonttextlabelinfo1 = new FontTextLabelInfo();
            String s1 = (new StringBuilder()).append("textRes/texture/gr_text_texture_").append(k).append(".jpg").toString();
            fonttextlabelinfo1.n = false;
            fonttextlabelinfo1.i = s1;
            fonttextlabelinfo1.o = true;
            c.add(fonttextlabelinfo1);
        }

        return c;
    }

    public ArrayList b()
    {
        return d;
    }

    public ArrayList c()
    {
        return c;
    }

    public bgd d()
    {
        return f;
    }

}
