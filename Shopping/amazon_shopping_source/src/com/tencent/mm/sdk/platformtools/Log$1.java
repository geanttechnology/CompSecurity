// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.platformtools;

import android.util.Log;

// Referenced classes of package com.tencent.mm.sdk.platformtools:
//            Log

static final class gImp
    implements gImp
{

    public int getLogLevel()
    {
        return Log.access$000();
    }

    public void logD(String s, String s1, String s2, int i, int j, long l, 
            long l1, String s3)
    {
        if (Log.access$000() <= 1)
        {
            Log.d(s, s3);
        }
    }

    public void logE(String s, String s1, String s2, int i, int j, long l, 
            long l1, String s3)
    {
        if (Log.access$000() <= 4)
        {
            Log.e(s, s3);
        }
    }

    public void logI(String s, String s1, String s2, int i, int j, long l, 
            long l1, String s3)
    {
        if (Log.access$000() <= 2)
        {
            Log.i(s, s3);
        }
    }

    gImp()
    {
    }
}
