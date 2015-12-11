// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.search.handler;

import android.content.Context;
import android.text.Html;
import com.google.a.a.e;
import com.target.mothership.common.product.CategoryId;
import com.target.mothership.common.product.EndecaId;
import com.target.mothership.common.product.d;
import com.target.mothership.model.typeahead.interfaces.ProductSubSuggestion;
import com.target.mothership.model.typeahead.interfaces.ProductSuggestion;
import com.target.mothership.services.aa;
import com.target.mothership.util.o;
import com.target.ui.model.search.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ProductSuggestionModelTransformer
    implements aa
{

    private final Context mContext;
    private final aa mTransformer = new aa() {

        final ProductSuggestionModelTransformer this$0;

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
            for (Iterator iterator = list.iterator(); iterator.hasNext();)
            {
                ProductSuggestion productsuggestion = (ProductSuggestion)iterator.next();
                list = new b(Html.fromHtml(productsuggestion.a()).toString());
                list.a(null);
                list.a(null);
                arraylist.add(list);
                Iterator iterator1 = productsuggestion.b().iterator();
                while (iterator1.hasNext()) 
                {
                    ProductSubSuggestion productsubsuggestion = (ProductSubSuggestion)iterator1.next();
                    b b1 = new b(productsuggestion.a());
                    d d1;
                    String s;
                    if (productsubsuggestion.c().b())
                    {
                        b1.a((EndecaId)productsubsuggestion.c().c());
                    } else
                    {
                        b1.a(null);
                    }
                    s = Html.fromHtml(productsubsuggestion.a()).toString();
                    d1 = d.UNKNOWN;
                    list = d1;
                    if (o.g(s))
                    {
                        String s1 = ProductSuggestionModelTransformer.a(ProductSuggestionModelTransformer.this).getString(0x7f0904f3);
                        list = d1;
                        if (s.contains(s1))
                        {
                            list = s.subSequence(s1.length(), s.length()).toString();
                            if (o.g(list))
                            {
                                list = d.a(list.trim());
                            } else
                            {
                                list = d.UNKNOWN;
                            }
                        }
                    }
                    b1.a(list);
                    b1.a(s);
                    if (productsubsuggestion.b().b())
                    {
                        b1.a((CategoryId)productsubsuggestion.b().c());
                    } else
                    {
                        b1.a(null);
                    }
                    arraylist.add(b1);
                }
            }

            return arraylist;
        }

            
            {
                this$0 = ProductSuggestionModelTransformer.this;
                super();
            }
    };

    public ProductSuggestionModelTransformer(Context context)
    {
        mContext = context;
    }

    static Context a(ProductSuggestionModelTransformer productsuggestionmodeltransformer)
    {
        return productsuggestionmodeltransformer.mContext;
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
