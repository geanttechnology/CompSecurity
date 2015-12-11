// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.aspects.c.b;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.h;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.shazam.android.aspects.b.b.c;
import java.util.Collection;
import java.util.Iterator;

public class a extends h
{

    private com.shazam.android.aspects.d.b.a aj;

    public a()
    {
        aj = new com.shazam.android.aspects.d.b.a(com.shazam.android.aspects.b.a.a(this, com/shazam/android/aspects/b/b/c, com/shazam/android/aspects/c/b/a));
    }

    public Dialog a(Bundle bundle)
    {
        Dialog dialog1;
        dialog1 = super.a(bundle);
        Iterator iterator = aj.a.iterator();
        Dialog dialog;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_60;
            }
            dialog = ((c)iterator.next()).onCreateDialog(this, bundle);
        } while (dialog == null);
        bundle = dialog;
_L1:
        if (bundle != null)
        {
            return bundle;
        } else
        {
            return dialog1;
        }
        bundle = null;
          goto _L1
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        for (Iterator iterator = aj.a.iterator(); iterator.hasNext(); ((c)iterator.next()).onActivityCreated(this, bundle)) { }
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        for (Iterator iterator = aj.a.iterator(); iterator.hasNext(); ((c)iterator.next()).onActivityResult(this, i, j, intent)) { }
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        for (Iterator iterator = aj.a.iterator(); iterator.hasNext(); ((c)iterator.next()).onAttach(this, activity)) { }
    }

    public void onCancel(DialogInterface dialoginterface)
    {
        super.onCancel(dialoginterface);
        for (Iterator iterator = aj.a.iterator(); iterator.hasNext(); ((c)iterator.next()).onCancel(this, dialoginterface)) { }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        for (Iterator iterator = aj.a.iterator(); iterator.hasNext(); ((c)iterator.next()).onConfigurationChanged(this, configuration)) { }
    }

    public boolean onContextItemSelected(MenuItem menuitem)
    {
        if (super.onContextItemSelected(menuitem)) goto _L2; else goto _L1
_L1:
        Iterator iterator = aj.a.iterator();
_L6:
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        if (!((c)iterator.next()).onContextItemSelected(this, menuitem)) goto _L6; else goto _L5
_L5:
        boolean flag = true;
_L8:
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
_L2:
        return true;
_L4:
        flag = false;
        if (true) goto _L8; else goto _L7
_L7:
        return false;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        for (Iterator iterator = aj.a.iterator(); iterator.hasNext(); ((c)iterator.next()).onCreate(this, bundle)) { }
    }

    public Animation onCreateAnimation(int i, boolean flag, int j)
    {
        Animation animation = super.onCreateAnimation(i, flag, j);
        if (animation != null)
        {
            return animation;
        }
        for (Iterator iterator = aj.a.iterator(); iterator.hasNext();)
        {
            Animation animation1 = ((c)iterator.next()).onCreateAnimation(this, i, flag, j);
            if (animation1 != null)
            {
                return animation1;
            }
        }

        return null;
    }

    public void onCreateContextMenu(ContextMenu contextmenu, View view, android.view.ContextMenu.ContextMenuInfo contextmenuinfo)
    {
        super.onCreateContextMenu(contextmenu, view, contextmenuinfo);
        for (Iterator iterator = aj.a.iterator(); iterator.hasNext(); ((c)iterator.next()).onCreateContextMenu(this, contextmenu, view, contextmenuinfo)) { }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        super.onCreateOptionsMenu(menu, menuinflater);
        for (Iterator iterator = aj.a.iterator(); iterator.hasNext(); ((c)iterator.next()).onCreateOptionsMenu(this, menu, menuinflater)) { }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        View view = super.onCreateView(layoutinflater, viewgroup, bundle);
        if (view != null)
        {
            return view;
        }
        for (Iterator iterator = aj.a.iterator(); iterator.hasNext();)
        {
            View view1 = ((c)iterator.next()).onCreateView(this, layoutinflater, viewgroup, bundle);
            if (view1 != null)
            {
                return view1;
            }
        }

        return null;
    }

    public void onDestroy()
    {
        super.onDestroy();
        for (Iterator iterator = aj.a.iterator(); iterator.hasNext(); ((c)iterator.next()).onDestroy(this)) { }
    }

    public void onDestroyOptionsMenu()
    {
        super.onDestroyOptionsMenu();
        for (Iterator iterator = aj.a.iterator(); iterator.hasNext(); ((c)iterator.next()).onDestroyOptionsMenu(this)) { }
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        for (Iterator iterator = aj.a.iterator(); iterator.hasNext(); ((c)iterator.next()).onDestroyView(this)) { }
    }

    public void onDetach()
    {
        super.onDetach();
        for (Iterator iterator = aj.a.iterator(); iterator.hasNext(); ((c)iterator.next()).onDetach(this)) { }
    }

    public void onDismiss(DialogInterface dialoginterface)
    {
        super.onDismiss(dialoginterface);
        for (Iterator iterator = aj.a.iterator(); iterator.hasNext(); ((c)iterator.next()).onDismiss(this, dialoginterface)) { }
    }

    public void onHiddenChanged(boolean flag)
    {
        super.onHiddenChanged(flag);
        for (Iterator iterator = aj.a.iterator(); iterator.hasNext(); ((c)iterator.next()).onHiddenChanged(this, flag)) { }
    }

    public void onInflate(Activity activity, AttributeSet attributeset, Bundle bundle)
    {
        super.onInflate(activity, attributeset, bundle);
        for (Iterator iterator = aj.a.iterator(); iterator.hasNext(); ((c)iterator.next()).onInflate(this, activity, attributeset, bundle)) { }
    }

    public void onLowMemory()
    {
        super.onLowMemory();
        for (Iterator iterator = aj.a.iterator(); iterator.hasNext(); ((c)iterator.next()).onLowMemory(this)) { }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (super.onOptionsItemSelected(menuitem)) goto _L2; else goto _L1
_L1:
        Iterator iterator = aj.a.iterator();
_L6:
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        if (!((c)iterator.next()).onOptionsItemSelected(this, menuitem)) goto _L6; else goto _L5
_L5:
        boolean flag = true;
_L8:
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
_L2:
        return true;
_L4:
        flag = false;
        if (true) goto _L8; else goto _L7
_L7:
        return false;
    }

    public void onOptionsMenuClosed(Menu menu)
    {
        super.onOptionsMenuClosed(menu);
        for (Iterator iterator = aj.a.iterator(); iterator.hasNext(); ((c)iterator.next()).onOptionsMenuClosed(this, menu)) { }
    }

    public void onPause()
    {
        super.onPause();
        for (Iterator iterator = aj.a.iterator(); iterator.hasNext(); ((c)iterator.next()).onPause(this)) { }
    }

    public void onPrepareOptionsMenu(Menu menu)
    {
        super.onPrepareOptionsMenu(menu);
        for (Iterator iterator = aj.a.iterator(); iterator.hasNext(); ((c)iterator.next()).onPrepareOptionsMenu(this, menu)) { }
    }

    public void onResume()
    {
        super.onResume();
        for (Iterator iterator = aj.a.iterator(); iterator.hasNext(); ((c)iterator.next()).onResume(this)) { }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        for (Iterator iterator = aj.a.iterator(); iterator.hasNext(); ((c)iterator.next()).onSaveInstanceState(this, bundle)) { }
    }

    public void onStart()
    {
        super.onStart();
        for (Iterator iterator = aj.a.iterator(); iterator.hasNext(); ((c)iterator.next()).onStart(this)) { }
    }

    public void onStop()
    {
        super.onStop();
        for (Iterator iterator = aj.a.iterator(); iterator.hasNext(); ((c)iterator.next()).onStop(this)) { }
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        for (Iterator iterator = aj.a.iterator(); iterator.hasNext(); ((c)iterator.next()).onViewCreated(this, view, bundle)) { }
    }

    public void onViewStateRestored(Bundle bundle)
    {
        super.onViewStateRestored(bundle);
        for (Iterator iterator = aj.a.iterator(); iterator.hasNext(); ((c)iterator.next()).onViewStateRestored(this, bundle)) { }
    }
}
