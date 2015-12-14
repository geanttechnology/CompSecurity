// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.widget.FrameLayout;
import com.fotoable.fotoproedit.activity.ProEditFilterActivity;
import java.lang.ref.WeakReference;

public class gk extends Handler
{

    private WeakReference a;

    public gk(ProEditFilterActivity proeditfilteractivity)
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
                ProEditFilterActivity.b(proeditfilteractivity).post(new Runnable(proeditfilteractivity, message) {

                    final ProEditFilterActivity a;
                    final Bitmap b;
                    final gk c;

                    public void run()
                    {
                        ProEditFilterActivity.a(a, b);
                        ProEditFilterActivity.n(a);
                    }

            
            {
                c = gk.this;
                a = proeditfilteractivity;
                b = bitmap;
                super();
            }
                });
            }
        }
    }
}
