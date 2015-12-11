// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.droidparts.model;


// Referenced classes of package org.droidparts.model:
//            Model

public abstract class Entity extends Model
{

    private static final long serialVersionUID = 1L;
    public long id;

    public Entity()
    {
    }

    public int hashCode()
    {
        return getClass().hashCode() + (int)id;
    }
}
