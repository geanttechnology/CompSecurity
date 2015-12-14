// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.tgifview;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.fotoable.tgifview:
//            TGifView

public class a extends Handler
{

    final TGifView a;

    public void handleMessage(Message message)
    {
        a.invalidate();
    }

    (TGifView tgifview)
    {
        a = tgifview;
        super();
    }
}
