// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.platformtools;

import android.os.Process;
import java.io.File;
import java.util.Scanner;

// Referenced classes of package com.tencent.mm.sdk.platformtools:
//            Log

public final class TrafficStats
{

    public static final String DEV_FILE = "/proc/self/net/dev";
    public static final String GPRSLINE = "rmnet0";
    public static final String WIFILINE = "tiwlan0";
    private static long bl;
    private static long bm;
    private static long bn;
    private static long bo;
    private static long bp;
    private static long bq;
    private static long br;
    private static long bs;

    private TrafficStats()
    {
    }

    public static long getMobileRx(long l)
    {
        long l1 = l;
        if (bq > l)
        {
            l1 = bq;
        }
        return l1;
    }

    public static long getMobileTx(long l)
    {
        long l1 = l;
        if (bp > l)
        {
            l1 = bp;
        }
        return l1;
    }

    public static long getWifiRx(long l)
    {
        long l1 = l;
        if (bs > l)
        {
            l1 = bs;
        }
        return l1;
    }

    public static long getWifiTx(long l)
    {
        long l1 = l;
        if (br > l)
        {
            l1 = br;
        }
        return l1;
    }

    public static void reset()
    {
        bl = -1L;
        bm = -1L;
        bn = -1L;
        bo = -1L;
        update();
    }

    public static void update()
    {
        long l;
        long l1;
        long l2;
        long l3;
        l3 = 0L;
        l2 = 0L;
        l1 = 0L;
        l = 0L;
        Scanner scanner;
        scanner = new Scanner(new File((new StringBuilder("/proc/")).append(Process.myPid()).append("/net/dev").toString()));
        scanner.nextLine();
        scanner.nextLine();
_L2:
        String as[];
        if (!scanner.hasNext())
        {
            break MISSING_BLOCK_LABEL_232;
        }
        as = scanner.nextLine().split("[ :\t]+");
        Exception exception;
        int i;
        long l4;
        long l5;
        if (as[0].length() == 0)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        l5 = l2;
        l4 = l3;
        if (as[0].equals("lo"))
        {
            break MISSING_BLOCK_LABEL_154;
        }
        l5 = l2;
        l4 = l3;
        if (as[i + 0].startsWith("rmnet"))
        {
            l4 = l3 + Long.parseLong(as[i + 9]);
            l5 = l2 + Long.parseLong(as[i + 1]);
        }
        l2 = l5;
        l3 = l4;
        if (as[i + 0].equals("lo")) goto _L2; else goto _L1
_L1:
        l2 = l5;
        l3 = l4;
        if (as[i + 0].startsWith("rmnet")) goto _L2; else goto _L3
_L3:
        l1 += Long.parseLong(as[i + 9]);
        l += Long.parseLong(as[i + 1]);
        l2 = l5;
        l3 = l4;
          goto _L2
        scanner.close();
        if (bl < 0L)
        {
            bl = l3;
            Log.v("MicroMsg.SDK.TrafficStats", "fix loss newMobileTx %d", new Object[] {
                Long.valueOf(l3)
            });
        }
        if (bm < 0L)
        {
            bm = l2;
            Log.v("MicroMsg.SDK.TrafficStats", "fix loss newMobileRx %d", new Object[] {
                Long.valueOf(l2)
            });
        }
        if (bn < 0L)
        {
            bn = l1;
            Log.v("MicroMsg.SDK.TrafficStats", "fix loss newWifiTx %d", new Object[] {
                Long.valueOf(l1)
            });
        }
        if (bo < 0L)
        {
            bo = l;
            Log.v("MicroMsg.SDK.TrafficStats", "fix loss newWifiRx %d", new Object[] {
                Long.valueOf(l)
            });
        }
        if (l - bo < 0L)
        {
            Log.v("MicroMsg.SDK.TrafficStats", "minu %d", new Object[] {
                Long.valueOf(l - bo)
            });
        }
        if (l1 - bn < 0L)
        {
            Log.v("MicroMsg.SDK.TrafficStats", "minu %d", new Object[] {
                Long.valueOf(l1 - bn)
            });
        }
        if (l3 < bl) goto _L5; else goto _L4
_L4:
        l4 = l3 - bl;
_L12:
        bp = l4;
        if (l2 < bm) goto _L7; else goto _L6
_L6:
        l4 = l2 - bm;
_L13:
        bq = l4;
        if (l1 < bn) goto _L9; else goto _L8
_L8:
        l4 = l1 - bn;
_L14:
        br = l4;
        if (l < bo) goto _L11; else goto _L10
_L10:
        l4 = l - bo;
_L15:
        bs = l4;
        bl = l3;
        bm = l2;
        bn = l1;
        bo = l;
_L16:
        Log.d("MicroMsg.SDK.TrafficStats", "current system traffic: wifi rx/tx=%d/%d, mobile rx/tx=%d/%d", new Object[] {
            Long.valueOf(bs), Long.valueOf(br), Long.valueOf(bq), Long.valueOf(bp)
        });
        return;
_L5:
        l4 = l3;
          goto _L12
_L7:
        l4 = l2;
          goto _L13
_L9:
        l4 = l1;
          goto _L14
_L11:
        l4 = l;
          goto _L15
        exception;
        exception.printStackTrace();
          goto _L16
    }

    public static long updateMobileRx(long l)
    {
        update();
        return getMobileRx(l);
    }

    public static long updateMobileTx(long l)
    {
        update();
        return getMobileTx(l);
    }

    public static long updateWifiRx(long l)
    {
        update();
        return getWifiRx(l);
    }

    public static long updateWifiTx(long l)
    {
        update();
        return getWifiTx(l);
    }
}
