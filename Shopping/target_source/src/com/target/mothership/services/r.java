// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services;

import android.util.SparseBooleanArray;

// Referenced classes of package com.target.mothership.services:
//            s, z

public class r
{
    public static class a
    {

        private boolean mTriggerOnAllErrorCodes;
        private SparseBooleanArray mTriggerOnStatusCodes;

        static SparseBooleanArray a(a a1)
        {
            return a1.mTriggerOnStatusCodes;
        }

        static boolean b(a a1)
        {
            return a1.mTriggerOnAllErrorCodes;
        }

        public r a()
        {
            return new r(this);
        }

        public a()
        {
            mTriggerOnAllErrorCodes = false;
            mTriggerOnStatusCodes = new SparseBooleanArray();
        }
    }


    private boolean mTriggerOnAllErrorCodes;
    private SparseBooleanArray mTriggerOnStatusCodes;

    private r(a a1)
    {
        mTriggerOnAllErrorCodes = false;
        mTriggerOnStatusCodes = new SparseBooleanArray();
        mTriggerOnStatusCodes = a.a(a1);
        mTriggerOnAllErrorCodes = a.b(a1);
    }


    public final boolean a(s s1, z z1)
    {
        if (s1.c())
        {
            boolean flag1 = mTriggerOnStatusCodes.get(z1.a(), false);
            boolean flag;
            if (mTriggerOnAllErrorCodes && z1.a() >= z.BAD_REQUEST.a())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag || flag1)
            {
                return true;
            }
        }
        return false;
    }
}
