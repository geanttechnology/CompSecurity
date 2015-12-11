// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.collect;


// Referenced classes of package org.roboguice.shaded.goole.common.collect:
//            Ordering

static class value extends ClassCastException
{

    final Object value;

    (Object obj)
    {
        super((new StringBuilder()).append("Cannot compare value: ").append(obj).toString());
        value = obj;
    }
}
