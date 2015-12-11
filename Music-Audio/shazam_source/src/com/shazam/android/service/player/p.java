// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.service.player;

import com.shazam.model.player.PlaybackProvider;
import com.shazam.model.player.PlaylistItem;
import com.shazam.model.preview.PlayerState;

public interface p
{

    public abstract PlayerState a(PlaylistItem playlistitem, int i);

    public abstract void a(int i);

    public abstract boolean a(PlaylistItem playlistitem);

    public abstract void b();

    public abstract void c();

    public abstract int d();

    public abstract int e();

    public abstract PlaybackProvider f();

    public abstract PlaylistItem g();

    public abstract String h();

    public abstract void k();
}
