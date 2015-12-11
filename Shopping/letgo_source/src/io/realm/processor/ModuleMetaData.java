// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm.processor;

import io.realm.annotations.internal.RealmModule;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;

// Referenced classes of package io.realm.processor:
//            ClassMetaData, Utils

public class ModuleMetaData
{

    private final Set availableClasses;
    private Map classMetaData;
    private final RoundEnvironment env;
    private Map libraryModules;
    private Map modules;
    private boolean shouldCreateDefaultModule;

    public ModuleMetaData(RoundEnvironment roundenvironment, Set set)
    {
        modules = new HashMap();
        libraryModules = new HashMap();
        classMetaData = new HashMap();
        env = roundenvironment;
        availableClasses = set;
        for (roundenvironment = set.iterator(); roundenvironment.hasNext(); classMetaData.put(set.getFullyQualifiedClassName(), set))
        {
            set = (ClassMetaData)roundenvironment.next();
        }

    }

    public boolean generate(ProcessingEnvironment processingenvironment)
    {
        for (Iterator iterator = env.getElementsAnnotatedWith(io/realm/annotations/internal/RealmModule).iterator(); iterator.hasNext();)
        {
            processingenvironment = (Element)iterator.next();
            String s = processingenvironment.getSimpleName().toString();
            if (!processingenvironment.getKind().equals(ElementKind.CLASS))
            {
                Utils.error("The RealmModule annotation can only be applied to classes", processingenvironment);
                return false;
            }
            RealmModule realmmodule = (RealmModule)processingenvironment.getAnnotation(io/realm/annotations/internal/RealmModule);
            Utils.note((new StringBuilder()).append("Processing ").append(s).toString());
            if (realmmodule.allClasses() && realmmodule.classes().length > 0)
            {
                Utils.error((new StringBuilder()).append("Setting @RealmModule(allClasses=true) will override @RealmModule(classes={...}) in ").append(s).toString());
                return false;
            }
            s = ((TypeElement)processingenvironment).getQualifiedName().toString();
            if (realmmodule.allClasses())
            {
                processingenvironment = availableClasses;
            } else
            {
                processingenvironment = new HashSet();
                Class aclass[] = realmmodule.classes();
                int j = aclass.length;
                int i = 0;
                while (i < j) 
                {
                    Object obj = aclass[i];
                    if (!((Class) (obj)).getSuperclass().toString().endsWith("RealmObject"))
                    {
                        Utils.error((new StringBuilder()).append(((Class) (obj)).getSimpleName()).append(" is not extending RealmObject. Only RealmObjects can be ").append("part of a module.").toString());
                        return false;
                    }
                    obj = (ClassMetaData)classMetaData.get(((Class) (obj)).getName());
                    if (obj == null)
                    {
                        Utils.error((new StringBuilder()).append(Utils.stripPackage(s)).append(" could not be added to the module. It is not ").append("possible to add classes which are part of another library.").toString());
                        return false;
                    }
                    processingenvironment.add(obj);
                    i++;
                }
            }
            if (realmmodule.library())
            {
                libraryModules.put(s, processingenvironment);
            } else
            {
                modules.put(s, processingenvironment);
            }
        }

        if (modules.size() > 0 && libraryModules.size() > 0)
        {
            Utils.error("Normal modules and library modules cannot be mixed in the same project");
            return false;
        }
        if (libraryModules.size() == 0)
        {
            shouldCreateDefaultModule = true;
            modules.put("io.realm.DefaultRealmModule", availableClasses);
        }
        return true;
    }

    public Map getAllModules()
    {
        HashMap hashmap = new HashMap();
        hashmap.putAll(modules);
        hashmap.putAll(libraryModules);
        return hashmap;
    }

    public boolean shouldCreateDefaultModule()
    {
        return shouldCreateDefaultModule;
    }
}
