// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.account;


public class Account
{
    public static class Builder
    {

        public String email;
        public int followersCount;
        public String name;

        public static Builder a()
        {
            return new Builder();
        }

        public static Builder a(Account account)
        {
            Builder builder = new Builder();
            builder.email = Account.a(account);
            builder.name = Account.b(account);
            builder.followersCount = Account.c(account);
            return builder;
        }

        static String a(Builder builder)
        {
            return builder.email;
        }

        static String b(Builder builder)
        {
            return builder.name;
        }

        static int c(Builder builder)
        {
            return builder.followersCount;
        }

        public final Account b()
        {
            return new Account(this, null);
        }

        public Builder()
        {
        }
    }


    public String email;
    public int followersCount;
    public String name;

    private Account()
    {
    }

    private Account(Builder builder)
    {
        email = Builder.a(builder);
        name = Builder.b(builder);
        followersCount = Builder.c(builder);
    }

    Account(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    static String a(Account account)
    {
        return account.email;
    }

    static String b(Account account)
    {
        return account.name;
    }

    static int c(Account account)
    {
        return account.followersCount;
    }
}
