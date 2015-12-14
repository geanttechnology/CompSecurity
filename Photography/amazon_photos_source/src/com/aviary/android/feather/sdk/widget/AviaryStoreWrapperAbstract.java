// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.widget.Toast;
import com.aviary.android.feather.cds.CdsUtils;
import com.aviary.android.feather.cds.IAPInstance;
import com.aviary.android.feather.cds.billing.util.IabResult;
import com.aviary.android.feather.cds.billing.util.Inventory;
import com.aviary.android.feather.cds.billing.util.Purchase;
import com.aviary.android.feather.cds.billing.util.SkuDetails;
import com.aviary.android.feather.common.log.LoggerFactory;
import com.aviary.android.feather.common.tracking.AviaryTracker;
import com.aviary.android.feather.common.utils.PackageManagerUtils;
import com.aviary.android.feather.receipt.ReceiptManager;
import java.io.IOException;
import junit.framework.Assert;

public abstract class AviaryStoreWrapperAbstract
{
    public static interface Callback
    {

        public abstract void onDownloadStatusChanged(long l, String s, int i);

        public abstract void onPackInstalled(long l, String s, int i);

        public abstract void onPurchaseSuccess(long l, String s, Purchase purchase1);

        public abstract void onServiceFinished();

        public abstract void onSubscriptionPurchased(String s, int i);
    }


    protected static com.aviary.android.feather.common.log.LoggerFactory.Logger logger = LoggerFactory.getLogger("AviaryStoreWrapper");
    private Callback callback;
    protected Activity context;
    final BroadcastReceiver downloadStatusReceiver = new BroadcastReceiver() {

        final AviaryStoreWrapperAbstract this$0;

        public void onReceive(Context context1, Intent intent)
        {
            AviaryStoreWrapperAbstract.logger.info("downloadStatusReceiver::onReceive: %s", new Object[] {
                intent
            });
            if (intent != null && isActive())
            {
                context1 = intent.getStringExtra("packType");
                long l = intent.getLongExtra("packId", -1L);
                int j = intent.getIntExtra("status", -1);
                callback.onDownloadStatusChanged(l, context1, j);
            }
        }

            
            {
                this$0 = AviaryStoreWrapperAbstract.this;
                super();
            }
    };
    final ContentObserver mServiceFinishedContentObserver = new ContentObserver(new Handler()) {

        final AviaryStoreWrapperAbstract this$0;

        public void onChange(boolean flag)
        {
            onChange(flag, null);
        }

        public void onChange(boolean flag, Uri uri)
        {
            AviaryStoreWrapperAbstract.logger.info("mServiceFinishedContentObserver::onChange");
            if (isActive())
            {
                callback.onServiceFinished();
            }
        }

            
            {
                this$0 = AviaryStoreWrapperAbstract.this;
                super(handler);
            }
    };
    final BroadcastReceiver packInstalledReceiver = new BroadcastReceiver() {

        final AviaryStoreWrapperAbstract this$0;

        public void onReceive(Context context1, Intent intent)
        {
            AviaryStoreWrapperAbstract.logger.info("packInstalledReceiver::onReceive: %s", new Object[] {
                intent
            });
            if (intent != null && isActive())
            {
                context1 = intent.getStringExtra("packType");
                long l = intent.getLongExtra("packId", -1L);
                int j = intent.getIntExtra("purchased", 0);
                callback.onPackInstalled(l, context1, j);
            }
        }

            
            {
                this$0 = AviaryStoreWrapperAbstract.this;
                super();
            }
    };
    final BroadcastReceiver packPurchasedReceiver = new BroadcastReceiver() {

        final AviaryStoreWrapperAbstract this$0;

        public void onReceive(Context context1, Intent intent)
        {
            AviaryStoreWrapperAbstract.logger.info("packPurchasedReceiver::onReceive: %s", new Object[] {
                intent
            });
            if (intent != null && isActive())
            {
                context1 = intent.getStringExtra("packType");
                long l = intent.getLongExtra("packId", -1L);
                intent = (Purchase)intent.getParcelableExtra("purchase");
                callback.onPurchaseSuccess(l, context1, intent);
            }
        }

            
            {
                this$0 = AviaryStoreWrapperAbstract.this;
                super();
            }
    };
    protected int purchaseRequestCode;
    final BroadcastReceiver subscriptionPurchasedReceiver = new BroadcastReceiver() {

        final AviaryStoreWrapperAbstract this$0;

        public void onReceive(Context context1, Intent intent)
        {
            AviaryStoreWrapperAbstract.logger.info("subscriptionPurchasedReceiver::onReceive: %s", new Object[] {
                intent
            });
            if (intent != null && isActive())
            {
                int j = intent.getIntExtra("purchased", 0);
                context1 = intent.getStringExtra("identifier");
                callback.onSubscriptionPurchased(context1, j);
            }
        }

            
            {
                this$0 = AviaryStoreWrapperAbstract.this;
                super();
            }
    };
    protected AviaryTracker tracker;
    protected IAPInstance wrapper;

    public AviaryStoreWrapperAbstract(Callback callback1, int i)
    {
        purchaseRequestCode = -1;
        callback = callback1;
        purchaseRequestCode = i;
    }

    private void onPurchaseSuccess(Purchase purchase1, long l, String s, String s1, String s2)
    {
        logger.info("onPurchaseSuccess: %s - %s (%s)", new Object[] {
            s, s1, purchase1
        });
        if (isActive()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        byte byte0;
        byte0 = -1;
        sendReceipt(purchase1, s2);
        boolean flag = requestPackDownload(l, true);
        if (!flag)
        {
            byte0 = 16;
        }
_L4:
        CdsUtils.notifyPackPurchased(context, l, s1, purchase1);
        if (byte0 > -1)
        {
            callback.onDownloadStatusChanged(l, s1, byte0);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        s;
        byte0 = 16;
        s2 = new StringBuilder();
        s2.append(context.getString(com.aviary.android.feather.sdk.R.string.feather_download_start_failed));
        s2.append(".");
        s2.append("\n");
        s2.append("Cause: ");
        s2.append(s.getLocalizedMessage());
        (new android.app.AlertDialog.Builder(context)).setTitle(com.aviary.android.feather.sdk.R.string.feather_iap_download_failed).setMessage(s2.toString()).setPositiveButton(0x1040000, null).create().show();
          goto _L4
    }

    protected abstract IAPInstance createWrapper(Activity activity, String s);

    public IAPInstance getIAPInstance()
    {
        return wrapper;
    }

    public com.aviary.android.feather.cds.CdsUtils.PackOptionWithPrice getPackOptionFromInventory(String s, Inventory inventory)
    {
        if (inventory != null)
        {
            if (inventory.getPurchase(s) != null)
            {
                return new com.aviary.android.feather.cds.CdsUtils.PackOptionWithPrice(com.aviary.android.feather.cds.CdsUtils.PackOption.RESTORE);
            }
            s = inventory.getSkuDetails(s);
            if (s != null)
            {
                return new com.aviary.android.feather.cds.CdsUtils.PackOptionWithPrice(com.aviary.android.feather.cds.CdsUtils.PackOption.PURCHASE, s.getPrice());
            }
        }
        return new com.aviary.android.feather.cds.CdsUtils.PackOptionWithPrice(com.aviary.android.feather.cds.CdsUtils.PackOption.ERROR);
    }

    public boolean isActive()
    {
        return callback != null && context != null;
    }

    public boolean isAvailable()
    {
        return wrapper.isAvailable();
    }

    public boolean isSetupDone()
    {
        return wrapper.isSetupDone();
    }

    protected abstract void launchPurchaseFlow(String s, com.aviary.android.feather.cds.billing.util.IabHelper.OnIabPurchaseFinishedListener oniabpurchasefinishedlistener, String s1);

    public void onAttach(Activity activity, String s)
    {
        logger.info("onAttach");
        context = activity;
        tracker = AviaryTracker.getInstance(context);
        wrapper = createWrapper(activity, s);
    }

    public void onDetach()
    {
        logger.info("onDetach");
        if (context != null)
        {
            context = null;
            tracker = null;
            callback = null;
        }
    }

    public void purchase(long l, String s, String s1, String s2, String s3)
    {
        purchase(l, s, s1, s2, s3, -1);
    }

    public void purchase(final long packid, final String identifier, final String packType, final String whereFrom, final String price, final int clickFromPosition)
    {
        logger.info("purchase {%d, %s, %s, %s, %s}", new Object[] {
            Long.valueOf(packid), identifier, packType, whereFrom, price
        });
        if (!isActive())
        {
            return;
        }
        if (!wrapper.isSetupDone())
        {
            Toast.makeText(context, "There was a problem connecting to the billing service. Please try again.", 0).show();
            wrapper.startSetup(null);
            return;
        }
        packType = new com.aviary.android.feather.cds.billing.util.IabHelper.OnIabPurchaseFinishedListener() {

            final AviaryStoreWrapperAbstract this$0;
            final int val$clickFromPosition;
            final String val$identifier;
            final String val$packType;
            final long val$packid;
            final String val$price;
            final String val$whereFrom;

            public void onIabPurchaseFinished(IabResult iabresult, Purchase purchase1)
            {
                AviaryStoreWrapperAbstract.logger.log("onIabPurchaseFinished: { result: %s, purchase: %s }", new Object[] {
                    iabresult, purchase1
                });
                if (!isActive())
                {
                    AviaryStoreWrapperAbstract.logger.error("context is no more valid");
                    return;
                }
                if (iabresult.isFailure())
                {
                    switch (iabresult.getResponse())
                    {
                    default:
                        Toast.makeText(context, iabresult.getMessage(), 0).show();
                        break;

                    case -1005: 
                        break;
                    }
                } else
                {
                    onPurchaseSuccess(purchase1, packid, identifier, packType, price);
                }
                tracker.trackEndPurchaseFlow(identifier, whereFrom, iabresult.isSuccess(), clickFromPosition);
            }

            
            {
                this$0 = AviaryStoreWrapperAbstract.this;
                packid = l;
                identifier = s;
                packType = s1;
                price = s2;
                whereFrom = s3;
                clickFromPosition = i;
                super();
            }
        };
        if (wrapper != null && wrapper.isAvailable())
        {
            launchPurchaseFlow(identifier, packType, null);
            tracker.trackBeginPurchaseFlow(identifier, whereFrom);
            return;
        } else
        {
            logger.error("wrapper disposed or null");
            Toast.makeText(context, com.aviary.android.feather.sdk.R.string.feather_store_connection_problem, 0).show();
            return;
        }
    }

    public void registerReceivers()
    {
        logger.info("registerReceivers");
        if (context != null)
        {
            context.registerReceiver(packPurchasedReceiver, new IntentFilter((new StringBuilder()).append(context.getPackageName()).append(".cds.packPurchased").toString()));
            context.registerReceiver(packInstalledReceiver, new IntentFilter((new StringBuilder()).append(context.getPackageName()).append(".cds.packInstalled").toString()));
            context.registerReceiver(downloadStatusReceiver, new IntentFilter((new StringBuilder()).append(context.getPackageName()).append(".cds.downloadStatusChanged").toString()));
            context.registerReceiver(subscriptionPurchasedReceiver, new IntentFilter((new StringBuilder()).append(context.getPackageName()).append(".cds.subscriptionPurchased").toString()));
            context.getContentResolver().registerContentObserver(PackageManagerUtils.getCDSProviderContentUri(context, "service/finished"), false, mServiceFinishedContentObserver);
        }
    }

    boolean requestPackDownload(long l, boolean flag)
        throws AssertionError, IOException
    {
        logger.info("requestPackDownload { packId: %d, notify: %b }", new Object[] {
            Long.valueOf(l), Boolean.valueOf(flag)
        });
        if (!isActive())
        {
            return false;
        }
        Object obj = PackageManagerUtils.getCDSProviderContentUri(context, (new StringBuilder()).append("pack/id/").append(l).append("/requestDownload/1").toString());
        logger.log((new StringBuilder()).append("updating: ").append(obj).toString());
        int i = context.getContentResolver().update(((Uri) (obj)), new ContentValues(), null, null);
        logger.log((new StringBuilder()).append("result: ").append(i).toString());
        boolean flag1;
        if (i != 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        Assert.assertTrue("Failed to update the database, please try again later", flag1);
        obj = CdsUtils.requestPackDownload(context, l, flag);
        logger.log("requestResult: %s", new Object[] {
            obj
        });
        return true;
    }

    public void restore(long l, String s, String s1, String s2, boolean flag, boolean flag1, 
            boolean flag2, boolean flag3)
    {
        logger.info("restore {%d, %s, %s, %s, restore: %b, free: %b, error: %b, subscription: %s}", new Object[] {
            Long.valueOf(l), s, s1, s2, Boolean.valueOf(flag), Boolean.valueOf(flag1), Boolean.valueOf(flag2), Boolean.valueOf(flag3)
        });
        if (isActive()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        byte byte0;
        if (!flag2)
        {
            if (flag1)
            {
                tracker.trackContentInstalled(s, s2);
            } else
            {
                tracker.trackContentRestored(s, s2);
            }
            sendReceipt(s, flag1, flag, flag3);
        }
        byte0 = -1;
        flag = requestPackDownload(l, true);
        if (!flag)
        {
            byte0 = 16;
        }
_L4:
        if (byte0 > -1)
        {
            callback.onDownloadStatusChanged(l, s1, byte0);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        s;
        s.printStackTrace();
        byte0 = 16;
        s2 = new StringBuilder();
        s2.append(context.getString(com.aviary.android.feather.sdk.R.string.feather_download_start_failed));
        s2.append(".");
        s2.append("\n");
        s2.append("Cause: ");
        s2.append(s.getLocalizedMessage());
        (new android.app.AlertDialog.Builder(context)).setTitle(com.aviary.android.feather.sdk.R.string.feather_iap_download_failed).setMessage(s2.toString()).setPositiveButton(0x1040000, null).create().show();
          goto _L4
    }

    void sendReceipt(Purchase purchase1, String s)
    {
        if (context == null)
        {
            return;
        }
        logger.info("sendReceipt{ item: %s, price: %s }", new Object[] {
            purchase1, s
        });
        purchase1 = (new com.aviary.android.feather.receipt.Receipt.Builder(false)).withProductId(purchase1.getSku()).withPurchaseTime(purchase1.getPurchaseTime()).withOrderId(purchase1.getOrderId()).withPrice(s).isNewPurchase(true).withToken(purchase1.getToken());
        try
        {
            purchase1 = purchase1.build();
            ReceiptManager.getInstance(context).sendTicket(purchase1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Purchase purchase1)
        {
            purchase1.printStackTrace();
        }
    }

    void sendReceipt(String s, boolean flag, boolean flag1, boolean flag2)
    {
        boolean flag3 = true;
        if (context == null)
        {
            return;
        }
        logger.info("sendReceipt{ identifier: %s, isFree: %b, isRestore: %b, isSubscription: %b }", new Object[] {
            s, Boolean.valueOf(flag), Boolean.valueOf(flag1), Boolean.valueOf(flag2)
        });
        s = (new com.aviary.android.feather.receipt.Receipt.Builder(flag)).withProductId(s);
        if (!flag1)
        {
            flag = flag3;
        } else
        {
            flag = false;
        }
        s = s.isNewPurchase(flag).withPurchaseTime(System.currentTimeMillis());
        if (flag2)
        {
            s.withOrderId("subscription");
            s.withToken("");
            s.withPrice("");
        }
        try
        {
            s = s.build();
            ReceiptManager.getInstance(context).sendTicket(s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
    }

    public void startSetup(boolean flag, com.aviary.android.feather.cds.billing.util.IabHelper.OnIabSetupFinishedListener oniabsetupfinishedlistener)
    {
        if (isActive())
        {
            logger.info("startSetup: %b", new Object[] {
                Boolean.valueOf(flag)
            });
            if (!wrapper.isSetupDone() || flag)
            {
                wrapper.startSetup(oniabsetupfinishedlistener);
                return;
            }
        }
    }

    public void unregisterReceivers()
    {
        logger.info("unregisterReceivers");
        if (context != null)
        {
            context.unregisterReceiver(packPurchasedReceiver);
            context.unregisterReceiver(packInstalledReceiver);
            context.unregisterReceiver(downloadStatusReceiver);
            context.unregisterReceiver(subscriptionPurchasedReceiver);
            context.getContentResolver().unregisterContentObserver(mServiceFinishedContentObserver);
        }
    }



}
