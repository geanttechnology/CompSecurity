// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.f.a;

import com.target.mothership.common.product.d;

public class com.target.ui.util.f.a.a
{
    public static final class a extends Enum
    {

        private static final a $VALUES[];
        public static final a FOUND_AISLE;
        public static final a FOUND_KNOWN_DEPARTMENT;
        public static final a FOUND_NONE;
        public static final a FOUND_UNKNOWN_DEPARTMENT;

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/ui/util/f/a/a$a, s);
        }

        public static a[] values()
        {
            return (a[])$VALUES.clone();
        }

        static 
        {
            FOUND_KNOWN_DEPARTMENT = new a("FOUND_KNOWN_DEPARTMENT", 0);
            FOUND_UNKNOWN_DEPARTMENT = new a("FOUND_UNKNOWN_DEPARTMENT", 1);
            FOUND_AISLE = new a("FOUND_AISLE", 2);
            FOUND_NONE = new a("FOUND_NONE", 3);
            $VALUES = (new a[] {
                FOUND_KNOWN_DEPARTMENT, FOUND_UNKNOWN_DEPARTMENT, FOUND_AISLE, FOUND_NONE
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }


    public String mAisle;
    public d mDepartment;
    public a mLocationLookupStatus;

    public com.target.ui.util.f.a.a(String s, d d, a a1)
    {
        mAisle = s;
        mDepartment = d;
        mLocationLookupStatus = a1;
    }
}
