// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.deeplinking;

import com.picsart.studio.util.StudioManager;
import com.picsart.studio.util.a;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.ImageItem;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.apiv3.model.ViewerUser;
import com.socialin.android.dialog.g;
import com.socialin.android.util.s;
import com.socialin.android.util.x;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.d;
import java.io.IOException;

// Referenced classes of package com.socialin.android.photo.deeplinking:
//            GalleryItemDeepLinkingActivity

final class b
    implements d
{

    final g a;
    final BaseActivity b;
    final GalleryItemDeepLinkingActivity c;

    public final volatile void onCancelRequest(Object obj, Request request)
    {
    }

    public final void onFailure(Exception exception, Request request)
    {
        c.finish();
    }

    public final transient void onProgressUpdate(Integer ainteger[])
    {
    }

    public final void onSuccess(Object obj, Request request)
    {
        obj = (ImageItem)obj;
        if (((ImageItem) (obj)).freeToEdit() || SocialinV3.getInstance().isRegistered() && SocialinV3.getInstance().getUser().id == ((ImageItem) (obj)).user.id)
        {
            request = ((ImageItem) (obj)).getUrl();
            a.show();
            (new Thread(request, ((ImageItem) (obj))) {

                private String a;
                private ImageItem b;
                private GalleryItemDeepLinkingActivity._cls1 c;

                public final void run()
                {
                    Object obj1;
                    a a1;
                    try
                    {
                        obj1 = s.b(a);
                        if (c.b.isFinishing())
                        {
                            break MISSING_BLOCK_LABEL_67;
                        }
                        x.a();
                        obj1 = x.a(((java.io.InputStream) (obj1)));
                    }
                    catch (IOException ioexception)
                    {
                        ioexception.printStackTrace();
                        return;
                    }
                    if (obj1 == null)
                    {
                        break MISSING_BLOCK_LABEL_67;
                    }
                    a1 = new a(0);
                    StudioManager.openImageInEditor(c.b, ((String) (obj1)), a1, b, x.c("picsart"), "picsart", null);
                    c.a.dismiss();
                    c.c.finish();
                    return;
                }

            
            {
                c = GalleryItemDeepLinkingActivity._cls1.this;
                a = s1;
                b = imageitem;
                super();
            }
            }).start();
            return;
        } else
        {
            c.finish();
            return;
        }
    }

    _cls1.b(GalleryItemDeepLinkingActivity galleryitemdeeplinkingactivity, g g1, BaseActivity baseactivity)
    {
        c = galleryitemdeeplinkingactivity;
        a = g1;
        b = baseactivity;
        super();
    }
}
