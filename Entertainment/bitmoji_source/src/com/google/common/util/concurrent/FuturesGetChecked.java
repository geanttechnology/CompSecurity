// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.util.concurrent;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Ordering;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

// Referenced classes of package com.google.common.util.concurrent:
//            ExecutionError, UncheckedExecutionException

final class FuturesGetChecked
{
    static interface GetCheckedTypeValidator
    {

        public abstract void validateClass(Class class1);
    }

    static class GetCheckedTypeValidatorHolder
    {

        static final GetCheckedTypeValidator BEST_VALIDATOR = getBestValidator();
        static final String CLASS_VALUE_VALIDATOR_NAME = String.valueOf(com/google/common/util/concurrent/FuturesGetChecked$GetCheckedTypeValidatorHolder.getName()).concat("$ClassValueValidator");

        static GetCheckedTypeValidator getBestValidator()
        {
            GetCheckedTypeValidator getcheckedtypevalidator;
            try
            {
                getcheckedtypevalidator = (GetCheckedTypeValidator)Class.forName(CLASS_VALUE_VALIDATOR_NAME).getEnumConstants()[0];
            }
            catch (Throwable throwable)
            {
                return FuturesGetChecked.weakSetValidator();
            }
            return getcheckedtypevalidator;
        }


        GetCheckedTypeValidatorHolder()
        {
        }
    }

    static final class GetCheckedTypeValidatorHolder.ClassValueValidator extends Enum
        implements GetCheckedTypeValidator
    {

        private static final GetCheckedTypeValidatorHolder.ClassValueValidator $VALUES[];
        public static final GetCheckedTypeValidatorHolder.ClassValueValidator INSTANCE;
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

        public static GetCheckedTypeValidatorHolder.ClassValueValidator valueOf(String s)
        {
            return (GetCheckedTypeValidatorHolder.ClassValueValidator)Enum.valueOf(com/google/common/util/concurrent/FuturesGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidator, s);
        }

        public static GetCheckedTypeValidatorHolder.ClassValueValidator[] values()
        {
            return (GetCheckedTypeValidatorHolder.ClassValueValidator[])$VALUES.clone();
        }

        public void validateClass(Class class1)
        {
            isValidClass.get(class1);
        }

        static 
        {
            INSTANCE = new GetCheckedTypeValidatorHolder.ClassValueValidator("INSTANCE", 0);
            $VALUES = (new GetCheckedTypeValidatorHolder.ClassValueValidator[] {
                INSTANCE
            });
        }

        private GetCheckedTypeValidatorHolder.ClassValueValidator(String s, int i)
        {
            super(s, i);
        }
    }

    static final class GetCheckedTypeValidatorHolder.WeakSetValidator extends Enum
        implements GetCheckedTypeValidator
    {

        private static final GetCheckedTypeValidatorHolder.WeakSetValidator $VALUES[];
        public static final GetCheckedTypeValidatorHolder.WeakSetValidator INSTANCE;
        private static final Set validClasses = new CopyOnWriteArraySet();

        public static GetCheckedTypeValidatorHolder.WeakSetValidator valueOf(String s)
        {
            return (GetCheckedTypeValidatorHolder.WeakSetValidator)Enum.valueOf(com/google/common/util/concurrent/FuturesGetChecked$GetCheckedTypeValidatorHolder$WeakSetValidator, s);
        }

        public static GetCheckedTypeValidatorHolder.WeakSetValidator[] values()
        {
            return (GetCheckedTypeValidatorHolder.WeakSetValidator[])$VALUES.clone();
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
            INSTANCE = new GetCheckedTypeValidatorHolder.WeakSetValidator("INSTANCE", 0);
            $VALUES = (new GetCheckedTypeValidatorHolder.WeakSetValidator[] {
                INSTANCE
            });
        }

        private GetCheckedTypeValidatorHolder.WeakSetValidator(String s, int i)
        {
            super(s, i);
        }
    }


    private static final Ordering WITH_STRING_PARAM_FIRST = Ordering.natural().onResultOf(new Function() {

        public Boolean apply(Constructor constructor)
        {
            return Boolean.valueOf(Arrays.asList(constructor.getParameterTypes()).contains(java/lang/String));
        }

        public volatile Object apply(Object obj)
        {
            return apply((Constructor)obj);
        }

    }).reverse();

    private FuturesGetChecked()
    {
    }

    private static GetCheckedTypeValidator bestGetCheckedTypeValidator()
    {
        return GetCheckedTypeValidatorHolder.BEST_VALIDATOR;
    }

    static void checkExceptionClassValidity(Class class1)
    {
        Preconditions.checkArgument(isCheckedException(class1), "Futures.getChecked exception type (%s) must not be a RuntimeException", new Object[] {
            class1
        });
        Preconditions.checkArgument(hasConstructorUsableByGetChecked(class1), "Futures.getChecked exception type (%s) must be an accessible class with an accessible constructor whose parameters (if any) must be of type String and/or Throwable", new Object[] {
            class1
        });
    }

    static GetCheckedTypeValidator classValueValidator()
    {
        return GetCheckedTypeValidatorHolder.ClassValueValidator.INSTANCE;
    }

    static Object getChecked(GetCheckedTypeValidator getcheckedtypevalidator, Future future, Class class1)
        throws Exception
    {
        getcheckedtypevalidator.validateClass(class1);
        try
        {
            getcheckedtypevalidator = ((GetCheckedTypeValidator) (future.get()));
        }
        // Misplaced declaration of an exception variable
        catch (GetCheckedTypeValidator getcheckedtypevalidator)
        {
            Thread.currentThread().interrupt();
            throw newWithCause(class1, getcheckedtypevalidator);
        }
        // Misplaced declaration of an exception variable
        catch (GetCheckedTypeValidator getcheckedtypevalidator)
        {
            wrapAndThrowExceptionOrError(getcheckedtypevalidator.getCause(), class1);
            throw new AssertionError();
        }
        return getcheckedtypevalidator;
    }

    static Object getChecked(Future future, Class class1)
        throws Exception
    {
        return getChecked(bestGetCheckedTypeValidator(), future, class1);
    }

    static Object getChecked(Future future, Class class1, long l, TimeUnit timeunit)
        throws Exception
    {
        bestGetCheckedTypeValidator().validateClass(class1);
        try
        {
            future = ((Future) (future.get(l, timeunit)));
        }
        // Misplaced declaration of an exception variable
        catch (Future future)
        {
            Thread.currentThread().interrupt();
            throw newWithCause(class1, future);
        }
        // Misplaced declaration of an exception variable
        catch (Future future)
        {
            throw newWithCause(class1, future);
        }
        // Misplaced declaration of an exception variable
        catch (Future future)
        {
            wrapAndThrowExceptionOrError(future.getCause(), class1);
            throw new AssertionError();
        }
        return future;
    }

    private static boolean hasConstructorUsableByGetChecked(Class class1)
    {
        try
        {
            newWithCause(class1, new Exception());
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            return false;
        }
        return true;
    }

    static boolean isCheckedException(Class class1)
    {
        return !java/lang/RuntimeException.isAssignableFrom(class1);
    }

    private static Object newFromConstructor(Constructor constructor, Throwable throwable)
    {
label0:
        {
            Object obj1 = null;
            Class aclass[] = constructor.getParameterTypes();
            Object aobj[] = new Object[aclass.length];
            int i = 0;
            Object obj;
            while (i < aclass.length) 
            {
                Class class1 = aclass[i];
                if (class1.equals(java/lang/String))
                {
                    aobj[i] = throwable.toString();
                } else
                {
                    obj = obj1;
                    if (!class1.equals(java/lang/Throwable))
                    {
                        break label0;
                    }
                    aobj[i] = throwable;
                }
                i++;
            }
            try
            {
                obj = constructor.newInstance(aobj);
            }
            // Misplaced declaration of an exception variable
            catch (Constructor constructor)
            {
                return null;
            }
            // Misplaced declaration of an exception variable
            catch (Constructor constructor)
            {
                return null;
            }
            // Misplaced declaration of an exception variable
            catch (Constructor constructor)
            {
                return null;
            }
            // Misplaced declaration of an exception variable
            catch (Constructor constructor)
            {
                return null;
            }
        }
        return obj;
    }

    private static Exception newWithCause(Class class1, Throwable throwable)
    {
        for (Iterator iterator = preferringStrings(Arrays.asList(class1.getConstructors())).iterator(); iterator.hasNext();)
        {
            Exception exception = (Exception)newFromConstructor((Constructor)iterator.next(), throwable);
            if (exception != null)
            {
                if (exception.getCause() == null)
                {
                    exception.initCause(throwable);
                }
                return exception;
            }
        }

        class1 = String.valueOf(class1);
        throw new IllegalArgumentException((new StringBuilder(String.valueOf(class1).length() + 82)).append("No appropriate constructor for exception of type ").append(class1).append(" in response to chained exception").toString(), throwable);
    }

    private static List preferringStrings(List list)
    {
        return WITH_STRING_PARAM_FIRST.sortedCopy(list);
    }

    static GetCheckedTypeValidator weakSetValidator()
    {
        return GetCheckedTypeValidatorHolder.WeakSetValidator.INSTANCE;
    }

    private static void wrapAndThrowExceptionOrError(Throwable throwable, Class class1)
        throws Exception
    {
        if (throwable instanceof Error)
        {
            throw new ExecutionError((Error)throwable);
        }
        if (throwable instanceof RuntimeException)
        {
            throw new UncheckedExecutionException(throwable);
        } else
        {
            throw newWithCause(class1, throwable);
        }
    }

}
