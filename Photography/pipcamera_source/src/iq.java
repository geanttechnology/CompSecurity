// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.graphics.Typeface;
import com.pipcamera.application.PIPCameraApplication;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class iq
{

    private static iq a;
    private Map b;
    private Map c;
    private List d;

    public iq()
    {
        b = new HashMap();
        c = new HashMap();
        d = new ArrayList();
        f();
        e();
    }

    public static iq a()
    {
        if (a == null)
        {
            a = new iq();
        }
        return a;
    }

    private void e()
    {
        new hb();
        hb hb1 = new hb();
        hb1.a = true;
        hb1.e = true;
        hb1.f = "DFPGBWW5.ttf";
        hb1.b = "http://download.fotoable.com/fonts/DFPGBWW5.zip.asp";
        hb1.c = 0x7f020145;
        hb1.d = 0x7f020146;
        hb1.g = "\u534E\u5EB7\u5A03\u5A03\u4F53";
        hb1.h = 2.6F;
        if (!ew.c())
        {
            d.add(hb1);
        }
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.a = true;
        hb1.e = true;
        hb1.f = "HKSNW5.ttf";
        hb1.b = "http://download.fotoable.com/fonts/HKSNW5.ttf.zip.asp";
        hb1.c = 0x7f020143;
        hb1.d = 0x7f020144;
        hb1.g = "\u534E\u5EB7\u5C11\u5973\u4F53W5";
        hb1.h = 2.3F;
        if (!ew.c())
        {
            d.add(hb1);
        }
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.a = true;
        hb1.e = true;
        hb1.f = "FZNH.ttf";
        hb1.b = "http://download.fotoable.com/fonts/FZNH.ttf.zip.asp";
        hb1.c = 0x7f020139;
        hb1.d = 0x7f02013a;
        hb1.g = "\u65B9\u6B63\u5450\u558A\u4F53";
        hb1.h = 6.4F;
        if (!ew.c())
        {
            d.add(hb1);
        }
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.a = true;
        hb1.e = true;
        hb1.f = "DFGBMO9.ttc";
        hb1.b = "http://download.fotoable.com/fonts/DFGBMO9.zip.asp";
        hb1.c = 0x7f020141;
        hb1.d = 0x7f020142;
        hb1.g = "\u534E\u5EB7\u58A8\u7B80\u4F53";
        hb1.h = 4.1F;
        if (!ew.c())
        {
            d.add(hb1);
        }
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "DFPBuDingW12.TTC";
        hb1.c = 0x7f020114;
        hb1.d = 0x7f020113;
        hb1.g = "\u534E\u5EB7\u5E03\u4E01\u4F53";
        hb1.b = "http://dl.fotoable.com/fonts/DFPBuDingW12.TTC.zip.asp";
        hb1.h = 2.3F;
        if (!ew.c())
        {
            d.add(hb1);
        }
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "DFPTFY_W7GB.ttc";
        hb1.c = 0x7f02011a;
        hb1.d = 0x7f020119;
        hb1.g = "\u534E\u5EB7\u65B9\u5706\u4F53";
        hb1.b = "http://dl.fotoable.com/fonts/DFPTFY_W7GB.ttc.zip.asp";
        hb1.h = 1.9F;
        if (!ew.c())
        {
            d.add(hb1);
        }
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.a = true;
        hb1.e = true;
        hb1.f = "FZJZSH.ttf";
        hb1.b = "http://download.fotoable.com/fonts/FZJZSH.ttf.zip.asp";
        hb1.c = 0x7f020131;
        hb1.d = 0x7f020132;
        hb1.g = "\u65B9\u6B63\u526A\u7EB8\u7B80\u4F53";
        hb1.h = 0.9F;
        if (!ew.c())
        {
            d.add(hb1);
        }
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.a = true;
        hb1.e = true;
        hb1.f = "FZKSH.ttf";
        hb1.b = "http://download.fotoable.com/fonts/FZKSH.ttf.zip.asp";
        hb1.c = 0x7f020137;
        hb1.d = 0x7f020138;
        hb1.g = "\u65B9\u6B63\u6977\u4F53\u7B80\u4F53";
        hb1.h = 2.1F;
        if (!ew.c())
        {
            d.add(hb1);
        }
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.a = true;
        hb1.e = true;
        hb1.f = "FZZZH.ttf";
        hb1.b = "http://download.fotoable.com/fonts/FZZZH.ttf.zip.asp";
        hb1.c = 0x7f02013b;
        hb1.d = 0x7f02013c;
        hb1.g = "\u65B9\u6B63\u6B63\u51C6\u9ED1\u4F53";
        hb1.h = 1.1F;
        if (!ew.c())
        {
            d.add(hb1);
        }
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "DFPGBZY9.ttf";
        hb1.c = 0x7f02014c;
        hb1.d = 0x7f02014b;
        hb1.g = "\u534E\u5EB7\u65B0\u7EFC\u827A\u4F53";
        hb1.b = "http://dl.fotoable.com/fonts/DFPGBZY9.ttf.zip.asp";
        hb1.h = 0.97F;
        if (!ew.c())
        {
            d.add(hb1);
        }
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "DFPGB_HC.ttf";
        hb1.c = 0x7f020118;
        hb1.d = 0x7f020117;
        hb1.g = "\u534E\u5EB7\u9ED1\u4F53";
        hb1.b = "http://dl.fotoable.com/fonts/DFPGB_HC.ttf.zip.asp";
        hb1.h = 1.7F;
        if (!ew.c())
        {
            d.add(hb1);
        }
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "DFPT_PF4.ttf";
        hb1.c = 0x7f020116;
        hb1.d = 0x7f020115;
        hb1.g = "\u83EF\u5EB7\u5BF6\u9CF3\u9AD4";
        hb1.b = "http://dl.fotoable.com/fonts/DFPT_PF4.ttf.zip.asp";
        hb1.h = 5.9F;
        if (ew.c())
        {
            d.add(hb1);
        }
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "DFPT_HF3.ttf";
        hb1.c = 0x7f020120;
        hb1.d = 0x7f02011f;
        hb1.g = "\u83EF\u5EB7\u79C0\u9CF3\u9AD4";
        hb1.b = "http://dl.fotoable.com/fonts/DFPT_HF3.ttf.zip.asp";
        hb1.h = 5.4F;
        if (ew.c())
        {
            d.add(hb1);
        }
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "DFPT_MO9.ttf";
        hb1.c = 0x7f02011e;
        hb1.d = 0x7f02011d;
        hb1.g = "\u83EF\u5EB7\u58A8\u7E41\u9AD4";
        hb1.b = "http://dl.fotoable.com/fonts/DFPT_MO9.ttf.zip.asp";
        hb1.h = 5.4F;
        if (ew.c())
        {
            d.add(hb1);
        }
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.a = true;
        hb1.e = true;
        hb1.f = "DFPT_XXH.ttf";
        hb1.b = "http://download.fotoable.com/fonts/DFPT_XXH.zip.asp";
        hb1.c = 0x7f020149;
        hb1.d = 0x7f02014a;
        hb1.g = "\u83EF\u5EB7\u99A8\u9999\u82B1\u9AD4";
        hb1.h = 10F;
        if (ew.c())
        {
            d.add(hb1);
        }
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.a = true;
        hb1.e = true;
        hb1.f = "FZJZTH.ttf";
        hb1.b = "http://download.fotoable.com/fonts/FZJZTH.ttf.zip.asp";
        hb1.c = 0x7f020133;
        hb1.d = 0x7f020134;
        hb1.g = "\u65B9\u6B63\u526A\u7D19\u7E41\u9AD4";
        hb1.h = 0.96F;
        if (ew.c())
        {
            d.add(hb1);
        }
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "DFPT_Y8.ttf";
        hb1.c = 0x7f02011c;
        hb1.d = 0x7f02011b;
        hb1.g = "\u83EF\u5EB7\u5137\u7279\u5713";
        hb1.b = "http://dl.fotoable.com/fonts/DFPT_Y8.ttf.zip.asp";
        hb1.h = 4.1F;
        if (ew.c())
        {
            d.add(hb1);
        }
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.a = true;
        hb1.e = true;
        hb1.f = "FZKTH.ttf";
        hb1.b = "http://download.fotoable.com/fonts/FZKTH.ttf.zip.asp";
        hb1.c = 0x7f020135;
        hb1.d = 0x7f020136;
        hb1.g = "\u65B9\u6B63\u6977\u9AD4\u7E41\u9AD4";
        hb1.h = 2.3F;
        if (ew.c())
        {
            d.add(hb1);
        }
        c.put(hb1.f, hb1);
    }

    private void f()
    {
        hb hb1 = new hb();
        hb1.a(Typeface.create("monospace", 0));
        hb1.a("monospace");
        b.put("monospace", hb1);
        c.put("monospace", hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "Ubuntu-Regular.ttf";
        hb1.c = 0x7f020176;
        hb1.d = 0x7f020177;
        hb1.g = "ubuntu";
        hb1.h = 0.173F;
        hb1.b = "http://dl.fotoable.com/fonts/Ubuntu-Regular.ttf.zip.asp";
        b.put("ubuntu", hb1);
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "Ubuntu-Bold.ttf";
        hb1.c = 0x7f020176;
        hb1.d = 0x7f020177;
        hb1.g = "ubuntu_bold";
        hb1.h = 0.173F;
        hb1.b = "http://dl.fotoable.com/fonts/Ubuntu-Bold.ttf.zip.asp";
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "Ubuntu-Italic.ttf";
        hb1.c = 0x7f020176;
        hb1.d = 0x7f020177;
        hb1.g = "Ubuntu-Italic";
        hb1.h = 0.173F;
        hb1.b = "http://dl.fotoable.com/fonts/Ubuntu-Italic.ttf.zip.asp";
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "Ubuntu-BoldItalic.ttf";
        hb1.c = 0x7f020176;
        hb1.d = 0x7f020177;
        hb1.g = "Ubuntu-BoldItalic";
        hb1.h = 0.173F;
        hb1.b = "http://dl.fotoable.com/fonts/Ubuntu-BoldItalic.ttf.zip.asp";
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "Altitude.ttf";
        hb1.c = 0x7f0200fc;
        hb1.d = 0x7f0200fd;
        hb1.g = "Altitude";
        hb1.h = 0.007F;
        hb1.b = "http://dl.fotoable.com/fonts/Altitude.ttf.zip.asp";
        b.put("Altitude", hb1);
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "arvil-sans.ttf";
        hb1.c = 0x7f0200fe;
        hb1.d = 0x7f0200ff;
        hb1.g = "arvil";
        hb1.b = "http://dl.fotoable.com/fonts/arvil-sans.ttf.zip.asp";
        hb1.h = 0.017F;
        b.put("arvil", hb1);
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "Blackout-2am.ttf";
        hb1.c = 0x7f020101;
        hb1.d = 0x7f020102;
        hb1.g = "Blackout";
        hb1.b = "http://dl.fotoable.com/fonts/Blackout-2am.ttf.zip.asp";
        hb1.h = 0.01F;
        b.put("Blackout", hb1);
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "BLANCH_CAPS.ttf";
        hb1.c = 0x7f020103;
        hb1.d = 0x7f020104;
        hb1.g = "BLANCH";
        hb1.b = "http://dl.fotoable.com/fonts/BLANCH_CAPS.ttf.zip.asp";
        hb1.h = 0.009F;
        b.put("BLANCH", hb1);
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "calendar note tfb.ttf";
        hb1.c = 0x7f020105;
        hb1.d = 0x7f020106;
        hb1.g = "calendar";
        hb1.b = "http://dl.fotoable.com/fonts/calendar note tfb.ttf.zip.asp";
        hb1.h = 0.01F;
        b.put("calendar", hb1);
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "Capsuula.ttf";
        hb1.c = 0x7f020107;
        hb1.d = 0x7f020108;
        hb1.g = "Capsuula";
        hb1.b = "http://dl.fotoable.com/fonts/Capsuula.ttf.zip.asp";
        hb1.h = 0.045F;
        b.put("Capsuula", hb1);
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "CenturyGothic.ttf";
        hb1.c = 0x7f020109;
        hb1.d = 0x7f02010a;
        hb1.g = "CenturyGothic";
        hb1.b = "http://dl.fotoable.com/fonts/CenturyGothic.ttf.zip.asp";
        hb1.h = 0.087F;
        b.put("CenturyGothic", hb1);
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "CHERI___.ttf";
        hb1.c = 0x7f02010b;
        hb1.d = 0x7f02010c;
        hb1.g = "CHERI";
        hb1.b = "http://dl.fotoable.com/fonts/CHERI___.ttf.zip.asp";
        hb1.h = 0.006F;
        b.put("CHERI", hb1);
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "Chunkfive Ex.ttf";
        hb1.c = 0x7f02010d;
        hb1.d = 0x7f02010e;
        hb1.g = "Chunkfive";
        hb1.b = "http://dl.fotoable.com/fonts/Chunkfive Ex.ttf.zip.asp";
        hb1.h = 0.17F;
        b.put("Chunkfive", hb1);
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "Cubano-Regular.ttf";
        hb1.c = 0x7f02010f;
        hb1.d = 0x7f020110;
        hb1.g = "Cubano";
        hb1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(hb1.f).append(".zip.asp").toString();
        hb1.h = 0.01F;
        b.put(hb1.g, hb1);
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "Cuisine.ttf";
        hb1.c = 0x7f020111;
        hb1.d = 0x7f020112;
        hb1.g = "Cuisine";
        hb1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(hb1.f).append(".zip.asp").toString();
        hb1.h = 0.061F;
        b.put(hb1.g, hb1);
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "Dolce Vita.ttf";
        hb1.c = 0x7f020121;
        hb1.d = 0x7f020122;
        hb1.g = "Dolce";
        hb1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(hb1.f).append(".zip.asp").toString();
        hb1.h = 0.012F;
        b.put(hb1.g, hb1);
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "Dolce Vita Heavy Bold.ttf";
        hb1.c = 0x7f020121;
        hb1.d = 0x7f020122;
        hb1.g = "Dolce Vita Heavy Bold";
        hb1.h = 0.173F;
        hb1.b = "http://dl.fotoable.com/fonts/Dolce Vita Heavy Bold.ttf.zip.asp";
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "EPISODE1.ttf";
        hb1.c = 0x7f020123;
        hb1.d = 0x7f020124;
        hb1.g = "EPISODE1";
        hb1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(hb1.f).append(".zip.asp").toString();
        hb1.h = 0.029F;
        b.put(hb1.g, hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "Espacio.ttf";
        hb1.c = 0x7f020125;
        hb1.d = 0x7f020126;
        hb1.g = "Espacio";
        hb1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(hb1.f).append(".zip.asp").toString();
        hb1.h = 0.038F;
        b.put(hb1.g, hb1);
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "Fava-black.ttf";
        hb1.c = 0x7f020127;
        hb1.d = 0x7f020128;
        hb1.g = "Fava";
        hb1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(hb1.f).append(".zip.asp").toString();
        hb1.h = 0.63F;
        b.put(hb1.g, hb1);
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "Florenzio.ttf";
        hb1.c = 0x7f020129;
        hb1.d = 0x7f02012a;
        hb1.g = "Florenzio";
        hb1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(hb1.f).append(".zip.asp").toString();
        hb1.h = 0.55F;
        b.put(hb1.g, hb1);
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "funkymuskrat.ttf";
        hb1.c = 0x7f02012b;
        hb1.d = 0x7f02012c;
        hb1.g = "funkymuskrat";
        hb1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(hb1.f).append(".zip.asp").toString();
        hb1.h = 0.018F;
        b.put(hb1.g, hb1);
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "galette-med.ttf";
        hb1.c = 0x7f02013d;
        hb1.d = 0x7f02013e;
        hb1.g = "galette";
        hb1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(hb1.f).append(".zip.asp").toString();
        hb1.h = 0.021F;
        b.put(hb1.g, hb1);
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "HEADOH__.ttf";
        hb1.c = 0x7f02013f;
        hb1.d = 0x7f020140;
        hb1.g = "HEADOH";
        hb1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(hb1.f).append(".zip.asp").toString();
        hb1.h = 0.027F;
        b.put(hb1.g, hb1);
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "Hiekka Graphics - Savu-Condensed_0.ttf";
        hb1.c = 0x7f02016c;
        hb1.d = 0x7f02016d;
        hb1.g = "Savu";
        hb1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(hb1.f).append(".zip.asp").toString();
        hb1.h = 0.015F;
        b.put(hb1.g, hb1);
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "JohnHancockCP.ttf";
        hb1.c = 0x7f02014e;
        hb1.d = 0x7f02014f;
        hb1.g = "JohnHancockCP";
        hb1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(hb1.f).append(".zip.asp").toString();
        hb1.h = 0.012F;
        b.put(hb1.g, hb1);
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "LAIKA.ttf";
        hb1.c = 0x7f020150;
        hb1.d = 0x7f020151;
        hb1.g = "LAIKA";
        hb1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(hb1.f).append(".zip.asp").toString();
        hb1.h = 0.019F;
        b.put(hb1.g, hb1);
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "Lifestyle M54.ttf";
        hb1.c = 0x7f020152;
        hb1.d = 0x7f020153;
        hb1.g = "Lifestyle";
        hb1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(hb1.f).append(".zip.asp").toString();
        hb1.h = 0.009F;
        b.put(hb1.g, hb1);
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "LogJam-Inline.ttf";
        hb1.c = 0x7f020154;
        hb1.d = 0x7f020155;
        hb1.g = "LogJam";
        hb1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(hb1.f).append(".zip.asp").toString();
        hb1.h = 0.079F;
        b.put(hb1.g, hb1);
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "LUNABAR.ttf";
        hb1.c = 0x7f020156;
        hb1.d = 0x7f020157;
        hb1.g = "LUNABAR";
        hb1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(hb1.f).append(".zip.asp").toString();
        hb1.h = 0.038F;
        b.put(hb1.g, hb1);
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "mensch-regular.ttf";
        hb1.c = 0x7f020158;
        hb1.d = 0x7f020159;
        hb1.g = "mensch";
        hb1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(hb1.f).append(".zip.asp").toString();
        hb1.h = 0.016F;
        b.put(hb1.g, hb1);
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "Minnie.ttf";
        hb1.c = 0x7f02015a;
        hb1.d = 0x7f02015b;
        hb1.g = "Minnie";
        hb1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(hb1.f).append(".zip.asp").toString();
        hb1.h = 0.012F;
        b.put(hb1.g, hb1);
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "MovLette.ttf";
        hb1.c = 0x7f02015c;
        hb1.d = 0x7f02015d;
        hb1.g = "MovLette";
        hb1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(hb1.f).append(".zip.asp").toString();
        hb1.h = 0.009F;
        b.put(hb1.g, hb1);
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "OLDSH___.ttf";
        hb1.c = 0x7f02015e;
        hb1.d = 0x7f02015f;
        hb1.g = "OLDSH";
        hb1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(hb1.f).append(".zip.asp").toString();
        hb1.h = 0.43F;
        b.put(hb1.g, hb1);
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "OLDSIH__.ttf";
        hb1.c = 0x7f02015e;
        hb1.d = 0x7f02015f;
        hb1.g = "OLDSIH__";
        hb1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(hb1.f).append(".zip.asp").toString();
        hb1.h = 0.43F;
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "OstrichSans-Bold.ttf";
        hb1.c = 0x7f020160;
        hb1.d = 0x7f020161;
        hb1.g = "OstrichSans";
        hb1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(hb1.f).append(".zip.asp").toString();
        hb1.h = 0.01F;
        b.put(hb1.g, hb1);
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "Pistilli-Roman.ttf";
        hb1.c = 0x7f020162;
        hb1.d = 0x7f020163;
        hb1.g = "Pistilli";
        hb1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(hb1.f).append(".zip.asp").toString();
        hb1.h = 0.024F;
        b.put(hb1.g, hb1);
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "POTTERYB.ttf";
        hb1.c = 0x7f020164;
        hb1.d = 0x7f020165;
        hb1.g = "POTTERYB";
        hb1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(hb1.f).append(".zip.asp").toString();
        hb1.h = 0.013F;
        b.put(hb1.g, hb1);
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "Prisma.ttf";
        hb1.c = 0x7f020166;
        hb1.d = 0x7f020167;
        hb1.g = "Prisma";
        hb1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(hb1.f).append(".zip.asp").toString();
        hb1.h = 0.022F;
        b.put(hb1.g, hb1);
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "Quote.ttf";
        hb1.c = 0x7f020168;
        hb1.d = 0x7f020169;
        hb1.g = "Quote";
        hb1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(hb1.f).append(".zip.asp").toString();
        hb1.h = 0.03F;
        b.put(hb1.g, hb1);
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "Rounder.ttf";
        hb1.c = 0x7f02016a;
        hb1.d = 0x7f02016b;
        hb1.g = "Rounder";
        hb1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(hb1.f).append(".zip.asp").toString();
        hb1.h = 0.026F;
        b.put(hb1.g, hb1);
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "RounderBold.ttf";
        hb1.c = 0x7f02016a;
        hb1.d = 0x7f02016b;
        hb1.g = "RounderBold";
        hb1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(hb1.f).append(".zip.asp").toString();
        hb1.h = 0.026F;
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "RounderItalic.ttf";
        hb1.c = 0x7f02016a;
        hb1.d = 0x7f02016b;
        hb1.g = "RounderItalic";
        hb1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(hb1.f).append(".zip.asp").toString();
        hb1.h = 0.026F;
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "Sniglet.ttf";
        hb1.c = 0x7f02016e;
        hb1.d = 0x7f02016f;
        hb1.g = "Sniglet";
        hb1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(hb1.f).append(".zip.asp").toString();
        hb1.h = 0.03F;
        b.put(hb1.g, hb1);
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "talldark.ttf";
        hb1.c = 0x7f020170;
        hb1.d = 0x7f020171;
        hb1.g = "talldark";
        hb1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(hb1.f).append(".zip.asp").toString();
        hb1.h = 0.008F;
        b.put(hb1.g, hb1);
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "TrajanPro-Regular.ttf";
        hb1.c = 0x7f020172;
        hb1.d = 0x7f020173;
        hb1.g = "TrajanPro";
        hb1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(hb1.f).append(".zip.asp").toString();
        hb1.h = 0.045F;
        b.put(hb1.g, hb1);
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "typewcond_regular.ttf";
        hb1.c = 0x7f020174;
        hb1.d = 0x7f020175;
        hb1.g = "Typewriter_Condensed";
        hb1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(hb1.f).append(".zip.asp").toString();
        hb1.h = 0.017F;
        b.put(hb1.g, hb1);
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "PTS56F.ttf";
        hb1.c = 0x7f02016a;
        hb1.d = 0x7f02016b;
        hb1.g = "PTSans-Italic";
        hb1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(hb1.f).append(".zip.asp").toString();
        hb1.h = 0.221F;
        c.put(hb1.f, hb1);
        c.put("PTSans-Italic", hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "PTC75F.ttf";
        hb1.c = 0x7f02016a;
        hb1.d = 0x7f02016b;
        hb1.g = "PTSans-CaptionBold";
        hb1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(hb1.f).append(".zip.asp").toString();
        hb1.h = 0.221F;
        c.put(hb1.f, hb1);
        c.put("PTSans-CaptionBold", hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "PT_Sans-Narrow-Web-Regular.ttf";
        hb1.c = 0x7f02016a;
        hb1.d = 0x7f02016b;
        hb1.g = "PTSans-Narrow";
        hb1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(hb1.f).append(".zip.asp").toString();
        hb1.h = 0.199F;
        c.put(hb1.f, hb1);
        c.put("PTSans-Narrow", hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "PT_Sans-Narrow-Web-Bold.ttf";
        hb1.c = 0x7f02016a;
        hb1.d = 0x7f02016b;
        hb1.g = "PTSans-NarrowBold";
        hb1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(hb1.f).append(".zip.asp").toString();
        hb1.h = 0.199F;
        c.put(hb1.f, hb1);
        c.put("PTSans-NarrowBold", hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "BEBASNEUE.otf";
        hb1.c = 0x7f02016a;
        hb1.d = 0x7f02016b;
        hb1.g = "Bebas Neue";
        hb1.b = "http://dl.fotoable.com/fonts/BEBASNEUE.otf.zip.asp";
        hb1.h = 0.02F;
        c.put(hb1.f, hb1);
        c.put("BEBASNEUE", hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "Didot.ttf";
        hb1.c = 0x7f02016a;
        hb1.d = 0x7f02016b;
        hb1.g = "Didot";
        hb1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(hb1.f).append(".zip.asp").toString();
        hb1.h = 0.02F;
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "Helvetica Neue LT Std.otf";
        hb1.c = 0x7f02016a;
        hb1.d = 0x7f02016b;
        hb1.g = "Helvetica Neue LT Std";
        hb1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(hb1.f).append(".zip.asp").toString();
        hb1.h = 0.02F;
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "Mom\u2019sTypewriter.ttf";
        hb1.c = 0x7f02016a;
        hb1.d = 0x7f02016b;
        hb1.g = "Mom\u2019sTypewriter";
        hb1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(hb1.f).append(".zip.asp").toString();
        hb1.h = 0.02F;
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "RomanticaStd-Condensed.otf";
        hb1.c = 0x7f02016a;
        hb1.d = 0x7f02016b;
        hb1.g = "RomanticaStd-Condensed";
        hb1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(hb1.f).append(".zip.asp").toString();
        hb1.h = 0.02F;
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "Segoe Print.ttf";
        hb1.c = 0x7f02016a;
        hb1.d = 0x7f02016b;
        hb1.g = "Segoe Print";
        hb1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(hb1.f).append(".zip.asp").toString();
        hb1.h = 0.02F;
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "Streetwear.otf";
        hb1.c = 0x7f02016a;
        hb1.d = 0x7f02016b;
        hb1.g = "Streetwear";
        hb1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(hb1.f).append(".zip.asp").toString();
        hb1.h = 0.02F;
        c.put(hb1.f, hb1);
        hb1 = new hb();
        hb1.e = true;
        hb1.f = "Update 537 Italic.ttf";
        hb1.c = 0x7f02016a;
        hb1.d = 0x7f02016b;
        hb1.g = "Update 537 Italic";
        hb1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(hb1.f).append(".zip.asp").toString();
        hb1.h = 0.02F;
        c.put(hb1.f, hb1);
    }

    public Typeface a(hb hb1)
    {
        if (a().b(hb1))
        {
            hb1 = new File((new StringBuilder()).append(d()).append("/fonts/").append(hb1.f).toString());
            if (hb1.exists() && hb1.length() == 0L)
            {
                hb1.delete();
            }
            if (hb1.exists())
            {
                Typeface typeface;
                try
                {
                    typeface = Typeface.createFromFile(hb1);
                }
                catch (Exception exception)
                {
                    hb1.delete();
                    return null;
                }
                return typeface;
            }
        }
        return null;
    }

    public Map b()
    {
        return b;
    }

    public boolean b(hb hb1)
    {
        hb1 = new File((new StringBuilder()).append(d()).append("/fonts/").append(hb1.f).toString());
        if (hb1.exists() && hb1.length() == 0L)
        {
            hb1.delete();
        }
        return hb1.exists();
    }

    public List c()
    {
        return d;
    }

    public String d()
    {
        return PIPCameraApplication.a.getDir("onlineRes", 0).getAbsolutePath();
    }
}
