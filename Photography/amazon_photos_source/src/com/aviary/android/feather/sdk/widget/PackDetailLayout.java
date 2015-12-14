// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.CursorAdapter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ViewAnimator;
import com.aviary.android.feather.cds.AviaryCds;
import com.aviary.android.feather.cds.AviaryCdsDownloaderFactory;
import com.aviary.android.feather.cds.AviaryCdsValidatorFactory;
import com.aviary.android.feather.cds.CdsUtils;
import com.aviary.android.feather.cds.IAPInstance;
import com.aviary.android.feather.cds.billing.util.IabException;
import com.aviary.android.feather.cds.billing.util.IabResult;
import com.aviary.android.feather.cds.billing.util.Inventory;
import com.aviary.android.feather.cds.billing.util.Purchase;
import com.aviary.android.feather.common.log.LoggerFactory;
import com.aviary.android.feather.common.utils.SystemUtils;
import com.aviary.android.feather.common.utils.os.AviaryAsyncTask;
import com.aviary.android.feather.sdk.graphics.CdsPreviewTransformer;
import com.aviary.android.feather.sdk.utils.CdsUIUtils;
import com.nineoldandroids.view.ViewHelper;
import it.sephiroth.android.library.picasso.Callback;
import it.sephiroth.android.library.picasso.Picasso;
import it.sephiroth.android.library.picasso.RequestCreator;
import it.sephiroth.android.library.widget.HListView;
import java.io.File;
import java.util.Arrays;

// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            AviaryTextView, AviaryStoreWrapperAbstract, IAPBuyButton

public abstract class PackDetailLayout extends RelativeLayout
    implements android.view.View.OnClickListener, com.aviary.android.feather.cds.billing.util.IabHelper.OnIabSetupFinishedListener
{
    class DetailImageDownloadAsyncTask extends AviaryAsyncTask
    {

        private final long delay;
        private final long packId;
        final PackDetailLayout this$0;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Context[])aobj);
        }

        protected transient String doInBackground(Context acontext[])
        {
            PackDetailLayout.logger.info("DetailImageDownloadAsyncTask::doInBackground");
            for (acontext = acontext[0]; !isValidContext() || acontext == null || getPack() == null || packId != getPackId();)
            {
                return null;
            }

            if (delay > 0L)
            {
                SystemUtils.trySleep(delay);
            }
            com.aviary.android.feather.cds.AviaryCdsDownloaderFactory.Downloader downloader = AviaryCdsDownloaderFactory.create(com.aviary.android.feather.cds.AviaryCds.ContentType.DETAIL_IMAGE);
            try
            {
                acontext = downloader.download(acontext, packId);
            }
            // Misplaced declaration of an exception variable
            catch (Context acontext[])
            {
                acontext.printStackTrace();
                return null;
            }
            return acontext;
        }

        protected volatile void doPostExecute(Object obj)
        {
            doPostExecute((String)obj);
        }

        protected void doPostExecute(String s)
        {
            PackDetailLayout.logger.info("DetailImageDownloadAsyncTask::doPostExecute");
            if (!isValidContext() || getPack() == null || mPicasso == null || packId != getPackId())
            {
                PackDetailLayout.logger.warn("isValidContext: %b", new Object[] {
                    Boolean.valueOf(isValidContext())
                });
                s = PackDetailLayout.logger;
                boolean flag;
                if (getPack() != null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                s.warn("pack != null: %b", new Object[] {
                    Boolean.valueOf(flag)
                });
                s = PackDetailLayout.logger;
                if (mPicasso != null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                s.warn("picasso != null: %b", new Object[] {
                    Boolean.valueOf(flag)
                });
                PackDetailLayout.logger.warn("packId != mPackId: %d/%d", new Object[] {
                    Long.valueOf(packId), Long.valueOf(getPackId())
                });
                return;
            } else
            {
                s = mPicasso.load(s);
                s.noFade();
                s.config(android.graphics.Bitmap.Config.RGB_565).fit(true).skipMemoryCache().into(mDetailImageView, new Callback() {

                    final DetailImageDownloadAsyncTask this$1;

                    public void onError()
                    {
                        PackDetailLayout.logger.warn("onError");
                    }

                    public void onSuccess()
                    {
                        if (isValidContext() && packId == getPackId() && mDetailBanner.getDisplayedChild() == 1)
                        {
                            if (isChildVisible(_fld0))
                            {
                                mDetailBanner.setInAnimation(getContext(), com.aviary.android.feather.sdk.R.anim.aviary_detail_banner_fade_in);
                                mDetailBanner.setOutAnimation(getContext(), com.aviary.android.feather.sdk.R.anim.aviary_detail_banner_fade_out);
                            } else
                            {
                                PackDetailLayout.logger.warn("downloadDetailImage, skip animation..");
                                mDetailBanner.setInAnimation(null);
                                mDetailBanner.setOutAnimation(null);
                            }
                            mDetailBanner.setDisplayedChild(2);
                        }
                    }

            
            {
                this$1 = DetailImageDownloadAsyncTask.this;
                super();
            }
                });
                return;
            }
        }

        protected void doPreExecute()
        {
        }


        DetailImageDownloadAsyncTask(long l, long l1)
        {
            this$0 = PackDetailLayout.this;
            super();
            delay = l1;
            packId = l;
        }
    }

    class DeterminePackOptionAsyncTask extends AviaryAsyncTask
    {

        Inventory inventory;
        long packId;
        final PackDetailLayout this$0;

        private com.aviary.android.feather.cds.CdsUtils.PackOptionWithPrice getPackDownloadStatus(Context context, com.aviary.android.feather.cds.PacksColumns.PackCursorWrapper packcursorwrapper)
        {
            if (context != null)
            {
                if ((context = CdsUtils.getPackOptionDownloadStatus(context, packcursorwrapper.getId())) != null)
                {
                    return new com.aviary.android.feather.cds.CdsUtils.PackOptionWithPrice((com.aviary.android.feather.cds.CdsUtils.PackOption)((Pair) (context)).first, null);
                }
            }
            return null;
        }

        protected transient com.aviary.android.feather.cds.CdsUtils.PackOptionWithPrice doInBackground(Inventory ainventory[])
        {
            PackDetailLayout.logger.info("DeterminePackOptionAsyncTask.doInBackground");
            if (isValidContext()) goto _L2; else goto _L1
_L1:
            ainventory = null;
_L4:
            return ainventory;
_L2:
            Object obj;
            AviaryStoreWrapperAbstract aviarystorewrapperabstract;
            com.aviary.android.feather.cds.PacksColumns.PackCursorWrapper packcursorwrapper;
            IAPInstance iapinstance;
            com.aviary.android.feather.cds.CdsUtils.PackOptionWithPrice packoptionwithprice;
            obj = getContext();
            inventory = ainventory[0];
            aviarystorewrapperabstract = getStoreWrapper();
            if (aviarystorewrapperabstract == null)
            {
                return null;
            }
            iapinstance = aviarystorewrapperabstract.getIAPInstance();
            packcursorwrapper = CdsUtils.getPackFullInfoById(((Context) (obj)), packId);
            if (packcursorwrapper == null)
            {
                return null;
            }
            packoptionwithprice = getPackDownloadStatus(((Context) (obj)), packcursorwrapper);
            obj = new com.aviary.android.feather.cds.CdsUtils.PackOptionWithPrice(CdsUtils.getPackOption(((Context) (obj)), packcursorwrapper), null);
            PackDetailLayout.logger.log("downloadStatus: %s", new Object[] {
                packoptionwithprice
            });
            PackDetailLayout.logger.log("optionsStatus: %s", new Object[] {
                obj
            });
            if (packoptionwithprice == null)
            {
                break MISSING_BLOCK_LABEL_168;
            }
            if (packoptionwithprice.option != com.aviary.android.feather.cds.CdsUtils.PackOption.DOWNLOAD_COMPLETE)
            {
                break; /* Loop/switch isn't completed */
            }
            ainventory = ((Inventory []) (obj));
            if (com.aviary.android.feather.cds.CdsUtils.PackOption.isInstalled(((com.aviary.android.feather.cds.CdsUtils.PackOptionWithPrice) (obj)).option)) goto _L4; else goto _L3
_L3:
            return packoptionwithprice;
            ainventory = ((Inventory []) (obj));
            if (!com.aviary.android.feather.cds.CdsUtils.PackOption.isOwned(((com.aviary.android.feather.cds.CdsUtils.PackOptionWithPrice) (obj)).option))
            {
                ainventory = ((Inventory []) (obj));
                if (!com.aviary.android.feather.cds.CdsUtils.PackOption.isFree(((com.aviary.android.feather.cds.CdsUtils.PackOptionWithPrice) (obj)).option))
                {
                    if (iapinstance != null && iapinstance.isSetupDone() && inventory == null)
                    {
                        try
                        {
                            inventory = getInventory(packcursorwrapper.getIdentifier(), iapinstance);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Inventory ainventory[])
                        {
                            ainventory.printStackTrace();
                        }
                    }
                    if (inventory != null)
                    {
                        return aviarystorewrapperabstract.getPackOptionFromInventory(packcursorwrapper.getIdentifier(), inventory);
                    } else
                    {
                        return null;
                    }
                }
            }
            if (true) goto _L4; else goto _L5
_L5:
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Inventory[])aobj);
        }

        protected void doPostExecute(com.aviary.android.feather.cds.CdsUtils.PackOptionWithPrice packoptionwithprice)
        {
            PackDetailLayout.logger.log("DeterminePackOptionAsyncTask::doPostExecute: %s", new Object[] {
                packoptionwithprice
            });
            while (!isValidContext() || isCancelled() || getPack() == null || getStoreWrapper() == null || !getStoreWrapper().isActive() || getPackId() != packId) 
            {
                return;
            }
            setInventory(inventory);
            com.aviary.android.feather.cds.CdsUtils.PackOptionWithPrice packoptionwithprice1 = packoptionwithprice;
            if (packoptionwithprice == null)
            {
                packoptionwithprice1 = new com.aviary.android.feather.cds.CdsUtils.PackOptionWithPrice(com.aviary.android.feather.cds.CdsUtils.PackOption.ERROR);
            }
            setPackOption(packoptionwithprice1, getPackId());
        }

        protected volatile void doPostExecute(Object obj)
        {
            doPostExecute((com.aviary.android.feather.cds.CdsUtils.PackOptionWithPrice)obj);
        }

        protected void doPreExecute()
        {
        }

        Inventory getInventory(String s, IAPInstance iapinstance)
            throws IabException
        {
            Object obj = null;
            java.util.List list = Arrays.asList(new String[] {
                s
            });
            s = obj;
            if (iapinstance.isAvailable())
            {
                s = iapinstance.queryInventory(true, list, null);
            }
            return s;
        }

        DeterminePackOptionAsyncTask(long l)
        {
            this$0 = PackDetailLayout.this;
            super();
            packId = l;
        }
    }

    static class LoadPreviewsAsyncTask extends AviaryAsyncTask
    {

        public static final int STATUS_ERROR = 2;
        public static final int STATUS_OK = 0;
        public static final int STATUS_REMOTE_DOWNLOAD = 1;
        private final PackDetailLayout callback;
        private final long delay;
        private final com.aviary.android.feather.cds.PacksColumns.PackCursorWrapper pack;
        private final long packId;
        private int status;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Context[])aobj);
        }

        protected transient String doInBackground(Context acontext[])
        {
            com.aviary.android.feather.cds.PacksColumns.PackCursorWrapper packcursorwrapper;
            Object obj;
            PackDetailLayout.logger.info("LoadPreviewsAsyncTask::doInBackground");
            acontext = acontext[0];
            if (!callback.isValidContext() || acontext == null || packId != callback.getPackId())
            {
                return null;
            }
            if (delay > 0L)
            {
                SystemUtils.trySleep(delay);
            }
            packcursorwrapper = CdsUtils.getPackFullInfoById(acontext, packId);
            if (packcursorwrapper == null || packcursorwrapper.getContent() == null)
            {
                status = 2;
                return null;
            }
            obj = packcursorwrapper.getContent().getPreviewPath();
            if (TextUtils.isEmpty(((CharSequence) (obj)))) goto _L2; else goto _L1
_L1:
            com.aviary.android.feather.cds.AviaryCdsValidatorFactory.Validator validator;
            obj = new File(((String) (obj)));
            validator = AviaryCdsValidatorFactory.create(com.aviary.android.feather.cds.AviaryCds.ContentType.PREVIEW, com.aviary.android.feather.cds.AviaryCds.PackType.fromString(packcursorwrapper.getPackType()));
            validator.validate(acontext, packcursorwrapper.getContent().getId(), ((File) (obj)), false);
            acontext = packcursorwrapper.getContent().getPreviewPath();
            return acontext;
            acontext;
            status = 1;
_L4:
            return null;
_L2:
            status = 1;
            if (true) goto _L4; else goto _L3
_L3:
        }

        protected volatile void doPostExecute(Object obj)
        {
            doPostExecute((String)obj);
        }

        protected void doPostExecute(String s)
        {
            PackDetailLayout.logger.info("LoadPreviewsAsyncTask::doPostExecute: %s, %d", new Object[] {
                s, Integer.valueOf(status)
            });
            if (callback != null)
            {
                callback.onLoadPreviewsCompleted(status, s, pack);
            }
        }

        protected void doPreExecute()
        {
            if (callback != null)
            {
                callback.onLoadPreviewsStarted();
            }
        }

        LoadPreviewsAsyncTask(PackDetailLayout packdetaillayout, com.aviary.android.feather.cds.PacksColumns.PackCursorWrapper packcursorwrapper, long l)
        {
            delay = l;
            pack = packcursorwrapper;
            packId = packcursorwrapper.getId();
            callback = packdetaillayout;
        }
    }

    private class MeasurePreviewTask extends AviaryAsyncTask
    {

        private final com.aviary.android.feather.cds.PacksColumns.PackCursorWrapper pack;
        private double previewAspectRatio;
        private String previewPath;
        final PackDetailLayout this$0;

        protected transient Cursor doInBackground(Context acontext[])
        {
            acontext = acontext[0];
            if (acontext == null)
            {
                acontext = null;
            } else
            {
                double ad[] = new double[1];
                ad[0] = 1.0D;
                Cursor cursor = CdsUIUtils.computePreviewAspectRatio(acontext, pack.getId(), pack.getPackType(), previewPath, ad);
                acontext = cursor;
                if (cursor != null)
                {
                    acontext = cursor;
                    if (cursor.moveToFirst())
                    {
                        previewAspectRatio = ad[0];
                        return cursor;
                    }
                }
            }
            return acontext;
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Context[])aobj);
        }

        protected void doPostExecute(Cursor cursor)
        {
            if (cursor != null && getContext() != null)
            {
                mPreviewWidth = (int)((double)mPreviewHeight * previewAspectRatio);
                ViewHelper.setTranslationX(mHListView, 0.0F);
                mHListView.setDividerWidth(mPreviewDefaultDivider);
                DisplayMetrics displaymetrics = getResources().getDisplayMetrics();
                if (!mIsTablet && cursor != null && cursor.getCount() > 0)
                {
                    int j = mHListView.getWidth();
                    PackDetailLayout.logger.info("hlistview.getWidth: %d, screen.size: %d", new Object[] {
                        Integer.valueOf(j), Integer.valueOf(displaymetrics.widthPixels)
                    });
                    if (j > 0)
                    {
                        int l = cursor.getCount();
                        int i = mHListView.getDividerWidth();
                        PackDetailLayout.logger.info("preview.width: %d, divider.width: %d", new Object[] {
                            Integer.valueOf(mPreviewWidth), Integer.valueOf(i)
                        });
                        if (mPreviewWidth * l + (i * l - 1) < j)
                        {
                            int k = (displaymetrics.widthPixels - mPreviewWidth * l) / Math.max(1, l + 1);
                            mHListView.setDividerWidth(k);
                            float f = Math.abs(k - i);
                            PackDetailLayout.logger.log("new dividerWidth: %d", new Object[] {
                                Integer.valueOf(k)
                            });
                            PackDetailLayout.logger.log("translationX: %f", new Object[] {
                                Float.valueOf(f)
                            });
                            ViewHelper.setTranslationX(mHListView, f);
                        }
                    }
                }
                mPreviewListAdapter.setPreviewSize(mPreviewWidth, mPreviewHeight);
                mPreviewListAdapter.setPreviewMargin(mMarginpx);
                mPreviewListAdapter.setBaseDir(previewPath);
                mPreviewListAdapter.changeCursor(cursor, pack.getPackType());
                mHListView.setTag(pack.getIdentifier());
                mHListView.setSelection(0);
                onDownloadPreviewCompleted();
            }
        }

        protected volatile void doPostExecute(Object obj)
        {
            doPostExecute((Cursor)obj);
        }

        protected void doPreExecute()
        {
        }

        MeasurePreviewTask(com.aviary.android.feather.cds.PacksColumns.PackCursorWrapper packcursorwrapper, String s)
        {
            this$0 = PackDetailLayout.this;
            super();
            pack = packcursorwrapper;
            previewPath = s;
            previewAspectRatio = 1.0D;
        }
    }

    class PreviewDownloadAsyncTask extends AviaryAsyncTask
    {

        private Throwable error;
        private final com.aviary.android.feather.cds.PacksColumns.PackCursorWrapper pack;
        private final long packId;
        final PackDetailLayout this$0;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Context[])aobj);
        }

        protected transient String doInBackground(Context acontext[])
        {
            PackDetailLayout.logger.log("PreviewDownloadAsyncTask::doInBackground");
            acontext = acontext[0];
            if (!isValidContext() || getPack() == null || acontext == null || packId != getPackId())
            {
                return null;
            }
            com.aviary.android.feather.cds.AviaryCdsDownloaderFactory.Downloader downloader = AviaryCdsDownloaderFactory.create(com.aviary.android.feather.cds.AviaryCds.ContentType.PREVIEW);
            try
            {
                acontext = downloader.download(acontext, packId);
            }
            // Misplaced declaration of an exception variable
            catch (Context acontext[])
            {
                acontext.printStackTrace();
                error = acontext;
                return null;
            }
            return acontext;
        }

        protected volatile void doPostExecute(Object obj)
        {
            doPostExecute((String)obj);
        }

        protected void doPostExecute(String s)
        {
            PackDetailLayout.logger.log("PreviewDownloadAsyncTask::doPostExecute: %s", new Object[] {
                s
            });
            if (isCancelled() || !isValidContext() || getPack() == null || packId != getPackId())
            {
                return;
            }
            if (s != null)
            {
                initWorkspace(pack, s);
            }
            if (error != null)
            {
                onDownloadPreviewError();
            }
            downloadDetailImage(pack);
        }

        protected void doPreExecute()
        {
            onDownloadPreviewStarted(true);
        }

        PreviewDownloadAsyncTask(com.aviary.android.feather.cds.PacksColumns.PackCursorWrapper packcursorwrapper)
        {
            this$0 = PackDetailLayout.this;
            super();
            pack = packcursorwrapper;
            packId = packcursorwrapper.getId();
        }
    }

    static class PreviewListAdapter extends CursorAdapter
    {

        int columnIndexDisplayName;
        int columnIndexIdentifier;
        String mBaseDir;
        String mFileExt;
        LayoutInflater mLayoutInflater;
        private int mMarginpx;
        private int mPreviewHeight;
        private int mPreviewWidth;
        int mTargetDensity;
        private String packType;
        private Picasso picasso;

        private void initCursor(Cursor cursor)
        {
            PackDetailLayout.logger.info("initCursor");
            if (cursor != null)
            {
                columnIndexDisplayName = cursor.getColumnIndex("item_displayName");
                columnIndexIdentifier = cursor.getColumnIndex("item_identifier");
            }
        }

        private void recycleBitmaps()
        {
            PackDetailLayout.logger.info("recycleBitmaps. Not implemented");
        }

        public void bindView(View view, Context context, Cursor cursor)
        {
            view = (ImageView)view;
            loadImage(cursor.getPosition(), view);
        }

        public void changeCursor(Cursor cursor, String s)
        {
            packType = s;
            super.changeCursor(cursor);
        }

        public String getBaseDir()
        {
            return mBaseDir;
        }

        public void loadImage(int i, final ImageView imageView)
        {
            Object obj = (Cursor)getItem(i);
            if (obj != null && !((Cursor) (obj)).isAfterLast() && imageView != null && columnIndexDisplayName > -1 && columnIndexIdentifier > -1)
            {
                String s1 = ((Cursor) (obj)).getString(columnIndexIdentifier);
                obj = ((Cursor) (obj)).getString(columnIndexDisplayName);
                String s = com.aviary.android.feather.cds.AviaryCds.PackType.fromString(packType).toCdsString();
                s1 = (new File(getBaseDir(), (new StringBuilder()).append(s1).append(mFileExt).toString())).getAbsolutePath();
                int j = s1.hashCode();
                Integer integer = (Integer)imageView.getTag();
                if (integer != null && integer.equals(Integer.valueOf(j)))
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                if (i == 0)
                {
                    if (imageView.getDrawable() != null)
                    {
                        imageView.setImageBitmap(null);
                    }
                    picasso.cancelRequest(imageView);
                    picasso.load(s1).fit().error(com.aviary.android.feather.sdk.R.drawable.aviary_store_placeholder).transform(new CdsPreviewTransformer(s1, ((String) (obj)), s)).into(imageView, j. new Callback() {

                        final PreviewListAdapter this$0;
                        final int val$imageTag;
                        final ImageView val$imageView;

                        public void onError()
                        {
                        }

                        public void onSuccess()
                        {
                            imageView.setTag(Integer.valueOf(imageTag));
                        }

            
            {
                this$0 = final_previewlistadapter;
                imageView = imageview;
                imageTag = I.this;
                super();
            }
                    });
                }
            }
        }

        public View newView(Context context, Cursor cursor, ViewGroup viewgroup)
        {
            context = new ImageView(context);
            context.setLayoutParams(new android.widget.LinearLayout.LayoutParams(mPreviewWidth, mPreviewHeight));
            if (!"effect".equals(packType))
            {
                context.setPadding(mMarginpx, 0, mMarginpx, 0);
            } else
            {
                context.setPadding(0, 0, 0, 0);
            }
            context.setTag(null);
            return context;
        }

        public void setBaseDir(String s)
        {
            mBaseDir = s;
        }

        public void setFileExt(String s)
        {
            mFileExt = s;
        }

        public void setPreviewMargin(int i)
        {
            mMarginpx = i;
        }

        public void setPreviewSize(int i, int j)
        {
            mPreviewWidth = i;
            mPreviewHeight = j;
        }

        public Cursor swapCursor(Cursor cursor)
        {
            initCursor(cursor);
            recycleBitmaps();
            return super.swapCursor(cursor);
        }

        public PreviewListAdapter(Context context, String s, Cursor cursor)
        {
            super(context, cursor, false);
            mPreviewWidth = 100;
            mPreviewHeight = 100;
            mMarginpx = 0;
            picasso = Picasso.with(context);
            mLayoutInflater = LayoutInflater.from(context);
            mBaseDir = s;
            mTargetDensity = context.getResources().getDisplayMetrics().densityDpi;
            initCursor(cursor);
        }
    }


    protected static com.aviary.android.feather.common.log.LoggerFactory.Logger logger;
    private boolean mAttached;
    private AviaryTextView mAuthor;
    private IAPBuyButton mBuyButton;
    private int mClickedFromPosition;
    private View mContent;
    private boolean mDataIsAnimating;
    protected int mDelay;
    private AviaryTextView mDescription;
    private ViewAnimator mDetailBanner;
    private ImageView mDetailBannerIcon;
    private AviaryTextView mDetailBannerText;
    private ImageView mDetailImageView;
    private View mErrorView;
    private HListView mHListView;
    private View mHListViewContainer;
    private View mHeadView;
    private boolean mIsTablet;
    private int mMarginpx;
    private com.aviary.android.feather.cds.PacksColumns.PackCursorWrapper mPack;
    private long mPackId;
    protected Picasso mPicasso;
    private int mPreviewDefaultDivider;
    private View mPreviewError;
    private int mPreviewHeight;
    private PreviewListAdapter mPreviewListAdapter;
    private ProgressBar mPreviewProgress;
    private int mPreviewWidth;
    private AviaryTextView mTitle;

    public PackDetailLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mClickedFromPosition = -1;
        initialize(context);
    }

    private void determinePackOption(long l, Inventory inventory)
    {
        (new DeterminePackOptionAsyncTask(l)).execute(new Inventory[] {
            inventory
        });
    }

    private void initWorkspace(com.aviary.android.feather.cds.PacksColumns.PackCursorWrapper packcursorwrapper, String s)
    {
        if (packcursorwrapper != null && isValidContext())
        {
            if (packcursorwrapper.getIdentifier().equals(mHListView.getTag()))
            {
                logger.warn("ok, don't reload the workspace, same tag found");
                return;
            } else
            {
                (new MeasurePreviewTask(packcursorwrapper, s)).executeInParallel(new Context[] {
                    getContext()
                });
                return;
            }
        } else
        {
            logger.error("invalid plugin");
            mPreviewListAdapter.changeCursor(null, null);
            mHListView.setTag(null);
            return;
        }
    }

    private boolean loadDetailImageIfLocal(com.aviary.android.feather.cds.PacksColumns.PackCursorWrapper packcursorwrapper)
    {
        logger.info("loadDetailImageIfLocal");
        Object obj = packcursorwrapper.getContent().getDetailImageLocalPath();
        logger.verbose("detailImagePath: %s", new Object[] {
            obj
        });
        if (!TextUtils.isEmpty(((CharSequence) (obj))) && (new File(((String) (obj)))).exists())
        {
            obj = mPicasso.load(((String) (obj)));
            ((RequestCreator) (obj)).noFade();
            if (mDataIsAnimating)
            {
                ((RequestCreator) (obj)).withDelay(mDelay + 100);
            }
            mDetailImageView.setTag(packcursorwrapper.getIdentifier());
            ((RequestCreator) (obj)).config(android.graphics.Bitmap.Config.RGB_565).fit(true).skipMemoryCache().into(mDetailImageView, new Callback() {

                final PackDetailLayout this$0;

                public void onError()
                {
                    PackDetailLayout.logger.error("failed to load local detail image");
                }

                public void onSuccess()
                {
                    if (getContext() != null && mDetailBanner.getDisplayedChild() == 0)
                    {
                        PackDetailLayout.logger.verbose("detail image loaded from local path", new Object[0]);
                        mDetailBanner.setInAnimation(getContext(), com.aviary.android.feather.sdk.R.anim.aviary_detail_banner_fade_in);
                        mDetailBanner.setOutAnimation(getContext(), com.aviary.android.feather.sdk.R.anim.aviary_detail_banner_fade_out);
                        mDetailBanner.setDisplayedChild(2);
                    }
                }

            
            {
                this$0 = PackDetailLayout.this;
                super();
            }
            });
            return true;
        } else
        {
            return false;
        }
    }

    private void loadPreviews(com.aviary.android.feather.cds.PacksColumns.PackCursorWrapper packcursorwrapper)
    {
        if (packcursorwrapper.getIdentifier().equals(mHListView.getTag()))
        {
            logger.warn("ok, don't reload the workspace, same tag found");
            downloadDetailImage(packcursorwrapper);
            return;
        }
        long l;
        if (mDataIsAnimating)
        {
            l = mDelay + 100;
        } else
        {
            l = 0L;
        }
        (new LoadPreviewsAsyncTask(this, packcursorwrapper, l)).executeInParallel(new Context[] {
            getContext()
        });
    }

    private void loadTempDetailImage(com.aviary.android.feather.cds.PacksColumns.PackCursorWrapper packcursorwrapper)
    {
        logger.info("loadTempDetailImage");
        if (!isValidContext())
        {
            return;
        }
        Object obj = com.aviary.android.feather.cds.AviaryCds.PackType.fromString(packcursorwrapper.getPackType());
        obj = CdsUIUtils.getPackTypeString(getContext(), ((com.aviary.android.feather.cds.AviaryCds.PackType) (obj)));
        mDetailBannerText.setText((new StringBuilder()).append(packcursorwrapper.getContent().getDisplayName()).append(" ").append(((String) (obj))).toString());
        obj = mPicasso.load(packcursorwrapper.getContent().getIconPath());
        ((RequestCreator) (obj)).noFade();
        ((RequestCreator) (obj)).skipMemoryCache();
        ((RequestCreator) (obj)).fit(true);
        try
        {
            ((RequestCreator) (obj)).transform((new com.aviary.android.feather.sdk.utils.PackIconStoreTransformation.Builder()).withPackType(packcursorwrapper.getPackType()).withIdentifier(packcursorwrapper.getIdentifier()).withResources(getContext().getResources()).build());
        }
        // Misplaced declaration of an exception variable
        catch (com.aviary.android.feather.cds.PacksColumns.PackCursorWrapper packcursorwrapper)
        {
            packcursorwrapper.printStackTrace();
        }
        ((RequestCreator) (obj)).into(mDetailBannerIcon, new Callback() {

            final PackDetailLayout this$0;

            public void onError()
            {
            }

            public void onSuccess()
            {
                if (mDetailBanner.getDisplayedChild() == 0)
                {
                    PackDetailLayout.logger.verbose("loadTempDetailImage:onSuccess", new Object[0]);
                    mDetailBanner.setInAnimation(null);
                    mDetailBanner.setOutAnimation(null);
                    mDetailBanner.setDisplayedChild(1);
                }
            }

            
            {
                this$0 = PackDetailLayout.this;
                super();
            }
        });
    }

    private void onDownloadPreviewCompleted()
    {
        logger.info("onDownloadPreviewCompleted");
        mPreviewProgress.setVisibility(4);
        mPreviewError.setVisibility(4);
    }

    private void onDownloadPreviewError()
    {
        logger.info("onDownloadPreviewError");
        mPreviewProgress.setVisibility(4);
        mPreviewError.setVisibility(0);
        mPreviewListAdapter.changeCursor(null, null);
        mHListView.setTag(null);
    }

    private void onDownloadPreviewStarted(boolean flag)
    {
        logger.info("onDownloadPreviewStarted");
        if (flag)
        {
            mPreviewProgress.setVisibility(0);
        }
        mPreviewError.setVisibility(4);
    }

    private void onPackMissingError()
    {
        logger.info("onPackMissingError");
        mContent.setVisibility(4);
        mErrorView.setVisibility(0);
        mPreviewListAdapter.changeCursor(null, null);
        mHListView.setTag(null);
    }

    private void resetView()
    {
        logger.info("resetView");
        setPackOption(new com.aviary.android.feather.cds.CdsUtils.PackOptionWithPrice(com.aviary.android.feather.cds.CdsUtils.PackOption.PACK_OPTION_BEING_DETERMINED), -1L);
        mTitle.setText("");
        mDescription.setText("");
        mAuthor.setText("");
        mPreviewListAdapter.changeCursor(null, null);
        mHListView.setTag(null);
        mDetailBanner.setInAnimation(null);
        mDetailBanner.setOutAnimation(null);
        mDetailBanner.setDisplayedChild(0);
        mDetailImageView.setTag(null);
        mDetailImageView.setImageBitmap(null);
        mDetailBannerIcon.setImageBitmap(null);
        mDetailBannerText.setText("");
        mPicasso.cancelRequest(mDetailImageView);
    }

    private void setPackContent(com.aviary.android.feather.cds.PacksColumns.PackCursorWrapper packcursorwrapper)
    {
        logger.info("setPackContent: %s", new Object[] {
            packcursorwrapper
        });
        if (!isValidContext() || getPackId() < 0L)
        {
            return;
        }
        if (packcursorwrapper == null || packcursorwrapper.getContent() == null)
        {
            logger.error("pack or pack.content are null!");
            onPackMissingError();
            return;
        }
        mErrorView.setVisibility(8);
        mContent.setVisibility(0);
        mPreviewError.setVisibility(4);
        mPack = (com.aviary.android.feather.cds.PacksColumns.PackCursorWrapper)packcursorwrapper.clone();
        mPackId = packcursorwrapper.getId();
        mTitle.setText(mPack.getContent().getDisplayName());
        mTitle.setSelected(true);
        AviaryTextView aviarytextview = mDescription;
        if (TextUtils.isEmpty(mPack.getContent().getDisplayDescription()))
        {
            packcursorwrapper = "";
        } else
        {
            packcursorwrapper = mPack.getContent().getDisplayDescription();
        }
        aviarytextview.setText(packcursorwrapper);
        aviarytextview = mAuthor;
        if (TextUtils.isEmpty(mPack.getContent().getAuthor()))
        {
            packcursorwrapper = "";
        } else
        {
            packcursorwrapper = mPack.getContent().getAuthor();
        }
        aviarytextview.setText(packcursorwrapper);
        loadPreviews(mPack);
        if (!loadDetailImageIfLocal(mPack))
        {
            loadTempDetailImage(mPack);
        }
        packcursorwrapper = mPack.getContent().getShopBackgroundColor();
        if (!TextUtils.isEmpty(packcursorwrapper))
        {
            mHListViewContainer.setBackgroundColor(Color.parseColor(packcursorwrapper));
        } else
        {
            mHListViewContainer.setBackgroundDrawable(null);
        }
        mPreviewListAdapter.setFileExt(AviaryCds.getPreviewItemExt(mPack.getPackType()));
        mPreviewListAdapter.setBaseDir(null);
        if (mHeadView != null)
        {
            mHeadView.requestFocus();
            mHeadView.requestFocusFromTouch();
        }
        packcursorwrapper = getStoreWrapper();
        if (packcursorwrapper != null && packcursorwrapper.isActive())
        {
            if (packcursorwrapper.isSetupDone())
            {
                onIabSetupFinished(null);
            } else
            {
                packcursorwrapper.startSetup(true, this);
            }
        }
        onSetPackContentCompleted(mPack);
    }

    void downloadDetailImage(com.aviary.android.feather.cds.PacksColumns.PackCursorWrapper packcursorwrapper)
    {
label0:
        {
            logger.info("downloadDetailImage: %s", new Object[] {
                packcursorwrapper.getContent().getDetailImageURL()
            });
            if (packcursorwrapper != null && packcursorwrapper.getContent() != null && isValidContext() && packcursorwrapper.getId() == getPackId())
            {
                if (mDetailBanner.getDisplayedChild() != 2 && !packcursorwrapper.getIdentifier().equals(mDetailImageView.getTag()))
                {
                    break label0;
                }
                logger.warn("detail image already loaded! skipping..");
            }
            return;
        }
        mDetailImageView.setTag(packcursorwrapper.getIdentifier());
        long l;
        if (mDetailBanner.getDisplayedChild() == 0)
        {
            l = 100L;
        } else
        {
            l = 1000L;
        }
        (new DetailImageDownloadAsyncTask(packcursorwrapper.getId(), l)).executeInParallel(new Context[] {
            getContext()
        });
    }

    public abstract Inventory getInventory();

    protected final com.aviary.android.feather.cds.PacksColumns.PackCursorWrapper getPack()
    {
        return mPack;
    }

    public final long getPackId()
    {
        return mPackId;
    }

    protected abstract AviaryStoreWrapperAbstract getStoreWrapper();

    protected void initialize(Context context)
    {
        mPicasso = Picasso.with(context);
        context = getResources();
        mIsTablet = context.getBoolean(com.aviary.android.feather.sdk.R.bool.aviary_is_tablet);
        mMarginpx = context.getDimensionPixelSize(com.aviary.android.feather.sdk.R.dimen.aviary_preview_margins);
        mPreviewHeight = context.getDimensionPixelSize(com.aviary.android.feather.sdk.R.dimen.aviary_iap_previews_list_height);
        mDelay = context.getInteger(com.aviary.android.feather.sdk.R.integer.aviary_iap_animator_time) + 100;
    }

    public boolean isAttached()
    {
        return mAttached;
    }

    protected abstract boolean isChildVisible(PackDetailLayout packdetaillayout);

    public abstract boolean isValidContext();

    protected void onAttachedToWindow()
    {
        logger.info("onAttachedToWindow (packid: %d)", new Object[] {
            Long.valueOf(mPackId)
        });
        super.onAttachedToWindow();
        mAttached = true;
        mPreviewListAdapter = new PreviewListAdapter(getContext(), null, null);
        mHListView.setAdapter(mPreviewListAdapter);
        mBuyButton.setOnClickListener(this);
        if (mErrorView != null)
        {
            mErrorView.setOnClickListener(this);
        }
        if (mPreviewError != null)
        {
            mPreviewError.setOnClickListener(this);
        }
        if (mPack == null && mPackId > 0L && isValidContext())
        {
            logger.verbose("ok, attached", new Object[0]);
            resetView();
            setPackContent(CdsUtils.getPackFullInfoById(getContext(), mPackId));
        }
    }

    public void onClick(View view)
    {
        int i = view.getId();
        if (i == mErrorView.getId())
        {
            onForceUpdate();
        } else
        {
            if (i == mPreviewError.getId())
            {
                (new PreviewDownloadAsyncTask(getPack())).executeInParallel(new Context[] {
                    getContext()
                });
                return;
            }
            if (i == mBuyButton.getId())
            {
                view = ((IAPBuyButton)view).getPackOption();
                static class _cls3
                {

                    static final int $SwitchMap$com$aviary$android$feather$cds$CdsUtils$PackOption[];

                    static 
                    {
                        $SwitchMap$com$aviary$android$feather$cds$CdsUtils$PackOption = new int[com.aviary.android.feather.cds.CdsUtils.PackOption.values().length];
                        try
                        {
                            $SwitchMap$com$aviary$android$feather$cds$CdsUtils$PackOption[com.aviary.android.feather.cds.CdsUtils.PackOption.PURCHASE.ordinal()] = 1;
                        }
                        catch (NoSuchFieldError nosuchfielderror9) { }
                        try
                        {
                            $SwitchMap$com$aviary$android$feather$cds$CdsUtils$PackOption[com.aviary.android.feather.cds.CdsUtils.PackOption.INSTALL.ordinal()] = 2;
                        }
                        catch (NoSuchFieldError nosuchfielderror8) { }
                        try
                        {
                            $SwitchMap$com$aviary$android$feather$cds$CdsUtils$PackOption[com.aviary.android.feather.cds.CdsUtils.PackOption.FREE.ordinal()] = 3;
                        }
                        catch (NoSuchFieldError nosuchfielderror7) { }
                        try
                        {
                            $SwitchMap$com$aviary$android$feather$cds$CdsUtils$PackOption[com.aviary.android.feather.cds.CdsUtils.PackOption.RESTORE.ordinal()] = 4;
                        }
                        catch (NoSuchFieldError nosuchfielderror6) { }
                        try
                        {
                            $SwitchMap$com$aviary$android$feather$cds$CdsUtils$PackOption[com.aviary.android.feather.cds.CdsUtils.PackOption.DOWNLOAD_ERROR.ordinal()] = 5;
                        }
                        catch (NoSuchFieldError nosuchfielderror5) { }
                        try
                        {
                            $SwitchMap$com$aviary$android$feather$cds$CdsUtils$PackOption[com.aviary.android.feather.cds.CdsUtils.PackOption.ERROR.ordinal()] = 6;
                        }
                        catch (NoSuchFieldError nosuchfielderror4) { }
                        try
                        {
                            $SwitchMap$com$aviary$android$feather$cds$CdsUtils$PackOption[com.aviary.android.feather.cds.CdsUtils.PackOption.OWNED.ordinal()] = 7;
                        }
                        catch (NoSuchFieldError nosuchfielderror3) { }
                        try
                        {
                            $SwitchMap$com$aviary$android$feather$cds$CdsUtils$PackOption[com.aviary.android.feather.cds.CdsUtils.PackOption.PACK_OPTION_BEING_DETERMINED.ordinal()] = 8;
                        }
                        catch (NoSuchFieldError nosuchfielderror2) { }
                        try
                        {
                            $SwitchMap$com$aviary$android$feather$cds$CdsUtils$PackOption[com.aviary.android.feather.cds.CdsUtils.PackOption.DOWNLOADING.ordinal()] = 9;
                        }
                        catch (NoSuchFieldError nosuchfielderror1) { }
                        try
                        {
                            $SwitchMap$com$aviary$android$feather$cds$CdsUtils$PackOption[com.aviary.android.feather.cds.CdsUtils.PackOption.DOWNLOAD_COMPLETE.ordinal()] = 10;
                        }
                        catch (NoSuchFieldError nosuchfielderror)
                        {
                            return;
                        }
                    }
                }

                if (view != null)
                {
                    switch (_cls3..SwitchMap.com.aviary.android.feather.cds.CdsUtils.PackOption[((com.aviary.android.feather.cds.CdsUtils.PackOptionWithPrice) (view)).option.ordinal()])
                    {
                    default:
                        return;

                    case 1: // '\001'
                        Log.d("PackDetails", (new StringBuilder()).append("clicked from position: ").append(mClickedFromPosition).toString());
                        getStoreWrapper().purchase(mPack.getId(), mPack.getIdentifier(), mPack.getPackType(), "shop_detail", ((com.aviary.android.feather.cds.CdsUtils.PackOptionWithPrice) (view)).price, mClickedFromPosition);
                        return;

                    case 2: // '\002'
                    case 3: // '\003'
                    case 4: // '\004'
                    case 5: // '\005'
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
                        getStoreWrapper().restore(mPack.getId(), mPack.getIdentifier(), mPack.getPackType(), "shop_detail", flag1, flag, flag2, flag3);
                        return;

                    case 6: // '\006'
                        setPackOption(new com.aviary.android.feather.cds.CdsUtils.PackOptionWithPrice(com.aviary.android.feather.cds.CdsUtils.PackOption.PACK_OPTION_BEING_DETERMINED), getPackId());
                        getStoreWrapper().startSetup(true, this);
                        return;

                    case 7: // '\007'
                    case 8: // '\b'
                    case 9: // '\t'
                    case 10: // '\n'
                        logger.log("Do nothing here");
                        return;
                    }
                }
            }
        }
    }

    protected void onDetachedFromWindow()
    {
        logger.info("onDetachedFromWindow");
        mAttached = false;
        mBuyButton.setOnClickListener(null);
        mHListView.setTag(null);
        mPreviewListAdapter.changeCursor(null, null);
        mHListView.setAdapter(null);
        if (mPreviewError != null)
        {
            mPreviewError.setOnClickListener(null);
        }
        super.onDetachedFromWindow();
    }

    public void onDownloadStatusChanged(long l, String s, int i)
    {
        if (isValidContext() && getPack() != null)
        {
            logger.info("onDownloadStatusChanged: %d, %s, %d", new Object[] {
                Long.valueOf(l), s, Integer.valueOf(i)
            });
            if (l == getPackId())
            {
                determinePackOption(getPackId(), getInventory());
            }
        }
    }

    protected void onFinishInflate()
    {
        logger.info("onFinishInflate");
        super.onFinishInflate();
        mDetailBanner = (ViewAnimator)findViewById(com.aviary.android.feather.sdk.R.id.aviary_detail_switcher);
        mTitle = (AviaryTextView)findViewById(com.aviary.android.feather.sdk.R.id.aviary_title);
        mAuthor = (AviaryTextView)findViewById(com.aviary.android.feather.sdk.R.id.author);
        mDescription = (AviaryTextView)findViewById(com.aviary.android.feather.sdk.R.id.aviary_description);
        mDetailImageView = (ImageView)findViewById(com.aviary.android.feather.sdk.R.id.feature_image);
        mHListView = (HListView)findViewById(com.aviary.android.feather.sdk.R.id.aviary_list);
        mDetailBannerText = (AviaryTextView)findViewById(com.aviary.android.feather.sdk.R.id.aviary_detail_background_text);
        mDetailBannerIcon = (ImageView)findViewById(com.aviary.android.feather.sdk.R.id.aviary_detail_background_icon);
        mContent = findViewById(com.aviary.android.feather.sdk.R.id.aviary_content);
        mBuyButton = (IAPBuyButton)findViewById(com.aviary.android.feather.sdk.R.id.aviary_buy_button);
        mErrorView = findViewById(com.aviary.android.feather.sdk.R.id.aviary_error_message);
        mPreviewProgress = (ProgressBar)findViewById(com.aviary.android.feather.sdk.R.id.aviary_progress2);
        mPreviewError = findViewById(com.aviary.android.feather.sdk.R.id.aviary_error_previews);
        mHListViewContainer = findViewById(com.aviary.android.feather.sdk.R.id.list_container);
        mHeadView = findViewById(com.aviary.android.feather.sdk.R.id.aviary_head);
        mPreviewDefaultDivider = mHListView.getDividerWidth();
    }

    protected abstract void onForceUpdate();

    public void onIabSetupFinished(IabResult iabresult)
    {
        logger.info("onIabSetupFinished: %s", new Object[] {
            iabresult
        });
        if (isValidContext() && getPack() != null)
        {
            determinePackOption(getPackId(), getInventory());
        }
    }

    public void onLoadPreviewsCompleted(int i, String s, com.aviary.android.feather.cds.PacksColumns.PackCursorWrapper packcursorwrapper)
    {
        logger.info("onLoadPreviewsCompleted(%d, %s)", new Object[] {
            Integer.valueOf(i), s
        });
        if (!isValidContext() || getPack() == null || packcursorwrapper == null || getPackId() != packcursorwrapper.getId())
        {
            return;
        }
        if (s != null)
        {
            initWorkspace(packcursorwrapper, s);
            downloadDetailImage(packcursorwrapper);
            return;
        }
        if (i == 2)
        {
            onDownloadPreviewError();
            downloadDetailImage(packcursorwrapper);
            return;
        } else
        {
            (new PreviewDownloadAsyncTask(packcursorwrapper)).executeInParallel(new Context[] {
                getContext()
            });
            return;
        }
    }

    public void onLoadPreviewsStarted()
    {
        onDownloadPreviewStarted(false);
    }

    public void onPackInstalled(long l, String s, int i)
    {
        if (isValidContext() && getPack() != null && l == getPackId())
        {
            logger.info("onPackInstalled: %d, %s, %d", new Object[] {
                Long.valueOf(l), s, Integer.valueOf(i)
            });
            determinePackOption(getPackId(), getInventory());
        }
    }

    public void onPurchaseSuccess(long l, String s, Purchase purchase)
    {
        if (isValidContext() && getPack() != null && l == getPackId())
        {
            logger.info("onPurchaseSuccess: %d - %s", new Object[] {
                Long.valueOf(l), s
            });
            determinePackOption(getPackId(), getInventory());
        }
    }

    public void onServiceFinished()
    {
        if (!isValidContext() || getPack() == null)
        {
            return;
        } else
        {
            logger.info("onServiceFinished");
            return;
        }
    }

    protected abstract void onSetPackContentCompleted(com.aviary.android.feather.cds.PacksColumns.PackCursorWrapper packcursorwrapper);

    public void onSubscriptionPurchased(String s, int i)
    {
        if (isValidContext() && getPack() != null)
        {
            logger.info("onSubscriptionPurchased: %s, %d", new Object[] {
                s, Integer.valueOf(i)
            });
            determinePackOption(getPackId(), getInventory());
        }
    }

    public abstract void setInventory(Inventory inventory);

    void setPackOption(com.aviary.android.feather.cds.CdsUtils.PackOptionWithPrice packoptionwithprice, long l)
    {
        logger.info("setPackOption: %s", new Object[] {
            packoptionwithprice
        });
        if (mBuyButton != null)
        {
            mBuyButton.setPackOption(packoptionwithprice, l);
        }
    }

    protected void update(long l, boolean flag, Bundle bundle)
    {
        int i = -1;
        if (bundle != null)
        {
            i = bundle.getInt("click_from_position", -1);
        }
        logger.info("(update: %d, %b)", new Object[] {
            Long.valueOf(l), Boolean.valueOf(flag)
        });
        mDataIsAnimating = flag;
        mPackId = l;
        mPack = null;
        mClickedFromPosition = i;
        if (isValidContext())
        {
            logger.verbose("ok attached!", new Object[0]);
            resetView();
            setPackContent(CdsUtils.getPackFullInfoById(getContext(), mPackId));
        }
    }

    static 
    {
        logger = LoggerFactory.getLogger("PackDetailLayout", com.aviary.android.feather.common.log.LoggerFactory.LoggerType.ConsoleLoggerType);
    }












/*
    static int access$602(PackDetailLayout packdetaillayout, int i)
    {
        packdetaillayout.mPreviewWidth = i;
        return i;
    }

*/



}
