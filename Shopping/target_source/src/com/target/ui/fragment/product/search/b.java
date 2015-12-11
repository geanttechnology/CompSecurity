// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.search;

import com.target.ui.fragment.product.common.BaseProductSearchFragment;

// Referenced classes of package com.target.ui.fragment.product.search:
//            SearchProductInStore, SearchProductEverywhere

public class b
{
    public static final class a extends Enum
    {

        private static final a $VALUES[];
        public static final a PI_PRODUCTS;
        public static final a PRODUCTS;

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/ui/fragment/product/search/b$a, s);
        }

        public static a[] values()
        {
            return (a[])$VALUES.clone();
        }

        static 
        {
            PRODUCTS = new a("PRODUCTS", 0);
            PI_PRODUCTS = new a("PI_PRODUCTS", 1);
            $VALUES = (new a[] {
                PRODUCTS, PI_PRODUCTS
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }


    public static BaseProductSearchFragment a(a a1)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$target$ui$fragment$product$search$SearchFragmentFactory$SearchType[];

            static 
            {
                $SwitchMap$com$target$ui$fragment$product$search$SearchFragmentFactory$SearchType = new int[a.values().length];
                try
                {
                    $SwitchMap$com$target$ui$fragment$product$search$SearchFragmentFactory$SearchType[a.PI_PRODUCTS.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$ui$fragment$product$search$SearchFragmentFactory$SearchType[a.PRODUCTS.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.target.ui.fragment.product.search.SearchFragmentFactory.SearchType[a1.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return SearchProductInStore.i();

        case 2: // '\002'
            return SearchProductEverywhere.i();
        }
    }
}
