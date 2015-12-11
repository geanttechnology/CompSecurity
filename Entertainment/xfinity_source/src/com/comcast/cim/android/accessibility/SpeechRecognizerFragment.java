// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.accessibility;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

// Referenced classes of package com.comcast.cim.android.accessibility:
//            SpeechRecognizer

public class SpeechRecognizerFragment extends Fragment
{

    private static boolean TALKBACKMODE_ON = true;
    private TextView caption;
    private SpeechRecognizer speechRecognizer;

    public SpeechRecognizerFragment()
    {
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        speechRecognizer = (SpeechRecognizer)getActivity();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        bundle = speechRecognizer.getIntent().getExtras().getString("android.speech.extra.PROMPT");
        layoutinflater = (ViewGroup)layoutinflater.inflate(com.comcast.cim.android.R.layout.speech_recognizer, viewgroup, false);
        caption = (TextView)layoutinflater.findViewById(com.comcast.cim.android.R.id.caption);
        caption.setText(bundle);
        return layoutinflater;
    }

    public void onStart()
    {
        super.onStart();
        if (TALKBACKMODE_ON)
        {
            speechRecognizer.talk();
            return;
        } else
        {
            speechRecognizer.listen();
            return;
        }
    }

}
