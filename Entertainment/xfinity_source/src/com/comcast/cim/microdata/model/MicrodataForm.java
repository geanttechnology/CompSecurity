// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.microdata.model;

import java.util.List;

// Referenced classes of package com.comcast.cim.microdata.model:
//            MicrodataFormValue

public interface MicrodataForm
{

    public abstract String getId();

    public abstract MicrodataFormValue getValue();

    public abstract List getValues();

    public abstract boolean isCollection();
}
