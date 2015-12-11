// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.interception;

import android.content.Context;
import android.net.Uri;
import com.amazon.mobile.mash.util.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.mobile.mash.interception:
//            UrlIntercepterConfigEntry, ParameterModel

public class UrlInterceptionHandler
{

    private Context mContext;
    private ArrayList mParamList;
    private Uri mUri;

    public UrlInterceptionHandler(Context context, Uri uri, UrlIntercepterConfigEntry urlintercepterconfigentry)
    {
        mContext = context;
        mUri = uri;
        mParamList = urlintercepterconfigentry.getParamList();
    }

    public Context getContext()
    {
        return mContext;
    }

    public String getParam(String s)
    {
        List list = mUri.getPathSegments();
        if (mParamList != null) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        int i;
        Iterator iterator = mParamList.iterator();
        ParameterModel parametermodel;
        do
        {
            if (!iterator.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            parametermodel = (ParameterModel)iterator.next();
            i = parametermodel.getPathSegmentIndex();
        } while (!parametermodel.getName().equals(s) || i >= list.size());
        break; /* Loop/switch isn't completed */
        if (true) goto _L1; else goto _L3
_L3:
        return (String)list.get(i);
    }

    public String getRefmarker()
    {
        String s1 = null;
        String s;
        Iterator iterator;
        try
        {
            iterator = mUri.getPathSegments().iterator();
        }
        catch (UnsupportedOperationException unsupportedoperationexception)
        {
            return null;
        }
        s = s1;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        s = (String)iterator.next();
        if (s.indexOf("ref=") != 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        s = s.substring("ref=".length(), s.length());
        break; /* Loop/switch isn't completed */
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_15;
_L1:
        s1 = s;
        if (Util.isEmpty(s))
        {
            s1 = mUri.getQueryParameter("ref_");
        }
        return s1;
    }

    public Uri getUri()
    {
        return mUri;
    }

    public boolean handle()
    {
        return false;
    }
}
