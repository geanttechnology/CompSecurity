// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.utils.pushnotification;

import android.content.Context;
import android.content.Intent;
import com.parse.ParsePushBroadcastReceiver;
import java.io.PrintStream;
import my.googlemusic.play.activities.LoginActivity;

public class ParseReceiver extends ParsePushBroadcastReceiver
{

    public ParseReceiver()
    {
    }

    public void onPushOpen(Context context, Intent intent)
    {
        Intent intent1 = new Intent(context, my/googlemusic/play/activities/LoginActivity);
        intent1.putExtras(intent.getExtras());
        intent1.setFlags(0x10008000);
        context.startActivity(intent1);
    }

    public void onReceive(Context context, Intent intent)
    {
        super.onReceive(context, intent);
        System.out.println("Notification received from - PARSE");
    }
}
