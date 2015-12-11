// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import android.net.Uri;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

// Referenced classes of package com.google.tagmanager:
//            Log

class PreviewManager
{
    static final class PreviewMode extends Enum
    {

        private static final PreviewMode $VALUES[];
        public static final PreviewMode CONTAINER;
        public static final PreviewMode CONTAINER_DEBUG;
        public static final PreviewMode NONE;

        public static PreviewMode valueOf(String s)
        {
            return (PreviewMode)Enum.valueOf(com/google/tagmanager/PreviewManager$PreviewMode, s);
        }

        public static PreviewMode[] values()
        {
            return (PreviewMode[])$VALUES.clone();
        }

        static 
        {
            NONE = new PreviewMode("NONE", 0);
            CONTAINER = new PreviewMode("CONTAINER", 1);
            CONTAINER_DEBUG = new PreviewMode("CONTAINER_DEBUG", 2);
            $VALUES = (new PreviewMode[] {
                NONE, CONTAINER, CONTAINER_DEBUG
            });
        }

        private PreviewMode(String s, int i)
        {
            super(s, i);
        }
    }


    static final String BASE_DEBUG_QUERY = "&gtm_debug=x";
    private static final String CONTAINER_BASE_PATTERN = "^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&";
    private static final String CONTAINER_DEBUG_STRING_PATTERN = ".*?&gtm_debug=x$";
    private static final String CONTAINER_PREVIEW_EXIT_URL_PATTERN = "^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_preview=$";
    private static final String CONTAINER_PREVIEW_URL_PATTERN = "^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_auth=\\S+&gtm_preview=\\d+(&gtm_debug=x)?$";
    static final String CTFE_URL_PATH_PREFIX = "/r?";
    private static PreviewManager sInstance;
    private volatile String mCTFEUrlPath;
    private volatile String mCTFEUrlQuery;
    private volatile String mContainerId;
    private volatile PreviewMode mPreviewMode;

    PreviewManager()
    {
        clear();
    }

    private String getContainerId(String s)
    {
        return s.split("&")[0].split("=")[1];
    }

    static PreviewManager getInstance()
    {
        com/google/tagmanager/PreviewManager;
        JVM INSTR monitorenter ;
        PreviewManager previewmanager;
        if (sInstance == null)
        {
            sInstance = new PreviewManager();
        }
        previewmanager = sInstance;
        com/google/tagmanager/PreviewManager;
        JVM INSTR monitorexit ;
        return previewmanager;
        Exception exception;
        exception;
        com/google/tagmanager/PreviewManager;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private String getQueryWithoutDebugParameter(Uri uri)
    {
        return uri.getQuery().replace("&gtm_debug=x", "");
    }

    void clear()
    {
        mPreviewMode = PreviewMode.NONE;
        mCTFEUrlPath = null;
        mContainerId = null;
        mCTFEUrlQuery = null;
    }

    String getCTFEUrlDebugQuery()
    {
        return mCTFEUrlQuery;
    }

    String getCTFEUrlPath()
    {
        return mCTFEUrlPath;
    }

    String getContainerId()
    {
        return mContainerId;
    }

    PreviewMode getPreviewMode()
    {
        return mPreviewMode;
    }

    boolean setPreviewData(Uri uri)
    {
        boolean flag = true;
        this;
        JVM INSTR monitorenter ;
        String s = URLDecoder.decode(uri.toString(), "UTF-8");
        if (!s.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_auth=\\S+&gtm_preview=\\d+(&gtm_debug=x)?$")) goto _L2; else goto _L1
_L1:
        Log.v((new StringBuilder()).append("Container preview url: ").append(s).toString());
        if (!s.matches(".*?&gtm_debug=x$")) goto _L4; else goto _L3
_L3:
        mPreviewMode = PreviewMode.CONTAINER_DEBUG;
_L6:
        mCTFEUrlQuery = getQueryWithoutDebugParameter(uri);
        if (mPreviewMode == PreviewMode.CONTAINER || mPreviewMode == PreviewMode.CONTAINER_DEBUG)
        {
            mCTFEUrlPath = (new StringBuilder()).append("/r?").append(mCTFEUrlQuery).toString();
        }
        mContainerId = getContainerId(mCTFEUrlQuery);
_L5:
        this;
        JVM INSTR monitorexit ;
        return flag;
        uri;
        flag = false;
          goto _L5
_L4:
        mPreviewMode = PreviewMode.CONTAINER;
          goto _L6
        uri;
        throw uri;
_L2:
label0:
        {
            if (!s.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_preview=$"))
            {
                break label0;
            }
            if (!getContainerId(uri.getQuery()).equals(mContainerId))
            {
                break MISSING_BLOCK_LABEL_247;
            }
            Log.v((new StringBuilder()).append("Exit preview mode for container: ").append(mContainerId).toString());
            mPreviewMode = PreviewMode.NONE;
            mCTFEUrlPath = null;
        }
          goto _L5
        Log.w((new StringBuilder()).append("Invalid preview uri: ").append(s).toString());
        flag = false;
          goto _L5
        flag = false;
          goto _L5
    }
}
