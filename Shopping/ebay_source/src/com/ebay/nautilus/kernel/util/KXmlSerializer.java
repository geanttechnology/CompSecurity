// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.util;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Locale;
import org.xmlpull.v1.XmlSerializer;

public class KXmlSerializer
    implements XmlSerializer
{

    private static final int WRITE_BUFFER_SIZE = 500;
    private int auto;
    private int depth;
    private String elementStack[];
    private String encoding;
    private boolean indent[];
    private int nspCounts[];
    private String nspStack[];
    private boolean pending;
    private boolean unicode;
    private BufferedWriter writer;

    public KXmlSerializer()
    {
        elementStack = new String[12];
        nspCounts = new int[4];
        nspStack = new String[8];
        indent = new boolean[4];
    }

    private final void check(boolean flag)
        throws IOException
    {
        int i;
        if (!pending)
        {
            return;
        }
        depth = depth + 1;
        pending = false;
        if (indent.length <= depth)
        {
            boolean aflag[] = new boolean[depth + 4];
            System.arraycopy(indent, 0, aflag, 0, depth);
            indent = aflag;
        }
        indent[depth] = indent[depth - 1];
        i = nspCounts[depth - 1];
_L2:
        if (i >= nspCounts[depth])
        {
            break MISSING_BLOCK_LABEL_249;
        }
        writer.write(32);
        writer.write("xmlns");
        if (nspStack[i * 2].isEmpty())
        {
            break; /* Loop/switch isn't completed */
        }
        writer.write(58);
        writer.write(nspStack[i * 2]);
_L4:
        writer.write("=\"");
        writeEscaped(nspStack[i * 2 + 1], 34);
        writer.write(34);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        if (!getNamespace().isEmpty() || nspStack[i * 2 + 1].isEmpty()) goto _L4; else goto _L3
_L3:
        throw new IllegalStateException("Cannot set default namespace for elements in no namespace");
        if (nspCounts.length <= depth + 1)
        {
            int ai[] = new int[depth + 8];
            System.arraycopy(nspCounts, 0, ai, 0, depth + 1);
            nspCounts = ai;
        }
        nspCounts[depth + 1] = nspCounts[depth];
        BufferedWriter bufferedwriter = writer;
        String s;
        if (flag)
        {
            s = " />";
        } else
        {
            s = ">";
        }
        bufferedwriter.write(s);
        return;
    }

    private final String getPrefix(String s, boolean flag, boolean flag1)
        throws IOException
    {
label0:
        for (int i = nspCounts[depth + 1] * 2 - 2; i >= 0; i -= 2)
        {
            if (!nspStack[i + 1].equals(s) || !flag && nspStack[i].isEmpty())
            {
                continue;
            }
            String s2 = nspStack[i];
            int k = i + 2;
            do
            {
label1:
                {
                    String s1 = s2;
                    if (k < nspCounts[depth + 1] * 2)
                    {
                        if (!nspStack[k].equals(s2))
                        {
                            break label1;
                        }
                        s1 = null;
                    }
                    if (s1 != null)
                    {
                        return s1;
                    }
                    continue label0;
                }
                k++;
            } while (true);
        }

        if (!flag1)
        {
            return null;
        }
        if (!s.isEmpty()) goto _L2; else goto _L1
_L1:
        Object obj = "";
_L5:
        flag = pending;
        pending = false;
        setPrefix(((String) (obj)), s);
        pending = flag;
        return ((String) (obj));
_L2:
        String s3;
        int j;
        obj = (new StringBuilder()).append("n");
        j = auto;
        auto = j + 1;
        s3 = ((StringBuilder) (obj)).append(j).toString();
        j = nspCounts[depth + 1] * 2 - 2;
_L6:
        obj = s3;
        if (j < 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!s3.equals(nspStack[j])) goto _L4; else goto _L3
_L3:
        obj = null;
        if (obj == null) goto _L2; else goto _L5
_L4:
        j -= 2;
          goto _L6
    }

    private static void reportInvalidCharacter(char c)
    {
        throw new IllegalArgumentException((new StringBuilder()).append("Illegal character (").append(Integer.toHexString(c)).append(")").toString());
    }

    private final void writeEscaped(String s, int i)
        throws IOException
    {
        int j = 0;
_L7:
        char c1;
        if (j >= s.length())
        {
            break MISSING_BLOCK_LABEL_401;
        }
        c1 = s.charAt(j);
        c1;
        JVM INSTR lookupswitch 6: default 80
    //                   9: 119
    //                   10: 119
    //                   13: 119
    //                   38: 171
    //                   60: 195
    //                   62: 183;
           goto _L1 _L2 _L2 _L2 _L3 _L4 _L5
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        char c;
        if (c1 == i)
        {
            BufferedWriter bufferedwriter = writer;
            String s1;
            if (c1 == '"')
            {
                s1 = "&quot;";
            } else
            {
                s1 = "&apos;";
            }
            bufferedwriter.write(s1);
        } else
        {
label0:
            {
                c = c1;
                if (c1 < '\uD800')
                {
                    break MISSING_BLOCK_LABEL_301;
                }
                c = c1;
                if (c1 > '\uDBFF')
                {
                    break MISSING_BLOCK_LABEL_301;
                }
                int k = j + 1;
                c = c1;
                if (k >= s.length())
                {
                    break label0;
                }
                c = s.charAt(k);
                if (c < '\uDC00' || c > '\uDFFF')
                {
                    break label0;
                }
                writer.write(c1);
                writer.write(c);
                j++;
            }
        }
_L8:
        j++;
        if (true) goto _L7; else goto _L6
_L6:
        if (i == -1)
        {
            writer.write(c1);
        } else
        {
            writer.write((new StringBuilder()).append("&#").append(c1).append(';').toString());
        }
        break MISSING_BLOCK_LABEL_110;
_L3:
        writer.write("&amp;");
        break MISSING_BLOCK_LABEL_110;
_L5:
        writer.write("&gt;");
        break MISSING_BLOCK_LABEL_110;
_L4:
        writer.write("&lt;");
        break MISSING_BLOCK_LABEL_110;
        reportInvalidCharacter(c);
        boolean flag;
        if (c >= ' ' && c <= '\uD7FF' || c >= '\uE000' && c <= '\uFFFD')
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            reportInvalidCharacter(c);
        }
        if (unicode || c < '\177')
        {
            writer.write(c);
        } else
        {
            writer.write((new StringBuilder()).append("&#").append(c).append(";").toString());
        }
          goto _L8
    }

    public XmlSerializer attribute(String s, String s1, String s2)
        throws IOException
    {
        byte byte0 = 34;
        if (!pending)
        {
            throw new IllegalStateException("illegal position for attribute");
        }
        String s3 = s;
        if (s == null)
        {
            s3 = "";
        }
        if (s3.isEmpty())
        {
            s = "";
        } else
        {
            s = getPrefix(s3, false, true);
        }
        writer.write(32);
        if (!s.isEmpty())
        {
            writer.write(s);
            writer.write(58);
        }
        writer.write(s1);
        writer.write(61);
        if (s2.indexOf('"') != -1)
        {
            byte0 = 39;
        }
        writer.write(byte0);
        writeEscaped(s2, byte0);
        writer.write(byte0);
        return this;
    }

    public void cdsect(String s)
        throws IOException
    {
        check(false);
        s = s.replace("]]>", "]]]]><![CDATA[>").toCharArray();
        int j = s.length;
        int i = 0;
        while (i < j) 
        {
            char c = s[i];
            boolean flag;
            if (c >= ' ' && c <= '\uD7FF' || c == '\t' || c == '\n' || c == '\r' || c >= '\uE000' && c <= '\uFFFD')
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                reportInvalidCharacter(c);
            }
            i++;
        }
        writer.write("<![CDATA[");
        writer.write(s, 0, s.length);
        writer.write("]]>");
    }

    public void comment(String s)
        throws IOException
    {
        check(false);
        writer.write("<!--");
        writer.write(s);
        writer.write("-->");
    }

    public void docdecl(String s)
        throws IOException
    {
        writer.write("<!DOCTYPE");
        writer.write(s);
        writer.write(">");
    }

    public void endDocument()
        throws IOException
    {
        while (depth > 0) 
        {
            endTag(elementStack[depth * 3 - 3], elementStack[depth * 3 - 1]);
        }
        flush();
    }

    public XmlSerializer endTag(String s, String s1)
        throws IOException
    {
        if (!pending)
        {
            depth = depth - 1;
        }
        if (s == null && elementStack[depth * 3] != null || s != null && !s.equals(elementStack[depth * 3]) || !elementStack[depth * 3 + 2].equals(s1))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("</{").append(s).append("}").append(s1).append("> does not match start").toString());
        }
        if (pending)
        {
            check(true);
            depth = depth - 1;
        } else
        {
            if (indent[depth + 1])
            {
                writer.write("\r\n");
                for (int i = 0; i < depth; i++)
                {
                    writer.write("  ");
                }

            }
            writer.write("</");
            s = elementStack[depth * 3 + 1];
            if (!s.isEmpty())
            {
                writer.write(s);
                writer.write(58);
            }
            writer.write(s1);
            writer.write(62);
        }
        nspCounts[depth + 1] = nspCounts[depth];
        return this;
    }

    public void entityRef(String s)
        throws IOException
    {
        check(false);
        writer.write(38);
        writer.write(s);
        writer.write(59);
    }

    public void flush()
        throws IOException
    {
        check(false);
        writer.flush();
    }

    public int getDepth()
    {
        if (pending)
        {
            return depth + 1;
        } else
        {
            return depth;
        }
    }

    public boolean getFeature(String s)
    {
        if ("http://xmlpull.org/v1/doc/features.html#indent-output".equals(s))
        {
            return indent[depth];
        } else
        {
            return false;
        }
    }

    public String getName()
    {
        if (getDepth() == 0)
        {
            return null;
        } else
        {
            return elementStack[getDepth() * 3 - 1];
        }
    }

    public String getNamespace()
    {
        if (getDepth() == 0)
        {
            return null;
        } else
        {
            return elementStack[getDepth() * 3 - 3];
        }
    }

    public String getPrefix(String s, boolean flag)
    {
        try
        {
            s = getPrefix(s, false, flag);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s.toString());
        }
        return s;
    }

    public Object getProperty(String s)
    {
        throw new RuntimeException("Unsupported property");
    }

    public void ignorableWhitespace(String s)
        throws IOException
    {
        text(s);
    }

    public void processingInstruction(String s)
        throws IOException
    {
        check(false);
        writer.write("<?");
        writer.write(s);
        writer.write("?>");
    }

    public void setFeature(String s, boolean flag)
    {
        if ("http://xmlpull.org/v1/doc/features.html#indent-output".equals(s))
        {
            indent[depth] = flag;
            return;
        } else
        {
            throw new RuntimeException("Unsupported Feature");
        }
    }

    public void setOutput(OutputStream outputstream, String s)
        throws IOException
    {
        if (outputstream == null)
        {
            throw new IllegalArgumentException("os == null");
        }
        if (s == null)
        {
            outputstream = new OutputStreamWriter(outputstream);
        } else
        {
            outputstream = new OutputStreamWriter(outputstream, s);
        }
        setOutput(((Writer) (outputstream)));
        encoding = s;
        if (s != null && s.toLowerCase(Locale.US).startsWith("utf"))
        {
            unicode = true;
        }
    }

    public void setOutput(Writer writer1)
    {
        if (writer1 instanceof BufferedWriter)
        {
            writer = (BufferedWriter)writer1;
        } else
        {
            writer = new BufferedWriter(writer1, 500);
        }
        nspCounts[0] = 2;
        nspCounts[1] = 2;
        nspStack[0] = "";
        nspStack[1] = "";
        nspStack[2] = "xml";
        nspStack[3] = "http://www.w3.org/XML/1998/namespace";
        pending = false;
        auto = 0;
        depth = 0;
        unicode = false;
    }

    public void setPrefix(String s, String s1)
        throws IOException
    {
        check(false);
        String s2 = s;
        if (s == null)
        {
            s2 = "";
        }
        s = s1;
        if (s1 == null)
        {
            s = "";
        }
        if (s2.equals(getPrefix(s, true, false)))
        {
            return;
        }
        s1 = nspCounts;
        int i = depth + 1;
        int j = s1[i];
        s1[i] = j + 1;
        i = j << 1;
        if (nspStack.length < i + 1)
        {
            s1 = new String[nspStack.length + 16];
            System.arraycopy(nspStack, 0, s1, 0, i);
            nspStack = s1;
        }
        nspStack[i] = s2;
        nspStack[i + 1] = s;
    }

    public void setProperty(String s, Object obj)
    {
        throw new RuntimeException((new StringBuilder()).append("Unsupported Property:").append(obj).toString());
    }

    public void startDocument(String s, Boolean boolean1)
        throws IOException
    {
        writer.write("<?xml version='1.0' ");
        if (s != null)
        {
            encoding = s;
            if (s.toLowerCase(Locale.US).startsWith("utf"))
            {
                unicode = true;
            }
        }
        if (encoding != null)
        {
            writer.write("encoding='");
            writer.write(encoding);
            writer.write("' ");
        }
        if (boolean1 != null)
        {
            writer.write("standalone='");
            BufferedWriter bufferedwriter = writer;
            if (boolean1.booleanValue())
            {
                s = "yes";
            } else
            {
                s = "no";
            }
            bufferedwriter.write(s);
            writer.write("' ");
        }
        writer.write("?>");
    }

    public XmlSerializer startTag(String s, String s1)
        throws IOException
    {
        check(false);
        if (indent[depth])
        {
            writer.write("\r\n");
            for (int i = 0; i < depth; i++)
            {
                writer.write("  ");
            }

        }
        int l = depth * 3;
        if (elementStack.length < l + 3)
        {
            String as[] = new String[elementStack.length + 12];
            System.arraycopy(elementStack, 0, as, 0, l);
            elementStack = as;
        }
        String s2;
        if (s == null)
        {
            s2 = "";
        } else
        {
            s2 = getPrefix(s, true, true);
        }
        if (s != null && s.isEmpty())
        {
            for (int j = nspCounts[depth]; j < nspCounts[depth + 1]; j++)
            {
                if (nspStack[j * 2].isEmpty() && !nspStack[j * 2 + 1].isEmpty())
                {
                    throw new IllegalStateException("Cannot set default namespace for elements in no namespace");
                }
            }

        }
        String as1[] = elementStack;
        int k = l + 1;
        as1[l] = s;
        elementStack[k] = s2;
        elementStack[k + 1] = s1;
        writer.write(60);
        if (!s2.isEmpty())
        {
            writer.write(s2);
            writer.write(58);
        }
        writer.write(s1);
        pending = true;
        return this;
    }

    public XmlSerializer text(String s)
        throws IOException
    {
        check(false);
        indent[depth] = false;
        writeEscaped(s, -1);
        return this;
    }

    public XmlSerializer text(char ac[], int i, int j)
        throws IOException
    {
        text(new String(ac, i, j));
        return this;
    }
}
