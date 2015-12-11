// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public interface ObjectStream
{

    public abstract ObjectInputStream objectInputStream()
        throws IOException;

    public abstract ObjectOutputStream objectOutputStream()
        throws IOException;
}
