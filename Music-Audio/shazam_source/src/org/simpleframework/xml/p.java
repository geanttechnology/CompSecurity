// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public interface p
{

    public abstract Object a(Class class1, InputStream inputstream);

    public abstract Object a(Class class1, Reader reader);

    public abstract Object a(Class class1, String s);

    public abstract Object a(Object obj, String s);

    public abstract void a(Object obj, OutputStream outputstream);

    public abstract void a(Object obj, Writer writer);
}
