// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.service;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.view.Window;
import com.aio.downloader.activity.AppDetailsActivity;
import com.aio.downloader.dialog.CallerInDialog;
import com.aio.downloader.dialog.CallerOutDialog;
import com.aio.downloader.dialog.CallerOutDialog1;
import com.aio.downloader.utils.Myutils;
import com.aio.downloader.utils.SharedPreferencesConfig;
import com.umeng.analytics.MobclickAgent;
import java.io.File;
import java.io.FileInputStream;

public class PhoneStateReceiver extends BroadcastReceiver
{

    private File AIOCALLERAPK;
    private File AIOCALLERDOWN;
    private CallerInDialog callerInDialog;
    private CallerOutDialog callerOutDialog;
    private CallerOutDialog1 callerOutDialog1;
    private android.view.View.OnClickListener itemsOnClick;
    private TelephonyManager telMgr;

    public PhoneStateReceiver()
    {
        telMgr = null;
        AIOCALLERDOWN = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("caller.swf").toString());
        AIOCALLERAPK = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("caller.apk").toString());
    }

    public static String getContactNameByPhoneNumber(Context context, String s)
    {
        Object obj;
        context = context.getContentResolver();
        obj = android.provider.ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        s = (new StringBuilder("data1 = '")).append(s).append("'").toString();
        obj = context.query(((Uri) (obj)), new String[] {
            "display_name", "photo_id", "data1"
        }, s, null, null);
        if (obj == null || ((Cursor) (obj)).getCount() == 0) goto _L2; else goto _L1
_L1:
        int i = 0;
_L7:
        if (i < ((Cursor) (obj)).getCount()) goto _L3; else goto _L2
_L2:
        context = "";
_L5:
        return context;
_L3:
        ((Cursor) (obj)).moveToPosition(i);
        s = ((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndex("display_name"));
        if (s.equals(""))
        {
            break; /* Loop/switch isn't completed */
        }
        context = s;
        if (s != null) goto _L5; else goto _L4
_L4:
        i++;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public long getFileSizes(File file)
        throws Exception
    {
        if (file.exists())
        {
            return (long)(new FileInputStream(file)).available();
        } else
        {
            file.createNewFile();
            return 0L;
        }
    }

    public void onReceive(final Context context, Intent intent)
    {
        telMgr = (TelephonyManager)context.getSystemService("phone");
        switch (telMgr.getCallState())
        {
        default:
            return;

        case 1: // '\001'
            Myutils.laststate = 1;
            Log.e("qwer", (new StringBuilder("laststate=")).append(Myutils.laststate).toString());
            return;

        case 2: // '\002'
            Myutils.laststate = 2;
            Log.e("qwer", (new StringBuilder("Myutils.laststate=")).append(Myutils.laststate).toString());
            return;

        case 0: // '\0'
            intent = intent.getStringExtra("incoming_number");
            getContactNameByPhoneNumber(context, intent);
            Log.e("qwer", (new StringBuilder("Myutils.laststate=")).append(Myutils.laststate).append("number=").append(intent).toString());
            break;
        }
        if (Myutils.laststate != 1) goto _L2; else goto _L1
_L1:
        itemsOnClick = new android.view.View.OnClickListener() {

            final PhoneStateReceiver this$0;
            private final Context val$context;

            public void onClick(View view)
            {
                switch (view.getId())
                {
                case 2131166057: 
                case 2131166058: 
                default:
                    return;

                case 2131166056: 
                    callerOutDialog.dismiss();
                    return;

                case 2131166059: 
                    MobclickAgent.onEvent(context, "call_state_ringing_click");
                    break;
                }
                if (!AIOCALLERAPK.exists() || getFileSizes(AIOCALLERAPK) < 0x4e87bdL) goto _L2; else goto _L1
_L1:
                view = new Intent("android.intent.action.VIEW");
                view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AIOCALLERAPK).toString()), "application/vnd.android.package-archive");
                view.addFlags(0x10000000);
                context.startActivity(view);
_L4:
                callerOutDialog.dismiss();
                return;
_L2:
                if (AIOCALLERDOWN.exists() && getFileSizes(AIOCALLERDOWN) >= 0x4e87bdL)
                {
                    (context. new AsyncTask() {

                        final _cls1 this$1;
                        private final Context val$context;

                        protected volatile transient Object doInBackground(Object aobj[])
                        {
                            return doInBackground((Void[])aobj);
                        }

                        protected transient Void doInBackground(Void avoid[])
                        {
                            Myutils.copyfile(AIOCALLERDOWN, AIOCALLERAPK, Boolean.valueOf(false));
                            return null;
                        }

                        protected volatile void onPostExecute(Object obj)
                        {
                            onPostExecute((Void)obj);
                        }

                        protected void onPostExecute(Void void1)
                        {
                            super.onPostExecute(void1);
                            void1 = new Intent("android.intent.action.VIEW");
                            void1.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AIOCALLERAPK).toString()), "application/vnd.android.package-archive");
                            void1.addFlags(0x10000000);
                            context.startActivity(void1);
                        }

            
            {
                this$1 = final__pcls1;
                context = Context.this;
                super();
            }
                    }).execute(new Void[0]);
                    continue; /* Loop/switch isn't completed */
                }
                try
                {
                    view = new Intent(context, com/aio/downloader/activity/AppDetailsActivity);
                    view.putExtra("myid", "com.allinone.callerid");
                    view.addFlags(0x10000000);
                    context.startActivity(view);
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    view.printStackTrace();
                }
                if (true) goto _L4; else goto _L3
_L3:
            }


            
            {
                this$0 = PhoneStateReceiver.this;
                context = context1;
                super();
            }
        };
        callerOutDialog = new CallerOutDialog(context, 0x7f0c0010, itemsOnClick, intent);
        callerOutDialog.setCanceledOnTouchOutside(true);
        callerOutDialog.getWindow().setType(2003);
        intent = null;
        android.content.pm.PackageInfo packageinfo = context.getPackageManager().getPackageInfo("com.allinone.callerid", 0);
        intent = packageinfo;
_L5:
        if (intent == null && System.currentTimeMillis() > SharedPreferencesConfig.GetCalleroutTime(context))
        {
            SharedPreferencesConfig.SetCalleroutTime(context, System.currentTimeMillis() + 0x1b77400L);
            MobclickAgent.onEvent(context, "call_state_ringing");
            (new Handler()).postDelayed(new Runnable() {

                final PhoneStateReceiver this$0;

                public void run()
                {
                    callerOutDialog.show();
                }

            
            {
                this$0 = PhoneStateReceiver.this;
                super();
            }
            }, 2000L);
        }
_L2:
        if (Myutils.laststate != 2) goto _L4; else goto _L3
_L3:
        itemsOnClick = new android.view.View.OnClickListener() {

            final PhoneStateReceiver this$0;
            private final Context val$context;

            public void onClick(View view)
            {
                switch (view.getId())
                {
                case 2131166057: 
                case 2131166058: 
                default:
                    return;

                case 2131166056: 
                    callerOutDialog1.dismiss();
                    return;

                case 2131166059: 
                    MobclickAgent.onEvent(context, "simulate_call_click");
                    break;
                }
                if (!AIOCALLERAPK.exists() || getFileSizes(AIOCALLERAPK) < 0x4e87bdL) goto _L2; else goto _L1
_L1:
                view = new Intent("android.intent.action.VIEW");
                view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AIOCALLERAPK).toString()), "application/vnd.android.package-archive");
                view.addFlags(0x10000000);
                context.startActivity(view);
_L4:
                callerOutDialog1.dismiss();
                return;
_L2:
                if (AIOCALLERDOWN.exists() && getFileSizes(AIOCALLERDOWN) >= 0x4e87bdL)
                {
                    (context. new AsyncTask() {

                        final _cls3 this$1;
                        private final Context val$context;

                        protected volatile transient Object doInBackground(Object aobj[])
                        {
                            return doInBackground((Void[])aobj);
                        }

                        protected transient Void doInBackground(Void avoid[])
                        {
                            Myutils.copyfile(AIOCALLERDOWN, AIOCALLERAPK, Boolean.valueOf(false));
                            return null;
                        }

                        protected volatile void onPostExecute(Object obj)
                        {
                            onPostExecute((Void)obj);
                        }

                        protected void onPostExecute(Void void1)
                        {
                            super.onPostExecute(void1);
                            void1 = new Intent("android.intent.action.VIEW");
                            void1.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AIOCALLERAPK).toString()), "application/vnd.android.package-archive");
                            void1.addFlags(0x10000000);
                            context.startActivity(void1);
                        }

            
            {
                this$1 = final__pcls3;
                context = Context.this;
                super();
            }
                    }).execute(new Void[0]);
                    continue; /* Loop/switch isn't completed */
                }
                try
                {
                    view = new Intent(context, com/aio/downloader/activity/AppDetailsActivity);
                    view.putExtra("myid", "com.allinone.callerid");
                    view.addFlags(0x10000000);
                    context.startActivity(view);
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    view.printStackTrace();
                }
                if (true) goto _L4; else goto _L3
_L3:
            }


            
            {
                this$0 = PhoneStateReceiver.this;
                context = context1;
                super();
            }
        };
        callerOutDialog1 = new CallerOutDialog1(context, 0x7f0c0010, itemsOnClick, "+1 813-449-2756");
        callerOutDialog1.setCanceledOnTouchOutside(true);
        callerOutDialog1.getWindow().setType(2003);
        intent = null;
        packageinfo = context.getPackageManager().getPackageInfo("com.allinone.callerid", 0);
        intent = packageinfo;
_L6:
        if (intent == null && System.currentTimeMillis() > SharedPreferencesConfig.Getsimulate_callTime(context))
        {
            SharedPreferencesConfig.Setsimulate_callTime(context, System.currentTimeMillis() + 0x1499700L);
            MobclickAgent.onEvent(context, "simulate_call");
            (new Handler()).postDelayed(new Runnable() {

                final PhoneStateReceiver this$0;

                public void run()
                {
                    callerOutDialog1.show();
                }

            
            {
                this$0 = PhoneStateReceiver.this;
                super();
            }
            }, 3000L);
        }
_L4:
        Myutils.laststate = 0;
        return;
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        namenotfoundexception.printStackTrace();
          goto _L5
        namenotfoundexception;
        namenotfoundexception.printStackTrace();
          goto _L6
    }




}
