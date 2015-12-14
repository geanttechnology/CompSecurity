// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import org.json.JSONArray;

// Referenced classes of package com.millennialmedia.android:
//            NVASpeechKit, MMWebView

class a
    implements stener
{

    private NVASpeechKit a;

    public void onAudioLevelUpdate(double d)
    {
        MMWebView mmwebview = a.a();
        if (mmwebview != null)
        {
            mmwebview.loadUrl((new StringBuilder("javascript:MMJS.sdk.audioLevelChange(")).append(d).append(")").toString());
        }
    }

    public void onAudioSampleUpdate(double d)
    {
        MMWebView mmwebview = a.a();
        if (mmwebview != null)
        {
            mmwebview.loadUrl((new StringBuilder("javascript:MMJS.sdk.backgroundAudioLevel(")).append(d).append(")").toString());
        }
    }

    public void onCustomWordsAdded()
    {
    }

    public void onCustomWordsDeleted()
    {
    }

    public void onError()
    {
    }

    public void onResults()
    {
        Object obj1 = NVASpeechKit.a(a.getResults());
        Object obj = a;
        obj1 = ((JSONArray) (obj1)).toString();
        obj = ((NVASpeechKit) (obj)).a();
        if (obj != null)
        {
            ((MMWebView) (obj)).loadUrl((new StringBuilder("javascript:MMJS.sdk.recognitionResult(")).append(((String) (obj1))).append(")").toString());
        }
    }

    public void onStateChange(ate ate)
    {
        a[ate.ordinal()];
        JVM INSTR tableswitch 1 5: default 44
    //                   1 45
    //                   2 64
    //                   3 83
    //                   4 102
    //                   5 121;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        return;
_L2:
        if ((ate = a.a()) != null)
        {
            ate.loadUrl("javascript:MMJS.sdk.voiceStateChange('error')");
            return;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        ate = a.a();
        if (ate != null)
        {
            ate.loadUrl("javascript:MMJS.sdk.voiceStateChange('processing')");
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
        ate = a.a();
        if (ate != null)
        {
            ate.loadUrl("javascript:MMJS.sdk.voiceStateChange('ready')");
            return;
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L5:
        ate = a.a();
        if (ate != null)
        {
            ate.loadUrl("javascript:MMJS.sdk.voiceStateChange('recording')");
            return;
        }
        if (true) goto _L1; else goto _L6
_L6:
        ate = a.a();
        if (ate != null)
        {
            ate.loadUrl("javascript:MMJS.sdk.voiceStateChange('vocalizing')");
            return;
        }
        if (true) goto _L1; else goto _L7
_L7:
    }

    ate(NVASpeechKit nvaspeechkit)
    {
        a = nvaspeechkit;
        super();
    }
}
