// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads;


public final class AdRequest
{
    public static final class Gender extends Enum
    {

        public static final Gender FEMALE;
        public static final Gender MALE;
        public static final Gender UNKNOWN;
        private static final Gender zzaJ[];

        public static Gender valueOf(String s)
        {
            return (Gender)Enum.valueOf(com/google/ads/AdRequest$Gender, s);
        }

        public static Gender[] values()
        {
            return (Gender[])zzaJ.clone();
        }

        static 
        {
            UNKNOWN = new Gender("UNKNOWN", 0);
            MALE = new Gender("MALE", 1);
            FEMALE = new Gender("FEMALE", 2);
            zzaJ = (new Gender[] {
                UNKNOWN, MALE, FEMALE
            });
        }

        private Gender(String s, int i)
        {
            super(s, i);
        }
    }


    public static final String TEST_EMULATOR;

    static 
    {
        TEST_EMULATOR = com.google.android.gms.ads.AdRequest.DEVICE_ID_EMULATOR;
    }
}
