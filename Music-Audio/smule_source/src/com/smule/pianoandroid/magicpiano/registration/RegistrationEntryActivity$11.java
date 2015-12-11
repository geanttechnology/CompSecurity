// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.registration;

import android.content.DialogInterface;
import com.smule.android.c.a;

// Referenced classes of package com.smule.pianoandroid.magicpiano.registration:
//            RegistrationEntryActivity, e

class a
    implements android.content.ner
{

    final RegistrationEntryActivity a;

    public void onCancel(DialogInterface dialoginterface)
    {
        com.smule.android.c.a.i();
        a.finish();
        e.b(a);
    }

    Q(RegistrationEntryActivity registrationentryactivity)
    {
        a = registrationentryactivity;
        super();
    }
}
