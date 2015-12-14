// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import java.util.ArrayList;

public class ia
{

    public static ArrayList a(Context context)
    {
        if (yp.i(context).equalsIgnoreCase(ie.b))
        {
            return new com.fotoable.alertad.FotoAlertHelpr._cls1();
        }
        if (yp.i(context).equalsIgnoreCase(ie.j))
        {
            return new com.fotoable.alertad.FotoAlertHelpr._cls2();
        } else
        {
            return new com.fotoable.alertad.FotoAlertHelpr._cls3();
        }
    }

    public static ArrayList b(Context context)
    {
        if (yp.i(context).equalsIgnoreCase(ie.b) || yp.i(context).equalsIgnoreCase(ie.j))
        {
            return new com.fotoable.alertad.FotoAlertHelpr._cls4();
        } else
        {
            return null;
        }
    }
}
