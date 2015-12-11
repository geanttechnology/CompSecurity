// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.text.TextUtils;
import java.util.List;

public final class cmf extends apu
    implements anm
{

    private boolean a;
    private String b;

    public cmf(String s)
    {
        a = false;
        b = s;
    }

    public final void a(int i, Object obj)
    {
        if (i == 0 && ((obj instanceof String) || obj == null))
        {
            b = (String)obj;
        }
    }

    public final void a(List list, long l, app aapp[], apt apt1)
    {
        bxa bxa1;
        bxa bxa2;
        bxa bxa3;
        int i;
        int j;
        boolean flag;
        flag = TextUtils.isEmpty(b);
        bxa2 = null;
        bxa1 = null;
        bxa3 = null;
        j = aapp.length;
        i = 0;
_L2:
        bxa bxa5;
        bxa bxa6;
        bxa bxa7;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        Object obj = aapp[i];
        bxa7 = bxa1;
        bxa6 = bxa2;
        if (!(obj instanceof bxa))
        {
            break MISSING_BLOCK_LABEL_383;
        }
        bxa5 = (bxa)obj;
        obj = bxa2;
        if (bxa2 == null)
        {
            obj = bxa2;
            if (bxa5.g)
            {
                obj = bxa5;
            }
        }
        bxa2 = bxa1;
        if (bxa1 == null)
        {
            bxa2 = bxa5;
        }
        bxa7 = bxa2;
        bxa6 = ((bxa) (obj));
        if (bxa3 != null)
        {
            break MISSING_BLOCK_LABEL_383;
        }
        bxa7 = bxa2;
        bxa6 = ((bxa) (obj));
        if (flag)
        {
            break MISSING_BLOCK_LABEL_383;
        }
        bxa7 = bxa2;
        bxa6 = ((bxa) (obj));
        if (!b.equals(bxa5.f))
        {
            break MISSING_BLOCK_LABEL_383;
        }
        bxa1 = bxa2;
        bxa2 = ((bxa) (obj));
_L18:
        i++;
        bxa3 = bxa5;
        if (true) goto _L2; else goto _L1
_L1:
        bxa bxa4 = bxa3;
        if (bxa3 != null) goto _L4; else goto _L3
_L3:
        if (bxa2 != null)
        {
            bxa1 = bxa2;
        }
        bxa4 = bxa1;
        if (bxa1 != null) goto _L4; else goto _L5
_L5:
        bmo.d("Unable to select audio by language or default or fallback. Giving up");
        apt1.c = aapp[0];
_L17:
        return;
_L4:
        apt1.c = bxa4;
        if (!a)
        {
            a = true;
        } else
        {
            apt1.b = 1;
        }
        j = 1;
_L15:
        if (j >= list.size())
        {
            break; /* Loop/switch isn't completed */
        }
        aapp = ((apv)list.get(j)).a;
        if (!(aapp instanceof bxa)) goto _L7; else goto _L6
_L6:
        aapp = (bxa)aapp;
        if (!TextUtils.isEmpty(bxa4.f)) goto _L9; else goto _L8
_L8:
        if (TextUtils.isEmpty(((bxa) (aapp)).f)) goto _L11; else goto _L10
_L10:
        i = 1;
_L13:
        if (!i)
        {
            break; /* Loop/switch isn't completed */
        }
_L7:
        apt1.a = j;
        return;
_L9:
        if (!bxa4.f.equals(((bxa) (aapp)).f))
        {
            i = 1;
            continue; /* Loop/switch isn't completed */
        }
_L11:
        if (bxa4.g != ((bxa) (aapp)).g)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (true) goto _L13; else goto _L12
_L12:
        j++;
        if (true) goto _L15; else goto _L14
_L14:
        if (true) goto _L17; else goto _L16
_L16:
        bxa1 = bxa7;
        bxa2 = bxa6;
        bxa5 = bxa3;
          goto _L18
    }
}
