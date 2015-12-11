// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import org.simpleframework.xml.strategy.Type;

// Referenced classes of package org.simpleframework.xml.core:
//            Label, KeyBuilder

abstract class TemplateLabel
    implements Label
{

    private final KeyBuilder builder = new KeyBuilder(this);

    protected TemplateLabel()
    {
    }

    public Type getDependent()
        throws Exception
    {
        return null;
    }

    public String getEntry()
        throws Exception
    {
        return null;
    }

    public Object getKey()
        throws Exception
    {
        return builder.getKey();
    }

    public Label getLabel(Class class1)
        throws Exception
    {
        return this;
    }

    public String[] getNames()
        throws Exception
    {
        return (new String[] {
            getPath(), getName()
        });
    }

    public String[] getPaths()
        throws Exception
    {
        return (new String[] {
            getPath()
        });
    }

    public Type getType(Class class1)
        throws Exception
    {
        return getContact();
    }

    public boolean isAttribute()
    {
        return false;
    }

    public boolean isCollection()
    {
        return false;
    }

    public boolean isInline()
    {
        return false;
    }

    public boolean isText()
    {
        return false;
    }

    public boolean isUnion()
    {
        return false;
    }
}
