// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.search;

import android.content.Context;
import android.os.Handler;
import android.widget.EditText;
import com.comcast.cim.android.accessibility.AlternateInterfaceListener;
import com.comcast.cim.android.accessibility.DefaultSpeechListener;
import com.comcast.cim.android.accessibility.TalkDelegate;
import com.xfinity.playerlib.alt.PlayerSearchTalkListHelper;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.xfinity.playerlib.view.search:
//            SearchResultsFragment

private class <init> extends DefaultSpeechListener
{

    final SearchResultsFragment this$0;

    public boolean onSpeechResponseClear()
    {
        SearchResultsFragment.access$2800(SearchResultsFragment.this).getTalkDelegate().speak(SearchResultsFragment.access$2000(SearchResultsFragment.this).getContext().getString(com.xfinity.playerlib.echListener.this._fld0));
        SearchResultsFragment.access$2602(SearchResultsFragment.this, new PlayerSearchTalkListHelper(getActivity()));
        clearSearchQuery();
        SearchResultsFragment.access$1600(SearchResultsFragment.this).postDelayed(new this._cls0(SearchResultsFragment.this, ""), 200L);
        return true;
    }

    public boolean onSpeechResponseLess()
    {
        SearchResultsFragment.access$2800(SearchResultsFragment.this).getTalkDelegate().speak(SearchResultsFragment.access$2600(SearchResultsFragment.this).getLessResults());
        return true;
    }

    public boolean onSpeechResponseMore()
    {
        SearchResultsFragment.access$2800(SearchResultsFragment.this).getTalkDelegate().speak(SearchResultsFragment.access$2600(SearchResultsFragment.this).getMoreResults());
        return true;
    }

    public boolean onSpeechResponseRepeat()
    {
        SearchResultsFragment.access$2800(SearchResultsFragment.this).getTalkDelegate().speak(SearchResultsFragment.access$2600(SearchResultsFragment.this).speakResults());
        return true;
    }

    public boolean onSpeechResponseSearch(String as[])
    {
        if (as == null || as.length == 0)
        {
            SearchResultsFragment.access$2800(SearchResultsFragment.this).getTalkDelegate().speak(com.xfinity.playerlib.);
            SearchResultsFragment.access$2902(SearchResultsFragment.this, false);
            return false;
        } else
        {
            as = StringUtils.join(as, " ");
            SearchResultsFragment.access$1600(SearchResultsFragment.this).postDelayed(new this._cls0(SearchResultsFragment.this, as), 200L);
            return false;
        }
    }

    private a()
    {
        this$0 = SearchResultsFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
