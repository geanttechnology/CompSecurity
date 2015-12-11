// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.search.handler;

import com.pointinside.products.AutocompleteSuggestion;
import com.target.mothership.services.aa;
import com.target.ui.model.search.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class a
    implements aa
{

    private final aa mTransformer = new aa() {

        final a this$0;

        public volatile Object a(Object obj)
        {
            return a((List)obj);
        }

        public List a(List list)
        {
            if (list == null)
            {
                return Collections.emptyList();
            }
            ArrayList arraylist = new ArrayList();
            list = list.iterator();
            do
            {
                if (!list.hasNext())
                {
                    break;
                }
                Object obj = (AutocompleteSuggestion)list.next();
                if (obj != null)
                {
                    obj = new b(((AutocompleteSuggestion) (obj)).getTerm());
                    ((b) (obj)).a(null);
                    ((b) (obj)).a(null);
                    arraylist.add(obj);
                }
            } while (true);
            return arraylist;
        }

            
            {
                this$0 = a.this;
                super();
            }
    };

    public a()
    {
    }

    public volatile Object a(Object obj)
    {
        return a((List)obj);
    }

    public List a(List list)
    {
        return (List)mTransformer.a(list);
    }
}
