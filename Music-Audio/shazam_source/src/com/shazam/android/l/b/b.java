// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.l.b;

import com.shazam.b.a.a;
import com.shazam.c.i;
import com.shazam.model.store.StoreChoiceAction;
import com.shazam.server.response.config.StoreAction;
import java.util.List;

public final class b
    implements a
{

    private final i a;

    public b(i j)
    {
        a = j;
    }

    public final Object a(Object obj)
    {
        obj = (StoreAction)obj;
        com.shazam.model.store.StoreChoiceAction.Builder builder = com.shazam.model.store.StoreChoiceAction.Builder.a();
        builder.defaultActions = (List)a.a(((StoreAction) (obj)).getDefaultActions());
        builder.staticActions = (List)a.a(((StoreAction) (obj)).getStaticActions());
        return new StoreChoiceAction(builder, null);
    }
}
