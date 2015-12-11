// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.internal;

import com.google.android.speech.callback.RecognitionEngineCallback;
import com.google.android.speech.embedded.Greco3Callback;
import com.google.android.speech.embedded.Greco3CallbackFactory;
import com.google.android.speech.embedded.Greco3Mode;

// Referenced classes of package com.google.android.speech.internal:
//            Greco3CallbackImpl

public class DefaultCallbackFactory
    implements Greco3CallbackFactory
{

    public DefaultCallbackFactory()
    {
    }

    public Greco3Callback create(RecognitionEngineCallback recognitionenginecallback, Greco3Mode greco3mode)
    {
        return new Greco3CallbackImpl(greco3mode, recognitionenginecallback);
    }
}
