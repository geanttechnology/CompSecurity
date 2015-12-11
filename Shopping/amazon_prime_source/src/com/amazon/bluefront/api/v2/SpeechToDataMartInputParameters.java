// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.bluefront.api.v2;


// Referenced classes of package com.amazon.bluefront.api.v2:
//            ServiceParameters

public class SpeechToDataMartInputParameters
    implements Comparable
{

    private ServiceParameters mServiceParams;

    public SpeechToDataMartInputParameters()
    {
    }

    public int compareTo(SpeechToDataMartInputParameters speechtodatamartinputparameters)
    {
        int j = -1;
        if (speechtodatamartinputparameters != null) goto _L2; else goto _L1
_L1:
        int i = j;
_L6:
        return i;
_L2:
        ServiceParameters serviceparameters;
        if (speechtodatamartinputparameters == this)
        {
            return 0;
        }
        serviceparameters = getServiceParams();
        speechtodatamartinputparameters = speechtodatamartinputparameters.getServiceParams();
        if (serviceparameters == speechtodatamartinputparameters)
        {
            break; /* Loop/switch isn't completed */
        }
        i = j;
        if (serviceparameters == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (speechtodatamartinputparameters == null)
        {
            return 1;
        }
        if (!(serviceparameters instanceof Comparable)) goto _L4; else goto _L3
_L3:
        j = ((Comparable)serviceparameters).compareTo(speechtodatamartinputparameters);
        i = j;
        if (j != 0) goto _L6; else goto _L5
_L5:
        return 0;
_L4:
        if (!serviceparameters.equals(speechtodatamartinputparameters))
        {
            int k = serviceparameters.hashCode();
            int l = speechtodatamartinputparameters.hashCode();
            i = j;
            if (k < l)
            {
                continue; /* Loop/switch isn't completed */
            }
            if (k > l)
            {
                return 1;
            }
        }
        if (true) goto _L5; else goto _L7
_L7:
        if (true) goto _L6; else goto _L8
_L8:
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((SpeechToDataMartInputParameters)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof SpeechToDataMartInputParameters)
            {
                if (compareTo((SpeechToDataMartInputParameters)obj) != 0)
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

    public ServiceParameters getServiceParams()
    {
        return mServiceParams;
    }

    public int hashCode()
    {
        int i;
        if (getServiceParams() == null)
        {
            i = 0;
        } else
        {
            i = getServiceParams().hashCode();
        }
        return 1 + i;
    }

    public void setServiceParams(ServiceParameters serviceparameters)
    {
        mServiceParams = serviceparameters;
    }
}
