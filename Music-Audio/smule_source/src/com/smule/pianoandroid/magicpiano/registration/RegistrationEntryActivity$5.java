// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.registration;

import com.smule.pianoandroid.magicpiano.b.h;

// Referenced classes of package com.smule.pianoandroid.magicpiano.registration:
//            RegistrationEntryActivity

class a
    implements Runnable
{

    final RegistrationEntryActivity a;

    public void run()
    {
        (new h(a, RegistrationEntryActivity.i(a), Boolean.valueOf(false))).execute(new Void[0]);
    }

    (RegistrationEntryActivity registrationentryactivity)
    {
        a = registrationentryactivity;
        super();
    }
}
