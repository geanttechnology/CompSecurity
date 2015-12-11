// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.content.Intent;
import android.support.v7.internal.widget.d;
import android.view.MenuItem;

// Referenced classes of package android.support.v7.widget:
//            x

private final class <init>
    implements android.view.Item.OnMenuItemClickListener
{

    final x a;

    public final boolean onMenuItemClick(MenuItem menuitem)
    {
        menuitem = d.a(x.access$100(a), x.access$200(a)).b(menuitem.getItemId());
        if (menuitem != null)
        {
            String s = menuitem.getAction();
            if ("android.intent.action.SEND".equals(s) || "android.intent.action.SEND_MULTIPLE".equals(s))
            {
                x.access$300(a, menuitem);
            }
            x.access$100(a).startActivity(menuitem);
        }
        return true;
    }

    private dget.d(x x1)
    {
        a = x1;
        super();
    }

    a(x x1, byte byte0)
    {
        this(x1);
    }
}
