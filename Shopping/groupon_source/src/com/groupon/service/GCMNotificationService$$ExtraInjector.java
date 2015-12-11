// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import com.groupon.models.country.Country;

// Referenced classes of package com.groupon.service:
//            GCMNotificationService

public class 
{

    public static void inject(com.f2prateek.dart. , GCMNotificationService gcmnotificationservice, Object obj)
    {
         = ((com.f2prateek.dart.) (.(obj, "countryToBeUnsubscribed")));
        if ( != null)
        {
            gcmnotificationservice.countryToBeUnsubscribed = (Country);
        }
    }

    public ()
    {
    }
}
