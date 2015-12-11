// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flow.android.engine.library.impl.servermatch;


public interface HttpManagerInterface
{

    public abstract void didReceiveImageMatchResponse(String s, com.a9.vs.mobile.library.impl.jni.ServerResponse.Type type, double d);

    public abstract void didReceiveTextMatchResponse(String s, com.a9.vs.mobile.library.impl.jni.ServerResponse.Type type, double d);
}
