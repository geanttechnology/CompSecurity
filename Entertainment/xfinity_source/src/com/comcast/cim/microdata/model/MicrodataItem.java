// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.microdata.model;


// Referenced classes of package com.comcast.cim.microdata.model:
//            MicrodataProperty

public interface MicrodataItem
{

    public abstract MicrodataProperty get(String s);

    public abstract MicrodataProperty get(String s, boolean flag);

    public abstract String getId();

    public abstract String getType();

    public abstract boolean isCanonical();
}
