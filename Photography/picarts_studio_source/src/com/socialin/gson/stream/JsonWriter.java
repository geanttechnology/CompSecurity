// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.gson.stream;

import java.io.Closeable;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.socialin.gson.stream:
//            JsonScope

public class JsonWriter
    implements Closeable
{

    private String deferredName;
    private boolean htmlSafe;
    private String indent;
    private boolean lenient;
    private final Writer out;
    private String separator;
    private boolean serializeNulls;
    private final List stack = new ArrayList();

    public JsonWriter(Writer writer)
    {
        stack.add(JsonScope.EMPTY_DOCUMENT);
        separator = ":";
        serializeNulls = true;
        if (writer == null)
        {
            throw new NullPointerException("out == null");
        } else
        {
            out = writer;
            return;
        }
    }

    private void beforeName()
    {
        JsonScope jsonscope = peek();
        if (jsonscope == JsonScope.NONEMPTY_OBJECT)
        {
            out.write(44);
        } else
        if (jsonscope != JsonScope.EMPTY_OBJECT)
        {
            throw new IllegalStateException((new StringBuilder("Nesting problem: ")).append(stack).toString());
        }
        newline();
        replaceTop(JsonScope.DANGLING_NAME);
    }

    private void beforeValue(boolean flag)
    {
        switch (_cls1..SwitchMap.com.google.gson.stream.JsonScope[peek().ordinal()])
        {
        default:
            throw new IllegalStateException((new StringBuilder("Nesting problem: ")).append(stack).toString());

        case 1: // '\001'
            if (!lenient && !flag)
            {
                throw new IllegalStateException("JSON must start with an array or an object.");
            } else
            {
                replaceTop(JsonScope.NONEMPTY_DOCUMENT);
                return;
            }

        case 2: // '\002'
            replaceTop(JsonScope.NONEMPTY_ARRAY);
            newline();
            return;

        case 3: // '\003'
            out.append(',');
            newline();
            return;

        case 4: // '\004'
            out.append(separator);
            replaceTop(JsonScope.NONEMPTY_OBJECT);
            return;

        case 5: // '\005'
            throw new IllegalStateException("JSON must have only one top-level value.");
        }
    }

    private JsonWriter close(JsonScope jsonscope, JsonScope jsonscope1, String s)
    {
        JsonScope jsonscope2 = peek();
        if (jsonscope2 != jsonscope1 && jsonscope2 != jsonscope)
        {
            throw new IllegalStateException((new StringBuilder("Nesting problem: ")).append(stack).toString());
        }
        if (deferredName != null)
        {
            throw new IllegalStateException((new StringBuilder("Dangling name: ")).append(deferredName).toString());
        }
        stack.remove(stack.size() - 1);
        if (jsonscope2 == jsonscope1)
        {
            newline();
        }
        out.write(s);
        return this;
    }

    private void newline()
    {
        if (indent != null)
        {
            out.write("\n");
            int i = 1;
            while (i < stack.size()) 
            {
                out.write(indent);
                i++;
            }
        }
    }

    private JsonWriter open(JsonScope jsonscope, String s)
    {
        beforeValue(true);
        stack.add(jsonscope);
        out.write(s);
        return this;
    }

    private JsonScope peek()
    {
        return (JsonScope)stack.get(stack.size() - 1);
    }

    private void replaceTop(JsonScope jsonscope)
    {
        stack.set(stack.size() - 1, jsonscope);
    }

    private void string(String s)
    {
        int i;
        int j;
        out.write("\"");
        j = s.length();
        i = 0;
_L12:
        char c;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_344;
        }
        c = s.charAt(i);
        c;
        JVM INSTR lookupswitch 14: default 152
    //                   8: 223
    //                   9: 211
    //                   10: 235
    //                   12: 259
    //                   13: 247
    //                   34: 190
    //                   38: 271
    //                   39: 271
    //                   60: 271
    //                   61: 271
    //                   62: 271
    //                   92: 190
    //                   8232: 317
    //                   8233: 317;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L8 _L8 _L8 _L8 _L7 _L9 _L9
_L9:
        break MISSING_BLOCK_LABEL_317;
_L1:
        if (c > '\037') goto _L11; else goto _L10
_L10:
        out.write(String.format("\\u%04x", new Object[] {
            Integer.valueOf(c)
        }));
_L13:
        i++;
          goto _L12
_L7:
        out.write(92);
_L11:
        out.write(c);
          goto _L13
_L3:
        out.write("\\t");
          goto _L13
_L2:
        out.write("\\b");
          goto _L13
_L4:
        out.write("\\n");
          goto _L13
_L6:
        out.write("\\r");
          goto _L13
_L5:
        out.write("\\f");
          goto _L13
_L8:
        if (htmlSafe)
        {
            out.write(String.format("\\u%04x", new Object[] {
                Integer.valueOf(c)
            }));
        } else
        {
            out.write(c);
        }
          goto _L13
        out.write(String.format("\\u%04x", new Object[] {
            Integer.valueOf(c)
        }));
          goto _L13
        out.write("\"");
        return;
    }

    private void writeDeferredName()
    {
        if (deferredName != null)
        {
            beforeName();
            string(deferredName);
            deferredName = null;
        }
    }

    public JsonWriter beginArray()
    {
        writeDeferredName();
        return open(JsonScope.EMPTY_ARRAY, "[");
    }

    public JsonWriter beginObject()
    {
        writeDeferredName();
        return open(JsonScope.EMPTY_OBJECT, "{");
    }

    public void close()
    {
        out.close();
        if (peek() != JsonScope.NONEMPTY_DOCUMENT)
        {
            throw new IOException("Incomplete document");
        } else
        {
            return;
        }
    }

    public JsonWriter endArray()
    {
        return close(JsonScope.EMPTY_ARRAY, JsonScope.NONEMPTY_ARRAY, "]");
    }

    public JsonWriter endObject()
    {
        return close(JsonScope.EMPTY_OBJECT, JsonScope.NONEMPTY_OBJECT, "}");
    }

    public void flush()
    {
        out.flush();
    }

    public final boolean getSerializeNulls()
    {
        return serializeNulls;
    }

    public final boolean isHtmlSafe()
    {
        return htmlSafe;
    }

    public boolean isLenient()
    {
        return lenient;
    }

    public JsonWriter name(String s)
    {
        if (s == null)
        {
            throw new NullPointerException("name == null");
        }
        if (deferredName != null)
        {
            throw new IllegalStateException();
        } else
        {
            deferredName = s;
            return this;
        }
    }

    public JsonWriter nullValue()
    {
label0:
        {
            if (deferredName != null)
            {
                if (!serializeNulls)
                {
                    break label0;
                }
                writeDeferredName();
            }
            beforeValue(false);
            out.write("null");
            return this;
        }
        deferredName = null;
        return this;
    }

    public final void setHtmlSafe(boolean flag)
    {
        htmlSafe = flag;
    }

    public final void setIndent(String s)
    {
        if (s.length() == 0)
        {
            indent = null;
            separator = ":";
            return;
        } else
        {
            indent = s;
            separator = ": ";
            return;
        }
    }

    public final void setLenient(boolean flag)
    {
        lenient = flag;
    }

    public final void setSerializeNulls(boolean flag)
    {
        serializeNulls = flag;
    }

    public JsonWriter value(double d)
    {
        if (Double.isNaN(d) || Double.isInfinite(d))
        {
            throw new IllegalArgumentException((new StringBuilder("Numeric values must be finite, but was ")).append(d).toString());
        } else
        {
            writeDeferredName();
            beforeValue(false);
            out.append(Double.toString(d));
            return this;
        }
    }

    public JsonWriter value(long l)
    {
        writeDeferredName();
        beforeValue(false);
        out.write(Long.toString(l));
        return this;
    }

    public JsonWriter value(Number number)
    {
        if (number == null)
        {
            return nullValue();
        }
        writeDeferredName();
        String s = number.toString();
        if (!lenient && (s.equals("-Infinity") || s.equals("Infinity") || s.equals("NaN")))
        {
            throw new IllegalArgumentException((new StringBuilder("Numeric values must be finite, but was ")).append(number).toString());
        } else
        {
            beforeValue(false);
            out.append(s);
            return this;
        }
    }

    public JsonWriter value(String s)
    {
        if (s == null)
        {
            return nullValue();
        } else
        {
            writeDeferredName();
            beforeValue(false);
            string(s);
            return this;
        }
    }

    public JsonWriter value(boolean flag)
    {
        writeDeferredName();
        beforeValue(false);
        Writer writer = out;
        String s;
        if (flag)
        {
            s = "true";
        } else
        {
            s = "false";
        }
        writer.write(s);
        return this;
    }

    /* member class not found */
    class _cls1 {}

}
