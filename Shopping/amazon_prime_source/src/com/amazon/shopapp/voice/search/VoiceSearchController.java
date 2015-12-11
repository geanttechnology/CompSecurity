// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.shopapp.voice.search;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseIntArray;
import com.amazon.bluefront.api.common.TranslateToObfuscatedCustomerIdFrom;
import com.amazon.blueshift.bluefront.android.SpeechClient;
import com.amazon.blueshift.bluefront.android.common.BluefrontCredential;
import com.amazon.blueshift.bluefront.android.request.SpeechRequest;
import com.amazon.blueshift.bluefront.android.vad.config.DnnVADConfig;
import com.amazon.shopapp.voice.metrics.VoiceSearchMetricsRecorder;
import com.amazon.shopapp.voice.module.CustomerProvider;
import com.amazon.shopapp.voice.module.VoiceContext;
import com.amazon.shopapp.voice.module.VoiceInitSettings;
import com.amazon.shopapp.voice.search.bluefront.BluefrontSpeechRequestListener;
import com.amazon.shopapp.voice.search.bluefront.SpeechRequestHandler;
import com.amazon.shopapp.voice.search.ui.LegacySpeechFragment;
import com.amazon.shopapp.voice.search.ui.SpeechFragment;
import com.amazon.shopapp.voice.search.ui.SpeechPanel;
import com.amazon.shopapp.voice.search.ui.VoiceSearchDialog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

// Referenced classes of package com.amazon.shopapp.voice.search:
//            VoiceResult, RandomStringUtil

public class VoiceSearchController
{
    private class SoundLoadHandler
        implements android.media.SoundPool.OnLoadCompleteListener
    {

        final VoiceSearchController this$0;

        public void onLoadComplete(SoundPool soundpool, int i, int j)
        {
_L3:
            j = mSamples.get(i);
            if (j != 0)
            {
                break MISSING_BLOCK_LABEL_125;
            }
            Log.e(VoiceSearchController.TAG, (new StringBuilder()).append("Unknown sample: ").append(i).toString());
_L1:
            playSample(soundpool, i);
            return;
            mSounds.put(j, i);
              goto _L1
            try
            {
                if (VoiceContext.isDebug())
                {
                    Log.d(VoiceSearchController.TAG, (new StringBuilder()).append("Sound loaded: ").append(i).append(", status: ").append(j).toString());
                }
            }
            // Misplaced declaration of an exception variable
            catch (SoundPool soundpool)
            {
                Log.e(VoiceSearchController.TAG, (new StringBuilder()).append("Failed to play sample ").append(i).toString(), soundpool);
                return;
            }
            if (j != 0)
            {
                return;
            }
            if (true) goto _L3; else goto _L2
_L2:
        }

        private SoundLoadHandler()
        {
            this$0 = VoiceSearchController.this;
            super();
        }

    }


    private static final String AUDIO_DATA_SOLICITOR_METADATA_KEY = "audioDataSolicitor";
    private static final String AUDIO_INITIATOR_METADATA_KEY = "audioInitiator";
    private static final String AUDIO_INITIATOR_METADATA_VALUE = "AUDIO_RECORDING";
    private static final String LIVE_TRAFIC_METADATA_KEY = "isLiveTraffic";
    private static final boolean LIVE_TRAFIC_METADATA_VALUE = true;
    private static final float LRT_THRESHOLD = 1.6F;
    private static final int MAX_NEGATIVE_RESULT = 2;
    public static final int MAX_NUM_INTERPRETATIONS = 3;
    private static final String MSHOP_APP_VERSION_METADATA_KEY = "appVersion";
    public static final int REQUEST_ID_LENGTH = 32;
    private static final String SESSION_ID_METADATA_KEY = "SessionId";
    private static final int SOUND_CAPACITY = 4;
    private static final int START_THRESHOLD = 22;
    private static final int STOP_THRESHOLD = 60;
    public static final String SUGGESTIONS_FLOW_PARAM = "suggestionsFlow";
    private static final String TAG = com/amazon/shopapp/voice/search/VoiceSearchController.getSimpleName();
    private static final String VOICE_SEARCH_DIALOG_TAG = "VoiceSearchDialogFragment";
    private final Activity mActivity;
    private boolean mCancelPlayed;
    private boolean mDialogCancelled;
    private MediaPlayer mListeningPlayer;
    private final VoiceSearchMetricsRecorder mMetricsRecorder;
    private int mNegativeResults;
    private final SpeechPanel mPanel;
    private SparseIntArray mSamples;
    private SoundPool mSoundPool;
    private SparseIntArray mSounds;
    private boolean mStartScheduled;
    private boolean mStopPlayed;
    private final boolean mSuggestionsFlow;
    private final VoiceSearchDialog mVoiceSearchDialog = new VoiceSearchDialog(this);

    public VoiceSearchController(Activity activity, SpeechPanel speechpanel, boolean flag)
    {
        mStartScheduled = false;
        mDialogCancelled = false;
        mSounds = new SparseIntArray(4);
        mSamples = new SparseIntArray(4);
        mActivity = activity;
        mPanel = speechpanel;
        mSuggestionsFlow = flag;
        mMetricsRecorder = new VoiceSearchMetricsRecorder(activity);
    }

    private void playCancelSound()
    {
        if (mCancelPlayed || mStopPlayed)
        {
            return;
        } else
        {
            playSoundResource(com.amazon.shopapp.voice.R.raw.vs_system_state_mshop_cancel);
            mCancelPlayed = true;
            return;
        }
    }

    private boolean playListeningSound()
    {
        try
        {
            releaseListeningPlayer();
            mListeningPlayer = MediaPlayer.create(mActivity, com.amazon.shopapp.voice.R.raw.vs_system_state_mshop_listening);
            mListeningPlayer.setOnCompletionListener(new android.media.MediaPlayer.OnCompletionListener() {

                final VoiceSearchController this$0;

                public void onCompletion(MediaPlayer mediaplayer)
                {
                    if (mListeningPlayer != mediaplayer)
                    {
                        return;
                    }
                    try
                    {
                        if (!mDialogCancelled && mPanel.isActive())
                        {
                            startSpeechRecognition();
                        }
                        releaseListeningPlayer();
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (MediaPlayer mediaplayer)
                    {
                        Log.e(VoiceSearchController.TAG, "Error", mediaplayer);
                    }
                    return;
                }

            
            {
                this$0 = VoiceSearchController.this;
                super();
            }
            });
            mListeningPlayer.start();
        }
        catch (Throwable throwable)
        {
            Log.e(TAG, "Error", throwable);
            return false;
        }
        return true;
    }

    private void playResultsDeliveredSound()
    {
        playSoundResource(com.amazon.shopapp.voice.R.raw.vs_system_state_mshop_results_delivered);
    }

    private void playSample(SoundPool soundpool, int i)
    {
        try
        {
            if (VoiceContext.isDebug())
            {
                Log.d(TAG, (new StringBuilder()).append("Playing sample: ").append(i).toString());
            }
            float f = VoiceContext.getSettings().getSoundClipVolume();
            if (soundpool.play(i, f, f, 1, 0, 1.0F) == 0)
            {
                Log.e(TAG, (new StringBuilder()).append("Failed to play sound: ").append(i).toString());
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (SoundPool soundpool)
        {
            Log.e(TAG, "Error", soundpool);
        }
    }

    private void playSoundResource(int i)
    {
        if (VoiceContext.isDebug())
        {
            Log.d(TAG, (new StringBuilder()).append("Playing sound resource ").append(i).toString());
        }
        if (!soundEnabled())
        {
            return;
        }
        if (mSoundPool != null)
        {
            break MISSING_BLOCK_LABEL_88;
        }
        int j;
        if (VoiceContext.getSettings().useRingAudioStream())
        {
            j = 2;
        } else
        {
            j = 5;
        }
        mSoundPool = new SoundPool(1, j, 0);
        mSoundPool.setOnLoadCompleteListener(new SoundLoadHandler());
        j = mSounds.get(i);
        if (j != 0)
        {
            try
            {
                playSample(mSoundPool, j);
                return;
            }
            catch (Throwable throwable)
            {
                Log.e(TAG, "Error", throwable);
            }
            return;
        }
        int k = mSoundPool.load(mActivity, i, 1);
        mSamples.put(k, i);
        if (VoiceContext.isDebug())
        {
            Log.d(TAG, (new StringBuilder()).append("Loading resource ").append(i).append(": sample ID: ").append(k).toString());
        }
        return;
    }

    private void playStopSound()
    {
        if (mStopPlayed || mCancelPlayed)
        {
            return;
        } else
        {
            playSoundResource(com.amazon.shopapp.voice.R.raw.vs_system_state_mshop_endpointing);
            mStopPlayed = true;
            return;
        }
    }

    private void release()
    {
        try
        {
            if (VoiceContext.isDebug())
            {
                Log.d(TAG, "release");
            }
            SpeechRequestHandler.getInstance().destroyClient();
            releaseListeningPlayer();
            return;
        }
        catch (Throwable throwable)
        {
            Log.e(TAG, "Error", throwable);
        }
    }

    private void releaseListeningPlayer()
    {
        try
        {
            if (mListeningPlayer != null)
            {
                mListeningPlayer.release();
                mListeningPlayer = null;
            }
            return;
        }
        catch (Throwable throwable)
        {
            mListeningPlayer = null;
            Log.e(TAG, "Error", throwable);
            return;
        }
    }

    private boolean shouldPlayListeningSound(Activity activity)
    {
        if (!soundEnabled())
        {
            break MISSING_BLOCK_LABEL_50;
        }
        if (!VoiceContext.getSettings().isListeningSoundEnabled())
        {
            return false;
        }
        int i = ((AudioManager)activity.getSystemService("audio")).getRingerMode();
        if (i == 2)
        {
            return true;
        }
        break MISSING_BLOCK_LABEL_50;
        activity;
        Log.e(TAG, "Error", activity);
        return false;
    }

    private static void showDialog(Activity activity, boolean flag)
    {
        boolean flag1 = false;
        boolean flag2 = activity instanceof FragmentActivity;
        flag1 = flag2;
_L2:
        if (flag1)
        {
            showLegacyFragment(activity, flag);
            return;
        }
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            showStandardFragment(activity, flag);
            return;
        } else
        {
            Log.e(TAG, "Activity does not support fragments");
            return;
        }
        Throwable throwable;
        throwable;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private static LegacySpeechFragment showLegacyFragment(Activity activity, boolean flag)
    {
        FragmentManager fragmentmanager = ((FragmentActivity)activity).getSupportFragmentManager();
        LegacySpeechFragment legacyspeechfragment = (LegacySpeechFragment)fragmentmanager.findFragmentByTag("VoiceSearchDialogFragment");
        activity = legacyspeechfragment;
        if (legacyspeechfragment == null)
        {
            activity = LegacySpeechFragment.newInstance(flag);
            activity.show(fragmentmanager, "VoiceSearchDialogFragment");
        }
        return activity;
    }

    private static SpeechFragment showStandardFragment(Activity activity, boolean flag)
    {
        android.app.FragmentManager fragmentmanager = activity.getFragmentManager();
        SpeechFragment speechfragment = (SpeechFragment)fragmentmanager.findFragmentByTag("VoiceSearchDialogFragment");
        activity = speechfragment;
        if (speechfragment == null)
        {
            activity = SpeechFragment.newInstance(flag);
            activity.show(fragmentmanager, "VoiceSearchDialogFragment");
        }
        return activity;
    }

    private boolean soundEnabled()
    {
        if (!VoiceContext.getSettings().isSoundEnabled())
        {
            return false;
        }
        String s = VoiceContext.getSettings().getSoundFeature();
        if (s == null) goto _L2; else goto _L1
_L1:
        boolean flag = VoiceContext.getInstance().isFeatureActive(s);
        if (flag) goto _L3; else goto _L2
_L2:
        return true;
        Throwable throwable;
        throwable;
        Log.e(TAG, "Error", throwable);
        if (true) goto _L2; else goto _L3
_L3:
        return false;
    }

    public static void startVoiceSearch(Activity activity, boolean flag)
    {
        if (VoiceContext.isDebug())
        {
            Log.d(TAG, "Start voice search");
        }
        if (activity == null)
        {
            try
            {
                Log.e(TAG, "Activity is null");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Activity activity)
            {
                Log.e(TAG, "Failed to launch voice search", activity);
            }
            break MISSING_BLOCK_LABEL_67;
        }
        if (activity.isFinishing())
        {
            if (VoiceContext.isDebug())
            {
                Log.d(TAG, "Activity is finishing");
                return;
            }
            break MISSING_BLOCK_LABEL_73;
        }
        break MISSING_BLOCK_LABEL_68;
        return;
        showDialog(activity, flag);
    }

    public void cancel()
    {
        try
        {
            if (VoiceContext.isDebug())
            {
                Log.d(TAG, "cancel");
            }
            mDialogCancelled = true;
            if (mVoiceSearchDialog.getState() != com.amazon.shopapp.voice.search.ui.VoiceSearchDialog.DialogState.NONE)
            {
                playCancelSound();
            }
            release();
            reset();
            return;
        }
        catch (Exception exception)
        {
            Log.e(TAG, "Error", exception);
        }
    }

    public void clearPlayedSounds()
    {
        mStopPlayed = false;
        mCancelPlayed = false;
    }

    public Activity getActivity()
    {
        return mActivity;
    }

    public VoiceSearchMetricsRecorder getMetricsRecorder()
    {
        return mMetricsRecorder;
    }

    public SpeechPanel getPanel()
    {
        return mPanel;
    }

    public VoiceSearchDialog getVoiceSearchDialog()
    {
        return mVoiceSearchDialog;
    }

    public boolean isSuggestionsFlow()
    {
        return mSuggestionsFlow;
    }

    public void onFinishedSpeaking()
    {
        try
        {
            if (VoiceContext.isDebug())
            {
                Log.d(TAG, "onFinishedSpeaking");
            }
            mMetricsRecorder.startRecognitionTimer();
            playStopSound();
            mVoiceSearchDialog.showProcessing();
            return;
        }
        catch (Exception exception)
        {
            Log.e(TAG, "Error", exception);
        }
    }

    public void onListening()
    {
        try
        {
            if (VoiceContext.isDebug())
            {
                Log.d(TAG, "onListening");
            }
            if (mVoiceSearchDialog.getState() == com.amazon.shopapp.voice.search.ui.VoiceSearchDialog.DialogState.LOADING)
            {
                mVoiceSearchDialog.showSearch();
            }
            mMetricsRecorder.stopReadyTimer();
            return;
        }
        catch (Exception exception)
        {
            Log.e(TAG, "Error", exception);
        }
    }

    public void onResult(VoiceResult voiceresult)
    {
        if (VoiceContext.isDebug())
        {
            Log.d(TAG, (new StringBuilder()).append("onResult: ").append(voiceresult).toString());
        }
        if (voiceresult == null)
        {
            try
            {
                Log.e(TAG, "Voice result is null");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (VoiceResult voiceresult)
            {
                Log.e(TAG, "Error", voiceresult);
            }
            break MISSING_BLOCK_LABEL_80;
        }
        if (!mVoiceSearchDialog.isSearching())
        {
            Log.e(TAG, "Not searching");
            return;
        }
        break MISSING_BLOCK_LABEL_81;
        return;
        mMetricsRecorder.recordVoiceSearchResults(voiceresult.getStatus());
        mMetricsRecorder.stopRecognitionTimer();
        mMetricsRecorder.stopRequestTimer();
_L7:
        static class _cls2
        {

            static final int $SwitchMap$com$amazon$shopapp$voice$search$VoiceResult$Status[];

            static 
            {
                $SwitchMap$com$amazon$shopapp$voice$search$VoiceResult$Status = new int[VoiceResult.Status.values().length];
                try
                {
                    $SwitchMap$com$amazon$shopapp$voice$search$VoiceResult$Status[VoiceResult.Status.HIGH_CONFIDENCE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$amazon$shopapp$voice$search$VoiceResult$Status[VoiceResult.Status.MEDIUM_CONFIDENCE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$amazon$shopapp$voice$search$VoiceResult$Status[VoiceResult.Status.LOW_CONFIDENCE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$amazon$shopapp$voice$search$VoiceResult$Status[VoiceResult.Status.NO_SPEECH_DETECTED.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$shopapp$voice$search$VoiceResult$Status[VoiceResult.Status.WRONG_TIME_ON_DEVICE.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$shopapp$voice$search$VoiceResult$Status[VoiceResult.Status.ERROR.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls2..SwitchMap.com.amazon.shopapp.voice.search.VoiceResult.Status[voiceresult.getStatus().ordinal()];
        JVM INSTR tableswitch 1 5: default 340
    //                   1 178
    //                   2 208
    //                   3 258
    //                   4 291
    //                   5 328;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        playCancelSound();
        mVoiceSearchDialog.showNetworkError();
        return;
        Exception exception;
        exception;
        Log.e(TAG, "Error", exception);
          goto _L7
_L2:
        mNegativeResults = 0;
        playResultsDeliveredSound();
        mVoiceSearchDialog.closeDialogAndSearch((String)voiceresult.getInterpretations().get(0), voiceresult, 0);
        return;
_L3:
        if (voiceresult.getInterpretations().size() > 1)
        {
            mNegativeResults = 0;
            mVoiceSearchDialog.showDisambiguation(voiceresult);
            return;
        }
        playResultsDeliveredSound();
        mVoiceSearchDialog.closeDialogAndSearch((String)voiceresult.getInterpretations().get(0), voiceresult, 0);
        return;
_L4:
        int i;
        i = mNegativeResults + 1;
        mNegativeResults = i;
        if (i < 2) goto _L9; else goto _L8
_L8:
        mVoiceSearchDialog.showNegativeResult();
        return;
_L9:
        mVoiceSearchDialog.showLowConfidence();
        return;
_L5:
        playCancelSound();
        i = mNegativeResults + 1;
        mNegativeResults = i;
        if (i < 2) goto _L11; else goto _L10
_L10:
        mVoiceSearchDialog.showNegativeResult();
        return;
_L11:
        mVoiceSearchDialog.showNoSpeech();
        return;
_L6:
        playCancelSound();
        mVoiceSearchDialog.showTimeError();
        return;
    }

    public void onSpeechHeard()
    {
        try
        {
            if (VoiceContext.isDebug())
            {
                Log.d(TAG, "onSpeechHeard");
            }
            mVoiceSearchDialog.showRecordingMicrophone();
            return;
        }
        catch (Exception exception)
        {
            Log.e(TAG, "Error", exception);
        }
    }

    public void onStopListening()
    {
        try
        {
            if (VoiceContext.isDebug())
            {
                Log.d(TAG, "onStopListening");
            }
            mVoiceSearchDialog.showInactiveMicrophone();
            mVoiceSearchDialog.stopWaveformAnimation();
            return;
        }
        catch (Exception exception)
        {
            Log.e(TAG, "Error", exception);
        }
    }

    public void onVolumeChanged(float f)
    {
        try
        {
            mVoiceSearchDialog.onVolumeChanged(f);
            return;
        }
        catch (Exception exception)
        {
            Log.e(TAG, "Error", exception);
        }
    }

    public void prepareSpeechRecognition()
    {
        try
        {
            if (mStartScheduled)
            {
                return;
            }
        }
        catch (Exception exception)
        {
            Log.e(TAG, "Error", exception);
            return;
        }
        stopSpeechRecognition();
        mStartScheduled = true;
        mDialogCancelled = false;
        if (!shouldPlayListeningSound(mActivity))
        {
            startSpeechRecognition();
            return;
        }
        if (!playListeningSound())
        {
            startSpeechRecognition();
        }
        return;
    }

    public void reset()
    {
        mNegativeResults = 0;
        clearPlayedSounds();
    }

    public void startSpeechRecognition()
    {
        String s;
        Object obj;
        Object obj1;
        mMetricsRecorder.startRequestTimer();
        mMetricsRecorder.startReadyTimer();
        mStartScheduled = false;
        obj = mActivity.getResources().getString(com.amazon.shopapp.voice.R.string.vs_bluefront_endpoint);
        s = RandomStringUtil.generate(32);
        if (VoiceContext.isDebug())
        {
            Log.d(TAG, (new StringBuilder()).append("Host: ").append(((String) (obj))).append(", request ID: ").append(s).toString());
        }
        obj = ((com.amazon.blueshift.bluefront.android.request.SpeechRequestBuilder.SpeechToIntentRequestBuilder)((com.amazon.blueshift.bluefront.android.request.SpeechRequestBuilder.SpeechToIntentRequestBuilder)((com.amazon.blueshift.bluefront.android.request.SpeechRequestBuilder.SpeechToIntentRequestBuilder)SpeechRequest.speechToIntentRequestBuilder().hostname(((String) (obj)))).requestId(s)).locale(Locale.US)).maxResultCount(3);
        obj1 = new HashMap(4);
        ((Map) (obj1)).put("isLiveTraffic", Boolean.valueOf(true));
        ((Map) (obj1)).put("audioInitiator", "AUDIO_RECORDING");
        ((Map) (obj1)).put("audioDataSolicitor", VoiceContext.getSettings().getAudioDataSolicitor());
        Object obj2;
        String s1;
        try
        {
            ((Map) (obj1)).put("appVersion", mActivity.getPackageManager().getPackageInfo(mActivity.getPackageName(), 0).versionName);
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            try
            {
                Log.e(TAG, "Error", namenotfoundexception);
            }
            catch (Exception exception)
            {
                Log.e(TAG, "Error", exception);
                return;
            }
        }
        obj2 = VoiceContext.getSettings().getCustomerProvider();
        s1 = ((CustomerProvider) (obj2)).getDirectedId(mActivity);
        if (VoiceContext.isDebug())
        {
            Log.d(TAG, (new StringBuilder()).append("Directed ID: ").append(s1).toString());
        }
        if (!TextUtils.isEmpty(s1))
        {
            ((com.amazon.blueshift.bluefront.android.request.SpeechRequestBuilder.SpeechToIntentRequestBuilder) (obj)).customer(s1, TranslateToObfuscatedCustomerIdFrom.DIRECTED_ID);
            s1 = ((CustomerProvider) (obj2)).getDeviceId();
            if (VoiceContext.isDebug())
            {
                Log.d(TAG, (new StringBuilder()).append("Device ID: ").append(s1).toString());
            }
            if (!TextUtils.isEmpty(s1))
            {
                ((com.amazon.blueshift.bluefront.android.request.SpeechRequestBuilder.SpeechToIntentRequestBuilder) (obj)).device((new com.amazon.blueshift.bluefront.android.common.AndroidDevice.Builder(mActivity, s1)).build());
            }
            obj2 = ((CustomerProvider) (obj2)).getSessionId();
            if (VoiceContext.isDebug())
            {
                Log.d(TAG, (new StringBuilder()).append("Session ID: ").append(((String) (obj2))).toString());
            }
            if (!TextUtils.isEmpty(((CharSequence) (obj2))))
            {
                ((Map) (obj1)).put("SessionId", obj2);
            }
        }
        ((com.amazon.blueshift.bluefront.android.request.SpeechRequestBuilder.SpeechToIntentRequestBuilder) (obj)).metadataMap(((Map) (obj1)));
        obj1 = (new com.amazon.blueshift.bluefront.android.audio.AudioRecorder.Builder(mActivity)).dnnVADConfig(new DnnVADConfig(Float.valueOf(1.6F), 22, 60)).build();
        obj2 = new BluefrontCredential(VoiceContext.getSettings().getBluefrontAccessId(), VoiceContext.getSettings().getBluefrontAccessKey());
        obj = new SpeechClient(((com.amazon.blueshift.bluefront.android.request.SpeechRequestBuilder.SpeechToIntentRequestBuilder) (obj)).build(), ((com.amazon.blueshift.bluefront.android.audio.AudioSource) (obj1)), ((BluefrontCredential) (obj2)));
        ((SpeechClient) (obj)).setSpeechRequestListener(new BluefrontSpeechRequestListener(s, this));
        SpeechRequestHandler.getInstance().startRequest(((SpeechClient) (obj)));
        return;
    }

    public void stopSpeechRecognition()
    {
        try
        {
            if (SpeechRequestHandler.getInstance().isListening())
            {
                SpeechRequestHandler.getInstance().stopListening();
            }
            return;
        }
        catch (Exception exception)
        {
            Log.e(TAG, "Error", exception);
        }
    }









}
