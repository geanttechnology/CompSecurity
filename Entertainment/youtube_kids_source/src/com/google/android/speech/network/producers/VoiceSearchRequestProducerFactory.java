// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.network.producers;

import android.util.Log;
import com.google.android.speech.logger.SpeechLibLogger;
import com.google.android.speech.network.request.MobileUserInfoBuilderTask;
import com.google.android.speech.network.request.RecognizerVocabularyContextBuilderTask;
import com.google.android.speech.network.request.S3ClientInfoBuilderTask;
import com.google.android.speech.network.request.S3RecognizerInfoBuilderTask;
import com.google.android.speech.network.request.S3UserInfoBuilderTask;
import com.google.android.speech.params.AudioInputParams;
import com.google.android.speech.params.NetworkRequestProducerParams;
import com.google.android.speech.params.SessionParams;
import daf;
import dah;
import dai;
import dbi;
import ewq;
import exh;
import exn;
import f;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

// Referenced classes of package com.google.android.speech.network.producers:
//            RequestProducerFactory, VoiceSearchHeaderProducer, AmrStreamProducer

public class VoiceSearchRequestProducerFactory
    implements RequestProducerFactory
{

    private static final String TAG = "VoiceSearchRequestProducerFactory";
    private final ExecutorService mExecutor;
    private final SpeechLibLogger mLogger;
    private Future mMobileUserInfoFuture;
    private final NetworkRequestProducerParams mNrpp;
    private Future mPinholeParamsFuture;
    private Future mRecognizerVocabularyContextFuture;
    private String mRequestId;
    private ewq mS3AudioInfo;
    private Future mS3ClientInfoFuture;
    private exn mS3RecognizerInfo;
    private Future mS3UserInfoFuture;
    private String mService;
    private SessionParams mSessionParams;
    private final dai mTimeoutEnforcer = new dai(1000L);

    public VoiceSearchRequestProducerFactory(ExecutorService executorservice, NetworkRequestProducerParams networkrequestproducerparams, SpeechLibLogger speechliblogger)
    {
        mExecutor = executorservice;
        mNrpp = networkrequestproducerparams;
        mLogger = speechliblogger;
    }

    private Future createMobileUserInfoFuture()
    {
        return mExecutor.submit(new MobileUserInfoBuilderTask(mNrpp.getNetworkInformation()));
    }

    private Future createPinholeParamsFuture()
    {
        if (mSessionParams.getMode() == 2)
        {
            ExecutorService executorservice = mExecutor;
            dbi dbi1 = mNrpp.getPinholeParamsBuilder();
            String s = mRequestId;
            return executorservice.submit(dbi1.a());
        } else
        {
            return null;
        }
    }

    private Future createRecognizerVocabularyContextFuture()
    {
        return mExecutor.submit(RecognizerVocabularyContextBuilderTask.getBuilder(mNrpp.getTopContactNamesSupplier()));
    }

    private ewq createS3AudioInfo()
    {
        AudioInputParams audioinputparams = mSessionParams.getAudioInputParams();
        return (new ewq()).a(audioinputparams.getEncoding()).a(audioinputparams.getSamplingRate());
    }

    private Future createS3ClientInfoFuture()
    {
        return mExecutor.submit(new S3ClientInfoBuilderTask(mNrpp.getLocationHelper(), mNrpp.getRegionExperimentsSupplier(), mNrpp.getSpeechSettings(), mSessionParams.getApplicationId(), mNrpp.getDeviceParams(), mSessionParams.getTriggerApplication()));
    }

    private exn createS3RecognizerInfo()
    {
        return (exn)(new S3RecognizerInfoBuilderTask(mSessionParams.getRecognitionContext(), mNrpp.getSpeechSettings(), mSessionParams.isPartialResultsEnabled(), mSessionParams.isCombinedNbestEnabled(), mSessionParams.isSuggestionsEnabled(), mSessionParams.getMaxNbest(), mSessionParams.isServerEndpointingEnabled(), mSessionParams.isProfanityFilterEnabled())).call();
    }

    private Future createS3UserInfoFuture()
    {
        return mExecutor.submit(S3UserInfoBuilderTask.getBuilder(mNrpp.getAuthTokenHelper(), mNrpp.getSpeechSettings(), mNrpp.getLocationHelper(), mSessionParams.getSpokenBcp47Locale(), mSessionParams.getLocationOverride()));
    }

    public void init(SessionParams sessionparams)
    {
        mSessionParams = sessionparams;
        mService = mSessionParams.getService();
        mRequestId = mSessionParams.getRequestId();
        mPinholeParamsFuture = createPinholeParamsFuture();
        mMobileUserInfoFuture = createMobileUserInfoFuture();
        mS3AudioInfo = createS3AudioInfo();
        mS3ClientInfoFuture = createS3ClientInfoFuture();
        mS3UserInfoFuture = createS3UserInfoFuture();
        mS3RecognizerInfo = createS3RecognizerInfo();
        mRecognizerVocabularyContextFuture = createRecognizerVocabularyContextFuture();
    }

    public dah newRequestProducer(InputStream inputstream)
    {
        f.b(mSessionParams);
        return new daf(new VoiceSearchHeaderProducer(mPinholeParamsFuture, mMobileUserInfoFuture, mS3ClientInfoFuture, mS3UserInfoFuture, mRecognizerVocabularyContextFuture, mS3AudioInfo, mS3RecognizerInfo, mRequestId, mService, mLogger, mNrpp.getSpeechSettings()), new AmrStreamProducer(inputstream, mSessionParams.getAudioInputParams().getEncoding(), 384));
    }

    public void refresh()
    {
        if (mSessionParams == null)
        {
            Log.w("VoiceSearchRequestProducerFactory", "Trying to refresh before init.");
            return;
        }
        Object obj;
        try
        {
            obj = (exh)mTimeoutEnforcer.a(mS3UserInfoFuture);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Log.w("VoiceSearchRequestProducerFactory", "Could not get S3UserInfo for refresh.");
            obj = null;
        }
        if (obj == null)
        {
            mS3UserInfoFuture = createS3UserInfoFuture();
            return;
        } else
        {
            mS3UserInfoFuture = mExecutor.submit(S3UserInfoBuilderTask.getAuthTokenRefreshingBuilder(mNrpp.getAuthTokenHelper(), ((exh) (obj)), mNrpp.getSpeechSettings()));
            return;
        }
    }
}
