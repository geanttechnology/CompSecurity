// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import android.os.Debug;

// Referenced classes of package a.a:
//            bd

public final class bt
    implements bd
{

    private Integer a;

    public bt()
    {
        a = null;
        android.os.Debug.MemoryInfo memoryinfo = new android.os.Debug.MemoryInfo();
        Debug.getMemoryInfo(memoryinfo);
        int i = memoryinfo.dalvikPss;
        int j = memoryinfo.nativePss;
        a = Integer.valueOf((memoryinfo.otherPss + (i + j)) * 1024);
    }

    public final String a()
    {
        return "memory_usage";
    }

    public final volatile Object b()
    {
        return a;
    }
}
