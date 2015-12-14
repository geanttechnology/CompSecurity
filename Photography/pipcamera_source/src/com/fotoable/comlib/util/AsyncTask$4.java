// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.comlib.util;


// Referenced classes of package com.fotoable.comlib.util:
//            AsyncTask

class atus
{

    static final int a[];

    static 
    {
        a = new int[atus.values().length];
        try
        {
            a[atus.RUNNING.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[atus.FINISHED.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
