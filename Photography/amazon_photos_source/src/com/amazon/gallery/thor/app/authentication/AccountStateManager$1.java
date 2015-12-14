// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.authentication;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.amazon.gallery.foundation.utils.log.GLogger;

// Referenced classes of package com.amazon.gallery.thor.app.authentication:
//            AccountStateManager

class val.context
    implements Runnable
{

    final AccountStateManager this$0;
    final Context val$context;
    final Intent val$intent;

    public void run()
    {
        if ("com.amazon.dcp.sso.action.account.removed".equals(val$intent.getAction()))
        {
            GLogger.i(AccountStateManager.access$000(), "Received Primary Account Removed broadcast.", new Object[0]);
            removeAccount(val$context);
        } else
        {
            if ("com.amazon.dcp.sso.action.secondary.account.removed".equals(val$intent.getAction()))
            {
                GLogger.i(AccountStateManager.access$000(), "Received Secondary Account Removed broadcast.", new Object[0]);
                AccountStateManager.access$100(AccountStateManager.this, val$context, val$intent.getStringExtra("com.amazon.dcp.sso.property.account.acctId"));
                return;
            }
            if ("com.amazon.kindle.tablet.do_ftue".equals(val$intent.getAction()) && AccountStateManager.access$200().equals(val$intent.getData()))
            {
                GLogger.i(AccountStateManager.access$000(), "Received Do FTUE broadcast.", new Object[0]);
                return;
            }
            if ("com.amazon.kindle.tablet.ftue_free_for_all".equals(val$intent.getAction()))
            {
                GLogger.i(AccountStateManager.access$000(), "Received FTUE Free for All broadcast.", new Object[0]);
                registerAccount(val$context);
                return;
            }
            if ("com.amazon.clouddrive.photos.do_setup_account".equals(val$intent.getAction()))
            {
                GLogger.i(AccountStateManager.access$000(), "Received AOSP setup account broadcast. Setting up account and starting first time sync", new Object[0]);
                AccountStateManager.access$400(AccountStateManager.this, val$context, AccountStateManager.access$300(AccountStateManager.this, val$context.getApplicationContext()));
                return;
            }
        }
    }

    ()
    {
        this$0 = final_accountstatemanager;
        val$intent = intent1;
        val$context = Context.this;
        super();
    }
}
