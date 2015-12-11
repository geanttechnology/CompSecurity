// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.util.Log;
import android.view.View;
import co.vine.android.client.Session;

// Referenced classes of package co.vine.android:
//            DebugHomeActivity

class val.session
    implements android.view.
{

    final DebugHomeActivity this$0;
    final Session val$session;

    public void onClick(View view)
    {
        Log.d("VINEDEBUG", (new StringBuilder()).append("vine-session-id: ").append(val$session.getSessionKey()).toString());
    }

    ()
    {
        this$0 = final_debughomeactivity;
        val$session = Session.this;
        super();
    }
}
