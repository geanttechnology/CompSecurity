// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.filter.Filter;
import org.simpleframework.xml.filter.PlatformFilter;
import org.simpleframework.xml.strategy.Strategy;
import org.simpleframework.xml.strategy.TreeStrategy;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.NodeBuilder;
import org.simpleframework.xml.stream.OutputNode;
import org.simpleframework.xml.transform.Matcher;

// Referenced classes of package org.simpleframework.xml.core:
//            EmptyMatcher, Support, SessionManager, Traverser, 
//            Source, Context, Session

public class Persister
    implements Serializer
{

    private final Format format;
    private final SessionManager manager;
    private final Strategy strategy;
    private final Support support;

    public Persister()
    {
        this(((Map) (new HashMap())));
    }

    public Persister(Map map)
    {
        this(((Filter) (new PlatformFilter(map))));
    }

    public Persister(Map map, Format format1)
    {
        this(((Filter) (new PlatformFilter(map))));
    }

    public Persister(Filter filter)
    {
        this(((Strategy) (new TreeStrategy())), filter);
    }

    public Persister(Filter filter, Format format1)
    {
        this(((Strategy) (new TreeStrategy())), filter, format1);
    }

    public Persister(Filter filter, Matcher matcher)
    {
        this(((Strategy) (new TreeStrategy())), filter, matcher);
    }

    public Persister(Filter filter, Matcher matcher, Format format1)
    {
        this(((Strategy) (new TreeStrategy())), filter, matcher, format1);
    }

    public Persister(Strategy strategy1)
    {
        this(strategy1, ((Map) (new HashMap())));
    }

    public Persister(Strategy strategy1, Map map)
    {
        this(strategy1, ((Filter) (new PlatformFilter(map))));
    }

    public Persister(Strategy strategy1, Map map, Format format1)
    {
        this(strategy1, ((Filter) (new PlatformFilter(map))), format1);
    }

    public Persister(Strategy strategy1, Filter filter)
    {
        this(strategy1, filter, new Format());
    }

    public Persister(Strategy strategy1, Filter filter, Format format1)
    {
        this(strategy1, filter, ((Matcher) (new EmptyMatcher())), format1);
    }

    public Persister(Strategy strategy1, Filter filter, Matcher matcher)
    {
        this(strategy1, filter, matcher, new Format());
    }

    public Persister(Strategy strategy1, Filter filter, Matcher matcher, Format format1)
    {
        support = new Support(filter, matcher, format1);
        manager = new SessionManager();
        strategy = strategy1;
        format = format1;
    }

    public Persister(Strategy strategy1, Format format1)
    {
        this(strategy1, ((Map) (new HashMap())), format1);
    }

    public Persister(Strategy strategy1, Matcher matcher)
    {
        this(strategy1, ((Filter) (new PlatformFilter())), matcher);
    }

    public Persister(Strategy strategy1, Matcher matcher, Format format1)
    {
        this(strategy1, ((Filter) (new PlatformFilter())), matcher, format1);
    }

    public Persister(Format format1)
    {
        this(((Strategy) (new TreeStrategy())), format1);
    }

    public Persister(Matcher matcher)
    {
        this(((Strategy) (new TreeStrategy())), matcher);
    }

    public Persister(Matcher matcher, Format format1)
    {
        this(((Strategy) (new TreeStrategy())), matcher, format1);
    }

    private Object read(Class class1, InputNode inputnode, Context context)
        throws Exception
    {
        return (new Traverser(context)).read(inputnode, class1);
    }

    private Object read(Class class1, InputNode inputnode, Session session)
        throws Exception
    {
        return read(class1, inputnode, ((Context) (new Source(strategy, support, session))));
    }

    private Object read(Object obj, InputNode inputnode, Context context)
        throws Exception
    {
        return (new Traverser(context)).read(inputnode, obj);
    }

    private Object read(Object obj, InputNode inputnode, Session session)
        throws Exception
    {
        return read(obj, inputnode, ((Context) (new Source(strategy, support, session))));
    }

    private boolean validate(Class class1, InputNode inputnode, Context context)
        throws Exception
    {
        return (new Traverser(context)).validate(inputnode, class1);
    }

    private boolean validate(Class class1, InputNode inputnode, Session session)
        throws Exception
    {
        return validate(class1, inputnode, ((Context) (new Source(strategy, support, session))));
    }

    private void write(Object obj, OutputNode outputnode, Context context)
        throws Exception
    {
        (new Traverser(context)).write(outputnode, obj);
    }

    private void write(Object obj, OutputNode outputnode, Session session)
        throws Exception
    {
        write(obj, outputnode, ((Context) (new Source(strategy, support, session))));
    }

    public Object read(Class class1, File file)
        throws Exception
    {
        return read(class1, file, true);
    }

    public Object read(Class class1, File file, boolean flag)
        throws Exception
    {
        file = new FileInputStream(file);
        class1 = ((Class) (read(class1, ((InputStream) (file)), flag)));
        file.close();
        return class1;
        class1;
        file.close();
        throw class1;
    }

    public Object read(Class class1, InputStream inputstream)
        throws Exception
    {
        return read(class1, inputstream, true);
    }

    public Object read(Class class1, InputStream inputstream, boolean flag)
        throws Exception
    {
        return read(class1, NodeBuilder.read(inputstream), flag);
    }

    public Object read(Class class1, Reader reader)
        throws Exception
    {
        return read(class1, reader, true);
    }

    public Object read(Class class1, Reader reader, boolean flag)
        throws Exception
    {
        return read(class1, NodeBuilder.read(reader), flag);
    }

    public Object read(Class class1, String s)
        throws Exception
    {
        return read(class1, s, true);
    }

    public Object read(Class class1, String s, boolean flag)
        throws Exception
    {
        return read(class1, ((Reader) (new StringReader(s))), flag);
    }

    public Object read(Class class1, InputNode inputnode)
        throws Exception
    {
        return read(class1, inputnode, true);
    }

    public Object read(Class class1, InputNode inputnode, boolean flag)
        throws Exception
    {
        Session session = manager.open(flag);
        class1 = ((Class) (read(class1, inputnode, session)));
        manager.close();
        return class1;
        class1;
        manager.close();
        throw class1;
    }

    public Object read(Object obj, File file)
        throws Exception
    {
        return read(obj, file, true);
    }

    public Object read(Object obj, File file, boolean flag)
        throws Exception
    {
        file = new FileInputStream(file);
        obj = read(obj, ((InputStream) (file)), flag);
        file.close();
        return obj;
        obj;
        file.close();
        throw obj;
    }

    public Object read(Object obj, InputStream inputstream)
        throws Exception
    {
        return read(obj, inputstream, true);
    }

    public Object read(Object obj, InputStream inputstream, boolean flag)
        throws Exception
    {
        return read(obj, NodeBuilder.read(inputstream), flag);
    }

    public Object read(Object obj, Reader reader)
        throws Exception
    {
        return read(obj, reader, true);
    }

    public Object read(Object obj, Reader reader, boolean flag)
        throws Exception
    {
        return read(obj, NodeBuilder.read(reader), flag);
    }

    public Object read(Object obj, String s)
        throws Exception
    {
        return read(obj, s, true);
    }

    public Object read(Object obj, String s, boolean flag)
        throws Exception
    {
        return read(obj, ((Reader) (new StringReader(s))), flag);
    }

    public Object read(Object obj, InputNode inputnode)
        throws Exception
    {
        return read(obj, inputnode, true);
    }

    public Object read(Object obj, InputNode inputnode, boolean flag)
        throws Exception
    {
        Session session = manager.open(flag);
        obj = read(obj, inputnode, session);
        manager.close();
        return obj;
        obj;
        manager.close();
        throw obj;
    }

    public boolean validate(Class class1, File file)
        throws Exception
    {
        return validate(class1, file, true);
    }

    public boolean validate(Class class1, File file, boolean flag)
        throws Exception
    {
        file = new FileInputStream(file);
        flag = validate(class1, ((InputStream) (file)), flag);
        file.close();
        return flag;
        class1;
        file.close();
        throw class1;
    }

    public boolean validate(Class class1, InputStream inputstream)
        throws Exception
    {
        return validate(class1, inputstream, true);
    }

    public boolean validate(Class class1, InputStream inputstream, boolean flag)
        throws Exception
    {
        return validate(class1, NodeBuilder.read(inputstream), flag);
    }

    public boolean validate(Class class1, Reader reader)
        throws Exception
    {
        return validate(class1, reader, true);
    }

    public boolean validate(Class class1, Reader reader, boolean flag)
        throws Exception
    {
        return validate(class1, NodeBuilder.read(reader), flag);
    }

    public boolean validate(Class class1, String s)
        throws Exception
    {
        return validate(class1, s, true);
    }

    public boolean validate(Class class1, String s, boolean flag)
        throws Exception
    {
        return validate(class1, ((Reader) (new StringReader(s))), flag);
    }

    public boolean validate(Class class1, InputNode inputnode)
        throws Exception
    {
        return validate(class1, inputnode, true);
    }

    public boolean validate(Class class1, InputNode inputnode, boolean flag)
        throws Exception
    {
        Session session = manager.open(flag);
        flag = validate(class1, inputnode, session);
        manager.close();
        return flag;
        class1;
        manager.close();
        throw class1;
    }

    public void write(Object obj, File file)
        throws Exception
    {
        file = new FileOutputStream(file);
        write(obj, ((OutputStream) (file)));
        file.close();
        return;
        obj;
        file.close();
        throw obj;
    }

    public void write(Object obj, OutputStream outputstream)
        throws Exception
    {
        write(obj, outputstream, "utf-8");
    }

    public void write(Object obj, OutputStream outputstream, String s)
        throws Exception
    {
        write(obj, ((Writer) (new OutputStreamWriter(outputstream, s))));
    }

    public void write(Object obj, Writer writer)
        throws Exception
    {
        write(obj, NodeBuilder.write(writer, format));
    }

    public void write(Object obj, OutputNode outputnode)
        throws Exception
    {
        Session session = manager.open();
        write(obj, outputnode, session);
        manager.close();
        return;
        obj;
        manager.close();
        throw obj;
    }
}
