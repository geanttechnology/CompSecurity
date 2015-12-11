// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.view.menu;

import android.content.Context;
import android.support.v4.internal.view.SupportMenuItem;
import android.view.ActionProvider;

// Referenced classes of package android.support.v7.internal.view.menu:
//            k, q, l

class p extends k
{

    p(Context context, SupportMenuItem supportmenuitem)
    {
        super(context, supportmenuitem);
    }

    l a(ActionProvider actionprovider)
    {
        return new q(this, a, actionprovider);
    }
}
