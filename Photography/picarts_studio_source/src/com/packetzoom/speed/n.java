// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.packetzoom.speed;

import android.content.SharedPreferences;
import android.util.Log;

// Referenced classes of package com.packetzoom.speed:
//            Session

class n
    implements Runnable
{

    final SharedPreferences a_android_content_SharedPreferences_fld;
    final Session a_com_packetzoom_speed_Session_fld;

    n(Session session, SharedPreferences sharedpreferences)
    {
        a_com_packetzoom_speed_Session_fld = session;
        a_android_content_SharedPreferences_fld = sharedpreferences;
        super();
    }

    public void run()
    {
        Session session = a_com_packetzoom_speed_Session_fld;
        session;
        JVM INSTR monitorenter ;
        Session.a(a_com_packetzoom_speed_Session_fld, a_com_packetzoom_speed_Session_fld.init(a_android_content_SharedPreferences_fld, Session.a(a_com_packetzoom_speed_Session_fld), Session.b(a_com_packetzoom_speed_Session_fld), Session.c(a_com_packetzoom_speed_Session_fld), Session.d(a_com_packetzoom_speed_Session_fld)));
_L1:
        return;
        Object obj;
        obj;
        ((Exception) (obj)).printStackTrace();
        Log.e("libpz", (new StringBuilder("session init failed:")).append(((Exception) (obj)).getMessage()).toString());
          goto _L1
        obj;
        session;
        JVM INSTR monitorexit ;
        throw obj;
    }
}
