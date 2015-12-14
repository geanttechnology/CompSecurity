// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;


// Referenced classes of package com.millennialmedia.android:
//            NVASpeechKit

class a
    implements Runnable
{

    private NVASpeechKit a;

    public void run()
    {
        a.endRecording();
    }

    (NVASpeechKit nvaspeechkit)
    {
        a = nvaspeechkit;
        super();
    }
}
