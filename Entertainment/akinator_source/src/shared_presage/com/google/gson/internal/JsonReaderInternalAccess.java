// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.gson.internal;

import shared_presage.com.google.gson.stream.JsonReader;

public abstract class JsonReaderInternalAccess
{

    public static JsonReaderInternalAccess INSTANCE;

    public JsonReaderInternalAccess()
    {
    }

    public abstract void promoteNameToValue(JsonReader jsonreader);
}
