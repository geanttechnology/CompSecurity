// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;

public class acr
    implements Runnable
{

    private final Context a;
    private final acn b;

    public acr(Context context, acn acn1)
    {
        a = context;
        b = acn1;
    }

    public void run()
    {
        try
        {
            CommonUtils.a(a, "Performing time based file roll over.");
            if (!b.rollFileOver())
            {
                b.cancelTimeBasedFileRollOver();
            }
            return;
        }
        catch (Exception exception)
        {
            CommonUtils.a(a, "Failed to roll over file", exception);
        }
    }
}
