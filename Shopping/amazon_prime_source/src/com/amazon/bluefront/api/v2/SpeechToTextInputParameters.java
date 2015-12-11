// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.bluefront.api.v2;


// Referenced classes of package com.amazon.bluefront.api.v2:
//            RecognitionParameters, ServiceParameters

public class SpeechToTextInputParameters
    implements Comparable
{

    private RecognitionParameters mRecognitionParams;
    private ServiceParameters mServiceParams;

    public SpeechToTextInputParameters()
    {
    }

    public int compareTo(SpeechToTextInputParameters speechtotextinputparameters)
    {
        if (speechtotextinputparameters != null) goto _L2; else goto _L1
_L1:
        int i = -1;
_L6:
        return i;
_L2:
        Object obj;
        RecognitionParameters recognitionparameters;
        if (speechtotextinputparameters == this)
        {
            return 0;
        }
        obj = getRecognitionParams();
        recognitionparameters = speechtotextinputparameters.getRecognitionParams();
        if (obj == recognitionparameters)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        if (recognitionparameters == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L4; else goto _L3
_L3:
        int k;
        k = ((Comparable)obj).compareTo(recognitionparameters);
        i = k;
        if (k != 0) goto _L6; else goto _L5
_L5:
        obj = getServiceParams();
        speechtotextinputparameters = speechtotextinputparameters.getServiceParams();
        if (obj == speechtotextinputparameters)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L4:
        if (!obj.equals(recognitionparameters))
        {
            i = obj.hashCode();
            k = recognitionparameters.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L5; else goto _L7
_L7:
        if (speechtotextinputparameters == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L9; else goto _L8
_L8:
        k = ((Comparable)obj).compareTo(speechtotextinputparameters);
        i = k;
        if (k != 0) goto _L6; else goto _L10
_L10:
        return 0;
_L9:
        if (!obj.equals(speechtotextinputparameters))
        {
            int j = obj.hashCode();
            int l = speechtotextinputparameters.hashCode();
            if (j < l)
            {
                return -1;
            }
            if (j > l)
            {
                return 1;
            }
        }
        if (true) goto _L10; else goto _L11
_L11:
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((SpeechToTextInputParameters)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof SpeechToTextInputParameters)
            {
                if (compareTo((SpeechToTextInputParameters)obj) != 0)
                {
                    return false;
                }
            } else
            {
                return false;
            }
        }
        return true;
    }

    public RecognitionParameters getRecognitionParams()
    {
        return mRecognitionParams;
    }

    public ServiceParameters getServiceParams()
    {
        return mServiceParams;
    }

    public int hashCode()
    {
        int j = 0;
        int i;
        if (getRecognitionParams() == null)
        {
            i = 0;
        } else
        {
            i = getRecognitionParams().hashCode();
        }
        if (getServiceParams() != null)
        {
            j = getServiceParams().hashCode();
        }
        return 1 + i + j;
    }

    public void setRecognitionParams(RecognitionParameters recognitionparameters)
    {
        mRecognitionParams = recognitionparameters;
    }

    public void setServiceParams(ServiceParameters serviceparameters)
    {
        mServiceParams = serviceparameters;
    }
}
