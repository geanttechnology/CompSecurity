// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import android.widget.LinearLayout;
import com.comcast.cim.android.accessibility.DefaultSpeechListener;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            EpisodeDetailFragment

private class <init> extends DefaultSpeechListener
{

    final EpisodeDetailFragment this$0;

    public boolean onSpeechResponsePlay(String as[])
    {
        as = getFirstPlayButton();
        if (as != null)
        {
            as.callOnClick();
        }
        return true;
    }

    private i()
    {
        this$0 = EpisodeDetailFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
