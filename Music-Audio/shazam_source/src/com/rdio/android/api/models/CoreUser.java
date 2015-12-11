// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.api.models;

import com.rdio.android.api.models.generated.BaseUser;
import java.util.List;

public class CoreUser extends BaseUser
{
    public static class Features
    {

        public List limits;
        public String product;

        public Features()
        {
        }
    }

    public static class ProductAccess
    {

        public List all_devices;
        public List ce_devices;
        public List mobile_devices;
        public String name;

        public ProductAccess()
        {
        }
    }


    public boolean isSubscriber;
    public boolean isTrial;
    public boolean isUnlimited;
    public List productAccess;
    public String registrationDate;
    public String streamRegion;

    public CoreUser()
    {
    }
}
