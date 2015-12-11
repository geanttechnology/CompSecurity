// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cardstream.f;

import com.google.a.b.h;
import com.google.a.b.k;
import java.util.Collection;
import java.util.List;

// Referenced classes of package com.target.ui.fragment.cardstream.f:
//            e

public class c
{
    public static class a
    {

        private final List mMutations;
        private final int mViewToModify;
        private final e mViewtagenSet;

        private c b()
        {
            return new c(mViewToModify, h.a(mMutations));
        }

        public a a(int i)
        {
            return a(((b.f) (new b.d(4, Integer.valueOf(i)))));
        }

        public a a(int i, List list)
        {
            return a(((b.f) (new b.c(new b.a(i, list)))));
        }

        public a a(b.e e1)
        {
            return a(((b.f) (e1)));
        }

        public a a(b.f f)
        {
            mMutations.add(f);
            return this;
        }

        public a a(CharSequence charsequence)
        {
            return a(((b.f) (new b.b(1, charsequence))));
        }

        public a a(String s)
        {
            return a(((b.f) (new b.b(7, s))));
        }

        public a a(Collection collection)
        {
            mMutations.addAll(collection);
            return this;
        }

        public e a()
        {
            mViewtagenSet.a(b());
            return mViewtagenSet;
        }

        public a b(int i)
        {
            return a(new b.d(3, Integer.valueOf(i)));
        }

        public a c(int i)
        {
            return a(new b.d(2, Integer.valueOf(i)));
        }

        public a d(int i)
        {
            return a(new b.d(8, Integer.valueOf(i)));
        }

        public a e(int i)
        {
            return a().b(i);
        }

        a(e e1, int i, List list)
        {
            mViewtagenSet = e1;
            mViewToModify = i;
            if (list == null)
            {
                mMutations = k.a();
                return;
            } else
            {
                mMutations = k.a(list);
                return;
            }
        }
    }


    public final h mMutations;
    public final int mViewToModify;

    c(int i, h h1)
    {
        mViewToModify = i;
        mMutations = h1;
    }

    a a(e e)
    {
        return new a(e, mViewToModify, mMutations);
    }

    public boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        obj = (c)obj;
        if (mViewToModify != ((c) (obj)).mViewToModify)
        {
            return false;
        }
        if (mMutations == null) goto _L4; else goto _L3
_L3:
        if (mMutations.equals(((c) (obj)).mMutations)) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (((c) (obj)).mMutations == null)
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public int hashCode()
    {
        int j = mViewToModify;
        int i;
        if (mMutations != null)
        {
            i = mMutations.hashCode();
        } else
        {
            i = 0;
        }
        return i + j * 31;
    }
}
