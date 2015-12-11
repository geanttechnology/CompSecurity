// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.view.menu;

import android.content.Context;
import android.os.Parcelable;

// Referenced classes of package android.support.v7.internal.view.menu:
//            i, m, ac

public interface x
{

    public abstract boolean collapseItemActionView(i i, m m);

    public abstract boolean expandItemActionView(i i, m m);

    public abstract boolean flagActionItems();

    public abstract int getId();

    public abstract void initForMenu(Context context, i i);

    public abstract void onCloseMenu(i i, boolean flag);

    public abstract void onRestoreInstanceState(Parcelable parcelable);

    public abstract Parcelable onSaveInstanceState();

    public abstract boolean onSubMenuSelected(ac ac);

    public abstract void updateMenuView(boolean flag);
}
