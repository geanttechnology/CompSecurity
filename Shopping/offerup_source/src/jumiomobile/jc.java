// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import com.jumio.mrz.impl.smartEngines.swig.MrzDate;
import com.jumio.mrz.impl.smartEngines.swig.MrzDateField;
import com.jumio.mrz.impl.smartEngines.swig.MrzEngine;
import com.jumio.mrz.impl.smartEngines.swig.MrzEngineSessionHelpers;
import com.jumio.mrz.impl.smartEngines.swig.MrzField;
import com.jumio.mrz.impl.smartEngines.swig.MrzRect;
import com.jumio.mrz.impl.smartEngines.swig.MrzResult;
import com.jumio.mrz.impl.smartEngines.swig.StringVector;
import com.jumio.netverify.sdk.core.ModelTemplate;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

// Referenced classes of package jumiomobile:
//            ix, l, n, ao, 
//            q, cs, mr, g, 
//            oo, jd, ay, ab

class jc extends Thread
{

    final ix a;
    private byte b[];
    private l c;

    public jc(ix ix1, byte abyte0[])
    {
        a = ix1;
        super();
        b = Arrays.copyOf(abyte0, abyte0.length);
        c = ix1.b.a();
    }

    private void a(byte abyte0[])
    {
        float f;
        n n1;
        byte abyte1[];
        Object obj1;
        int i;
        int k;
        int l1;
        int i2;
        int j2;
        int k2;
        int i1 = c.c.a;
        i = c.c.b;
        double d = ix.b(a).get_optimal_aspect_ratio();
        l1 = ((ix.c(a) + (c.a.a - c.b.a) / 2) * i1) / c.a.a;
        k2 = i1 - l1 * 2;
        j2 = (int)((double)k2 / d);
        i2 = ((ix.d(a) + (c.a.b - c.b.b) / 2) * i) / c.a.b;
        obj1 = new MrzRect(l1, i2, k2, j2);
        if (a.c.f())
        {
            k = i1;
        } else
        {
            k = i;
            i = i1;
        }
        obj = com.jumio.mrz.impl.smartEngines.swig.MrzEngine.ImageOrientation.Landscape;
        if (c.e != 90) goto _L2; else goto _L1
_L1:
        obj = com.jumio.mrz.impl.smartEngines.swig.MrzEngine.ImageOrientation.Portrait;
_L9:
        StringBuilder stringbuilder;
        Calendar calendar;
        float f1;
        float f2;
        if (c.d)
        {
            if (obj == com.jumio.mrz.impl.smartEngines.swig.MrzEngine.ImageOrientation.Portrait)
            {
                obj = com.jumio.mrz.impl.smartEngines.swig.MrzEngine.ImageOrientation.InvertedPortrait;
            } else
            if (obj == com.jumio.mrz.impl.smartEngines.swig.MrzEngine.ImageOrientation.InvertedPortrait)
            {
                obj = com.jumio.mrz.impl.smartEngines.swig.MrzEngine.ImageOrientation.Portrait;
            }
        }
        f2 = (float)a.b.b.b / (float)a.b.b.a;
        if (a.c.f())
        {
            f = 1.0F;
        } else
        {
            f = 0.75F;
        }
        if (a.c.f() && f2 < f)
        {
            f1 = f2;
        } else
        {
            f1 = f;
            if (!a.c.f())
            {
                f1 = f;
                if (f2 > f)
                {
                    f1 = Math.min(1.0F, f2);
                }
            }
        }
        n1 = new n(-1, -1);
        abyte1 = q.a(abyte0, a.c.f(), a.b, f1, n1);
        if (abyte1 == null)
        {
            synchronized (a)
            {
                ix.a(a, false);
            }
            return;
        }
        f = a.a(abyte1, n1.a, n1.b, true);
        if (cs.a() && a.g != null)
        {
            a.g.a(-1F, f);
        }
        boolean flag;
        if (f <= 0.12F)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            i = k2 / 2;
            k = j2 / 2;
            ix.e(a).a(i + l1, k + i2);
            return;
        }
        ix.f(a).FeedUncompressedImageData(abyte0, i, k, i, 1, ((MrzRect) (obj1)), ((com.jumio.mrz.impl.smartEngines.swig.MrzEngine.ImageOrientation) (obj)));
        if (!oo.a())
        {
            break MISSING_BLOCK_LABEL_1652;
        }
        obj1 = oo.a(a.a, (new StringBuilder("MRZ_")).append(a.e.j).toString());
        if (ix.a(a).c != null && ix.a(a).c.length != 0)
        {
            byte abyte2[] = new byte[k2 * j2];
            int j1 = 0;
            do
            {
                if (j1 >= j2)
                {
                    break;
                }
                int k1 = 0;
                while (k1 < k2) 
                {
                    if (obj == com.jumio.mrz.impl.smartEngines.swig.MrzEngine.ImageOrientation.Landscape)
                    {
                        abyte2[j1 * k2 + k1] = abyte0[l1 + k1 + (j1 + i2) * i];
                    } else
                    if (obj == com.jumio.mrz.impl.smartEngines.swig.MrzEngine.ImageOrientation.InvertedLandscape)
                    {
                        abyte2[j1 * k2 + k1] = abyte0[((k - i2 - 1 - j1) * i + l1 + k2) - k1];
                    } else
                    if (obj == com.jumio.mrz.impl.smartEngines.swig.MrzEngine.ImageOrientation.Portrait)
                    {
                        abyte2[j1 * k2 + k1] = abyte0[((l1 + k2) - 1 - k1) * i + i2 + j1];
                    } else
                    if (obj == com.jumio.mrz.impl.smartEngines.swig.MrzEngine.ImageOrientation.InvertedPortrait)
                    {
                        abyte2[j1 * k2 + k1] = abyte0[((l1 + k1) * i + i) - i2 - j1];
                    }
                    k1++;
                }
                j1++;
            } while (true);
            oo.a(abyte2, ((java.io.File) (obj1)), String.format("%s_%d", new Object[] {
                a.e.j, Long.valueOf(System.currentTimeMillis())
            }), false);
        }
        if (!ix.a(a).a)
        {
            break MISSING_BLOCK_LABEL_1652;
        }
        oo.a(abyte0, ((java.io.File) (obj1)), "buffer.yuv", false);
        stringbuilder = new StringBuilder();
        calendar = Calendar.getInstance();
        oo.a(stringbuilder, "width = ", i);
        oo.a(stringbuilder, "height = ", k);
        oo.a(stringbuilder, "stride = ", i);
        oo.a(stringbuilder, "roi_x = ", l1);
        oo.a(stringbuilder, "roi_y = ", i2);
        oo.a(stringbuilder, "roiWidth = ", k2);
        oo.a(stringbuilder, "roiHeight = ", j2);
        oo.a(stringbuilder, "roi = ", "new MrzRect(roi_x, roi_y, roiWidth, roiHeight)");
        abyte0 = "Portrait";
          goto _L3
_L2:
        if (c.e == 180)
        {
            obj = com.jumio.mrz.impl.smartEngines.swig.MrzEngine.ImageOrientation.InvertedLandscape;
        } else
        if (c.e == 270)
        {
            obj = com.jumio.mrz.impl.smartEngines.swig.MrzEngine.ImageOrientation.InvertedPortrait;
        }
        continue; /* Loop/switch isn't completed */
        obj;
        abyte0;
        JVM INSTR monitorexit ;
        throw obj;
_L3:
        if (obj != com.jumio.mrz.impl.smartEngines.swig.MrzEngine.ImageOrientation.InvertedPortrait) goto _L5; else goto _L4
_L4:
        abyte0 = "InvertedPortrait";
_L7:
        oo.a(stringbuilder, "orientation = ", abyte0);
        stringbuilder.append("FeedUncompressedImageData(buffer, width, height, stride, 1, roi, orientation)");
        stringbuilder.append("\r\n\r\n");
        stringbuilder.append("Result:\r\n");
        abyte0 = ix.a(a).b.getMrzLines();
        for (int j = 0; (long)j < abyte0.size(); j++)
        {
            oo.a(stringbuilder, String.format("getMrzLines().get(%d) ", new Object[] {
                Integer.valueOf(j)
            }), abyte0.get(j));
        }

        break; /* Loop/switch isn't completed */
_L5:
        if (obj == com.jumio.mrz.impl.smartEngines.swig.MrzEngine.ImageOrientation.Landscape)
        {
            abyte0 = "Landscape";
        } else
        if (obj == com.jumio.mrz.impl.smartEngines.swig.MrzEngine.ImageOrientation.InvertedLandscape)
        {
            abyte0 = "InvertedLandscape";
        }
        if (true) goto _L7; else goto _L6
_L6:
        oo.a(stringbuilder, "getDocType() ", ix.a(a).b.getDocType().getAsString());
        oo.a(stringbuilder, "getDocTypeCode() ", ix.a(a).b.getDocTypeCode().getAsString());
        oo.a(stringbuilder, "getDocNum() ", ix.a(a).b.getDocNum().getAsString());
        oo.a(stringbuilder, "getOptData1() ", ix.a(a).b.getOptData1().getAsString());
        oo.a(stringbuilder, "getOptData2() ", ix.a(a).b.getOptData2().getAsString());
        calendar.set(ix.a(a).b.getExpidate().getAsMrzDate().getYear(), ix.a(a).b.getExpidate().getAsMrzDate().getMonth() - 1, ix.a(a).b.getExpidate().getAsMrzDate().getDay(), 0, 0, 0);
        oo.a(stringbuilder, "getExpidate() ", calendar.getTime().toString());
        oo.a(stringbuilder, "getCountry() ", ix.a(a).b.getCountry().getAsString());
        oo.a(stringbuilder, "getSecondName() ", ix.a(a).b.getSecondName().getAsString());
        oo.a(stringbuilder, "getFirstName() ", ix.a(a).b.getFirstName().getAsString());
        calendar.set(ix.a(a).b.getBirthdate().getAsMrzDate().getYear(), ix.a(a).b.getBirthdate().getAsMrzDate().getMonth() - 1, ix.a(a).b.getBirthdate().getAsMrzDate().getDay(), 0, 0, 0);
        oo.a(stringbuilder, "getBirthdate() ", calendar.getTime().toString());
        oo.a(stringbuilder, "getSex() ", ix.a(a).b.getSex().getAsString());
        oo.a(stringbuilder, "getNationality() ", ix.a(a).b.getNationality().getAsString());
        oo.a(stringbuilder.toString(), ((java.io.File) (obj1)), "info.txt", false);
        abyte0 = ay.a(abyte1, n1.a, n1.b);
        oo.a(a.a, abyte0, ((java.io.File) (obj1)), "roi_crop.png", android.graphics.Bitmap.CompressFormat.PNG, 80);
        if (ix.a(a).a)
        {
            a.a(ix.a(a).b, abyte1, n1.a, n1.b, f);
            return;
        }
        a.a(ix.a(a).c);
        return;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public void run()
    {
        try
        {
            a(b);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ab.a(((Throwable) (obj)));
        }
        synchronized (a)
        {
            ix.a(a, ix.a(a).a);
            b = null;
            c = null;
            System.gc();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
