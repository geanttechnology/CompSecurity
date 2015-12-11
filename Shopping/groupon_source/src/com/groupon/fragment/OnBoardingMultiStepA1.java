// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.ButterKnife;
import com.groupon.events.ZipCodeSelectedEvent;
import com.groupon.models.country.Country;
import com.groupon.models.division.City;
import com.groupon.service.LocationService;
import com.groupon.service.core.AbTestService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.service.countryanddivision.CurrentDivisionManager;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.ArraySharedPreferences;
import com.groupon.util.DivisionUtil;
import com.groupon.util.GeoPoint;
import com.groupon.util.GeoUtils;
import com.groupon.view.SpinnerButton;
import com.groupon.view.TypewriterTextView;
import com.squareup.otto.Bus;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import roboguice.util.Ln;
import roboguice.util.RoboAsyncTask;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.fragment:
//            OnboardingFragment

public class OnBoardingMultiStepA1 extends OnboardingFragment
{

    private static final String PROPERTY_ALPHA = "alpha";
    private static final String PROPERTY_ROTATION = "rotation";
    private static final String PROPERTY_SCALE_X = "scaleX";
    private static final String PROPERTY_SCALE_Y = "scaleY";
    private static final String PROPERTY_X = "x";
    private static final String PROPERTY_Y = "y";
    protected AbTestService abTestService;
    private boolean animationDisplayed;
    View bottomContainer;
    protected Bus bus;
    private AnimatorSet categoriesAnimatorSet;
    protected View categoriesContainer;
    View categoryCircleIcon;
    TypewriterTextView containerText;
    protected SpinnerButton continueButton;
    protected CurrentCountryManager currentCountryManager;
    private CurrentDivisionManager currentDivisionManager;
    private DivisionUtil divisionUtil;
    protected int exitAnimationDelay;
    View forkIcon;
    protected GeoUtils geoUtils;
    protected Geocoder geocoder;
    protected InputMethodManager imm;
    protected EditText inputField;
    private boolean isCategoriesContainerVisibile;
    View knifeIcon;
    private LocationService locationService;
    protected Logger logger;
    private ArraySharedPreferences loginPrefs;
    String lunch;
    private float originalLunchY;
    private float originalShoppingX;
    private float originalShoppingY;
    private float originalTravelX;
    private float originalTravelY;
    String reservations;
    View shoppingIcon;
    protected View skipOnboarding;
    String travel;
    View travelIcon;
    protected RelativeLayout userInputContainer;

    public OnBoardingMultiStepA1()
    {
        exitAnimationDelay = 1000;
        animationDisplayed = false;
        isCategoriesContainerVisibile = true;
    }

    private android.view.ViewTreeObserver.OnGlobalLayoutListener getBottomContainerGlobalLayoutListener()
    {
        return new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

            final OnBoardingMultiStepA1 this$0;

            public void onGlobalLayout()
            {
                while (categoriesContainer == null || userInputContainer == null || bottomContainer == null || animationDisplayed) 
                {
                    return;
                }
                animationDisplayed = true;
                if (isCategoriesContainerVisibile)
                {
                    bottomContainer.setY(bottomContainer.getY() + (float)userInputContainer.getHeight());
                    startCategoriesAnimation();
                    return;
                } else
                {
                    categoriesContainer.setVisibility(8);
                    return;
                }
            }

            
            {
                this$0 = OnBoardingMultiStepA1.this;
                super();
            }
        };
    }

    private Animator getCircleGrowAnimator()
    {
        AnimatorSet animatorset = new AnimatorSet();
        animatorset.playTogether(new Animator[] {
            ObjectAnimator.ofFloat(categoryCircleIcon, "scaleX", new float[] {
                0.0F, categoryCircleIcon.getScaleX()
            }), ObjectAnimator.ofFloat(categoryCircleIcon, "scaleY", new float[] {
                0.0F, categoryCircleIcon.getScaleY()
            })
        });
        animatorset.setInterpolator(new DecelerateInterpolator());
        animatorset.setDuration(400L);
        return animatorset;
    }

    private Animator getEnterZipCodeAnimator()
    {
        Object obj = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(((DisplayMetrics) (obj)));
        float f = bottomContainer.getY();
        float f1 = bottomContainer.getY();
        float f2 = userInputContainer.getHeight();
        obj = ObjectAnimator.ofFloat(bottomContainer, "y", new float[] {
            f, f1 - f2
        });
        ((ObjectAnimator) (obj)).setDuration(600L);
        ((ObjectAnimator) (obj)).setInterpolator(new DecelerateInterpolator());
        ((ObjectAnimator) (obj)).addListener(new AnimatorListenerAdapter() {

            final OnBoardingMultiStepA1 this$0;

            public void onAnimationEnd(Animator animator)
            {
                super.onAnimationEnd(animator);
                if (categoriesContainer != null)
                {
                    categoriesContainer.setVisibility(8);
                }
                if (inputField != null)
                {
                    inputField.setFocusable(true);
                    inputField.setFocusableInTouchMode(true);
                }
            }

            public void onAnimationStart(Animator animator)
            {
                super.onAnimationStart(animator);
                if (inputField != null)
                {
                    inputField.setFocusable(false);
                }
            }

            
            {
                this$0 = OnBoardingMultiStepA1.this;
                super();
            }
        });
        return ((Animator) (obj));
    }

    private Animator getLunchSlideInAnimator()
    {
        float f = forkIcon.getY();
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(forkIcon, "y", new float[] {
            f, originalLunchY
        }).setDuration(600L);
        ObjectAnimator objectanimator1 = ObjectAnimator.ofFloat(knifeIcon, "y", new float[] {
            f, originalLunchY
        }).setDuration(600L);
        objectanimator1.setStartDelay(200L);
        AnimatorSet animatorset = new AnimatorSet();
        animatorset.playTogether(new Animator[] {
            objectanimator, objectanimator1
        });
        animatorset.addListener(new AnimatorListenerAdapter() {

            final OnBoardingMultiStepA1 this$0;

            public void onAnimationStart(Animator animator)
            {
                super.onAnimationStart(animator);
                containerText.setCharacterDelay(50L);
                containerText.animateInText(lunch);
            }

            
            {
                this$0 = OnBoardingMultiStepA1.this;
                super();
            }
        });
        return animatorset;
    }

    private Animator getLunchSlideOutAnimator()
    {
        float f = -categoryCircleIcon.getHeight();
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(forkIcon, "y", new float[] {
            originalLunchY, f
        }).setDuration(600L);
        objectanimator.addListener(new AnimatorListenerAdapter() {

            final OnBoardingMultiStepA1 this$0;

            public void onAnimationStart(Animator animator)
            {
                super.onAnimationStart(animator);
                containerText.setCharacterDelay(50L);
                containerText.animateOutText(lunch);
            }

            
            {
                this$0 = OnBoardingMultiStepA1.this;
                super();
            }
        });
        ObjectAnimator objectanimator1 = ObjectAnimator.ofFloat(knifeIcon, "y", new float[] {
            originalLunchY, f
        }).setDuration(600L);
        objectanimator1.setStartDelay(200L);
        AnimatorSet animatorset = new AnimatorSet();
        animatorset.playTogether(new Animator[] {
            objectanimator, objectanimator1
        });
        animatorset.setStartDelay(1000L);
        return animatorset;
    }

    private Animator getShoppingSlideInAnimator()
    {
        float f = shoppingIcon.getX();
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(shoppingIcon, "x", new float[] {
            f, originalShoppingX
        });
        objectanimator.setDuration(300L);
        Object obj = ObjectAnimator.ofFloat(shoppingIcon, "rotation", new float[] {
            -10F, 15F
        }).setDuration(200L);
        ObjectAnimator objectanimator1 = ObjectAnimator.ofFloat(shoppingIcon, "rotation", new float[] {
            15F, -15F
        }).setDuration(200L);
        ObjectAnimator objectanimator2 = ObjectAnimator.ofFloat(shoppingIcon, "rotation", new float[] {
            -15F, 5F
        }).setDuration(200L);
        ObjectAnimator objectanimator3 = ObjectAnimator.ofFloat(shoppingIcon, "rotation", new float[] {
            5F, -5F
        }).setDuration(200L);
        ObjectAnimator objectanimator4 = ObjectAnimator.ofFloat(shoppingIcon, "rotation", new float[] {
            -5F, 0.0F
        }).setDuration(200L);
        AnimatorSet animatorset = new AnimatorSet();
        animatorset.playSequentially(new Animator[] {
            obj, objectanimator1, objectanimator2, objectanimator3, objectanimator4
        });
        animatorset.setStartDelay(250L);
        obj = new AnimatorSet();
        ((AnimatorSet) (obj)).playTogether(new Animator[] {
            objectanimator, animatorset
        });
        ((AnimatorSet) (obj)).setInterpolator(new DecelerateInterpolator());
        ((AnimatorSet) (obj)).addListener(new AnimatorListenerAdapter() {

            final OnBoardingMultiStepA1 this$0;

            public void onAnimationStart(Animator animator)
            {
                super.onAnimationStart(animator);
                containerText.setCharacterDelay(30L);
                containerText.animateInText(reservations);
            }

            
            {
                this$0 = OnBoardingMultiStepA1.this;
                super();
            }
        });
        return ((Animator) (obj));
    }

    private Animator getShoppingSlideOutAnimator()
    {
        float f = categoryCircleIcon.getY();
        float f1 = categoryCircleIcon.getHeight();
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(shoppingIcon, "y", new float[] {
            originalShoppingY, f + f1
        }).setDuration(400L);
        objectanimator.setStartDelay(600L);
        objectanimator.addListener(new AnimatorListenerAdapter() {

            final OnBoardingMultiStepA1 this$0;

            public void onAnimationStart(Animator animator)
            {
                super.onAnimationStart(animator);
                containerText.setCharacterDelay(30L);
                containerText.animateOutText(reservations);
            }

            
            {
                this$0 = OnBoardingMultiStepA1.this;
                super();
            }
        });
        ObjectAnimator objectanimator1 = ObjectAnimator.ofFloat(shoppingIcon, "rotation", new float[] {
            0.0F, 15F
        }).setDuration(300L);
        AnimatorSet animatorset = new AnimatorSet();
        animatorset.playTogether(new Animator[] {
            objectanimator, objectanimator1
        });
        animatorset.setInterpolator(new AccelerateDecelerateInterpolator());
        return animatorset;
    }

    private Animator getTravelSlideInAnimator()
    {
        float f = travelIcon.getX();
        float f1 = travelIcon.getY();
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(travelIcon, "x", new float[] {
            f, originalTravelX
        }).setDuration(600L);
        ObjectAnimator objectanimator1 = ObjectAnimator.ofFloat(travelIcon, "y", new float[] {
            f1, originalTravelY
        }).setDuration(600L);
        AnimatorSet animatorset = new AnimatorSet();
        animatorset.playTogether(new Animator[] {
            objectanimator, objectanimator1
        });
        animatorset.addListener(new AnimatorListenerAdapter() {

            final OnBoardingMultiStepA1 this$0;

            public void onAnimationStart(Animator animator)
            {
                super.onAnimationStart(animator);
                containerText.setCharacterDelay(50L);
                containerText.animateInText(travel);
            }

            
            {
                this$0 = OnBoardingMultiStepA1.this;
                super();
            }
        });
        return animatorset;
    }

    private void goToNextEvent()
    {
        Bus bus1 = bus;
        android.text.Editable editable;
        if (inputField != null)
        {
            editable = inputField.getText();
        } else
        {
            editable = null;
        }
        bus1.post(new ZipCodeSelectedEvent(Strings.toString(editable)));
        bus.post(new com.groupon.activity.OnboardingMultiStep.NextStepEvent());
    }

    private void setupViews()
    {
        if (userInputContainer != null)
        {
            userInputContainer.removeAllViews();
            inflateUserInputComponent();
        }
        if (categoriesContainer != null)
        {
            categoriesContainer.setVisibility(0);
        }
        continueButton.setOnClickListener(getOnContinueClickListener());
        if (bottomContainer == null || categoriesContainer == null)
        {
            return;
        }
        if (!animationDisplayed)
        {
            bottomContainer.getViewTreeObserver().addOnGlobalLayoutListener(getBottomContainerGlobalLayoutListener());
        }
        View view = categoriesContainer;
        byte byte0;
        if (animationDisplayed)
        {
            byte0 = 8;
        } else
        {
            byte0 = 0;
        }
        view.setVisibility(byte0);
        userInputContainer.setVisibility(0);
    }

    private void showInetRequired()
    {
        if (getActivity() != null)
        {
            Toast.makeText(getActivity().getApplicationContext(), 0x7f080165, 0).show();
        }
    }

    private void showZipcodeError()
    {
        if (getActivity() != null)
        {
            Toast.makeText(getActivity().getApplicationContext(), 0x7f08042f, 0).show();
        }
    }

    private void startCategoriesAnimation()
    {
        originalLunchY = forkIcon.getY();
        originalShoppingX = shoppingIcon.getX();
        originalShoppingY = shoppingIcon.getY();
        originalTravelX = travelIcon.getX();
        originalTravelY = travelIcon.getY();
        forkIcon.setY(categoryCircleIcon.getY() + (float)categoryCircleIcon.getHeight());
        knifeIcon.setY(categoryCircleIcon.getY() + (float)categoryCircleIcon.getHeight());
        shoppingIcon.setX(categoryCircleIcon.getX() + (float)categoryCircleIcon.getWidth());
        travelIcon.setX(-categoryCircleIcon.getWidth());
        travelIcon.setY(categoryCircleIcon.getY() + (float)categoryCircleIcon.getHeight());
        shoppingIcon.setPivotX(shoppingIcon.getWidth() / 2);
        shoppingIcon.setPivotY(0.0F);
        shoppingIcon.setRotation(-10F);
        categoriesAnimatorSet = new AnimatorSet();
        categoriesAnimatorSet.playSequentially(new Animator[] {
            getCircleGrowAnimator(), getLunchSlideInAnimator(), getLunchSlideOutAnimator(), getShoppingSlideInAnimator(), getShoppingSlideOutAnimator(), getTravelSlideInAnimator()
        });
        categoriesAnimatorSet.setInterpolator(new DecelerateInterpolator());
        categoriesAnimatorSet.addListener(new AnimatorListenerAdapter() {

            final OnBoardingMultiStepA1 this$0;

            public void onAnimationEnd(Animator animator)
            {
                super.onAnimationEnd(animator);
                if (currentCountryManager.getCurrentCountry().shouldHideEmailSubscriptionInOnBoarding())
                {
                    goToNextEvent();
                    return;
                } else
                {
                    startExitAnimation();
                    return;
                }
            }

            
            {
                this$0 = OnBoardingMultiStepA1.this;
                super();
            }
        });
        categoriesAnimatorSet.start();
    }

    private void startExitAnimation()
    {
        AnimatorSet animatorset = new AnimatorSet();
        animatorset.playTogether(new Animator[] {
            getExitCategoriesAnimator(), getEnterZipCodeAnimator()
        });
        animatorset.setStartDelay(exitAnimationDelay);
        animatorset.start();
    }

    private void updateDivisionFrom(Address address)
    {
        Object obj = new GeoPoint((int)(address.getLatitude() * 1000000D), (int)(address.getLongitude() * 1000000D));
        obj = divisionUtil.getDivisionFrom(((GeoPoint) (obj)));
        if (obj != null)
        {
            String s = divisionUtil.getCityNameFromAddress(address);
            address = ((Address) (obj));
            if (abTestService.isVariantEnabled("maskDivisions1508", "on"))
            {
                address = ((Address) (obj));
                if (currentCountryManager.getCurrentCountry().isLocationsAutocompleteEnabledCountry())
                {
                    address = ((Address) (obj));
                    if (Strings.notEmpty(s))
                    {
                        address = new City(((com.groupon.models.division.Division) (obj)), s);
                    }
                }
            }
            currentDivisionManager.setCurrentDivisionAndClearCaches(address, new Class[0]);
        }
    }

    private void validateZipcodeAndContinue()
    {
        String s;
label0:
        {
            if (getActivity() != null)
            {
                if (inputField != null)
                {
                    s = inputField.getText().toString();
                } else
                {
                    s = null;
                }
                if (!Strings.isEmpty(s))
                {
                    break label0;
                }
                showZipcodeError();
            }
            return;
        }
        (new RoboAsyncTask(s) {

            final OnBoardingMultiStepA1 this$0;
            final String val$zipCode;

            public Address call()
                throws Exception
            {
                List list = geocoder.getFromLocationName(zipCode, 1);
                if (list != null && list.size() > 0 && Strings.equalsIgnoreCase(((Address)list.get(0)).getCountryCode(), "us"))
                {
                    return (Address)list.get(0);
                } else
                {
                    return null;
                }
            }

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            protected void onException(Exception exception)
            {
                super.onException(exception);
                if (exception instanceof IOException)
                {
                    geoUtils.logGeocodeException(exception, com/groupon/fragment/OnBoardingMultiStepA1.getSimpleName());
                    goToNextEvent();
                    return;
                }
                if (exception instanceof NullPointerException)
                {
                    showZipcodeError();
                    return;
                } else
                {
                    showInetRequired();
                    return;
                }
            }

            protected void onFinally()
            {
                super.onFinally();
                continueButton.stopSpinning();
            }

            protected void onPreExecute()
                throws Exception
            {
                super.onPreExecute();
                continueButton.startSpinning();
            }

            protected void onSuccess(Address address)
                throws Exception
            {
                super.onSuccess(address);
                if (address != null)
                {
                    updateDivisionFrom(address);
                    goToNextEvent();
                    return;
                } else
                {
                    showZipcodeError();
                    return;
                }
            }

            protected volatile void onSuccess(Object obj)
                throws Exception
            {
                onSuccess((Address)obj);
            }

            
            {
                this$0 = OnBoardingMultiStepA1.this;
                zipCode = s;
                super(final_context);
            }
        }).execute();
    }

    protected Animator getExitCategoriesAnimator()
    {
        AnimatorSet animatorset = new AnimatorSet();
        animatorset.playTogether(new Animator[] {
            ObjectAnimator.ofFloat(categoriesContainer, "alpha", new float[] {
                1.0F, 0.0F
            }).setDuration(300L), ObjectAnimator.ofFloat(categoriesContainer, "y", new float[] {
                categoriesContainer.getY(), categoriesContainer.getY() + (float)categoriesContainer.getHeight()
            }).setDuration(300L)
        });
        animatorset.setInterpolator(new DecelerateInterpolator());
        return animatorset;
    }

    protected android.view.View.OnClickListener getOnContinueClickListener()
    {
        return new android.view.View.OnClickListener() {

            final OnBoardingMultiStepA1 this$0;

            public void onClick(View view)
            {
                if (categoriesContainer != null && categoriesContainer.getVisibility() == 0)
                {
                    exitAnimationDelay = 0;
                    stopCategoriesAnimation();
                    return;
                } else
                {
                    logger.logClick("", "zipcode_continue_button_click", com/groupon/fragment/OnBoardingMultiStepA1.getSimpleName(), "");
                    validateZipcodeAndContinue();
                    imm.hideSoftInputFromWindow(inputField.getWindowToken(), 0);
                    return;
                }
            }

            
            {
                this$0 = OnBoardingMultiStepA1.this;
                super();
            }
        };
    }

    protected void inflateUserInputComponent()
    {
        View view = ((LayoutInflater)getActivity().getSystemService("layout_inflater")).inflate(0x7f03018a, userInputContainer);
        inputField = (EditText)view.findViewById(0x7f100006);
        skipOnboarding = view.findViewById(0x7f100475);
    }

    public void onActivityCreated(Bundle bundle)
    {
        Object obj;
        boolean flag = true;
        super.onActivityCreated(bundle);
        logger.logPageView("", com/groupon/fragment/OnBoardingMultiStepA1.getSimpleName(), Logger.NULL_NST_FIELD);
        if (bundle != null)
        {
            if (bundle.getInt("categoriesContainerVisibility") != 0)
            {
                flag = false;
            }
            isCategoriesContainerVisibile = flag;
        }
        setupViews();
        setListeners();
        if (!currentCountryManager.getCurrentCountry().isUnitedStates()) goto _L2; else goto _L1
_L1:
        obj = locationService.getLocation();
        geocoder = new Geocoder(getActivity(), Locale.US);
        if (obj == null) goto _L4; else goto _L3
_L3:
        obj = geocoder.getFromLocation(((Location) (obj)).getLatitude(), ((Location) (obj)).getLongitude(), 2);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_243;
        }
        if (((List) (obj)).size() <= 0)
        {
            break MISSING_BLOCK_LABEL_243;
        }
        obj = (Address)((List) (obj)).get(0);
_L5:
        if (obj != null)
        {
            try
            {
                if (Strings.equalsIgnoreCase(((Address) (obj)).getCountryCode(), currentCountryManager.getCurrentCountry().isoName))
                {
                    inputField.setText(((Address) (obj)).getPostalCode());
                    inputField.setCursorVisible(false);
                    loginPrefs.edit().putBoolean("prefilledZipcode", true).apply();
                }
            }
            catch (IOException ioexception)
            {
                Ln.w(ioexception, "Could not geocode location during on boarding.", new Object[0]);
                geoUtils.logGeocodeException(ioexception, com/groupon/fragment/OnBoardingMultiStepA1.getSimpleName());
                inputField.setText("");
                inputField.setHint(0x7f0802c5);
            }
        }
_L4:
        if (bundle != null && bundle.containsKey("zip_code") && Strings.isEmpty(inputField.getText()))
        {
            inputField.setText(bundle.getString("zip_code"));
        }
_L2:
        return;
        obj = null;
          goto _L5
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030188, viewgroup, false);
        ButterKnife.bind(this, layoutinflater);
        return layoutinflater;
    }

    public void onDestroyView()
    {
        if (categoriesAnimatorSet != null)
        {
            categoriesAnimatorSet.removeAllListeners();
            categoriesAnimatorSet.cancel();
        }
        super.onDestroyView();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        String s;
        if (inputField != null)
        {
            s = Strings.toString(inputField.getText());
        } else
        {
            s = null;
        }
        if (Strings.notEmpty(s))
        {
            bundle.putString("zip_code", s);
        }
        if (categoriesContainer != null)
        {
            bundle.putInt("categoriesContainerVisibility", categoriesContainer.getVisibility());
        }
    }

    protected void setListeners()
    {
        if (inputField != null)
        {
            inputField.setOnClickListener(new android.view.View.OnClickListener() {

                final OnBoardingMultiStepA1 this$0;

                public void onClick(View view)
                {
                    inputField.setCursorVisible(true);
                }

            
            {
                this$0 = OnBoardingMultiStepA1.this;
                super();
            }
            });
            inputField.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() {

                final OnBoardingMultiStepA1 this$0;

                public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
                {
                    if (i == 6)
                    {
                        validateZipcodeAndContinue();
                    }
                    return false;
                }

            
            {
                this$0 = OnBoardingMultiStepA1.this;
                super();
            }
            });
            inputField.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() {

                final OnBoardingMultiStepA1 this$0;

                public void onFocusChange(View view, boolean flag)
                {
                    if (flag)
                    {
                        imm.showSoftInput(inputField, 0);
                        if (Strings.isEmpty(inputField.getText()))
                        {
                            inputField.setHint("");
                        }
                    }
                }

            
            {
                this$0 = OnBoardingMultiStepA1.this;
                super();
            }
            });
        }
    }

    protected void stopCategoriesAnimation()
    {
        if (categoriesAnimatorSet != null)
        {
            categoriesAnimatorSet.end();
        }
    }



/*
    static boolean access$002(OnBoardingMultiStepA1 onboardingmultistepa1, boolean flag)
    {
        onboardingmultistepa1.animationDisplayed = flag;
        return flag;
    }

*/








}
