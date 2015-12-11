// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms;


// Referenced classes of package com.digimarc.dms:
//            DMSIBaseSource

public abstract class DMSIImageSource extends DMSIBaseSource
{

    private int currentFrameRate;

    public DMSIImageSource()
    {
    }

    public int getCurrentFrameRate()
    {
        return currentFrameRate;
    }

    public void setCurrentFrameRate(int i)
    {
        currentFrameRate = i;
    }
}
