// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.network.request;

import egf;
import exm;
import exx;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

// Referenced classes of package com.google.android.speech.network.request:
//            BaseRequestBuilderTask

public class RecognizerVocabularyContextBuilderTask extends BaseRequestBuilderTask
{

    private static final boolean DBG = false;
    private static final String TAG = "VS.RecognizerVocabularyContextBuilderTask";
    private final egf mTopContactNamesSupplier;

    RecognizerVocabularyContextBuilderTask(egf egf1)
    {
        super("RecognizerVocabularyContextBuilderTask");
        mTopContactNamesSupplier = egf1;
    }

    public static Callable getBuilder(egf egf1)
    {
        return new RecognizerVocabularyContextBuilderTask(egf1);
    }

    protected exm build()
    {
        exm exm1 = new exm();
        Object obj = (List)mTopContactNamesSupplier.get();
        if (obj == null || ((List) (obj)).isEmpty())
        {
            return exm1;
        }
        String s;
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); exm1.a((new exx()).a(s)))
        {
            s = (String)((Iterator) (obj)).next();
        }

        return exm1;
    }

    protected volatile Object build()
    {
        return build();
    }
}
