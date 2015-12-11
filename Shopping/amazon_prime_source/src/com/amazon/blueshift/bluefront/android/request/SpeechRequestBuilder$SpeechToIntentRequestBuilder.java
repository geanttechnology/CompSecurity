// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.blueshift.bluefront.android.request;

import com.amazon.bluefront.api.v2.IntentParameters;
import com.amazon.bluefront.api.v2.SpeechToIntentInputParameters;
import com.amazon.dee.result.bif.BIF;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Preconditions;

// Referenced classes of package com.amazon.blueshift.bluefront.android.request:
//            SpeechRequestBuilder, SpeechRequest

public static class mMaxResultCount extends mMaxResultCount
{

    private static final String PATH = "speech/interpreter/v2";
    private int mMaxResultCount;

    public SpeechRequest build()
    {
        Object obj = buildBaseParameters();
        IntentParameters intentparameters = new IntentParameters();
        intentparameters.setMaxNBest(mMaxResultCount);
        SpeechToIntentInputParameters speechtointentinputparameters = new SpeechToIntentInputParameters();
        speechtointentinputparameters.setServiceParams(((com.amazon.bluefront.api.v2.ServiceParameters) (obj)));
        speechtointentinputparameters.setIntentParams(intentparameters);
        try
        {
            obj = new SpeechRequest(SpeechRequestBuilder.access$100().writeValueAsString(speechtointentinputparameters), getLocaleString(), getProfile(), getCompleteUri("speech/interpreter/v2"), getTimeouts(), com/amazon/dee/result/bif/BIF);
        }
        catch (JsonProcessingException jsonprocessingexception)
        {
            throw new RuntimeException("Error building request json", jsonprocessingexception);
        }
        return ((SpeechRequest) (obj));
    }

    public getTimeouts maxResultCount(int i)
    {
        boolean flag;
        if (i > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag, "Max result count must be greater than 0");
        mMaxResultCount = i;
        return this;
    }

    public ()
    {
        super(null);
        mMaxResultCount = 1;
    }
}
