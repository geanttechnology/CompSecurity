// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import com.fotoable.fotoproedit.activity.font.FontShadowOutlineEditView;
import com.fotoable.fotoproedit.activity.font.FontStyleColorShadowView;
import com.fotoable.fotoproedit.activity.font.FontStyleGridView;

public class aju
    implements android.view.View.OnClickListener
{

    final FontStyleColorShadowView a;

    public aju(FontStyleColorShadowView fontstylecolorshadowview)
    {
        a = fontstylecolorshadowview;
        super();
    }

    public void onClick(View view)
    {
        FontStyleColorShadowView.access$100(a).setBackgroundColor(a.getResources().getColor(0x7f0c004b));
        FontStyleColorShadowView.access$000(a).setBackgroundColor(a.getResources().getColor(0x7f0c004a));
        FontStyleColorShadowView.access$200(a).setBackgroundColor(a.getResources().getColor(0x7f0c004a));
        FontStyleColorShadowView.access$400(a).getBackground().mutate().setColorFilter(0xff007aff, android.graphics.PorterDuff.Mode.SRC_IN);
        FontStyleColorShadowView.access$300(a).getBackground().mutate().setColorFilter(-1, android.graphics.PorterDuff.Mode.SRC_IN);
        FontStyleColorShadowView.access$500(a).getBackground().mutate().setColorFilter(-1, android.graphics.PorterDuff.Mode.SRC_IN);
        FontStyleColorShadowView.access$600(a).setVisibility(8);
        FontStyleColorShadowView.access$700(a).setVisibility(0);
        FontStyleColorShadowView.access$800(a).setVisibility(8);
    }
}
