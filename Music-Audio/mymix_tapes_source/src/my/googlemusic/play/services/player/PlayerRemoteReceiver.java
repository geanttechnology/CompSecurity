// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.services.player;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import my.googlemusic.play.interfaces.Player;

public class PlayerRemoteReceiver extends BroadcastReceiver
{

    private static Player sPlayer;

    public PlayerRemoteReceiver()
    {
    }

    public static void setPlayer(Player player)
    {
        sPlayer = player;
    }

    public void onReceive(Context context, Intent intent)
    {
        if (sPlayer == null || !sPlayer.isActive() || !"android.intent.action.MEDIA_BUTTON".equals(intent.getAction())) goto _L2; else goto _L1
_L1:
        context = (KeyEvent)intent.getParcelableExtra("android.intent.extra.KEY_EVENT");
        if (context.getAction() == 0) goto _L3; else goto _L2
_L2:
        return;
_L3:
        switch (context.getKeyCode())
        {
        default:
            return;

        case 79: // 'O'
        case 85: // 'U'
            if (sPlayer.isPlaying())
            {
                sPlayer.pause();
                return;
            }
            continue; /* Loop/switch isn't completed */

        case 86: // 'V'
            sPlayer.pause();
            return;

        case 126: // '~'
            sPlayer.play();
            return;

        case 127: // '\177'
            sPlayer.pause();
            return;

        case 87: // 'W'
            sPlayer.next();
            return;

        case 88: // 'X'
            sPlayer.previous();
            return;
        }
        if (!sPlayer.isPaused()) goto _L2; else goto _L4
_L4:
        sPlayer.play();
        return;
    }
}
