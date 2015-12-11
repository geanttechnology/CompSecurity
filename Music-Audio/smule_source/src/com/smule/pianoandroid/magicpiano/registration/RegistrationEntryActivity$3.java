// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.registration;

import com.smule.android.c.a;

// Referenced classes of package com.smule.pianoandroid.magicpiano.registration:
//            RegistrationEntryActivity

class a
    implements Runnable
{

    final RegistrationEntryActivity a;

    public void run()
    {
        if (!RegistrationEntryActivity.g(a))
        {
            return;
        } else
        {
            com.smule.android.c.a.g();
            RegistrationEntryActivity.h(a);
            com.smule.pianoandroid.magicpiano.registration.RegistrationEntryActivity.a(a, false);
            return;
        }
    }

    (RegistrationEntryActivity registrationentryactivity)
    {
        a = registrationentryactivity;
        super();
    }
}
