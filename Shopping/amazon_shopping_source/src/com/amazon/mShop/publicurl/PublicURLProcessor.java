// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.publicurl;

import android.content.Context;
import android.net.Uri;
import com.amazon.mShop.platform.AppLocale;
import com.amazon.mShop.util.Util;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.amazon.mShop.publicurl:
//            PublicURLProcessException

public abstract class PublicURLProcessor
{

    private static final Map sLocaleMapping;
    protected String mAssociateTag;
    protected String mHost;
    private boolean mIsLocaleChecked;
    protected String mLocaleName;
    protected String mOrigin;
    protected Map mParams;
    protected List mPathSegments;
    protected String mRefmarker;
    protected final Uri mUri;

    public PublicURLProcessor(Uri uri)
    {
        mUri = uri;
        mHost = mUri.getHost();
        if (!Util.isEmpty(mHost))
        {
            mHost = mHost.toLowerCase();
        }
        mPathSegments = mUri.getPathSegments();
        mRefmarker = mUri.getQueryParameter("ref");
        mAssociateTag = mUri.getQueryParameter("tag");
        mLocaleName = getLocaleNameFromUri(uri);
        mParams = new HashMap();
        String s;
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            uri = mUri.getQueryParameterNames();
        } else
        {
            uri = parseQueryParameterNames(mUri);
        }
        for (uri = uri.iterator(); uri.hasNext(); mParams.put(s, mUri.getQueryParameter(s)))
        {
            s = (String)uri.next();
        }

    }

    private void checkMarketplace()
        throws PublicURLProcessException
    {
        if (!Util.isEmpty(mHost))
        {
            if (mLocaleName == null)
            {
                throw new PublicURLProcessException(PublicURLProcessException.PublicURLErrorCode.ERROR_CODE_ERROR_HOSTNAME);
            }
            String s = AppLocale.getInstance().getCurrentLocaleName();
            if (!mLocaleName.equals(s) && (!AppLocale.isLocaleOfCA(mLocaleName) || !AppLocale.isLocaleOfCA(s)))
            {
                throw new PublicURLProcessException(PublicURLProcessException.PublicURLErrorCode.ERROR_CODE_NEED_SWITCH_LOCALE);
            }
        }
    }

    public static String getLocaleNameFromUri(Uri uri)
    {
        if (uri != null)
        {
            if (!Util.isEmpty(uri = uri.getHost()))
            {
                uri = uri.toLowerCase();
                uri = uri.substring(uri.indexOf("amazon.") + "amazon.".length());
                return (String)sLocaleMapping.get(uri);
            }
        }
        return null;
    }

    private Set parseQueryParameterNames(Uri uri)
    {
        uri = uri.getEncodedQuery();
        if (uri == null)
        {
            return Collections.emptySet();
        }
        LinkedHashSet linkedhashset = new LinkedHashSet();
        int j = 0;
        do
        {
            int i;
            int k;
label0:
            {
                i = uri.indexOf('&', j);
                if (i == -1)
                {
                    i = uri.length();
                }
                int l = uri.indexOf('=', j);
                if (l <= i)
                {
                    k = l;
                    if (l != -1)
                    {
                        break label0;
                    }
                }
                k = i;
            }
            linkedhashset.add(Uri.decode(uri.substring(j, k)));
            i++;
            j = i;
            if (i >= uri.length())
            {
                return linkedhashset;
            }
        } while (true);
    }

    private void preprocess()
        throws PublicURLProcessException
    {
        if (!mIsLocaleChecked)
        {
            mIsLocaleChecked = true;
            checkMarketplace();
        }
    }

    protected abstract void doProcess(Context context)
        throws PublicURLProcessException;

    public String getHost()
    {
        return mHost;
    }

    public String getLocaleName()
    {
        return mLocaleName;
    }

    public abstract String getMetricIdentity();

    public String getOrigin()
    {
        return mOrigin;
    }

    public Map getParams()
    {
        return mParams;
    }

    public String getRefmarker()
    {
        return mRefmarker;
    }

    public void process(Context context)
        throws PublicURLProcessException
    {
        process(context, null);
    }

    public void process(Context context, String s)
        throws PublicURLProcessException
    {
        mOrigin = s;
        if (!Util.isEmpty(mRefmarker))
        {
            break MISSING_BLOCK_LABEL_35;
        }
        s = mOrigin;
_L1:
        mRefmarker = s;
        preprocess();
        doProcess(context);
        return;
        try
        {
            s = mRefmarker;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new PublicURLProcessException(PublicURLProcessException.PublicURLErrorCode.ERROR_CODE_ERROR_PATH);
        }
          goto _L1
    }

    static 
    {
        sLocaleMapping = new HashMap();
        sLocaleMapping.put("com", "en_US");
        sLocaleMapping.put("co.uk", "en_GB");
        sLocaleMapping.put("co.jp", "ja_JP");
        sLocaleMapping.put("cn", "zh_CN");
        sLocaleMapping.put("ca", "en_CA");
        sLocaleMapping.put("it", "it_IT");
        sLocaleMapping.put("es", "es_ES");
        sLocaleMapping.put("de", "de_DE");
        sLocaleMapping.put("fr", "fr_FR");
        sLocaleMapping.put("in", "en_IN");
    }
}
