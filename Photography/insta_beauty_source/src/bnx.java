// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import com.wantu.service.gif.play.GifView;

public class bnx extends Handler
{

    final GifView a;

    public bnx(GifView gifview)
    {
        a = gifview;
        super();
    }

    public void handleMessage(Message message)
    {
        if (GifView.access$000(a) != null)
        {
            GifView.access$000(a).setBackgroundDrawable(new BitmapDrawable(GifView.access$100(a)));
            return;
        }
        try
        {
            GifView.access$200(a);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Message message)
        {
            Log.e("GifView", message.toString());
        }
        return;
    }
}
