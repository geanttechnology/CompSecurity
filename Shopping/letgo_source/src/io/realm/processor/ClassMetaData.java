// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm.processor;

import io.realm.annotations.Ignore;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

// Referenced classes of package io.realm.processor:
//            Utils

public class ClassMetaData
{

    private String className;
    private final TypeElement classType;
    private Set expectedGetters;
    private Set expectedSetters;
    private List fieldNames;
    private List fields;
    private Map getters;
    private boolean hasDefaultConstructor;
    private List ignoreFieldNames;
    private List indexedFields;
    private Set methods;
    private String packageName;
    private VariableElement primaryKey;
    private Map setters;
    private final Types typeUtils;
    private final List validPrimaryKeyTypes;

    public ClassMetaData(ProcessingEnvironment processingenvironment, TypeElement typeelement)
    {
        fields = new ArrayList();
        fieldNames = new ArrayList();
        ignoreFieldNames = new ArrayList();
        indexedFields = new ArrayList();
        expectedGetters = new HashSet();
        expectedSetters = new HashSet();
        methods = new HashSet();
        getters = new HashMap();
        setters = new HashMap();
        classType = typeelement;
        className = typeelement.getSimpleName().toString();
        typeUtils = processingenvironment.getTypeUtils();
        validPrimaryKeyTypes = Arrays.asList(new TypeMirror[] {
            processingenvironment.getElementUtils().getTypeElement("java.lang.String").asType(), typeUtils.getPrimitiveType(TypeKind.SHORT), typeUtils.getPrimitiveType(TypeKind.INT), typeUtils.getPrimitiveType(TypeKind.LONG)
        });
    }

    private boolean categorizeClassElements()
    {
        Iterator iterator = classType.getEnclosedElements().iterator();
label0:
        do
        {
            Object obj;
            Object obj1;
label1:
            {
                String s;
label2:
                {
label3:
                    {
label4:
                        {
                            if (!iterator.hasNext())
                            {
                                break label0;
                            }
                            obj = (Element)iterator.next();
                            obj1 = ((Element) (obj)).getKind();
                            if (!((ElementKind) (obj1)).equals(ElementKind.FIELD))
                            {
                                break label1;
                            }
                            obj1 = (VariableElement)obj;
                            s = ((VariableElement) (obj1)).getSimpleName().toString();
                            if (((VariableElement) (obj1)).getModifiers().contains(Modifier.STATIC))
                            {
                                continue;
                            }
                            if (((VariableElement) (obj1)).getAnnotation(io/realm/annotations/Ignore) != null)
                            {
                                obj = ((VariableElement) (obj1)).getSimpleName().toString();
                                fieldNames.add(obj);
                                ignoreFieldNames.add(obj);
                                continue;
                            }
                            if (((VariableElement) (obj1)).getAnnotation(io/realm/annotations/Index) != null)
                            {
                                if (!((VariableElement) (obj1)).asType().toString().equals("java.lang.String"))
                                {
                                    break label4;
                                }
                                indexedFields.add(obj1);
                            }
                            if (((VariableElement) (obj1)).getAnnotation(io/realm/annotations/PrimaryKey) == null)
                            {
                                break label2;
                            }
                            if (primaryKey != null)
                            {
                                Utils.error(String.format("@PrimaryKey cannot be defined more than once. It was found here \"%s\" and here \"%s\"", new Object[] {
                                    primaryKey.getSimpleName().toString(), ((VariableElement) (obj1)).getSimpleName().toString()
                                }));
                                return false;
                            }
                            break label3;
                        }
                        Utils.error((new StringBuilder()).append("@Index is only applicable to String fields - got ").append(obj).toString());
                        return false;
                    }
                    if (!isValidPrimaryKeyType(((VariableElement) (obj1)).asType()))
                    {
                        Utils.error((new StringBuilder()).append("\"").append(((VariableElement) (obj1)).getSimpleName().toString()).append("\" is not allowed as primary key. See @PrimaryKey for allowed types.").toString());
                        return false;
                    }
                    primaryKey = ((VariableElement) (obj1));
                    if (Utils.isString(((VariableElement) (obj1))) && !indexedFields.contains(obj1))
                    {
                        indexedFields.add(obj1);
                    }
                }
                if (!((VariableElement) (obj1)).getModifiers().contains(Modifier.PRIVATE))
                {
                    Utils.error("The fields of the model must be private", ((Element) (obj1)));
                    return false;
                }
                fields.add(obj1);
                expectedGetters.add(s);
                expectedSetters.add(s);
                continue;
            }
            if (((ElementKind) (obj1)).equals(ElementKind.CONSTRUCTOR))
            {
                boolean flag;
                if (hasDefaultConstructor || Utils.isDefaultConstructor(((Element) (obj))))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                hasDefaultConstructor = flag;
            } else
            if (((ElementKind) (obj1)).equals(ElementKind.METHOD))
            {
                obj = (ExecutableElement)obj;
                methods.add(obj);
            }
        } while (true);
        VariableElement variableelement;
        for (Iterator iterator1 = fields.iterator(); iterator1.hasNext(); fieldNames.add(variableelement.getSimpleName().toString()))
        {
            variableelement = (VariableElement)iterator1.next();
        }

        if (fields.size() == 0)
        {
            Utils.error((new StringBuilder()).append(className).append(" must contain at least 1 persistable field").toString());
        }
        return true;
    }

    private boolean checkDefaultConstructor()
    {
        if (!hasDefaultConstructor)
        {
            Utils.error("A default public constructor with no argument must be declared if a custom constructor is declared.");
            return false;
        } else
        {
            return true;
        }
    }

    private boolean checkGetterMethod(String s)
    {
        boolean flag;
        boolean flag1;
        flag1 = false;
        flag = flag1;
        if (!s.startsWith("is")) goto _L2; else goto _L1
_L1:
        String s1;
        String s2;
        s1 = s.substring(2);
        s2 = Utils.lowerFirstChar(s1);
        if (!fieldNames.contains(s)) goto _L4; else goto _L3
_L3:
        expectedGetters.remove(s);
        if (!ignoreFieldNames.contains(s))
        {
            getters.put(s, s);
        }
        flag = true;
_L2:
        if (flag || !s.startsWith("get")) goto _L6; else goto _L5
_L5:
        s1 = s.substring(3);
        s2 = Utils.lowerFirstChar(s1);
        if (!fieldNames.contains(s1)) goto _L8; else goto _L7
_L7:
        expectedGetters.remove(s1);
        if (!ignoreFieldNames.contains(s1))
        {
            getters.put(s1, s);
        }
_L11:
        return true;
_L4:
        if (fieldNames.contains(s1))
        {
            expectedGetters.remove(s1);
            if (!ignoreFieldNames.contains(s1))
            {
                getters.put(s1, s);
            }
            flag = true;
        } else
        {
            flag = flag1;
            if (fieldNames.contains(s2))
            {
                expectedGetters.remove(s2);
                if (!ignoreFieldNames.contains(s2))
                {
                    getters.put(s2, s);
                }
                flag = true;
            }
        }
        continue; /* Loop/switch isn't completed */
_L8:
        if (!fieldNames.contains(s2)) goto _L6; else goto _L9
_L9:
        expectedGetters.remove(s2);
        if (ignoreFieldNames.contains(s2)) goto _L11; else goto _L10
_L10:
        getters.put(s2, s);
        return true;
_L6:
        return flag;
        if (true) goto _L2; else goto _L12
_L12:
    }

    private boolean checkMethods()
    {
        for (Iterator iterator = methods.iterator(); iterator.hasNext();)
        {
            ExecutableElement executableelement = (ExecutableElement)iterator.next();
            String s = executableelement.getSimpleName().toString();
            Set set = executableelement.getModifiers();
            if (!set.contains(Modifier.STATIC))
            {
                if (!set.contains(Modifier.PUBLIC))
                {
                    Utils.error("The methods of the model must be public", executableelement);
                    return false;
                }
                if (s.startsWith("get") || s.startsWith("is"))
                {
                    if (!checkGetterMethod(s))
                    {
                        Utils.error(String.format("Getter %s is not associated to any field", new Object[] {
                            s
                        }), executableelement);
                        return false;
                    }
                } else
                if (s.startsWith("set"))
                {
                    if (!checkSetterMethod(s))
                    {
                        Utils.error(String.format("Setter %s is not associated to any field", new Object[] {
                            s
                        }), executableelement);
                        return false;
                    }
                } else
                {
                    Utils.error("Only getters and setters should be defined in model classes", executableelement);
                    return false;
                }
            }
        }

        return true;
    }

    private boolean checkRequireSetters()
    {
        String s;
        for (Iterator iterator = expectedSetters.iterator(); iterator.hasNext(); Utils.error((new StringBuilder()).append("No setter found for field ").append(s).toString()))
        {
            s = (String)iterator.next();
        }

        return expectedSetters.size() == 0;
    }

    private boolean checkRequiredGetters()
    {
        String s;
        for (Iterator iterator = expectedGetters.iterator(); iterator.hasNext(); Utils.error((new StringBuilder()).append("No getter found for field ").append(s).toString()))
        {
            s = (String)iterator.next();
        }

        return expectedGetters.size() == 0;
    }

    private boolean checkSetterMethod(String s)
    {
        String s1;
        String s2;
        String s3;
        s1 = s.substring(3);
        s2 = Utils.lowerFirstChar(s1);
        s3 = (new StringBuilder()).append("is").append(s1).toString();
        if (!fieldNames.contains(s1)) goto _L2; else goto _L1
_L1:
        expectedSetters.remove(s1);
        if (!ignoreFieldNames.contains(s1))
        {
            setters.put(s1, s);
        }
_L4:
        return true;
_L2:
        if (!fieldNames.contains(s2))
        {
            break; /* Loop/switch isn't completed */
        }
        expectedSetters.remove(s2);
        if (!ignoreFieldNames.contains(s2))
        {
            setters.put(s2, s);
            return true;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (fieldNames.contains(s3))
        {
            expectedSetters.remove(s3);
            if (!ignoreFieldNames.contains(s3))
            {
                setters.put(s3, s);
                return true;
            }
        } else
        {
            return false;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    private boolean isValidPrimaryKeyType(TypeMirror typemirror)
    {
        for (Iterator iterator = validPrimaryKeyTypes.iterator(); iterator.hasNext();)
        {
            TypeMirror typemirror1 = (TypeMirror)iterator.next();
            if (typeUtils.isAssignable(typemirror, typemirror1))
            {
                return true;
            }
        }

        return false;
    }

    public boolean generate()
    {
        Element element = classType.getEnclosingElement();
        if (!element.getKind().equals(ElementKind.PACKAGE))
        {
            Utils.error("The RealmClass annotation does not support nested classes", classType);
            return false;
        }
        if (!((TypeElement)Utils.getSuperClass(classType)).toString().endsWith(".RealmObject"))
        {
            Utils.error("A RealmClass annotated object must be derived from RealmObject", classType);
            return false;
        }
        packageName = ((PackageElement)element).getQualifiedName().toString();
        if (!categorizeClassElements())
        {
            return false;
        }
        if (!checkMethods())
        {
            return false;
        }
        if (!checkDefaultConstructor())
        {
            return false;
        }
        if (!checkRequiredGetters())
        {
            return false;
        }
        return checkRequireSetters();
    }

    public List getFields()
    {
        return fields;
    }

    public String getFullyQualifiedClassName()
    {
        return (new StringBuilder()).append(packageName).append(".").append(className).toString();
    }

    public String getGetter(String s)
    {
        return (String)getters.get(s);
    }

    public List getIndexedFields()
    {
        return indexedFields;
    }

    public VariableElement getPrimaryKey()
    {
        return primaryKey;
    }

    public String getPrimaryKeyGetter()
    {
        return (String)getters.get(primaryKey.getSimpleName().toString());
    }

    public String getSetter(String s)
    {
        return (String)setters.get(s);
    }

    public String getSimpleClassName()
    {
        return className;
    }

    public boolean hasPrimaryKey()
    {
        return primaryKey != null;
    }

    public boolean isModelClass()
    {
        return !classType.toString().endsWith(".RealmObject") && !classType.toString().endsWith("RealmProxy");
    }
}
