// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.aspects.b.b;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
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
import com.shazam.android.aspects.c.b.a;

public interface c
    extends b
{

    public abstract void onActivityCreated(a a, Bundle bundle);

    public abstract void onActivityResult(a a, int i, int j, Intent intent);

    public abstract void onAttach(a a, Activity activity);

    public abstract void onCancel(a a, DialogInterface dialoginterface);

    public abstract void onConfigurationChanged(a a, Configuration configuration);

    public abstract boolean onContextItemSelected(a a, MenuItem menuitem);

    public abstract void onCreate(a a, Bundle bundle);

    public abstract Animation onCreateAnimation(a a, int i, boolean flag, int j);

    public abstract void onCreateContextMenu(a a, ContextMenu contextmenu, View view, android.view.ContextMenu.ContextMenuInfo contextmenuinfo);

    public abstract Dialog onCreateDialog(a a, Bundle bundle);

    public abstract void onCreateOptionsMenu(a a, Menu menu, MenuInflater menuinflater);

    public abstract View onCreateView(a a, LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle);

    public abstract void onDestroy(a a);

    public abstract void onDestroyOptionsMenu(a a);

    public abstract void onDestroyView(a a);

    public abstract void onDetach(a a);

    public abstract void onDismiss(a a, DialogInterface dialoginterface);

    public abstract void onHiddenChanged(a a, boolean flag);

    public abstract void onInflate(a a, Activity activity, AttributeSet attributeset, Bundle bundle);

    public abstract void onLowMemory(a a);

    public abstract boolean onOptionsItemSelected(a a, MenuItem menuitem);

    public abstract void onOptionsMenuClosed(a a, Menu menu);

    public abstract void onPause(a a);

    public abstract void onPrepareOptionsMenu(a a, Menu menu);

    public abstract void onResume(a a);

    public abstract void onSaveInstanceState(a a, Bundle bundle);

    public abstract void onStart(a a);

    public abstract void onStop(a a);

    public abstract void onViewCreated(a a, View view, Bundle bundle);

    public abstract void onViewStateRestored(a a, Bundle bundle);
}
