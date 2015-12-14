// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.util;


// Referenced classes of package com.socialin.android.util:
//            ModernAsyncTask

public abstract class an extends ModernAsyncTask
{

    public an()
    {
    }

    public final transient void a(Object aobj[])
    {
        executeOnExecutor(ModernAsyncTask.THREAD_POOL_EXECUTOR, aobj);
    }
}
