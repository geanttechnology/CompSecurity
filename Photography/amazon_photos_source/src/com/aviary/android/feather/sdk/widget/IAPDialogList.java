// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.MergeCursor;
import android.database.sqlite.SQLiteException;
import android.os.Handler;
import android.support.v4.widget.CursorAdapter;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.aviary.android.feather.cds.CdsUtils;
import com.aviary.android.feather.cds.IAPInstance;
import com.aviary.android.feather.cds.RestoreAllHelper;
import com.aviary.android.feather.cds.billing.util.IabException;
import com.aviary.android.feather.cds.billing.util.IabResult;
import com.aviary.android.feather.cds.billing.util.Inventory;
import com.aviary.android.feather.cds.billing.util.Purchase;
import com.aviary.android.feather.cds.billing.util.SkuDetails;
import com.aviary.android.feather.common.AviaryIntent;
import com.aviary.android.feather.common.log.LoggerFactory;
import com.aviary.android.feather.common.tracking.AviaryTracker;
import com.aviary.android.feather.common.utils.ApiHelper;
import com.aviary.android.feather.common.utils.PackageManagerUtils;
import com.aviary.android.feather.common.utils.os.AviaryAsyncTask;
import com.aviary.android.feather.library.services.LocalDataService;
import com.aviary.android.feather.sdk.AviaryMainController;
import com.aviary.android.feather.sdk.FeatherActivity;
import com.aviary.android.feather.sdk.utils.CdsUIUtils;
import com.nhaarman.listviewanimations.appearance.AnimationAdapter;
import com.nhaarman.listviewanimations.appearance.simple.AlphaInAnimationAdapter;
import it.sephiroth.android.library.picasso.Callback;
import it.sephiroth.android.library.picasso.Picasso;
import it.sephiroth.android.library.picasso.RequestCreator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            IAPDialogMain, IAPBuyButton, AviaryStoreWrapper

public class IAPDialogList extends LinearLayout
    implements android.view.View.OnClickListener, android.widget.AdapterView.OnItemClickListener, com.aviary.android.feather.cds.billing.util.IabHelper.OnIabSetupFinishedListener
{
    private class MyCursorAdapter extends CursorAdapter
    {

        static final int TYPE_ITEM = 0;
        static final int TYPE_LOADER = 1;
        int displayNameColumnIndex;
        int iconPackColumnIndex;
        int idColumnIndex;
        int identifierColumnIndex;
        int itemsCountColumnIndex;
        int mMaxImageSize;
        final IAPDialogList this$0;

        public void bindView(View view, Context context, Cursor cursor)
        {
            final ViewHolder holder;
            int i;
            i = getItemViewType(cursor.getPosition());
            holder = (ViewHolder)view.getTag();
            if (holder != null) goto _L2; else goto _L1
_L1:
            return;
_L2:
            if (i != 0) goto _L4; else goto _L3
_L3:
            long l = cursor.getLong(idColumnIndex);
            view = cursor.getString(displayNameColumnIndex);
            context = cursor.getString(iconPackColumnIndex);
            String s = cursor.getString(identifierColumnIndex);
            int j = cursor.getInt(itemsCountColumnIndex);
            boolean flag1 = true;
            if (context != null)
            {
                cursor = ((Cursor) (holder.icon.getTag()));
                int k = context.hashCode();
                boolean flag = flag1;
                if (cursor instanceof Integer)
                {
                    flag = flag1;
                    if (((Integer)cursor).intValue() == k)
                    {
                        flag = false;
                    }
                }
                if (flag)
                {
                    mPicasso.cancelRequest(holder.icon);
                    mPicasso.load(context).resize(mMaxImageSize, mMaxImageSize, true).noFade().transform((new com.aviary.android.feather.sdk.utils.PackIconCallable.Builder()).withResources(getResources()).withPath(context).withPackType(mData.getPackType()).noBackground().roundedCorners().build()).into(holder.icon, context. new Callback() {

                        final MyCursorAdapter this$1;
                        final MyCursorAdapter.ViewHolder val$holder;
                        final String val$iconPath;

                        public void onError()
                        {
                            holder.icon.setTag(null);
                        }

                        public void onSuccess()
                        {
                            holder.icon.setTag(Integer.valueOf(iconPath.hashCode()));
                        }

            
            {
                this$1 = final_mycursoradapter;
                holder = viewholder;
                iconPath = String.this;
                super();
            }
                    });
                    holder.title.setText(view);
                    holder.setItemCount(j, mData.getPackType());
                }
            } else
            {
                holder.icon.setImageBitmap(null);
                holder.icon.setTag(null);
            }
            holder.packid = l;
            holder.identifier = s;
            if (mParent == null || mParent.getStoreWrapper() == null) goto _L1; else goto _L5
_L5:
            context = null;
            cursor = (com.aviary.android.feather.cds.CdsUtils.PackOption)mParent.mDownloadMap.get(Long.valueOf(holder.packid));
            view = cursor;
            if (cursor == null)
            {
                view = cursor;
                if (mParent.mCacheMap.containsKey(Long.valueOf(holder.packid)))
                {
                    view = (com.aviary.android.feather.cds.CdsUtils.PackOption)mParent.mCacheMap.get(Long.valueOf(holder.packid));
                }
            }
            if (view != null) goto _L7; else goto _L6
_L6:
            view = context;
            if (mParent.mInventory == null) goto _L9; else goto _L8
_L8:
            if (!mParent.mInventory.hasPurchase(holder.identifier)) goto _L11; else goto _L10
_L10:
            view = new com.aviary.android.feather.cds.CdsUtils.PackOptionWithPrice(com.aviary.android.feather.cds.CdsUtils.PackOption.RESTORE);
_L9:
            context = view;
            if (view == null)
            {
                IAPDialogList.logger.error("%d, option is null", new Object[] {
                    Long.valueOf(holder.packid)
                });
                context = new com.aviary.android.feather.cds.CdsUtils.PackOptionWithPrice(com.aviary.android.feather.cds.CdsUtils.PackOption.ERROR);
            }
            holder.buttonContainer.setPackOption(context, holder.packid);
            return;
_L11:
            view = context;
            if (mParent.mInventory.hasDetails(holder.identifier))
            {
                view = mParent.mInventory.getSkuDetails(holder.identifier);
                view = new com.aviary.android.feather.cds.CdsUtils.PackOptionWithPrice(com.aviary.android.feather.cds.CdsUtils.PackOption.PURCHASE, view.getPrice());
            }
            continue; /* Loop/switch isn't completed */
_L7:
            view = new com.aviary.android.feather.cds.CdsUtils.PackOptionWithPrice(view);
            if (true) goto _L9; else goto _L4
_L4:
            holder.title.setText(com.aviary.android.feather.sdk.R.string.feather_store_checking_additional_packs);
            return;
        }

        public int getItemViewType(int i)
        {
            return getItemId(i) <= -1L ? 1 : 0;
        }

        public int getViewTypeCount()
        {
            return 2;
        }

        protected void initCursor(Cursor cursor)
        {
            if (cursor != null)
            {
                idColumnIndex = cursor.getColumnIndex("pack_id");
                displayNameColumnIndex = cursor.getColumnIndex("content_displayName");
                iconPackColumnIndex = cursor.getColumnIndex("content_iconPath");
                identifierColumnIndex = cursor.getColumnIndex("pack_identifier");
                itemsCountColumnIndex = cursor.getColumnIndex("content_numItems");
            }
        }

        public View newView(Context context, Cursor cursor, ViewGroup viewgroup)
        {
            int i = getItemViewType(cursor.getPosition());
            cursor = new ViewHolder();
            if (i == 0)
            {
                context = LayoutInflater.from(context).inflate(com.aviary.android.feather.sdk.R.layout.aviary_iap_list_item, viewgroup, false);
                viewgroup = (IAPBuyButton)context.findViewById(com.aviary.android.feather.sdk.R.id.aviary_buy_button);
                TextView textview = (TextView)context.findViewById(com.aviary.android.feather.sdk.R.id.aviary_title);
                TextView textview1 = (TextView)context.findViewById(com.aviary.android.feather.sdk.R.id.aviary_text);
                ImageView imageview = (ImageView)context.findViewById(com.aviary.android.feather.sdk.R.id.aviary_image);
                cursor.title = textview;
                cursor.text = textview1;
                cursor.icon = imageview;
                cursor.buttonContainer = viewgroup;
                ((ViewHolder) (cursor)).buttonContainer.setOnClickListener(IAPDialogList.this);
            } else
            {
                context = LayoutInflater.from(context).inflate(0x1090003, viewgroup, false);
                cursor.title = (TextView)context.findViewById(0x1020014);
            }
            context.setTag(cursor);
            return context;
        }

        public Cursor swapCursor(Cursor cursor)
        {
            initCursor(cursor);
            return super.swapCursor(cursor);
        }

        public MyCursorAdapter(Context context, Cursor cursor)
        {
            this$0 = IAPDialogList.this;
            super(context, cursor, false);
            mMaxImageSize = context.getResources().getDimensionPixelSize(com.aviary.android.feather.sdk.R.dimen.aviary_store_list_icon_size);
            initCursor(cursor);
        }
    }

    class MyCursorAdapter.ViewHolder
    {

        IAPBuyButton buttonContainer;
        ImageView icon;
        String identifier;
        int itemsCount;
        com.aviary.android.feather.cds.AviaryCds.PackType packType;
        long packid;
        TextView text;
        final MyCursorAdapter this$1;
        TextView title;

        public void setItemCount(int i, com.aviary.android.feather.cds.AviaryCds.PackType packtype)
        {
            packType = packtype;
            itemsCount = i;
            updateText();
        }

        public void updateText()
        {
            StringBuilder stringbuilder = new StringBuilder();
            String s = CdsUIUtils.getPackTypeString(getContext(), packType);
            if (itemsCount > 0)
            {
                stringbuilder.append((new StringBuilder()).append(itemsCount).append(" ").append(s).toString());
            } else
            {
                stringbuilder.append("");
            }
            text.setText(stringbuilder.toString());
        }

        MyCursorAdapter.ViewHolder()
        {
            this$1 = MyCursorAdapter.this;
            super();
            itemsCount = 0;
        }
    }

    static interface OnPackSelectedListener
    {

        public abstract void onPackSelected(long l, com.aviary.android.feather.cds.AviaryCds.PackType packtype, String s);
    }

    class QueryInventoryAsyncTask extends AviaryAsyncTask
    {

        Cursor cursor1;
        Cursor cursor2;
        int error;
        Cursor finalCursor;
        Inventory inventory;
        List ownedPacks;
        com.aviary.android.feather.cds.AviaryCds.PackType packType;
        final IAPDialogList this$0;

        private void removeFromCursor(List list, Cursor cursor)
        {
            IAPDialogList.logger.info("removeFromCursor");
            do
            {
                if (!cursor.moveToNext())
                {
                    break;
                }
                com.aviary.android.feather.cds.PacksColumns.PackCursorWrapper packcursorwrapper = com.aviary.android.feather.cds.PacksColumns.PackCursorWrapper.create(cursor);
                if (list.contains(packcursorwrapper.getIdentifier()))
                {
                    list.remove(packcursorwrapper.getIdentifier());
                }
            } while (true);
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((com.aviary.android.feather.cds.AviaryCds.PackType[])aobj);
        }

        protected transient HashMap doInBackground(com.aviary.android.feather.cds.AviaryCds.PackType apacktype[])
        {
            Object obj;
            IabResult iabresult;
            HashMap hashmap;
            IAPDialogList.logger.info("QueryInventoryAsyncTask::doInBackground");
            hashmap = new HashMap();
            packType = apacktype[0];
            obj = mParent.getStoreWrapper();
            iabresult = ((AviaryStoreWrapper) (obj)).getIAPInstance().getResult();
            if (mParent != null && isValidContext()) goto _L2; else goto _L1
_L1:
            return hashmap;
_L2:
            static class _cls4
            {

                static final int $SwitchMap$com$aviary$android$feather$cds$CdsUtils$PackOption[];

                static 
                {
                    $SwitchMap$com$aviary$android$feather$cds$CdsUtils$PackOption = new int[com.aviary.android.feather.cds.CdsUtils.PackOption.values().length];
                    try
                    {
                        $SwitchMap$com$aviary$android$feather$cds$CdsUtils$PackOption[com.aviary.android.feather.cds.CdsUtils.PackOption.PURCHASE.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror10) { }
                    try
                    {
                        $SwitchMap$com$aviary$android$feather$cds$CdsUtils$PackOption[com.aviary.android.feather.cds.CdsUtils.PackOption.UNINSTALL.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror9) { }
                    try
                    {
                        $SwitchMap$com$aviary$android$feather$cds$CdsUtils$PackOption[com.aviary.android.feather.cds.CdsUtils.PackOption.FREE.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror8) { }
                    try
                    {
                        $SwitchMap$com$aviary$android$feather$cds$CdsUtils$PackOption[com.aviary.android.feather.cds.CdsUtils.PackOption.RESTORE.ordinal()] = 4;
                    }
                    catch (NoSuchFieldError nosuchfielderror7) { }
                    try
                    {
                        $SwitchMap$com$aviary$android$feather$cds$CdsUtils$PackOption[com.aviary.android.feather.cds.CdsUtils.PackOption.INSTALL.ordinal()] = 5;
                    }
                    catch (NoSuchFieldError nosuchfielderror6) { }
                    try
                    {
                        $SwitchMap$com$aviary$android$feather$cds$CdsUtils$PackOption[com.aviary.android.feather.cds.CdsUtils.PackOption.DOWNLOAD_ERROR.ordinal()] = 6;
                    }
                    catch (NoSuchFieldError nosuchfielderror5) { }
                    try
                    {
                        $SwitchMap$com$aviary$android$feather$cds$CdsUtils$PackOption[com.aviary.android.feather.cds.CdsUtils.PackOption.ERROR.ordinal()] = 7;
                    }
                    catch (NoSuchFieldError nosuchfielderror4) { }
                    try
                    {
                        $SwitchMap$com$aviary$android$feather$cds$CdsUtils$PackOption[com.aviary.android.feather.cds.CdsUtils.PackOption.OWNED.ordinal()] = 8;
                    }
                    catch (NoSuchFieldError nosuchfielderror3) { }
                    try
                    {
                        $SwitchMap$com$aviary$android$feather$cds$CdsUtils$PackOption[com.aviary.android.feather.cds.CdsUtils.PackOption.PACK_OPTION_BEING_DETERMINED.ordinal()] = 9;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$com$aviary$android$feather$cds$CdsUtils$PackOption[com.aviary.android.feather.cds.CdsUtils.PackOption.DOWNLOADING.ordinal()] = 10;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$aviary$android$feather$cds$CdsUtils$PackOption[com.aviary.android.feather.cds.CdsUtils.PackOption.DOWNLOAD_COMPLETE.ordinal()] = 11;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            try
            {
                cursor1 = createCursorForAvailablePacks(packType);
            }
            catch (SQLiteException sqliteexception)
            {
                sqliteexception.printStackTrace();
            }
            if (cursor1 == null || iabresult == null || !iabresult.isSuccess() || inventory != null)
            {
                break MISSING_BLOCK_LABEL_137;
            }
            inventory = getInventory(cursor1, ((AviaryStoreWrapper) (obj)).getIAPInstance());
            cursor1.moveToPosition(-1);
_L3:
            if (mParent != null && isValidContext())
            {
                iabresult = null;
                obj = iabresult;
                if (inventory != null)
                {
                    ownedPacks = getPurchasedPacksByType(inventory, apacktype[0]);
                    obj = iabresult;
                    if (ownedPacks != null)
                    {
                        obj = (new StringBuilder()).append("pack_identifier IN (").append(CdsUtils.toSQLArray(ownedPacks)).append(")").toString();
                    }
                }
                if (obj != null)
                {
                    try
                    {
                        cursor2 = createCursorForHiddenPacks(apacktype[0], ((String) (obj)));
                    }
                    // Misplaced declaration of an exception variable
                    catch (com.aviary.android.feather.cds.AviaryCds.PackType apacktype[])
                    {
                        apacktype.printStackTrace();
                    }
                }
                if (cursor1 != null)
                {
                    Exception exception;
                    if (cursor2 != null)
                    {
                        finalCursor = new MergeCursor(new Cursor[] {
                            cursor1, cursor2
                        });
                    } else
                    {
                        finalCursor = cursor1;
                    }
                    IAPDialogList.logger.log("final cursor size: %d", new Object[] {
                        Integer.valueOf(finalCursor.getCount())
                    });
                    while (finalCursor.moveToNext()) 
                    {
                        apacktype = com.aviary.android.feather.cds.PacksColumns.PackCursorWrapper.create(finalCursor);
                        apacktype.setContent(com.aviary.android.feather.cds.PacksContentColumns.ContentCursorWrapper.create(finalCursor));
                        obj = CdsUtils.getPackOption(getContext(), apacktype);
                        IAPDialogList.logger.log("result: %s", new Object[] {
                            obj
                        });
                        switch (_cls4..SwitchMap.com.aviary.android.feather.cds.CdsUtils.PackOption[((com.aviary.android.feather.cds.CdsUtils.PackOption) (obj)).ordinal()])
                        {
                        default:
                            IAPDialogList.logger.verbose("option: %s, identifier: %s", new Object[] {
                                obj, apacktype.getIdentifier()
                            });
                            hashmap.put(Long.valueOf(apacktype.getId()), obj);
                            break;

                        case 9: // '\t'
                            break;
                        }
                    }
                }
            }
            continue; /* Loop/switch isn't completed */
            exception;
            exception.printStackTrace();
            cursor1.moveToPosition(-1);
              goto _L3
            apacktype;
            cursor1.moveToPosition(-1);
            throw apacktype;
            if (true) goto _L1; else goto _L4
_L4:
        }

        protected volatile void doPostExecute(Object obj)
        {
            doPostExecute((HashMap)obj);
        }

        protected void doPostExecute(HashMap hashmap)
        {
            IAPDialogList.logger.info("QueryInventoryAsyncTask::doPostExecute");
            IAPDialogList.logger.log("result: %s", new Object[] {
                hashmap
            });
            if (!isValidContext() || mParent == null)
            {
                return;
            }
            Context context = getContext();
            Object obj = mParent.getStoreWrapper().getIAPInstance().getResult();
            byte byte0;
            if (obj != null && ((IabResult) (obj)).isFailure())
            {
                IAPDialogList.logger.warn(((IabResult) (obj)).getMessage());
                String s;
                if (((IabResult) (obj)).getResponse() != -1011)
                {
                    if (!"amazon".equals("production"))
                    {
                        Toast.makeText(context, ((IabResult) (obj)).getMessage(), 0).show();
                    } else
                    {
                        IAPDialogList.logger.warn("failure: %s", new Object[] {
                            ((IabResult) (obj)).getMessage()
                        });
                    }
                }
            }
            if (finalCursor != null && ownedPacks != null)
            {
                finalCursor.moveToPosition(-1);
                removeFromCursor(ownedPacks, finalCursor);
                if (ownedPacks.size() > 0 && error == 0)
                {
                    int i = ((lang) (this)).;
                    if (mMissingPackRetryCount > 0)
                    {
                        IAPDialogList.logger.log("need to download missing packs...");
                        obj = new MatrixCursor(finalCursor.getColumnNames());
                        ((MatrixCursor) (obj)).addRow(new Object[] {
                            Integer.valueOf(-1), Integer.valueOf(-1), "", "", Integer.valueOf(-1), "", "", "", "", "", 
                            Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(0)
                        });
                        finalCursor = new MergeCursor(new Cursor[] {
                            finalCursor, obj
                        });
                        obj = (String)mDataService.getIntentExtra("extra-api-key-secret", "");
                        s = (String)mDataService.getIntentExtra("extra-billing-public-key", "");
                        context.startService(AviaryIntent.createCdsRestoreOwnedPacks(context, packType.toCdsString(), ((String) (obj)), s));
                    }
                }
            }
            mParent.mCacheMap.clear();
            mParent.mCacheMap.putAll(hashmap);
            mParent.mInventory = inventory;
            mAdapter.changeCursor(finalCursor);
            mListProgress.setVisibility(8);
            mErrorView.setVisibility(8);
            hashmap = mRestoreAllView;
            if ("amazon".equals("production"))
            {
                byte0 = 8;
            } else
            {
                byte0 = 0;
            }
            hashmap.setVisibility(byte0);
        }

        protected void doPreExecute()
        {
        }

        Inventory getInventory(Cursor cursor, IAPInstance iapinstance)
            throws IabException
        {
            Object obj = null;
            Inventory inventory1 = obj;
            if (cursor != null)
            {
                ArrayList arraylist = new ArrayList();
                for (; cursor.moveToNext(); arraylist.add(com.aviary.android.feather.cds.PacksColumns.PackCursorWrapper.create(cursor).getIdentifier())) { }
                inventory1 = obj;
                if (iapinstance.isAvailable())
                {
                    inventory1 = iapinstance.queryInventory(true, arraylist, null);
                }
            }
            return inventory1;
        }

        List getPurchasedPacksByType(Inventory inventory1, com.aviary.android.feather.cds.AviaryCds.PackType packtype)
        {
            Inventory inventory2 = null;
            if (inventory1 != null)
            {
                inventory1 = inventory1.getAllOwnedSkus("inapp");
                inventory2 = inventory1;
                if (inventory1 != null)
                {
                    CdsUtils.filterSkuByPackType(inventory1, packtype.toCdsString());
                    inventory2 = inventory1;
                }
            }
            return inventory2;
        }

        public QueryInventoryAsyncTask(int i, Inventory inventory1)
        {
            this$0 = IAPDialogList.this;
            super();
            error = i;
            inventory = inventory1;
        }
    }


    static com.aviary.android.feather.common.log.LoggerFactory.Logger logger = LoggerFactory.getLogger("IAPDialogList");
    BroadcastReceiver downloadMissingPacksCompletedReceiver;
    private CursorAdapter mAdapter;
    private AnimationAdapter mAnimationAdapter;
    private boolean mAttached;
    private IAPDialogMain.IAPUpdater mData;
    private LocalDataService mDataService;
    private View mErrorView;
    private ListView mList;
    private View mListProgress;
    private int mMissingPackRetryCount;
    private OnPackSelectedListener mPackSelectedListener;
    private IAPDialogMain mParent;
    private Picasso mPicasso;
    private Button mRestoreAllButton;
    private View mRestoreAllView;

    public IAPDialogList(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        downloadMissingPacksCompletedReceiver = new BroadcastReceiver() {

            final IAPDialogList this$0;

            public void onReceive(Context context1, Intent intent)
            {
                IAPDialogList.logger.info("downloadMissingPacksCompletedReceiver");
                int i;
                if (context1 != null && intent != null)
                {
                    context1 = intent.getStringExtra("packType");
                    i = intent.getIntExtra("error", 0);
                    break MISSING_BLOCK_LABEL_33;
                }
                do
                {
                    return;
                } while (!isValidContext() || context1 == null || mData == null || mData.getPackType() == null || !context1.equals(mData.getPackType().toCdsString()));
                runInventoryAsyncTask(i, mParent.mInventory);
            }

            
            {
                this$0 = IAPDialogList.this;
                super();
            }
        };
        mMissingPackRetryCount = 5;
    }

    private void displayProgressNotification()
    {
        Context context = getContext();
        if (context != null)
        {
            android.support.v4.app.NotificationCompat.Builder builder = RestoreAllHelper.createNotification(context);
            builder.setProgress(100, 0, true);
            ((NotificationManager)context.getSystemService("notification")).notify(22322, builder.build());
        }
    }

    private void onError()
    {
        logger.info("onError");
        mListProgress.setVisibility(8);
        mErrorView.setVisibility(0);
        mRestoreAllView.setVisibility(4);
    }

    private void onRestoreAll()
    {
        logger.info("onRestoreAll");
        Toast.makeText(getContext(), com.aviary.android.feather.sdk.R.string.feather_restore_all_request_sent, 0).show();
        Object obj = (String)mDataService.getIntentExtra("extra-api-key-secret", "");
        String s = (String)mDataService.getIntentExtra("extra-billing-public-key", "");
        obj = AviaryIntent.createCdsRestoreAllIntent(getContext(), mData.getPackType().toCdsString(), ((String) (obj)), s);
        if (mParent.getContext().startService(((Intent) (obj))) != null)
        {
            displayProgressNotification();
        }
        AviaryTracker.getInstance(getContext()).tagEvent("shop_list: restore_all_initiated");
    }

    private void onUpdate()
    {
        logger.info("onUpdate");
        if (!isValidContext() || getHandler() == null)
        {
            return;
        } else
        {
            mErrorView.setVisibility(8);
            int i = getResources().getInteger(0x10e0001);
            getHandler().postDelayed(new Runnable() {

                final IAPDialogList this$0;

                public void run()
                {
                    runInventoryAsyncTask(0, null);
                }

            
            {
                this$0 = IAPDialogList.this;
                super();
            }
            }, i + 300);
            return;
        }
    }

    protected CursorAdapter createAdapter()
    {
        return new MyCursorAdapter(getContext(), null);
    }

    protected Cursor createCursorForAvailablePacks(com.aviary.android.feather.cds.AviaryCds.PackType packtype)
        throws SQLiteException
    {
        logger.info("createCursorForAvailablePacks(%s)", new Object[] {
            packtype
        });
        if (!isValidContext())
        {
            return null;
        } else
        {
            packtype = (new StringBuilder()).append("pack/type/").append(packtype.toCdsString()).append("/content/available/list").toString();
            return getContext().getContentResolver().query(PackageManagerUtils.getCDSProviderContentUri(getContext(), packtype), new String[] {
                "pack_id as _id", "pack_id", "pack_type", "pack_identifier", "content_id", "content_contentPath", "content_contentURL", "content_displayName", "content_iconPath", "content_iconUrl", 
                "content_isFree", "content_purchased", "content_packId", "content_numItems"
            }, null, null, "content_purchased ASC, pack_displayOrder ASC");
        }
    }

    protected Cursor createCursorForHiddenPacks(com.aviary.android.feather.cds.AviaryCds.PackType packtype, String s)
        throws SQLiteException
    {
        logger.info("createCursorForHiddenPacks(%s)", new Object[] {
            packtype
        });
        if (!isValidContext())
        {
            return null;
        }
        if (s == null)
        {
            throw new IllegalArgumentException("selection cannot be null");
        } else
        {
            packtype = (new StringBuilder()).append("pack/type/").append(packtype.toCdsString()).append("/content/hidden/list").toString();
            return getContext().getContentResolver().query(PackageManagerUtils.getCDSProviderContentUri(getContext(), packtype), new String[] {
                "pack_id as _id", "pack_id", "pack_type", "pack_identifier", "content_id", "content_contentPath", "content_contentURL", "content_displayName", "content_iconPath", "content_iconUrl", 
                "content_isFree", "content_purchased", "content_packId", "content_numItems"
            }, s, null, "content_purchased ASC, pack_displayOrder ASC");
        }
    }

    public IAPDialogMain.IAPUpdater getData()
    {
        return mData;
    }

    boolean isValidContext()
    {
        return getContext() != null && mAttached;
    }

    protected void onAttachedToWindow()
    {
        logger.info("onAttachedToWindow");
        super.onAttachedToWindow();
        if (isInEditMode())
        {
            return;
        }
        FeatherActivity featheractivity = (FeatherActivity)getContext();
        mMissingPackRetryCount = 5;
        mAttached = true;
        mList = (ListView)findViewById(0x102000a);
        mRestoreAllButton = (Button)findViewById(com.aviary.android.feather.sdk.R.id.aviary_restore_all_button);
        mRestoreAllButton.setOnClickListener(this);
        mRestoreAllView = findViewById(com.aviary.android.feather.sdk.R.id.restore_all_container);
        mListProgress = findViewById(com.aviary.android.feather.sdk.R.id.aviary_iap_list_progress);
        mErrorView = findViewById(com.aviary.android.feather.sdk.R.id.aviary_error_message);
        View view = mRestoreAllView;
        byte byte0;
        if ("amazon".equals("production"))
        {
            byte0 = 8;
        } else
        {
            byte0 = 0;
        }
        view.setVisibility(byte0);
        mPicasso = Picasso.with(getContext());
        mDataService = (LocalDataService)featheractivity.getMainController().getService(com/aviary/android/feather/library/services/LocalDataService);
        featheractivity.registerReceiver(downloadMissingPacksCompletedReceiver, new IntentFilter((new StringBuilder()).append(featheractivity.getPackageName()).append(".cds.downloadMissingPacksCompleted").toString()));
        mList.setOnItemClickListener(this);
        mList.setItemsCanFocus(true);
        mAdapter = createAdapter();
        if (ApiHelper.listAnimationsAvailable())
        {
            mAnimationAdapter = new AlphaInAnimationAdapter(mAdapter);
            mAnimationAdapter.setAbsListView(mList);
            mList.setAdapter(mAnimationAdapter);
        } else
        {
            mList.setAdapter(mAdapter);
        }
        mErrorView.setOnClickListener(this);
    }

    public void onClick(View view)
    {
        if (view != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int i;
        i = view.getId();
        if (i == com.aviary.android.feather.sdk.R.id.aviary_restore_all_button)
        {
            onRestoreAll();
            return;
        }
        if (i == mErrorView.getId())
        {
            mListProgress.setVisibility(0);
            mErrorView.setVisibility(8);
            update(mData, mParent);
            return;
        }
        if (i != com.aviary.android.feather.sdk.R.id.aviary_buy_button || !(view instanceof IAPBuyButton)) goto _L1; else goto _L3
_L3:
        IAPBuyButton iapbuybutton;
        Object obj;
        iapbuybutton = (IAPBuyButton)view;
        obj = (ViewGroup)view.getParent();
        view = iapbuybutton.getPackOption();
        if (view == null || obj == null) goto _L1; else goto _L4
_L4:
        obj = (ViewGroup)((ViewGroup) (obj)).getParent();
        if (obj == null) goto _L1; else goto _L5
_L5:
        obj = ((ViewGroup) (obj)).getTag();
        if (!(obj instanceof MyCursorAdapter.ViewHolder)) goto _L1; else goto _L6
_L6:
        obj = (MyCursorAdapter.ViewHolder)obj;
        if (obj == null || ((MyCursorAdapter.ViewHolder) (obj)).packid < 0L || ((MyCursorAdapter.ViewHolder) (obj)).identifier == null) goto _L1; else goto _L7
_L7:
        switch (_cls4..SwitchMap.com.aviary.android.feather.cds.CdsUtils.PackOption[((com.aviary.android.feather.cds.CdsUtils.PackOptionWithPrice) (view)).option.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            mParent.getStoreWrapper().purchase(((MyCursorAdapter.ViewHolder) (obj)).packid, ((MyCursorAdapter.ViewHolder) (obj)).identifier, mData.getPackType().toCdsString(), "shop_list", ((com.aviary.android.feather.cds.CdsUtils.PackOptionWithPrice) (view)).price);
            return;

        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
            boolean flag;
            boolean flag1;
            boolean flag2;
            boolean flag3;
            if (((com.aviary.android.feather.cds.CdsUtils.PackOptionWithPrice) (view)).option == com.aviary.android.feather.cds.CdsUtils.PackOption.FREE)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (((com.aviary.android.feather.cds.CdsUtils.PackOptionWithPrice) (view)).option == com.aviary.android.feather.cds.CdsUtils.PackOption.RESTORE)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (((com.aviary.android.feather.cds.CdsUtils.PackOptionWithPrice) (view)).option == com.aviary.android.feather.cds.CdsUtils.PackOption.DOWNLOAD_ERROR)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            if (((com.aviary.android.feather.cds.CdsUtils.PackOptionWithPrice) (view)).option == com.aviary.android.feather.cds.CdsUtils.PackOption.INSTALL)
            {
                flag3 = true;
            } else
            {
                flag3 = false;
            }
            mParent.getStoreWrapper().restore(((MyCursorAdapter.ViewHolder) (obj)).packid, ((MyCursorAdapter.ViewHolder) (obj)).identifier, mData.getPackType().toCdsString(), "top_store", flag1, flag, flag2, flag3);
            return;

        case 7: // '\007'
            mParent.mCacheMap.put(Long.valueOf(((MyCursorAdapter.ViewHolder) (obj)).packid), com.aviary.android.feather.cds.CdsUtils.PackOption.PACK_OPTION_BEING_DETERMINED);
            iapbuybutton.setPackOption(new com.aviary.android.feather.cds.CdsUtils.PackOptionWithPrice(com.aviary.android.feather.cds.CdsUtils.PackOption.PACK_OPTION_BEING_DETERMINED), ((MyCursorAdapter.ViewHolder) (obj)).packid);
            mParent.getStoreWrapper().startSetup(true, this);
            return;

        case 2: // '\002'
        case 8: // '\b'
        case 9: // '\t'
        case 10: // '\n'
        case 11: // '\013'
            break;
        }
        if (true) goto _L1; else goto _L8
_L8:
    }

    protected void onDetachedFromWindow()
    {
        logger.info("onDetachedFromWindow");
        onVisibilityChanged(null, 8);
        if (mAdapter != null)
        {
            mAdapter.changeCursor(null);
        }
        mList.setAdapter(null);
        if (mAnimationAdapter != null)
        {
            mAnimationAdapter.setAbsListView(null);
        }
        getContext().unregisterReceiver(downloadMissingPacksCompletedReceiver);
        mAttached = false;
        super.onDetachedFromWindow();
    }

    void onDownloadStatusChanged(long l, String s, int i)
    {
        if (mAdapter != null && mData != null && isValidContext() && s != null && s.equals(mData.getPackType().toCdsString()))
        {
            logger.info("onDownloadStatusChanged: id: %d, type: %s, status: %d", new Object[] {
                Long.valueOf(l), s, Integer.valueOf(i)
            });
            mAdapter.notifyDataSetChanged();
        }
    }

    public void onIabSetupFinished(IabResult iabresult)
    {
label0:
        {
            logger.info("onIabSetupFinished: %s", new Object[] {
                iabresult
            });
            if (mData != null && isValidContext())
            {
                if (iabresult == null)
                {
                    break label0;
                }
                logger.log("mData not null and result is success");
                onUpdate();
            }
            return;
        }
        onError();
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        logger.info("onItemClick: position: %d, id: %d", new Object[] {
            Integer.valueOf(i), Long.valueOf(l)
        });
        if (mPackSelectedListener != null && l > -1L)
        {
            adapterview = ((AdapterView) (view.getTag()));
            if (adapterview instanceof MyCursorAdapter.ViewHolder)
            {
                adapterview = ((MyCursorAdapter.ViewHolder)adapterview).identifier;
                mPackSelectedListener.onPackSelected(l, mData.getPackType(), adapterview);
            }
        }
    }

    void onPackInstalled(long l, String s, int i)
    {
        if (mAdapter != null && isValidContext() && mData != null && s != null && s.equals(mData.getPackType().toCdsString()))
        {
            logger.info("onPackInstalled: id: %d, type: %s, purchased: %d", new Object[] {
                Long.valueOf(l), s, Integer.valueOf(i)
            });
            mAdapter.notifyDataSetChanged();
        }
    }

    void onPurchaseSuccess(long l, String s, Purchase purchase)
    {
        if (mAdapter != null && isValidContext() && mData != null && s != null && s.equals(mData.getPackType().toCdsString()))
        {
            logger.info("onPurchaseSuccess( %d, %s )", new Object[] {
                Long.valueOf(l), s
            });
            mAdapter.notifyDataSetChanged();
        }
    }

    void onServiceFinished()
    {
        logger.info("onServiceFinished");
        if (isValidContext() && mData != null)
        {
            runInventoryAsyncTask(0, null);
        }
    }

    void onSubscriptionPurchased(String s, int i)
    {
        logger.info("onSubscriptionPurchased: identifier: %s, purchased: %d", new Object[] {
            s, Integer.valueOf(i)
        });
        if (mAdapter != null && isValidContext() && mData != null)
        {
            runInventoryAsyncTask(0, mParent.mInventory);
        }
    }

    protected void onVisibilityChanged(View view, int i)
    {
        logger.info((new StringBuilder()).append("onVisibilityChanged: ").append(i).toString());
        super.onVisibilityChanged(view, i);
        if (i == 0)
        {
            getHandler().postDelayed(new Runnable() {

                final IAPDialogList this$0;

                public void run()
                {
                    if (mList != null)
                    {
                        mList.clearFocus();
                        mList.clearChoices();
                        mList.invalidateViews();
                    }
                }

            
            {
                this$0 = IAPDialogList.this;
                super();
            }
            }, 100L);
        }
    }

    void runInventoryAsyncTask(int i, Inventory inventory)
    {
        logger.info("runInventoryAsyncTask");
        (new QueryInventoryAsyncTask(i, inventory)).execute(new com.aviary.android.feather.cds.AviaryCds.PackType[] {
            mData.getPackType()
        });
    }

    public void setOnPackSelectedListener(OnPackSelectedListener onpackselectedlistener)
    {
        mPackSelectedListener = onpackselectedlistener;
    }

    public void update(IAPDialogMain.IAPUpdater iapupdater, IAPDialogMain iapdialogmain)
    {
label0:
        {
            logger.info("update: %s", new Object[] {
                iapupdater
            });
            mParent = iapdialogmain;
            mData = (IAPDialogMain.IAPUpdater)iapupdater.clone();
            if (isValidContext() && mParent.getStoreWrapper().isActive())
            {
                if (!mParent.getStoreWrapper().isSetupDone())
                {
                    break label0;
                }
                logger.log("valid iabResult");
                onUpdate();
            }
            return;
        }
        logger.log("setup not yet started");
        mParent.getStoreWrapper().startSetup(true, this);
    }








/*
    static int access$410(IAPDialogList iapdialoglist)
    {
        int i = iapdialoglist.mMissingPackRetryCount;
        iapdialoglist.mMissingPackRetryCount = i - 1;
        return i;
    }

*/





}
