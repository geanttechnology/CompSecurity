// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.auth.mapr5;

import android.os.Bundle;
import com.amazon.identity.auth.device.api.CustomerAttributeStore;

public class MapAttributeHelper
{

    public static String getDeviceAttribute(CustomerAttributeStore customerattributestore, String s, String s1, String s2)
    {
        if (s != null)
        {
            if (!(customerattributestore = customerattributestore.peekAttribute(s, s1)).containsKey("error_code_key"))
            {
                return CustomerAttributeStore.getValueOrAttributeDefault(customerattributestore);
            }
        }
        return s2;
    }
}
