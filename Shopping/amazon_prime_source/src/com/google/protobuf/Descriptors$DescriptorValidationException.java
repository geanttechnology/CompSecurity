// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;


// Referenced classes of package com.google.protobuf:
//            Descriptors, Message

public static class <init> extends Exception
{

    private final String description;
    private final String name;
    private final Message proto;

    private ( , String s)
    {
        super((new StringBuilder()).append(.()).append(": ").append(s).toString());
        name = .name();
        proto = .proto();
        description = s;
    }

    description(description description1, String s, description description2)
    {
        this(description1, s);
    }

    private <init>(<init> <init>1, String s)
    {
        super((new StringBuilder()).append(<init>1.<init>()).append(": ").append(s).toString());
        name = <init>1.name();
        proto = <init>1.proto();
        description = s;
    }

    description(description description1, String s, description description2)
    {
        this(description1, s);
    }

    private <init>(<init> <init>1, String s, Throwable throwable)
    {
        this(<init>1, s);
        initCause(throwable);
    }

    initCause(initCause initcause, String s, Throwable throwable, initCause initcause1)
    {
        this(initcause, s, throwable);
    }
}
