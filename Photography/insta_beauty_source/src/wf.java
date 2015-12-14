// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import com.fotoable.beautyui.newui.MOneKeyFragment;
import java.lang.ref.WeakReference;

public class wf extends Handler
{

    final MOneKeyFragment a;
    private WeakReference b;

    public wf(MOneKeyFragment monekeyfragment, MOneKeyFragment monekeyfragment1)
    {
        a = monekeyfragment;
        super();
        b = new WeakReference(monekeyfragment1);
    }

    public void handleMessage(Message message)
    {
        MOneKeyFragment monekeyfragment;
label0:
        {
            monekeyfragment = (MOneKeyFragment)b.get();
            if (monekeyfragment != null && message != null)
            {
                message = (Bitmap)message.obj;
                if (message != null && a.getActivity() != null)
                {
                    break label0;
                }
            }
            return;
        }
        MOneKeyFragment.a(monekeyfragment).post(new wg(this, monekeyfragment, message));
    }
}
