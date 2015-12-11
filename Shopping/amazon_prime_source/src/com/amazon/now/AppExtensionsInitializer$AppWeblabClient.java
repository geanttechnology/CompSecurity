// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now;

import com.amazon.retailsearch.android.api.experimentation.WeblabClient;

// Referenced classes of package com.amazon.now:
//            AppExtensionsInitializer

private static class <init>
    implements WeblabClient
{

    private boolean isSparkleFeature(String s)
    {
        return s.contains("Android_Sparkle");
    }

    public String getTreatment(String s)
    {
        return "C";
    }

    public String getTreatmentAndTrigger(String s)
    {
        if (isSparkleFeature(s))
        {
            return "T1";
        } else
        {
            return "C";
        }
    }

    public void postFeatureTrigger(String s)
    {
    }

    private abClient()
    {
    }

    abClient(abClient abclient)
    {
        this();
    }
}
