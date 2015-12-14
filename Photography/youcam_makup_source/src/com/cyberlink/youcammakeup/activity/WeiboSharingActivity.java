// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.cyberlink.youcammakeup.BaseActivity;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.utility.cc;
import com.cyberlink.youcammakeup.widgetpool.dialogs.aa;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.api.share.BaseResponse;
import com.sina.weibo.sdk.api.share.IWeiboShareAPI;
import com.sina.weibo.sdk.api.share.SendMultiMessageToWeiboRequest;
import com.sina.weibo.sdk.api.share.WeiboShareSDK;
import java.io.File;

public class WeiboSharingActivity extends BaseActivity
    implements com.sina.weibo.sdk.api.share.IWeiboHandler.Response
{

    public static final String a = Globals.d().getResources().getString(0x7f070699);
    public static final String b = Globals.d().getResources().getString(0x7f07069a);
    private IWeiboShareAPI c;
    private File d;
    private String e;
    private Toast f;
    private boolean g;
    private String h;
    private boolean i;

    public WeiboSharingActivity()
    {
        g = false;
        i = false;
    }

    private void a(int i1)
    {
        if (f != null)
        {
            f.cancel();
        }
        f = Toast.makeText(this, i1, 0);
        f.setGravity(17, 0, 0);
        f.show();
    }

    private FrameLayout k()
    {
        FrameLayout framelayout = new FrameLayout(this);
        framelayout.setBackgroundColor(0);
        framelayout.setOnClickListener(new android.view.View.OnClickListener() {

            final WeiboSharingActivity a;

            public void onClick(View view)
            {
                a.finish();
            }

            
            {
                a = WeiboSharingActivity.this;
                super();
            }
        });
        return framelayout;
    }

    private void l()
    {
        Intent intent = getIntent();
        Object obj = intent.getExtras();
        if (obj != null)
        {
            String s = ((Bundle) (obj)).getString("mimeType");
            obj = ((Bundle) (obj)).getString("url");
            if (s != null && obj != null)
            {
                d = new File(((String) (obj)));
                e = s;
                h = intent.getStringExtra("unlock_key_id");
            }
        }
    }

    private boolean m()
    {
        NetworkInfo networkinfo = ((ConnectivityManager)getSystemService("connectivity")).getActiveNetworkInfo();
        if (networkinfo != null && networkinfo.isConnected())
        {
            return true;
        } else
        {
            a(0x7f070533);
            return false;
        }
    }

    private ImageObject n()
    {
        int j1 = 1600;
        if (d == null || !d.exists()) goto _L2; else goto _L1
_L1:
        ImageObject imageobject = new ImageObject();
        Bitmap bitmap;
        int i1;
        int k1;
        bitmap = ((BitmapDrawable)BitmapDrawable.createFromPath(d.getPath())).getBitmap();
        k1 = bitmap.getWidth();
        i1 = bitmap.getHeight();
        if (Math.max(k1, i1) <= 1600)
        {
            break MISSING_BLOCK_LABEL_183;
        }
        if (k1 <= i1) goto _L4; else goto _L3
_L3:
        i1 = (int)Math.floor((1600D / (double)k1) * (double)i1);
_L5:
        imageobject.setImageObject(Bitmap.createScaledBitmap(bitmap, Math.max(j1, 1), Math.max(i1, 1), true));
        return imageobject;
_L4:
        double d1 = Math.floor((1600D / (double)i1) * (double)k1);
        j1 = (int)d1;
        i1 = 1600;
          goto _L5
        OutOfMemoryError outofmemoryerror;
        outofmemoryerror;
        aa aa1 = new aa(this);
        aa1.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() {

            final WeiboSharingActivity a;

            public void onDismiss(DialogInterface dialoginterface)
            {
                a.finish();
            }

            
            {
                a = WeiboSharingActivity.this;
                super();
            }
        });
        aa1.show();
        i = true;
_L2:
        return null;
        j1 = k1;
          goto _L5
    }

    private TextObject o()
    {
        TextObject textobject = new TextObject();
        textobject.text = getString(0x7f07067a);
        return textobject;
    }

    public void j()
    {
        if (c.isWeiboAppSupportAPI() && c.getWeiboAppSupportAPI() >= 10351 && e != null)
        {
            WeiboMultiMessage weibomultimessage = new WeiboMultiMessage();
            weibomultimessage.textObject = o();
            if (e.equals("image/*"))
            {
                weibomultimessage.imageObject = n();
            }
            SendMultiMessageToWeiboRequest sendmultimessagetoweiborequest = new SendMultiMessageToWeiboRequest();
            sendmultimessagetoweiborequest.transaction = String.valueOf(System.currentTimeMillis());
            sendmultimessagetoweiborequest.multiMessage = weibomultimessage;
            if (!i)
            {
                c.sendRequest(this, sendmultimessagetoweiborequest);
                return;
            }
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(k(), new android.view.ViewGroup.LayoutParams(-1, -1));
        c = WeiboShareSDK.createWeiboAPI(this, a);
        if (bundle != null)
        {
            g = bundle.getBoolean("IS_SENT_TO_WEIBO");
            c.handleWeiboResponse(getIntent(), this);
        }
        if (g || !m())
        {
            finish();
            return;
        } else
        {
            l();
            j();
            g = true;
            return;
        }
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        c.handleWeiboResponse(intent, this);
    }

    public void onResponse(BaseResponse baseresponse)
    {
        baseresponse.errCode;
        JVM INSTR tableswitch 0 2: default 32
    //                   0 37
    //                   1 32
    //                   2 61;
           goto _L1 _L2 _L1 _L3
_L1:
        finish();
        return;
_L2:
        a(0x7f070695);
        if (h != null)
        {
            cc.c(h);
        }
        continue; /* Loop/switch isn't completed */
_L3:
        a(0x7f070694);
        if (true) goto _L1; else goto _L4
_L4:
    }

    protected void onRestart()
    {
        super.onRestart();
        finish();
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
        g = bundle.getBoolean("IS_SENT_TO_WEIBO");
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("IS_SENT_TO_WEIBO", g);
    }

}
