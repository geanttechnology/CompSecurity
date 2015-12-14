// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.fotoproedit.activity.ProEditCropActivity;

public class aex
    implements Runnable
{

    final ProEditCropActivity a;

    public aex(ProEditCropActivity proeditcropactivity)
    {
        a = proeditcropactivity;
        super();
    }

    public void run()
    {
        android.graphics.Bitmap bitmap = ProEditCropActivity.k(a);
        a.runOnUiThread(new aey(this, bitmap));
    }
}
