// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;

import java.io.IOException;

// Referenced classes of package com.google.protobuf:
//            TextFormat

private static final class <init>
{

    private boolean atStartOfLine;
    private final StringBuilder indent;
    private final Appendable output;

    private void write(CharSequence charsequence, int i)
        throws IOException
    {
        if (i == 0)
        {
            return;
        }
        if (atStartOfLine)
        {
            atStartOfLine = false;
            output.append(indent);
        }
        output.append(charsequence);
    }

    public void indent()
    {
        indent.append("  ");
    }

    public void outdent()
    {
        int i = indent.length();
        if (i == 0)
        {
            throw new IllegalArgumentException(" Outdent() without matching Indent().");
        } else
        {
            indent.delete(i - 2, i);
            return;
        }
    }

    public void print(CharSequence charsequence)
        throws IOException
    {
        int j = 0;
        int l = charsequence.length();
        for (int i = 0; i < l;)
        {
            int k = j;
            if (charsequence.charAt(i) == '\n')
            {
                write(charsequence.subSequence(j, l), (i - j) + 1);
                k = i + 1;
                atStartOfLine = true;
            }
            i++;
            j = k;
        }

        write(charsequence.subSequence(j, l), l - j);
    }

    private (Appendable appendable)
    {
        indent = new StringBuilder();
        atStartOfLine = true;
        output = appendable;
    }

    output(Appendable appendable, output output1)
    {
        this(appendable);
    }
}
