// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.HashMap;

public class nk
{

    private static HashMap a;

    public static String a(String s)
    {
        return (String)a.get(s);
    }

    static 
    {
        a = new HashMap();
        a.put("weddingregistrylists", "weddingregistrylist");
        a.put("createyourownlists", "createyourownlist");
        a.put("holidaylists", "holidaylist");
        a.put("birthdaylists", "birthdaylist");
        a.put("backtoschoollists", "backtoschoollist");
        a.put("graduationlists", "graduationlist");
        a.put("anniversarylists", "anniversarylist");
        a.put("movinglists", "movinglist");
    }
}
