// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.aspects.b.b;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.shazam.android.aspects.b.b;

public interface d
    extends b
{

    public abstract void onActivityCreated(com.shazam.android.aspects.c.b.b b1, Bundle bundle);

    public abstract void onActivityResult(com.shazam.android.aspects.c.b.b b1, int i, int j, Intent intent);

    public abstract void onAttach(com.shazam.android.aspects.c.b.b b1, Activity activity);

    public abstract void onConfigurationChanged(com.shazam.android.aspects.c.b.b b1, Configuration configuration);

    public abstract boolean onContextItemSelected(com.shazam.android.aspects.c.b.b b1, MenuItem menuitem);

    public abstract void onCreate(com.shazam.android.aspects.c.b.b b1, Bundle bundle);

    public abstract Animation onCreateAnimation(com.shazam.android.aspects.c.b.b b1, int i, boolean flag, int j);

    public abstract void onCreateContextMenu(com.shazam.android.aspects.c.b.b b1, ContextMenu contextmenu, View view, android.view.ContextMenu.ContextMenuInfo contextmenuinfo);

    public abstract void onCreateOptionsMenu(com.shazam.android.aspects.c.b.b b1, Menu menu, MenuInflater menuinflater);

    public abstract View onCreateView(com.shazam.android.aspects.c.b.b b1, LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle);

    public abstract void onDestroy(com.shazam.android.aspects.c.b.b b1);

    public abstract void onDestroyOptionsMenu(com.shazam.android.aspects.c.b.b b1);

    public abstract void onDestroyView(com.shazam.android.aspects.c.b.b b1);

    public abstract void onDetach(com.shazam.android.aspects.c.b.b b1);

    public abstract void onHiddenChanged(com.shazam.android.aspects.c.b.b b1, boolean flag);

    public abstract void onInflate(com.shazam.android.aspects.c.b.b b1, Activity activity, AttributeSet attributeset, Bundle bundle);

    public abstract void onLowMemory(com.shazam.android.aspects.c.b.b b1);

    public abstract boolean onOptionsItemSelected(com.shazam.android.aspects.c.b.b b1, MenuItem menuitem);

    public abstract void onOptionsMenuClosed(com.shazam.android.aspects.c.b.b b1, Menu menu);

    public abstract void onPause(com.shazam.android.aspects.c.b.b b1);

    public abstract void onPrepareOptionsMenu(com.shazam.android.aspects.c.b.b b1, Menu menu);

    public abstract void onResume(com.shazam.android.aspects.c.b.b b1);

    public abstract void onSaveInstanceState(com.shazam.android.aspects.c.b.b b1, Bundle bundle);

    public abstract void onStart(com.shazam.android.aspects.c.b.b b1);

    public abstract void onStop(com.shazam.android.aspects.c.b.b b1);

    public abstract void onViewCreated(com.shazam.android.aspects.c.b.b b1, View view, Bundle bundle);

    public abstract void onViewStateRestored(com.shazam.android.aspects.c.b.b b1, Bundle bundle);
}
