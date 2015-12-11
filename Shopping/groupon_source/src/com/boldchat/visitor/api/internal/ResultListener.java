// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.visitor.api.internal;

import com.boldchat.visitor.api.json.JSONObject;
import java.io.IOException;

public interface ResultListener
{

    public abstract void failure(int i, String s, JSONObject jsonobject);

    public abstract void failure(IOException ioexception);

    public abstract void success(JSONObject jsonobject);
}
