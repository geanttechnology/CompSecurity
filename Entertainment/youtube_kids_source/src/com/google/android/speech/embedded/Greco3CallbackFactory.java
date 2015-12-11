// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.embedded;

import com.google.android.speech.callback.RecognitionEngineCallback;

// Referenced classes of package com.google.android.speech.embedded:
//            Greco3Mode, Greco3Callback

public interface Greco3CallbackFactory
{

    public abstract Greco3Callback create(RecognitionEngineCallback recognitionenginecallback, Greco3Mode greco3mode);
}
