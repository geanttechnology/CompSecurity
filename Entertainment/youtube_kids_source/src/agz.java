// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import android.util.Pair;
import com.google.android.speech.RecognitionEngineStore;
import com.google.android.speech.embedded.Greco3RecognitionEngine;
import com.google.android.speech.engine.NetworkRecognitionEngine;
import com.google.android.speech.engine.RecognitionEngine;
import com.google.android.speech.params.RecognitionEngineParams;
import java.util.Iterator;
import java.util.List;

final class agz
    implements RecognitionEngineStore
{

    private RecognitionEngine a;
    private RecognitionEngine b;
    private agw c;

    agz(agw agw1)
    {
        c = agw1;
        super();
        agw1 = agw.a(c).getNetworkParams();
        com.google.android.speech.logger.SpeechLibLogger speechliblogger = c.buildSpeechLibLogger();
        ahe ahe1 = new ahe(c, c.a, agw1.getNetworkRequestProducerParams(), speechliblogger);
        a = new NetworkRecognitionEngine(agw1.getPrimaryConnectionFactory(), agw1.getFallbackConnectionFactory(), agw1.getRetryPolicy(), c.a, ahe1, speechliblogger);
        agw1 = agw.a(c).getEmbeddedParams();
        b = new Greco3RecognitionEngine(agw1.getGreco3EngineManager(), agw1.getSamplingRate(), agw1.getBytesPerSample(), agw1.getSpeechSettings(), agw1.getCallbackFactory(), agw1.getModeSelector(), new aha(this), c.buildSpeechLibLogger());
    }

    public final List getEngines(List list)
    {
        java.util.ArrayList arraylist = a.f(list.size());
        list = list.iterator();
        do
        {
            if (list.hasNext())
            {
                switch (((Integer)list.next()).intValue())
                {
                default:
                    Log.w(agw.a(), "Unknown engine index");
                    break;

                case 2: // '\002'
                    arraylist.add(Pair.create(Integer.valueOf(2), a));
                    break;

                case 1: // '\001'
                    arraylist.add(Pair.create(Integer.valueOf(1), b));
                    break;
                }
            } else
            {
                return arraylist;
            }
        } while (true);
    }
}
