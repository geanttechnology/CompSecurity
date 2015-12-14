// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.SystemClock;
import com.fotoable.tgifview.TGifView;

public class pg extends Thread
{

    final TGifView a;

    private pg(TGifView tgifview)
    {
        a = tgifview;
        super();
    }

    public pg(TGifView tgifview, com.fotoable.tgifview.TGifView._cls1 _pcls1)
    {
        this(tgifview);
    }

    public void run()
    {
        if (TGifView.access$100(a) != null) goto _L2; else goto _L1
_L1:
        long l;
        long l1;
        do
        {
            return;
        } while (TGifView.access$600(a) == null);
        obj = TGifView.access$600(a).obtainMessage();
        TGifView.access$600(a).sendMessage(((android.os.Message) (obj)));
        SystemClock.sleep(l1);
_L2:
        if (!TGifView.access$200(a)) goto _L1; else goto _L3
_L3:
label0:
        {
            if (TGifView.access$300(a))
            {
                break label0;
            }
            obj = TGifView.access$100(a).d();
            if (obj == null)
            {
                return;
            }
        }
        TGifView.access$402(a, ((pf) (obj)).a);
        l1 = ((pf) (obj)).b;
        l = l1;
        if (l1 == 0L)
        {
            l = 100L;
        }
        l1 = l;
        if (TGifView.access$500(a))
        {
            l1 = l;
            if (TGifView.access$100(a).b() > 0)
            {
                l1 = 1000 / TGifView.access$100(a).b();
            }
        }
        continue;
        SystemClock.sleep(100L);
          goto _L2
    }
}
