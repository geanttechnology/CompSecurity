// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse.gdata;


public interface Escaper
{

    public abstract Appendable escape(Appendable appendable);

    public abstract String escape(String s);
}
