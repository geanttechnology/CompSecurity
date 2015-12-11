// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.gno;

import android.view.View;
import android.view.ViewGroup;
import com.amazon.mShop.AmazonActivity;
import java.util.Collection;

// Referenced classes of package com.amazon.mShop.gno:
//            GNODrawer

public interface GNODrawerItem
{
    public static final class Type extends Enum
    {

        private static final Type $VALUES[];
        public static final Type APPSTORE_HEADER;
        public static final Type AUTHENTICATION;
        public static final Type CHARITY;
        public static final Type FAKE_GROUP_ANIMATION;
        public static final Type SIMPLE_ITEM;
        public static final Type SUB_HEADER;
        public static final Type SUB_ITEM;
        public static final Type SUB_SUB_HEADER;
        private int mResId;

        public static Type valueOf(String s)
        {
            return (Type)Enum.valueOf(com/amazon/mShop/gno/GNODrawerItem$Type, s);
        }

        public static Type[] values()
        {
            return (Type[])$VALUES.clone();
        }

        public int getLayoutId()
        {
            return mResId;
        }

        static 
        {
            SIMPLE_ITEM = new Type("SIMPLE_ITEM", 0, com.amazon.mShop.android.lib.R.layout.gno_drawer_item_simple);
            SUB_ITEM = new Type("SUB_ITEM", 1, com.amazon.mShop.android.lib.R.layout.gno_drawer_item_sub_item);
            SUB_HEADER = new Type("SUB_HEADER", 2, com.amazon.mShop.android.lib.R.layout.gno_drawer_item_sub_header);
            SUB_SUB_HEADER = new Type("SUB_SUB_HEADER", 3, com.amazon.mShop.android.lib.R.layout.gno_drawer_item_sub_sub_header);
            AUTHENTICATION = new Type("AUTHENTICATION", 4, com.amazon.mShop.android.lib.R.layout.gno_drawer_item_simple);
            CHARITY = new Type("CHARITY", 5, com.amazon.mShop.android.lib.R.layout.gno_drawer_item_simple);
            APPSTORE_HEADER = new Type("APPSTORE_HEADER", 6, com.amazon.mShop.android.lib.R.layout.gno_drawer_item_appstore_header);
            FAKE_GROUP_ANIMATION = new Type("FAKE_GROUP_ANIMATION", 7, 0);
            $VALUES = (new Type[] {
                SIMPLE_ITEM, SUB_ITEM, SUB_HEADER, SUB_SUB_HEADER, AUTHENTICATION, CHARITY, APPSTORE_HEADER, FAKE_GROUP_ANIMATION
            });
        }

        private Type(String s, int i, int j)
        {
            super(s, i);
            mResId = j;
        }
    }


    public abstract boolean allowDividers();

    public abstract Collection getChildren();

    public abstract String getId();

    public abstract GNODrawerItem getParent();

    public abstract Type getType();

    public abstract View getView(View view, ViewGroup viewgroup);

    public abstract void onClick(AmazonActivity amazonactivity, GNODrawer gnodrawer);

    public abstract void setChildren(Collection collection);
}
