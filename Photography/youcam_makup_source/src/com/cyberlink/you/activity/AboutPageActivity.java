// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.cyberlink.you.BaseActivity;
import com.cyberlink.you.database.MessageObj;
import com.cyberlink.you.database.f;
import com.cyberlink.you.e;
import com.cyberlink.you.g;
import com.cyberlink.you.o;
import com.cyberlink.you.p;
import com.cyberlink.you.utility.d;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.apache.commons.io.FileUtils;

// Referenced classes of package com.cyberlink.you.activity:
//            LogBrowserActivity, ScrollTextViewActivity, SelectXmppServerActivity

public class AboutPageActivity extends BaseActivity
{

    private int a;
    private final String b = (new StringBuilder()).append(com.cyberlink.you.utility.d.a()).append("LICENSE.txt").toString();
    private android.view.View.OnClickListener c;
    private android.view.View.OnClickListener d;
    private android.view.View.OnClickListener e;
    private android.view.View.OnClickListener f;
    private android.view.View.OnClickListener g;
    private android.view.View.OnClickListener h;
    private android.view.View.OnClickListener i;
    private android.view.View.OnClickListener j;
    private android.view.View.OnClickListener k;
    private android.view.View.OnClickListener l;
    private android.view.View.OnClickListener m;
    private android.view.View.OnClickListener n;
    private android.view.View.OnClickListener o;
    private android.view.View.OnClickListener p;
    private android.view.View.OnClickListener q;
    private android.view.View.OnClickListener r;
    private android.view.View.OnClickListener s;
    private android.view.View.OnClickListener t;

    public AboutPageActivity()
    {
        a = 0;
        c = new android.view.View.OnClickListener() {

            final AboutPageActivity a;

            public void onClick(View view)
            {
                AboutPageActivity.a(a, false);
            }

            
            {
                a = AboutPageActivity.this;
                super();
            }
        };
        d = new android.view.View.OnClickListener() {

            final AboutPageActivity a;

            public void onClick(View view)
            {
                AboutPageActivity.a(a, true);
            }

            
            {
                a = AboutPageActivity.this;
                super();
            }
        };
        e = new android.view.View.OnClickListener() {

            final AboutPageActivity a;

            public void onClick(View view)
            {
                AboutPageActivity.a(a);
                if (AboutPageActivity.b(a) >= 10)
                {
                    AboutPageActivity.a(a, 0);
                    com.cyberlink.you.utility.d.a(AboutPageActivity.c(a), "Enable Debug Mode");
                    com.cyberlink.you.activity.AboutPageActivity.d(a);
                }
            }

            
            {
                a = AboutPageActivity.this;
                super();
            }
        };
        f = new android.view.View.OnClickListener() {

            final AboutPageActivity a;

            public void onClick(View view)
            {
                try
                {
                    view = new Intent("android.intent.action.VIEW");
                    File file = new File(com.cyberlink.you.activity.AboutPageActivity.e(a));
                    if (file.exists())
                    {
                        view.setDataAndType(Uri.fromFile(file), "text/plain");
                        a.startActivity(view);
                    }
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    view.printStackTrace();
                }
            }

            
            {
                a = AboutPageActivity.this;
                super();
            }
        };
        g = new android.view.View.OnClickListener() {

            final AboutPageActivity a;

            public void onClick(View view)
            {
                view = new Intent(AboutPageActivity.c(a), com/cyberlink/you/activity/LogBrowserActivity);
                view.putExtra("type", com.cyberlink.you.utility.ULogUtility.LogType.a.toString());
                a.startActivity(view);
            }

            
            {
                a = AboutPageActivity.this;
                super();
            }
        };
        h = new android.view.View.OnClickListener() {

            final AboutPageActivity a;

            public void onClick(View view)
            {
                view = new Intent(AboutPageActivity.c(a), com/cyberlink/you/activity/ScrollTextViewActivity);
                a.startActivity(view);
            }

            
            {
                a = AboutPageActivity.this;
                super();
            }
        };
        i = new android.view.View.OnClickListener() {

            final AboutPageActivity a;

            public void onClick(View view)
            {
                view = new Intent(AboutPageActivity.c(a), com/cyberlink/you/activity/LogBrowserActivity);
                view.putExtra("type", com.cyberlink.you.utility.ULogUtility.LogType.c.toString());
                a.startActivity(view);
            }

            
            {
                a = AboutPageActivity.this;
                super();
            }
        };
        j = new android.view.View.OnClickListener() {

            final AboutPageActivity a;

            public void onClick(View view)
            {
                view = new Intent(AboutPageActivity.c(a), com/cyberlink/you/activity/LogBrowserActivity);
                view.putExtra("type", com.cyberlink.you.utility.ULogUtility.LogType.h.toString());
                a.startActivity(view);
            }

            
            {
                a = AboutPageActivity.this;
                super();
            }
        };
        k = new android.view.View.OnClickListener() {

            final AboutPageActivity a;

            public void onClick(View view)
            {
                view = (new StringBuilder()).append(com.cyberlink.you.utility.d.d(com.cyberlink.you.d.a)).append("pht.sqlite").toString();
                String s1 = (new StringBuilder()).append("//data//data//").append(com.cyberlink.you.g.l()).append("//databases//").append("pht.sqlite").toString();
                try
                {
                    FileUtils.copyFile(new File(view), new File(s1));
                    view = com.cyberlink.you.e.d().a();
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    view.printStackTrace();
                    return;
                }
                if (view == null)
                {
                    break MISSING_BLOCK_LABEL_114;
                }
                com.cyberlink.you.g.a().a(view.d().getTime());
                com.cyberlink.you.g.a().a(view.d().getTime(), true);
                com.cyberlink.you.utility.d.a(AboutPageActivity.c(a), "[Debug] Please restart U!!!");
                return;
            }

            
            {
                a = AboutPageActivity.this;
                super();
            }
        };
        l = new android.view.View.OnClickListener() {

            final AboutPageActivity a;

            public void onClick(View view)
            {
                view = (new StringBuilder()).append("//data//data//").append(com.cyberlink.you.g.l()).append("//databases//").append("u.sqlite").toString();
                String s1 = (new StringBuilder()).append(com.cyberlink.you.utility.d.d(com.cyberlink.you.d.a)).append("u.sqlite").toString();
                try
                {
                    FileUtils.copyFile(new File(view), new File(s1));
                    MediaScannerConnection.scanFile(AboutPageActivity.c(a), new String[] {
                        s1
                    }, null, null);
                    Toast.makeText(a.getBaseContext(), (new StringBuilder()).append(view).append(" to ").append(s1).toString(), 1).show();
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    view.printStackTrace();
                }
            }

            
            {
                a = AboutPageActivity.this;
                super();
            }
        };
        m = new android.view.View.OnClickListener() {

            final AboutPageActivity a;

            public void onClick(View view)
            {
                view = new Intent(AboutPageActivity.c(a), com/cyberlink/you/activity/LogBrowserActivity);
                view.putExtra("type", com.cyberlink.you.utility.ULogUtility.LogType.d.toString());
                a.startActivity(view);
            }

            
            {
                a = AboutPageActivity.this;
                super();
            }
        };
        n = new android.view.View.OnClickListener() {

            final AboutPageActivity a;

            public void onClick(View view)
            {
                view = new Intent(AboutPageActivity.c(a), com/cyberlink/you/activity/LogBrowserActivity);
                view.putExtra("type", com.cyberlink.you.utility.ULogUtility.LogType.e.toString());
                a.startActivity(view);
            }

            
            {
                a = AboutPageActivity.this;
                super();
            }
        };
        o = new android.view.View.OnClickListener() {

            final AboutPageActivity a;

            public void onClick(View view)
            {
                view = new Intent(AboutPageActivity.c(a), com/cyberlink/you/activity/LogBrowserActivity);
                view.putExtra("type", com.cyberlink.you.utility.ULogUtility.LogType.f.toString());
                a.startActivity(view);
            }

            
            {
                a = AboutPageActivity.this;
                super();
            }
        };
        p = new android.view.View.OnClickListener() {

            final AboutPageActivity a;

            public void onClick(View view)
            {
                view = new Intent(AboutPageActivity.c(a), com/cyberlink/you/activity/LogBrowserActivity);
                view.putExtra("type", com.cyberlink.you.utility.ULogUtility.LogType.i.toString());
                a.startActivity(view);
            }

            
            {
                a = AboutPageActivity.this;
                super();
            }
        };
        q = new android.view.View.OnClickListener() {

            final AboutPageActivity a;

            public void onClick(View view)
            {
                view = new Intent(AboutPageActivity.c(a), com/cyberlink/you/activity/LogBrowserActivity);
                view.putExtra("type", com.cyberlink.you.utility.ULogUtility.LogType.g.toString());
                a.startActivity(view);
            }

            
            {
                a = AboutPageActivity.this;
                super();
            }
        };
        r = new android.view.View.OnClickListener() {

            final AboutPageActivity a;

            public void onClick(View view)
            {
                view = (new StringBuilder()).append("//data//data//").append(com.cyberlink.you.g.l()).append("//shared_prefs//").toString();
                String s1 = com.cyberlink.you.utility.d.d(com.cyberlink.you.d.a);
                try
                {
                    FileUtils.copyDirectoryToDirectory(new File(view), new File(s1));
                    Toast.makeText(a.getBaseContext(), (new StringBuilder()).append(view).append(" to ").append(s1).toString(), 1).show();
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    view.printStackTrace();
                }
            }

            
            {
                a = AboutPageActivity.this;
                super();
            }
        };
        s = new android.view.View.OnClickListener() {

            final AboutPageActivity a;

            public void onClick(View view)
            {
                view = new Intent(AboutPageActivity.c(a), com/cyberlink/you/activity/SelectXmppServerActivity);
                a.startActivity(view);
            }

            
            {
                a = AboutPageActivity.this;
                super();
            }
        };
        t = new android.view.View.OnClickListener() {

            final AboutPageActivity a;

            public void onClick(View view)
            {
                view = Toast.makeText(a.getBaseContext(), "Gathering data, please wait...", 1);
                view.show();
                com.cyberlink.you.utility.d.d(a.getApplicationContext());
                view.cancel();
                view = new File(com.cyberlink.you.utility.d.g());
                Intent intent = new Intent("android.intent.action.SEND");
                intent.putExtra("android.intent.extra.SUBJECT", "U log data").putExtra("android.intent.extra.TEXT", "Collected U log data in a zip file.").setType("application/zip").putExtra("android.intent.extra.STREAM", Uri.fromFile(view));
                a.startActivityForResult(Intent.createChooser(intent, "Send Email"), 1);
            }

            
            {
                a = AboutPageActivity.this;
                super();
            }
        };
    }

    static int a(AboutPageActivity aboutpageactivity)
    {
        int i1 = aboutpageactivity.a;
        aboutpageactivity.a = i1 + 1;
        return i1;
    }

    static int a(AboutPageActivity aboutpageactivity, int i1)
    {
        aboutpageactivity.a = i1;
        return i1;
    }

    private void a()
    {
        findViewById(o.AboutRevision).setVisibility(0);
        findViewById(o.AboutQueryMessageVersion).setVisibility(0);
        findViewById(o.AboutUserId).setVisibility(0);
        findViewById(o.AboutBaiduUserId).setVisibility(0);
        findViewById(o.AboutBaiduChannelId).setVisibility(0);
        findViewById(o.AboutXMPPLog).setVisibility(0);
        findViewById(o.AboutPingLog).setVisibility(0);
        findViewById(o.AboutGcmLog).setVisibility(0);
        findViewById(o.AboutImportDB).setVisibility(0);
        findViewById(o.AboutExportDB).setVisibility(0);
        findViewById(o.AboutSendPhotoLog).setVisibility(0);
        findViewById(o.AboutHeartbeatLog).setVisibility(0);
        findViewById(o.AboutNotificationLog).setVisibility(0);
        findViewById(o.AboutDbLog).setVisibility(0);
        findViewById(o.AboutVoiceCallLog).setVisibility(0);
        findViewById(o.AboutExportSharedPrefs).setVisibility(0);
        findViewById(o.AboutDebugModeSelectXmppServer).setVisibility(0);
        findViewById(o.AboutDebugModeSendData).setVisibility(0);
        findViewById(o.AboutUnreadCntLog).setVisibility(0);
    }

    static void a(AboutPageActivity aboutpageactivity, boolean flag)
    {
        aboutpageactivity.a(flag);
    }

    private void a(boolean flag)
    {
        Bundle bundle = new Bundle();
        bundle.putBoolean("isCloseParent", flag);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        setResult(-1, intent);
        finish();
    }

    static int b(AboutPageActivity aboutpageactivity)
    {
        return aboutpageactivity.a;
    }

    private Activity b()
    {
        return this;
    }

    static Activity c(AboutPageActivity aboutpageactivity)
    {
        return aboutpageactivity.b();
    }

    static void d(AboutPageActivity aboutpageactivity)
    {
        aboutpageactivity.a();
    }

    static String e(AboutPageActivity aboutpageactivity)
    {
        return aboutpageactivity.b;
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        if (i1 != 1);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(p.u_activity_about_page);
        findViewById(o.AboutPageCloseBtn).setOnClickListener(d);
        findViewById(o.AboutPageBackBtn).setOnClickListener(c);
        findViewById(o.AboutBackground).setOnClickListener(e);
        ((TextView)findViewById(o.AboutPageVersionTextView)).setText(com.cyberlink.you.g.o());
        ((TextView)findViewById(o.AboutRevisionTextView)).setText(com.cyberlink.you.g.p());
        ((TextView)findViewById(o.AboutQueryMessageVersionTextView)).setText(com.cyberlink.you.g.a().N());
        ((TextView)findViewById(o.AboutUserIdTextView)).setText(String.valueOf(com.cyberlink.you.g.a().g()));
        ((TextView)findViewById(o.AboutRevisionTextView)).setOnLongClickListener(new android.view.View.OnLongClickListener() {

            final AboutPageActivity a;

            public boolean onLongClick(View view)
            {
                view = new File((new StringBuilder()).append(com.cyberlink.you.utility.d.d(com.cyberlink.you.d.a)).append("debug").toString());
                if (view.exists())
                {
                    view.delete();
                    com.cyberlink.you.utility.d.a(AboutPageActivity.c(a), "Disable Advance Debug Mode");
                } else
                {
                    try
                    {
                        view.createNewFile();
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        view.printStackTrace();
                    }
                    com.cyberlink.you.utility.d.a(AboutPageActivity.c(a), "Enable Advance Debug Mode");
                }
                com.cyberlink.you.g.a().c();
                return true;
            }

            
            {
                a = AboutPageActivity.this;
                super();
            }
        });
        findViewById(o.AboutPageLegalNoticesArea).setOnClickListener(f);
        findViewById(o.AboutXMPPLog).setOnClickListener(g);
        findViewById(o.AboutPingLog).setOnClickListener(h);
        findViewById(o.AboutGcmLog).setOnClickListener(i);
        findViewById(o.AboutImportDB).setOnClickListener(k);
        findViewById(o.AboutExportDB).setOnClickListener(l);
        findViewById(o.AboutSendPhotoLog).setOnClickListener(m);
        findViewById(o.AboutHeartbeatLog).setOnClickListener(n);
        findViewById(o.AboutExportSharedPrefs).setOnClickListener(r);
        findViewById(o.AboutNotificationLog).setOnClickListener(o);
        findViewById(o.AboutDbLog).setOnClickListener(q);
        findViewById(o.AboutVoiceCallLog).setOnClickListener(j);
        findViewById(o.AboutUnreadCntLog).setOnClickListener(p);
        findViewById(o.AboutDebugModeSelectXmppServer).setOnClickListener(s);
        findViewById(o.AboutDebugModeSendData).setOnClickListener(t);
        a();
    }
}
