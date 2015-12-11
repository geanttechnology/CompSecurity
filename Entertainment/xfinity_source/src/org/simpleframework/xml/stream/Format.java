// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.stream;


// Referenced classes of package org.simpleframework.xml.stream:
//            IdentityStyle, Style

public class Format
{

    private int indent;
    private String prolog;
    private Style style;

    public Format()
    {
        this(3);
    }

    public Format(int i)
    {
        this(i, null, ((Style) (new IdentityStyle())));
    }

    public Format(int i, String s)
    {
        this(i, s, ((Style) (new IdentityStyle())));
    }

    public Format(int i, String s, Style style1)
    {
        prolog = s;
        indent = i;
        style = style1;
    }

    public Format(int i, Style style1)
    {
        this(i, null, style1);
    }

    public Format(String s)
    {
        this(3, s);
    }

    public Format(Style style1)
    {
        this(3, null, style1);
    }

    public int getIndent()
    {
        return indent;
    }

    public String getProlog()
    {
        return prolog;
    }

    public Style getStyle()
    {
        return style;
    }
}
