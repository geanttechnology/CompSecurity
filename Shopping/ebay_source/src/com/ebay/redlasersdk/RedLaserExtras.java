// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.redlasersdk;

import RLSDK.a;
import RLSDK.b;
import RLSDK.l;
import RLSDK.m;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Process;
import java.util.Set;

// Referenced classes of package com.ebay.redlasersdk:
//            BarcodeTypes

public class RedLaserExtras
{
    public static final class RLScannerReadyState extends Enum
    {

        private static final RLScannerReadyState $VALUES[];
        public static final RLScannerReadyState APILevelTooLow;
        public static final RLScannerReadyState BadLicense;
        public static final RLScannerReadyState EvalModeReady;
        public static final RLScannerReadyState LicensedModeReady;
        public static final RLScannerReadyState MissingPermissions;
        public static final RLScannerReadyState NoCamera;
        public static final RLScannerReadyState ScanLimitReached;
        public static final RLScannerReadyState UnknownState;
        public static final RLScannerReadyState UnsupportedHardware;

        public static RLScannerReadyState valueOf(String s)
        {
            return (RLScannerReadyState)Enum.valueOf(com/ebay/redlasersdk/RedLaserExtras$RLScannerReadyState, s);
        }

        public static RLScannerReadyState[] values()
        {
            return (RLScannerReadyState[])$VALUES.clone();
        }

        static 
        {
            EvalModeReady = new RLScannerReadyState("EvalModeReady", 0);
            LicensedModeReady = new RLScannerReadyState("LicensedModeReady", 1);
            APILevelTooLow = new RLScannerReadyState("APILevelTooLow", 2);
            NoCamera = new RLScannerReadyState("NoCamera", 3);
            BadLicense = new RLScannerReadyState("BadLicense", 4);
            ScanLimitReached = new RLScannerReadyState("ScanLimitReached", 5);
            MissingPermissions = new RLScannerReadyState("MissingPermissions", 6);
            UnsupportedHardware = new RLScannerReadyState("UnsupportedHardware", 7);
            UnknownState = new RLScannerReadyState("UnknownState", 8);
            $VALUES = (new RLScannerReadyState[] {
                EvalModeReady, LicensedModeReady, APILevelTooLow, NoCamera, BadLicense, ScanLimitReached, MissingPermissions, UnsupportedHardware, UnknownState
            });
        }

        private RLScannerReadyState(String s, int i)
        {
            super(s, i);
        }
    }


    private RedLaserExtras()
    {
    }

    public static Set ScanBitmap(Bitmap bitmap, Context context)
    {
        BarcodeTypes barcodetypes = new BarcodeTypes();
        barcodetypes.setEnabledTypes(-1);
        context = new b(barcodetypes, context);
        bitmap = context.a(bitmap);
        context.a();
        return bitmap;
    }

    public static RLScannerReadyState checkReadyStatus(Context context)
    {
        if (android.os.Build.VERSION.SDK_INT < 7)
        {
            return RLScannerReadyState.APILevelTooLow;
        }
        a.a();
        RLSDK.a.a a1 = RLSDK.a.a.b;
        if (a1 == RLSDK.a.a.c)
        {
            return RLScannerReadyState.ScanLimitReached;
        }
        if (a1 == RLSDK.a.a.e)
        {
            return RLScannerReadyState.BadLicense;
        }
        if (!context.getPackageManager().hasSystemFeature("android.hardware.camera"))
        {
            return RLScannerReadyState.NoCamera;
        }
        if (Build.MODEL.equals("Xoom"))
        {
            return RLScannerReadyState.UnsupportedHardware;
        }
        if (context.checkPermission("android.permission.CAMERA", Process.myPid(), Process.myUid()) != 0 || context.checkPermission("android.permission.INTERNET", Process.myPid(), Process.myUid()) != 0)
        {
            return RLScannerReadyState.MissingPermissions;
        }
        if (a1 == RLSDK.a.a.a)
        {
            return RLScannerReadyState.EvalModeReady;
        }
        if (a1 == RLSDK.a.a.b)
        {
            return RLScannerReadyState.LicensedModeReady;
        } else
        {
            return RLScannerReadyState.UnknownState;
        }
    }

    public static String getDeviceID(ContentResolver contentresolver)
    {
        m.a(contentresolver);
        return m.a();
    }

    public static String getRedLaserSDKVersion()
    {
        return l.a;
    }
}
