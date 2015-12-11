// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.list.interfaces;

import android.os.Parcelable;

public interface ListMostRecent
    extends Parcelable
{
    public static final class a extends Enum
    {

        private static final a $VALUES[];
        public static final a SEARCH;

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/mothership/model/list/interfaces/ListMostRecent$a, s);
        }

        public static a[] values()
        {
            return (a[])$VALUES.clone();
        }

        static 
        {
            SEARCH = new a("SEARCH", 0);
            $VALUES = (new a[] {
                SEARCH
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }


    public abstract String b();
}
