// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.graphics.Typeface;
import com.instabeauty.application.InstaBeautyApplication;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class alr
{

    private static alr a;
    private Map b;
    private Map c;
    private List d;

    public alr()
    {
        b = new HashMap();
        c = new HashMap();
        d = new ArrayList();
        f();
        e();
    }

    public static alr a()
    {
        if (a == null)
        {
            a = new alr();
        }
        return a;
    }

    private void e()
    {
        new ama();
        ama ama1 = new ama();
        ama1.e = true;
        ama1.f = "FZQingKeBenYueSongS-R-GB.TTF";
        ama1.g = "\u65B9\u6B63\u6E05\u523B\u672C\u60A6\u5B8B\u7B80\u4F53";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/FZQingKeBenYueSongS-R-GB.TTF.zip.asp").toString();
        ama1.h = 1.6F;
        ama1.c = 0x7f020352;
        ama1.d = 0x7f0203b4;
        if (!yp.c())
        {
            d.add(ama1);
        }
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "ZHSRXT-GBK.ttf";
        ama1.g = "\u5F20\u6D77\u5C71\u9510\u7EBF\u4F53";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/ZHSRXT-GBK.ttf.zip.asp").toString();
        ama1.h = 4.3F;
        ama1.c = 0x7f020359;
        ama1.d = 0x7f0203bb;
        if (!yp.c())
        {
            d.add(ama1);
        }
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "SentyTEA-Platinum.ttf";
        ama1.g = "\u65B0\u8482\u4E0B\u5348\u8336";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/SentyTEA-Platinum.ttf.zip.asp").toString();
        ama1.h = 1.4F;
        ama1.c = 0x7f020357;
        ama1.d = 0x7f0203b9;
        if (!yp.c())
        {
            d.add(ama1);
        }
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "SentyMARUKOapp.ttf";
        ama1.g = "\u65B0\u8482\u5C0F\u4E38\u5B50";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/SentyMARUKOapp.ttf.zip.asp").toString();
        ama1.h = 6.5F;
        ama1.c = 0x7f020358;
        ama1.d = 0x7f0203ba;
        if (!yp.c())
        {
            d.add(ama1);
        }
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "SentyPea.otf";
        ama1.g = "\u65B0\u8482\u7EFF\u8C46";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/SentyPea.otf.zip.asp").toString();
        ama1.h = 3.4F;
        ama1.c = 0x7f020354;
        ama1.d = 0x7f0203b6;
        if (!yp.c())
        {
            d.add(ama1);
        }
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "SentyCHALKoriginal.ttf";
        ama1.g = "\u65B0\u8482\u9ED1\u677F\u62A5\u5E95";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/SentyCHALKoriginal.ttf.zip.asp").toString();
        ama1.h = 6.8F;
        ama1.c = 0x7f020353;
        ama1.d = 0x7f0203b5;
        if (!yp.c())
        {
            d.add(ama1);
        }
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "SentySnowMountain.otf";
        ama1.g = "\u65B0\u8482\u96EA\u5C71";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/SentySnowMountain.otf.zip.asp").toString();
        ama1.h = 4.5F;
        ama1.c = 0x7f020356;
        ama1.d = 0x7f0203b8;
        if (!yp.c())
        {
            d.add(ama1);
        }
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "SentyCreamPuff.otf";
        ama1.g = "\u65B0\u8482\u6CE1\u8299";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/SentyCreamPuff.otf.zip.asp").toString();
        ama1.h = 3.4F;
        ama1.c = 0x7f020355;
        ama1.d = 0x7f0203b7;
        if (!yp.c())
        {
            d.add(ama1);
        }
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.a = true;
        ama1.e = true;
        ama1.f = "DFPGBWW5.ttf";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/DFPGBWW5.zip.asp").toString();
        ama1.c = 0x7f02024f;
        ama1.d = 0x7f020250;
        ama1.g = "\u534E\u5EB7\u5A03\u5A03\u4F53";
        ama1.h = 2.6F;
        if (!yp.c())
        {
            d.add(ama1);
        }
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.a = true;
        ama1.e = true;
        ama1.f = "HKSNW5.ttf";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/HKSNW5.ttf.zip.asp").toString();
        ama1.c = 0x7f02024d;
        ama1.d = 0x7f02024e;
        ama1.g = "\u534E\u5EB7\u5C11\u5973\u4F53W5";
        ama1.h = 2.3F;
        if (!yp.c())
        {
            d.add(ama1);
        }
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.a = true;
        ama1.e = true;
        ama1.f = "FZNH.ttf";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/FZNH.ttf.zip.asp").toString();
        ama1.c = 0x7f020243;
        ama1.d = 0x7f020244;
        ama1.g = "\u65B9\u6B63\u5450\u558A\u4F53";
        ama1.h = 6.4F;
        if (!yp.c())
        {
            d.add(ama1);
        }
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.a = true;
        ama1.e = true;
        ama1.f = "DFGBMO9.ttc";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/DFGBMO9.zip.asp").toString();
        ama1.c = 0x7f02024b;
        ama1.d = 0x7f02024c;
        ama1.g = "\u534E\u5EB7\u58A8\u7B80\u4F53";
        ama1.h = 4.1F;
        if (!yp.c())
        {
            d.add(ama1);
        }
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "DFPBuDingW12.TTC";
        ama1.c = 0x7f02021e;
        ama1.d = 0x7f02021d;
        ama1.g = "\u534E\u5EB7\u5E03\u4E01\u4F53";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/DFPBuDingW12.TTC.zip.asp").toString();
        ama1.h = 2.3F;
        if (!yp.c())
        {
            d.add(ama1);
        }
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "DFPTFY_W7GB.ttc";
        ama1.c = 0x7f020224;
        ama1.d = 0x7f020223;
        ama1.g = "\u534E\u5EB7\u65B9\u5706\u4F53";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/DFPTFY_W7GB.ttc.zip.asp").toString();
        ama1.h = 1.9F;
        if (!yp.c())
        {
            d.add(ama1);
        }
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.a = true;
        ama1.e = true;
        ama1.f = "FZJZSH.ttf";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/FZJZSH.ttf.zip.asp").toString();
        ama1.c = 0x7f02023b;
        ama1.d = 0x7f02023c;
        ama1.g = "\u65B9\u6B63\u526A\u7EB8\u7B80\u4F53";
        ama1.h = 0.9F;
        if (!yp.c())
        {
            d.add(ama1);
        }
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.a = true;
        ama1.e = true;
        ama1.f = "FZKSH.ttf";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/FZKSH.ttf.zip.asp").toString();
        ama1.c = 0x7f020241;
        ama1.d = 0x7f020242;
        ama1.g = "\u65B9\u6B63\u6977\u4F53\u7B80\u4F53";
        ama1.h = 2.1F;
        if (!yp.c())
        {
            d.add(ama1);
        }
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.a = true;
        ama1.e = true;
        ama1.f = "FZZZH.ttf";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/FZZZH.ttf.zip.asp").toString();
        ama1.c = 0x7f020245;
        ama1.d = 0x7f020246;
        ama1.g = "\u65B9\u6B63\u6B63\u51C6\u9ED1\u4F53";
        ama1.h = 1.1F;
        if (!yp.c())
        {
            d.add(ama1);
        }
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "DFPGBZY9.ttf";
        ama1.c = 0x7f020256;
        ama1.d = 0x7f020255;
        ama1.g = "\u534E\u5EB7\u65B0\u7EFC\u827A\u4F53";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/DFPGBZY9.ttf.zip.asp").toString();
        ama1.h = 0.97F;
        if (!yp.c())
        {
            d.add(ama1);
        }
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "DFPGB_HC.ttf";
        ama1.c = 0x7f020222;
        ama1.d = 0x7f020221;
        ama1.g = "\u534E\u5EB7\u9ED1\u4F53";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/DFPGB_HC.ttf.zip.asp").toString();
        ama1.h = 1.7F;
        if (!yp.c())
        {
            d.add(ama1);
        }
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "DFPT_PF4.ttf";
        ama1.c = 0x7f020220;
        ama1.d = 0x7f02021f;
        ama1.g = "\u83EF\u5EB7\u5BF6\u9CF3\u9AD4";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/DFPT_PF4.ttf.zip.asp").toString();
        ama1.h = 5.9F;
        if (yp.c())
        {
            d.add(ama1);
        }
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "DFPT_HF3.ttf";
        ama1.c = 0x7f02022a;
        ama1.d = 0x7f020229;
        ama1.g = "\u83EF\u5EB7\u79C0\u9CF3\u9AD4";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/DFPT_HF3.ttf.zip.asp").toString();
        ama1.h = 5.4F;
        if (yp.c())
        {
            d.add(ama1);
        }
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "DFPT_MO9.ttf";
        ama1.c = 0x7f020228;
        ama1.d = 0x7f020227;
        ama1.g = "\u83EF\u5EB7\u58A8\u7E41\u9AD4";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/DFPT_MO9.ttf.zip.asp").toString();
        ama1.h = 5.4F;
        if (yp.c())
        {
            d.add(ama1);
        }
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.a = true;
        ama1.e = true;
        ama1.f = "DFPT_XXH.ttf";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/DFPT_XXH.zip.asp").toString();
        ama1.c = 0x7f020253;
        ama1.d = 0x7f020254;
        ama1.g = "\u83EF\u5EB7\u99A8\u9999\u82B1\u9AD4";
        ama1.h = 10F;
        if (yp.c())
        {
            d.add(ama1);
        }
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.a = true;
        ama1.e = true;
        ama1.f = "FZJZTH.ttf";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/FZJZTH.ttf.zip.asp").toString();
        ama1.c = 0x7f02023d;
        ama1.d = 0x7f02023e;
        ama1.g = "\u65B9\u6B63\u526A\u7D19\u7E41\u9AD4";
        ama1.h = 0.96F;
        if (yp.c())
        {
            d.add(ama1);
        }
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "DFPT_Y8.ttf";
        ama1.c = 0x7f020226;
        ama1.d = 0x7f020225;
        ama1.g = "\u83EF\u5EB7\u5137\u7279\u5713";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/DFPT_Y8.ttf.zip.asp").toString();
        ama1.h = 4.1F;
        if (yp.c())
        {
            d.add(ama1);
        }
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.a = true;
        ama1.e = true;
        ama1.f = "FZKTH.ttf";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/FZKTH.ttf.zip.asp").toString();
        ama1.c = 0x7f02023f;
        ama1.d = 0x7f020240;
        ama1.g = "\u65B9\u6B63\u6977\u9AD4\u7E41\u9AD4";
        ama1.h = 2.3F;
        if (yp.c())
        {
            d.add(ama1);
        }
        c.put(ama1.f, ama1);
    }

    private void f()
    {
        ama ama1 = new ama();
        ama1.a(Typeface.create("monospace", 0));
        ama1.a("monospace");
        b.put("monospace", ama1);
        c.put("monospace", ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "Ubuntu-Regular.ttf";
        ama1.c = 0x7f020280;
        ama1.d = 0x7f020281;
        ama1.g = "ubuntu";
        ama1.h = 0.173F;
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/Ubuntu-Regular.ttf.zip.asp").toString();
        b.put("ubuntu", ama1);
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "Ubuntu-Bold.ttf";
        ama1.c = 0x7f020280;
        ama1.d = 0x7f020281;
        ama1.g = "ubuntu_bold";
        ama1.h = 0.173F;
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/Ubuntu-Bold.ttf.zip.asp").toString();
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "Ubuntu-Italic.ttf";
        ama1.c = 0x7f020280;
        ama1.d = 0x7f020281;
        ama1.g = "Ubuntu-Italic";
        ama1.h = 0.173F;
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/Ubuntu-Italic.ttf.zip.asp").toString();
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "Ubuntu-BoldItalic.ttf";
        ama1.c = 0x7f020280;
        ama1.d = 0x7f020281;
        ama1.g = "Ubuntu-BoldItalic";
        ama1.h = 0.173F;
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/Ubuntu-BoldItalic.ttf.zip.asp").toString();
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "Altitude.ttf";
        ama1.c = 0x7f020206;
        ama1.d = 0x7f020207;
        ama1.g = "Altitude";
        ama1.h = 0.007F;
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/Altitude.ttf.zip.asp").toString();
        b.put("Altitude", ama1);
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "arvil-sans.ttf";
        ama1.c = 0x7f020208;
        ama1.d = 0x7f020209;
        ama1.g = "arvil";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/arvil-sans.ttf.zip.asp").toString();
        ama1.h = 0.017F;
        b.put("arvil", ama1);
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "Blackout-2am.ttf";
        ama1.c = 0x7f02020b;
        ama1.d = 0x7f02020c;
        ama1.g = "Blackout";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/Blackout-2am.ttf.zip.asp").toString();
        ama1.h = 0.01F;
        b.put("Blackout", ama1);
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "BLANCH_CAPS.ttf";
        ama1.c = 0x7f02020d;
        ama1.d = 0x7f02020e;
        ama1.g = "BLANCH";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/BLANCH_CAPS.ttf.zip.asp").toString();
        ama1.h = 0.009F;
        b.put("BLANCH", ama1);
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "calendar note tfb.ttf";
        ama1.c = 0x7f02020f;
        ama1.d = 0x7f020210;
        ama1.g = "calendar";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/calendarnotetfb.ttf.zip.asp").toString();
        ama1.h = 0.01F;
        b.put("calendar", ama1);
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "Capsuula.ttf";
        ama1.c = 0x7f020211;
        ama1.d = 0x7f020212;
        ama1.g = "Capsuula";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/Capsuula.ttf.zip.asp").toString();
        ama1.h = 0.045F;
        b.put("Capsuula", ama1);
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "CenturyGothic.ttf";
        ama1.c = 0x7f020213;
        ama1.d = 0x7f020214;
        ama1.g = "CenturyGothic";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/CenturyGothic.ttf.zip.asp").toString();
        ama1.h = 0.087F;
        b.put("CenturyGothic", ama1);
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "CHERI___.ttf";
        ama1.c = 0x7f020215;
        ama1.d = 0x7f020216;
        ama1.g = "CHERI";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/CHERI___.ttf.zip.asp").toString();
        ama1.h = 0.006F;
        b.put("CHERI", ama1);
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "Chunkfive Ex.ttf";
        ama1.c = 0x7f020217;
        ama1.d = 0x7f020218;
        ama1.g = "Chunkfive";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/ChunkfiveEx.ttf.zip.asp").toString();
        ama1.h = 0.17F;
        b.put("Chunkfive", ama1);
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "Cubano-Regular.ttf";
        ama1.c = 0x7f020219;
        ama1.d = 0x7f02021a;
        ama1.g = "Cubano";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/").append(ama1.f).append(".zip.asp").toString();
        ama1.h = 0.01F;
        b.put(ama1.g, ama1);
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "Cuisine.ttf";
        ama1.c = 0x7f02021b;
        ama1.d = 0x7f02021c;
        ama1.g = "Cuisine";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/").append(ama1.f).append(".zip.asp").toString();
        ama1.h = 0.061F;
        b.put(ama1.g, ama1);
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "Dolce Vita.ttf";
        ama1.c = 0x7f02022b;
        ama1.d = 0x7f02022c;
        ama1.g = "Dolce";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/").append("DolceVita.ttf").append(".zip.asp").toString();
        ama1.h = 0.012F;
        b.put(ama1.g, ama1);
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "Dolce Vita Heavy Bold.ttf";
        ama1.c = 0x7f02022b;
        ama1.d = 0x7f02022c;
        ama1.g = "Dolce Vita Heavy Bold";
        ama1.h = 0.173F;
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/Dolce Vita Heavy Bold.ttf.zip.asp").toString();
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "EPISODE1.ttf";
        ama1.c = 0x7f02022d;
        ama1.d = 0x7f02022e;
        ama1.g = "EPISODE1";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/").append(ama1.f).append(".zip.asp").toString();
        ama1.h = 0.029F;
        b.put(ama1.g, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "Espacio.ttf";
        ama1.c = 0x7f02022f;
        ama1.d = 0x7f020230;
        ama1.g = "Espacio";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/").append(ama1.f).append(".zip.asp").toString();
        ama1.h = 0.038F;
        b.put(ama1.g, ama1);
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "Fava-black.ttf";
        ama1.c = 0x7f020231;
        ama1.d = 0x7f020232;
        ama1.g = "Fava";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/").append(ama1.f).append(".zip.asp").toString();
        ama1.h = 0.63F;
        b.put(ama1.g, ama1);
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "Florenzio.ttf";
        ama1.c = 0x7f020233;
        ama1.d = 0x7f020234;
        ama1.g = "Florenzio";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/").append(ama1.f).append(".zip.asp").toString();
        ama1.h = 0.55F;
        b.put(ama1.g, ama1);
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "funkymuskrat.ttf";
        ama1.c = 0x7f020235;
        ama1.d = 0x7f020236;
        ama1.g = "funkymuskrat";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/").append(ama1.f).append(".zip.asp").toString();
        ama1.h = 0.018F;
        b.put(ama1.g, ama1);
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "galette-med.ttf";
        ama1.c = 0x7f020247;
        ama1.d = 0x7f020248;
        ama1.g = "galette";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/").append(ama1.f).append(".zip.asp").toString();
        ama1.h = 0.021F;
        b.put(ama1.g, ama1);
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "HEADOH__.ttf";
        ama1.c = 0x7f020249;
        ama1.d = 0x7f02024a;
        ama1.g = "HEADOH";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/").append(ama1.f).append(".zip.asp").toString();
        ama1.h = 0.027F;
        b.put(ama1.g, ama1);
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "Hiekka Graphics - Savu-Condensed_0.ttf";
        ama1.c = 0x7f020276;
        ama1.d = 0x7f020277;
        ama1.g = "Savu";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/").append("HiekkaGraphics-Savu-Condensed_0.ttf").append(".zip.asp").toString();
        ama1.h = 0.015F;
        b.put(ama1.g, ama1);
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "JohnHancockCP.ttf";
        ama1.c = 0x7f020258;
        ama1.d = 0x7f020259;
        ama1.g = "JohnHancockCP";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/").append(ama1.f).append(".zip.asp").toString();
        ama1.h = 0.012F;
        b.put(ama1.g, ama1);
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "LAIKA.ttf";
        ama1.c = 0x7f02025a;
        ama1.d = 0x7f02025b;
        ama1.g = "LAIKA";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/").append(ama1.f).append(".zip.asp").toString();
        ama1.h = 0.019F;
        b.put(ama1.g, ama1);
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "Lifestyle M54.ttf";
        ama1.c = 0x7f02025c;
        ama1.d = 0x7f02025d;
        ama1.g = "Lifestyle";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/").append("LifestyleM54.ttf").append(".zip.asp").toString();
        ama1.h = 0.009F;
        b.put(ama1.g, ama1);
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "LogJam-Inline.ttf";
        ama1.c = 0x7f02025e;
        ama1.d = 0x7f02025f;
        ama1.g = "LogJam";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/").append(ama1.f).append(".zip.asp").toString();
        ama1.h = 0.079F;
        b.put(ama1.g, ama1);
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "LUNABAR.ttf";
        ama1.c = 0x7f020260;
        ama1.d = 0x7f020261;
        ama1.g = "LUNABAR";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/").append(ama1.f).append(".zip.asp").toString();
        ama1.h = 0.038F;
        b.put(ama1.g, ama1);
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "mensch-regular.ttf";
        ama1.c = 0x7f020262;
        ama1.d = 0x7f020263;
        ama1.g = "mensch";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/").append(ama1.f).append(".zip.asp").toString();
        ama1.h = 0.016F;
        b.put(ama1.g, ama1);
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "Minnie.ttf";
        ama1.c = 0x7f020264;
        ama1.d = 0x7f020265;
        ama1.g = "Minnie";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/").append(ama1.f).append(".zip.asp").toString();
        ama1.h = 0.012F;
        b.put(ama1.g, ama1);
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "MovLette.ttf";
        ama1.c = 0x7f020266;
        ama1.d = 0x7f020267;
        ama1.g = "MovLette";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/").append(ama1.f).append(".zip.asp").toString();
        ama1.h = 0.009F;
        b.put(ama1.g, ama1);
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "OLDSH___.ttf";
        ama1.c = 0x7f020268;
        ama1.d = 0x7f020269;
        ama1.g = "OLDSH";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/").append(ama1.f).append(".zip.asp").toString();
        ama1.h = 0.43F;
        b.put(ama1.g, ama1);
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "OLDSIH__.ttf";
        ama1.c = 0x7f020268;
        ama1.d = 0x7f020269;
        ama1.g = "OLDSIH__";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/").append(ama1.f).append(".zip.asp").toString();
        ama1.h = 0.43F;
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "OstrichSans-Bold.ttf";
        ama1.c = 0x7f02026a;
        ama1.d = 0x7f02026b;
        ama1.g = "OstrichSans";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/").append(ama1.f).append(".zip.asp").toString();
        ama1.h = 0.01F;
        b.put(ama1.g, ama1);
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "Pistilli-Roman.ttf";
        ama1.c = 0x7f02026c;
        ama1.d = 0x7f02026d;
        ama1.g = "Pistilli";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/").append(ama1.f).append(".zip.asp").toString();
        ama1.h = 0.024F;
        b.put(ama1.g, ama1);
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "POTTERYB.ttf";
        ama1.c = 0x7f02026e;
        ama1.d = 0x7f02026f;
        ama1.g = "POTTERYB";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/").append(ama1.f).append(".zip.asp").toString();
        ama1.h = 0.013F;
        b.put(ama1.g, ama1);
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "Prisma.ttf";
        ama1.c = 0x7f020270;
        ama1.d = 0x7f020271;
        ama1.g = "Prisma";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/").append(ama1.f).append(".zip.asp").toString();
        ama1.h = 0.022F;
        b.put(ama1.g, ama1);
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "Quote.ttf";
        ama1.c = 0x7f020272;
        ama1.d = 0x7f020273;
        ama1.g = "Quote";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/").append(ama1.f).append(".zip.asp").toString();
        ama1.h = 0.03F;
        b.put(ama1.g, ama1);
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "Rounder.ttf";
        ama1.c = 0x7f020274;
        ama1.d = 0x7f020275;
        ama1.g = "Rounder";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/").append(ama1.f).append(".zip.asp").toString();
        ama1.h = 0.026F;
        b.put(ama1.g, ama1);
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "RounderBold.ttf";
        ama1.c = 0x7f020274;
        ama1.d = 0x7f020275;
        ama1.g = "RounderBold";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/").append(ama1.f).append(".zip.asp").toString();
        ama1.h = 0.026F;
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "RounderItalic.ttf";
        ama1.c = 0x7f020274;
        ama1.d = 0x7f020275;
        ama1.g = "RounderItalic";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/").append(ama1.f).append(".zip.asp").toString();
        ama1.h = 0.026F;
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "Sniglet.ttf";
        ama1.c = 0x7f020278;
        ama1.d = 0x7f020279;
        ama1.g = "Sniglet";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/").append(ama1.f).append(".zip.asp").toString();
        ama1.h = 0.03F;
        b.put(ama1.g, ama1);
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "talldark.ttf";
        ama1.c = 0x7f02027a;
        ama1.d = 0x7f02027b;
        ama1.g = "talldark";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/").append(ama1.f).append(".zip.asp").toString();
        ama1.h = 0.008F;
        b.put(ama1.g, ama1);
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "TrajanPro-Regular.ttf";
        ama1.c = 0x7f02027c;
        ama1.d = 0x7f02027d;
        ama1.g = "TrajanPro";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/").append(ama1.f).append(".zip.asp").toString();
        ama1.h = 0.045F;
        b.put(ama1.g, ama1);
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "typewcond_regular.ttf";
        ama1.c = 0x7f02027e;
        ama1.d = 0x7f02027f;
        ama1.g = "Typewriter_Condensed";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/").append(ama1.f).append(".zip.asp").toString();
        ama1.h = 0.017F;
        b.put(ama1.g, ama1);
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "PTS56F.ttf";
        ama1.c = 0x7f020274;
        ama1.d = 0x7f020275;
        ama1.g = "PTSans-Italic";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/").append(ama1.f).append(".zip.asp").toString();
        ama1.h = 0.221F;
        c.put(ama1.f, ama1);
        c.put("PTSans-Italic", ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "PTC75F.ttf";
        ama1.c = 0x7f020274;
        ama1.d = 0x7f020275;
        ama1.g = "PTSans-CaptionBold";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/").append(ama1.f).append(".zip.asp").toString();
        ama1.h = 0.221F;
        c.put(ama1.f, ama1);
        c.put("PTSans-CaptionBold", ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "PT_Sans-Narrow-Web-Regular.ttf";
        ama1.c = 0x7f020274;
        ama1.d = 0x7f020275;
        ama1.g = "PTSans-Narrow";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/").append(ama1.f).append(".zip.asp").toString();
        ama1.h = 0.199F;
        c.put(ama1.f, ama1);
        c.put("PTSans-Narrow", ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "PT_Sans-Narrow-Web-Bold.ttf";
        ama1.c = 0x7f020274;
        ama1.d = 0x7f020275;
        ama1.g = "PTSans-NarrowBold";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/").append(ama1.f).append(".zip.asp").toString();
        ama1.h = 0.199F;
        c.put(ama1.f, ama1);
        c.put("PTSans-NarrowBold", ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "BEBASNEUE.otf";
        ama1.c = 0x7f020274;
        ama1.d = 0x7f020275;
        ama1.g = "Bebas Neue";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/BEBASNEUE.otf.zip.asp").toString();
        ama1.h = 0.02F;
        c.put(ama1.f, ama1);
        c.put("BEBASNEUE", ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "Didot.ttf";
        ama1.c = 0x7f020274;
        ama1.d = 0x7f020275;
        ama1.g = "Didot";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/").append(ama1.f).append(".zip.asp").toString();
        ama1.h = 0.02F;
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "Helvetica Neue LT Std.otf";
        ama1.c = 0x7f020274;
        ama1.d = 0x7f020275;
        ama1.g = "Helvetica Neue LT Std";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/").append(ama1.f).append(".zip.asp").toString();
        ama1.h = 0.02F;
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "Mom\u2019sTypewriter.ttf";
        ama1.c = 0x7f020274;
        ama1.d = 0x7f020275;
        ama1.g = "Mom\u2019sTypewriter";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/").append(ama1.f).append(".zip.asp").toString();
        ama1.h = 0.02F;
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "RomanticaStd-Condensed.otf";
        ama1.c = 0x7f020274;
        ama1.d = 0x7f020275;
        ama1.g = "RomanticaStd-Condensed";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/").append(ama1.f).append(".zip.asp").toString();
        ama1.h = 0.02F;
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "Segoe Print.ttf";
        ama1.c = 0x7f020274;
        ama1.d = 0x7f020275;
        ama1.g = "Segoe Print";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/").append(ama1.f).append(".zip.asp").toString();
        ama1.h = 0.02F;
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "Streetwear.otf";
        ama1.c = 0x7f020274;
        ama1.d = 0x7f020275;
        ama1.g = "Streetwear";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/").append(ama1.f).append(".zip.asp").toString();
        ama1.h = 0.02F;
        c.put(ama1.f, ama1);
        ama1 = new ama();
        ama1.e = true;
        ama1.f = "Update 537 Italic.ttf";
        ama1.c = 0x7f020274;
        ama1.d = 0x7f020275;
        ama1.g = "Update 537 Italic";
        ama1.b = (new StringBuilder()).append(azn.e()).append("/fonts/").append(ama1.f).append(".zip.asp").toString();
        ama1.h = 0.02F;
        c.put(ama1.f, ama1);
    }

    public Typeface a(ama ama1)
    {
        if (a().b(ama1))
        {
            ama1 = new File((new StringBuilder()).append(d()).append("/fonts/").append(ama1.f).toString());
            if (ama1.exists() && ama1.length() == 0L)
            {
                ama1.delete();
            }
            if (ama1.exists())
            {
                Typeface typeface;
                try
                {
                    typeface = Typeface.createFromFile(ama1);
                }
                catch (Exception exception)
                {
                    ama1.delete();
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

    public boolean b(ama ama1)
    {
        ama1 = new File((new StringBuilder()).append(d()).append("/fonts/").append(ama1.f).toString());
        if (ama1.exists() && ama1.length() == 0L)
        {
            ama1.delete();
        }
        return ama1.exists();
    }

    public List c()
    {
        return d;
    }

    public String d()
    {
        return InstaBeautyApplication.a.getDir("onlineRes", 0).getAbsolutePath();
    }
}
