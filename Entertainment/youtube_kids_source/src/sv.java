// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Dialog;
import android.content.Context;

public final class sv
{

    public final Context a;
    public Dialog b;

    public sv(Context context)
    {
        a = (Context)b.b(context, "context cannot be null");
    }

    public final void a()
    {
        if (b != null && b.isShowing())
        {
            b.dismiss();
        }
        b = null;
    }
}
