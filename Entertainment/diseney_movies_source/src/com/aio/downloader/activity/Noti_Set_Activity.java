// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import com.aio.downloader.service.ServiceToggle;
import com.umeng.analytics.MobclickAgent;

public class Noti_Set_Activity extends Activity
{

    private CheckBox cb_battery_change;
    private CheckBox cb_battery_haodian;
    private CheckBox cb_battery_low;
    private CheckBox cb_clean_cpu;
    private CheckBox cb_clean_ram;
    private CheckBox cb_clean_slow;
    private CheckBox cb_clean_storage;
    private CheckBox cb_clean_temp;
    private ImageView noti_fan;
    private SharedPreferences userInfo;
    private SharedPreferences userInfo_b_change;
    private SharedPreferences userInfo_b_low;
    private SharedPreferences userInfo_cpu;
    private SharedPreferences userInfo_ram;
    private SharedPreferences userInfo_slow;
    private SharedPreferences userInfo_storage;
    private SharedPreferences userInfo_temp;

    public Noti_Set_Activity()
    {
    }

    private void click()
    {
        cb_battery_haodian.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final Noti_Set_Activity this$0;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                if (flag)
                {
                    userInfo.edit().putInt("wycdc", 0).commit();
                    return;
                } else
                {
                    userInfo.edit().putInt("wycdc", 1).commit();
                    return;
                }
            }

            
            {
                this$0 = Noti_Set_Activity.this;
                super();
            }
        });
        cb_battery_low.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final Noti_Set_Activity this$0;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                if (flag)
                {
                    userInfo_b_low.edit().putInt("b_low", 0).commit();
                    compoundbutton = new Intent("toggle_on");
                    sendBroadcast(compoundbutton);
                    return;
                } else
                {
                    userInfo_b_low.edit().putInt("b_low", 1).commit();
                    compoundbutton = new Intent("toggle_off");
                    sendBroadcast(compoundbutton);
                    return;
                }
            }

            
            {
                this$0 = Noti_Set_Activity.this;
                super();
            }
        });
        cb_battery_change.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final Noti_Set_Activity this$0;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                if (flag)
                {
                    userInfo_b_change.edit().putInt("wycupdate", 0).commit();
                    return;
                } else
                {
                    userInfo_b_change.edit().putInt("wycupdate", 1).commit();
                    return;
                }
            }

            
            {
                this$0 = Noti_Set_Activity.this;
                super();
            }
        });
        cb_clean_temp.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final Noti_Set_Activity this$0;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                if (flag)
                {
                    userInfo_temp.edit().putInt("b_temp", 0).commit();
                    return;
                } else
                {
                    userInfo_temp.edit().putInt("b_temp", 1).commit();
                    return;
                }
            }

            
            {
                this$0 = Noti_Set_Activity.this;
                super();
            }
        });
        cb_clean_ram.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final Noti_Set_Activity this$0;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                if (flag)
                {
                    userInfo_ram.edit().putInt("wycis", 0).commit();
                    return;
                } else
                {
                    userInfo_ram.edit().putInt("wycis", 1).commit();
                    return;
                }
            }

            
            {
                this$0 = Noti_Set_Activity.this;
                super();
            }
        });
        cb_clean_storage.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final Noti_Set_Activity this$0;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                if (flag)
                {
                    userInfo_storage.edit().putInt("wycand", 0).commit();
                    return;
                } else
                {
                    userInfo_storage.edit().putInt("wycand", 1).commit();
                    return;
                }
            }

            
            {
                this$0 = Noti_Set_Activity.this;
                super();
            }
        });
        cb_clean_slow.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final Noti_Set_Activity this$0;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                if (flag)
                {
                    userInfo_slow.edit().putInt("c_slow", 0).commit();
                    return;
                } else
                {
                    userInfo_slow.edit().putInt("c_slow", 1).commit();
                    return;
                }
            }

            
            {
                this$0 = Noti_Set_Activity.this;
                super();
            }
        });
        cb_clean_cpu.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final Noti_Set_Activity this$0;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                if (flag)
                {
                    userInfo_cpu.edit().putInt("c_cpu", 0).commit();
                    return;
                } else
                {
                    userInfo_cpu.edit().putInt("c_cpu", 1).commit();
                    return;
                }
            }

            
            {
                this$0 = Noti_Set_Activity.this;
                super();
            }
        });
    }

    private void init()
    {
        noti_fan = (ImageView)findViewById(0x7f070328);
        noti_fan.setOnClickListener(new android.view.View.OnClickListener() {

            final Noti_Set_Activity this$0;

            public void onClick(View view)
            {
                finish();
            }

            
            {
                this$0 = Noti_Set_Activity.this;
                super();
            }
        });
        cb_battery_low = (CheckBox)findViewById(0x7f070329);
        cb_battery_change = (CheckBox)findViewById(0x7f07032a);
        cb_battery_haodian = (CheckBox)findViewById(0x7f07032b);
        cb_clean_ram = (CheckBox)findViewById(0x7f07032c);
        cb_clean_storage = (CheckBox)findViewById(0x7f07032d);
        cb_clean_cpu = (CheckBox)findViewById(0x7f07032e);
        cb_clean_temp = (CheckBox)findViewById(0x7f07032f);
        cb_clean_slow = (CheckBox)findViewById(0x7f070330);
    }

    protected void onCreate(Bundle bundle)
    {
        int i;
        super.onCreate(bundle);
        setContentView(0x7f03008f);
        startService(new Intent(getApplicationContext(), com/aio/downloader/service/ServiceToggle));
        userInfo = getSharedPreferences("downloadcomplete", 0);
        userInfo_b_low = getSharedPreferences("battery_low", 0);
        userInfo_b_change = getSharedPreferences("app_update", 0);
        userInfo_ram = getSharedPreferences("install_success", 0);
        userInfo_storage = getSharedPreferences("appnotdownload", 0);
        userInfo_cpu = getSharedPreferences("clean_cpu", 0);
        userInfo_temp = getSharedPreferences("battery_temp", 0);
        userInfo_slow = getSharedPreferences("clean_slow", 0);
        init();
        click();
        i = getSharedPreferences("downloadcomplete", 0).getInt("wycdc", 0);
        if (i != 0) goto _L2; else goto _L1
_L1:
        cb_battery_haodian.setChecked(true);
_L8:
        int j;
        i = getSharedPreferences("battery_low", 0).getInt("b_low", 0);
        if (i == 0)
        {
            cb_battery_low.setChecked(true);
        } else
        if (i == 1)
        {
            cb_battery_low.setChecked(false);
        }
        i = getSharedPreferences("app_update", 0).getInt("wycupdate", 0);
        if (i == 0)
        {
            cb_battery_change.setChecked(true);
        } else
        if (i == 1)
        {
            cb_battery_change.setChecked(false);
        }
        i = getSharedPreferences("battery_temp", 0).getInt("b_temp", 0);
        if (i == 0)
        {
            cb_clean_temp.setChecked(true);
        } else
        if (i == 1)
        {
            cb_clean_temp.setChecked(false);
        }
        i = getSharedPreferences("install_success", 0).getInt("wycis", 0);
        if (i == 0)
        {
            cb_clean_ram.setChecked(true);
        } else
        if (i == 1)
        {
            cb_clean_ram.setChecked(false);
        }
        i = getSharedPreferences("appnotdownload", 0).getInt("wycand", 0);
        if (i == 0)
        {
            cb_clean_storage.setChecked(true);
        } else
        if (i == 1)
        {
            cb_clean_storage.setChecked(false);
        }
        i = getSharedPreferences("clean_slow", 0).getInt("c_slow", 0);
        if (i == 0)
        {
            cb_clean_slow.setChecked(true);
        } else
        if (i == 1)
        {
            cb_clean_slow.setChecked(false);
        }
        j = getSharedPreferences("clean_cpu", 0).getInt("c_cpu", 0);
        if (i != 0) goto _L4; else goto _L3
_L3:
        cb_clean_cpu.setChecked(true);
_L6:
        return;
_L2:
        if (i == 1)
        {
            cb_battery_haodian.setChecked(false);
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (j != 1) goto _L6; else goto _L5
_L5:
        cb_clean_cpu.setChecked(false);
        return;
        if (true) goto _L8; else goto _L7
_L7:
    }

    protected void onPause()
    {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    protected void onResume()
    {
        super.onResume();
        MobclickAgent.onResume(this);
    }








}
