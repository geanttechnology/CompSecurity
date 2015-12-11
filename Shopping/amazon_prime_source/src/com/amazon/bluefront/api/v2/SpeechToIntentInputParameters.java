// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.bluefront.api.v2;


// Referenced classes of package com.amazon.bluefront.api.v2:
//            ServiceParameters, IntentParameters

public class SpeechToIntentInputParameters
    implements Comparable
{

    private IntentParameters mIntentParams;
    private ServiceParameters mServiceParams;

    public SpeechToIntentInputParameters()
    {
    }

    public int compareTo(SpeechToIntentInputParameters speechtointentinputparameters)
    {
        if (speechtointentinputparameters != null) goto _L2; else goto _L1
_L1:
        int i = -1;
_L6:
        return i;
_L2:
        Object obj;
        ServiceParameters serviceparameters;
        if (speechtointentinputparameters == this)
        {
            return 0;
        }
        obj = getServiceParams();
        serviceparameters = speechtointentinputparameters.getServiceParams();
        if (obj == serviceparameters)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        if (serviceparameters == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L4; else goto _L3
_L3:
        int k;
        k = ((Comparable)obj).compareTo(serviceparameters);
        i = k;
        if (k != 0) goto _L6; else goto _L5
_L5:
        obj = getIntentParams();
        speechtointentinputparameters = speechtointentinputparameters.getIntentParams();
        if (obj == speechtointentinputparameters)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L4:
        if (!obj.equals(serviceparameters))
        {
            i = obj.hashCode();
            k = serviceparameters.hashCode();
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
        if (speechtointentinputparameters == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L9; else goto _L8
_L8:
        k = ((Comparable)obj).compareTo(speechtointentinputparameters);
        i = k;
        if (k != 0) goto _L6; else goto _L10
_L10:
        return 0;
_L9:
        if (!obj.equals(speechtointentinputparameters))
        {
            int j = obj.hashCode();
            int l = speechtointentinputparameters.hashCode();
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
        return compareTo((SpeechToIntentInputParameters)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof SpeechToIntentInputParameters)
            {
                if (compareTo((SpeechToIntentInputParameters)obj) != 0)
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

    public IntentParameters getIntentParams()
    {
        return mIntentParams;
    }

    public ServiceParameters getServiceParams()
    {
        return mServiceParams;
    }

    public int hashCode()
    {
        int j = 0;
        int i;
        if (getServiceParams() == null)
        {
            i = 0;
        } else
        {
            i = getServiceParams().hashCode();
        }
        if (getIntentParams() != null)
        {
            j = getIntentParams().hashCode();
        }
        return 1 + i + j;
    }

    public void setIntentParams(IntentParameters intentparameters)
    {
        mIntentParams = intentparameters;
    }

    public void setServiceParams(ServiceParameters serviceparameters)
    {
        mServiceParams = serviceparameters;
    }
}
