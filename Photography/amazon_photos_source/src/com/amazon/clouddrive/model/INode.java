// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model;

import java.util.List;

// Referenced classes of package com.amazon.clouddrive.model:
//            IEditableNode

public interface INode
    extends IEditableNode
{

    public abstract void setAssets(List list);

    public abstract void setCreatedBy(String s);

    public abstract void setCreatedDate(String s);

    public abstract void setETagRequest(String s);

    public abstract void setETagResponse(String s);

    public abstract void setExclusivelyTrashed(Boolean boolean1);

    public abstract void setIsRoot(Boolean boolean1);

    public abstract void setIsShared(Boolean boolean1);

    public abstract void setModifiedDate(String s);

    public abstract void setRecursivelyTrashed(Boolean boolean1);

    public abstract void setTempLink(String s);

    public abstract void setVersion(long l);
}
