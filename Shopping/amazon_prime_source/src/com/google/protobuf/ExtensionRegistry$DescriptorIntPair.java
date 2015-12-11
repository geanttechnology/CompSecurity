// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;


// Referenced classes of package com.google.protobuf:
//            ExtensionRegistry

private static final class number
{

    private final number descriptor;
    private final int number;

    public boolean equals(Object obj)
    {
        if (obj instanceof number)
        {
            if (descriptor == ((descriptor) (obj = (descriptor)obj)).descriptor && number == ((number) (obj)).number)
            {
                return true;
            }
        }
        return false;
    }

    public int hashCode()
    {
        return descriptor.hashCode() * 65535 + number;
    }

    ( , int i)
    {
        descriptor = ;
        number = i;
    }
}
