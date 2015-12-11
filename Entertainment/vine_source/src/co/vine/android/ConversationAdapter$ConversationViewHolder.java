// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import co.vine.android.api.VinePrivateMessage;
import co.vine.android.drawable.ColoredOvalDrawable;
import co.vine.android.player.OnListVideoClickListener;
import co.vine.android.player.SdkVideoView;
import co.vine.android.util.image.ImageKey;

// Referenced classes of package co.vine.android:
//            ConversationAdapter

public static class timestamp
{

    public ImageKey avatarKey;
    public final View bottomPaddingView;
    public int color;
    public final TextView errorMessage;
    public boolean hasVideoImage;
    public boolean isCurrentUser;
    public boolean isSharedPost;
    public boolean isVideoImageLoaded;
    public final View loadImage;
    public VinePrivateMessage message;
    public final ViewGroup messageContainer;
    public final TextView messageContainerMessage;
    public final ImageView messageContainerUserImage;
    public final View nibs;
    public final View nibsChatNib;
    public int position;
    public final ViewGroup postMessageContainer;
    public final TextView postMessageContainerMessage;
    public View postNibs;
    public final View secondaryMessageContainer;
    public final TextView secondaryMessageContainerMessage;
    public ColoredOvalDrawable timerOval;
    public final TextView timestamp;
    public final ViewGroup topMessageContainer;
    public final TextView topMessageContainerMessage;
    public final ImageView topMessageContainerUserImage;
    public View userImageProgressNormal;
    public View userImageProgressTop;
    public final View vanishMessageContainer;
    public final TextView vanishMessageOverlay;
    public final View vanishPlayButton;
    public r vanishPlayButtonListener;
    public final View vanishThumbnailOverlay;
    public final TextView vanishTimerText;
    public final ImageView vanishUserImage;
    public final View videoContainer;
    public final ImageView videoImage;
    public ImageKey videoImageKey;
    public OnListVideoClickListener videoListener;
    public SdkVideoView videoView;

    public r(View view)
    {
        messageContainer = (ViewGroup)view.findViewById(0x7f0a0135);
        messageContainerUserImage = (ImageView)view.findViewById(0x7f0a0136);
        messageContainerMessage = (TextView)view.findViewById(0x7f0a0138);
        topMessageContainer = (ViewGroup)view.findViewById(0x7f0a0141);
        topMessageContainerUserImage = (ImageView)view.findViewById(0x7f0a0142);
        topMessageContainerMessage = (TextView)view.findViewById(0x7f0a0144);
        vanishThumbnailOverlay = view.findViewById(0x7f0a012c);
        vanishMessageOverlay = (TextView)view.findViewById(0x7f0a00b1);
        vanishMessageContainer = view.findViewById(0x7f0a012d);
        vanishUserImage = (ImageView)view.findViewById(0x7f0a012e);
        vanishPlayButton = view.findViewById(0x7f0a012f);
        vanishTimerText = (TextView)view.findViewById(0x7f0a0134);
        postMessageContainer = (ViewGroup)view.findViewById(0x7f0a0139);
        postMessageContainerMessage = (TextView)view.findViewById(0x7f0a013a);
        userImageProgressNormal = view.findViewById(0x7f0a013e);
        userImageProgressTop = view.findViewById(0x7f0a0143);
        secondaryMessageContainer = view.findViewById(0x7f0a013b);
        secondaryMessageContainerMessage = (TextView)view.findViewById(0x7f0a013c);
        videoContainer = view.findViewById(0x7f0a012a);
        videoImage = (ImageView)view.findViewById(0x7f0a012b);
        videoView = (SdkVideoView)view.findViewById(0x7f0a0130);
        loadImage = view.findViewById(0x7f0a0074);
        errorMessage = (TextView)view.findViewById(0x7f0a013f);
        bottomPaddingView = view.findViewById(0x7f0a013d);
        nibs = view.findViewById(0x7f0a0131);
        postNibs = view.findViewById(0x7f0a0132);
        nibsChatNib = view.findViewById(0x7f0a0137);
        timestamp = (TextView)view.findViewById(0x7f0a0140);
    }
}
