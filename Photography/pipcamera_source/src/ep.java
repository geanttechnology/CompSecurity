// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import java.util.ArrayList;

public class ep
{

    public static ArrayList a(Context context)
    {
        if (ew.j(context).equalsIgnoreCase(es.b))
        {
            return new com.fotoable.alertad.FotoAlertHelpr._cls1();
        }
        if (ew.j(context).equalsIgnoreCase(es.j))
        {
            return new com.fotoable.alertad.FotoAlertHelpr._cls2();
        } else
        {
            return new com.fotoable.alertad.FotoAlertHelpr._cls3();
        }
    }

    public static ArrayList b(Context context)
    {
        if (ew.j(context).equalsIgnoreCase(es.b) || ew.j(context).equalsIgnoreCase(es.j))
        {
            return new com.fotoable.alertad.FotoAlertHelpr._cls4();
        } else
        {
            return null;
        }
    }
}
