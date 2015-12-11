// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.storage;

import android.util.Base64;

// Referenced classes of package com.amazon.identity.auth.device.storage:
//            AbstractTokenEncryptor, AccountManagerDataMigrationHelper

private static class mEncryptionKeyBytes extends AbstractTokenEncryptor
{

    private final byte mEncryptionKeyBytes[];

    protected byte[] getEncryptionKey()
    {
        return mEncryptionKeyBytes;
    }

    public q(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("EncryptionKeyCannotBeNull");
        } else
        {
            mEncryptionKeyBytes = Base64.decode(s, 0);
            return;
        }
    }
}
