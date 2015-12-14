// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.beautyui.newui.MNewFotoBeautyActivity;
import com.fotoable.beautyui.newui.MNewProEditScrollView;

public class ur
    implements va
{

    final MNewFotoBeautyActivity a;

    public ur(MNewFotoBeautyActivity mnewfotobeautyactivity)
    {
        a = mnewfotobeautyactivity;
        super();
    }

    public void a(MNewProEditScrollView mnewproeditscrollview, com.fotoable.beautyui.newui.MNewProEditScrollView.SecondToolState secondtoolstate)
    {
        sx.a("SecondTool_Clicked", secondtoolstate.toString());
        switch (uk.a[secondtoolstate.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            MNewFotoBeautyActivity.j(a);
            return;

        case 2: // '\002'
            MNewFotoBeautyActivity.k(a);
            return;

        case 3: // '\003'
            MNewFotoBeautyActivity.l(a);
            return;

        case 4: // '\004'
            MNewFotoBeautyActivity.m(a);
            return;

        case 5: // '\005'
            MNewFotoBeautyActivity.n(a);
            return;

        case 6: // '\006'
            MNewFotoBeautyActivity.o(a);
            return;

        case 7: // '\007'
            MNewFotoBeautyActivity.p(a);
            break;
        }
    }
}
