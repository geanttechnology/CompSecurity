// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.widget.FrameLayout;
import com.fotoable.fotoproedit.activity.ProEditFilterActivity;
import java.lang.ref.WeakReference;

public class agg extends Handler
{

    private WeakReference a;

    public agg(ProEditFilterActivity proeditfilteractivity)
    {
        a = new WeakReference(proeditfilteractivity);
    }

    public void handleMessage(Message message)
    {
        ProEditFilterActivity proeditfilteractivity = (ProEditFilterActivity)a.get();
        if (proeditfilteractivity != null && message != null)
        {
            message = (Bitmap)message.obj;
            if (message != null)
            {
                ProEditFilterActivity.t(proeditfilteractivity).post(new agh(this, proeditfilteractivity, message));
            }
        }
    }
}
