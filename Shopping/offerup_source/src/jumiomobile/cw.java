// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import com.jumio.ocr.impl.smartEngines.swig.YuvUtils;

// Referenced classes of package jumiomobile:
//            r, cs

public class cw
    implements r
{

    public cw()
    {
    }

    public int a(byte abyte0[], int i, int j, int k, int l, int i1, int j1, 
            byte abyte1[], int k1, int l1, int i2, StringBuilder stringbuilder)
    {
        int j2 = YuvUtils.yuvCutRotateScale2rgb(abyte0, i, j, k, l, i1, j1, abyte1, k1, l1, i2);
        if (cs.a() && stringbuilder != null)
        {
            cs.a(stringbuilder, "yuvWidth = ", i);
            cs.a(stringbuilder, "yuvHeight = ", j);
            cs.a(stringbuilder, "holeLeft = ", k);
            cs.a(stringbuilder, "holeTop = ", l);
            cs.a(stringbuilder, "holeWidth = ", i1);
            cs.a(stringbuilder, "holeHeight = ", j1);
            cs.a(stringbuilder, "outWidth = ", k1);
            cs.a(stringbuilder, "outHeight = ", l1);
            cs.a(stringbuilder, "imageRotation = ", i2);
            stringbuilder.append("status = YuvUtils.yuvCutRotateScale2rgb(yuv, yuvWidth, yuvHeight, holeLeft, holeTop, holeWidth, holeHeight, out, outWidth, outHeight, imageRotation)");
            stringbuilder.append("\r\n\r\n");
            stringbuilder.append("Result:\r\n");
            cs.a(stringbuilder, "status: ", j2);
        }
        return j2;
    }
}
