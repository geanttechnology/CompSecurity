// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile;


public final class TestOverride
{
    private static final class HelperImpl
        implements TestHelper
    {

        public void initTestFramework()
        {
        }

        public void setUpTest()
        {
            com/ebay/mobile/TestOverride;
            JVM INSTR monitorenter ;
            if (TestOverride.helper != null)
            {
                TestOverride.helper.setUpTest();
            }
            com/ebay/mobile/TestOverride;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            com/ebay/mobile/TestOverride;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void tearDownTest()
        {
            com/ebay/mobile/TestOverride;
            JVM INSTR monitorenter ;
            if (TestOverride.helper != null)
            {
                TestOverride.helper.tearDownTest();
            }
            com/ebay/mobile/TestOverride;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            com/ebay/mobile/TestOverride;
            JVM INSTR monitorexit ;
            throw exception;
        }

        private HelperImpl()
        {
        }

    }

    public static interface TestHelper
    {

        public abstract void initTestFramework();

        public abstract void setUpTest();

        public abstract void tearDownTest();
    }


    static TestHelper helper;
    private static boolean isTest;

    public TestOverride()
    {
    }

    public static TestHelper getTestHelper()
    {
        com/ebay/mobile/TestOverride;
        JVM INSTR monitorenter ;
        if (isTest)
        {
            throw new RuntimeException("Don't call getTestHelper more than once.");
        }
        break MISSING_BLOCK_LABEL_25;
        Exception exception;
        exception;
        com/ebay/mobile/TestOverride;
        JVM INSTR monitorexit ;
        throw exception;
        HelperImpl helperimpl;
        isTest = true;
        init();
        helperimpl = new HelperImpl();
        com/ebay/mobile/TestOverride;
        JVM INSTR monitorexit ;
        return helperimpl;
    }

    private static void init()
    {
        if (isTest && helper != null)
        {
            helper.initTestFramework();
        }
    }

    public static void setTestHelper(TestHelper testhelper)
    {
        com/ebay/mobile/TestOverride;
        JVM INSTR monitorenter ;
        if (testhelper != null)
        {
            break MISSING_BLOCK_LABEL_23;
        }
        throw new IllegalArgumentException("testHelper must not be null.");
        testhelper;
        com/ebay/mobile/TestOverride;
        JVM INSTR monitorexit ;
        throw testhelper;
        if (helper != null)
        {
            throw new RuntimeException("Only call setTestHelper once in Application.onCreate.");
        }
        helper = testhelper;
        init();
        com/ebay/mobile/TestOverride;
        JVM INSTR monitorexit ;
    }
}
