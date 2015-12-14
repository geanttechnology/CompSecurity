// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.panels;

import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.CursorAdapter;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import com.aviary.android.feather.cds.AviaryCds;
import com.aviary.android.feather.cds.CdsUtils;
import com.aviary.android.feather.common.tracking.AviaryTracker;
import com.aviary.android.feather.common.utils.ApiHelper;
import com.aviary.android.feather.common.utils.IOUtils;
import com.aviary.android.feather.common.utils.PackageManagerUtils;
import com.aviary.android.feather.headless.moa.MoaActionFactory;
import com.aviary.android.feather.headless.moa.MoaActionList;
import com.aviary.android.feather.library.content.ToolEntry;
import com.aviary.android.feather.library.filters.StickerFilter;
import com.aviary.android.feather.library.graphics.drawable.FeatherDrawable;
import com.aviary.android.feather.library.graphics.drawable.StickerDrawable;
import com.aviary.android.feather.library.services.ConfigService;
import com.aviary.android.feather.library.services.DragController;
import com.aviary.android.feather.library.services.DragControllerService;
import com.aviary.android.feather.library.services.IAviaryController;
import com.aviary.android.feather.library.services.PreferenceService;
import com.aviary.android.feather.library.services.drag.DragView;
import com.aviary.android.feather.library.services.drag.DropTarget;
import com.aviary.android.feather.library.utils.BitmapUtils;
import com.aviary.android.feather.library.utils.MatrixUtils;
import com.aviary.android.feather.library.vo.EditToolResultVO;
import com.aviary.android.feather.library.vo.ToolActionVO;
import com.aviary.android.feather.sdk.FeatherActivity;
import com.aviary.android.feather.sdk.overlays.AviaryOverlay;
import com.aviary.android.feather.sdk.overlays.StickersOverlay;
import com.aviary.android.feather.sdk.utils.Maturity;
import com.aviary.android.feather.sdk.widget.DrawableHighlightView;
import com.aviary.android.feather.sdk.widget.IAPDialogMain;
import com.aviary.android.feather.sdk.widget.ImageViewDrawableOverlay;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.view.ViewHelper;
import it.sephiroth.android.library.imagezoom.ImageViewTouch;
import it.sephiroth.android.library.picasso.Callback;
import it.sephiroth.android.library.picasso.Picasso;
import it.sephiroth.android.library.picasso.RequestCreator;
import it.sephiroth.android.library.tooltip.TooltipManager;
import it.sephiroth.android.library.widget.AdapterView;
import it.sephiroth.android.library.widget.HListView;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import junit.framework.Assert;

// Referenced classes of package com.aviary.android.feather.sdk.panels:
//            AbstractContentPanel, SimpleStatusMachine

public class StickersPanel extends AbstractContentPanel
    implements android.support.v4.content.Loader.OnLoadCompleteListener, com.aviary.android.feather.library.services.DragControllerService.DragListener, com.aviary.android.feather.library.services.DragControllerService.DragSource, com.aviary.android.feather.library.services.drag.DropTarget.DropTargetListener, SimpleStatusMachine.OnStatusChangeListener, it.sephiroth.android.library.widget.AdapterView.OnItemClickListener
{
    static class StickerDragInfo
    {

        String contentPath;
        String identifier;
        float scaleFactor;

        StickerDragInfo(String s, String s1, float f)
        {
            contentPath = s;
            identifier = s1;
            scaleFactor = f;
        }
    }

    static class StickerPackInfo
    {

        long packId;
        String packIdentifier;

        StickerPackInfo(long l, String s)
        {
            packId = l;
            packIdentifier = s;
        }
    }

    class StickerPacksAdapter extends CursorAdapter
    {

        static final int TYPE_DIVIDER = 2;
        static final int TYPE_EXTERNAL = 1;
        static final int TYPE_INVALID = -1;
        static final int TYPE_LEFT_DIVIDER = 3;
        static final int TYPE_LEFT_GETMORE = 5;
        static final int TYPE_NORMAL = 0;
        static final int TYPE_RIGHT_DIVIDER = 4;
        static final int TYPE_RIGHT_GETMORE = 6;
        int mDisplayNameColumnIndex;
        private int mExternalLayoutResId;
        private LayoutInflater mInflater;
        int mIsFreeColumnIndex;
        private int mLayoutResId;
        private int mMoreResId;
        int mPackageNameColumnIndex;
        int mPathColumnIndex;
        final StickersPanel this$0;

        private void initColumns(Cursor cursor)
        {
            if (cursor != null)
            {
                mPackageNameColumnIndex = cursor.getColumnIndex("packagename");
                mDisplayNameColumnIndex = cursor.getColumnIndex("displayName");
                mPathColumnIndex = cursor.getColumnIndex("path");
                mIsFreeColumnIndex = cursor.getColumnIndex("isFree");
            }
        }

        private View newView(Context context, Cursor cursor, ViewGroup viewgroup, int i)
        {
            int j;
            int l;
            j = mPackCellWidth;
            l = getItemViewType(i);
            l;
            JVM INSTR tableswitch 1 6: default 56
        //                       1 399
        //                       2 373
        //                       3 425
        //                       4 445
        //                       5 176
        //                       6 218;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L5:
            break MISSING_BLOCK_LABEL_445;
_L1:
            context = null;
            i = j;
_L8:
            context.setLayoutParams(new android.view.ViewGroup.LayoutParams(i, -1));
            View view;
            int k;
            if (l == 1)
            {
                cursor = new BordersPanel.ViewHolderExternal();
            } else
            {
                cursor = new BordersPanel.ViewHolder();
            }
            cursor.type = l;
            cursor.image = (ImageView)context.findViewById(com.aviary.android.feather.sdk.R.id.aviary_image);
            cursor.text = (TextView)context.findViewById(com.aviary.android.feather.sdk.R.id.aviary_text);
            if (((BordersPanel.ViewHolder) (cursor)).image != null)
            {
                viewgroup = ((BordersPanel.ViewHolder) (cursor)).image.getLayoutParams();
                viewgroup.height = mPackThumbSize;
                viewgroup.width = mPackThumbSize;
                ((BordersPanel.ViewHolder) (cursor)).image.setLayoutParams(viewgroup);
            }
            context.setTag(cursor);
            return context;
_L6:
            context = mInflater.inflate(mMoreResId, viewgroup, false);
            ((ImageView)context.findViewById(com.aviary.android.feather.sdk.R.id.aviary_image)).setImageResource(com.aviary.android.feather.sdk.R.drawable.aviary_sticker_item_getmore);
            i = mPackCellWidth;
              goto _L8
_L7:
            view = mInflater.inflate(mMoreResId, viewgroup, false);
            ((ImageView)view.findViewById(com.aviary.android.feather.sdk.R.id.aviary_image)).setImageResource(com.aviary.android.feather.sdk.R.drawable.aviary_sticker_item_getmore);
            k = mPackCellWidth;
            if (mPackCellWidth * cursor.getCount() < viewgroup.getWidth() * 2)
            {
                view.setVisibility(4);
                i = 1;
                context = view;
            } else
            {
                i = k;
                context = view;
                if (viewgroup.getChildCount() > 0)
                {
                    i = k;
                    context = view;
                    if (mListPacks.getFirstVisiblePosition() == 0)
                    {
                        i = k;
                        context = view;
                        if (viewgroup.getChildAt(viewgroup.getChildCount() - 1).getRight() < viewgroup.getWidth())
                        {
                            view.setVisibility(4);
                            i = 1;
                            context = view;
                        }
                    }
                }
            }
              goto _L8
_L3:
            context = mInflater.inflate(mLayoutResId, viewgroup, false);
            i = mPackCellWidth;
              goto _L8
_L2:
            context = mInflater.inflate(mExternalLayoutResId, viewgroup, false);
            i = mPackCellWidth;
              goto _L8
_L4:
            context = mInflater.inflate(com.aviary.android.feather.sdk.R.layout.aviary_thumb_divider_right, viewgroup, false);
            i = -2;
              goto _L8
            view = mInflater.inflate(com.aviary.android.feather.sdk.R.layout.aviary_thumb_divider_left, viewgroup, false);
            k = -2;
            if (mPackCellWidth * cursor.getCount() < viewgroup.getWidth() * 2)
            {
                view.setVisibility(4);
                i = 1;
                context = view;
            } else
            {
                i = k;
                context = view;
                if (viewgroup.getChildCount() > 0)
                {
                    i = k;
                    context = view;
                    if (mListPacks.getFirstVisiblePosition() == 0)
                    {
                        i = k;
                        context = view;
                        if (viewgroup.getChildAt(viewgroup.getChildCount() - 1).getRight() < viewgroup.getWidth())
                        {
                            view.setVisibility(4);
                            i = 1;
                            context = view;
                        }
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
            long l;
            view = (BordersPanel.ViewHolder)view.getTag();
            long l1 = -1L;
            l = l1;
            if (!cursor.isAfterLast())
            {
                l = l1;
                if (!cursor.isBeforeFirst())
                {
                    l = cursor.getLong(0);
                }
            }
            if (((BordersPanel.ViewHolder) (view)).type != 1) goto _L2; else goto _L1
_L1:
            context = (BordersPanel.ViewHolderExternal)view;
            String s = cursor.getString(3);
            String s2 = cursor.getString(mDisplayNameColumnIndex);
            String s3 = cursor.getString(mPathColumnIndex);
            i = cursor.getInt(mIsFreeColumnIndex);
            ((BordersPanel.ViewHolder) (view)).text.setText(s2);
            view.identifier = s;
            context.free = i;
            if (((BordersPanel.ViewHolder) (view)).id != l)
            {
                mPicassoLib.load(s3).resize(mPackThumbSize, mPackThumbSize, true).transform((new com.aviary.android.feather.sdk.utils.PackIconCallable.Builder()).withResources(getContext().getBaseContext().getResources()).withPackType(com.aviary.android.feather.cds.AviaryCds.PackType.STICKER).withPath(s3).build()).noFade().error(com.aviary.android.feather.sdk.R.drawable.aviary_ic_na).into(((BordersPanel.ViewHolder) (view)).image);
            }
_L4:
            view.id = l;
            return;
_L2:
            if (((BordersPanel.ViewHolder) (view)).type == 2)
            {
                context = cursor.getString(mDisplayNameColumnIndex);
                String s1 = cursor.getString(3);
                cursor = cursor.getString(mPathColumnIndex);
                ((BordersPanel.ViewHolder) (view)).text.setText(context);
                view.identifier = s1;
                view.obj = cursor;
                view.isNew = mNewPacks.contains(Long.valueOf(l));
                if (((BordersPanel.ViewHolder) (view)).id != l)
                {
                    loadStickerPackIcon(view, l);
                } else
                {
                    mLogger.warn("icon already loaded...");
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
                return cursor.getInt(4);
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

        public Cursor swapCursor(Cursor cursor)
        {
            initColumns(cursor);
            return super.swapCursor(cursor);
        }

        public StickerPacksAdapter(Context context, int i, int j, int k, Cursor cursor)
        {
            this$0 = StickersPanel.this;
            super(context, cursor, 0);
            initColumns(cursor);
            mLayoutResId = i;
            mExternalLayoutResId = j;
            mMoreResId = k;
            mInflater = LayoutInflater.from(context);
        }
    }

    static class StickerThumbnailCallable
        implements Callable
    {

        int mFinalSize;
        String mUrl;

        public Bitmap call()
            throws Exception
        {
            Object obj = new android.graphics.BitmapFactory.Options();
            obj.inPreferredConfig = android.graphics.Bitmap.Config.ARGB_8888;
            Bitmap bitmap = BitmapFactory.decodeFile(mUrl, ((android.graphics.BitmapFactory.Options) (obj)));
            obj = bitmap;
            if (mFinalSize > 0)
            {
                obj = bitmap;
                if (bitmap != null)
                {
                    Bitmap bitmap1 = BitmapUtils.resizeBitmap(bitmap, mFinalSize, mFinalSize);
                    obj = bitmap;
                    if (bitmap1 != bitmap)
                    {
                        bitmap.recycle();
                        obj = bitmap1;
                    }
                }
            }
            return ((Bitmap) (obj));
        }

        public volatile Object call()
            throws Exception
        {
            return call();
        }

        public StickerThumbnailCallable(String s, int i)
        {
            mUrl = s;
            mFinalSize = i;
        }
    }

    class StickersAdapter extends CursorAdapter
    {

        int idColumnIndex;
        int identifierColumnIndex;
        String mContentPath;
        LayoutInflater mLayoutInflater;
        int mStickerResourceId;
        int packIdColumnIndex;
        final StickersPanel this$0;

        private void initCursor(Cursor cursor)
        {
            if (cursor != null)
            {
                idColumnIndex = cursor.getColumnIndex("item_id");
                identifierColumnIndex = cursor.getColumnIndex("item_identifier");
                packIdColumnIndex = cursor.getColumnIndex("item_packId");
            }
        }

        public void bindView(View view, Context context, Cursor cursor)
        {
            view = (ImageView)view.findViewById(com.aviary.android.feather.sdk.R.id.image);
            context = cursor.getString(identifierColumnIndex);
            context = (new StringBuilder()).append(mContentPath).append("/").append(AviaryCds.getPackItemFilename(context, com.aviary.android.feather.cds.AviaryCds.PackType.STICKER, com.aviary.android.feather.cds.AviaryCds.Size.Small)).toString();
            mPicassoLib.load(context).skipMemoryCache().resize(mStickerThumbSize, mStickerThumbSize, true).noFade().into(view);
        }

        public String getContentPath()
        {
            return mContentPath;
        }

        public String getItemIdentifier(int i)
        {
            return ((Cursor)getItem(i)).getString(identifierColumnIndex);
        }

        public boolean hasStableIds()
        {
            return true;
        }

        public View newView(Context context, Cursor cursor, ViewGroup viewgroup)
        {
            context = mLayoutInflater.inflate(mStickerResourceId, null);
            context.setLayoutParams(new android.view.ViewGroup.LayoutParams(mStickerCellWidth, -1));
            return context;
        }

        public void setContentPath(String s)
        {
            mContentPath = s;
        }

        public Cursor swapCursor(Cursor cursor)
        {
            initCursor(cursor);
            return super.swapCursor(cursor);
        }

        public StickersAdapter(Context context, int i, Cursor cursor)
        {
            this$0 = StickersPanel.this;
            super(context, cursor, 0);
            mStickerResourceId = i;
            mLayoutInflater = LayoutInflater.from(context);
            initCursor(cursor);
        }
    }


    public static final float DRAG_SCALE_FACTOR = 1.5F;
    public static final String ESCAPE = " ESCAPE '\\'";
    public static final float SHAKE_PACK_ROTATION_END = 3F;
    public static final float SHAKE_PACK_SCALE_START = 0.3F;
    private static final int STATUS_NULL = -1;
    private static final int STATUS_OPACITY = 3;
    private static final int STATUS_PACKS = 1;
    private static final int STATUS_STICKERS = 2;
    protected CursorAdapter mAdapterPacks;
    protected CursorAdapter mAdapterStickers;
    private Canvas mCanvas;
    private ConfigService mConfigService;
    protected ContentObserver mContentObserver;
    private StickerFilter mCurrentFilter;
    protected CursorLoader mCursorLoaderPacks;
    private SQLiteDatabase mDatabase;
    private DragControllerService mDragControllerService;
    private boolean mFirstTime;
    private IAPDialogMain mIapDialog;
    private final List mInstalledPacks = new ArrayList();
    List mItemApplied;
    int mItemCount;
    private long mLastInstalledPack;
    private HListView mListPacks;
    private HListView mListStickers;
    private final List mNewPacks = new ArrayList(0);
    private View mOpacityConfirm;
    private View mOpacityDismiss;
    StickersOverlay mOverlay;
    private int mPackCellWidth;
    private StickerPackInfo mPackInfo;
    private int mPackThumbSize;
    private Picasso mPicassoLib;
    private PreferenceService mPreferenceService;
    private SeekBar mSeekBar;
    private SimpleStatusMachine mStatus;
    private int mStickerCellWidth;
    int mStickerFlipToolTip;
    private int mStickerThumbSize;
    int mStickersOnScreen;
    private ViewFlipper mViewFlipper;

    public StickersPanel(IAviaryController iaviarycontroller, ToolEntry toolentry)
    {
        super(iaviarycontroller, toolentry);
        mFirstTime = true;
        mItemCount = 0;
        mStickersOnScreen = 0;
        mItemApplied = new ArrayList(0);
        mStickerFlipToolTip = 0;
    }

    private void addSticker(FeatherDrawable featherdrawable, RectF rectf)
    {
        DrawableHighlightView drawablehighlightview = new DrawableHighlightView(mImageView, ((ImageViewDrawableOverlay)mImageView).getOverlayStyleId(), featherdrawable);
        drawablehighlightview.setOnDeleteClickListener(new com.aviary.android.feather.sdk.widget.DrawableHighlightView.OnDeleteClickListener() {

            final StickersPanel this$0;

            public void onDeleteClick()
            {
                onClearCurrent(true);
            }

            
            {
                this$0 = StickersPanel.this;
                super();
            }
        });
        drawablehighlightview.setOnContentFlipListener(new com.aviary.android.feather.sdk.widget.DrawableHighlightView.OnContentFlipListener() {

            final StickersPanel this$0;

            public void onContentFlip(DrawableHighlightView drawablehighlightview1)
            {
                getContext().getTracker().tagEvent("stickers: item_flipped");
            }

            
            {
                this$0 = StickersPanel.this;
                super();
            }
        });
        if (!FeatherActivity.MATURITY.isKidsFriendly())
        {
            drawablehighlightview.setOnChangeOpacityListener(new com.aviary.android.feather.sdk.widget.DrawableHighlightView.OnOpacityChangeListener() {

                final StickersPanel this$0;

                public void onChangeOpacity()
                {
                    mStatus.setStatus(3);
                }

                public void onLockOpacity()
                {
                    if (mStatus.getCurrentStatus() == 3)
                    {
                        mStatus.setStatus(mStatus.getPreviousStatus());
                    }
                }

            
            {
                this$0 = StickersPanel.this;
                super();
            }
            });
        }
        Matrix matrix = mImageView.getImageViewMatrix();
        int i1 = mImageView.getWidth();
        int j1 = mImageView.getHeight();
        int i;
        int j;
        int k;
        int l;
        if (rectf != null)
        {
            j = (int)rectf.width();
            i = (int)rectf.height();
        } else
        {
            j = (int)featherdrawable.getCurrentWidth();
            i = (int)featherdrawable.getCurrentHeight();
        }
        l = i;
        k = j;
        featherdrawable = rectf;
        if (Math.max(j, i) > Math.min(mImageView.getWidth(), mImageView.getHeight()))
        {
            float f = (float)mImageView.getWidth() / (float)j;
            float f1 = (float)mImageView.getHeight() / (float)i;
            if (f >= f1)
            {
                f = f1;
            }
            k = (int)((float)j * (f / 2.0F));
            l = (int)((float)i * (f / 2.0F));
            featherdrawable = rectf;
            if (rectf == null)
            {
                i = mImageView.getWidth();
                j = mImageView.getHeight();
                featherdrawable = new RectF(i / 2 - k / 2, j / 2 - l / 2, i / 2 + k / 2, j / 2 + l / 2);
            }
            featherdrawable.inset((featherdrawable.width() - (float)k) / 2.0F, (featherdrawable.height() - (float)l) / 2.0F);
        }
        if (featherdrawable != null)
        {
            i = (int)((RectF) (featherdrawable)).left;
            j = (int)((RectF) (featherdrawable)).top;
        } else
        {
            i = (i1 - k) / 2;
            j = (j1 - l) / 2;
        }
        featherdrawable = new Matrix(matrix);
        featherdrawable.invert(featherdrawable);
        rectf = new float[4];
        rectf[0] = i;
        rectf[1] = j;
        rectf[2] = i + k;
        rectf[3] = j + l;
        MatrixUtils.mapPoints(featherdrawable, rectf);
        featherdrawable = new RectF(rectf[0], rectf[1], rectf[2], rectf[3]);
        rectf = new Rect(0, 0, i1, j1);
        drawablehighlightview.setup(getContext().getBaseContext(), matrix, rectf, featherdrawable, false);
        ((ImageViewDrawableOverlay)mImageView).addHighlightView(drawablehighlightview);
        ((ImageViewDrawableOverlay)mImageView).setSelectedHighlightView(drawablehighlightview);
        mStickersOnScreen = mStickersOnScreen + 1;
        l = mStickerFlipToolTip;
        mStickerFlipToolTip = l + 1;
        if (l == 0)
        {
            l = ((com.aviary.android.feather.sdk.AviaryMainController.FeatherContext)getContext().getBaseContext()).getActionBarSize();
            featherdrawable = TooltipManager.getInstance(getContext().getBaseActivity());
            if (featherdrawable != null)
            {
                featherdrawable.create(0).actionBarSize(l).anchor(new Point(k / 2 + i, j - 5), it.sephiroth.android.library.tooltip.TooltipManager.Gravity.TOP).text(getContext().getBaseContext().getResources(), com.aviary.android.feather.sdk.R.string.feather_sticker_flip_tooltip).closePolicy(it.sephiroth.android.library.tooltip.TooltipManager.ClosePolicy.TouchOutside, 3000L).activateDelay(1000L).maxWidth(mImageView.getWidth() / 2).showDelay(150L).withStyleId(com.aviary.android.feather.sdk.R.style.AviaryPanelsTooltip).withCustomView(com.aviary.android.feather.sdk.R.layout.aviary_effect_intensity_tooltip, false).show();
            }
            if (mPreferenceService != null)
            {
                mPreferenceService.containsSingleTimeKey(getClass(), "sticker.flip.tooltip", true);
            }
            drawablehighlightview.playHorizontalFlipDemo();
        }
    }

    private void addSticker(String s, String s1, RectF rectf)
    {
        onApplyCurrent();
        Assert.assertNotNull(mPackInfo);
        Assert.assertNotNull(s);
        Object obj = new File(s, AviaryCds.getPackItemFilename(s1, com.aviary.android.feather.cds.AviaryCds.PackType.STICKER, com.aviary.android.feather.cds.AviaryCds.Size.Medium));
        mLogger.log((new StringBuilder()).append("file: ").append(((File) (obj)).getAbsolutePath()).toString());
        if (((File) (obj)).exists())
        {
            obj = new StickerDrawable(getContext().getBaseContext().getResources(), ((File) (obj)).getAbsolutePath(), s1, mPackInfo.packIdentifier);
            ((StickerDrawable) (obj)).setAntiAlias(true);
            mCurrentFilter = new StickerFilter(s, s1);
            mCurrentFilter.setSize(((StickerDrawable) (obj)).getBitmapWidth(), ((StickerDrawable) (obj)).getBitmapHeight());
            s = new HashMap();
            s.put("item", s1);
            s.put("pack", mPackInfo.packIdentifier);
            getContext().getTracker().tagEventAttributes("stickers: item_added", s);
            addSticker(((FeatherDrawable) (obj)), rectf);
            return;
        } else
        {
            mLogger.warn("file does not exists");
            Toast.makeText(getContext().getBaseContext(), "Error loading the selected sticker", 0).show();
            return;
        }
    }

    private void closeDatabase()
    {
        if (mDatabase != null && mDatabase.isOpen())
        {
            mDatabase.close();
            mDatabase = null;
        }
    }

    private void createAndConfigurePreview()
    {
        if (mPreview != null && !mPreview.isRecycled())
        {
            mPreview.recycle();
            mPreview = null;
        }
        mPreview = BitmapUtils.copy(mBitmap, android.graphics.Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mPreview);
    }

    private StickerPacksAdapter createPacksAdapter(Context context, Cursor cursor)
    {
        return new StickerPacksAdapter(context, com.aviary.android.feather.sdk.R.layout.aviary_sticker_item, com.aviary.android.feather.sdk.R.layout.aviary_effect_item_external, com.aviary.android.feather.sdk.R.layout.aviary_effect_item_more, cursor);
    }

    private void createTutorialOverlayIfNecessary(final int firstValidIndex, int i)
    {
        mLogger.info("createTutorialOverlayIfNecessary: %d, %d", new Object[] {
            Integer.valueOf(firstValidIndex), Integer.valueOf(i)
        });
        while (i != 1 || !isActive() || getHandler() == null) 
        {
            return;
        }
        getHandler().postDelayed(new Runnable() {

            final StickersPanel this$0;
            final int val$firstValidIndex;

            public void run()
            {
                if (firstValidIndex < 0)
                {
                    createTutorialOverlayIfNecessaryDelayed(firstValidIndex);
                }
            }

            
            {
                this$0 = StickersPanel.this;
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
        if (!isActive() || mStatus.getCurrentStatus() != 1)
        {
            return false;
        }
        boolean flag4 = true;
        int l = mListPacks.getChildCount();
        int j = -1;
        ImageView imageview = null;
        boolean flag2 = false;
        mLogger.log("count: %d", new Object[] {
            Integer.valueOf(l)
        });
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
                        obj = mListPacks.getChildAt(i);
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
                        if (!(obj instanceof BordersPanel.ViewHolder))
                        {
                            break label1;
                        }
                        obj = (BordersPanel.ViewHolder)obj;
                        if (((BordersPanel.ViewHolder) (obj)).type != 2)
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
                if (((BordersPanel.ViewHolder) (obj)).type == 1)
                {
                    obj = (BordersPanel.ViewHolderExternal)obj;
                    boolean flag1;
                    if (((BordersPanel.ViewHolderExternal) (obj)).free == 1)
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
                        imageview1 = ((BordersPanel.ViewHolderExternal) (obj)).image;
                        flag3 = flag1;
                    }
                }
            }
            i++;
            flag2 = flag3;
            j = k;
            imageview = imageview1;
        } while (true);
        if (mOverlay == null)
        {
            if (AviaryOverlay.shouldShow(getContext(), 1))
            {
                mOverlay = new StickersOverlay(getContext().getBaseActivity(), com.aviary.android.feather.sdk.R.style.AviaryWidget_Overlay_Stickers, imageview);
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

                final StickersPanel this$0;

                public void onClose()
                {
                    removeIapDialog();
                }

            
            {
                this$0 = StickersPanel.this;
                super();
            }
            });
        }
        mIapDialog = iapupdater;
        setApplyEnabled(false);
    }

    private void loadStickerPackIcon(final BordersPanel.ViewHolder holder, long l)
    {
        if (holder != null && holder.obj != null)
        {
            final boolean shouldShake;
            if (mLastInstalledPack == l)
            {
                shouldShake = true;
            } else
            {
                shouldShake = false;
            }
            mLogger.log("shouldShake: %b, lastInstalledPack: %d, id: %d", new Object[] {
                Boolean.valueOf(shouldShake), Long.valueOf(mLastInstalledPack), Long.valueOf(l)
            });
            if (shouldShake)
            {
                holder.image.setAlpha(0);
                ViewHelper.setScaleX(holder.image, 0.0F);
                ViewHelper.setScaleY(holder.image, 0.0F);
            }
            mPicassoLib.load(new File((String)holder.obj)).fit().transform((new com.aviary.android.feather.sdk.utils.PackIconCallable.Builder()).withResources(getContext().getBaseContext().getResources()).withPackType(com.aviary.android.feather.cds.AviaryCds.PackType.STICKER).withPath((String)holder.obj).isNew(mNewPacks.contains(Long.valueOf(l))).build()).noFade().error(com.aviary.android.feather.sdk.R.drawable.aviary_ic_na).into(holder.image, new Callback() {

                final StickersPanel this$0;
                final BordersPanel.ViewHolder val$holder;
                final boolean val$shouldShake;

                public void onError()
                {
                }

                public void onSuccess()
                {
                    if (shouldShake)
                    {
                        shakePack(holder);
                        mLastInstalledPack = -1L;
                    }
                }

            
            {
                this$0 = StickersPanel.this;
                shouldShake = flag;
                holder = viewholder;
                super();
            }
            });
            if (shouldShake)
            {
                mLastInstalledPack = -1L;
            }
        }
    }

    private void onApplyCurrent()
    {
        if (!stickersOnScreen())
        {
            return;
        }
        Object obj = ((ImageViewDrawableOverlay)mImageView).getHighlightViewAt(0);
        if (obj != null)
        {
            StickerDrawable stickerdrawable = (StickerDrawable)((DrawableHighlightView) (obj)).getContent();
            RectF rectf = ((DrawableHighlightView) (obj)).getCropRectF();
            Rect rect = new Rect((int)rectf.left, (int)rectf.top, (int)rectf.right, (int)rectf.bottom);
            Matrix matrix = ((DrawableHighlightView) (obj)).getCropRotationMatrix();
            Matrix matrix1 = new Matrix();
            mImageView.getImageMatrix().invert(matrix1);
            int i = mCanvas.save(1);
            mCanvas.concat(matrix);
            stickerdrawable.setDropShadow(false);
            ((DrawableHighlightView) (obj)).getContent().setBounds(rect);
            ((DrawableHighlightView) (obj)).getContent().draw(mCanvas);
            mCanvas.restoreToCount(i);
            mImageView.invalidate();
            if (mCurrentFilter != null)
            {
                int j = mBitmap.getWidth();
                int k = mBitmap.getHeight();
                mCurrentFilter.setTopLeft(rectf.left / (float)j, rectf.top / (float)k);
                mCurrentFilter.setBottomRight(rectf.right / (float)j, rectf.bottom / (float)k);
                mCurrentFilter.setRotation(Math.toRadians(((DrawableHighlightView) (obj)).getRotation()));
                int l = stickerdrawable.getBitmapWidth();
                int i1 = stickerdrawable.getBitmapHeight();
                float f = rectf.width() / (float)l;
                float f1 = rectf.height() / (float)i1;
                mCurrentFilter.setCenter(rectf.centerX() / (float)j, rectf.centerY() / (float)k);
                mCurrentFilter.setScale(f, f1);
                mCurrentFilter.setFlipH(((DrawableHighlightView) (obj)).getFlipHorizontal());
                if (mSeekBar != null)
                {
                    mCurrentFilter.setAlpha((int)(((double)mSeekBar.getProgress() / 100D) * 255D));
                } else
                {
                    mCurrentFilter.setAlpha(255);
                }
                obj = new ToolActionVO();
                ((ToolActionVO) (obj)).setPackIdentifier(stickerdrawable.getPackIdentifier());
                ((ToolActionVO) (obj)).setContentIdentifier(stickerdrawable.getIdentifier());
                mEditResult.addToolAction(((ToolActionVO) (obj)));
                mEditResult.getActionList().add(mCurrentFilter.getActions().get(0));
                mItemCount = mItemCount + 1;
                mItemApplied.add(Pair.create(stickerdrawable.getPackIdentifier(), stickerdrawable.getIdentifier()));
                mCurrentFilter = null;
            }
        }
        if (mSeekBar != null)
        {
            mSeekBar.setProgress(100);
        }
        onClearCurrent(false);
        onPreviewChanged(mPreview, false, false);
    }

    private void onClearCurrent(DrawableHighlightView drawablehighlightview, boolean flag)
    {
        if (mCurrentFilter != null)
        {
            mCurrentFilter = null;
        }
        if (drawablehighlightview != null)
        {
            Object obj = drawablehighlightview.getContent();
            if (flag && (obj instanceof StickerDrawable))
            {
                String s = ((StickerDrawable)obj).getIdentifier();
                obj = ((StickerDrawable)obj).getPackIdentifier();
                HashMap hashmap = new HashMap();
                hashmap.put("item", s);
                hashmap.put("pack", obj);
                getContext().getTracker().tagEventAttributes("stickers: item_deleted", hashmap);
                int i = mItemApplied.lastIndexOf(Pair.create(obj, s));
                if (i > -1)
                {
                    mItemApplied.remove(i);
                }
            }
        }
        drawablehighlightview.setOnDeleteClickListener(null);
        drawablehighlightview.setOnContentFlipListener(null);
        ((ImageViewDrawableOverlay)mImageView).removeHightlightView(drawablehighlightview);
        ((ImageViewDrawableOverlay)mImageView).invalidate();
        if (flag)
        {
            mStickersOnScreen = mStickersOnScreen - 1;
        }
    }

    private void onClearCurrent(boolean flag)
    {
        if (stickersOnScreen())
        {
            onClearCurrent(((ImageViewDrawableOverlay)mImageView).getHighlightViewAt(0), flag);
        }
    }

    private void onSendEvents()
    {
        if (getContext() != null)
        {
            AviaryTracker aviarytracker = getContext().getTracker();
            Pair pair;
            for (Iterator iterator = mItemApplied.iterator(); iterator.hasNext(); aviarytracker.tagEvent("stickers: item_saved", new String[] {
    "pack", (String)pair.first, "item", (String)pair.second
}))
            {
                pair = (Pair)iterator.next();
            }

        }
    }

    private void onStickerPackSelected(long l, String s)
    {
        mLogger.info("onStickerPackSelected: %d, %s", new Object[] {
            Long.valueOf(l), s
        });
        mNewPacks.remove(Long.valueOf(l));
        removeIapDialog();
        mPackInfo = new StickerPackInfo(l, s);
        mStatus.setStatus(2);
    }

    private void onStickersPackListUpdated(Cursor cursor, int i, boolean flag, boolean flag1)
    {
        if (i <= 0)
        {
            i = 0;
        }
        if ((mFirstTime || flag) && i > 0)
        {
            if (flag1)
            {
                mListPacks.smoothScrollToPositionFromLeft(i - 1, mPackCellWidth / 2, 500);
            }
            mListPacks.setSelectionFromLeft(i - 1, mPackCellWidth / 2);
        }
        mFirstTime = false;
    }

    private void openDatabase(Context context)
    {
        if (mDatabase == null || !mDatabase.isOpen())
        {
            mDatabase = SQLiteDatabase.openDatabase(context.getDatabasePath("aviarycds.sqlite").getPath(), null, 1);
        }
    }

    private boolean openStorePanelIfRequired(long l)
    {
        if (hasOption("quick-packId") || l > -1L)
        {
            if (l <= -1L)
            {
                Bundle bundle = getOptions();
                l = bundle.getLong("quick-packId");
                bundle.remove("quick-packId");
            }
            if (l > -1L)
            {
                displayIAPDialog((new com.aviary.android.feather.sdk.widget.IAPDialogMain.IAPUpdater.Builder()).setPackId(l).setFeaturedPackId(l).setPackType(com.aviary.android.feather.cds.AviaryCds.PackType.STICKER).setEvent("shop_details: opened").addEventAttributes("pack", String.valueOf(l)).addEventAttributes("from", "message").build());
                return true;
            }
        }
        return false;
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

    private void shakePack(BordersPanel.ViewHolder viewholder)
    {
        if (viewholder == null || viewholder.image == null)
        {
            return;
        } else
        {
            mLogger.info("shakePack");
            ViewHelper.setPivotX(viewholder.image, viewholder.image.getWidth() / 2);
            ViewHelper.setPivotY(viewholder.image, viewholder.image.getHeight() / 2);
            AnimatorSet animatorset = new AnimatorSet();
            animatorset.setDuration(100L);
            animatorset.setInterpolator(new DecelerateInterpolator(1.0F));
            animatorset.playTogether(new Animator[] {
                ObjectAnimator.ofInt(viewholder.image, "alpha", new int[] {
                    0, 255
                }), ObjectAnimator.ofFloat(viewholder.image, "scaleX", new float[] {
                    0.3F, 1.0F
                }), ObjectAnimator.ofFloat(viewholder.image, "scaleY", new float[] {
                    0.3F, 1.0F
                })
            });
            viewholder = ObjectAnimator.ofFloat(viewholder.image, "rotation", new float[] {
                0.0F, 3F
            });
            viewholder.setDuration(400L);
            viewholder.setInterpolator(new CycleInterpolator(3F));
            AnimatorSet animatorset1 = new AnimatorSet();
            animatorset1.playSequentially(new Animator[] {
                animatorset, viewholder
            });
            animatorset1.setStartDelay(100L);
            animatorset1.start();
            return;
        }
    }

    private boolean startDrag(AdapterView adapterview, View view, int i, long l, boolean flag)
    {
        float f;
        View view1;
        String s;
        String s1;
        String s2;
        if (adapterview == null || view == null || adapterview.getAdapter() == null || mStatus.getCurrentStatus() != 2)
        {
            return false;
        }
        if (view == null)
        {
            break MISSING_BLOCK_LABEL_344;
        }
        view1 = view.findViewById(com.aviary.android.feather.sdk.R.id.image);
        if (view1 == null)
        {
            break MISSING_BLOCK_LABEL_344;
        }
        if (adapterview.getAdapter() == null || !(adapterview.getAdapter() instanceof StickersAdapter))
        {
            return false;
        }
        adapterview = (StickersAdapter)adapterview.getAdapter();
        s = adapterview.getItemIdentifier(i);
        s1 = adapterview.getContentPath();
        if (s == null || s1 == null)
        {
            return false;
        }
        getContext().getTracker().tagEvent("stickers: drag_began", new String[] {
            "item", s
        });
        s2 = (new StringBuilder()).append(s1).append("/").append(AviaryCds.getPackItemFilename(s, com.aviary.android.feather.cds.AviaryCds.PackType.STICKER, com.aviary.android.feather.cds.AviaryCds.Size.Small)).toString();
        view = null;
        float f1 = 1.0F;
        android.graphics.drawable.Drawable drawable = ((ImageView)view1).getDrawable();
        adapterview = view;
        f = f1;
        if (drawable != null)
        {
            adapterview = view;
            f = f1;
            if (drawable instanceof BitmapDrawable)
            {
                adapterview = ((BitmapDrawable)drawable).getBitmap();
                adapterview = Bitmap.createScaledBitmap(adapterview, (int)((float)adapterview.getWidth() * 1.5F), (int)((float)adapterview.getHeight() * 1.5F), true);
                f = 1.5F;
            }
        }
        view = adapterview;
        if (adapterview != null)
        {
            break MISSING_BLOCK_LABEL_265;
        }
        view = (new StickerThumbnailCallable(s2, mStickerThumbSize)).call();
        boolean flag1;
        adapterview = new int[2];
        view1.getLocationOnScreen(adapterview);
        flag1 = getDragController().startDrag(view1, view, this, new StickerDragInfo(s1, s, f), 0, adapterview[0], adapterview[1]);
        return flag1;
        adapterview;
        adapterview.printStackTrace();
        return getDragController().startDrag(view1, this, new StickerDragInfo(s1, s, 1.0F), 0, flag);
        return false;
    }

    private boolean stickersOnScreen()
    {
        return ((ImageViewDrawableOverlay)mImageView).getHighlightCount() > 0;
    }

    public boolean acceptDrop(com.aviary.android.feather.library.services.DragControllerService.DragSource dragsource, int i, int j, int k, int l, DragView dragview, Object obj)
    {
        return dragsource == this;
    }

    void askToLeaveWithoutApply()
    {
        (new android.app.AlertDialog.Builder(getContext().getBaseContext())).setTitle(com.aviary.android.feather.sdk.R.string.feather_attention).setMessage(com.aviary.android.feather.sdk.R.string.feather_tool_leave_question).setPositiveButton(0x1040013, new android.content.DialogInterface.OnClickListener() {

            final StickersPanel this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                getContext().cancel();
            }

            
            {
                this$0 = StickersPanel.this;
                super();
            }
        }).setNegativeButton(0x1040009, null).show();
    }

    protected View generateContentView(LayoutInflater layoutinflater)
    {
        return layoutinflater.inflate(com.aviary.android.feather.sdk.R.layout.aviary_content_stickers, null);
    }

    protected ViewGroup generateOptionView(LayoutInflater layoutinflater, ViewGroup viewgroup)
    {
        int i;
        if (FeatherActivity.MATURITY.isKidsFriendly())
        {
            i = com.aviary.android.feather.sdk.R.layout.aviary_panel_stickers_freetime;
        } else
        {
            i = com.aviary.android.feather.sdk.R.layout.aviary_panel_stickers;
        }
        return (ViewGroup)layoutinflater.inflate(i, null);
    }

    public DragController getDragController()
    {
        return mDragControllerService.getInstance();
    }

    public boolean getIsChanged()
    {
        return mStickersOnScreen > 0 || stickersOnScreen();
    }

    public volatile boolean isRendering()
    {
        return super.isRendering();
    }

    protected void loadStickers()
    {
        Context context = getContext().getBaseContext();
        if (mPackInfo != null)
        {
            String s = CdsUtils.getPackContentPath(context, mPackInfo.packId);
            openDatabase(context);
            SQLiteQueryBuilder sqlitequerybuilder = new SQLiteQueryBuilder();
            sqlitequerybuilder.setTables("items_table");
            Object obj;
            if (FeatherActivity.MATURITY.isKidsFriendly())
            {
                obj = (new StringBuilder()).append("item_identifier LIKE ").append(FeatherActivity.MATURITY.getStickerMask()).append(" ESCAPE '\\'").toString();
            } else
            {
                obj = (new StringBuilder()).append("item_packId = ").append(mPackInfo.packId).toString();
            }
            obj = sqlitequerybuilder.buildQuery(new String[] {
                "item_id as _id", "item_id", "item_packId", "item_identifier", "item_displayName"
            }, ((String) (obj)), null, null, null, null);
            obj = mDatabase.rawQuery(((String) (obj)), null);
            if (mAdapterStickers == null)
            {
                mAdapterStickers = new StickersAdapter(context, com.aviary.android.feather.sdk.R.layout.aviary_sticker_item_single, ((Cursor) (obj)));
                ((StickersAdapter)mAdapterStickers).setContentPath(s);
                mListStickers.setAdapter(mAdapterStickers);
            } else
            {
                ((StickersAdapter)mAdapterStickers).setContentPath(s);
                mAdapterStickers.changeCursor(((Cursor) (obj)));
            }
            if (ApiHelper.AT_LEAST_11)
            {
                mListStickers.setSelection(0);
            }
            mListStickers.setOnItemClickListener(new it.sephiroth.android.library.widget.AdapterView.OnItemClickListener() {

                final StickersPanel this$0;

                public void onItemClick(AdapterView adapterview, View view, int j, long l1)
                {
                    adapterview = (StickersAdapter)adapterview.getAdapter();
                    view = (Cursor)adapterview.getItem(j);
                    view = view.getString(view.getColumnIndex("item_identifier"));
                    removeIapDialog();
                    addSticker(adapterview.getContentPath(), view, null);
                }

            
            {
                this$0 = StickersPanel.this;
                super();
            }
            });
            mListStickers.setOnItemLongClickListener(new it.sephiroth.android.library.widget.AdapterView.OnItemLongClickListener() {

                final StickersPanel this$0;

                public boolean onItemLongClick(AdapterView adapterview, View view, int j, long l1)
                {
                    return startDrag(adapterview, view, j, l1, true);
                }

            
            {
                this$0 = StickersPanel.this;
                super();
            }
            });
            if (hasOption("quick-contentId"))
            {
                obj = getOptions();
                long l = ((Bundle) (obj)).getLong("quick-contentId", -1L);
                int i = 0;
                do
                {
label0:
                    {
                        if (i < mAdapterStickers.getCount())
                        {
                            if (l != mAdapterStickers.getItemId(i))
                            {
                                break label0;
                            }
                            mListStickers.performItemClick(null, i, l);
                        }
                        ((Bundle) (obj)).remove("quick-contentId");
                        return;
                    }
                    i++;
                } while (true);
            }
        }
    }

    public void onActivate()
    {
        super.onActivate();
        mImageView.setImageBitmap(mPreview, null, -1F, 8F);
        mPackCellWidth = mConfigService.getDimensionPixelSize(com.aviary.android.feather.sdk.R.dimen.aviary_sticker_pack_width);
        mPackThumbSize = mConfigService.getDimensionPixelSize(com.aviary.android.feather.sdk.R.dimen.aviary_sticker_pack_image_width);
        mStickerCellWidth = mConfigService.getDimensionPixelSize(com.aviary.android.feather.sdk.R.dimen.aviary_sticker_single_item_width);
        mStickerThumbSize = mConfigService.getDimensionPixelSize(com.aviary.android.feather.sdk.R.dimen.aviary_sticker_single_item_image_width);
        mStatus.setOnStatusChangeListener(this);
        updateInstalledPacks();
        getContentView().setVisibility(0);
        contentReady();
    }

    public boolean onBackPressed()
    {
label0:
        {
label1:
            {
                mLogger.info("onBackPressed");
                if (mIapDialog != null)
                {
                    if (mStatus.getCurrentStatus() != 2)
                    {
                        break label1;
                    }
                    removeIapDialog();
                }
                if (mOverlay != null && mOverlay.onBackPressed())
                {
                    return true;
                }
                break label0;
            }
            if (mIapDialog.onBackPressed())
            {
                return true;
            } else
            {
                removeIapDialog();
                return true;
            }
        }
        if (mStatus.getCurrentStatus() == 1)
        {
            if (stickersOnScreen())
            {
                getContext().cancel();
                return true;
            } else
            {
                return false;
            }
        }
        if (mStatus.getCurrentStatus() == 2)
        {
            int i = 0;
            if (mAdapterPacks != null)
            {
                i = mAdapterPacks.getCount();
            }
            if (i > 1)
            {
                mStatus.setStatus(1);
                return true;
            }
            if (stickersOnScreen())
            {
                getContext().cancel();
                return true;
            } else
            {
                return false;
            }
        }
        if (mStatus.getCurrentStatus() == 3)
        {
            DrawableHighlightView drawablehighlightview = ((ImageViewDrawableOverlay)mImageView).getHighlightViewAt(0);
            if (drawablehighlightview != null && mSeekBar != null)
            {
                drawablehighlightview.setOpacity(drawablehighlightview.getConfirmedOpacity());
                mSeekBar.setProgress((int)(((double)drawablehighlightview.getConfirmedOpacity() / 255D) * 100D));
            }
            mStatus.setStatus(mStatus.getPreviousStatus());
            return true;
        } else
        {
            return super.onBackPressed();
        }
    }

    public boolean onCancel()
    {
        if (stickersOnScreen())
        {
            getContext().cancel();
            return true;
        } else
        {
            return super.onCancel();
        }
    }

    protected void onComplete(Bitmap bitmap, EditToolResultVO edittoolresultvo)
    {
        mTrackingAttributes.put("item_count", String.valueOf(mItemCount));
        super.onComplete(bitmap, edittoolresultvo);
    }

    public void onConfigurationChanged(Configuration configuration, Configuration configuration1)
    {
        if (mIapDialog != null)
        {
            mIapDialog.onConfigurationChanged(configuration);
        }
        super.onConfigurationChanged(configuration, configuration1);
    }

    public void onCreate(Bitmap bitmap, Bundle bundle)
    {
        super.onCreate(bitmap, bundle);
        mStatus = new SimpleStatusMachine();
        mInstalledPacks.clear();
        mNewPacks.clear();
        mListPacks = (HListView)getOptionView().findViewById(com.aviary.android.feather.sdk.R.id.aviary_list_packs);
        mListStickers = (HListView)getOptionView().findViewById(com.aviary.android.feather.sdk.R.id.aviary_list_stickers);
        mViewFlipper = (ViewFlipper)getOptionView().findViewById(com.aviary.android.feather.sdk.R.id.aviary_flipper);
        mImageView = (ImageViewDrawableOverlay)getContentView().findViewById(com.aviary.android.feather.sdk.R.id.aviary_overlay);
        if (!FeatherActivity.MATURITY.isKidsFriendly())
        {
            mSeekBar = (SeekBar)getOptionView().findViewById(com.aviary.android.feather.sdk.R.id.aviary_seekbar);
            mSeekBar.setProgress(100);
            mSeekBar.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {

                final StickersPanel this$0;

                public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
                {
                    seekbar = ((ImageViewDrawableOverlay)mImageView).getHighlightViewAt(0);
                    if (seekbar != null)
                    {
                        seekbar.setOpacity((int)(((double)i / 100D) * 255D));
                    }
                }

                public void onStartTrackingTouch(SeekBar seekbar)
                {
                }

                public void onStopTrackingTouch(SeekBar seekbar)
                {
                    if (!ApiHelper.AT_LEAST_14)
                    {
                        seekbar = ((ImageViewDrawableOverlay)mImageView).getHighlightViewAt(0);
                        seekbar.invalidateDrawable(seekbar.getContent().getCurrent());
                    }
                }

            
            {
                this$0 = StickersPanel.this;
                super();
            }
            });
            mOpacityDismiss = getOptionView().findViewById(com.aviary.android.feather.sdk.R.id.aviary_button_cancel);
            mOpacityDismiss.setOnClickListener(new android.view.View.OnClickListener() {

                final StickersPanel this$0;

                public void onClick(View view)
                {
                    mLogger.log("sticker opacity dismiss clicked");
                    view = ((ImageViewDrawableOverlay)mImageView).getHighlightViewAt(0);
                    if (view != null)
                    {
                        view.setOpacity(view.getConfirmedOpacity());
                        mSeekBar.setProgress((int)(((double)view.getConfirmedOpacity() / 255D) * 100D));
                    }
                    mStatus.setStatus(mStatus.getPreviousStatus());
                }

            
            {
                this$0 = StickersPanel.this;
                super();
            }
            });
            mOpacityConfirm = getOptionView().findViewById(com.aviary.android.feather.sdk.R.id.aviary_button_confirm);
            mOpacityConfirm.setOnClickListener(new android.view.View.OnClickListener() {

                final StickersPanel this$0;

                public void onClick(View view)
                {
                    mLogger.log("sticker opacity confirm clicked");
                    mStatus.setStatus(mStatus.getPreviousStatus());
                    view = ((ImageViewDrawableOverlay)mImageView).getHighlightViewAt(0);
                    view.setConfirmedOpacity(view.getOpacity());
                }

            
            {
                this$0 = StickersPanel.this;
                super();
            }
            });
        }
        mConfigService = (ConfigService)getContext().getService(com/aviary/android/feather/library/services/ConfigService);
        mPreferenceService = (PreferenceService)getContext().getService(com/aviary/android/feather/library/services/PreferenceService);
        ((ImageViewDrawableOverlay)mImageView).setDisplayType(it.sephiroth.android.library.imagezoom.ImageViewTouchBase.DisplayType.FIT_TO_SCREEN);
        ((ImageViewDrawableOverlay)mImageView).setForceSingleSelection(false);
        ((ImageViewDrawableOverlay)mImageView).setDropTargetListener(this);
        ((ImageViewDrawableOverlay)mImageView).setScaleWithContent(true);
        ((ImageViewDrawableOverlay)mImageView).setDoubleTapEnabled(false);
        mEditResult.setActionList(MoaActionFactory.actionList());
        mPicassoLib = Picasso.with(getContext().getBaseContext());
        createAndConfigurePreview();
        bitmap = (DragControllerService)getContext().getService(com/aviary/android/feather/library/services/DragControllerService);
        bitmap.addDropTarget((DropTarget)mImageView);
        bitmap.setMoveTarget(mImageView);
        bitmap.setDragListener(this);
        mDragControllerService = bitmap;
        if (mPreferenceService != null && !mPreferenceService.containsSingleTimeKey(getClass(), "sticker.flip.tooltip", false))
        {
            mStickerFlipToolTip = 0;
            return;
        } else
        {
            mStickerFlipToolTip = 1;
            return;
        }
    }

    public void onDeactivate()
    {
        super.onDeactivate();
        if (mOverlay != null)
        {
            mOverlay.dismiss();
            mOverlay = null;
        }
        if (getDragController() != null)
        {
            getDragController().deactivate();
            getDragController().removeDropTarget((DropTarget)mImageView);
            getDragController().setDragListener(null);
        }
        setDragController(null);
        if (mAdapterPacks != null)
        {
            mAdapterPacks.changeCursor(null);
        }
        if (mAdapterStickers != null)
        {
            mAdapterStickers.changeCursor(null);
        }
        mListPacks.setAdapter(null);
        mListStickers.setAdapter(null);
        mStatus.setOnStatusChangeListener(null);
        mListPacks.setOnItemClickListener(null);
        mListStickers.setOnItemClickListener(null);
        mListStickers.setOnItemLongClickListener(null);
        removeIapDialog();
        Context context = getContext().getBaseContext();
        if (mContentObserver != null)
        {
            context.getContentResolver().unregisterContentObserver(mContentObserver);
        }
        if (mCursorLoaderPacks != null)
        {
            mCursorLoaderPacks.unregisterListener(this);
            mCursorLoaderPacks.stopLoading();
        }
    }

    public void onDestroy()
    {
        super.onDestroy();
        mItemApplied.clear();
        ((ImageViewDrawableOverlay)mImageView).clearOverlays();
        mCurrentFilter = null;
        if (mCursorLoaderPacks != null)
        {
            mCursorLoaderPacks.abandon();
            mCursorLoaderPacks.reset();
        }
        if (mAdapterPacks != null)
        {
            IOUtils.closeSilently(mAdapterPacks.getCursor());
        }
        if (mAdapterStickers != null)
        {
            IOUtils.closeSilently(mAdapterStickers.getCursor());
        }
        mAdapterPacks = null;
        mAdapterStickers = null;
        mCursorLoaderPacks = null;
        closeDatabase();
    }

    protected void onDispose()
    {
        super.onDispose();
        mCanvas = null;
    }

    public boolean onDragEnd()
    {
        return true;
    }

    public void onDragStart(com.aviary.android.feather.library.services.DragControllerService.DragSource dragsource, Object obj, int i)
    {
    }

    public void onDrop(com.aviary.android.feather.library.services.DragControllerService.DragSource dragsource, int i, int j, int k, int l, DragView dragview, Object obj)
    {
        mLogger.info("onDrop. source: %s, x: %d, y: %d, xOffset: %d, yOffset: %d", new Object[] {
            dragsource, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(l)
        });
        while (!isActive() || obj == null || !(obj instanceof StickerDragInfo)) 
        {
            return;
        }
        dragsource = (StickerDragInfo)obj;
        getContext().getTracker().tagEvent("stickers: drag_suceeded");
        onApplyCurrent();
        dragview.getScaleFactorX();
        dragview.getScaleFactorY();
        float f = dragview.getWidth();
        float f1 = dragview.getHeight();
        mLogger.log("w: %f, h: %f", new Object[] {
            Float.valueOf(f), Float.valueOf(f1)
        });
        int i1 = (int)(f / ((StickerDragInfo) (dragsource)).scaleFactor);
        int j1 = (int)(f1 / ((StickerDragInfo) (dragsource)).scaleFactor);
        k = i - k;
        l = j - l;
        j = k;
        i = l;
        if (((StickerDragInfo) (dragsource)).scaleFactor != 1.0F)
        {
            j = (int)((float)k - f / ((StickerDragInfo) (dragsource)).scaleFactor / 2.0F);
            i = (int)((float)l - f1 / ((StickerDragInfo) (dragsource)).scaleFactor / 2.0F);
        }
        dragview = new RectF(j, i, j + i1, i + j1);
        addSticker(((StickerDragInfo) (dragsource)).contentPath, ((StickerDragInfo) (dragsource)).identifier, dragview);
    }

    public void onDropCompleted(DropTarget droptarget, boolean flag)
    {
    }

    protected void onGenerateResult()
    {
        onApplyCurrent();
        onSendEvents();
        super.onGenerateResult(mEditResult);
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        mLogger.info((new StringBuilder()).append("onItemClick: ").append(i).toString());
        if (mOverlay != null)
        {
            mOverlay.hide();
        }
        break MISSING_BLOCK_LABEL_43;
_L7:
        do
        {
            return;
        } while (!isActive() || mStatus.getCurrentStatus() != 1);
        adapterview = (BordersPanel.ViewHolder)view.getTag();
        if (adapterview == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((BordersPanel.ViewHolder) (adapterview)).type != 5 && ((BordersPanel.ViewHolder) (adapterview)).type != 6) goto _L2; else goto _L1
_L1:
        view = new HashMap();
        view.put("from", com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.STICKERS.name().toLowerCase(Locale.US));
        if (((BordersPanel.ViewHolder) (adapterview)).type != 5) goto _L4; else goto _L3
_L3:
        view.put("side", "left");
_L5:
        getContext().getTracker().tagEventAttributes("shop_list: opened", view);
        displayIAPDialog((new com.aviary.android.feather.sdk.widget.IAPDialogMain.IAPUpdater.Builder()).setPackType(com.aviary.android.feather.cds.AviaryCds.PackType.STICKER).setFeaturedPackId(-1L).build());
        return;
_L4:
        if (((BordersPanel.ViewHolder) (adapterview)).type == 6)
        {
            view.put("side", "right");
        }
        if (true) goto _L5; else goto _L2
_L2:
        if (((BordersPanel.ViewHolder) (adapterview)).type == 1)
        {
            view = new HashMap();
            view.put("pack", ((BordersPanel.ViewHolder) (adapterview)).identifier);
            view.put("from", "featured");
            getContext().getTracker().tagEventAttributes("shop_details: opened", view);
            view = new Bundle();
            view.putInt("click_from_position", i);
            displayIAPDialog((new com.aviary.android.feather.sdk.widget.IAPDialogMain.IAPUpdater.Builder()).setPackType(com.aviary.android.feather.cds.AviaryCds.PackType.STICKER).setPackId(((BordersPanel.ViewHolder) (adapterview)).id).setFeaturedPackId(((BordersPanel.ViewHolder) (adapterview)).id).setExtras(view).build());
            return;
        }
        if (((BordersPanel.ViewHolder) (adapterview)).type == 2)
        {
            onStickerPackSelected(((BordersPanel.ViewHolder) (adapterview)).id, ((BordersPanel.ViewHolder) (adapterview)).identifier);
            if (((BordersPanel.ViewHolder) (adapterview)).isNew)
            {
                adapterview.isNew = false;
                loadStickerPackIcon(adapterview, ((BordersPanel.ViewHolder) (adapterview)).id);
                return;
            }
        }
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void onLoadComplete(Loader loader, Cursor cursor)
    {
        String s;
        int i;
        int k;
        int l;
        boolean flag;
        boolean flag1;
        int j1;
        byte byte0;
        int l1;
        int i2;
        byte byte1;
        boolean flag2;
        int j2;
        long l2;
        long l4;
        long l5;
        boolean flag3;
        boolean flag4;
        boolean flag6;
        mLogger.info((new StringBuilder()).append("onLoadComplete: ").append(cursor).append(", currentStatus: ").append(mStatus.getCurrentStatus()).toString());
        l2 = -1L;
        l1 = -1;
        byte0 = -1;
        k = 1;
        byte1 = 1;
        i2 = 0;
        l4 = -1L;
        boolean flag7 = false;
        flag4 = false;
        flag6 = false;
        long l3;
        if (!mFirstTime && mIapDialog != null && mIapDialog.isValid() && mIapDialog.getParent() != null && mIapDialog.getData() != null)
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        l = 0;
        flag1 = true;
        flag2 = true;
        mLogger.info("checkFromIap: %b", new Object[] {
            Boolean.valueOf(flag3)
        });
        l3 = l2;
        if (flag3)
        {
            loader = mIapDialog.getData();
            l3 = l2;
            if (loader.getFeaturedPackId() == loader.getPackId())
            {
                l3 = l2;
                if (loader.getFeaturedPackId() > -1L)
                {
                    l3 = loader.getFeaturedPackId();
                }
            }
        }
        if (l3 > -1L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mLastInstalledPack = -1L;
        i = l;
        l2 = l4;
        if (hasOptions())
        {
            i = l;
            l2 = l4;
            if (mFirstTime)
            {
                i = l;
                l2 = l4;
                if (!flag)
                {
                    loader = getOptions();
                    l2 = loader.getLong("quick-packId", -1L);
                    l4 = loader.getLong("quick-contentId", -1L);
                    mLogger.verbose("options_pack_id: %s, options_content_id: %s", new Object[] {
                        Long.valueOf(l2), Long.valueOf(l4)
                    });
                    loader.remove("quick-packId");
                    if (l2 > -1L && l4 > -1L)
                    {
                        i = 1;
                    } else
                    {
                        i = 0;
                    }
                }
            }
        }
        loader = new ArrayList();
        l = byte0;
        j1 = l1;
        l4 = l2;
        flag3 = flag7;
        if (cursor == null) goto _L2; else goto _L1
_L1:
        j2 = cursor.getPosition();
        flag3 = flag4;
        flag1 = flag2;
        k = byte1;
        j1 = l1;
        l = byte0;
        i2 = i;
_L9:
        if (!cursor.moveToNext()) goto _L4; else goto _L3
_L3:
        if (cursor.getInt(4) != 2)
        {
            continue; /* Loop/switch isn't completed */
        }
        l5 = cursor.getLong(0);
        s = cursor.getString(3);
        mLogger.log("%d = %s", new Object[] {
            Long.valueOf(l5), s
        });
        loader.add(Long.valueOf(l5));
        if (mInstalledPacks.contains(Long.valueOf(l5)) || mFirstTime) goto _L6; else goto _L5
_L5:
        mNewPacks.add(Long.valueOf(l5));
        mLogger.log("adding %d (%s) to new packs", new Object[] {
            Long.valueOf(l5), s
        });
        mLogger.verbose("iapDialogFeaturedId: %d, pack_id: %d", new Object[] {
            Long.valueOf(mLastInstalledPack), Long.valueOf(l5)
        });
        byte0 = flag;
        l1 = i2;
        i = j1;
        byte1 = k;
        l4 = l2;
        flag2 = flag1;
        flag4 = flag3;
        if (flag)
        {
            byte0 = flag;
            l1 = i2;
            i = j1;
            byte1 = k;
            l4 = l2;
            flag2 = flag1;
            flag4 = flag3;
            if (l3 == l5)
            {
                byte0 = flag;
                l1 = i2;
                i = j1;
                byte1 = k;
                l4 = l2;
                flag2 = flag1;
                flag4 = flag3;
                if (mLastInstalledPack == -1L)
                {
                    mLastInstalledPack = l5;
                    i = cursor.getPosition();
                    byte0 = 0;
                    flag4 = true;
                    flag2 = flag1;
                    l4 = l2;
                    byte1 = k;
                    l1 = i2;
                }
            }
        }
_L7:
        flag = byte0;
        i2 = l1;
        j1 = i;
        k = byte1;
        l2 = l4;
        flag1 = flag2;
        flag3 = flag4;
        if (l == -1)
        {
            l = cursor.getPosition();
            flag = byte0;
            i2 = l1;
            j1 = i;
            k = byte1;
            l2 = l4;
            flag1 = flag2;
            flag3 = flag4;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        byte0 = flag;
        l1 = i2;
        i = j1;
        byte1 = k;
        l4 = l2;
        flag2 = flag1;
        flag4 = flag3;
        if (i2 != 0)
        {
            mLogger.verbose("checking options.. %s", new Object[] {
                s
            });
            byte0 = flag;
            l1 = i2;
            i = j1;
            byte1 = k;
            l4 = l2;
            flag2 = flag1;
            flag4 = flag3;
            if (l2 == l5)
            {
                byte0 = flag;
                l1 = i2;
                i = j1;
                byte1 = k;
                l4 = l2;
                flag2 = flag1;
                flag4 = flag3;
                if (mPackInfo == null)
                {
                    mLogger.log("found pack to auto-select: %s", new Object[] {
                        s
                    });
                    i = -1;
                    l4 = -1L;
                    mPackInfo = new StickerPackInfo(cursor.getLong(0), cursor.getString(3));
                    byte1 = 2;
                    l1 = 0;
                    flag2 = true;
                    byte0 = flag;
                    flag4 = flag3;
                }
            }
        }
        if (true) goto _L7; else goto _L4
_L4:
        i2 = cursor.getCount();
        cursor.moveToPosition(j2);
        l4 = l2;
_L2:
        mInstalledPacks.clear();
        mInstalledPacks.addAll(loader);
        int j = j1;
        int k1 = k;
        int i1 = ((flag1) ? 1 : 0);
        if (l == 0)
        {
            j = j1;
            k1 = k;
            i1 = ((flag1) ? 1 : 0);
            if (i2 == 1)
            {
                j = j1;
                k1 = k;
                i1 = ((flag1) ? 1 : 0);
                if (cursor != null)
                {
                    j = j1;
                    k1 = k;
                    i1 = ((flag1) ? 1 : 0);
                    if (mStatus.getCurrentStatus() != 2)
                    {
                        i1 = cursor.getPosition();
                        j = k;
                        if (cursor.moveToFirst())
                        {
                            j = k;
                            if (cursor.getInt(4) == 2)
                            {
                                mLogger.log("one pack only, show it");
                                mPackInfo = new StickerPackInfo(cursor.getLong(0), cursor.getString(3));
                                j = 2;
                            }
                        }
                        cursor.moveToPosition(i1);
                        i1 = 1;
                        k = -1;
                        k1 = j;
                        j = k;
                    }
                }
            }
        }
        k = mStatus.getCurrentStatus();
        mLogger.log("mLastInstalledPack: %d", new Object[] {
            Long.valueOf(mLastInstalledPack)
        });
        mLogger.log("lastInstalledPackIndex: %d", new Object[] {
            Integer.valueOf(j)
        });
        mLogger.log((new StringBuilder()).append("currentStatus: ").append(k).toString());
        mLogger.log((new StringBuilder()).append("newStatus: ").append(k1).toString());
        if (k != 2)
        {
            mStatus.setStatus(k1);
        }
        mAdapterPacks.changeCursor(cursor);
        boolean flag5 = flag6;
        if (j >= 0)
        {
            flag5 = true;
            removeIapDialog();
            l = j;
        }
        onStickersPackListUpdated(cursor, l, flag5, flag3);
        while (openStorePanelIfRequired(l4) || i1 != 0) 
        {
            return;
        }
        createTutorialOverlayIfNecessary(l, mStatus.getCurrentStatus());
        return;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public volatile void onLoadComplete(Loader loader, Object obj)
    {
        onLoadComplete(loader, (Cursor)obj);
    }

    public void onStatusChanged(int i, int j)
    {
        mLogger.info((new StringBuilder()).append("OnStatusChange: ").append(i).append(" >> ").append(j).toString());
        int k;
        int l;
        if (i == 3 || j == 3)
        {
            k = com.aviary.android.feather.sdk.R.anim.aviary_bottobar_in_animation;
            l = com.aviary.android.feather.sdk.R.anim.aviary_bottobar_out_animation;
        } else
        {
            k = com.aviary.android.feather.sdk.R.anim.abc_fade_in;
            l = com.aviary.android.feather.sdk.R.anim.abc_fade_out;
        }
        mViewFlipper.setInAnimation(getContext().getBaseContext(), k);
        mViewFlipper.setOutAnimation(getContext().getBaseContext(), l);
        j;
        JVM INSTR tableswitch 1 3: default 120
    //                   1 172
    //                   2 246
    //                   3 284;
           goto _L1 _L2 _L3 _L4
_L1:
        mLogger.error((new StringBuilder()).append("unmanaged status change: ").append(i).append(" >> ").append(j).toString());
_L6:
        return;
_L2:
        mListStickers.setOnItemClickListener(null);
        mListStickers.setOnItemLongClickListener(null);
        if (mViewFlipper.getDisplayedChild() != 1)
        {
            mViewFlipper.setDisplayedChild(1);
        }
        if (i == 2)
        {
            restoreToolbarTitle();
            if (getDragController() != null)
            {
                getDragController().deactivate();
            }
            if (mAdapterStickers != null)
            {
                mAdapterStickers.changeCursor(null);
                return;
            }
        }
        continue; /* Loop/switch isn't completed */
_L3:
        loadStickers();
        if (mViewFlipper.getDisplayedChild() != 2)
        {
            mViewFlipper.setDisplayedChild(2);
        }
        if (getDragController() != null)
        {
            getDragController().activate();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (mViewFlipper.getDisplayedChild() != 3)
        {
            mViewFlipper.setDisplayedChild(3);
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void onStatusUpdated(int i)
    {
    }

    public void setDragController(DragController dragcontroller)
    {
    }

    public volatile void setEnabled(boolean flag)
    {
        super.setEnabled(flag);
    }

    protected void updateInstalledPacks()
    {
        mLogger.info("updateInstalledPacks");
        if (mViewFlipper.getDisplayedChild() != 0)
        {
            mViewFlipper.setDisplayedChild(0);
        }
        mAdapterPacks = createPacksAdapter(getContext().getBaseContext(), null);
        mListPacks.setAdapter(mAdapterPacks);
        Context context = getContext().getBaseContext();
        if (mCursorLoaderPacks == null)
        {
            mCursorLoaderPacks = new CursorLoader(context, PackageManagerUtils.getCDSProviderContentUri(context, String.format(Locale.US, "packTray/%d/%d/%d/%s", new Object[] {
                Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), "sticker"
            })), null, null, null, null);
            mCursorLoaderPacks.registerListener(1, this);
            mContentObserver = new ContentObserver(new Handler()) {

                final StickersPanel this$0;

                public void onChange(boolean flag)
                {
                    mLogger.info("mContentObserver::onChange");
                    super.onChange(flag);
                    if (isActive() && mCursorLoaderPacks != null && mCursorLoaderPacks.isStarted())
                    {
                        mCursorLoaderPacks.onContentChanged();
                    }
                }

            
            {
                this$0 = StickersPanel.this;
                super(handler);
            }
            };
            context.getContentResolver().registerContentObserver(PackageManagerUtils.getCDSProviderContentUri(context, "packTray/sticker"), false, mContentObserver);
        }
        mCursorLoaderPacks.startLoading();
        mListPacks.setOnItemClickListener(this);
    }








/*
    static long access$1402(StickersPanel stickerspanel, long l)
    {
        stickerspanel.mLastInstalledPack = l;
        return l;
    }

*/










}
