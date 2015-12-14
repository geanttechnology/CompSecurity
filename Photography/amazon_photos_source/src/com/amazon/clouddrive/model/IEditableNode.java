// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model;

import java.util.List;
import java.util.Map;

// Referenced classes of package com.amazon.clouddrive.model:
//            CollectionProperties, ContentProperties, Settings

public interface IEditableNode
{

    public abstract CollectionProperties getCollectionProperties();

    public abstract ContentProperties getContentProperties();

    public abstract String getDescription();

    public abstract String getId();

    public abstract String getKind();

    public abstract List getLabels();

    public abstract String getName();

    public abstract Map getParentMap();

    public abstract List getParents();

    public abstract Map getProperties();

    public abstract Settings getSettings();

    public abstract String getStatus();

    public abstract List getTransforms();

    public abstract void setCollectionProperties(CollectionProperties collectionproperties);

    public abstract void setContentProperties(ContentProperties contentproperties);

    public abstract void setDescription(String s);

    public abstract void setId(String s);

    public abstract void setKind(String s);

    public abstract void setLabels(List list);

    public abstract void setName(String s);

    public abstract void setParentMap(Map map);

    public abstract void setParents(List list);

    public abstract void setProperties(Map map);

    public abstract void setSettings(Settings settings);

    public abstract void setStatus(String s);

    public abstract void setTransforms(List list);
}
