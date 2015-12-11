// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.immersion.hapticmediasdk;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.HandlerThread;
import com.immersion.hapticmediasdk.utils.Log;
import com.immersion.hapticmediasdk.utils.RuntimeInfo;

// Referenced classes of package com.immersion.hapticmediasdk:
//            MediaTaskManager

public abstract class HapticContentSDK
{

    public static final int INACCESSIBLE_URL = -2;
    public static final int INVALID = -1;
    public static final int MALFORMED_URL = -4;
    public static final int PERMISSION_DENIED = -3;
    public static final int SDKMODE_MEDIAPLAYBACK = 0;
    public static final int SUCCESS = 0;
    public static final int UNSUPPORTED_PROTOCOL = -5;
    private static final String a = "HapticContentSDK";
    public static final int b044404440444044404440444 = 10000;
    public static int b044604460446044604460446 = 25;
    public static int b044604460446044604460446 = 1;
    public static final int b044404440444044404440444 = 1500;
    public static int b044604460446044604460446 = 2;
    public static int b044604460446044604460446;
    private HandlerThread b;
    private Handler c;
    private Context d;
    private RuntimeInfo e;
    public boolean mDisposed;
    public MediaTaskManager mMediaTaskManager;
    public SDKStatus mSDKStatus;

    public HapticContentSDK(int i, Context context)
    {
    /* block-local class not found */
    class SDKStatus {}

        mSDKStatus = SDKStatus.NOT_INITIALIZED;
        mDisposed = false;
        d = context;
        if (((b044604460446044604460446 + b044604460446044604460446) * b044604460446044604460446) % b044604460446044604460446 != b044604460446044604460446)
        {
            b044604460446044604460446 = 24;
            b044604460446044604460446 = b044604460446044604460446();
        }
        e = new RuntimeInfo();
    }

    public static int b044604460446044604460446()
    {
        return 96;
    }

    public static int b044604460446044604460446()
    {
        return 2;
    }

    public int b041104110411041104110411()
    {
        if (d.getPackageManager().checkPermission("android.permission.VIBRATE", d.getPackageName()) != 0)
        {
            break MISSING_BLOCK_LABEL_133;
        }
        b = new HandlerThread("SDK Monitor");
        b.start();
        Handler handler;
        int i;
        try
        {
            c = new Handler(b.getLooper());
            handler = c;
        }
        catch (Exception exception1)
        {
            throw exception1;
        }
        i = b044604460446044604460446;
        switch ((i * (b044604460446044604460446 + i)) % b044604460446044604460446)
        {
        default:
            b044604460446044604460446 = b044604460446044604460446();
            b044604460446044604460446 = 93;
            break;

        case 0: // '\0'
            break;
        }
        try
        {
            mMediaTaskManager = new MediaTaskManager(handler, d, e);
        }
        catch (Exception exception)
        {
            throw exception;
        }
        return 0;
        Log.e("HapticContentSDK", "Failed to create a Haptic Content SDK instance.Vibrate permission denied.");
        return -3;
    }

    public final void dispose()
    {
        if (getSDKStatus() != SDKStatus.DISPOSED)
        {
            mMediaTaskManager.transitToState(SDKStatus.NOT_INITIALIZED);
            b.quit();
            b = null;
            mMediaTaskManager = null;
            mDisposed = true;
        }
    }

    public void finalize()
        throws Throwable
    {
        dispose();
        super.finalize();
        return;
        Object obj;
        obj;
        super.finalize();
        throw obj;
        obj;
        throw obj;
    }

    public final SDKStatus getSDKStatus()
    {
        if (mDisposed)
        {
            return SDKStatus.DISPOSED;
        } else
        {
            return mMediaTaskManager.getSDKStatus();
        }
    }

    public final String getVersion()
    {
        throw new Runtime("d2j fail translate: java.lang.IndexOutOfBoundsException: fromIndex < 0: -1\n\tat java.util.BitSet.nextSetBit(BitSet.java:701)\n\tat com.googlecode.dex2jar.ir.ts.array.FillArrayTransformer.makeSureAllElementAreAssigned(FillArrayTransformer.java:505)\n\tat com.googlecode.dex2jar.ir.ts.array.FillArrayTransformer.transformReportChanged(FillArrayTransformer.java:123)\n\tat com.googlecode.dex2jar.ir.ts.StatedTransformer.transform(StatedTransformer.java:10)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:149)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
    }

    public final int mute()
    {
        int i = b044604460446044604460446;
        switch ((i * (b044604460446044604460446 + i)) % b044604460446044604460446)
        {
        default:
            b044604460446044604460446 = 16;
            b044604460446044604460446 = b044604460446044604460446();
            break;

        case 0: // '\0'
            break;
        }
        SDKStatus sdkstatus;
        SDKStatus sdkstatus1;
        try
        {
            sdkstatus = getSDKStatus();
            sdkstatus1 = SDKStatus.DISPOSED;
        }
        catch (Exception exception)
        {
            throw exception;
        }
        if (sdkstatus != sdkstatus1)
        {
            try
            {
                e.mute();
            }
            catch (Exception exception1)
            {
                throw exception1;
            }
            return 0;
        } else
        {
            return -1;
        }
    }

    public abstract int openHaptics(String s);

    public final int pause()
    {
        SDKStatus sdkstatus;
        SDKStatus sdkstatus1;
        sdkstatus = getSDKStatus();
        if (sdkstatus == SDKStatus.DISPOSED)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        sdkstatus1 = SDKStatus.STOPPED_DUE_TO_ERROR;
        if (sdkstatus != sdkstatus1)
        {
            break MISSING_BLOCK_LABEL_37;
        }
        try
        {
            throw new NullPointerException();
        }
        catch (Exception exception)
        {
            b044604460446044604460446 = 21;
        }
        return -1;
        MediaTaskManager mediataskmanager;
        int i;
        try
        {
            mediataskmanager = mMediaTaskManager;
        }
        catch (Exception exception1)
        {
            throw exception1;
        }
        try
        {
            i = mediataskmanager.transitToState(SDKStatus.PAUSED);
        }
        catch (Exception exception2)
        {
            throw exception2;
        }
        return i;
    }

    public final int play()
    {
label0:
        {
            Object obj;
            SDKStatus sdkstatus;
            int i;
            try
            {
                obj = getSDKStatus();
                if (obj != SDKStatus.INITIALIZED && obj != SDKStatus.STOPPED)
                {
                    break label0;
                }
                mMediaTaskManager.setMediaTimestamp(0L);
                obj = mMediaTaskManager;
                sdkstatus = SDKStatus.PLAYING;
            }
            catch (Exception exception)
            {
                throw exception;
            }
            if (((b044604460446044604460446() + b044604460446044604460446) * b044604460446044604460446()) % b044604460446044604460446() != b044604460446044604460446)
            {
                b044604460446044604460446 = b044604460446044604460446();
                b044604460446044604460446 = b044604460446044604460446();
            }
            try
            {
                i = ((MediaTaskManager) (obj)).transitToState(sdkstatus);
            }
            catch (Exception exception1)
            {
                throw exception1;
            }
            return i;
        }
        return -1;
    }

    public final int resume()
    {
        throw new Runtime("d2j fail translate: java.lang.IndexOutOfBoundsException: fromIndex < 0: -1\n\tat java.util.BitSet.nextSetBit(BitSet.java:701)\n\tat com.googlecode.dex2jar.ir.ts.array.FillArrayTransformer.makeSureAllElementAreAssigned(FillArrayTransformer.java:505)\n\tat com.googlecode.dex2jar.ir.ts.array.FillArrayTransformer.transformReportChanged(FillArrayTransformer.java:123)\n\tat com.googlecode.dex2jar.ir.ts.StatedTransformer.transform(StatedTransformer.java:10)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:149)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
    }

    public final int seek(int i)
    {
        SDKStatus sdkstatus = getSDKStatus();
        int j = b044604460446044604460446;
        SDKStatus sdkstatus1;
        switch ((j * (b044604460446044604460446 + j)) % b044604460446044604460446)
        {
        default:
            b044604460446044604460446 = 56;
            b044604460446044604460446 = b044604460446044604460446();
            // fall through

        case 0: // '\0'
            sdkstatus1 = SDKStatus.DISPOSED;
            break;
        }
label0:
        do
        {
            switch (1)
            {
            default:
                while (true) 
                {
                    switch (1)
                    {
                    default:
                        break;

                    case 0: // '\0'
                        continue label0;

                    case 1: // '\001'
                        break label0;
                    }
                }
                break;

            case 0: // '\0'
                break;

            case 1: // '\001'
                break label0;
            }
        } while (true);
        if (sdkstatus == sdkstatus1 || sdkstatus == SDKStatus.NOT_INITIALIZED || sdkstatus == SDKStatus.STOPPED_DUE_TO_ERROR)
        {
            return -1;
        } else
        {
            return mMediaTaskManager.SeekTo(i);
        }
    }

    public final int stop()
    {
        SDKStatus sdkstatus = getSDKStatus();
        if (sdkstatus != SDKStatus.DISPOSED && sdkstatus != SDKStatus.NOT_INITIALIZED) goto _L2; else goto _L1
_L1:
        int i = -1;
_L8:
        return i;
_L2:
        int j = mMediaTaskManager.transitToState(SDKStatus.STOPPED);
_L4:
        i = j;
        1;
        JVM INSTR tableswitch 0 1: default 60
    //                   0 34
    //                   1 21;
           goto _L3 _L4 _L5
_L5:
        continue; /* Loop/switch isn't completed */
_L3:
        i = j;
        1;
        JVM INSTR tableswitch 0 1: default 84
    //                   0 34
    //                   1 21;
           goto _L3 _L4 _L6
_L6:
        if (true) goto _L8; else goto _L7
_L7:
    }

    public final int unmute()
    {
label0:
        {
            try
            {
                if (getSDKStatus() == SDKStatus.DISPOSED)
                {
                    break label0;
                }
                e.unmute();
            }
            catch (Exception exception)
            {
                throw exception;
            }
            return 0;
        }
        return -1;
    }

    public final int update(long l)
    {
_L6:
        mMediaTaskManager.setMediaTimestamp(l);
        return 0;
        SDKStatus sdkstatus = getSDKStatus();
        int i = b044604460446044604460446;
        switch ((i * (b044604460446044604460446 + i)) % b044604460446044604460446)
        {
        default:
            b044604460446044604460446 = b044604460446044604460446();
            b044604460446044604460446 = 98;
            break;

        case 0: // '\0'
            break;
        }
        if (sdkstatus == SDKStatus.PLAYING || sdkstatus == SDKStatus.PAUSED_DUE_TO_TIMEOUT)
        {
            mMediaTaskManager.setMediaTimestamp(l);
            return mMediaTaskManager.transitToState(SDKStatus.PLAYING);
        }
        while (sdkstatus != SDKStatus.PAUSED && sdkstatus != SDKStatus.PAUSED_DUE_TO_BUFFERING) 
        {
            return -1;
        }
_L2:
        1;
        JVM INSTR tableswitch 0 1: default 132
    //                   0 110
    //                   1 84;
           goto _L1 _L2 _L3
_L3:
        continue; /* Loop/switch isn't completed */
_L1:
        1;
        JVM INSTR tableswitch 0 1: default 156
    //                   0 110
    //                   1 84;
           goto _L1 _L2 _L4
_L4:
        if (true) goto _L6; else goto _L5
_L5:
    }
}
