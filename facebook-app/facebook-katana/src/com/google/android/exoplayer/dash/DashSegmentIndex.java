// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.dash;

import com.google.android.exoplayer.dash.mpd.RangedUri;

public interface DashSegmentIndex
{

    public abstract int a();

    public abstract int a(long l);

    public abstract long a(int i);

    public abstract int b();

    public abstract long b(int i);

    public abstract RangedUri c(int i);

    public abstract boolean c();
}
