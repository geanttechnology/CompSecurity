// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.handler;

import com.target.mothership.services.aa;

public class g
    implements aa
{

    public static final String STS = "STS";

    public g()
    {
    }

    public volatile Object a(Object obj)
    {
        return a((com.target.mothership.common.a.g)obj);
    }

    public String a(com.target.mothership.common.a.g g1)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$target$mothership$common$cart$PickUpItemType[];

            static 
            {
                $SwitchMap$com$target$mothership$common$cart$PickUpItemType = new int[com.target.mothership.common.a.g.values().length];
                try
                {
                    $SwitchMap$com$target$mothership$common$cart$PickUpItemType[com.target.mothership.common.a.g.SHIP_TO_STORE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
            }
        }

        switch (_cls1..SwitchMap.com.target.mothership.common.cart.PickUpItemType[g1.ordinal()])
        {
        default:
            return "";

        case 1: // '\001'
            return "STS";
        }
    }
}
