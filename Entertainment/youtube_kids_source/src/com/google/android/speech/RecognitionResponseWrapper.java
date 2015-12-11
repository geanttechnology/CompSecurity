// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech;

import com.google.android.speech.callback.Callback;
import daj;
import dap;
import exf;

public class RecognitionResponseWrapper
    implements Callback
{

    final Callback mCallback;
    final int mEngine;

    public RecognitionResponseWrapper(Callback callback, int i)
    {
        mCallback = callback;
        mEngine = i;
    }

    public void onError(dap dap1)
    {
        int i = mEngine;
        mCallback.onError(dap1);
    }

    public volatile void onError(Object obj)
    {
        onError((dap)obj);
    }

    public void onResult(exf exf1)
    {
        mCallback.onResult(daj.a(mEngine, exf1));
    }

    public volatile void onResult(Object obj)
    {
        onResult((exf)obj);
    }
}
