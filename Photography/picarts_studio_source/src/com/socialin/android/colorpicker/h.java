// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.colorpicker;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;

// Referenced classes of package com.socialin.android.colorpicker:
//            f, g, c, d

public final class h extends DialogFragment
{

    public int a;
    public int b;
    private c c;
    private d d;

    public h()
    {
        a = 0xff000000;
        b = 0xff000000;
    }

    public final void a(c c1)
    {
        c = c1;
        if (getDialog() != null)
        {
            ((f)getDialog()).b = c1;
        }
    }

    public final void a(d d1)
    {
        d = d1;
        if (getDialog() != null)
        {
            ((f)getDialog()).c = d1;
        }
    }

    public final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle != null)
        {
            a = bundle.getInt("currentColor");
            b = bundle.getInt("previousColor");
        }
    }

    public final Dialog onCreateDialog(Bundle bundle)
    {
        bundle = new g();
        bundle.a = c;
        boolean flag;
        if (d != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        bundle.d = flag;
        bundle.b = d;
        bundle.e = b;
        bundle.f = a;
        bundle.c = true;
        return bundle.a(getActivity());
    }

    public final void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        f f1 = (f)getDialog();
        bundle.putInt("currentColor", f1.b());
        bundle.putInt("previousColor", f1.a);
    }
}
