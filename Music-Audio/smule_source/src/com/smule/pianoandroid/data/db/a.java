// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.data.db;

import java.util.ArrayList;

public class a
{

    public static ArrayList a;
    public static ArrayList b;
    public static ArrayList c = new ArrayList();
    public static int d = 1;

    public static String a()
    {
        return (String)a.get(0);
    }

    static 
    {
        a = new ArrayList();
        a.add("{\"status\":{\"code\":0,\"message\":\"ok\",\"version\":1},\"data\":{\"song\":{\"songId\":\"_twinkle_twinkle_bundled\",\"resources\":[{\"uid\":\"2841885\",\"url\":\"\",\"size\":1419,\"contentType\":\"audio/midi\",\"role\":\"main\"}],\"artist\":\"W. A. Mozart\",\"genre\":\"Classical\",\"title\":\"Twinkle, Twinkle Little Star\",\"version\":1}}}");
        b = new ArrayList();
        b.add("_twinkle_twinkle_bundled");
    }
}
