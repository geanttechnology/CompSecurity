// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import com.instamag.activity.compose.MagComposeLinkFragement;
import com.wantu.activity.link.view.LinkImageView;

public class bay extends Handler
{

    final MagComposeLinkFragement a;

    public bay(MagComposeLinkFragement magcomposelinkfragement)
    {
        a = magcomposelinkfragement;
        super();
    }

    public void handleMessage(Message message)
    {
        if (message != null)
        {
            message = (Bitmap)message.obj;
            if (message != null)
            {
                ((LinkImageView)MagComposeLinkFragement.i(a)).setImageBitmap(message);
            }
        }
    }
}
