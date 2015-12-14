// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jivesoftware.smackx.carbons.packet;

import org.jivesoftware.smack.packet.f;
import org.jivesoftware.smackx.forward.a;

public class CarbonExtension
    implements f
{

    private Direction a;
    private a b;

    public CarbonExtension(Direction direction, a a1)
    {
        a = direction;
        b = a1;
    }

    public String a()
    {
        return a.toString();
    }

    public String b()
    {
        return "urn:xmpp:carbons:2";
    }

    public a c()
    {
        return b;
    }

    public String d()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("<").append(a()).append(" xmlns=\"").append(b()).append("\">");
        stringbuilder.append(b.c());
        stringbuilder.append("</").append(a()).append(">");
        return stringbuilder.toString();
    }

    public CharSequence g()
    {
        return d();
    }

    private class Direction extends Enum
    {

        public static final Direction a;
        public static final Direction b;
        private static final Direction c[];

        public static Direction valueOf(String s)
        {
            return (Direction)Enum.valueOf(org/jivesoftware/smackx/carbons/packet/CarbonExtension$Direction, s);
        }

        public static Direction[] values()
        {
            return (Direction[])c.clone();
        }

        static 
        {
            a = new Direction("received", 0);
            b = new Direction("sent", 1);
            c = (new Direction[] {
                a, b
            });
        }

        private Direction(String s, int i)
        {
            super(s, i);
        }
    }

}
