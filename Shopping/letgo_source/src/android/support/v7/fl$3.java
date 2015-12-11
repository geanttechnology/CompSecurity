// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.app.Activity;
import android.content.DialogInterface;

// Referenced classes of package android.support.v7:
//            fl

class a
    implements android.content.gInterface.OnClickListener
{

    final Activity a;
    final fl b;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (i == 0)
        {
            b.b(a);
        }
        if (i == 1)
        {
            b.a(a);
        }
    }

    terface(fl fl1, Activity activity)
    {
        b = fl1;
        a = activity;
        super();
    }
}
