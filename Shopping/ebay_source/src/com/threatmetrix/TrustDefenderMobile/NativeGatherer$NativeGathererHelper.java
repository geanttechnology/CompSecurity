// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.threatmetrix.TrustDefenderMobile;

import android.util.Log;

// Referenced classes of package com.threatmetrix.TrustDefenderMobile:
//            NativeGatherer, TrustDefenderMobileVersion

private class m_available
{

    private final String TAG = com/threatmetrix/TrustDefenderMobile/NativeGatherer$NativeGathererHelper.getName();
    boolean m_available;
    int m_packageLimit;
    int m_packageTotalLimit;
    int m_packagesFound;
    String m_systemPath;
    final NativeGatherer this$0;

    native String[] checkURLs(String as[]);

    protected void finalize()
        throws Throwable
    {
        super.finalize();
        finit();
    }

    native int findPackages(int i, String s);

    native void finit();

    native boolean init(int i);

    ()
    {
        this$0 = NativeGatherer.this;
        super();
        m_packagesFound = 0;
        m_packageLimit = 10;
        m_packageTotalLimit = m_packageLimit;
        m_systemPath = "/system/app";
        boolean flag;
        try
        {
            System.loadLibrary("trustdefender-jni");
            flag = init(TrustDefenderMobileVersion.numeric.intValue());
            Log.d(TAG, "Finding packages");
            m_packagesFound = findPackages(m_packageLimit, m_systemPath);
        }
        // Misplaced declaration of an exception variable
        catch (NativeGatherer nativegatherer)
        {
            flag = false;
        }
        m_available = flag;
    }
}
