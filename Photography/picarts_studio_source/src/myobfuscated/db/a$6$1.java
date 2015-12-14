// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.db;

import android.util.SparseArray;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ListView;
import com.socialin.android.util.c;
import com.socialin.camera.masks.b;
import com.socialin.camera.masks.d;
import java.util.ArrayList;

// Referenced classes of package myobfuscated.db:
//            a

final class >
    implements android.view.animation.ion.AnimationListener
{

    private .Animation a;

    public final void onAnimationEnd(Animation animation)
    {
        myobfuscated.db.a.g(a.a).setVisibility(8);
    }

    public final void onAnimationRepeat(Animation animation)
    {
    }

    public final void onAnimationStart(Animation animation)
    {
    }

    >(> >)
    {
        a = >;
        super();
    }

    // Unreferenced inner class myobfuscated/db/a$6

/* anonymous class */
    final class a._cls6
        implements android.widget.AdapterView.OnItemClickListener
    {

        final a a;

        public final void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            for (adapterview = a.getView(); adapterview == null || myobfuscated.db.a.d(a).a == i;)
            {
                return;
            }

            view = myobfuscated.db.a.e(a);
            c.b(((myobfuscated.da.b) (view)).a);
            ((myobfuscated.da.b) (view)).b.clear();
            System.gc();
            myobfuscated.db.a.e(a).a((com.socialin.camera.masks.c)myobfuscated.db.a.f(a).a.get(i));
            myobfuscated.db.a.e(a).notifyDataSetChanged();
            myobfuscated.db.a.d(a).a = i;
            myobfuscated.db.a.d(a).notifyDataSetChanged();
            myobfuscated.db.a.e(a).a(-1);
            view = AnimationUtils.loadAnimation(a.getActivity(), 0x7f040018);
            view.setAnimationListener(new a._cls6._cls1(this));
            myobfuscated.db.a.g(a).startAnimation(view);
            adapterview.findViewById(0x7f1006e4).startAnimation(AnimationUtils.loadAnimation(a.getActivity(), 0x7f04003e));
        }

            
            {
                a = a1;
                super();
            }
    }

}
