// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.panels;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.aviary.android.feather.common.tracking.AviaryTracker;
import com.aviary.android.feather.headless.moa.MoaActionFactory;
import com.aviary.android.feather.headless.moa.MoaActionList;
import com.aviary.android.feather.library.content.ToolEntry;
import com.aviary.android.feather.library.filters.TextFilter;
import com.aviary.android.feather.library.filters.ToolLoaderFactory;
import com.aviary.android.feather.library.graphics.drawable.AviaryTextDrawable;
import com.aviary.android.feather.library.graphics.drawable.EditableDrawable;
import com.aviary.android.feather.library.graphics.drawable.FeatherDrawable;
import com.aviary.android.feather.library.services.ConfigService;
import com.aviary.android.feather.library.services.IAviaryController;
import com.aviary.android.feather.library.utils.BitmapUtils;
import com.aviary.android.feather.library.utils.MatrixUtils;
import com.aviary.android.feather.library.vo.EditToolResultVO;
import com.aviary.android.feather.library.vo.ToolActionVO;
import com.aviary.android.feather.sdk.FeatherActivity;
import com.aviary.android.feather.sdk.graphics.PreviewFillColorDrawable;
import com.aviary.android.feather.sdk.graphics.PreviewFillColorFreetime;
import com.aviary.android.feather.sdk.utils.Maturity;
import com.aviary.android.feather.sdk.widget.AviaryAdapterView;
import com.aviary.android.feather.sdk.widget.AviaryGallery;
import com.aviary.android.feather.sdk.widget.DrawableHighlightView;
import com.aviary.android.feather.sdk.widget.ImageViewDrawableOverlay;
import com.aviary.android.feather.sdk.widget.VibrationWidget;
import it.sephiroth.android.library.imagezoom.ImageViewTouch;

// Referenced classes of package com.aviary.android.feather.sdk.panels:
//            AbstractContentPanel

public class TextPanel extends AbstractContentPanel
    implements android.view.View.OnKeyListener, android.widget.TextView.OnEditorActionListener, com.aviary.android.feather.sdk.widget.AviaryGallery.OnItemsScrollListener, com.aviary.android.feather.sdk.widget.ImageViewDrawableOverlay.OnDrawableEventListener
{
    class GalleryAdapter extends BaseAdapter
    {

        private static final int INVALID_POSITION = 1;
        private static final int VALID_POSITION = 0;
        LayoutInflater mLayoutInflater;
        Resources mRes;
        private int sizes[];
        final TextPanel this$0;

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
            boolean flag1 = true;
            int k = getItemViewType(i);
            viewgroup = null;
            View view1;
            if (view == null)
            {
                view = mLayoutInflater;
                int j;
                if (FeatherActivity.MATURITY.isKidsFriendly())
                {
                    j = com.aviary.android.feather.sdk.R.layout.aviary_gallery_item_view_freetime_row2;
                } else
                {
                    j = com.aviary.android.feather.sdk.R.layout.aviary_gallery_item_view;
                }
                view = view.inflate(j, mGallery, false);
                view1 = view;
                if (k == 0)
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
                view1 = view;
                if (k == 0)
                {
                    viewgroup = (PreviewFillColorDrawable)view.getTag();
                    view1 = view;
                }
            }
            if (viewgroup != null && k == 0)
            {
                j = sizes[i];
                boolean flag;
                if (i == mSelectedPosition)
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
            }
            if (mSelectedPosition == i)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            view1.setSelected(flag);
            view1.setId(i);
            return view1;
        }

        public int getViewTypeCount()
        {
            return 2;
        }

        public GalleryAdapter(Context context, int ai[])
        {
            this$0 = TextPanel.this;
            super();
            mLayoutInflater = LayoutInflater.from(context);
            sizes = ai;
            mRes = context.getResources();
        }
    }

    abstract class MyTextWatcher
        implements TextWatcher
    {

        final TextPanel this$0;
        public DrawableHighlightView view;

        MyTextWatcher()
        {
            this$0 = TextPanel.this;
            super();
        }
    }


    private ConfigService config;
    private Canvas mCanvas;
    private int mColor;
    String mColorContentDescription;
    private int mColors[];
    private int mDefaultTextSize;
    private EditText mEditText;
    private final MyTextWatcher mEditTextWatcher = new MyTextWatcher() {

        final TextPanel this$0;

        public void afterTextChanged(Editable editable)
        {
            mLogger.info("afterTextChanged");
        }

        public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
        {
            mLogger.info("beforeTextChanged");
        }

        public void onTextChanged(CharSequence charsequence, int i, int j, int k)
        {
            EditableDrawable editabledrawable;
label0:
            {
                if (view != null && (view.getContent() instanceof EditableDrawable))
                {
                    editabledrawable = (EditableDrawable)view.getContent();
                    if (editabledrawable.isEditing())
                    {
                        break label0;
                    }
                }
                return;
            }
            editabledrawable.setText(charsequence.toString());
        }

            
            {
                this$0 = TextPanel.this;
                super();
            }
    };
    private AviaryGallery mGallery;
    private int mSelectedPosition;
    ToolActionVO mToolAction;

    public TextPanel(IAviaryController iaviarycontroller, ToolEntry toolentry)
    {
        super(iaviarycontroller, toolentry);
        mColor = 0;
        mToolAction = new ToolActionVO();
    }

    private void beginEdit(DrawableHighlightView drawablehighlightview)
    {
        if (drawablehighlightview != null)
        {
            drawablehighlightview.setFocused(true);
            mImageView.postInvalidate();
        }
        mEditTextWatcher.view = null;
        mEditText.removeTextChangedListener(mEditTextWatcher);
        Object obj = (EditableDrawable)drawablehighlightview.getContent();
        if (((EditableDrawable) (obj)).isTextHint())
        {
            obj = "";
        } else
        {
            obj = (String)((EditableDrawable) (obj)).getText();
        }
        mEditText.setText(((CharSequence) (obj)));
        mEditText.setSelection(mEditText.length());
        mEditText.requestFocusFromTouch();
        obj = (InputMethodManager)getContext().getBaseContext().getSystemService("input_method");
        if (obj != null)
        {
            ((InputMethodManager) (obj)).showSoftInput(mEditText, 0);
        }
        mEditTextWatcher.view = drawablehighlightview;
        mEditText.setOnEditorActionListener(this);
        mEditText.addTextChangedListener(mEditTextWatcher);
    }

    private void createAndConfigurePreview()
    {
        if (mPreview != null && !mPreview.isRecycled())
        {
            mPreview.recycle();
            mPreview = null;
        }
        mPreview = BitmapUtils.copy(mBitmap, mBitmap.getConfig());
        mCanvas = new Canvas(mPreview);
    }

    private void endEdit(DrawableHighlightView drawablehighlightview)
    {
        if (drawablehighlightview != null)
        {
            drawablehighlightview.setFocused(false);
            if (drawablehighlightview.forceUpdate())
            {
                mImageView.invalidate(drawablehighlightview.getInvalidationRect());
            } else
            {
                mImageView.postInvalidate();
            }
        }
        mEditTextWatcher.view = null;
        mEditText.removeTextChangedListener(mEditTextWatcher);
        drawablehighlightview = (InputMethodManager)getContext().getBaseContext().getSystemService("input_method");
        if (drawablehighlightview != null && drawablehighlightview.isActive(mEditText))
        {
            drawablehighlightview.hideSoftInputFromWindow(mEditText.getWindowToken(), 0);
        }
    }

    private void onAddNewText()
    {
        ImageViewDrawableOverlay imageviewdrawableoverlay = (ImageViewDrawableOverlay)mImageView;
        if (imageviewdrawableoverlay.getHighlightCount() > 0)
        {
            onApplyCurrent(imageviewdrawableoverlay.getHighlightViewAt(0));
        }
        Object obj = new AviaryTextDrawable("", mDefaultTextSize);
        ((AviaryTextDrawable) (obj)).setTextColor(mColors[mSelectedPosition]);
        ((AviaryTextDrawable) (obj)).setStrokeEnabled(config.getBoolean(com.aviary.android.feather.sdk.R.integer.aviary_text_stroke_enabled));
        ((AviaryTextDrawable) (obj)).setCursorWidth(2);
        ((AviaryTextDrawable) (obj)).setMinTextSize(14F);
        ((AviaryTextDrawable) (obj)).setTextHint(mEditText.getHint());
        DrawableHighlightView drawablehighlightview = new DrawableHighlightView(mImageView, imageviewdrawableoverlay.getOverlayStyleId(), ((FeatherDrawable) (obj)));
        Matrix matrix = mImageView.getImageViewMatrix();
        int i1 = mImageView.getWidth();
        int j1 = mImageView.getHeight();
        int k1 = Math.max(i1, j1);
        int k = ((AviaryTextDrawable) (obj)).getIntrinsicWidth();
        int l = ((AviaryTextDrawable) (obj)).getIntrinsicHeight();
        int j = l;
        int i = k;
        if (Math.max(k, l) > k1)
        {
            i = i1 / 2;
            j = j1 / 2;
        }
        k = (i1 - i) / 2;
        l = (j1 - j) / 2;
        obj = new Matrix(matrix);
        ((Matrix) (obj)).invert(((Matrix) (obj)));
        float af[] = new float[4];
        af[0] = k;
        af[1] = l;
        af[2] = k + i;
        af[3] = l + j;
        MatrixUtils.mapPoints(((Matrix) (obj)), af);
        obj = new RectF(af[0], af[1], af[2], af[3]);
        Rect rect = new Rect(0, 0, i1, j1);
        drawablehighlightview.setup(getContext().getBaseContext(), matrix, rect, ((RectF) (obj)), false);
        imageviewdrawableoverlay.addHighlightView(drawablehighlightview);
        onClick(drawablehighlightview);
    }

    private MoaActionList onApplyCurrent()
    {
        MoaActionList moaactionlist = MoaActionFactory.actionList();
        if (((ImageViewDrawableOverlay)mImageView).getHighlightCount() >= 1) goto _L2; else goto _L1
_L1:
        DrawableHighlightView drawablehighlightview;
        return moaactionlist;
_L2:
        if ((drawablehighlightview = ((ImageViewDrawableOverlay)mImageView).getHighlightViewAt(0)) == null) goto _L1; else goto _L3
_L3:
        EditableDrawable editabledrawable;
        if (!(drawablehighlightview.getContent() instanceof EditableDrawable))
        {
            break; /* Loop/switch isn't completed */
        }
        editabledrawable = (EditableDrawable)drawablehighlightview.getContent();
        if (editabledrawable != null && editabledrawable.isTextHint()) goto _L1; else goto _L4
_L4:
        return onApplyCurrent(drawablehighlightview);
    }

    private MoaActionList onApplyCurrent(DrawableHighlightView drawablehighlightview)
    {
        if (drawablehighlightview != null)
        {
            Object obj1 = drawablehighlightview.getCropRectF();
            float f = MatrixUtils.getScale(mImageView.getImageMatrix())[0];
            mLogger.log((new StringBuilder()).append("cropRect: ").append(obj1).toString());
            int i = mBitmap.getWidth();
            int j = mBitmap.getHeight();
            float f1 = ((RectF) (obj1)).left;
            float f2 = ((RectF) (obj1)).top;
            float f3 = ((RectF) (obj1)).right;
            float f4 = ((RectF) (obj1)).bottom;
            Object obj2 = (EditableDrawable)drawablehighlightview.getContent();
            ((EditableDrawable) (obj2)).endEdit();
            mImageView.invalidate();
            Object obj = (TextFilter)ToolLoaderFactory.get(com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.TEXT);
            ((TextFilter) (obj)).setPreviewSize(i, j);
            ((TextFilter) (obj)).setText(((EditableDrawable) (obj2)).getText());
            ((TextFilter) (obj)).setFillColor(((EditableDrawable) (obj2)).getTextColor());
            if (((EditableDrawable) (obj2)).getStrokeEnabled())
            {
                i = ((EditableDrawable) (obj2)).getTextStrokeColor();
            } else
            {
                i = 0;
            }
            ((TextFilter) (obj)).setStrokeColor(i);
            ((TextFilter) (obj)).setRotation(drawablehighlightview.getRotation());
            ((TextFilter) (obj)).setTopLeft(f2, f1);
            ((TextFilter) (obj)).setBottomRight(f4, f3);
            ((TextFilter) (obj)).setTextSize(((EditableDrawable) (obj2)).getTextSize() / f);
            obj = (MoaActionList)((TextFilter) (obj)).getActions().clone();
            mToolAction.setValue((String)((EditableDrawable) (obj2)).getText());
            obj1 = new Rect((int)((RectF) (obj1)).left, (int)((RectF) (obj1)).top, (int)((RectF) (obj1)).right, (int)((RectF) (obj1)).bottom);
            i = mCanvas.save(1);
            obj2 = drawablehighlightview.getCropRotationMatrix();
            mCanvas.concat(((Matrix) (obj2)));
            drawablehighlightview.getContent().setBounds(((Rect) (obj1)));
            drawablehighlightview.getContent().draw(mCanvas);
            mCanvas.restoreToCount(i);
            mImageView.invalidate();
            onClearCurrent(drawablehighlightview);
            drawablehighlightview = ((DrawableHighlightView) (obj));
        } else
        {
            drawablehighlightview = MoaActionFactory.actionList();
        }
        onPreviewChanged(mPreview, false, false);
        return drawablehighlightview;
    }

    private void onClearCurrent(DrawableHighlightView drawablehighlightview)
    {
        drawablehighlightview.setOnDeleteClickListener(null);
        ((ImageViewDrawableOverlay)mImageView).removeHightlightView(drawablehighlightview);
    }

    private void updateCurrentHighlightColor()
    {
        ImageViewDrawableOverlay imageviewdrawableoverlay = (ImageViewDrawableOverlay)mImageView;
        DrawableHighlightView drawablehighlightview1 = imageviewdrawableoverlay.getSelectedHighlightView();
        DrawableHighlightView drawablehighlightview = drawablehighlightview1;
        if (drawablehighlightview1 == null)
        {
            drawablehighlightview = drawablehighlightview1;
            if (imageviewdrawableoverlay.getHighlightCount() > 0)
            {
                drawablehighlightview = imageviewdrawableoverlay.getHighlightViewAt(0);
            }
        }
        if (drawablehighlightview != null && (drawablehighlightview.getContent() instanceof EditableDrawable))
        {
            ((EditableDrawable)drawablehighlightview.getContent()).setTextColor(mColor);
            mImageView.postInvalidate();
        }
    }

    protected View generateContentView(LayoutInflater layoutinflater)
    {
        return layoutinflater.inflate(com.aviary.android.feather.sdk.R.layout.aviary_content_text, null);
    }

    protected ViewGroup generateOptionView(LayoutInflater layoutinflater, ViewGroup viewgroup)
    {
        int i;
        if (FeatherActivity.MATURITY.isKidsFriendly())
        {
            i = com.aviary.android.feather.sdk.R.layout.aviary_panel_text_freetime;
        } else
        {
            i = com.aviary.android.feather.sdk.R.layout.aviary_panel_crop;
        }
        return (ViewGroup)layoutinflater.inflate(i, viewgroup, false);
    }

    public boolean getIsChanged()
    {
        mLogger.info("getIsChanged");
        Object obj;
        if (((ImageViewDrawableOverlay)mImageView).getHighlightCount() > 0)
        {
            obj = ((ImageViewDrawableOverlay)mImageView).getHighlightViewAt(0);
            if (obj != null && (((DrawableHighlightView) (obj)).getContent() instanceof EditableDrawable))
            {
                obj = (EditableDrawable)((DrawableHighlightView) (obj)).getContent();
                break MISSING_BLOCK_LABEL_59;
            }
        }
        do
        {
            return false;
        } while (obj == null || ((EditableDrawable) (obj)).isTextHint() || ((EditableDrawable) (obj)).getText() == null);
        boolean flag;
        if (((EditableDrawable) (obj)).getText().length() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return flag;
    }

    public volatile boolean isRendering()
    {
        return super.isRendering();
    }

    public void onActivate()
    {
        super.onActivate();
        disableHapticIsNecessary(new VibrationWidget[] {
            mGallery
        });
        mDefaultTextSize = config.getDimensionPixelSize(com.aviary.android.feather.sdk.R.dimen.aviary_text_overlay_default_size);
        ((ImageViewDrawableOverlay)mImageView).setOnDrawableEventListener(this);
        ((ImageViewDrawableOverlay)mImageView).setScaleWithContent(true);
        ((ImageViewDrawableOverlay)mImageView).setForceSingleSelection(false);
        mImageView.requestLayout();
        mEditText.setOnKeyListener(this);
        contentReady();
        getHandler().postDelayed(new Runnable() {

            final TextPanel this$0;

            public void run()
            {
                onAddNewText();
            }

            
            {
                this$0 = TextPanel.this;
                super();
            }
        }, 200L);
    }

    public void onBitmapReplaced(Bitmap bitmap)
    {
        super.onBitmapReplaced(bitmap);
        if (isActive())
        {
            ((ImageViewDrawableOverlay)mImageView).clearOverlays();
            createAndConfigurePreview();
            mImageView.setImageBitmap(mPreview, null, -1F, 8F);
            onAddNewText();
        }
    }

    public void onClick(DrawableHighlightView drawablehighlightview)
    {
        if (drawablehighlightview != null && (drawablehighlightview.getContent() instanceof EditableDrawable) && !drawablehighlightview.isFocused())
        {
            beginEdit(drawablehighlightview);
        }
    }

    public void onCreate(Bitmap bitmap, Bundle bundle)
    {
        super.onCreate(bitmap, bundle);
        config = (ConfigService)getContext().getService(com/aviary/android/feather/library/services/ConfigService);
        mColors = config.getIntArray(com.aviary.android.feather.sdk.R.array.aviary_text_fill_colors);
        bitmap = config;
        int i;
        if (FeatherActivity.MATURITY.isKidsFriendly())
        {
            i = com.aviary.android.feather.sdk.R.integer.aviary_text_fill_color_index_freetime;
        } else
        {
            i = com.aviary.android.feather.sdk.R.integer.aviary_text_fill_color_index;
        }
        mSelectedPosition = bitmap.getInteger(i);
        mColor = mColors[mSelectedPosition];
        mColorContentDescription = config.getString(com.aviary.android.feather.sdk.R.string.feather_acc_color);
        mGallery = (AviaryGallery)getOptionView().findViewById(com.aviary.android.feather.sdk.R.id.aviary_gallery);
        mGallery.setDefaultPosition(mSelectedPosition);
        mGallery.setCallbackDuringFling(false);
        mGallery.setAutoSelectChild(true);
        mGallery.setAdapter(new GalleryAdapter(getContext().getBaseContext(), mColors));
        mGallery.setOnItemsScrollListener(this);
        mEditText = (EditText)getContentView().findViewById(com.aviary.android.feather.sdk.R.id.aviary_text);
        mImageView = (ImageViewTouch)getContentView().findViewById(com.aviary.android.feather.sdk.R.id.aviary_image);
        mImageView.setDisplayType(it.sephiroth.android.library.imagezoom.ImageViewTouchBase.DisplayType.FIT_TO_SCREEN);
        mImageView.setDoubleTapEnabled(false);
        createAndConfigurePreview();
        mImageView.setImageBitmap(mPreview, null, -1F, 8F);
    }

    public void onDeactivate()
    {
        ((ImageViewDrawableOverlay)mImageView).setOnDrawableEventListener(null);
        mGallery.setOnItemsScrollListener(null);
        endEdit(null);
        super.onDeactivate();
    }

    public void onDestroy()
    {
        mCanvas = null;
        ((ImageViewDrawableOverlay)mImageView).clearOverlays();
        super.onDestroy();
    }

    public void onDown(DrawableHighlightView drawablehighlightview)
    {
    }

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        mLogger.info((new StringBuilder()).append("onEditorAction: ").append(i).append(", event: ").append(keyevent).toString());
        if (mEditText != null && mEditText.equals(textview) && i == 6)
        {
            textview = (ImageViewDrawableOverlay)mImageView;
            if (textview.getSelectedHighlightView() != null)
            {
                textview = textview.getSelectedHighlightView();
                if ((textview.getContent() instanceof EditableDrawable) && ((EditableDrawable)textview.getContent()).isEditing())
                {
                    endEdit(textview);
                }
            }
        }
        return false;
    }

    public void onFocusChange(DrawableHighlightView drawablehighlightview, DrawableHighlightView drawablehighlightview1)
    {
        if (drawablehighlightview1 != null && (drawablehighlightview1.getContent() instanceof EditableDrawable) && ((EditableDrawable)drawablehighlightview1.getContent()).isEditing())
        {
            endEdit(drawablehighlightview1);
        }
        if (drawablehighlightview != null && (drawablehighlightview.getContent() instanceof EditableDrawable))
        {
            mColor = ((EditableDrawable)drawablehighlightview.getContent()).getTextColor();
        }
    }

    protected void onGenerateResult()
    {
        MoaActionList moaactionlist = onApplyCurrent();
        mEditResult.setActionList(moaactionlist);
        mEditResult.setToolAction(mToolAction);
        super.onGenerateResult(mEditResult);
    }

    public boolean onKey(View view, int i, KeyEvent keyevent)
    {
        view = ((ImageViewDrawableOverlay)mImageView).getSelectedHighlightView();
        mLogger.log((new StringBuilder()).append("onKey: ").append(i).toString());
        if (view != null && (i == 67 || i == 4))
        {
            keyevent = view.getContent();
            if (keyevent instanceof EditableDrawable)
            {
                keyevent = (EditableDrawable)keyevent;
                if (keyevent.isTextHint() && keyevent.isEditing())
                {
                    keyevent.setText("");
                    if (view.forceUpdate())
                    {
                        mImageView.invalidate(view.getInvalidationRect());
                    }
                }
            }
        }
        return false;
    }

    public void onMove(DrawableHighlightView drawablehighlightview)
    {
        if ((drawablehighlightview.getContent() instanceof EditableDrawable) && ((EditableDrawable)drawablehighlightview.getContent()).isEditing())
        {
            endEdit(drawablehighlightview);
        }
    }

    public void onScroll(AviaryAdapterView aviaryadapterview, View view, int i, long l)
    {
        if (i >= 0 && i < mColors.length)
        {
            int j = mColors[i];
            mSelectedPosition = i;
            mColor = j;
            mGallery.invalidateViews();
            updateCurrentHighlightColor();
        }
    }

    public void onScrollFinished(AviaryAdapterView aviaryadapterview, View view, int i, long l)
    {
        if (i >= 0 && i < mColors.length)
        {
            int j = mColors[i];
            mSelectedPosition = i;
            mColor = j;
            mGallery.invalidateViews();
            try
            {
                getContext().getTracker().tagEvent("text: colors_selected");
            }
            // Misplaced declaration of an exception variable
            catch (AviaryAdapterView aviaryadapterview) { }
            updateCurrentHighlightColor();
        }
    }

    public void onScrollStarted(AviaryAdapterView aviaryadapterview, View view, int i, long l)
    {
    }

    public volatile void setEnabled(boolean flag)
    {
        super.setEnabled(flag);
    }



}
