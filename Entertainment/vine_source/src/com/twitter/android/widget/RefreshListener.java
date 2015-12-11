// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.android.widget;


// Referenced classes of package com.twitter.android.widget:
//            ItemPosition

public interface RefreshListener
{

    public abstract ItemPosition getFirstItemPosition();

    public abstract int getPositionForItemId(long l);

    public abstract void onRefreshCancelled();

    public abstract void onRefreshFinished();

    public abstract void onRefreshFinishedNewData();

    public abstract void onRefreshFinishedNoChange();

    public abstract void onRefreshPulled();

    public abstract void onRefreshReleased(boolean flag);
}
