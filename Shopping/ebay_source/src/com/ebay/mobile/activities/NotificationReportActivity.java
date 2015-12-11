// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import com.ebay.common.Preferences;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.common.EbayUtil;
import com.ebay.mobile.notifications.EbaySmartNotificationManager;
import com.ebay.mobile.notifications.ItemCache;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.net.DataRequest;
import com.ebay.nautilus.domain.net.DataResponse;
import com.ebay.nautilus.kernel.content.EbayContext;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

// Referenced classes of package com.ebay.mobile.activities:
//            BaseActivity

public class NotificationReportActivity extends BaseActivity
    implements android.view.View.OnClickListener
{
    public class OnItemSelectedListenerWrapper
        implements android.widget.AdapterView.OnItemSelectedListener
    {

        private int lastPosition;
        private android.widget.AdapterView.OnItemSelectedListener listener;
        final NotificationReportActivity this$0;

        public void onItemSelected(AdapterView adapterview, View view, int i, long l)
        {
            if (lastPosition == i)
            {
                Log.d(getClass().getName(), (new StringBuilder()).append("Ignoring onItemSelected for same position: ").append(i).toString());
            } else
            {
                Log.d(getClass().getName(), (new StringBuilder()).append("Passing on onItemSelected for different position: ").append(i).toString());
                listener.onItemSelected(adapterview, view, i, l);
            }
            lastPosition = i;
        }

        public void onNothingSelected(AdapterView adapterview)
        {
            listener.onNothingSelected(adapterview);
        }

        public OnItemSelectedListenerWrapper(android.widget.AdapterView.OnItemSelectedListener onitemselectedlistener)
        {
            this$0 = NotificationReportActivity.this;
            super();
            lastPosition = 0;
            listener = onitemselectedlistener;
        }
    }

    public final class SendReportAsyncTask extends AsyncTask
    {

        private final EbayContext context;
        final NotificationReportActivity this$0;
        private StringBuffer url;

        protected transient Long doInBackground(Void avoid[])
        {
            long l1 = 0L;
            avoid = ((DataResponse)com.ebay.nautilus.kernel.net.Connector.Legacy.sendRequest(context, new DataRequest(new URL(url.toString())))).getText();
            long l;
            l = l1;
            if (avoid == null)
            {
                break MISSING_BLOCK_LABEL_65;
            }
            boolean flag = avoid.contains("200 OK");
            l = l1;
            if (flag)
            {
                l = 0L + 1L;
            }
_L2:
            return Long.valueOf(l);
            avoid;
            Log.e("NotificationReport", "removeFromList request failed", avoid);
            l = l1;
            if (true) goto _L2; else goto _L1
_L1:
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected void onPostExecute(Long long1)
        {
            if (long1.longValue() != 0L)
            {
                Toast.makeText(NotificationReportActivity.this, "Report sent to notification monitor", 1).show();
                finish();
                return;
            } else
            {
                Toast.makeText(NotificationReportActivity.this, "Error sending to notification monitor", 1).show();
                sendButton.setEnabled(true);
                return;
            }
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Long)obj);
        }

        public SendReportAsyncTask(StringBuffer stringbuffer)
        {
            this$0 = NotificationReportActivity.this;
            super();
            url = stringbuffer;
            context = getEbayContext();
        }
    }

    private class SpinnerAdapter extends ArrayAdapter
    {

        final NotificationReportActivity this$0;

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            if (view == null)
            {
                view = super.getView(i, null, viewgroup);
            }
            viewgroup = (String)getItem(i);
            TextView textview = (TextView)view.findViewById(0x1020014);
            if (textview != null)
            {
                textview.setText(viewgroup);
            }
            return view;
        }

        public SpinnerAdapter(Context context, int i, List list)
        {
            this$0 = NotificationReportActivity.this;
            super(context, i, list);
        }
    }


    protected static final String LOG_TAG = "NotificationReport";
    private static final String NOTI_URL = "http://awolnoti.appspot.com/awolnoti?";
    private Button cancelButton;
    private EditText comments;
    private EditText itemId;
    private Button sendButton;
    private Spinner spinner;
    private TimePicker timePicker;

    public NotificationReportActivity()
    {
    }

    private void createUi()
    {
        timePicker = (TimePicker)findViewById(0x7f10040e);
        spinner = (Spinner)findViewById(0x7f100120);
        comments = (EditText)findViewById(0x7f100410);
        itemId = (EditText)findViewById(0x7f10040f);
        String s = MyApp.getPrefs().getCurrentUser();
        Object obj = new ArrayList();
        if (EbayUtil.isPushActive(this, s, "AEAPP"))
        {
            com.ebay.common.model.mdns.NotificationPreference.EventType aeventtype[] = com.ebay.common.model.mdns.NotificationPreference.EventType.values();
            int k = aeventtype.length;
            for (int i = 0; i < k; i++)
            {
                ((List) (obj)).add(aeventtype[i].name());
            }

        } else
        {
            com.ebay.common.model.mdns.NotificationPreference.AlertType aalerttype[] = com.ebay.common.model.mdns.NotificationPreference.AlertType.values();
            int l = aalerttype.length;
            for (int j = 0; j < l; j++)
            {
                ((List) (obj)).add(aalerttype[j].name());
            }

        }
        obj = new SpinnerAdapter(this, 0x1090008, ((List) (obj)));
        ((SpinnerAdapter) (obj)).setDropDownViewResource(0x1090009);
        spinner.setAdapter(((android.widget.SpinnerAdapter) (obj)));
        obj = Calendar.getInstance();
        aalerttype = android.provider.Settings.System.getString(getContentResolver(), "time_12_24");
        timePicker.setIs24HourView(Boolean.valueOf("24".equals(aalerttype)));
        timePicker.setCurrentHour(Integer.valueOf(((Calendar) (obj)).get(11)));
        timePicker.setCurrentMinute(Integer.valueOf(((Calendar) (obj)).get(12)));
        cancelButton = (Button)findViewById(0x7f10014c);
        cancelButton.setOnClickListener(this);
        sendButton = (Button)findViewById(0x7f10014d);
        sendButton.setOnClickListener(this);
    }

    private String makeStringTime(TimePicker timepicker)
    {
        String s = String.valueOf(timepicker.getCurrentHour());
        String s1 = String.valueOf(timepicker.getCurrentMinute());
        timepicker = s;
        if (s.length() == 1)
        {
            timepicker = (new StringBuilder()).append("0").append(s).toString();
        }
        s = s1;
        if (s1.length() == 1)
        {
            s = (new StringBuilder()).append(s1).append("0").toString();
        }
        return (new StringBuilder()).append(timepicker).append(s).toString();
    }

    private void sendNotificationReport()
    {
        Authentication authentication;
        StringBuffer stringbuffer;
        StringBuffer stringbuffer1;
        ItemCache itemcache;
        com.ebay.mobile.notifications.EbaySmartNotificationManager.NotificationType notificationtype;
        authentication = MyApp.getPrefs().getAuthentication();
        if (authentication == null)
        {
            Toast.makeText(this, "You are not logged in", 1).show();
            return;
        }
        stringbuffer = new StringBuffer("http://awolnoti.appspot.com/awolnoti?");
        stringbuffer1 = new StringBuffer();
        itemcache = new ItemCache(this);
        notificationtype = EbaySmartNotificationManager.getCurrentConfiguration(this);
        stringbuffer1.append("userid=").append(authentication.user);
        stringbuffer1.append((new StringBuilder()).append("&t=").append(notificationtype).toString());
        if (notificationtype != com.ebay.mobile.notifications.EbaySmartNotificationManager.NotificationType.GCM) goto _L2; else goto _L1
_L1:
        stringbuffer1.append("&regid=").append(itemcache.getGCMRegistrationId(authentication.user));
_L4:
        stringbuffer1.append("&now=").append(System.currentTimeMillis());
        stringbuffer1.append("&osv=").append(String.valueOf(android.os.Build.VERSION.SDK_INT));
        stringbuffer1.append("&nt=").append((String)spinner.getSelectedItem());
        if (itemId.getText() != null)
        {
            stringbuffer1.append("&ii=").append(itemId.getText().toString().trim());
        }
        if (comments.getText() != null)
        {
            stringbuffer1.append("&comments=").append(URLEncoder.encode(comments.getText().toString().trim()));
        }
        stringbuffer1.append("&et=").append(makeStringTime(timePicker));
        stringbuffer.append("data=").append(Base64.encodeToString(stringbuffer1.toString().getBytes(), 2));
        sendButton.setEnabled(false);
        (new SendReportAsyncTask(stringbuffer)).execute(new Void[0]);
        return;
_L2:
        if (notificationtype == com.ebay.mobile.notifications.EbaySmartNotificationManager.NotificationType.C2DM)
        {
            stringbuffer1.append("&regid=").append(itemcache.getRegistrationId(authentication.user));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131755341: 
            sendNotificationReport();
            return;

        case 2131755340: 
            finish();
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030185);
        createUi();
    }

}
