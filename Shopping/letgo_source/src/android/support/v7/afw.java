// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.gson.stream.JsonReader;
import java.io.IOException;

public abstract class afw
{

    public static afw INSTANCE;

    public afw()
    {
    }

    public abstract void promoteNameToValue(JsonReader jsonreader)
        throws IOException;
}
