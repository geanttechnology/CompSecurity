// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import android.os.AsyncTask;

// Referenced classes of package u.aly:
//            bo, bn, bj, bm

public class bl extends bo
{
    public static interface a
    {

        public abstract void a();

        public abstract void a(bn.a a1);
    }

    private class b extends AsyncTask
    {

        final bl a;
        private bm b;
        private a c;

        protected transient bn.a a(Integer ainteger[])
        {
            return a.a(b);
        }

        protected void a(bn.a a1)
        {
            if (c != null)
            {
                c.a(a1);
            }
        }

        protected transient Object doInBackground(Object aobj[])
        {
            return a((Integer[])aobj);
        }

        protected void onPostExecute(Object obj)
        {
            a((bn.a)obj);
        }

        protected void onPreExecute()
        {
            if (c != null)
            {
                c.a();
            }
        }

        public b(bm bm, a a1)
        {
            a = bl.this;
            super();
            b = bm;
            c = a1;
        }
    }


    private static final String a = u/aly/bl.getName();

    public bl()
    {
    }

    public bn.a a(bm bm)
    {
        bm = (bn)a(((bp) (bm)), u/aly/bn);
        if (bm == null)
        {
            return bn.a.b;
        } else
        {
            return ((bn) (bm)).a;
        }
    }

    public void a(bm bm, a a1)
    {
        (new b(bm, a1)).execute(new Integer[0]);
_L1:
        return;
        bm;
        bj.b(a, "", bm);
        if (a1 != null)
        {
            a1.a(bn.a.b);
            return;
        }
          goto _L1
    }

}
