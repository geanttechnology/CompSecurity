// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.events.activity;

import android.content.Context;
import android.os.Bundle;

public class OnCreateEvent
{

    protected final Context context;
    protected final Bundle savedInstanceState;

    public OnCreateEvent(Context context1, Bundle bundle)
    {
        savedInstanceState = bundle;
        context = context1;
    }

    public Context getContext()
    {
        return context;
    }

    public Bundle getSavedInstanceState()
    {
        return savedInstanceState;
    }
}
