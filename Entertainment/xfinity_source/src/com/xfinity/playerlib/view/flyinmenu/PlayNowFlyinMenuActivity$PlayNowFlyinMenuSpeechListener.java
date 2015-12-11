// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.flyinmenu;

import com.comcast.cim.android.accessibility.SpeechDelegate;
import com.xfinity.playerlib.view.search.SearchActivity;

// Referenced classes of package com.xfinity.playerlib.view.flyinmenu:
//            PlayNowFlyinMenuActivity

protected class this._cls0 extends com.comcast.cim.android.view.common.
{

    final PlayNowFlyinMenuActivity this$0;

    public boolean onSpeechResponseSearch(String as[])
    {
        getSpeechDelegate().startSearch(com/xfinity/playerlib/view/search/SearchActivity, as);
        return false;
    }

    protected ()
    {
        this$0 = PlayNowFlyinMenuActivity.this;
        super(PlayNowFlyinMenuActivity.this);
    }
}
