// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.graphics.Bitmap;
import java.util.ArrayList;

public class ata extends asz
{

    private asy b;

    public ata(asy asy1)
    {
        b = asy1;
    }

    public Bitmap a(Context context, int i, int j)
    {
        if (a.size() > 0)
        {
            return ((asx)a.get(0)).a(context, i, j);
        } else
        {
            return null;
        }
    }

    public String a()
    {
        return b.a();
    }
}
