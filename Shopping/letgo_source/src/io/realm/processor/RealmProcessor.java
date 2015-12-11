// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm.processor;

import io.realm.annotations.RealmClass;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;

// Referenced classes of package io.realm.processor:
//            Utils, DefaultModuleGenerator, RealmProxyMediatorGenerator, ModuleMetaData, 
//            RealmVersionChecker, ClassMetaData, RealmProxyClassGenerator

public class RealmProcessor extends AbstractProcessor
{

    Set classesToValidate;
    private boolean hasProcessedModules;

    public RealmProcessor()
    {
        classesToValidate = new HashSet();
        hasProcessedModules = false;
    }

    private boolean createDefaultModule()
    {
        Utils.note("Creating DefaultRealmModule");
        DefaultModuleGenerator defaultmodulegenerator = new DefaultModuleGenerator(processingEnv);
        try
        {
            defaultmodulegenerator.generate();
        }
        catch (IOException ioexception)
        {
            Utils.error(ioexception.getMessage());
            return false;
        }
        return true;
    }

    private boolean createMediator(String s, Set set)
    {
        s = new RealmProxyMediatorGenerator(processingEnv, s, set);
        try
        {
            s.generate();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Utils.error(s.getMessage());
            return false;
        }
        return true;
    }

    private boolean processModules(RoundEnvironment roundenvironment)
    {
        roundenvironment = new ModuleMetaData(roundenvironment, classesToValidate);
        if (!roundenvironment.generate(processingEnv))
        {
            return false;
        }
        if (roundenvironment.shouldCreateDefaultModule() && !createDefaultModule())
        {
            return false;
        }
        for (roundenvironment = roundenvironment.getAllModules().entrySet().iterator(); roundenvironment.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)roundenvironment.next();
            if (!createMediator(Utils.stripPackage((String)entry.getKey()), (Set)entry.getValue()))
            {
                return false;
            }
        }

        return true;
    }

    public SourceVersion getSupportedSourceVersion()
    {
        return SourceVersion.latestSupported();
    }

    public boolean process(Set set, RoundEnvironment roundenvironment)
    {
        if (hasProcessedModules)
        {
            return true;
        }
        RealmVersionChecker.getInstance(processingEnv).executeRealmVersionUpdate();
        Utils.initialize(processingEnv);
        set = roundenvironment.getElementsAnnotatedWith(io/realm/annotations/RealmClass).iterator();
        do
        {
            if (!set.hasNext())
            {
                break;
            }
            Element element = (Element)set.next();
            if (!element.getKind().equals(ElementKind.CLASS))
            {
                Utils.error("The RealmClass annotation can only be applied to classes", element);
            }
            Object obj = new ClassMetaData(processingEnv, (TypeElement)element);
            if (((ClassMetaData) (obj)).isModelClass())
            {
                Utils.note((new StringBuilder()).append("Processing class ").append(((ClassMetaData) (obj)).getSimpleClassName()).toString());
                if (!((ClassMetaData) (obj)).generate())
                {
                    return true;
                }
                classesToValidate.add(obj);
                obj = new RealmProxyClassGenerator(processingEnv, ((ClassMetaData) (obj)));
                try
                {
                    ((RealmProxyClassGenerator) (obj)).generate();
                }
                catch (IOException ioexception)
                {
                    Utils.error(ioexception.getMessage(), element);
                }
                catch (UnsupportedOperationException unsupportedoperationexception)
                {
                    Utils.error(unsupportedoperationexception.getMessage(), element);
                }
            }
        } while (true);
        hasProcessedModules = true;
        return processModules(roundenvironment);
    }
}
