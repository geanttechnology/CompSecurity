// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package me.lyft.android.domain.driver;


// Referenced classes of package me.lyft.android.domain.driver:
//            Vehicle

class  extends Vehicle
{

    private static Vehicle INSTANCE = new <init>();

    public static Vehicle getInstance()
    {
        return INSTANCE;
    }

    public boolean isNull()
    {
        return true;
    }


    private ()
    {
        super("", "", "", "", Integer.valueOf(0), "", "");
    }
}
