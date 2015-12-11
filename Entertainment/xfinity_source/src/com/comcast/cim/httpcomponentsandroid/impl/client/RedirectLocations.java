// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.client;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RedirectLocations
{

    private final List all = new ArrayList();
    private final Set unique = new HashSet();

    public RedirectLocations()
    {
    }

    public void add(URI uri)
    {
        unique.add(uri);
        all.add(uri);
    }

    public boolean contains(URI uri)
    {
        return unique.contains(uri);
    }

    public List getAll()
    {
        return new ArrayList(all);
    }
}
