// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.collages;

import android.content.Intent;
import android.os.Bundle;
import java.util.HashMap;

// Referenced classes of package com.picsart.collages:
//            e, CollageImage, CollageCreatorView, a

final class b
    implements Runnable
{

    private HashMap a;
    private Intent b;
    private e c;

    public final void run()
    {
        CollageImage collageimage;
        boolean flag;
        if (a != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        collageimage = new CollageImage(flag, b.getExtras().getString("path"), a, 0);
        e.b(c).setImageToCell(collageimage, e.b(c).d, false, e.b(c).e().i, true);
    }

    geCreatorView(e e1, HashMap hashmap, Intent intent)
    {
        c = e1;
        a = hashmap;
        b = intent;
        super();
    }
}
