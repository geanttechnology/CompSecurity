// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.interfaces;

import java.util.List;

public interface SearchCallback
{

    public abstract void onSearchAlbumFinish(List list);

    public abstract void onSearchArtistFinish(List list);

    public abstract void onSearchFailed(int i, String s);

    public abstract void onSearchSongFinish(List list);

    public abstract void onSearching();
}
