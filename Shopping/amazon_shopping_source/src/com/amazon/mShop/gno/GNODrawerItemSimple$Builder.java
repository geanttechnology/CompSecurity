// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.gno;

import android.content.Context;

// Referenced classes of package com.amazon.mShop.gno:
//            GNODrawerItemSimple

public static class item
{

    private GNODrawerItemSimple item;
    private self type;

    public GNODrawerItemSimple build()
    {
        if (type != null)
        {
            GNODrawerItemSimple.access$202(item, type);
        } else
        {
            GNODrawerItemSimple.access$202(item, EM);
        }
        return item;
    }

    protected item self()
    {
        return this;
    }

    public nClickListener withListener(nClickListener nclicklistener)
    {
        GNODrawerItemSimple.access$102(item, nclicklistener);
        return self();
    }

    public self withRefMarker(String s)
    {
        item.setRefMarker(s);
        return self();
    }

    public self withSubView(int i)
    {
        GNODrawerItemSimple.access$502(item, i);
        return self();
    }

    public self withText(int i)
    {
        GNODrawerItemSimple.access$402(item, i);
        return self();
    }

    public self withText(String s)
    {
        GNODrawerItemSimple.access$302(item, s);
        return self();
    }

    public self withType(self self1)
    {
        type = self1;
        return self();
    }

    public nClickListener(Context context, String s)
    {
        item = new GNODrawerItemSimple(context, s);
    }

    protected item(GNODrawerItemSimple gnodraweritemsimple)
    {
        item = gnodraweritemsimple;
    }
}
