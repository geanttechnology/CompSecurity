// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import org.xml.sax.Attributes;

public final class cxs extends bnt
{

    public cxs()
    {
    }

    public final void a(bmz bmz1, Attributes attributes, String s)
    {
        byte byte0;
        int k;
        int l;
        boolean flag1;
        byte0 = 34;
        flag1 = true;
        bmz1 = (cyh)bmz1.a(cyh);
        k = a.b(a.a(attributes, new String[] {
            "w", "win", "id"
        }), 0);
        l = Integer.valueOf(a.a(attributes, new String[] {
            "t", "start"
        })).intValue();
        s = attributes.getValue("op");
        if (s == null || !s.equals("define")) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        i = 50;
        j = 95;
        s = a.a(attributes, new String[] {
            "ap"
        });
        if (s == null) goto _L4; else goto _L3
_L3:
        Integer.valueOf(s).intValue();
        JVM INSTR tableswitch 0 8: default 176
    //                   0 330
    //                   1 337
    //                   2 344
    //                   3 351
    //                   4 358
    //                   5 365
    //                   6 372
    //                   7 379
    //                   8 386;
           goto _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14
_L14:
        break MISSING_BLOCK_LABEL_386;
_L5:
        byte0 = 34;
_L4:
        s = a.a(attributes, new String[] {
            "ah"
        });
        if (s != null)
        {
            i = Math.max(0, Math.min(Integer.valueOf(s).intValue(), 100));
        }
        s = a.a(attributes, new String[] {
            "av"
        });
        if (s != null)
        {
            j = Math.max(0, Math.min(Integer.valueOf(s).intValue(), 100));
        }
        s = a.a(attributes, new String[] {
            "vs"
        });
        boolean flag;
        if (s != null)
        {
            flag = Boolean.valueOf(s).booleanValue();
        } else
        {
            flag = true;
        }
        if (a.a(attributes, new String[] {
    "sd"
}) == null)
        {
            flag1 = false;
        }
        attributes = new cxy(byte0, i, j, flag, flag1);
        bmz1.a(k).b.a(l, attributes);
_L2:
        return;
_L6:
        byte0 = 9;
          goto _L4
_L7:
        byte0 = 10;
          goto _L4
_L8:
        byte0 = 12;
          goto _L4
_L9:
        byte0 = 17;
          goto _L4
_L10:
        byte0 = 18;
          goto _L4
_L11:
        byte0 = 20;
          goto _L4
_L12:
        byte0 = 33;
          goto _L4
_L13:
        byte0 = 34;
          goto _L4
        byte0 = 36;
          goto _L4
    }
}
