// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.groupon.service.LoginService;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.ImageUrl;
import com.groupon.util.MarketRateUtil;
import com.groupon.util.VolatileTravelerNameProvider;
import com.groupon.view.UrlImageView;
import com.squareup.picasso.Callback;
import java.util.Calendar;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            GrouponActivity, BookingMetaData

public class TravelerNameActivity extends GrouponActivity
    implements Callback
{

    private static final String FIRSTNAME = "firstname";
    private static final String LASTNAME = "lastname";
    public static final int REQUEST_CODE = 10130;
    BookingMetaData bookingMetaData;
    Button continueButton;
    UrlImageView dealImageView;
    String dealTitle;
    EditText firstNameView;
    ImageUrl imageUrl;
    EditText lastNameView;
    Logger logger;
    LoginService loginService;
    VolatileTravelerNameProvider nameProvider;
    TextView reservationDateText;
    TextView titleView;

    public TravelerNameActivity()
    {
    }

    private void buildImageHeader()
    {
        dealImageView.setCallback(this);
        dealImageView.setImageUrl(imageUrl);
        titleView.setText(dealTitle);
    }

    private void continueToConfirmation()
    {
        if (nameIsValid())
        {
            nameProvider.setFirstName(Strings.toString(firstNameView.getText()));
            nameProvider.setLastName(Strings.toString(lastNameView.getText()));
            setResult(-1);
            logger.logClick("", "traveler_info_continue_click", "", Logger.NULL_NST_FIELD);
            finish();
        }
    }

    public static Intent instantiate(Context context, String s, ImageUrl imageurl, BookingMetaData bookingmetadata)
    {
        return (new Intent(context, com/groupon/activity/TravelerNameActivity)).putExtra("dealTitle", s).putExtra("imageUrl", imageurl).putExtra("getaways_booking", bookingmetadata);
    }

    private boolean nameIsValid()
    {
        boolean flag = true;
        if (Strings.isEmpty(firstNameView.getText()))
        {
            firstNameView.setError(getString(0x7f080149));
            flag = false;
        }
        if (Strings.isEmpty(lastNameView.getText()))
        {
            lastNameView.setError(getString(0x7f08014a));
            flag = false;
        }
        return flag;
    }

    private void setContinueListeners()
    {
        lastNameView.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() {

            final TravelerNameActivity this$0;

            public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
            {
                if (i == 6)
                {
                    continueToConfirmation();
                    return true;
                } else
                {
                    return false;
                }
            }

            
            {
                this$0 = TravelerNameActivity.this;
                super();
            }
        });
        continueButton.setOnClickListener(new android.view.View.OnClickListener() {

            final TravelerNameActivity this$0;

            public void onClick(View view)
            {
                continueToConfirmation();
            }

            
            {
                this$0 = TravelerNameActivity.this;
                super();
            }
        });
    }

    protected void initActionBar(Bundle bundle)
    {
        super.initActionBar(bundle);
        setToolbarTitle(getString(0x7f0803eb));
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030219);
        buildImageHeader();
        setContinueListeners();
        if (bundle == null) goto _L2; else goto _L1
_L1:
        String s;
        String s1 = bundle.getString("firstname");
        s = bundle.getString("lastname");
        bundle = s1;
_L4:
        firstNameView.setText(bundle);
        lastNameView.setText(s);
        bundle = new StringBuilder(getString(0x7f0803df));
        int i = bundle.length();
        s = MarketRateUtil.getReservationDatesString(this, bookingMetaData.getStartDate().getTime(), bookingMetaData.getEndDate().getTime());
        bundle.append(" ").append(s);
        bundle = new SpannableString(bundle);
        bundle.setSpan(new ForegroundColorSpan(getResources().getColor(0x7f0e00d5)), 0, i, 33);
        reservationDateText.setText(bundle);
        return;
_L2:
        String s2 = nameProvider.getFirstName();
        String s3 = nameProvider.getLastName();
        bundle = s2;
        s = s3;
        if (Strings.isEmpty(s2))
        {
            bundle = s2;
            s = s3;
            if (Strings.isEmpty(s3))
            {
                bundle = loginService.getFirstName();
                s = loginService.getLastName();
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onError(ImageView imageview)
    {
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putString("firstname", Strings.toString(firstNameView.getText()));
        bundle.putString("lastname", Strings.toString(lastNameView.getText()));
    }

    public void onSuccess(final ImageView view)
    {
        final Bitmap bitmap = ((BitmapDrawable)view.getDrawable()).getBitmap();
        if (bitmap == null)
        {
            return;
        } else
        {
            view.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

                final TravelerNameActivity this$0;
                final Bitmap val$bitmap;
                final ImageView val$view;

                public void onGlobalLayout()
                {
                    Object obj = new DisplayMetrics();
                    getWindowManager().getDefaultDisplay().getMetrics(((DisplayMetrics) (obj)));
                    int i = ((DisplayMetrics) (obj)).widthPixels;
                    int j = (int)Math.floor((bitmap.getHeight() * i) / bitmap.getWidth());
                    Ln.d("PAGER: bm = %s x %s, new = %s x %s", new Object[] {
                        Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf(i), Integer.valueOf(j)
                    });
                    obj = view.getLayoutParams();
                    obj.width = i;
                    obj.height = j;
                    view.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
                    view.requestLayout();
                    view.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }

            
            {
                this$0 = TravelerNameActivity.this;
                bitmap = bitmap1;
                view = imageview;
                super();
            }
            });
            return;
        }
    }

}
