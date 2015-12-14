// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.panels;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.aviary.android.feather.common.utils.PackageManagerUtils;
import com.aviary.android.feather.headless.moa.MoaActionList;
import com.aviary.android.feather.library.content.ToolEntry;
import com.aviary.android.feather.library.filters.MemeFilter;
import com.aviary.android.feather.library.filters.ToolLoaderFactory;
import com.aviary.android.feather.library.graphics.drawable.AviaryMemeTextDrawable;
import com.aviary.android.feather.library.graphics.drawable.EditableDrawable;
import com.aviary.android.feather.library.services.ConfigService;
import com.aviary.android.feather.library.services.IAviaryController;
import com.aviary.android.feather.library.utils.BitmapUtils;
import com.aviary.android.feather.library.utils.MatrixUtils;
import com.aviary.android.feather.library.vo.EditToolResultVO;
import com.aviary.android.feather.library.vo.ToolActionVO;
import com.aviary.android.feather.sdk.utils.TypefaceUtils;
import com.aviary.android.feather.sdk.widget.AviaryButton;
import com.aviary.android.feather.sdk.widget.DrawableHighlightView;
import com.aviary.android.feather.sdk.widget.ImageViewDrawableOverlay;
import it.sephiroth.android.library.imagezoom.ImageViewTouch;

// Referenced classes of package com.aviary.android.feather.sdk.panels:
//            AbstractContentPanel

public class MemePanel extends AbstractContentPanel
    implements android.view.View.OnClickListener, android.widget.TextView.OnEditorActionListener, com.aviary.android.feather.sdk.widget.ImageViewDrawableOverlay.OnDrawableEventListener, it.sephiroth.android.library.imagezoom.ImageViewTouchBase.OnLayoutChangeListener
{
    abstract class MyTextWatcher
        implements TextWatcher
    {

        final MemePanel this$0;
        public DrawableHighlightView view;

        MyTextWatcher()
        {
            this$0 = MemePanel.this;
            super();
        }
    }


    DrawableHighlightView bottomHv;
    View clearButtonBottom;
    View clearButtonTop;
    AviaryButton editBottomButton;
    EditText editBottomText;
    AviaryButton editTopButton;
    EditText editTopText;
    String fontName;
    Canvas mCanvas;
    private final MyTextWatcher mEditTextWatcher = new MyTextWatcher() {

        final MemePanel this$0;

        public void afterTextChanged(Editable editable)
        {
        }

        public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
        {
        }

        public void onTextChanged(CharSequence charsequence, int i, int j, int k)
        {
            EditableDrawable editabledrawable;
label0:
            {
                j = 0;
                i = 0;
                mLogger.info("onTextChanged", new Object[] {
                    this.view
                });
                if (this.view != null && (this.view.getContent() instanceof EditableDrawable))
                {
                    editabledrawable = (EditableDrawable)this.view.getContent();
                    if (editabledrawable.isEditing())
                    {
                        break label0;
                    }
                }
                return;
            }
            editabledrawable.setText(charsequence.toString());
            if (!this.view.equals(topHv)) goto _L2; else goto _L1
_L1:
            editTopButton.setText(charsequence);
            View view = clearButtonTop;
            if (charsequence == null || charsequence.length() <= 0)
            {
                i = 4;
            }
            view.setVisibility(i);
_L4:
            if (this.view.forceUpdate())
            {
                mImageView.invalidate(this.view.getInvalidationRect());
            }
            checkIsChanged();
            return;
_L2:
            if (this.view.equals(bottomHv))
            {
                editBottomButton.setText(charsequence);
                View view1 = clearButtonBottom;
                if (charsequence != null && charsequence.length() > 0)
                {
                    i = j;
                } else
                {
                    i = 4;
                }
                view1.setVisibility(i);
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

            
            {
                this$0 = MemePanel.this;
                super();
            }
    };
    Handler mInputHandler;
    InputMethodManager mInputManager;
    ResultReceiver mInputReceiver;
    int mTextColor;
    int mTextStrokeColor;
    boolean mTextStrokeEnabled;
    final ToolActionVO mToolAction = new ToolActionVO(new String[] {
        "", ""
    });
    Typeface mTypeface;
    String mTypefaceSourceDir;
    int paddingBottom;
    int paddingTop;
    DrawableHighlightView topHv;

    public MemePanel(IAviaryController iaviarycontroller, ToolEntry toolentry)
    {
        super(iaviarycontroller, toolentry);
        paddingTop = 16;
        paddingBottom = 16;
        mTextColor = -1;
        mTextStrokeColor = 0xff000000;
        mTextStrokeEnabled = true;
        mInputHandler = new Handler();
        mInputReceiver = new ResultReceiver(mInputHandler);
        iaviarycontroller = (ConfigService)iaviarycontroller.getService(com/aviary/android/feather/library/services/ConfigService);
        if (iaviarycontroller != null)
        {
            fontName = iaviarycontroller.getString(com.aviary.android.feather.sdk.R.string.aviary_meme_font);
            mTextColor = iaviarycontroller.getColor(com.aviary.android.feather.sdk.R.color.aviary_meme_text_color);
            mTextStrokeColor = iaviarycontroller.getColor(com.aviary.android.feather.sdk.R.color.aviary_meme_stroke_color);
            mTextStrokeEnabled = iaviarycontroller.getBoolean(com.aviary.android.feather.sdk.R.integer.aviary_meme_stroke_enabled);
        }
    }

    private void beginEditText(DrawableHighlightView drawablehighlightview)
    {
        EditText edittext;
        mLogger.info("beginEditText", new Object[] {
            drawablehighlightview
        });
        edittext = null;
        if (drawablehighlightview != topHv) goto _L2; else goto _L1
_L1:
        edittext = editTopText;
_L4:
        if (edittext != null)
        {
            mEditTextWatcher.view = null;
            edittext.removeTextChangedListener(mEditTextWatcher);
            edittext.setText((String)((EditableDrawable)drawablehighlightview.getContent()).getText());
            edittext.setSelection(edittext.length());
            edittext.setImeOptions(6);
            edittext.requestFocusFromTouch();
            if (!mInputManager.showSoftInput(edittext, 0, mInputReceiver))
            {
                mInputManager.toggleSoftInput(2, 0);
            }
            mEditTextWatcher.view = drawablehighlightview;
            edittext.setOnEditorActionListener(this);
            edittext.addTextChangedListener(mEditTextWatcher);
            ((ImageViewDrawableOverlay)mImageView).setSelectedHighlightView(drawablehighlightview);
            ((EditableDrawable)drawablehighlightview.getContent()).setText(((EditableDrawable)drawablehighlightview.getContent()).getText());
            if (drawablehighlightview.forceUpdate())
            {
                mImageView.invalidate(drawablehighlightview.getInvalidationRect());
            }
            checkIsChanged();
        }
        return;
_L2:
        if (drawablehighlightview == bottomHv)
        {
            edittext = editBottomText;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void beginEditView(DrawableHighlightView drawablehighlightview)
    {
        mLogger.info("beginEditView");
        if (drawablehighlightview == null)
        {
            return;
        }
        EditableDrawable editabledrawable = (EditableDrawable)drawablehighlightview.getContent();
        if (drawablehighlightview == topHv)
        {
            endEditView(bottomHv);
        } else
        {
            endEditView(topHv);
        }
        if (!editabledrawable.isEditing())
        {
            editabledrawable.beginEdit();
        }
        beginEditText(drawablehighlightview);
    }

    private void checkIsChanged()
    {
        if (checkIsChanged(topHv))
        {
            setIsChanged(true);
        } else
        if (checkIsChanged(bottomHv))
        {
            setIsChanged(true);
        } else
        {
            setIsChanged(false);
        }
        mLogger.log((new StringBuilder()).append("isChanged?: ").append(getIsChanged()).toString());
    }

    private boolean checkIsChanged(DrawableHighlightView drawablehighlightview)
    {
        if (drawablehighlightview != null)
        {
            drawablehighlightview = (EditableDrawable)drawablehighlightview.getContent();
            if (drawablehighlightview != null)
            {
                drawablehighlightview = drawablehighlightview.getText();
                if (drawablehighlightview != null && drawablehighlightview.length() > 0)
                {
                    return true;
                }
            }
        }
        return false;
    }

    private void clearEditView(DrawableHighlightView drawablehighlightview)
    {
        if (drawablehighlightview != null)
        {
            AviaryMemeTextDrawable aviarymemetextdrawable = (AviaryMemeTextDrawable)drawablehighlightview.getContent();
            aviarymemetextdrawable.setText("");
            aviarymemetextdrawable.invalidateSelf();
            if (drawablehighlightview.forceUpdate())
            {
                mImageView.invalidate(drawablehighlightview.getInvalidationRect());
            }
            checkIsChanged();
        }
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

    private void createTypeFace()
    {
        ApplicationInfo applicationinfo;
        try
        {
            mTypeface = TypefaceUtils.createFromAsset(getContext().getBaseContext().getAssets(), fontName);
            applicationinfo = PackageManagerUtils.getApplicationInfo(getContext().getBaseContext());
        }
        catch (Exception exception)
        {
            mTypeface = Typeface.DEFAULT;
            return;
        }
        if (applicationinfo == null)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        mTypefaceSourceDir = applicationinfo.sourceDir;
    }

    private void endEditText(DrawableHighlightView drawablehighlightview)
    {
        EditText edittext;
        mLogger.info("endEditText", new Object[] {
            drawablehighlightview
        });
        mEditTextWatcher.view = null;
        edittext = null;
        if (drawablehighlightview != topHv) goto _L2; else goto _L1
_L1:
        edittext = editTopText;
_L4:
        if (edittext != null)
        {
            edittext.removeTextChangedListener(mEditTextWatcher);
            edittext.setOnEditorActionListener(null);
            if (mInputManager.isActive(edittext))
            {
                mInputManager.hideSoftInputFromWindow(edittext.getWindowToken(), 0);
            }
            edittext.clearFocus();
        }
        return;
_L2:
        if (drawablehighlightview == bottomHv)
        {
            edittext = editBottomText;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void endEditView(DrawableHighlightView drawablehighlightview)
    {
        boolean flag = false;
        int i = 0;
        if (drawablehighlightview != null)
        {
            Object obj = (EditableDrawable)drawablehighlightview.getContent();
            if (((EditableDrawable) (obj)).isEditing())
            {
                ((EditableDrawable) (obj)).endEdit();
                endEditText(drawablehighlightview);
            }
            obj = ((EditableDrawable) (obj)).getText();
            if (drawablehighlightview.equals(topHv))
            {
                editTopButton.setText(((CharSequence) (obj)));
                drawablehighlightview = clearButtonTop;
                if (obj == null || ((CharSequence) (obj)).length() <= 0)
                {
                    i = 4;
                }
                drawablehighlightview.setVisibility(i);
                return;
            }
            if (drawablehighlightview.equals(bottomHv))
            {
                editBottomButton.setText(((CharSequence) (obj)));
                drawablehighlightview = clearButtonBottom;
                int j;
                if (obj != null && ((CharSequence) (obj)).length() > 0)
                {
                    j = ((flag) ? 1 : 0);
                } else
                {
                    j = 4;
                }
                drawablehighlightview.setVisibility(j);
                return;
            }
        }
    }

    private void flattenText(DrawableHighlightView drawablehighlightview, MemeFilter memefilter)
    {
        if (drawablehighlightview == null) goto _L2; else goto _L1
_L1:
        AviaryMemeTextDrawable aviarymemetextdrawable;
        drawablehighlightview.setHidden(true);
        float f = MatrixUtils.getScale(mImageView.getImageMatrix())[0];
        int i = mBitmap.getWidth();
        int k = mBitmap.getHeight();
        Object obj = drawablehighlightview.getCropRectF();
        obj = new Rect((int)((RectF) (obj)).left, (int)((RectF) (obj)).top, (int)((RectF) (obj)).right, (int)((RectF) (obj)).bottom);
        aviarymemetextdrawable = (AviaryMemeTextDrawable)drawablehighlightview.getContent();
        int j = mCanvas.save(1);
        aviarymemetextdrawable.endEdit();
        aviarymemetextdrawable.invalidateSelf();
        aviarymemetextdrawable.setContentSize(i, k);
        aviarymemetextdrawable.setBounds(((Rect) (obj)).left, ((Rect) (obj)).top, ((Rect) (obj)).right, ((Rect) (obj)).bottom);
        aviarymemetextdrawable.draw(mCanvas);
        memefilter.setPreviewSize(i, k);
        memefilter.setFillColor(aviarymemetextdrawable.getTextColor());
        if (aviarymemetextdrawable.getStrokeEnabled())
        {
            i = aviarymemetextdrawable.getTextStrokeColor();
        } else
        {
            i = 0;
        }
        memefilter.setStrokeColor(i);
        memefilter.setTextSize(aviarymemetextdrawable.getDefaultTextSize() / f);
        if (topHv != drawablehighlightview) goto _L4; else goto _L3
_L3:
        memefilter.setTopText((String)aviarymemetextdrawable.getText());
        ((String[])mToolAction.getValue())[0] = (String)aviarymemetextdrawable.getText();
_L6:
        mCanvas.restoreToCount(j);
        mImageView.invalidate();
_L2:
        onPreviewChanged(mPreview, false, false);
        return;
_L4:
        if (drawablehighlightview == bottomHv)
        {
            memefilter.setBottomText((String)aviarymemetextdrawable.getText());
            ((String[])mToolAction.getValue())[1] = (String)aviarymemetextdrawable.getText();
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static float[] getMatrixValues(Matrix matrix)
    {
        float af[] = new float[9];
        matrix.getValues(af);
        return af;
    }

    private void onAddBottomText()
    {
        ImageViewDrawableOverlay imageviewdrawableoverlay = (ImageViewDrawableOverlay)mImageView;
        RectF rectf = imageviewdrawableoverlay.getBitmapRect();
        Object obj = new AviaryMemeTextDrawable("", (int)(Math.min(rectf.width(), rectf.height()) / 7F), mTypeface, false);
        ((AviaryMemeTextDrawable) (obj)).setTextColor(mTextColor);
        ((AviaryMemeTextDrawable) (obj)).setStrokeEnabled(mTextStrokeEnabled);
        ((AviaryMemeTextDrawable) (obj)).setStrokeColor(mTextStrokeColor);
        ((AviaryMemeTextDrawable) (obj)).setContentSize(rectf.width(), rectf.height());
        ((AviaryMemeTextDrawable) (obj)).getFontMetrics(new android.graphics.Paint.FontMetrics());
        bottomHv = new DrawableHighlightView(imageviewdrawableoverlay, imageviewdrawableoverlay.getOverlayStyleId(), ((com.aviary.android.feather.library.graphics.drawable.FeatherDrawable) (obj)));
        Matrix matrix = imageviewdrawableoverlay.getImageViewMatrix();
        int i = ((AviaryMemeTextDrawable) (obj)).getIntrinsicHeight();
        obj = new Matrix(matrix);
        ((Matrix) (obj)).invert(((Matrix) (obj)));
        float af[] = new float[4];
        af[0] = rectf.left;
        af[1] = rectf.bottom - (float)i - (float)paddingBottom;
        af[2] = rectf.left + rectf.width();
        af[3] = rectf.bottom - (float)paddingBottom;
        MatrixUtils.mapPoints(((Matrix) (obj)), af);
        obj = new RectF(af[0], af[1], af[2], af[3]);
        mLogger.log((new StringBuilder()).append("bitmap rect: ").append(rectf).toString());
        bottomHv.setAlignModeV(com.aviary.android.feather.sdk.widget.DrawableHighlightView.AlignModeV.Bottom);
        bottomHv.setup(getContext().getBaseContext(), matrix, null, ((RectF) (obj)), false);
        imageviewdrawableoverlay.addHighlightView(bottomHv);
    }

    private void onAddTopText()
    {
        ImageViewDrawableOverlay imageviewdrawableoverlay = (ImageViewDrawableOverlay)mImageView;
        RectF rectf = imageviewdrawableoverlay.getBitmapRect();
        Object obj = new AviaryMemeTextDrawable("", (int)(Math.min(rectf.width(), rectf.height()) / 7F), mTypeface, true);
        ((AviaryMemeTextDrawable) (obj)).setTextColor(mTextColor);
        ((AviaryMemeTextDrawable) (obj)).setStrokeEnabled(mTextStrokeEnabled);
        ((AviaryMemeTextDrawable) (obj)).setStrokeColor(mTextStrokeColor);
        ((AviaryMemeTextDrawable) (obj)).setContentSize(rectf.width(), rectf.height());
        topHv = new DrawableHighlightView(imageviewdrawableoverlay, imageviewdrawableoverlay.getOverlayStyleId(), ((com.aviary.android.feather.library.graphics.drawable.FeatherDrawable) (obj)));
        Matrix matrix = imageviewdrawableoverlay.getImageViewMatrix();
        int i = ((AviaryMemeTextDrawable) (obj)).getIntrinsicHeight();
        obj = new Matrix(matrix);
        ((Matrix) (obj)).invert(((Matrix) (obj)));
        float af[] = new float[4];
        af[0] = rectf.left;
        af[1] = rectf.top + (float)paddingTop;
        af[2] = rectf.right;
        af[3] = rectf.top + (float)i + (float)paddingTop;
        MatrixUtils.mapPoints(((Matrix) (obj)), af);
        rectf = new RectF(af[0], af[1], af[2], af[3]);
        topHv.setAlignModeV(com.aviary.android.feather.sdk.widget.DrawableHighlightView.AlignModeV.Top);
        topHv.setup(getContext().getBaseContext(), matrix, null, rectf, false);
        imageviewdrawableoverlay.addHighlightView(topHv);
    }

    protected View generateContentView(LayoutInflater layoutinflater)
    {
        return layoutinflater.inflate(com.aviary.android.feather.sdk.R.layout.aviary_content_meme, null);
    }

    protected ViewGroup generateOptionView(LayoutInflater layoutinflater, ViewGroup viewgroup)
    {
        return (ViewGroup)layoutinflater.inflate(com.aviary.android.feather.sdk.R.layout.aviary_panel_meme, viewgroup, false);
    }

    public volatile boolean isRendering()
    {
        return super.isRendering();
    }

    public void onActivate()
    {
        super.onActivate();
        createTypeFace();
        ((ImageViewDrawableOverlay)mImageView).setOnDrawableEventListener(this);
        ((ImageViewDrawableOverlay)mImageView).setOnLayoutChangeListener(this);
        mInputManager = (InputMethodManager)getContext().getBaseContext().getSystemService("input_method");
        editTopButton.setOnClickListener(this);
        editBottomButton.setOnClickListener(this);
        editTopText.setVisibility(0);
        editBottomText.setVisibility(0);
        editTopText.getBackground().setAlpha(0);
        editBottomText.getBackground().setAlpha(0);
        clearButtonTop.setOnClickListener(this);
        clearButtonBottom.setOnClickListener(this);
        getContentView().setVisibility(0);
        contentReady();
    }

    public void onClick(View view)
    {
        mLogger.info("onClick");
        if (view != null)
        {
            int i = view.getId();
            if (i == editTopButton.getId())
            {
                if (topHv == null)
                {
                    onAddTopText();
                }
                onTopClick(topHv);
                return;
            }
            if (i == editBottomButton.getId())
            {
                if (bottomHv == null)
                {
                    onAddBottomText();
                }
                onTopClick(bottomHv);
                return;
            }
            if (i == clearButtonTop.getId())
            {
                clearEditView(topHv);
                endEditView(topHv);
                return;
            }
            if (i == clearButtonBottom.getId())
            {
                clearEditView(bottomHv);
                endEditView(bottomHv);
                return;
            }
        }
    }

    public void onClick(DrawableHighlightView drawablehighlightview)
    {
        if (drawablehighlightview != null && (drawablehighlightview.getContent() instanceof EditableDrawable))
        {
            beginEditView(drawablehighlightview);
        }
    }

    public void onCreate(Bitmap bitmap, Bundle bundle)
    {
        super.onCreate(bitmap, bundle);
        editTopButton = (AviaryButton)getOptionView().findViewById(com.aviary.android.feather.sdk.R.id.aviary_button1);
        editBottomButton = (AviaryButton)getOptionView().findViewById(com.aviary.android.feather.sdk.R.id.aviary_button2);
        mImageView = (ImageViewTouch)getContentView().findViewById(com.aviary.android.feather.sdk.R.id.aviary_image);
        editTopText = (EditText)getContentView().findViewById(com.aviary.android.feather.sdk.R.id.aviary_invisible_text_1);
        editBottomText = (EditText)getContentView().findViewById(com.aviary.android.feather.sdk.R.id.aviary_invisible_text_2);
        clearButtonTop = getOptionView().findViewById(com.aviary.android.feather.sdk.R.id.aviary_clear_button1);
        clearButtonBottom = getOptionView().findViewById(com.aviary.android.feather.sdk.R.id.aviary_clear_button2);
        mImageView.setDisplayType(it.sephiroth.android.library.imagezoom.ImageViewTouchBase.DisplayType.FIT_TO_SCREEN);
        mImageView.setDoubleTapEnabled(false);
        mImageView.setScaleEnabled(false);
        mImageView.setScrollEnabled(false);
        createAndConfigurePreview();
        mImageView.setOnDrawableChangedListener(new it.sephiroth.android.library.imagezoom.ImageViewTouchBase.OnDrawableChangeListener() {

            final MemePanel this$0;

            public void onDrawableChanged(Drawable drawable)
            {
                mLogger.info("onDrawableChanged");
                drawable = MemePanel.getMatrixValues(mImageView.getImageViewMatrix());
                int i = (int)((float)mBitmap.getHeight() * drawable[4]);
                drawable = getContentView().findViewById(com.aviary.android.feather.sdk.R.id.aviary_meme_dumb);
                android.widget.LinearLayout.LayoutParams layoutparams = (android.widget.LinearLayout.LayoutParams)drawable.getLayoutParams();
                layoutparams.height = i - 50;
                drawable.setLayoutParams(layoutparams);
                drawable.requestLayout();
            }

            
            {
                this$0 = MemePanel.this;
                super();
            }
        });
        mImageView.setImageBitmap(mPreview, null, -1F, -1F);
    }

    public void onDeactivate()
    {
        super.onDeactivate();
        endEditView(topHv);
        endEditView(bottomHv);
        ((ImageViewDrawableOverlay)mImageView).setOnDrawableEventListener(null);
        ((ImageViewDrawableOverlay)mImageView).setOnLayoutChangeListener(null);
        editTopButton.setOnClickListener(null);
        editBottomButton.setOnClickListener(null);
        clearButtonTop.setOnClickListener(null);
        clearButtonBottom.setOnClickListener(null);
        if (mInputManager.isActive(editTopText))
        {
            mInputManager.hideSoftInputFromWindow(editTopText.getWindowToken(), 0);
        }
        if (mInputManager.isActive(editBottomText))
        {
            mInputManager.hideSoftInputFromWindow(editBottomText.getWindowToken(), 0);
        }
    }

    public void onDestroy()
    {
        mCanvas = null;
        mInputManager = null;
        ((ImageViewDrawableOverlay)mImageView).clearOverlays();
        super.onDestroy();
    }

    public void onDown(DrawableHighlightView drawablehighlightview)
    {
    }

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        mLogger.info("onEditorAction", new Object[] {
            textview, Integer.valueOf(i), keyevent
        });
        if (textview != null && (i == 6 || i == 0))
        {
            textview = (ImageViewDrawableOverlay)mImageView;
            if (textview.getSelectedHighlightView() != null)
            {
                textview = textview.getSelectedHighlightView();
                if (textview.getContent() instanceof EditableDrawable)
                {
                    endEditView(textview);
                }
            }
        }
        return false;
    }

    public void onFocusChange(DrawableHighlightView drawablehighlightview, DrawableHighlightView drawablehighlightview1)
    {
        mLogger.info("onFocusChange", new Object[] {
            drawablehighlightview, drawablehighlightview1
        });
        if (drawablehighlightview1 != null && drawablehighlightview == null)
        {
            endEditView(drawablehighlightview1);
        }
    }

    protected void onGenerateResult()
    {
        Object obj = (MemeFilter)ToolLoaderFactory.get(com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.MEME);
        float f = MatrixUtils.getScale(mImageView.getImageMatrix())[0];
        ((MemeFilter) (obj)).setPaddingTop((double)paddingTop / (double)f);
        ((MemeFilter) (obj)).setPaddingBottom((double)paddingBottom / (double)f);
        if (mTypeface != null)
        {
            ((MemeFilter) (obj)).setAssetFontName(fontName);
        }
        if (mTypefaceSourceDir != null)
        {
            ((MemeFilter) (obj)).setFontSourceDir(mTypefaceSourceDir);
        }
        if (topHv != null)
        {
            flattenText(topHv, ((MemeFilter) (obj)));
        }
        if (bottomHv != null)
        {
            flattenText(bottomHv, ((MemeFilter) (obj)));
        }
        obj = (MoaActionList)((MemeFilter) (obj)).getActions().clone();
        mEditResult.setActionList(((MoaActionList) (obj)));
        mEditResult.setToolAction(mToolAction);
        super.onGenerateResult(mEditResult);
    }

    public void onLayoutChanged(boolean flag, int i, int j, int k, int l)
    {
        if (flag)
        {
            float af[] = getMatrixValues(mImageView.getImageViewMatrix());
            float f = mBitmap.getWidth();
            float f1 = mBitmap.getHeight();
            float f2 = af[0];
            if (topHv != null)
            {
                ((AviaryMemeTextDrawable)topHv.getContent()).setContentSize(f * f2, f1 * f2);
            }
            if (bottomHv != null)
            {
                ((AviaryMemeTextDrawable)bottomHv.getContent()).setContentSize(f * f2, f1 * f2);
            }
        }
    }

    public void onMove(DrawableHighlightView drawablehighlightview)
    {
    }

    public void onTopClick(DrawableHighlightView drawablehighlightview)
    {
        mLogger.info("onTopClick", new Object[] {
            drawablehighlightview
        });
        if (drawablehighlightview != null && (drawablehighlightview.getContent() instanceof EditableDrawable))
        {
            beginEditView(drawablehighlightview);
        }
    }

    public volatile void setEnabled(boolean flag)
    {
        super.setEnabled(flag);
    }

}
