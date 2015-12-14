// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.camera.opengl;

import android.widget.RadioGroup;

// Referenced classes of package com.socialin.camera.opengl:
//            ad

public final class v
{

    public int a;
    private ad b;

    public v()
    {
    }

    public v(ad ad1)
    {
        b = ad1;
    }

    final void a(int i)
    {
        a = i;
        if (b != null)
        {
            b.a("mode", Integer.valueOf(i));
        }
    }

    // Unreferenced inner class com/socialin/camera/opengl/v$1

/* anonymous class */
    final class _cls1
        implements android.widget.RadioGroup.OnCheckedChangeListener
    {

        private v a;

        public final void onCheckedChanged(RadioGroup radiogroup, int i)
        {
            if (i == 0x7f100250)
            {
                a.a(0);
                return;
            } else
            {
                a.a(1);
                return;
            }
        }

            
            {
                a = v.this;
                super();
            }
    }

}
