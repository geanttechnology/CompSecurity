// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.nav;

import android.net.Uri;
import android.util.Log;
import android.webkit.WebBackForwardList;
import com.amazon.mobile.mash.MASHWebView;
import com.amazon.mobile.mash.util.Util;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.mobile.mash.nav:
//            MASHNavOperation, MASHWebBackForwardList, MASHNavInterface, MASHWebHistoryItem

public final class MASHNavUtils
{

    private MASHNavUtils()
    {
    }

    public static int computeBackAmount(MASHWebView mashwebview, MASHNavOperation mashnavoperation)
    {
        byte byte0 = -1;
        if (!"back".equals(mashnavoperation.getOperation())) goto _L2; else goto _L1
_L1:
        int i = mashnavoperation.getBackAmount();
_L4:
        return i;
_L2:
        if (!"backToBookmark".equals(mashnavoperation.getOperation()))
        {
            break; /* Loop/switch isn't completed */
        }
        mashwebview = mashwebview.getMASHWebBackForwardList();
        int j = getTargetPageIndex(mashwebview, mashwebview.getCurrentIndex(), mashnavoperation.getBookmark());
        i = byte0;
        if (j >= 0)
        {
            return mashwebview.getCurrentIndex() - j;
        }
        if (true) goto _L4; else goto _L3
_L3:
        i = byte0;
        if ("backToModalRoot".equals(mashnavoperation.getOperation()))
        {
            i = byte0;
            if (mashwebview.getContext() instanceof MASHNavInterface)
            {
                mashnavoperation = (MASHNavInterface)mashwebview.getContext();
                i = byte0;
                if (mashwebview.getContext().getClass() == mashnavoperation.getModalActivityClass())
                {
                    return mashwebview.copyBackForwardList().getCurrentIndex();
                }
            }
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    public static String getFullUrlForGetRequest(String s, JSONObject jsonobject)
        throws JSONException
    {
        android.net.Uri.Builder builder = Uri.parse(s).buildUpon();
        if (jsonobject != null)
        {
            String s1;
            for (s = jsonobject.keys(); s.hasNext(); builder.appendQueryParameter(s1, jsonobject.getString(s1)))
            {
                s1 = (String)s.next();
            }

            s = builder.toString();
        }
        return s;
    }

    public static int getTargetPageIndex(MASHWebBackForwardList mashwebbackforwardlist, int i, String s)
    {
        byte byte0 = -1;
        i--;
        do
        {
label0:
            {
                int j = byte0;
                if (i >= 0)
                {
                    if (!s.equals(mashwebbackforwardlist.getItemAtIndex(i).getBookmark()))
                    {
                        break label0;
                    }
                    j = i;
                }
                return j;
            }
            i--;
        } while (true);
    }

    public static void goBackAndForward(MASHWebView mashwebview, int i, MASHNavOperation.MASHNavRequest mashnavrequest)
    {
        mashwebview.setShouldHideProgressIndicator(false);
        mashwebview.goBackOrForward(0 - i);
        mashwebview.setPendingNavRequest(mashnavrequest);
    }

    public static void issuePageRequest(MASHWebView mashwebview, MASHNavOperation.MASHNavRequest mashnavrequest)
    {
        if (mashnavrequest == null)
        {
            break MISSING_BLOCK_LABEL_89;
        }
        if (Util.isEmpty(mashnavrequest.getUrl()))
        {
            break MISSING_BLOCK_LABEL_89;
        }
        if ("POST".equalsIgnoreCase(mashnavrequest.getMethod()))
        {
            byte abyte0[] = Util.getPostDataAsByteArray(mashnavrequest.getParams());
            mashwebview.postUrl(mashnavrequest.getUrl(), abyte0);
            return;
        }
        try
        {
            mashwebview.loadUrl(getFullUrlForGetRequest(mashnavrequest.getUrl(), mashnavrequest.getParams()));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MASHWebView mashwebview)
        {
            Log.e("Amazon", (new StringBuilder()).append("JSONException ").append(mashwebview.getMessage()).toString());
        }
    }
}
