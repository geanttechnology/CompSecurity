// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

public interface Serializer
{

    public abstract Object read(Class class1, File file)
        throws Exception;

    public abstract Object read(Class class1, File file, boolean flag)
        throws Exception;

    public abstract Object read(Class class1, InputStream inputstream)
        throws Exception;

    public abstract Object read(Class class1, InputStream inputstream, boolean flag)
        throws Exception;

    public abstract Object read(Class class1, Reader reader)
        throws Exception;

    public abstract Object read(Class class1, Reader reader, boolean flag)
        throws Exception;

    public abstract Object read(Class class1, String s)
        throws Exception;

    public abstract Object read(Class class1, String s, boolean flag)
        throws Exception;

    public abstract Object read(Class class1, InputNode inputnode)
        throws Exception;

    public abstract Object read(Class class1, InputNode inputnode, boolean flag)
        throws Exception;

    public abstract Object read(Object obj, File file)
        throws Exception;

    public abstract Object read(Object obj, File file, boolean flag)
        throws Exception;

    public abstract Object read(Object obj, InputStream inputstream)
        throws Exception;

    public abstract Object read(Object obj, InputStream inputstream, boolean flag)
        throws Exception;

    public abstract Object read(Object obj, Reader reader)
        throws Exception;

    public abstract Object read(Object obj, Reader reader, boolean flag)
        throws Exception;

    public abstract Object read(Object obj, String s)
        throws Exception;

    public abstract Object read(Object obj, String s, boolean flag)
        throws Exception;

    public abstract Object read(Object obj, InputNode inputnode)
        throws Exception;

    public abstract Object read(Object obj, InputNode inputnode, boolean flag)
        throws Exception;

    public abstract boolean validate(Class class1, File file)
        throws Exception;

    public abstract boolean validate(Class class1, File file, boolean flag)
        throws Exception;

    public abstract boolean validate(Class class1, InputStream inputstream)
        throws Exception;

    public abstract boolean validate(Class class1, InputStream inputstream, boolean flag)
        throws Exception;

    public abstract boolean validate(Class class1, Reader reader)
        throws Exception;

    public abstract boolean validate(Class class1, Reader reader, boolean flag)
        throws Exception;

    public abstract boolean validate(Class class1, String s)
        throws Exception;

    public abstract boolean validate(Class class1, String s, boolean flag)
        throws Exception;

    public abstract boolean validate(Class class1, InputNode inputnode)
        throws Exception;

    public abstract boolean validate(Class class1, InputNode inputnode, boolean flag)
        throws Exception;

    public abstract void write(Object obj, File file)
        throws Exception;

    public abstract void write(Object obj, OutputStream outputstream)
        throws Exception;

    public abstract void write(Object obj, Writer writer)
        throws Exception;

    public abstract void write(Object obj, OutputNode outputnode)
        throws Exception;
}
