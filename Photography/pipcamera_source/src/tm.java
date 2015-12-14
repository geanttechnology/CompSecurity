// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import java.io.File;

public class tm extends ahm
{

    public tm(Context context, String s)
    {
        super(context, s);
    }

    public String a()
    {
        return a;
    }

    protected String a(Context context, String s)
    {
        context = context.getApplicationContext().getDir("onlineRes", 0).getAbsolutePath();
        context = (new StringBuilder()).append(context).append("/").append(s).toString();
        (new File(context)).mkdirs();
        return context;
    }
}
