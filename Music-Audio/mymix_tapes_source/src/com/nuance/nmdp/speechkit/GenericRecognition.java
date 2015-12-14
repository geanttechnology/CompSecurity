// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit;


public interface GenericRecognition
{

    public abstract com.nuance.nmdp.speechkit.util.pdx.PdxValue.Dictionary getAppserverResult();

    public abstract com.nuance.nmdp.speechkit.util.pdx.PdxValue.Dictionary getFullResult();

    public abstract boolean isFinalResult();
}
