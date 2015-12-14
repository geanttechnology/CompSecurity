// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import java.lang.ref.WeakReference;
import java.util.HashMap;

class ps extends Handler
{

    private WeakReference a;

    public ps(pn pn1)
    {
        a = new WeakReference(pn1);
    }

    public void handleMessage(Message message)
    {
        pn pn1 = (pn)a.get();
        if (message != null && message.obj != null)
        {
            Object obj = (HashMap)message.obj;
            message = (ImageView)((HashMap) (obj)).get("View");
            obj = (Bitmap)((HashMap) (obj)).get("bitmap");
            if (message != null && obj != null && pn.a(pn1) != null)
            {
                pn.a(pn1).a(((Bitmap) (obj)), message);
            }
        }
    }
}
