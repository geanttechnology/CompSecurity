// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import com.aio.downloader.dialog.CleanerUPDialog;
import com.aio.downloader.utils.Myutils;
import com.umeng.analytics.MobclickAgent;
import java.io.File;

public class ScreenReceiver extends BroadcastReceiver
{

    static boolean launched = false;
    private File PRO_DIR;
    private File PRO_DIR_FOME;
    private File PRO_DIR_TO;
    private Handler handler;
    private Context mContext;
    private int status;

    public ScreenReceiver()
    {
        PRO_DIR_FOME = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/cleaner/cleaner.apk").toString());
        PRO_DIR_TO = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/cleaner/cleaner.swf").toString());
        PRO_DIR = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/cleaner").toString());
        handler = new Handler() {

            final ScreenReceiver this$0;

            public void handleMessage(Message message)
            {
                super.handleMessage(message);
                message = new CleanerUPDialog(mContext, 0x7f0c000e);
                message.setCanceledOnTouchOutside(false);
                message.getWindow().setType(2003);
                message.show();
                Button button = (Button)message.findViewById(0x7f070141);
                Button button1 = (Button)message.findViewById(0x7f070142);
                button.setOnClickListener(message. new android.view.View.OnClickListener() {

                    final _cls1 this$1;
                    private final CleanerUPDialog val$dialog;

                    public void onClick(View view)
                    {
                        dialog.dismiss();
                    }

            
            {
                this$1 = final__pcls1;
                dialog = CleanerUPDialog.this;
                super();
            }
                });
                button1.setOnClickListener(message. new android.view.View.OnClickListener() {

                    final _cls1 this$1;
                    private final CleanerUPDialog val$dialog;

                    public void onClick(View view)
                    {
                        MobclickAgent.onEvent(mContext, "cleanerupdate_click");
                        view = null;
                        android.content.pm.PackageInfo packageinfo = mContext.getPackageManager().getPackageInfo("com.evzapp.cleanmaster", 0);
                        view = packageinfo;
_L1:
                        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
                        if (view == null)
                        {
                            if (PRO_DIR_FOME.exists())
                            {
                                view = new Intent("android.intent.action.VIEW");
                                view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(PRO_DIR).append(File.separator).append("cleaner.apk").toString()), "application/vnd.android.package-archive");
                                view.addFlags(0x10000000);
                                mContext.startActivity(view);
                            } else
                            if (PRO_DIR_TO.exists())
                            {
                                (new AsyncTask() {

                                    final _cls2 this$2;

                                    protected volatile transient Object doInBackground(Object aobj[])
                                    {
                                        return doInBackground((Void[])aobj);
                                    }

                                    protected transient Void doInBackground(Void avoid[])
                                    {
                                        Myutils.copyfile(PRO_DIR_TO, PRO_DIR_FOME, Boolean.valueOf(false));
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
                                        void1.setDataAndType(Uri.parse((new StringBuilder("file://")).append(PRO_DIR).append(File.separator).append("cleaner.apk").toString()), "application/vnd.android.package-archive");
                                        void1.addFlags(0x10000000);
                                        mContext.startActivity(void1);
                                    }

            
            {
                this$2 = _cls2.this;
                super();
            }
                                }).execute(new Void[0]);
                            }
                        }
                        dialog.dismiss();
                        return;
                        namenotfoundexception;
                        namenotfoundexception.printStackTrace();
                          goto _L1
                    }


            
            {
                this$1 = final__pcls1;
                dialog = CleanerUPDialog.this;
                super();
            }
                });
            }


            
            {
                this$0 = ScreenReceiver.this;
                super();
            }
        };
    }

    public void onReceive(Context context, Intent intent)
    {
        mContext = context;
        intent = intent.getAction();
        try
        {
            context.getPackageManager().getPackageInfo("com.evzapp.cleanmaster", 0);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
        }
        intent.equals("android.intent.action.SCREEN_OFF");
        intent.equals("android.intent.action.BATTERY_CHANGED");
    }





}
