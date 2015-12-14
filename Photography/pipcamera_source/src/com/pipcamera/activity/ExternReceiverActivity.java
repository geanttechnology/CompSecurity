// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.crashlytics.android.Crashlytics;
import com.flurry.android.FlurryAgent;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.modelmsg.WXWebpageObject;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import ky;
import kz;
import oc;
import od;
import oe;
import of;

// Referenced classes of package com.pipcamera.activity:
//            FullscreenActivity

public class ExternReceiverActivity extends FullscreenActivity
{

    private IWXAPI a;

    public ExternReceiverActivity()
    {
    }

    static void a(ExternReceiverActivity externreceiveractivity, String s, String s1, String s2, Bitmap bitmap, boolean flag)
    {
        externreceiveractivity.a(s, s1, s2, bitmap, flag);
    }

    private void a(String s)
    {
        String s2;
        String s3;
        s = Uri.parse(s);
        s2 = s.getQueryParameter("type");
        s3 = s.getQueryParameter("shareway");
        s = s.getQueryParameter("message");
        String s1 = URLDecoder.decode(s, "UTF-8");
        s = s1;
_L1:
        if (s2 != null && s2.compareTo("share") == 0)
        {
            if (s3 != null && s3.compareTo("all") == 0)
            {
                boolean flag2 = oe.a(this);
                boolean flag3 = oe.b(this);
                boolean flag4 = oe.d(this);
                boolean flag5 = oe.c(this);
                Object obj = new of(this);
                boolean flag1 = false;
                boolean flag = flag1;
                if (((of) (obj)).b())
                {
                    flag = flag1;
                    if (((of) (obj)).a())
                    {
                        flag = true;
                    }
                }
                if (flag2)
                {
                    oe.a(this, s);
                    FlurryAgent.logEvent("Ex_Sina");
                } else
                if (flag3)
                {
                    oe.b(this, s);
                    FlurryAgent.logEvent("Ex_QWeibo");
                } else
                if (flag4)
                {
                    oe.d(this, s);
                    FlurryAgent.logEvent("Ex_QZone");
                } else
                if (flag5)
                {
                    oe.c(this, s);
                    FlurryAgent.logEvent("Ex_Renren");
                } else
                if (flag)
                {
                    ((of) (obj)).b(s);
                    FlurryAgent.logEvent("Ex_Moment");
                }
            } else
            {
                if (s3 != null && s3.compareTo("sina") == 0)
                {
                    oe.a(this, s);
                    FlurryAgent.logEvent("Ex_Sina");
                }
                if (s3 != null && s3.compareTo("qqWeibo") == 0)
                {
                    oe.b(this, s);
                    FlurryAgent.logEvent("Ex_QWeibo");
                }
                if (s3 != null && s3.compareTo("moment") == 0)
                {
                    (new of(this)).b(s);
                    FlurryAgent.logEvent("Ex_Moment");
                }
            }
        }
        finish();
        return;
        obj;
        ((UnsupportedEncodingException) (obj)).printStackTrace();
        Crashlytics.logException(((Throwable) (obj)));
          goto _L1
    }

    private void a(String s, String s1, String s2)
    {
        if (s != null)
        {
            Bitmap bitmap = (new ky()).a(this, s, new kz(s1, s2) {

                final String a;
                final String b;
                final ExternReceiverActivity c;

                public void a(Bitmap bitmap1)
                {
                    String s4 = a;
                    String s3 = s4;
                    if (b != null)
                    {
                        s3 = (new StringBuilder()).append(s4).append(" ").append(b).toString();
                    }
                    oc.e(c, bitmap1, null, null, s3, new od(this) {

                        final _cls1 a;

                        public void a(boolean flag, boolean flag1)
                        {
                            a.c.finish();
                        }

            
            {
                a = _pcls1;
                super();
            }
                    });
                }

                public void a(Exception exception)
                {
                    String s3 = a;
                    exception = s3;
                    if (b != null)
                    {
                        exception = (new StringBuilder()).append(s3).append(" ").append(b).toString();
                    }
                    oe.a(c, exception);
                    c.finish();
                }

            
            {
                c = ExternReceiverActivity.this;
                a = s;
                b = s1;
                super();
            }
            });
            if (bitmap != null)
            {
                if (s2 != null)
                {
                    s = (new StringBuilder()).append(s1).append(" ").append(s2).toString();
                } else
                {
                    s = s1;
                }
                oc.e(this, bitmap, null, null, s, new od() {

                    final ExternReceiverActivity a;

                    public void a(boolean flag, boolean flag1)
                    {
                        a.finish();
                    }

            
            {
                a = ExternReceiverActivity.this;
                super();
            }
                });
            }
            return;
        }
        s = s1;
        if (s2 != null)
        {
            s = (new StringBuilder()).append(s1).append(" ").append(s2).toString();
        }
        oe.a(this, s);
        finish();
    }

    private void a(String s, String s1, String s2, Bitmap bitmap, boolean flag)
    {
        int i = 1;
        a = WXAPIFactory.createWXAPI(this, "wx236dd568f82c78c2");
        WXWebpageObject wxwebpageobject = new WXWebpageObject();
        wxwebpageobject.webpageUrl = s;
        s = new WXMediaMessage(wxwebpageobject);
        s.title = s1;
        s.description = s2;
        if (bitmap != null)
        {
            s.thumbData = a(bitmap, true);
        }
        s1 = new com.tencent.mm.sdk.modelmsg.SendMessageToWX.Req();
        s1.transaction = c("webpage");
        s1.message = s;
        if (!flag)
        {
            i = 0;
        }
        s1.scene = i;
        a.sendReq(s1);
    }

    private void a(String s, String s1, String s2, String s3, String s4, String s5)
    {
        if (s4 == null)
        {
            s = " ";
        } else
        {
            s = s4;
        }
        if (s5 == null)
        {
            s4 = " ";
        } else
        {
            s4 = s5;
        }
        if (s3 != null || s2 != null) goto _L2; else goto _L1
_L1:
        (new of(this)).b(s1);
_L4:
        return;
_L2:
        if (s3 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        s1 = (new ky()).a(this, s3, new kz(s2, s, s4) {

            final String a;
            final String b;
            final String c;
            final ExternReceiverActivity d;

            public void a(Bitmap bitmap)
            {
                ExternReceiverActivity.a(d, a, b, c, bitmap, true);
                d.finish();
            }

            public void a(Exception exception)
            {
                ExternReceiverActivity.a(d, a, b, c, null, true);
                d.finish();
            }

            
            {
                d = ExternReceiverActivity.this;
                a = s;
                b = s1;
                c = s2;
                super();
            }
        });
        if (s1 == null) goto _L4; else goto _L3
_L3:
        a(s2, s, s4, ((Bitmap) (s1)), true);
        finish();
        return;
        if (s2 == null) goto _L4; else goto _L5
_L5:
        a(s2, s, s4, null, true);
        finish();
        return;
    }

    public static byte[] a(Bitmap bitmap, boolean flag)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        bitmap.compress(android.graphics.Bitmap.CompressFormat.PNG, 100, bytearrayoutputstream);
        if (flag)
        {
            bitmap.recycle();
        }
        bitmap = bytearrayoutputstream.toByteArray();
        try
        {
            bytearrayoutputstream.close();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            Crashlytics.logException(exception);
            return bitmap;
        }
        return bitmap;
    }

    private void b(String s)
    {
        Object obj = Uri.parse(s);
        s = ((Uri) (obj)).getQueryParameter("type");
        String s1 = ((Uri) (obj)).getQueryParameter("shareway");
        String s2 = ((Uri) (obj)).getQueryParameter("message");
        String s3 = ((Uri) (obj)).getQueryParameter("weburl");
        String s4 = ((Uri) (obj)).getQueryParameter("thumbUrl");
        String s5 = ((Uri) (obj)).getQueryParameter("imageUrl");
        String s6 = ((Uri) (obj)).getQueryParameter("title");
        obj = ((Uri) (obj)).getQueryParameter("description");
        if (s != null && s.compareTo("share") == 0)
        {
            if (s1 != null && s1.compareTo("sina") == 0)
            {
                a(s5, s2, s3);
            }
            if (s1 != null && s1.compareTo("WXMoments") == 0)
            {
                a(s5, s2, s3, s4, s6, ((String) (obj)));
            }
            if (s1 != null && s1.compareTo("WeChat") == 0)
            {
                b(s5, s2, s3, s4, s6, ((String) (obj)));
            }
        }
    }

    private void b(String s, String s1, String s2, String s3, String s4, String s5)
    {
        if (s4 == null)
        {
            s = " ";
        } else
        {
            s = s4;
        }
        if (s5 == null)
        {
            s4 = " ";
        } else
        {
            s4 = s5;
        }
        if (s3 != null || s2 != null) goto _L2; else goto _L1
_L1:
        (new of(this)).a(s1);
_L4:
        return;
_L2:
        if (s3 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        s1 = (new ky()).a(this, s3, new kz(s2, s, s4) {

            final String a;
            final String b;
            final String c;
            final ExternReceiverActivity d;

            public void a(Bitmap bitmap)
            {
                ExternReceiverActivity.a(d, a, b, c, bitmap, false);
                d.finish();
            }

            public void a(Exception exception)
            {
                ExternReceiverActivity.a(d, a, b, c, null, false);
                d.finish();
            }

            
            {
                d = ExternReceiverActivity.this;
                a = s;
                b = s1;
                c = s2;
                super();
            }
        });
        if (s1 == null) goto _L4; else goto _L3
_L3:
        a(s2, s, s4, s1, false);
        finish();
        return;
        if (s2 == null) goto _L4; else goto _L5
_L5:
        a(s2, s, s4, null, false);
        finish();
        return;
    }

    private String c(String s)
    {
        if (s == null)
        {
            return String.valueOf(System.currentTimeMillis());
        } else
        {
            return (new StringBuilder()).append(s).append(System.currentTimeMillis()).toString();
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030089);
        Object obj = getIntent();
        if (obj != null)
        {
            bundle = ((Intent) (obj)).getStringExtra("url");
            obj = ((Intent) (obj)).getStringExtra("prefix");
            if (obj == null)
            {
                a(bundle);
            } else
            if (((String) (obj)).compareTo("fotoable") == 0)
            {
                b(bundle);
                return;
            }
        }
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    protected void onStart()
    {
        super.onStart();
    }

    protected void onStop()
    {
        super.onStop();
    }
}
