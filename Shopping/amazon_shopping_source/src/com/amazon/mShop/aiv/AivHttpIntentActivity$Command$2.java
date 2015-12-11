// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.aiv;

import android.app.Activity;
import android.util.Log;
import java.util.List;

// Referenced classes of package com.amazon.mShop.aiv:
//            AivHttpIntentActivity

static final class nit> extends nit>
{

    public void performCommand(Activity activity, List list)
    {
        Log.e(AivHttpIntentActivity.access$100(), String.format("Operation %s not currently supported", new Object[] {
            this
        }));
    }

    (String s, int i, String s1)
    {
        super(s, i, s1, null);
    }
}
