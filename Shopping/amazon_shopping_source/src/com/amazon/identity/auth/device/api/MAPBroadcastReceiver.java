// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import android.accounts.Account;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.amazon.identity.auth.accounts.AmazonAccountManager;
import com.amazon.identity.auth.device.utils.BackwardsCompatiabilityHelper;
import com.amazon.identity.auth.device.utils.ThreadUtils;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            MAPAccountManager

public abstract class MAPBroadcastReceiver extends BroadcastReceiver
{

    private static final Set ACCOUNT_ADDED_ACTIONS;
    private static final Set ACCOUNT_REMOVED_ACTIONS;
    private static final String TAG = com/amazon/identity/auth/device/api/MAPBroadcastReceiver.getName();

    public MAPBroadcastReceiver()
    {
    }

    public static Intent constructBackwardsCompatibleIntent(Context context, Intent intent)
    {
        if (intent != null) goto _L2; else goto _L1
_L1:
        intent = null;
_L4:
        return intent;
_L2:
        Intent intent1;
        String s;
        intent1 = new Intent(intent);
        s = intent1.getAction();
        if (!ACCOUNT_ADDED_ACTIONS.contains(s) && !ACCOUNT_REMOVED_ACTIONS.contains(s))
        {
            break; /* Loop/switch isn't completed */
        }
        intent = intent1;
        if (intent1.getStringExtra("com.amazon.dcp.sso.extra.account.directed_id") == null)
        {
            if (ACCOUNT_REMOVED_ACTIONS.contains(intent1.getAction()))
            {
                return null;
            } else
            {
                intent1.putExtra("com.amazon.dcp.sso.extra.account.directed_id", BackwardsCompatiabilityHelper.getDirectedId(context, intent1.getStringExtra("com.amazon.dcp.sso.extra.account.type"), intent1.getStringExtra("com.amazon.dcp.sso.extra.account.name")));
                return intent1;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (!"com.amazon.dcp.sso.action.AmazonAccountPropertyService.property.changed".equals(s))
        {
            break; /* Loop/switch isn't completed */
        }
        intent = intent1;
        if (intent1.getStringExtra("new.account.property.changed") == null)
        {
            s = BackwardsCompatiabilityHelper.getDirectedId(context, (Account)intent1.getParcelableExtra("account.property.changed"));
            intent = s;
            if (s == null)
            {
                intent = (new MAPAccountManager(context)).getAccount();
            }
            intent1.putExtra("new.account.property.changed", intent);
            return intent1;
        }
        if (true) goto _L4; else goto _L5
_L5:
        intent = intent1;
        if ("com.amazon.dcp.sso.broadcast.CORPFMHasChanged".equals(s))
        {
            intent = intent1;
            if (intent1.getStringExtra("new.account.property.changed") == null)
            {
                intent1.putExtra("new.account.property.changed", (new AmazonAccountManager(context)).getDevicePrimaryAmazonAccount());
                return intent1;
            }
        }
        if (true) goto _L4; else goto _L6
_L6:
    }

    protected abstract void backwardsCompatibleOnReceive(Context context, Intent intent);

    public final void onReceive(final Context context, final Intent intent)
    {
        ThreadUtils.submitToBackgroundThread(new Runnable() {

            final MAPBroadcastReceiver this$0;
            final Context val$context;
            final Intent val$intent;

            public void run()
            {
                Intent intent1 = MAPBroadcastReceiver.constructBackwardsCompatibleIntent(context, intent);
                if (intent1 == null)
                {
                    String _tmp = MAPBroadcastReceiver.TAG;
                    intent.getAction();
                    return;
                } else
                {
                    backwardsCompatibleOnReceive(context, intent1);
                    return;
                }
            }

            
            {
                this$0 = MAPBroadcastReceiver.this;
                context = context1;
                intent = intent1;
                super();
            }
        });
    }

    static 
    {
        HashSet hashset = new HashSet();
        ACCOUNT_ADDED_ACTIONS = hashset;
        hashset.add("com.amazon.dcp.sso.action.account.added");
        ACCOUNT_ADDED_ACTIONS.add("com.amazon.dcp.sso.action.secondary.account.added");
        hashset = new HashSet();
        ACCOUNT_REMOVED_ACTIONS = hashset;
        hashset.add("com.amazon.dcp.sso.action.account.removed");
        ACCOUNT_REMOVED_ACTIONS.add("com.amazon.dcp.sso.action.secondary.account.removed");
    }

}
