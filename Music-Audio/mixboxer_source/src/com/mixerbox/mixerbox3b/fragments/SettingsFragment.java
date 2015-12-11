// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.fragments;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.mixerbox.mixerbox3b.MainPage;
import com.mixerbox.mixerbox3b.utils.MixerBoxClient;
import com.mixerbox.mixerbox3b.utils.MixerBoxSharedPreferences;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class SettingsFragment extends Fragment
{

    Button btnLogout;
    public Button btnSleep;
    CheckBox cbBackground;
    public CheckBox cbHD;
    public CheckBox checkbox;
    public boolean shouldOpenConfirmDialog;

    public SettingsFragment()
    {
        shouldOpenConfirmDialog = true;
    }

    public void loadContent()
    {
        if (!isAdded())
        {
            return;
        } else
        {
            cbHD.setChecked(MixerBoxSharedPreferences.getHighQuality(getActivity()));
            shouldOpenConfirmDialog = false;
            checkbox.setChecked(MixerBoxSharedPreferences.getPostFB(getActivity()));
            shouldOpenConfirmDialog = true;
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        Button button;
        Button button1;
        Button button2;
        layoutinflater = layoutinflater.inflate(0x7f030034, viewgroup, false);
        viewgroup = (LinearLayout)layoutinflater.findViewById(0x7f07008f);
        bundle = (RelativeLayout)layoutinflater.findViewById(0x7f070091);
        btnLogout = (Button)layoutinflater.findViewById(0x7f07009d);
        button2 = (Button)layoutinflater.findViewById(0x7f070097);
        checkbox = (CheckBox)layoutinflater.findViewById(0x7f070092);
        button = (Button)layoutinflater.findViewById(0x7f070098);
        btnSleep = (Button)layoutinflater.findViewById(0x7f070095);
        cbHD = (CheckBox)layoutinflater.findViewById(0x7f070094);
        button1 = (Button)layoutinflater.findViewById(0x7f070096);
        if (!MixerBoxSharedPreferences.getHasShownFAQ(getActivity()))
        {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getActivity());
            builder.setTitle(getResources().getString(0x7f0800ef));
            WebView webview = new WebView(getActivity());
            webview.loadUrl((new StringBuilder()).append("file:///android_asset/").append(getActivity().getResources().getString(0x7f080107)).append(".html").toString());
            webview.setWebViewClient(new _cls1());
            builder.setView(webview);
            builder.setNegativeButton(getResources().getString(0x7f08007e), new _cls2());
            builder.show();
            MixerBoxSharedPreferences.putHasShownFAQ(getActivity());
        }
        final Object jAd;
        jAd = MixerBoxSharedPreferences.getLastAd(getActivity());
        if (!((String) (jAd)).equals(""))
        {
            break MISSING_BLOCK_LABEL_573;
        }
        button2.setVisibility(8);
_L1:
        button2 = (Button)layoutinflater.findViewById(0x7f070099);
        jAd = MixerBoxSharedPreferences.getFAQUrl(getActivity());
        if (((String) (jAd)).equals(""))
        {
            button2.setVisibility(8);
        } else
        {
            button2.setOnClickListener(new _cls4());
        }
        if (((MainPage)getActivity()).isLogIn)
        {
            viewgroup.setVisibility(8);
            bundle.setVisibility(0);
        } else
        {
            bundle.setVisibility(8);
            btnLogout.setVisibility(8);
            button.setVisibility(8);
        }
        btnLogout.setOnClickListener(new _cls5());
        checkbox.setOnCheckedChangeListener(new _cls6());
        btnSleep.setText((new StringBuilder()).append(getActivity().getResources().getString(0x7f0800f0)).append(":  ").append(getActivity().getResources().getString(0x7f08007c)).toString());
        btnSleep.setOnClickListener(new _cls7());
        cbHD.setOnCheckedChangeListener(new _cls8());
        ((Button)layoutinflater.findViewById(0x7f07009a)).setOnClickListener(new _cls9());
        ((Button)layoutinflater.findViewById(0x7f070090)).setOnClickListener(new _cls10());
        ((Button)layoutinflater.findViewById(0x7f07009b)).setOnClickListener(new _cls11());
        button1.setOnClickListener(new _cls12());
        button.setOnClickListener(new _cls13());
        ((Button)layoutinflater.findViewById(0x7f07009c)).setOnClickListener(new _cls14());
        loadContent();
        return layoutinflater;
        try
        {
            jAd = new JSONObject(((String) (jAd)));
            button2.setText(((JSONObject) (jAd)).getString("msg"));
            button2.setOnClickListener(new _cls3());
        }
        // Misplaced declaration of an exception variable
        catch (final Object jAd)
        {
            ((JSONException) (jAd)).printStackTrace();
            button2.setVisibility(8);
        }
          goto _L1
    }

    void updateSysinfo()
    {
        String s;
        try
        {
            if (!MixerBoxClient.MIXERBOX_URL_PARAMETER.contains("&appVer="))
            {
                int i = getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 0).versionCode;
                MixerBoxClient.MIXERBOX_URL_PARAMETER = (new StringBuilder()).append(MixerBoxClient.MIXERBOX_URL_PARAMETER).append("&appVer=").append(i).toString();
            }
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception) { }
        s = (new StringBuilder()).append(Locale.getDefault().getLanguage()).append("-").append(Locale.getDefault().getCountry().toLowerCase(Locale.getDefault())).toString();
        MixerBoxSharedPreferences.putLocale(getActivity(), s);
        MixerBoxClient.get(MixerBoxClient.getSysInfoUrl(Long.valueOf(MixerBoxSharedPreferences.getFirstLaunchTime(getActivity())), s), null, new _cls15(getActivity()));
    }

    private class _cls1 extends WebViewClient
    {

        final SettingsFragment this$0;

        public boolean shouldOverrideUrlLoading(WebView webview, String s)
        {
            if (s.contains("fb://") || s.contains("://play.google.com/store/apps/details?id="))
            {
                webview = new Intent("android.intent.action.VIEW");
                webview.setData(Uri.parse(s));
                startActivity(webview);
                return true;
            }
            if (s.startsWith("mailto:"))
            {
                webview = MailTo.parse(s);
                s = new Intent("android.intent.action.SEND");
                s.putExtra("android.intent.extra.EMAIL", new String[] {
                    webview.getTo()
                });
                s.setType("message/rfc822");
                startActivity(s);
                return true;
            } else
            {
                return super.shouldOverrideUrlLoading(webview, s);
            }
        }

        _cls1()
        {
            this$0 = SettingsFragment.this;
            super();
        }
    }


    private class _cls2
        implements android.content.DialogInterface.OnClickListener
    {

        final SettingsFragment this$0;

        public void onClick(DialogInterface dialoginterface, int i)
        {
        }

        _cls2()
        {
            this$0 = SettingsFragment.this;
            super();
        }
    }


    private class _cls5
        implements android.view.View.OnClickListener
    {

        final SettingsFragment this$0;

        public void onClick(View view)
        {
            if (((MainPage)getActivity()).rlVideoPlayer.getVisibility() == 0)
            {
                ((MainPage)getActivity()).shouldSendNoti = false;
                ((MainPage)getActivity()).closePlayer();
            }
            FlurryAgent.logEvent("action:logout");
            MixerBoxSharedPreferences.clearSharedPreferences(getActivity());
            view = Session.getActiveSession();
            if (!view.isClosed())
            {
                view.closeAndClearTokenInformation();
            }
            MixerBoxClient.reset();
            MixerBoxUtils.toastMsg(getActivity(), getResources().getString(0x7f080074), 1);
            updateSysinfo();
        }

        _cls5()
        {
            this$0 = SettingsFragment.this;
            super();
        }
    }


    private class _cls6
        implements android.widget.CompoundButton.OnCheckedChangeListener
    {

        final SettingsFragment this$0;

        public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
        {
            if (flag)
            {
                if (shouldOpenConfirmDialog)
                {
                    AlertDialogFactory.AskPostAlertDialog(getActivity()).show();
                    return;
                } else
                {
                    shouldOpenConfirmDialog = true;
                    return;
                }
            } else
            {
                shouldOpenConfirmDialog = true;
                compoundbutton = new HashMap();
                compoundbutton.put("on", "0");
                FlurryAgent.logEvent("action:set_publish_activity", compoundbutton);
                MixerBoxSharedPreferences.putPostFB(getActivity(), false);
                MixerBoxSharedPreferences.putPlaySongCount(getActivity(), 1);
                return;
            }
        }

        _cls6()
        {
            this$0 = SettingsFragment.this;
            super();
        }
    }


    private class _cls7
        implements android.view.View.OnClickListener
    {

        final SettingsFragment this$0;

        public void onClick(View view)
        {
            if (btnSleep.getText().toString().equals((new StringBuilder()).append(getActivity().getResources().getString(0x7f0800f0)).append(":  ").append(getActivity().getResources().getString(0x7f08007c)).toString()))
            {
                (new SleepDialog(getActivity())).show().getWindow().setSoftInputMode(16);
                return;
            } else
            {
                view = (AlarmManager)getActivity().getSystemService("alarm");
                Intent intent = new Intent("SleepService");
                view.cancel(PendingIntent.getBroadcast(getActivity(), 0, intent, 0));
                btnSleep.setText((new StringBuilder()).append(getActivity().getResources().getString(0x7f0800f0)).append(":  ").append(getActivity().getResources().getString(0x7f08007c)).toString());
                MixerBoxUtils.toastMsg(getActivity(), (new StringBuilder()).append(getActivity().getResources().getString(0x7f0800f0)).append(":  ").append(getActivity().getResources().getString(0x7f08007c)).toString(), 1);
                view = new HashMap();
                view.put("val", "off");
                FlurryAgent.logEvent("action:set_sleep_timer", view);
                return;
            }
        }

        _cls7()
        {
            this$0 = SettingsFragment.this;
            super();
        }
    }


    private class _cls8
        implements android.widget.CompoundButton.OnCheckedChangeListener
    {

        final SettingsFragment this$0;

        public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
        {
            if (MixerBoxSharedPreferences.getHighQuality(getActivity()) && flag)
            {
                return;
            }
            ((MainPage)getActivity()).changeQuality(flag);
            ((MainPage)getActivity()).changeQuality(flag);
            if (flag)
            {
                compoundbutton = new HashMap();
                compoundbutton.put("from", "setting");
                compoundbutton.put("hd", "1");
                FlurryAgent.logEvent("action:set_hd", compoundbutton);
                return;
            } else
            {
                compoundbutton = new HashMap();
                compoundbutton.put("from", "setting");
                compoundbutton.put("hd", "0");
                FlurryAgent.logEvent("action:set_hd", compoundbutton);
                return;
            }
        }

        _cls8()
        {
            this$0 = SettingsFragment.this;
            super();
        }
    }


    private class _cls9
        implements android.view.View.OnClickListener
    {

        final SettingsFragment this$0;

        public void onClick(View view)
        {
            if (!MixerBoxClient.isConnectingToInternet(getActivity()))
            {
                AlertDialogFactory.NoNetworkAlertDialog(getActivity()).show();
                return;
            }
            FlurryAgent.logEvent("action:like_fanpage");
            try
            {
                view = new Intent("android.intent.action.VIEW", Uri.parse("fb://profile/264387593636216"));
                startActivity(view);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                view = new Intent("android.intent.action.VIEW", Uri.parse("https://www.facebook.com/MixerBox"));
            }
            startActivity(view);
        }

        _cls9()
        {
            this$0 = SettingsFragment.this;
            super();
        }
    }


    private class _cls10
        implements android.view.View.OnClickListener
    {

        final SettingsFragment this$0;

        public void onClick(View view)
        {
            if (!MixerBoxClient.isConnectingToInternet(getActivity()))
            {
                AlertDialogFactory.NoNetworkAlertDialog(getActivity()).show();
                return;
            }
            if (((MainPage)getActivity()).rlVideoPlayer.getVisibility() == 0)
            {
                ((MainPage)getActivity()).shouldSendNoti = false;
                ((MainPage)getActivity()).closePlayer();
            }
            FlurryAgent.logEvent("action:setting_page_login");
            ((MainPage)getActivity()).fragmentSignUp.checkLoginType = 0;
            ((MainPage)getActivity()).fragmentSignUp.loginButton.performClick();
        }

        _cls10()
        {
            this$0 = SettingsFragment.this;
            super();
        }
    }


    private class _cls11
        implements android.view.View.OnClickListener
    {

        final SettingsFragment this$0;

        public void onClick(View view)
        {
            if (!MixerBoxClient.isConnectingToInternet(getActivity()))
            {
                AlertDialogFactory.NoNetworkAlertDialog(getActivity()).show();
                return;
            }
            FlurryAgent.logEvent("action:feedback");
            try
            {
                view = new Intent("android.intent.action.VIEW", Uri.parse("fb://profile/264387593636216"));
                startActivity(view);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                view = new Intent("android.intent.action.VIEW", Uri.parse("https://www.facebook.com/MixerBox"));
            }
            startActivity(view);
        }

        _cls11()
        {
            this$0 = SettingsFragment.this;
            super();
        }
    }


    private class _cls12
        implements android.view.View.OnClickListener
    {

        final SettingsFragment this$0;

        public void onClick(View view)
        {
        }

        _cls12()
        {
            this$0 = SettingsFragment.this;
            super();
        }
    }


    private class _cls13
        implements android.view.View.OnClickListener
    {

        final SettingsFragment this$0;

        public void onClick(View view)
        {
            if (!MixerBoxClient.isConnectingToInternet(getActivity()))
            {
                AlertDialogFactory.NoNetworkAlertDialog(getActivity()).show();
                return;
            } else
            {
                FlurryAgent.logEvent("action:invite_friends");
                ((MainPage)getActivity()).sendRequestDialog();
                return;
            }
        }

        _cls13()
        {
            this$0 = SettingsFragment.this;
            super();
        }
    }


    private class _cls14
        implements android.view.View.OnClickListener
    {

        final SettingsFragment this$0;

        public void onClick(View view)
        {
            if (!MixerBoxClient.isConnectingToInternet(getActivity()))
            {
                AlertDialogFactory.NoNetworkAlertDialog(getActivity()).show();
                return;
            } else
            {
                view = new android.app.AlertDialog.Builder(getActivity());
                WebView webview = new WebView(getActivity());
                webview.loadUrl("http://static.mixerbox.com/inAppWeb/mb.copyright.info.android.html");
                class _cls1 extends WebViewClient
                {

                    final _cls14 this$1;

                    public boolean shouldOverrideUrlLoading(WebView webview1, String s)
                    {
                        if (s.contains("fb://") || s.contains("://play.google.com/store/apps/details?id="))
                        {
                            webview1 = new Intent("android.intent.action.VIEW");
                            webview1.setData(Uri.parse(s));
                            startActivity(webview1);
                            return true;
                        }
                        if (s.startsWith("mailto:"))
                        {
                            webview1 = MailTo.parse(s);
                            s = new Intent("android.intent.action.SEND");
                            s.putExtra("android.intent.extra.EMAIL", new String[] {
                                webview1.getTo()
                            });
                            s.setType("message/rfc822");
                            startActivity(s);
                            return true;
                        } else
                        {
                            return super.shouldOverrideUrlLoading(webview1, s);
                        }
                    }

                _cls1()
                {
                    this$1 = _cls14.this;
                    super();
                }
                }

                webview.setWebViewClient(new _cls1());
                view.setView(webview);
                class _cls2
                    implements android.content.DialogInterface.OnClickListener
                {

                    final _cls14 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                    }

                _cls2()
                {
                    this$1 = _cls14.this;
                    super();
                }
                }

                view.setNegativeButton(getResources().getString(0x7f08007e), new _cls2());
                view.show();
                return;
            }
        }

        _cls14()
        {
            this$0 = SettingsFragment.this;
            super();
        }
    }


    private class _cls3
        implements android.view.View.OnClickListener
    {

        final SettingsFragment this$0;
        final JSONObject val$jAd;

        public void onClick(View view)
        {
            FlurryAgent.logEvent("page:open_ad");
            view = new android.app.AlertDialog.Builder(getActivity());
            MyFocusableWebView myfocusablewebview = new MyFocusableWebView(getActivity());
            class _cls1 extends WebViewClient
            {

                final _cls3 this$1;

                public boolean shouldOverrideUrlLoading(WebView webview, String s)
                {
                    if (s.contains("fb://") || s.contains("://play.google.com/store/apps/details?id="))
                    {
                        webview = new Intent("android.intent.action.VIEW");
                        webview.setData(Uri.parse(s));
                        startActivity(webview);
                        return true;
                    }
                    if (s.startsWith("mailto:"))
                    {
                        webview = MailTo.parse(s);
                        s = new Intent("android.intent.action.SEND");
                        s.putExtra("android.intent.extra.EMAIL", new String[] {
                            webview.getTo()
                        });
                        s.setType("message/rfc822");
                        startActivity(s);
                        return true;
                    } else
                    {
                        return super.shouldOverrideUrlLoading(webview, s);
                    }
                }

                _cls1()
                {
                    this$1 = _cls3.this;
                    super();
                }
            }

            class _cls2
                implements android.content.DialogInterface.OnClickListener
            {

                final _cls3 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                }

                _cls2()
                {
                    this$1 = _cls3.this;
                    super();
                }
            }

            try
            {
                myfocusablewebview.loadUrl(jAd.getString("link"));
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
            myfocusablewebview.getSettings().setJavaScriptEnabled(true);
            myfocusablewebview.setWebChromeClient(new WebChromeClient());
            myfocusablewebview.setWebViewClient(new _cls1());
            view.setView(myfocusablewebview);
            view.setNegativeButton(getResources().getString(0x7f08007e), new _cls2());
            view.show().getWindow().setSoftInputMode(16);
        }

        _cls3()
        {
            this$0 = SettingsFragment.this;
            jAd = jsonobject;
            super();
        }
    }


    private class _cls4
        implements android.view.View.OnClickListener
    {

        final SettingsFragment this$0;
        final String val$s;

        public void onClick(View view)
        {
            FlurryAgent.logEvent("action:faq_open");
            view = new android.app.AlertDialog.Builder(getActivity());
            view.setTitle(getResources().getString(0x7f0800ef));
            WebView webview = new WebView(getActivity());
            webview.loadUrl(s);
            class _cls1 extends WebViewClient
            {

                final _cls4 this$1;

                public boolean shouldOverrideUrlLoading(WebView webview1, String s1)
                {
                    if (s1.contains("fb://") || s1.contains("://play.google.com/store/apps/details?id="))
                    {
                        webview1 = new Intent("android.intent.action.VIEW");
                        webview1.setData(Uri.parse(s1));
                        startActivity(webview1);
                        return true;
                    }
                    if (s1.startsWith("mailto:"))
                    {
                        webview1 = MailTo.parse(s1);
                        s1 = new Intent("android.intent.action.SEND");
                        s1.putExtra("android.intent.extra.EMAIL", new String[] {
                            webview1.getTo()
                        });
                        s1.setType("message/rfc822");
                        startActivity(s1);
                        return true;
                    } else
                    {
                        return super.shouldOverrideUrlLoading(webview1, s1);
                    }
                }

                _cls1()
                {
                    this$1 = _cls4.this;
                    super();
                }
            }

            webview.setWebViewClient(new _cls1());
            view.setView(webview);
            class _cls2
                implements android.content.DialogInterface.OnClickListener
            {

                final _cls4 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                }

                _cls2()
                {
                    this$1 = _cls4.this;
                    super();
                }
            }

            view.setNegativeButton(getResources().getString(0x7f08007e), new _cls2());
            view.show();
        }

        _cls4()
        {
            this$0 = SettingsFragment.this;
            s = s1;
            super();
        }
    }


    private class _cls15 extends MixerBoxAsyncHttpResponseHandler
    {

        final SettingsFragment this$0;

        public void onFailure(Throwable throwable, String s)
        {
            throwable = new Intent();
            s = new Bundle();
            s.putBoolean("islogin", false);
            throwable.putExtras(s);
            throwable.setClass(getActivity(), com/mixerbox/mixerbox3b/LoginBridge);
            startActivity(throwable);
            getActivity().finish();
        }

        public void onSuccess(String s)
        {
            if (s == null)
            {
                break MISSING_BLOCK_LABEL_116;
            }
            s = new JSONObject(s);
            if (!s.isNull("sysinfo"))
            {
                s = s.getJSONObject("sysinfo");
                if (!s.isNull("showAd"))
                {
                    MixerBoxSharedPreferences.putShouldShowAd(getActivity(), s.getBoolean("showAd"));
                }
                s = new Intent();
                Bundle bundle = new Bundle();
                bundle.putBoolean("islogin", false);
                s.putExtras(bundle);
                s.setClass(getActivity(), com/mixerbox/mixerbox3b/LoginBridge);
                startActivity(s);
                getActivity().finish();
                return;
            }
            break MISSING_BLOCK_LABEL_240;
            try
            {
                s = new Intent();
                Bundle bundle1 = new Bundle();
                bundle1.putBoolean("islogin", false);
                s.putExtras(bundle1);
                s.setClass(getActivity(), com/mixerbox/mixerbox3b/LoginBridge);
                startActivity(s);
                getActivity().finish();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s = new Intent();
            }
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("islogin", false);
            s.putExtras(bundle2);
            s.setClass(getActivity(), com/mixerbox/mixerbox3b/LoginBridge);
            startActivity(s);
            getActivity().finish();
        }

        _cls15(Context context)
        {
            this$0 = SettingsFragment.this;
            super(context);
        }
    }

}
