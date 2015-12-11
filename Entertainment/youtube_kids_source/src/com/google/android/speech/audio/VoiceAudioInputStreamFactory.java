// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.audio;

import android.content.Context;
import com.google.android.speech.SpeechSettings;
import com.google.android.speech.debug.DebugAudioLogger;
import java.io.InputStream;

// Referenced classes of package com.google.android.speech.audio:
//            AudioInputStreamFactory

public final class VoiceAudioInputStreamFactory
    implements AudioInputStreamFactory
{

    private static final boolean DEBUG = false;
    private static final String TAG = "MicrophoneManagerImpl";
    private final Context mContext;
    private final AudioInputStreamFactory mDelegate;
    private final SpeechSettings mSettings;

    public VoiceAudioInputStreamFactory(AudioInputStreamFactory audioinputstreamfactory, SpeechSettings speechsettings, Context context)
    {
        mDelegate = audioinputstreamfactory;
        mSettings = speechsettings;
        mContext = context;
    }

    public final InputStream createInputStream()
    {
        return DebugAudioLogger.maybeWrapInLogStream(mDelegate.createInputStream(), mContext, mSettings);
    }
}
