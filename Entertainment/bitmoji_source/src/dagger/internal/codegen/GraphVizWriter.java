// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package dagger.internal.codegen;

import com.squareup.javawriter.JavaWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.Writer;
import java.util.LinkedHashMap;
import java.util.Map;

public final class GraphVizWriter
    implements Closeable
{

    private static final String INDENT = "  ";
    private final Map generatedNames = new LinkedHashMap();
    private int indent;
    private int nextName;
    private final Writer out;

    public GraphVizWriter(Writer writer)
    {
        indent = 0;
        nextName = 1;
        out = writer;
    }

    private void attributes(String as[])
        throws IOException
    {
        if (as.length != 0)
        {
            if (as.length % 2 != 0)
            {
                throw new IllegalArgumentException();
            }
            int i = 0;
            while (i < as.length) 
            {
                indent();
                out.write(as[i]);
                out.write(" = ");
                out.write(literal(as[i + 1]));
                out.write(";\n");
                i += 2;
            }
        }
    }

    private void indent()
        throws IOException
    {
        for (int i = 0; i < indent; i++)
        {
            out.write("  ");
        }

    }

    private void inlineAttributes(String as[])
        throws IOException
    {
        if (as.length == 0)
        {
            return;
        }
        if (as.length % 2 != 0)
        {
            throw new IllegalArgumentException();
        }
        out.write(" [");
        for (int i = 0; i < as.length; i += 2)
        {
            if (i != 0)
            {
                out.write(";");
            }
            out.write(as[i]);
            out.write("=");
            out.write(literal(as[i + 1]));
        }

        out.write("]");
    }

    private String literal(String s)
    {
        if (s.matches("\\w+"))
        {
            return s;
        } else
        {
            return JavaWriter.stringLiteral(s);
        }
    }

    private String nextName(String s)
    {
        s = (new StringBuilder()).append(s);
        int i = nextName;
        nextName = i + 1;
        return s.append(i).toString();
    }

    private String nodeName(String s)
        throws IOException
    {
        String s1;
        if (s.matches("\\w+"))
        {
            s1 = s;
        } else
        {
            String s3 = (String)generatedNames.get(s);
            s1 = s3;
            if (s3 == null)
            {
                String s2 = nextName("n");
                generatedNames.put(s, s2);
                node(s2, new String[] {
                    "label", s
                });
                return s2;
            }
        }
        return s1;
    }

    public transient void beginGraph(String as[])
        throws IOException
    {
        indent();
        String s;
        String s1;
        if (indent == 0)
        {
            s = "digraph ";
        } else
        {
            s = "subgraph ";
        }
        if (indent == 0)
        {
            s1 = "G";
        } else
        {
            s1 = "cluster";
        }
        s1 = nextName(s1);
        out.write(s);
        out.write(s1);
        out.write(" {\n");
        indent = indent + 1;
        attributes(as);
    }

    public void close()
        throws IOException
    {
        out.close();
    }

    public transient void edge(String s, String s1, String as[])
        throws IOException
    {
        s = nodeName(s);
        s1 = nodeName(s1);
        indent();
        out.write(s);
        out.write(" -> ");
        out.write(s1);
        inlineAttributes(as);
        out.write(";\n");
    }

    public transient void edgeDefaults(String as[])
        throws IOException
    {
        if (as.length == 0)
        {
            return;
        } else
        {
            indent();
            out.write("edge");
            inlineAttributes(as);
            out.write(";\n");
            return;
        }
    }

    public void endGraph()
        throws IOException
    {
        indent = indent - 1;
        indent();
        out.write("}\n");
    }

    public transient void node(String s, String as[])
        throws IOException
    {
        s = nodeName(s);
        indent();
        out.write(s);
        inlineAttributes(as);
        out.write(";\n");
    }

    public transient void nodeDefaults(String as[])
        throws IOException
    {
        if (as.length == 0)
        {
            return;
        } else
        {
            indent();
            out.write("node");
            inlineAttributes(as);
            out.write(";\n");
            return;
        }
    }
}
