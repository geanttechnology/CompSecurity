// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.blueshift.bluefront.android.request;

import com.amazon.bluefront.api.v2.DataMartStorageId;
import com.amazon.bluefront.api.v2.SpeechToDataMartInputParameters;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

// Referenced classes of package com.amazon.blueshift.bluefront.android.request:
//            SpeechRequestBuilder, SpeechRequest

public static class i extends i
{

    private static final String PATH = "speech/recorder/v2";

    public SpeechRequest build()
    {
        Object obj = buildBaseParameters();
        SpeechToDataMartInputParameters speechtodatamartinputparameters = new SpeechToDataMartInputParameters();
        speechtodatamartinputparameters.setServiceParams(((com.amazon.bluefront.api.v2.ServiceParameters) (obj)));
        try
        {
            obj = new SpeechRequest(SpeechRequestBuilder.access$100().writeValueAsString(speechtodatamartinputparameters), getLocaleString(), getProfile(), getCompleteUri("speech/recorder/v2"), getTimeouts(), com/amazon/bluefront/api/v2/DataMartStorageId);
        }
        catch (JsonProcessingException jsonprocessingexception)
        {
            throw new RuntimeException("Error building request json", jsonprocessingexception);
        }
        return ((SpeechRequest) (obj));
    }

    public i()
    {
        super(null);
    }
}
