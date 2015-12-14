// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.util;

import android.app.Dialog;

public final class g
    implements Runnable
{

    private Dialog a;

    public g(Dialog dialog)
    {
        a = dialog;
        super();
    }

    public final void run()
    {
        try
        {
            a.show();
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }
}
