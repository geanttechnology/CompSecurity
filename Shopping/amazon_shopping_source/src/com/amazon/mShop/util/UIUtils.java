// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.os.Vibrator;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewAnimator;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.AmazonAlertDialog;
import com.amazon.mShop.AmazonBrandedWebView;
import com.amazon.mShop.error.AmazonErrorBox;
import com.amazon.mShop.error.AmazonErrorInfo;
import com.amazon.mShop.net.ErrorExceptionMetricsObserver;
import com.amazon.mShop.net.NetInfo;
import com.amazon.mShop.platform.AppLocale;
import com.amazon.mShop.platform.Platform;
import com.amazon.rio.j2me.client.services.ApplicationException;
import com.amazon.rio.j2me.client.services.mShop.HyperText;
import com.amazon.rio.j2me.client.services.mShop.Notification;
import com.amazon.rio.j2me.client.services.mShop.TextAttributes;
import com.amazon.rio.j2me.client.trans.HttpException;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import org.apache.http.conn.ConnectionPoolTimeoutException;

// Referenced classes of package com.amazon.mShop.util:
//            Util, ConfigUtils

public class UIUtils
{
    public static final class CharacterColor extends Enum
    {

        private static final CharacterColor $VALUES[];
        public static final CharacterColor BLACK;
        public static final CharacterColor DARK_GRAY;
        public static final CharacterColor RED;

        public static CharacterColor valueOf(String s)
        {
            return (CharacterColor)Enum.valueOf(com/amazon/mShop/util/UIUtils$CharacterColor, s);
        }

        public static CharacterColor[] values()
        {
            return (CharacterColor[])$VALUES.clone();
        }

        static 
        {
            RED = new CharacterColor("RED", 0);
            DARK_GRAY = new CharacterColor("DARK_GRAY", 1);
            BLACK = new CharacterColor("BLACK", 2);
            $VALUES = (new CharacterColor[] {
                RED, DARK_GRAY, BLACK
            });
        }

        private CharacterColor(String s, int i)
        {
            super(s, i);
        }
    }

    private static class WebViewURLSpan extends URLSpan
    {

        private final AmazonActivity amazonActivity;
        private final String title;

        public void onClick(View view)
        {
            amazonActivity.pushView(new AmazonBrandedWebView(amazonActivity, getURL(), title));
        }

        public WebViewURLSpan(AmazonActivity amazonactivity, String s, String s1)
        {
            super(s);
            amazonActivity = amazonactivity;
            title = s1;
        }
    }

    public static interface WebViewURLSpanFactory
    {

        public abstract URLSpan getURLSpan(String s, String s1);
    }


    public static final int CART_ICON_RES_ID_FOR_COUNT[];
    public static final int CART_ICON_RES_ID_FOR_COUNT_PLUS;
    private static Map UNSUPPORTED_CHARACTERS;
    private static long sLastNetworkExceptionAlertTime = 0L;
    private static volatile boolean sShowingNetFailDialog;

    public UIUtils()
    {
    }

    public static void addEmbeddedLink(AmazonActivity amazonactivity, SpannableString spannablestring, String s, String s1, String s2)
    {
        int i;
label0:
        {
            if (amazonactivity != null && spannablestring != null && !Util.isEmpty(s) && !Util.isEmpty(s1) && !Util.isEmpty(s2))
            {
                i = s.indexOf(s1);
                if (i >= 0)
                {
                    break label0;
                }
            }
            return;
        }
        spannablestring.setSpan(new ClickableSpan(amazonactivity, s2, s1) {

            final AmazonActivity val$amazonActivity;
            final String val$linkText;
            final String val$linkUrl;

            public void onClick(View view)
            {
                amazonActivity.pushView(new AmazonBrandedWebView(amazonActivity, linkUrl, linkText));
            }

            
            {
                amazonActivity = amazonactivity;
                linkUrl = s;
                linkText = s1;
                super();
            }
        }, i, s1.length() + i, 33);
    }

    public static void alert(Context context)
    {
        alert(context, "", null);
    }

    public static void alert(Context context, int i)
    {
        alert(context, context.getResources().getString(i), null);
    }

    public static void alert(Context context, Notification notification)
    {
        alert(context, (new StringBuilder()).append(notification.getTitle()).append("\n\n").append(notification.getMessage()).toString());
    }

    public static void alert(Context context, Exception exception)
    {
        if (ConfigUtils.isEnabledForApp(context, com.amazon.mShop.android.lib.R.bool.config_reportErrorExceptionMetricsToPmet))
        {
            ErrorExceptionMetricsObserver.logMetric(exception);
        }
        if (isCommonNetworkException(exception) || (exception instanceof SSLPeerUnverifiedException))
        {
            if (shouldShowNetworkExceptionAlert() && !sShowingNetFailDialog)
            {
                info(context, getMessageForException(context, exception));
            }
            return;
        } else
        {
            alert(context, getMessageForException(context, exception), null);
            return;
        }
    }

    public static void alert(Context context, String s)
    {
        alert(context, s, null);
    }

    public static void alert(Context context, String s, android.content.DialogInterface.OnDismissListener ondismisslistener)
    {
        String s1 = s;
        if (Util.isEmpty(s))
        {
            s1 = context.getResources().getString(com.amazon.mShop.android.lib.R.string.alert_error_service_please_try_again);
        }
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable(context, s1, ondismisslistener) {

            final Context val$context;
            final android.content.DialogInterface.OnDismissListener val$dismissListener;
            final String val$msg;

            public void run()
            {
                Object obj = new com.amazon.mShop.AmazonAlertDialog.Builder(context);
                ((com.amazon.mShop.AmazonAlertDialog.Builder) (obj)).setMessage(msg);
                ((com.amazon.mShop.AmazonAlertDialog.Builder) (obj)).setCancelable(true);
                obj = ((com.amazon.mShop.AmazonAlertDialog.Builder) (obj)).create();
                ((AmazonAlertDialog) (obj)).setOnDismissListener(dismissListener);
                ((AmazonAlertDialog) (obj)).setCanceledOnTouchOutside(true);
                ((AmazonAlertDialog) (obj)).setDismissedOnTrackBall(true);
                ((AmazonAlertDialog) (obj)).show();
            }

            
            {
                context = context1;
                msg = s;
                dismissListener = ondismisslistener;
                super();
            }
        });
    }

    public static Drawable badgedIconForCount(Context context, int ai[], int i, int j)
    {
        if (j < 0)
        {
            return null;
        }
        if (j <= ai.length - 1)
        {
            i = ai[j];
        }
        try
        {
            context = context.getResources().getDrawable(i);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e("Amazon.UIUtils", (new StringBuilder()).append("Failed to find badge icon for drawable id ").append(i).toString());
            return null;
        }
        return context;
    }

    public static List breakLines(String s, int i, TextPaint textpaint, int j)
    {
        Object obj;
        obj = null;
        break MISSING_BLOCK_LABEL_3;
_L2:
        ArrayList arraylist;
        int k;
        do
        {
            return ((List) (obj));
        } while (i < 1 || Util.isEmpty(s));
        s = s.trim();
        k = 0;
        arraylist = new ArrayList();
_L4:
        obj = arraylist;
        if (s.length() <= 0) goto _L2; else goto _L1
_L1:
        obj = arraylist;
        if (k >= i) goto _L2; else goto _L3
_L3:
        String s1;
        boolean flag;
        if (k == i - 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        s1 = getOneLineText(s, flag, textpaint, j);
        s = s.substring(s1.length());
        arraylist.add(s1.trim());
        s = s.trim();
        k++;
          goto _L4
    }

    public static void closeSoftKeyboard(View view)
    {
        InputMethodManager inputmethodmanager;
        if (view != null)
        {
            if ((inputmethodmanager = (InputMethodManager)view.getContext().getSystemService("input_method")) != null)
            {
                inputmethodmanager.hideSoftInputFromWindow(view.getWindowToken(), 0);
                return;
            }
        }
    }

    public static byte[] convertBitmapToByteArray(Bitmap bitmap)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, bytearrayoutputstream);
        return bytearrayoutputstream.toByteArray();
    }

    public static int convertDipToPixel(int i)
    {
        return Math.round(TypedValue.applyDimension(1, 2.0F, ((Context)com.amazon.mShop.platform.Platform.Factory.getInstance().getApplicationContext()).getResources().getDisplayMetrics()));
    }

    public static CharSequence convertUnsupportedCharacter(Context context, String s, CharacterColor charactercolor)
    {
        if (AppLocale.getInstance().getCurrentLocaleName().equals("en_IN") && android.os.Build.VERSION.SDK_INT < 11)
        {
            Set set = UNSUPPORTED_CHARACTERS.keySet();
            SpannableString spannablestring = new SpannableString(s);
            boolean flag = false;
            for (int i = 0; i < s.length(); i++)
            {
                char c = s.charAt(i);
                if (set.contains(Character.valueOf(c)))
                {
                    spannablestring.setSpan(new ImageSpan(context, ((Integer)((Map)UNSUPPORTED_CHARACTERS.get(Character.valueOf(c))).get(charactercolor)).intValue()), i, i + 1, 18);
                    flag = true;
                }
            }

            if (flag)
            {
                return spannablestring;
            } else
            {
                return s;
            }
        } else
        {
            return s;
        }
    }

    public static AmazonErrorBox createErrorBox(AmazonActivity amazonactivity, AmazonErrorInfo amazonerrorinfo)
    {
        if (amazonerrorinfo.getErrorId() == 0)
        {
            amazonactivity = null;
        } else
        {
            AmazonErrorBox amazonerrorbox = new AmazonErrorBox(amazonactivity);
            amazonerrorbox.setButtonOnClick(1, new android.view.View.OnClickListener(amazonerrorinfo, amazonactivity) {

                final AmazonActivity val$amazonActivity;
                final AmazonErrorInfo val$errorInfo;

                public void onClick(View view)
                {
                    view = errorInfo.getActionListener();
                    if (view != null)
                    {
                        view.onActionButtonClick(errorInfo.getErrorId());
                    }
                    amazonActivity.dismissErrorBox();
                }

            
            {
                errorInfo = amazonerrorinfo;
                amazonActivity = amazonactivity;
                super();
            }
            });
            String s1 = amazonerrorinfo.getMessage();
            String s = s1;
            if (Util.isEmpty(s1))
            {
                int i;
                if (NetInfo.hasNetworkConnection())
                {
                    i = com.amazon.mShop.android.lib.R.string.error_network_fail_access_amazon_message;
                } else
                {
                    i = com.amazon.mShop.android.lib.R.string.error_network_no_connection_message;
                }
                s = amazonactivity.getString(i);
            }
            amazonerrorbox.setMessage(formatErrorMessage(s, amazonerrorinfo.getErrorId()));
            amazonerrorinfo = amazonerrorinfo.getActionButtonText();
            amazonactivity = amazonerrorbox;
            if (!Util.isEmpty(amazonerrorinfo))
            {
                amazonerrorbox.setButtonText(1, amazonerrorinfo);
                return amazonerrorbox;
            }
        }
        return amazonactivity;
    }

    public static int findViewIndex(ViewAnimator viewanimator, View view)
    {
        for (int i = viewanimator.getChildCount() - 1; i >= 0; i--)
        {
            if (view == viewanimator.getChildAt(i))
            {
                return i;
            }
        }

        return -1;
    }

    public static String formatErrorMessage(String s, int i)
    {
        return (new StringBuilder()).append(s).append(" (CS").append(i).append(")").toString();
    }

    public static DisplayMetrics getDeviceDisplayMetrics(Context context)
    {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((WindowManager)context.getSystemService("window")).getDefaultDisplay().getMetrics(displaymetrics);
        return displaymetrics;
    }

    public static float getDeviceLogicalDPI(Context context)
    {
        return getDeviceDisplayMetrics(context).density * 160F;
    }

    public static String getMessageForException(Context context, Exception exception)
    {
        Resources resources = context.getResources();
        if (exception instanceof EOFException)
        {
            context = resources.getString(com.amazon.mShop.android.lib.R.string.alert_error_service_please_try_again);
        } else
        {
            if (exception instanceof HttpException)
            {
                return resources.getString(com.amazon.mShop.android.lib.R.string.alert_error_service_please_try_again);
            }
            if (exception instanceof IOException)
            {
                if (exception instanceof SocketTimeoutException)
                {
                    return resources.getString(com.amazon.mShop.android.lib.R.string.alert_error_network_error_socket_timeout);
                }
                if (exception instanceof UnknownHostException)
                {
                    return resources.getString(com.amazon.mShop.android.lib.R.string.alert_error_network_error_unknownhost);
                } else
                {
                    return resources.getString(com.amazon.mShop.android.lib.R.string.error_network_fail_access_amazon_message);
                }
            }
            if (exception instanceof ApplicationException)
            {
                exception = getServerMessageForException(exception);
                context = exception;
                if (exception == null)
                {
                    return resources.getString(com.amazon.mShop.android.lib.R.string.alert_error_service_please_try_again);
                }
            } else
            if (exception instanceof SecurityException)
            {
                return resources.getString(com.amazon.mShop.android.lib.R.string.alert_error_client_problem);
            } else
            {
                return resources.getString(com.amazon.mShop.android.lib.R.string.alert_error_client_problem);
            }
        }
        return context;
    }

    private static String getOneLineText(String s, boolean flag, TextPaint textpaint, int i)
    {
        int j = textpaint.breakText(s, true, i, null);
        if (j == s.length())
        {
            return s;
        }
        if (j < s.length())
        {
            if (flag)
            {
                return TextUtils.ellipsize(s, textpaint, i, android.text.TextUtils.TruncateAt.END).toString();
            }
            s = s.substring(0, j);
            i = s.lastIndexOf(" ");
            if (i == -1)
            {
                return s;
            } else
            {
                return s.substring(0, i);
            }
        } else
        {
            return null;
        }
    }

    public static int getPortraitHeight(Context context)
    {
        Display display = ((WindowManager)context.getSystemService("window")).getDefaultDisplay();
        if (isPortrait(context))
        {
            return display.getHeight();
        } else
        {
            return display.getWidth();
        }
    }

    public static int getPortraitWidth(Context context)
    {
        Display display = ((WindowManager)context.getSystemService("window")).getDefaultDisplay();
        if (isPortrait(context))
        {
            return display.getWidth();
        } else
        {
            return display.getHeight();
        }
    }

    public static String getServerMessageForException(Exception exception)
    {
        if (exception instanceof ApplicationException)
        {
            exception = (ApplicationException)exception;
            if ((ApplicationException.INTERNAL_ERROR.equals(exception.getErrorCode()) || ApplicationException.OPERATION_NO_LONGER_SUPPORTED.equals(exception.getErrorCode())) && !Util.isEmpty(exception.getMessage()))
            {
                return exception.getMessage();
            }
        }
        return null;
    }

    public static void info(Context context, int i)
    {
        info(context, context.getResources().getString(i));
    }

    public static void info(Context context, String s)
    {
        if (!Util.isEmpty(s))
        {
            com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable(context, s) {

                final Context val$context;
                final String val$message;

                public void run()
                {
                    Toast toast = Toast.makeText(context, message, 0);
                    toast.setGravity(17, 0, 0);
                    toast.show();
                }

            
            {
                context = context1;
                message = s;
                super();
            }
            });
        }
    }

    public static boolean isCommonNetworkException(Exception exception)
    {
        while (exception == null || !(exception instanceof ConnectionPoolTimeoutException) && !(exception instanceof SocketTimeoutException) && !exception.getClass().getName().equals("android.accounts.NetworkErrorException") && !(exception instanceof UnknownHostException) && !(exception instanceof SocketException) && !(exception instanceof ConnectException)) 
        {
            return false;
        }
        return true;
    }

    public static boolean isPortrait(Context context)
    {
        context = ((WindowManager)context.getSystemService("window")).getDefaultDisplay();
        return context.getHeight() > context.getWidth();
    }

    public static void setAlpha(View view, float f)
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            view.setAlpha(f);
            view.invalidate();
        }
    }

    public static void setHyperTexts(TextView textview, AmazonActivity amazonactivity, List list)
    {
        setHyperTexts(textview, amazonactivity, list, null);
    }

    public static void setHyperTexts(TextView textview, AmazonActivity amazonactivity, List list, List list1)
    {
        setHyperTexts(textview, new WebViewURLSpanFactory(amazonactivity) {

            final AmazonActivity val$activity;

            public URLSpan getURLSpan(String s, String s1)
            {
                return new WebViewURLSpan(activity, s, s1);
            }

            
            {
                activity = amazonactivity;
                super();
            }
        }, list, list1);
    }

    public static void setHyperTexts(TextView textview, WebViewURLSpanFactory webviewurlspanfactory, List list, List list1)
    {
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder();
        boolean flag = setSpanFromHyperTexts(webviewurlspanfactory, spannablestringbuilder, list, list1);
        textview.setText(spannablestringbuilder);
        if (flag)
        {
            if (!(textview.getMovementMethod() instanceof LinkMovementMethod))
            {
                textview.setMovementMethod(LinkMovementMethod.getInstance());
            }
        } else
        if (textview.getMovementMethod() instanceof LinkMovementMethod)
        {
            textview.setMovementMethod(null);
            return;
        }
    }

    public static void setImageSpan(AmazonActivity amazonactivity, Bitmap bitmap, SpannableStringBuilder spannablestringbuilder, int i)
    {
        if (spannablestringbuilder != null && bitmap != null)
        {
            int k = spannablestringbuilder.length();
            int j = k;
            if (k != 0)
            {
                spannablestringbuilder.append(" ");
                j = spannablestringbuilder.length();
            }
            spannablestringbuilder.append("a");
            k = spannablestringbuilder.length();
            spannablestringbuilder.setSpan(new ImageSpan(amazonactivity, bitmap, i), j, k, 33);
        }
    }

    public static void setMaxLength(TextView textview, int i)
    {
        InputFilter ainputfilter[] = textview.getFilters();
        android.text.InputFilter.LengthFilter lengthfilter = new android.text.InputFilter.LengthFilter(i);
        if (ainputfilter == null || ainputfilter.length == 0)
        {
            textview.setFilters(new InputFilter[] {
                lengthfilter
            });
            return;
        }
        for (i = 0; i < ainputfilter.length; i++)
        {
            if (ainputfilter[i] instanceof android.text.InputFilter.LengthFilter)
            {
                ainputfilter[i] = lengthfilter;
                textview.setFilters(ainputfilter);
                return;
            }
        }

        InputFilter ainputfilter1[] = new InputFilter[ainputfilter.length + 1];
        System.arraycopy(ainputfilter, 0, ainputfilter1, 0, ainputfilter.length);
        ainputfilter1[ainputfilter1.length - 1] = lengthfilter;
        textview.setFilters(ainputfilter1);
    }

    public static void setMaxLengthFromRule(TextView textview, int i)
    {
        i = Util.parseRuleMaxLength(textview.getContext().getString(i));
        if (i > 0)
        {
            setMaxLength(textview, i);
        }
    }

    public static void setSpanFromHyperTexts(AmazonActivity amazonactivity, SpannableStringBuilder spannablestringbuilder, List list, List list1)
    {
        setSpanFromHyperTexts(new WebViewURLSpanFactory(amazonactivity) {

            final AmazonActivity val$activity;

            public URLSpan getURLSpan(String s, String s1)
            {
                return new WebViewURLSpan(activity, s, s1);
            }

            
            {
                activity = amazonactivity;
                super();
            }
        }, spannablestringbuilder, list, list1);
    }

    public static boolean setSpanFromHyperTexts(WebViewURLSpanFactory webviewurlspanfactory, SpannableStringBuilder spannablestringbuilder, List list, List list1)
    {
        HyperText hypertext;
        int i;
        boolean flag;
        hypertext = (HyperText)list.get(list.size() - 1);
        flag = false;
        i = 0;
_L2:
        Object obj;
        int j;
        int k;
        boolean flag1;
        if (i >= list.size())
        {
            break MISSING_BLOCK_LABEL_499;
        }
        obj = (HyperText)list.get(i);
        j = spannablestringbuilder.length();
        if (!Util.isEmpty(((HyperText) (obj)).getText()))
        {
            spannablestringbuilder.append(((HyperText) (obj)).getText());
        }
        if (((HyperText) (obj)).getLineBreak() && hypertext != obj)
        {
            spannablestringbuilder.append("\n");
        }
        k = spannablestringbuilder.length();
        if (j != k)
        {
            break; /* Loop/switch isn't completed */
        }
        flag1 = flag;
_L4:
        i++;
        flag = flag1;
        if (true) goto _L2; else goto _L1
_L1:
        Object obj1;
        obj1 = ((HyperText) (obj)).getAttributes();
        flag1 = flag;
        if (obj1 == null) goto _L4; else goto _L3
_L3:
        if (((TextAttributes) (obj1)).getSize() == null) goto _L6; else goto _L5
_L5:
        ((TextAttributes) (obj1)).getSize().intValue();
        JVM INSTR tableswitch 0 2: default 188
    //                   0 376
    //                   1 188
    //                   2 399;
           goto _L6 _L7 _L6 _L8
_L6:
        if (((TextAttributes) (obj1)).getStyle() == null) goto _L10; else goto _L9
_L9:
        ((TextAttributes) (obj1)).getStyle().intValue();
        JVM INSTR tableswitch 1 3: default 232
    //                   1 422
    //                   2 232
    //                   3 443;
           goto _L11 _L12 _L11 _L13
_L11:
        break; /* Loop/switch isn't completed */
_L13:
        break MISSING_BLOCK_LABEL_443;
_L10:
        if (list1 != null && list1.size() > i)
        {
            spannablestringbuilder.setSpan(new BackgroundColorSpan(((Integer)list1.get(i)).intValue()), j, k, 33);
        }
        if (((TextAttributes) (obj1)).getColor() != null)
        {
            spannablestringbuilder.setSpan(new ForegroundColorSpan(((TextAttributes) (obj1)).getColor().intValue()), j, k, 33);
        }
        obj1 = ((TextAttributes) (obj1)).getLinkUrl();
        flag1 = flag;
        if (obj1 != null)
        {
            flag1 = true;
            if (((String) (obj1)).startsWith("open:"))
            {
                obj = new URLSpan(((String) (obj1)).substring("open:".length()));
            } else
            if (webviewurlspanfactory != null)
            {
                obj = webviewurlspanfactory.getURLSpan(((String) (obj1)), ((HyperText) (obj)).getText());
            } else
            {
                obj = new URLSpan(((String) (obj1)));
            }
            spannablestringbuilder.setSpan(obj, j, k, 33);
        }
          goto _L4
_L7:
        spannablestringbuilder.setSpan(new RelativeSizeSpan(0.75F), j, k, 33);
          goto _L6
_L8:
        spannablestringbuilder.setSpan(new RelativeSizeSpan(1.25F), j, k, 33);
          goto _L6
_L12:
        spannablestringbuilder.setSpan(new StyleSpan(1), j, k, 33);
          goto _L10
        spannablestringbuilder.setSpan(new UnderlineSpan(), j, k, 33);
          goto _L10
        return flag;
          goto _L4
    }

    private static boolean shouldShowNetworkExceptionAlert()
    {
        if (SystemClock.elapsedRealtime() - sLastNetworkExceptionAlertTime > 6000L)
        {
            sLastNetworkExceptionAlertTime = SystemClock.elapsedRealtime();
            return true;
        } else
        {
            return false;
        }
    }

    public static void showSoftKeyboard(View view)
    {
        if (view != null)
        {
            if ((view = (InputMethodManager)view.getContext().getSystemService("input_method")) != null)
            {
                view.toggleSoftInput(2, 2);
                return;
            }
        }
    }

    public static void vibrate(Context context, long l)
    {
        context = (Vibrator)context.getSystemService("vibrator");
        if (context != null)
        {
            context.vibrate(l);
        }
    }

    static 
    {
        UNSUPPORTED_CHARACTERS = new HashMap();
        HashMap hashmap = new HashMap();
        hashmap.put(CharacterColor.RED, Integer.valueOf(com.amazon.mShop.android.lib.R.drawable.rupee_red));
        hashmap.put(CharacterColor.DARK_GRAY, Integer.valueOf(com.amazon.mShop.android.lib.R.drawable.rupee_grey));
        hashmap.put(CharacterColor.BLACK, Integer.valueOf(com.amazon.mShop.android.lib.R.drawable.rupee_black));
        UNSUPPORTED_CHARACTERS.put(Character.valueOf('\u20B9'), hashmap);
        CART_ICON_RES_ID_FOR_COUNT = (new int[] {
            com.amazon.mShop.android.lib.R.drawable.android_menu_cart, com.amazon.mShop.android.lib.R.drawable.android_menu_cart_new_1, com.amazon.mShop.android.lib.R.drawable.android_menu_cart_new_2, com.amazon.mShop.android.lib.R.drawable.android_menu_cart_new_3, com.amazon.mShop.android.lib.R.drawable.android_menu_cart_new_4, com.amazon.mShop.android.lib.R.drawable.android_menu_cart_new_5, com.amazon.mShop.android.lib.R.drawable.android_menu_cart_new_6, com.amazon.mShop.android.lib.R.drawable.android_menu_cart_new_7, com.amazon.mShop.android.lib.R.drawable.android_menu_cart_new_8, com.amazon.mShop.android.lib.R.drawable.android_menu_cart_new_9, 
            com.amazon.mShop.android.lib.R.drawable.android_menu_cart_new_10
        });
        CART_ICON_RES_ID_FOR_COUNT_PLUS = com.amazon.mShop.android.lib.R.drawable.android_menu_cart_new_10plus;
    }
}
