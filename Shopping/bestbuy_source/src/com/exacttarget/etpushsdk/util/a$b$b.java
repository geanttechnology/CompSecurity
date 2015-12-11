// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.util;

import java.security.Provider;

class put extends Provider
{

    public ()
    {
        super("LinuxPRNG", 1.0D, "A Linux-specific random number provider that uses /dev/urandom");
        put("SecureRandom.SHA1PRNG", com/exacttarget/etpushsdk/util/a$b$a.getName());
        put("SecureRandom.SHA1PRNG ImplementedIn", "Software");
    }
}
