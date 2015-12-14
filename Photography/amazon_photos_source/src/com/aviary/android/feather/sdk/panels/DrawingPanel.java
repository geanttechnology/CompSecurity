// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.panels;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;
import com.aviary.android.feather.common.tracking.AviaryTracker;
import com.aviary.android.feather.headless.moa.MoaAction;
import com.aviary.android.feather.headless.moa.MoaActionFactory;
import com.aviary.android.feather.headless.moa.MoaActionList;
import com.aviary.android.feather.headless.moa.MoaGraphicsCommandParameter;
import com.aviary.android.feather.headless.moa.MoaGraphicsOperationParameter;
import com.aviary.android.feather.headless.moa.MoaPointParameter;
import com.aviary.android.feather.library.content.ToolEntry;
import com.aviary.android.feather.library.services.ConfigService;
import com.aviary.android.feather.library.services.IAviaryController;
import com.aviary.android.feather.library.utils.BitmapUtils;
import com.aviary.android.feather.library.vo.EditToolResultVO;
import com.aviary.android.feather.library.vo.ToolActionVO;
import com.aviary.android.feather.sdk.FeatherActivity;
import com.aviary.android.feather.sdk.graphics.PreviewFillColorDrawable;
import com.aviary.android.feather.sdk.graphics.PreviewFillColorFreetime;
import com.aviary.android.feather.sdk.graphics.PreviewSpotDrawable;
import com.aviary.android.feather.sdk.utils.Maturity;
import com.aviary.android.feather.sdk.utils.UIUtils;
import com.aviary.android.feather.sdk.widget.AviaryAdapterView;
import com.aviary.android.feather.sdk.widget.AviaryGallery;
import com.aviary.android.feather.sdk.widget.AviaryHighlightImageButton;
import com.aviary.android.feather.sdk.widget.ImageViewTouchAndDraw;
import com.aviary.android.feather.sdk.widget.VibrationWidget;
import it.sephiroth.android.library.imagezoom.ImageViewTouch;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

// Referenced classes of package com.aviary.android.feather.sdk.panels:
//            AbstractContentPanel

public class DrawingPanel extends AbstractContentPanel
    implements android.view.View.OnClickListener, com.aviary.android.feather.sdk.widget.ImageViewTouchAndDraw.OnDrawPathListener, com.aviary.android.feather.sdk.widget.ImageViewTouchAndDraw.OnDrawStartListener
{
    private static final class DrawinTool extends Enum
    {

        private static final DrawinTool $VALUES[];
        public static final DrawinTool Draw;
        public static final DrawinTool Erase;
        public static final DrawinTool Zoom;

        public static DrawinTool valueOf(String s)
        {
            return (DrawinTool)Enum.valueOf(com/aviary/android/feather/sdk/panels/DrawingPanel$DrawinTool, s);
        }

        public static DrawinTool[] values()
        {
            return (DrawinTool[])$VALUES.clone();
        }

        static 
        {
            Draw = new DrawinTool("Draw", 0);
            Erase = new DrawinTool("Erase", 1);
            Zoom = new DrawinTool("Zoom", 2);
            $VALUES = (new DrawinTool[] {
                Draw, Erase, Zoom
            });
        }

        private DrawinTool(String s, int i)
        {
            super(s, i);
        }
    }

    class GalleryColorAdapter extends BaseAdapter
    {

        public static final int ERASER_POSITION = 2;
        public static final int INVALID_POSITION = 1;
        public static final int VALID_POSITION = 0;
        LayoutInflater mLayoutInflater;
        Resources mRes;
        private int sizes[];
        final DrawingPanel this$0;

        public int getCount()
        {
            return sizes.length;
        }

        public Object getItem(int i)
        {
            return Integer.valueOf(sizes[i]);
        }

        public long getItemId(int i)
        {
            return 0L;
        }

        public int getItemViewType(int i)
        {
            boolean flag;
            if (i >= 0 && i < getCount())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                return 1;
            }
            return ((Integer)getItem(i)).intValue() != 0 ? 0 : 2;
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            int l = getItemViewType(i);
            View view1 = null;
            if (view == null)
            {
                if (l == 2)
                {
                    int j;
                    if (FeatherActivity.MATURITY.isKidsFriendly())
                    {
                        view = mLayoutInflater.inflate(com.aviary.android.feather.sdk.R.layout.aviary_gallery_item_highlight_view_freetime, viewgroup, false);
                    } else
                    {
                        view = mLayoutInflater.inflate(com.aviary.android.feather.sdk.R.layout.aviary_gallery_item_highlight_view, viewgroup, false);
                    }
                    view.setContentDescription(mEraserContentDescription);
                } else
                {
                    view = mLayoutInflater;
                    int k;
                    if (FeatherActivity.MATURITY.isKidsFriendly())
                    {
                        k = com.aviary.android.feather.sdk.R.layout.aviary_gallery_item_view_freetime_row2;
                    } else
                    {
                        k = com.aviary.android.feather.sdk.R.layout.aviary_gallery_item_view;
                    }
                    view = view.inflate(k, viewgroup, false);
                }
                viewgroup = view1;
                view1 = view;
                if (l == 0)
                {
                    viewgroup = getContext().getBaseContext();
                    if (FeatherActivity.MATURITY.isKidsFriendly())
                    {
                        viewgroup = new PreviewFillColorFreetime(viewgroup);
                    } else
                    {
                        viewgroup = new PreviewFillColorDrawable(viewgroup);
                    }
                    ((ImageView)view.findViewById(com.aviary.android.feather.sdk.R.id.image)).setImageDrawable(viewgroup);
                    view.setTag(viewgroup);
                    view1 = view;
                }
            } else
            {
                viewgroup = view1;
                view1 = view;
                if (l == 0)
                {
                    viewgroup = (PreviewFillColorDrawable)view.getTag();
                    view1 = view;
                }
            }
            if (viewgroup != null && l == 0)
            {
                j = sizes[i];
                boolean flag;
                if (mBrushColorIndex == i)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                viewgroup.setSelected(flag);
                viewgroup.setColor(j);
                try
                {
                    view1.setContentDescription((new StringBuilder()).append(mColorContentDescription).append(" ").append(Integer.toHexString(j)).toString());
                }
                // Misplaced declaration of an exception variable
                catch (View view) { }
            } else
            if (l == 2 && FeatherActivity.MATURITY.isKidsFriendly())
            {
                if (i == mBrushColorIndex)
                {
                    view1.findViewById(com.aviary.android.feather.sdk.R.id.image2).setVisibility(0);
                    view1.findViewById(com.aviary.android.feather.sdk.R.id.image).setVisibility(8);
                } else
                {
                    view1.findViewById(com.aviary.android.feather.sdk.R.id.image2).setVisibility(8);
                    view1.findViewById(com.aviary.android.feather.sdk.R.id.image).setVisibility(0);
                }
            }
            view1.setId(i);
            return view1;
        }

        public int getViewTypeCount()
        {
            return 3;
        }

        public GalleryColorAdapter(Context context, int ai[])
        {
            this$0 = DrawingPanel.this;
            super();
            mLayoutInflater = LayoutInflater.from(context);
            sizes = ai;
            mRes = context.getResources();
        }
    }

    class GallerySizeAdapter extends BaseAdapter
    {

        public static final float BRUSH_SIZE_RATIO = 0.55F;
        private static final int INVALID_POSITION = 1;
        private static final int VALID_POSITION = 0;
        LayoutInflater mLayoutInflater;
        Resources mRes;
        private int sizes[];
        final DrawingPanel this$0;

        private int getSizeDrawableForPosition(int i, boolean flag)
        {
            switch (i)
            {
            default:
                return -1;

            case 0: // '\0'
                if (flag)
                {
                    return com.aviary.android.feather.sdk.R.drawable.aviary_tool_draw_0_selected;
                } else
                {
                    return com.aviary.android.feather.sdk.R.drawable.aviary_tool_draw_0;
                }

            case 1: // '\001'
                if (flag)
                {
                    return com.aviary.android.feather.sdk.R.drawable.aviary_tool_draw_1_selected;
                } else
                {
                    return com.aviary.android.feather.sdk.R.drawable.aviary_tool_draw_1;
                }

            case 2: // '\002'
                if (flag)
                {
                    return com.aviary.android.feather.sdk.R.drawable.aviary_tool_draw_2_selected;
                } else
                {
                    return com.aviary.android.feather.sdk.R.drawable.aviary_tool_draw_2;
                }

            case 3: // '\003'
                break;
            }
            if (flag)
            {
                return com.aviary.android.feather.sdk.R.drawable.aviary_tool_draw_3_selected;
            } else
            {
                return com.aviary.android.feather.sdk.R.drawable.aviary_tool_draw_3;
            }
        }

        public int getCount()
        {
            return sizes.length;
        }

        public Object getItem(int i)
        {
            return Integer.valueOf(sizes[i]);
        }

        public long getItemId(int i)
        {
            return 0L;
        }

        public int getItemViewType(int i)
        {
            if (i >= 0 && i < getCount())
            {
                i = 1;
            } else
            {
                i = 0;
            }
            return i == 0 ? 1 : 0;
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            int k = getItemViewType(i);
            Object obj1 = null;
            Object obj;
            if (view == null)
            {
                view = mLayoutInflater;
                int j;
                if (FeatherActivity.MATURITY.isKidsFriendly())
                {
                    j = com.aviary.android.feather.sdk.R.layout.aviary_gallery_item_view_freetime_row1;
                } else
                {
                    j = com.aviary.android.feather.sdk.R.layout.aviary_gallery_item_view;
                }
                view = view.inflate(j, viewgroup, false);
                viewgroup = obj1;
                obj = view;
                if (k == 0)
                {
                    obj = (ImageView)view.findViewById(com.aviary.android.feather.sdk.R.id.image);
                    float f;
                    if (FeatherActivity.MATURITY.isKidsFriendly())
                    {
                        ((ImageView) (obj)).setImageResource(getSizeDrawableForPosition(i, false));
                        ((ImageView)view.findViewById(com.aviary.android.feather.sdk.R.id.image2)).setImageResource(getSizeDrawableForPosition(i, true));
                        obj = view;
                        viewgroup = obj1;
                    } else
                    {
                        viewgroup = new PreviewSpotDrawable(getContext().getBaseContext());
                        ((ImageView) (obj)).setImageDrawable(viewgroup);
                        view.setTag(viewgroup);
                        obj = view;
                    }
                }
            } else
            {
                viewgroup = obj1;
                obj = view;
                if (k == 0)
                {
                    if (!FeatherActivity.MATURITY.isKidsFriendly())
                    {
                        viewgroup = (PreviewSpotDrawable)view.getTag();
                        obj = view;
                    } else
                    {
                        ((ImageView)view.findViewById(com.aviary.android.feather.sdk.R.id.image)).setImageResource(getSizeDrawableForPosition(i, false));
                        ((ImageView)view.findViewById(com.aviary.android.feather.sdk.R.id.image2)).setImageResource(getSizeDrawableForPosition(i, true));
                        viewgroup = obj1;
                        obj = view;
                    }
                }
            }
            if (viewgroup != null && k == 0)
            {
                j = sizes[i];
                f = minRadiusSize + (((float)j - (float)minBrushSize) / (float)(maxBrushSize - minBrushSize)) * (maxRadiusSize - minRadiusSize) * 0.55F;
                try
                {
                    ((View) (obj)).setContentDescription((new StringBuilder()).append(mSizeContentDescription).append(" ").append(Float.toString(f)).toString());
                }
                // Misplaced declaration of an exception variable
                catch (View view) { }
                viewgroup.setRadius(f);
            } else
            if (k == 0 && FeatherActivity.MATURITY.isKidsFriendly())
            {
                if (i == mBrushSizeIndex)
                {
                    ((View) (obj)).findViewById(com.aviary.android.feather.sdk.R.id.image).setVisibility(8);
                    ((View) (obj)).findViewById(com.aviary.android.feather.sdk.R.id.image2).setVisibility(0);
                } else
                {
                    ((View) (obj)).findViewById(com.aviary.android.feather.sdk.R.id.image).setVisibility(0);
                    ((View) (obj)).findViewById(com.aviary.android.feather.sdk.R.id.image2).setVisibility(8);
                }
            }
            ((View) (obj)).setId(i);
            return ((View) (obj));
        }

        public int getViewTypeCount()
        {
            return 2;
        }

        public GallerySizeAdapter(Context context, int ai[])
        {
            this$0 = DrawingPanel.this;
            super();
            mLayoutInflater = LayoutInflater.from(context);
            sizes = ai;
            mRes = context.getResources();
        }
    }


    MoaAction mAction;
    MoaActionList mActionList;
    private int mBlur;
    private int mBrushColorIndex;
    int mBrushColors[];
    private int mBrushSizeIndex;
    int mBrushSizes[];
    private int mColor;
    String mColorContentDescription;
    private ConfigService mConfig;
    MoaGraphicsOperationParameter mCurrentOperation;
    PreviewFillColorDrawable mDrawable;
    String mEraserContentDescription;
    PreviewSpotDrawable mEraserDrawable;
    protected AviaryGallery mGalleryColor;
    protected AviaryGallery mGallerySize;
    int mHeight;
    protected AviaryHighlightImageButton mLensButton;
    Collection mOperations;
    private Paint mPaint;
    protected int mSelectedColorPosition;
    protected int mSelectedSizePosition;
    private DrawinTool mSelectedTool;
    private int mSize;
    String mSizeContentDescription;
    Toast mToast;
    ToolActionVO mToolAction;
    int mWidth;
    private int maxBrushSize;
    private float maxRadiusSize;
    private int minBrushSize;
    private float minRadiusSize;

    public DrawingPanel(IAviaryController iaviarycontroller, ToolEntry toolentry)
    {
        super(iaviarycontroller, toolentry);
        mSelectedSizePosition = 0;
        mColor = 0;
        mSize = 10;
        mBlur = 1;
    }

    private DrawinTool getSelectedTool()
    {
        return mSelectedTool;
    }

    private Paint initPaint(Paint paint)
    {
        paint.setDither(true);
        paint.setAntiAlias(true);
        paint.setFilterBitmap(false);
        paint.setColor(mColor);
        paint.setStrokeWidth(mSize * 2);
        paint.setStyle(android.graphics.Paint.Style.STROKE);
        paint.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        paint.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        paint.setMaskFilter(new BlurMaskFilter(mBlur, android.graphics.BlurMaskFilter.Blur.NORMAL));
        return paint;
    }

    private Toast makeToast()
    {
        mDrawable = new PreviewFillColorDrawable(getContext().getBaseContext());
        mEraserDrawable = new PreviewSpotDrawable(getContext().getBaseContext());
        Toast toast = UIUtils.makeCustomToast(getContext().getBaseContext());
        ((ImageView)toast.getView().findViewById(com.aviary.android.feather.sdk.R.id.image)).setImageDrawable(mDrawable);
        return toast;
    }

    private void resetBitmap()
    {
        getContext().getCurrentImageViewMatrix();
        mImageView.setImageBitmap(mBitmap, null, -1F, 8F);
        ((ImageViewTouchAndDraw)mImageView).setDrawMode(com.aviary.android.feather.sdk.widget.ImageViewTouchAndDraw.TouchMode.DRAW);
    }

    private void setSelectedTool(DrawinTool drawintool)
    {
        boolean flag1 = true;
        static class _cls3
        {

            static final int $SwitchMap$com$aviary$android$feather$sdk$panels$DrawingPanel$DrawinTool[];

            static 
            {
                $SwitchMap$com$aviary$android$feather$sdk$panels$DrawingPanel$DrawinTool = new int[DrawinTool.values().length];
                try
                {
                    $SwitchMap$com$aviary$android$feather$sdk$panels$DrawingPanel$DrawinTool[DrawinTool.Draw.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$sdk$panels$DrawingPanel$DrawinTool[DrawinTool.Erase.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$sdk$panels$DrawingPanel$DrawinTool[DrawinTool.Zoom.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls3..SwitchMap.com.aviary.android.feather.sdk.panels.DrawingPanel.DrawinTool[drawintool.ordinal()];
        JVM INSTR tableswitch 1 3: default 36
    //                   1 76
    //                   2 111
    //                   3 196;
           goto _L1 _L2 _L3 _L4
_L1:
        break; /* Loop/switch isn't completed */
_L4:
        break MISSING_BLOCK_LABEL_196;
_L5:
        AviaryHighlightImageButton aviaryhighlightimagebutton = mLensButton;
        boolean flag;
        if (drawintool == DrawinTool.Zoom)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        aviaryhighlightimagebutton.setSelected(flag);
        if (drawintool != DrawinTool.Zoom)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        setPanelEnabled(flag);
        mSelectedTool = drawintool;
        return;
_L2:
        ((ImageViewTouchAndDraw)mImageView).setDrawMode(com.aviary.android.feather.sdk.widget.ImageViewTouchAndDraw.TouchMode.DRAW);
        mPaint.setAlpha(255);
        mPaint.setXfermode(null);
          goto _L5
_L3:
        ((ImageViewTouchAndDraw)mImageView).setDrawMode(com.aviary.android.feather.sdk.widget.ImageViewTouchAndDraw.TouchMode.DRAW);
        mPaint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.CLEAR));
        mPaint.setAlpha(0);
        getContext().getTracker().tagEvent((new StringBuilder()).append(com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.DRAW.name().toLowerCase(Locale.US)).append(": eraser_selected").toString());
          goto _L5
        ((ImageViewTouchAndDraw)mImageView).setDrawMode(com.aviary.android.feather.sdk.widget.ImageViewTouchAndDraw.TouchMode.IMAGE);
          goto _L5
    }

    private void setupFill()
    {
        mGalleryColor.setDefaultPosition(mBrushColorIndex);
        mGalleryColor.setCallbackDuringFling(true);
        mGalleryColor.setAutoSelectChild(true);
        mGalleryColor.setAdapter(new GalleryColorAdapter(getContext().getBaseContext(), mBrushColors));
    }

    private void setupSize()
    {
        mGallerySize.setDefaultPosition(mBrushSizeIndex);
        mGallerySize.setCallbackDuringFling(true);
        mGallerySize.setAutoSelectChild(true);
        mGallerySize.setAdapter(new GallerySizeAdapter(getContext().getBaseContext(), mBrushSizes));
    }

    private void updateToast()
    {
        int j = mGalleryColor.getSelectedItemPosition();
        int i = mGallerySize.getSelectedItemPosition();
        if (mToast != null && j > -1 && i > -1)
        {
            j = mBrushColors[j];
            i = mBrushSizes[i];
            ImageView imageview = (ImageView)mToast.getView().findViewById(com.aviary.android.feather.sdk.R.id.image);
            if (j != 0)
            {
                mDrawable.setFixedRadius(i);
                mDrawable.setColor(j);
                imageview.setImageDrawable(mDrawable);
            } else
            {
                mEraserDrawable.setFixedRadius(i);
                imageview.setImageDrawable(mEraserDrawable);
            }
            mToast.show();
        }
    }

    protected View generateContentView(LayoutInflater layoutinflater)
    {
        return layoutinflater.inflate(com.aviary.android.feather.sdk.R.layout.aviary_content_draw, null);
    }

    protected ViewGroup generateOptionView(LayoutInflater layoutinflater, ViewGroup viewgroup)
    {
        int i;
        if (FeatherActivity.MATURITY.isKidsFriendly())
        {
            i = com.aviary.android.feather.sdk.R.layout.aviary_panel_draw_freetime;
        } else
        {
            i = com.aviary.android.feather.sdk.R.layout.aviary_panel_draw;
        }
        return (ViewGroup)layoutinflater.inflate(i, viewgroup, false);
    }

    public volatile boolean isRendering()
    {
        return super.isRendering();
    }

    public void onActivate()
    {
        super.onActivate();
        disableHapticIsNecessary(new VibrationWidget[] {
            mGalleryColor, mGallerySize
        });
        mGallerySize.setOnItemsScrollListener(new com.aviary.android.feather.sdk.widget.AviaryGallery.OnItemsScrollListener() {

            final DrawingPanel this$0;

            public void onScroll(AviaryAdapterView aviaryadapterview, View view, int i, long l)
            {
                mLogger.log((new StringBuilder()).append("onScroll: ").append(i).toString());
                mBrushSizeIndex = i;
                updateToast();
                mGallerySize.invalidateViews();
            }

            public void onScrollFinished(AviaryAdapterView aviaryadapterview, View view, int i, long l)
            {
                mSize = Math.max(4, mBrushSizes[i]);
                mBrushSizeIndex = i;
                mPaint.setStrokeWidth(mSize * 2);
                mGallerySize.invalidateViews();
                if (mGalleryColor.getAdapter().getItemViewType(mGalleryColor.getSelectedItemPosition()) == 2)
                {
                    setSelectedTool(DrawinTool.Erase);
                    return;
                } else
                {
                    setSelectedTool(DrawinTool.Draw);
                    return;
                }
            }

            public void onScrollStarted(AviaryAdapterView aviaryadapterview, View view, int i, long l)
            {
                if (getSelectedTool() == DrawinTool.Zoom)
                {
                    setSelectedTool(DrawinTool.Draw);
                }
            }

            
            {
                this$0 = DrawingPanel.this;
                super();
            }
        });
        mGalleryColor.setOnItemsScrollListener(new com.aviary.android.feather.sdk.widget.AviaryGallery.OnItemsScrollListener() {

            final DrawingPanel this$0;

            public void onScroll(AviaryAdapterView aviaryadapterview, View view, int i, long l)
            {
                mLogger.log((new StringBuilder()).append("onScroll: ").append(i).toString());
                updateToast();
                mColor = mBrushColors[i];
                mBrushColorIndex = i;
                mPaint.setColor(mColor);
                mGalleryColor.invalidateViews();
            }

            public void onScrollFinished(AviaryAdapterView aviaryadapterview, View view, int i, long l)
            {
                mColor = mBrushColors[i];
                mBrushColorIndex = i;
                mPaint.setColor(mColor);
                if (mColor == 0)
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                if (getSelectedTool() != DrawinTool.Zoom) goto _L2; else goto _L1
_L1:
                if (i != 0)
                {
                    setSelectedTool(DrawinTool.Erase);
                } else
                {
                    setSelectedTool(DrawinTool.Draw);
                }
_L4:
                mGalleryColor.invalidateViews();
                return;
_L2:
                if (i != 0 && getSelectedTool() != DrawinTool.Erase)
                {
                    setSelectedTool(DrawinTool.Erase);
                } else
                if (i == 0 && getSelectedTool() != DrawinTool.Draw)
                {
                    setSelectedTool(DrawinTool.Draw);
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            public void onScrollStarted(AviaryAdapterView aviaryadapterview, View view, int i, long l)
            {
                if (getSelectedTool() == DrawinTool.Zoom)
                {
                    setSelectedTool(DrawinTool.Draw);
                }
            }

            
            {
                this$0 = DrawingPanel.this;
                super();
            }
        });
        mLensButton.setOnClickListener(this);
        setSelectedTool(DrawinTool.Draw);
        ((ImageViewTouchAndDraw)mImageView).setOnDrawStartListener(this);
        ((ImageViewTouchAndDraw)mImageView).setOnDrawPathListener(this);
        getContentView().setVisibility(0);
        contentReady();
    }

    public void onBitmapReplaced(Bitmap bitmap)
    {
        super.onBitmapReplaced(bitmap);
        if (isActive())
        {
            resetBitmap();
        }
    }

    public void onClick(View view)
    {
label0:
        {
            if (view.getId() == mLensButton.getId())
            {
                boolean flag;
                if (!view.isSelected())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                view.setSelected(flag);
                mLogger.info((new StringBuilder()).append("isSelected: ").append(view.isSelected()).toString());
                mLogger.info((new StringBuilder()).append("selectedToolPos: ").append(mGalleryColor.getSelectedItemPosition()).toString());
                if (!view.isSelected())
                {
                    break label0;
                }
                setSelectedTool(DrawinTool.Zoom);
            }
            return;
        }
        if (mGalleryColor.getSelectedItemPosition() == 0)
        {
            setSelectedTool(DrawinTool.Erase);
            return;
        } else
        {
            setSelectedTool(DrawinTool.Draw);
            return;
        }
    }

    public void onCreate(Bitmap bitmap, Bundle bundle)
    {
        super.onCreate(bitmap, bundle);
        mConfig = (ConfigService)getContext().getService(com/aviary/android/feather/library/services/ConfigService);
        minRadiusSize = (float)mConfig.getInteger(com.aviary.android.feather.sdk.R.integer.aviary_spot_gallery_item_min_size) / 100F;
        maxRadiusSize = (float)mConfig.getInteger(com.aviary.android.feather.sdk.R.integer.aviary_spot_gallery_item_max_size) / 100F;
        mEraserContentDescription = mConfig.getString(com.aviary.android.feather.sdk.R.string.feather_colorsplash_eraser);
        mColorContentDescription = mConfig.getString(com.aviary.android.feather.sdk.R.string.feather_acc_color);
        mSizeContentDescription = mConfig.getString(com.aviary.android.feather.sdk.R.string.feather_acc_size);
        if (FeatherActivity.MATURITY.isKidsFriendly())
        {
            mBrushSizes = mConfig.getIntArray(com.aviary.android.feather.sdk.R.array.aviary_freetime_draw_brush_sizes);
            mBrushSizeIndex = mConfig.getInteger(com.aviary.android.feather.sdk.R.integer.aviary_freetime_draw_brush_index);
            mBrushColorIndex = mConfig.getInteger(com.aviary.android.feather.sdk.R.integer.aviary_freetime_draw_fill_color_index);
        } else
        {
            mBrushSizes = mConfig.getIntArray(com.aviary.android.feather.sdk.R.array.aviary_draw_brush_sizes);
            mBrushSizeIndex = mConfig.getInteger(com.aviary.android.feather.sdk.R.integer.aviary_draw_brush_index);
            mBrushColorIndex = mConfig.getInteger(com.aviary.android.feather.sdk.R.integer.aviary_draw_fill_color_index);
        }
        mBrushColors = mConfig.getIntArray(com.aviary.android.feather.sdk.R.array.aviary_draw_fill_colors);
        minBrushSize = mBrushSizes[0];
        maxBrushSize = mBrushSizes[mBrushSizes.length - 1];
        mBlur = mConfig.getInteger(com.aviary.android.feather.sdk.R.integer.aviary_draw_brush_softValue);
        mColor = mBrushColors[mBrushColorIndex];
        mSize = mBrushSizes[mBrushSizeIndex];
        mLensButton = (AviaryHighlightImageButton)getContentView().findViewById(com.aviary.android.feather.sdk.R.id.aviary_lens_button);
        mGallerySize = (AviaryGallery)getOptionView().findViewById(com.aviary.android.feather.sdk.R.id.aviary_gallery);
        mGalleryColor = (AviaryGallery)getOptionView().findViewById(com.aviary.android.feather.sdk.R.id.aviary_gallery2);
        mImageView = (ImageViewTouchAndDraw)getContentView().findViewById(com.aviary.android.feather.sdk.R.id.image);
        mImageView.setDisplayType(it.sephiroth.android.library.imagezoom.ImageViewTouchBase.DisplayType.FIT_TO_SCREEN);
        mToast = makeToast();
        mWidth = mBitmap.getWidth();
        mHeight = mBitmap.getHeight();
        resetBitmap();
        mSelectedColorPosition = 1;
        mSelectedSizePosition = 0;
        mOperations = new ArrayList();
        mCurrentOperation = null;
        mActionList = MoaActionFactory.actionList(new String[] {
            "draw"
        });
        mToolAction = new ToolActionVO(Integer.valueOf(0));
        mAction = mActionList.get(0);
        mAction.setValue("previewSize", new MoaPointParameter(mWidth, mHeight));
        mAction.setValue("commands", mOperations);
        setupFill();
        setupSize();
        mPaint = initPaint(((ImageViewTouchAndDraw)mImageView).getPaint());
        ((ImageViewTouchAndDraw)mImageView).setPaint(mPaint);
    }

    public void onDeactivate()
    {
        ((ImageViewTouchAndDraw)mImageView).setOnDrawStartListener(null);
        ((ImageViewTouchAndDraw)mImageView).setOnDrawPathListener(null);
        mLensButton.setOnClickListener(null);
        mGalleryColor.setOnItemsScrollListener(null);
        mGallerySize.setOnItemsScrollListener(null);
        if (mToast != null)
        {
            mToast.cancel();
        }
        super.onDeactivate();
    }

    public void onDestroy()
    {
        super.onDestroy();
        mImageView.clear();
    }

    public void onDrawStart()
    {
        setIsChanged(true);
    }

    public void onEnd()
    {
        mLogger.info("onEnd");
        if (mCurrentOperation != null)
        {
            mOperations.add(mCurrentOperation);
        }
    }

    protected void onGenerateResult()
    {
        Bitmap bitmap;
        Canvas canvas;
        if (!mBitmap.isMutable())
        {
            bitmap = BitmapUtils.copy(mBitmap, mBitmap.getConfig());
        } else
        {
            bitmap = mBitmap;
        }
        canvas = new Canvas(bitmap);
        ((ImageViewTouchAndDraw)mImageView).commit(canvas);
        ((ImageViewTouchAndDraw)mImageView).setImageBitmap(bitmap, mImageView.getDisplayMatrix(), -1F, -1F);
        mEditResult.setToolAction(mToolAction);
        mEditResult.setActionList(mActionList);
        onComplete(bitmap);
    }

    public void onLineTo(float f, float f1)
    {
        if (mCurrentOperation != null)
        {
            mCurrentOperation.addCommand(new MoaGraphicsCommandParameter(1, f, f1));
        }
    }

    public void onMoveTo(float f, float f1)
    {
        if (mCurrentOperation != null)
        {
            mCurrentOperation.addCommand(new MoaGraphicsCommandParameter(0, f, f1));
        }
    }

    public void onQuadTo(float f, float f1, float f2, float f3)
    {
        if (mCurrentOperation != null)
        {
            mCurrentOperation.addCommand(new MoaGraphicsCommandParameter(2, f, f1, f2, f3));
        }
    }

    public void onStart()
    {
        mLogger.info("onStart");
        float f = ((ImageViewTouchAndDraw)mImageView).getDrawingScale();
        int j = mBlur;
        float f1 = mSize * 2;
        int k = mColor;
        int i;
        if (getSelectedTool() == DrawinTool.Erase)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        mCurrentOperation = new MoaGraphicsOperationParameter(j, f1 * f, k, i);
    }

    public volatile void setEnabled(boolean flag)
    {
        super.setEnabled(flag);
    }

    public void setPanelEnabled(boolean flag)
    {
        if (!isActive())
        {
            return;
        }
        View view;
        byte byte0;
        if (flag)
        {
            getContext().restoreToolbarTitle();
        } else
        {
            getContext().setToolbarTitle(com.aviary.android.feather.sdk.R.string.feather_zoom_mode);
        }
        view = mOptionView.findViewById(com.aviary.android.feather.sdk.R.id.aviary_disable_status);
        if (flag)
        {
            byte0 = 4;
        } else
        {
            byte0 = 0;
        }
        view.setVisibility(byte0);
    }



/*
    static int access$002(DrawingPanel drawingpanel, int i)
    {
        drawingpanel.mSize = i;
        return i;
    }

*/




/*
    static int access$102(DrawingPanel drawingpanel, int i)
    {
        drawingpanel.mBrushSizeIndex = i;
        return i;
    }

*/








/*
    static int access$602(DrawingPanel drawingpanel, int i)
    {
        drawingpanel.mColor = i;
        return i;
    }

*/



/*
    static int access$702(DrawingPanel drawingpanel, int i)
    {
        drawingpanel.mBrushColorIndex = i;
        return i;
    }

*/


}
