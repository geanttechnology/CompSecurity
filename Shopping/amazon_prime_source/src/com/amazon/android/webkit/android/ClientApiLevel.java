// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit.android;

import android.util.Log;

class ClientApiLevel
{

    private static final String TAG = com/amazon/android/webkit/android/ClientApiLevel.getName();
    private static ClientApiLevel instance = null;
    private int apiLevel;

    private ClientApiLevel()
    {
    }

    static ClientApiLevel getInstance()
    {
        return instance;
    }

    static void initialize()
    {
        instance = new ClientApiLevel();
        instance.setApiLevel(1);
    }

    int getApiLevel()
    {
        return apiLevel;
    }

    void setApiLevel(int i)
        throws IllegalArgumentException
    {
        if (i < 1 || i > 4)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid apiLevel (").append(i).append(")").toString());
        } else
        {
            apiLevel = i;
            Log.i(TAG, (new StringBuilder()).append("Client API Level:").append(i).toString());
            return;
        }
    }

}
