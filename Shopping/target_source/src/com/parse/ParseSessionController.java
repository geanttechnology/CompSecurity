// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.j;

interface ParseSessionController
{

    public abstract j getSessionAsync(String s);

    public abstract j revokeAsync(String s);

    public abstract j upgradeToRevocable(String s);
}
