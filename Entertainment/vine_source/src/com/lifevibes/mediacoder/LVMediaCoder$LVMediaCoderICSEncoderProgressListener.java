// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.lifevibes.mediacoder;

import java.nio.ByteBuffer;

// Referenced classes of package com.lifevibes.mediacoder:
//            LVMediaCoder

public static interface 
{

    public abstract void onComplete();

    public abstract void onError(Exception exception, int i);

    public abstract void onFrameAvailable(ByteBuffer bytebuffer);
}
