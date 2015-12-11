// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ParcelUuid;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.poshmark.fb_tmblr_twitter.FbHelper;
import com.poshmark.fb_tmblr_twitter.GooglePlusHelper;
import com.poshmark.fb_tmblr_twitter.PinterestHelper;
import com.poshmark.ui.customviews.PMDrawerLayout;
import com.poshmark.ui.fragments.PMDialogFragment;
import com.poshmark.ui.fragments.PMFragment;
import com.poshmark.utils.ObjectPickupDropOff;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.UUID;

// Referenced classes of package com.poshmark.ui:
//            PMActivity

public class PMContainerActivity extends PMActivity
{

    public android.support.v4.app.FragmentManager.OnBackStackChangedListener backStackChangedListener;
    List descendants;
    PMDrawerLayout drawer;
    boolean isFinishing;

    public PMContainerActivity()
    {
        isFinishing = false;
        descendants = new ArrayList();
        backStackChangedListener = new android.support.v4.app.FragmentManager.OnBackStackChangedListener() {

            final PMContainerActivity this$0;

            public void onBackStackChanged()
            {
                (new Handler()).post(new Runnable() {

                    final _cls1 this$1;

                    public void run()
                    {
                        PMFragment pmfragment = getTopFragmentFromBackStack();
                        if (pmfragment != null)
                        {
                            pmfragment.onLoadingComplete();
                        }
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                });
            }

            
            {
                this$0 = PMContainerActivity.this;
                super();
            }
        };
    }

    private PMFragment getTopFragmentFromBackStack()
    {
        FragmentManager fragmentmanager = getSupportFragmentManager();
        int i = fragmentmanager.getBackStackEntryCount();
        if (i > 0)
        {
            return (PMFragment)fragmentmanager.findFragmentByTag(Integer.toString(i));
        } else
        {
            return null;
        }
    }

    public void closeDrawer()
    {
        drawer = (PMDrawerLayout)findViewById(0x7f0c0048);
        if (drawer.isDrawerOpen(5))
        {
            drawer.closeDrawer(5);
        }
    }

    public void enableDrawer(boolean flag)
    {
        drawer = (PMDrawerLayout)findViewById(0x7f0c0048);
        drawer.enableDrawer(flag);
    }

    public Stack getFragmentStack()
    {
        return null;
    }

    public int getFragmentStackCount()
    {
        return getSupportFragmentManager().getBackStackEntryCount();
    }

    public List getScreenNavigationStack()
    {
        return descendants;
    }

    public PMFragment getVisibleFragment()
    {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0)
        {
            return getTopFragmentFromBackStack();
        } else
        {
            return null;
        }
    }

    public boolean has_onSaveInstanceState_beenCalled()
    {
        return bSaveStateCalled;
    }

    public void hideDrawer()
    {
        enableDrawer(false);
    }

    public boolean isActivityInForeground()
    {
        return bIsInForeground;
    }

    public boolean isDrawerOpen()
    {
        drawer = (PMDrawerLayout)findViewById(0x7f0c0048);
        if (drawer != null)
        {
            return drawer.isDrawerOpen(5);
        } else
        {
            return false;
        }
    }

    public void killDrawerFragment(PMFragment pmfragment)
    {
        if (!has_onSaveInstanceState_beenCalled() && !isFinishing)
        {
            FragmentManager fragmentmanager = getSupportFragmentManager();
            pmfragment = (PMFragment)fragmentmanager.findFragmentByTag(pmfragment.getFragmentId().toString());
            if (pmfragment != null)
            {
                drawer = (PMDrawerLayout)findViewById(0x7f0c0048);
                Object obj = drawer.getCurrentFragment();
                if (obj != null && ((PMFragment) (obj)).equals(pmfragment))
                {
                    drawer.setCurrentFragment(null);
                    drawer.setDrawerListener(null);
                }
                obj = fragmentmanager.beginTransaction();
                ((FragmentTransaction) (obj)).remove(pmfragment);
                ((FragmentTransaction) (obj)).commitAllowingStateLoss();
                fragmentmanager.executePendingTransactions();
            }
        }
    }

    public void launchDialogFragmentForResult(Bundle bundle, Class class1, Object obj, PMFragment pmfragment, int i)
    {
        try
        {
            class1 = (PMDialogFragment)class1.newInstance();
            class1.setTargetFragment(pmfragment, i);
            class1.setArguments(bundle);
            class1.setUserVisibleHint(true);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
            return;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        class1.setFragmentData(obj);
        bundle = getSupportFragmentManager();
        obj = bundle.beginTransaction();
        pmfragment = (PMDialogFragment)bundle.findFragmentByTag("dialog");
        if (pmfragment == null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        ((FragmentTransaction) (obj)).remove(pmfragment);
        ((FragmentTransaction) (obj)).addToBackStack(null);
        class1.show(bundle, "dialog");
        return;
    }

    public void launchFragment(Bundle bundle, Class class1, Object obj)
    {
        int i;
        try
        {
            class1 = (PMFragment)class1.newInstance();
            class1.setArguments(bundle);
            class1.setUserVisibleHint(true);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
            return;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        class1.setFragmentData(obj);
        class1.setNavigationList(descendants);
        bundle = getSupportFragmentManager();
        i = bundle.getBackStackEntryCount();
        bundle = bundle.beginTransaction();
        bundle.replace(0x7f0c0049, class1, Integer.toString(i + 1));
        bundle.addToBackStack(null);
        bundle.commit();
        return;
    }

    public void launchFragmentForResult(Bundle bundle, Class class1, Object obj, PMFragment pmfragment, int i)
    {
        try
        {
            class1 = (PMFragment)class1.newInstance();
            class1.setTargetFragment(pmfragment, i);
            class1.setArguments(bundle);
            class1.setUserVisibleHint(true);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
            return;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        class1.setFragmentData(obj);
        class1.setNavigationList(descendants);
        bundle = getSupportFragmentManager();
        i = bundle.getBackStackEntryCount();
        obj = bundle.beginTransaction();
        ((FragmentTransaction) (obj)).replace(0x7f0c0049, class1, Integer.toString(i + 1));
        ((FragmentTransaction) (obj)).addToBackStack(null);
        ((FragmentTransaction) (obj)).commit();
        bundle.executePendingTransactions();
        return;
    }

    public void launchFragmentInNewActivity(Bundle bundle, Class class1, Object obj)
    {
        Intent intent = new Intent(this, com/poshmark/ui/PMContainerActivity);
        intent.putExtra("FRAGMENT", class1);
        intent.putExtra("FRAGMENT_DATA", bundle);
        if (obj != null)
        {
            bundle = ObjectPickupDropOff.getUniqueKey();
            ObjectPickupDropOff.dropOffDataObject(bundle, obj);
            intent.putExtra("DATAKEY", new ParcelUuid(bundle));
        }
        if (descendants != null)
        {
            bundle = ObjectPickupDropOff.getUniqueKey();
            ObjectPickupDropOff.dropOffDataObject(bundle, descendants);
            intent.putExtra("SCREENSTACK", new ParcelUuid(bundle));
        }
        startActivity(intent);
    }

    public void launchFragmentInNewActivityForResult(Bundle bundle, Class class1, Object obj, PMFragment pmfragment, int i)
    {
        Intent intent = new Intent(this, com/poshmark/ui/PMContainerActivity);
        intent.putExtra("FRAGMENT", class1);
        intent.putExtra("FRAGMENT_DATA", bundle);
        if (obj != null)
        {
            bundle = ObjectPickupDropOff.getUniqueKey();
            ObjectPickupDropOff.dropOffDataObject(bundle, obj);
            intent.putExtra("DATAKEY", new ParcelUuid(bundle));
        }
        if (descendants != null)
        {
            bundle = ObjectPickupDropOff.getUniqueKey();
            ObjectPickupDropOff.dropOffDataObject(bundle, descendants);
            intent.putExtra("SCREENSTACK", new ParcelUuid(bundle));
        }
        bundle = pmfragment.getParentFragment();
        if (bundle != null)
        {
            bundle.startActivityForResult(intent, i);
            return;
        } else
        {
            pmfragment.startActivityForResult(intent, i);
            return;
        }
    }

    public void launchSearchActivity()
    {
    }

    public void lockDrawer()
    {
        drawer = (PMDrawerLayout)findViewById(0x7f0c0048);
        drawer.setDrawerLockMode(2);
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (FacebookSdk.isFacebookRequestCode(i))
        {
            FbHelper.getInstance().getCallbackManager().onActivityResult(i, j, intent);
        } else
        {
            if (i == GooglePlusHelper.GP_REQUEST)
            {
                GooglePlusHelper.getInstance().handleResultFromActivity(i, j, intent);
                return;
            }
            if (i == 8772 || i == 9494)
            {
                PinterestHelper.getInstance().onActivityResult(i, j, intent);
                return;
            }
        }
    }

    public void onBackPressed()
    {
        FragmentManager fragmentmanager = getSupportFragmentManager();
        int i = fragmentmanager.getBackStackEntryCount();
        if (i == 0)
        {
            super.onBackPressed();
        } else
        {
            PMFragment pmfragment = getTopFragmentFromBackStack();
            if (pmfragment != null)
            {
                if (!pmfragment.handleBack())
                {
                    if (i == 1)
                    {
                        isFinishing = true;
                        finish();
                        return;
                    } else
                    {
                        killDrawerFragment(pmfragment);
                        fragmentmanager.popBackStack();
                        return;
                    }
                }
            } else
            if (i == 1)
            {
                isFinishing = true;
                finish();
                return;
            } else
            {
                fragmentmanager.popBackStack();
                return;
            }
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030033);
        if (bundle == null)
        {
            Object obj = getIntent().getExtras();
            if (obj != null)
            {
                Class class1 = (Class)((Bundle) (obj)).getSerializable("FRAGMENT");
                Bundle bundle1 = ((Bundle) (obj)).getBundle("FRAGMENT_DATA");
                if (class1 != null)
                {
                    bundle = null;
                    ParcelUuid parceluuid = (ParcelUuid)((Bundle) (obj)).getParcelable("DATAKEY");
                    if (parceluuid != null)
                    {
                        bundle = ((Bundle) (ObjectPickupDropOff.pickupDataObject(parceluuid.getUuid())));
                    }
                    obj = (ParcelUuid)((Bundle) (obj)).getParcelable("SCREENSTACK");
                    if (obj != null)
                    {
                        descendants = (List)ObjectPickupDropOff.pickupDataObject(((ParcelUuid) (obj)).getUuid());
                    }
                    launchFragment(bundle1, class1, bundle);
                }
            }
        }
        getSupportFragmentManager().addOnBackStackChangedListener(backStackChangedListener);
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bSaveStateCalled = true;
    }

    public boolean onSearchRequested()
    {
        return false;
    }

    public void openDrawer()
    {
        drawer = (PMDrawerLayout)findViewById(0x7f0c0048);
        drawer.openDrawer(5);
    }

    public void openDrawerDelayed()
    {
    }

    public void popTopFragment()
    {
        FragmentManager fragmentmanager = getSupportFragmentManager();
        if (fragmentmanager.getBackStackEntryCount() == 1)
        {
            finish();
            return;
        } else
        {
            fragmentmanager.popBackStack();
            return;
        }
    }

    public void popTopNFragments(int i, boolean flag)
    {
        FragmentManager fragmentmanager = getSupportFragmentManager();
        if (fragmentmanager.getBackStackEntryCount() > i)
        {
            while (i > 0) 
            {
                if (flag)
                {
                    fragmentmanager.popBackStackImmediate();
                } else
                {
                    fragmentmanager.popBackStack();
                }
                i--;
            }
        }
    }

    public void replaceFragment(Bundle bundle, Class class1, Object obj)
    {
        int i;
        try
        {
            class1 = (PMFragment)class1.newInstance();
            class1.setArguments(bundle);
            class1.setUserVisibleHint(true);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
            return;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        class1.setFragmentData(obj);
        class1.setNavigationList(descendants);
        bundle = getSupportFragmentManager();
        i = bundle.getBackStackEntryCount();
        bundle = bundle.beginTransaction();
        obj = getVisibleFragment();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        ((PMFragment) (obj)).setUserVisibleHint(false);
        bundle.hide(((Fragment) (obj)));
        bundle.add(0x7f0c0049, class1, Integer.toString(i + 1));
        bundle.addToBackStack(null);
        bundle.commit();
        return;
    }

    public PMFragment setDrawerData(Class class1, PMFragment pmfragment, Object obj)
    {
        Object obj2 = null;
        if (has_onSaveInstanceState_beenCalled()) goto _L2; else goto _L1
_L1:
        Object obj1;
        Object obj3;
        drawer = (PMDrawerLayout)findViewById(0x7f0c0048);
        obj3 = getSupportFragmentManager();
        obj1 = (PMFragment)((FragmentManager) (obj3)).findFragmentByTag(pmfragment.getFragmentId().toString());
        if (obj1 != null) goto _L4; else goto _L3
_L3:
        obj2 = obj1;
        try
        {
            class1 = (PMFragment)class1.newInstance();
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            class1.printStackTrace();
            return ((PMFragment) (obj2));
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            class1.printStackTrace();
            return ((PMFragment) (obj1));
        }
        obj2 = class1;
        obj1 = class1;
        class1.setFragmentData(obj);
        obj2 = class1;
        obj1 = class1;
        obj = ((FragmentManager) (obj3)).beginTransaction();
        obj2 = class1;
        obj1 = class1;
        obj3 = drawer.getCurrentFragment();
        if (obj3 == null)
        {
            break MISSING_BLOCK_LABEL_119;
        }
        obj2 = class1;
        obj1 = class1;
        ((FragmentTransaction) (obj)).hide(((Fragment) (obj3)));
        obj2 = class1;
        obj1 = class1;
        drawer.setCurrentFragment(class1);
        obj2 = class1;
        obj1 = class1;
        ((FragmentTransaction) (obj)).add(0x7f0c004b, class1, pmfragment.getFragmentId().toString());
        obj2 = class1;
        obj1 = class1;
        ((FragmentTransaction) (obj)).commit();
        obj2 = class1;
_L2:
        return ((PMFragment) (obj2));
_L4:
        class1 = ((FragmentManager) (obj3)).beginTransaction();
        pmfragment = drawer.getCurrentFragment();
        if (pmfragment == null)
        {
            break; /* Loop/switch isn't completed */
        }
        obj2 = obj1;
        if (pmfragment.equals(obj1)) goto _L2; else goto _L5
_L5:
        if (pmfragment != null)
        {
            class1.hide(pmfragment);
        }
        drawer.setCurrentFragment(((PMFragment) (obj1)));
        class1.show(((Fragment) (obj1)));
        class1.commit();
        return ((PMFragment) (obj1));
    }

    public void setDrawerListener(android.support.v4.widget.DrawerLayout.DrawerListener drawerlistener)
    {
        drawer = (PMDrawerLayout)findViewById(0x7f0c0048);
        drawer.setDrawerListener(drawerlistener);
    }

    public void setScreenNavigationStack(List list)
    {
        descendants = list;
    }

    public void toggleDrawer()
    {
        drawer = (PMDrawerLayout)findViewById(0x7f0c0048);
        if (drawer.isDrawerOpen(5))
        {
            drawer.closeDrawer(5);
            return;
        } else
        {
            drawer.openDrawer(5);
            return;
        }
    }

}
