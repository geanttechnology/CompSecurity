// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.Message;
import com.fotoable.homewall.THomewallView;
import java.util.TimerTask;

public class kr extends TimerTask
{

    final THomewallView a;

    public kr(THomewallView thomewallview)
    {
        a = thomewallview;
        super();
    }

    public void run()
    {
        Message message = new Message();
        message.what = 19;
        a.handler.sendMessage(message);
    }
}
