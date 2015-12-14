// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.platformtools;

import android.os.Build;
import android.text.format.DateFormat;
import com.tencent.mm.algorithm.TypeTransform;
import java.io.PrintStream;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

// Referenced classes of package com.tencent.mm.sdk.platformtools:
//            Util

final class LogHelper
{

    private static final byte au[] = {
        4, 0, 0, 0, -1, -1, -1, 0
    };

    private LogHelper()
    {
    }

    public static void initLogHeader(PrintStream printstream, String s, String s1, long l, int i)
    {
        if (printstream == null || Util.isNullOrNil(s1) || l == 0L)
        {
            return;
        } else
        {
            printstream.println((new StringBuilder("1 ")).append(s).toString());
            printstream.println((new StringBuilder("2 ")).append(s1).toString());
            printstream.println((new StringBuilder("3 ")).append(l).toString());
            printstream.println((new StringBuilder("4 ")).append(Integer.toHexString(i)).toString());
            printstream.println((new StringBuilder("5 ")).append(android.os.Build.VERSION.RELEASE).toString());
            printstream.println((new StringBuilder("6 ")).append(android.os.Build.VERSION.CODENAME).toString());
            printstream.println((new StringBuilder("7 ")).append(android.os.Build.VERSION.INCREMENTAL).toString());
            printstream.println((new StringBuilder("8 ")).append(Build.BOARD).toString());
            printstream.println((new StringBuilder("9 ")).append(Build.DEVICE).toString());
            printstream.println((new StringBuilder("10 ")).append(Build.DISPLAY).toString());
            printstream.println((new StringBuilder("11 ")).append(Build.FINGERPRINT).toString());
            printstream.println((new StringBuilder("12 ")).append(Build.HOST).toString());
            printstream.println((new StringBuilder("13 ")).append(Build.MANUFACTURER).toString());
            printstream.println((new StringBuilder("14 ")).append(Build.MODEL).toString());
            printstream.println((new StringBuilder("15 ")).append(Build.PRODUCT).toString());
            printstream.println((new StringBuilder("16 ")).append(Build.TAGS).toString());
            printstream.println((new StringBuilder("17 ")).append(Build.TYPE).toString());
            printstream.println((new StringBuilder("18 ")).append(Build.USER).toString());
            printstream.println();
            printstream.flush();
            return;
        }
    }

    public static void writeToStream(PrintStream printstream, byte abyte0[], String s, String s1)
    {
        if (printstream == null || Util.isNullOrNil(abyte0) || Util.isNullOrNil(s) || Util.isNullOrNil(s1))
        {
            return;
        }
        printstream;
        JVM INSTR monitorenter ;
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append(DateFormat.format("MM-dd kk:mm:ss", System.currentTimeMillis()));
        stringbuffer.append(" ").append(s).append(" ").append(s1);
        s = stringbuffer.toString();
        abyte0 = new DESKeySpec(abyte0);
        abyte0 = SecretKeyFactory.getInstance("DES").generateSecret(abyte0);
        s1 = Cipher.getInstance("DES");
        s1.init(1, abyte0);
        abyte0 = s1.doFinal(s.getBytes());
        printstream.write(TypeTransform.intToByteArrayLH(abyte0.length));
        printstream.write(abyte0);
        printstream.write(au);
_L1:
        printstream.flush();
        printstream;
        JVM INSTR monitorexit ;
        return;
        abyte0;
        printstream;
        JVM INSTR monitorexit ;
        throw abyte0;
        abyte0;
        abyte0.printStackTrace();
          goto _L1
    }

}
