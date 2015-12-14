// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;

class qp
    implements android.view.View.OnClickListener
{

    final int a;
    final qn b;

    qp(qn qn1, int i)
    {
        b = qn1;
        a = i;
        super();
    }

    public void onClick(View view)
    {
        qn.b(b).b(a);
    }
}
