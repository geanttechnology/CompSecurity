// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.blueshift.bluefront.android.request;

import com.amazon.bluefront.api.common.Arrf;
import com.amazon.bluefront.api.v2.RecognitionParameters;
import com.amazon.bluefront.api.v2.SpeechToTextInputParameters;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Preconditions;

// Referenced classes of package com.amazon.blueshift.bluefront.android.request:
//            SpeechRequestBuilder, SpeechRequest

public static class mMaxResultCount extends mMaxResultCount
{

    private static final String PATH = "speech/recognizer/v2";
    private int mMaxResultCount;
    private String mRecognitionOutputType;

    private SpeechRequest build(Class class1)
    {
        if (class1.equals(com/amazon/bluefront/api/common/Arrf))
        {
            mRecognitionOutputType = "ARRF";
            com.amazon.bluefront.api.v2.ServiceParameters serviceparameters = buildBaseParameters();
            RecognitionParameters recognitionparameters = new RecognitionParameters();
            recognitionparameters.setMaxNBest(mMaxResultCount);
            recognitionparameters.setOutputFormat(mRecognitionOutputType);
            SpeechToTextInputParameters speechtotextinputparameters = new SpeechToTextInputParameters();
            speechtotextinputparameters.setServiceParams(serviceparameters);
            speechtotextinputparameters.setRecognitionParams(recognitionparameters);
            try
            {
                class1 = new SpeechRequest(SpeechRequestBuilder.access$100().writeValueAsString(speechtotextinputparameters), getLocaleString(), getProfile(), getCompleteUri("speech/recognizer/v2"), getTimeouts(), class1);
            }
            // Misplaced declaration of an exception variable
            catch (Class class1)
            {
                throw new RuntimeException("Error building request json", class1);
            }
            return class1;
        } else
        {
            throw new IllegalArgumentException("SpeechToText only supports ARRF");
        }
    }

    public SpeechRequest build()
    {
        return build(com/amazon/bluefront/api/common/Arrf);
    }

    public build maxResultCount(int i)
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
