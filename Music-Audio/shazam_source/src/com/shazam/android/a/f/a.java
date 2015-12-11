// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.a.f;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.shazam.android.widget.image.d;
import com.shazam.android.widget.player.PlayerItemCoverArtImageView;
import com.shazam.model.player.PlaylistItem;
import java.util.ArrayList;
import java.util.List;

public final class a extends at.technikum.mti.fancycoverflow.a
{

    public final List a = new ArrayList();

    public a()
    {
    }

    public final View a(int i, View view, ViewGroup viewgroup)
    {
        if (view == null)
        {
            view = LayoutInflater.from(viewgroup.getContext()).inflate(0x7f0300a8, viewgroup, false);
        }
        if (view instanceof PlayerItemCoverArtImageView)
        {
            viewgroup = (PlayerItemCoverArtImageView)view;
            PlaylistItem playlistitem = a(i);
            viewgroup.a(playlistitem.status, 1.0F);
            viewgroup.setForceInvalidateWhenOffset(true);
            viewgroup = viewgroup.a(playlistitem.coverArtUrl);
            viewgroup.f = d.b;
            viewgroup.e = 0x7f0201ac;
            viewgroup.g = 0x7f0201ac;
            viewgroup.j = true;
            viewgroup.c();
        }
        return view;
    }

    public final PlaylistItem a(int i)
    {
        return (PlaylistItem)a.get(i);
    }

    public final int getCount()
    {
        return a.size();
    }

    public final Object getItem(int i)
    {
        return a(i);
    }

    public final long getItemId(int i)
    {
        return (long)i;
    }
}
