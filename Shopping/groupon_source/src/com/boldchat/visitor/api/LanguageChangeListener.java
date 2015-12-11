// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.visitor.api;


public interface LanguageChangeListener
{

    public abstract void onLanguageChange(String s);

    public abstract void onLanguageChangeFailed(String s);
}
