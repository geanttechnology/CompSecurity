// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.AlertDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            zzfb, zzip, zzhu, zzbq, 
//            zzhl, zzhv

public class zzey extends zzfb
{

    private final Context mContext;
    private final Map zzvs;

    public zzey(zzip zzip1, Map map)
    {
        super(zzip1, "storePicture");
        zzvs = map;
        mContext = zzip1.zzgN();
    }

    static Context zza(zzey zzey1)
    {
        return zzey1.mContext;
    }

    public void execute()
    {
        if (mContext == null)
        {
            zzah("Activity context is not available");
            return;
        }
        if (!zzp.zzbx().zzM(mContext).zzcX())
        {
            zzah("Feature is not supported by the device.");
            return;
        }
        String s = (String)zzvs.get("iurl");
        if (TextUtils.isEmpty(s))
        {
            zzah("Image url cannot be empty.");
            return;
        }
        if (!URLUtil.isValidUrl(s))
        {
            zzah((new StringBuilder()).append("Invalid image url: ").append(s).toString());
            return;
        }
        String s1 = zzag(s);
        if (!zzp.zzbx().zzay(s1))
        {
            zzah((new StringBuilder()).append("Image type not recognized: ").append(s1).toString());
            return;
        } else
        {
            android.app.AlertDialog.Builder builder = zzp.zzbx().zzL(mContext);
            builder.setTitle(zzp.zzbA().zzc(com.google.android.gms.R.string.store_picture_title, "Save image"));
            builder.setMessage(zzp.zzbA().zzc(com.google.android.gms.R.string.store_picture_message, "Allow Ad to store image in Picture gallery?"));
            builder.setPositiveButton(zzp.zzbA().zzc(com.google.android.gms.R.string.accept, "Accept"), new _cls1(s, s1));
            builder.setNegativeButton(zzp.zzbA().zzc(com.google.android.gms.R.string.decline, "Decline"), new _cls2());
            builder.create().show();
            return;
        }
    }

    String zzag(String s)
    {
        return Uri.parse(s).getLastPathSegment();
    }

    android.app.DownloadManager.Request zzg(String s, String s1)
    {
        s = new android.app.DownloadManager.Request(Uri.parse(s));
        s.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, s1);
        zzp.zzbz().zza(s);
        return s;
    }

    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}

}
