// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.common.a;

import android.content.Context;
import android.graphics.Color;
import com.cyberlink.youcammakeup.database.more.i.d;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.SkuTemplateUtils;
import com.cyberlink.youcammakeup.utility.at;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import com.cyberlink.youcammakeup.widgetpool.common.MultiColorView;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.common.a:
//            f

public class h extends f
{

    private MultiColorView h;
    private String i;
    private d j;

    public h(Context context, BeautyMode beautymode, String s, d d1)
    {
        super(context, beautymode);
        i = s;
        j = d1;
    }

    protected int a(BeautyMode beautymode)
    {
        class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[BeautyMode.values().length];
                try
                {
                    a[BeautyMode.v.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    a[BeautyMode.z.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    a[BeautyMode.A.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[BeautyMode.B.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[BeautyMode.C.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[BeautyMode.s.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[BeautyMode.x.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1.a[beautymode.ordinal()])
        {
        default:
            return super.a(beautymode);

        case 1: // '\001'
            return 0x7f0300fe;

        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
            return 0x7f0300f8;

        case 6: // '\006'
            return 0x7f0300fb;

        case 7: // '\007'
            return 0x7f0300ff;
        }
    }

    protected void a(Context context, BeautyMode beautymode)
    {
        super.a(context, beautymode);
        if (isInEditMode())
        {
            return;
        } else
        {
            h = (MultiColorView)a;
            return;
        }
    }

    public void setColors(List list)
    {
        Object obj;
        obj = StatusManager.j().s();
        if (list.size() != 1)
        {
            break MISSING_BLOCK_LABEL_503;
        }
        list = (at)list.get(0);
        setTextColorByShadeColor(list);
        if (obj != BeautyMode.a || j == null) goto _L2; else goto _L1
_L1:
        obj = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().d(SkuTemplateUtils.a(((BeautyMode) (obj))), j.d(), i);
        if (obj == null || ((String) (obj)).equals("")) goto _L4; else goto _L3
_L3:
        list = ((String) (obj)).split(",");
        h.a(Color.parseColor((new StringBuilder()).append("#").append(list[0]).toString()), Color.parseColor((new StringBuilder()).append("#").append(list[1]).toString()), Color.parseColor((new StringBuilder()).append("#").append(list[2]).toString()), Color.parseColor((new StringBuilder()).append("#").append(list[3]).toString()));
_L6:
        return;
_L4:
        h.setBackgroundColor(Color.rgb(list.a().intValue(), list.b().intValue(), list.c().intValue()));
        return;
_L2:
        if (obj == BeautyMode.r && j != null)
        {
            obj = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().d(SkuTemplateUtils.a(((BeautyMode) (obj))), j.d(), i);
            if (obj != null && !((String) (obj)).equals(""))
            {
                list = ((String) (obj)).split(",");
                h.a(Color.parseColor((new StringBuilder()).append("#").append(list[0]).toString()), Color.parseColor((new StringBuilder()).append("#").append(list[1]).toString()), Color.parseColor((new StringBuilder()).append("#").append(list[2]).toString()), 0.8F);
                return;
            } else
            {
                h.setBackgroundColor(Color.rgb(list.a().intValue(), list.b().intValue(), list.c().intValue()));
                return;
            }
        }
        if (obj == BeautyMode.s)
        {
            list = MotionControlHelper.e().b(list);
            h.setBackgroundColor(list.e());
            return;
        }
        if (obj == BeautyMode.x)
        {
            h.setBackgroundColor(Color.argb(204, list.a().intValue(), list.b().intValue(), list.c().intValue()));
            return;
        }
        if (obj == BeautyMode.y) goto _L6; else goto _L5
_L5:
        h.setBackgroundColor(Color.rgb(list.a().intValue(), list.b().intValue(), list.c().intValue()));
        return;
        if (list.size() == 2)
        {
            at at2 = (at)list.get(0);
            list = (at)list.get(1);
            if (BeautyMode.d(((BeautyMode) (obj))))
            {
                h.a(at2.e(), list.e(), list.e(), 1.0F);
                return;
            }
            if (obj == BeautyMode.s)
            {
                h.a(MotionControlHelper.e().b(at2).e(), MotionControlHelper.e().b(list).e());
                return;
            } else
            {
                h.a(at2.e(), list.e());
                return;
            }
        }
        if (list.size() == 3)
        {
            at at1 = (at)list.get(0);
            at at3 = (at)list.get(1);
            list = (at)list.get(2);
            h.a(at1.e(), at3.e(), list.e(), 0.8F);
            return;
        } else
        {
            h.setBackgroundColor(0);
            return;
        }
    }
}
