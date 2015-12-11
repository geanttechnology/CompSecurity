// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nielsen.app.sdk;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.nielsen.app.sdk:
//            c, h, a, AppConfig

class AppCache extends SQLiteOpenHelper
{
    public class LogData
    {

        final AppCache a;
        private long b;
        private String c;
        private long d;
        private long e;
        private long f;
        private long g;
        private int h;

        public void addOccurrence(String s1)
        {
            f = e;
            e = d;
            d = com.nielsen.app.sdk.h.g();
            c = s1;
            h = h + 1;
        }

        public void copy(LogData logdata)
        {
            e = logdata.e;
            f = logdata.f;
            d = logdata.d;
            h = logdata.h;
            c = logdata.c;
            b = logdata.b;
            g = logdata.g;
        }

        public int getCount()
        {
            return h;
        }

        public String getInfo()
        {
            return c;
        }

        public long getKey()
        {
            return g;
        }

        public long getLog()
        {
            return b;
        }

        public long getTimestamp()
        {
            return d;
        }

        public long getTimestamp2()
        {
            return e;
        }

        public long getTimestamp3()
        {
            return f;
        }

        public void initialize(long l1)
        {
            initialize(l1, 0, "", 0L, 0L, 0L);
        }

        public void initialize(long l1, int i1, String s1, long l2, long l3, long l4)
        {
            f = l4;
            e = l3;
            d = l2;
            h = i1;
            c = s1;
            b = l1;
        }

        public void setCount(int i1)
        {
            h = i1;
        }

        public void setInfo(String s1)
        {
            c = s1;
        }

        public void setKey(long l1)
        {
            g = l1;
        }

        public void setLog(long l1)
        {
            b = l1;
        }

        public void setTimestamp(long l1)
        {
            d = l1;
        }

        public void setTimestamp2(long l1)
        {
            e = l1;
        }

        public void setTimestamp3(long l1)
        {
            f = l1;
        }

        public LogData(long l1)
        {
            a = AppCache.this;
            super();
            b = 23L;
            c = "";
            d = 0L;
            e = 0L;
            f = 0L;
            g = -1L;
            h = 0;
            initialize(l1);
        }

        public LogData(long l1, int i1, long l2, long l3, long l4, String s1)
        {
            a = AppCache.this;
            super();
            b = 23L;
            c = "";
            d = 0L;
            e = 0L;
            f = 0L;
            g = -1L;
            h = 0;
            initialize(l1, i1, s1, l2, l3, l4);
        }

        public LogData(LogData logdata)
        {
            a = AppCache.this;
            super();
            b = 23L;
            c = "";
            d = 0L;
            e = 0L;
            f = 0L;
            g = -1L;
            h = 0;
            copy(logdata);
        }
    }

    public class ProcessorData
    {

        final AppCache a;
        private char b;
        private int c;
        private int d;
        private long e;
        private String f;
        private long g;

        public String getData()
        {
            return f;
        }

        public long getKey()
        {
            return g;
        }

        public int getMessage()
        {
            retu