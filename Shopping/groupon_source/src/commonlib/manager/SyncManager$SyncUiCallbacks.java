// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package commonlib.manager;


// Referenced classes of package commonlib.manager:
//            SyncManager

public static interface 
{

    public abstract void enableSyncProgressIndicator(boolean flag);

    public abstract void handleSyncError(Runnable runnable, Exception exception);
}
