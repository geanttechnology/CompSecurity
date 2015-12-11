// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import co.vine.android.util.image.ImageKey;

public class UserViewHolder
{

    public ImageKey avatarUrl;
    public TextView bio;
    public ImageButton followButton;
    public ImageView image;
    public TextView location;
    public long userId;
    public TextView username;
    public ImageView verified;

    public UserViewHolder(View view)
    {
        username = (TextView)view.findViewById(0x7f0a00c4);
        bio = (TextView)view.findViewById(0x7f0a0230);
        location = (TextView)view.findViewById(0x7f0a0231);
        followButton = (ImageButton)view.findViewById(0x7f0a022d);
        image = (ImageView)view.findViewById(0x7f0a0063);
        verified = (ImageView)view.findViewById(0x7f0a022f);
    }
}
