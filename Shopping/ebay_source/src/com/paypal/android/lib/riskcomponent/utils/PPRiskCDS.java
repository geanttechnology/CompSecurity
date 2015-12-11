// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.lib.riskcomponent.utils;


// Referenced classes of package com.paypal.android.lib.riskcomponent.utils:
//            Util, PPRiskData

public class PPRiskCDS
{

    public static final PPRiskCDS DEFAULT_BITMAP = new PPRiskCDS();
    private static final String TAG = com/paypal/android/lib/riskcomponent/utils/PPRiskCDS.getSimpleName();
    private byte mCdsBytes[];

    private PPRiskCDS()
    {
        mCdsBytes = null;
        mCdsBytes = null;
    }

    public PPRiskCDS(String s)
    {
        mCdsBytes = null;
        int i;
        mCdsBytes = new byte[(s.length() + 1) / 2];
        i = s.length() - 1;
        int j = 0;
          goto _L1
_L5:
        int k;
        mCdsBytes[j] = (byte)Integer.parseInt(s.substring(k, i + 1), 16);
        i -= 2;
        j++;
          goto _L1
        s;
        Util.logExceptionSliently(TAG, "PPRiskDataBitSet initialize failed", s);
        mCdsBytes = null;
_L3:
        return;
_L1:
        if (i < 0) goto _L3; else goto _L2
_L2:
        int l = i - 1;
        k = l;
        if (l < 0)
        {
            k = 0;
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    public boolean isCDSEnabled(PPRiskData ppriskdata)
    {
        int i = ppriskdata.ordinal() / 8;
        if (mCdsBytes != null)
        {
            if (i >= mCdsBytes.length)
            {
                return false;
            }
            i = mCdsBytes[i];
            byte byte0 = (byte)(1 << ppriskdata.ordinal() % 8);
            if ((i & byte0) != byte0)
            {
                return false;
            }
        }
        return true;
    }

}
