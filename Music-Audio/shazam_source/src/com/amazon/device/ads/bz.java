// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public final class bz
{

    public Activity a;
    public Context b;
    public Class c;
    public TreeMap d;

    public bz()
    {
        d = new TreeMap();
    }

    public final boolean a()
    {
        Intent intent;
        try
        {
            intent = new Intent(b, c);
            java.util.Map.Entry entry;
            for (Iterator iterator = d.entrySet().iterator(); iterator.hasNext(); intent.putExtra((String)entry.getKey(), (String)entry.getValue()))
            {
                entry = (java.util.Map.Entry)iterator.next();
            }

        }
        catch (ActivityNotFoundException activitynotfoundexception)
        {
            return false;
        }
        a.startActivity(intent);
        return true;
    }
}
