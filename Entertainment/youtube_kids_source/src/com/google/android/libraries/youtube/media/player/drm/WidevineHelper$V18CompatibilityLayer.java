// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.libraries.youtube.media.player.drm;

import android.media.MediaDrm;
import android.media.UnsupportedSchemeException;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import ara;
import are;
import bmo;
import clj;
import clp;
import cls;

public class 
{

    public static ara createWidevineDrmSessionManager18$1c66caf5(Uri uri, clj clj, Looper looper, Handler handler, are are, int i, String s)
    {
        boolean flag;
        try
        {
            uri = new clp(uri.toString(), clj, s, handler, are);
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            bmo.a("CDM initialization failed.", uri);
            return null;
        }
        if (i == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        uri = new cls(flag, looper, uri, handler, are);
        return uri;
    }

    public static int getWidevineSecurityLevel()
    {
        int i = 1;
        String s = (new MediaDrm(cls.k)).getPropertyString("securityLevel");
        if (s.equals("L1"))
        {
            return 1;
        }
        boolean flag;
        if (s.equals("L2"))
        {
            break MISSING_BLOCK_LABEL_56;
        }
        flag = s.equals("L3");
        return !flag ? -1 : 3;
        Exception exception;
        exception;
        i = -1;
        return i;
    }

    private ()
    {
    }
}
