// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.sdk.availability;

import org.json.JSONObject;

interface EncryptionManager
{

    public abstract String decrypt(byte abyte0[]);

    public abstract byte[] encrypt(JSONObject jsonobject);

    public abstract String getEncryptionAlgorithm();

    public abstract String getKey();
}
