// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;


// Referenced classes of package com.mopub.nativeads:
//            NativeVideoController

static class OnTrackedStrategy
{
    static interface OnTrackedStrategy
    {

        public abstract void execute();
    }


    boolean isTracked;
    int minimumPercentageVisible;
    OnTrackedStrategy strategy;
    int totalQualifiedPlayCounter;
    int totalRequiredPlayTimeMs;

    OnTrackedStrategy()
    {
    }
}
