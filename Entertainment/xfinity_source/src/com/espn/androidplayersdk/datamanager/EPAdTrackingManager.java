// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.espn.androidplayersdk.datamanager;

import android.app.Activity;
import android.content.Context;
import com.espn.androidplayersdk.utilities.Utils;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import tv.freewheel.hybrid.StreamStitcherHelper;

public class EPAdTrackingManager
{

    protected static final String ID3_IDENTIFIER = "TIT2";
    private Activity mActivity;
    private Context mCtx;
    private StreamStitcherHelper ssh;

    public EPAdTrackingManager(Activity activity, Context context)
    {
        mActivity = activity;
        mCtx = context;
    }

    protected static String extractTIT2Frame(byte abyte0[], String s)
    {
label0:
        {
            boolean flag = false;
            int l = abyte0.length;
            if (!(new String(abyte0, 0, 3)).equals("ID3"))
            {
                Utils.sdkLog("Not ID3 tag", 2, null);
                return null;
            }
            int j = 0 + 3;
            String s1 = new byte[2];
            System.arraycopy(abyte0, j, s1, 0, 2);
            while (s1[0] <= 3 || s1[0] == 4) 
            {
                j += 2;
                if ((abyte0[j] >> 6 & 1) == 1)
                {
                    flag = true;
                }
                int k = j + 1;
                s1 = new byte[4];
                System.arraycopy(abyte0, k, s1, 0, 4);
                j = (s1[0] & 0x7f) * 0x200000 + (s1[1] & 0x7f) * 1024 + (s1[2] & 0x7f) * 128 + (s1[3] & 0x7f);
                k += 4;
                byte abyte1[];
                UnsupportedEncodingException unsupportedencodingexception;
                String s2;
                int i;
                int i1;
                int j1;
                int k1;
                boolean flag1;
                if (flag)
                {
                    s1 = new byte[4];
                    System.arraycopy(abyte0, k, s1, 0, 4);
                    k = (s1[0] & 0x7f) * 0x200000 + (s1[1] & 0x7f) * 1024 + (s1[2] & 0x7f) * 128 + (s1[3] & 0x7f);
                    i = k + 10;
                    k = j - k;
                    s1 = null;
                    j = i;
                    i = k;
                } else
                {
                    s1 = null;
                    i = j;
                    j = k;
                }
                break label0;
            }
            Utils.sdkLog("version is five or higher, ignore", 2, null);
            return null;
        }
_L4:
        if (i <= 10 || j >= l)
        {
            return s1;
        }
        k = 0;
        flag1 = (new String(abyte0, j, 4, "UTF-8")).equals(s);
        if (!flag1)
        {
            k = 1;
        }
_L2:
        j += 4;
        abyte1 = new byte[4];
        System.arraycopy(abyte0, j, abyte1, 0, 4);
        i1 = abyte1[0] * 0x1000000 + abyte1[1] * 0x10000 + abyte1[2] * 256 + abyte1[3];
        j += 4;
        System.arraycopy(abyte0, j, new byte[2], 0, 2);
        j1 = j + 2;
        if (k == 0)
        {
            break; /* Loop/switch isn't completed */
        }
        j = j1 + i1;
        i -= i1 + 10;
        continue; /* Loop/switch isn't completed */
        unsupportedencodingexception;
        Utils.sdkLog("UnsupportedEncodingException", 5, unsupportedencodingexception);
        if (true) goto _L2; else goto _L1
_L1:
        j = abyte0[j1];
        if (j != 3)
        {
            break; /* Loop/switch isn't completed */
        }
        k = 0;
        k1 = (j1 + i1) - 1;
        j = k;
        if (abyte0[k1] != 0)
        {
            j = k;
            if (abyte0[k1] >= 50)
            {
                j = k;
                if (abyte0[k1] <= 126)
                {
                    j = 0 + 1;
                }
            }
        }
        s2 = new String(abyte0, j1 + 1, (i1 - 2) + j, "UTF-8");
        s1 = s2;
_L5:
        j = j1 + i1;
        i -= i1 + 10;
        if (true) goto _L4; else goto _L3
        s2;
        Utils.sdkLog("UnsupportedEncodingException", 5, s2);
          goto _L5
_L3:
        if (j != 0)
        {
            break MISSING_BLOCK_LABEL_559;
        }
        s2 = new String(abyte0, j1 + 1, i1 - 2, "ISO-8859-1");
        s1 = s2;
          goto _L5
        s2;
        Utils.sdkLog("UnsupportedEncodingException", 5, s2);
          goto _L5
        if (j != 1) goto _L7; else goto _L6
_L6:
        s2 = new String(abyte0, j1 + 1, i1 - 3, "UTF-16");
        s1 = s2;
          goto _L5
        s2;
        Utils.sdkLog("UnsupportedEncodingException", 5, s2);
          goto _L5
_L7:
        if (j != 2) goto _L5; else goto _L8
_L8:
        s2 = new String(abyte0, j1 + 1, i1 - 3, "UTF-16");
        s1 = s2;
          goto _L5
        s2;
        Utils.sdkLog("UnsupportedEncodingException", 5, s2);
          goto _L5
    }

    public void handleMetaData(byte abyte0[], Long long1)
    {
        String s = new String(abyte0);
        if (ssh != null && s.contains("TIT2"))
        {
            abyte0 = extractTIT2Frame(abyte0, "TIT2");
            ssh.handleMetadata("TIT2", abyte0, long1.longValue());
        }
    }

    public void progressUpdate(Long long1)
    {
        if (ssh != null)
        {
            ssh.handleProgressUpdate(long1.longValue());
        }
    }

    public void start(String s)
    {
        try
        {
            s = new URL(s);
            ssh = new StreamStitcherHelper(mActivity, mCtx, s);
            ssh.start();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Utils.sdkLog("Unable to initialize Ad tracking manager", 5, s);
        }
    }

    public void stop()
    {
        if (ssh != null)
        {
            ssh.stop();
        }
    }
}
