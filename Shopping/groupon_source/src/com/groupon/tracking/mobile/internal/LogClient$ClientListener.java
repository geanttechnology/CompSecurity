// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.tracking.mobile.internal;

import java.io.IOException;

// Referenced classes of package com.groupon.tracking.mobile.internal:
//            LogClient, ByteCountedOutputStream

public static interface 
{

    public abstract int getNextPackageNumber();

    public abstract void onLogCreate(long l, String s, ByteCountedOutputStream bytecountedoutputstream)
        throws IOException;
}
