// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.model;


// Referenced classes of package com.amazon.gallery.framework.model:
//            ObjectID

public interface Persistable
{

    public abstract long getId();

    public abstract ObjectID getObjectId();

    public abstract void setObjectId(ObjectID objectid);
}
