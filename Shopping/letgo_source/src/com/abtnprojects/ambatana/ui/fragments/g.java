// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.fragments;


// Referenced classes of package com.abtnprojects.ambatana.ui.fragments:
//            f, ProductDeleteOrSoldConfirmationFragment, AbstractProductDeleteConfirmationFragment

public class g
{

    public static AbstractProductDeleteConfirmationFragment a(int i)
    {
        if (i == 0 || i == 3 || i == 5)
        {
            return new f();
        } else
        {
            return new ProductDeleteOrSoldConfirmationFragment();
        }
    }
}
