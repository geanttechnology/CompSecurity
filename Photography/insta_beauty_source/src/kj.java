// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import com.fotoable.beautyui.SlideSwitch;

public class kj
    implements Runnable
{

    final boolean a;
    final Handler b;
    final SlideSwitch c;

    public kj(SlideSwitch slideswitch, boolean flag, Handler handler)
    {
        c = slideswitch;
        a = flag;
        b = handler;
        super();
    }

    public void run()
    {
        if (!a) goto _L2; else goto _L1
_L1:
        while (SlideSwitch.access$100(c) <= SlideSwitch.access$200(c)) 
        {
            SlideSwitch.access$302(c, (int)(((float)SlideSwitch.access$100(c) * 255F) / (float)SlideSwitch.access$200(c)));
            SlideSwitch.access$400(c);
            SlideSwitch.access$102(c, SlideSwitch.access$100(c) + 3);
            try
            {
                Thread.sleep(3L);
            }
            catch (InterruptedException interruptedexception)
            {
                interruptedexception.printStackTrace();
            }
        }
        SlideSwitch.access$302(c, 255);
        SlideSwitch.access$102(c, SlideSwitch.access$200(c));
        SlideSwitch.access$502(c, SlideSwitch.access$200(c));
        if (!SlideSwitch.access$600(c)) goto _L4; else goto _L3
_L3:
        return;
_L4:
        SlideSwitch.access$602(c, true);
        if (SlideSwitch.access$000(c) != null)
        {
            b.sendEmptyMessage(1);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        while (SlideSwitch.access$100(c) >= SlideSwitch.access$700(c)) 
        {
            SlideSwitch.access$302(c, (int)(((float)SlideSwitch.access$100(c) * 255F) / (float)SlideSwitch.access$200(c)));
            SlideSwitch.access$400(c);
            SlideSwitch.access$102(c, SlideSwitch.access$100(c) - 3);
            try
            {
                Thread.sleep(3L);
            }
            catch (InterruptedException interruptedexception1)
            {
                interruptedexception1.printStackTrace();
            }
        }
        SlideSwitch.access$302(c, 0);
        SlideSwitch.access$102(c, SlideSwitch.access$700(c));
        SlideSwitch.access$502(c, SlideSwitch.access$700(c));
        if (SlideSwitch.access$600(c))
        {
            SlideSwitch.access$602(c, false);
            if (SlideSwitch.access$000(c) != null)
            {
                b.sendEmptyMessage(0);
                return;
            }
        }
        if (true) goto _L3; else goto _L5
_L5:
    }
}
