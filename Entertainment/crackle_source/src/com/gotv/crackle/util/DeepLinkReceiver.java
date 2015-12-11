// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.gotv.crackle.DetailsActivityResolver;
import com.gotv.crackle.LoadingActivity;

// Referenced classes of package com.gotv.crackle.util:
//            Log

public class DeepLinkReceiver extends BroadcastReceiver
{

    private static final String TAG = "DeepLinkReceiver";

    public DeepLinkReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        Log.d("DeepLinkReceiver", (new StringBuilder()).append("onReceive : action = ").append(intent.getAction()).toString());
        String s = intent.getStringExtra("mId");
        String s1 = intent.getStringExtra("chId");
        Log.d("DeepLinkReceiver", (new StringBuilder()).append("onReceive : mediaId = ").append(s).toString());
        Log.d("DeepLinkReceiver", (new StringBuilder()).append("onReceive : channelId = ").append(s1).toString());
        if (s != null)
        {
            Intent intent1 = new Intent(context, com/gotv/crackle/DetailsActivityResolver);
            intent1.setAction(intent.getAction());
            intent1.putExtra("MEDIA_ITEM_ID", s);
            intent = intent1;
        } else
        if (s1 != null)
        {
            Intent intent2 = new Intent(context, com/gotv/crackle/DetailsActivityResolver);
            intent2.setAction(intent.getAction());
            intent2.putExtra("ID", s1);
            intent = intent2;
        } else
        {
            intent = new Intent(context, com/gotv/crackle/LoadingActivity);
        }
        intent.setFlags(0x10000000);
        context.startActivity(intent);
    }
}
