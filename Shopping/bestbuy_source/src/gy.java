// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.gson.Gson;

public class gy
{

    public gy()
    {
    }

    public gu a(String s, gu gu1)
    {
        return (gu)(new Gson()).fromJson(s, gu1.getClass());
    }

    public String a(gu gu1)
    {
        return (new Gson()).toJson(gu1, gu1.getClass());
    }
}
