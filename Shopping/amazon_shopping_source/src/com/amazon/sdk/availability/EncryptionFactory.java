// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.sdk.availability;


// Referenced classes of package com.amazon.sdk.availability:
//            EncryptionManagerImpl, Logger, EncryptionManager

final class EncryptionFactory
{

    private EncryptionFactory()
    {
    }

    public static EncryptionManager getEncryptionManager(String s, String s1)
    {
        try
        {
            s = new EncryptionManagerImpl(s, s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Logger.e("could not create encryption manager", s);
            return null;
        }
        return s;
    }
}
