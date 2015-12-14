// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.cds;

import android.accounts.AccountManager;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.content.Context;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.thor.syncframework.MetadataSyncScheduler;
import java.io.IOException;

// Referenced classes of package com.amazon.gallery.thor.cds:
//            CDSSyncManager

class this._cls0
    implements Runnable
{

    final CDSSyncManager this$0;

    public void run()
    {
        this;
        JVM INSTR monitorenter ;
        AccountManager accountmanager;
        CDSSyncManager.access$902(CDSSyncManager.this, null);
        stopSync();
        accountmanager = (AccountManager)CDSSyncManager.access$600(CDSSyncManager.this).getSystemService("account");
        if (CDSSyncManager.access$1000(CDSSyncManager.this) != null)
        {
            accountmanager.removeAccount(CDSSyncManager.access$1000(CDSSyncManager.this).getSyncAccount(), null, null).getResult();
        }
_L2:
        CDSSyncManager.access$1002(CDSSyncManager.this, null);
        this;
        JVM INSTR monitorexit ;
        return;
_L3:
        Object obj;
        GLogger.ex(CDSSyncManager.access$400(), "Could not remove account.", ((Throwable) (obj)));
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        obj;
          goto _L3
        obj;
          goto _L3
        obj;
          goto _L3
    }

    er()
    {
        this$0 = CDSSyncManager.this;
        super();
    }
}
