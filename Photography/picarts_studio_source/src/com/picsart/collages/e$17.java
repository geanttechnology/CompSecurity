// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.collages;

import android.content.Intent;
import android.os.Bundle;
import java.util.HashMap;
import myobfuscated.ax.a;

// Referenced classes of package com.picsart.collages:
//            e, CollageCreatorView, a, CollageImage, 
//            SPArrow

final class b
    implements Runnable
{

    private Intent a;
    private HashMap b;
    private e c;

    public final void run()
    {
        int i = e.b(c).e().e();
        float f = e.b(c).e().h;
        CollageImage collageimage = new CollageImage(true, a.getExtras().getString("path"), b, 0);
        e.b(c).e().b(f - (float)i - (float)e.b(c).e().w, e.b(c).e().j.getX(), e.b(c).e().j.getY());
        e.b(c).setImageToCell(collageimage, e.b(c).d, true, e.b(c).e().i, true, new a(i));
    }

    ow(e e1, Intent intent, HashMap hashmap)
    {
        c = e1;
        a = intent;
        b = hashmap;
        super();
    }
}
