// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager;

import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ay;
import java.util.HashMap;

public class RevisionState
{

    private final HashMap a = new HashMap(RevisionType.values().length);

    public RevisionState(ay ay1)
    {
        a.put(RevisionType.a, Integer.valueOf(ay1.h()));
        a.put(RevisionType.b, Integer.valueOf(ay1.i()));
        a.put(RevisionType.c, Integer.valueOf(ay1.g()));
    }

    private class RevisionType extends Enum
    {

        public static final RevisionType a;
        public static final RevisionType b;
        public static final RevisionType c;
        private static final RevisionType d[];

        public static RevisionType valueOf(String s)
        {
            return (RevisionType)Enum.valueOf(com/cyberlink/youcammakeup/kernelctrl/networkmanager/RevisionState$RevisionType, s);
        }

        public static RevisionType[] values()
        {
            return (RevisionType[])d.clone();
        }

        static 
        {
            a = new RevisionType("Notice", 0);
            b = new RevisionType("Ranking", 1);
            c = new RevisionType("Template", 2);
            d = (new RevisionType[] {
                a, b, c
            });
        }

        private RevisionType(String s, int i)
        {
            super(s, i);
        }
    }

}
