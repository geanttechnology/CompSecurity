// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.aviary.android.feather.cds.billing.util.Inventory;
import com.aviary.android.feather.common.tracking.AviaryTracker;
import com.aviary.android.feather.library.services.BadgeService;
import com.aviary.android.feather.sdk.AviaryMainController;
import com.aviary.android.feather.sdk.FeatherActivity;

// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            PackDetailLayout, IAPDialogMain, AviaryStoreWrapper, AviaryStoreWrapperAbstract

public class IAPDialogDetail extends PackDetailLayout
{

    public static final String EXTRA_CLICK_FROM_POSITION = "click_from_position";
    private BadgeService mBadgeService;
    private IAPDialogMain.IAPUpdater mData;
    private IAPDialogMain mParent;

    public IAPDialogDetail(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public IAPDialogMain.IAPUpdater getData()
    {
        return mData;
    }

    public Inventory getInventory()
    {
        return mParent.mInventory;
    }

    protected AviaryStoreWrapperAbstract getStoreWrapper()
    {
        return mParent.getStoreWrapper();
    }

    protected boolean isChildVisible(PackDetailLayout packdetaillayout)
    {
        return mParent.isChildVisible(this);
    }

    public boolean isValidContext()
    {
        return isAttached() && getContext() != null;
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        mBadgeService = (BadgeService)((FeatherActivity)getContext()).getMainController().getService(com/aviary/android/feather/library/services/BadgeService);
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        try
        {
            mParent.getController().getTracker().tagEvent("shop_details: closed");
            return;
        }
        catch (Throwable throwable)
        {
            return;
        }
    }

    protected void onForceUpdate()
    {
        update(mData, mParent);
    }

    protected void onSetPackContentCompleted(com.aviary.android.feather.cds.PacksColumns.PackCursorWrapper packcursorwrapper)
    {
        if (mBadgeService != null && packcursorwrapper != null)
        {
            mBadgeService.markAsRead(packcursorwrapper.getIdentifier());
        }
    }

    public void setInventory(Inventory inventory)
    {
    }

    public void update(IAPDialogMain.IAPUpdater iapupdater, IAPDialogMain iapdialogmain)
    {
        logger.info("update: %s", new Object[] {
            iapupdater
        });
        logger.log("isValidContext: %b", new Object[] {
            Boolean.valueOf(isValidContext())
        });
        while (iapupdater == null || !isValidContext() || !iapdialogmain.getStoreWrapper().isActive()) 
        {
            return;
        }
        mParent = iapdialogmain;
        mData = (IAPDialogMain.IAPUpdater)iapupdater.clone();
        update(mData.getPackId(), mData.getIsAnimating(), mData.getExtras());
    }
}
