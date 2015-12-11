// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;


// Referenced classes of package com.poshmark.utils:
//            TextValidator

static class DE
{

    static final int $SwitchMap$com$poshmark$utils$TextValidator$MODE[];

    static 
    {
        $SwitchMap$com$poshmark$utils$TextValidator$MODE = new int[DE.values().length];
        try
        {
            $SwitchMap$com$poshmark$utils$TextValidator$MODE[DE.MODE_SIMPLE.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        try
        {
            $SwitchMap$com$poshmark$utils$TextValidator$MODE[DE.MODE_SIMPLE_NO_SPACES.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            $SwitchMap$com$poshmark$utils$TextValidator$MODE[DE.MODE_PASSWORD.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            $SwitchMap$com$poshmark$utils$TextValidator$MODE[DE.MODE_EMAIL.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$poshmark$utils$TextValidator$MODE[DE.MODE_USERNAME.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$poshmark$utils$TextValidator$MODE[DE.MODE_CREDITCARD.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$poshmark$utils$TextValidator$MODE[DE.MODE_ZIPCODE.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$poshmark$utils$TextValidator$MODE[DE.MODE_SSN.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$poshmark$utils$TextValidator$MODE[DE.MODE_DOB.ordinal()] = 9;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
