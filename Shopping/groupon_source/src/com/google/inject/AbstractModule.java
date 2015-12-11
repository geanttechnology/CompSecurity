// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject;

import com.google.inject.binder.AnnotatedBindingBuilder;
import com.google.inject.binder.AnnotatedConstantBindingBuilder;
import com.google.inject.binder.LinkedBindingBuilder;
import com.google.inject.matcher.Matcher;
import com.google.inject.spi.Message;
import com.google.inject.spi.ProvisionListener;
import com.google.inject.spi.TypeConverter;
import com.google.inject.spi.TypeListener;
import java.util.HashMap;
import java.util.Set;
import org.roboguice.shaded.goole.common.base.Preconditions;

// Referenced classes of package com.google.inject:
//            Module, NoOpAnnotatedBindingBuilder, Binder, AnnotationDatabaseFinder, 
//            TypeLiteral, Key, Scope, Stage, 
//            MembersInjector, Provider

public abstract class AbstractModule
    implements Module
{

    private AnnotationDatabaseFinder annotationDatabaseFinder;
    protected Binder binder;
    private AnnotatedBindingBuilder noOpAnnotatedBindingBuilder;

    public AbstractModule()
    {
        noOpAnnotatedBindingBuilder = new NoOpAnnotatedBindingBuilder();
    }

    protected void addError(Message message)
    {
        binder().addError(message);
    }

    protected transient void addError(String s, Object aobj[])
    {
        binder().addError(s, aobj);
    }

    protected void addError(Throwable throwable)
    {
        binder().addError(throwable);
    }

    protected AnnotatedBindingBuilder bind(TypeLiteral typeliteral)
    {
        return binder().bind(typeliteral);
    }

    protected AnnotatedBindingBuilder bind(Class class1)
    {
        if (isInjectable(class1))
        {
            return binder.bind(class1);
        } else
        {
            return noOpAnnotatedBindingBuilder;
        }
    }

    protected LinkedBindingBuilder bind(Key key)
    {
        return binder().bind(key);
    }

    protected AnnotatedConstantBindingBuilder bindConstant()
    {
        return binder().bindConstant();
    }

    protected void bindListener(Matcher matcher, TypeListener typelistener)
    {
        binder().bindListener(matcher, typelistener);
    }

    protected transient void bindListener(Matcher matcher, ProvisionListener aprovisionlistener[])
    {
        binder().bindListener(matcher, aprovisionlistener);
    }

    protected void bindScope(Class class1, Scope scope)
    {
        binder().bindScope(class1, scope);
    }

    protected Binder binder()
    {
        boolean flag;
        if (binder != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkState(flag, "The binder can only be used inside configure()");
        return binder;
    }

    protected abstract void configure();

    public final void configure(Binder binder1)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        if (binder == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkState(flag, "Re-entry is not allowed.");
        binder = (Binder)Preconditions.checkNotNull(binder1, "builder");
        configure();
        binder = null;
        this;
        JVM INSTR monitorexit ;
        return;
        binder1;
        binder = null;
        throw binder1;
        binder1;
        this;
        JVM INSTR monitorexit ;
        throw binder1;
    }

    protected void convertToTypes(Matcher matcher, TypeConverter typeconverter)
    {
        binder().convertToTypes(matcher, typeconverter);
    }

    protected Stage currentStage()
    {
        return binder().currentStage();
    }

    public AnnotationDatabaseFinder getAnnotationDatabaseFinder()
    {
        return annotationDatabaseFinder;
    }

    protected MembersInjector getMembersInjector(TypeLiteral typeliteral)
    {
        return binder().getMembersInjector(typeliteral);
    }

    protected MembersInjector getMembersInjector(Class class1)
    {
        return binder().getMembersInjector(class1);
    }

    protected Provider getProvider(Key key)
    {
        return binder().getProvider(key);
    }

    protected Provider getProvider(Class class1)
    {
        return binder().getProvider(class1);
    }

    protected boolean hasInjectionPointsForAnnotation(Class class1)
    {
        return annotationDatabaseFinder == null || annotationDatabaseFinder.getMapAnnotationToMapClassContainingInjectionToInjectedConstructorSet().containsKey(class1.getName()) || annotationDatabaseFinder.getMapAnnotationToMapClassContainingInjectionToInjectedMethodSet().containsKey(class1.getName()) || annotationDatabaseFinder.getMapAnnotationToMapClassContainingInjectionToInjectedFieldSet().containsKey(class1.getName());
    }

    protected void install(Module module)
    {
        if (annotationDatabaseFinder != null && (module instanceof AbstractModule))
        {
            ((AbstractModule)module).setAnnotationDatabaseFinder(annotationDatabaseFinder);
        }
        binder().install(module);
    }

    protected boolean isInjectable(Class class1)
    {
        return annotationDatabaseFinder == null || annotationDatabaseFinder.getBindableClassesSet().contains(class1.getName());
    }

    protected void requestInjection(Object obj)
    {
        binder().requestInjection(obj);
    }

    protected transient void requestStaticInjection(Class aclass[])
    {
        binder().requestStaticInjection(aclass);
    }

    protected void requireBinding(Key key)
    {
        binder().getProvider(key);
    }

    protected void requireBinding(Class class1)
    {
        binder().getProvider(class1);
    }

    public void setAnnotationDatabaseFinder(AnnotationDatabaseFinder annotationdatabasefinder)
    {
        annotationDatabaseFinder = annotationdatabasefinder;
    }

    protected AnnotatedBindingBuilder superbind(Class class1)
    {
        return binder.bind(class1);
    }
}
