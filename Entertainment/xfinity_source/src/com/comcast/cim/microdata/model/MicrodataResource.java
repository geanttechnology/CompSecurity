// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.microdata.model;


// Referenced classes of package com.comcast.cim.microdata.model:
//            MicrodataItemImpl, MicrodataProperty

public class MicrodataResource extends MicrodataItemImpl
{

    private boolean canonical;

    public MicrodataResource(String s)
    {
        super(s);
        canonical = false;
    }

    public MicrodataProperty get(String s)
    {
        return super.get(s);
    }

    public MicrodataProperty get(String s, boolean flag)
    {
        return super.get(s);
    }

    public boolean isCanonical()
    {
        return canonical;
    }

    public void setCanonical(boolean flag)
    {
        canonical = flag;
    }
}
