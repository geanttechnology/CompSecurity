// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.librarypicker.photozoompage;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.LabeledIntent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.view.View;
import com.cyberlink.youcammakeup.c;
import com.cyberlink.youcammakeup.clflurry.YMKLivePhotoEvent;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.database.o;
import com.cyberlink.youcammakeup.database.p;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.m;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.pages.librarypicker.photozoompage:
//            PhotoZoomFragment

class a extends m
{

    final a a;

    protected void a(Uri uri)
    {
        if (uri != null)
        {
            Activity activity = a.a.getActivity();
            if (activity != null)
            {
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("image/*");
                intent.putExtra("android.intent.extra.STREAM", uri);
                PackageManager packagemanager = a.a.getActivity().getPackageManager();
                List list = packagemanager.queryIntentActivities(intent, 0);
                ArrayList arraylist = new ArrayList();
                int i = 0;
                while (i < list.size()) 
                {
                    ResolveInfo resolveinfo = (ResolveInfo)list.get(i);
                    String s = resolveinfo.activityInfo.packageName;
                    if (!s.contains("com.cyberlink.youcammakeup"))
                    {
                        Intent intent1 = new Intent();
                        intent1.setComponent(new ComponentName(s, resolveinfo.activityInfo.name));
                        intent1.setAction("android.intent.action.SEND");
                        intent1.setType("image/*");
                        intent1.putExtra("android.intent.extra.STREAM", uri);
                        arraylist.add(new LabeledIntent(intent1, s, resolveinfo.loadLabel(packagemanager), resolveinfo.icon));
                    }
                    i++;
                }
                if (arraylist.size() == 0)
                {
                    uri = intent;
                } else
                {
                    uri = Intent.createChooser((Intent)arraylist.remove(0), null);
                    uri.putExtra("android.intent.extra.INITIAL_INTENTS", (LabeledIntent[])arraylist.toArray(new LabeledIntent[arraylist.size()]));
                }
                uri.putExtra("LibraryPickerActivity_RESET_STATE", true);
                activity.startActivity(uri);
            }
        }
    }

    protected void b(Object obj)
    {
        a((Uri)obj);
    }

    a(a a1)
    {
        a = a1;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/pages/librarypicker/photozoompage/PhotoZoomFragment$1

/* anonymous class */
    class PhotoZoomFragment._cls1
        implements android.view.View.OnClickListener
    {

        final PhotoZoomFragment a;

        public void onClick(View view)
        {
            com.cyberlink.youcammakeup.clflurry.b.a(new YMKLivePhotoEvent(com.cyberlink.youcammakeup.clflurry.YMKLivePhotoEvent.Operation.c));
            (new PhotoZoomFragment._cls1._cls2()).d(null).a(new PhotoZoomFragment._cls1._cls1(this));
        }

            
            {
                a = photozoomfragment;
                super();
            }

        // Unreferenced inner class com/cyberlink/youcammakeup/pages/librarypicker/photozoompage/PhotoZoomFragment$1$2

/* anonymous class */
        class PhotoZoomFragment._cls1._cls2 extends j
        {

            final PhotoZoomFragment._cls1 a;

            protected Uri a(Void void1)
            {
                void1 = c.f();
                if (void1.d(a.a.a()) != null)
                {
                    if ((void1 = new File(void1.b(a.a.a()).b())).exists())
                    {
                        return Uri.fromFile(void1);
                    }
                }
                return null;
            }

            protected volatile Object a(Object obj)
            {
                return a((Void)obj);
            }

                    
                    {
                        a = PhotoZoomFragment._cls1.this;
                        super();
                    }
        }

    }

}
