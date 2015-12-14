// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.upload;


public class MixtapeBlockers
{
    public static final class RequestBlockers extends Enum
    {

        private static final RequestBlockers $VALUES[];
        public static final RequestBlockers CONFLICT;
        public static final RequestBlockers FILE_NOT_FOUND;
        public static final RequestBlockers FORBIDDEN;
        public static final RequestBlockers INSUFFICIENT_STORAGE;
        public static final RequestBlockers INVALID_PARAMETER;
        public static final RequestBlockers NO_ACTIVE_SUBSCRIPTION_FOUND;
        public static final RequestBlockers RETRY_LIMIT;

        public static RequestBlockers valueOf(String s)
        {
            return (RequestBlockers)Enum.valueOf(com/amazon/mixtape/upload/MixtapeBlockers$RequestBlockers, s);
        }

        public static RequestBlockers[] values()
        {
            return (RequestBlockers[])$VALUES.clone();
        }

        static 
        {
            FILE_NOT_FOUND = new RequestBlockers("FILE_NOT_FOUND", 0);
            CONFLICT = new RequestBlockers("CONFLICT", 1);
            RETRY_LIMIT = new RequestBlockers("RETRY_LIMIT", 2);
            INSUFFICIENT_STORAGE = new RequestBlockers("INSUFFICIENT_STORAGE", 3);
            INVALID_PARAMETER = new RequestBlockers("INVALID_PARAMETER", 4);
            NO_ACTIVE_SUBSCRIPTION_FOUND = new RequestBlockers("NO_ACTIVE_SUBSCRIPTION_FOUND", 5);
            FORBIDDEN = new RequestBlockers("FORBIDDEN", 6);
            $VALUES = (new RequestBlockers[] {
                FILE_NOT_FOUND, CONFLICT, RETRY_LIMIT, INSUFFICIENT_STORAGE, INVALID_PARAMETER, NO_ACTIVE_SUBSCRIPTION_FOUND, FORBIDDEN
            });
        }

        private RequestBlockers(String s, int i)
        {
            super(s, i);
        }
    }

}
