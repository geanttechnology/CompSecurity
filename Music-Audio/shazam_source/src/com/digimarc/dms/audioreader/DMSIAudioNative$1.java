// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms.audioreader;


// Referenced classes of package com.digimarc.dms.audioreader:
//            DMSIAudioNative

class val.factoryType
    implements Runnable
{

    final DMSIAudioNative this$0;
    final int val$factoryType;

    public void run()
    {
        DMSIAudioNative.access$002(DMSIAudioNative.this, Thread.currentThread());
        (new StringBuilder("Read, factory=")).append(val$factoryType);
        DMSIAudioNative.access$100(DMSIAudioNative.this, val$factoryType);
    }

    ()
    {
        this$0 = final_dmsiaudionative;
        val$factoryType = I.this;
        super();
    }
}
