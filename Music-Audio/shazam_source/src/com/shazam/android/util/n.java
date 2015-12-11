// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

// Referenced classes of package com.shazam.android.util:
//            s, q

public final class n
    implements s
{

    private final Context a;
    private final LayoutInflater b;

    public n(Context context, LayoutInflater layoutinflater)
    {
        a = context;
        b = layoutinflater;
    }

    public final void a(q q1)
    {
        int i = q1.d;
        int j = q1.e;
        int k = q1.a;
        int l = q1.h;
        int i1 = q1.c;
        Object obj = q1.b.toString();
        if (k > 0)
        {
            obj = a.getString(k);
        }
        Toast toast = Toast.makeText(a, ((CharSequence) (obj)), i1);
        if (l > 0)
        {
            toast = new Toast(a);
            android.view.View view = b.inflate(l, null);
            if (view instanceof TextView)
            {
                ((TextView)view).setText(((CharSequence) (obj)));
            }
            toast.setView(view);
            toast.setDuration(i1);
            obj = toast;
        } else
        {
            obj = toast;
        }
        if (i != 0)
        {
            ((Toast) (obj)).setGravity(i, q1.f, q1.g);
        }
        if (j == 0) goto _L2; else goto _L1
_L1:
        if (!(((Toast) (obj)).getView() instanceof ViewGroup)) goto _L4; else goto _L3
_L3:
        q1 = (TextView)((ViewGroup)((Toast) (obj)).getView()).getChildAt(0);
_L5:
        q1.setGravity(j);
_L2:
        ((Toast) (obj)).show();
        return;
_L4:
        q1 = (TextView)((Toast) (obj)).getView();
          goto _L5
        q1;
          goto _L2
    }
}
