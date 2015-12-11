// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g;

import android.app.Dialog;
import android.os.Bundle;

// Referenced classes of package com.offerup.android.g:
//            r, q

public final class p extends android.support.v4.app.p
{

    private r a;
    private int b;

    public p()
    {
    }

    public static p a(int i, r r1)
    {
        Bundle bundle = new Bundle();
        bundle.putInt("photo_index", i);
        p p1 = new p();
        p1.a = r1;
        p1.setArguments(bundle);
        return p1;
    }

    static void a(p p1)
    {
        if (p1.a != null)
        {
            p1.a.b(p1.b);
        }
        p1.dismiss();
    }

    static void b(p p1)
    {
        if (p1.a != null)
        {
            p1.a.a(p1.b);
        }
        p1.dismiss();
    }

    public final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle != null)
        {
            b = bundle.getInt("photo_index", -1);
            return;
        } else
        {
            b = getArguments().getInt("photo_index", -1);
            return;
        }
    }

    public final Dialog onCreateDialog(Bundle bundle)
    {
        bundle = new android.support.v7.app.AlertDialog.Builder(getActivity());
        bundle.setTitle(0x7f0901ae).setItems(0x7f0f0003, new q(this));
        return bundle.create();
    }
}
