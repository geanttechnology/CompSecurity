// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.activity;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.appboy.Appboy;
import com.appboy.enums.CardCategory;
import java.util.ArrayList;
import java.util.List;
import myobfuscated.e.a;
import myobfuscated.e.b;
import myobfuscated.g.c;
import myobfuscated.g.d;
import myobfuscated.g.e;
import myobfuscated.g.f;

// Referenced classes of package com.socialin.android.activity:
//            WhatsNewActivity

final class a
    implements Runnable
{

    private ArrayList a;
    private b b;

    public final void run()
    {
        WhatsNewActivity.access$100(b.b).setVisibility(8);
        WhatsNewActivity.access$200(b.b).setVisibility(0);
        WhatsNewActivity.access$300(b.b, a);
        if (a.size() > 0)
        {
            Appboy.getInstance(b.b).logFeedCardImpression(b.b);
        }
    }

    ata(ata ata, ArrayList arraylist)
    {
        b = ata;
        a = arraylist;
        super();
    }

    // Unreferenced inner class com/socialin/android/activity/WhatsNewActivity$2

/* anonymous class */
    final class WhatsNewActivity._cls2
        implements b
    {

        final String a;
        final WhatsNewActivity b;

        public final void trigger(Object obj)
        {
            a a1;
            ArrayList arraylist;
            int i;
            int j;
            a1 = (a)obj;
            j = a1.b(CardCategory.ALL_CATEGORIES);
            arraylist = new ArrayList();
            i = 0;
_L16:
            if (i >= j) goto _L2; else goto _L1
_L1:
            obj = (c)a1.a(CardCategory.ALL_CATEGORIES).get(i);
            if (!((c) (obj)).c().equals(a)) goto _L4; else goto _L3
_L3:
            if (!(obj instanceof myobfuscated.g.b)) goto _L6; else goto _L5
_L5:
            String s;
            String s1;
            String s2;
            String s3;
            s3 = ((myobfuscated.g.b)obj).b;
            s2 = ((myobfuscated.g.b)obj).d;
            s1 = ((myobfuscated.g.b)obj).c;
            s = ((myobfuscated.g.b)obj).a;
            obj = ((myobfuscated.g.b)obj).e;
_L14:
            com.socialin.android.apiv3.model.WhatsNewResponse.WhatsNewItem whatsnewitem = new com.socialin.android.apiv3.model.WhatsNewResponse.WhatsNewItem();
            whatsnewitem.data = new com.socialin.android.apiv3.model.WhatsNewResponse.Data();
            whatsnewitem.data.title = s3;
            whatsnewitem.data.text = s1;
            whatsnewitem.data.link = s2;
            whatsnewitem.data.linkName = ((String) (obj));
            whatsnewitem.data.photoUrl = s;
            arraylist.add(whatsnewitem);
_L4:
            i++;
            continue; /* Loop/switch isn't completed */
_L6:
            if (!(obj instanceof e)) goto _L8; else goto _L7
_L7:
            s3 = ((e)obj).c;
            s2 = ((e)obj).d;
            s1 = ((e)obj).a;
            s = ((e)obj).b;
            obj = ((e)obj).e;
              goto _L9
_L8:
            if (!(obj instanceof myobfuscated.g.a)) goto _L11; else goto _L10
_L10:
            s = ((myobfuscated.g.a)obj).a;
            obj = ((myobfuscated.g.a)obj).c;
            s1 = null;
            s2 = null;
            s3 = null;
              goto _L9
_L11:
            if (obj instanceof d) goto _L13; else goto _L12
_L12:
            if (obj instanceof f)
            {
                s3 = ((f)obj).b;
                s2 = ((f)obj).c;
                s1 = ((f)obj).a;
                obj = ((f)obj).d;
                s = null;
            } else
            {
                obj = null;
                s = null;
                s1 = null;
                s2 = null;
                s3 = null;
            }
_L9:
            if (true) goto _L14; else goto _L13
_L2:
            b.runOnUiThread(new WhatsNewActivity._cls2._cls1(this, arraylist));
_L13:
            return;
            if (true) goto _L16; else goto _L15
_L15:
        }

            
            {
                b = whatsnewactivity;
                a = s;
                super();
            }
    }

}
