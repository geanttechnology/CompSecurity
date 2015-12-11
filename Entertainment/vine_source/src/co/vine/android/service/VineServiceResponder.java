// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.service;

import android.os.Binder;
import android.os.Bundle;

public abstract class VineServiceResponder extends Binder
{

    public VineServiceResponder()
    {
    }

    public abstract void onServiceResponse(int i, int j, String s, Bundle bundle);
}
