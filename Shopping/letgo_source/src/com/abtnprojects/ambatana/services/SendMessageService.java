// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.services;

import retrofit.Callback;
import retrofit.mime.TypedString;

public interface SendMessageService
{

    public abstract void sendMessage(String s, TypedString typedstring, TypedString typedstring1, TypedString typedstring2, Callback callback);
}
