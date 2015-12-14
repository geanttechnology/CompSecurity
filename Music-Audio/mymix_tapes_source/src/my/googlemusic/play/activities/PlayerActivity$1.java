// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import my.googlemusic.play.interfaces.Player;

// Referenced classes of package my.googlemusic.play.activities:
//            PlayerActivity

class this._cls0 extends BroadcastReceiver
{

    final PlayerActivity this$0;

    public void onReceive(Context context, Intent intent)
    {
        byte byte0;
        context = intent.getStringExtra("EXTRAS");
        if (context == null || PlayerActivity.access$000(PlayerActivity.this) == null || !PlayerActivity.access$000(PlayerActivity.this).isActive())
        {
            break MISSING_BLOCK_LABEL_285;
        }
        byte0 = -1;
        context.hashCode();
        JVM INSTR lookupswitch 6: default 100
    //                   -1800986711: 197
    //                   -1311235430: 211
    //                   -1231961305: 155
    //                   300620019: 183
    //                   1533127545: 169
    //                   1865311224: 141;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_211;
_L8:
        switch (byte0)
        {
        default:
            return;

        case 0: // '\0'
            PlayerActivity.access$100(PlayerActivity.this);
            return;

        case 1: // '\001'
            PlayerActivity.access$200(PlayerActivity.this, Integer.valueOf(intent.getStringExtra("EXTRAS ADDITIONAL")).intValue());
            return;

        case 2: // '\002'
            PlayerActivity.access$300(PlayerActivity.this);
            return;

        case 3: // '\003'
            PlayerActivity.access$400(PlayerActivity.this);
            return;

        case 4: // '\004'
            PlayerActivity.access$500(PlayerActivity.this);
            return;

        case 5: // '\005'
            PlayerActivity.access$600(PlayerActivity.this);
            break;
        }
        break MISSING_BLOCK_LABEL_284;
_L7:
        if (context.equals("MUSIC PREPARED"))
        {
            byte0 = 0;
        }
          goto _L8
_L4:
        if (context.equals("MUSIC BUFFERING"))
        {
            byte0 = 1;
        }
          goto _L8
_L6:
        if (context.equals("MUSIC CHANGED"))
        {
            byte0 = 2;
        }
          goto _L8
_L5:
        if (context.equals("MUSIC PLAYING"))
        {
            byte0 = 3;
        }
          goto _L8
_L2:
        if (context.equals("MUSIC PAUSED"))
        {
            byte0 = 4;
        }
          goto _L8
        if (context.equals("MUSIC MEDIA PLAYER FINISHED"))
        {
            byte0 = 5;
        }
          goto _L8
        return;
        PlayerActivity.access$700(PlayerActivity.this);
        return;
    }

    ()
    {
        this$0 = PlayerActivity.this;
        super();
    }
}
