// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.panels;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import com.aviary.android.feather.library.services.IAviaryController;

// Referenced classes of package com.aviary.android.feather.sdk.panels:
//            AbstractPanel

class this._cls0 extends Handler
{

    final AbstractPanel this$0;

    public void handleMessage(Message message)
    {
        boolean flag;
        boolean flag2;
        flag2 = true;
        flag = true;
        super.handleMessage(message);
        message.what;
        JVM INSTR tableswitch 1 13: default 80
    //                   1 81
    //                   2 80
    //                   3 80
    //                   4 238
    //                   5 271
    //                   6 304
    //                   7 337
    //                   8 370
    //                   9 400
    //                   10 423
    //                   11 447
    //                   12 141
    //                   13 174;
           goto _L1 _L2 _L1 _L1 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12
_L1:
        return;
_L2:
        if (mListener != null && isActive())
        {
            PreviewListener previewlistener = mListener;
            Bitmap bitmap = (Bitmap)message.obj;
            if (message.arg1 != 1)
            {
                flag = false;
            }
            previewlistener.onPreviewChange(bitmap, flag);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L11:
        if (mListener != null && isActive())
        {
            mListener.onPreviewUpdated();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L12:
        if (mListener != null && isActive())
        {
            PreviewListener previewlistener1 = mListener;
            Drawable drawable = (Drawable)message.obj;
            boolean flag1;
            if (message.arg1 == 1)
            {
                flag1 = flag2;
            } else
            {
                flag1 = false;
            }
            previewlistener1.onPreviewChange(drawable, flag1);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (mProgressListener != null && isCreated())
        {
            mProgressListener.onProgressStart();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (mProgressListener != null && isCreated())
        {
            mProgressListener.onProgressEnd();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (mProgressListener != null && isCreated())
        {
            mProgressListener.onProgressModalStart();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (mProgressListener != null && isCreated())
        {
            mProgressListener.onProgressModalEnd();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L7:
        if (isActive())
        {
            getContext().setToolbarTitle((CharSequence)message.obj);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L8:
        if (isActive())
        {
            getContext().restoreToolbarTitle();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L9:
        if (isActive())
        {
            getContext().setPanelApplyStatusEnabled(false);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L10:
        if (isActive())
        {
            getContext().setPanelApplyStatusEnabled(true);
            return;
        }
        if (true) goto _L1; else goto _L13
_L13:
    }

    troller()
    {
        this$0 = AbstractPanel.this;
        super();
    }
}
