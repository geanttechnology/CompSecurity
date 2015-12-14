// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.d;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cyberlink.you.o;
import com.cyberlink.you.p;
import com.cyberlink.you.widgetpool.common.GifImageView;

// Referenced classes of package com.cyberlink.you.d:
//            d

public class b
{

    public static View a(d d1, LayoutInflater layoutinflater, ViewGroup viewgroup)
    {
        layoutinflater = layoutinflater.inflate(p.u_view_item_recv_text_msg, viewgroup, false);
        a(d1, ((View) (layoutinflater)));
        d1.f = layoutinflater.findViewById(o.TextContentArea);
        d1.e = (TextView)layoutinflater.findViewById(o.ChatMessageContentTextView);
        d1.j = layoutinflater.findViewById(o.ChatMessageContentLayout2);
        return layoutinflater;
    }

    private static void a(d d1, View view)
    {
        d1.b = (ImageView)view.findViewById(o.ChatMessageAvatar);
        d1.a = (TextView)view.findViewById(o.ChatMessageNameTextView);
        d1.h = (TextView)view.findViewById(o.ChatMessageTimeTextView);
        d1.s = view.findViewById(o.itemCheckBox);
    }

    public static View b(d d1, LayoutInflater layoutinflater, ViewGroup viewgroup)
    {
        layoutinflater = layoutinflater.inflate(p.u_view_item_recv_sticker_msg, viewgroup, false);
        a(d1, layoutinflater);
        d1.c = (ImageView)layoutinflater.findViewById(o.ChatMessageContentStickerView);
        d1.j = d1.c;
        d1.k = (TextView)layoutinflater.findViewById(o.ttl);
        d1.i = (ImageView)layoutinflater.findViewById(o.explode);
        return layoutinflater;
    }

    public static View c(d d1, LayoutInflater layoutinflater, ViewGroup viewgroup)
    {
        layoutinflater = layoutinflater.inflate(p.u_view_item_recv_anim_sticker_msg, viewgroup, false);
        a(d1, layoutinflater);
        d1.d = (GifImageView)layoutinflater.findViewById(o.ChatMessageContentGifView);
        d1.j = d1.d;
        d1.k = (TextView)layoutinflater.findViewById(o.ttl);
        d1.i = (ImageView)layoutinflater.findViewById(o.explode);
        return layoutinflater;
    }

    public static View d(d d1, LayoutInflater layoutinflater, ViewGroup viewgroup)
    {
        layoutinflater = layoutinflater.inflate(p.u_view_item_recv_animpng_sticker_msg, viewgroup, false);
        a(d1, layoutinflater);
        d1.c = (ImageView)layoutinflater.findViewById(o.ChatMessageContentStickerView);
        d1.j = d1.c;
        d1.k = (TextView)layoutinflater.findViewById(o.ttl);
        d1.i = (ImageView)layoutinflater.findViewById(o.explode);
        return layoutinflater;
    }

    public static View e(d d1, LayoutInflater layoutinflater, ViewGroup viewgroup)
    {
        layoutinflater = layoutinflater.inflate(p.u_view_item_recv_need_update_msg, viewgroup, false);
        d1.e = (TextView)layoutinflater.findViewById(o.ChatMessageContentTextView);
        d1.h = (TextView)layoutinflater.findViewById(o.ChatMessageTimeTextView);
        return layoutinflater;
    }

    public static View f(d d1, LayoutInflater layoutinflater, ViewGroup viewgroup)
    {
        layoutinflater = layoutinflater.inflate(p.u_view_item_recv_bc_post, viewgroup, false);
        a(d1, layoutinflater);
        d1.p = (RelativeLayout)layoutinflater.findViewById(o.contentLayout);
        d1.h = (TextView)layoutinflater.findViewById(o.ChatMessageTimeTextView);
        d1.e = (TextView)layoutinflater.findViewById(o.content);
        d1.t = (ImageView)layoutinflater.findViewById(o.cover);
        d1.u = (TextView)layoutinflater.findViewById(o.likeCnt);
        d1.v = (TextView)layoutinflater.findViewById(o.commentCnt);
        d1.w = (TextView)layoutinflater.findViewById(o.circleCnt);
        d1.x = (ImageView)layoutinflater.findViewById(o.creatorAvatar);
        d1.y = (TextView)layoutinflater.findViewById(o.creatorName);
        d1.z = (TextView)layoutinflater.findViewById(o.postCircle);
        return layoutinflater;
    }
}
