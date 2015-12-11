// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.graphics.Rect;
import com.jumio.clientlib.impl.livenessAndTM.ImgWarp;
import com.jumio.clientlib.impl.livenessAndTM.PixelFormatType;
import com.jumio.netverify.sdk.extraction.templatematcher.TemplateInfoWrapper;

// Referenced classes of package jumiomobile:
//            n, cs, pn, os, 
//            pm, pt, ab

public class kb
{

    public static byte[] a(byte abyte0[], float f, n n1, boolean flag, String s, TemplateInfoWrapper templateinfowrapper)
    {
        float af[] = a(templateinfowrapper, f);
        float f1;
        int i;
        int j;
        if (flag)
        {
            i = (int)templateinfowrapper.r();
        } else
        {
            i = (int)templateinfowrapper.q();
        }
        if (flag)
        {
            j = (int)templateinfowrapper.q();
        } else
        {
            j = (int)templateinfowrapper.r();
        }
        f1 = (float)templateinfowrapper.B() / (float)templateinfowrapper.C();
        n1.a = (int)((float)templateinfowrapper.s().width() * f);
        n1.b = (int)((float)n1.a / f1);
        return a(abyte0, i, j, af, n1.a, n1.b, s, templateinfowrapper);
    }

    public static byte[] a(byte abyte0[], int i, int j, float af[], int k, int l, String s, TemplateInfoWrapper templateinfowrapper)
    {
        long l1 = System.currentTimeMillis();
        float f = af[0];
        float f1 = af[1];
        float f2 = af[2];
        float f3 = af[3];
        float f4 = af[4];
        float f5 = af[5];
        float f6 = af[6];
        float f7 = af[7];
        af = new byte[l * k * 3];
        ImgWarp.warp(abyte0, i, i, j, PixelFormatType.PIXEL_FORMAT_YUV420_NV21, f, f1, f2, f3, f4, f5, f6, f7, af, k, l);
        l1 = System.currentTimeMillis() - l1;
        if (cs.a() && templateinfowrapper != null)
        {
            double d = templateinfowrapper.r() * templateinfowrapper.q();
            os.a(new pn(s, templateinfowrapper.A(), d, templateinfowrapper.n()));
            os.a(new pm(s, templateinfowrapper.v(), templateinfowrapper.n()));
            os.a(new pt(s, l1));
        }
        ab.c("TemplateMatcher", (new StringBuilder("Image warping took ")).append(l1).append(" ms").toString());
        return af;
    }

    public static byte[] a(byte abyte0[], boolean flag, String s, TemplateInfoWrapper templateinfowrapper)
    {
        float af[] = templateinfowrapper.i();
        float f;
        int i;
        int j;
        int k;
        if (flag)
        {
            i = (int)templateinfowrapper.r();
        } else
        {
            i = (int)templateinfowrapper.q();
        }
        if (flag)
        {
            j = (int)templateinfowrapper.q();
        } else
        {
            j = (int)templateinfowrapper.r();
        }
        f = (float)templateinfowrapper.B() / (float)templateinfowrapper.C();
        k = templateinfowrapper.s().width();
        return a(abyte0, i, j, af, k, (int)((float)k / f), s, templateinfowrapper);
    }

    public static float[] a(TemplateInfoWrapper templateinfowrapper, float f)
    {
        templateinfowrapper = templateinfowrapper.i();
        float f1 = (templateinfowrapper[0] + templateinfowrapper[2] + templateinfowrapper[6] + templateinfowrapper[4]) / 4F;
        float f2 = (templateinfowrapper[1] + templateinfowrapper[3] + templateinfowrapper[7] + templateinfowrapper[5]) / 4F;
        float f4 = templateinfowrapper[0] - f1;
        float f5 = templateinfowrapper[1] - f2;
        float f6 = templateinfowrapper[2] - f1;
        float f7 = templateinfowrapper[3] - f2;
        float f8 = templateinfowrapper[6] - f1;
        float f9 = templateinfowrapper[7] - f2;
        float f10 = templateinfowrapper[4] - f1;
        float f3 = templateinfowrapper[5] - f2;
        double d = Math.sqrt(f4 * f4 + f5 * f5);
        double d1 = Math.sqrt(f6 * f6 + f7 * f7);
        double d2 = Math.sqrt(f8 * f8 + f9 * f9);
        double d3 = Math.sqrt(f10 * f10 + f3 * f3);
        f4 = (float)((double)f4 / d);
        f5 = (float)((double)f5 / d);
        f6 = (float)((double)f6 / d1);
        f7 = (float)((double)f7 / d1);
        f8 = (float)((double)f8 / d2);
        f9 = (float)((double)f9 / d2);
        f10 = (float)((double)f10 / d3);
        f3 = (float)((double)f3 / d3);
        f4 = (float)((double)f4 * ((double)f * d));
        double d4 = f5;
        f5 = (float)(d * (double)f * d4);
        f6 = (float)((double)f6 * ((double)f * d1));
        f7 = (float)((double)f7 * (d1 * (double)f));
        f8 = (float)((double)f8 * ((double)f * d2));
        f9 = (float)((double)f9 * ((double)f * d2));
        f10 = (float)((double)f10 * ((double)f * d3));
        f = (float)((double)f3 * ((double)f * d3));
        templateinfowrapper[0] = f4 + f1;
        templateinfowrapper[1] = f5 + f2;
        templateinfowrapper[2] = f1 + f6;
        templateinfowrapper[3] = f2 + f7;
        templateinfowrapper[6] = f1 + f8;
        templateinfowrapper[7] = f2 + f9;
        templateinfowrapper[4] = f1 + f10;
        templateinfowrapper[5] = f2 + f;
        return templateinfowrapper;
    }
}
