// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.Menu;

public interface bq
{

    public abstract boolean canShowOverflowMenu();

    public abstract void dismissPopups();

    public abstract boolean hideOverflowMenu();

    public abstract void initFeature(int i);

    public abstract boolean isOverflowMenuShowPending();

    public abstract boolean isOverflowMenuShowing();

    public abstract void setMenu(Menu menu, as as);

    public abstract void setMenuPrepared();

    public abstract void setWindowCallback(l l);

    public abstract void setWindowTitle(CharSequence charsequence);

    public abstract boolean showOverflowMenu();
}
