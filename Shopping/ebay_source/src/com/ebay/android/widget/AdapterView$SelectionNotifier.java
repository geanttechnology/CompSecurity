// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.android.widget;

import android.os.Handler;
import java.lang.ref.WeakReference;

// Referenced classes of package com.ebay.android.widget:
//            AdapterView

private static class ref extends Handler
    implements Runnable
{

    private final WeakReference ref;

    public void run()
    {
        AdapterView adapterview = (AdapterView)ref.get();
        if (adapterview == null)
        {
            return;
        }
        if (adapterview.mDataChanged)
        {
            post(this);
            return;
        } else
        {
            AdapterView.access$200(adapterview);
            return;
        }
    }

    public (AdapterView adapterview)
    {
        ref = new WeakReference(adapterview);
    }
}
