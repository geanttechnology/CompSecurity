// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.home;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amazon.now.AmazonActivity;
import com.amazon.now.ChromeStyle;
import com.amazon.now.account.SSO;
import com.amazon.now.cart.CartController;
import com.amazon.now.debug.DebugActivity;
import com.amazon.now.location.LocaleManager;
import com.amazon.now.location.Location;
import com.amazon.now.location.OnboardVerificationHelper;
import com.amazon.now.platform.TaskCallback;
import com.amazon.now.util.AppUtils;
import com.amazon.now.util.WeblabUtil;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.amazon.now.home:
//            ZipCheckActivity, CountryListAdapterItem

public class WelcomeScreen extends AmazonActivity
{

    public static final String INTENT_KEY_CHANGE_LOCATION = "intentKeyChangeLocation";
    public static final String INTENT_KEY_QUERY_PARAMETER = "intentKeyQueryParameters";
    public static final String INTENT_KEY_SYNC_COOKIE = "intentKeySyncCookie";
    private Context mContext;
    private TextWatcher mEditTextWatcher;
    private boolean mGoEnabled;
    private LinearLayout mInputLayout;
    private int mMinZip;
    private String mRegexZipCode;
    private ImageView mZipCheckGo;
    private EditText mZipInput;

    public WelcomeScreen()
    {
        mGoEnabled = false;
        mEditTextWatcher = new TextWatcher() {

            final WelcomeScreen this$0;

            public void afterTextChanged(Editable editable)
            {
            }

            public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            public void onTextChanged(CharSequence charsequence, int i, int j, int k)
            {
                if (charsequence.toString().trim().length() < mMinZip || !charsequence.toString().trim().matches(mRegexZipCode)) goto _L2; else goto _L1
_L1:
                if (!mGoEnabled) goto _L4; else goto _L3
_L3:
                return;
_L4:
                mGoEnabled = true;
                mZipCheckGo.setOnClickListener(new android.view.View.OnClickListener() {

                    final _cls5 this$1;

                    public void onClick(View view)
                    {
                        gotoZipCheck();
                    }

            
            {
                this$1 = _cls5.this;
                super();
            }
                });
                charsequence = AnimationUtils.loadAnimation(mZipCheckGo.getContext(), 0x7f040007);
                mZipCheckGo.setAlpha(1.0F);
                mZipCheckGo.startAnimation(charsequence);
                return;
_L2:
                if (mGoEnabled)
                {
                    mGoEnabled = false;
                    mZipCheckGo.setOnClickListener(null);
                    charsequence = AnimationUtils.loadAnimation(mZipCheckGo.getContext(), 0x7f040008);
                    mZipCheckGo.setAlpha(1.0F);
                    mZipCheckGo.startAnimation(charsequence);
                    return;
                }
                if (true) goto _L3; else goto _L5
_L5:
            }

            
            {
                this$0 = WelcomeScreen.this;
                super();
            }
        };
    }

    private void gotoZipCheck()
    {
        String s = mZipInput.getText().toString().trim();
        if (s.length() >= mMinZip && s.matches(mRegexZipCode))
        {
            Intent intent = new Intent(mContext, com/amazon/now/home/ZipCheckActivity);
            intent.putExtra("intentStyleKey", new ChromeStyle(com.amazon.now.ChromeStyle.ChromeLayout.LOGO_ONLY));
            intent.putExtra("keyZipCode", s);
            intent.putExtra("intentKeyQueryParameters", getIntent().getStringExtra("intentKeyQueryParameters"));
            startActivity(intent);
        }
    }

    private void handleWeblabOverrides()
    {
        Object obj = getIntent().getData();
        if (obj != null && ((Uri) (obj)).getScheme() != null && "primenow".equalsIgnoreCase(((Uri) (obj)).getScheme()) && ((Uri) (obj)).getPath() != null && ((Uri) (obj)).getPath().contains("setExperiment"))
        {
            obj = ((Uri) (obj)).getQueryParameter("experiment");
            if (obj != null)
            {
                WeblabUtil.saveWeblabs(((String) (obj)).replaceAll(",", "|"));
            }
        }
    }

    private void showCountryChooser()
    {
        final List locales = Arrays.asList(LocaleManager.getAvailableLocales());
        final Locale currLocale = LocaleManager.getInstance().getLocale();
        Collections.sort(locales, new Comparator() {

            final WelcomeScreen this$0;
            final Locale val$currLocale;

            public volatile int compare(Object obj, Object obj1)
            {
                return compare((Locale)obj, (Locale)obj1);
            }

            public int compare(Locale locale, Locale locale1)
            {
                if (locale == currLocale)
                {
                    return -1;
                }
                if (locale1 == currLocale)
                {
                    return 1;
                } else
                {
                    return locale.getDisplayCountry().compareTo(locale1.getDisplayCountry());
                }
            }

            
            {
                this$0 = WelcomeScreen.this;
                currLocale = locale;
                super();
            }
        });
        CountryListAdapterItem acountrylistadapteritem[] = new CountryListAdapterItem[locales.size()];
        for (int i = 0; i < locales.size(); i++)
        {
            acountrylistadapteritem[i] = new CountryListAdapterItem(((Locale)locales.get(i)).getDisplayCountry(), Integer.valueOf(LocaleManager.getInstance().getResourceIdForLocale(this, "drawable", (Locale)locales.get(i), "country_flag")));
        }

        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle(0x7f070094);
        builder.setAdapter(new ArrayAdapter(0x1090011, 0x1020014, acountrylistadapteritem, acountrylistadapteritem) {

            final WelcomeScreen this$0;
            final CountryListAdapterItem val$countries[];

            public View getView(int j, View view, ViewGroup viewgroup)
            {
                view = super.getView(j, view, viewgroup);
                ((TextView)view.findViewById(0x1020014)).setCompoundDrawablesWithIntrinsicBounds(0, 0, countries[j].getFlagIcon().intValue(), 0);
                return view;
            }

            
            {
                this$0 = WelcomeScreen.this;
                countries = acountrylistadapteritem1;
                super(final_context, i, j, acountrylistadapteritem);
            }
        }, new android.content.DialogInterface.OnClickListener() {

            final WelcomeScreen this$0;
            final Locale val$currLocale;
            final List val$locales;

            public void onClick(DialogInterface dialoginterface, int j)
            {
                while (j >= locales.size() || locales.get(j) == currLocale) 
                {
                    return;
                }
                Location.resetLocation();
                LocaleManager.getInstance().setLocale((Locale)locales.get(j));
                dialoginterface = new Intent(mContext, com/amazon/now/home/WelcomeScreen);
                dialoginterface.addFlags(0x14008000);
                dialoginterface.putExtra("intentKeyChangeLocation", getIntent().getBooleanExtra("intentKeyChangeLocation", false));
                boolean flag;
                if (SSO.getAccount() != null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                dialoginterface.putExtra("intentKeySyncCookie", flag);
                mContext.startActivity(dialoginterface);
            }

            
            {
                this$0 = WelcomeScreen.this;
                locales = list;
                currLocale = locale;
                super();
            }
        });
        builder.create().show();
    }

    private void showZipcodeInput()
    {
        mInputLayout.setVisibility(0);
    }

    public void onCreate(Bundle bundle)
    {
        boolean flag;
        super.onCreate(bundle);
        mContext = this;
        handleWeblabOverrides();
        mRegexZipCode = getString(0x7f070090);
        mMinZip = getResources().getInteger(0x7f0a0001);
        bundle = LayoutInflater.from(this).inflate(0x7f030076, null);
        mInputLayout = (LinearLayout)bundle.findViewById(0x7f0e0170);
        mZipInput = (EditText)bundle.findViewById(0x7f0e0172);
        mZipCheckGo = (ImageView)mInputLayout.findViewById(0x7f0e0171);
        mZipCheckGo.setAlpha(0.3F);
        flag = getIntent().getBooleanExtra("intentKeyChangeLocation", false);
        if (!flag) goto _L2; else goto _L1
_L1:
        ChromeStyle chromestyle = new ChromeStyle(com.amazon.now.ChromeStyle.ChromeLayout.HEADER);
        chromestyle.setHeader(getString(0x7f070082));
        setRootView(bundle, chromestyle);
_L4:
        mZipInput.setOnTouchListener(new android.view.View.OnTouchListener() {

            final WelcomeScreen this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                if (motionevent.getAction() == 1)
                {
                    int i = AppUtils.getPxFromDp(mContext, (int)mContext.getResources().getDimension(0x7f0b0124));
                    if (motionevent.getX() <= (float)(mZipInput.getCompoundDrawables()[0].getBounds().width() + i))
                    {
                        showCountryChooser();
                        return true;
                    }
                }
                return false;
            }

            
            {
                this$0 = WelcomeScreen.this;
                super();
            }
        });
        mZipInput.addTextChangedListener(mEditTextWatcher);
        mZipInput.setOnKeyListener(new android.view.View.OnKeyListener() {

            final WelcomeScreen this$0;

            public boolean onKey(View view, int i, KeyEvent keyevent)
            {
                if (i == 66 && keyevent.getAction() == 0)
                {
                    gotoZipCheck();
                    return true;
                } else
                {
                    return false;
                }
            }

            
            {
                this$0 = WelcomeScreen.this;
                super();
            }
        });
        if (getIntent().getBooleanExtra("hasRecreated", false))
        {
            showZipcodeInput();
            return;
        }
        break; /* Loop/switch isn't completed */
_L2:
        WeblabUtil.saveWeblabs(null);
        if (AppUtils.isAppDebuggable(this))
        {
            ChromeStyle chromestyle1 = new ChromeStyle(com.amazon.now.ChromeStyle.ChromeLayout.HEADER);
            chromestyle1.setHeader("Debug");
            setRootView(bundle, chromestyle1);
            bundle = findViewById(0x7f0e0037);
            if (bundle != null)
            {
                bundle.setOnClickListener(new android.view.View.OnClickListener() {

                    final WelcomeScreen this$0;

                    public void onClick(View view)
                    {
                        view.getContext().startActivity(new Intent(view.getContext(), com/amazon/now/debug/DebugActivity));
                    }

            
            {
                this$0 = WelcomeScreen.this;
                super();
            }
                });
            }
        } else
        {
            setRootView(bundle, new ChromeStyle(com.amazon.now.ChromeStyle.ChromeLayout.NONE));
        }
        if (true) goto _L4; else goto _L3
_L3:
        getIntent().putExtra("hasRecreated", true);
        if (SSO.getAccount() != null && !flag && Location.isSet())
        {
            OnboardVerificationHelper.verify(this, new TaskCallback() {

                final WelcomeScreen this$0;

                public void failure()
                {
                    showZipcodeInput();
                }

                public void success()
                {
                    AppUtils.goHome(mContext);
                }

            
            {
                this$0 = WelcomeScreen.this;
                super();
            }
            });
            CartController.getInstance().fetchCartCount(null, null);
            return;
        }
        if (flag && getIntent().getBooleanExtra("intentKeySyncCookie", false))
        {
            SSO.syncCookies(false, null);
        }
        showZipcodeInput();
        return;
    }










/*
    static boolean access$702(WelcomeScreen welcomescreen, boolean flag)
    {
        welcomescreen.mGoEnabled = flag;
        return flag;
    }

*/

}
