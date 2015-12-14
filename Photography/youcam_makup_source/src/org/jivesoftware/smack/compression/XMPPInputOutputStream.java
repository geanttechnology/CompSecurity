// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jivesoftware.smack.compression;

import java.io.InputStream;
import java.io.OutputStream;

public abstract class XMPPInputOutputStream
{

    protected static FlushMethod a;
    protected String b;

    public XMPPInputOutputStream()
    {
    }

    public abstract InputStream a(InputStream inputstream);

    public abstract OutputStream a(OutputStream outputstream);

    public abstract boolean a();

    public String d()
    {
        return b;
    }
}
