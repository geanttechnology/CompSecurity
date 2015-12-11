// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c;

import com.immersion.hapticmediasdk.b.b;
import com.immersion.hapticmediasdk.d;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class f
    implements Runnable
{

    public static int b = 24;
    public static int c = 1;
    public static int d = 2;
    public final d a;
    private URL e;

    public f(d d1, String s)
    {
        throw new Runtime("d2j fail translate: java.lang.IndexOutOfBoundsException: fromIndex < 0: -1\n\tat java.util.BitSet.nextSetBit(BitSet.java:701)\n\tat com.googlecode.dex2jar.ir.ts.array.FillArrayTransformer.makeSureAllElementAreAssigned(FillArrayTransformer.java:505)\n\tat com.googlecode.dex2jar.ir.ts.array.FillArrayTransformer.transformReportChanged(FillArrayTransformer.java:123)\n\tat com.googlecode.dex2jar.ir.ts.StatedTransformer.transform(StatedTransformer.java:10)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:149)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
    }

    public static int a()
    {
        return 6;
    }

    private void a(int i)
    {
        this;
        JVM INSTR monitorenter ;
        com.immersion.hapticmediasdk.d.a(a, i);
        notifyAll();
          goto _L1
_L6:
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
_L1:
        0;
        JVM INSTR tableswitch 0 1: default 48
    //                   0 18
    //                   1 26;
           goto _L2 _L3 _L1
_L3:
        continue; /* Loop/switch isn't completed */
_L2:
        1;
        JVM INSTR tableswitch 0 1: default 72
    //                   0 26
    //                   1 18;
           goto _L2 _L1 _L4
_L4:
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void run()
    {
        HttpURLConnection httpurlconnection;
        httpurlconnection = (HttpURLConnection)e.openConnection();
        httpurlconnection.setConnectTimeout(10000);
        httpurlconnection.setReadTimeout(10000);
        httpurlconnection.setUseCaches(false);
        int i = b;
        switch ((i * (c + i)) % d)
        {
        default:
            b = 0;
            c = a();
            break;

        case 0: // '\0'
            break;
        }
        int j;
        httpurlconnection.setRequestMethod("HEAD");
        j = httpurlconnection.getResponseCode();
        Object obj;
        try
        {
            a(j);
            return;
        }
        catch (Exception exception)
        {
            throw exception;
        }
        obj;
        com.immersion.hapticmediasdk.b.b.d("ValidateURL", ((IOException) (obj)).getMessage());
        try
        {
            a(500);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw obj;
        }
        obj;
        a(500);
        throw obj;
    }
}
