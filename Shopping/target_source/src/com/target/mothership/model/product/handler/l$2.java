// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.handler;

import com.target.mothership.common.product.g;

// Referenced classes of package com.target.mothership.model.product.handler:
//            l

static class 
{

    static final int $SwitchMap$com$target$mothership$common$product$FacetKey[];

    static 
    {
        $SwitchMap$com$target$mothership$common$product$FacetKey = new int[g.values().length];
        try
        {
            $SwitchMap$com$target$mothership$common$product$FacetKey[g.CATEGORY_ID.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$target$mothership$common$product$FacetKey[g.ENDECA_ID.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
