// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.gno;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.amazon.mShop.platform.AppLocale;

// Referenced classes of package com.amazon.mShop.gno:
//            GNODrawerItemSimple, GNODrawerItemSubHeaderHideable

public class GNODrawerItemSubHeader extends GNODrawerItemSimple
{
    public static class Builder extends GNODrawerItemSimple.Builder
    {

        public GNODrawerItemSimple build()
        {
            return super.build();
        }

        public volatile GNODrawerItemSimple.Builder withSubView(int i)
        {
            return withSubView(i);
        }

        public Builder withSubView(int i)
        {
            return (Builder)self();
        }

        public Builder(Context context, String s)
        {
            super(new GNODrawerItemSubHeader(context, s));
            super.withType(GNODrawerItem.Type.SUB_HEADER);
        }

        public Builder(GNODrawerItemSubHeaderHideable gnodraweritemsubheaderhideable)
        {
            super(gnodraweritemsubheaderhideable);
            super.withType(GNODrawerItem.Type.SUB_HEADER);
        }
    }


    public GNODrawerItemSubHeader(Context context, String s)
    {
        super(context, s);
    }

    public static Builder builder(Context context, String s)
    {
        return new Builder(context, s);
    }

    public boolean allowDividers()
    {
        return false;
    }

    public View getView(View view, ViewGroup viewgroup)
    {
        view = super.getView(view, viewgroup);
        viewgroup = (TextView)view.findViewById(com.amazon.mShop.android.lib.R.id.drawer_item_title);
        viewgroup.setText(viewgroup.getText().toString().toUpperCase(AppLocale.getInstance().getCurrentLocale()));
        return view;
    }
}
