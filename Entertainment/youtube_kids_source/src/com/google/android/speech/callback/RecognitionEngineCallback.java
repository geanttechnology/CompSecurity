// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.callback;


// Referenced classes of package com.google.android.speech.callback:
//            Callback

public interface RecognitionEngineCallback
    extends Callback
{

    public abstract void onProgressUpdate(int i, long l);
}
