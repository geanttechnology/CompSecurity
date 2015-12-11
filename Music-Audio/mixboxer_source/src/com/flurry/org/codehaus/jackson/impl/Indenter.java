// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.impl;

import com.flurry.org.codehaus.jackson.JsonGenerationException;
import com.flurry.org.codehaus.jackson.JsonGenerator;
import java.io.IOException;

public interface Indenter
{

    public abstract boolean isInline();

    public abstract void writeIndentation(JsonGenerator jsongenerator, int i)
        throws IOException, JsonGenerationException;
}
