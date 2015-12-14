// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.photocollage.model.res.collage.TPhotoCollageComposeInfo;
import com.fotoable.photocollage.service.collage.FixComposeResourceManager;
import com.wantu.model.res.TFrameItemInfo;
import java.util.List;

public class mh
{

    public static TPhotoCollageComposeInfo a(com.fotoable.photocollage.service.collage.FixComposeResourceManager.FixComposeType fixcomposetype, int i)
    {
        fixcomposetype = (new FixComposeResourceManager()).a(fixcomposetype, i);
        if (fixcomposetype.size() > 0)
        {
            return (TPhotoCollageComposeInfo)fixcomposetype.get(0);
        } else
        {
            return null;
        }
    }

    public static com.fotoable.photocollage.service.collage.FixComposeResourceManager.FixComposeType a()
    {
        if (ew.a())
        {
            return com.fotoable.photocollage.service.collage.FixComposeResourceManager.FixComposeType.COMPOSE_43;
        } else
        {
            return com.fotoable.photocollage.service.collage.FixComposeResourceManager.FixComposeType.COMPOSE_11;
        }
    }

    public static TFrameItemInfo b()
    {
        return (new yc()).b();
    }
}
