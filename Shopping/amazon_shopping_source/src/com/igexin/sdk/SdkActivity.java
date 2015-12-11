// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.igexin.sdk;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.ImageView;
import com.igexin.sdk.action.PushMessageAction;
import com.igexin.sdk.bean.ButtonBean;
import com.igexin.sdk.bean.PopupBean;
import com.igexin.sdk.bean.PushMessageBean;
import com.igexin.sdk.data.BasicDataManager;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

public class SdkActivity extends Activity
{

    private String action;
    private Dialog dialog;
    private boolean flag;
    private String messageId;
    private PopupBean popupBean;
    private PushMessageBean pushMessageBean;
    private int screenHeight;
    private int screenWidth;
    private String taskId;

    public SdkActivity()
    {
        flag = true;
    }

    private void doStopAction()
    {
        if (popupBean != null)
        {
            String s = popupBean.getDoActionId();
            if (!"".equals(s))
            {
                PushMessageAction.getInstance().executePushMessageAction(pushMessageBean, s);
            }
        }
    }

    private String getButtonText(String s)
    {
        String s1 = s;
        if (s.length() > 20)
        {
            s1 = (new StringBuilder()).append(s.substring(0, 18)).append("...").toString();
        }
        return s1;
    }

    private String getText(String s)
    {
        String s1 = s;
        if (s.length() > 256)
        {
            s1 = (new StringBuilder()).append(s.substring(0, 254)).append("...").toString();
        }
        return s1;
    }

    private void showDialog()
    {
        Object obj;
        android.app.AlertDialog.Builder builder;
        String s = popupBean.getTitle();
        String s1 = popupBean.getContent();
        obj = popupBean.getImg_src();
        builder = (new android.app.AlertDialog.Builder(this)).setTitle(s).setMessage(getText(s1));
        if (obj == null) goto _L2; else goto _L1
_L1:
        FileInputStream fileinputstream;
        Bitmap bitmap;
        ImageView imageview;
        imageview = new ImageView(this);
        bitmap = null;
        fileinputstream = null;
        obj = new FileInputStream(((String) (obj)));
        fileinputstream = ((FileInputStream) (obj));
_L3:
        if (fileinputstream != null)
        {
            bitmap = BitmapFactory.decodeStream(fileinputstream);
        }
        if (bitmap != null)
        {
            int i = bitmap.getWidth();
            int j = bitmap.getHeight();
            float f1 = 0.0F;
            double d = (350D * ((double)screenHeight / 800D)) / (double)j;
            double d1 = (350D * ((double)screenWidth / 480D)) / (double)i;
            float f;
            final ButtonBean button;
            FileNotFoundException filenotfoundexception;
            if (d >= 1.0D && d1 >= 1.0D)
            {
                f = 1.0F;
            } else
            if (d >= 1.0D && d1 < 1.0D)
            {
                f = (float)d1;
            } else
            if (d < 1.0D && d1 >= 1.0D)
            {
                f = (float)d;
            } else
            {
                f = f1;
                if (d < 1.0D)
                {
                    f = f1;
                    if (d1 < 1.0D)
                    {
                        if (d > d1)
                        {
                            f = (float)d1;
                        } else
                        {
                            f = (float)d;
                        }
                    }
                }
            }
            button = new Matrix();
            button.postScale(f, f);
            imageview.setImageBitmap(Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), button, true));
            imageview.setMaxHeight(0);
            imageview.setMinimumHeight(0);
            builder.setView(imageview);
        }
_L2:
        if (popupBean.getButtons() != null)
        {
            if (popupBean.getButtons().size() >= 1)
            {
                button = (ButtonBean)popupBean.getButtons().get(0);
                builder.setPositiveButton(getButtonText(button.getText()), new android.content.DialogInterface.OnClickListener() {

                    final SdkActivity this$0;
                    final ButtonBean val$button;

                    public void onClick(DialogInterface dialoginterface, int k)
                    {
                        PushMessageAction.getInstance().executePushMessageAction(pushMessageBean, button.getDoActionId());
                        flag = false;
                        finish();
                    }

            
            {
                this$0 = SdkActivity.this;
                button = buttonbean;
                super();
            }
                });
            }
            if (popupBean.getButtons().size() >= 2)
            {
                button = (ButtonBean)popupBean.getButtons().get(1);
                builder.setNeutralButton(getButtonText(button.getText()), new android.content.DialogInterface.OnClickListener() {

                    final SdkActivity this$0;
                    final ButtonBean val$button;

                    public void onClick(DialogInterface dialoginterface, int k)
                    {
                        PushMessageAction.getInstance().executePushMessageAction(pushMessageBean, button.getDoActionId());
                        flag = false;
                        finish();
                    }

            
            {
                this$0 = SdkActivity.this;
                button = buttonbean;
                super();
            }
                });
            }
            if (popupBean.getButtons().size() >= 3)
            {
                button = (ButtonBean)popupBean.getButtons().get(2);
                builder.setNegativeButton(getButtonText(button.getText()), new android.content.DialogInterface.OnClickListener() {

                    final SdkActivity this$0;
                    final ButtonBean val$button;

                    public void onClick(DialogInterface dialoginterface, int k)
                    {
                        PushMessageAction.getInstance().executePushMessageAction(pushMessageBean, button.getDoActionId());
                        flag = false;
                        finish();
                    }

            
            {
                this$0 = SdkActivity.this;
                button = buttonbean;
                super();
            }
                });
            }
        }
        dialog = builder.create();
        dialog.show();
        dialog.setOnKeyListener(new android.content.DialogInterface.OnKeyListener() {

            final SdkActivity this$0;

            public boolean onKey(DialogInterface dialoginterface, int k, KeyEvent keyevent)
            {
                switch (k)
                {
                default:
                    return true;

                case 4: // '\004'
                    dialoginterface.dismiss();
                    break;
                }
                finish();
                return true;
            }

            
            {
                this$0 = SdkActivity.this;
                super();
            }
        });
        return;
        filenotfoundexception;
        filenotfoundexception.printStackTrace();
          goto _L3
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        configuration = getResources().getDisplayMetrics();
        screenHeight = ((DisplayMetrics) (configuration)).heightPixels;
        screenWidth = ((DisplayMetrics) (configuration)).widthPixels;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(3);
        getWindow().setFeatureDrawableResource(3, 0x108009b);
        bundle = getResources().getDisplayMetrics();
        screenHeight = ((DisplayMetrics) (bundle)).heightPixels;
        screenWidth = ((DisplayMetrics) (bundle)).widthPixels;
        setRequestedOrientation(2);
    }

    public void onDestroy()
    {
        if (dialog != null)
        {
            dialog.dismiss();
        }
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 4)
        {
            doStopAction();
            return true;
        } else
        {
            return false;
        }
    }

    protected void onPause()
    {
        if (flag)
        {
            doStopAction();
        }
        super.onPause();
    }

    protected void onStart()
    {
        super.onStart();
        Object obj = getIntent();
        if (obj == null)
        {
            finish();
            return;
        }
        action = ((Intent) (obj)).getStringExtra("action");
        if ("popup".equals(action))
        {
            messageId = ((Intent) (obj)).getStringExtra("messageId");
            taskId = ((Intent) (obj)).getStringExtra("taskId");
            obj = PushMessageAction.getInstance().getPushMessageCacheId(taskId, messageId);
            pushMessageBean = (PushMessageBean)BasicDataManager.pushMessageMap.get(obj);
            popupBean = (PopupBean)pushMessageBean.getBean(pushMessageBean.getActionId());
            showDialog();
            return;
        } else
        {
            finish();
            return;
        }
    }



/*
    static boolean access$102(SdkActivity sdkactivity, boolean flag1)
    {
        sdkactivity.flag = flag1;
        return flag1;
    }

*/
}
