// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.flyinmenu;

import android.view.View;
import com.comcast.cim.android.accessibility.AccessibilityUtil;
import com.comcast.cim.android.accessibility.SpeechDelegate;
import com.comcast.cim.android.accessibility.TalkDelegate;
import com.xfinity.playerlib.alt.speechrecognizers.PlayerSpeechRecognizer;

// Referenced classes of package com.xfinity.playerlib.view.flyinmenu:
//            PlayNowFlyinMenuActivity

class this._cls0
    implements android.view.yNowFlyinMenuActivity._cls3
{

    final PlayNowFlyinMenuActivity this$0;

    public void onClick(View view)
    {
        PlayNowFlyinMenuActivity.access$100(PlayNowFlyinMenuActivity.this).setImportantForAccessibility(PlayNowFlyinMenuActivity.access$000(PlayNowFlyinMenuActivity.this), 2);
        getTalkDelegate().stopSpeaking();
        getSpeechDelegate().getSpeechInput(com/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer);
    }

    er()
    {
        this$0 = PlayNowFlyinMenuActivity.this;
        super();
    }
}
