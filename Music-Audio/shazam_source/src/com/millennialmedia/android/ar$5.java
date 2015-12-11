// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;


// Referenced classes of package com.millennialmedia.android:
//            ar, ao

final class a
    implements a
{

    final ar a;

    public final void a(double d)
    {
        ao ao1 = a.a();
        if (ao1 != null)
        {
            ao1.loadUrl((new StringBuilder("javascript:MMJS.sdk.audioLevelChange(")).append(d).append(")").toString());
        }
    }

    public final void a(adUrl adurl)
    {
        a[adurl.ordinal()];
        JVM INSTR tableswitch 1 5: default 44
    //                   1 45
    //                   2 64
    //                   3 83
    //                   4 102
    //                   5 121;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        return;
_L2:
        if ((adurl = a.a()) != null)
        {
            adurl.loadUrl("javascript:MMJS.sdk.voiceStateChange('error')");
            return;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        adurl = a.a();
        if (adurl != null)
        {
            adurl.loadUrl("javascript:MMJS.sdk.voiceStateChange('processing')");
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
        adurl = a.a();
        if (adurl != null)
        {
            adurl.loadUrl("javascript:MMJS.sdk.voiceStateChange('ready')");
            return;
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L5:
        adurl = a.a();
        if (adurl != null)
        {
            adurl.loadUrl("javascript:MMJS.sdk.voiceStateChange('recording')");
            return;
        }
        if (true) goto _L1; else goto _L6
_L6:
        adurl = a.a();
        if (adurl != null)
        {
            adurl.loadUrl("javascript:MMJS.sdk.voiceStateChange('vocalizing')");
            return;
        }
        if (true) goto _L1; else goto _L7
_L7:
    }

    (ar ar1)
    {
        a = ar1;
        super();
    }
}
