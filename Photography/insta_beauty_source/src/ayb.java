// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.Message;
import com.fotoable.tgifview.TGifView;

public class ayb extends Handler
{

    final TGifView a;

    public ayb(TGifView tgifview)
    {
        a = tgifview;
        super();
    }

    public void handleMessage(Message message)
    {
        a.invalidate();
    }
}
