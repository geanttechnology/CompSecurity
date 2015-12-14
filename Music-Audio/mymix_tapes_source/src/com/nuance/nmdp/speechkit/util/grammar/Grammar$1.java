// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit.util.grammar;


// Referenced classes of package com.nuance.nmdp.speechkit.util.grammar:
//            Grammar

static final class ammarType
{

    static final int a[];

    static 
    {
        a = new int[ammarType.values().length];
        try
        {
            a[ammarType.CONTACTS.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            a[ammarType.CUSTOMWORDS.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            a[ammarType.HISTORY.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            a[ammarType.URI.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[ammarType.PREDEFINED_STATIC_GRAMMARS.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[ammarType.INSTANT_ITEM_LIST.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
