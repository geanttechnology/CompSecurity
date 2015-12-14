// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.common;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.open.a.k;
import com.tencent.open.utils.j;
import com.tencent.open.utils.m;
import com.tencent.tauth.b;
import com.tencent.tauth.d;
import org.json.JSONObject;

// Referenced classes of package com.tencent.connect.common:
//            a

public class AssistActivity extends Activity
{

    public static boolean a = false;
    public static boolean b = false;
    public static boolean c = false;
    private static a d;
    private a e;

    public AssistActivity()
    {
    }

    public static void a(Activity activity, Intent intent)
    {
        if (activity != null)
        {
label0:
            {
                if (intent == null)
                {
                    activity.setResult(10101, intent);
                    return;
                }
                try
                {
                    String s = intent.getStringExtra("key_response");
                    k.b("AssistActivity", (new StringBuilder()).append("AssistActivity--setResultDataForLogin-- ").append(s).toString());
                    if (!TextUtils.isEmpty(s))
                    {
                        Object obj = new JSONObject(s);
                        s = ((JSONObject) (obj)).optString("openid");
                        obj = ((JSONObject) (obj)).optString("access_token");
                        if (!TextUtils.isEmpty(s) && !TextUtils.isEmpty(((CharSequence) (obj))))
                        {
                            activity.setResult(10101, intent);
                            return;
                        }
                        break label0;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (Activity activity)
                {
                    activity.printStackTrace();
                    return;
                }
            }
        }
        return;
        activity.setResult(12345, intent);
        return;
    }

    private void a(Bundle bundle)
    {
        String s1 = bundle.getString("viaShareType");
        Object obj = bundle.getString("callbackAction");
        String s3 = bundle.getString("url");
        String s2 = bundle.getString("openId");
        String s4 = bundle.getString("appId");
        bundle = "";
        String s = "";
        if ("shareToQQ".equals(obj))
        {
            bundle = "ANDROIDQQ.SHARETOQQ.XX";
            s = "10";
        } else
        if ("shareToQzone".equals(obj))
        {
            bundle = "ANDROIDQQ.SHARETOQZ.XX";
            s = "11";
        }
        if (!m.a(this, s3))
        {
            obj = (b)j.a(((String) (obj)));
            if (obj != null)
            {
                ((b) (obj)).a(new d(-6, "\u6253\u5F00\u6D4F\u89C8\u5668\u5931\u8D25!", null));
            }
            com.tencent.open.b.d.a().a(s2, s4, bundle, s, "3", "1", s1, "0", "2", "0");
            finish();
        } else
        {
            com.tencent.open.b.d.a().a(s2, s4, bundle, s, "3", "0", s1, "0", "2", "0");
        }
        getIntent().removeExtra("shareH5");
    }

    public static void a(a a1)
    {
        d = a1;
    }

    protected void onActivityResult(int i, int l, Intent intent)
    {
        k.b("AssistActivity", (new StringBuilder()).append("AssistActivity--onActivityResult--").append(l).append(" data=").append(intent).toString());
        k.b("AssistActivity", (new StringBuilder()).append("--requestCode: ").append(i).append(" | resultCode: ").append(l).append(" | data: ").append(intent).toString());
        super.onActivityResult(i, l, intent);
        if (i == 0)
        {
            if (!isFinishing())
            {
                finish();
            }
            return;
        }
        if (intent != null)
        {
            intent.putExtra("key_action", "action_login");
        }
        if (e != null)
        {
            k.b("AssistActivity", "AssistActivity--onActivityResult-- mAPiObject != null");
            e.a(this, i, l, intent);
        } else
        {
            k.b("AssistActivity", "AssistActivity--onActivityResult-- mAPiObject == null");
            a(this, intent);
        }
        finish();
    }

    protected void onCreate(Bundle bundle)
    {
        boolean flag = false;
        super.onCreate(bundle);
        requestWindowFeature(1);
        k.b("AssistActivity", "AssistActivity--onCreate--");
        if (d != null)
        {
            e = d;
            d = null;
            Intent intent = e.b();
            Bundle bundle1;
            int i;
            if (intent == null)
            {
                i = 0;
            } else
            {
                i = intent.getIntExtra("key_request_code", 0);
            }
            bundle1 = getIntent().getBundleExtra("h5_share_data");
            if (bundle != null)
            {
                flag = bundle.getBoolean("RESTART_FLAG");
            }
            if (!flag)
            {
                if (bundle1 == null)
                {
                    startActivityForResult(intent, i);
                    return;
                } else
                {
                    a(bundle1);
                    return;
                }
            }
        }
    }

    protected void onDestroy()
    {
        k.b("AssistActivity", "-->onDestroy");
        super.onDestroy();
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        Object obj = j.a(intent.getStringExtra("action"));
        StringBuilder stringbuilder = (new StringBuilder()).append("AssistActivity--onNewIntent--");
        String s;
        if (obj == null)
        {
            s = "mAPiObject = null";
        } else
        {
            s = "mAPiObject != null";
        }
        k.b("AssistActivity", stringbuilder.append(s).toString());
        intent.putExtra("key_action", "action_share");
        if (obj != null)
        {
            com.tencent.connect.common.a.a(intent, (b)obj);
        } else
        {
            setResult(-1, intent);
        }
        if (!isFinishing())
        {
            finish();
        }
    }

    protected void onPause()
    {
        k.b("AssistActivity", "-->onPause");
        super.onPause();
    }

    protected void onResume()
    {
        k.b("AssistActivity", "-->onResume");
        super.onResume();
        Intent intent = getIntent();
        if (!intent.getBooleanExtra("is_login", false))
        {
            if (!intent.getBooleanExtra("is_qq_mobile_share", false))
            {
                if (!b && !isFinishing())
                {
                    finish();
                }
                b = false;
            }
            if (c)
            {
                c = false;
                return;
            }
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        k.b("AssistActivity", "AssistActivity--onSaveInstanceState--");
        bundle.putBoolean("RESTART_FLAG", true);
        super.onSaveInstanceState(bundle);
    }

    protected void onStart()
    {
        k.b("AssistActivity", "-->onStart");
        super.onStart();
    }

    protected void onStop()
    {
        k.b("AssistActivity", "-->onStop");
        super.onStop();
    }

}
