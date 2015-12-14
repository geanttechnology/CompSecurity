// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.github.rahatarmanahmed.cpv;


public interface CircularProgressViewListener
{

    public abstract void onAnimationReset();

    public abstract void onModeChanged(boolean flag);

    public abstract void onProgressUpdate(float f);

    public abstract void onProgressUpdateEnd(float f);
}
