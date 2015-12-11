// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.platformtools;


// Referenced classes of package com.tencent.mm.sdk.platformtools:
//            Log

public static interface 
{

    public abstract int getLogLevel();

    public abstract void logD(String s, String s1, String s2, int i, int j, long l, 
            long l1, String s3);

    public abstract void logE(String s, String s1, String s2, int i, int j, long l, 
            long l1, String s3);

    public abstract void logI(String s, String s1, String s2, int i, int j, long l, 
            long l1, String s3);
}
