// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TrackingGoal
{
    class Node
    {

        String nm;
        final TrackingGoal this$0;
        Object v;

        Node(String s, Object obj)
        {
            this$0 = TrackingGoal.this;
            super();
            nm = s;
            v = obj;
        }
    }


    String goal;
    ArrayList stack;

    public TrackingGoal(String s, List list)
    {
        goal = s;
        if (list != null && list.size() > 0)
        {
            stack = new ArrayList();
            for (s = list.iterator(); s.hasNext(); stack.add(list))
            {
                list = new Node((String)s.next(), null);
            }

        }
    }
}
