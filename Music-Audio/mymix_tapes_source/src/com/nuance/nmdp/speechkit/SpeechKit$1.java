// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit;

import android.content.res.AssetFileDescriptor;
import d;

// Referenced classes of package com.nuance.nmdp.speechkit:
//            SpeechKit

final class b
    implements Runnable
{

    private d a;
    private AssetFileDescriptor b;

    public final void run()
    {
        a.a(b);
    }

    r(d d1, AssetFileDescriptor assetfiledescriptor)
    {
        a = d1;
        b = assetfiledescriptor;
        super();
    }
}
