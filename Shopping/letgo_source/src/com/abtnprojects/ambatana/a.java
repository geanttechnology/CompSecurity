// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana;

import android.content.Context;
import android.content.Intent;
import android.support.v7.dl;
import com.parse.ParseUser;

public class com.abtnprojects.ambatana.a
{
    public static final class a extends Enum
    {

        public static final a a;
        private static final a c[];
        private String b;

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/abtnprojects/ambatana/a$a, s);
        }

        public static a[] values()
        {
            return (a[])c.clone();
        }

        public String toString()
        {
            return b;
        }

        static 
        {
            a = new a("UNREAD_MESSAGES_COUNT", 0, "UNREAD_MESSAGES_COUNT");
            c = (new a[] {
                a
            });
        }

        private a(String s, int i, String s1)
        {
            super(s, i);
            b = (new StringBuilder()).append("com.abtnprojects.ambatana.utils.").append(s1).toString();
        }
    }

    public static final class b extends Enum
    {

        public static final b a;
        private static final b c[];
        private String b;

        public static b valueOf(String s)
        {
            return (b)Enum.valueOf(com/abtnprojects/ambatana/a$b, s);
        }

        public static b[] values()
        {
            return (b[])c.clone();
        }

        public String toString()
        {
            return b;
        }

        static 
        {
            a = new b("UNREAD_MESSAGES_COUNT", 0, "UNREAD_MESSAGES_COUNT");
            c = (new b[] {
                a
            });
        }

        private b(String s, int i, String s1)
        {
            super(s, i);
            b = s1;
        }
    }


    private static com.abtnprojects.ambatana.a a;
    private Context b;
    private int c;

    private com.abtnprojects.ambatana.a(Context context)
    {
        b = context.getApplicationContext();
    }

    static int a(com.abtnprojects.ambatana.a a1, int i)
    {
        a1.c = i;
        return i;
    }

    static Context a(com.abtnprojects.ambatana.a a1)
    {
        return a1.b;
    }

    public static com.abtnprojects.ambatana.a a(Context context)
    {
        com/abtnprojects/ambatana/a;
        JVM INSTR monitorenter ;
        if (a == null)
        {
            a = new com.abtnprojects.ambatana.a(context);
        }
        context = a;
        com/abtnprojects/ambatana/a;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    public int a()
    {
        return c;
    }

    public void b()
    {
        (new dl(ParseUser.getCurrentUser().getSessionToken())).a(new android.support.v7.dl.a() {

            final com.abtnprojects.ambatana.a a;

            public void a()
            {
            }

            public void a(int i)
            {
                com.abtnprojects.ambatana.a.a(a, i);
                Intent intent = new Intent();
                intent.setAction(a.a.toString());
                intent.putExtra(b.a.toString(), i);
                com.abtnprojects.ambatana.a.a(a).sendBroadcast(intent);
            }

            
            {
                a = com.abtnprojects.ambatana.a.this;
                super();
            }
        });
    }
}
