// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.pip.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;
import com.crashlytics.android.Crashlytics;
import com.pipcamera.activity.NewPhotoShareActivity;
import com.pipcamera.activity.pip.PipStyleBaseActivity;
import com.wantu.model.res.pip.TDFSceneInfo;
import java.io.File;
import java.util.Date;
import rd;

// Referenced classes of package com.pipcamera.activity.pip.fragment:
//            PipProcessFragment

class a extends Handler
{

    final PipProcessFragment a;

    public void handleMessage(Message message)
    {
        if (message == null)
        {
            break MISSING_BLOCK_LABEL_254;
        }
        Bitmap bitmap = (Bitmap)message.obj;
        message = a.a(bitmap);
        bitmap.recycle();
        Object obj;
        if (message == null)
        {
            try
            {
                Log.e("PipProcessFragment", "Can't make result image");
                Toast.makeText(PipProcessFragment.a(a), 0x7f060152, 1).show();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Message message)
            {
                message.printStackTrace();
            }
            break MISSING_BLOCK_LABEL_97;
        }
        if (PipProcessFragment.a(a) == null)
        {
            break MISSING_BLOCK_LABEL_254;
        }
        obj = rd.a(message);
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_112;
        }
        PipProcessFragment.a(a).runOnUiThread(new Runnable() {

            final PipProcessFragment._cls8 a;

            public void run()
            {
                Toast.makeText(PipProcessFragment.a(a.a), PipProcessFragment.a(a.a).getResources().getString(0x7f060196), 0).show();
            }

            
            {
                a = PipProcessFragment._cls8.this;
                super();
            }
        });
        return;
        Crashlytics.logException(message);
        PipProcessFragment.a(a).b();
        return;
        rd.a(((File) (obj)).getAbsolutePath(), PipProcessFragment.a(a));
        obj = Uri.fromFile(((File) (obj)));
        if (message == null)
        {
            break MISSING_BLOCK_LABEL_146;
        }
        if (!message.isRecycled())
        {
            message.recycle();
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_254;
        }
        Intent intent;
        message = PipProcessFragment.a(a).i();
        intent = new Intent(PipProcessFragment.a(a), com/pipcamera/activity/NewPhotoShareActivity);
        intent.putExtra("PhotoShareActivity_ToShareImageUri", ((Uri) (obj)).toString());
        if (message == null)
        {
            break MISSING_BLOCK_LABEL_233;
        }
        if (message.getShareTag() != null)
        {
            long l = message.getExpireTime();
            if ((new Date()).getTime() <= l)
            {
                intent.putExtra("share_tag", message.getShareTag());
            }
        }
        a.startActivity(intent);
        PipProcessFragment.a(a).overridePendingTransition(0x7f040007, 0);
    }

    _cls1.a(PipProcessFragment pipprocessfragment)
    {
        a = pipprocessfragment;
        super();
    }
}
