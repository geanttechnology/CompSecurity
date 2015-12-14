// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.fragment;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.util.Pair;
import com.amazon.gallery.foundation.ui.layout.LayoutType;
import com.amazon.gallery.foundation.utils.apilevel.Api;
import com.amazon.gallery.framework.gallery.view.ViewDescriptor;
import com.amazon.gallery.framework.kindle.provider.MediaContentConfiguration;
import com.amazon.gallery.thor.app.FeatureChecker;
import com.amazon.gallery.thor.app.activity.ThorViewActivity;

// Referenced classes of package com.amazon.gallery.framework.kindle.fragment:
//            GridFragment, MosaicFragment, ViewFragment, SingleViewFragment, 
//            AdapterFragment

public abstract class FragmentController
{

    private final Activity activity;
    private final FeatureChecker featureChecker;
    private Fragment fragment;
    private FragmentManager fragmentManager;
    private boolean inAddToAlbumChooserMode;
    private boolean inChooserMode;
    private Pair scrollState;
    private boolean transactionPending;

    public FragmentController(Activity activity1, FragmentManager fragmentmanager, FeatureChecker featurechecker)
    {
        inChooserMode = false;
        inAddToAlbumChooserMode = false;
        transactionPending = false;
        activity = activity1;
        fragmentManager = fragmentmanager;
        featureChecker = featurechecker;
    }

    private void completeFragmentTransaction(FragmentTransaction fragmenttransaction, Fragment fragment1)
    {
        fragmenttransaction.commitAllowingStateLoss();
        fragmentManager.executePendingTransactions();
        fragment = fragment1;
        transactionPending = false;
    }

    private LayoutType determineLayoutType(LayoutType layouttype)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$amazon$gallery$foundation$ui$layout$LayoutType[];

            static 
            {
                $SwitchMap$com$amazon$gallery$foundation$ui$layout$LayoutType = new int[LayoutType.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$foundation$ui$layout$LayoutType[LayoutType.SINGLE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$foundation$ui$layout$LayoutType[LayoutType.GRID.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$foundation$ui$layout$LayoutType[LayoutType.MOSAIC.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.amazon.gallery.foundation.ui.layout.LayoutType[layouttype.ordinal()];
        JVM INSTR tableswitch 1 1: default 28
    //                   1 30;
           goto _L1 _L2
_L1:
        return layouttype;
_L2:
        if (!featureChecker.hasSingleLayout() && !(activity instanceof ThorViewActivity))
        {
            boolean flag;
            if (activity.getResources().getConfiguration().orientation == 2)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                layouttype = LayoutType.MOSAIC;
            } else
            {
                layouttype = LayoutType.GRID;
            }
            return layouttype;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    private LayoutType getCurrentLayoutType()
    {
        if (fragment instanceof GridFragment)
        {
            return LayoutType.GRID;
        }
        if (fragment instanceof MosaicFragment)
        {
            return LayoutType.MOSAIC;
        } else
        {
            return LayoutType.SINGLE;
        }
    }

    private Fragment restoreActiveFragment()
    {
        Fragment fragment2 = fragmentManager.findFragmentByTag(com/amazon/gallery/framework/kindle/fragment/GridFragment.getSimpleName());
        Fragment fragment1 = fragment2;
        if (fragment2 == null)
        {
            fragment1 = fragmentManager.findFragmentByTag(com/amazon/gallery/framework/kindle/fragment/MosaicFragment.getSimpleName());
        }
        return fragment1;
    }

    private void saveScrollState()
    {
        if (fragment instanceof ViewFragment)
        {
            scrollState = ((ViewFragment)fragment).getScrollState();
        }
    }

    private boolean shouldAnimate(LayoutType layouttype)
    {
        if (fragment != null)
        {
            LayoutType layouttype1 = getCurrentLayoutType();
            switch (_cls1..SwitchMap.com.amazon.gallery.foundation.ui.layout.LayoutType[layouttype.ordinal()])
            {
            default:
                return false;

            case 1: // '\001'
                return true;

            case 2: // '\002'
            case 3: // '\003'
                break;
            }
            if (layouttype1 == LayoutType.SINGLE)
            {
                return true;
            }
        }
        return false;
    }

    private void switchMainFragment(Fragment fragment1, boolean flag)
    {
        transactionPending = true;
        FragmentTransaction fragmenttransaction = fragmentManager.beginTransaction();
        if (Api.isAtLeastAPI(11) && flag)
        {
            fragmenttransaction.setCustomAnimations(0x7f040020, 0x7f040021, 0x7f040020, 0x7f040021);
        }
        fragmenttransaction.replace(getFragmentContainer(), fragment1, fragment1.getClass().getSimpleName());
        completeFragmentTransaction(fragmenttransaction, fragment1);
    }

    private void switchToGridFragment(MediaContentConfiguration mediacontentconfiguration, int i, boolean flag)
    {
        ViewFragment viewfragment = (ViewFragment)fragmentManager.findFragmentByTag(com/amazon/gallery/framework/kindle/fragment/GridFragment.getSimpleName());
        Object obj = viewfragment;
        if (viewfragment == null)
        {
            obj = new GridFragment();
        }
        switchToViewFragment(((ViewFragment) (obj)), mediacontentconfiguration, i, flag);
    }

    private void switchToMosaicFragment(MediaContentConfiguration mediacontentconfiguration, int i, boolean flag)
    {
        ViewFragment viewfragment = (ViewFragment)fragmentManager.findFragmentByTag(com/amazon/gallery/framework/kindle/fragment/MosaicFragment.getSimpleName());
        Object obj = viewfragment;
        if (viewfragment == null)
        {
            obj = new MosaicFragment();
        }
        switchToViewFragment(((ViewFragment) (obj)), mediacontentconfiguration, i, flag);
    }

    private void switchToSingleViewFragment(int i, MediaContentConfiguration mediacontentconfiguration, boolean flag)
    {
        SingleViewFragment singleviewfragment1 = (SingleViewFragment)fragmentManager.findFragmentByTag(com/amazon/gallery/framework/kindle/fragment/SingleViewFragment.getSimpleName());
        SingleViewFragment singleviewfragment = singleviewfragment1;
        if (singleviewfragment1 == null)
        {
            singleviewfragment = new SingleViewFragment();
        }
        if (!singleviewfragment.isAdded())
        {
            Bundle bundle = new Bundle();
            bundle.putInt("START_POSITION", i);
            singleviewfragment.setArguments(bundle);
        }
        singleviewfragment.setContentConfiguration(mediacontentconfiguration);
        switchMainFragment(singleviewfragment, flag);
    }

    private void switchToViewFragment(ViewFragment viewfragment, MediaContentConfiguration mediacontentconfiguration, int i, boolean flag)
    {
        int j = 0;
        hideMainFragment(false);
        viewfragment.setContentConfiguration(mediacontentconfiguration);
        if (scrollState != null)
        {
            i = ((Integer)scrollState.first).intValue();
        }
        if (scrollState != null)
        {
            j = ((Integer)scrollState.second).intValue();
        }
        if (viewfragment.isAdded())
        {
            viewfragment.scrollToPositionWithOffset(i, j);
        } else
        {
            mediacontentconfiguration = new Bundle();
            mediacontentconfiguration.putInt("START_POSITION", i);
            mediacontentconfiguration.putInt("POSITION_OFFSET", j);
            mediacontentconfiguration.putBoolean("chooser_mode", inChooserMode);
            mediacontentconfiguration.putBoolean("add_to_album_chooser_mode", inAddToAlbumChooserMode);
            viewfragment.setArguments(mediacontentconfiguration);
        }
        switchMainFragment(viewfragment, flag);
    }

    public Fragment getFragment()
    {
        if (fragment != null)
        {
            return fragment;
        } else
        {
            fragment = restoreActiveFragment();
            return fragment;
        }
    }

    protected abstract int getFragmentContainer();

    public boolean getInAddToAlbumChooserMode()
    {
        return inAddToAlbumChooserMode;
    }

    public boolean getInChooserMode()
    {
        return inChooserMode;
    }

    public void hideMainFragment(boolean flag)
    {
        if (fragment == null)
        {
            return;
        }
        transactionPending = true;
        FragmentTransaction fragmenttransaction = fragmentManager.beginTransaction();
        if (Api.isAtLeastAPI(11) && flag)
        {
            fragmenttransaction.setCustomAnimations(0x7f040020, 0x7f040021, 0x7f040020, 0x7f040021);
        }
        fragmenttransaction.remove(fragment);
        completeFragmentTransaction(fragmenttransaction, null);
    }

    public boolean isFragmentOpen()
    {
        fragment = restoreActiveFragment();
        return fragment != null;
    }

    public void onNavigateTo(LayoutType layouttype, MediaContentConfiguration mediacontentconfiguration)
    {
        int i;
        if (fragment instanceof AdapterFragment)
        {
            i = ((AdapterFragment)fragment).getFirstVisiblePosition();
        } else
        {
            i = mediacontentconfiguration.toViewDescriptor().getFocusedIndex();
        }
        onNavigateTo(layouttype, mediacontentconfiguration, i);
    }

    public void onNavigateTo(LayoutType layouttype, MediaContentConfiguration mediacontentconfiguration, int i)
    {
        if (!transactionPending) goto _L2; else goto _L1
_L1:
        return;
_L2:
        saveScrollState();
        layouttype = determineLayoutType(layouttype);
        if (layouttype != LayoutType.SINGLE)
        {
            break; /* Loop/switch isn't completed */
        }
        if (!(fragment instanceof SingleViewFragment))
        {
            switchToSingleViewFragment(i, mediacontentconfiguration, shouldAnimate(layouttype));
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (layouttype != LayoutType.MOSAIC)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (fragment instanceof MosaicFragment) goto _L1; else goto _L4
_L4:
        switchToMosaicFragment(mediacontentconfiguration, i, shouldAnimate(layouttype));
        return;
        if (layouttype != LayoutType.GRID || (fragment instanceof GridFragment)) goto _L1; else goto _L5
_L5:
        switchToGridFragment(mediacontentconfiguration, i, shouldAnimate(layouttype));
        return;
    }

    public boolean setContentConfiguration(MediaContentConfiguration mediacontentconfiguration)
    {
        while (fragment == null || !(fragment instanceof AdapterFragment)) 
        {
            return false;
        }
        ((AdapterFragment)fragment).setContentConfiguration(mediacontentconfiguration);
        return true;
    }

    public void setInAddToAlbumChooserMode(boolean flag)
    {
        inAddToAlbumChooserMode = flag;
    }

    public void setInChooserMode(boolean flag)
    {
        inChooserMode = flag;
    }
}
