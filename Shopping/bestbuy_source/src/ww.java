// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.internal.gu;
import java.util.Map;
import org.json.JSONObject;

public class ww
{

    private final gu a;
    private final Map b;
    private final Context c;

    public ww(gu gu1, Map map)
    {
        a = gu1;
        b = map;
        c = gu1.k();
    }

    static Context a(ww ww1)
    {
        return ww1.c;
    }

    static gu b(ww ww1)
    {
        return ww1.a;
    }

    android.app.DownloadManager.Request a(String s, String s1)
    {
        s = new android.app.DownloadManager.Request(Uri.parse(s));
        s.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, s1);
        if (aej.a())
        {
            s.allowScanningByMediaScanner();
            s.setNotificationVisibility(1);
            return s;
        } else
        {
            s.setShowRunningNotification(true);
            return s;
        }
    }

    String a(String s)
    {
        return Uri.parse(s).getLastPathSegment();
    }

    public void a()
    {
        if (!(new ue(c)).c())
        {
            acb.e("Store picture feature is not supported on this device.");
            return;
        }
        if (TextUtils.isEmpty((CharSequence)b.get("iurl")))
        {
            acb.e("Image url cannot be empty.");
            return;
        }
        String s = (String)b.get("iurl");
        if (!URLUtil.isValidUrl(s))
        {
            acb.e((new StringBuilder()).append("Invalid image url:").append(s).toString());
            return;
        }
        String s1 = a(s);
        if (!abq.c(s1))
        {
            acb.e("Image type not recognized:");
            return;
        } else
        {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(c);
            builder.setTitle(abi.a(com.google.android.gms.R.string.store_picture_title, "Save image"));
            builder.setMessage(abi.a(com.google.android.gms.R.string.store_picture_message, "Allow Ad to store image in Picture gallery?"));
            builder.setPositiveButton(abi.a(com.google.android.gms.R.string.accept, "Accept"), new android.content.DialogInterface.OnClickListener(s, s1) {

                final String a;
                final String b;
                final ww c;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = (DownloadManager)ww.a(c).getSystemService("download");
                    try
                    {
                        dialoginterface.enqueue(c.a(a, b));
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (DialogInterface dialoginterface)
                    {
                        acb.c("Could not store picture.");
                    }
                }

            
            {
                c = ww.this;
                a = s;
                b = s1;
                super();
            }
            });
            builder.setNegativeButton(abi.a(com.google.android.gms.R.string.decline, "Decline"), new android.content.DialogInterface.OnClickListener() {

                final ww a;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    ww.b(a).b("onStorePictureCanceled", new JSONObject());
                }

            
            {
                a = ww.this;
                super();
            }
            });
            builder.create().show();
            return;
        }
    }
}
