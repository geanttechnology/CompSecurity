// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bumptech.glide.util.Util;

// Referenced classes of package com.bumptech.glide.load.engine:
//            Resource

class ResourceRecycler
{
    private static class ResourceRecyclerCallback
        implements android.os.Handler.Callback
    {

        public boolean handleMessage(Message message)
        {
            if (message.what == 1)
            {
                ((Resource)message.obj).recycle();
                return true;
            } else
            {
                return false;
            }
        }

        private ResourceRecyclerCallback()
        {
        }

    }


    private final Handler handler = new Handler(Looper.getMainLooper(), new ResourceRecyclerCallback());
    private boolean isRecycling;

    ResourceRecycler()
    {
    }

    public void recycle(Resource resource)
    {
        Util.assertMainThread();
        if (isRecycling)
        {
            handler.obtainMessage(1, resource).sendToTarget();
            return;
        } else
        {
            isRecycling = true;
            resource.recycle();
            isRecycling = false;
            return;
        }
    }
}
