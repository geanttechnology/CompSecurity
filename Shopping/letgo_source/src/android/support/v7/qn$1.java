// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.content.DialogInterface;

// Referenced classes of package android.support.v7:
//            qn

class a
    implements android.content.gInterface.OnClickListener
{

    final qn a;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = a.b();
        qn.a(a).startActivity(dialoginterface);
    }

    terface(qn qn1)
    {
        a = qn1;
        super();
    }
}
