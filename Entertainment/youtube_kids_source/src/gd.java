// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

public class gd extends i
{

    public ip W;

    public gd()
    {
        a(true);
    }

    public fz a(Context context)
    {
        return new fz(context);
    }

    public final Dialog c(Bundle bundle)
    {
        bundle = a(super.w);
        m();
        bundle.a(W);
        return bundle;
    }

    public void m()
    {
        if (W == null)
        {
            Bundle bundle = super.k;
            if (bundle != null)
            {
                W = ip.a(bundle.getBundle("selector"));
            }
            if (W == null)
            {
                W = ip.c;
            }
        }
    }
}
