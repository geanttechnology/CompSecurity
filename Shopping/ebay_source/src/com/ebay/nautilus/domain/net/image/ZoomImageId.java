// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.image;

import android.text.TextUtils;

public class ZoomImageId
{
    public static final class Type extends Enum
    {

        private static final Type $VALUES[];
        public static final Type GUID;
        public static final Type MD5;

        public static Type valueOf(String s)
        {
            return (Type)Enum.valueOf(com/ebay/nautilus/domain/net/image/ZoomImageId$Type, s);
        }

        public static Type[] values()
        {
            return (Type[])$VALUES.clone();
        }

        static 
        {
            GUID = new Type("GUID", 0);
            MD5 = new Type("MD5", 1);
            $VALUES = (new Type[] {
                GUID, MD5
            });
        }

        private Type(String s, int i)
        {
            super(s, i);
        }
    }


    public final String id;
    public final Type type;

    public ZoomImageId(String s, String s1)
        throws IllegalArgumentException
    {
        if (!TextUtils.isEmpty(s))
        {
            type = Type.GUID;
            id = s;
            return;
        }
        if (!TextUtils.isEmpty(s1))
        {
            type = Type.MD5;
            id = s1;
            return;
        } else
        {
            throw new IllegalArgumentException("no valid identifier specified");
        }
    }
}
