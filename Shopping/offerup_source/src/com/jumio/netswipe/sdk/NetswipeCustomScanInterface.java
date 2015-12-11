// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.netswipe.sdk;

import java.util.ArrayList;

// Referenced classes of package com.jumio.netswipe.sdk:
//            NetswipeCardInformation

public interface NetswipeCustomScanInterface
{

    public abstract void onNetswipeCameraAvailable();

    public abstract void onNetswipeError(int i, String s, boolean flag, ArrayList arraylist);

    public abstract void onNetswipeExtractionFinished(NetswipeCardInformation netswipecardinformation, ArrayList arraylist);

    public abstract void onNetswipeExtractionStarted();
}
