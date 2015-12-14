// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.fotoproedit.activity.ProEditFontActivity;

public class agy
    implements android.view.View.OnClickListener
{

    final ProEditFontActivity a;

    public agy(ProEditFontActivity proeditfontactivity)
    {
        a = proeditfontactivity;
        super();
    }

    public void onClick(View view)
    {
        ProEditFontActivity.e(a);
    }
}
