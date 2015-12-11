// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.view.View;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import java.util.ArrayList;

// Referenced classes of package android.support.v4.app:
//            FragmentActivity, FragmentManagerImpl, Fragment

public abstract class Watson extends FragmentActivity
    implements com.actionbarsherlock.ActionBarSherlock.OnCreatePanelMenuListener, com.actionbarsherlock.ActionBarSherlock.OnMenuItemSelectedListener, com.actionbarsherlock.ActionBarSherlock.OnPreparePanelListener
{

    private static final String TAG = "Watson";
    private ArrayList mCreatedMenus;

    public Watson()
    {
    }

    public abstract MenuInflater getSupportMenuInflater();

    public abstract boolean onCreateOptionsMenu(Menu menu);

    public boolean onCreatePanelMenu(int i, Menu menu)
    {
        boolean flag1 = false;
        boolean flag = false;
        (new StringBuilder()).append("[onCreatePanelMenu] featureId: ").append(i).append(", menu: ").append(menu).toString();
        if (i == 0)
        {
            boolean flag3 = onCreateOptionsMenu(menu);
            (new StringBuilder()).append("[onCreatePanelMenu] activity create result: ").append(flag3).toString();
            MenuInflater menuinflater = getSupportMenuInflater();
            Object obj = null;
            ArrayList arraylist = null;
            boolean flag2;
            if (mFragments.mAdded != null)
            {
                i = 0;
                flag1 = false;
                do
                {
                    flag2 = flag1;
                    obj = arraylist;
                    if (i >= mFragments.mAdded.size())
                    {
                        break;
                    }
                    obj = (Fragment)mFragments.mAdded.get(i);
                    if (obj != null && !((Fragment) (obj)).mHidden && ((Fragment) (obj)).mHasMenu && ((Fragment) (obj)).mMenuVisible && (obj instanceof OnCreateOptionsMenuListener))
                    {
                        ((OnCreateOptionsMenuListener)obj).onCreateOptionsMenu(menu, menuinflater);
                        if (arraylist == null)
                        {
                            arraylist = new ArrayList();
                        }
                        arraylist.add(obj);
                        flag1 = true;
                    }
                    i++;
                } while (true);
            } else
            {
                flag2 = false;
            }
            if (mCreatedMenus != null)
            {
                for (i = ((flag) ? 1 : 0); i < mCreatedMenus.size(); i++)
                {
                    menu = (Fragment)mCreatedMenus.get(i);
                    if (obj == null || !((ArrayList) (obj)).contains(menu))
                    {
                        menu.onDestroyOptionsMenu();
                    }
                }

            }
            mCreatedMenus = ((ArrayList) (obj));
            (new StringBuilder()).append("[onCreatePanelMenu] fragments create result: ").append(flag2).toString();
            flag1 = flag3 | flag2;
            (new StringBuilder()).append("[onCreatePanelMenu] returning ").append(flag1).toString();
        }
        return flag1;
    }

    public boolean onMenuItemSelected(int i, MenuItem menuitem)
    {
        boolean flag;
        boolean flag1;
        flag1 = false;
        (new StringBuilder()).append("[onMenuItemSelected] featureId: ").append(i).append(", item: ").append(menuitem).toString();
        flag = flag1;
        if (i != 0) goto _L2; else goto _L1
_L1:
        if (!onOptionsItemSelected(menuitem)) goto _L4; else goto _L3
_L3:
        flag = true;
_L2:
        return flag;
_L4:
        flag = flag1;
        if (mFragments.mAdded == null)
        {
            continue;
        }
        i = 0;
        do
        {
            flag = flag1;
            if (i >= mFragments.mAdded.size())
            {
                continue;
            }
            Fragment fragment = (Fragment)mFragments.mAdded.get(i);
            if (fragment != null && !fragment.mHidden && fragment.mHasMenu && fragment.mMenuVisible && (fragment instanceof OnOptionsItemSelectedListener) && ((OnOptionsItemSelectedListener)fragment).onOptionsItemSelected(menuitem))
            {
                return true;
            }
            i++;
        } while (true);
        if (true) goto _L2; else goto _L5
_L5:
    }

    public abstract boolean onOptionsItemSelected(MenuItem menuitem);

    public abstract boolean onPrepareOptionsMenu(Menu menu);

    public boolean onPreparePanel(int i, View view, Menu menu)
    {
        boolean flag = false;
        (new StringBuilder()).append("[onPreparePanel] featureId: ").append(i).append(", view: ").append(view).append(" menu: ").append(menu).toString();
        if (i == 0)
        {
            boolean flag2 = onPrepareOptionsMenu(menu);
            (new StringBuilder()).append("[onPreparePanel] activity prepare result: ").append(flag2).toString();
            boolean flag1;
            if (mFragments.mAdded != null)
            {
                i = 0;
                flag = false;
                do
                {
                    flag1 = flag;
                    if (i >= mFragments.mAdded.size())
                    {
                        break;
                    }
                    view = (Fragment)mFragments.mAdded.get(i);
                    flag1 = flag;
                    if (view != null)
                    {
                        flag1 = flag;
                        if (!((Fragment) (view)).mHidden)
                        {
                            flag1 = flag;
                            if (((Fragment) (view)).mHasMenu)
                            {
                                flag1 = flag;
                                if (((Fragment) (view)).mMenuVisible)
                                {
                                    flag1 = flag;
                                    if (view instanceof OnPrepareOptionsMenuListener)
                                    {
                                        flag1 = true;
                                        ((OnPrepareOptionsMenuListener)view).onPrepareOptionsMenu(menu);
                                    }
                                }
                            }
                        }
                    }
                    i++;
                    flag = flag1;
                } while (true);
            } else
            {
                flag1 = false;
            }
            (new StringBuilder()).append("[onPreparePanel] fragments prepare result: ").append(flag1).toString();
            flag = (flag2 | flag1) & menu.hasVisibleItems();
            (new StringBuilder()).append("[onPreparePanel] returning ").append(flag).toString();
        }
        return flag;
    }

    private class OnCreateOptionsMenuListener
    {

        public abstract void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater);
    }


    private class OnOptionsItemSelectedListener
    {

        public abstract boolean onOptionsItemSelected(MenuItem menuitem);
    }


    private class OnPrepareOptionsMenuListener
    {

        public abstract void onPrepareOptionsMenu(Menu menu);
    }

}
