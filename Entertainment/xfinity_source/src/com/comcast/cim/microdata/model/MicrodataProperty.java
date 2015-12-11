// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.microdata.model;

import java.util.List;

// Referenced classes of package com.comcast.cim.microdata.model:
//            MicrodataItem, MicrodataLinkValue

public interface MicrodataProperty
{

    public abstract Boolean asBoolean();

    public abstract Boolean asBoolean(Boolean boolean1);

    public abstract Integer asInt();

    public abstract Integer asInt(Integer integer);

    public abstract MicrodataItem asItem();

    public abstract List asItems();

    public abstract MicrodataLinkValue asLink();

    public abstract List asList();

    public abstract List asList(List list);

    public abstract String asString();

    public abstract String asString(String s);

    public abstract String getName();

    public abstract Object getValue();

    public abstract List getValues();

    public abstract boolean isCollection();

    public abstract boolean isEmbedded();

    public abstract boolean isMissing();
}
