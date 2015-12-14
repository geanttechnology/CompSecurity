// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.pip.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;
import com.pipcamera.activity.NewPhotoShareActivity;
import com.pipcamera.activity.pip.Pip2FragmentActivity;
import java.io.File;
import rd;

// Referenced classes of package com.pipcamera.activity.pip.fragment:
//            Pip2ProcessFragment

class a
    implements Runnable
{

    final Uri a;
    final ingTransition b;

    public void run()
    {
        if (Pip2ProcessFragment.a(b.b) != null)
        {
            Pip2ProcessFragment.a(b.b).b();
            Log.v("Pip2ProcessFragment", "Pip2ProcessFragmentwrite ResultImage end");
            if (b.b != null && !b.b.isRecycled())
            {
                b.b.recycle();
            }
            if (a != null)
            {
                Intent intent = new Intent(b.b.getActivity(), com/pipcamera/activity/NewPhotoShareActivity);
                intent.putExtra("PhotoShareActivity_ToShareImageUri", a.toString());
                b.b.startActivity(intent);
                Pip2ProcessFragment.a(b.b).overridePendingTransition(0x7f040007, 0);
                return;
            }
        }
    }

    a(a a1, Uri uri)
    {
        b = a1;
        a = uri;
        super();
    }

    // Unreferenced inner class com/pipcamera/activity/pip/fragment/Pip2ProcessFragment$6

/* anonymous class */
    class Pip2ProcessFragment._cls6
        implements Runnable
    {

        final Bitmap a;
        final Pip2ProcessFragment b;

        public void run()
        {
            if (Pip2ProcessFragment.a(b) == null)
            {
                return;
            }
            Object obj = rd.a(a);
            if (obj == null)
            {
                Pip2ProcessFragment.a(b).b();
                Pip2ProcessFragment.a(b).runOnUiThread(new Pip2ProcessFragment._cls6._cls1());
                return;
            } else
            {
                rd.a(((File) (obj)).getAbsolutePath(), Pip2ProcessFragment.a(b));
                obj = Uri.fromFile(((File) (obj)));
                Pip2ProcessFragment.a(b).runOnUiThread(new Pip2ProcessFragment._cls6._cls2(this, ((Uri) (obj))));
                return;
            }
        }

            
            {
                b = pip2processfragment;
                a = bitmap;
                super();
            }

        // Unreferenced inner class com/pipcamera/activity/pip/fragment/Pip2ProcessFragment$6$1

/* anonymous class */
        class Pip2ProcessFragment._cls6._cls1
            implements Runnable
        {

            final Pip2ProcessFragment._cls6 a;

            public void run()
            {
                Toast.makeText(Pip2ProcessFragment.a(a.b), Pip2ProcessFragment.a(a.b).getResources().getString(0x7f060196), 0).show();
            }

                    
                    {
                        a = Pip2ProcessFragment._cls6.this;
                        super();
                    }
        }

    }

}
