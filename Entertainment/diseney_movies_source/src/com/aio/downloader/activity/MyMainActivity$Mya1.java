// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.aio.downloader.db.TypeDbUtils;
import com.aio.downloader.dialog.WebFirstDialog;
import com.aio.downloader.mydownload.DownloadMovieItem;
import com.aio.downloader.mydownload.MyApplcation;
import com.aio.downloader.utils.NetWorkUtil;
import com.aio.downloader.utils.ProgressWheel;
import com.aio.downloader.utils.publicTools;
import com.umeng.analytics.MobclickAgent;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.aio.downloader.activity:
//            MyMainActivity

class this._cls0 extends AsyncTask
{

    final MyMainActivity this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient ArrayList doInBackground(Void avoid[])
    {
        String s = null;
        avoid = publicTools.getUrl(MyMainActivity.access$29(MyMainActivity.this));
label0:
        {
            s = avoid;
            if (avoid == null)
            {
                return null;
            }
            break label0;
        }
        avoid;
        MyMainActivity.access$30(MyMainActivity.this, new ArrayList());
        if (s == null) goto _L2; else goto _L1
_L1:
        avoid = new JSONObject(s);
        if (avoid.getInt("status") != 1) goto _L2; else goto _L3
_L3:
        MyMainActivity.access$31(MyMainActivity.this, new DownloadMovieItem());
        int i;
        int j;
        try
        {
            if (MyMainActivity.access$32(MyMainActivity.this) == 1 && !avoid.isNull("pdt"))
            {
                JSONObject jsonobject = avoid.getJSONObject("pdt");
                MyMainActivity.access$18(MyMainActivity.this).setId(jsonobject.getString("id"));
                MyMainActivity.access$18(MyMainActivity.this).setIcon(jsonobject.getString("icon"));
                MyMainActivity.access$18(MyMainActivity.this).setTitle(jsonobject.getString("title"));
                MyMainActivity.access$18(MyMainActivity.this).setAuthor_title(jsonobject.getString("author_title"));
                MyMainActivity.access$18(MyMainActivity.this).setShort_desc(jsonobject.getString("short_desc"));
                MyMainActivity.access$18(MyMainActivity.this).setRating(Float.valueOf(Float.parseFloat(jsonobject.getString("rating"))));
                MyMainActivity.access$18(MyMainActivity.this).setSerial(jsonobject.getInt("serial"));
                MyMainActivity.access$18(MyMainActivity.this).setHas_apk(jsonobject.getString("has_apk"));
                MyMainActivity.access$18(MyMainActivity.this).setIs_official(jsonobject.getString("is_official"));
            }
        }
        catch (Exception exception) { }
        avoid = avoid.getJSONArray("list");
        i = 0;
_L5:
        j = avoid.length();
        if (i < j) goto _L4; else goto _L2
_L2:
        return MyMainActivity.access$33(MyMainActivity.this);
_L4:
        DownloadMovieItem downloadmovieitem = new DownloadMovieItem();
        JSONObject jsonobject1 = avoid.getJSONObject(i);
        downloadmovieitem.setId(jsonobject1.getString("id"));
        downloadmovieitem.setSerial(jsonobject1.getInt("serial"));
        downloadmovieitem.setTitle(jsonobject1.getString("title"));
        downloadmovieitem.setAuthor_title(jsonobject1.getString("author_title"));
        downloadmovieitem.setIcon(jsonobject1.getString("icon"));
        downloadmovieitem.setSize(jsonobject1.getString("size"));
        downloadmovieitem.setRating(Float.valueOf(Float.parseFloat(jsonobject1.getString("rating"))));
        downloadmovieitem.setPrice(jsonobject1.getString("price"));
        downloadmovieitem.setHas_apk(jsonobject1.getString("has_apk"));
        downloadmovieitem.setIs_official(jsonobject1.getString("is_official"));
        MyMainActivity.access$33(MyMainActivity.this).add(downloadmovieitem);
        i++;
          goto _L5
        avoid;
        avoid.printStackTrace();
          goto _L2
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((ArrayList)obj);
    }

    protected void onPostExecute(ArrayList arraylist)
    {
        super.onPostExecute(arraylist);
        if (arraylist != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (MyMainActivity.access$32(MyMainActivity.this) != 1) goto _L1; else goto _L3
_L3:
        TextView textview;
        Button button;
        Button button1;
        final WebFirstDialog dialog1;
        MobclickAgent.onEvent(getApplicationContext(), "web_caller");
        dialog1 = new WebFirstDialog(MyMainActivity.this, 0x7f0c000e);
        dialog1.setCanceledOnTouchOutside(true);
        dialog1.show();
        arraylist = (ImageView)dialog1.findViewById(0x7f070369);
        textview = (TextView)dialog1.findViewById(0x7f070371);
        button = (Button)dialog1.findViewById(0x7f070376);
        button1 = (Button)dialog1.findViewById(0x7f070377);
        ((ImageView)dialog1.findViewById(0x7f070378)).setOnClickListener(new android.view.View.OnClickListener() {

            final MyMainActivity.Mya1 this$1;
            private final WebFirstDialog val$dialog1;

            public void onClick(View view)
            {
                dialog1.dismiss();
            }

            
            {
                this$1 = MyMainActivity.Mya1.this;
                dialog1 = webfirstdialog;
                super();
            }
        });
        ((CheckBox)dialog1.findViewById(0x7f070379)).setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final MyMainActivity.Mya1 this$1;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                if (flag)
                {
                    callerD = false;
                    return;
                } else
                {
                    callerD = true;
                    return;
                }
            }

            
            {
                this$1 = MyMainActivity.Mya1.this;
                super();
            }
        });
        button.setOnClickListener(new android.view.View.OnClickListener() {

            final MyMainActivity.Mya1 this$1;
            private final WebFirstDialog val$dialog1;

            public void onClick(View view)
            {
                if (MyMainActivity.access$4(this$0).getBoolean("isopen", false) && NetWorkUtil.getAPNType(this$0) != 1)
                {
                    MyMainActivity.access$5(this$0);
                    return;
                }
                if (MyMainActivity.access$6(this$0).queryfile(MyMainActivity.access$18(this$0).getId()) == null)
                {
                    MydownloadApk(MyMainActivity.access$18(this$0).getId(), MyMainActivity.access$18(this$0).getTitle(), MyMainActivity.access$18(this$0).getIcon(), MyMainActivity.access$18(this$0).getSerial());
                } else
                {
                    MyMainActivity.access$17(this$0);
                }
                if (callerD)
                {
                    if (MyMainActivity.access$6(this$0).queryfile("com.freepezzle.hexcrush") == null)
                    {
                        MobclickAgent.onEvent(getApplicationContext(), "web_caller_click");
                        MydownloadApk("com.freepezzle.hexcrush", "HEX Crush", "http://android.downloadatoz.com/_201409/img/hex512.png", 8964);
                    } else
                    {
                        MyMainActivity.access$17(this$0);
                    }
                }
                dialog1.dismiss();
            }

            
            {
                this$1 = MyMainActivity.Mya1.this;
                dialog1 = webfirstdialog;
                super();
            }
        });
        button1.setOnClickListener(new android.view.View.OnClickListener() {

            final MyMainActivity.Mya1 this$1;
            private final WebFirstDialog val$dialog1;

            public void onClick(View view)
            {
                view = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("https://play.google.com/store/apps/details?id=")).append(MyMainActivity.access$18(this$0).getId()).toString()));
                startActivity(view);
                dialog1.dismiss();
            }

            
            {
                this$1 = MyMainActivity.Mya1.this;
                dialog1 = webfirstdialog;
                super();
            }
        });
        dialog1 = MyMainActivity.access$18(MyMainActivity.this).getHas_apk();
        if (!dialog1.equals("1")) goto _L5; else goto _L4
_L4:
        button.setVisibility(0);
_L7:
        MyMainActivity.access$19(MyMainActivity.this).asyncLoadImage(MyMainActivity.access$18(MyMainActivity.this).getIcon(), arraylist);
        textview.setText(MyMainActivity.access$18(MyMainActivity.this).getTitle());
        return;
_L5:
        if (dialog1.equals("0"))
        {
            button1.setVisibility(0);
        }
        if (true) goto _L7; else goto _L6
_L6:
        arraylist;
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        MyMainActivity.access$13(MyMainActivity.this).setVisibility(0);
    }


    _cls4.val.dialog1()
    {
        this$0 = MyMainActivity.this;
        super();
    }
}
