// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.timeline.model;

import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.kindle.timeline.model:
//            ExpandableListComponent

public interface ExpandableContainer
    extends ExpandableListComponent
{

    public abstract List getSubItems();

    public abstract void setContainerHighlighted(boolean flag);
}
