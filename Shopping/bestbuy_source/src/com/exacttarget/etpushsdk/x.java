// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk;

import android.content.Context;
import android.content.Intent;
import com.exacttarget.etpushsdk.database.h;
import com.exacttarget.etpushsdk.util.m;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

// Referenced classes of package com.exacttarget.etpushsdk:
//            ETPush, ETPushReceiver

final class x
    implements Runnable
{

    x()
    {
    }

    public void run()
    {
        h.a(ETPush.n());
        Intent intent = new Intent(ETPush.k(), com/exacttarget/etpushsdk/ETPushReceiver);
        intent.putExtra("et_send_type_extra", "et_send_type_registration");
        ETPush.k().sendBroadcast(intent);
        return;
        Object obj;
        obj;
_L2:
        m.c("~!ETPush", ((Exception) (obj)).getMessage(), ((Throwable) (obj)));
        return;
        obj;
        if (true) goto _L2; else goto _L1
_L1:
    }
}
