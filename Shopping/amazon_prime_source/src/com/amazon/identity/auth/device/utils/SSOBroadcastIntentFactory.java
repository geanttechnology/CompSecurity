// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import android.content.Intent;

public final class SSOBroadcastIntentFactory
{

    public static Intent createIntent(String s)
    {
        Intent intent = new Intent();
        intent.setFlags(32);
        intent.setAction(s);
        return intent;
    }
}
