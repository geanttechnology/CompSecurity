// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.cleaner;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class KaijishijianActivity extends Activity
{

    private File PRO_DIR;
    private int aiojiasu;
    private Button btn_cancel_kaiji;
    private Button btn_ok_kaiji;
    private int dabai;
    private ImageView iv_back_kaiji;
    private TextView kaiji_lala;
    private TextView kaiji_message;
    private TextView kaiji_shijan;
    private TextView kaiji_title;
    private int kaijishijian;

    public KaijishijianActivity()
    {
        kaijishijian = (int)(Math.random() * 20D + 20D);
        aiojiasu = (int)(Math.random() * 4D + 1.0D);
        dabai = (int)(Math.random() * 20D + 75D);
        PRO_DIR = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/cleaner").toString());
    }

    private File getAssetFile()
    {
        Object obj = getAssets();
        File file;
        PRO_DIR.mkdirs();
        obj = ((AssetManager) (obj)).open("cleaner.apk");
        file = new File(PRO_DIR, "cleaner.apk");
        FileOutputStream fileoutputstream;
        byte abyte0[];
        file.createNewFile();
        fileoutputstream = new FileOutputStream(file);
        abyte0 = new byte[1024];
_L1:
        int i = ((InputStream) (obj)).read(abyte0);
        if (i != -1)
        {
            break MISSING_BLOCK_LABEL_83;
        }
        fileoutputstream.flush();
        ((InputStream) (obj)).close();
        fileoutputstream.close();
        return file;
        fileoutputstream.write(abyte0, 0, i);
          goto _L1
        IOException ioexception;
        ioexception;
_L3:
        ioexception.printStackTrace();
        return null;
        ioexception;
        if (true) goto _L3; else goto _L2
_L2:
    }

    private void installApk()
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(Uri.parse((new StringBuilder("file://")).append(PRO_DIR).append(File.separator).append("cleaner.apk").toString()), "application/vnd.android.package-archive");
        startActivity(intent);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030064);
        kaiji_title = (TextView)findViewById(0x7f07025c);
        btn_cancel_kaiji = (Button)findViewById(0x7f070263);
        btn_ok_kaiji = (Button)findViewById(0x7f070264);
        kaiji_lala = (TextView)findViewById(0x7f070261);
        kaiji_shijan = (TextView)findViewById(0x7f07025d);
        kaiji_message = (TextView)findViewById(0x7f070260);
        iv_back_kaiji = (ImageView)findViewById(0x7f07025e);
        kaiji_shijan.setText((new StringBuilder(String.valueOf(kaijishijian))).append("s").toString());
        kaiji_message.setText(Html.fromHtml((new StringBuilder("Speed up by AIO Cleaner:<font color='#0AA3FA'><b>")).append(aiojiasu).append("s").append("</b></font>").toString()));
        iv_back_kaiji.setOnClickListener(new android.view.View.OnClickListener() {

            final KaijishijianActivity this$0;

            public void onClick(View view)
            {
                finish();
            }

            
            {
                this$0 = KaijishijianActivity.this;
                super();
            }
        });
        btn_cancel_kaiji.setOnClickListener(new android.view.View.OnClickListener() {

            final KaijishijianActivity this$0;

            public void onClick(View view)
            {
                finish();
            }

            
            {
                this$0 = KaijishijianActivity.this;
                super();
            }
        });
        btn_ok_kaiji.setOnClickListener(new android.view.View.OnClickListener() {

            final KaijishijianActivity this$0;

            public void onClick(View view)
            {
                view = null;
                android.content.pm.PackageInfo packageinfo = getPackageManager().getPackageInfo("com.evzapp.cleanmaster", 0);
                view = packageinfo;
_L1:
                android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
                if (view == null)
                {
                    installApk();
                } else
                {
                    view = getPackageManager().getLaunchIntentForPackage("com.evzapp.cleanmaster");
                    startActivity(view);
                }
                finish();
                return;
                namenotfoundexception;
                namenotfoundexception.printStackTrace();
                  goto _L1
            }

            
            {
                this$0 = KaijishijianActivity.this;
                super();
            }
        });
        kaiji_lala.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/Roboto-Light.ttf"));
        getAssetFile();
    }

}
