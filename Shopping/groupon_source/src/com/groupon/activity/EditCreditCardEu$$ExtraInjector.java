// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.os.Bundle;
import com.groupon.Channel;

// Referenced classes of package com.groupon.activity:
//            EditCreditCardEu

public class 
{

    public static void inject(com.f2prateek.dart.r r, EditCreditCardEu editcreditcardeu, Object obj)
    {
        ject(r, editcreditcardeu, obj);
        Object obj1 = r.inject(obj, "channel");
        if (obj1 != null)
        {
            editcreditcardeu.channel = (Channel)obj1;
        }
        r = ((com.f2prateek.dart.inject) (r.inject(obj, "creditCardConsentRequirements")));
        if (r != null)
        {
            editcreditcardeu.storageConsentRequirements = (Bundle)r;
        }
    }

    public ()
    {
    }
}
