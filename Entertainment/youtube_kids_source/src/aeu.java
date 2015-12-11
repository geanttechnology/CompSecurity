// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.apps.youtube.kids.application.KidsApplication;

final class aeu
    implements android.view.View.OnClickListener
{

    private aes a;

    aeu(aes aes1)
    {
        a = aes1;
        super();
    }

    public final void onClick(View view)
    {
        view = a.b.getDrawable();
        if (view instanceof BitmapDrawable)
        {
            view = ((BitmapDrawable)view).getBitmap();
            ((KidsApplication)a.a.getContext().getApplicationContext()).e = view;
        }
        aes.b(a);
    }
}
