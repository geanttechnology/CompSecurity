// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.github.hiteshsondhi88.libffmpeg;


// Referenced classes of package com.github.hiteshsondhi88.libffmpeg:
//            FFmpeg

class Log
{

    private static boolean DEBUG = false;
    private static String TAG = com/github/hiteshsondhi88/libffmpeg/FFmpeg.getSimpleName();

    Log()
    {
    }

    static void d(Object obj)
    {
        if (DEBUG)
        {
            String s = TAG;
            if (obj != null)
            {
                obj = obj.toString();
            } else
            {
                obj = (new StringBuilder()).append(null).append("").toString();
            }
            android.util.Log.d(s, ((String) (obj)));
        }
    }

    static void e(Object obj)
    {
        if (DEBUG)
        {
            String s = TAG;
            if (obj != null)
            {
                obj = obj.toString();
            } else
            {
                obj = (new StringBuilder()).append(null).append("").toString();
            }
            android.util.Log.e(s, ((String) (obj)));
        }
    }

    static void e(Object obj, Throwable throwable)
    {
        if (DEBUG)
        {
            String s = TAG;
            if (obj != null)
            {
                obj = obj.toString();
            } else
            {
                obj = (new StringBuilder()).append(null).append("").toString();
            }
            android.util.Log.e(s, ((String) (obj)), throwable);
        }
    }

    static void e(Throwable throwable)
    {
        if (DEBUG)
        {
            android.util.Log.e(TAG, "", throwable);
        }
    }

    static void i(Object obj)
    {
        if (DEBUG)
        {
            String s = TAG;
            if (obj != null)
            {
                obj = obj.toString();
            } else
            {
                obj = (new StringBuilder()).append(null).append("").toString();
            }
            android.util.Log.i(s, ((String) (obj)));
        }
    }

    static void setDEBUG(boolean flag)
    {
        DEBUG = flag;
    }

    static void setTAG(String s)
    {
        TAG = s;
    }

    static void v(Object obj)
    {
        if (DEBUG)
        {
            String s = TAG;
            if (obj != null)
            {
                obj = obj.toString();
            } else
            {
                obj = (new StringBuilder()).append(null).append("").toString();
            }
            android.util.Log.v(s, ((String) (obj)));
        }
    }

    static void w(Object obj)
    {
        if (DEBUG)
        {
            String s = TAG;
            if (obj != null)
            {
                obj = obj.toString();
            } else
            {
                obj = (new StringBuilder()).append(null).append("").toString();
            }
            android.util.Log.w(s, ((String) (obj)));
        }
    }

}
