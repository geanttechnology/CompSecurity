// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.api.debug;

import android.widget.RadioGroup;

public final class ServiceUrlType extends Enum
{

    private static final ServiceUrlType $VALUES[];
    public static final ServiceUrlType CUSTOM;
    public static final ServiceUrlType INSECURE;
    public static final ServiceUrlType SECURE;
    private final int radioButtonViewId;

    private ServiceUrlType(String s, int i, int j)
    {
        super(s, i);
        radioButtonViewId = j;
    }

    public static ServiceUrlType getServiceUrlType(RadioGroup radiogroup)
    {
        if (radiogroup != null) goto _L2; else goto _L1
_L1:
        radiogroup = SECURE;
_L4:
        return radiogroup;
_L2:
        int j = radiogroup.getCheckedRadioButtonId();
        ServiceUrlType aserviceurltype[] = values();
        int k = aserviceurltype.length;
        int i = 0;
label0:
        do
        {
label1:
            {
                if (i >= k)
                {
                    break label1;
                }
                ServiceUrlType serviceurltype = aserviceurltype[i];
                radiogroup = serviceurltype;
                if (serviceurltype.radioButtonViewId == j)
                {
                    break label0;
                }
                i++;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
        return SECURE;
    }

    public static ServiceUrlType valueOf(String s)
    {
        return (ServiceUrlType)Enum.valueOf(com/amazon/retailsearch/android/api/debug/ServiceUrlType, s);
    }

    public static ServiceUrlType[] values()
    {
        return (ServiceUrlType[])$VALUES.clone();
    }

    public int getRadioButtonViewId()
    {
        return radioButtonViewId;
    }

    static 
    {
        SECURE = new ServiceUrlType("SECURE", 0, com.amazon.retailsearch.R.id.rs_debug_radio_secure);
        INSECURE = new ServiceUrlType("INSECURE", 1, com.amazon.retailsearch.R.id.rs_debug_radio_insecure);
        CUSTOM = new ServiceUrlType("CUSTOM", 2, com.amazon.retailsearch.R.id.rs_debug_radio_custom);
        $VALUES = (new ServiceUrlType[] {
            SECURE, INSECURE, CUSTOM
        });
    }
}
