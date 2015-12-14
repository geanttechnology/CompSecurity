// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model.deserializer;

import java.io.IOException;
import org.codehaus.jackson.JsonParser;

public interface JsonFieldDeserializer
{

    public abstract boolean handleField(JsonParser jsonparser, String s, Object obj)
        throws IOException;
}
