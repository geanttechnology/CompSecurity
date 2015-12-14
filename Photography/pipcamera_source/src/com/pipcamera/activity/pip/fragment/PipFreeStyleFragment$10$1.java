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
import com.pipcamera.activity.pip.PipFreeStyleActivity;
import java.io.File;
import rd;

// Referenced classes of package com.pipcamera.activity.pip.fragment:
//            PipFreeStyleFragment

class a
    implements Runnable
{

    final a a;

    public void run()
    {
        Toast.makeText(PipFreeStyleFragment.i(a.a), PipFreeStyleFragment.i(a.a).getResources().getString(0x7f060196), 0).show();
    }

    b(b b)
    {
        a = b;
        super();
    }

    // Unreferenced inner class com/pipcamera/activity/pip/fragment/PipFreeStyleFragment$10

/* anonymous class */
    class PipFreeStyleFragment._cls10 extends Handler
    {

        final PipFreeStyleFragment a;

        public void handleMessage(Message message)
        {
            Object obj = (Bitmap)message.obj;
            if (obj == null)
            {
                try
                {
                    PipFreeStyleFragment.i(a).b();
                    Log.e("PipFreeStyleFragment", "Can't make result image");
                    Toast.makeText(PipFreeStyleFragment.i(a), 0x7f060152, 1).show();
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Message message)
                {
                    message.printStackTrace();
                }
                break MISSING_BLOCK_LABEL_105;
            }
            message = ((Message) (obj));
            if (PipFreeStyleFragment.m(a))
            {
                message = PipFreeStyleFragment.b(a, ((Bitmap) (obj)));
                ((Bitmap) (obj)).recycle();
            }
            obj = rd.a(message);
            if (obj != null)
            {
                break MISSING_BLOCK_LABEL_120;
            }
            PipFreeStyleFragment.i(a).runOnUiThread(new PipFreeStyleFragment._cls10._cls1(this));
            return;
            Crashlytics.logException(message);
            PipFreeStyleFragment.i(a).b();
            return;
            rd.a(((File) (obj)).getAbsolutePath(), PipFreeStyleFragment.i(a));
            obj = Uri.fromFile(((File) (obj)));
            PipFreeStyleFragment.i(a).runOnUiThread(new PipFreeStyleFragment._cls10._cls2(message, ((Uri) (obj))));
            return;
        }

            
            {
                a = pipfreestylefragment;
                super();
            }

        // Unreferenced inner class com/pipcamera/activity/pip/fragment/PipFreeStyleFragment$10$2

/* anonymous class */
        class PipFreeStyleFragment._cls10._cls2
            implements Runnable
        {

            final Bitmap a;
            final Uri b;
            final PipFreeStyleFragment._cls10 c;

            public void run()
            {
                if (PipFreeStyleFragment.i(c.a) != null)
                {
                    PipFreeStyleFragment.i(c.a).b();
                    Log.v("PipFreeStyleFragment", "PipFreeStyleFragmentwrite ResultImage end");
                    if (a != null && !a.isRecycled())
                    {
                        a.recycle();
                    }
                    if (b != null)
                    {
                        Intent intent = new Intent(PipFreeStyleFragment.i(c.a), com/pipcamera/activity/NewPhotoShareActivity);
                        intent.putExtra("PhotoShareActivity_ToShareImageUri", b.toString());
                        c.a.startActivity(intent);
                        PipFreeStyleFragment.i(c.a).overridePendingTransition(0x7f040007, 0);
                        return;
                    }
                }
            }

                    
                    {
                        c = PipFreeStyleFragment._cls10.this;
                        a = bitmap;
                        b = uri;
                        super();
                    }
        }

    }

}
