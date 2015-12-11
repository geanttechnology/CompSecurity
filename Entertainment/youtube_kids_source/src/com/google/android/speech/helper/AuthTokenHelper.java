// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.helper;

import java.util.Collection;

public interface AuthTokenHelper
{

    public abstract Collection blockingGetAllTokens(String s, long l);

    public abstract void invalidateToken(String s);
}
