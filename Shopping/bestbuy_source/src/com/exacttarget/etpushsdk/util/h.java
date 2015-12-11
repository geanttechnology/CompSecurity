// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.util;

import android.text.TextUtils;

// Referenced classes of package com.exacttarget.etpushsdk.util:
//            ETLogger

class h
    implements Runnable
{

    final Object a[];
    final String b;
    final String c;
    final ETLogger d;

    h(ETLogger etlogger, Object aobj[], String s, String s1)
    {
        d = etlogger;
        a = aobj;
        b = s;
        c = s1;
        super();
    }

    public void run()
    {
        Object obj;
        Object obj1;
        StringBuilder stringbuilder;
        if (a != null && a.length > 0 && (a[0] instanceof Throwable))
        {
            obj1 = (Throwable)a[0];
        } else
        {
            obj1 = null;
        }
        if (b != null)
        {
            if (b.contains("\n"))
            {
                obj = b.split("\n");
            } else
            {
                obj = (new String[] {
                    b
                });
            }
        } else
        {
            obj = null;
        }
        if (obj1 != null)
        {
            ((Throwable) (obj1)).getMessage();
            obj1 = new String[((Throwable) (obj1)).getStackTrace().length + 1];
        } else
        {
            obj1 = null;
        }
        if (obj == null && obj1 == null)
        {
            return;
        }
        stringbuilder = new StringBuilder();
        if (ETLogger.access$000().length() == 0)
        {
            stringbuilder.append(ETLogger.access$100(d));
        }
        if (obj != null)
        {
            int k = obj.length;
            for (int i = 0; i < k; i++)
            {
                String s = obj[i];
                if (!TextUtils.isEmpty(s))
                {
                    stringbuilder.append(ETLogger.access$200(d, c, s));
                }
            }

        }
        if (obj1 != null)
        {
            int l = obj1.length;
            for (int j = 0; j < l; j++)
            {
                obj = obj1[j];
                if (!TextUtils.isEmpty(((CharSequence) (obj))))
                {
                    stringbuilder.append(ETLogger.access$200(d, c, ((String) (obj))));
                }
            }

        }
        if ((long)(ETLogger.access$000().length() + stringbuilder.length()) > ETLogger.access$300())
        {
            ETLogger.access$400(d, null);
        }
        ETLogger.access$000().append(stringbuilder.toString());
    }
}
