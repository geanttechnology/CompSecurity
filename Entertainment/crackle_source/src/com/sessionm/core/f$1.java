// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.core;

import android.content.Context;

// Referenced classes of package com.sessionm.core:
//            f

class >
    implements Runnable
{

    final Context cK;
    final String cL;
    final f cM;

    public void run()
    {
        cM.b(cK, cL);
    }

    t(f f1, Context context, String s)
    {
        cM = f1;
        cK = context;
        cL = s;
        super();
    }
}
