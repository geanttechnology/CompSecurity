// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.perfectcorp.utility;


// Referenced classes of package com.perfectcorp.utility:
//            a

class f
{

    public String a;
    public String b;

    public transient f(StackTraceElement stacktraceelement, Object aobj[])
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("[").append(stacktraceelement.getMethodName()).append("][").append(stacktraceelement.getLineNumber()).append("] ");
        int j = aobj.length;
        int i = 0;
        while (i < j) 
        {
            Object obj = aobj[i];
            if (obj == null)
            {
                obj = "null";
            } else
            {
                obj = obj.toString();
            }
            stringbuilder.append(((String) (obj)));
            i++;
        }
        b = stringbuilder.toString();
        a = ((String)com.perfectcorp.utility.a.a(stacktraceelement.getClassName().split("\\."))).split("\\$")[0];
    }
}
