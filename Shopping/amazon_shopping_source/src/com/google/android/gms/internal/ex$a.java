// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;

// Referenced classes of package com.google.android.gms.internal:
//            ex

private static class  extends MutableContextWrapper
{

    private Context lz;
    private Activity sG;

    public void setBaseContext(Context context)
    {
        lz = context.getApplicationContext();
        if (context instanceof Activity)
        {
            context = (Activity)context;
        } else
        {
            context = null;
        }
        sG = context;
        super.setBaseContext(lz);
    }

    public void startActivity(Intent intent)
    {
        if (sG != null)
        {
            sG.startActivity(intent);
            return;
        } else
        {
            intent.setFlags(0x10000000);
            lz.startActivity(intent);
            return;
        }
    }
}
