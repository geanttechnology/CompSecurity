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
//            zzfh, zziz, zzid, zzbq, 
//            zzhu, zzie

public class zzfe extends zzfh
{

    private final Context mContext;
    private final Map zzvS;

    public zzfe(zziz zziz1, Map map)
    {
        super(zziz1, "storePicture");
        zzvS = map;
        mContext = zziz1.zzgZ();
    }

    static Context zza(zzfe zzfe1)
    {
        return zzfe1.mContext;
    }

    public void execute()
    {
        if (mContext == null)
        {
            zzak("Activity context is not available");
            return;
        }
        if (!zzp.zzbv().zzL(mContext).zzcY())
        {
            zzak("Feature is not supported by the device.");
            return;
        }
        String s = (String)zzvS.get("iurl");
        if (TextUtils.isEmpty(s))
        {
            zzak("Image url cannot be empty.");
            return;
        }
        if (!URLUtil.isValidUrl(s))
        {
            zzak((new StringBuilder()).append("Invalid image url: ").append(s).toString());
            return;
        }
        String s1 = zzaj(s);
        if (!zzp.zzbv().zzaB(s1))
        {
            zzak((new StringBuilder()).append("Image type not recognized: ").append(s1).toString());
            return;
        } else
        {
            android.app.AlertDialog.Builder builder = zzp.zzbv().zzK(mContext);
            builder.setTitle(zzp.zzby().zzd(com.google.android.gms.R.string.store_picture_title, "Save image"));
            builder.setMessage(zzp.zzby().zzd(com.google.android.gms.R.string.store_picture_message, "Allow Ad to store image in Picture gallery?"));
            builder.setPositiveButton(zzp.zzby().zzd(com.google.android.gms.R.string.accept, "Accept"), new _cls1(s, s1));
            builder.setNegativeButton(zzp.zzby().zzd(com.google.android.gms.R.string.decline, "Decline"), new _cls2());
            builder.create().show();
            return;
        }
    }

    String zzaj(String s)
    {
        return Uri.parse(s).getLastPathSegment();
    }

    android.app.DownloadManager.Request zzg(String s, String s1)
    {
        s = new android.app.DownloadManager.Request(Uri.parse(s));
        s.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, s1);
        zzp.zzbx().zza(s);
        return s;
    }

    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}

}
