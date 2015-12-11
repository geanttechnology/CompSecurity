// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cardstream;

import com.target.ui.fragment.cardstream.f.e;

// Referenced classes of package com.target.ui.fragment.cardstream:
//            e

public class b
{

    public final com.target.ui.fragment.cardstream.e cardName;
    public final e chromeMutations;
    public final e contentMutations;
    public final int layoutToInflate;

    public b(int i, e e1, e e2, com.target.ui.fragment.cardstream.e e3)
    {
        layoutToInflate = i;
        chromeMutations = e1;
        contentMutations = e2;
        cardName = e3;
    }

    public boolean equals(Object obj)
    {
        boolean flag2;
        boolean flag3;
        flag2 = true;
        flag3 = false;
        if (this != obj) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        flag = flag3;
        if (obj == null) goto _L4; else goto _L3
_L3:
        flag = flag3;
        if (getClass() != obj.getClass()) goto _L4; else goto _L5
_L5:
        obj = (b)obj;
        flag = flag3;
        if (layoutToInflate != ((b) (obj)).layoutToInflate) goto _L4; else goto _L6
_L6:
        if (chromeMutations == null) goto _L8; else goto _L7
_L7:
        flag = flag3;
        if (!chromeMutations.equals(((b) (obj)).chromeMutations)) goto _L4; else goto _L9
_L9:
        if (contentMutations == null)
        {
            break MISSING_BLOCK_LABEL_126;
        }
        flag = flag3;
        if (!contentMutations.equals(((b) (obj)).contentMutations)) goto _L4; else goto _L10
_L10:
        boolean flag1;
        if (cardName == ((b) (obj)).cardName)
        {
            flag1 = flag2;
        } else
        {
            flag1 = false;
        }
        return flag1;
_L8:
        if (((b) (obj)).chromeMutations != null)
        {
            return false;
        }
          goto _L9
        if (((b) (obj)).contentMutations != null)
        {
            return false;
        }
          goto _L10
    }

    public int hashCode()
    {
        int k = 0;
        int l = layoutToInflate;
        int i;
        int j;
        if (chromeMutations != null)
        {
            i = chromeMutations.hashCode();
        } else
        {
            i = 0;
        }
        if (contentMutations != null)
        {
            j = contentMutations.hashCode();
        } else
        {
            j = 0;
        }
        if (cardName != null)
        {
            k = cardName.hashCode();
        }
        return (j + (i + l * 31) * 31) * 31 + k;
    }
}
