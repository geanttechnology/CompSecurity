// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            qu, ul, tq, tp, 
//            nf, tg

public class qq extends qu
{

    private final Map a;
    private final Context b;

    public qq(ul ul1, Map map)
    {
        super(ul1, "storePicture");
        a = map;
        b = ul1.c();
    }

    static Context a(qq qq1)
    {
        return qq1.b;
    }

    android.app.DownloadManager.Request a(String s, String s1)
    {
        s = new android.app.DownloadManager.Request(Uri.parse(s));
        s.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, s1);
        zzp.zzbz().a(s);
        return s;
    }

    String a(String s)
    {
        return Uri.parse(s).getLastPathSegment();
    }

    public void a()
    {
        if (b == null)
        {
            b("Activity context is not available");
            return;
        }
        if (!zzp.zzbx().e(b).c())
        {
            b("Feature is not supported by the device.");
            return;
        }
        String s = (String)a.get("iurl");
        if (TextUtils.isEmpty(s))
        {
            b("Image url cannot be empty.");
            return;
        }
        if (!URLUtil.isValidUrl(s))
        {
            b((new StringBuilder()).append("Invalid image url: ").append(s).toString());
            return;
        }
        String s1 = a(s);
        if (!zzp.zzbx().c(s1))
        {
            b((new StringBuilder()).append("Image type not recognized: ").append(s1).toString());
            return;
        } else
        {
            android.app.AlertDialog.Builder builder = zzp.zzbx().d(b);
            builder.setTitle(zzp.zzbA().a(ks.b.store_picture_title, "Save image"));
            builder.setMessage(zzp.zzbA().a(ks.b.store_picture_message, "Allow Ad to store image in Picture gallery?"));
            builder.setPositiveButton(zzp.zzbA().a(ks.b.accept, "Accept"), new android.content.DialogInterface.OnClickListener(s, s1) {

                final String a;
                final String b;
                final qq c;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = (DownloadManager)qq.a(c).getSystemService("download");
                    try
                    {
                        dialoginterface.enqueue(c.a(a, b));
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (DialogInterface dialoginterface)
                    {
                        c.b("Could not store picture.");
                    }
                }

            
            {
                c = qq.this;
                a = s;
                b = s1;
                super();
            }
            });
            builder.setNegativeButton(zzp.zzbA().a(ks.b.decline, "Decline"), new android.content.DialogInterface.OnClickListener() {

                final qq a;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    a.b("User canceled the download.");
                }

            
            {
                a = qq.this;
                super();
            }
            });
            builder.create().show();
            return;
        }
    }
}
