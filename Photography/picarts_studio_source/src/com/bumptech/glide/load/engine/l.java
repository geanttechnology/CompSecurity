// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;

public abstract class l
{

    public static final l a = new l() {

        public final boolean a()
        {
            return true;
        }

        public final boolean a(DataSource datasource)
        {
            return datasource == DataSource.REMOTE;
        }

        public final boolean a(boolean flag, DataSource datasource, EncodeStrategy encodestrategy)
        {
            return datasource != DataSource.RESOURCE_DISK_CACHE && datasource != DataSource.MEMORY_CACHE;
        }

        public final boolean b()
        {
            return true;
        }

    };
    public static final l b = new l() {

        public final boolean a()
        {
            return false;
        }

        public final boolean a(DataSource datasource)
        {
            return false;
        }

        public final boolean a(boolean flag, DataSource datasource, EncodeStrategy encodestrategy)
        {
            return false;
        }

        public final boolean b()
        {
            return false;
        }

    };
    public static final l c = new l() {

        public final boolean a()
        {
            return false;
        }

        public final boolean a(DataSource datasource)
        {
            return datasource != DataSource.DATA_DISK_CACHE && datasource != DataSource.MEMORY_CACHE;
        }

        public final boolean a(boolean flag, DataSource datasource, EncodeStrategy encodestrategy)
        {
            return false;
        }

        public final boolean b()
        {
            return true;
        }

    };
    public static final l d = new l() {

        public final boolean a()
        {
            return true;
        }

        public final boolean a(DataSource datasource)
        {
            return true;
        }

        public final boolean a(boolean flag, DataSource datasource, EncodeStrategy encodestrategy)
        {
            return datasource != DataSource.RESOURCE_DISK_CACHE && datasource != DataSource.MEMORY_CACHE;
        }

        public final boolean b()
        {
            return false;
        }

    };
    public static final l e = new l() {

        public final boolean a()
        {
            return true;
        }

        public final boolean a(DataSource datasource)
        {
            return datasource == DataSource.REMOTE;
        }

        public final boolean a(boolean flag, DataSource datasource, EncodeStrategy encodestrategy)
        {
            return (flag && datasource == DataSource.DATA_DISK_CACHE || datasource == DataSource.LOCAL) && encodestrategy == EncodeStrategy.TRANSFORMED;
        }

        public final boolean b()
        {
            return true;
        }

    };

    public l()
    {
    }

    public abstract boolean a();

    public abstract boolean a(DataSource datasource);

    public abstract boolean a(boolean flag, DataSource datasource, EncodeStrategy encodestrategy);

    public abstract boolean b();

}
