// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.speech.logger.SpeechLibLogger;
import com.google.android.speech.network.producers.VoiceSearchRequestProducerFactory;
import com.google.android.speech.params.NetworkRequestProducerParams;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;

final class ahe extends VoiceSearchRequestProducerFactory
{

    private agw a;

    ahe(agw agw, ExecutorService executorservice, NetworkRequestProducerParams networkrequestproducerparams, SpeechLibLogger speechliblogger)
    {
        a = agw;
        super(executorservice, networkrequestproducerparams, speechliblogger);
    }

    public final dah newRequestProducer(InputStream inputstream)
    {
        inputstream = super.newRequestProducer(inputstream);
        return new ahd(a, inputstream);
    }
}
