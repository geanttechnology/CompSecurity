// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;

import android.os.Looper;
import com.mopub.common.logging.MoPubLog;
import java.util.IllegalFormatException;

public final class Preconditions
{
    public static final class NoThrow
    {

        private static volatile boolean sStrictMode = false;

        public static boolean checkArgument(boolean flag)
        {
            return Preconditions.checkArgumentInternal(flag, sStrictMode, "Illegal argument", new Object[] {
                ""
            });
        }

        public static boolean checkArgument(boolean flag, String s)
        {
            return Preconditions.checkArgumentInternal(flag, sStrictMode, s, new Object[] {
                ""
            });
        }

        public static transient boolean checkArgument(boolean flag, String s, Object aobj[])
        {
            return Preconditions.checkArgumentInternal(flag, sStrictMode, s, aobj);
        }

        public static boolean checkNotNull(Object obj)
        {
            return Preconditions.checkNotNullInternal(obj, sStrictMode, "Object can not be null.", new Object[] {
                ""
            });
        }

        public static boolean checkNotNull(Object obj, String s)
        {
            return Preconditions.checkNotNullInternal(obj, sStrictMode, s, new Object[] {
                ""
            });
        }

        public static transient boolean checkNotNull(Object obj, String s, Object aobj[])
        {
            return Preconditions.checkNotNullInternal(obj, sStrictMode, s, aobj);
        }

        public static boolean checkState(boolean flag)
        {
            return Preconditions.checkStateInternal(flag, sStrictMode, "Illegal state.", new Object[] {
                ""
            });
        }

        public static boolean checkState(boolean flag, String s)
        {
            return Preconditions.checkStateInternal(flag, sStrictMode, s, new Object[] {
                ""
            });
        }

        public static transient boolean checkState(boolean flag, String s, Object aobj[])
        {
            return Preconditions.checkStateInternal(flag, sStrictMode, s, aobj);
        }

        public static boolean checkUiThread()
        {
            return Preconditions.checkUiThreadInternal(sStrictMode, "This method must be called from the UI thread.", new Object[] {
                ""
            });
        }

        public static boolean checkUiThread(String s)
        {
            return Preconditions.checkUiThreadInternal(sStrictMode, s, new Object[] {
                ""
            });
        }

        public static transient boolean checkUiThread(String s, Object aobj[])
        {
            return Preconditions.checkUiThreadInternal(false, s, aobj);
        }

        public static void setStrictMode(boolean flag)
        {
            sStrictMode = flag;
        }


        public NoThrow()
        {
        }
    }


    public static final String EMPTY_ARGUMENTS = "";

    private Preconditions()
    {
    }

    public static void checkArgument(boolean flag)
    {
        checkArgumentInternal(flag, true, "Illegal argument.", new Object[] {
            ""
        });
    }

    public static void checkArgument(boolean flag, String s)
    {
        checkArgumentInternal(flag, true, s, new Object[] {
            ""
        });
    }

    public static transient void checkArgument(boolean flag, String s, Object aobj[])
    {
        checkArgumentInternal(flag, true, s, aobj);
    }

    private static transient boolean checkArgumentInternal(boolean flag, boolean flag1, String s, Object aobj[])
    {
        if (flag)
        {
            return true;
        }
        s = format(s, aobj);
        if (flag1)
        {
            throw new IllegalArgumentException(s);
        } else
        {
            MoPubLog.e(s);
            return false;
        }
    }

    public static void checkNotNull(Object obj)
    {
        checkNotNullInternal(obj, true, "Object can not be null.", new Object[] {
            ""
        });
    }

    public static void checkNotNull(Object obj, String s)
    {
        checkNotNullInternal(obj, true, s, new Object[] {
            ""
        });
    }

    public static transient void checkNotNull(Object obj, String s, Object aobj[])
    {
        checkNotNullInternal(obj, true, s, aobj);
    }

    private static transient boolean checkNotNullInternal(Object obj, boolean flag, String s, Object aobj[])
    {
        if (obj != null)
        {
            return true;
        }
        obj = format(s, aobj);
        if (flag)
        {
            throw new NullPointerException(((String) (obj)));
        } else
        {
            MoPubLog.e(((String) (obj)));
            return false;
        }
    }

    public static void checkState(boolean flag)
    {
        checkStateInternal(flag, true, "Illegal state.", new Object[] {
            ""
        });
    }

    public static void checkState(boolean flag, String s)
    {
        checkStateInternal(flag, true, s, new Object[] {
            ""
        });
    }

    public static transient void checkState(boolean flag, String s, Object aobj[])
    {
        checkStateInternal(flag, true, s, aobj);
    }

    private static transient boolean checkStateInternal(boolean flag, boolean flag1, String s, Object aobj[])
    {
        if (flag)
        {
            return true;
        }
        s = format(s, aobj);
        if (flag1)
        {
            throw new IllegalStateException(s);
        } else
        {
            MoPubLog.e(s);
            return false;
        }
    }

    public static void checkUiThread()
    {
        checkUiThreadInternal(true, "This method must be called from the UI thread.", new Object[] {
            ""
        });
    }

    public static void checkUiThread(String s)
    {
        checkUiThreadInternal(true, s, new Object[] {
            ""
        });
    }

    public static transient void checkUiThread(String s, Object aobj[])
    {
        checkUiThreadInternal(true, s, aobj);
    }

    private static transient boolean checkUiThreadInternal(boolean flag, String s, Object aobj[])
    {
        if (Looper.getMainLooper().equals(Looper.myLooper()))
        {
            return true;
        }
        s = format(s, aobj);
        if (flag)
        {
            throw new IllegalStateException(s);
        } else
        {
            MoPubLog.e(s);
            return false;
        }
    }

    private static transient String format(String s, Object aobj[])
    {
        s = String.valueOf(s);
        try
        {
            aobj = String.format(s, aobj);
        }
        // Misplaced declaration of an exception variable
        catch (Object aobj[])
        {
            MoPubLog.e((new StringBuilder()).append("MoPub preconditions had a format exception: ").append(((IllegalFormatException) (aobj)).getMessage()).toString());
            return s;
        }
        return ((String) (aobj));
    }




}
