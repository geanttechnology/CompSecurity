// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.d;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class i
{

    private static i a;
    private static HashMap b = new HashMap();
    private static HashMap c = new HashMap();
    private static HashSet d = new HashSet();
    private static final List e = Arrays.asList(new String[] {
        "AnalogClock", "ImageView", "KeyboardView", "MediaRouteButton", "ProgressBar", "Space", "SurfaceView", "TextView", "TextureView", "ViewGroup", 
        "ViewStub", "AbsListView", "AbsSeekBar", "AbsSpinner", "AbsoluteLayout", "AdapterView", "AdapterViewAnimator", "AdapterViewFlipper", "AppWidgetHostView", "AutoCompleteTextView", 
        "Button", "CalendarView", "CheckBox", "CheckedTextView", "Chronometer", "CompoundButton", "ContentLoadingProgressBar", "DatePicker", "DialerFilter", "DigitalClock", 
        "DrawerLayout", "EditText", "ExpandableListView", "ExtractEditText", "FragmentBreadCrumbs", "FragmentTabHost", "FrameLayout", "GLSurfaceView", "Gallery", "GestureOverlayView", 
        "GridLayout", "GridView", "HorizontalScrollView", "ImageButton", "ImageSwitcher", "LinearLayout", "ListView", "MediaController", "MultiAutoCompleteTextView", "NumberPicker", 
        "PagerTabStrip", "PagerTitleStrip", "QuickContactBadge", "RadioButton", "RadioGroup", "RatingBar", "RelativeLayout", "ScrollView", "SearchView", "SeekBar", 
        "SlidingDrawer", "SlidingPaneLayout", "Spinner", "StackView", "SwipeRefreshLayout", "Switch", "TabHost", "TabWidget", "TableLayout", "TableRow", 
        "TextClock", "TimePicker", "ToggleButton", "TwoLineListItem", "VideoView", "ViewAnimator", "ViewFlipper", "ViewFlipper", "ViewPager", "WebView", 
        "ZoomButton", "ZoomControls", "View"
    });
    private static final HashSet f = new HashSet(Arrays.asList(new String[] {
        "setAlpha", "setHapticFeedbackEnabled", "setVisibility", "setPadding", "setBackgroundColor", "setBackgroundDrawable"
    }));
    private static final HashSet g = new HashSet(Arrays.asList(new String[] {
        "getAlpha", "isHapticFeedbackEnabled", "getVisibility", "getWidth", "getHeight", "getPaddingLeft", "getPaddingTop", "getPaddingRight", "getPaddingBottom", "getBackground"
    }));
    private static final HashSet h = new HashSet(Arrays.asList(new String[] {
        "setText", "setHint", "setLineSpacing", "setMaxLines", "setTextSize", "setGravity"
    }));
    private static final HashSet i = new HashSet(Arrays.asList(new String[] {
        "getText", "getHint", "getLineSpacingExtra", "getMaxLines", "getTextSize", "getGravity"
    }));
    private static final HashSet j = new HashSet(Arrays.asList(new String[] {
        "setImageAlpha", "setScaleType", "setImageDrawable"
    }));
    private static final HashSet k = new HashSet(Arrays.asList(new String[] {
        "getImageAlpha", "getScaleType", "getDrawable"
    }));

    private i()
    {
        d = new HashSet(e);
        b.put("View", f);
        c.put("View", g);
        h.addAll(f);
        b.put("TextView", h);
        i.addAll(g);
        c.put("TextView", i);
        j.addAll(f);
        b.put("ImageView", j);
        k.addAll(g);
        c.put("ImageView", k);
    }

    public static i a()
    {
        if (a != null)
        {
            return a;
        } else
        {
            a = new i();
            return a;
        }
    }

    public HashMap b()
    {
        return b;
    }

    public HashMap c()
    {
        return c;
    }

    public HashSet d()
    {
        return d;
    }

}
