// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.bt;

import android.os.AsyncTask;
import android.view.View;

// Referenced classes of package myobfuscated.bt:
//            i

final class it>
    implements android.view..OnClickListener
{

    final i a;

    public final void onClick(View view)
    {
        (new AsyncTask() {

            private i._cls2 a;

            protected final Object doInBackground(Object aobj[])
            {
                i.a(a.a);
                return null;
            }

            
            {
                a = i._cls2.this;
                super();
            }
        }).execute(new Integer[] {
            Integer.valueOf(0)
        });
    }

    (i j)
    {
        a = j;
        super();
    }
}
