// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.util.concurrent;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

// Referenced classes of package com.google.common.util.concurrent:
//            FuturesGetChecked

static class WeakSetValidator
{
    static final class ClassValueValidator extends Enum
        implements FuturesGetChecked.GetCheckedTypeValidator
    {

        private static final ClassValueValidator $VALUES[];
        public static final ClassValueValidator INSTANCE;
        private static final ClassValue isValidClass = new ClassValue() {

            protected Boolean computeValue(Class class1)
            {
                FuturesGetChecked.checkExceptionClassValidity(class1.asSubclass(java/lang/Exception));
                return Boolean.valueOf(true);
            }

            protected volatile Object computeValue(Class class1)
            {
                return computeValue(class1);
            }

        };

        public static ClassValueValidator valueOf(String s)
        {
            return (ClassValueValidator)Enum.valueOf(com/google/common/util/concurrent/FuturesGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidator, s);
        }

        public static ClassValueValidator[] values()
        {
            return (ClassValueValidator[])$VALUES.clone();
        }

        public void validateClass(Class class1)
        {
            isValidClass.get(class1);
        }

        static 
        {
            INSTANCE = new ClassValueValidator("INSTANCE", 0);
            $VALUES = (new ClassValueValidator[] {
                INSTANCE
            });
        }

        private ClassValueValidator(String s, int i)
        {
            super(s, i);
        }
    }

    static final class WeakSetValidator extends Enum
        implements FuturesGetChecked.GetCheckedTypeValidator
    {

        private static final WeakSetValidator $VALUES[];
        public static final WeakSetValidator INSTANCE;
        private static final Set validClasses = new CopyOnWriteArraySet();

        public static WeakSetValidator valueOf(String s)
        {
            return (WeakSetValidator)Enum.valueOf(com/google/common/util/concurrent/FuturesGetChecked$GetCheckedTypeValidatorHolder$WeakSetValidator, s);
        }

        public static WeakSetValidator[] values()
        {
            return (WeakSetValidator[])$VALUES.clone();
        }

        public void validateClass(Class class1)
        {
            for (Iterator iterator = validClasses.iterator(); iterator.hasNext();)
            {
                if (class1.equals(((WeakReference)iterator.next()).get()))
                {
                    return;
                }
            }

            FuturesGetChecked.checkExceptionClassValidity(class1);
            if (validClasses.size() > 1000)
            {
                validClasses.clear();
            }
            validClasses.add(new WeakReference(class1));
        }

        static 
        {
            INSTANCE = new WeakSetValidator("INSTANCE", 0);
            $VALUES = (new WeakSetValidator[] {
                INSTANCE
            });
        }

        private WeakSetValidator(String s, int i)
        {
            super(s, i);
        }
    }


    static final CLASS_VALUE_VALIDATOR_NAME BEST_VALIDATOR = getBestValidator();
    static final String CLASS_VALUE_VALIDATOR_NAME = String.valueOf(com/google/common/util/concurrent/FuturesGetChecked$GetCheckedTypeValidatorHolder.getName()).concat("$ClassValueValidator");

    static WeakSetValidator getBestValidator()
    {
        WeakSetValidator weaksetvalidator;
        try
        {
            weaksetvalidator = (WeakSetValidator)Class.forName(CLASS_VALUE_VALIDATOR_NAME).getEnumConstants()[0];
        }
        catch (Throwable throwable)
        {
            return FuturesGetChecked.weakSetValidator();
        }
        return weaksetvalidator;
    }


    WeakSetValidator()
    {
    }
}
