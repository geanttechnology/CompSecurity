// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem.fragments;

import android.view.View;

// Referenced classes of package com.ebay.mobile.viewitem.fragments:
//            ActionsFactory

static final class val.factory
    implements android.view.ner
{

    final tion val$action;
    final ActionsFactory val$factory;

    public void onClick(View view)
    {
        val$action.execute(val$factory);
    }

    tion(tion tion, ActionsFactory actionsfactory)
    {
        val$action = tion;
        val$factory = actionsfactory;
        super();
    }
}
