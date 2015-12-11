// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.gson.internal;


// Referenced classes of package shared_presage.com.google.gson.internal:
//            UnsafeAllocator

final class t extends UnsafeAllocator
{

    t()
    {
    }

    public final Object newInstance(Class class1)
    {
        throw new UnsupportedOperationException((new StringBuilder("Cannot allocate ")).append(class1).toString());
    }
}
