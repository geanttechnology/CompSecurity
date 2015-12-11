// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import com.edisonwang.android.slog.SLog;

// Referenced classes of package co.vine.android:
//            ConversationActivity

class > extends BroadcastReceiver
{

    final ConversationActivity this$0;

    public void onReceive(Context context, Intent intent)
    {
        boolean flag;
        try
        {
            context = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            SLog.e("We are not gangsta enough to acess the connectivity state.", context);
            return;
        }
        if (context == null) goto _L2; else goto _L1
_L1:
        if (!context.isConnected()) goto _L2; else goto _L3
_L3:
        flag = true;
_L5:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_72;
        }
        if (ConversationActivity.access$300(ConversationActivity.this) != flag)
        {
            SLog.dWithTag("ConvActivity;RTC", "Connectivity change received, reconnecting");
            ConversationActivity.access$500(ConversationActivity.this).removeCallbacks(ConversationActivity.access$400(ConversationActivity.this));
            ConversationActivity.access$600(ConversationActivity.this);
        }
        ConversationActivity.access$302(ConversationActivity.this, flag);
        return;
_L2:
        flag = false;
        if (true) goto _L5; else goto _L4
_L4:
    }

    ()
    {
        this$0 = ConversationActivity.this;
        super();
    }
}
