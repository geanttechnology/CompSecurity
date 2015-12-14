// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model.serializer;

import java.io.IOException;
import org.codehaus.jackson.JsonGenerator;

public interface JsonSerializer
{

    public abstract void serialize(Object obj, JsonGenerator jsongenerator)
        throws IOException;
}
