// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.chromium.net;

import java.security.PrivateKey;

// Referenced classes of package org.chromium.net:
//            AndroidPrivateKey, DefaultAndroidKeyStore, AndroidKeyStore

class 
    implements AndroidPrivateKey
{

    final PrivateKey a;
    private DefaultAndroidKeyStore b;

    public AndroidKeyStore getKeyStore()
    {
        return b;
    }
}
