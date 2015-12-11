// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.magicpiano;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import java.util.TimerTask;

// Referenced classes of package com.smule.magicpiano:
//            PianoCoreBridge

final class a extends TimerTask
{

    final Intent a;

    public void run()
    {
        if (PianoCoreBridge.sChallenge)
        {
            if (PianoCoreBridge.access$000() != null)
            {
                PianoCoreBridge.access$000().startActivity(a);
                ((Activity)PianoCoreBridge.access$000()).finish();
            }
        } else
        if (PianoCoreBridge.access$000() != null)
        {
            ((Activity)PianoCoreBridge.access$000()).startActivityForResult(a, 2);
            return;
        }
    }

    (Intent intent)
    {
        a = intent;
        super();
    }
}
