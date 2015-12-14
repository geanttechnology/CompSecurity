// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.panels;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.util.SparseArrayCompat;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import com.aviary.android.feather.common.tracking.AviaryTracker;
import com.aviary.android.feather.common.utils.ApiHelper;
import com.aviary.android.feather.common.utils.IOUtils;
import com.aviary.android.feather.common.utils.PackageManagerUtils;
import com.aviary.android.feather.common.utils.os.AviaryAsyncTask;
import com.aviary.android.feather.headless.filters.IntensityNativeFilter;
import com.aviary.android.feather.headless.filters.NativeFilter;
import com.aviary.android.feather.headless.moa.MoaResult;
import com.aviary.android.feather.library.content.ToolEntry;
import com.aviary.android.feather.library.filters.BorderFilter;
import com.aviary.android.feather.library.filters.ToolLoaderFactory;
import com.aviary.android.feather.library.services.ConfigService;
import com.aviary.android.feather.library.services.IAviaryController;
import com.aviary.android.feather.library.services.PreferenceService;
import com.aviary.android.feather.library.utils.BitmapUtils;
import com.aviary.android.feather.library.vo.EditToolResultVO;
import com.aviary.android.feather.library.vo.ToolActionVO;
import com.aviary.android.feather.sdk.graphics.PluginDividerDrawable;
import com.aviary.android.feather.sdk.overlays.AviaryOverlay;
import com.aviary.android.feather.sdk.overlays.StickersOverlay;
import com.aviary.android.feather.sdk.widget.EffectThumbLayout;
import com.aviary.android.feather.sdk.widget.IAPDialogMain;
import com.aviary.android.feather.sdk.widget.ImageViewWithIntensity;
import it.sephiroth.android.library.imagezoom.ImageViewTouch;
import it.sephiroth.android.library.picasso.LruCache;
import it.sephiroth.android.library.picasso.Picasso;
import it.sephiroth.android.library.picasso.RequestCreator;
import it.sephiroth.android.library.tooltip.TooltipManager;
import it.sephiroth.android.library.widget.AdapterView;
import it.sephiroth.android.library.widget.HListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.aviary.android.feather.sdk.panels:
//            AbstractContentPanel, AbstractPanelLoaderService

public class BordersPanel extends AbstractContentPanel
    implements android.support.v4.content.Loader.OnLoadCompleteListener, com.aviary.android.feather.sdk.widget.ImageViewWithIntensity.OnIntensityChange, it.sephiroth.android.library.widget.AdapterView.OnItemClickListener, it.sephiroth.android.library.widget.AdapterView.OnItemSelectedListener
{
    class GenerateResultTask extends AviaryAsyncTask
    {

        ProgressDialog mProgress;
        final BordersPanel this$0;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            mLogger.info("GenerateResultTask::doInBackground", new Object[] {
                mIsRendering
            });
            for (; mIsRendering.booleanValue(); mLogger.log("waiting....")) { }
            return null;
        }

        protected volatile void doPostExecute(Object obj)
        {
            doPostExecute((Void)obj);
        }

        protected void doPostExecute(Void void1)
        {
            if (getContext().getBaseActivity().isFinishing())
            {
                return;
            }
            if (mProgress.isShowing())
            {
                mProgress.dismiss();
            }
            onGenerateFinalBitmap();
        }

        protected void doPreExecute()
        {
            mProgress.setTitle(getContext().getBaseContext().getString(com.aviary.android.feather.sdk.R.string.feather_loading_title));
            mProgress.setMessage(getContext().getBaseContext().getString(com.aviary.android.feather.sdk.R.string.feather_effect_loading_message));
            mProgress.setIndeterminate(true);
            mProgress.setCancelable(false);
            mProgress.show();
        }

        GenerateResultTask()
        {
            this$0 = BordersPanel.this;
            super();
            mProgress = new ProgressDialog(getContext().getBaseContext());
        }
    }

    class ListAdapter extends CursorAdapter
    {

        static final int TYPE_DIVIDER = 2;
        static final int TYPE_EXTERNAL = 1;
        static final int TYPE_INVALID = -1;
        static final int TYPE_LEFT_DIVIDER = 3;
        static final int TYPE_LEFT_GETMORE = 5;
        static final int TYPE_NORMAL = 0;
        static final int TYPE_RIGHT_DIVIDER = 4;
        static final int TYPE_RIGHT_GETMORE = 6;
        int mCount;
        int mDefaultResId;
        int mDisplayNameColumnIndex;
        int mDividerResId;
        int mExternalResId;
        int mIdColumnIndex;
        int mIdentifierColumnIndex;
        LayoutInflater mInflater;
        int mIsFreeColumnIndex;
        int mMoreResId;
        int mPackageNameColumnIndex;
        int mPathColumnIndex;
        int mTypeColumnIndex;
        final BordersPanel this$0;

        private void initColumns(Cursor cursor)
        {
            if (cursor != null)
            {
                mIdColumnIndex = cursor.getColumnIndex("_id");
                mPackageNameColumnIndex = cursor.getColumnIndex("packagename");
                mIdentifierColumnIndex = cursor.getColumnIndex("identifier");
                mTypeColumnIndex = cursor.getColumnIndex("type");
                mDisplayNameColumnIndex = cursor.getColumnIndex("displayName");
                mPathColumnIndex = cursor.getColumnIndex("path");
                mIsFreeColumnIndex = cursor.getColumnIndex("isFree");
            }
        }

        private View newView(Context context, Cursor cursor, ViewGroup viewgroup, int i)
        {
            int k = getItemViewType(i);
            k;
            JVM INSTR tableswitch 1 6: default 48
        //                       1 418
        //                       2 397
        //                       3 444
        //                       4 464
        //                       5 191
        //                       6 260;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L5:
            break MISSING_BLOCK_LABEL_464;
_L1:
            context = mInflater.inflate(mDefaultResId, viewgroup, false);
            i = mCellWidth;
_L8:
            context.setLayoutParams(new android.view.ViewGroup.LayoutParams(i, -1));
            int j;
            if (k == 1)
            {
                cursor = new ViewHolderExternal();
            } else
            {
                cursor = new ViewHolder();
            }
            cursor.type = k;
            cursor.image = (ImageView)context.findViewById(com.aviary.android.feather.sdk.R.id.aviary_image);
            cursor.text = (TextView)context.findViewById(com.aviary.android.feather.sdk.R.id.aviary_text);
            if (k != 2 && ((ViewHolder) (cursor)).image != null)
            {
                viewgroup = ((ViewHolder) (cursor)).image.getLayoutParams();
                viewgroup.height = mThumbSize;
                viewgroup.width = mThumbSize;
                ((ViewHolder) (cursor)).image.setLayoutParams(viewgroup);
            }
            context.setTag(cursor);
            return context;
_L6:
            context = mInflater.inflate(mMoreResId, viewgroup, false);
            cursor = (ImageView)context.findViewById(com.aviary.android.feather.sdk.R.id.aviary_image);
            if (mPackType == com.aviary.android.feather.cds.AviaryCds.PackType.EFFECT)
            {
                i = com.aviary.android.feather.sdk.R.drawable.aviary_effect_item_getmore;
            } else
            {
                i = com.aviary.android.feather.sdk.R.drawable.aviary_frame_item_getmore;
            }
            cursor.setImageResource(i);
            i = mCellWidth;
              goto _L8
_L7:
            cursor = mInflater.inflate(mMoreResId, viewgroup, false);
            context = (ImageView)cursor.findViewById(com.aviary.android.feather.sdk.R.id.aviary_image);
            if (mPackType == com.aviary.android.feather.cds.AviaryCds.PackType.EFFECT)
            {
                i = com.aviary.android.feather.sdk.R.drawable.aviary_effect_item_getmore;
            } else
            {
                i = com.aviary.android.feather.sdk.R.drawable.aviary_frame_item_getmore;
            }
            context.setImageResource(i);
            j = mCellWidth;
            i = j;
            context = cursor;
            if (viewgroup.getChildCount() > 0)
            {
                i = j;
                context = cursor;
                if (mHList.getFirstVisiblePosition() == 0)
                {
                    i = j;
                    context = cursor;
                    if (viewgroup.getChildAt(viewgroup.getChildCount() - 1).getRight() < viewgroup.getWidth())
                    {
                        cursor.setVisibility(4);
                        i = 1;
                        context = cursor;
                    }
                }
            }
              goto _L8
_L3:
            context = mInflater.inflate(mDividerResId, viewgroup, false);
            i = -2;
              goto _L8
_L2:
            context = mInflater.inflate(mExternalResId, viewgroup, false);
            i = mCellWidth;
              goto _L8
_L4:
            context = mInflater.inflate(com.aviary.android.feather.sdk.R.layout.aviary_thumb_divider_right, viewgroup, false);
            i = -2;
              goto _L8
            cursor = mInflater.inflate(com.aviary.android.feather.sdk.R.layout.aviary_thumb_divider_left, viewgroup, false);
            j = -2;
            i = j;
            context = cursor;
            if (viewgroup.getChildCount() > 0)
            {
                i = j;
                context = cursor;
                if (mHList.getFirstVisiblePosition() == 0)
                {
                    i = j;
                    context = cursor;
                    if (viewgroup.getChildAt(viewgroup.getChildCount() - 1).getRight() < viewgroup.getWidth())
                    {
                        cursor.setVisibility(4);
                        i = 1;
                        context = cursor;
                    }
                }
            }
              goto _L8
        }

        public void bindView(View view, Context context, Cursor cursor)
        {
        }

        void bindView(View view, Context context, Cursor cursor, int i)
        {
            ViewHolder viewholder;
            long l;
            boolean flag;
            viewholder = (ViewHolder)view.getTag();
            long l1 = -1L;
            l = l1;
            if (!cursor.isAfterLast())
            {
                l = l1;
                if (!cursor.isBeforeFirst())
                {
                    l = cursor.getLong(mIdColumnIndex);
                }
            }
            flag = ((Boolean)mHList.getCheckedItemPositions().get(i, Boolean.valueOf(false))).booleanValue();
            if (viewholder.type != 0) goto _L2; else goto _L1
_L1:
            context = cursor.getString(mDisplayNameColumnIndex);
            String s = cursor.getString(mIdentifierColumnIndex);
            cursor = cursor.getString(mPathColumnIndex);
            viewholder.text.setText(context);
            viewholder.identifier = s;
            if (viewholder.id != l)
            {
                viewholder.image.setImageBitmap(null);
                if (mPackType == com.aviary.android.feather.cds.AviaryCds.PackType.EFFECT)
                {
                    context = (new StringBuilder()).append("aviary_effect://").append(cursor).append("/").append(s).append(".json").toString();
                } else
                {
                    context = cursor;
                    if (!cursor.startsWith("file://"))
                    {
                        context = (new StringBuilder()).append("file://").append(cursor).toString();
                    }
                    context = (new StringBuilder()).append(context).append("/").append(s).append("-small.png").toString();
                }
                mPicassoLibrary.load(Uri.parse(context)).fade(200L).error(com.aviary.android.feather.sdk.R.drawable.aviary_ic_na).withCache(mCache).into(viewholder.image);
            }
            ((EffectThumbLayout)view).setIsOpened(flag);
_L4:
            viewholder.id = l;
            return;
_L2:
            if (viewholder.type == 1)
            {
                view = (ViewHolderExternal)viewholder;
                context = cursor.getString(mIdentifierColumnIndex);
                String s1 = cursor.getString(mDisplayNameColumnIndex);
                String s2 = cursor.getString(mPathColumnIndex);
                i = cursor.getInt(mIsFreeColumnIndex);
                viewholder.text.setText(s1);
                viewholder.identifier = context;
                view.free = i;
                if (viewholder.id != l)
                {
                    mPicassoLibrary.load(s2).transform((new com.aviary.android.feather.sdk.utils.PackIconCallable.Builder()).withResources(getContext().getBaseContext().getResources()).withPackType(mPackType).withPath(s2).build()).error(com.aviary.android.feather.sdk.R.drawable.aviary_ic_na).into(viewholder.image);
                }
            } else
            if (viewholder.type == 2)
            {
                view = viewholder.image.getDrawable();
                context = cursor.getString(mDisplayNameColumnIndex);
                if (view instanceof PluginDividerDrawable)
                {
                    ((PluginDividerDrawable)view).setTitle(context);
                } else
                {
                    view = new PluginDividerDrawable(getContext().getBaseContext(), com.aviary.android.feather.sdk.R.attr.aviaryEffectThumbDividerTextStyle, context);
                    viewholder.image.setImageDrawable(view);
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public int getItemViewType(int i)
        {
            Cursor cursor = (Cursor)getItem(i);
            if (cursor != null)
            {
                return cursor.getInt(mTypeColumnIndex);
            } else
            {
                return -1;
            }
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            if (!mDataValid)
            {
                throw new IllegalStateException("this should only be called when the cursor is valid");
            }
            if (view == null)
            {
                view = newView(mContext, mCursor, viewgroup, i);
            }
            bindView(view, mContext, mCursor, i);
            return view;
        }

        public int getViewTypeCount()
        {
            return 7;
        }

        public boolean hasStableIds()
        {
            return true;
        }

        public View newView(Context context, Cursor cursor, ViewGroup viewgroup)
        {
            return null;
        }

        protected void onContentChanged()
        {
            super.onContentChanged();
        }

        public Cursor swapCursor(Cursor cursor)
        {
            initColumns(cursor);
            return super.swapCursor(cursor);
        }

        public ListAdapter(Context context, int i, int j, int k, int l, Cursor cursor)
        {
            this$0 = BordersPanel.this;
            super(context, cursor, 0);
            mCount = -1;
            initColumns(cursor);
            mInflater = LayoutInflater.from(context);
            mDefaultResId = i;
            mMoreResId = j;
            mExternalResId = k;
            mDividerResId = l;
        }
    }

    protected class RenderTask extends AviaryAsyncTask
        implements android.content.DialogInterface.OnCancelListener
    {

        com.aviary.android.feather.cds.TrayColumns.TrayCursorWrapper currentEffect;
        IntensityNativeFilter filter;
        float intensity;
        String mError;
        MoaResult mMoaMainExecutor;
        int mPosition;
        final BordersPanel this$0;

        private IntensityNativeFilter initFilter(com.aviary.android.feather.cds.TrayColumns.TrayCursorWrapper traycursorwrapper, int i, float f)
        {
            try
            {
                traycursorwrapper = (IntensityNativeFilter)loadNativeFilter(traycursorwrapper, i, true, f);
            }
            // Misplaced declaration of an exception variable
            catch (com.aviary.android.feather.cds.TrayColumns.TrayCursorWrapper traycursorwrapper)
            {
                traycursorwrapper.printStackTrace();
                return null;
            }
            if (traycursorwrapper == null)
            {
                return null;
            }
            if (traycursorwrapper instanceof BorderFilter)
            {
                ((BorderFilter)traycursorwrapper).setHiRes(false);
            }
            try
            {
                mMoaMainExecutor = traycursorwrapper.prepare(mBitmap, mPreview, 1, 1);
            }
            // Misplaced declaration of an exception variable
            catch (com.aviary.android.feather.cds.TrayColumns.TrayCursorWrapper traycursorwrapper)
            {
                traycursorwrapper.printStackTrace();
                mMoaMainExecutor = null;
                return null;
            }
            return traycursorwrapper;
        }

        public transient Bitmap doInBackground(com.aviary.android.feather.cds.TrayColumns.TrayCursorWrapper atraycursorwrapper[])
        {
            if (!isCancelled())
            {
                atraycursorwrapper = atraycursorwrapper[0];
                currentEffect = atraycursorwrapper;
                filter = initFilter(atraycursorwrapper, mPosition, intensity);
                if (filter == null)
                {
                    currentEffect = null;
                    return null;
                }
                mIsRendering = Boolean.valueOf(true);
                if (!isCancelled())
                {
                    try
                    {
                        mMoaMainExecutor.execute();
                    }
                    // Misplaced declaration of an exception variable
                    catch (com.aviary.android.feather.cds.TrayColumns.TrayCursorWrapper atraycursorwrapper[])
                    {
                        mError = atraycursorwrapper.getMessage();
                        atraycursorwrapper.printStackTrace();
                        return null;
                    }
                    if (!isCancelled())
                    {
                        return mMoaMainExecutor.outputBitmap;
                    }
                }
            }
            return null;
        }

        public volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((com.aviary.android.feather.cds.TrayColumns.TrayCursorWrapper[])aobj);
        }

        public void doPostExecute(Bitmap bitmap)
        {
            mFilter = filter;
            mIsAnimating = false;
            if (!isActive())
            {
                return;
            }
            mPreview = bitmap;
            mRenderedEffect = currentEffect;
            if (bitmap == null || mMoaMainExecutor == null || mMoaMainExecutor.active == 0)
            {
                onRestoreOriginalBitmap();
                if (mError != null)
                {
                    onGenericError(mError, 0x104000a, null);
                }
                setIsChanged(false);
            } else
            {
                onApplyNewBitmap(bitmap);
                if (mRenderedEffect != null)
                {
                    bitmap = new HashMap();
                    bitmap.put("pack", mRenderedEffect.getPackageName());
                    bitmap.put("item", mRenderedEffect.getIdentifier());
                    bitmap.put("intensity_adjusted", String.valueOf(mFilter.getIntensity()));
                    getContext().getTracker().tagEventAttributes((new StringBuilder()).append(getName().name().toLowerCase(Locale.US)).append(": item_previewed").toString(), bitmap);
                    bitmap = new ToolActionVO();
                    bitmap.setPackIdentifier(mRenderedEffect.getPackageName());
                    bitmap.setContentIdentifier(mRenderedEffect.getIdentifier());
                    mEditResult.setActionList(mFilter.getActions());
                    mEditResult.setToolAction(bitmap);
                    mTrackingAttributes.put("item", mRenderedEffect.getIdentifier());
                    mTrackingAttributes.put("pack", mRenderedEffect.getPackageName());
                } else
                {
                    mEditResult.setToolAction(null);
                    mEditResult.setActionList(null);
                    mTrackingAttributes.remove("item");
                    mTrackingAttributes.remove("pack");
                }
            }
            if (mPackType != com.aviary.android.feather.cds.AviaryCds.PackType.FRAME)
            {
                onProgressEnd();
            }
            mIsRendering = Boolean.valueOf(false);
            mCurrentTask = null;
        }

        public volatile void doPostExecute(Object obj)
        {
            doPostExecute((Bitmap)obj);
        }

        protected void doPreExecute()
        {
            boolean flag = true;
            if (mPackType != com.aviary.android.feather.cds.AviaryCds.PackType.FRAME)
            {
                onProgressStart();
            }
            mIsAnimating = true;
            ImageViewWithIntensity imageviewwithintensity = (ImageViewWithIntensity)mImageView;
            if (!getIntensityIsManaged() || !getIntensitySliderEnabled())
            {
                flag = false;
            }
            imageviewwithintensity.setSwipeGestureEnabled(flag);
        }

        protected void onApplyNewBitmap(Bitmap bitmap)
        {
            int i;
            boolean flag;
            if (getIntensityIsManaged() || !getIntensitySliderEnabled())
            {
                mImageView.postInvalidate();
            } else
            {
                ((ImageViewWithIntensity)mImageView).setPreviewBitmap(bitmap, 255F);
            }
            ((ImageViewWithIntensity)mImageView).setSwipeGestureEnabled(getIntensitySliderEnabled());
            bitmap = BordersPanel.this;
            if (mRenderedEffect != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            bitmap.setIsChanged(flag);
            bitmap = BordersPanel.this;
            i = ((BordersPanel) (bitmap)).mSliderIntensityTooltip;
            bitmap.mSliderIntensityTooltip = i + 1;
            if (i == 0 && getIntensitySliderEnabled())
            {
                bitmap = (ImageViewWithIntensity)mImageView;
                PointF pointf = bitmap.playDemo();
                mTooltipManager.create(0).actionBarSize(((com.aviary.android.feather.sdk.AviaryMainController.FeatherContext)getContext().getBaseContext()).getActionBarSize()).anchor(new Point((int)((double)pointf.x - (double)bitmap.getTooltipSize() * 1.8500000000000001D), (int)pointf.y + bitmap.getTooltipSize() / 2), it.sephiroth.android.library.tooltip.TooltipManager.Gravity.LEFT).text(getContext().getBaseContext().getResources(), com.aviary.android.feather.sdk.R.string.feather_effect_intensity_tooltip).closePolicy(it.sephiroth.android.library.tooltip.TooltipManager.ClosePolicy.None, 2500L).maxWidth((int)((double)bitmap.getWidth() / 2.5D)).showDelay(100L).withStyleId(com.aviary.android.feather.sdk.R.style.AviaryPanelsTooltip).toggleArrow(false).withCustomView(com.aviary.android.feather.sdk.R.layout.aviary_effect_intensity_tooltip, false).show();
                if (mPreferenceService != null)
                {
                    mPreferenceService.containsSingleTimeKey(getClass(), "intensity.slider.tooltip", true);
                }
            }
        }

        public void onCancel(DialogInterface dialoginterface)
        {
            cancel(true);
        }

        public void onCancelled()
        {
            super.onCancelled();
            if (mMoaMainExecutor != null)
            {
                mMoaMainExecutor.cancel();
            }
            mIsRendering = Boolean.valueOf(false);
        }

        protected void onRestoreOriginalBitmap()
        {
            mLogger.info("onRestoreOriginalBitmap");
            mPreview = BitmapUtils.copy(mBitmap, android.graphics.Bitmap.Config.ARGB_8888);
            if (getIntensitySliderEnabled())
            {
                if (getIntensityIsManaged())
                {
                    mImageView.setImageBitmap(mPreview, null, 1.0F, 1.0F);
                } else
                {
                    ((ImageViewWithIntensity)mImageView).setPreviewBitmap(mPreview, 255F);
                }
                ((ImageViewWithIntensity)mImageView).setIntensity(255F);
                ((ImageViewWithIntensity)mImageView).setSwipeGestureEnabled(false);
            } else
            {
                mImageView.setImageBitmap(mPreview, null, 1.0F, 1.0F);
            }
            setIsChanged(false);
        }

        public RenderTask(int i, float f)
        {
            this$0 = BordersPanel.this;
            super();
            mPosition = i;
            intensity = f;
        }
    }

    static class ViewHolder
    {

        protected long id;
        protected String identifier;
        protected ImageView image;
        protected boolean isNew;
        protected Object obj;
        protected TextView text;
        protected int type;

        ViewHolder()
        {
        }
    }

    static class ViewHolderExternal extends ViewHolder
    {

        protected ImageView externalIcon;
        protected int free;

        ViewHolderExternal()
        {
        }
    }


    public static final double ANCHOR_MAX_WIDTH_RATIO = 2.5D;
    public static final double ANCHOR_X_OFFSET = 1.8500000000000001D;
    private static final int MAX_MEM_CACHE_SIZE = 0x600000;
    private static android.graphics.BitmapFactory.Options mThumbnailOptions;
    protected CursorAdapter mAdapter;
    private LruCache mCache;
    private int mCellWidth;
    protected ConfigService mConfigService;
    protected ContentObserver mContentObserver;
    private RenderTask mCurrentTask;
    protected CursorLoader mCursorLoader;
    protected boolean mEnableFastPreview;
    protected IntensityNativeFilter mFilter;
    private boolean mFirstTime;
    protected HListView mHList;
    protected IAPDialogMain mIapDialog;
    protected final float mInitialIntensityValue;
    private final List mInstalledPacks;
    private volatile boolean mIsAnimating;
    protected volatile Boolean mIsRendering;
    protected int mListFirstValidPosition;
    protected View mLoader;
    StickersOverlay mOverlay;
    private final com.aviary.android.feather.cds.AviaryCds.PackType mPackType;
    protected Picasso mPicassoLibrary;
    protected PreferenceService mPreferenceService;
    protected com.aviary.android.feather.cds.TrayColumns.TrayCursorWrapper mRenderedEffect;
    protected int mSliderIntensityTooltip;
    protected int mThumbSize;
    protected TooltipManager mTooltipManager;

    public BordersPanel(IAviaryController iaviarycontroller, ToolEntry toolentry)
    {
        this(iaviarycontroller, toolentry, com.aviary.android.feather.cds.AviaryCds.PackType.FRAME);
    }

    protected BordersPanel(IAviaryController iaviarycontroller, ToolEntry toolentry, com.aviary.android.feather.cds.AviaryCds.PackType packtype)
    {
        super(iaviarycontroller, toolentry);
        mIsRendering = Boolean.valueOf(false);
        mCellWidth = 80;
        mListFirstValidPosition = 0;
        mFirstTime = true;
        mEnableFastPreview = false;
        mInitialIntensityValue = 255F;
        mInstalledPacks = new ArrayList();
        mSliderIntensityTooltip = 0;
        mPackType = packtype;
    }

    private void applyEffect(final int position, long l)
    {
        if (!isActive() || getHandler() == null)
        {
            return;
        } else
        {
            getHandler().postDelayed(new Runnable() {

                final BordersPanel this$0;
                final int val$position;

                public void run()
                {
                    if (isActive() && mAdapter != null && mHList != null)
                    {
                        mHList.clearChoices();
                        if (position >= mHList.getFirstVisiblePosition() && position < mHList.getLastVisiblePosition() && position < mAdapter.getCount())
                        {
                            View view = mHList.getChildAt(position - mHList.getFirstVisiblePosition());
                            if (view != null && (view instanceof EffectThumbLayout))
                            {
                                mHList.performItemClick(view, position, mAdapter.getItemId(position));
                                return;
                            }
                        }
                    }
                }

            
            {
                this$0 = BordersPanel.this;
                position = i;
                super();
            }
            }, l);
            return;
        }
    }

    private void createTutorialOverlayIfNecessary(final int firstValidIndex)
    {
        mLogger.info("createTutorialOverlayIfNecessary: %d", new Object[] {
            Integer.valueOf(firstValidIndex)
        });
        while (!isActive() || getHandler() == null) 
        {
            return;
        }
        getHandler().postDelayed(new Runnable() {

            final BordersPanel this$0;
            final int val$firstValidIndex;

            public void run()
            {
                if (firstValidIndex < 0)
                {
                    createTutorialOverlayIfNecessaryDelayed(firstValidIndex);
                }
            }

            
            {
                this$0 = BordersPanel.this;
                firstValidIndex = i;
                super();
            }
        }, 200L);
    }

    private boolean createTutorialOverlayIfNecessaryDelayed(int i)
    {
        mLogger.info("createTutorialOverlayIfNecessaryDelayed: %d", new Object[] {
            Integer.valueOf(i)
        });
        if (!isActive())
        {
            return false;
        }
        boolean flag4 = true;
        int l = mHList.getChildCount();
        int j = -1;
        ImageView imageview = null;
        boolean flag2 = false;
        i = 0;
label0:
        do
        {
label1:
            {
                ImageView imageview1;
                Object obj;
                boolean flag3;
                int k;
label2:
                {
                    boolean flag = flag4;
                    if (i < l)
                    {
                        obj = mHList.getChildAt(i);
                        flag3 = flag2;
                        k = j;
                        imageview1 = imageview;
                        if (obj == null)
                        {
                            break label1;
                        }
                        obj = ((View) (obj)).getTag();
                        flag3 = flag2;
                        k = j;
                        imageview1 = imageview;
                        if (obj == null)
                        {
                            break label1;
                        }
                        flag3 = flag2;
                        k = j;
                        imageview1 = imageview;
                        if (!(obj instanceof ViewHolder))
                        {
                            break label1;
                        }
                        obj = (ViewHolder)obj;
                        if (((ViewHolder) (obj)).type != 0)
                        {
                            break label2;
                        }
                        flag = false;
                    }
                    if (!flag2 || j <= -1 || imageview == null)
                    {
                        flag = false;
                    }
                    if (!flag)
                    {
                        if (mOverlay != null)
                        {
                            mOverlay.hide();
                        }
                        return false;
                    }
                    break label0;
                }
                flag3 = flag2;
                k = j;
                imageview1 = imageview;
                if (((ViewHolder) (obj)).type == 1)
                {
                    obj = (ViewHolderExternal)obj;
                    boolean flag1;
                    if (((ViewHolderExternal) (obj)).free == 1)
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    flag3 = flag1;
                    k = j;
                    imageview1 = imageview;
                    if (flag1)
                    {
                        k = i;
                        imageview1 = ((ViewHolderExternal) (obj)).image;
                        flag3 = flag1;
                    }
                }
            }
            i++;
            flag2 = flag3;
            j = k;
            imageview = imageview1;
        } while (true);
        mLogger.log("free item index: %d", new Object[] {
            Integer.valueOf(j)
        });
        if (mOverlay == null)
        {
            if (AviaryOverlay.shouldShow(getContext(), getTutorialOverlayId()))
            {
                mOverlay = createTutorialOverlay(imageview);
                return mOverlay.show();
            }
        } else
        {
            mOverlay.update(imageview);
        }
        return false;
    }

    private void displayIAPDialog(com.aviary.android.feather.sdk.widget.IAPDialogMain.IAPUpdater iapupdater)
    {
        if (mIapDialog != null)
        {
            if (mIapDialog.isValid())
            {
                mIapDialog.update(iapupdater);
                setApplyEnabled(false);
                return;
            }
            mIapDialog.dismiss(false);
            mIapDialog = null;
        }
        iapupdater = IAPDialogMain.create((com.aviary.android.feather.sdk.AviaryMainController.FeatherContext)getContext().getBaseContext(), iapupdater);
        if (iapupdater != null)
        {
            iapupdater.setOnCloseListener(new com.aviary.android.feather.sdk.widget.IAPDialogMain.OnCloseListener() {

                final BordersPanel this$0;

                public void onClose()
                {
                    removeIapDialog();
                }

            
            {
                this$0 = BordersPanel.this;
                super();
            }
            });
        }
        mIapDialog = iapupdater;
        setApplyEnabled(false);
    }

    private void onEffectListUpdated(Cursor cursor, int i, boolean flag, boolean flag1, boolean flag2)
    {
        if (i <= 0)
        {
            i = 0;
        }
        if (mFirstTime)
        {
            mLoader.setVisibility(4);
            mHList.setVisibility(0);
        }
        if ((mFirstTime || flag) && i > 0)
        {
            if (flag2)
            {
                applyEffect(i, 500L);
            }
            if (flag1)
            {
                mHList.smoothScrollToPositionFromLeft(i - 1, mCellWidth / 2, 500);
            } else
            {
                mHList.setSelectionFromLeft(i - 1, mCellWidth / 2);
            }
        }
        if (mFirstTime)
        {
            cursor = new AlphaAnimation(0.0F, 1.0F);
            cursor.setFillAfter(true);
            cursor.setDuration(getContext().getBaseContext().getResources().getInteger(0x10e0002));
            mHList.startAnimation(cursor);
        }
        mFirstTime = false;
    }

    private boolean openStorePanelIfRequired(long l)
    {
        long l1;
        boolean flag1;
        flag1 = false;
        mLogger.info("openStorePanelIfRequired: %d", new Object[] {
            Long.valueOf(l)
        });
        l1 = -1L;
        if (hasOption("quick-packId")) goto _L2; else goto _L1
_L1:
        boolean flag = flag1;
        if (l <= -1L) goto _L3; else goto _L2
_L2:
        if (l <= -1L) goto _L5; else goto _L4
_L4:
        l1 = l;
_L7:
        mLogger.log("iapPackageId: %d", new Object[] {
            Long.valueOf(l)
        });
        flag = flag1;
        if (l1 > -1L)
        {
            displayIAPDialog((new com.aviary.android.feather.sdk.widget.IAPDialogMain.IAPUpdater.Builder()).setPackId(l1).setFeaturedPackId(l1).setEvent("shop_details: opened").setPackType(mPackType).addEventAttributes("pack", String.valueOf(l1)).addEventAttributes("from", "message").build());
            flag = true;
        }
_L3:
        return flag;
_L5:
        if (hasOption("quick-packId"))
        {
            Bundle bundle = getOptions();
            l1 = bundle.getLong("quick-packId");
            bundle.remove("quick-packId");
        }
        if (true) goto _L7; else goto _L6
_L6:
    }

    private boolean removeIapDialog()
    {
        setApplyEnabled(true);
        if (mIapDialog != null)
        {
            mIapDialog.dismiss(true);
            mIapDialog = null;
            return true;
        } else
        {
            return false;
        }
    }

    boolean backHandled()
    {
        if (!mIsAnimating) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (mIapDialog == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (mIapDialog.onBackPressed()) goto _L1; else goto _L3
_L3:
        removeIapDialog();
        return true;
        if (mOverlay != null && mOverlay.onBackPressed()) goto _L1; else goto _L4
_L4:
        killCurrentTask();
        return false;
    }

    protected CursorAdapter createListAdapter(Context context, Cursor cursor)
    {
        return new ListAdapter(context, com.aviary.android.feather.sdk.R.layout.aviary_frame_item, com.aviary.android.feather.sdk.R.layout.aviary_effect_item_more, com.aviary.android.feather.sdk.R.layout.aviary_effect_item_external, com.aviary.android.feather.sdk.R.layout.aviary_frame_item_divider, cursor);
    }

    protected RenderTask createRenderTask(int i, float f)
    {
        return new RenderTask(i, f);
    }

    protected StickersOverlay createTutorialOverlay(View view)
    {
        view = new StickersOverlay(getContext().getBaseActivity(), com.aviary.android.feather.sdk.R.style.AviaryWidget_Overlay_Frames, view, getName(), getTutorialOverlayId());
        view.setTitle(AbstractPanelLoaderService.getToolDisplayName(getName()));
        return view;
    }

    protected View generateContentView(LayoutInflater layoutinflater)
    {
        return layoutinflater.inflate(com.aviary.android.feather.sdk.R.layout.aviary_content_frames, null);
    }

    protected ViewGroup generateOptionView(LayoutInflater layoutinflater, ViewGroup viewgroup)
    {
        return (ViewGroup)layoutinflater.inflate(com.aviary.android.feather.sdk.R.layout.aviary_panel_frames, viewgroup, false);
    }

    protected boolean getIntensityIsManaged()
    {
        return true;
    }

    protected boolean getIntensitySliderEnabled()
    {
        return false;
    }

    public boolean getIsChanged()
    {
        return super.getIsChanged() || mIsRendering.booleanValue();
    }

    protected CharSequence[] getOptionalEffectsLabels()
    {
        if (mConfigService != null)
        {
            return (new CharSequence[] {
                mConfigService.getString(com.aviary.android.feather.sdk.R.string.feather_original)
            });
        } else
        {
            return (new CharSequence[] {
                "Original"
            });
        }
    }

    protected final com.aviary.android.feather.cds.AviaryCds.PackType getPluginType()
    {
        return mPackType;
    }

    protected int getTutorialOverlayId()
    {
        return 3;
    }

    protected boolean isContentTutorialNeeded()
    {
        return false;
    }

    public boolean isRendering()
    {
        return mIsRendering.booleanValue();
    }

    boolean killCurrentTask()
    {
        if (mCurrentTask != null)
        {
            if (mPackType != com.aviary.android.feather.cds.AviaryCds.PackType.FRAME)
            {
                onProgressEnd();
            }
            return mCurrentTask.cancel(true);
        } else
        {
            return false;
        }
    }

    protected NativeFilter loadNativeFilter(com.aviary.android.feather.cds.TrayColumns.TrayCursorWrapper traycursorwrapper, int i, boolean flag, float f)
        throws JSONException
    {
        double d;
        Cursor cursor;
        BorderFilter borderfilter;
        if (traycursorwrapper == null || i <= -1)
        {
            break MISSING_BLOCK_LABEL_199;
        }
        borderfilter = (BorderFilter)ToolLoaderFactory.get(com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.FRAMES);
        cursor = getContext().getBaseContext().getContentResolver().query(PackageManagerUtils.getCDSProviderContentUri(getContext().getBaseContext(), (new StringBuilder()).append("pack/content/item/").append(traycursorwrapper.getId()).toString()), null, null, null, null);
        double d1 = 0.0D;
        d = d1;
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_141;
        }
        d = d1;
        if (cursor.moveToFirst())
        {
            d = (new JSONObject(new String(cursor.getBlob(cursor.getColumnIndex("item_options"))))).getDouble("width");
        }
        IOUtils.closeSilently(cursor);
        borderfilter.setHiRes(flag);
        borderfilter.setSize(d);
        borderfilter.setIdentifier(traycursorwrapper.getIdentifier());
        borderfilter.setSourceDir(traycursorwrapper.getPath());
        borderfilter.setIntensity(f / 255F);
        return borderfilter;
        traycursorwrapper;
        IOUtils.closeSilently(cursor);
        throw traycursorwrapper;
        return null;
    }

    public void onActivate()
    {
        super.onActivate();
        onSetupImageView();
        onAddCustomRequestHandlers();
        mHList.setOnItemClickListener(this);
        onPostActivate();
        contentReady();
    }

    protected void onAddCustomRequestHandlers()
    {
    }

    public boolean onBackPressed()
    {
        if (backHandled())
        {
            return true;
        } else
        {
            return super.onBackPressed();
        }
    }

    public void onBitmapReplaced(Bitmap bitmap)
    {
        super.onBitmapReplaced(bitmap);
        if (isActive())
        {
            mLogger.error("TODO: BordersPanel check this");
            mHList.setSelection(mListFirstValidPosition);
        }
    }

    public void onCancelled()
    {
        killCurrentTask();
        mIsRendering = Boolean.valueOf(false);
        super.onCancelled();
    }

    public void onConfigurationChanged(Configuration configuration, Configuration configuration1)
    {
        if (mIapDialog != null)
        {
            mIapDialog.onConfigurationChanged(configuration);
        }
        if (getIntensitySliderEnabled())
        {
            ((ImageViewWithIntensity)mImageView).finishIntensityChanging();
        }
        super.onConfigurationChanged(configuration, configuration1);
    }

    public void onCreate(Bitmap bitmap, Bundle bundle)
    {
        super.onCreate(bitmap, bundle);
        mPicassoLibrary = Picasso.with(getContext().getBaseContext());
        mInstalledPacks.clear();
        bitmap = new double[3];
        com.aviary.android.feather.common.utils.SystemUtils.MemoryInfo.getRuntimeMemory(bitmap);
        int i = (int)(1048576D * Math.max(bitmap[0], 2D));
        mLogger.log((new StringBuilder()).append("max size for cache: ").append(i).toString());
        mCache = new LruCache(Math.min(i, 0x600000));
        mThumbnailOptions = new android.graphics.BitmapFactory.Options();
        mThumbnailOptions.inPreferredConfig = android.graphics.Bitmap.Config.RGB_565;
        mConfigService = (ConfigService)getContext().getService(com/aviary/android/feather/library/services/ConfigService);
        mPreferenceService = (PreferenceService)getContext().getService(com/aviary/android/feather/library/services/PreferenceService);
        mTooltipManager = TooltipManager.getInstance(getContext().getBaseActivity());
        mEnableFastPreview = ApiHelper.fastPreviewEnabled();
        mHList = (HListView)getOptionView().findViewById(com.aviary.android.feather.sdk.R.id.aviary_list);
        mLoader = getOptionView().findViewById(com.aviary.android.feather.sdk.R.id.aviary_loader);
        mCellWidth = mConfigService.getDimensionPixelSize(com.aviary.android.feather.sdk.R.dimen.aviary_frame_item_width);
        mThumbSize = mConfigService.getDimensionPixelSize(com.aviary.android.feather.sdk.R.dimen.aviary_frame_item_image_width);
        mPreview = BitmapUtils.copy(mBitmap, android.graphics.Bitmap.Config.ARGB_8888);
        mImageView = (ImageViewTouch)getContentView().findViewById(com.aviary.android.feather.sdk.R.id.aviary_image);
        mImageView.setDisplayType(it.sephiroth.android.library.imagezoom.ImageViewTouchBase.DisplayType.FIT_TO_SCREEN);
        if (getIntensitySliderEnabled())
        {
            ((ImageViewWithIntensity)mImageView).setVaryTipStroke(false);
            ((ImageViewWithIntensity)mImageView).setVaryTipHue(true);
        }
        if (mPreferenceService != null && !mPreferenceService.containsSingleTimeKey(getClass(), "intensity.slider.tooltip", false))
        {
            mSliderIntensityTooltip = 0;
            return;
        } else
        {
            mSliderIntensityTooltip = 1;
            return;
        }
    }

    public void onDeactivate()
    {
        if (mPackType != com.aviary.android.feather.cds.AviaryCds.PackType.FRAME)
        {
            onProgressEnd();
        }
        mHList.setOnItemClickListener(null);
        mHList.setAdapter(null);
        mHList.setOnScrollListener(null);
        removeIapDialog();
        if (mOverlay != null)
        {
            mOverlay.dismiss();
            mOverlay = null;
        }
        if (getIntensitySliderEnabled())
        {
            ((ImageViewWithIntensity)mImageView).setOnIntensityChangeListener(null);
        }
        getContext().getBaseContext().getContentResolver().unregisterContentObserver(mContentObserver);
        if (mCursorLoader != null)
        {
            mCursorLoader.unregisterListener(this);
            mCursorLoader.stopLoading();
            mCursorLoader.abandon();
            mCursorLoader.reset();
        }
        if (mAdapter != null)
        {
            IOUtils.closeSilently(mAdapter.getCursor());
        }
        mAdapter = null;
        mCursorLoader = null;
        super.onDeactivate();
    }

    public void onDestroy()
    {
        mConfigService = null;
        if (getIntensitySliderEnabled())
        {
            ((ImageViewWithIntensity)mImageView).setPreviewBitmap(null, 255F);
        }
        try
        {
            mCache.clear();
        }
        catch (Exception exception) { }
        super.onDestroy();
    }

    protected void onDispose()
    {
        mHList.setAdapter(null);
        onRemoveCustomRequestHandlers();
        super.onDispose();
    }

    protected void onGenerateFinalBitmap()
    {
        if (getIntensitySliderEnabled() && !getIntensityIsManaged())
        {
            float f = ((ImageViewWithIntensity)mImageView).getIntensity();
            Bitmap bitmap;
            if (mFilter != null)
            {
                if (f < 255F)
                {
                    mFilter.setIntensity(f / 255F);
                } else
                {
                    mFilter.setIntensity(1.0D);
                }
            }
            if (f == 255F)
            {
                bitmap = mPreview;
            } else
            if (f == 0.0F)
            {
                bitmap = mBitmap;
            } else
            {
                Bitmap bitmap1 = mBitmap;
                bitmap = bitmap1;
                if (!bitmap1.isMutable())
                {
                    bitmap = mBitmap.copy(mBitmap.getConfig(), true);
                }
                ((ImageViewWithIntensity)mImageView).generateBitmap(bitmap, f);
            }
            onComplete(bitmap);
            return;
        } else
        {
            onComplete(mPreview);
            return;
        }
    }

    protected void onGenerateResult()
    {
        mLogger.info((new StringBuilder()).append("onGenerateResult. isRendering: ").append(mIsRendering).toString());
        if (mIsRendering.booleanValue())
        {
            (new GenerateResultTask()).execute(new Void[0]);
            return;
        } else
        {
            onGenerateFinalBitmap();
            return;
        }
    }

    public void onIntensityInit()
    {
        if (mRenderedEffect != null)
        {
            AviaryTracker.getInstance(getContext().getBaseContext()).tagEvent((new StringBuilder()).append(getName().name().toLowerCase(Locale.US)).append(": intensity_initiated").toString(), new String[] {
                "pack", mRenderedEffect.getPackageName(), "item", mRenderedEffect.getIdentifier()
            });
        }
    }

    public void onIntensitySwipeChanged(float f)
    {
        if (mPackType == com.aviary.android.feather.cds.AviaryCds.PackType.FRAME)
        {
            SparseArrayCompat sparsearraycompat = mHList.getCheckedItemPositions();
            if (sparsearraycompat != null && sparsearraycompat.size() > 0)
            {
                for (int i = 0; i < sparsearraycompat.size(); i++)
                {
                    int j = sparsearraycompat.keyAt(i);
                    if (((Boolean)sparsearraycompat.get(j)).booleanValue())
                    {
                        renderEffect(j, f);
                    }
                }

            }
        }
    }

    public void onIntensitySwipeChanging(float f)
    {
        if (getIntensityIsManaged())
        {
            onIntensitySwipeChanged(f);
        }
    }

    public void onIntensitySwipeStarted(float f)
    {
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        mLogger.info((new StringBuilder()).append("onItemClick: ").append(i).toString());
        if (mOverlay != null)
        {
            mOverlay.hide();
        }
        int j = mHList.getCheckedItemCount();
        SparseArrayCompat sparsearraycompat = mHList.getCheckedItemPositions().clone();
        sparsearraycompat.remove(i);
        if (isActive())
        {
            adapterview = (ViewHolder)view.getTag();
            if (adapterview != null)
            {
                boolean flag;
                if (((ViewHolder) (adapterview)).type == 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (((ViewHolder) (adapterview)).type == 5 || ((ViewHolder) (adapterview)).type == 6)
                {
                    if (((ViewHolder) (adapterview)).type == 6)
                    {
                        adapterview = "right";
                    } else
                    {
                        adapterview = "left";
                    }
                    displayIAPDialog((new com.aviary.android.feather.sdk.widget.IAPDialogMain.IAPUpdater.Builder()).setPackType(mPackType).setEvent("shop_list: opened").setFeaturedPackId(-1L).addEventAttributes("from", getName().name().toLowerCase(Locale.US)).addEventAttributes("side", adapterview).build());
                } else
                if (((ViewHolder) (adapterview)).type == 1)
                {
                    Bundle bundle = new Bundle();
                    bundle.putInt("click_from_position", i);
                    displayIAPDialog((new com.aviary.android.feather.sdk.widget.IAPDialogMain.IAPUpdater.Builder()).setPackId(((ViewHolder) (adapterview)).id).setPackType(mPackType).setFeaturedPackId(((ViewHolder) (adapterview)).id).setEvent("shop_details: opened").addEventAttributes("pack", ((ViewHolder) (adapterview)).identifier).addEventAttributes("from", "featured").setExtras(bundle).build());
                } else
                if (((ViewHolder) (adapterview)).type == 0)
                {
                    removeIapDialog();
                    mLogger.log("checkedItemsCount: %d", new Object[] {
                        Integer.valueOf(j)
                    });
                    if (j > 0)
                    {
                        renderEffect(i, 255F);
                    } else
                    {
                        renderEffect(null, -1, 255F);
                    }
                }
                if (flag)
                {
                    adapterview = (EffectThumbLayout)view;
                    if (adapterview.isChecked())
                    {
                        adapterview.open();
                    } else
                    {
                        adapterview.close();
                    }
                } else
                {
                    mHList.setItemChecked(i, false);
                }
                if (sparsearraycompat.size() > 0 && flag)
                {
                    mHList.setItemChecked(sparsearraycompat.keyAt(0), false);
                }
            }
        }
    }

    public void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
    }

    public void onLoadComplete(Loader loader, Cursor cursor)
    {
        mLogger.info("onLoadComplete");
        long l1 = -1L;
        byte byte1 = -1;
        byte byte0 = -1;
        long l4 = -1L;
        long l5 = -1L;
        boolean flag2 = false;
        boolean flag4 = false;
        boolean flag5 = false;
        int i;
        int j;
        int k;
        boolean flag;
        int i1;
        boolean flag1;
        long l2;
        long l3;
        boolean flag3;
        boolean flag6;
        if (!mFirstTime && mIapDialog != null && mIapDialog.isValid() && mIapDialog.getParent() != null && mIapDialog.getData() != null)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        k = 0;
        i1 = 0;
        flag1 = false;
        flag3 = false;
        flag6 = false;
        l2 = l1;
        if (i != 0)
        {
            loader = mIapDialog.getData();
            l2 = l1;
            if (loader.getFeaturedPackId() == loader.getPackId())
            {
                l2 = l1;
                if (loader.getFeaturedPackId() > -1L)
                {
                    l2 = loader.getFeaturedPackId();
                }
            }
        }
        if (l2 > -1L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        j = k;
        l3 = l5;
        l1 = l4;
        if (hasOptions())
        {
            j = k;
            l3 = l5;
            l1 = l4;
            if (mFirstTime)
            {
                j = k;
                l3 = l5;
                l1 = l4;
                if (!flag)
                {
                    loader = getOptions();
                    l1 = loader.getLong("quick-packId", -1L);
                    l3 = loader.getLong("quick-contentId", -1L);
                    String s;
                    if (l1 > -1L && l3 > -1L)
                    {
                        j = 1;
                    } else
                    {
                        j = 0;
                    }
                    loader.remove("quick-packId");
                    loader.remove("quick-contentId");
                }
            }
        }
        loader = new ArrayList();
        k = byte0;
        i = byte1;
        l4 = l1;
        if (cursor != null)
        {
            i1 = cursor.getPosition();
            k = ((flag1) ? 1 : 0);
            i = byte1;
            byte1 = j;
            flag3 = flag6;
            flag2 = flag4;
            j = byte0;
            do
            {
                if (!cursor.moveToNext())
                {
                    break;
                }
                int l = cursor.getInt(4);
                if (l == 2)
                {
                    l4 = cursor.getLong(0);
                    s = cursor.getString(3);
                    loader.add(Long.valueOf(l4));
                    flag4 = flag2;
                    l = i;
                    if (!mFirstTime)
                    {
                        flag4 = flag2;
                        l = i;
                        if (!mInstalledPacks.contains(Long.valueOf(l4)))
                        {
                            mLogger.log("adding %d (%s) to new packs", new Object[] {
                                Long.valueOf(l4), s
                            });
                            mLogger.log("iapDialogFeaturedId: %d, pack_id: %d", new Object[] {
                                Long.valueOf(l2), Long.valueOf(l4)
                            });
                            flag4 = flag2;
                            l = i;
                            if (flag)
                            {
                                flag4 = flag2;
                                l = i;
                                if (l2 == l4)
                                {
                                    mLogger.log("setting new position based on featured: %d", new Object[] {
                                        Long.valueOf(l4)
                                    });
                                    l = cursor.getPosition();
                                    flag4 = true;
                                }
                            }
                        }
                    }
                    flag2 = flag4;
                    i = l;
                    if (j == -1)
                    {
                        j = cursor.getPosition();
                        flag2 = flag4;
                        i = l;
                    }
                } else
                if (l == 0 && byte1 && l3 == cursor.getLong(0))
                {
                    i = cursor.getPosition();
                    byte1 = 0;
                    k = 1;
                    flag3 = true;
                    l1 = -1L;
                }
            } while (true);
            cursor.moveToPosition(i1);
            l4 = l1;
            i1 = k;
            k = j;
        }
        mInstalledPacks.clear();
        mInstalledPacks.addAll(loader);
        mAdapter.changeCursor(cursor);
        mLogger.log("lastInstalledPackIndex: %d", new Object[] {
            Integer.valueOf(i)
        });
        flag4 = flag5;
        if (i >= 0)
        {
            flag4 = true;
            removeIapDialog();
            k = i;
        }
        onEffectListUpdated(cursor, k, flag4, flag2, flag3);
        while (openStorePanelIfRequired(l4) || i1 != 0 || !isContentTutorialNeeded()) 
        {
            return;
        }
        createTutorialOverlayIfNecessary(k);
    }

    public volatile void onLoadComplete(Loader loader, Object obj)
    {
        onLoadComplete(loader, (Cursor)obj);
    }

    public void onNothingSelected(AdapterView adapterview)
    {
    }

    protected void onPostActivate()
    {
        updateInstalledPacks(true);
    }

    protected void onRemoveCustomRequestHandlers()
    {
    }

    protected void onSetupImageView()
    {
        if (getIntensitySliderEnabled())
        {
            ((ImageViewWithIntensity)mImageView).setOnIntensityChangeListener(this);
            if (getIntensityIsManaged())
            {
                mImageView.setImageBitmap(mPreview, null, 1.0F, 1.0F);
                ((ImageViewWithIntensity)mImageView).setIntensity(255F);
            } else
            {
                mImageView.setImageBitmap(mBitmap, null, 1.0F, 1.0F);
                ((ImageViewWithIntensity)mImageView).setPreviewBitmap(mPreview, 255F);
            }
        } else
        {
            ((ImageViewWithIntensity)mImageView).setSwipeGestureEnabled(false);
            mImageView.setImageBitmap(mPreview, null, 1.0F, 1.0F);
        }
        mHList.setOnItemClickListener(this);
        onPostActivate();
        contentReady();
    }

    protected void renderEffect(int i, float f)
    {
        if (mAdapter != null && i >= 0 && i < mAdapter.getCount())
        {
            Object obj = (Cursor)mAdapter.getItem(i);
            if (obj != null)
            {
                obj = com.aviary.android.feather.cds.TrayColumns.TrayCursorWrapper.create(((Cursor) (obj)));
                if (obj != null)
                {
                    renderEffect(((com.aviary.android.feather.cds.TrayColumns.TrayCursorWrapper) (obj)), i, f);
                    return;
                }
            }
        }
    }

    protected void renderEffect(com.aviary.android.feather.cds.TrayColumns.TrayCursorWrapper traycursorwrapper, int i, float f)
    {
        killCurrentTask();
        mCurrentTask = createRenderTask(i, f);
        mCurrentTask.execute(new com.aviary.android.feather.cds.TrayColumns.TrayCursorWrapper[] {
            traycursorwrapper
        });
    }

    public volatile void setEnabled(boolean flag)
    {
        super.setEnabled(flag);
    }

    protected void updateInstalledPacks(boolean flag)
    {
        mLoader.setVisibility(0);
        mHList.setVisibility(4);
        mAdapter = createListAdapter(getContext().getBaseContext(), null);
        mHList.setAdapter(mAdapter);
        Context context = getContext().getBaseContext();
        if (mCursorLoader == null)
        {
            mCursorLoader = new CursorLoader(context, PackageManagerUtils.getCDSProviderContentUri(context, String.format(Locale.US, "packTray/%d/%d/%d/%s", new Object[] {
                Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), mPackType.toCdsString()
            })), null, null, null, null);
            mCursorLoader.registerListener(1, this);
            mContentObserver = new ContentObserver(new Handler()) {

                final BordersPanel this$0;

                public void onChange(boolean flag1)
                {
                    mLogger.info("mContentObserver::onChange");
                    super.onChange(flag1);
                    if (isActive() && mCursorLoader != null && mCursorLoader.isStarted())
                    {
                        mCursorLoader.onContentChanged();
                    }
                }

            
            {
                this$0 = BordersPanel.this;
                super(handler);
            }
            };
            context.getContentResolver().registerContentObserver(PackageManagerUtils.getCDSProviderContentUri(context, (new StringBuilder()).append("packTray/").append(mPackType.toCdsString()).toString()), false, mContentObserver);
        }
        mCursorLoader.startLoading();
    }







/*
    static boolean access$502(BordersPanel borderspanel, boolean flag)
    {
        borderspanel.mIsAnimating = flag;
        return flag;
    }

*/


/*
    static RenderTask access$602(BordersPanel borderspanel, RenderTask rendertask)
    {
        borderspanel.mCurrentTask = rendertask;
        return rendertask;
    }

*/
}
