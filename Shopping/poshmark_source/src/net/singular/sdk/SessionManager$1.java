// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.singular.sdk;

import org.json.JSONObject;

// Referenced classes of package net.singular.sdk:
//            SessionManager, SingularLog, Controller

class val.session_end_event
    implements Runnable
{

    final SessionManager this$0;
    final JSONObject val$session_end_event;

    public void run()
    {
        try
        {
            SessionManager.access$000(SessionManager.this).d("singular_sdk", "SessionManager: delayed Runnable started");
            SessionManager.access$100(SessionManager.this).postEventNow(val$session_end_event);
            SessionManager.access$200(SessionManager.this);
            SessionManager.access$302(SessionManager.this, null);
            return;
        }
        catch (RuntimeException runtimeexception)
        {
            SessionManager.access$000(SessionManager.this).e("singular_sdk", "SessionManager:onPause() failed", runtimeexception);
        }
    }

    ()
    {
        this$0 = final_sessionmanager;
        val$session_end_event = JSONObject.this;
        super();
    }
}
