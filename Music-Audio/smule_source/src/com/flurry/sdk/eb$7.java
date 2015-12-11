// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.view.View;
import java.util.Collections;

// Referenced classes of package com.flurry.sdk:
//            eb, aw

class it>
    implements android.view.OnClickListener
{

    final eb a;

    public void onClick(View view)
    {
        a.a(aw.s, Collections.emptyMap(), a.getAdController(), 0);
    }

    s(eb eb1)
    {
        a = eb1;
        super();
    }
}
