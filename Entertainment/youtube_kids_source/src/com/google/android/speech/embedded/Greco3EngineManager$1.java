// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.embedded;

import android.util.Log;
import evg;
import ewe;
import ewo;
import eyn;
import java.util.concurrent.Callable;

// Referenced classes of package com.google.android.speech.embedded:
//            GrecoEventLogger, Greco3Recognizer, Greco3EngineManager

class val.languagePack
    implements Callable
{

    final Greco3EngineManager this$0;
    final GrecoEventLogger val$eventLogger;
    final eyn val$languagePack;
    final ewo val$recParams;
    final Greco3Recognizer val$recognizer;

    public Greco3Recognizer call()
    {
        if (val$eventLogger != null)
        {
            val$eventLogger.recognitionStarted();
        }
        Object obj = val$recognizer.run(val$recParams);
        int i = ((ewe) (obj)).a;
        if (i != 0 && i != 4)
        {
            Log.e("VS.G3EngineManager", (new StringBuilder("Error running recognition: ")).append(i).toString());
        }
        if (val$eventLogger != null)
        {
            obj = ((ewe) (obj)).b;
            ((evg) (obj)).a(Greco3EngineManager.access$000(val$languagePack));
            ((evg) (obj)).a(val$languagePack.a);
            val$eventLogger.recognitionCompleted(((evg) (obj)));
        }
        return val$recognizer;
    }

    public volatile Object call()
    {
        return call();
    }

    ()
    {
        this$0 = final_greco3enginemanager;
        val$eventLogger = grecoeventlogger;
        val$recognizer = greco3recognizer;
        val$recParams = ewo;
        val$languagePack = eyn.this;
        super();
    }
}
