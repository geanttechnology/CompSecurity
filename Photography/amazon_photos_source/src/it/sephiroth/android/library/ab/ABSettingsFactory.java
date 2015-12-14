// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.ab;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

// Referenced classes of package it.sephiroth.android.library.ab:
//            ABFilePreference, ABSharedPreference

class ABSettingsFactory
{
    static abstract class ABSettingsManager
    {

        protected static final String DIR_NAME = "ab";
        protected static final String FILE_NAME = ".alpha-beta";
        protected static final String PREF_NAME = "alphabeta";

        protected final UUID generateNew()
        {
            return UUID.randomUUID();
        }

        public abstract String getUUID();

        ABSettingsManager()
        {
        }
    }


    ABSettingsFactory()
    {
    }

    private static boolean canUseFileSystem(Context context)
    {
        context = context.getFilesDir();
        return context != null && context.canRead() && context.canWrite();
    }

    public static ABSettingsManager create(Context context)
    {
        if (!canUseFileSystem(context))
        {
            break MISSING_BLOCK_LABEL_23;
        }
        ABFilePreference abfilepreference = new ABFilePreference(context);
        return abfilepreference;
        IOException ioexception;
        ioexception;
        ioexception.printStackTrace();
        return new ABSharedPreference(context);
    }
}
