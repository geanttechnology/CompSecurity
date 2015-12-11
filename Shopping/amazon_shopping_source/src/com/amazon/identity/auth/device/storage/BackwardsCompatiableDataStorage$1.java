// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.storage;

import android.util.Base64;

// Referenced classes of package com.amazon.identity.auth.device.storage:
//            AbstractTokenEncryptor, BackwardsCompatiableDataStorage

class val.encryptKey extends AbstractTokenEncryptor
{

    final BackwardsCompatiableDataStorage this$0;
    final String val$encryptKey;

    protected byte[] getEncryptionKey()
    {
        return Base64.decode(val$encryptKey, 0);
    }

    ()
    {
        this$0 = final_backwardscompatiabledatastorage;
        val$encryptKey = String.this;
        super();
    }
}
