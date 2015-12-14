// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity;

import android.graphics.Bitmap;
import java.util.ArrayList;
import sp;

// Referenced classes of package com.pipcamera.activity:
//            PhotoShareToInstagramActivity

class a
    implements sp
{

    final PhotoShareToInstagramActivity a;

    public void a(int i)
    {
    }

    public void a(ArrayList arraylist, int i)
    {
        arraylist = (Bitmap)arraylist.get(0);
        if (arraylist == null)
        {
            a.a();
            return;
        } else
        {
            a.a(arraylist);
            return;
        }
    }

    (PhotoShareToInstagramActivity photosharetoinstagramactivity)
    {
        a = photosharetoinstagramactivity;
        super();
    }
}
