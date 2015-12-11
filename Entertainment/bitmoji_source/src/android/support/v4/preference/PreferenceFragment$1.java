// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.preference;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package android.support.v4.preference:
//            PreferenceFragment

class this._cls0 extends Handler
{

    final PreferenceFragment this$0;

    public void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            return;

        case 1: // '\001'
            PreferenceFragment.access$000(PreferenceFragment.this);
            break;
        }
    }

    ()
    {
        this$0 = PreferenceFragment.this;
        super();
    }
}
