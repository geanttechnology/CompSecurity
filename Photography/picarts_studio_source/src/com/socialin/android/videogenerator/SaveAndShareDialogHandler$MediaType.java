// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.videogenerator;


final class  extends Enum
{

    private static final MPG $VALUES[];
    public static final MPG GIF;
    public static final MPG MPG;

    public static String getType( )
    {
        if ( == GIF)
        {
            return "gif";
        } else
        {
            return "mpg";
        }
    }

    public static GIF valueOf(String s)
    {
        return (GIF)Enum.valueOf(com/socialin/android/videogenerator/SaveAndShareDialogHandler$MediaType, s);
    }

    public static GIF[] values()
    {
        return (GIF[])$VALUES.clone();
    }

    static 
    {
        GIF = new <init>("GIF", 0);
        MPG = new <init>("MPG", 1);
        $VALUES = (new .VALUES[] {
            GIF, MPG
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
