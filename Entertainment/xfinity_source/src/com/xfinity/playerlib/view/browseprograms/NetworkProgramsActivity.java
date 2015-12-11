// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browseprograms;

import android.content.Intent;
import android.os.Bundle;
import com.comcast.cim.android.accessibility.SpeechDelegate;
import com.comcast.cim.android.accessibility.TalkDelegate;
import com.comcast.cim.android.view.flow.FilterRequestObserver;
import com.xfinity.playerlib.alt.speechrecognizers.NetworkProgramsSpeechRecognizer;
import com.xfinity.playerlib.view.networkcollections.NetworkActivity;

// Referenced classes of package com.xfinity.playerlib.view.browseprograms:
//            NetworkProgramsFilterDialog

public class NetworkProgramsActivity extends NetworkActivity
    implements FilterRequestObserver
{

    public NetworkProgramsActivity()
    {
    }

    protected int getLayoutId()
    {
        return com.xfinity.playerlib.R.layout.flyin_network_programs;
    }

    protected Class getSpeechRecognizerClass()
    {
        return com/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;
    }

    public void onSpeechSwipe()
    {
        Intent intent = getIntent();
        Bundle bundle = new Bundle();
        if (intent != null)
        {
            bundle = intent.getExtras();
        }
        getTalkDelegate().stopSpeaking();
        getSpeechDelegate().getSpeechInput(getSpeechRecognizerClass(), bundle);
    }

    public void showFilter(Bundle bundle)
    {
        Intent intent = new Intent(this, com/xfinity/playerlib/view/browseprograms/NetworkProgramsFilterDialog);
        intent.putExtras(bundle);
        startActivityForResult(intent, 0);
    }
}
