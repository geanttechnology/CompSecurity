// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.bouncycastle.jce.provider;

import org.bouncycastle.crypto.engines.SkipjackEngine;
import org.bouncycastle.crypto.modes.OFBBlockCipher;

// Referenced classes of package org.bouncycastle.jce.provider:
//            JCEStreamCipher

public class A extends JCEStreamCipher
{

    public A()
    {
        super(new OFBBlockCipher(new SkipjackEngine(), 8), 64);
    }
}
