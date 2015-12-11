// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.service;

import android.os.Bundle;

public class PendingAction
{

    public final int actionCode;
    public final Bundle bundle;

    public PendingAction(int i, Bundle bundle1)
    {
        if (bundle1 == null)
        {
            throw new IllegalArgumentException("Bundle cannot be null.");
        } else
        {
            actionCode = i;
            bundle = bundle1;
            return;
        }
    }
}
