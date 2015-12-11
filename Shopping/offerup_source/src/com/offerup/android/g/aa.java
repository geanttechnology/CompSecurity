// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.p;

// Referenced classes of package com.offerup.android.g:
//            ab, ac

public final class aa extends p
{

    private ac a;
    private int b;
    private int c;

    public aa()
    {
        c = -1;
    }

    public static aa a(int i, ac ac1)
    {
        Bundle bundle = new Bundle();
        bundle.putInt("photo_index", i);
        aa aa1 = new aa();
        aa1.a = ac1;
        aa1.setArguments(bundle);
        return aa1;
    }

    static void a(aa aa1)
    {
        aa1.c = 0;
        aa1.dismiss();
    }

    static void b(aa aa1)
    {
        aa1.c = 1;
        aa1.dismiss();
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
        bundle.setTitle(0x7f0900b8).setItems(0x7f0f0000, new ab(this));
        return bundle.create();
    }

    public final void onDismiss(DialogInterface dialoginterface)
    {
label0:
        {
label1:
            {
                super.onDismiss(dialoginterface);
                if (a != null)
                {
                    switch (c)
                    {
                    default:
                        a.e(b);
                        break;

                    case 0: // '\0'
                        break label1;

                    case 1: // '\001'
                        break label0;
                    }
                }
                return;
            }
            a.c(b);
            return;
        }
        a.d(b);
    }
}
