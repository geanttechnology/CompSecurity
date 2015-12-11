// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.utils;

import java.util.ArrayList;

public class Updatesize
{

    private static Updatesize manager = new Updatesize();
    public ArrayList list_update;

    private Updatesize()
    {
        list_update = new ArrayList();
    }

    public static Updatesize getUpdatesize()
    {
        return manager;
    }

}
