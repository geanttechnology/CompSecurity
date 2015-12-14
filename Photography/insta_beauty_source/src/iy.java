// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.fotoable.beautyui.NewFilterScrollView;
import java.lang.ref.WeakReference;

public class iy extends Handler
{

    final NewFilterScrollView a;
    private WeakReference b;

    public iy(NewFilterScrollView newfilterscrollview, NewFilterScrollView newfilterscrollview1)
    {
        a = newfilterscrollview;
        super();
        b = new WeakReference(newfilterscrollview1);
    }

    public void handleMessage(Message message)
    {
        NewFilterScrollView newfilterscrollview = (NewFilterScrollView)b.get();
        if (newfilterscrollview != null && message != null)
        {
            message = (Bitmap)message.obj;
            if (message != null)
            {
                newfilterscrollview.getChildAt(0).post(new iz(this, newfilterscrollview, message));
            }
        }
    }
}
