// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.Message;
import com.fotoable.beautyui.SlideSwitch;

public class ki extends Handler
{

    final SlideSwitch a;

    public ki(SlideSwitch slideswitch)
    {
        a = slideswitch;
        super();
    }

    public void handleMessage(Message message)
    {
        if (message.what == 1)
        {
            SlideSwitch.access$000(a).a();
            return;
        } else
        {
            SlideSwitch.access$000(a).b();
            return;
        }
    }
}
