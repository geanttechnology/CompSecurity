// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import com.comcast.cim.android.accessibility.AlternateInterfaceListener;
import com.comcast.cim.android.accessibility.DefaultSpeechListener;
import com.comcast.cim.android.accessibility.TalkDelegate;
import com.xfinity.playerlib.alt.PlayerEpisodeListTalkListHelper;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            SeriesEpisodeListFragment

protected class this._cls0 extends DefaultSpeechListener
{

    final SeriesEpisodeListFragment this$0;

    public boolean onSpeechResponseLess()
    {
        SeriesEpisodeListFragment.access$500(SeriesEpisodeListFragment.this).getTalkDelegate().speak(SeriesEpisodeListFragment.access$1800(SeriesEpisodeListFragment.this).getLessResults());
        return true;
    }

    public boolean onSpeechResponseMore()
    {
        SeriesEpisodeListFragment.access$500(SeriesEpisodeListFragment.this).getTalkDelegate().speak(SeriesEpisodeListFragment.access$1900(SeriesEpisodeListFragment.this, getActivity()).getMoreResults());
        return true;
    }

    public boolean onSpeechResponseOpen(String as[])
    {
        SeriesEpisodeListFragment.access$2002(SeriesEpisodeListFragment.this, true);
        return true;
    }

    public boolean onSpeechResponsePlay(String as[])
    {
        SeriesEpisodeListFragment.access$2002(SeriesEpisodeListFragment.this, true);
        return true;
    }

    public boolean onSpeechResponseRepeat()
    {
        SeriesEpisodeListFragment.access$500(SeriesEpisodeListFragment.this).getTalkDelegate().speak(SeriesEpisodeListFragment.access$1900(SeriesEpisodeListFragment.this, getActivity()).speakResults());
        return true;
    }

    protected i()
    {
        this$0 = SeriesEpisodeListFragment.this;
        super();
    }
}
