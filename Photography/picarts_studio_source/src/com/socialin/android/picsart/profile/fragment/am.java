// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.fragment;

import com.picsart.studio.view.WrappingListPopupWindow;
import com.socialin.android.apiv3.model.Comment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class am
{

    public Comment a;
    public WrappingListPopupWindow b;

    public am()
    {
    }

    public static ArrayList a(List list)
    {
        ArrayList arraylist = new ArrayList();
        am am1;
        for (list = list.iterator(); list.hasNext(); arraylist.add(am1))
        {
            Comment comment = (Comment)list.next();
            am1 = new am();
            am1.a = comment;
        }

        return arraylist;
    }
}
