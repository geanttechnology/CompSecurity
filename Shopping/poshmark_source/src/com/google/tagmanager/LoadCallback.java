// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;


interface LoadCallback
{
    public static final class Failure extends Enum
    {

        private static final Failure $VALUES[];
        public static final Failure IO_ERROR;
        public static final Failure NOT_AVAILABLE;
        public static final Failure SERVER_ERROR;

        public static Failure valueOf(String s)
        {
            return (Failure)Enum.valueOf(com/google/tagmanager/LoadCallback$Failure, s);
        }

        public static Failure[] values()
        {
            return (Failure[])$VALUES.clone();
        }

        static 
        {
            NOT_AVAILABLE = new Failure("NOT_AVAILABLE", 0);
            IO_ERROR = new Failure("IO_ERROR", 1);
            SERVER_ERROR = new Failure("SERVER_ERROR", 2);
            $VALUES = (new Failure[] {
                NOT_AVAILABLE, IO_ERROR, SERVER_ERROR
            });
        }

        private Failure(String s, int i)
        {
            super(s, i);
        }
    }


    public abstract void onFailure(Failure failure);

    public abstract void onSuccess(Object obj);

    public abstract void startLoad();
}
