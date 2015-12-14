// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.view.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import bc;
import bq;
import dx;

// Referenced classes of package android.support.v7.internal.view.menu:
//            MenuBuilder, MenuItemImpl

public final class ExpandedMenuView extends ListView
    implements android.widget.AdapterView.OnItemClickListener, bc, bq
{

    private static final int TINT_ATTRS[] = {
        0x10100d4, 0x1010129
    };
    private int mAnimations;
    private MenuBuilder mMenu;

    public ExpandedMenuView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0x1010074);
    }

    public ExpandedMenuView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset);
        setOnItemClickListener(this);
        context = dx.a(context, attributeset, TINT_ATTRS, i, 0);
        if (context.d(0))
        {
            setBackgroundDrawable(context.a(0));
        }
        if (context.d(1))
        {
            setDivider(context.a(1));
        }
        context.b();
    }

    public int getWindowAnimations()
    {
        return mAnimations;
    }

    public void initialize(MenuBuilder menubuilder)
    {
        mMenu = menubuilder;
    }

    public boolean invokeItem(MenuItemImpl menuitemimpl)
    {
        return mMenu.a(menuitemimpl, 0);
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        invokeItem((MenuItemImpl)getAdapter().getItem(i));
    }

}
