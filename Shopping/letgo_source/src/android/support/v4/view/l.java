// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

// Referenced classes of package android.support.v4.view:
//            o

class l
{
    static class a
        implements android.view.LayoutInflater.Factory
    {

        final o a;

        public View onCreateView(String s, Context context, AttributeSet attributeset)
        {
            return a.a(null, s, context, attributeset);
        }

        public String toString()
        {
            return (new StringBuilder()).append(getClass().getName()).append("{").append(a).append("}").toString();
        }

        a(o o1)
        {
            a = o1;
        }
    }


    static void a(LayoutInflater layoutinflater, o o)
    {
        if (o != null)
        {
            o = new a(o);
        } else
        {
            o = null;
        }
        layoutinflater.setFactory(o);
    }
}
