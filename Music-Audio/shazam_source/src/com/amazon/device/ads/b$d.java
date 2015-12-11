// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

// Referenced classes of package com.amazon.device.ads:
//            b, cm, y, bg, 
//            cd, do, bb

static final class <init> extends <init>
{

    protected final Object b(<init> <init>1)
    {
        bg bg1 = cm.a().b;
        <init>1 = <init>1.a.b;
        org.json.JSONObject jsonobject = bg1.j();
        cd.b(jsonobject, "orientation", <init>1);
        if (<init>1.equals("portrait") && bg1.j != null)
        {
            <init>1 = bg1.j;
        } else
        if (<init>1.equals("landscape") && bg1.i != null)
        {
            <init>1 = bg1.i;
        } else
        {
            Object obj = (WindowManager)bg1.k.b().getSystemService("window");
            DisplayMetrics displaymetrics = new DisplayMetrics();
            ((WindowManager) (obj)).getDefaultDisplay().getMetrics(displaymetrics);
            obj = (new StringBuilder()).append(String.valueOf(displaymetrics.widthPixels)).append("x").append(String.valueOf(displaymetrics.heightPixels)).toString();
            if (<init>1.equals("portrait"))
            {
                bg1.j = new do(((String) (obj)));
                <init>1 = bg1.j;
            } else
            if (<init>1.equals("landscape"))
            {
                bg1.i = new do(((String) (obj)));
                <init>1 = bg1.i;
            } else
            {
                <init>1 = new do(((String) (obj)));
            }
        }
        cd.b(jsonobject, "screenSize", <init>1.toString());
        cd.b(jsonobject, "connectionType", (new bb(bg1.k)).a);
        return jsonobject;
    }

    s()
    {
        super("dinfo", "debug.dinfo");
    }
}
