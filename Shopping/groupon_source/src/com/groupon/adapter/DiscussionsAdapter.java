// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.groupon.models.Post;
import com.groupon.util.IntlDateFormat;
import com.groupon.view.Transformation.RoundedCropTransformation;
import com.groupon.view.UrlImageView;
import java.util.ArrayList;

public class DiscussionsAdapter extends ArrayAdapter
{
    private static class PostViewHolder
    {

        public TextView body;
        public TextView createdAt;
        public UrlImageView posterIcon;
        public TextView posterName;

        private PostViewHolder()
        {
        }

    }


    private Drawable avatarPlaceholder;
    private final LayoutInflater inflater;
    private final IntlDateFormat intlDateFormat;

    public DiscussionsAdapter(Context context, IntlDateFormat intldateformat)
    {
        super(context, 0x7f0300d3, new ArrayList());
        inflater = LayoutInflater.from(context);
        avatarPlaceholder = context.getResources().getDrawable(0x7f02008c);
        intlDateFormat = intldateformat;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        Post post;
        if (view == null)
        {
            view = inflater.inflate(0x7f0300d3, viewgroup, false);
            viewgroup = new PostViewHolder();
            viewgroup.posterName = (TextView)view.findViewById(0x7f100278);
            viewgroup.posterIcon = (UrlImageView)view.findViewById(0x7f100277);
            viewgroup.createdAt = (TextView)view.findViewById(0x7f100279);
            viewgroup.body = (TextView)view.findViewById(0x7f10027a);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (PostViewHolder)view.getTag();
        }
        post = (Post)getItem(i);
        ((PostViewHolder) (viewgroup)).posterName.setText(post.posterName);
        ((PostViewHolder) (viewgroup)).posterIcon.setImageUrl(post.posterAvatar, new RoundedCropTransformation(), avatarPlaceholder);
        ((PostViewHolder) (viewgroup)).createdAt.setText(intlDateFormat.format(post.createdAt));
        ((PostViewHolder) (viewgroup)).body.setText(post.body);
        return view;
    }

    public boolean isEnabled(int i)
    {
        return false;
    }
}
