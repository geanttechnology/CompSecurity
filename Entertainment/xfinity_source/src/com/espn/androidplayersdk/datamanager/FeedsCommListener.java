// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.espn.androidplayersdk.datamanager;

import java.util.HashMap;
import org.apache.http.HttpEntity;
import org.json.JSONObject;

public interface FeedsCommListener
{

    public abstract void handleError(int i);

    public abstract void update(HttpEntity httpentity, String s);

    public abstract void update(JSONObject jsonobject, String s, HashMap hashmap);
}
