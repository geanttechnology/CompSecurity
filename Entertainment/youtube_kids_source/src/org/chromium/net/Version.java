// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.chromium.net;


public class Version
{

    public Version()
    {
    }

    public static String a()
    {
        return (new StringBuilder("42.0.2283.0@")).append("ba7505cc6e1e7c3ee8b9001f5dfe35d29ee89a32-refs/heads/master@{#312230}".substring(0, 8)).toString();
    }
}
