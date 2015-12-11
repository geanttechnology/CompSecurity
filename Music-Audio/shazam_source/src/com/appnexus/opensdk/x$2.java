// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk;

import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.util.Base64;
import com.appnexus.opensdk.b.b;
import com.appnexus.opensdk.b.f;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

// Referenced classes of package com.appnexus.opensdk:
//            x, m

final class a
    implements android.content.ogInterface.OnClickListener
{

    final String a;
    final x b;

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        i = 1;
        if (!a.startsWith("data:")) goto _L2; else goto _L1
_L1:
        dialoginterface = ".png";
        Object obj;
        File file;
        byte abyte0[];
        if (a.contains("image/gif"))
        {
            dialoginterface = ".gif";
        } else
        if (a.contains("image/jpeg") || a.contains("image/pjpeg"))
        {
            dialoginterface = ".jpg";
        } else
        if (a.contains("image/png"))
        {
            dialoginterface = ".png";
        } else
        if (a.contains("image/tiff"))
        {
            dialoginterface = ".tif";
        } else
        if (a.contains("image/svg+xml"))
        {
            dialoginterface = ".svg";
        }
        Exception exception;
        if (!a.contains("base64"))
        {
            i = 0;
        }
        file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), (new StringBuilder()).append(System.currentTimeMillis()).append(dialoginterface).toString());
        dialoginterface = null;
        obj = new FileOutputStream(file);
        dialoginterface = ((DialogInterface) (obj));
        if (!file.canWrite()) goto _L4; else goto _L3
_L3:
        if (i != 0) goto _L6; else goto _L5
_L5:
        dialoginterface = ((DialogInterface) (obj));
        abyte0 = f.a(a.substring(a.lastIndexOf(",") + 1, a.length()));
_L7:
        dialoginterface = ((DialogInterface) (obj));
        ((FileOutputStream) (obj)).write(abyte0);
_L4:
        try
        {
            ((FileOutputStream) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (DialogInterface dialoginterface)
        {
            com.appnexus.opensdk.b.b.b(b.i, com.appnexus.opensdk.b.b.a(.store_picture_error));
        }
_L8:
        b.b.a();
        return;
_L6:
        dialoginterface = ((DialogInterface) (obj));
        abyte0 = Base64.decode(a.substring(a.lastIndexOf(",") + 1, a.length()), 0);
          goto _L7
        dialoginterface;
        obj = null;
_L12:
        dialoginterface = ((DialogInterface) (obj));
        com.appnexus.opensdk.b.b.b(b.i, com.appnexus.opensdk.b.b.a(.store_picture_error));
        if (obj != null)
        {
            try
            {
                ((FileOutputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (DialogInterface dialoginterface)
            {
                com.appnexus.opensdk.b.b.b(b.i, com.appnexus.opensdk.b.b.a(.store_picture_error));
            }
        }
          goto _L8
        dialoginterface;
        obj = null;
_L11:
        dialoginterface = ((DialogInterface) (obj));
        com.appnexus.opensdk.b.b.b(b.i, com.appnexus.opensdk.b.b.a(.store_picture_error));
        if (obj != null)
        {
            try
            {
                ((FileOutputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (DialogInterface dialoginterface)
            {
                com.appnexus.opensdk.b.b.b(b.i, com.appnexus.opensdk.b.b.a(.store_picture_error));
            }
        }
          goto _L8
        dialoginterface;
        obj = null;
_L10:
        dialoginterface = ((DialogInterface) (obj));
        com.appnexus.opensdk.b.b.b(b.i, com.appnexus.opensdk.b.b.a(.store_picture_error));
        if (obj != null)
        {
            try
            {
                ((FileOutputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (DialogInterface dialoginterface)
            {
                com.appnexus.opensdk.b.b.b(b.i, com.appnexus.opensdk.b.b.a(.store_picture_error));
            }
        }
          goto _L8
        exception;
        obj = dialoginterface;
        dialoginterface = exception;
_L9:
        if (obj != null)
        {
            try
            {
                ((FileOutputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                com.appnexus.opensdk.b.b.b(b.i, com.appnexus.opensdk.b.b.a(.store_picture_error));
            }
        }
        throw dialoginterface;
_L2:
        dialoginterface = (DownloadManager)b.b.getContext().getSystemService("download");
        obj = new android.app.loadManager.Request(Uri.parse(a));
        if (b.b.getContext().getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", b.b.getContext().getPackageName()) != 0)
        {
            break MISSING_BLOCK_LABEL_579;
        }
        ((android.app.loadManager.Request) (obj)).setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, a.split("/")[a.split("/").length - 1]);
        ((android.app.loadManager.Request) (obj)).allowScanningByMediaScanner();
        ((android.app.loadManager.Request) (obj)).setNotificationVisibility(1);
        dialoginterface.enqueue(((android.app.loadManager.Request) (obj)));
          goto _L8
        dialoginterface;
        com.appnexus.opensdk.b.b.b(b.i, com.appnexus.opensdk.b.b.a(.store_picture_error));
          goto _L8
        exception;
        obj = dialoginterface;
        dialoginterface = exception;
          goto _L9
        dialoginterface;
          goto _L10
        dialoginterface;
          goto _L11
        dialoginterface;
          goto _L12
    }

    eption(x x1, String s)
    {
        b = x1;
        a = s;
        super();
    }
}
