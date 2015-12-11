// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package amazon.profile;

import android.util.Log;

// Referenced classes of package amazon.profile:
//            TLogger

public class TLoggerFactory
{

    public TLoggerFactory()
    {
    }

    public static TLogger getLogger(String s)
    {
        Log.d("BogusTLoggerFactory", "getLogger");
        return new TLogger();
    }
}
