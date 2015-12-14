// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.sketch.activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.Toast;
import com.pipcamera.application.PIPCameraApplication;
import java.util.ArrayList;
import sp;

// Referenced classes of package com.fotoable.sketch.activity:
//            TTieZhiActivity

class a
    implements sp
{

    final TTieZhiActivity a;

    public void a(int i)
    {
        TTieZhiActivity.a(a, true, PIPCameraApplication.a.getString(0x7f060147));
    }

    public void a(ArrayList arraylist, int i)
    {
        TTieZhiActivity.a(a, false, "");
        arraylist = (Bitmap)arraylist.get(0);
        if (arraylist == null)
        {
            TTieZhiActivity.d(a);
            Toast.makeText(a.getApplicationContext(), 0x7f0600e4, 0).show();
            return;
        } else
        {
            a.h = arraylist;
            if (a.h == null);
            TTieZhiActivity.e(a);
            return;
        }
    }

    (TTieZhiActivity ttiezhiactivity)
    {
        a = ttiezhiactivity;
        super();
    }
}
