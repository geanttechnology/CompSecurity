// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.support.v4.view.d;
import android.view.MenuItem;
import android.view.View;

public interface ag
    extends MenuItem
{

    public abstract d a();

    public abstract ag a(d d);

    public abstract ag a(android.support.v4.view.r.e e);

    public abstract boolean collapseActionView();

    public abstract boolean expandActionView();

    public abstract View getActionView();

    public abstract boolean isActionViewExpanded();

    public abstract MenuItem setActionView(int i);

    public abstract MenuItem setActionView(View view);

    public abstract void setShowAsAction(int i);

    public abstract MenuItem setShowAsActionFlags(int i);
}
