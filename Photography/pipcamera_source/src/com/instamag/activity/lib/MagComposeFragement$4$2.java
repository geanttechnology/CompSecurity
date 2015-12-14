// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.lib;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;
import com.pipcamera.activity.NewPhotoShareActivity;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import java.io.File;
import rd;

// Referenced classes of package com.instamag.activity.lib:
//            MagComposeFragement, MagComposeActivity

class a
    implements Runnable
{

    final Uri a;
    final idePendingTransition b;

    public void run()
    {
        if (b.b.a != null)
        {
            b.b.a.d();
            Log.v(MagComposeFragement.e(b.b), (new StringBuilder()).append(MagComposeFragement.e(b.b)).append("write ResultImage end").toString());
            if (b.b != null && !b.b.isRecycled())
            {
                b.b.recycle();
            }
            if (a != null)
            {
                Intent intent = new Intent(b.b.getActivity(), com/pipcamera/activity/NewPhotoShareActivity);
                intent.putExtra("PhotoShareActivity_ToShareImageUri", a.toString());
                if (b.b.a.g().isShouldFirst())
                {
                    String s = b.b.a.g().shareTag;
                    if (s != null && s.length() > 0)
                    {
                        intent.putExtra("share_tag", s);
                    }
                }
                b.b.startActivity(intent);
                b.b.a.overridePendingTransition(0x7f040007, 0);
                return;
            }
        }
    }

    a(a a1, Uri uri)
    {
        b = a1;
        a = uri;
        super();
    }

    // Unreferenced inner class com/instamag/activity/lib/MagComposeFragement$4

/* anonymous class */
    class MagComposeFragement._cls4
        implements Runnable
    {

        final Bitmap a;
        final MagComposeFragement b;

        public void run()
        {
            if (b.a == null)
            {
                return;
            }
            Object obj = rd.a(a);
            if (obj == null)
            {
                b.a.d();
                b.a.runOnUiThread(new MagComposeFragement._cls4._cls1());
                return;
            } else
            {
                rd.a(((File) (obj)).getAbsolutePath(), b.a);
                obj = Uri.fromFile(((File) (obj)));
                b.a.runOnUiThread(new MagComposeFragement._cls4._cls2(this, ((Uri) (obj))));
                return;
            }
        }

            
            {
                b = magcomposefragement;
                a = bitmap;
                super();
            }

        // Unreferenced inner class com/instamag/activity/lib/MagComposeFragement$4$1

/* anonymous class */
        class MagComposeFragement._cls4._cls1
            implements Runnable
        {

            final MagComposeFragement._cls4 a;

            public void run()
            {
                Toast.makeText(a.b.a, a.b.a.getResources().getString(0x7f060196), 0).show();
            }

                    
                    {
                        a = MagComposeFragement._cls4.this;
                        super();
                    }
        }

    }

}
