// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.parser;

import org.apache.james.mime4j.util.ByteSequence;

public interface Field
{

    public abstract String getBody();

    public abstract String getName();

    public abstract ByteSequence getRaw();
}
