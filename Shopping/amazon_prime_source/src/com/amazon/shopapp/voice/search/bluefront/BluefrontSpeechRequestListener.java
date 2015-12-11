// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.shopapp.voice.search.bluefront;

import android.os.Bundle;
import android.util.Log;
import com.amazon.blueshift.bluefront.android.SpeechClientException;
import com.amazon.blueshift.bluefront.android.SpeechRequestListener;
import com.amazon.dee.result.bif.BIF;
import com.amazon.shopapp.voice.module.VoiceContext;
import com.amazon.shopapp.voice.search.VoiceResult;
import com.amazon.shopapp.voice.search.VoiceSearchController;
import java.lang.ref.WeakReference;

// Referenced classes of package com.amazon.shopapp.voice.search.bluefront:
//            SpeechRequestHandler

public class BluefrontSpeechRequestListener
    implements SpeechRequestListener
{

    private static final String INCORRECT_TIME_EXCEPTION_TYPE = "RequestExpiredException";
    private static final String TAG = com/amazon/shopapp/voice/search/bluefront/BluefrontSpeechRequestListener.getSimpleName();
    private final WeakReference mControllerRef;
    private final String mRequestId;

    public BluefrontSpeechRequestListener(String s, VoiceSearchController voicesearchcontroller)
    {
        mRequestId = s;
        mControllerRef = new WeakReference(voicesearchcontroller);
    }

    public void onBeginningOfSpeech()
    {
        VoiceSearchController voicesearchcontroller;
        try
        {
            voicesearchcontroller = (VoiceSearchController)mControllerRef.get();
        }
        catch (Exception exception)
        {
            Log.e(TAG, "Error", exception);
            return;
        }
        if (voicesearchcontroller == null)
        {
            break MISSING_BLOCK_LABEL_19;
        }
        voicesearchcontroller.onSpeechHeard();
    }

    public void onBluefrontResults(BIF bif)
    {
        VoiceSearchController voicesearchcontroller;
        try
        {
            if (!VoiceContext.isDebug())
            {
                break MISSING_BLOCK_LABEL_94;
            }
            Log.d(TAG, (new StringBuilder()).append("Bluefront result: ").append(bif).toString());
        }
        // Misplaced declaration of an exception variable
        catch (BIF bif)
        {
            Log.e(TAG, "Error", bif);
            return;
        }
        if (bif == null)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        Log.d(TAG, (new StringBuilder()).append("Utterance ID: ").append(bif.getUtteranceId()).toString());
        Log.d(TAG, (new StringBuilder()).append("Interpretations: ").append(bif.getInterpretations()).toString());
        voicesearchcontroller = (VoiceSearchController)mControllerRef.get();
        if (voicesearchcontroller == null)
        {
            break MISSING_BLOCK_LABEL_125;
        }
        voicesearchcontroller.onResult(new VoiceResult(mRequestId, bif));
    }

    public volatile void onBluefrontResults(Object obj)
    {
        onBluefrontResults((BIF)obj);
    }

    public void onBufferReceived(byte abyte0[])
    {
        try
        {
            if (VoiceContext.isDebug())
            {
                Log.v(TAG, (new StringBuilder()).append("Received ").append(abyte0.length).append(" bytes of audio.").toString());
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            Log.e(TAG, "Error", abyte0);
        }
    }

    public void onEndOfSpeech()
    {
        VoiceSearchController voicesearchcontroller;
        try
        {
            voicesearchcontroller = (VoiceSearchController)mControllerRef.get();
        }
        catch (Exception exception)
        {
            Log.e(TAG, "Error", exception);
            return;
        }
        if (voicesearchcontroller == null)
        {
            break MISSING_BLOCK_LABEL_19;
        }
        voicesearchcontroller.onStopListening();
    }

    public void onError(int i)
    {
    }

    public void onError(SpeechClientException speechclientexception)
    {
        VoiceSearchController voicesearchcontroller;
        Log.e(TAG, "Bluefront error", speechclientexception);
        voicesearchcontroller = (VoiceSearchController)mControllerRef.get();
        if (voicesearchcontroller == null)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        if (speechclientexception.getCause() != null && speechclientexception.getCause().toString().contains("RequestExpiredException"))
        {
            voicesearchcontroller.onResult(new VoiceResult(mRequestId, com.amazon.shopapp.voice.search.VoiceResult.Status.WRONG_TIME_ON_DEVICE));
            return;
        }
        try
        {
            voicesearchcontroller.onResult(new VoiceResult(mRequestId, com.amazon.shopapp.voice.search.VoiceResult.Status.ERROR));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (SpeechClientException speechclientexception)
        {
            Log.e(TAG, "Error", speechclientexception);
        }
    }

    public void onEvent(int i, Bundle bundle)
    {
    }

    public void onMaxSpeechTimeout()
    {
        try
        {
            if (VoiceContext.isDebug())
            {
                Log.v(TAG, "onMaxSpeechTimeout");
            }
            return;
        }
        catch (Exception exception)
        {
            Log.e(TAG, "Error", exception);
        }
    }

    public void onNoSpeechTimeout()
    {
        VoiceSearchController voicesearchcontroller;
        try
        {
            if (VoiceContext.isDebug())
            {
                Log.v(TAG, "onNoSpeechTimeout");
            }
            voicesearchcontroller = (VoiceSearchController)mControllerRef.get();
        }
        catch (Exception exception)
        {
            Log.e(TAG, "Error", exception);
            return;
        }
        if (voicesearchcontroller == null)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        voicesearchcontroller.onResult(new VoiceResult(mRequestId, com.amazon.shopapp.voice.search.VoiceResult.Status.NO_SPEECH_DETECTED));
        SpeechRequestHandler.getInstance().destroyClient();
        return;
    }

    public void onPartialResults(Bundle bundle)
    {
    }

    public void onReadyForSpeech(Bundle bundle)
    {
        try
        {
            bundle = (VoiceSearchController)mControllerRef.get();
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            Log.e(TAG, "Error", bundle);
            return;
        }
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_19;
        }
        bundle.onListening();
    }

    public void onResults(Bundle bundle)
    {
    }

    public void onRmsChanged(float f)
    {
        VoiceSearchController voicesearchcontroller;
        try
        {
            voicesearchcontroller = (VoiceSearchController)mControllerRef.get();
        }
        catch (Exception exception)
        {
            Log.e(TAG, "Error", exception);
            return;
        }
        if (voicesearchcontroller == null)
        {
            break MISSING_BLOCK_LABEL_20;
        }
        voicesearchcontroller.onVolumeChanged(f);
    }

    public void onSilenceDetected()
    {
        VoiceSearchController voicesearchcontroller;
        try
        {
            voicesearchcontroller = (VoiceSearchController)mControllerRef.get();
        }
        catch (Exception exception)
        {
            Log.e(TAG, "Error", exception);
            return;
        }
        if (voicesearchcontroller == null)
        {
            break MISSING_BLOCK_LABEL_19;
        }
        voicesearchcontroller.onFinishedSpeaking();
    }

}
