// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.Html;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.aio.downloader.model.Info;
import com.aio.downloader.views.RoundImageView;
import java.util.ArrayList;
import java.util.List;

public class Batterylow extends Dialog
{
    public static interface OnCustomDialogListener
    {

        public abstract void back(String s);
    }


    private Button batterycancel;
    private Context ctx;
    private List infos;
    private android.view.View.OnClickListener itemsOnClick;
    private RoundImageView iv_icon_ins1;
    private RoundImageView iv_icon_ins10;
    private RoundImageView iv_icon_ins2;
    private RoundImageView iv_icon_ins3;
    private RoundImageView iv_icon_ins4;
    private RoundImageView iv_icon_ins5;
    private RoundImageView iv_icon_ins6;
    private RoundImageView iv_icon_ins7;
    private RoundImageView iv_icon_ins8;
    private RoundImageView iv_icon_ins9;
    private RelativeLayout rl_battery_ok;
    private int size;
    private TextView tv_9apps;
    private TextView tv_battery_low_appname;

    public Batterylow(Context context, int i, android.view.View.OnClickListener onclicklistener)
    {
        super(context, i);
        infos = new ArrayList();
        ctx = context;
        itemsOnClick = onclicklistener;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030020);
        tv_battery_low_appname = (TextView)findViewById(0x7f070123);
        tv_9apps = (TextView)findViewById(0x7f070124);
        iv_icon_ins1 = (RoundImageView)findViewById(0x7f070125);
        iv_icon_ins2 = (RoundImageView)findViewById(0x7f070126);
        iv_icon_ins3 = (RoundImageView)findViewById(0x7f070127);
        iv_icon_ins4 = (RoundImageView)findViewById(0x7f070128);
        iv_icon_ins5 = (RoundImageView)findViewById(0x7f070129);
        iv_icon_ins6 = (RoundImageView)findViewById(0x7f07012a);
        iv_icon_ins7 = (RoundImageView)findViewById(0x7f07012b);
        iv_icon_ins8 = (RoundImageView)findViewById(0x7f07012c);
        iv_icon_ins9 = (RoundImageView)findViewById(0x7f07012d);
        iv_icon_ins10 = (RoundImageView)findViewById(0x7f07012e);
        batterycancel = (Button)findViewById(0x7f07012f);
        rl_battery_ok = (RelativeLayout)findViewById(0x7f070130);
        batterycancel.setOnClickListener(itemsOnClick);
        rl_battery_ok.setOnClickListener(itemsOnClick);
        tv_battery_low_appname.setText(Html.fromHtml("Fix to save <font color='#ff0000'>50%</font> power"));
        infos.clear();
        bundle = ctx.getPackageManager();
        List list = bundle.getInstalledApplications(8192);
        int i = 0;
        do
        {
            if (i >= list.size())
            {
                Object obj;
                if (infos.size() >= 70)
                {
                    size = infos.size() - 58;
                } else
                if (infos.size() > 60)
                {
                    size = infos.size() - 48;
                } else
                if (infos.size() > 50)
                {
                    size = infos.size() - 38;
                } else
                if (infos.size() > 40)
                {
                    size = infos.size() - 28;
                } else
                if (infos.size() > 30)
                {
                    size = infos.size() - 18;
                } else
                if (infos.size() > 20)
                {
                    size = infos.size() - 8;
                } else
                {
                    size = infos.size();
                }
                tv_9apps.setText(Html.fromHtml((new StringBuilder("<font color='#ff0000'>")).append(size).append("</font> Apps are killing your battery!").toString()));
                if (infos.size() >= 10)
                {
                    iv_icon_ins1.setBackgroundDrawable(((Info)infos.get(0)).getIcon());
                    iv_icon_ins2.setBackgroundDrawable(((Info)infos.get(1)).getIcon());
                    iv_icon_ins3.setBackgroundDrawable(((Info)infos.get(2)).getIcon());
                    iv_icon_ins4.setBackgroundDrawable(((Info)infos.get(3)).getIcon());
                    iv_icon_ins5.setBackgroundDrawable(((Info)infos.get(4)).getIcon());
                    iv_icon_ins6.setBackgroundDrawable(((Info)infos.get(5)).getIcon());
                    iv_icon_ins7.setBackgroundDrawable(((Info)infos.get(6)).getIcon());
                    iv_icon_ins8.setBackgroundDrawable(((Info)infos.get(7)).getIcon());
                    iv_icon_ins9.setBackgroundDrawable(((Info)infos.get(8)).getIcon());
                    iv_icon_ins10.setBackgroundDrawable(((Info)infos.get(9)).getIcon());
                    return;
                }
            } else
            {
                obj = (ApplicationInfo)list.get(i);
                if ((((ApplicationInfo)list.get(i)).flags & 1) == 0)
                {
                    obj = new Info();
                    ((Info) (obj)).setName(bundle.getApplicationLabel((ApplicationInfo)list.get(i)).toString());
                    ((Info) (obj)).setIcon(((ApplicationInfo)list.get(i)).loadIcon(bundle));
                    ((Info) (obj)).setPackagename(((ApplicationInfo)list.get(i)).packageName);
                    infos.add(obj);
                    if (((ApplicationInfo)list.get(i)).packageName.equals("com.allinone.free") && ((ApplicationInfo)list.get(i)).packageName.equals("com.aio.downloader"))
                    {
                        infos.remove(obj);
                    }
                }
                i++;
                continue;
            }
            if (infos.size() == 9)
            {
                iv_icon_ins1.setBackgroundDrawable(((Info)infos.get(0)).getIcon());
                iv_icon_ins2.setBackgroundDrawable(((Info)infos.get(1)).getIcon());
                iv_icon_ins3.setBackgroundDrawable(((Info)infos.get(2)).getIcon());
                iv_icon_ins4.setBackgroundDrawable(((Info)infos.get(3)).getIcon());
                iv_icon_ins5.setBackgroundDrawable(((Info)infos.get(4)).getIcon());
                iv_icon_ins6.setBackgroundDrawable(((Info)infos.get(5)).getIcon());
                iv_icon_ins7.setBackgroundDrawable(((Info)infos.get(6)).getIcon());
                iv_icon_ins8.setBackgroundDrawable(((Info)infos.get(7)).getIcon());
                iv_icon_ins9.setBackgroundDrawable(((Info)infos.get(8)).getIcon());
                iv_icon_ins10.setVisibility(8);
                return;
            }
            if (infos.size() == 8)
            {
                iv_icon_ins1.setBackgroundDrawable(((Info)infos.get(0)).getIcon());
                iv_icon_ins2.setBackgroundDrawable(((Info)infos.get(1)).getIcon());
                iv_icon_ins3.setBackgroundDrawable(((Info)infos.get(2)).getIcon());
                iv_icon_ins4.setBackgroundDrawable(((Info)infos.get(3)).getIcon());
                iv_icon_ins5.setBackgroundDrawable(((Info)infos.get(4)).getIcon());
                iv_icon_ins6.setBackgroundDrawable(((Info)infos.get(5)).getIcon());
                iv_icon_ins7.setBackgroundDrawable(((Info)infos.get(6)).getIcon());
                iv_icon_ins8.setBackgroundDrawable(((Info)infos.get(7)).getIcon());
                iv_icon_ins9.setVisibility(8);
                iv_icon_ins10.setVisibility(8);
                return;
            }
            if (infos.size() == 7)
            {
                iv_icon_ins1.setBackgroundDrawable(((Info)infos.get(0)).getIcon());
                iv_icon_ins2.setBackgroundDrawable(((Info)infos.get(1)).getIcon());
                iv_icon_ins3.setBackgroundDrawable(((Info)infos.get(2)).getIcon());
                iv_icon_ins4.setBackgroundDrawable(((Info)infos.get(3)).getIcon());
                iv_icon_ins5.setBackgroundDrawable(((Info)infos.get(4)).getIcon());
                iv_icon_ins6.setBackgroundDrawable(((Info)infos.get(5)).getIcon());
                iv_icon_ins7.setBackgroundDrawable(((Info)infos.get(6)).getIcon());
                iv_icon_ins8.setVisibility(8);
                iv_icon_ins9.setVisibility(8);
                iv_icon_ins10.setVisibility(8);
                return;
            }
            if (infos.size() == 6)
            {
                iv_icon_ins1.setBackgroundDrawable(((Info)infos.get(0)).getIcon());
                iv_icon_ins2.setBackgroundDrawable(((Info)infos.get(1)).getIcon());
                iv_icon_ins3.setBackgroundDrawable(((Info)infos.get(2)).getIcon());
                iv_icon_ins4.setBackgroundDrawable(((Info)infos.get(3)).getIcon());
                iv_icon_ins5.setBackgroundDrawable(((Info)infos.get(4)).getIcon());
                iv_icon_ins6.setBackgroundDrawable(((Info)infos.get(5)).getIcon());
                iv_icon_ins7.setVisibility(8);
                iv_icon_ins8.setVisibility(8);
                iv_icon_ins9.setVisibility(8);
                iv_icon_ins10.setVisibility(8);
                return;
            }
            if (infos.size() == 5)
            {
                iv_icon_ins1.setBackgroundDrawable(((Info)infos.get(0)).getIcon());
                iv_icon_ins2.setBackgroundDrawable(((Info)infos.get(1)).getIcon());
                iv_icon_ins3.setBackgroundDrawable(((Info)infos.get(2)).getIcon());
                iv_icon_ins4.setBackgroundDrawable(((Info)infos.get(3)).getIcon());
                iv_icon_ins5.setBackgroundDrawable(((Info)infos.get(4)).getIcon());
                iv_icon_ins6.setVisibility(8);
                iv_icon_ins7.setVisibility(8);
                iv_icon_ins8.setVisibility(8);
                iv_icon_ins9.setVisibility(8);
                iv_icon_ins10.setVisibility(8);
                return;
            }
            if (infos.size() == 4)
            {
                iv_icon_ins1.setBackgroundDrawable(((Info)infos.get(0)).getIcon());
                iv_icon_ins2.setBackgroundDrawable(((Info)infos.get(1)).getIcon());
                iv_icon_ins3.setBackgroundDrawable(((Info)infos.get(2)).getIcon());
                iv_icon_ins4.setBackgroundDrawable(((Info)infos.get(3)).getIcon());
                iv_icon_ins5.setVisibility(8);
                iv_icon_ins6.setVisibility(8);
                iv_icon_ins7.setVisibility(8);
                iv_icon_ins8.setVisibility(8);
                iv_icon_ins9.setVisibility(8);
                iv_icon_ins10.setVisibility(8);
                return;
            }
            if (infos.size() == 3)
            {
                iv_icon_ins1.setBackgroundDrawable(((Info)infos.get(0)).getIcon());
                iv_icon_ins2.setBackgroundDrawable(((Info)infos.get(1)).getIcon());
                iv_icon_ins3.setBackgroundDrawable(((Info)infos.get(2)).getIcon());
                iv_icon_ins4.setVisibility(8);
                iv_icon_ins5.setVisibility(8);
                iv_icon_ins6.setVisibility(8);
                iv_icon_ins7.setVisibility(8);
                iv_icon_ins8.setVisibility(8);
                iv_icon_ins9.setVisibility(8);
                iv_icon_ins10.setVisibility(8);
                return;
            }
            if (infos.size() == 2)
            {
                iv_icon_ins1.setBackgroundDrawable(((Info)infos.get(0)).getIcon());
                iv_icon_ins2.setBackgroundDrawable(((Info)infos.get(1)).getIcon());
                iv_icon_ins3.setVisibility(8);
                iv_icon_ins4.setVisibility(8);
                iv_icon_ins5.setVisibility(8);
                iv_icon_ins6.setVisibility(8);
                iv_icon_ins7.setVisibility(8);
                iv_icon_ins8.setVisibility(8);
                iv_icon_ins9.setVisibility(8);
                iv_icon_ins10.setVisibility(8);
                return;
            }
            if (infos.size() == 1)
            {
                iv_icon_ins1.setBackgroundDrawable(((Info)infos.get(0)).getIcon());
                iv_icon_ins2.setVisibility(8);
                iv_icon_ins3.setVisibility(8);
                iv_icon_ins4.setVisibility(8);
                iv_icon_ins5.setVisibility(8);
                iv_icon_ins6.setVisibility(8);
                iv_icon_ins7.setVisibility(8);
                iv_icon_ins8.setVisibility(8);
                iv_icon_ins9.setVisibility(8);
                iv_icon_ins10.setVisibility(8);
                return;
            }
            iv_icon_ins1.setVisibility(8);
            iv_icon_ins2.setVisibility(8);
            iv_icon_ins3.setVisibility(8);
            iv_icon_ins4.setVisibility(8);
            iv_icon_ins5.setVisibility(8);
            iv_icon_ins6.setVisibility(8);
            iv_icon_ins7.setVisibility(8);
            iv_icon_ins8.setVisibility(8);
            iv_icon_ins9.setVisibility(8);
            iv_icon_ins10.setVisibility(8);
            return;
        } while (true);
    }
}
