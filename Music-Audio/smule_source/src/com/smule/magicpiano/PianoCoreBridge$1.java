// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.magicpiano;

import com.crittercism.app.Crittercism;

// Referenced classes of package com.smule.magicpiano:
//            PianoCoreBridge

final class a
    implements Runnable
{

    final int a;

    public void run()
    {
        Crittercism.a(new Exception((new StringBuilder()).append("jni exception, couldn't load midi: ").append(PianoCoreBridge.sFilePath).append(" error code ").append(a).toString()));
    }

    (int i)
    {
        a = i;
        super();
    }
}
