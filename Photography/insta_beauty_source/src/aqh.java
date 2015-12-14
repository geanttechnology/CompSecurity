// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.Message;
import com.fotoable.homewall.THomewallView;

public class aqh extends Handler
{

    final THomewallView a;

    public aqh(THomewallView thomewallview)
    {
        a = thomewallview;
        super();
    }

    public void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            return;

        case 19: // '\023'
            THomewallView.access$100(a);
            break;
        }
    }
}
