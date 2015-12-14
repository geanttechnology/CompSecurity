// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.fotoable.beautyui.newui.MNewFotoBeautyActivity;
import com.fotoable.beautyui.newui.MOneKeyFragment;
import java.util.Iterator;
import java.util.List;

public class ua
    implements ty
{

    final MNewFotoBeautyActivity a;

    public ua(MNewFotoBeautyActivity mnewfotobeautyactivity)
    {
        a = mnewfotobeautyactivity;
        super();
    }

    public void a()
    {
        a.a();
    }

    public void a(PointF pointf, PointF pointf1)
    {
        a.a();
        if (MNewFotoBeautyActivity.r(a) != null)
        {
            adi adi1 = new adi();
            adi1.a(pointf.x);
            adi1.b(pointf.y);
            pointf = new adi();
            pointf.a(pointf1.x);
            pointf.b(pointf1.y);
            MNewFotoBeautyActivity.r(a).a(adi1, pointf);
            pointf = a.getSupportFragmentManager();
            if (pointf != null)
            {
                if ((pointf = pointf.getFragments()) != null && pointf.size() > 0)
                {
                    pointf = pointf.iterator();
                    while (pointf.hasNext()) 
                    {
                        pointf1 = (Fragment)pointf.next();
                        if (pointf1 instanceof MOneKeyFragment)
                        {
                            ((MOneKeyFragment)pointf1).a(true);
                        }
                    }
                }
            }
        }
    }

    public Bitmap b()
    {
        return MNewFotoBeautyActivity.f(a);
    }
}
