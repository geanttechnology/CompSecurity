// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.ab;

import android.content.Context;

// Referenced classes of package it.sephiroth.android.library.ab:
//            ABSettingsFactory, ABTest

public class AB
{
    public static final class Group extends Enum
    {

        private static final Group $VALUES[];
        public static final Group GroupA;
        public static final Group GroupB;

        public static Group valueOf(String s)
        {
            return (Group)Enum.valueOf(it/sephiroth/android/library/ab/AB$Group, s);
        }

        public static Group[] values()
        {
            return (Group[])$VALUES.clone();
        }

        static 
        {
            GroupA = new Group("GroupA", 0);
            GroupB = new Group("GroupB", 1);
            $VALUES = (new Group[] {
                GroupA, GroupB
            });
        }

        private Group(String s, int i)
        {
            super(s, i);
        }
    }


    public static final boolean LOG_ENABLED = false;
    public static final String LOG_TAG = "AB";
    public static final String VERSION = "2.0.3-SNAPSHOT";
    private static AB instance;
    private Group group;
    private final int hashCode;
    private final ABSettingsFactory.ABSettingsManager manager;

    AB(Context context)
    {
        manager = setup(context);
        hashCode = manager.getUUID().hashCode();
    }

    private Group generateGroup()
    {
        if (hashCode % 2 == 0)
        {
            return Group.GroupA;
        } else
        {
            return Group.GroupB;
        }
    }

    public static AB getInstance(Context context)
    {
        if (instance != null) goto _L2; else goto _L1
_L1:
        it/sephiroth/android/library/ab/AB;
        JVM INSTR monitorenter ;
        if (instance != null) goto _L4; else goto _L3
_L3:
        it/sephiroth/android/library/ab/AB;
        JVM INSTR monitorenter ;
        instance = new AB(context);
        it/sephiroth/android/library/ab/AB;
        JVM INSTR monitorexit ;
_L4:
        it/sephiroth/android/library/ab/AB;
        JVM INSTR monitorexit ;
_L2:
        return instance;
        context;
        it/sephiroth/android/library/ab/AB;
        JVM INSTR monitorexit ;
        throw context;
        context;
        it/sephiroth/android/library/ab/AB;
        JVM INSTR monitorexit ;
        throw context;
    }

    private ABSettingsFactory.ABSettingsManager setup(Context context)
    {
        return ABSettingsFactory.create(context);
    }

    public void doABTest(CharSequence charsequence, ABTest abtest)
    {
        abtest.run(charsequence, getGroup());
    }

    public Group getGroup()
    {
        if (group == null)
        {
            group = generateGroup();
        }
        return group;
    }

    public String getUUID()
    {
        return manager.getUUID();
    }
}
