// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import co.vine.android.player.SdkVideoView;
import co.vine.android.recorder.ProgressView;

// Referenced classes of package co.vine.android:
//            DraftFragment

public static class draftContainer
{

    public ViewGroup containerView;
    public RelativeLayout draftContainer;
    public ProgressView progressView;
    public ImageView thumb;
    public String videoUrl;
    public SdkVideoView videoView;

    public (View view, String s)
    {
        videoView = (SdkVideoView)view.findViewById(0x7f0a0075);
        videoUrl = s;
        containerView = (ViewGroup)view.findViewById(0x7f0a00d6);
        progressView = (ProgressView)view.findViewById(0x7f0a00b2);
        thumb = (ImageView)view.findViewById(0x7f0a00d8);
        draftContainer = (RelativeLayout)view.findViewById(0x7f0a00d5);
    }
}
