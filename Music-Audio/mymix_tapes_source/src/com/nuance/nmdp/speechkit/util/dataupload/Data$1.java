// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit.util.dataupload;


// Referenced classes of package com.nuance.nmdp.speechkit.util.dataupload:
//            Data

static final class taType
{

    static final int a[];

    static 
    {
        a = new int[taType.values().length];
        try
        {
            a[taType.CONTACTS.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[taType.CUSTOMWORDS.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[taType.HISTORY.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
