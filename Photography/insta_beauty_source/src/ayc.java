// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.BitmapFactory;
import com.crashlytics.android.Crashlytics;
import com.fotoable.ad.StaticFlurryEvent;
import com.fotoable.tgifview.TGifView;

public class ayc
    implements aqb
{

    final String a;
    final axx b;
    final TGifView c;

    public ayc(TGifView tgifview, String s, axx axx1)
    {
        c = tgifview;
        a = s;
        b = axx1;
        super();
    }

    public void a(Exception exception)
    {
        StaticFlurryEvent.logFotoableADEvent(StaticFlurryEvent.key_ad_imageRequest, "wall_fail");
    }

    public void a(String s, byte abyte0[])
    {
        String s1;
        c.mImageByteArray = abyte0;
        s1 = c.getExtension(s);
        String s2 = (new StringBuilder()).append(a).append(".").append(s1).toString();
        TGifView.access$700(c).a(s2, abyte0);
        TGifView.access$700(c).a(s);
        if (!s1.equalsIgnoreCase("gif"))
        {
            break MISSING_BLOCK_LABEL_117;
        }
        c.setGifImage(c.mImageByteArray);
_L1:
        if (b != null)
        {
            b.a();
        }
        TGifView.access$800(c, false);
        return;
        try
        {
            c.setImageBitmap(BitmapFactory.decodeByteArray(c.mImageByteArray, 0, c.mImageByteArray.length));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Crashlytics.logException(s);
            StaticFlurryEvent.logFotoableADEvent(StaticFlurryEvent.key_ad_imageRequest, "wall_fail");
            return;
        }
          goto _L1
    }
}
