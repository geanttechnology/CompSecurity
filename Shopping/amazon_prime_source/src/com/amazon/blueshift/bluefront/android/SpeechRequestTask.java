// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.blueshift.bluefront.android;

import android.os.AsyncTask;
import android.util.Log;
import com.amazon.blueshift.bluefront.android.audio.AudioSource;
import com.amazon.blueshift.bluefront.android.audio.AudioSourceListener;
import com.amazon.blueshift.bluefront.android.common.BluefrontCredential;
import com.amazon.blueshift.bluefront.android.common.RequestTimeouts;
import com.amazon.blueshift.bluefront.android.http.AwsV2SigningProtocol;
import com.amazon.blueshift.bluefront.android.http.MultipartRequest;
import com.amazon.blueshift.bluefront.android.http.Part;
import com.amazon.blueshift.bluefront.android.http.SigningProtocol;
import com.amazon.blueshift.bluefront.android.http.URLWrapper;
import com.amazon.blueshift.bluefront.android.request.SpeechRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import javax.net.ssl.HttpsURLConnection;

// Referenced classes of package com.amazon.blueshift.bluefront.android:
//            SpeechClientException

final class SpeechRequestTask extends AsyncTask
{
    public static final class RecognitionTaskState extends Enum
    {

        private static final RecognitionTaskState $VALUES[];
        public static final RecognitionTaskState BeginingOfSpeech;
        public static final RecognitionTaskState BufferReceived;
        public static final RecognitionTaskState EndOfSpeech;
        public static final RecognitionTaskState Error;
        public static final RecognitionTaskState MaxSpeechTimeout;
        public static final RecognitionTaskState NoSpeechTimeout;
        public static final RecognitionTaskState ReadyForSpeech;
        public static final RecognitionTaskState RmsChanged;
        public static final RecognitionTaskState SilenceDetected;

        public static RecognitionTaskState valueOf(String s)
        {
            return (RecognitionTaskState)Enum.valueOf(com/amazon/blueshift/bluefront/android/SpeechRequestTask$RecognitionTaskState, s);
        }

        public static RecognitionTaskState[] values()
        {
            return (RecognitionTaskState[])$VALUES.clone();
        }

        static 
        {
            ReadyForSpeech = new RecognitionTaskState("ReadyForSpeech", 0);
            BeginingOfSpeech = new RecognitionTaskState("BeginingOfSpeech", 1);
            BufferReceived = new RecognitionTaskState("BufferReceived", 2);
            RmsChanged = new RecognitionTaskState("RmsChanged", 3);
            SilenceDetected = new RecognitionTaskState("SilenceDetected", 4);
            EndOfSpeech = new RecognitionTaskState("EndOfSpeech", 5);
            Error = new RecognitionTaskState("Error", 6);
            NoSpeechTimeout = new RecognitionTaskState("NoSpeechTimeout", 7);
            MaxSpeechTimeout = new RecognitionTaskState("MaxSpeechTimeout", 8);
            $VALUES = (new RecognitionTaskState[] {
                ReadyForSpeech, BeginingOfSpeech, BufferReceived, RmsChanged, SilenceDetected, EndOfSpeech, Error, NoSpeechTimeout, MaxSpeechTimeout
            });
        }

        private RecognitionTaskState(String s, int i)
        {
            super(s, i);
        }
    }

    public static class RecognitionTaskUpdate
    {

        private final Object mPayload;
        private final RecognitionTaskState mState;

        public Object getPayload()
        {
            return mPayload;
        }

        public RecognitionTaskState getState()
        {
            return mState;
        }

        public RecognitionTaskUpdate(RecognitionTaskState recognitiontaskstate)
        {
            this(recognitiontaskstate, null);
        }

        public RecognitionTaskUpdate(RecognitionTaskState recognitiontaskstate, Object obj)
        {
            mState = recognitiontaskstate;
            mPayload = obj;
        }
    }

    public static interface RequestTaskListener
    {

        public abstract void onBeginningOfSpeech();

        public abstract void onBluefrontResult(Object obj);

        public abstract void onBufferReceived(byte abyte0[]);

        public abstract void onError(SpeechClientException speechclientexception);

        public abstract void onMaxSpeechTimeout();

        public abstract void onNoSpeechTimeout();

        public abstract void onReadyForSpeech();

        public abstract void onRmsChanged(float f);

        public abstract void onSilenceDetected();
    }

    private class SpeechAudioRecorderListener
        implements AudioSourceListener
    {

        final SpeechRequestTask this$0;

        public void onBeginningOfSpeech()
        {
            publishProgress(new RecognitionTaskUpdate[] {
                new RecognitionTaskUpdate(RecognitionTaskState.BeginingOfSpeech)
            });
        }

        public void onBufferReceived(byte abyte0[])
        {
            publishProgress(new RecognitionTaskUpdate[] {
                new RecognitionTaskUpdate(RecognitionTaskState.BufferReceived, abyte0)
            });
        }

        public void onMaxSpeechTimeout()
        {
            publishProgress(new RecognitionTaskUpdate[] {
                new RecognitionTaskUpdate(RecognitionTaskState.MaxSpeechTimeout)
            });
        }

        public void onNoSpeechTimeout()
        {
            publishProgress(new RecognitionTaskUpdate[] {
                new RecognitionTaskUpdate(RecognitionTaskState.NoSpeechTimeout)
            });
        }

        public void onReadyForSpeech()
        {
            publishProgress(new RecognitionTaskUpdate[] {
                new RecognitionTaskUpdate(RecognitionTaskState.ReadyForSpeech)
            });
        }

        public void onRmsChanged(float f)
        {
            publishProgress(new RecognitionTaskUpdate[] {
                new RecognitionTaskUpdate(RecognitionTaskState.RmsChanged, Float.valueOf(f))
            });
        }

        public void onSilenceDetected()
        {
            publishProgress(new RecognitionTaskUpdate[] {
                new RecognitionTaskUpdate(RecognitionTaskState.SilenceDetected)
            });
        }

        private SpeechAudioRecorderListener()
        {
            this$0 = SpeechRequestTask.this;
            super();
        }

    }


    public static final String BIF_RESULT = (new StringBuilder()).append(TAG).append(".BIF").toString();
    public static final String CONFIDENCE_SCORES = (new StringBuilder()).append(TAG).append(".CONFIDENCE_SCORES").toString();
    private static final ObjectMapper MAPPER = new ObjectMapper();
    public static final String RECOGNITION_RESULTS = (new StringBuilder()).append(TAG).append(".RECOGNITION_RESULTS").toString();
    public static final String RESPONSE_CODE = (new StringBuilder()).append(TAG).append(".RESPONSE_CODE").toString();
    private static final String TAG = com/amazon/blueshift/bluefront/android/SpeechRequestTask.getCanonicalName();
    private final AudioSource mAudioSource;
    private final BluefrontCredential mCredentials;
    private final RequestTaskListener mListener;
    private final SigningProtocol mSigningProtocol;
    private final SpeechRequest mSpeechRequest;

    SpeechRequestTask(SpeechRequest speechrequest, BluefrontCredential bluefrontcredential, AudioSource audiosource, RequestTaskListener requesttasklistener)
    {
        this(speechrequest, bluefrontcredential, audiosource, requesttasklistener, ((SigningProtocol) (new AwsV2SigningProtocol())));
    }

    SpeechRequestTask(SpeechRequest speechrequest, BluefrontCredential bluefrontcredential, AudioSource audiosource, RequestTaskListener requesttasklistener, SigningProtocol signingprotocol)
    {
        Preconditions.checkNotNull(speechrequest, "Speech request cannot be null.");
        Preconditions.checkNotNull(bluefrontcredential, "Bluefront credentials cannot be null.");
        Preconditions.checkNotNull(audiosource, "AudioSource cannot be null");
        Preconditions.checkNotNull(requesttasklistener, "Recognition task listener cannot be null.");
        Preconditions.checkNotNull(signingprotocol, "Signing protocol cannot be null");
        mSpeechRequest = speechrequest;
        mCredentials = bluefrontcredential;
        mAudioSource = audiosource;
        mListener = requesttasklistener;
        mSigningProtocol = signingprotocol;
        mAudioSource.setAudioSourceListener(new SpeechAudioRecorderListener());
    }

    private Object handleResponse(String s)
        throws SpeechClientException
    {
        try
        {
            Log.v(TAG, s);
            s = ((String) (MAPPER.readValue(s, mSpeechRequest.getOutputType())));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new SpeechClientException("Failed to parse JSON response.", s);
        }
        return s;
    }

    HttpsURLConnection createConnection(URLWrapper urlwrapper, RequestTimeouts requesttimeouts)
        throws SpeechClientException
    {
        Log.v(TAG, (new StringBuilder()).append("Request URL: ").append(urlwrapper.toString()).toString());
        try
        {
            urlwrapper = (HttpsURLConnection)urlwrapper.openConnection();
        }
        // Misplaced declaration of an exception variable
        catch (URLWrapper urlwrapper)
        {
            throw new SpeechClientException("Error establishing a connection", urlwrapper);
        }
        urlwrapper.setConnectTimeout(requesttimeouts.getConnectionTimeoutMillis());
        urlwrapper.setReadTimeout(requesttimeouts.getResponseTimeoutMillis());
        urlwrapper.setChunkedStreamingMode(mAudioSource.getChunkSize());
        return urlwrapper;
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Object doInBackground(Void avoid[])
    {
        try
        {
            avoid = ((Void []) (handleResponse(new String((new MultipartRequest(createConnection(mSigningProtocol.sign(mCredentials, mSpeechRequest.getRequestUri()), mSpeechRequest.getTimeouts()), new Part[] {
                mSpeechRequest, mAudioSource
            })).execute(), "UTF-8"))));
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            publishProgress(new RecognitionTaskUpdate[] {
                new RecognitionTaskUpdate(RecognitionTaskState.Error, avoid)
            });
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            publishProgress(new RecognitionTaskUpdate[] {
                new RecognitionTaskUpdate(RecognitionTaskState.Error, avoid)
            });
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            publishProgress(new RecognitionTaskUpdate[] {
                new RecognitionTaskUpdate(RecognitionTaskState.Error, avoid)
            });
            return null;
        }
        return avoid;
    }

    protected void onPostExecute(Object obj)
    {
        if (obj != null)
        {
            mListener.onBluefrontResult(obj);
        }
    }

    protected transient void onProgressUpdate(RecognitionTaskUpdate arecognitiontaskupdate[])
    {
        Object obj;
        boolean flag = true;
        Preconditions.checkNotNull(arecognitiontaskupdate, "States cannot be null.");
        static class _cls1
        {

            static final int $SwitchMap$com$amazon$blueshift$bluefront$android$SpeechRequestTask$RecognitionTaskState[];

            static 
            {
                $SwitchMap$com$amazon$blueshift$bluefront$android$SpeechRequestTask$RecognitionTaskState = new int[RecognitionTaskState.values().length];
                try
                {
                    $SwitchMap$com$amazon$blueshift$bluefront$android$SpeechRequestTask$RecognitionTaskState[RecognitionTaskState.ReadyForSpeech.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$amazon$blueshift$bluefront$android$SpeechRequestTask$RecognitionTaskState[RecognitionTaskState.BeginingOfSpeech.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$amazon$blueshift$bluefront$android$SpeechRequestTask$RecognitionTaskState[RecognitionTaskState.BufferReceived.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$amazon$blueshift$bluefront$android$SpeechRequestTask$RecognitionTaskState[RecognitionTaskState.RmsChanged.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$amazon$blueshift$bluefront$android$SpeechRequestTask$RecognitionTaskState[RecognitionTaskState.SilenceDetected.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$amazon$blueshift$bluefront$android$SpeechRequestTask$RecognitionTaskState[RecognitionTaskState.Error.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$blueshift$bluefront$android$SpeechRequestTask$RecognitionTaskState[RecognitionTaskState.NoSpeechTimeout.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$blueshift$bluefront$android$SpeechRequestTask$RecognitionTaskState[RecognitionTaskState.MaxSpeechTimeout.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        if (arecognitiontaskupdate.length != 1)
        {
            flag = false;
        }
        Preconditions.checkArgument(flag, "Only one state is allowed.");
        arecognitiontaskupdate = arecognitiontaskupdate[0];
        Log.v(TAG, (new StringBuilder()).append("onProgressUpdate: ").append(arecognitiontaskupdate.getState().toString()).toString());
        obj = arecognitiontaskupdate.getPayload();
        if (mListener == null) goto _L2; else goto _L1
_L1:
        _cls1..SwitchMap.com.amazon.blueshift.bluefront.android.SpeechRequestTask.RecognitionTaskState[arecognitiontaskupdate.getState().ordinal()];
        JVM INSTR tableswitch 1 8: default 128
    //                   1 153
    //                   2 163
    //                   3 173
    //                   4 201
    //                   5 229
    //                   6 239
    //                   7 264
    //                   8 274;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L3:
        mListener.onError(new SpeechClientException("Received an unknown progress update"));
_L13:
        return;
_L4:
        mListener.onReadyForSpeech();
        return;
_L5:
        mListener.onBeginningOfSpeech();
        return;
_L6:
        if (obj == null || !(obj instanceof byte[])) goto _L13; else goto _L12
_L12:
        mListener.onBufferReceived((byte[])(byte[])obj);
        return;
_L7:
        if (obj == null || !(obj instanceof Float)) goto _L13; else goto _L14
_L14:
        mListener.onRmsChanged(((Float)obj).floatValue());
        return;
_L8:
        mListener.onSilenceDetected();
        return;
_L9:
        if (obj == null || !(obj instanceof SpeechClientException)) goto _L13; else goto _L15
_L15:
        mListener.onError((SpeechClientException)obj);
        return;
_L10:
        mListener.onNoSpeechTimeout();
        return;
_L11:
        mListener.onMaxSpeechTimeout();
        return;
_L2:
        Log.w(TAG, "Recogniton listener is null.");
        return;
    }

    protected volatile void onProgressUpdate(Object aobj[])
    {
        onProgressUpdate((RecognitionTaskUpdate[])aobj);
    }

    void stopRecording()
    {
        Log.v(TAG, "stopRecording");
        mAudioSource.cancel();
    }








}
