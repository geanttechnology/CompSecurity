// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.share;


// Referenced classes of package com.shazam.model.share:
//            ShareDataItem

public static class 
{

    public String iconUri;
    public String intentClassName;
    public String intentPackageName;
    public String title;

    public static  a()
    {
        return new <init>();
    }

    static String a(<init> <init>1)
    {
        return <init>1.iconUri;
    }

    static String b(iconUri iconuri)
    {
        return iconuri.title;
    }

    static String c(title title1)
    {
        return title1.intentPackageName;
    }

    static String d(intentPackageName intentpackagename)
    {
        return intentpackagename.intentClassName;
    }

    public final ShareDataItem b()
    {
        return new ShareDataItem(this, null);
    }

    public ()
    {
    }
}
