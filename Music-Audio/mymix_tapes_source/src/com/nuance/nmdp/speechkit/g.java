// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit;

import bf;
import com.nuance.nmdp.speechkit.recognitionresult.b;
import cv;
import cw;

// Referenced classes of package com.nuance.nmdp.speechkit:
//            DataUploadResult

final class g
    implements DataUploadResult
{
    static final class a
        implements DataUploadResult.DataResult
    {

        private String a;
        private String b;
        private String c;
        private String d;
        private int e;
        private int f;

        final boolean a(cv cv1)
        {
            if (cv1.a("id"))
            {
                a = cv1.f("id");
            }
            if (cv1.a("type"))
            {
                b = cv1.f("type");
            }
            if (cv1.a("status"))
            {
                c = cv1.f("status");
            }
            if (cv1.a("checksum"))
            {
                d = cv1.f("checksum");
            }
            if (cv1.a("force_upload"))
            {
                f = cv1.d("force_upload");
            }
            if (cv1.a("final_count"))
            {
                e = cv1.d("final_count");
            }
            return true;
        }

        public final int getChecksum()
        {
            int i;
            try
            {
                i = Integer.parseInt(d);
            }
            catch (Exception exception)
            {
                return 0;
            }
            return i;
        }

        public final int getDataCount()
        {
            return e;
        }

        public final int getForceUpload()
        {
            return f;
        }

        public final String getId()
        {
            return a;
        }

        public final String getStatus()
        {
            return c;
        }

        public final String getType()
        {
            return b;
        }

        a()
        {
        }
    }


    private a a[];
    private boolean b;

    g()
    {
        b = false;
        a = null;
    }

    static boolean a(g g1, boolean flag)
    {
        g1.b = flag;
        return flag;
    }

    static a[] a(g g1)
    {
        return g1.a;
    }

    static a[] a(g g1, a aa[])
    {
        g1.a = aa;
        return aa;
    }

    final bf a()
    {
        return new bf() {

            private g a;

            private boolean a(cv cv1)
            {
                boolean flag1 = true;
                if (cv1.d("voc_pregeneration_status") != 1) goto _L2; else goto _L1
_L1:
                g.a(a, true);
_L7:
                cv1 = cv1.i("result_list");
                if (cv1 == null) goto _L4; else goto _L3
_L3:
                int j;
                j = cv1.a();
                g.a(a, new a[j]);
                int i = 0;
_L6:
                boolean flag;
                flag = flag1;
                if (i >= j)
                {
                    break; /* Loop/switch isn't completed */
                }
                g.a(a)[i] = new a();
                g.a(a)[i].a(cv1.g(i));
                i++;
                if (true) goto _L6; else goto _L5
_L2:
                g.a(a, false);
                  goto _L7
                cv1;
                com.nuance.nmdp.speechkit.recognitionresult.b.a(this, "Error parsing result", cv1);
_L4:
                flag = false;
_L5:
                return flag;
            }

            public final boolean a()
            {
                return false;
            }

            public final volatile boolean a(Object obj)
            {
                return a((cv)obj);
            }

            public final volatile Object b()
            {
                return a;
            }

            
            {
                a = g.this;
                super();
            }
        };
    }

    public final DataUploadResult.DataResult getDataResult(int i)
    {
        if (i >= 0 && i < a.length)
        {
            return a[i];
        } else
        {
            return null;
        }
    }

    public final int getDataResultCount()
    {
        return a.length;
    }

    public final boolean isVocRegenerated()
    {
        return b;
    }
}
