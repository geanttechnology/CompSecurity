// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.fotoable.fotoproedit.activity.ProEditFilterActivity;

public class agb extends Handler
{

    final ProEditFilterActivity a;

    public agb(ProEditFilterActivity proeditfilteractivity)
    {
        a = proeditfilteractivity;
        super();
    }

    public void handleMessage(Message message)
    {
        message = (Bitmap)message.obj;
        if (message != null)
        {
            try
            {
                uv.c().a(message, new agc(this));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Message message)
            {
                Log.e("ProEditFilterActivity", message.getMessage());
            }
            break MISSING_BLOCK_LABEL_55;
        }
        a.runOnUiThread(new age(this));
        return;
        a.c();
        a.finish();
        return;
    }
}
