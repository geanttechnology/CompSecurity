// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.notification;

import com.groupon.models.GenericAmount;

public class GCMNotificationExtra
{
    public static class Deal
    {

        public GenericAmount price;
        public GenericAmount value;

        public Deal()
        {
        }
    }


    public Deal deal;
    public String nid;

    public GCMNotificationExtra()
    {
    }
}
