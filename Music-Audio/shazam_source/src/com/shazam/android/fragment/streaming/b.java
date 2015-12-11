// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.fragment.streaming;

import android.view.View;

public interface b
{
    public static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        private static final a d[];
        public final com.shazam.android.analytics.event.factory.StreamingEventFactory.StreamingEventAction c;

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/shazam/android/fragment/streaming/b$a, s);
        }

        public static a[] values()
        {
            return (a[])d.clone();
        }

        static 
        {
            a = new a("INITIALIZE", 0, com.shazam.android.analytics.event.factory.StreamingEventFactory.StreamingEventAction.CONNECT);
            b = new a("PROGRESS", 1, com.shazam.android.analytics.event.factory.StreamingEventFactory.StreamingEventAction.CONNECT);
            d = (new a[] {
                a, b
            });
        }

        private a(String s, int i, com.shazam.android.analytics.event.factory.StreamingEventFactory.StreamingEventAction streamingeventaction)
        {
            super(s, i);
            c = streamingeventaction;
        }
    }


    public abstract void a();

    public abstract void a(View view, com.shazam.android.activities.streaming.b b1);

    public abstract void b();

    public abstract a c();
}
