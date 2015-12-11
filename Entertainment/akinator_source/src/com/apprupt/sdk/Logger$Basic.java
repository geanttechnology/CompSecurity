// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import android.util.Log;

// Referenced classes of package com.apprupt.sdk:
//            Logger

private static class <init>
    implements <init>
{

    private int level;
    private final String tag;

    private void d(int j, Object aobj[], Throwable throwable)
    {
        StringBuilder stringbuilder;
label0:
        {
label1:
            {
label2:
                {
                    int i1 = level;
                    int k = i1;
                    if (i1 == -1)
                    {
                        k = Logger.access$100();
                    }
                    if (k > 0 && (k & j) > 0)
                    {
                        stringbuilder = new StringBuilder();
                        int j1 = aobj.length;
                        for (int l = 0; l < j1; l++)
                        {
                            Object obj = aobj[l];
                            if (stringbuilder.length() > 0)
                            {
                                stringbuilder.append(" ");
                            }
                            stringbuilder.append(obj);
                        }

                        if (throwable != null)
                        {
                            stringbuilder.append("\n");
                            stringbuilder.append("Exception: ");
                            stringbuilder.append(throwable.getClass().getName());
                            stringbuilder.append("\n");
                            stringbuilder.append(throwable.getMessage());
                            stringbuilder.append("\n");
                            stringbuilder.append(Log.getStackTraceString(throwable));
                        }
                        switch (j)
                        {
                        default:
                            Log.v(tag, stringbuilder.toString());
                            break;

                        case 2: // '\002'
                            break label2;

                        case 4: // '\004'
                            break label1;

                        case 8: // '\b'
                            break label0;
                        }
                    }
                    return;
                }
                Log.i(tag, stringbuilder.toString());
                return;
            }
            Log.w(tag, stringbuilder.toString());
            return;
        }
        Log.e(tag, stringbuilder.toString());
    }

    public transient void e(Throwable throwable, Object aobj[])
    {
        d(8, aobj, throwable);
    }

    public transient void e(Object aobj[])
    {
        d(8, aobj, null);
    }

    public int getLevel()
    {
        return level;
    }

    public transient void i(Throwable throwable, Object aobj[])
    {
        d(2, aobj, throwable);
    }

    public transient void i(Object aobj[])
    {
        d(2, aobj, null);
    }

    public void setLevel(int j)
    {
        level = j;
    }

    public transient void v(Throwable throwable, Object aobj[])
    {
        d(1, aobj, throwable);
    }

    public transient void v(Object aobj[])
    {
        d(1, aobj, null);
    }

    public transient void w(Throwable throwable, Object aobj[])
    {
        d(4, aobj, throwable);
    }

    public transient void w(Object aobj[])
    {
        d(4, aobj, null);
    }

    private (String s)
    {
        level = -1;
        StringBuilder stringbuilder = (new StringBuilder()).append("CV_SDK");
        String s1;
        if (s.length() > 0)
        {
            s1 = ".";
        } else
        {
            s1 = "";
        }
        tag = stringbuilder.append(s1).append(s).toString();
    }

    ing(String s, ing ing)
    {
        this(s);
    }
}
