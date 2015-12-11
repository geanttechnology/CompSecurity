// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm.exceptions;


public class RealmMigrationNeededException extends RuntimeException
{

    private final String canonicalRealmPath;

    public RealmMigrationNeededException(String s, String s1)
    {
        super(s1);
        canonicalRealmPath = s;
    }

    public RealmMigrationNeededException(String s, String s1, Throwable throwable)
    {
        super(s1, throwable);
        canonicalRealmPath = s;
    }

    public String getPath()
    {
        return canonicalRealmPath;
    }
}
