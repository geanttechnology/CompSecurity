// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            zzsg, zzrw, zzse, zzsh, 
//            zzrx

public class zzrz
{

    public final int tag;
    protected final int type;
    protected final Class zzbil;
    protected final boolean zzbim;

    private zzrz(int i, Class class1, int j, boolean flag)
    {
        type = i;
        zzbil = class1;
        tag = j;
        zzbim = flag;
    }

    private Object zzF(List list)
    {
        ArrayList arraylist;
        boolean flag;
        int k;
        flag = false;
        arraylist = new ArrayList();
        for (int i = 0; i < list.size(); i++)
        {
            zzsg zzsg1 = (zzsg)list.get(i);
            if (zzsg1.zzbiw.length != 0)
            {
                zza(zzsg1, arraylist);
            }
        }

        k = arraylist.size();
        if (k != 0) goto _L2; else goto _L1
_L1:
        list = null;
_L4:
        return list;
_L2:
        Object obj = zzbil.cast(Array.newInstance(zzbil.getComponentType(), k));
        int j = ((flag) ? 1 : 0);
        do
        {
            list = ((List) (obj));
            if (j >= k)
            {
                continue;
            }
            Array.set(obj, j, arraylist.get(j));
            j++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    private Object zzG(List list)
    {
        if (list.isEmpty())
        {
            return null;
        } else
        {
            list = (zzsg)list.get(list.size() - 1);
            return zzbil.cast(zzF(zzrw.zzB(((zzsg) (list)).zzbiw)));
        }
    }

    public static zzrz zza(int i, Class class1, long l)
    {
        return new zzrz(i, class1, (int)l, false);
    }

    final Object zzE(List list)
    {
        if (list == null)
        {
            return null;
        }
        if (zzbim)
        {
            return zzF(list);
        } else
        {
            return zzG(list);
        }
    }

    protected Object zzF(zzrw zzrw1)
    {
        Class class1;
        if (zzbim)
        {
            class1 = zzbil.getComponentType();
        } else
        {
            class1 = zzbil;
        }
        type;
        JVM INSTR tableswitch 10 11: default 176
    //                   10 101
    //                   11 123;
           goto _L1 _L2 _L3
_L1:
        throw new IllegalArgumentException((new StringBuilder("Unknown type ")).append(type).toString());
_L2:
        zzse zzse1;
        try
        {
            zzse1 = (zzse)class1.newInstance();
            zzrw1.zza(zzse1, zzsh.zzlV(tag));
        }
        // Misplaced declaration of an exception variable
        catch (zzrw zzrw1)
        {
            throw new IllegalArgumentException((new StringBuilder("Error creating instance of class ")).append(class1).toString(), zzrw1);
        }
        // Misplaced declaration of an exception variable
        catch (zzrw zzrw1)
        {
            throw new IllegalArgumentException((new StringBuilder("Error creating instance of class ")).append(class1).toString(), zzrw1);
        }
        // Misplaced declaration of an exception variable
        catch (zzrw zzrw1)
        {
            throw new IllegalArgumentException("Error reading extension field", zzrw1);
        }
        return zzse1;
_L3:
        zzse1 = (zzse)class1.newInstance();
        zzrw1.zza(zzse1);
        return zzse1;
    }

    int zzX(Object obj)
    {
        if (zzbim)
        {
            return zzY(obj);
        } else
        {
            return zzZ(obj);
        }
    }

    protected int zzY(Object obj)
    {
        int j = 0;
        int l = Array.getLength(obj);
        for (int i = 0; i < l;)
        {
            int k = j;
            if (Array.get(obj, i) != null)
            {
                k = j + zzZ(Array.get(obj, i));
            }
            i++;
            j = k;
        }

        return j;
    }

    protected int zzZ(Object obj)
    {
        int i = zzsh.zzlV(tag);
        switch (type)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder("Unknown type ")).append(type).toString());

        case 10: // '\n'
            return zzrx.zzb(i, (zzse)obj);

        case 11: // '\013'
            return zzrx.zzc(i, (zzse)obj);
        }
    }

    protected void zza(zzsg zzsg1, List list)
    {
        list.add(zzF(zzrw.zzB(zzsg1.zzbiw)));
    }

    void zza(Object obj, zzrx zzrx1)
    {
        if (zzbim)
        {
            zzc(obj, zzrx1);
            return;
        } else
        {
            zzb(obj, zzrx1);
            return;
        }
    }

    protected void zzb(Object obj, zzrx zzrx1)
    {
        zzrx1.zzlN(tag);
        type;
        JVM INSTR tableswitch 10 11: default 107
    //                   10 73
    //                   11 98;
           goto _L1 _L2 _L3
_L1:
        throw new IllegalArgumentException((new StringBuilder("Unknown type ")).append(type).toString());
_L2:
        try
        {
            obj = (zzse)obj;
            int i = zzsh.zzlV(tag);
            zzrx1.zzb(((zzse) (obj)));
            zzrx1.zzC(i, 4);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new IllegalStateException(((Throwable) (obj)));
        }
_L3:
        zzrx1.zzc((zzse)obj);
        return;
    }

    protected void zzc(Object obj, zzrx zzrx1)
    {
        int j = Array.getLength(obj);
        for (int i = 0; i < j; i++)
        {
            Object obj1 = Array.get(obj, i);
            if (obj1 != null)
            {
                zzb(obj1, zzrx1);
            }
        }

    }
}
