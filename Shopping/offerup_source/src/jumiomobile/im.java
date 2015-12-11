// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import com.jumio.netverify.sdk.core.ModelTemplate;
import com.jumio.ocr.impl.smartEngines.swig.DetectionEngine;
import com.jumio.ocr.impl.smartEngines.swig.DetectionResult;
import com.jumio.ocr.impl.smartEngines.swig.OcrPoint;
import com.jumio.ocr.impl.smartEngines.swig.OcrQuadrangle;
import java.util.Arrays;

// Referenced classes of package jumiomobile:
//            ij, ao, l, n, 
//            cs, mr, oo, op

class im extends Thread
{

    final ij a;
    private byte b[];

    public im(ij ij1, byte abyte0[])
    {
        a = ij1;
        super();
        b = Arrays.copyOf(abyte0, abyte0.length);
    }

    public void run()
    {
        boolean flag1 = false;
        ij.h = 800;
        ij.i = 600;
        byte abyte0[];
        boolean flag;
        if (a.c.f())
        {
            if (a.b.c.a < 800)
            {
                int i = (int)(((float)(a.b.a.a - a.b.b.a) / 2.0F) * ((float)a.b.c.a / (float)a.b.a.a));
                i = a.b.c.a - i * 2;
                ij.h = i;
                ij.i = (int)((float)i * 0.75F);
            }
        } else
        if (a.c.c())
        {
            j = (int)(((float)(a.b.a.a - a.b.b.a) / 2.0F) * ((float)a.b.c.a / (float)a.b.a.a));
            if (a.b.c.a - j * 2 < 800)
            {
                j = a.b.c.a - j * 2;
                ij.h = j;
                ij.i = (int)((float)j * 0.75F);
            }
        } else
        if (a.b.c.b < 600)
        {
            j = (int)(((float)(a.b.a.b - a.b.b.b) / 2.0F) * ((float)a.b.c.b / (float)a.b.a.b));
            j = a.b.c.b - j * 2;
            ij.i = j;
            ij.h = (int)((float)j / 0.75F);
        }
        abyte0 = ij.a(a, b, ij.h, ij.i);
        flag = flag1;
        if (abyte0 != null)
        {
            float f = a.a(abyte0, ij.h, ij.i, true);
            if (cs.a() && a.g != null)
            {
                a.g.a(-1F, f);
            }
            if (f >= 0.12F)
            {
                obj = ij.a(a).processRawImage(abyte0, ij.h, ij.i, ij.h * 3, (int)System.currentTimeMillis());
            } else
            {
                obj = null;
            }
            flag = flag1;
            if (obj != null)
            {
                ij ij1 = a;
                boolean flag2 = ((DetectionResult) (obj)).hasTopOfCard();
                boolean flag3 = ((DetectionResult) (obj)).hasBottomOfCard();
                boolean flag4 = ((DetectionResult) (obj)).hasLeftOfCard();
                boolean flag5 = ((DetectionResult) (obj)).hasRightOfCard();
                boolean flag6 = ((DetectionResult) (obj)).getFlashTurnOn();
                if (!((DetectionResult) (obj)).isCardImageOfGoodQuality())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                flag = ij1.a(flag2, flag3, flag4, flag5, flag6, flag);
                if (flag)
                {
                    Object obj1 = ((DetectionResult) (obj)).getCardQuadrangle();
                    if (obj1 != null)
                    {
                        OcrPoint ocrpoint = ((OcrQuadrangle) (obj1)).getTopLeft();
                        OcrPoint ocrpoint1 = ((OcrQuadrangle) (obj1)).getTopRight();
                        OcrPoint ocrpoint2 = ((OcrQuadrangle) (obj1)).getBottomLeft();
                        obj1 = ((OcrQuadrangle) (obj1)).getBottomRight();
                        byte abyte1[];
                        int j;
                        int k;
                        int i1;
                        int j1;
                        int k1;
                        if (ocrpoint.getX() < ocrpoint2.getX())
                        {
                            k = ocrpoint.getX();
                        } else
                        {
                            k = ocrpoint2.getX();
                        }
                        if (ocrpoint.getY() < ocrpoint1.getY())
                        {
                            j = ocrpoint.getY();
                        } else
                        {
                            j = ocrpoint1.getY();
                        }
                        if (((OcrPoint) (obj1)).getX() > ocrpoint1.getX())
                        {
                            i1 = ((OcrPoint) (obj1)).getX();
                        } else
                        {
                            i1 = ocrpoint1.getX();
                        }
                        if (((OcrPoint) (obj1)).getY() > ocrpoint2.getY())
                        {
                            j1 = ((OcrPoint) (obj1)).getY();
                        } else
                        {
                            j1 = ocrpoint2.getY();
                        }
                        k1 = i1 - k;
                        j1 -= j;
                        abyte1 = new byte[k1 * j1 * 3];
                        for (i1 = j; i1 < j + j1; i1++)
                        {
                            System.arraycopy(abyte0, ij.h * i1 * 3 + k * 3, abyte1, (i1 - j) * k1 * 3, k1 * 3);
                        }

                        a.a(abyte0, ij.h, ij.i, abyte1, k1, j1, f);
                    }
                    if (oo.a())
                    {
                        java.io.File file = oo.a(a.a, (new StringBuilder("LF_")).append(a.e.j).toString());
                        oo.a(b, file, String.format("buffer_%d.yuv", new Object[] {
                            Long.valueOf(a.f)
                        }), false);
                        oo.a(abyte0, file, String.format("buffer_%d.rgb", new Object[] {
                            Long.valueOf(a.f)
                        }), false);
                        StringBuilder stringbuilder = new StringBuilder();
                        oo.a(stringbuilder, "hasTopOfCard() ", Boolean.toString(((DetectionResult) (obj)).hasTopOfCard()));
                        oo.a(stringbuilder, "hasBottomOfCard() ", Boolean.toString(((DetectionResult) (obj)).hasBottomOfCard()));
                        oo.a(stringbuilder, "hasLeftOfCard() ", Boolean.toString(((DetectionResult) (obj)).hasLeftOfCard()));
                        oo.a(stringbuilder, "hasRightOfCard() ", Boolean.toString(((DetectionResult) (obj)).hasRightOfCard()));
                        oo.a(stringbuilder, "getFlashTurnOn() ", Boolean.toString(((DetectionResult) (obj)).getFlashTurnOn()));
                        oo.a(stringbuilder, "isCardImageOfGoodQuality() ", Boolean.toString(((DetectionResult) (obj)).isCardImageOfGoodQuality()));
                        stringbuilder.append("\r\n");
                        op.a(stringbuilder);
                        oo.a(stringbuilder.toString(), file, "info.txt", true);
                    }
                }
            }
        }
        b = null;
        System.gc();
        synchronized (a)
        {
            ij.a(a, flag);
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
