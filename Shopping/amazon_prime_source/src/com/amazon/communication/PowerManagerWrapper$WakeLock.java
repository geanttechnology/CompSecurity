// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;


// Referenced classes of package com.amazon.communication:
//            PowerManagerWrapper

public static interface 
{

    public abstract void acquire();

    public abstract boolean isHeld();

    public abstract void release();

    public abstract void setReferenceCounted(boolean flag);
}
