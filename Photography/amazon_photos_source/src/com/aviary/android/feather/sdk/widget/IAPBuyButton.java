// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.aviary.android.feather.cds.CdsUtils;

public class IAPBuyButton extends RelativeLayout
{
    private class InnerVisibility
    {

        private boolean newEnableStatus;
        private int newProgressVisibility;
        private int newTextVisibility;
        private final com.aviary.android.feather.cds.CdsUtils.PackOptionWithPrice option;
        final IAPBuyButton this$0;

        public int getNewProgressVisibility()
        {
            return newProgressVisibility;
        }

        public int getNewTextVisibility()
        {
            return newTextVisibility;
        }

        public InnerVisibility invoke()
        {
            static class _cls2
            {

                static final int $SwitchMap$com$aviary$android$feather$cds$CdsUtils$PackOption[];

                static 
                {
                    $SwitchMap$com$aviary$android$feather$cds$CdsUtils$PackOption = new int[com.aviary.android.feather.cds.CdsUtils.PackOption.values().length];
                    try
                    {
                        $SwitchMap$com$aviary$android$feather$cds$CdsUtils$PackOption[com.aviary.android.feather.cds.CdsUtils.PackOption.RESTORE.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror10) { }
                    try
                    {
                        $SwitchMap$com$aviary$android$feather$cds$CdsUtils$PackOption[com.aviary.android.feather.cds.CdsUtils.PackOption.PURCHASE.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror9) { }
                    try
                    {
                        $SwitchMap$com$aviary$android$feather$cds$CdsUtils$PackOption[com.aviary.android.feather.cds.CdsUtils.PackOption.OWNED.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror8) { }
                    try
                    {
                        $SwitchMap$com$aviary$android$feather$cds$CdsUtils$PackOption[com.aviary.android.feather.cds.CdsUtils.PackOption.UNINSTALL.ordinal()] = 4;
                    }
                    catch (NoSuchFieldError nosuchfielderror7) { }
                    try
                    {
                        $SwitchMap$com$aviary$android$feather$cds$CdsUtils$PackOption[com.aviary.android.feather.cds.CdsUtils.PackOption.ERROR.ordinal()] = 5;
                    }
                    catch (NoSuchFieldError nosuchfielderror6) { }
                    try
                    {
                        $SwitchMap$com$aviary$android$feather$cds$CdsUtils$PackOption[com.aviary.android.feather.cds.CdsUtils.PackOption.FREE.ordinal()] = 6;
                    }
                    catch (NoSuchFieldError nosuchfielderror5) { }
                    try
                    {
                        $SwitchMap$com$aviary$android$feather$cds$CdsUtils$PackOption[com.aviary.android.feather.cds.CdsUtils.PackOption.INSTALL.ordinal()] = 7;
                    }
                    catch (NoSuchFieldError nosuchfielderror4) { }
                    try
                    {
                        $SwitchMap$com$aviary$android$feather$cds$CdsUtils$PackOption[com.aviary.android.feather.cds.CdsUtils.PackOption.DOWNLOAD_COMPLETE.ordinal()] = 8;
                    }
                    catch (NoSuchFieldError nosuchfielderror3) { }
                    try
                    {
                        $SwitchMap$com$aviary$android$feather$cds$CdsUtils$PackOption[com.aviary.android.feather.cds.CdsUtils.PackOption.DOWNLOADING.ordinal()] = 9;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$com$aviary$android$feather$cds$CdsUtils$PackOption[com.aviary.android.feather.cds.CdsUtils.PackOption.PACK_OPTION_BEING_DETERMINED.ordinal()] = 10;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$aviary$android$feather$cds$CdsUtils$PackOption[com.aviary.android.feather.cds.CdsUtils.PackOption.DOWNLOAD_ERROR.ordinal()] = 11;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            _cls2..SwitchMap.com.aviary.android.feather.cds.CdsUtils.PackOption[option.option.ordinal()];
            JVM INSTR tableswitch 1 11: default 72
        //                       1 74
        //                       2 89
        //                       3 144
        //                       4 164
        //                       5 179
        //                       6 194
        //                       7 209
        //                       8 224
        //                       9 244
        //                       10 301
        //                       11 318;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12
_L1:
            return this;
_L2:
            mTextView.setText(com.aviary.android.feather.sdk.R.string.feather_iap_restore);
            return this;
_L3:
            mTextView.setVisibility(0);
            if (option.price != null)
            {
                mTextView.setText(option.price);
                return this;
            } else
            {
                mTextView.setText(com.aviary.android.feather.sdk.R.string.feather_iap_unavailable);
                return this;
            }
_L4:
            mTextView.setText(com.aviary.android.feather.sdk.R.string.feather_iap_owned);
            newEnableStatus = false;
            return this;
_L5:
            mTextView.setText(com.aviary.android.feather.sdk.R.string.feather_iap_uninstall);
            return this;
_L6:
            mTextView.setText(com.aviary.android.feather.sdk.R.string.feather_iap_retry);
            return this;
_L7:
            mTextView.setText(com.aviary.android.feather.sdk.R.string.feather_download);
            return this;
_L8:
            mTextView.setText(com.aviary.android.feather.sdk.R.string.feather_iap_install);
            return this;
_L9:
            mTextView.setText(com.aviary.android.feather.sdk.R.string.feather_iap_installing);
            newEnableStatus = false;
            return this;
_L10:
            newProgressVisibility = 0;
            newTextVisibility = 4;
            newEnableStatus = false;
            if (getHandler() != null)
            {
                getHandler().postDelayed(checkDownloadStatus, (long)(Math.random() * 100D + 900D));
                return this;
            }
              goto _L1
_L11:
            newProgressVisibility = 0;
            newTextVisibility = 4;
            newEnableStatus = false;
            return this;
_L12:
            mTextView.setText(com.aviary.android.feather.sdk.R.string.feather_iap_retry);
            return this;
        }

        public boolean isNewEnableStatus()
        {
            return newEnableStatus;
        }




        public InnerVisibility(com.aviary.android.feather.cds.CdsUtils.PackOptionWithPrice packoptionwithprice, boolean flag, int i, int j)
        {
            this$0 = IAPBuyButton.this;
            super();
            option = packoptionwithprice;
            newEnableStatus = flag;
            newProgressVisibility = i;
            newTextVisibility = j;
        }
    }


    Runnable checkDownloadStatus;
    com.aviary.android.feather.cds.CdsUtils.PackOptionWithPrice mOption;
    long mPackId;
    View mProgress;
    TextView mTextView;

    public IAPBuyButton(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        checkDownloadStatus = new Runnable() {

            final IAPBuyButton this$0;

            public void run()
            {
                if (mPackId > -1L && getContext() != null && mOption != null)
                {
                    Pair pair = CdsUtils.getPackOptionDownloadStatus(getContext(), mPackId);
                    if (pair != null && getContext() != null)
                    {
                        setPackOption(new com.aviary.android.feather.cds.CdsUtils.PackOptionWithPrice((com.aviary.android.feather.cds.CdsUtils.PackOption)pair.first), mPackId);
                    }
                }
            }

            
            {
                this$0 = IAPBuyButton.this;
                super();
            }
        };
    }

    public long getPackId()
    {
        return mPackId;
    }

    public com.aviary.android.feather.cds.CdsUtils.PackOptionWithPrice getPackOption()
    {
        return mOption;
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        getHandler().removeCallbacks(checkDownloadStatus);
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        mTextView = (TextView)findViewById(com.aviary.android.feather.sdk.R.id.aviary_buy_button_text);
        mProgress = findViewById(com.aviary.android.feather.sdk.R.id.aviary_buy_button_loader);
    }

    public void setPackOption(com.aviary.android.feather.cds.CdsUtils.PackOptionWithPrice packoptionwithprice, long l)
    {
        if (packoptionwithprice == null || !packoptionwithprice.equals(mOption))
        {
            mOption = packoptionwithprice;
            mPackId = l;
            if (getHandler() != null)
            {
                getHandler().removeCallbacks(checkDownloadStatus);
            }
            if (packoptionwithprice != null)
            {
                boolean flag = isEnabled();
                int i = mProgress.getVisibility();
                int j = mTextView.getVisibility();
                packoptionwithprice = (new InnerVisibility(packoptionwithprice, true, 4, 0)).invoke();
                if (flag != packoptionwithprice.isNewEnableStatus())
                {
                    setEnabled(((InnerVisibility) (packoptionwithprice)).newEnableStatus);
                }
                if (i != ((InnerVisibility) (packoptionwithprice)).newProgressVisibility)
                {
                    mProgress.setVisibility(((InnerVisibility) (packoptionwithprice)).newProgressVisibility);
                }
                if (j != ((InnerVisibility) (packoptionwithprice)).newTextVisibility)
                {
                    mTextView.setVisibility(((InnerVisibility) (packoptionwithprice)).newTextVisibility);
                    return;
                }
            }
        }
    }
}
