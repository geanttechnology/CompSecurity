// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ck;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import com.socialin.android.util.c;
import com.socialin.android.util.w;
import com.socialin.android.util.x;
import java.io.File;
import java.util.Observable;
import java.util.Observer;
import myobfuscated.cm.n;

// Referenced classes of package myobfuscated.ck:
//            e, c, a

final class t>
    implements Observer
{

    private e a;

    public final void update(Observable observable, Object obj)
    {
        observable = (n)obj;
        obj = e.d(a);
        if (obj != null && !((Activity) (obj)).isFinishing()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        x.a();
        if (((n) (observable)).a == null) goto _L4; else goto _L3
_L3:
        Object obj1 = ((n) (observable)).a;
        e.a(a).i();
        String s = x.e();
        String s1 = x.d();
        (new File(s1, s)).mkdirs();
        obj1 = w.a((new StringBuilder()).append(s1).append("/").append(s).append("/orig_w").append(((Bitmap) (obj1)).getWidth()).append("_h").append(((Bitmap) (obj1)).getHeight()).toString(), ((Bitmap) (obj1)));
        x.c();
        observable.b = ((java.util.HashMap) (obj1));
_L5:
        if (((n) (observable)).a != null && !((n) (observable)).a.isRecycled())
        {
            c.a(((n) (observable)).a);
        }
        e.s();
        Object obj2 = new Intent();
        ((Intent) (obj2)).setClassName("com.picsart.studio", "com.picsart.studio.editor.activity.EditorActivity");
        ((Intent) (obj2)).addCategory("android.intent.category.DEFAULT");
        if (((n) (observable)).b != null)
        {
            ((Intent) (obj2)).putExtra("bufferData", ((n) (observable)).b);
        } else
        {
            ((Intent) (obj2)).putExtra("path", ((n) (observable)).c);
        }
        if (e.a(a).q != null)
        {
            ((Intent) (obj2)).putExtra("editing_data", e.a(a).q);
        }
        e.p(a).startActivity(((Intent) (obj2)));
        if (e.q(a))
        {
            ((Activity) (obj)).setResult(-1);
            e.r();
            ((Activity) (obj)).finish();
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
        if (((n) (observable)).b != null)
        {
            obj2 = ((n) (observable)).b;
            e.a(a).i();
            x.a(((java.util.HashMap) (obj2)));
        } else
        if (((n) (observable)).c != null)
        {
            obj2 = ((n) (observable)).c;
            e.a(a).i();
            x.b(((String) (obj2)), false);
        }
          goto _L5
    }

    t(e e1)
    {
        a = e1;
        super();
    }
}
