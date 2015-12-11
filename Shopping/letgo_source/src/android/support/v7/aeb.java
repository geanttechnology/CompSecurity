// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;


// Referenced classes of package android.support.v7:
//            ade, abj, aea

class aeb
{
    public static interface a
    {

        public abstract int a(Object obj, Object obj1);
    }


    final a a = new a() {

        final aeb a;

        public int a(Object obj, Object obj1)
        {
            return 1;
        }

            
            {
                a = aeb.this;
                super();
            }
    };

    public aeb()
    {
    }

    int a()
    {
        return android.os.Build.VERSION.SDK_INT;
    }

    public aea a(int i, a a1)
    {
        if (i <= 0)
        {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (a() < 12)
        {
            return new ade(i, a1);
        } else
        {
            return new abj(i, a1);
        }
    }
}
