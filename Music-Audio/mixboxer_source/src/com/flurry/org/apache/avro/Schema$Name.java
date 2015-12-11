// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro;

import com.flurry.org.codehaus.jackson.JsonGenerator;
import java.io.IOException;

// Referenced classes of package com.flurry.org.apache.avro:
//            Schema

private static class full
{

    private final String full;
    private final String name;
    private final String space;

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof full))
            {
                return false;
            }
            obj = (full)obj;
            if (full == null)
            {
                if (((full) (obj)).full != null)
                {
                    return false;
                }
            } else
            {
                return full.equals(((full) (obj)).full);
            }
        }
        return true;
    }

    public String getQualified(String s)
    {
        if (space == null || space.equals(s))
        {
            return name;
        } else
        {
            return full;
        }
    }

    public int hashCode()
    {
        if (full == null)
        {
            return 0;
        } else
        {
            return full.hashCode();
        }
    }

    public String toString()
    {
        return full;
    }

    public void writeName( , JsonGenerator jsongenerator)
        throws IOException
    {
        if (name != null)
        {
            jsongenerator.writeStringField("name", name);
        }
        if (space != null)
        {
            if (!space.equals(.space()))
            {
                jsongenerator.writeStringField("namespace", space);
            }
            if (.space() == null)
            {
                .space(space);
            }
        }
    }




    public erator(String s, String s1)
    {
        if (s == null)
        {
            full = null;
            space = null;
            name = null;
            return;
        }
        int i = s.lastIndexOf('.');
        if (i < 0)
        {
            space = s1;
            name = Schema.access$200(s);
        } else
        {
            space = s.substring(0, i);
            name = Schema.access$200(s.substring(i + 1, s.length()));
        }
        if (space == null)
        {
            s = name;
        } else
        {
            s = (new StringBuilder()).append(space).append(".").append(name).toString();
        }
        full = s;
    }
}
