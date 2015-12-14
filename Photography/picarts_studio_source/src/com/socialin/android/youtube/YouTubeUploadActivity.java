// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.youtube;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.socialin.android.d;
import com.socialin.android.dialog.g;
import com.socialin.android.oauth2.OAuth2BaseActivity;
import com.socialin.android.oauth2.a;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import myobfuscated.f.m;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.youtube:
//            a

public class YouTubeUploadActivity extends AppCompatActivity
{

    private static final String a = com/socialin/android/youtube/YouTubeUploadActivity.getSimpleName();
    private static final String b[] = {
        "private", "public", "unlisted"
    };
    private static final int c[] = {
        500, 502, 503, 504
    };
    private g d;
    private SharedPreferences e;
    private EditText f;
    private EditText g;
    private EditText h;
    private Spinner i;
    private String j;
    private File k;
    private JSONObject l;

    public YouTubeUploadActivity()
    {
        d = null;
        e = null;
        j = "";
    }

    private Boolean a(HttpClient httpclient, String s, String s1)
    {
        Object obj;
        int i1 = (int)k.length();
        byte abyte0[] = new byte[i1];
        DefaultHttpClient defaulthttpclient;
        HttpResponse httpresponse;
        long l1;
        long l2;
        try
        {
            BufferedInputStream bufferedinputstream = new BufferedInputStream(new FileInputStream(k));
            bufferedinputstream.read(abyte0, 0, i1);
            bufferedinputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            com.socialin.android.d.b(a, "resumeUpload", ((Throwable) (obj)));
        }
        httpclient.getConnectionManager().shutdown();
        obj = new DefaultHttpClient();
        httpclient = new HttpPut(s1);
        httpclient.addHeader(new BasicHeader("Authorization", (new StringBuilder("Bearer ")).append(s).toString()));
        httpclient.addHeader(new BasicHeader("Content-Range", (new StringBuilder("bytes */")).append(k.length()).toString()));
        httpresponse = ((HttpClient) (obj)).execute(httpclient);
        if (httpresponse.getStatusLine().getStatusCode() != 308)
        {
            break MISSING_BLOCK_LABEL_493;
        }
        l1 = Long.parseLong(httpresponse.getLastHeader("Range").getValue().split("-")[1]);
        httpclient = Arrays.copyOfRange(abyte0, (int)(1L + l1), i1);
        if (httpresponse.containsHeader("Retry-After") && Long.parseLong(httpresponse.getLastHeader("Retry-After").getValue()) <= 10L)
        {
            Thread.sleep(Long.parseLong(httpresponse.getLastHeader("Retry-After").getValue()) * 1000L);
        }
        ((HttpClient) (obj)).getConnectionManager().shutdown();
        defaulthttpclient = new DefaultHttpClient();
        s1 = new HttpPut(s1);
        l2 = (k.length() - 1L) / k.length();
        s1.addHeader(new BasicHeader("Content-Range", (new StringBuilder("bytes */")).append(l1 - l2).toString()));
        s1.addHeader(new BasicHeader("Authorization", (new StringBuilder("Bearer ")).append(s).toString()));
        s1.setEntity(new ByteArrayEntity(httpclient));
        httpclient = defaulthttpclient.execute(s1);
        defaulthttpclient.getConnectionManager().shutdown();
        boolean flag;
        if (httpclient.getStatusLine().getStatusCode() != 200 && httpclient.getStatusLine().getStatusCode() != 201)
        {
            flag = false;
        } else
        {
            flag = true;
        }
        ((HttpClient) (obj)).getConnectionManager().shutdown();
        return Boolean.valueOf(flag);
        ((HttpClient) (obj)).getConnectionManager().shutdown();
        return Boolean.valueOf(false);
        httpclient;
_L2:
        com.socialin.android.d.b(a, (new StringBuilder("Got unexpected exception: ")).append(httpclient.getMessage()).toString(), httpclient);
        ((HttpClient) (obj)).getConnectionManager().shutdown();
        return Boolean.valueOf(false);
        httpclient;
        ((HttpClient) (obj)).getConnectionManager().shutdown();
        throw httpclient;
        httpclient;
        continue; /* Loop/switch isn't completed */
        httpclient;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private String a()
    {
        Intent intent = getIntent();
        Object obj = null;
        String s = obj;
        if (intent != null)
        {
            s = obj;
            if (intent.hasExtra("fileUri"))
            {
                s = intent.getStringExtra("fileUri");
            }
        }
        return s;
    }

    private JSONObject a(String s, String s1, String s2)
    {
        JSONObject jsonobject = new JSONObject();
        JSONObject jsonobject1 = new JSONObject();
        try
        {
            jsonobject1.put("title", s);
            jsonobject1.put("description", s1);
            jsonobject1.put("tags", (new StringBuilder()).append(s2).append(", PicsArt").toString());
            jsonobject1.put("categoryId", 22);
            s = new JSONObject();
            s.put("privacyStatus", j);
            s.put("embeddable", true);
            s.put("license", "youtube");
            jsonobject.put("snippet", jsonobject1);
            jsonobject.put("status", s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.socialin.android.d.b(a, "prepareRequestJson", s);
            return jsonobject;
        }
        return jsonobject;
    }

    static void a(YouTubeUploadActivity youtubeuploadactivity)
    {
        DefaultHttpClient defaulthttpclient;
        long l1;
        defaulthttpclient = new DefaultHttpClient();
        youtubeuploadactivity.k = new File(youtubeuploadactivity.a());
        l1 = youtubeuploadactivity.k.length();
        String s;
        Object obj1;
        s = youtubeuploadactivity.e.getString("oauth2AccessToken", null);
        obj1 = new HttpPost("https://www.googleapis.com/upload/youtube/v3/videos?uploadType=resumable&part=snippet,status,contentDetails");
        ((HttpPost) (obj1)).addHeader(new BasicHeader("Authorization", (new StringBuilder("Bearer ")).append(s).toString()));
        ((HttpPost) (obj1)).addHeader(new BasicHeader("X-Upload-Content-Length", String.valueOf(l1)));
        ((HttpPost) (obj1)).addHeader(new BasicHeader("X-Upload-Content-Type", "video/*"));
        StringEntity stringentity = new StringEntity(youtubeuploadactivity.l.toString());
        stringentity.setContentType("application/json; charset=UTF-8");
        stringentity.setContentEncoding(new BasicHeader("Content-Type", "application/json; charset=UTF-8"));
        ((HttpPost) (obj1)).setEntity(stringentity);
        obj1 = defaulthttpclient.execute(((org.apache.http.client.methods.HttpUriRequest) (obj1)));
        if (((HttpResponse) (obj1)).getStatusLine().getStatusCode() != 200) goto _L2; else goto _L1
_L1:
        DefaultHttpClient defaulthttpclient1;
        int i1;
        obj1 = ((HttpResponse) (obj1)).getLastHeader("Location").getValue();
        defaulthttpclient.getConnectionManager().shutdown();
        defaulthttpclient1 = new DefaultHttpClient();
        HttpPut httpput = new HttpPut(((String) (obj1)));
        httpput.addHeader(new BasicHeader("Authorization", (new StringBuilder("Bearer ")).append(s).toString()));
        httpput.setEntity(new FileEntity(youtubeuploadactivity.k, "video/*"));
        i1 = defaulthttpclient1.execute(httpput).getStatusLine().getStatusCode();
        if (i1 != 200 && i1 != 201) goto _L4; else goto _L3
_L3:
        youtubeuploadactivity.a(((HttpClient) (defaulthttpclient1)), youtubeuploadactivity.getString(0x7f080684));
_L2:
        youtubeuploadactivity.a(((HttpClient) (defaulthttpclient)), null);
        return;
_L4:
        if (!Arrays.asList(new int[][] {
    c
}).contains(Integer.valueOf(i1)))
        {
            break MISSING_BLOCK_LABEL_421;
        }
        if (youtubeuploadactivity.a(((HttpClient) (defaulthttpclient1)), s, ((String) (obj1))).booleanValue())
        {
            youtubeuploadactivity.a(((HttpClient) (defaulthttpclient1)), youtubeuploadactivity.getString(0x7f080684));
        }
          goto _L2
        Object obj;
        obj;
        com.socialin.android.d.b(a, "uploadVideo", ((Throwable) (obj)));
        youtubeuploadactivity.a(((HttpClient) (defaulthttpclient)), null);
        return;
        youtubeuploadactivity.a(((HttpClient) (defaulthttpclient1)), youtubeuploadactivity.getString(0x7f080683));
          goto _L2
        obj;
        youtubeuploadactivity.a(((HttpClient) (defaulthttpclient)), null);
        throw obj;
    }

    private void a(HttpClient httpclient, String s)
    {
        httpclient.getConnectionManager().shutdown();
        m.b(this, d);
        if (!TextUtils.isEmpty(s))
        {
            (new com.socialin.android.youtube.a(this, (byte)0)).execute(new String[] {
                s
            });
        }
        finish();
    }

    public void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        if (i1 == 325)
        {
            if (j1 == 326)
            {
                com.socialin.android.oauth2.a.a(intent, e);
                m.a(this, d);
                (new Thread(new Runnable() {

                    private YouTubeUploadActivity a;

                    public final void run()
                    {
                        com.socialin.android.youtube.YouTubeUploadActivity.a(a);
                    }

            
            {
                a = YouTubeUploadActivity.this;
                super();
            }
                })).start();
            } else
            if (j1 == 327)
            {
                Toast.makeText(this, intent.getStringExtra("oauth2FailedErrorDesc"), 1).show();
                return;
            }
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03026c);
        f = (EditText)findViewById(0x7f100ade);
        g = (EditText)findViewById(0x7f100adf);
        h = (EditText)findViewById(0x7f100ae1);
        i = (Spinner)findViewById(0x7f100ae0);
        e = getSharedPreferences("YouTubePrefs", 0);
        k = new File(a());
        bundle = getSupportActionBar();
        bundle.setDisplayHomeAsUpEnabled(true);
        bundle.setIcon(getResources().getDrawable(0x7f020420));
        bundle.setTitle(getResources().getString(0x7f080375));
        bundle = new ArrayAdapter(this, 0x7f03023a, b);
        bundle.setDropDownViewResource(0x7f03023a);
        i.setAdapter(bundle);
        i.setSelection(1);
        f.setText(getString(0x7f080686));
        h.setText("SpeedDrawing, TimeLapse");
        d = new g(this);
        d.setMessage(getString(0x7f080483));
        d.setCancelable(true);
        d.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            private YouTubeUploadActivity a;

            public final void onCancel(DialogInterface dialoginterface)
            {
                a.setResult(1);
                a.finish();
            }

            
            {
                a = YouTubeUploadActivity.this;
                super();
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuItemCompat.setShowAsAction(menu.add(0, 2, 0, getResources().getString(0x7f080367)), 2);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 2)
        {
            String s = f.getText().toString();
            String s1 = g.getText().toString();
            String s2 = h.getText().toString();
            j = i.getSelectedItem().toString();
            l = a(s, s1, s2);
            if (s.length() == 0)
            {
                Toast.makeText(this, getString(0x7f080231), 0).show();
            } else
            {
                Intent intent = new Intent(this, com/socialin/android/oauth2/OAuth2BaseActivity);
                intent.putExtra("oauth2AuthorizationEndpoint", "https://accounts.google.com/o/oauth2/auth");
                intent.putExtra("oauth2AccessTokenEndpoint", "https://accounts.google.com/o/oauth2/token");
                intent.putExtra("oauth2ClientId", "1076413845392-jklrhjo0vlh6ac7l9esc70gun7m83l6f.apps.googleusercontent.com");
                intent.putExtra("oauth2UsePostRequest", true);
                intent.putExtra("oauth2scope", "https://www.googleapis.com/auth/youtube.upload");
                intent.putExtra("oauth2RedirectUrl", "https://localhost");
                intent.putExtra("oauth2SocialKey", 5);
                startActivityForResult(intent, 325);
            }
        }
        if (menuitem.getItemId() == 0x102002c)
        {
            finish();
        }
        return super.onOptionsItemSelected(menuitem);
    }

}
