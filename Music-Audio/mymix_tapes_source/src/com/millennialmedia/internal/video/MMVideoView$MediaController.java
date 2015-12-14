// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.video;


// Referenced classes of package com.millennialmedia.internal.video:
//            MMVideoView

public static interface 
{

    public abstract void onComplete();

    public abstract void onMuted();

    public abstract void onPause();

    public abstract void onProgress(int i);

    public abstract void onStart();

    public abstract void onUnmuted();

    public abstract void setDuration(int i);
}
