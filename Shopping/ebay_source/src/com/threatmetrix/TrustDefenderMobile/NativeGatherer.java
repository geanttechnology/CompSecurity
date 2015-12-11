// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.threatmetrix.TrustDefenderMobile;

import android.util.Log;

// Referenced classes of package com.threatmetrix.TrustDefenderMobile:
//            TrustDefenderMobileVersion

public final class NativeGatherer extends Enum
{
    private class NativeGathererHelper
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

        NativeGathererHelper()
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


    private static final NativeGatherer $VALUES[];
    public static final NativeGatherer INSTANCE;
    private final String TAG = com/threatmetrix/TrustDefenderMobile/NativeGatherer.getName();
    private final NativeGathererHelper m_gatherer = new NativeGathererHelper();

    private NativeGatherer(String s, int i)
    {
        super(s, i);
    }

    public static NativeGatherer valueOf(String s)
    {
        return (NativeGatherer)Enum.valueOf(com/threatmetrix/TrustDefenderMobile/NativeGatherer, s);
    }

    public static NativeGatherer[] values()
    {
        return (NativeGatherer[])$VALUES.clone();
    }

    public String[] checkURLs(String as[])
    {
        if (m_gatherer.m_available)
        {
            if (m_gatherer.m_packagesFound == m_gatherer.m_packageLimit)
            {
                Log.d(TAG, (new StringBuilder()).append("Finding more packages ").append(m_gatherer.m_packagesFound).append(" / ").append(m_gatherer.m_packageTotalLimit).toString());
                NativeGathererHelper nativegathererhelper = m_gatherer;
                nativegathererhelper.m_packageTotalLimit = nativegathererhelper.m_packageTotalLimit + m_gatherer.findPackages(m_gatherer.m_packageLimit, m_gatherer.m_systemPath);
            }
            return m_gatherer.checkURLs(as);
        } else
        {
            return null;
        }
    }

    static 
    {
        INSTANCE = new NativeGatherer("INSTANCE", 0);
        $VALUES = (new NativeGatherer[] {
            INSTANCE
        });
    }
}
