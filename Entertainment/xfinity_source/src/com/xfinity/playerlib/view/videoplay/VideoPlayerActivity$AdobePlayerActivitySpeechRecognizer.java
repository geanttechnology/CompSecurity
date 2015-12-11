// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.videoplay;

import com.comcast.cim.android.accessibility.SpeechDelegate;
import com.xfinity.playerlib.view.search.SearchActivity;

// Referenced classes of package com.xfinity.playerlib.view.videoplay:
//            VideoPlayerActivity

private class <init> extends com.comcast.cim.android.view.common.
{

    final VideoPlayerActivity this$0;

    public boolean onSpeechResponseSearch(String as[])
    {
        getSpeechDelegate().startSearch(com/xfinity/playerlib/view/search/SearchActivity, as);
        return false;
    }

    private ()
    {
        this$0 = VideoPlayerActivity.this;
        super(VideoPlayerActivity.this);
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
