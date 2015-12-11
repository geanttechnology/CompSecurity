// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.hockeyapp.android.d;

import android.content.DialogInterface;
import java.lang.ref.WeakReference;
import net.hockeyapp.android.e.h;
import net.hockeyapp.android.y;
import org.json.JSONArray;

// Referenced classes of package net.hockeyapp.android.d:
//            a

final class c
    implements android.content.DialogInterface.OnClickListener
{

    final JSONArray a;
    final a b;

    c(a a1, JSONArray jsonarray)
    {
        b = a1;
        a = jsonarray;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        h.a(net.hockeyapp.android.d.a.b(b), "[]");
        dialoginterface = new WeakReference(net.hockeyapp.android.d.a.b(b));
        if (y.a().booleanValue() && y.a(dialoginterface).booleanValue())
        {
            net.hockeyapp.android.d.a.a(b, a);
            return;
        } else
        {
            net.hockeyapp.android.d.a.a(b, a, Boolean.valueOf(false));
            return;
        }
    }
}
