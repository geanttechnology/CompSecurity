// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models;


// Referenced classes of package com.groupon.models:
//            FilterCategory

static class de
{

    static final int $SwitchMap$com$groupon$models$FilterCategory$Mode[];

    static 
    {
        $SwitchMap$com$groupon$models$FilterCategory$Mode = new int[de.values().length];
        try
        {
            $SwitchMap$com$groupon$models$FilterCategory$Mode[de.EVERYTHING.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$groupon$models$FilterCategory$Mode[de.FAVORITES.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$groupon$models$FilterCategory$Mode[de.SELECTION.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
