// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.actionbarsherlock;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.internal.ActionBarSherlockCompat;
import com.actionbarsherlock.internal.ActionBarSherlockNative;
import com.actionbarsherlock.view.ActionMode;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public abstract class ActionBarSherlock
{

    private static final Class CONSTRUCTOR_ARGS[];
    public static final int FLAG_DELEGATE = 1;
    private static final HashMap IMPLEMENTATIONS = new HashMap();
    protected static final String TAG = "ActionBarSherlock";
    protected final Activity mActivity;
    protected final boolean mIsDelegate;
    protected MenuInflater mMenuInflater;

    protected ActionBarSherlock(Activity activity, int i)
    {
        (new StringBuilder()).append("[<ctor>] activity: ").append(activity).append(", flags: ").append(i).toString();
        mActivity = activity;
        boolean flag;
        if ((i & 1) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsDelegate = flag;
    }

    public static void registerImplementation(Class class1)
    {
        if (!class1.isAnnotationPresent(com/actionbarsherlock/ActionBarSherlock$Implementation))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Class ").append(class1.getSimpleName()).append(" is not annotated with @Implementation").toString());
        }
        if (IMPLEMENTATIONS.containsValue(class1))
        {
            (new StringBuilder()).append("Class ").append(class1.getSimpleName()).append(" already registered").toString();
            return;
        } else
        {
            Implementation implementation = (Implementation)class1.getAnnotation(com/actionbarsherlock/ActionBarSherlock$Implementation);
            (new StringBuilder()).append("Registering ").append(class1.getSimpleName()).append(" with qualifier ").append(implementation).toString();
            IMPLEMENTATIONS.put(implementation, class1);
            return;
        }
    }

    public static boolean unregisterImplementation(Class class1)
    {
        return IMPLEMENTATIONS.values().remove(class1);
    }

    public static ActionBarSherlock wrap(Activity activity)
    {
        return wrap(activity, 0);
    }

    public static ActionBarSherlock wrap(Activity activity, int i)
    {
        Object obj;
        Iterator iterator;
        boolean flag;
        flag = false;
        obj = new HashMap(IMPLEMENTATIONS);
        iterator = ((HashMap) (obj)).keySet().iterator();
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        if (((Implementation)iterator.next()).dpi() != 213) goto _L4; else goto _L3
_L3:
        int j = 1;
_L11:
        if (j != 0)
        {
            if (activity.getResources().getDisplayMetrics().densityDpi == 213)
            {
                j = 1;
            } else
            {
                j = 0;
            }
            iterator = ((HashMap) (obj)).keySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                int l = ((Implementation)iterator.next()).dpi();
                if (j != 0 && l != 213 || j == 0 && l == 213)
                {
                    iterator.remove();
                }
            } while (true);
        }
        iterator = ((HashMap) (obj)).keySet().iterator();
_L8:
        if (!iterator.hasNext()) goto _L6; else goto _L5
_L5:
        if (((Implementation)iterator.next()).api() == -1) goto _L8; else goto _L7
_L7:
        j = 1;
_L9:
        if (j != 0)
        {
            int i1 = android.os.Build.VERSION.SDK_INT;
            Iterator iterator1 = ((HashMap) (obj)).keySet().iterator();
            j = ((flag) ? 1 : 0);
            do
            {
                if (!iterator1.hasNext())
                {
                    break;
                }
                int k = ((Implementation)iterator1.next()).api();
                if (k > i1)
                {
                    iterator1.remove();
                } else
                if (k > j)
                {
                    j = k;
                }
            } while (true);
            iterator1 = ((HashMap) (obj)).keySet().iterator();
            do
            {
                if (!iterator1.hasNext())
                {
                    break;
                }
                if (((Implementation)iterator1.next()).api() != j)
                {
                    iterator1.remove();
                }
            } while (true);
        }
        if (((HashMap) (obj)).size() > 1)
        {
            throw new IllegalStateException("More than one implementation matches configuration.");
        }
        if (((HashMap) (obj)).isEmpty())
        {
            throw new IllegalStateException("No implementations match configuration.");
        }
        obj = (Class)((HashMap) (obj)).values().iterator().next();
        (new StringBuilder()).append("Using implementation: ").append(((Class) (obj)).getSimpleName()).toString();
        try
        {
            activity = (ActionBarSherlock)((Class) (obj)).getConstructor(CONSTRUCTOR_ARGS).newInstance(new Object[] {
                activity, Integer.valueOf(i)
            });
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            throw new RuntimeException(activity);
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            throw new RuntimeException(activity);
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            throw new RuntimeException(activity);
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            throw new RuntimeException(activity);
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            throw new RuntimeException(activity);
        }
        return activity;
_L6:
        j = 0;
        if (true) goto _L9; else goto _L2
_L2:
        j = 0;
        if (true) goto _L11; else goto _L10
_L10:
    }

    public abstract void addContentView(View view, android.view.ViewGroup.LayoutParams layoutparams);

    protected final boolean callbackCreateOptionsMenu(Menu menu)
    {
        boolean flag;
        (new StringBuilder()).append("[callbackCreateOptionsMenu] menu: ").append(menu).toString();
        flag = true;
        if (!(mActivity instanceof OnCreatePanelMenuListener)) goto _L2; else goto _L1
_L1:
        flag = ((OnCreatePanelMenuListener)mActivity).onCreatePanelMenu(0, menu);
_L4:
        (new StringBuilder()).append("[callbackCreateOptionsMenu] returning ").append(flag).toString();
        return flag;
_L2:
        if (mActivity instanceof OnCreateOptionsMenuListener)
        {
            flag = ((OnCreateOptionsMenuListener)mActivity).onCreateOptionsMenu(menu);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected final boolean callbackOptionsItemSelected(MenuItem menuitem)
    {
        (new StringBuilder()).append("[callbackOptionsItemSelected] item: ").append(menuitem.getTitleCondensed()).toString();
        boolean flag;
        if (mActivity instanceof OnMenuItemSelectedListener)
        {
            flag = ((OnMenuItemSelectedListener)mActivity).onMenuItemSelected(0, menuitem);
        } else
        if (mActivity instanceof OnOptionsItemSelectedListener)
        {
            flag = ((OnOptionsItemSelectedListener)mActivity).onOptionsItemSelected(menuitem);
        } else
        {
            flag = false;
        }
        (new StringBuilder()).append("[callbackOptionsItemSelected] returning ").append(flag).toString();
        return flag;
    }

    protected final boolean callbackPrepareOptionsMenu(Menu menu)
    {
        boolean flag;
        (new StringBuilder()).append("[callbackPrepareOptionsMenu] menu: ").append(menu).toString();
        flag = true;
        if (!(mActivity instanceof OnPreparePanelListener)) goto _L2; else goto _L1
_L1:
        flag = ((OnPreparePanelListener)mActivity).onPreparePanel(0, null, menu);
_L4:
        (new StringBuilder()).append("[callbackPrepareOptionsMenu] returning ").append(flag).toString();
        return flag;
_L2:
        if (mActivity instanceof OnPrepareOptionsMenuListener)
        {
            flag = ((OnPrepareOptionsMenuListener)mActivity).onPrepareOptionsMenu(menu);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean dispatchCloseOptionsMenu()
    {
        return false;
    }

    public void dispatchConfigurationChanged(Configuration configuration)
    {
    }

    public abstract boolean dispatchCreateOptionsMenu(android.view.Menu menu);

    public void dispatchDestroy()
    {
    }

    public abstract void dispatchInvalidateOptionsMenu();

    public boolean dispatchKeyEvent(KeyEvent keyevent)
    {
        return false;
    }

    public boolean dispatchMenuOpened(int i, android.view.Menu menu)
    {
        return false;
    }

    public boolean dispatchOpenOptionsMenu()
    {
        return false;
    }

    public abstract boolean dispatchOptionsItemSelected(android.view.MenuItem menuitem);

    public void dispatchPanelClosed(int i, android.view.Menu menu)
    {
    }

    public void dispatchPause()
    {
    }

    public void dispatchPostCreate(Bundle bundle)
    {
    }

    public void dispatchPostResume()
    {
    }

    public abstract boolean dispatchPrepareOptionsMenu(android.view.Menu menu);

    public void dispatchRestoreInstanceState(Bundle bundle)
    {
    }

    public void dispatchSaveInstanceState(Bundle bundle)
    {
    }

    public void dispatchStop()
    {
    }

    public void dispatchTitleChanged(CharSequence charsequence, int i)
    {
    }

    public void ensureActionBar()
    {
    }

    public abstract ActionBar getActionBar();

    public MenuInflater getMenuInflater()
    {
        if (mMenuInflater == null)
        {
            if (getActionBar() != null)
            {
                mMenuInflater = new MenuInflater(getThemedContext(), mActivity);
            } else
            {
                mMenuInflater = new MenuInflater(mActivity);
            }
        }
        return mMenuInflater;
    }

    protected abstract Context getThemedContext();

    public abstract boolean hasFeature(int i);

    public abstract boolean requestFeature(int i);

    public abstract void setContentView(int i);

    public void setContentView(View view)
    {
        (new StringBuilder()).append("[setContentView] view: ").append(view).toString();
        setContentView(view, new android.view.ViewGroup.LayoutParams(-1, -1));
    }

    public abstract void setContentView(View view, android.view.ViewGroup.LayoutParams layoutparams);

    public abstract void setProgress(int i);

    public abstract void setProgressBarIndeterminate(boolean flag);

    public abstract void setProgressBarIndeterminateVisibility(boolean flag);

    public abstract void setProgressBarVisibility(boolean flag);

    public abstract void setSecondaryProgress(int i);

    public void setTitle(int i)
    {
        (new StringBuilder()).append("[setTitle] resId: ").append(i).toString();
        setTitle(((CharSequence) (mActivity.getString(i))));
    }

    public abstract void setTitle(CharSequence charsequence);

    public abstract void setUiOptions(int i);

    public abstract void setUiOptions(int i, int j);

    public abstract ActionMode startActionMode(com.actionbarsherlock.view.ActionMode.Callback callback);

    static 
    {
        CONSTRUCTOR_ARGS = (new Class[] {
            android/app/Activity, Integer.TYPE
        });
        registerImplementation(com/actionbarsherlock/internal/ActionBarSherlockCompat);
        registerImplementation(com/actionbarsherlock/internal/ActionBarSherlockNative);
    }

    private class Implementation
        implements Annotation
    {

        public static final int DEFAULT_API = -1;
        public static final int DEFAULT_DPI = -1;

        public abstract int api();

        public abstract int dpi();
    }


    private class OnCreatePanelMenuListener
    {

        public abstract boolean onCreatePanelMenu(int i, Menu menu);
    }


    private class OnCreateOptionsMenuListener
    {

        public abstract boolean onCreateOptionsMenu(Menu menu);
    }


    private class OnMenuItemSelectedListener
    {

        public abstract boolean onMenuItemSelected(int i, MenuItem menuitem);
    }


    private class OnOptionsItemSelectedListener
    {

        public abstract boolean onOptionsItemSelected(MenuItem menuitem);
    }


    private class OnPreparePanelListener
    {

        public abstract boolean onPreparePanel(int i, View view, Menu menu);
    }


    private class OnPrepareOptionsMenuListener
    {

        public abstract boolean onPrepareOptionsMenu(Menu menu);
    }

}
