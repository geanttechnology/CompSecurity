// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.groupon.Channel;
import com.groupon.fragment.PoGAutocomplete;
import com.groupon.fragment.PoGCoachmarkDialog;
import com.groupon.fragment.PoGLocationAutocomplete;
import com.groupon.fragment.PoGRecommendation;
import com.groupon.models.Place;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.LocationAutocompleteClient;
import com.groupon.util.LocationsAutocompleteServiceWrapper;
import com.groupon.util.LoggingUtils;
import com.groupon.util.ViewUtils;
import com.groupon.view.ClearableEditText;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            GlobalSearchBase

public class PoGSearch extends GlobalSearchBase
    implements com.groupon.fragment.PoGLocationAutocomplete.LocationCallback, LocationAutocompleteClient
{
    private static final class ViewState extends Enum
    {

        private static final ViewState $VALUES[];
        public static final ViewState LOCATION_AUTOCOMPLETE;
        public static final ViewState RECOMMENDATION;
        public static final ViewState SEARCH_AUTOCOMPLETE;

        public static ViewState valueOf(String s)
        {
            return (ViewState)Enum.valueOf(com/groupon/activity/PoGSearch$ViewState, s);
        }

        public static ViewState[] values()
        {
            return (ViewState[])$VALUES.clone();
        }

        static 
        {
            RECOMMENDATION = new ViewState("RECOMMENDATION", 0);
            SEARCH_AUTOCOMPLETE = new ViewState("SEARCH_AUTOCOMPLETE", 1);
            LOCATION_AUTOCOMPLETE = new ViewState("LOCATION_AUTOCOMPLETE", 2);
            $VALUES = (new ViewState[] {
                RECOMMENDATION, SEARCH_AUTOCOMPLETE, LOCATION_AUTOCOMPLETE
            });
        }

        private ViewState(String s, int i)
        {
            super(s, i);
        }
    }


    FrameLayout autocompleteContainer;
    protected String contxt;
    protected boolean displayCoachMark;
    FrameLayout locationContainer;
    private EditText locationSearchEditText;
    private ImageView locationSearchIcon;
    ClearableEditText locationSearchView;
    LocationsAutocompleteServiceWrapper locationsAutocompleteServiceWrapper;
    protected PoGAutocomplete poGAutocomplete;
    protected PoGLocationAutocomplete poGLocationAutocomplete;
    protected PoGRecommendation poGRecommendation;
    FrameLayout suggestionContainer;
    protected String targetUrl;

    public PoGSearch()
    {
    }

    private Bundle getExtraBundle()
    {
        Bundle bundle = new Bundle();
        bundle.putString("context", contxt);
        bundle.putString("url", targetUrl);
        return bundle;
    }

    private void initializeLocationSearchView()
    {
        locationSearchEditText = (EditText)locationSearchView.findViewById(0x7f1001a3);
        locationSearchIcon = (ImageView)locationSearchView.findViewById(0x7f1001a2);
        locationsAutocompleteServiceWrapper.setLocationAutocompleteClient(this);
        locationSearchEditText.addTextChangedListener(locationsAutocompleteServiceWrapper.getTextWatcher());
        locationSearchEditText.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() {

            final PoGSearch this$0;

            public void onFocusChange(View view, boolean flag)
            {
                int i;
                if (flag)
                {
                    toggleFragment(ViewState.LOCATION_AUTOCOMPLETE);
                    if (Strings.equalsIgnoreCase(Strings.toString(locationSearchEditText.getText()), locationsAutocompleteServiceWrapper.CURRENT_LOCATION))
                    {
                        locationSearchEditText.setText("");
                    }
                    locationsAutocompleteServiceWrapper.searchLocation(Strings.toString(locationSearchEditText.getText()));
                } else
                if (locationContainer.getVisibility() == 0)
                {
                    locationSearchEditText.setText(locationsAutocompleteServiceWrapper.getTopListSearchLocation().value);
                }
                locationSearchEditText.postDelayed(flag. new Runnable() {

                    final _cls1 this$1;
                    final boolean val$hasFocus;

                    public void run()
                    {
                        PoGSearch pogsearch = _fld0;
                        boolean flag;
                        if (!hasFocus)
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        ViewUtils.setSoftKeyboardState(pogsearch, flag, locationSearchEditText);
                    }

            
            {
                this$1 = final__pcls1;
                hasFocus = Z.this;
                super();
            }
                }, 500L);
                view = locationSearchIcon;
                if (flag)
                {
                    i = 0x7f020260;
                } else
                {
                    i = 0x7f020262;
                }
                view.setImageResource(i);
            }

            
            {
                this$0 = PoGSearch.this;
                super();
            }
        });
        locationSearchEditText.setOnClickListener(new android.view.View.OnClickListener() {

            final PoGSearch this$0;

            public void onClick(View view)
            {
                loggingUtils.logClickWithMetadata("", "pog_location_box_click", Channel.GLOBAL_SEARCH.name().toLowerCase(), null);
                locationsAutocompleteServiceWrapper.searchLocation(Strings.toString(locationSearchEditText.getText()));
            }

            
            {
                this$0 = PoGSearch.this;
                super();
            }
        });
        locationSearchEditText.setOnKeyListener(new android.view.View.OnKeyListener() {

            final PoGSearch this$0;

            public boolean onKey(View view, int i, KeyEvent keyevent)
            {
                return i == 66;
            }

            
            {
                this$0 = PoGSearch.this;
                super();
            }
        });
        locationSearchEditText.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() {

            final PoGSearch this$0;

            public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
            {
                return i == 3;
            }

            
            {
                this$0 = PoGSearch.this;
                super();
            }
        });
        locationSearchEditText.setText(locationsAutocompleteServiceWrapper.getCurrentlySelectedPlace().value);
    }

    public void dismissKeyboard()
    {
        ViewUtils.setSoftKeyboardState(this, true, textSearchEditText);
    }

    protected String getHintText()
    {
        return getString(0x7f080508);
    }

    public boolean isAutocomplete()
    {
        return locationSearchEditText != null && locationSearchEditText.hasFocus();
    }

    public boolean isTextEmpty()
    {
        return Strings.isEmpty(locationSearchEditText.getText());
    }

    public void locationReadyCallback(Location location)
    {
    }

    public void locationSearchReady(List list)
    {
        poGLocationAutocomplete.setAutocompleteList(list);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030191);
        initializeLocationSearchView();
        bundle = getFragmentManager();
        Object obj = (PoGRecommendation)bundle.findFragmentById(0x7f10047e);
        poGRecommendation = ((PoGRecommendation) (obj));
        if (obj == null)
        {
            poGRecommendation = new PoGRecommendation();
            poGRecommendation.setArguments(getExtraBundle());
            bundle.beginTransaction().add(0x7f10047e, poGRecommendation).commit();
        }
        obj = (PoGAutocomplete)bundle.findFragmentById(0x7f10047f);
        poGAutocomplete = ((PoGAutocomplete) (obj));
        if (obj == null)
        {
            poGAutocomplete = new PoGAutocomplete();
            poGAutocomplete.setArguments(getExtraBundle());
            bundle.beginTransaction().add(0x7f10047f, poGAutocomplete).commit();
        }
        obj = (PoGLocationAutocomplete)bundle.findFragmentById(0x7f100480);
        poGLocationAutocomplete = ((PoGLocationAutocomplete) (obj));
        if (obj == null)
        {
            poGLocationAutocomplete = new PoGLocationAutocomplete();
            bundle.beginTransaction().add(0x7f100480, poGLocationAutocomplete).commit();
        }
        if (displayCoachMark)
        {
            getIntent().putExtra("display_coach_mark", false);
            bundle = new PoGCoachmarkDialog();
            Bundle bundle1 = new Bundle();
            bundle1.putSerializable("type", com.groupon.fragment.PoGCoachmarkDialog.DialogType.CAMERA);
            bundle.setArguments(bundle1);
            bundle.setCancelable(false);
            bundle.show(getFragmentManager(), com.groupon.fragment.PoGCoachmarkDialog.DialogType.CAMERA.toString());
        }
    }

    public void onLocationSelected(Place place)
    {
        locationsAutocompleteServiceWrapper.saveRecentLocation(place);
        locationContainer.setVisibility(4);
        textSearchEditText.requestFocus();
        locationSearchEditText.setText(place.value);
        place = textSearchEditText.getText().toString();
        if (Strings.notEmpty(place))
        {
            poGAutocomplete.doSearch(place, locationsAutocompleteServiceWrapper.getCurrentlySelectedPlace());
        }
    }

    public void onResume()
    {
        super.onResume();
        loggingUtils.logPageView("", getClass().getSimpleName(), Logger.NULL_NST_FIELD);
    }

    protected void onSearchExecuted(String s)
    {
    }

    protected void onSearchTextBoxClicked()
    {
        loggingUtils.logClickWithMetadata("", "pog_search_icon_click", Channel.GLOBAL_SEARCH.name().toLowerCase(), null);
    }

    protected void onSearchTextChanged(CharSequence charsequence)
    {
        if (charsequence.toString().isEmpty())
        {
            toggleFragment(ViewState.RECOMMENDATION);
            return;
        } else
        {
            poGAutocomplete.doSearch(charsequence.toString(), locationsAutocompleteServiceWrapper.getCurrentlySelectedPlace());
            toggleFragment(ViewState.SEARCH_AUTOCOMPLETE);
            return;
        }
    }

    protected void onTextSearchFocusChanged(boolean flag)
    {
        String s = textSearchEditText.getText().toString();
        if (flag && Strings.isEmpty(s))
        {
            toggleFragment(ViewState.RECOMMENDATION);
        } else
        if (flag)
        {
            toggleFragment(ViewState.SEARCH_AUTOCOMPLETE);
            return;
        }
    }

    protected boolean requestFocusOnInitialize()
    {
        return false;
    }

    protected void toggleFragment(ViewState viewstate)
    {
        boolean flag = false;
        FrameLayout framelayout = autocompleteContainer;
        int i;
        if (ViewState.SEARCH_AUTOCOMPLETE.equals(viewstate))
        {
            i = 0;
        } else
        {
            i = 8;
        }
        framelayout.setVisibility(i);
        framelayout = suggestionContainer;
        if (ViewState.RECOMMENDATION.equals(viewstate))
        {
            i = 0;
        } else
        {
            i = 8;
        }
        framelayout.setVisibility(i);
        framelayout = locationContainer;
        if (ViewState.LOCATION_AUTOCOMPLETE.equals(viewstate))
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 8;
        }
        framelayout.setVisibility(i);
    }


}
