// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.beautyui.newui.FotoBeautySimpleActivity;

public class td
    implements android.view.View.OnClickListener
{

    final FotoBeautySimpleActivity a;

    public td(FotoBeautySimpleActivity fotobeautysimpleactivity)
    {
        a = fotobeautysimpleactivity;
        super();
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131558603: 
            FotoBeautySimpleActivity.n(a);
            return;

        case 2131558662: 
            FotoBeautySimpleActivity.o(a);
            break;
        }
    }
}
