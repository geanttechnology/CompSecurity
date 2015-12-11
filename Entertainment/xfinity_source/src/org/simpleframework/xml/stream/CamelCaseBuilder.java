// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.stream;


// Referenced classes of package org.simpleframework.xml.stream:
//            Style, Splitter

class CamelCaseBuilder
    implements Style
{
    private class Attribute extends Splitter
    {

        private boolean capital;
        final CamelCaseBuilder this$0;

        protected void commit(char ac[], int i, int j)
        {
            builder.append(ac, i, j);
        }

        protected void parse(char ac[], int i, int j)
        {
            if (attribute || capital)
            {
                ac[i] = toUpper(ac[i]);
            }
            capital = true;
        }

        private Attribute(String s)
        {
            this$0 = CamelCaseBuilder.this;
            super(s);
        }

    }

    private class Element extends Attribute
    {

        private boolean capital;
        final CamelCaseBuilder this$0;

        protected void parse(char ac[], int i, int j)
        {
            if (element || capital)
            {
                ac[i] = toUpper(ac[i]);
            }
            capital = true;
        }

        private Element(String s)
        {
            this$0 = CamelCaseBuilder.this;
            super(s);
        }

    }


    protected final boolean attribute;
    protected final boolean element;

    public CamelCaseBuilder(boolean flag, boolean flag1)
    {
        attribute = flag1;
        element = flag;
    }

    public String getAttribute(String s)
    {
        String s1 = null;
        if (s != null)
        {
            s1 = (new Attribute(s)).process();
        }
        return s1;
    }

    public String getElement(String s)
    {
        String s1 = null;
        if (s != null)
        {
            s1 = (new Element(s)).process();
        }
        return s1;
    }
}
