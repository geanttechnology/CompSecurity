// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal.exception;

import java.io.PrintStream;

// Referenced classes of package net.tsz.afinal.exception:
//            AfinalException

public class ViewException extends AfinalException
{

    private static final long serialVersionUID = 1L;
    private String strMsg;

    public ViewException(String s)
    {
        strMsg = null;
        strMsg = s;
    }

    public void printStackTrace()
    {
        if (strMsg != null)
        {
            System.err.println(strMsg);
        }
        super.printStackTrace();
    }
}
