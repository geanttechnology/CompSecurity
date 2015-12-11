// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.ui_stuff;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.os.Vibrator;
import android.text.Html;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.ebay.common.Preferences;
import com.ebay.common.UserCache;
import com.ebay.common.content.EbaySimpleNetLoader;
import com.ebay.common.model.ItemTransaction;
import com.ebay.common.model.UserDetail;
import com.ebay.common.view.util.EbayCountryManager;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.dcs.DcsHelper;
import com.ebay.mobile.util.ThemeUtil;
import com.ebay.mobile.viewitem.ItemViewActivity;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.ImageRequest;
import com.ebay.nautilus.domain.net.ImageResponse;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.util.NetworkUtil;
import com.ebay.nautilus.shell.app.FwContext;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util
{
    private static class CountDownStatStruct
    {

        public final boolean isCountdownItemEnding;
        public final boolean isRefreshUponEnding;
        public Date source;
        public String useToFormatDuringCountdown;
        public WeakReference view;

        public CountDownStatStruct(Date date, TextView textview, String s, boolean flag, boolean flag1)
        {
            source = date;
            view = new WeakReference(textview);
            useToFormatDuringCountdown = s;
            isCountdownItemEnding = flag;
            isRefreshUponEnding = flag1;
            if (flag && flag1)
            {
                throw new IllegalArgumentException("mutually exclusive");
            } else
            {
                return;
            }
        }
    }

    public static class DetectHtml
    {

        public static final String htmlEntity = "&[a-zA-Z][a-zA-Z0-9]+;";
        public static final Pattern htmlPattern = Pattern.compile("(\\<\\w+((\\s+\\w+(\\s*\\=\\s*(?:\".*?\"|'.*?'|[^'\"\\>\\s]+))?)+\\s*|\\s*)\\>.*\\</\\w+\\>)|(\\<\\w+((\\s+\\w+(\\s*\\=\\s*(?:\".*?\"|'.*?'|[^'\"\\>\\s]+))?)+\\s*|\\s*)/\\>)|(&[a-zA-Z][a-zA-Z0-9]+;)|(\\<[a-zA-Z]+\\>)", 32);
        public static final String simple = "\\<[a-zA-Z]+\\>";
        public static final String tagEnd = "\\</\\w+\\>";
        public static final String tagSelfClosing = "\\<\\w+((\\s+\\w+(\\s*\\=\\s*(?:\".*?\"|'.*?'|[^'\"\\>\\s]+))?)+\\s*|\\s*)/\\>";
        public static final String tagStart = "\\<\\w+((\\s+\\w+(\\s*\\=\\s*(?:\".*?\"|'.*?'|[^'\"\\>\\s]+))?)+\\s*|\\s*)\\>";

        public static boolean isHtml(String s)
        {
            boolean flag = false;
            if (s != null)
            {
                flag = htmlPattern.matcher(s).find();
            }
            return flag;
        }


        public DetectHtml()
        {
        }
    }

    public static interface SetImageCallback
    {

        public abstract void onSetImage(Bitmap bitmap);
    }


    public static final int COUNT_TRUNCATION_LIMIT = 99;
    private static CountDownTimer countDownStatTimer;
    private static List countDownStats;
    private static final Map m_after_sales_strings_buyer = new HashMap() {

            
            {
                put("CancelClosedForCommitment", Integer.valueOf(0x7f07088e));
                put("CancelClosedNoRefund", Integer.valueOf(0x7f07088e));
                put("CancelClosedUnknownRefund", Integer.valueOf(0x7f07088e));
                put("CancelClosedWithRefund", Integer.valueOf(0x7f07088f));
                put("CancelComplete", Integer.valueOf(0x7f070890));
                put("CancelFailed", Integer.valueOf(0x7f070891));
                put("CancelPending", Integer.valueOf(0x7f070892));
                put("CancelRejected", Integer.valueOf(0x7f070893));
                put("CancelRequested", Integer.valueOf(0x7f070894));
                put("ReturnClosedEscalated", Integer.valueOf(0x7f07088d));
                put("ReturnClosedNoRefund", Integer.valueOf(0x7f070895));
                put("ReturnClosedWithRefund", Integer.valueOf(0x7f070896));
                put("ReturnDelivered", Integer.valueOf(0x7f070897));
                put("ReturnEscalated", Integer.valueOf(0x7f07088d));
                put("ReturnEscalatedClosedNoRefund", Integer.valueOf(0x7f070887));
                put("ReturnEscalatedClosedWithRefund", Integer.valueOf(0x7f070898));
                put("ReturnEscalatedPendingBuyer", Integer.valueOf(0x7f070899));
                put("ReturnEscalatedPendingCS", Integer.valueOf(0x7f070889));
                put("ReturnEscalatedPendingSeller", Integer.valueOf(0x7f07089a));
                put("ReturnOpen", Integer.valueOf(0x7f07089b));
                put("ReturnRequestClosedNoRefund", Integer.valueOf(0x7f070895));
                put("ReturnRequestClosedWithRefund", Integer.valueOf(0x7f070896));
                put("ReturnRequestPending", Integer.valueOf(0x7f07089c));
                put("ReturnRequestPendingApproval", Integer.valueOf(0x7f07089c));
                put("ReturnRequestRejected", Integer.valueOf(0x7f07089d));
                put("ReturnShipped", Integer.valueOf(0x7f07089e));
                put("TrackInquiryClosedNoRefund", Integer.valueOf(0x7f07089f));
                put("TrackInquiryClosedWithRefund", Integer.valueOf(0x7f0708a0));
                put("TrackInquiryEscalatedClosedNoRefund", Integer.valueOf(0x7f0708a1));
                put("TrackInquiryEscalatedClosedWithRefund", Integer.valueOf(0x7f0708a0));
                put("TrackInquiryEscalatedPendingBuyer", Integer.valueOf(0x7f0708a2));
                put("TrackInquiryEscalatedPendingCS", Integer.valueOf(0x7f0708a3));
                put("TrackInquiryEscalatedPendingSeller", Integer.valueOf(0x7f0708a4));
                put("TrackInquiryPendingBuyerResponse", Integer.valueOf(0x7f0708a5));
                put("TrackInquiryPendingSellerResponse", Integer.valueOf(0x7f0708a6));
            }
    };
    private static final Map m_after_sales_strings_seller = new HashMap() {

            
            {
                put("CancelClosedForCommitment", Integer.valueOf(0x7f0708a7));
                put("CancelClosedNoRefund", Integer.valueOf(0x7f0708a7));
                put("CancelClosedUnknownRefund", Integer.valueOf(0x7f0708a7));
                put("CancelClosedWithRefund", Integer.valueOf(0x7f0708a7));
                put("CancelComplete", Integer.valueOf(0x7f0708a7));
                put("CancelFailed", Integer.valueOf(0x7f0708a8));
                put("CancelPending", Integer.valueOf(0x7f0708a9));
                put("CancelRejected", Integer.valueOf(0x7f0708aa));
                put("CancelRequested", Integer.valueOf(0x7f0708ab));
                put("ReturnClosedEscalated", Integer.valueOf(0x7f070889));
                put("ReturnClosedNoRefund", Integer.valueOf(0x7f0708ac));
                put("ReturnClosedWithRefund", Integer.valueOf(0x7f0708ad));
                put("ReturnDelivered", Integer.valueOf(0x7f0708ae));
                put("ReturnEscalated", Integer.valueOf(0x7f070889));
                put("ReturnEscalatedClosedNoRefund", Integer.valueOf(0x7f070887));
                put("ReturnEscalatedClosedWithRefund", Integer.valueOf(0x7f0708af));
                put("ReturnEscalatedPendingBuyer", Integer.valueOf(0x7f0708b0));
                put("ReturnEscalatedPendingCS", Integer.valueOf(0x7f0708b1));
                put("ReturnEscalatedPendingSeller", Integer.valueOf(0x7f0708b2));
                put("ReturnOpen", Integer.valueOf(0x7f0708b3));
                put("ReturnRequestClosedNoRefund", Integer.valueOf(0x7f0708ac));
                put("ReturnRequestClosedWithRefund", Integer.valueOf(0x7f0708ad));
                put("ReturnRequestPending", Integer.valueOf(0x7f0708b4));
                put("ReturnRequestPendingApproval", Integer.valueOf(0x7f0708b5));
                put("ReturnRequestRejected", Integer.valueOf(0x7f0708b6));
                put("ReturnShipped", Integer.valueOf(0x7f0708b7));
                put("TrackInquiryClosedNoRefund", Integer.valueOf(0x7f0708b8));
                put("TrackInquiryClosedWithRefund", Integer.valueOf(0x7f0708b9));
                put("TrackInquiryEscalatedClosedNoRefund", Integer.valueOf(0x7f070887));
                put("TrackInquiryEscalatedClosedWithRefund", Integer.valueOf(0x7f0708ba));
                put("TrackInquiryEscalatedPendingBuyer", Integer.valueOf(0x7f0708bb));
                put("TrackInquiryEscalatedPendingCS", Integer.valueOf(0x7f070889));
                put("TrackInquiryEscalatedPendingSeller", Integer.valueOf(0x7f0708bc));
                put("TrackInquiryPendingBuyerResponse", Integer.valueOf(0x7f0708bd));
                put("TrackInquiryPendingSellerResponse", Integer.valueOf(0x7f0708be));
            }
    };
    private static int m_base_color = -1;
    private static final Map m_payment_names = new HashMap() {

            
            {
                put("AmEx", Integer.valueOf(0x7f07002f));
                put("CashInPerson", Integer.valueOf(0x7f070032));
                put("CashOnPickup", Integer.valueOf(0x7f070033));
                put("CCAccepted", Integer.valueOf(0x7f070034));
                put("CreditCard", Integer.valueOf(0x7f070034));
                put("COD", Integer.valueOf(0x7f070030));
                put("CODPrePayDelivery", Integer.valueOf(0x7f070031));
                put("Discover", Integer.valueOf(0x7f070035));
                put("ELV", Integer.valueOf(0x7f070036));
                put("Escrow", Integer.valueOf(0x7f070037));
                put("LoanCheck", Integer.valueOf(0x7f070039));
                put("MOCC", Integer.valueOf(0x7f07003a));
                put("MoneyXferAccepted", Integer.valueOf(0x7f07003b));
                put("MoneyXferAcceptedInCheckout", Integer.valueOf(0x7f07003c));
                put("None", Integer.valueOf(0x7f07003e));
                put("Other", Integer.valueOf(0x7f07003f));
                put("OtherOnlinePayments", Integer.valueOf(0x7f070040));
                put("PaisaPayAccepted", Integer.valueOf(0x7f070041));
                put("PaisaPayEscrowEMI", Integer.valueOf(0x7f070042));
                put("PersonalCheck", Integer.valueOf(0x7f070043));
                put("PostalTransfer", Integer.valueOf(0x7f070044));
                put("PrePayDelivery", Integer.valueOf(0x7f070045));
                put("PaymentSeeDescription", Integer.valueOf(0x7f070046));
                put("VisaMC", Integer.valueOf(0x7f070047));
                put("Moneybookers", Integer.valueOf(0x7f07003d));
                put("PayUponInvoice", Integer.valueOf(0x7f070c53));
            }
    };

    public Util()
    {
    }

    public static boolean IsTabOrReturnOrKnob(int i, KeyEvent keyevent)
    {
        return keyevent.getAction() == 0 && (i == 61 || i == 66 || i == 23);
    }

    public static SpannableString RenderString(String s, int i)
    {
        return RenderString(s, i, 0);
    }

    public static SpannableString RenderString(String s, int i, int j)
    {
        SpannableString spannablestring = new SpannableString(s);
        spannablestring.setSpan(new StyleSpan(j), 0, s.length(), 0);
        spannablestring.setSpan(new ForegroundColorSpan(i), 0, s.length(), 33);
        return spannablestring;
    }

    public static void SetRatingStar(ImageView imageview, String s)
    {
        int i = getRatingStarResId(s);
        if (i == 0)
        {
            imageview.setVisibility(4);
            return;
        } else
        {
            imageview.setVisibility(0);
            imageview.setImageResource(i);
            return;
        }
    }

    public static void addCountDownToTextView(Date date, TextView textview, String s, boolean flag)
    {
        if (countDownStatTimer != null)
        {
            countDownStatTimer.cancel();
            countDownStatTimer = null;
        }
        if (countDownStats == null)
        {
            countDownStats = new ArrayList();
        }
        boolean flag1;
        if (!flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        date = new CountDownStatStruct(date, textview, s, flag, flag1);
        countDownStats.add(date);
        countDownStatTimer = (new CountDownTimer(1000L, 1000L) {

            public void onFinish()
            {
                if (Util.countDownStats != null)
                {
                    if (ItemViewActivity.logTag.isLoggable)
                    {
                        ItemViewActivity.logTag.log((new StringBuilder()).append("counDownStats onFinish beginning size=").append(Util.countDownStats.size()).toString());
                    }
                    Iterator iterator = Util.countDownStats.iterator();
                    do
                    {
                        if (!iterator.hasNext())
                        {
                            break;
                        }
                        CountDownStatStruct countdownstatstruct = (CountDownStatStruct)iterator.next();
                        if ((TextView)countdownstatstruct.view.get() == null)
                        {
                            iterator.remove();
                        } else
                        if (Util.updateCountDownStat(countdownstatstruct, this))
                        {
                            if (ItemViewActivity.logTag.isLoggable)
                            {
                                ItemViewActivity.logTag.log((new StringBuilder()).append("counDownStats removing").append(Util.countDownStats.size()).toString());
                            }
                            iterator.remove();
                            if (ItemViewActivity.logTag.isLoggable)
                            {
                                ItemViewActivity.logTag.log((new StringBuilder()).append("counDownStats removed").append(Util.countDownStats.size()).toString());
                            }
                        }
                    } while (true);
                    if (!Util.countDownStats.isEmpty())
                    {
                        if (ItemViewActivity.logTag.isLoggable)
                        {
                            ItemViewActivity.logTag.log((new StringBuilder()).append("restarting counDownStats size=").append(Util.countDownStats.size()).toString());
                        }
                        start();
                    } else
                    if (ItemViewActivity.logTag.isLoggable)
                    {
                        ItemViewActivity.logTag.log((new StringBuilder()).append("NOT restarting counDownStats size=").append(Util.countDownStats.size()).toString());
                        return;
                    }
                }
            }

            public void onTick(long l)
            {
            }

        }).start();
        if (updateCountDownStat(date, countDownStatTimer))
        {
            countDownStats.remove(date);
        }
    }

    public static void buildTextViewWithHyperLink(TextView textview, String s, String s1, String s2)
    {
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        textview.setText(linkifyText(s, s1, s2));
    }

    public static boolean checkForIAFTokenError(EbaySimpleNetLoader ebaysimplenetloader)
    {
        if (ebaysimplenetloader != null && ebaysimplenetloader.getResponse() != null)
        {
            return checkForIAFTokenError(ebaysimplenetloader.getResponse());
        } else
        {
            return false;
        }
    }

    public static boolean checkForIAFTokenError(EbayResponse ebayresponse)
    {
        if (ebayresponse != null && ebayresponse.getResultStatus().hasMessage())
        {
            ebayresponse = ebayresponse.getResultStatus().getMessages().iterator();
            do
            {
                if (!ebayresponse.hasNext())
                {
                    break;
                }
                switch (((com.ebay.nautilus.kernel.content.ResultStatus.Message)ebayresponse.next()).getId())
                {
                case 21916984: 
                case 21917053: 
                    return true;
                }
            } while (true);
        }
        return false;
    }

    public static void composeSupportEmail(Activity activity)
    {
        String s1 = NautilusKernel.getAppVersionName(activity);
        String s = "";
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder();
        SpannableStringBuilder spannablestringbuilder1 = new SpannableStringBuilder();
        Object obj = MyApp.getPrefs();
        Object obj1 = ((Preferences) (obj)).getAuthentication();
        obj = ((Preferences) (obj)).getCurrentCountry();
        if (obj1 != null)
        {
            s = ((Authentication) (obj1)).user;
        }
        obj1 = new Intent("android.intent.action.SEND");
        ((Intent) (obj1)).setType("message/rfc822");
        ((Intent) (obj1)).putExtra("android.intent.extra.EMAIL", new String[] {
            "mobilehelp@ebay.com"
        });
        spannablestringbuilder.append("eBay Mobile ").append(s1);
        spannablestringbuilder.append(" Android ").append(android.os.Build.VERSION.RELEASE);
        UserDetail userdetail = UserCache.getUserDetails();
        if (userdetail != null && userdetail.registrationAddress != null && !TextUtils.isEmpty(userdetail.registrationAddress.country))
        {
            spannablestringbuilder.append(" ").append(userdetail.registrationAddress.country);
        }
        ((Intent) (obj1)).putExtra("android.intent.extra.SUBJECT", spannablestringbuilder.toString());
        spannablestringbuilder1.append("Device: ").append(Build.MODEL).append("\n");
        spannablestringbuilder1.append("OS: ").append(android.os.Build.VERSION.RELEASE).append("\n");
        spannablestringbuilder1.append("App version: ").append(s1).append("\n");
        spannablestringbuilder1.append("UserID: ").append(s).append("\n");
        spannablestringbuilder1.append("eBay site: ").append(EbayCountryManager.getCountryWithLanguageName(activity.getResources(), ((EbayCountry) (obj))));
        spannablestringbuilder1.append(" [").append(((EbayCountry) (obj)).site.id).append("]\n");
        spannablestringbuilder1.append("\n\n");
        ((Intent) (obj1)).putExtra("android.intent.extra.TEXT", spannablestringbuilder1);
        activity.startActivity(Intent.createChooser(((Intent) (obj1)), activity.getString(0x7f0703a8)));
    }

    public static String convertHour(Context context, String s)
    {
        StringBuffer stringbuffer;
        String as[];
        int i;
        boolean flag;
        if (TextUtils.isEmpty(s))
        {
            return s;
        }
        stringbuffer = new StringBuffer();
        as = s.split(":");
        flag = false;
        i = ((flag) ? 1 : 0);
        if (as.length < 2) goto _L2; else goto _L1
_L1:
        String s1 = as[1];
        if ("24".equals(android.provider.Settings.System.getString(context.getContentResolver(), "time_12_24"))) goto _L4; else goto _L3
_L3:
        int k = Integer.parseInt(as[0]);
        i = 0;
        if (k == 12)
        {
            i = 1;
        }
          goto _L5
_L12:
        stringbuffer.append(i);
        if (!"00".equals(s1))
        {
            stringbuffer.append(":").append(s1);
        }
        int j;
        if (j == 0) goto _L7; else goto _L6
_L6:
        stringbuffer.append("pm");
_L8:
        i = 1;
_L2:
        if (i == 0 || stringbuffer.length() == 0)
        {
            stringbuffer.append(s);
        }
        return stringbuffer.toString();
_L10:
        j = i;
        i = k;
        if (k > 12)
        {
            i = k - 12;
            j = 1;
        }
        continue; /* Loop/switch isn't completed */
_L7:
        stringbuffer.append("am");
          goto _L8
        context;
        Log.w("Util", "convertHour exception handled", context);
        i = ((flag) ? 1 : 0);
          goto _L2
_L4:
        stringbuffer.append(as[0]).append(":").append(s1);
          goto _L8
_L5:
        if (k != 0 && k != 24) goto _L10; else goto _L9
_L9:
        byte byte0 = 12;
        j = i;
        i = byte0;
        if (true) goto _L12; else goto _L11
_L11:
    }

    public static String countAsString(Context context, int i)
    {
        return countAsString(context, i);
    }

    public static String countAsString(Context context, long l)
    {
        if (l > 99L && context != null)
        {
            return context.getString(0x7f070b84);
        } else
        {
            return String.valueOf(l);
        }
    }

    public static View createViewItemStat(LayoutInflater layoutinflater, ViewGroup viewgroup, String s, CharSequence charsequence)
    {
        return createViewItemStat(layoutinflater, viewgroup, s, charsequence, null, null);
    }

    public static View createViewItemStat(LayoutInflater layoutinflater, ViewGroup viewgroup, String s, CharSequence charsequence, android.view.View.OnClickListener onclicklistener)
    {
        return createViewItemStat(layoutinflater, viewgroup, s, charsequence, null, false, onclicklistener);
    }

    public static View createViewItemStat(LayoutInflater layoutinflater, ViewGroup viewgroup, String s, CharSequence charsequence, String s1, android.view.View.OnClickListener onclicklistener)
    {
        return createViewItemStat(layoutinflater, viewgroup, s, charsequence, s1, false, onclicklistener);
    }

    public static View createViewItemStat(LayoutInflater layoutinflater, ViewGroup viewgroup, String s, CharSequence charsequence, String s1, boolean flag, android.view.View.OnClickListener onclicklistener)
    {
        if (TextUtils.isEmpty(s1))
        {
            layoutinflater = layoutinflater.inflate(0x7f03029a, viewgroup, false);
        } else
        {
            layoutinflater = layoutinflater.inflate(0x7f0302a1, viewgroup, false);
        }
        if (s != null)
        {
            viewgroup = (TextView)layoutinflater.findViewById(0x7f1008f3);
            viewgroup.setSingleLine(flag);
            viewgroup.setText(s);
        }
        if (charsequence != null)
        {
            viewgroup = (TextView)layoutinflater.findViewById(0x7f1008cc);
            viewgroup.setText(charsequence);
            if (onclicklistener != null)
            {
                viewgroup.setOnClickListener(onclicklistener);
            }
        }
        if (!TextUtils.isEmpty(s1))
        {
            viewgroup = (TextView)layoutinflater.findViewById(0x7f1008f7);
            viewgroup.setText(s1);
            viewgroup.setVisibility(0);
        }
        return layoutinflater;
    }

    public static View createViewItemStatCollapsableList(Context context, LayoutInflater layoutinflater, ViewGroup viewgroup, String s, List list)
    {
        context = layoutinflater.inflate(0x7f0302a2, viewgroup, false);
        if (s != null)
        {
            ((TextView)context.findViewById(0x7f1008f3)).setText(s);
        }
        if (list != null && !list.isEmpty())
        {
            layoutinflater = (LinearLayout)context.findViewById(0x7f1008cc);
            layoutinflater.addView((View)list.get(0));
            if (list.size() > 1)
            {
                viewgroup = (LinearLayout)context.findViewById(0x7f1008f9);
                for (int i = 1; i < list.size(); i++)
                {
                    viewgroup.addView((View)list.get(i));
                }

                s = context.findViewById(0x7f100229);
                list = (TextView)context.findViewById(0x7f1008fa);
                TextView textview = (TextView)context.findViewById(0x7f1008fb);
                s.setVisibility(0);
                s.setOnClickListener(new android.view.View.OnClickListener(s, layoutinflater, viewgroup, list, textview) {

                    final View val$expandoControl;
                    final TextView val$showLessText;
                    final TextView val$showMoreText;
                    final LinearLayout val$statValue;
                    final LinearLayout val$statValues;

                    public void onClick(View view)
                    {
                        view = ((View) (expandoControl.getTag()));
                        View view1;
                        boolean flag;
                        if (view != null)
                        {
                            flag = ((String)view).equals("1");
                        } else
                        {
                            flag = false;
                        }
                        if (flag)
                        {
                            statValue.setVisibility(0);
                            statValues.setVisibility(8);
                            showMoreText.setVisibility(0);
                            showLessText.setVisibility(8);
                        } else
                        {
                            statValue.setVisibility(8);
                            statValues.setVisibility(0);
                            showMoreText.setVisibility(8);
                            showLessText.setVisibility(0);
                        }
                        view1 = expandoControl;
                        if (flag)
                        {
                            view = "0";
                        } else
                        {
                            view = "1";
                        }
                        view1.setTag(view);
                    }

            
            {
                expandoControl = view;
                statValue = linearlayout;
                statValues = linearlayout1;
                showMoreText = textview;
                showLessText = textview1;
                super();
            }
                });
            }
        }
        return context;
    }

    public static View createViewItemStatCopiable(Activity activity, LayoutInflater layoutinflater, ViewGroup viewgroup, String s, String s1)
    {
        layoutinflater = createViewItemStat(layoutinflater, viewgroup, s, s1, null);
        viewgroup = (TextView)layoutinflater.findViewById(0x7f1008cc);
        viewgroup.setTextColor(ThemeUtil.resolveThemeColorStateList(activity.getResources(), activity.getTheme(), 0x1010212));
        viewgroup.setOnClickListener(new android.view.View.OnClickListener(activity, viewgroup) {

            final Activity val$activity;
            final TextView val$copiableView;

            public void onClick(View view)
            {
                ((ClipboardManager)activity.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, copiableView.getText()));
                Toast.makeText(activity, activity.getString(0x7f070269), 0).show();
                Util.vibratePhone(activity);
            }

            
            {
                activity = activity1;
                copiableView = textview;
                super();
            }
        });
        return layoutinflater;
    }

    public static View createViewItemStatCountDown(Context context, LayoutInflater layoutinflater, ViewGroup viewgroup, String s, Date date, boolean flag)
    {
        layoutinflater = layoutinflater.inflate(0x7f0302a1, viewgroup, false);
        if (s != null)
        {
            ((TextView)layoutinflater.findViewById(0x7f1008f3)).setText(s);
        }
        if (date != null)
        {
            addCountDownToTextView(date, (TextView)layoutinflater.findViewById(0x7f1008cc), null, true);
            if (flag)
            {
                viewgroup = (TextView)layoutinflater.findViewById(0x7f1008f7);
                viewgroup.setText(getFormattedDateTimeStringFromDate(context, date));
                viewgroup.setVisibility(0);
            }
        }
        return layoutinflater;
    }

    public static View createViewItemStatCurrency(LayoutInflater layoutinflater, ViewGroup viewgroup, String s, String s1, String s2)
    {
        return createViewItemStatCurrency(layoutinflater, viewgroup, s, s1, s2, null);
    }

    public static View createViewItemStatCurrency(LayoutInflater layoutinflater, ViewGroup viewgroup, String s, String s1, String s2, String s3)
    {
        layoutinflater = layoutinflater.inflate(0x7f0302a1, viewgroup, false);
        if (s != null)
        {
            ((TextView)layoutinflater.findViewById(0x7f1008f3)).setText(s);
        }
        if (s1 != null)
        {
            ((TextView)layoutinflater.findViewById(0x7f1008cc)).setText(s1);
        }
        if (s2 != null)
        {
            viewgroup = (TextView)layoutinflater.findViewById(0x7f1008f7);
            viewgroup.setText(s2);
            viewgroup.setVisibility(0);
        }
        if (s3 != null)
        {
            viewgroup = (TextView)layoutinflater.findViewById(0x7f1008f8);
            viewgroup.setText(s3);
            viewgroup.setVisibility(0);
        }
        return layoutinflater;
    }

    public static View createViewItemStatFormattedDate(Context context, LayoutInflater layoutinflater, ViewGroup viewgroup, String s, Date date)
    {
        return createViewItemStatFormattedDate(context, layoutinflater, viewgroup, s, date, false);
    }

    public static View createViewItemStatFormattedDate(Context context, LayoutInflater layoutinflater, ViewGroup viewgroup, String s, Date date, boolean flag)
    {
        String s1 = null;
        if (date != null)
        {
            if (flag)
            {
                s1 = (String)DateFormat.format(getDeliveryDateFormat(context, false), date);
            } else
            {
                s1 = getFormattedDateTimeStringFromDate(context, date);
            }
        }
        return createViewItemStat(layoutinflater, viewgroup, s, s1);
    }

    public static View createViewItemStatFullWidth(LayoutInflater layoutinflater, ViewGroup viewgroup, String s)
    {
        layoutinflater = layoutinflater.inflate(0x7f03029b, viewgroup, false);
        if (s != null)
        {
            ((TextView)layoutinflater.findViewById(0x7f1008cc)).setText(s);
        }
        return layoutinflater;
    }

    public static View createViewItemStatFullWidth(LayoutInflater layoutinflater, ViewGroup viewgroup, List list)
    {
        layoutinflater = (LinearLayout)layoutinflater.inflate(0x7f03029c, viewgroup, false);
        for (viewgroup = list.iterator(); viewgroup.hasNext(); layoutinflater.addView((View)viewgroup.next())) { }
        return layoutinflater;
    }

    public static View createViewItemStatGsp(LayoutInflater layoutinflater, ViewGroup viewgroup, String s, String s1)
    {
        layoutinflater = layoutinflater.inflate(0x7f03029d, viewgroup, false);
        if (s != null)
        {
            ((TextView)layoutinflater.findViewById(0x7f1008f3)).setText(s);
        }
        if (s1 != null)
        {
            ((TextView)layoutinflater.findViewById(0x7f1008cc)).setText(s1);
        }
        return layoutinflater;
    }

    public static View createViewItemStatHyperlink(LayoutInflater layoutinflater, ViewGroup viewgroup, String s, Spanned spanned)
    {
        layoutinflater = createViewItemStat(layoutinflater, viewgroup, s, spanned, null);
        ((TextView)layoutinflater.findViewById(0x7f1008cc)).setMovementMethod(LinkMovementMethod.getInstance());
        return layoutinflater;
    }

    public static View createViewItemStatLeftImage(LayoutInflater layoutinflater, ViewGroup viewgroup, int i, String s)
    {
        layoutinflater = layoutinflater.inflate(0x7f03029e, viewgroup, false);
        if (i > 0)
        {
            ((ImageView)layoutinflater.findViewById(0x7f1008f4)).setImageResource(i);
        }
        if (s != null)
        {
            ((TextView)layoutinflater.findViewById(0x7f1008cc)).setText(s);
        }
        return layoutinflater;
    }

    public static View createViewItemStatList(LayoutInflater layoutinflater, ViewGroup viewgroup, String s, List list)
    {
        return createViewItemStatList(layoutinflater, viewgroup, s, list, null);
    }

    public static View createViewItemStatList(LayoutInflater layoutinflater, ViewGroup viewgroup, String s, List list, android.view.View.OnClickListener onclicklistener)
    {
        layoutinflater = layoutinflater.inflate(0x7f0302a3, viewgroup, false);
        if (s != null)
        {
            ((TextView)layoutinflater.findViewById(0x7f1008f3)).setText(s);
        }
        if (list != null && !list.isEmpty())
        {
            viewgroup = (LinearLayout)layoutinflater.findViewById(0x7f1008cc);
            for (s = list.iterator(); s.hasNext(); viewgroup.addView((View)s.next())) { }
        }
        if (onclicklistener != null)
        {
            layoutinflater.setOnClickListener(onclicklistener);
        }
        return layoutinflater;
    }

    public static View createViewItemStatPhone(Activity activity, LayoutInflater layoutinflater, ViewGroup viewgroup, String s, String s1)
    {
        layoutinflater = createViewItemStat(layoutinflater, viewgroup, s, s1, null);
        viewgroup = (TextView)layoutinflater.findViewById(0x7f1008cc);
        viewgroup.setTextColor(ThemeUtil.resolveThemeColorStateList(activity.getResources(), activity.getTheme(), 0x1010212));
        viewgroup.setOnClickListener(new android.view.View.OnClickListener(viewgroup, activity) {

            final Activity val$activity;
            final TextView val$phoneNumberView;

            public void onClick(View view)
            {
                view = new Intent("android.intent.action.DIAL");
                view.setData(Uri.parse((new StringBuilder()).append("tel:").append(phoneNumberView.getText()).toString()));
                activity.startActivity(view);
            }

            
            {
                phoneNumberView = textview;
                activity = activity1;
                super();
            }
        });
        return layoutinflater;
    }

    public static View createViewItemStatPrice(LayoutInflater layoutinflater, ViewGroup viewgroup, String s, String s1)
    {
        return createViewItemStatPrice(layoutinflater, viewgroup, s, s1, null, false);
    }

    public static View createViewItemStatPrice(LayoutInflater layoutinflater, ViewGroup viewgroup, String s, String s1, String s2, boolean flag)
    {
        viewgroup = layoutinflater.inflate(0x7f0302a4, viewgroup, false);
        if (s != null)
        {
            ((TextView)viewgroup.findViewById(0x7f1001b8)).setText(s);
        }
        if (s1 != null)
        {
            if (flag)
            {
                layoutinflater = (TextView)viewgroup.findViewById(0x7f1008fc);
            } else
            {
                layoutinflater = (TextView)viewgroup.findViewById(0x7f100373);
            }
            layoutinflater.setText(s1);
            layoutinflater.setVisibility(0);
        }
        if (s2 != null)
        {
            layoutinflater = (TextView)viewgroup.findViewById(0x7f1008fd);
            layoutinflater.setText(s2);
            layoutinflater.setVisibility(0);
        }
        return viewgroup;
    }

    public static View createViewItemStatRecentBid(LayoutInflater layoutinflater, ViewGroup viewgroup, String s, CharSequence charsequence, String s1)
    {
        layoutinflater = layoutinflater.inflate(0x7f0302a0, viewgroup, false);
        if (s != null)
        {
            ((TextView)layoutinflater.findViewById(0x7f1008f3)).setText(s);
        }
        if (charsequence != null)
        {
            ((TextView)layoutinflater.findViewById(0x7f1008cc)).setText(charsequence);
        }
        if (!TextUtils.isEmpty(s1))
        {
            viewgroup = (TextView)layoutinflater.findViewById(0x7f1008f6);
            viewgroup.setText(s1);
            viewgroup.setVisibility(0);
        }
        return layoutinflater;
    }

    public static View createViewItemStatTertiary(Activity activity, LayoutInflater layoutinflater, ViewGroup viewgroup, String s, CharSequence charsequence)
    {
        layoutinflater = createViewItemStat(layoutinflater, viewgroup, s, charsequence);
        ((TextView)layoutinflater.findViewById(0x7f1008cc)).setTextColor(ThemeUtil.resolveThemeColorStateList(activity.getResources(), activity.getTheme(), 0x1010212));
        return layoutinflater;
    }

    public static View createViewItemStatTruncated(LayoutInflater layoutinflater, ViewGroup viewgroup, String s, String s1)
    {
        layoutinflater = createViewItemStat(layoutinflater, viewgroup, s, s1, null);
        viewgroup = (TextView)layoutinflater.findViewById(0x7f1008cc);
        viewgroup.setMaxLines(3);
        viewgroup.setEllipsize(android.text.TextUtils.TruncateAt.END);
        return layoutinflater;
    }

    public static boolean currentLanguageBadForSearch()
    {
        Object obj = MyApp.getPrefs().getCurrentCountry();
        String s;
        if (obj != null)
        {
            obj = ((EbayCountry) (obj)).getSiteLanguageCode();
        } else
        {
            obj = "";
        }
        s = Locale.getDefault().getLanguage();
        return ("ru".equals(s) || "pt".equals(s)) && !s.equals(obj);
    }

    public static final String dateFormatForLocale(Locale locale, String s)
    {
        String s1;
label0:
        {
            if (!locale.equals(Locale.GERMAN))
            {
                s1 = s;
                if (!locale.equals(Locale.GERMANY))
                {
                    break label0;
                }
            }
            int i = s.lastIndexOf('d');
            s1 = (new StringBuilder()).append(s.substring(0, i + 1)).append(".").append(s.substring(i + 1)).toString();
        }
        return s1;
    }

    public static boolean forceEditTextFocus(View view)
    {
        boolean flag1 = false;
        boolean flag = false;
        if (view instanceof ViewGroup)
        {
            view = (ViewGroup)view;
            int i = 0;
            do
            {
                flag1 = flag;
                if (flag)
                {
                    break;
                }
                flag1 = flag;
                if (i >= view.getChildCount())
                {
                    break;
                }
                View view1 = view.getChildAt(i);
                if (view1 instanceof ViewGroup)
                {
                    flag = forceEditTextFocus(view1);
                } else
                if (view1 instanceof EditText)
                {
                    synthesizeTouch(view1);
                    flag = true;
                }
                i++;
            } while (true);
        } else
        if (view instanceof EditText)
        {
            synthesizeTouch(view);
            flag1 = true;
        }
        return flag1;
    }

    public static String formatDayHour(Context context, long l)
    {
        StringBuilder stringbuilder = new StringBuilder();
        long l1 = l / 1000L / 60L / 60L;
        l = l1 / 24L;
        l1 %= 24L;
        if (l > 0L)
        {
            stringbuilder.append(context.getString(0x7f07004a, new Object[] {
                Long.valueOf(l), Long.valueOf(l1)
            }));
        } else
        if (l1 > 0L)
        {
            stringbuilder.append(context.getString(0x7f07004e, new Object[] {
                Long.valueOf(l1)
            }));
        } else
        {
            return context.getString(0x7f0705db);
        }
        return stringbuilder.toString();
    }

    public static String formatDayHourMinSec(Context context, long l)
    {
        return formatDayHourMinSec(context, l, false);
    }

    public static String formatDayHourMinSec(Context context, long l, boolean flag)
    {
        StringBuilder stringbuilder = new StringBuilder();
        long l2 = l / 1000L;
        if (l2 > 0L)
        {
            long l3 = l2 / 60L;
            long l1 = l3 / 60L;
            l = l1 / 24L;
            l2 %= 60L;
            l3 %= 60L;
            l1 %= 24L;
            if (l > 0L)
            {
                stringbuilder.append(context.getString(0x7f07004a, new Object[] {
                    Long.valueOf(l), Long.valueOf(l1)
                }));
            } else
            if (l1 > 0L)
            {
                stringbuilder.append(context.getString(0x7f07004d, new Object[] {
                    Long.valueOf(l1), Long.valueOf(l3)
                }));
            } else
            if (l3 > 0L)
            {
                stringbuilder.append(context.getString(0x7f070050, new Object[] {
                    Long.valueOf(l3), Long.valueOf(l2)
                }));
            } else
            {
                stringbuilder.append(context.getString(0x7f070053, new Object[] {
                    Long.valueOf(l2)
                }));
            }
        } else
        if (flag)
        {
            stringbuilder.append(context.getString(0x7f07004e, new Object[] {
                Integer.valueOf(0)
            }));
        } else
        {
            stringbuilder.append(context.getString(0x7f0703c3));
        }
        return stringbuilder.toString();
    }

    public static String formatHourMinSec(Context context, long l)
    {
        l /= 1000L;
        if (l > 0L)
        {
            long l1 = (((l / 60L) * 60L) % 60L) * 60L;
            long l2 = (l / 60L) % 60L;
            if (l1 > 0L)
            {
                return context.getString(0x7f07004e, new Object[] {
                    Long.valueOf(l1)
                });
            }
            if (l2 > 0L)
            {
                return context.getString(0x7f070051, new Object[] {
                    Long.valueOf(l2)
                });
            } else
            {
                return context.getString(0x7f070053, new Object[] {
                    Long.valueOf(l % 60L)
                });
            }
        } else
        {
            return context.getString(0x7f0703c3);
        }
    }

    public static String formattedTimeAndDate(String s, Date date)
    {
        return String.format(s, new Object[] {
            java.text.DateFormat.getTimeInstance(3).format(date), java.text.DateFormat.getDateInstance(2).format(date)
        });
    }

    public static int getAfterSalesHeaderResId(ItemTransaction itemtransaction, boolean flag, int i, String s)
    {
        Map map;
        int j;
        if (flag)
        {
            map = m_after_sales_strings_seller;
        } else
        {
            map = m_after_sales_strings_buyer;
        }
        j = i;
        if (s != null)
        {
            itemtransaction = (Integer)map.get(s);
            if (itemtransaction != null)
            {
                return itemtransaction.intValue();
            } else
            {
                return -1;
            }
        }
        i = j;
        if (itemtransaction == null) goto _L2; else goto _L1
_L1:
        if (!map.containsKey(itemtransaction.returnStatus)) goto _L4; else goto _L3
_L3:
        i = ((Integer)map.get(itemtransaction.returnStatus)).intValue();
_L2:
        return i;
_L4:
        if (map.containsKey(itemtransaction.inquiryStatus))
        {
            i = ((Integer)map.get(itemtransaction.inquiryStatus)).intValue();
        } else
        {
            i = j;
            if (map.containsKey(itemtransaction.cancelStatus))
            {
                i = ((Integer)map.get(itemtransaction.cancelStatus)).intValue();
            }
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public static List getCollapsibleStatValueTextViews(Context context, String s, int i)
    {
        ArrayList arraylist = new ArrayList();
        if (!TextUtils.isEmpty(s))
        {
            TextView textview = new TextView(context);
            boolean flag;
            if (s.length() > i)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                textview.setText((new StringBuilder()).append(s.substring(0, i - 1)).append(context.getString(0x7f0703a7)).toString());
            } else
            {
                textview.setText(s);
            }
            arraylist.add(textview);
            if (flag)
            {
                context = new TextView(context);
                context.setText(s);
                arraylist.add(context);
            }
        }
        return arraylist;
    }

    public static String getCommonSearchHint(Context context)
    {
        EbayCountry ebaycountry = MyApp.getPrefs().getCurrentCountry();
        String s1 = context.getString(0x7f070250);
        String s = s1;
        if (ebaycountry != null)
        {
            s = s1;
            if (currentLanguageBadForSearch())
            {
                s = context.getString(0x7f070251, new Object[] {
                    ebaycountry.getSiteLocale().getDisplayLanguage()
                });
            }
        }
        return s;
    }

    public static String getDayHoursString(Context context, com.ebay.common.model.inventory.LocationDetails.Day day)
    {
        if (day == null || day.intervals.size() == 0)
        {
            return null;
        }
        StringBuffer stringbuffer = new StringBuffer();
        day = day.intervals.iterator();
        do
        {
            if (!day.hasNext())
            {
                break;
            }
            com.ebay.common.model.inventory.LocationDetails.Interval interval = (com.ebay.common.model.inventory.LocationDetails.Interval)day.next();
            if (!TextUtils.isEmpty(interval.open) && !TextUtils.isEmpty(interval.close))
            {
                if (stringbuffer.length() > 0)
                {
                    stringbuffer.append(",");
                }
                stringbuffer.append(convertHour(context, interval.open)).append("-").append(convertHour(context, interval.close));
            }
        } while (true);
        return stringbuffer.toString();
    }

    public static String getDayOfWeekFromNumber(Context context, int i)
    {
        return (new DateFormatSymbols(Locale.getDefault())).getShortWeekdays()[i];
    }

    public static final String getDeliveryDateFormat(Context context, boolean flag)
    {
        return getDeliveryDateFormat(context, flag, false);
    }

    public static final String getDeliveryDateFormat(Context context, boolean flag, boolean flag1)
    {
        return getDeliveryDateFormat(context, flag, flag1, null);
    }

    public static final String getDeliveryDateFormat(Context context, boolean flag, boolean flag1, Boolean boolean1)
    {
        boolean flag2;
        if (boolean1 != null)
        {
            flag2 = boolean1.booleanValue();
        } else
        {
            flag2 = isDayFirst(context);
        }
        if (flag)
        {
            flag = DateFormat.is24HourFormat(context);
            if (flag2)
            {
                if (flag)
                {
                    context = "d MMM kk:mm";
                } else
                {
                    context = "dd MMM hh:mma";
                }
            } else
            if (flag)
            {
                context = "MMM d kk:mm";
            } else
            {
                context = "MMM dd hh:mma";
            }
        } else
        if (flag1)
        {
            if (flag2)
            {
                context = "E, d MMM";
            } else
            {
                context = "E, MMM d";
            }
        } else
        if (flag2)
        {
            context = "d MMM";
        } else
        {
            context = "MMM d";
        }
        return dateFormatForLocale(Locale.getDefault(), context);
    }

    public static final String getDeliveryDateString(Context context, Date date, Date date1)
    {
        return getDeliveryDateString(context, date, date1, false);
    }

    public static final String getDeliveryDateString(Context context, Date date, Date date1, boolean flag)
    {
        return getDeliveryDateString(context, date, date1, flag, false);
    }

    public static final String getDeliveryDateString(Context context, Date date, Date date1, boolean flag, boolean flag1)
    {
        return getDeliveryDateString(context, date, date1, flag, flag1, null);
    }

    public static final String getDeliveryDateString(Context context, Date date, Date date1, boolean flag, boolean flag1, Boolean boolean1)
    {
        Object obj = context.getResources();
        String s = getDeliveryDateFormat(context, false, flag1, boolean1);
        if (date1.getTime() - date.getTime() < 0x5265c00L)
        {
            if (flag)
            {
                return DateFormat.format(s, date).toString();
            } else
            {
                return String.format(((Resources) (obj)).getString(0x7f0703da), new Object[] {
                    DateFormat.format(s, date)
                });
            }
        }
        boolean flag2;
        boolean flag3;
        if (boolean1 != null)
        {
            flag3 = boolean1.booleanValue();
        } else
        {
            flag3 = isDayFirst(context);
        }
        if (date.getMonth() == date1.getMonth() && !flag3 && !flag1)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (flag3)
        {
            context = "d MMM";
        } else
        {
            context = "MMM d";
        }
        boolean1 = "d";
        if (flag)
        {
            obj = ((Resources) (obj)).getString(0x7f070426);
            if (!flag2)
            {
                context = s;
            }
            context = DateFormat.format(context, date);
            if (!flag2)
            {
                boolean1 = s;
            }
            return String.format(((String) (obj)), new Object[] {
                context, DateFormat.format(boolean1, date1)
            });
        }
        obj = ((Resources) (obj)).getString(0x7f0703d9);
        if (!flag2)
        {
            context = s;
        }
        context = DateFormat.format(context, date);
        if (!flag2)
        {
            boolean1 = s;
        }
        return String.format(((String) (obj)), new Object[] {
            context, DateFormat.format(boolean1, date1)
        });
    }

    public static final String getDeliveryDateString(Context context, Date date, boolean flag)
    {
        if (date == null)
        {
            return "";
        } else
        {
            return DateFormat.format(getDeliveryDateFormat(context, false, flag, Boolean.valueOf(isDayFirst(context))), date).toString();
        }
    }

    public static final String[] getDeliveryDateStrings(Context context, Date date, Date date1)
    {
        return getDeliveryDateStrings(context, date, date1, true, Boolean.valueOf(false));
    }

    public static final String[] getDeliveryDateStrings(Context context, Date date, Date date1, boolean flag, Boolean boolean1)
    {
        context.getResources();
        context = getDeliveryDateFormat(context, false, flag, boolean1);
        if (date1 == null || date1.getTime() - date.getTime() < 0x5265c00L)
        {
            return (new String[] {
                DateFormat.format(context, date).toString()
            });
        } else
        {
            return (new String[] {
                DateFormat.format(context, date).toString(), DateFormat.format(context, date1).toString()
            });
        }
    }

    private static String getDisplayableDays(Context context, List list)
    {
        StringBuffer stringbuffer = new StringBuffer();
        int i;
        for (list = list.iterator(); list.hasNext(); stringbuffer.append(getDayOfWeekFromNumber(context, i)))
        {
            i = ((Integer)list.next()).intValue();
            if (stringbuffer.length() > 0)
            {
                stringbuffer.append(",");
            }
        }

        return stringbuffer.toString();
    }

    private static String getDisplayableDaysRange(Context context, List list)
    {
        StringBuffer stringbuffer = new StringBuffer();
        if (isSequencial(list))
        {
            stringbuffer.append(getDayOfWeekFromNumber(context, ((Integer)list.get(0)).intValue()));
            if (list.size() > 1)
            {
                stringbuffer.append("-");
                stringbuffer.append(getDayOfWeekFromNumber(context, ((Integer)list.get(list.size() - 1)).intValue()));
            }
        } else
        {
            stringbuffer.append(getDisplayableDays(context, list));
        }
        return stringbuffer.toString();
    }

    public static String getDisplayableHours(Context context, com.ebay.common.model.inventory.LocationDetails.Hours hours)
    {
        return getDisplayableHours(context, hours, new int[] {
            1, 2, 3, 4, 5, 6, 7
        }, true);
    }

    public static String getDisplayableHours(Context context, com.ebay.common.model.inventory.LocationDetails.Hours hours, int ai[])
    {
        return getDisplayableHours(context, hours, ai, false);
    }

    public static String getDisplayableHours(Context context, com.ebay.common.model.inventory.LocationDetails.Hours hours, int ai[], boolean flag)
    {
        StringBuffer stringbuffer = new StringBuffer();
        if (hours != null && hours.days != null)
        {
            SparseArray sparsearray = new SparseArray();
            com.ebay.common.model.inventory.LocationDetails.Day day;
            for (hours = hours.days.iterator(); hours.hasNext(); sparsearray.put(day.dayOfWeek, getDayHoursString(context, day)))
            {
                day = (com.ebay.common.model.inventory.LocationDetails.Day)hours.next();
            }

            hours = getMatchingDays(sparsearray, ai, flag);
            for (ai = hours.keySet().iterator(); ai.hasNext();)
            {
                String s = (String)ai.next();
                StringBuffer stringbuffer1 = new StringBuffer();
                List list = (List)hours.get(s);
                if (!flag)
                {
                    stringbuffer1.append(getDisplayableDays(context, list));
                    if (stringbuffer.length() > 0)
                    {
                        stringbuffer.append("\n");
                    }
                    stringbuffer.append(stringbuffer1).append(" ").append(s);
                } else
                {
                    stringbuffer1.append(getDisplayableDaysRange(context, list));
                    if (stringbuffer.length() > 0)
                    {
                        stringbuffer.append("\n");
                    }
                    stringbuffer.append(stringbuffer1).append(": ").append(s);
                }
            }

        }
        return stringbuffer.toString();
    }

    public static final String getEbayNowDeliveryTimeString(Context context, Date date, Date date1)
    {
        Resources resources = context.getResources();
        java.text.DateFormat dateformat = DateFormat.getTimeFormat(context);
        GregorianCalendar gregoriancalendar = new GregorianCalendar();
        gregoriancalendar.setTime(date);
        GregorianCalendar gregoriancalendar1 = new GregorianCalendar();
        gregoriancalendar1.setTime(date1);
        Calendar calendar = Calendar.getInstance();
        Calendar calendar1 = Calendar.getInstance();
        calendar1.add(5, 1);
        boolean flag = false;
        if (gregoriancalendar1.get(1) == calendar.get(1) && gregoriancalendar1.get(6) == calendar.get(6))
        {
            context = context.getString(0x7f070b75);
        } else
        if (gregoriancalendar1.get(1) == calendar1.get(1) && gregoriancalendar1.get(6) == calendar1.get(6))
        {
            context = context.getString(0x7f070b76);
        } else
        {
            context = DateFormat.format(getDeliveryDateFormat(context, false), date).toString();
            flag = true;
        }
        if (date.equals(date1))
        {
            return resources.getString(0x7f070381, new Object[] {
                dateformat.format(gregoriancalendar1.getTime()), context
            });
        }
        date = resources.getString(0x7f070382, new Object[] {
            dateformat.format(gregoriancalendar.getTime()), dateformat.format(gregoriancalendar1.getTime())
        });
        if (flag)
        {
            return resources.getString(0x7f070381, new Object[] {
                context, date
            });
        } else
        {
            return resources.getString(0x7f070381, new Object[] {
                date, context
            });
        }
    }

    public static final String getEstimatedPickupDateString(Context context, Date date, boolean flag)
    {
        Resources resources = context.getResources();
        context = getDeliveryDateFormat(context, false);
        if (flag)
        {
            return String.format(resources.getString(0x7f0703d7), new Object[] {
                DateFormat.format(context, date)
            });
        } else
        {
            return String.format(resources.getString(0x7f0703db), new Object[] {
                DateFormat.format(context, date)
            });
        }
    }

    public static String getFastAndFreeText()
    {
        switch (MyApp.getPrefs().getCurrentCountry().getSiteId())
        {
        default:
            return null;

        case 0: // '\0'
        case 15: // '\017'
            return "FAST 'N FREE";

        case 3: // '\003'
            return "FAST & FREE";

        case 77: // 'M'
            return "Kostenlos & Schnell";
        }
    }

    public static final String getFeedbackPercentString(Context context, double d)
    {
        if (d == 0.0D)
        {
            return context.getString(0x7f07065b);
        }
        context = context.getString(0x7f0707a6);
        int i = (int)Math.floor(d);
        if (d - (double)i == 0.0D)
        {
            return String.format(context, new Object[] {
                String.valueOf(i)
            });
        } else
        {
            return String.format(context, new Object[] {
                String.format("%2.1f", new Object[] {
                    Double.valueOf(d)
                })
            });
        }
    }

    public static final String getFeedbackPercentString(Context context, String s)
    {
        double d = 0.0D;
        double d1 = Double.parseDouble(s);
        d = d1;
_L2:
        return getFeedbackPercentString(context, d);
        s;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static String getFormattedDateTimeStringFromDate(Context context, Date date)
    {
        java.text.DateFormat dateformat = DateFormat.getMediumDateFormat(context);
        java.text.DateFormat dateformat1 = DateFormat.getTimeFormat(context);
        return context.getString(0x7f070048, new Object[] {
            dateformat.format(date), dateformat1.format(date)
        });
    }

    public static String getFormattedTimeStringFromDate(Context context, Date date)
    {
        return DateFormat.getTimeFormat(context).format(date);
    }

    public static final int getHoursFromNow(Date date)
    {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date);
        double d = (double)((calendar1.getTimeInMillis() - calendar.getTimeInMillis()) / 1000L) / 3600D;
        if (d > 0.0D)
        {
            return (int)Math.round(d);
        } else
        {
            return 1;
        }
    }

    public static Map getMatchingDays(SparseArray sparsearray)
    {
        return getMatchingDays(sparsearray, new int[] {
            1, 2, 3, 4, 5, 6, 7
        }, true);
    }

    public static Map getMatchingDays(SparseArray sparsearray, int ai[], boolean flag)
    {
        HashMap hashmap = new HashMap();
        if (ai != null && ai.length > 0)
        {
            ArrayList arraylist = new ArrayList();
            int k = ai.length;
            int i = 0;
            while (i < k) 
            {
                int j = ai[i];
                if (!arraylist.contains(Integer.valueOf(j)))
                {
                    String s = (String)sparsearray.get(j);
                    if (!TextUtils.isEmpty(s))
                    {
                        ArrayList arraylist1 = new ArrayList();
                        arraylist1.add(Integer.valueOf(j));
                        if (flag)
                        {
                            for (j++; j <= 7; j++)
                            {
                                String s1 = (String)sparsearray.get(j);
                                if (!TextUtils.isEmpty(s1) && s.equals(s1))
                                {
                                    arraylist1.add(Integer.valueOf(j));
                                    arraylist.add(Integer.valueOf(j));
                                }
                            }

                        }
                        hashmap.put(s, arraylist1);
                    }
                }
                i++;
            }
        }
        return hashmap;
    }

    public static String getPaymentMethodsAsLocalizedString(List list)
    {
        return getPaymentMethodsAsLocalizedString(list, true);
    }

    public static String getPaymentMethodsAsLocalizedString(List list, boolean flag)
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (list != null)
        {
            HashMap hashmap = new HashMap();
            if (list.contains("MoneyXferAccepted") && list.contains("MoneyXferAcceptedInCheckout"))
            {
                list.remove("MoneyXferAccepted");
            }
            boolean flag1 = MyApp.getDeviceConfiguration().isAlternativePaymentMethodsAvailable();
            int i = 0;
            do
            {
                if (i >= list.size())
                {
                    break;
                }
                String s = (String)list.get(i);
                if ((!s.equals("MoneyXferAcceptedInCheckout") || flag1) && (!s.equals("CashOnPickup") || flag1))
                {
                    String s1 = localizePaymentMethod((String)list.get(i), flag);
                    if (s1 != null && s1.trim().length() > 0 && hashmap.get(s1) == null)
                    {
                        if (i > 0)
                        {
                            stringbuilder.append(", ");
                        }
                        stringbuilder.append(s1);
                        hashmap.put(s1, Boolean.valueOf(true));
                    }
                }
                i++;
            } while (true);
        }
        return stringbuilder.toString();
    }

    public static int getRatingStarResId(String s)
    {
        if (s != null)
        {
            if (s.compareToIgnoreCase("blue") == 0)
            {
                return 0x7f0202aa;
            }
            if (s.compareToIgnoreCase("purple") == 0)
            {
                return 0x7f0202ae;
            }
            if (s.compareToIgnoreCase("purpleshooting") == 0)
            {
                return 0x7f0202ad;
            }
            if (s.compareToIgnoreCase("red") == 0)
            {
                return 0x7f0202b0;
            }
            if (s.compareToIgnoreCase("redshooting") == 0)
            {
                return 0x7f0202af;
            }
            if (s.compareToIgnoreCase("green") == 0)
            {
                return 0x7f0202ac;
            }
            if (s.compareToIgnoreCase("greenshooting") == 0)
            {
                return 0x7f0202ab;
            }
            if (s.compareToIgnoreCase("turquoise") == 0)
            {
                return 0x7f0202b3;
            }
            if (s.compareToIgnoreCase("turquoiseshooting") == 0)
            {
                return 0x7f0202b2;
            }
            if (s.compareToIgnoreCase("yellow") == 0)
            {
                return 0x7f0202b5;
            }
            if (s.compareToIgnoreCase("yellowshooting") == 0)
            {
                return 0x7f0202b4;
            }
            if (s.compareToIgnoreCase("silvershooting") == 0)
            {
                return 0x7f0202b1;
            }
        }
        return 0;
    }

    public static int getResIdForEulaBanner(boolean flag)
    {
        return !flag ? 0x7f070098 : 0x7f070097;
    }

    public static Date getZeroTimeDate(Date date)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTime();
    }

    public static boolean hasNetwork()
    {
        return NetworkUtil.hasConnectedNetwork(MyApp.getApp());
    }

    public static void hideSoftInput(Context context, View view)
    {
        ((InputMethodManager)context.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static boolean isAlternatePaymentMethodSupported(List list)
    {
        while (list != null && (list.contains("MoneyXferAcceptedInCheckout") || list.contains("MoneyXferAccepted") || list.contains("CashOnPickup"))) 
        {
            return true;
        }
        return false;
    }

    public static boolean isDayFirst(Context context)
    {
        int i;
        int j;
        try
        {
            context = new String(DateFormat.getDateFormatOrder(context));
            i = context.indexOf('d');
            j = context.indexOf('M');
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.w("Util", "isDayFirst date format", context);
            return true;
        }
        return i < j;
    }

    public static boolean isIntentHandlerAvailable(Context context, Intent intent)
    {
        if (intent == null || context == null)
        {
            throw new IllegalArgumentException("context and intent are required");
        }
        return intent.resolveActivity(context.getPackageManager()) != null;
    }

    public static boolean isPaisaPayPaymentMethodAvailable(List list)
    {
        for (list = list.iterator(); list.hasNext();)
        {
            String s = (String)list.next();
            if ("PaisaPayEscrow".equals(s) || "PaisaPayEscrowEMI".equals(s) || "COD".equals(s))
            {
                return true;
            }
        }

        return false;
    }

    private static boolean isSequencial(List list)
    {
        if (list == null)
        {
            return false;
        }
        if (list.size() == 1)
        {
            return true;
        }
        int i = -1;
        for (list = list.iterator(); list.hasNext();)
        {
            int j = ((Integer)list.next()).intValue();
            if (i == -1)
            {
                i = j;
            } else
            {
                if (i + 1 != j)
                {
                    return false;
                }
                i = j;
            }
        }

        return true;
    }

    public static Spanned linkifyText(String s, String s1, String s2)
    {
        return Html.fromHtml(String.format(s, new Object[] {
            (new StringBuilder()).append("<a href='").append(s1).append("'>").append(s2).append("</a>").toString()
        }));
    }

    private static String localizePaymentMethod(String s, boolean flag)
    {
label0:
        {
label1:
            {
                String s1 = s;
                if (m_payment_names.containsKey(s))
                {
                    if (!MyApp.getPrefs().getCurrentSite().equals(EbaySite.IN))
                    {
                        break label0;
                    }
                    if (!"MOCC".equals(s))
                    {
                        break label1;
                    }
                    s1 = MyApp.getApp().getResources().getString(0x7f070038);
                }
                return s1;
            }
            if ("PersonalCheck".equals(s))
            {
                return MyApp.getApp().getResources().getString(0x7f0707a4);
            }
        }
        if (!flag && "MoneyXferAcceptedInCheckout".equals(s))
        {
            return MyApp.getApp().getResources().getString(((Integer)m_payment_names.get("MoneyXferAccepted")).intValue());
        } else
        {
            return MyApp.getApp().getResources().getString(((Integer)m_payment_names.get(s)).intValue());
        }
    }

    public static String makeCommaDelimitedString(List list)
    {
        if (list != null && !list.isEmpty())
        {
            return TextUtils.join(", ", list);
        } else
        {
            return "";
        }
    }

    public static void resetAppStatus(Activity activity)
    {
        resetAppStatus(activity, activity.getResources().getString(0x7f070264));
    }

    public static void resetAppStatus(Activity activity, String s)
    {
        setAppStatusInternal(activity, s, m_base_color);
    }

    public static void setAppStatus(Activity activity, String s)
    {
        if (m_base_color == -1)
        {
            m_base_color = activity.getResources().getColor(0x106000b);
        }
        setAppStatusInternal(activity, s, m_base_color);
    }

    private static void setAppStatusInternal(Activity activity, String s, int i)
    {
        activity.setTitle(s);
        activity.setTitleColor(i);
    }

    public static View setFilterTouchesWhenObscured(View view)
    {
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT > 19)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view.setFilterTouchesWhenObscured(flag);
        return view;
    }

    public static boolean setImage(SetImageCallback setimagecallback, String s, int i, Activity activity)
    {
        if (TextUtils.isEmpty(s))
        {
            return false;
        } else
        {
            i = (int)((float)i * activity.getResources().getDisplayMetrics().density);
            (new AsyncTask(s, ((FwContext)activity).getEbayContext(), i, setimagecallback) {

                final SetImageCallback val$callback;
                final EbayContext val$ebayContext;
                final int val$maxSize;
                final String val$url;

                protected transient Bitmap doInBackground(Void avoid[])
                {
                    try
                    {
                        avoid = new ImageRequest(new URL(url), true);
                        avoid = ((ImageResponse)com.ebay.nautilus.kernel.net.Connector.Legacy.sendRequest(ebayContext, avoid)).getSizedImage(maxSize);
                    }
                    // Misplaced declaration of an exception variable
                    catch (Void avoid[])
                    {
                        return null;
                    }
                    // Misplaced declaration of an exception variable
                    catch (Void avoid[])
                    {
                        return null;
                    }
                    // Misplaced declaration of an exception variable
                    catch (Void avoid[])
                    {
                        return null;
                    }
                    return avoid;
                }

                protected volatile Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

                protected void onPostExecute(Bitmap bitmap)
                {
                    super.onPostExecute(bitmap);
                    callback.onSetImage(bitmap);
                }

                protected volatile void onPostExecute(Object obj)
                {
                    onPostExecute((Bitmap)obj);
                }

            
            {
                url = s;
                ebayContext = ebaycontext;
                maxSize = i;
                callback = setimagecallback;
                super();
            }
            }).execute(new Void[0]);
            return true;
        }
    }

    public static void showSoftInput(Context context, View view)
    {
        hideSoftInput(context, view);
        ((InputMethodManager)context.getSystemService("input_method")).toggleSoftInput(0, 0);
    }

    private static void synthesizeTouch(View view)
    {
        if (view == null)
        {
            return;
        } else
        {
            int ai[] = new int[2];
            ai[0] = view.getLeft();
            ai[1] = view.getTop();
            view.getLocationOnScreen(ai);
            int i = ai[0] + view.getWidth() / 2;
            int j = ai[1] + view.getHeight() / 2;
            long l = SystemClock.uptimeMillis();
            MotionEvent motionevent = MotionEvent.obtain(l, 39L + l, 0, i, j, 0);
            view.dispatchTouchEvent(motionevent);
            motionevent.recycle();
            motionevent = MotionEvent.obtain(40L + l, 80L + l, 1, i, j, 0);
            view.dispatchTouchEvent(motionevent);
            motionevent.recycle();
            return;
        }
    }

    private static boolean updateCountDownStat(CountDownStatStruct countdownstatstruct, CountDownTimer countdowntimer)
    {
        boolean flag1 = false;
        TextView textview = (TextView)countdownstatstruct.view.get();
        Context context = textview.getContext();
        long l1 = countdownstatstruct.source.getTime() - EbayResponse.currentHostTime();
        String s1 = formatDayHourMinSec(context, l1, false);
        int i = context.getResources().getColor(0x7f0d00dd);
        boolean flag;
        boolean flag2;
        if (l1 <= 0L || context.getString(0x7f0703c3).equals(s1) && !countdownstatstruct.isCountdownItemEnding)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            i = context.getResources().getColor(0x7f0d00dd);
        } else
        if (l1 <= 0x36ee80L)
        {
            i = context.getResources().getColor(0x7f0d00f0);
        }
        if (!flag && countdownstatstruct.useToFormatDuringCountdown != null)
        {
            Object obj = String.format(countdownstatstruct.useToFormatDuringCountdown, new Object[] {
                s1
            });
            int l = ((String) (obj)).indexOf("<b>");
            int k = ((String) (obj)).indexOf("</b>");
            int j = k;
            String s = ((String) (obj));
            if (l > 0)
            {
                j = k;
                s = ((String) (obj));
                if (k > l)
                {
                    s = ((String) (obj)).replace("<b>", "").replace("</b>", "");
                    j = k - 3;
                }
            }
            obj = new SpannableStringBuilder(s);
            k = s.indexOf(s1);
            if (k >= 0)
            {
                ((SpannableStringBuilder) (obj)).setSpan(new ForegroundColorSpan(i), k, s1.length() + k, 33);
            }
            if (l > 0 && j > l)
            {
                ((SpannableStringBuilder) (obj)).setSpan(new StyleSpan(1), l, j, 33);
            }
            textview.setText(((CharSequence) (obj)), android.widget.TextView.BufferType.SPANNABLE);
            textview.setContentDescription(Html.fromHtml(((SpannableStringBuilder) (obj)).toString()).toString());
        } else
        if (flag && countdownstatstruct.isRefreshUponEnding)
        {
            if (context instanceof com.ebay.mobile.viewitem.fragments.ViewItemBaseFragment.ActivityRefreshListener)
            {
                ((com.ebay.mobile.viewitem.fragments.ViewItemBaseFragment.ActivityRefreshListener)context).reloadItemFromNetwork(null);
            }
            countdowntimer.cancel();
            flag1 = true;
        } else
        {
            textview.setText(s1);
            textview.setContentDescription(s1);
            textview.setTextColor(i);
        }
        flag2 = flag1;
        if (flag)
        {
            flag2 = flag1;
            if (countdownstatstruct.isCountdownItemEnding)
            {
                if (DeviceConfiguration.getAsync().get(DcsBoolean.VI_featureNewBidFlow) && (context instanceof com.ebay.mobile.viewitem.fragments.ViewItemBaseFragment.ItemEndedListener))
                {
                    ((com.ebay.mobile.viewitem.fragments.ViewItemBaseFragment.ItemEndedListener)context).onItemEnded();
                }
                countdowntimer.cancel();
                flag2 = true;
            }
        }
        return flag2;
    }

    public static void vibratePhone(Activity activity)
    {
        vibratePhone(activity, 750);
    }

    public static void vibratePhone(Activity activity, int i)
    {
        activity = (Vibrator)activity.getSystemService("vibrator");
        if (activity != null)
        {
            activity.vibrate(i);
        }
    }



}
