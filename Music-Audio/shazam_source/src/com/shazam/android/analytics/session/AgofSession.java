// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.session;

import android.content.Context;

public interface AgofSession
{

    public abstract void initSession(Context context);

    public abstract void onActivityStart();

    public abstract void onActivityStop();

    public abstract void sendLoggedEvents();

    public abstract void viewAppeared(String s);
}
