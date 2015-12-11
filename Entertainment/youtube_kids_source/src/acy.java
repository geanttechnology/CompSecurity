// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.DialogInterface;

final class acy
    implements android.content.DialogInterface.OnClickListener
{

    private acx a;

    acy(acx acx1)
    {
        a = acx1;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        if (i == -1)
        {
            dialoginterface = act.c(a.d);
            String s = a.c;
            dialoginterface.f();
        } else
        if (i == -2)
        {
            dialoginterface.dismiss();
            return;
        }
    }
}
