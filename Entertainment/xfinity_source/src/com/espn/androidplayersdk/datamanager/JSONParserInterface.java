// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.espn.androidplayersdk.datamanager;

import java.util.HashMap;
import org.json.JSONObject;

interface JSONParserInterface
{

    public abstract void errorHandler(int i);

    public abstract void parse(JSONObject jsonobject, HashMap hashmap);
}
