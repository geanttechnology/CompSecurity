// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms.barcodereader;

import android.content.Intent;
import android.net.Uri;
import android.util.Patterns;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.digimarc.dms.barcodereader:
//            PayoffHandler

public class QRCodeResolver
{

    public final Boolean isWebUri;
    public final Uri uri;

    public QRCodeResolver(String s)
    {
        Uri uri1 = Uri.parse(PayoffHandler.sanitizeScheme(s));
        if (uri1.getScheme() == null || s.contains("\n") || s.contains("\r"))
        {
            if (Patterns.WEB_URL.matcher(s).matches())
            {
                isWebUri = Boolean.valueOf(true);
                uri = Uri.parse(s);
                return;
            } else
            {
                isWebUri = Boolean.valueOf(false);
                uri = null;
                return;
            }
        }
        if (uri1.getScheme().contains("http"))
        {
            isWebUri = Boolean.valueOf(true);
            uri = Uri.parse(PayoffHandler.sanitizeScheme(s));
            return;
        } else
        {
            isWebUri = Boolean.valueOf(false);
            uri = uri1;
            return;
        }
    }

    public static Intent intentForUri(Uri uri1)
    {
        if (uri1 == null)
        {
            uri1 = null;
        } else
        {
            String s = uri1.toString();
            Object obj = uri1.getScheme();
            obj = (new StringBuilder()).append(((String) (obj)).toLowerCase()).append(s.substring(((String) (obj)).length(), s.length())).toString();
            if (PayoffHandler.getPayoffType(((String) (obj))) == PayoffHandler.PayoffType.WEB)
            {
                return new Intent("android.intent.action.VIEW", Uri.parse(((String) (obj))));
            }
            if (PayoffHandler.getPayoffType(((String) (obj))) == PayoffHandler.PayoffType.DIAL)
            {
                uri1 = new Intent("android.intent.action.DIAL");
                uri1.setData(Uri.parse(((String) (obj)).toLowerCase()));
                return uri1;
            }
            if (PayoffHandler.getPayoffType(((String) (obj))) == PayoffHandler.PayoffType.SMS)
            {
                Intent intent = new Intent("android.intent.action.SENDTO");
                obj = ((String) (obj)).split(":");
                intent.setData(Uri.parse((new StringBuilder("smsto:")).append(obj[1]).toString()));
                uri1 = intent;
                if (obj.length > 2)
                {
                    intent.putExtra("sms_body", obj[2]);
                    return intent;
                }
            } else
            if (PayoffHandler.getPayoffType(((String) (obj))) == PayoffHandler.PayoffType.VIDEO)
            {
                uri1 = new Intent("android.intent.action.VIEW");
                uri1.setDataAndType(Uri.parse(((String) (obj))), "video/*");
                return uri1;
            } else
            {
                return new Intent("android.intent.action.VIEW", uri1);
            }
        }
        return uri1;
    }
}
