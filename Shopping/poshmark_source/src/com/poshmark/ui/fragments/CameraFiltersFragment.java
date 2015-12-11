// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.poshmark.analytics.Analytics;
import com.poshmark.image_processing.ImageEffects;
import com.poshmark.ui.customviews.PMListingImageView;
import com.poshmark.utils.ImageUtils;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFragment

public class CameraFiltersFragment extends PMFragment
{
    private class ApplyFilter extends AsyncTask
        implements TraceFieldInterface
    {

        public Trace _nr_trace;
        final CameraFiltersFragment this$0;

        public void _nr_setTrace(Trace trace)
        {
            try
            {
                _nr_trace = trace;
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Trace trace)
            {
                return;
            }
        }

        protected transient Drawable doInBackground(String as[])
        {
            Object obj;
            FilterType filtertype;
            obj = null;
            filtertype = FilterType.valueOf(as[0]);
            if (filtertype != FilterType.FILTER_TYPE_MODERN) goto _L2; else goto _L1
_L1:
            as = ImageEffects.applyOverlay(ImageEffects.adjustImage(ImageEffects.balanceColor(getDisplayBitmap(), 1.0D, 1.0D, 1.3999999999999999D), 1.0F, 1.0F, 1.2F), "overlay_vignette_border_black_thick");
_L4:
            return new BitmapDrawable(getResources(), as);
_L2:
            if (filtertype == FilterType.FILTER_TYPE_VINTAGE)
            {
                as = ImageEffects.applyOverlay(ImageEffects.blendColor(ImageEffects.adjustImage(getDisplayBitmap(), 1.0F, 1.0F, 1.2F), Color.argb(255, 247, 218, 174), android.graphics.PorterDuff.Mode.MULTIPLY), "overlay_vignette_warm_border_black_thick");
            } else
            if (filtertype == FilterType.FILTER_TYPE_RETRO)
            {
                as = ImageEffects.applyOverlay(ImageEffects.balanceColor(getDisplayBitmap(), 1.3999999999999999D, 1.3D, 1.0D), "overlay_border_black_thick");
            } else
            if (filtertype == FilterType.FILTER_TYPE_CHIC)
            {
                as = ImageEffects.applyOverlay(ImageEffects.applyOverlay(ImageEffects.adjustImage(ImageEffects.balanceColor(getDisplayBitmap(), 1.2D, 1.0D, 0.69999999999999996D), 1.2F, 1.0F, 0.7F), "overlay_effect_lightleak"), "overlay_border_black_thick");
            } else
            if (filtertype == FilterType.FILTER_TYPE_STREET)
            {
                as = ImageEffects.applyOverlay(ImageEffects.adjustImage(getDisplayBitmap(), 1.5F, 1.0F, 1.4F), "overlay_border_white_thick");
            } else
            {
                as = obj;
                if (filtertype == FilterType.FILTER_TYPE_CLASSIC)
                {
                    as = ImageEffects.convertImageToGrayScale(getDisplayBitmap());
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            TraceMachine.enterMethod(_nr_trace, "CameraFiltersFragment$ApplyFilter#doInBackground", null);
_L1:
            aobj = doInBackground((String[])aobj);
            TraceMachine.exitMethod();
            TraceMachine.unloadTraceContext(this);
            return ((Object) (aobj));
            NoSuchFieldError nosuchfielderror;
            nosuchfielderror;
            TraceMachine.enterMethod(null, "CameraFiltersFragment$ApplyFilter#doInBackground", null);
              goto _L1
        }

        protected void onPostExecute(Drawable drawable)
        {
            filteredDrawable = drawable;
            imageView.setImageDrawable(filteredDrawable);
            hideProgressDialog();
        }

        protected volatile void onPostExecute(Object obj)
        {
            TraceMachine.enterMethod(_nr_trace, "CameraFiltersFragment$ApplyFilter#onPostExecute", null);
_L1:
            onPostExecute((Drawable)obj);
            TraceMachine.exitMethod();
            return;
            NoSuchFieldError nosuchfielderror;
            nosuchfielderror;
            TraceMachine.enterMethod(null, "CameraFiltersFragment$ApplyFilter#onPostExecute", null);
              goto _L1
        }

        protected void onPreExecute()
        {
            showProgressDialogWithMessage(getString(0x7f06009a));
        }

        private ApplyFilter()
        {
            this$0 = CameraFiltersFragment.this;
            super();
        }

    }

    static final class FilterType extends Enum
    {

        private static final FilterType $VALUES[];
        public static final FilterType FILTER_TYPE_CHIC;
        public static final FilterType FILTER_TYPE_CLASSIC;
        public static final FilterType FILTER_TYPE_GLAM;
        public static final FilterType FILTER_TYPE_MODERN;
        public static final FilterType FILTER_TYPE_RETRO;
        public static final FilterType FILTER_TYPE_STREET;
        public static final FilterType FILTER_TYPE_TIMELESS;
        public static final FilterType FILTER_TYPE_VINTAGE;

        public static FilterType valueOf(String s)
        {
            return (FilterType)Enum.valueOf(com/poshmark/ui/fragments/CameraFiltersFragment$FilterType, s);
        }

        public static FilterType[] values()
        {
            return (FilterType[])$VALUES.clone();
        }

        static 
        {
            FILTER_TYPE_TIMELESS = new FilterType("FILTER_TYPE_TIMELESS", 0);
            FILTER_TYPE_GLAM = new FilterType("FILTER_TYPE_GLAM", 1);
            FILTER_TYPE_MODERN = new FilterType("FILTER_TYPE_MODERN", 2);
            FILTER_TYPE_VINTAGE = new FilterType("FILTER_TYPE_VINTAGE", 3);
            FILTER_TYPE_RETRO = new FilterType("FILTER_TYPE_RETRO", 4);
            FILTER_TYPE_CHIC = new FilterType("FILTER_TYPE_CHIC", 5);
            FILTER_TYPE_STREET = new FilterType("FILTER_TYPE_STREET", 6);
            FILTER_TYPE_CLASSIC = new FilterType("FILTER_TYPE_CLASSIC", 7);
            $VALUES = (new FilterType[] {
                FILTER_TYPE_TIMELESS, FILTER_TYPE_GLAM, FILTER_TYPE_MODERN, FILTER_TYPE_VINTAGE, FILTER_TYPE_RETRO, FILTER_TYPE_CHIC, FILTER_TYPE_STREET, FILTER_TYPE_CLASSIC
            });
        }

        private FilterType(String s, int i)
        {
            super(s, i);
        }
    }


    FilterType currentFilter;
    Uri fileName;
    Drawable filteredDrawable;
    PMListingImageView imageView;

    public CameraFiltersFragment()
    {
        fileName = null;
        currentFilter = null;
    }

    private Bitmap getDisplayBitmap()
    {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inMutable = true;
        return BitmapFactoryInstrumentation.decodeFile(fileName.getPath(), options);
    }

    private String getFilterNameForType(FilterType filtertype)
    {
        static class _cls11
        {

            static final int $SwitchMap$com$poshmark$ui$fragments$CameraFiltersFragment$FilterType[];

            static 
            {
                $SwitchMap$com$poshmark$ui$fragments$CameraFiltersFragment$FilterType = new int[FilterType.values().length];
                try
                {
                    $SwitchMap$com$poshmark$ui$fragments$CameraFiltersFragment$FilterType[FilterType.FILTER_TYPE_CHIC.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$poshmark$ui$fragments$CameraFiltersFragment$FilterType[FilterType.FILTER_TYPE_CLASSIC.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$poshmark$ui$fragments$CameraFiltersFragment$FilterType[FilterType.FILTER_TYPE_GLAM.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$poshmark$ui$fragments$CameraFiltersFragment$FilterType[FilterType.FILTER_TYPE_MODERN.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$poshmark$ui$fragments$CameraFiltersFragment$FilterType[FilterType.FILTER_TYPE_RETRO.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$poshmark$ui$fragments$CameraFiltersFragment$FilterType[FilterType.FILTER_TYPE_STREET.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$poshmark$ui$fragments$CameraFiltersFragment$FilterType[FilterType.FILTER_TYPE_TIMELESS.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$poshmark$ui$fragments$CameraFiltersFragment$FilterType[FilterType.FILTER_TYPE_VINTAGE.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls11..SwitchMap.com.poshmark.ui.fragments.CameraFiltersFragment.FilterType[filtertype.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return getString(0x7f060112);

        case 2: // '\002'
            return getString(0x7f060113);

        case 3: // '\003'
            return getString(0x7f060114);

        case 4: // '\004'
            return getString(0x7f060115);

        case 5: // '\005'
            return getString(0x7f060118);

        case 6: // '\006'
            return getString(0x7f060119);

        case 7: // '\007'
            return getString(0x7f06011a);

        case 8: // '\b'
            return getString(0x7f06011b);
        }
    }

    private void resetImage()
    {
        imageView.setImageBitmap(getDisplayBitmap());
    }

    private void setupActionBarNextActionButton()
    {
        Button button = getNextActionButton();
        if (button == null)
        {
            return;
        } else
        {
            button.setText(getString(0x7f0601cc).toUpperCase());
            button.setOnClickListener(new android.view.View.OnClickListener() {

                final CameraFiltersFragment this$0;

                public void onClick(View view)
                {
                    view = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("ORIGINALFILE", fileName);
                    if (currentFilter != null)
                    {
                        bundle.putParcelable("FILTEREDFILE", ImageUtils.saveDrawableToDisk(imageView.getDrawable()));
                        String s = getFilterNameForType(currentFilter);
                        Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "image_filter_selected", s);
                    } else
                    {
                        bundle.putParcelable("FILTEREDFILE", fileName);
                    }
                    view.putExtras(bundle);
                    finishActivityWithResult(-1, view);
                }

            
            {
                this$0 = CameraFiltersFragment.this;
                super();
            }
            });
            return;
        }
    }

    private void setupFilterButtonHandlers()
    {
        View view = getView();
        ((ImageButton)view.findViewById(0x7f0c0086)).setOnClickListener(new android.view.View.OnClickListener() {

            final CameraFiltersFragment this$0;

            public void onClick(View view1)
            {
                resetImage();
                currentFilter = null;
            }

            
            {
                this$0 = CameraFiltersFragment.this;
                super();
            }
        });
        ((ImageButton)getView().findViewById(0x7f0c0087)).setOnClickListener(new android.view.View.OnClickListener() {

            final CameraFiltersFragment this$0;

            public void onClick(View view1)
            {
                currentFilter = FilterType.FILTER_TYPE_TIMELESS;
                view1 = getFilterNameForType(currentFilter);
                Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "image_filter_preview", view1);
            }

            
            {
                this$0 = CameraFiltersFragment.this;
                super();
            }
        });
        ((ImageButton)view.findViewById(0x7f0c0088)).setOnClickListener(new android.view.View.OnClickListener() {

            final CameraFiltersFragment this$0;

            public void onClick(View view1)
            {
                currentFilter = FilterType.FILTER_TYPE_GLAM;
                view1 = getFilterNameForType(currentFilter);
                Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "image_filter_preview", view1);
            }

            
            {
                this$0 = CameraFiltersFragment.this;
                super();
            }
        });
        ((ImageButton)view.findViewById(0x7f0c0089)).setOnClickListener(new android.view.View.OnClickListener() {

            final CameraFiltersFragment this$0;

            public void onClick(View view1)
            {
                currentFilter = FilterType.FILTER_TYPE_MODERN;
                view1 = new ApplyFilter();
                String as[] = new String[1];
                as[0] = currentFilter.toString();
                if (!(view1 instanceof AsyncTask))
                {
                    view1.execute(as);
                } else
                {
                    AsyncTaskInstrumentation.execute((AsyncTask)view1, as);
                }
                view1 = getFilterNameForType(currentFilter);
                Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "image_filter_preview", view1);
            }

            
            {
                this$0 = CameraFiltersFragment.this;
                super();
            }
        });
        ((ImageButton)view.findViewById(0x7f0c008a)).setOnClickListener(new android.view.View.OnClickListener() {

            final CameraFiltersFragment this$0;

            public void onClick(View view1)
            {
                currentFilter = FilterType.FILTER_TYPE_VINTAGE;
                view1 = new ApplyFilter();
                String as[] = new String[1];
                as[0] = currentFilter.toString();
                if (!(view1 instanceof AsyncTask))
                {
                    view1.execute(as);
                } else
                {
                    AsyncTaskInstrumentation.execute((AsyncTask)view1, as);
                }
                view1 = getFilterNameForType(currentFilter);
                Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "image_filter_preview", view1);
            }

            
            {
                this$0 = CameraFiltersFragment.this;
                super();
            }
        });
        ((ImageButton)view.findViewById(0x7f0c008b)).setOnClickListener(new android.view.View.OnClickListener() {

            final CameraFiltersFragment this$0;

            public void onClick(View view1)
            {
                currentFilter = FilterType.FILTER_TYPE_RETRO;
                view1 = new ApplyFilter();
                String as[] = new String[1];
                as[0] = currentFilter.toString();
                if (!(view1 instanceof AsyncTask))
                {
                    view1.execute(as);
                } else
                {
                    AsyncTaskInstrumentation.execute((AsyncTask)view1, as);
                }
                view1 = getFilterNameForType(currentFilter);
                Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "image_filter_preview", view1);
            }

            
            {
                this$0 = CameraFiltersFragment.this;
                super();
            }
        });
        ((ImageButton)view.findViewById(0x7f0c008c)).setOnClickListener(new android.view.View.OnClickListener() {

            final CameraFiltersFragment this$0;

            public void onClick(View view1)
            {
                currentFilter = FilterType.FILTER_TYPE_CHIC;
                view1 = new ApplyFilter();
                String as[] = new String[1];
                as[0] = currentFilter.toString();
                if (!(view1 instanceof AsyncTask))
                {
                    view1.execute(as);
                } else
                {
                    AsyncTaskInstrumentation.execute((AsyncTask)view1, as);
                }
                view1 = getFilterNameForType(currentFilter);
                Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "image_filter_preview", view1);
            }

            
            {
                this$0 = CameraFiltersFragment.this;
                super();
            }
        });
        ((ImageButton)view.findViewById(0x7f0c008d)).setOnClickListener(new android.view.View.OnClickListener() {

            final CameraFiltersFragment this$0;

            public void onClick(View view1)
            {
                currentFilter = FilterType.FILTER_TYPE_STREET;
                view1 = new ApplyFilter();
                String as[] = new String[1];
                as[0] = currentFilter.toString();
                if (!(view1 instanceof AsyncTask))
                {
                    view1.execute(as);
                } else
                {
                    AsyncTaskInstrumentation.execute((AsyncTask)view1, as);
                }
                view1 = getFilterNameForType(currentFilter);
                Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "image_filter_preview", view1);
            }

            
            {
                this$0 = CameraFiltersFragment.this;
                super();
            }
        });
        ((ImageButton)view.findViewById(0x7f0c008e)).setOnClickListener(new android.view.View.OnClickListener() {

            final CameraFiltersFragment this$0;

            public void onClick(View view1)
            {
                currentFilter = FilterType.FILTER_TYPE_CLASSIC;
                view1 = new ApplyFilter();
                String as[] = new String[1];
                as[0] = currentFilter.toString();
                if (!(view1 instanceof AsyncTask))
                {
                    view1.execute(as);
                } else
                {
                    AsyncTaskInstrumentation.execute((AsyncTask)view1, as);
                }
                view1 = getFilterNameForType(currentFilter);
                Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "image_filter_preview", view1);
            }

            
            {
                this$0 = CameraFiltersFragment.this;
                super();
            }
        });
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        imageView = (PMListingImageView)getView().findViewById(0x7f0c0084);
        resetImage();
        setupFilterButtonHandlers();
        hideAllActionButtons(true);
        setupActionBarNextActionButton();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getArguments();
        if (bundle != null)
        {
            fileName = (Uri)bundle.getParcelable("FILE");
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        layoutinflater = layoutinflater.inflate(0x7f03001d, viewgroup, false);
        setTitle(0x7f060099);
        return layoutinflater;
    }

    public void onResume()
    {
        super.onResume();
        setupFilterButtonHandlers();
        hideAllActionButtons(true);
        setupActionBarNextActionButton();
    }

    public void setViewNameForAnalytics()
    {
        viewNameForAnalytics = "image_filters_screen";
    }



}
