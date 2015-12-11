// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import co.vine.android.api.VinePost;
import co.vine.android.player.SensitiveImageClickListener;
import co.vine.android.util.LoopManager;
import co.vine.android.util.image.ImageKey;

// Referenced classes of package co.vine.android.widget:
//            ColorizedCircleButton, CounterView, Typefaces

public abstract class GenericFeedViewHolder
{

    public ImageKey avatarKey;
    public ColorizedCircleButton comment;
    public LinearLayout commentList;
    public int commentType;
    public TextView comments1;
    public TextView comments2;
    public TextView comments3;
    public TextView compactLikesCommentsRevinesCounts;
    public View counterPlus;
    public CounterView counterView;
    public TextView description;
    public View divider;
    public boolean hasVideoImage;
    public SensitiveImageClickListener imageListener;
    public boolean isVideoImageLoaded;
    public ColorizedCircleButton liked;
    public TextView location;
    public ViewGroup loopsContainer;
    public Button loopsHintButton;
    public TextView loopsLabel;
    public ImageView more;
    public View onFireView;
    public int position;
    public VinePost post;
    public View postCommentsDivider;
    public TextView revineLine;
    public LinearLayout sensitiveTextContainer;
    public ColorizedCircleButton share;
    public TextView timestamp;
    public ImageView userImage;
    public TextView username;
    public ImageKey videoImageKey;
    public ProgressBar videoLoadImage;
    public TextView viewAllComments;

    public GenericFeedViewHolder(View view)
    {
        description = (TextView)view.findViewById(0x7f0a0128);
        username = (TextView)view.findViewById(0x7f0a00c4);
        location = (TextView)view.findViewById(0x7f0a019e);
        timestamp = (TextView)view.findViewById(0x7f0a007b);
        userImage = (ImageView)view.findViewById(0x7f0a0063);
        commentList = (LinearLayout)view.findViewById(0x7f0a015d);
        videoLoadImage = (ProgressBar)view.findViewById(0x7f0a0074);
        sensitiveTextContainer = (LinearLayout)view.findViewById(0x7f0a015a);
        liked = (ColorizedCircleButton)view.findViewById(0x7f0a014f);
        share = (ColorizedCircleButton)view.findViewById(0x7f0a0151);
        comment = (ColorizedCircleButton)view.findViewById(0x7f0a0150);
        more = (ImageView)view.findViewById(0x7f0a014d);
        comments1 = (TextView)view.findViewById(0x7f0a0160);
        comments2 = (TextView)view.findViewById(0x7f0a0161);
        comments3 = (TextView)view.findViewById(0x7f0a0162);
        compactLikesCommentsRevinesCounts = (TextView)view.findViewById(0x7f0a0159);
        revineLine = (TextView)view.findViewById(0x7f0a015b);
        loopsLabel = (TextView)view.findViewById(0x7f0a0157);
        loopsHintButton = (Button)view.findViewById(0x7f0a0158);
        loopsContainer = (ViewGroup)view.findViewById(0x7f0a0153);
        counterView = (CounterView)view.findViewById(0x7f0a0155);
        counterView.setMinAnimationSeparation(500L);
        counterView.setMaxAnimationSeparation(3000L);
        counterView.setTypeFace(Typefaces.get(view.getContext()).getContentTypeface(0, 2));
        counterView.setTextSize(view.getContext().getResources().getDimensionPixelSize(0x7f0b004a));
        onFireView = view.findViewById(0x7f0a0154);
        divider = view.findViewById(0x7f0a015c);
        counterPlus = view.findViewById(0x7f0a0156);
        postCommentsDivider = view.findViewById(0x7f0a015e);
        viewAllComments = (TextView)view.findViewById(0x7f0a015f);
    }

    public abstract View getViewForVideoImage();

    public void updateCount(VinePost vinepost)
    {
        boolean flag = false;
        counterView.adjustExtraCount(LoopManager.getLocalLoopCount(vinepost.postId));
        counterView.setKnownCount(vinepost.loops, vinepost.velocity / 1000D, vinepost.lastRefresh);
        View view = onFireView;
        int i;
        if (vinepost.onFire)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
        view = counterPlus;
        if (vinepost.created < 0x1458afc9808L)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
    }
}
