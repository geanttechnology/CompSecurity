// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ViewAnimator;
import com.aviary.android.feather.cds.CdsUtils;
import com.aviary.android.feather.cds.billing.util.Inventory;
import com.aviary.android.feather.cds.billing.util.Purchase;
import com.aviary.android.feather.common.log.LoggerFactory;
import com.aviary.android.feather.common.tracking.AviaryTracker;
import com.aviary.android.feather.library.services.LocalDataService;
import com.aviary.android.feather.sdk.AviaryMainController;
import com.aviary.android.feather.sdk.FeatherActivity;
import java.util.HashMap;

// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            AviaryStoreWrapper, IAPDialogList, IAPDialogDetail

public class IAPDialogMain
    implements AviaryStoreWrapperAbstract.Callback, IAPDialogList.OnPackSelectedListener
{
    public static class IAPUpdater
        implements Cloneable
    {

        private Bundle dialogExtras;
        private HashMap eventAttributes;
        private String eventName;
        private long featuredPackId;
        private boolean isAnimating;
        private long packId;
        private com.aviary.android.feather.cds.AviaryCds.PackType packType;

        public Object clone()
        {
            IAPUpdater iapupdater = new IAPUpdater();
            iapupdater.packId = packId;
            iapupdater.packType = packType;
            iapupdater.featuredPackId = featuredPackId;
            iapupdater.isAnimating = isAnimating;
            if (dialogExtras != null)
            {
                iapupdater.dialogExtras = (Bundle)dialogExtras.clone();
            }
            return iapupdater;
        }

        public boolean equals(Object obj)
        {
            if (obj instanceof IAPUpdater)
            {
                obj = (IAPUpdater)obj;
                return ((IAPUpdater) (obj)).packId == packId && ((IAPUpdater) (obj)).packType == packType;
            } else
            {
                return super.equals(obj);
            }
        }

        public Bundle getExtras()
        {
            return dialogExtras;
        }

        public long getFeaturedPackId()
        {
            return featuredPackId;
        }

        public boolean getIsAnimating()
        {
            return isAnimating;
        }

        public long getPackId()
        {
            return packId;
        }

        public com.aviary.android.feather.cds.AviaryCds.PackType getPackType()
        {
            return packType;
        }

        public int hashCode()
        {
            return Long.valueOf(packId).hashCode() + packType.hashCode() * 37;
        }

        public String toString()
        {
            return (new StringBuilder()).append("IAPUpdater{packType: ").append(packType).append(", packId: ").append(packId).append(", featuredPackId: ").append(featuredPackId).append("}").toString();
        }



/*
        static long access$102(IAPUpdater iapupdater, long l)
        {
            iapupdater.packId = l;
            return l;
        }

*/



/*
        static com.aviary.android.feather.cds.AviaryCds.PackType access$202(IAPUpdater iapupdater, com.aviary.android.feather.cds.AviaryCds.PackType packtype)
        {
            iapupdater.packType = packtype;
            return packtype;
        }

*/



/*
        static String access$302(IAPUpdater iapupdater, String s)
        {
            iapupdater.eventName = s;
            return s;
        }

*/



/*
        static boolean access$502(IAPUpdater iapupdater, boolean flag)
        {
            iapupdater.isAnimating = flag;
            return flag;
        }

*/


/*
        static long access$702(IAPUpdater iapupdater, long l)
        {
            iapupdater.featuredPackId = l;
            return l;
        }

*/


/*
        static Bundle access$802(IAPUpdater iapupdater, Bundle bundle)
        {
            iapupdater.dialogExtras = bundle;
            return bundle;
        }

*/

        public IAPUpdater()
        {
            packId = -1L;
            packType = null;
            eventName = null;
            featuredPackId = -1L;
            eventAttributes = new HashMap();
        }
    }

    public static class IAPUpdater.Builder
    {

        IAPUpdater result;

        public IAPUpdater.Builder addEventAttributes(String s, String s1)
        {
            result.eventAttributes.put(s, s1);
            return this;
        }

        public IAPUpdater build()
        {
            return result;
        }

        public IAPUpdater.Builder setEvent(String s)
        {
            result.eventName = s;
            return this;
        }

        public IAPUpdater.Builder setExtras(Bundle bundle)
        {
            result.dialogExtras = bundle;
            return this;
        }

        public IAPUpdater.Builder setFeaturedPackId(long l)
        {
            result.featuredPackId = l;
            return this;
        }

        public IAPUpdater.Builder setPackId(long l)
        {
            result.packId = l;
            return this;
        }

        public IAPUpdater.Builder setPackType(com.aviary.android.feather.cds.AviaryCds.PackType packtype)
        {
            result.packType = packtype;
            return this;
        }

        public IAPUpdater.Builder()
        {
            result = new IAPUpdater();
        }
    }

    public static interface OnCloseListener
    {

        public abstract void onClose();
    }


    static com.aviary.android.feather.common.log.LoggerFactory.Logger logger;
    HashMap mCacheMap;
    OnCloseListener mCloseListener;
    AviaryMainController mController;
    IAPUpdater mData;
    private LocalDataService mDataService;
    HashMap mDownloadMap;
    private Runnable mHideRunnable;
    Inventory mInventory;
    AviaryStoreWrapper mStoreWrapper;
    ViewGroup mView;
    ViewAnimator mViewAnimator;

    public IAPDialogMain(ViewGroup viewgroup)
    {
        mDownloadMap = new HashMap();
        mCacheMap = new HashMap();
        mHideRunnable = new Runnable() {

            final IAPDialogMain this$0;

            public void run()
            {
                handleHide();
            }

            
            {
                this$0 = IAPDialogMain.this;
                super();
            }
        };
        mView = viewgroup;
        mView.setTag(this);
        mStoreWrapper = new AviaryStoreWrapper(this, getClass().hashCode());
        onAttachedToWindow();
    }

    private static ViewGroup addToParent(ViewGroup viewgroup, int i)
    {
        ViewGroup viewgroup1 = (ViewGroup)LayoutInflater.from(viewgroup.getContext()).inflate(com.aviary.android.feather.sdk.R.layout.aviary_iap_dialog_container, viewgroup, false);
        viewgroup1.setFocusable(true);
        if (i > -1)
        {
            viewgroup.addView(viewgroup1, i);
            return viewgroup1;
        } else
        {
            viewgroup.addView(viewgroup1);
            return viewgroup1;
        }
    }

    public static IAPDialogMain create(com.aviary.android.feather.sdk.AviaryMainController.FeatherContext feathercontext, IAPUpdater iapupdater)
    {
        logger.info("create");
        feathercontext = feathercontext.activatePopupContainer();
        ViewGroup viewgroup = (ViewGroup)feathercontext.findViewById(com.aviary.android.feather.sdk.R.id.aviary_main_iap_dialog_container);
        if (viewgroup == null)
        {
            feathercontext = new IAPDialogMain(addToParent(feathercontext, -1));
            feathercontext.update(iapupdater, true);
            return feathercontext;
        } else
        {
            feathercontext = (IAPDialogMain)viewgroup.getTag();
            feathercontext.update(iapupdater, false);
            return feathercontext;
        }
    }

    private void handleHide()
    {
        logger.info("handleHide");
        if (!isValid())
        {
            return;
        } else
        {
            Animation animation = AnimationUtils.loadAnimation(mView.getContext(), com.aviary.android.feather.sdk.R.anim.aviary_iap_close_animation);
            animation.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

                final IAPDialogMain this$0;

                public void onAnimationEnd(Animation animation1)
                {
                    removeFromParent();
                }

                public void onAnimationRepeat(Animation animation1)
                {
                }

                public void onAnimationStart(Animation animation1)
                {
                }

            
            {
                this$0 = IAPDialogMain.this;
                super();
            }
            });
            mView.startAnimation(animation);
            return;
        }
    }

    private void initController()
    {
        if (mController == null)
        {
            if (mView.getContext() instanceof FeatherActivity)
            {
                mController = ((FeatherActivity)mView.getContext()).getMainController();
            }
            return;
        } else
        {
            logger.log((new StringBuilder()).append("controller: ").append(mController).toString());
            return;
        }
    }

    private boolean removeFromParent()
    {
        logger.info("removeFromParent");
        if (mView != null)
        {
            ViewGroup viewgroup = (ViewGroup)mView.getParent();
            if (viewgroup != null)
            {
                viewgroup.removeView(mView);
                onDetachedFromWindow();
                return true;
            }
        }
        return false;
    }

    public void dismiss(boolean flag)
    {
        logger.info((new StringBuilder()).append("dismiss, animate: ").append(flag).toString());
        getListView().setOnPackSelectedListener(null);
        mStoreWrapper.unregisterReceivers();
        mStoreWrapper.onDetach();
        setOnCloseListener(null);
        if (flag)
        {
            hide();
            return;
        } else
        {
            removeFromParent();
            return;
        }
    }

    void displayChild(IAPUpdater iapupdater, int i, boolean flag)
    {
        int j = mViewAnimator.getDisplayedChild();
        logger.info("displayChild: %d, current: %d, firstTime: %b", new Object[] {
            Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(flag)
        });
        if (iapupdater != null)
        {
            boolean flag1;
            if (flag || i != j)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            iapupdater.isAnimating = flag1;
        }
        if (flag)
        {
            if (i == 0)
            {
                mViewAnimator.setAnimateFirstView(true);
            } else
            {
                mViewAnimator.setAnimateFirstView(false);
            }
        }
        if (i == 0)
        {
            mViewAnimator.setInAnimation(getContext(), com.aviary.android.feather.sdk.R.anim.aviary_void_animation);
            mViewAnimator.setOutAnimation(getContext(), com.aviary.android.feather.sdk.R.anim.aviary_slide_out_right);
        } else
        {
            mViewAnimator.setInAnimation(getContext(), com.aviary.android.feather.sdk.R.anim.aviary_slide_in_right);
            mViewAnimator.setOutAnimation(getContext(), com.aviary.android.feather.sdk.R.anim.aviary_void_animation);
        }
        if (j != i)
        {
            mViewAnimator.setDisplayedChild(i);
        }
    }

    public Context getContext()
    {
        if (mView != null)
        {
            return mView.getContext();
        } else
        {
            return null;
        }
    }

    public AviaryMainController getController()
    {
        return mController;
    }

    public IAPUpdater getData()
    {
        return mData;
    }

    IAPDialogDetail getDetailView()
    {
        if (mViewAnimator.getChildCount() > 0)
        {
            return (IAPDialogDetail)mViewAnimator.getChildAt(1);
        } else
        {
            return null;
        }
    }

    IAPDialogList getListView()
    {
        return (IAPDialogList)mViewAnimator.getChildAt(0);
    }

    public ViewParent getParent()
    {
        if (mView != null)
        {
            return mView.getParent();
        } else
        {
            return null;
        }
    }

    public AviaryStoreWrapper getStoreWrapper()
    {
        return mStoreWrapper;
    }

    protected void hide()
    {
        logger.info("hide");
        if (!isValid())
        {
            return;
        } else
        {
            mView.post(mHideRunnable);
            return;
        }
    }

    public boolean isChildVisible(View view)
    {
        return view.equals(mViewAnimator.getChildAt(mViewAnimator.getDisplayedChild()));
    }

    public boolean isValid()
    {
        return mView != null && mView.getWindowToken() != null;
    }

    protected void onAttachedToWindow()
    {
        logger.info("onAttachedToWindow");
        mViewAnimator = (ViewAnimator)mView.findViewById(com.aviary.android.feather.sdk.R.id.aviary_view_animator);
        mDataService = (LocalDataService)((FeatherActivity)getContext()).getMainController().getService(com/aviary/android/feather/library/services/LocalDataService);
        mStoreWrapper.onAttach((FeatherActivity)getContext());
        mStoreWrapper.registerReceivers();
    }

    public boolean onBackPressed()
    {
        IAPDialogList iapdialoglist;
        if (mViewAnimator.getDisplayedChild() != 0)
        {
            if ((iapdialoglist = (IAPDialogList)mViewAnimator.getChildAt(0)) != null && iapdialoglist.getData() != null)
            {
                displayChild(mData, 0, false);
                return true;
            }
        }
        return false;
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        logger.info("onConfigurationChanged");
        if (!isValid())
        {
            return;
        }
        configuration = (ViewGroup)mView.getParent();
        if (configuration != null)
        {
            int i = configuration.indexOfChild(mView);
            removeFromParent();
            mView = addToParent(configuration, i);
            configuration = (ViewGroup)mView.findViewById(com.aviary.android.feather.sdk.R.id.aviary_main_iap_dialog);
            if (configuration != null)
            {
                configuration.setLayoutAnimation(null);
            }
            onAttachedToWindow();
            update((IAPUpdater)mData.clone());
            return;
        } else
        {
            logger.error("parent is null");
            return;
        }
    }

    protected void onDetachedFromWindow()
    {
        logger.info("onDetachedFromWindow");
    }

    public void onDownloadStatusChanged(long l, String s, int i)
    {
        logger.info("onDownloadStatusChanged: %d - %s - %d", new Object[] {
            Long.valueOf(l), s, Integer.valueOf(i)
        });
        if (isValid())
        {
            mDownloadMap.put(Long.valueOf(l), com.aviary.android.feather.cds.CdsUtils.PackOption.fromDownloadManagerStatus(i));
            IAPDialogList iapdialoglist = getListView();
            IAPDialogDetail iapdialogdetail = getDetailView();
            if (iapdialoglist != null && iapdialoglist.getData() != null)
            {
                iapdialoglist.onDownloadStatusChanged(l, s, i);
            }
            if (iapdialogdetail != null && iapdialogdetail.getData() != null && mViewAnimator.getDisplayedChild() == 1)
            {
                iapdialogdetail.onDownloadStatusChanged(l, s, i);
                return;
            }
        }
    }

    public void onPackInstalled(long l, String s, int i)
    {
        logger.info("onPackInstalled: %d - %s - %d", new Object[] {
            Long.valueOf(l), s, Integer.valueOf(i)
        });
        if (!isValid())
        {
            return;
        }
        mDownloadMap.remove(Long.valueOf(l));
        if (i != 1) goto _L2; else goto _L1
_L1:
        mCacheMap.put(Long.valueOf(l), com.aviary.android.feather.cds.CdsUtils.PackOption.OWNED);
_L4:
        IAPDialogList iapdialoglist = getListView();
        IAPDialogDetail iapdialogdetail = getDetailView();
        if (iapdialoglist != null && iapdialoglist.getData() != null)
        {
            iapdialoglist.onPackInstalled(l, s, i);
        }
        if (iapdialogdetail != null && iapdialogdetail.getData() != null && mViewAnimator.getDisplayedChild() == 1)
        {
            iapdialogdetail.onPackInstalled(l, s, i);
        }
        dismiss(true);
        return;
_L2:
        mCacheMap.remove(Long.valueOf(l));
        com.aviary.android.feather.cds.CdsUtils.PackOption packoption = CdsUtils.getPackOption(getContext(), CdsUtils.getPackFullInfoById(getContext(), l));
        if (packoption != com.aviary.android.feather.cds.CdsUtils.PackOption.PACK_OPTION_BEING_DETERMINED)
        {
            mCacheMap.put(Long.valueOf(l), packoption);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onPackSelected(long l, com.aviary.android.feather.cds.AviaryCds.PackType packtype, String s)
    {
        logger.info((new StringBuilder()).append("onPackSelected: ").append(l).toString());
        update((new IAPUpdater.Builder()).setPackId(l).setPackType(packtype).setEvent("shop_details: opened").addEventAttributes("pack", s).addEventAttributes("from", "shop_list").build());
    }

    public void onPurchaseSuccess(long l, String s, Purchase purchase)
    {
        if (isValid())
        {
            logger.info("onPurchaseSuccess(%d, %s)", new Object[] {
                Long.valueOf(l), s
            });
            if (mInventory != null)
            {
                mInventory.addPurchase(purchase);
            }
            IAPDialogList iapdialoglist = getListView();
            IAPDialogDetail iapdialogdetail = getDetailView();
            if (iapdialoglist != null && iapdialoglist.getData() != null)
            {
                iapdialoglist.onPurchaseSuccess(l, s, purchase);
            }
            if (iapdialogdetail != null && iapdialogdetail.getData() != null && mViewAnimator.getDisplayedChild() == 1)
            {
                iapdialogdetail.onPurchaseSuccess(l, s, purchase);
                return;
            }
        }
    }

    public void onServiceFinished()
    {
        logger.info("onServiceFinished");
        if (isValid())
        {
            IAPDialogList iapdialoglist = getListView();
            IAPDialogDetail iapdialogdetail = getDetailView();
            if (iapdialoglist != null && iapdialoglist.getData() != null)
            {
                iapdialoglist.onServiceFinished();
            }
            if (iapdialogdetail != null && iapdialogdetail.getData() != null && mViewAnimator.getDisplayedChild() == 1)
            {
                iapdialogdetail.onServiceFinished();
                return;
            }
        }
    }

    public void onSubscriptionPurchased(String s, int i)
    {
        logger.info("onSubscriptionPurchased: %s - %d", new Object[] {
            s, Integer.valueOf(i)
        });
        if (isValid())
        {
            IAPDialogList iapdialoglist = getListView();
            IAPDialogDetail iapdialogdetail = getDetailView();
            if (iapdialoglist != null && iapdialoglist.getData() != null)
            {
                iapdialoglist.onSubscriptionPurchased(s, i);
            }
            if (iapdialogdetail != null && iapdialogdetail.getData() != null && mViewAnimator.getDisplayedChild() == 1)
            {
                iapdialogdetail.onSubscriptionPurchased(s, i);
                return;
            }
        }
    }

    public void setOnCloseListener(OnCloseListener oncloselistener)
    {
        mCloseListener = oncloselistener;
    }

    public void update(IAPUpdater iapupdater)
    {
        update(iapupdater, false);
    }

    public void update(IAPUpdater iapupdater, boolean flag)
    {
        logger.info("update");
        if (iapupdater != null && isValid())
        {
            mData = iapupdater;
            initController();
            if (iapupdater.packId < 0L && iapupdater.packType == null)
            {
                logger.error("invalid updater instance");
                return;
            }
            mViewAnimator.getDisplayedChild();
            int i;
            if (iapupdater.getPackId() < 0L)
            {
                i = 0;
            } else
            {
                i = 1;
            }
            if (mData.eventName != null)
            {
                if (mData.eventAttributes != null)
                {
                    getController().getTracker().tagEventAttributes(mData.eventName, mData.eventAttributes);
                } else
                {
                    getController().getTracker().tagEvent(mData.eventName);
                }
            }
            displayChild(mData, i, flag);
            if (i == 0)
            {
                IAPDialogList iapdialoglist = (IAPDialogList)mViewAnimator.getChildAt(i);
                IAPUpdater iapupdater1 = iapdialoglist.getData();
                if (iapupdater != null && !iapupdater.equals(iapupdater1))
                {
                    iapdialoglist.update(iapupdater, this);
                }
                iapdialoglist.setOnPackSelectedListener(this);
                return;
            }
            IAPDialogDetail iapdialogdetail = (IAPDialogDetail)mViewAnimator.getChildAt(i);
            IAPUpdater iapupdater2 = iapdialogdetail.getData();
            if (iapupdater != null && !iapupdater.equals(iapupdater2))
            {
                iapdialogdetail.update(iapupdater, this);
                return;
            }
        }
    }

    static 
    {
        logger = LoggerFactory.getLogger("IAPDialogMain", com.aviary.android.feather.common.log.LoggerFactory.LoggerType.ConsoleLoggerType);
    }


}
