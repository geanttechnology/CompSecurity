// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.auth.api.credentials;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

// Referenced classes of package com.google.android.gms.auth.api.credentials:
//            PasswordSpecification

public class zzSz
{

    private final TreeSet zzSB = new TreeSet();
    private final List zzSw = new ArrayList();
    private final List zzSx = new ArrayList();
    private int zzSy;
    private int zzSz;

    private void zzlL()
    {
        Iterator iterator = zzSx.iterator();
        int i;
        for (i = 0; iterator.hasNext(); i = ((Integer)iterator.next()).intValue() + i) { }
        if (i > zzSz)
        {
            throw new <init>("required character count cannot be greater than the max password size");
        } else
        {
            return;
        }
    }

    private void zzlM()
    {
        boolean aflag[] = new boolean[95];
        for (Iterator iterator = zzSw.iterator(); iterator.hasNext();)
        {
            char ac[] = ((String)iterator.next()).toCharArray();
            int j = ac.length;
            int i = 0;
            while (i < j) 
            {
                char c = ac[i];
                if (aflag[c - 32])
                {
                    throw new <init>((new StringBuilder("character ")).append(c).append(" occurs in more than one required character set").toString());
                }
                aflag[c - 32] = true;
                i++;
            }
        }

    }

    private TreeSet zzr(String s, String s1)
    {
        if (TextUtils.isEmpty(s))
        {
            throw new <init>((new StringBuilder()).append(s1).append(" cannot be null or empty").toString());
        }
        TreeSet treeset = new TreeSet();
        s = s.toCharArray();
        int j = s.length;
        for (int i = 0; i < j; i++)
        {
            char c = s[i];
            if (PasswordSpecification.zzc(c, 32, 126))
            {
                throw new <init>((new StringBuilder()).append(s1).append(" must only contain ASCII printable characters").toString());
            }
            treeset.add(Character.valueOf(c));
        }

        return treeset;
    }

    public <init> zzbD(String s)
    {
        zzSB.addAll(zzr(s, "allowedChars"));
        return this;
    }

    public zzr zzf(String s, int i)
    {
        if (i <= 0)
        {
            throw new <init>("count must be at least 1");
        } else
        {
            s = zzr(s, "requiredChars");
            zzSw.add(PasswordSpecification.zzc(s));
            zzSx.add(Integer.valueOf(i));
            return this;
        }
    }

    public zzSx zzg(int i, int j)
    {
        if (i <= 0)
        {
            throw new <init>("minimumSize must be at least 1");
        }
        if (i > j)
        {
            throw new <init>("maximumSize must be greater than or equal to minimumSize");
        } else
        {
            zzSy = i;
            zzSz = j;
            return this;
        }
    }

    public PasswordSpecification zzlK()
    {
        if (zzSB.isEmpty())
        {
            throw new <init>("no allowed characters specified");
        } else
        {
            zzlL();
            zzlM();
            return new PasswordSpecification(1, PasswordSpecification.zzc(zzSB), zzSw, zzSx, zzSy, zzSz);
        }
    }

    public ()
    {
        zzSy = 12;
        zzSz = 16;
    }
}
