// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.receivers;

import android.content.BroadcastReceiver;
import io.presage.Presage;
import io.presage.utils.do.a;

public abstract class AbstractReceiver extends BroadcastReceiver
{

    private a a;

    public AbstractReceiver()
    {
    }

    public final a a()
    {
        if (a == null)
        {
            a = Presage.getInstance().getWS();
        }
        return a;
    }
}
