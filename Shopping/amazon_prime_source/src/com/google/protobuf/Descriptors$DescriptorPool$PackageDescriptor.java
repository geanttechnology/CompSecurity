// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;


// Referenced classes of package com.google.protobuf:
//            Descriptors, Message

private static final class name
    implements name
{

    private final file file;
    private final String fullName;
    private final String name;

    public name getFile()
    {
        return file;
    }

    public String getFullName()
    {
        return fullName;
    }

    public String getName()
    {
        return name;
    }

    public Message toProto()
    {
        return file.file();
    }

    (String s, String s1,  )
    {
        file = ;
        fullName = s1;
        name = s;
    }
}
