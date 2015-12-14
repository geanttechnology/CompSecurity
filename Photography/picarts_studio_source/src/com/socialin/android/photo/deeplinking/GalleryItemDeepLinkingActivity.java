// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.deeplinking;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.picsart.studio.util.StudioManager;
import com.picsart.studio.util.a;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.ImageItem;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.apiv3.model.ViewerUser;
import com.socialin.android.dialog.g;
import com.socialin.android.picsart.profile.activity.GalleryItemShowActivity;
import com.socialin.android.picsart.profile.util.n;
import com.socialin.android.util.Utils;
import com.socialin.android.util.s;
import com.socialin.android.util.x;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.d;
import java.io.IOException;
import java.util.regex.Pattern;
import myobfuscated.cv.c;

public class GalleryItemDeepLinkingActivity extends BaseActivity
{

    public GalleryItemDeepLinkingActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
label0:
        {
            super.onCreate(bundle);
            bundle = getIntent().getData();
            if (bundle != null && !TextUtils.isEmpty(bundle.toString()))
            {
                long l = -1L;
                String s = bundle.toString().replaceAll("\\s", "");
                String s1 = s.toLowerCase();
                boolean flag;
                if (s1.contains("edit=true"))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                bundle = null;
                if (s1.contains("http://picsart.com/i/") || s1.contains("picsart://i/"))
                {
                    if (s1.contains("http://picsart.com/i/"))
                    {
                        bundle = s.substring(s.indexOf("http://picsart.com/i/")).substring(21);
                    } else
                    if (s1.contains("picsart://i/"))
                    {
                        bundle = s.substring(s.indexOf("picsart://i/")).substring(12);
                    }
                } else
                if (s1.contains("picsart://photos?id="))
                {
                    bundle = s.substring(s.indexOf("picsart://photos?id=")).substring(20);
                }
                if (!TextUtils.isEmpty(bundle))
                {
                    int i = Utils.a(Pattern.compile("[^0-9]"), bundle);
                    if (i != -1)
                    {
                        l = Long.parseLong(bundle.substring(0, i));
                    } else
                    {
                        l = Long.parseLong(bundle);
                    }
                }
                if (!flag)
                {
                    break label0;
                }
                bundle = new g(this);
                bundle.setCancelable(false);
                (new n(this)).a(l, new d(bundle, this) {

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
                            (new Thread(this, request, ((ImageItem) (obj))) {

                                private String a;
                                private ImageItem b;
                                private _cls1 c;

                                public final void run()
                                {
                                    Object obj;
                                    a a1;
                                    try
                                    {
                                        obj = s.b(a);
                                        if (c.b.isFinishing())
                                        {
                                            break MISSING_BLOCK_LABEL_67;
                                        }
                                        x.a();
                                        obj = x.a(((java.io.InputStream) (obj)));
                                    }
                                    catch (IOException ioexception)
                                    {
                                        ioexception.printStackTrace();
                                        return;
                                    }
                                    if (obj == null)
                                    {
                                        break MISSING_BLOCK_LABEL_67;
                                    }
                                    a1 = new a(0);
                                    StudioManager.openImageInEditor(c.b, ((String) (obj)), a1, b, x.c("picsart"), "picsart", null);
                                    c.a.dismiss();
                                    c.c.finish();
                                    return;
                                }

            
            {
                c = _pcls1;
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

            
            {
                c = GalleryItemDeepLinkingActivity.this;
                a = g1;
                b = baseactivity;
                super();
            }
                });
            }
            return;
        }
        bundle = new Intent(getApplicationContext(), com/socialin/android/picsart/profile/activity/GalleryItemShowActivity);
        bundle.putExtra("openItemDetails", false);
        bundle.putExtra("fromUrl", true);
        c.a(bundle, this);
        bundle.putExtra("item_id", l);
        startActivity(bundle);
        finish();
    }
}
