// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import co.vine.android.util.image.ImageKey;

public class ActivityViewHolder
{

    public static final int TYPE_COMMENT_LIST = 3;
    public static final int TYPE_POST = 1;
    public static final int TYPE_USER = 0;
    public static final int TYPE_USER_LIST = 2;
    public long anchor;
    public ImageView avatar;
    public ImageKey avatarImageKey;
    public boolean clickable;
    public TextView contentLine;
    public TextView dateLine;
    public View divider;
    public View followButton;
    public TextView headerText;
    public View headerView;
    public int listItemClickType;
    public ImageView milestoneBackground;
    public ImageKey milestoneBackgroundImageKey;
    public TextView milestoneDescription;
    public ImageView milestoneIcon;
    public ImageKey milestoneIconImageKey;
    public ImageView milestoneImage;
    public ImageView milestoneImageFrame;
    public ImageKey milestoneImageImageKey;
    public View milestoneOverlay;
    public TextView milestoneTitle;
    public long notificationId;
    public long postId;
    public ImageView thumbnail;
    public ImageKey thumbnailImageKey;
    public ImageView typeIcon;
    public long userId;

    public ActivityViewHolder(View view)
    {
        clickable = true;
        typeIcon = (ImageView)view.findViewById(0x7f0a0064);
        avatar = (ImageView)view.findViewById(0x7f0a0063);
        thumbnail = (ImageView)view.findViewById(0x7f0a0065);
        followButton = view.findViewById(0x7f0a0066);
        contentLine = (TextView)view.findViewById(0x7f0a005e);
        dateLine = (TextView)view.findViewById(0x7f0a0067);
        milestoneBackground = (ImageView)view.findViewById(0x7f0a006a);
        milestoneOverlay = view.findViewById(0x7f0a006b);
        milestoneImage = (ImageView)view.findViewById(0x7f0a006c);
        milestoneImageFrame = (ImageView)view.findViewById(0x7f0a006d);
        milestoneIcon = (ImageView)view.findViewById(0x7f0a006e);
        milestoneTitle = (TextView)view.findViewById(0x7f0a006f);
        milestoneDescription = (TextView)view.findViewById(0x7f0a0070);
        headerView = view.findViewById(0x7f0a005b);
        headerText = (TextView)view.findViewById(0x7f0a005c);
        divider = view.findViewById(0x7f0a0060);
    }
}
