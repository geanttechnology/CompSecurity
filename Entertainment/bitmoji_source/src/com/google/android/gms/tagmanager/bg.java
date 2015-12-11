// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;


interface bg
{
    public static final class a extends Enum
    {

        public static final a VA;
        public static final a VB;
        public static final a VC;
        private static final a VD[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/google/android/gms/tagmanager/bg$a, s);
        }

        public static a[] values()
        {
            return (a[])VD.clone();
        }

        static 
        {
            VA = new a("NOT_AVAILABLE", 0);
            VB = new a("IO_ERROR", 1);
            VC = new a("SERVER_ERROR", 2);
            VD = (new a[] {
                VA, VB, VC
            });
        }

        private a(String s, int j)
        {
            super(s, j);
        }
    }


    public abstract void a(a a1);

    public abstract void i(Object obj);

    public abstract void iM();
}
