// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.mraid.controller;

import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import com.tapjoy.TapjoyLog;
import com.tapjoy.mraid.view.MraidView;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.tapjoy.mraid.controller:
//            Abstract, Assets, Display, MraidLocation, 
//            Network, MraidSensor

public class Utility extends Abstract
{

    private Assets c;
    private Display d;
    private MraidLocation e;
    private Network f;
    private MraidSensor g;

    public Utility(MraidView mraidview, Context context)
    {
        super(mraidview, context);
        c = new Assets(mraidview, context);
        d = new Display(mraidview, context);
        e = new MraidLocation(mraidview, context);
        f = new Network(mraidview, context);
        g = new MraidSensor(mraidview, context);
        mraidview.addJavascriptInterface(c, "MRAIDAssetsControllerBridge");
        mraidview.addJavascriptInterface(d, "MRAIDDisplayControllerBridge");
        mraidview.addJavascriptInterface(e, "MRAIDLocationControllerBridge");
        mraidview.addJavascriptInterface(f, "MRAIDNetworkControllerBridge");
        mraidview.addJavascriptInterface(g, "MRAIDSensorControllerBridge");
    }

    private void a(int i, String s, String s1, String s2)
    {
        ContentResolver contentresolver = b.getContentResolver();
        long l = Long.parseLong(s);
        s = new ContentValues();
        s.put("calendar_id", Integer.valueOf(i));
        s.put("title", s1);
        s.put("description", s2);
        s.put("dtstart", Long.valueOf(l));
        s.put("hasAlarm", Integer.valueOf(1));
        s.put("dtend", Long.valueOf(0x36ee80L + l));
        if (Integer.parseInt(android.os.Build.VERSION.SDK) == 8)
        {
            s = contentresolver.insert(Uri.parse("content://com.android.calendar/events"), s);
        } else
        {
            s = contentresolver.insert(Uri.parse("content://calendar/events"), s);
        }
        if (s != null)
        {
            long l1 = Long.parseLong(s.getLastPathSegment());
            s = new ContentValues();
            s.put("event_id", Long.valueOf(l1));
            s.put("method", Integer.valueOf(1));
            s.put("minutes", Integer.valueOf(15));
            if (Integer.parseInt(android.os.Build.VERSION.SDK) == 8)
            {
                contentresolver.insert(Uri.parse("content://com.android.calendar/reminders"), s);
            } else
            {
                contentresolver.insert(Uri.parse("content://calendar/reminders"), s);
            }
        }
        Toast.makeText(b, "Event added to calendar", 0).show();
    }

    static void a(Utility utility, int i, String s, String s1, String s2)
    {
        utility.a(i, s, s1, s2);
    }

    public void activate(String s)
    {
        TapjoyLog.d("MRAID Utility", (new StringBuilder("activate: ")).append(s).toString());
        if (s.equalsIgnoreCase("networkChange"))
        {
            f.startNetworkListener();
        } else
        {
            if (e.allowLocationServices() && s.equalsIgnoreCase("locationChange"))
            {
                e.startLocationListener();
                return;
            }
            if (s.equalsIgnoreCase("shake"))
            {
                g.startShakeListener();
                return;
            }
            if (s.equalsIgnoreCase("tiltChange"))
            {
                g.startTiltListener();
                return;
            }
            if (s.equalsIgnoreCase("headingChange"))
            {
                g.startHeadingListener();
                return;
            }
            if (s.equalsIgnoreCase("orientationChange"))
            {
                d.startConfigurationListener();
                return;
            }
        }
    }

    public String copyTextFromJarIntoAssetDir(String s, String s1)
    {
        return c.copyTextFromJarIntoAssetDir(s, s1);
    }

    public void createEvent(String s, String s1, String s2)
    {
        TapjoyLog.d("MRAID Utility", (new StringBuilder("createEvent: date: ")).append(s).append(" title: ").append(s1).append(" body: ").append(s2).toString());
        Object obj = b.getContentResolver();
        String as[] = new String[3];
        as[0] = "_id";
        as[1] = "displayName";
        as[2] = "_sync_account";
        if (Integer.parseInt(android.os.Build.VERSION.SDK) == 8)
        {
            obj = ((ContentResolver) (obj)).query(Uri.parse("content://com.android.calendar/calendars"), as, null, null, null);
        } else
        {
            obj = ((ContentResolver) (obj)).query(Uri.parse("content://calendar/calendars"), as, null, null, null);
        }
        if (obj == null || obj != null && !((Cursor) (obj)).moveToFirst())
        {
            Toast.makeText(b, "No calendar account found", 1).show();
            if (obj != null)
            {
                ((Cursor) (obj)).close();
            }
            return;
        }
        if (((Cursor) (obj)).getCount() == 1)
        {
            a(((Cursor) (obj)).getInt(0), s, s1, s2);
        } else
        {
            ArrayList arraylist = new ArrayList();
            for (int i = 0; i < ((Cursor) (obj)).getCount(); i++)
            {
                HashMap hashmap = new HashMap();
                hashmap.put("ID", ((Cursor) (obj)).getString(0));
                hashmap.put("NAME", ((Cursor) (obj)).getString(1));
                hashmap.put("EMAILID", ((Cursor) (obj)).getString(2));
                arraylist.add(hashmap);
                ((Cursor) (obj)).moveToNext();
            }

            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(b);
            builder.setTitle("Choose Calendar to save event to");
            builder.setSingleChoiceItems(new SimpleAdapter(b, arraylist, 0x109000d, new String[] {
                "NAME", "EMAILID"
            }, new int[] {
                0x1020014, 0x1020015
            }), -1, new android.content.DialogInterface.OnClickListener(arraylist, s, s1, s2) {

                final List a;
                final String b;
                final String c;
                final String d;
                final Utility e;

                public final void onClick(DialogInterface dialoginterface, int j)
                {
                    Map map = (Map)a.get(j);
                    Utility.a(e, Integer.parseInt((String)map.get("ID")), b, c, d);
                    dialoginterface.cancel();
                }

            
            {
                e = Utility.this;
                a = list;
                b = s;
                c = s1;
                d = s2;
                super();
            }
            });
            builder.create().show();
        }
        ((Cursor) (obj)).close();
    }

    public void deactivate(String s)
    {
        TapjoyLog.d("MRAID Utility", (new StringBuilder("deactivate: ")).append(s).toString());
        if (s.equalsIgnoreCase("networkChange"))
        {
            f.stopNetworkListener();
        } else
        {
            if (s.equalsIgnoreCase("locationChange"))
            {
                e.stopAllListeners();
                return;
            }
            if (s.equalsIgnoreCase("shake"))
            {
                g.stopShakeListener();
                return;
            }
            if (s.equalsIgnoreCase("tiltChange"))
            {
                g.stopTiltListener();
                return;
            }
            if (s.equalsIgnoreCase("headingChange"))
            {
                g.stopHeadingListener();
                return;
            }
            if (s.equalsIgnoreCase("orientationChange"))
            {
                d.stopConfigurationListener();
                return;
            }
        }
    }

    public void deleteOldAds()
    {
        c.deleteOldAds();
    }

    public void fireReadyEvent()
    {
        a.injectMraidJavaScript("mraid.signalReady();");
    }

    public void fireViewableChange(boolean flag)
    {
        a.injectMraidJavaScript((new StringBuilder("window.mraidview.fireChangeEvent({viewable:")).append(flag).append("});").toString());
    }

    public void init(float f1)
    {
        boolean flag1 = false;
        StringBuilder stringbuilder = (new StringBuilder("window.mraidview.fireChangeEvent({ state: 'default', network: '")).append(f.getNetwork()).append("', size: ").append(d.getSize()).append(", placement: '").append(a.getPlacementType()).append("', maxSize: ").append(d.getMaxSize()).append(",expandProperties: ").append(d.getMaxSize()).append(", screenSize: ").append(d.getScreenSize()).append(", defaultPosition: { x:").append((int)((float)a.getLeft() / f1)).append(", y: ").append((int)((float)a.getTop() / f1)).append(", width: ").append((int)((float)a.getWidth() / f1)).append(", height: ").append((int)((float)a.getHeight() / f1)).append(" }, orientation:").append(d.getOrientation()).append(",");
        String s1 = "supports: [ 'level-1', 'level-2', 'screen', 'orientation', 'network'";
        String s;
        boolean flag;
        if (e.allowLocationServices() && (b.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0 || b.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            s1 = (new StringBuilder()).append("supports: [ 'level-1', 'level-2', 'screen', 'orientation', 'network'").append(", 'location'").toString();
        }
        if (b.checkCallingOrSelfPermission("android.permission.SEND_SMS") == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        s = s1;
        if (flag)
        {
            s = (new StringBuilder()).append(s1).append(", 'sms'").toString();
        }
        if (b.checkCallingOrSelfPermission("android.permission.CALL_PHONE") == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        s1 = s;
        if (flag)
        {
            s1 = (new StringBuilder()).append(s).append(", 'phone'").toString();
        }
        flag = flag1;
        if (b.checkCallingOrSelfPermission("android.permission.WRITE_CALENDAR") == 0)
        {
            flag = flag1;
            if (b.checkCallingOrSelfPermission("android.permission.READ_CALENDAR") == 0)
            {
                flag = flag1;
                if (android.os.Build.VERSION.SDK_INT >= 14)
                {
                    flag = true;
                }
            }
        }
        s = s1;
        if (flag)
        {
            s = (new StringBuilder()).append(s1).append(", 'calendar'").toString();
        }
        s = (new StringBuilder()).append(s).append(", 'video'").toString();
        s = (new StringBuilder()).append(s).append(", 'audio'").toString();
        s = (new StringBuilder()).append(s).append(", 'map'").toString();
        s = (new StringBuilder()).append(s).append(", 'email' ]").toString();
        TapjoyLog.d("MRAID Utility", (new StringBuilder("getSupports: ")).append(s).toString());
        s = stringbuilder.append(s).append(",viewable:true });").toString();
        Log.d("MRAID Utility", (new StringBuilder("init: injection: ")).append(s).toString());
        a.injectMraidJavaScript(s);
        fireReadyEvent();
        fireViewableChange(true);
    }

    public void makeCall(String s)
    {
        TapjoyLog.d("MRAID Utility", (new StringBuilder("makeCall: number: ")).append(s).toString());
        if (TextUtils.isEmpty(s))
        {
            s = null;
        } else
        {
            StringBuilder stringbuilder = new StringBuilder("tel:");
            stringbuilder.append(s);
            s = stringbuilder.toString();
        }
        if (s == null)
        {
            a.raiseError("Bad Phone Number", "makeCall");
            return;
        } else
        {
            s = new Intent("android.intent.action.CALL", Uri.parse(s.toString()));
            s.addFlags(0x10000000);
            b.startActivity(s);
            return;
        }
    }

    public void mraidCreateEvent(String s)
    {
        Calendar calendar;
        Calendar calendar1;
        if (android.os.Build.VERSION.SDK_INT < 14)
        {
            return;
        }
        calendar = Calendar.getInstance();
        calendar1 = Calendar.getInstance();
        Object obj;
        Object obj1;
        Object obj2;
        obj = new JSONObject(s);
        obj2 = ((JSONObject) (obj)).getJSONObject("start");
        obj1 = ((JSONObject) (obj)).optJSONObject("end");
        if (obj1 == null)
        {
            obj1 = obj2;
        }
        s = ((JSONObject) (obj)).getString("description");
        String s1 = ((JSONObject) (obj)).optString("location");
        String s2 = ((JSONObject) (obj)).optString("summary");
        obj = ((JSONObject) (obj)).optString("status");
        calendar.set(((JSONObject) (obj2)).getInt("year"), ((JSONObject) (obj2)).getInt("month"), ((JSONObject) (obj2)).getInt("day"), ((JSONObject) (obj2)).getInt("hour"), ((JSONObject) (obj2)).getInt("min"));
        calendar1.set(((JSONObject) (obj1)).getInt("year"), ((JSONObject) (obj1)).getInt("month"), ((JSONObject) (obj1)).getInt("day"), ((JSONObject) (obj1)).getInt("hour"), ((JSONObject) (obj1)).getInt("min"));
        obj2 = s;
        obj1 = s1;
        s1 = s2;
        s = ((String) (obj));
_L2:
        s = (new Intent("android.intent.action.INSERT")).setData(android.provider.CalendarContract.Events.CONTENT_URI).putExtra("beginTime", calendar.getTimeInMillis()).putExtra("endTime", calendar1.getTimeInMillis()).putExtra("title", s1).putExtra("description", ((String) (obj2))).putExtra("eventLocation", ((String) (obj1))).putExtra("eventStatus", s);
        a.getContext().startActivity(s);
        return;
        JSONException jsonexception;
        jsonexception;
        s1 = null;
        s2 = null;
        obj = null;
        s = null;
_L3:
        jsonexception.printStackTrace();
        jsonexception = s2;
        obj2 = obj;
        if (true) goto _L2; else goto _L1
_L1:
        jsonexception;
        s1 = null;
        s2 = null;
        obj = s;
        s = null;
          goto _L3
        jsonexception;
        Object obj3 = null;
        s2 = s1;
        obj = s;
        s = null;
        s1 = obj3;
          goto _L3
        jsonexception;
        obj = s1;
        String s3 = s;
        s = null;
        s1 = s2;
        s2 = ((String) (obj));
        obj = s3;
          goto _L3
        jsonexception;
        String s4 = s1;
        String s5 = s;
        s = ((String) (obj));
        s1 = s2;
        s2 = s4;
        obj = s5;
          goto _L3
    }

    public void sendMail(String s, String s1, String s2)
    {
        TapjoyLog.d("MRAID Utility", (new StringBuilder("sendMail: recipient: ")).append(s).append(" subject: ").append(s1).append(" body: ").append(s2).toString());
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("plain/text");
        intent.putExtra("android.intent.extra.EMAIL", new String[] {
            s
        });
        intent.putExtra("android.intent.extra.SUBJECT", s1);
        intent.putExtra("android.intent.extra.TEXT", s2);
        intent.addFlags(0x10000000);
        b.startActivity(intent);
    }

    public void sendSMS(String s, String s1)
    {
        TapjoyLog.d("MRAID Utility", (new StringBuilder("sendSMS: recipient: ")).append(s).append(" body: ").append(s1).toString());
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.putExtra("address", s);
        intent.putExtra("sms_body", s1);
        intent.setType("vnd.android-dir/mms-sms");
        intent.addFlags(0x10000000);
        b.startActivity(intent);
    }

    public void setMaxSize(int i, int j)
    {
        d.setMaxSize(i, j);
    }

    public void showAlert(String s)
    {
        TapjoyLog.e("MRAID Utility", s);
    }

    public void stopAllListeners()
    {
        try
        {
            c.stopAllListeners();
            d.stopAllListeners();
            e.stopAllListeners();
            f.stopAllListeners();
            g.stopAllListeners();
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public String writeToDiskWrap(InputStream inputstream, String s, boolean flag, String s1, String s2)
    {
        return c.writeToDiskWrap(inputstream, s, flag, s1, s2);
    }
}
