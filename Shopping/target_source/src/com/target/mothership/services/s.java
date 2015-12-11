// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services;


public abstract class s
{

    protected static final int MAX_RETRIES = 1;

    public s()
    {
    }

    public abstract int b();

    public boolean c()
    {
        return b() <= 1;
    }
}
