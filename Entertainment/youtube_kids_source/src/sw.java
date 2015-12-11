// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.DialogInterface;
import android.widget.ArrayAdapter;

public final class sw
    implements android.content.DialogInterface.OnClickListener
{

    private ArrayAdapter a;
    private sx b;

    public sw(sv sv, ArrayAdapter arrayadapter, sx sx1)
    {
        a = arrayadapter;
        b = sx1;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        cxu cxu1 = (cxu)a.getItem(i);
        b.a(cxu1);
        dialoginterface.dismiss();
    }
}
