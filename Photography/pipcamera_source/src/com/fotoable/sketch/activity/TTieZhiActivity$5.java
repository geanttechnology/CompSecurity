// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.sketch.activity;

import com.fotoable.sketch.view.TTieZhiMainLibraryView;

// Referenced classes of package com.fotoable.sketch.activity:
//            TTieZhiActivity

class a
    implements Runnable
{

    final TTieZhiActivity a;

    public void run()
    {
        if (a.o.getVisibility() != 0)
        {
            TTieZhiActivity.b(a);
        }
    }

    (TTieZhiActivity ttiezhiactivity)
    {
        a = ttiezhiactivity;
        super();
    }
}
