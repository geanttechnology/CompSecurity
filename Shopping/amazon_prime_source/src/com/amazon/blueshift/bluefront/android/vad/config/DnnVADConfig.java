// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.blueshift.bluefront.android.vad.config;

import com.google.common.base.Optional;

// Referenced classes of package com.amazon.blueshift.bluefront.android.vad.config:
//            VADConfig

public final class DnnVADConfig extends VADConfig
{

    public static final int DEFAULT_ENDPOINTING_THRESHOLD = 60;
    public static final int DEFAULT_STARTPOINTING_THRESHOLD = 15;
    private Optional mThreshold;

    public DnnVADConfig()
    {
        super(15, 60);
        mThreshold = Optional.absent();
    }

    public DnnVADConfig(Float float1, int i, int j)
    {
        super(i, j);
        mThreshold = Optional.absent();
        mThreshold = Optional.fromNullable(float1);
    }

    public Optional getThreshold()
    {
        return mThreshold;
    }
}
