// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model;


// Referenced classes of package com.xfinity.playerlib.model:
//            MerlinId

public interface Program
{

    public abstract MerlinId getMerlinId();

    public abstract MerlinId.Namespace getMerlinIdNamespace();

    public abstract MerlinId getParentMerlinIdIfApplicable();

    public abstract String getTitle();

    public abstract boolean isMovie();
}
