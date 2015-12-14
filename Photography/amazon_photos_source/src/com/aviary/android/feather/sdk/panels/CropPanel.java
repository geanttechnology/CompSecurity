// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.panels;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.aviary.android.feather.common.utils.os.AviaryAsyncTask;
import com.aviary.android.feather.headless.filters.impl.CropFilter;
import com.aviary.android.feather.headless.moa.MoaActionList;
import com.aviary.android.feather.headless.moa.MoaPointParameter;
import com.aviary.android.feather.library.content.ToolEntry;
import com.aviary.android.feather.library.filters.ToolLoaderFactory;
import com.aviary.android.feather.library.graphics.RectD;
import com.aviary.android.feather.library.services.ConfigService;
import com.aviary.android.feather.library.services.IAviaryController;
import com.aviary.android.feather.library.vo.EditToolResultVO;
import com.aviary.android.feather.library.vo.ToolActionVO;
import com.aviary.android.feather.sdk.FeatherActivity;
import com.aviary.android.feather.sdk.utils.Maturity;
import com.aviary.android.feather.sdk.widget.AviaryAdapterView;
import com.aviary.android.feather.sdk.widget.AviaryGallery;
import com.aviary.android.feather.sdk.widget.AviaryHighlightImageButton;
import com.aviary.android.feather.sdk.widget.CropImageView;
import com.aviary.android.feather.sdk.widget.HighlightView;
import com.aviary.android.feather.sdk.widget.VibrationWidget;
import it.sephiroth.android.library.imagezoom.ImageViewTouch;
import java.util.HashMap;
import java.util.HashSet;
import org.json.JSONException;

// Referenced classes of package com.aviary.android.feather.sdk.panels:
//            AbstractContentPanel

public class CropPanel extends AbstractContentPanel
    implements com.aviary.android.feather.sdk.widget.AviaryAdapterView.OnItemClickListener, com.aviary.android.feather.sdk.widget.AviaryGallery.OnItemsScrollListener
{
    private class GalleryAdapter extends BaseAdapter
    {

        static final int INVALID_POSITION = 0;
        static final int VALID_POSITION = 1;
        static final int VALID_POSITION_CUSTOM = 2;
        LayoutInflater mLayoutInflater;
        Resources mRes;
        private String mValues[];
        final CropPanel this$0;

        public int getCount()
        {
            return mValues.length;
        }

        public Object getItem(int i)
        {
            return mValues[i];
        }

        public long getItemId(int i)
        {
            return 0L;
        }

        public int getItemViewType(int i)
        {
            boolean flag = true;
            byte byte0;
            if (i >= 0 && i < getCount())
            {
                byte0 = 1;
            } else
            {
                byte0 = 0;
            }
            if (byte0 != 0)
            {
                byte0 = flag;
                if (mNonInvertOptions.contains(Integer.valueOf(i)))
                {
                    byte0 = 2;
                }
                return byte0;
            } else
            {
                return 0;
            }
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            int j = getItemViewType(i);
            viewgroup = view;
            if (view == null)
            {
                if (j == 1)
                {
                    view = mLayoutInflater.inflate(com.aviary.android.feather.sdk.R.layout.aviary_gallery_crop_item_view, mGallery, false);
                } else
                if (j == 2)
                {
                    view = mLayoutInflater.inflate(com.aviary.android.feather.sdk.R.layout.aviary_gallery_crop_item_view_custom, mGallery, false);
                } else
                {
                    view = mLayoutInflater.inflate(com.aviary.android.feather.sdk.R.layout.aviary_gallery_item_view, mGallery, false);
                    view.findViewById(com.aviary.android.feather.sdk.R.id.image).setVisibility(8);
                }
                viewgroup = view;
                if (FeatherActivity.MATURITY.isKidsFriendly())
                {
                    view.setVisibility(4);
                    viewgroup = view;
                }
            }
            if (j != 0)
            {
                view = (String)getItem(i);
                ((TextView)viewgroup.findViewById(com.aviary.android.feather.sdk.R.id.text)).setText(view);
                if (j == 1)
                {
                    view = (AviaryHighlightImageButton)viewgroup.findViewById(com.aviary.android.feather.sdk.R.id.image);
                    if (!mStrictPolicy && !mNonInvertOptions.contains(Integer.valueOf(i)))
                    {
                        j = 0;
                    } else
                    {
                        j = 8;
                    }
                    if (view != null)
                    {
                        view.setVisibility(j);
                        view.setChecked(isChecked);
                    }
                }
            }
            viewgroup.setId(i);
            return viewgroup;
        }

        public int getViewTypeCount()
        {
            return 3;
        }

        public GalleryAdapter(Context context, String as[])
        {
            this$0 = CropPanel.this;
            super();
            mLayoutInflater = LayoutInflater.from(context);
            mValues = as;
            mRes = context.getResources();
        }
    }

    class GenerateResultTask extends AviaryAsyncTask
    {

        MoaActionList mActionList;
        RectD mCropRect;
        final CropPanel this$0;

        protected transient Bitmap doInBackground(Bitmap abitmap[])
        {
            Object obj = abitmap[0];
            double d = ((Bitmap) (obj)).getWidth();
            double d1 = ((Bitmap) (obj)).getHeight();
            obj = new MoaPointParameter();
            ((MoaPointParameter) (obj)).setValue((int)mCropRect.left, (int)mCropRect.top);
            MoaPointParameter moapointparameter = new MoaPointParameter();
            moapointparameter.setValue((int)mCropRect.width(), (int)mCropRect.height());
            MoaPointParameter moapointparameter1 = new MoaPointParameter(d, d1);
            ((CropFilter)mFilter).setTopLeft(((MoaPointParameter) (obj)));
            ((CropFilter)mFilter).setSize(moapointparameter);
            ((CropFilter)mFilter).setPreviewSize(moapointparameter1);
            mActionList = (MoaActionList)((CropFilter)mFilter).getActions().clone();
            try
            {
                obj = ((CropFilter)mFilter).execute(abitmap[0], null, 1, 1);
            }
            catch (JSONException jsonexception)
            {
                jsonexception.printStackTrace();
                return abitmap[0];
            }
            return ((Bitmap) (obj));
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Bitmap[])aobj);
        }

        protected void doPostExecute(Bitmap bitmap)
        {
            onProgressEnd();
            ((CropImageView)mImageView).setImageBitmap(bitmap, ((CropImageView)mImageView).getAspectRatio(), ((CropImageView)mImageView).getAspectRatioIsFixed());
            ((CropImageView)mImageView).setHighlightView(null);
            mEditResult.setActionList(mActionList);
            mEditResult.setToolAction(new ToolActionVO());
            onComplete(bitmap);
        }

        protected volatile void doPostExecute(Object obj)
        {
            doPostExecute((Bitmap)obj);
        }

        protected void doPreExecute()
        {
            onProgressStart();
        }

        public GenerateResultTask(RectD rectd)
        {
            this$0 = CropPanel.this;
            super();
            mCropRect = rectd;
        }
    }


    boolean isChecked;
    String mCropNames[];
    String mCropValues[];
    AviaryGallery mGallery;
    private boolean mHasScrolled;
    boolean mIsPortrait;
    HashSet mNonInvertOptions;
    int mSelectedPosition;
    boolean mStrictPolicy;

    public CropPanel(IAviaryController iaviarycontroller, ToolEntry toolentry)
    {
        super(iaviarycontroller, toolentry);
        mSelectedPosition = 0;
        mIsPortrait = true;
        mNonInvertOptions = new HashSet();
        mStrictPolicy = false;
        isChecked = false;
    }

    private double calculateAspectRatio(int i, boolean flag)
    {
        String as[] = mCropValues[i].split(":");
        if (as.length == 2)
        {
            double d;
            double d1;
            String s;
            int j;
            int k;
            if (flag)
            {
                s = as[1];
            } else
            {
                s = as[0];
            }
            j = Integer.parseInt(s);
            if (flag)
            {
                s = as[0];
            } else
            {
                s = as[1];
            }
            k = Integer.parseInt(s);
            i = j;
            if (j == -1)
            {
                if (flag)
                {
                    i = mBitmap.getHeight();
                } else
                {
                    i = mBitmap.getWidth();
                }
            }
            j = k;
            if (k == -1)
            {
                if (flag)
                {
                    j = mBitmap.getWidth();
                } else
                {
                    j = mBitmap.getHeight();
                }
            }
            d1 = 0.0D;
            d = d1;
            if (i != 0)
            {
                d = d1;
                if (j != 0)
                {
                    d = (double)i / (double)j;
                }
            }
            return d;
        } else
        {
            return 0.0D;
        }
    }

    private void createCropView(double d, boolean flag)
    {
        ((CropImageView)mImageView).setImageBitmap(mBitmap, d, flag);
    }

    private void invertRatios(String as[], String as1[])
    {
        for (int i = 0; i < as.length; i++)
        {
            if (as[i].contains(":"))
            {
                String as2[] = as[i].split("[:]");
                as[i] = (new StringBuilder()).append(as2[1]).append(":").append(as2[0]).toString();
            }
            if (as1[i].contains(":"))
            {
                String as3[] = as1[i].split("[:]");
                as1[i] = (new StringBuilder()).append(as3[1]).append(":").append(as3[0]).toString();
            }
        }

    }

    private void populateInvertOptions(HashSet hashset, String as[])
    {
        for (int i = 0; i < as.length; i++)
        {
            String as1[] = as[i].split(":");
            if (Integer.parseInt(as1[0]) == Integer.parseInt(as1[1]))
            {
                hashset.add(Integer.valueOf(i));
            }
        }

    }

    private void setCustomRatio(double d, boolean flag)
    {
        mTrackingAttributes.put("aspect", String.valueOf(d));
        ((CropImageView)mImageView).setAspectRatio(d, flag);
    }

    protected View generateContentView(LayoutInflater layoutinflater)
    {
        return layoutinflater.inflate(com.aviary.android.feather.sdk.R.layout.aviary_content_crop, null);
    }

    protected ViewGroup generateOptionView(LayoutInflater layoutinflater, ViewGroup viewgroup)
    {
        int i;
        if (FeatherActivity.MATURITY.isKidsFriendly())
        {
            i = com.aviary.android.feather.sdk.R.layout.aviary_panel_crop_freetime;
        } else
        {
            i = com.aviary.android.feather.sdk.R.layout.aviary_panel_crop;
        }
        return (ViewGroup)layoutinflater.inflate(i, viewgroup, false);
    }

    public boolean getIsChanged()
    {
        return super.getIsChanged() && ((CropImageView)mImageView).hasCropRectChanged();
    }

    public volatile boolean isRendering()
    {
        return super.isRendering();
    }

    public void onActivate()
    {
        boolean flag = false;
        super.onActivate();
        disableHapticIsNecessary(new VibrationWidget[] {
            mGallery
        });
        mGallery.setOnItemsScrollListener(this);
        mGallery.setOnItemClickListener(this);
        double d = calculateAspectRatio(mGallery.getSelectedItemPosition(), false);
        if (d != 0.0D)
        {
            flag = true;
        }
        createCropView(d, flag);
        contentReady();
        setIsChanged(true);
    }

    public void onBitmapReplaced(Bitmap bitmap)
    {
        super.onBitmapReplaced(bitmap);
        bitmap = (CropImageView)mImageView;
        if (isActive())
        {
            bitmap.setImageBitmap(mBitmap, bitmap.getAspectRatio(), bitmap.getAspectRatioIsFixed());
            bitmap.setCropRectChanged(false);
            setIsChanged(true);
        }
    }

    public void onCreate(Bitmap bitmap, Bundle bundle)
    {
        super.onCreate(bitmap, bundle);
        bundle = (ConfigService)getContext().getService(com/aviary/android/feather/library/services/ConfigService);
        mFilter = ToolLoaderFactory.get(com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.CROP);
        if (FeatherActivity.MATURITY.isKidsFriendly())
        {
            mCropNames = bundle.getStringArray(com.aviary.android.feather.sdk.R.array.aviary_freetime_crop_labels);
            mCropValues = bundle.getStringArray(com.aviary.android.feather.sdk.R.array.aviary_freetime_crop_values);
        } else
        {
            mCropNames = bundle.getStringArray(com.aviary.android.feather.sdk.R.array.aviary_crop_labels);
            mCropValues = bundle.getStringArray(com.aviary.android.feather.sdk.R.array.aviary_crop_values);
        }
        mStrictPolicy = bundle.getBoolean(com.aviary.android.feather.sdk.R.integer.aviary_crop_invert_policy);
        if (!mStrictPolicy)
        {
            if (bitmap.getHeight() > bitmap.getWidth())
            {
                mIsPortrait = true;
            } else
            {
                mIsPortrait = false;
            }
            populateInvertOptions(mNonInvertOptions, mCropValues);
            if (mIsPortrait)
            {
                invertRatios(mCropNames, mCropValues);
            }
        }
        if (FeatherActivity.MATURITY.isKidsFriendly())
        {
            mSelectedPosition = bundle.getInteger(com.aviary.android.feather.sdk.R.integer.aviary_freetime_crop_selected_index);
        } else
        {
            mSelectedPosition = bundle.getInteger(com.aviary.android.feather.sdk.R.integer.aviary_crop_selected_index);
        }
        mImageView = (CropImageView)getContentView().findViewById(com.aviary.android.feather.sdk.R.id.aviary_crop_image);
        mImageView.setDoubleTapEnabled(false);
        mImageView.setScaleEnabled(true);
        mImageView.setScrollEnabled(true);
        mImageView.setDisplayType(it.sephiroth.android.library.imagezoom.ImageViewTouchBase.DisplayType.FIT_TO_SCREEN);
        mGallery = (AviaryGallery)getOptionView().findViewById(com.aviary.android.feather.sdk.R.id.aviary_gallery);
        mGallery.setDefaultPosition(mSelectedPosition);
        mGallery.setCallbackDuringFling(false);
        mGallery.setAutoSelectChild(false);
        mGallery.setAdapter(new GalleryAdapter(getContext().getBaseContext(), mCropNames));
        mGallery.setSelection(mSelectedPosition, false, true);
    }

    public void onDeactivate()
    {
        super.onDeactivate();
        mGallery.setOnItemsScrollListener(null);
        mGallery.setOnItemClickListener(null);
    }

    public void onDestroy()
    {
        mImageView.clear();
        ((CropImageView)mImageView).setOnHighlightSingleTapUpConfirmedListener(null);
        super.onDestroy();
    }

    protected void onGenerateResult()
    {
        (new GenerateResultTask(new RectD(((CropImageView)mImageView).getHighlightView().getCropRectD()))).execute(new Bitmap[] {
            mBitmap
        });
    }

    public void onItemClick(AviaryAdapterView aviaryadapterview, View view, int i, long l)
    {
        if (!mStrictPolicy && !mNonInvertOptions.contains(Integer.valueOf(i)))
        {
            double d;
            double d1;
            boolean flag;
            if (!isChecked)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            isChecked = flag;
            aviaryadapterview = (CropImageView)mImageView;
            d1 = aviaryadapterview.getAspectRatio();
            view = aviaryadapterview.getHighlightView();
            d = d1;
            if (!aviaryadapterview.getAspectRatioIsFixed())
            {
                d = d1;
                if (view != null)
                {
                    d = (double)view.getDrawRect().width() / (double)view.getDrawRect().height();
                }
            }
            aviaryadapterview.setAspectRatio(1.0D / d, aviaryadapterview.getAspectRatioIsFixed());
            invertRatios(mCropNames, mCropValues);
            mGallery.invalidateViews();
            mTrackingAttributes.put("aspect", String.valueOf(d));
        }
    }

    public void onScroll(AviaryAdapterView aviaryadapterview, View view, int i, long l)
    {
        mHasScrolled = true;
    }

    public void onScrollFinished(AviaryAdapterView aviaryadapterview, View view, int i, long l)
    {
        boolean flag = true;
        if (i == mSelectedPosition)
        {
            return;
        }
        mLogger.info("onScrollFinished: %d --> %d", new Object[] {
            Integer.valueOf(mSelectedPosition), Integer.valueOf(i)
        });
        mSelectedPosition = i;
        double d = calculateAspectRatio(i, false);
        if (d == 0.0D)
        {
            flag = false;
        }
        setCustomRatio(d, flag);
    }

    public void onScrollStarted(AviaryAdapterView aviaryadapterview, View view, int i, long l)
    {
        mHasScrolled = false;
    }

    public volatile void setEnabled(boolean flag)
    {
        super.setEnabled(flag);
    }
}
