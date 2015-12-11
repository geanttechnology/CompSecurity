// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cardstream.f;

import android.os.Parcelable;
import java.util.List;

public class com.target.ui.fragment.cardstream.f.b
{
    public static class a
    {

        public final int collectionItemLayout;
        public final List collectionItemViewtagens;

        public boolean equals(Object obj)
        {
            boolean flag1 = false;
            boolean flag;
            if (this == obj)
            {
                flag = true;
            } else
            {
                flag = flag1;
                if (obj != null)
                {
                    flag = flag1;
                    if (getClass() == obj.getClass())
                    {
                        obj = (a)obj;
                        flag = flag1;
                        if (collectionItemLayout == ((a) (obj)).collectionItemLayout)
                        {
                            return collectionItemViewtagens.equals(((a) (obj)).collectionItemViewtagens);
                        }
                    }
                }
            }
            return flag;
        }

        public int hashCode()
        {
            return collectionItemLayout * 31 + collectionItemViewtagens.hashCode();
        }

        public a(int i, List list)
        {
            collectionItemLayout = i;
            collectionItemViewtagens = list;
        }
    }

    public static class b extends f
    {

        public b(int i, CharSequence charsequence)
        {
            super(i, charsequence);
        }
    }

    public static class c extends f
    {

        public c(a a1)
        {
            super(5, a1);
        }
    }

    public static class d extends f
    {

        public d(int i, Integer integer)
        {
            super(i, integer);
        }
    }

    public static final class e extends f
    {

        public e(Parcelable parcelable)
        {
            super(6, parcelable);
        }
    }

    public static abstract class f
    {

        public final int mutationType;
        public final Object param;

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
            obj = (f)obj;
            if (mutationType != ((f) (obj)).mutationType)
            {
                return false;
            }
            if (param == null) goto _L4; else goto _L3
_L3:
            if (param.equals(((f) (obj)).param)) goto _L1; else goto _L5
_L5:
            return false;
_L4:
            if (((f) (obj)).param == null)
            {
                return true;
            }
            if (true) goto _L5; else goto _L6
_L6:
        }

        public int hashCode()
        {
            int j = mutationType;
            int i;
            if (param != null)
            {
                i = param.hashCode();
            } else
            {
                i = 0;
            }
            return i + j * 31;
        }

        public f(int i, Object obj)
        {
            mutationType = i;
            param = obj;
        }
    }

}
