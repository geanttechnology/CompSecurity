// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.content.Context;
import com.groupon.http.Http;
import com.groupon.network.HttpResponseException;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.service:
//            MarkUsedManager

class val.username extends Http
{

    final MarkUsedManager this$0;
    final String val$id;
    final String val$username;

    protected void onException(Exception exception)
    {
        if ((exception instanceof HttpResponseException) && ((HttpResponseException)exception).getStatusCode() == 400)
        {
            Ln.d("Voucher %s was already redeemed so removing from retry queue", new Object[] {
                val$id
            });
            MarkUsedManager.access$000(MarkUsedManager.this, val$id, val$username);
        }
        Ln.d("Failed to mark voucher %s as used", new Object[] {
            val$id
        });
    }

    protected volatile void onSuccess(Object obj)
        throws Exception
    {
        onSuccess((Void)obj);
    }

    protected void onSuccess(Void void1)
        throws Exception
    {
        MarkUsedManager.access$000(MarkUsedManager.this, val$id, val$username);
        Ln.d("Voucher %s marked as used", new Object[] {
            val$id
        });
    }

    transient ion(String s, Object aobj[], String s1, String s2)
    {
        this$0 = final_markusedmanager;
        val$id = s1;
        val$username = s2;
        super(final_context, Class.this, s, aobj);
    }
}
