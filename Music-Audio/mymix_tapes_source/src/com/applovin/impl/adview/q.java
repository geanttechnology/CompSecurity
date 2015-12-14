// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.adview;

import android.util.Log;
import android.view.View;

// Referenced classes of package com.applovin.impl.adview:
//            o

class q
    implements android.view.View.OnLongClickListener
{

    final o a;

    q(o o)
    {
        a = o;
        super();
    }

    public boolean onLongClick(View view)
    {
        Log.d("AdWebView", "Received a LongClick event.");
        return true;
    }
}
