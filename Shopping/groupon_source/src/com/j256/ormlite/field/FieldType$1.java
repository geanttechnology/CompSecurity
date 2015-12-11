// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.field;


// Referenced classes of package com.j256.ormlite.field:
//            FieldType

static final class velCounters extends ThreadLocal
{

    protected velCounters initialValue()
    {
        return new velCounters(null);
    }

    protected volatile Object initialValue()
    {
        return initialValue();
    }

    velCounters()
    {
    }
}
