// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.shopapp.voice.search.bluefront;

import android.util.Log;
import com.amazon.blueshift.bluefront.android.SpeechClient;

public final class SpeechRequestHandler
{

    private static final String TAG = com/amazon/shopapp/voice/search/bluefront/SpeechRequestHandler.getCanonicalName();
    private static SpeechRequestHandler sInstance = new SpeechRequestHandler();
    private SpeechClient mSpeechClient;

    private SpeechRequestHandler()
    {
    }

    public static SpeechRequestHandler getInstance()
    {
        return sInstance;
    }

    public void destroyClient()
    {
        if (mSpeechClient != null)
        {
            mSpeechClient.cancel();
            mSpeechClient = null;
        }
    }

    public boolean isListening()
    {
        if (mSpeechClient != null)
        {
            return mSpeechClient.isListening();
        } else
        {
            return false;
        }
    }

    public void startRequest(SpeechClient speechclient)
    {
        if (mSpeechClient != null)
        {
            try
            {
                mSpeechClient.cancel();
            }
            catch (Exception exception)
            {
                Log.w(TAG, "Error", exception);
            }
        }
        mSpeechClient = speechclient;
        if (mSpeechClient != null)
        {
            mSpeechClient.startListening();
        }
    }

    public void stopListening()
    {
        if (mSpeechClient != null)
        {
            mSpeechClient.stopListening();
        }
    }

}
