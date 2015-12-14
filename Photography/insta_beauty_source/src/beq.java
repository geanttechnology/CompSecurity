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

public class beq
{

    private static beq a;
    private Map b;
    private Map c;
    private List d;

    public beq()
    {
        b = new HashMap();
        c = new HashMap();
        d = new ArrayList();
        c();
    }

    public static beq a()
    {
        if (a == null)
        {
            a = new beq();
        }
        return a;
    }

    private void c()
    {
        bev bev1 = new bev();
        bev1.a(Typeface.create("monospace", 0));
        bev1.a("monospace");
        b.put("monospace", bev1);
        c.put("monospace", bev1);
        bev1 = new bev();
        bev1.c = true;
        bev1.d = "Ubuntu-Regular.ttf";
        bev1.e = "ubuntu";
        bev1.f = 0.173F;
        bev1.b = "http://dl.fotoable.com/fonts/Ubuntu-Regular.ttf.zip.asp";
        b.put("ubuntu", bev1);
        c.put(bev1.d, bev1);
        bev1 = new bev();
        bev1.c = true;
        bev1.d = "Ubuntu-Bold.ttf";
        bev1.e = "ubuntu_bold";
        bev1.f = 0.173F;
        bev1.b = "http://dl.fotoable.com/fonts/Ubuntu-Bold.ttf.zip.asp";
        c.put(bev1.d, bev1);
        bev1 = new bev();
        bev1.c = true;
        bev1.d = "Ubuntu-Italic.ttf";
        bev1.e = "Ubuntu-Italic";
        bev1.f = 0.173F;
        bev1.b = "http://dl.fotoable.com/fonts/Ubuntu-Italic.ttf.zip.asp";
        c.put(bev1.d, bev1);
        bev1 = new bev();
        bev1.c = true;
        bev1.d = "Ubuntu-BoldItalic.ttf";
        bev1.e = "Ubuntu-BoldItalic";
        bev1.f = 0.173F;
        bev1.b = "http://dl.fotoable.com/fonts/Ubuntu-BoldItalic.ttf.zip.asp";
        c.put(bev1.d, bev1);
        bev1 = new bev();
        bev1.c = true;
        bev1.d = "Altitude.ttf";
        bev1.e = "Altitude";
        bev1.f = 0.007F;
        bev1.b = "http://dl.fotoable.com/fonts/Altitude.ttf.zip.asp";
        b.put("Altitude", bev1);
        c.put(bev1.d, bev1);
        bev1 = new bev();
        bev1.c = true;
        bev1.d = "arvil-sans.ttf";
        bev1.e = "arvil";
        bev1.b = "http://dl.fotoable.com/fonts/arvil-sans.ttf.zip.asp";
        bev1.f = 0.017F;
        b.put("arvil", bev1);
        c.put(bev1.d, bev1);
        bev1 = new bev();
        bev1.c = true;
        bev1.d = "Blackout-2am.ttf";
        bev1.e = "Blackout";
        bev1.b = "http://dl.fotoable.com/fonts/Blackout-2am.ttf.zip.asp";
        bev1.f = 0.01F;
        b.put("Blackout", bev1);
        c.put(bev1.d, bev1);
        bev1 = new bev();
        bev1.c = true;
        bev1.d = "BLANCH_CAPS.ttf";
        bev1.e = "BLANCH";
        bev1.b = "http://dl.fotoable.com/fonts/BLANCH_CAPS.ttf.zip.asp";
        bev1.f = 0.009F;
        b.put("BLANCH", bev1);
        c.put(bev1.d, bev1);
        bev1 = new bev();
        bev1.c = true;
        bev1.d = "calendar note tfb.ttf";
        bev1.e = "calendar";
        bev1.b = "http://dl.fotoable.com/fonts/calendar note tfb.ttf.zip.asp";
        bev1.f = 0.01F;
        b.put("calendar", bev1);
        c.put(bev1.d, bev1);
        bev1 = new bev();
        bev1.c = true;
        bev1.d = "Capsuula.ttf";
        bev1.e = "Capsuula";
        bev1.b = "http://dl.fotoable.com/fonts/Capsuula.ttf.zip.asp";
        bev1.f = 0.045F;
        b.put("Capsuula", bev1);
        c.put(bev1.d, bev1);
        bev1 = new bev();
        bev1.c = true;
        bev1.d = "CenturyGothic.ttf";
        bev1.e = "CenturyGothic";
        bev1.b = "http://dl.fotoable.com/fonts/CenturyGothic.ttf.zip.asp";
        bev1.f = 0.087F;
        b.put("CenturyGothic", bev1);
        c.put(bev1.d, bev1);
        bev1 = new bev();
        bev1.c = true;
        bev1.d = "CHERI___.ttf";
        bev1.e = "CHERI";
        bev1.b = "http://dl.fotoable.com/fonts/CHERI___.ttf.zip.asp";
        bev1.f = 0.006F;
        b.put("CHERI", bev1);
        c.put(bev1.d, bev1);
        bev1 = new bev();
        bev1.c = true;
        bev1.d = "Chunkfive Ex.ttf";
        bev1.e = "Chunkfive";
        bev1.b = "http://dl.fotoable.com/fonts/Chunkfive Ex.ttf.zip.asp";
        bev1.f = 0.17F;
        b.put("Chunkfive", bev1);
        c.put(bev1.d, bev1);
        bev1 = new bev();
        bev1.c = true;
        bev1.d = "Cubano-Regular.ttf";
        bev1.e = "Cubano";
        bev1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(bev1.d).append(".zip.asp").toString();
        bev1.f = 0.01F;
        b.put(bev1.e, bev1);
        c.put(bev1.d, bev1);
        bev1 = new bev();
        bev1.c = true;
        bev1.d = "Cuisine.ttf";
        bev1.e = "Cuisine";
        bev1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(bev1.d).append(".zip.asp").toString();
        bev1.f = 0.061F;
        b.put(bev1.e, bev1);
        c.put(bev1.d, bev1);
        bev1 = new bev();
        bev1.c = true;
        bev1.d = "Dolce Vita.ttf";
        bev1.e = "Dolce";
        bev1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(bev1.d).append(".zip.asp").toString();
        bev1.f = 0.012F;
        b.put(bev1.e, bev1);
        c.put(bev1.d, bev1);
        bev1 = new bev();
        bev1.c = true;
        bev1.d = "Dolce Vita Heavy Bold.ttf";
        bev1.e = "Dolce Vita Heavy Bold";
        bev1.f = 0.173F;
        bev1.b = "http://dl.fotoable.com/fonts/Dolce Vita Heavy Bold.ttf.zip.asp";
        c.put(bev1.d, bev1);
        bev1 = new bev();
        bev1.c = true;
        bev1.d = "EPISODE1.ttf";
        bev1.e = "EPISODE1";
        bev1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(bev1.d).append(".zip.asp").toString();
        bev1.f = 0.029F;
        b.put(bev1.e, bev1);
        bev1 = new bev();
        bev1.c = true;
        bev1.d = "Espacio.ttf";
        bev1.e = "Espacio";
        bev1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(bev1.d).append(".zip.asp").toString();
        bev1.f = 0.038F;
        b.put(bev1.e, bev1);
        c.put(bev1.d, bev1);
        bev1 = new bev();
        bev1.c = true;
        bev1.d = "Fava-black.ttf";
        bev1.e = "Fava";
        bev1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(bev1.d).append(".zip.asp").toString();
        bev1.f = 0.63F;
        b.put(bev1.e, bev1);
        c.put(bev1.d, bev1);
        bev1 = new bev();
        bev1.c = true;
        bev1.d = "Florenzio.ttf";
        bev1.e = "Florenzio";
        bev1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(bev1.d).append(".zip.asp").toString();
        bev1.f = 0.55F;
        b.put(bev1.e, bev1);
        c.put(bev1.d, bev1);
        bev1 = new bev();
        bev1.c = true;
        bev1.d = "funkymuskrat.ttf";
        bev1.e = "funkymuskrat";
        bev1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(bev1.d).append(".zip.asp").toString();
        bev1.f = 0.018F;
        b.put(bev1.e, bev1);
        c.put(bev1.d, bev1);
        bev1 = new bev();
        bev1.c = true;
        bev1.d = "galette-med.ttf";
        bev1.e = "galette";
        bev1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(bev1.d).append(".zip.asp").toString();
        bev1.f = 0.021F;
        b.put(bev1.e, bev1);
        c.put(bev1.d, bev1);
        bev1 = new bev();
        bev1.c = true;
        bev1.d = "HEADOH__.ttf";
        bev1.e = "HEADOH";
        bev1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(bev1.d).append(".zip.asp").toString();
        bev1.f = 0.027F;
        b.put(bev1.e, bev1);
        c.put(bev1.d, bev1);
        bev1 = new bev();
        bev1.c = true;
        bev1.d = "Hiekka Graphics - Savu-Condensed_0.ttf";
        bev1.e = "Savu";
        bev1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(bev1.d).append(".zip.asp").toString();
        bev1.f = 0.015F;
        b.put(bev1.e, bev1);
        c.put(bev1.d, bev1);
        bev1 = new bev();
        bev1.c = true;
        bev1.d = "JohnHancockCP.ttf";
        bev1.e = "JohnHancockCP";
        bev1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(bev1.d).append(".zip.asp").toString();
        bev1.f = 0.012F;
        b.put(bev1.e, bev1);
        c.put(bev1.d, bev1);
        bev1 = new bev();
        bev1.c = true;
        bev1.d = "LAIKA.ttf";
        bev1.e = "LAIKA";
        bev1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(bev1.d).append(".zip.asp").toString();
        bev1.f = 0.019F;
        b.put(bev1.e, bev1);
        c.put(bev1.d, bev1);
        bev1 = new bev();
        bev1.c = true;
        bev1.d = "Lifestyle M54.ttf";
        bev1.e = "Lifestyle";
        bev1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(bev1.d).append(".zip.asp").toString();
        bev1.f = 0.009F;
        b.put(bev1.e, bev1);
        c.put(bev1.d, bev1);
        bev1 = new bev();
        bev1.c = true;
        bev1.d = "LogJam-Inline.ttf";
        bev1.e = "LogJam";
        bev1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(bev1.d).append(".zip.asp").toString();
        bev1.f = 0.079F;
        b.put(bev1.e, bev1);
        c.put(bev1.d, bev1);
        bev1 = new bev();
        bev1.c = true;
        bev1.d = "LUNABAR.ttf";
        bev1.e = "LUNABAR";
        bev1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(bev1.d).append(".zip.asp").toString();
        bev1.f = 0.038F;
        b.put(bev1.e, bev1);
        c.put(bev1.d, bev1);
        bev1 = new bev();
        bev1.c = true;
        bev1.d = "mensch-regular.ttf";
        bev1.e = "mensch";
        bev1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(bev1.d).append(".zip.asp").toString();
        bev1.f = 0.016F;
        b.put(bev1.e, bev1);
        c.put(bev1.d, bev1);
        bev1 = new bev();
        bev1.c = true;
        bev1.d = "Minnie.ttf";
        bev1.e = "Minnie";
        bev1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(bev1.d).append(".zip.asp").toString();
        bev1.f = 0.012F;
        b.put(bev1.e, bev1);
        c.put(bev1.d, bev1);
        bev1 = new bev();
        bev1.c = true;
        bev1.d = "MovLette.ttf";
        bev1.e = "MovLette";
        bev1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(bev1.d).append(".zip.asp").toString();
        bev1.f = 0.009F;
        b.put(bev1.e, bev1);
        c.put(bev1.d, bev1);
        bev1 = new bev();
        bev1.c = true;
        bev1.d = "OLDSH___.ttf";
        bev1.e = "OLDSH";
        bev1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(bev1.d).append(".zip.asp").toString();
        bev1.f = 0.43F;
        b.put(bev1.e, bev1);
        c.put(bev1.d, bev1);
        bev1 = new bev();
        bev1.c = true;
        bev1.d = "OLDSIH__.ttf";
        bev1.e = "OLDSIH__";
        bev1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(bev1.d).append(".zip.asp").toString();
        bev1.f = 0.43F;
        c.put(bev1.d, bev1);
        bev1 = new bev();
        bev1.c = true;
        bev1.d = "OstrichSans-Bold.ttf";
        bev1.e = "OstrichSans";
        bev1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(bev1.d).append(".zip.asp").toString();
        bev1.f = 0.01F;
        b.put(bev1.e, bev1);
        c.put(bev1.d, bev1);
        bev1 = new bev();
        bev1.c = true;
        bev1.d = "Pistilli-Roman.ttf";
        bev1.e = "Pistilli";
        bev1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(bev1.d).append(".zip.asp").toString();
        bev1.f = 0.024F;
        b.put(bev1.e, bev1);
        c.put(bev1.d, bev1);
        bev1 = new bev();
        bev1.c = true;
        bev1.d = "POTTERYB.ttf";
        bev1.e = "POTTERYB";
        bev1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(bev1.d).append(".zip.asp").toString();
        bev1.f = 0.013F;
        b.put(bev1.e, bev1);
        c.put(bev1.d, bev1);
        bev1 = new bev();
        bev1.c = true;
        bev1.d = "Prisma.ttf";
        bev1.e = "Prisma";
        bev1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(bev1.d).append(".zip.asp").toString();
        bev1.f = 0.022F;
        b.put(bev1.e, bev1);
        c.put(bev1.d, bev1);
        bev1 = new bev();
        bev1.c = true;
        bev1.d = "Quote.ttf";
        bev1.e = "Quote";
        bev1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(bev1.d).append(".zip.asp").toString();
        bev1.f = 0.03F;
        b.put(bev1.e, bev1);
        c.put(bev1.d, bev1);
        bev1 = new bev();
        bev1.c = true;
        bev1.d = "Rounder.ttf";
        bev1.e = "Rounder";
        bev1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(bev1.d).append(".zip.asp").toString();
        bev1.f = 0.026F;
        b.put(bev1.e, bev1);
        c.put(bev1.d, bev1);
        bev1 = new bev();
        bev1.c = true;
        bev1.d = "RounderBold.ttf";
        bev1.e = "RounderBold";
        bev1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(bev1.d).append(".zip.asp").toString();
        bev1.f = 0.026F;
        c.put(bev1.d, bev1);
        bev1 = new bev();
        bev1.c = true;
        bev1.d = "RounderItalic.ttf";
        bev1.e = "RounderItalic";
        bev1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(bev1.d).append(".zip.asp").toString();
        bev1.f = 0.026F;
        c.put(bev1.d, bev1);
        bev1 = new bev();
        bev1.c = true;
        bev1.d = "Sniglet.ttf";
        bev1.e = "Sniglet";
        bev1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(bev1.d).append(".zip.asp").toString();
        bev1.f = 0.03F;
        b.put(bev1.e, bev1);
        c.put(bev1.d, bev1);
        bev1 = new bev();
        bev1.c = true;
        bev1.d = "talldark.ttf";
        bev1.e = "talldark";
        bev1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(bev1.d).append(".zip.asp").toString();
        bev1.f = 0.008F;
        b.put(bev1.e, bev1);
        c.put(bev1.d, bev1);
        bev1 = new bev();
        bev1.c = true;
        bev1.d = "TrajanPro-Regular.ttf";
        bev1.e = "TrajanPro";
        bev1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(bev1.d).append(".zip.asp").toString();
        bev1.f = 0.045F;
        b.put(bev1.e, bev1);
        c.put(bev1.d, bev1);
        bev1 = new bev();
        bev1.c = true;
        bev1.d = "typewcond_regular.ttf";
        bev1.e = "Typewriter_Condensed";
        bev1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(bev1.d).append(".zip.asp").toString();
        bev1.f = 0.017F;
        b.put(bev1.e, bev1);
        c.put(bev1.d, bev1);
        bev1 = new bev();
        bev1.c = true;
        bev1.d = "PTS56F.ttf";
        bev1.e = "PTSans-Italic";
        bev1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(bev1.d).append(".zip.asp").toString();
        bev1.f = 0.221F;
        c.put(bev1.d, bev1);
        c.put("PTSans-Italic", bev1);
        bev1 = new bev();
        bev1.c = true;
        bev1.d = "PTC75F.ttf";
        bev1.e = "PTSans-CaptionBold";
        bev1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(bev1.d).append(".zip.asp").toString();
        bev1.f = 0.221F;
        c.put(bev1.d, bev1);
        c.put("PTSans-CaptionBold", bev1);
        bev1 = new bev();
        bev1.c = true;
        bev1.d = "PT_Sans-Narrow-Web-Regular.ttf";
        bev1.e = "PTSans-Narrow";
        bev1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(bev1.d).append(".zip.asp").toString();
        bev1.f = 0.199F;
        c.put(bev1.d, bev1);
        c.put("PTSans-Narrow", bev1);
        bev1 = new bev();
        bev1.c = true;
        bev1.d = "PT_Sans-Narrow-Web-Bold.ttf";
        bev1.e = "PTSans-NarrowBold";
        bev1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(bev1.d).append(".zip.asp").toString();
        bev1.f = 0.199F;
        c.put(bev1.d, bev1);
        c.put("PTSans-NarrowBold", bev1);
        bev1 = new bev();
        bev1.c = true;
        bev1.d = "BEBASNEUE.otf";
        bev1.e = "Bebas Neue";
        bev1.b = "http://dl.fotoable.com/fonts/BEBASNEUE.otf.zip.asp";
        bev1.f = 0.02F;
        c.put(bev1.d, bev1);
        c.put("BEBASNEUE", bev1);
        bev1 = new bev();
        bev1.c = true;
        bev1.d = "Didot.ttf";
        bev1.e = "Didot";
        bev1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(bev1.d).append(".zip.asp").toString();
        bev1.f = 0.02F;
        c.put(bev1.d, bev1);
        bev1 = new bev();
        bev1.c = true;
        bev1.d = "Helvetica Neue LT Std.otf";
        bev1.e = "Helvetica Neue LT Std";
        bev1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(bev1.d).append(".zip.asp").toString();
        bev1.f = 0.02F;
        c.put(bev1.d, bev1);
        bev1 = new bev();
        bev1.c = true;
        bev1.d = "Mom\u2019sTypewriter.ttf";
        bev1.e = "Mom\u2019sTypewriter";
        bev1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(bev1.d).append(".zip.asp").toString();
        bev1.f = 0.02F;
        c.put(bev1.d, bev1);
        bev1 = new bev();
        bev1.c = true;
        bev1.d = "RomanticaStd-Condensed.otf";
        bev1.e = "RomanticaStd-Condensed";
        bev1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(bev1.d).append(".zip.asp").toString();
        bev1.f = 0.02F;
        c.put(bev1.d, bev1);
        bev1 = new bev();
        bev1.c = true;
        bev1.d = "Segoe Print.ttf";
        bev1.e = "Segoe Print";
        bev1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(bev1.d).append(".zip.asp").toString();
        bev1.f = 0.02F;
        c.put(bev1.d, bev1);
        bev1 = new bev();
        bev1.c = true;
        bev1.d = "Streetwear.otf";
        bev1.e = "Streetwear";
        bev1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(bev1.d).append(".zip.asp").toString();
        bev1.f = 0.02F;
        c.put(bev1.d, bev1);
        bev1 = new bev();
        bev1.c = true;
        bev1.d = "Update 537 Italic.ttf";
        bev1.e = "Update 537 Italic";
        bev1.b = (new StringBuilder()).append("http://dl.fotoable.com/fonts/").append(bev1.d).append(".zip.asp").toString();
        bev1.f = 0.02F;
        c.put(bev1.d, bev1);
    }

    public Typeface a(bev bev1)
    {
        if (a().b(bev1))
        {
            bev1 = new File((new StringBuilder()).append(b()).append("/fonts/").append(bev1.d).toString());
            if (bev1.exists() && bev1.length() == 0L)
            {
                bev1.delete();
            }
            if (bev1.exists())
            {
                Typeface typeface;
                try
                {
                    typeface = Typeface.createFromFile(bev1);
                }
                catch (Exception exception)
                {
                    bev1.delete();
                    return null;
                }
                return typeface;
            }
        }
        return null;
    }

    public bev a(String s)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        bev bev1 = b("sans");
_L4:
        return bev1;
_L2:
        bev bev2;
        if ((bev)c.get(s) != null)
        {
            break; /* Loop/switch isn't completed */
        }
        bev2 = (bev)c.get(String.format("%s.%s", new Object[] {
            s, "ttf"
        }));
        bev1 = bev2;
        if (bev2 != null) goto _L4; else goto _L3
_L3:
        bev2 = (bev)c.get(String.format("%s.%s", new Object[] {
            s, "TTF"
        }));
        bev1 = bev2;
        if (bev2 != null) goto _L4; else goto _L5
_L5:
        bev2 = (bev)c.get(String.format("%s.%s", new Object[] {
            s, "otf"
        }));
        bev1 = bev2;
        if (bev2 != null) goto _L4; else goto _L6
_L6:
        bev2 = (bev)c.get(String.format("%s.%s", new Object[] {
            s, "OTF"
        }));
        bev1 = bev2;
        if (bev2 != null) goto _L4; else goto _L7
_L7:
        bev2 = (bev)c.get(String.format("%s.%s", new Object[] {
            s, "ttc"
        }));
        bev1 = bev2;
        if (bev2 != null) goto _L4; else goto _L8
_L8:
        bev2 = (bev)c.get(String.format("%s.%s", new Object[] {
            s, "TTC"
        }));
        bev1 = bev2;
        if (bev2 != null) goto _L4; else goto _L9
_L9:
        bev2 = (bev)c.get(String.format("%s.%s", new Object[] {
            s, "otc"
        }));
        bev1 = bev2;
        if (bev2 != null) goto _L4; else goto _L10
_L10:
        bev2 = (bev)c.get(String.format("%s.%s", new Object[] {
            s, "OTC"
        }));
        bev1 = bev2;
        if (bev2 != null) goto _L4; else goto _L11
_L11:
        if (c.get(s) == null)
        {
            return b(s);
        } else
        {
            return (bev)c.get(s);
        }
    }

    public bev b(String s)
    {
        bev bev1 = new bev();
        bev1.a(Typeface.create(s, 0));
        bev1.a(s);
        return bev1;
    }

    public String b()
    {
        return InstaBeautyApplication.a.getDir("onlineRes", 0).getAbsolutePath();
    }

    public boolean b(bev bev1)
    {
        bev1 = new File((new StringBuilder()).append(b()).append("/fonts/").append(bev1.d).toString());
        if (bev1.exists() && bev1.length() == 0L)
        {
            bev1.delete();
        }
        return bev1.exists();
    }
}
