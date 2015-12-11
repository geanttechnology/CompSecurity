// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacpp;

import com.googlecode.javacpp.annotation.Adapter;
import com.googlecode.javacpp.annotation.Allocator;
import com.googlecode.javacpp.annotation.ArrayAllocator;
import com.googlecode.javacpp.annotation.ByPtr;
import com.googlecode.javacpp.annotation.ByPtrPtr;
import com.googlecode.javacpp.annotation.ByPtrRef;
import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.ByVal;
import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.Convention;
import com.googlecode.javacpp.annotation.Function;
import com.googlecode.javacpp.annotation.Index;
import com.googlecode.javacpp.annotation.MemberGetter;
import com.googlecode.javacpp.annotation.MemberSetter;
import com.googlecode.javacpp.annotation.Name;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.NoDeallocator;
import com.googlecode.javacpp.annotation.NoException;
import com.googlecode.javacpp.annotation.NoOffset;
import com.googlecode.javacpp.annotation.Opaque;
import com.googlecode.javacpp.annotation.Platform;
import com.googlecode.javacpp.annotation.Properties;
import com.googlecode.javacpp.annotation.Raw;
import com.googlecode.javacpp.annotation.ValueGetter;
import com.googlecode.javacpp.annotation.ValueSetter;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

// Referenced classes of package com.googlecode.javacpp:
//            Pointer, BytePointer, ShortPointer, IntPointer, 
//            LongPointer, FloatPointer, DoublePointer, CharPointer, 
//            PointerPointer, BoolPointer, CLongPointer, SizeTPointer, 
//            FunctionPointer, Loader

public class Generator
    implements Closeable
{
    public static class AdapterInformation
    {

        public int argc;
        public String cast;
        public boolean constant;
        public String name;

        public AdapterInformation()
        {
        }
    }

    public static class LinkedListRegister extends LinkedList
    {

        public int register(Object obj)
        {
            int j = indexOf(obj);
            int i = j;
            if (j < 0)
            {
                add(obj);
                i = size() - 1;
            }
            return i;
        }

        public LinkedListRegister()
        {
        }
    }

    public static class MethodInformation
    {

        public boolean allocator;
        public Annotation annotations[];
        public boolean arrayAllocator;
        public boolean bufferGetter;
        public Class cls;
        public boolean deallocator;
        public int dim;
        public boolean memberGetter;
        public String memberName[];
        public boolean memberSetter;
        public Method method;
        public int modifiers;
        public String name;
        public boolean noOffset;
        public boolean noReturnGetter;
        public boolean overloaded;
        public Method pairedMethod;
        public Annotation parameterAnnotations[][];
        public boolean parameterRaw[];
        public Class parameterTypes[];
        public boolean returnRaw;
        public Class returnType;
        public Class throwsException;
        public boolean valueGetter;
        public boolean valueSetter;
        public boolean withEnv;

        public MethodInformation()
        {
        }
    }


    public static final String JNI_VERSION = "JNI_VERSION_1_6";
    private static final List baseClasses = Arrays.asList(new Class[] {
        com/googlecode/javacpp/Pointer, com/googlecode/javacpp/BytePointer, com/googlecode/javacpp/ShortPointer, com/googlecode/javacpp/IntPointer, com/googlecode/javacpp/LongPointer, com/googlecode/javacpp/FloatPointer, com/googlecode/javacpp/DoublePointer, com/googlecode/javacpp/CharPointer, com/googlecode/javacpp/PointerPointer, com/googlecode/javacpp/BoolPointer, 
        com/googlecode/javacpp/CLongPointer, com/googlecode/javacpp/SizeTPointer
    });
    private static final Logger logger = Logger.getLogger(com/googlecode/javacpp/Generator.getName());
    private LinkedListRegister arrayDeallocators;
    private LinkedListRegister deallocators;
    private LinkedListRegister functionDefinitions;
    private LinkedListRegister functionPointers;
    private LinkedListRegister jclasses;
    private LinkedListRegister jclassesInit;
    private boolean mayThrowExceptions;
    private HashMap members;
    private PrintWriter out;
    private PrintWriter out2;
    private Loader.ClassProperties properties;
    private boolean usesAdapters;

    public Generator(Loader.ClassProperties classproperties)
    {
        properties = classproperties;
    }

    private void doCall(MethodInformation methodinformation, String s)
    {
        String s1;
        String s2;
        String s4;
        int i;
        int j;
        boolean flag;
        if (methodinformation.throwsException != null)
        {
            s4 = "        ";
        } else
        {
            s4 = "    ";
        }
        s2 = "(";
        s1 = ")";
        j = 0;
        i = 0;
        if (methodinformation.method.isAnnotationPresent(com/googlecode/javacpp/annotation/Index) || methodinformation.pairedMethod != null && methodinformation.pairedMethod.isAnnotationPresent(com/googlecode/javacpp/annotation/Index))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (methodinformation.deallocator)
        {
            out.println((new StringBuilder()).append(s4).append("void* allocatedAddress = jlong_to_ptr(arg0);").toString());
            out.println((new StringBuilder()).append(s4).append("void (*deallocatorAddress)(void*) = (void(*)(void*))jlong_to_ptr(arg1);").toString());
            out.println((new StringBuilder()).append(s4).append("if (deallocatorAddress != NULL && allocatedAddress != NULL) {").toString());
            out.println((new StringBuilder()).append(s4).append("    (*deallocatorAddress)(allocatedAddress);").toString());
            out.println((new StringBuilder()).append(s4).append("}").toString());
        } else
        {
            if (methodinformation.valueGetter || methodinformation.valueSetter || methodinformation.memberGetter || methodinformation.memberSetter)
            {
                j = 0;
                int k = methodinformation.parameterTypes.length - 1;
                PrintWriter printwriter1;
                StringBuilder stringbuilder;
                if ((methodinformation.valueSetter || methodinformation.memberSetter) && !(getParameterBy(methodinformation, k) instanceof ByRef) && getParameterAdapterInformation(false, methodinformation, k) == null && methodinformation.parameterTypes[k] == java/lang/String)
                {
                    out.print((new StringBuilder()).append(s4).append("strcpy((char*)").toString());
                    j = 1;
                    s = ", ";
                } else
                if (k >= 1 && methodinformation.parameterTypes[0].isArray() && methodinformation.parameterTypes[0].getComponentType().isPrimitive() && (methodinformation.parameterTypes[1] == Integer.TYPE || methodinformation.parameterTypes[1] == Long.TYPE))
                {
                    out.print((new StringBuilder()).append(s4).append("memcpy(").toString());
                    j = 1;
                    s = ", ";
                    if (methodinformation.memberGetter || methodinformation.valueGetter)
                    {
                        out.print("ptr0 + arg1, ");
                    } else
                    {
                        s = (new StringBuilder()).append(", ").append("ptr0 + arg1, ").toString();
                    }
                    i = 2;
                    s1 = (new StringBuilder()).append(" * sizeof(*ptr0)").append(")").toString();
                } else
                {
                    out.print((new StringBuilder()).append(s4).append(s).toString());
                    if (methodinformation.valueGetter || methodinformation.memberGetter)
                    {
                        s = "";
                    } else
                    {
                        s = " = ";
                    }
                    s1 = "";
                }
                if (Modifier.isStatic(methodinformation.modifiers))
                {
                    out.print(getCPPScopeName(methodinformation));
                } else
                if (methodinformation.memberGetter || methodinformation.memberSetter)
                {
                    if (flag)
                    {
                        out.print("(*ptr)");
                        s = (new StringBuilder()).append(".").append(methodinformation.memberName[0]).append(s).toString();
                    } else
                    {
                        out.print((new StringBuilder()).append("ptr->").append(methodinformation.memberName[0]).toString());
                    }
                } else
                {
                    PrintWriter printwriter2 = out;
                    if (flag)
                    {
                        s2 = "(*ptr)";
                    } else
                    if (methodinformation.dim > 0 || j != 0)
                    {
                        s2 = "ptr";
                    } else
                    {
                        s2 = "*ptr";
                    }
                    printwriter2.print(s2);
                }
            } else
            if (methodinformation.bufferGetter)
            {
                out.print((new StringBuilder()).append(s4).append(s).append("ptr").toString());
                s = "";
                s1 = "";
                i = j;
            } else
            {
                out.print((new StringBuilder()).append(s4).append(s).toString());
                if (com/googlecode/javacpp/FunctionPointer.isAssignableFrom(methodinformation.cls))
                {
                    if (methodinformation.cls.isAnnotationPresent(com/googlecode/javacpp/annotation/Namespace))
                    {
                        out.print("(ptr0->*(ptr->ptr))");
                        i = 1;
                        s = s2;
                    } else
                    {
                        out.print("(*ptr->ptr)");
                        s = s2;
                        i = j;
                    }
                } else
                if (methodinformation.allocator)
                {
                    String as[] = getCPPTypeName(methodinformation.cls);
                    String s5 = getValueTypeName(as);
                    if (methodinformation.cls == com/googlecode/javacpp/Pointer)
                    {
                        s = "";
                        s1 = "";
                        i = j;
                    } else
                    {
                        PrintWriter printwriter3 = out;
                        StringBuilder stringbuilder1 = new StringBuilder();
                        if (getNoException(methodinformation.cls, methodinformation.method))
                        {
                            s = "new (std::nothrow) ";
                        } else
                        {
                            s = "new ";
                        }
                        printwriter3.print(stringbuilder1.append(s).append(s5).append(as[1]).toString());
                        s = s2;
                        i = j;
                        if (methodinformation.arrayAllocator)
                        {
                            s = "[";
                            s1 = "]";
                            i = j;
                        }
                    }
                } else
                if (Modifier.isStatic(methodinformation.modifiers))
                {
                    out.print(getCPPScopeName(methodinformation));
                    s = s2;
                    i = j;
                } else
                if (flag)
                {
                    out.print("(*ptr)");
                    s = (new StringBuilder()).append(".").append(methodinformation.memberName[0]).append("(").toString();
                    i = j;
                } else
                {
                    out.print((new StringBuilder()).append("ptr->").append(methodinformation.memberName[0]).toString());
                    s = s2;
                    i = j;
                }
            }
            j = i;
            while (j < methodinformation.dim) 
            {
                s2 = getParameterCast(methodinformation, j);
                printwriter1 = out;
                stringbuilder = (new StringBuilder()).append("[").append(s2);
                if (methodinformation.parameterTypes[j].isPrimitive())
                {
                    s2 = "arg";
                } else
                {
                    s2 = "ptr";
                }
                printwriter1.print(stringbuilder.append(s2).append(j).append("]").toString());
                j++;
            }
            if (methodinformation.memberName.length > 1)
            {
                out.print(methodinformation.memberName[1]);
            }
            out.print(s);
            if (methodinformation.withEnv)
            {
                PrintWriter printwriter = out;
                if (Modifier.isStatic(methodinformation.modifiers))
                {
                    s = "env, cls";
                } else
                {
                    s = "env, obj";
                }
                printwriter.print(s);
                if (methodinformation.parameterTypes.length - i - methodinformation.dim > 0)
                {
                    out.print(", ");
                }
            }
            i += methodinformation.dim;
            while (i < methodinformation.parameterTypes.length) 
            {
                s = getParameterBy(methodinformation, i);
                String s3 = getParameterCast(methodinformation, i);
                AdapterInformation adapterinformation = getParameterAdapterInformation(false, methodinformation, i);
                if (("(void*)".equals(s3) || "(void *)".equals(s3)) && methodinformation.parameterTypes[i] == Long.TYPE)
                {
                    out.print((new StringBuilder()).append("jlong_to_ptr(arg").append(i).append(")").toString());
                } else
                if (methodinformation.parameterTypes[i].isPrimitive())
                {
                    out.print((new StringBuilder()).append(s3).append("arg").append(i).toString());
                } else
                if (adapterinformation != null)
                {
                    s3 = adapterinformation.cast.trim();
                    s = s3;
                    if (s3.length() > 0)
                    {
                        s = s3;
                        if (!s3.startsWith("("))
                        {
                            s = s3;
                            if (!s3.endsWith(")"))
                            {
                                s = (new StringBuilder()).append("(").append(s3).append(")").toString();
                            }
                        }
                    }
                    out.print((new StringBuilder()).append(s).append("adapter").append(i).toString());
                    i += adapterinformation.argc - 1;
                } else
                if (com/googlecode/javacpp/FunctionPointer.isAssignableFrom(methodinformation.parameterTypes[i]) && s == null)
                {
                    out.print((new StringBuilder()).append(s3).append("(ptr").append(i).append(" == NULL ? NULL : ptr").append(i).append("->ptr)").toString());
                } else
                if ((s instanceof ByVal) || (s instanceof ByRef) && methodinformation.parameterTypes[i] != java/lang/String)
                {
                    out.print((new StringBuilder()).append("*").append(s3).append("ptr").append(i).toString());
                } else
                if (s instanceof ByPtrPtr)
                {
                    out.print((new StringBuilder()).append(s3).append("(arg").append(i).append(" == NULL ? NULL : &ptr").append(i).append(")").toString());
                } else
                {
                    out.print((new StringBuilder()).append(s3).append("ptr").append(i).toString());
                }
                if (i < methodinformation.parameterTypes.length - 1)
                {
                    out.print(", ");
                }
                i++;
            }
            out.print(s1);
            if (methodinformation.memberName.length > 2)
            {
                out.print(methodinformation.memberName[2]);
            }
            if ((getBy(methodinformation.annotations) instanceof ByRef) && methodinformation.returnType == java/lang/String)
            {
                out.print((new StringBuilder()).append(");\n").append(s4).append("rptr = rstr.c_str()").toString());
                return;
            }
        }
    }

    private void doCallback(Class class1, Method method, String s, boolean flag)
    {
        Object obj;
        Class class2;
        Class aclass[];
        Annotation aannotation1[][];
        String s9;
        Object obj1;
        String as2[];
        String s10;
        AdapterInformation adapterinformation1;
        int k;
        class2 = method.getReturnType();
        aclass = method.getParameterTypes();
        Annotation aannotation[] = method.getAnnotations();
        aannotation1 = method.getParameterAnnotations();
        String s5 = getFunctionClassName(class1);
        String as[] = getCPPTypeName(class1);
        String as1[] = as[0].split("\\(");
        as1[1] = getValueTypeName(new String[] {
            as1[1]
        });
        obj1 = as[1].substring(1);
        functionPointers.register((new StringBuilder()).append("static ").append(s5).append(" ").append(s).append("_instance;").toString());
        jclassesInit.register(class1);
        if (out2 != null)
        {
            PrintWriter printwriter2 = out2;
            StringBuilder stringbuilder = (new StringBuilder()).append("JNIIMPORT ").append(as1[0]);
            int i;
            if (as1.length > 1)
            {
                obj = as1[1];
            } else
            {
                obj = "";
            }
            printwriter2.println(stringbuilder.append(((String) (obj))).append(s).append(((String) (obj1))).append(";").toString());
        }
        printwriter2 = out;
        stringbuilder = (new StringBuilder()).append("JNIEXPORT ").append(as1[0]);
        if (as1.length > 1)
        {
            obj = as1[1];
        } else
        {
            obj = "";
        }
        printwriter2.println(stringbuilder.append(((String) (obj))).append(s).append(((String) (obj1))).append(" {").toString());
        printwriter2 = out;
        stringbuilder = new StringBuilder();
        if (class2 != Void.TYPE)
        {
            obj = "    return ";
        } else
        {
            obj = "    ";
        }
        printwriter2.print(stringbuilder.append(((String) (obj))).append(s).append("_instance(").toString());
        for (i = 0; i < aclass.length; i++)
        {
            out.print((new StringBuilder()).append("arg").append(i).toString());
            if (i < aclass.length - 1)
            {
                out.print(", ");
            }
        }

        out.println(");");
        out.println("}");
        if (!flag)
        {
            return;
        }
        out.println((new StringBuilder()).append(as1[0]).append(s5).append("::operator()").append(((String) (obj1))).append(" {").toString());
        obj = "";
        if (class2 != Void.TYPE)
        {
            out.println((new StringBuilder()).append("    ").append(getJNITypeName(class2)).append(" rarg = 0;").toString());
            obj = "rarg = ";
            if (class2 == java/lang/String)
            {
                obj = (new StringBuilder()).append("rarg = ").append("(jstring)").toString();
            }
        }
        s9 = getCast(aannotation, class2);
        obj1 = getBy(aannotation);
        as2 = getCPPTypeName(class2);
        s10 = getValueTypeName(as2);
        adapterinformation1 = getAdapterInformation(false, s10, aannotation);
        out.println("    jthrowable exc = NULL;");
        out.println("    JNIEnv* env;");
        out.println("    int attached = JavaCPP_getEnv(&env);");
        out.println("    if (attached < 0) {");
        out.println("        goto end;");
        out.println("    }");
        out.println("{");
        if (aclass.length <= 0)
        {
            break MISSING_BLOCK_LABEL_3573;
        }
        out.println((new StringBuilder()).append("    jvalue args[").append(aclass.length).append("];").toString());
        k = 0;
_L2:
        if (k >= aclass.length)
        {
            break MISSING_BLOCK_LABEL_3573;
        }
        if (!aclass[k].isPrimitive())
        {
            break; /* Loop/switch isn't completed */
        }
        out.println((new StringBuilder()).append("    args[").append(k).append("].").append(getSignature(aclass[k]).toLowerCase()).append(" = (").append(getJNITypeName(aclass[k])).append(")arg").append(k).append(";").toString());
_L3:
        k++;
        if (true) goto _L2; else goto _L1
_L1:
        AdapterInformation adapterinformation2;
label0:
        {
            Annotation annotation1 = getBy(aannotation1[k]);
            String as3[] = getCPPTypeName(aclass[k]);
            String s6 = getValueTypeName(as3);
            adapterinformation2 = getAdapterInformation(false, s6, aannotation1[k]);
            boolean flag1 = false;
            String s1;
            if (adapterinformation2 != null)
            {
                usesAdapters = true;
                out.println((new StringBuilder()).append("    ").append(adapterinformation2.name).append(" adapter").append(k).append("(arg").append(k).append(");").toString());
                if (aclass[k] != java/lang/String)
                {
                    out.println((new StringBuilder()).append("    jint size").append(k).append(" = (jint)adapter").append(k).append(".size;").toString());
                    out.println((new StringBuilder()).append("    jlong deallocator").append(k).append(" = ptr_to_jlong(&(").append(adapterinformation2.name).append("::deallocate));").toString());
                }
                flag1 = true;
            } else
            if ((annotation1 instanceof ByVal) && aclass[k] != com/googlecode/javacpp/Pointer || com/googlecode/javacpp/FunctionPointer.isAssignableFrom(aclass[k]))
            {
                out.println((new StringBuilder()).append("    jint size").append(k).append(" = 1;").toString());
                out.println((new StringBuilder()).append("    jlong deallocator").append(k).append(" = ptr_to_jlong(&JavaCPP_").append(mangle(aclass[k].getName())).append("_deallocate);").toString());
                deallocators.register(aclass[k]);
                flag1 = true;
            }
            if (!com/googlecode/javacpp/Pointer.isAssignableFrom(aclass[k]) && !java/nio/Buffer.isAssignableFrom(aclass[k]))
            {
                s1 = s6;
                if (!aclass[k].isArray())
                {
                    break label0;
                }
                s1 = s6;
                if (!aclass[k].getComponentType().isPrimitive())
                {
                    break label0;
                }
            }
            s1 = s6;
            if (com/googlecode/javacpp/FunctionPointer.isAssignableFrom(aclass[k]))
            {
                as3[0] = (new StringBuilder()).append(getFunctionClassName(aclass[k])).append("*").toString();
                as3[1] = "";
                s1 = getValueTypeName(as3);
            }
            out.println((new StringBuilder()).append("    ").append(getJNITypeName(aclass[k])).append(" obj").append(k).append(" = NULL;").toString());
            out.println((new StringBuilder()).append("    ").append(as3[0]).append(" ptr").append(k).append(as3[1]).append(" = NULL;").toString());
            if (com/googlecode/javacpp/FunctionPointer.isAssignableFrom(aclass[k]))
            {
                out.println((new StringBuilder()).append("    ptr").append(k).append(" = new (std::nothrow) ").append(s1).append(";").toString());
                out.println((new StringBuilder()).append("    if (ptr").append(k).append(" != NULL) {").toString());
                out.println((new StringBuilder()).append("        ptr").append(k).append("->ptr = arg").append(k).append(";").toString());
                out.println("    }");
            } else
            if (adapterinformation2 != null)
            {
                out.println((new StringBuilder()).append("    ptr").append(k).append(" = adapter").append(k).append(";").toString());
            } else
            if ((annotation1 instanceof ByVal) && aclass[k] != com/googlecode/javacpp/Pointer)
            {
                PrintWriter printwriter3 = out;
                StringBuilder stringbuilder2 = (new StringBuilder()).append("    ptr").append(k);
                if (getNoException(aclass[k], method))
                {
                    s7 = " = new (std::nothrow) ";
                } else
                {
                    s7 = " = new ";
                }
                printwriter3.println(stringbuilder2.append(s7).append(s1).append(as3[1]).append("(*(").append(as3[0]).append(as3[1]).append(")&arg").append(k).append(");").toString());
            } else
            if ((annotation1 instanceof ByVal) || (annotation1 instanceof ByRef))
            {
                out.println((new StringBuilder()).append("    ptr").append(k).append(" = (").append(as3[0]).append(as3[1]).append(")&arg").append(k).append(";").toString());
            } else
            if (annotation1 instanceof ByPtrPtr)
            {
                out.println((new StringBuilder()).append("    if (arg").append(k).append(" == NULL) {").toString());
                out.println((new StringBuilder()).append("        JavaCPP_log(\"Pointer address of argument ").append(k).append(" is NULL in callback for ").append(class1.getCanonicalName()).append(".\");").toString());
                out.println("    } else {");
                out.println((new StringBuilder()).append("        ptr").append(k).append(" = (").append(as3[0]).append(as3[1]).append(")*arg").append(k).append(";").toString());
                out.println("    }");
            } else
            {
                out.println((new StringBuilder()).append("    ptr").append(k).append(" = (").append(as3[0]).append(as3[1]).append(")arg").append(k).append(";").toString());
            }
        }
        if (com/googlecode/javacpp/Pointer.isAssignableFrom(aclass[k]))
        {
            String s7 = (new StringBuilder()).append("    obj").append(k).append(" = env->AllocObject(JavaCPP_getClass(env, ").append(jclasses.register(aclass[k])).append("));").toString();
            jclassesInit.register(aclass[k]);
            if (getAdapterInformation(true, s1, aannotation1[k]) != null || (annotation1 instanceof ByPtrPtr) || (annotation1 instanceof ByPtrRef))
            {
                out.println(s7);
            } else
            {
                out.println((new StringBuilder()).append("    if (ptr").append(k).append(" != NULL) { ").toString());
                out.println((new StringBuilder()).append("    ").append(s7).toString());
                out.println("    }");
            }
            out.println((new StringBuilder()).append("    if (obj").append(k).append(" != NULL) { ").toString());
            if (flag1)
            {
                out.println((new StringBuilder()).append("        if (deallocator").append(k).append(" != 0) {").toString());
                out.println("            jvalue args[3];");
                out.println((new StringBuilder()).append("            args[0].j = ptr_to_jlong(ptr").append(k).append(");").toString());
                out.println((new StringBuilder()).append("            args[1].i = size").append(k).append(";").toString());
                out.println((new StringBuilder()).append("            args[2].j = deallocator").append(k).append(";").toString());
                out.println((new StringBuilder()).append("            env->CallNonvirtualVoidMethodA(obj").append(k).append(", JavaCPP_getClass(env, ").append(jclasses.register(com/googlecode/javacpp/Pointer)).append("), JavaCPP_initMID, args);").toString());
                out.println("        } else {");
                out.println((new StringBuilder()).append("            env->SetLongField(obj").append(k).append(", JavaCPP_addressFID, ptr_to_jlong(ptr").append(k).append("));").toString());
                out.println((new StringBuilder()).append("            env->SetIntField(obj").append(k).append(", JavaCPP_limitFID, size").append(k).append(");").toString());
                out.println((new StringBuilder()).append("            env->SetIntField(obj").append(k).append(", JavaCPP_capacityFID, size").append(k).append(");").toString());
                out.println("        }");
            } else
            {
                out.println((new StringBuilder()).append("        env->SetLongField(obj").append(k).append(", JavaCPP_addressFID, ptr_to_jlong(ptr").append(k).append("));").toString());
            }
            out.println("    }");
            out.println((new StringBuilder()).append("    args[").append(k).append("].l = obj").append(k).append(";").toString());
        } else
        if (aclass[k] == java/lang/String)
        {
            PrintWriter printwriter1 = out;
            StringBuilder stringbuilder1 = (new StringBuilder()).append("    jstring obj").append(k).append(" = (const char*)");
            String s2;
            if (adapterinformation2 != null)
            {
                s2 = "adapter";
            } else
            {
                s2 = "arg";
            }
            stringbuilder1 = stringbuilder1.append(s2).append(k).append(" == NULL ? NULL : env->NewStringUTF((const char*)");
            if (adapterinformation2 != null)
            {
                s2 = "adapter";
            } else
            {
                s2 = "arg";
            }
            printwriter1.println(stringbuilder1.append(s2).append(k).append(");").toString());
            out.println((new StringBuilder()).append("    args[").append(k).append("].l = obj").append(k).append(";").toString());
        } else
        if (aclass[k].isArray() && aclass[k].getComponentType().isPrimitive())
        {
            if (adapterinformation2 == null)
            {
                out.println((new StringBuilder()).append("    jint size").append(k).append(" = ptr").append(k).append(" != NULL ? 1 : 0;").toString());
            }
            String s3 = aclass[k].getComponentType().getName();
            String s8 = (new StringBuilder()).append(Character.toUpperCase(s3.charAt(0))).append(s3.substring(1)).toString();
            out.println((new StringBuilder()).append("    if (ptr").append(k).append(" != NULL) {").toString());
            out.println((new StringBuilder()).append("        obj").append(k).append(" = env->New").append(s8).append("Array(size").append(k).append(");").toString());
            out.println((new StringBuilder()).append("        env->Set").append(s8).append("ArrayRegion(obj").append(k).append(", 0, size").append(k).append(", (j").append(s3).append("*)ptr").append(k).append(");").toString());
            out.println("    }");
            if (adapterinformation2 != null)
            {
                out.println((new StringBuilder()).append("    if (deallocator").append(k).append(" != 0 && ptr").append(k).append(" != NULL) {").toString());
                out.println((new StringBuilder()).append("        (*(void(*)(void*))jlong_to_ptr(deallocator").append(k).append("))((void*)ptr").append(k).append(");").toString());
                out.println("    }");
            }
        } else
        if (java/nio/Buffer.isAssignableFrom(aclass[k]))
        {
            if (adapterinformation2 == null)
            {
                out.println((new StringBuilder()).append("    jint size").append(k).append(" = ptr").append(k).append(" != NULL ? 1 : 0;").toString());
            }
            out.println((new StringBuilder()).append("    if (ptr").append(k).append(" != NULL) {").toString());
            out.println((new StringBuilder()).append("        obj").append(k).append(" = env->NewDirectByteBuffer(ptr").append(k).append(", size").append(k).append(");").toString());
            out.println("    }");
        } else
        {
            logger.log(Level.WARNING, (new StringBuilder()).append("Callback \"").append(method).append("\" has unsupported parameter type \"").append(aclass[k].getCanonicalName()).append("\". Compilation will most likely fail.").toString());
        }
          goto _L3
        if (true) goto _L2; else goto _L4
_L4:
        out.println("    if (obj == NULL) {");
        out.println((new StringBuilder()).append("        obj = env->NewGlobalRef(env->AllocObject(JavaCPP_getClass(env, ").append(jclasses.register(class1)).append(")));").toString());
        out.println("        if (obj == NULL) {");
        out.println((new StringBuilder()).append("            JavaCPP_log(\"Error creating global reference of ").append(class1.getCanonicalName()).append(" instance for callback.\");").toString());
        out.println("        } else {");
        out.println("            env->SetLongField(obj, JavaCPP_addressFID, ptr_to_jlong(this));");
        out.println("        }");
        out.println((new StringBuilder()).append("        ptr = &").append(s).append(";").toString());
        out.println("    }");
        out.println("    if (mid == NULL) {");
        out.println((new StringBuilder()).append("        mid = env->GetMethodID(JavaCPP_getClass(env, ").append(jclasses.register(class1)).append("), \"").append(method.getName()).append("\", \"(").append(getSignature(method.getParameterTypes())).append(")").append(getSignature(method.getReturnType())).append("\");").toString());
        out.println("    }");
        out.println("    if (env->IsSameObject(obj, NULL)) {");
        out.println((new StringBuilder()).append("        JavaCPP_log(\"Function pointer object is NULL in callback for ").append(class1.getCanonicalName()).append(".\");").toString());
        out.println("    } else if (mid == NULL) {");
        out.println((new StringBuilder()).append("        JavaCPP_log(\"Error getting method ID of function caller \\\"").append(method).append("\\\" for callback.\");").toString());
        out.println("    } else {");
        s = "Object";
        if (class2.isPrimitive())
        {
            s = class2.getName();
            s = (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
        }
        PrintWriter printwriter = out;
        obj = (new StringBuilder()).append("        ").append(((String) (obj))).append("env->Call").append(s).append("MethodA(obj, mid, ");
        int j;
        if (aclass.length == 0)
        {
            s = "NULL);";
        } else
        {
            s = "args);";
        }
        printwriter.println(((StringBuilder) (obj)).append(s).toString());
        out.println("        if ((exc = env->ExceptionOccurred()) != NULL) {");
        out.println("            env->ExceptionClear();");
        out.println("        }");
        out.println("    }");
        j = 0;
        while (j < aclass.length) 
        {
            if (com/googlecode/javacpp/Pointer.isAssignableFrom(aclass[j]))
            {
                s = getCPPTypeName(aclass[j]);
                Annotation annotation = getBy(aannotation1[j]);
                String s4 = getCast(aannotation1[j], aclass[j]);
                AdapterInformation adapterinformation = getAdapterInformation(true, getValueTypeName(s), aannotation1[j]);
                if ("void*".equals(s[0]))
                {
                    s[0] = "char*";
                }
                if (adapterinformation != null || (annotation instanceof ByPtrPtr) || (annotation instanceof ByPtrRef))
                {
                    out.println((new StringBuilder()).append("    ").append(s[0]).append(" rptr").append(j).append(s[1]).append(" = (").append(s[0]).append(s[1]).append(")jlong_to_ptr(env->GetLongField(obj").append(j).append(", JavaCPP_addressFID));").toString());
                    if (adapterinformation != null)
                    {
                        out.println((new StringBuilder()).append("    jint rsize").append(j).append(" = env->GetIntField(obj").append(j).append(", JavaCPP_limitFID);").toString());
                    }
                    if (!aclass[j].isAnnotationPresent(com/googlecode/javacpp/annotation/Opaque))
                    {
                        out.println((new StringBuilder()).append("    jint rposition").append(j).append(" = env->GetIntField(obj").append(j).append(", JavaCPP_positionFID);").toString());
                        out.println((new StringBuilder()).append("    rptr").append(j).append(" += rposition").append(j).append(";").toString());
                        if (adapterinformation != null)
                        {
                            out.println((new StringBuilder()).append("    rsize").append(j).append(" -= rposition").append(j).append(";").toString());
                        }
                    }
                    if (adapterinformation != null)
                    {
                        out.println((new StringBuilder()).append("    adapter").append(j).append(".assign(rptr").append(j).append(", rsize").append(j).append(");").toString());
                    } else
                    if (annotation instanceof ByPtrPtr)
                    {
                        out.println((new StringBuilder()).append("    if (arg").append(j).append(" != NULL) {").toString());
                        out.println((new StringBuilder()).append("        *arg").append(j).append(" = *").append(s4).append("&rptr").append(j).append(";").toString());
                        out.println("    }");
                    } else
                    if (annotation instanceof ByPtrRef)
                    {
                        out.println((new StringBuilder()).append("    arg").append(j).append(" = ").append(s4).append("rptr").append(j).append(";").toString());
                    }
                }
            }
            if (!aclass[j].isPrimitive())
            {
                out.println((new StringBuilder()).append("    env->DeleteLocalRef(obj").append(j).append(");").toString());
            }
            j++;
        }
        out.println("}");
        out.println("end:");
        if (class2 != Void.TYPE)
        {
            if ("void*".equals(as2[0]))
            {
                as2[0] = "char*";
            }
            if (com/googlecode/javacpp/Pointer.isAssignableFrom(class2))
            {
                out.println((new StringBuilder()).append("    ").append(as2[0]).append(" rptr").append(as2[1]).append(" = rarg == NULL ? NULL : (").append(as2[0]).append(as2[1]).append(")jlong_to_ptr(env->GetLongField(rarg, JavaCPP_addressFID));").toString());
                if (adapterinformation1 != null)
                {
                    out.println("    jint rsize = rarg == NULL ? 0 : env->GetIntField(rarg, JavaCPP_limitFID);");
                }
                if (!class2.isAnnotationPresent(com/googlecode/javacpp/annotation/Opaque))
                {
                    out.println("    jint rposition = rarg == NULL ? 0 : env->GetIntField(rarg, JavaCPP_positionFID);");
                    out.println("    rptr += rposition;");
                    if (adapterinformation1 != null)
                    {
                        out.println("    rsize -= rposition;");
                    }
                }
            } else
            if (class2 == java/lang/String)
            {
                out.println((new StringBuilder()).append("    ").append(as2[0]).append(" rptr").append(as2[1]).append(" = rarg == NULL ? NULL : env->GetStringUTFChars(rarg, NULL);").toString());
                if (adapterinformation1 != null)
                {
                    out.println("    jint rsize = 0;");
                }
            } else
            if (java/nio/Buffer.isAssignableFrom(class2))
            {
                out.println((new StringBuilder()).append("    ").append(as2[0]).append(" rptr").append(as2[1]).append(" = rarg == NULL ? NULL : env->GetDirectBufferAddress(rarg);").toString());
                if (adapterinformation1 != null)
                {
                    out.println("    jint rsize = rarg == NULL ? 0 : env->GetDirectBufferCapacity(rarg);");
                }
            } else
            if (!class2.isPrimitive())
            {
                logger.log(Level.WARNING, (new StringBuilder()).append("Callback \"").append(method).append("\" has unsupported return type \"").append(class2.getCanonicalName()).append("\". Compilation will most likely fail.").toString());
            }
        }
        out.println("    if (exc != NULL) {");
        out.println("        jclass cls = env->GetObjectClass(exc);");
        out.println("        jmethodID mid = env->GetMethodID(cls, \"toString\", \"()Ljava/lang/String;\");");
        out.println("        env->DeleteLocalRef(cls);");
        out.println("        jstring str = (jstring)env->CallObjectMethod(exc, mid);");
        out.println("        env->DeleteLocalRef(exc);");
        out.println("        const char *msg = env->GetStringUTFChars(str, NULL);");
        out.println("        JavaCPP_exception e(msg);");
        out.println("        env->ReleaseStringUTFChars(str, msg);");
        out.println("        env->DeleteLocalRef(str);");
        out.println("        JavaCPP_detach(attached);");
        out.println("        throw e;");
        out.println("    } else {");
        out.println("        JavaCPP_detach(attached);");
        out.println("    }");
        if (class2 != Void.TYPE)
        {
            if (class2.isPrimitive())
            {
                out.println((new StringBuilder()).append("    return ").append(s9).append("rarg;").toString());
            } else
            if (adapterinformation1 != null)
            {
                usesAdapters = true;
                out.println((new StringBuilder()).append("    return ").append(adapterinformation1.name).append("(").append(s9).append("rptr, rsize);").toString());
            } else
            if (com/googlecode/javacpp/FunctionPointer.isAssignableFrom(class2))
            {
                out.println((new StringBuilder()).append("    return ").append(s9).append("(rptr == NULL ? NULL : rptr->ptr);").toString());
            } else
            if ((obj1 instanceof ByVal) || (obj1 instanceof ByRef))
            {
                out.println("    if (rptr == NULL) {");
                out.println((new StringBuilder()).append("        JavaCPP_log(\"Return pointer address is NULL in callback for ").append(class1.getCanonicalName()).append(".\");").toString());
                out.println((new StringBuilder()).append("        static ").append(s10).append(" empty").append(as2[1]).append(";").toString());
                out.println("        return empty;");
                out.println("    } else {");
                out.println((new StringBuilder()).append("        return *").append(s9).append("rptr;").toString());
                out.println("    }");
            } else
            if (obj1 instanceof ByPtrPtr)
            {
                out.println((new StringBuilder()).append("    return ").append(s9).append("&rptr;").toString());
            } else
            {
                out.println((new StringBuilder()).append("    return ").append(s9).append("rptr;").toString());
            }
        }
        out.println("}");
        return;
    }

    private void doCallbackAllocator(Class class1, String s)
    {
        String s1 = getFunctionClassName(class1);
        out.println("    obj = env->NewWeakGlobalRef(obj);");
        out.println("    if (obj == NULL) {");
        out.println((new StringBuilder()).append("        JavaCPP_log(\"Error creating global reference of ").append(class1.getCanonicalName()).append(" instance for callback.\");").toString());
        out.println("        return;");
        out.println("    }");
        out.println((new StringBuilder()).append("    ").append(s1).append("* rptr = new (std::nothrow) ").append(s1).append(";").toString());
        out.println("    if (rptr != NULL) {");
        out.println((new StringBuilder()).append("        rptr->ptr = &").append(s).append(";").toString());
        out.println("        rptr->obj = obj;");
        out.println("        jvalue args[3];");
        out.println("        args[0].j = ptr_to_jlong(rptr);");
        out.println("        args[1].i = 1;");
        out.println((new StringBuilder()).append("        args[2].j = ptr_to_jlong(&JavaCPP_").append(mangle(class1.getName())).append("_deallocate);").toString());
        deallocators.register(class1);
        out.println((new StringBuilder()).append("        env->CallNonvirtualVoidMethodA(obj, JavaCPP_getClass(env, ").append(jclasses.register(com/googlecode/javacpp/Pointer)).append("), JavaCPP_initMID, args);").toString());
        out.println((new StringBuilder()).append("        ").append(s).append("_instance = *rptr;").toString());
        out.println("    }");
        out.println("}");
    }

    private transient boolean doClasses(boolean flag, boolean flag1, String s, Class aclass[])
    {
        int j;
        int k;
        out.println("/* DO NOT EDIT THIS FILE - IT IS MACHINE GENERATED */");
        out.println();
        if (out2 != null)
        {
            out2.println("/* DO NOT EDIT THIS FILE - IT IS MACHINE GENERATED */");
            out2.println();
        }
        String s3;
        for (Iterator iterator = properties.get("generator.define").iterator(); iterator.hasNext(); out.println((new StringBuilder()).append("#define ").append(s3).toString()))
        {
            s3 = (String)iterator.next();
        }

        out.println();
        out.println("#ifdef __APPLE__");
        out.println("    #define _JAVASOFT_JNI_MD_H_");
        out.println();
        out.println("    #define JNIEXPORT __attribute__((visibility(\"default\")))");
        out.println("    #define JNIIMPORT");
        out.println("    #define JNICALL");
        out.println();
        out.println("    typedef int jint;");
        out.println("    typedef long long jlong;");
        out.println("    typedef signed char jbyte;");
        out.println("#endif");
        out.println("#ifdef _WIN32");
        out.println("    #define _JAVASOFT_JNI_MD_H_");
        out.println();
        out.println("    #define JNIEXPORT __declspec(dllexport)");
        out.println("    #define JNIIMPORT __declspec(dllimport)");
        out.println("    #define JNICALL __stdcall");
        out.println();
        out.println("    typedef int jint;");
        out.println("    typedef long long jlong;");
        out.println("    typedef signed char jbyte;");
        out.println("#endif");
        out.println("#include <jni.h>");
        if (out2 != null)
        {
            out2.println("#include <jni.h>");
        }
        out.println("#ifdef ANDROID");
        out.println("    #include <android/log.h>");
        out.println("    #define NewWeakGlobalRef(obj) NewGlobalRef(obj)");
        out.println("    #define DeleteWeakGlobalRef(obj) DeleteGlobalRef(obj)");
        out.println("#endif");
        out.println();
        out.println("#include <stddef.h>");
        out.println("#ifndef _WIN32");
        out.println("    #include <stdint.h>");
        out.println("#endif");
        out.println("#include <stdio.h>");
        out.println("#include <stdlib.h>");
        out.println("#include <string.h>");
        out.println("#include <exception>");
        out.println("#include <new>");
        out.println();
        out.println("#define jlong_to_ptr(a) ((void*)(uintptr_t)(a))");
        out.println("#define ptr_to_jlong(a) ((jlong)(uintptr_t)(a))");
        out.println();
        out.println("#if defined(_MSC_VER)");
        out.println("    #define JavaCPP_noinline __declspec(noinline)");
        out.println("    #define JavaCPP_hidden /* hidden by default */");
        out.println("#elif defined(__GNUC__)");
        out.println("    #define JavaCPP_noinline __attribute__((noinline))");
        out.println("    #define JavaCPP_hidden   __attribute__((visibility(\"hidden\")))");
        out.println("#else");
        out.println("    #define JavaCPP_noinline");
        out.println("    #define JavaCPP_hidden");
        out.println("#endif");
        out.println();
        List alist[] = new List[2];
        alist[0] = properties.get("generator.include");
        alist[1] = properties.get("generator.cinclude");
        for (int i = 0; i < alist.length; i++)
        {
            if (alist[i] == null || alist[i].size() <= 0)
            {
                continue;
            }
            if (i == 1)
            {
                out.println("extern \"C\" {");
                if (out2 != null)
                {
                    out2.println("#ifdef __cplusplus");
                    out2.println("extern \"C\" {");
                    out2.println("#endif");
                }
            }
            Iterator iterator3 = alist[i].iterator();
            do
            {
                if (!iterator3.hasNext())
                {
                    break;
                }
                String s10 = (String)iterator3.next();
                String s4 = "#include ";
                String s1 = s4;
                if (!s10.startsWith("<"))
                {
                    s1 = s4;
                    if (!s10.startsWith("\""))
                    {
                        s1 = (new StringBuilder()).append("#include ").append('"').toString();
                    }
                }
                s4 = (new StringBuilder()).append(s1).append(s10).toString();
                s1 = s4;
                if (!s10.endsWith(">"))
                {
                    s1 = s4;
                    if (!s10.endsWith("\""))
                    {
                        s1 = (new StringBuilder()).append(s4).append('"').toString();
                    }
                }
                out.println(s1);
                if (out2 != null)
                {
                    out2.println(s1);
                }
            } while (true);
            if (i == 1)
            {
                out.println("}");
                if (out2 != null)
                {
                    out2.println("#ifdef __cplusplus");
                    out2.println("}");
                    out2.println("#endif");
                }
            }
            out.println();
        }

        out.println("static JavaVM* JavaCPP_vm = NULL;");
        out.println((new StringBuilder()).append("static const char* JavaCPP_classNames[").append(jclasses.size()).append("] = {").toString());
        Iterator iterator1 = jclasses.iterator();
        j = 0;
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            Object obj = (Class)iterator1.next();
            out.print((new StringBuilder()).append("        \"").append(((Class) (obj)).getName().replace('.', '/')).append("\"").toString());
            if (iterator1.hasNext())
            {
                out.println(",");
            }
            obj = (LinkedList)members.get(obj);
            if (obj != null && ((LinkedList) (obj)).size() > j)
            {
                j = ((LinkedList) (obj)).size();
            }
        } while (true);
        out.println(" };");
        out.println((new StringBuilder()).append("static jclass JavaCPP_classes[").append(jclasses.size()).append("] = { NULL };").toString());
        out.println("static jmethodID JavaCPP_initMID = NULL;");
        out.println("static jfieldID JavaCPP_addressFID = NULL;");
        out.println("static jfieldID JavaCPP_positionFID = NULL;");
        out.println("static jfieldID JavaCPP_limitFID = NULL;");
        out.println("static jfieldID JavaCPP_capacityFID = NULL;");
        out.println();
        out.println("static inline void JavaCPP_log(const char* fmt, ...) {");
        out.println("    va_list ap;");
        out.println("    va_start(ap, fmt);");
        out.println("#ifdef ANDROID");
        out.println("    __android_log_vprint(ANDROID_LOG_ERROR, \"javacpp\", fmt, ap);");
        out.println("#else");
        out.println("    vfprintf(stderr, fmt, ap);");
        out.println("    fprintf(stderr, \"\\n\");");
        out.println("#endif");
        out.println("    va_end(ap);");
        out.println("}");
        out.println();
        out.println("static JavaCPP_noinline jclass JavaCPP_getClass(JNIEnv* env, int i) {");
        out.println("    if (JavaCPP_classes[i] == NULL && env->PushLocalFrame(1) == 0) {");
        out.println("        jclass cls = env->FindClass(JavaCPP_classNames[i]);");
        out.println("        if (cls == NULL || env->ExceptionCheck()) {");
        out.println("            JavaCPP_log(\"Error loading class %s.\", JavaCPP_classNames[i]);");
        out.println("            return NULL;");
        out.println("        }");
        out.println("        JavaCPP_classes[i] = (jclass)env->NewWeakGlobalRef(cls);");
        out.println("        if (JavaCPP_classes[i] == NULL || env->ExceptionCheck()) {");
        out.println("            JavaCPP_log(\"Error creating global reference of class %s.\", JavaCPP_classNames[i]);");
        out.println("            return NULL;");
        out.println("        }");
        out.println("        env->PopLocalFrame(NULL);");
        out.println("    }");
        out.println("    return JavaCPP_classes[i];");
        out.println("}");
        out.println();
        out.println("class JavaCPP_hidden JavaCPP_exception : public std::exception {");
        out.println("public:");
        out.println("    JavaCPP_exception(const char* str) throw() {");
        out.println("        if (str == NULL) {");
        out.println("            strcpy(msg, \"Unknown exception.\");");
        out.println("        } else {");
        out.println("            strncpy(msg, str, sizeof(msg));");
        out.println("            msg[sizeof(msg) - 1] = 0;");
        out.println("        }");
        out.println("    }");
        out.println("    virtual const char* what() const throw() { return msg; }");
        out.println("    char msg[1024];");
        out.println("};");
        out.println();
        if (flag)
        {
            out.println("static JavaCPP_noinline jthrowable JavaCPP_handleException(JNIEnv* env, int i) {");
            out.println("    jstring str = NULL;");
            out.println("    try {");
            out.println("        throw;");
            out.println("    } catch (std::exception& e) {");
            out.println("        str = env->NewStringUTF(e.what());");
            out.println("    } catch (...) {");
            out.println("        str = env->NewStringUTF(\"Unknown exception.\");");
            out.println("    }");
            out.println("    jclass cls = JavaCPP_getClass(env, i);");
            out.println("    jmethodID mid = env->GetMethodID(cls, \"<init>\", \"(Ljava/lang/String;)V\");");
            out.println("    if (mid == NULL || env->ExceptionCheck()) {");
            out.println("        JavaCPP_log(\"Error getting constructor ID of %s.\", JavaCPP_classNames[i]);");
            out.println("        return NULL;");
            out.println("    } else {");
            out.println("        return (jthrowable)env->NewObject(cls, mid, str);");
            out.println("    }");
            out.println("}");
            out.println();
        }
        if (flag1)
        {
            out.println("#include <vector>");
            out.println("template<typename P, typename T = P> class JavaCPP_hidden VectorAdapter {");
            out.println("public:");
            out.println("    VectorAdapter(const P* ptr, typename std::vector<T>::size_type size) : ptr((P*)ptr), size(size),");
            out.println("        vec2(ptr ? std::vector<T>((P*)ptr, (P*)ptr + size) : std::vector<T>()), vec(vec2) { }");
            out.println("    VectorAdapter(const std::vector<T>& vec) : ptr(0), size(0), vec2(vec), vec(vec2) { }");
            out.println("    VectorAdapter(      std::vector<T>& vec) : ptr(0), size(0), vec(vec) { }");
            out.println("    void assign(P* ptr, typename std::vector<T>::size_type size) {");
            out.println("        this->ptr = ptr;");
            out.println("        this->size = size;");
            out.println("        vec.assign(ptr, ptr + size);");
            out.println("    }");
            out.println("    static void deallocate(P* ptr) { delete[] ptr; }");
            out.println("    operator P*() {");
            out.println("        if (vec.size() > size) {");
            out.println("            ptr = new (std::nothrow) P[vec.size()];");
            out.println("        }");
            out.println("        if (ptr) {");
            out.println("            std::copy(vec.begin(), vec.end(), ptr);");
            out.println("        }");
            out.println("        size = vec.size();");
            out.println("        return ptr;");
            out.println("    }");
            out.println("    operator const P*()        { return &vec[0]; }");
            out.println("    operator std::vector<T>&() { return vec; }");
            out.println("    operator std::vector<T>*() { return ptr ? &vec : 0; }");
            out.println("    P* ptr;");
            out.println("    typename std::vector<T>::size_type size;");
            out.println("    std::vector<T> vec2;");
            out.println("    std::vector<T>& vec;");
            out.println("};");
            out.println();
            out.println("#include <string>");
            out.println("class JavaCPP_hidden StringAdapter {");
            out.println("public:");
            out.println("    StringAdapter(const          char* ptr, size_t size) : ptr((char*)ptr), size(size),");
            out.println("        str2(ptr ? (char*)ptr : \"\"), str(str2) { }");
            out.println("    StringAdapter(const signed   char* ptr, size_t size) : ptr((char*)ptr), size(size),");
            out.println("        str2(ptr ? (char*)ptr : \"\"), str(str2) { }");
            out.println("    StringAdapter(const unsigned char* ptr, size_t size) : ptr((char*)ptr), size(size),");
            out.println("        str2(ptr ? (char*)ptr : \"\"), str(str2) { }");
            out.println("    StringAdapter(const std::string& str) : ptr(0), size(0), str2(str), str(str2) { }");
            out.println("    StringAdapter(      std::string& str) : ptr(0), size(0), str(str) { }");
            out.println("    void assign(char* ptr, size_t size) {");
            out.println("        this->ptr = ptr;");
            out.println("        this->size = size;");
            out.println("        str.assign(ptr ? ptr : \"\");");
            out.println("    }");
            out.println("    static void deallocate(char* ptr) { free(ptr); }");
            out.println("    operator char*() {");
            out.println("        const char* c_str = str.c_str();");
            out.println("        if (ptr == NULL || strcmp(c_str, ptr) != 0) {");
            out.println("            ptr = strdup(c_str);");
            out.println("        }");
            out.println("        size = strlen(c_str) + 1;");
            out.println("        return ptr;");
            out.println("    }");
            out.println("    operator       signed   char*() { return (signed   char*)(operator char*)(); }");
            out.println("    operator       unsigned char*() { return (unsigned char*)(operator char*)(); }");
            out.println("    operator const          char*() { return                 str.c_str(); }");
            out.println("    operator const signed   char*() { return (signed   char*)str.c_str(); }");
            out.println("    operator const unsigned char*() { return (unsigned char*)str.c_str(); }");
            out.println("    operator         std::string&() { return str; }");
            out.println("    operator         std::string*() { return ptr ? &str : 0; }");
            out.println("    char* ptr;");
            out.println("    size_t size;");
            out.println("    std::string str2;");
            out.println("    std::string& str;");
            out.println("};");
            out.println();
        }
        if (!functionDefinitions.isEmpty())
        {
            out.println("static JavaCPP_noinline void JavaCPP_detach(int detach) {");
            out.println("    if (detach > 0 && JavaCPP_vm->DetachCurrentThread() != 0) {");
            out.println("        JavaCPP_log(\"Could not detach the JavaVM from the current thread.\");");
            out.println("    }");
            out.println("}");
            out.println();
            out.println("static JavaCPP_noinline int JavaCPP_getEnv(JNIEnv** env) {");
            out.println("    int attached = 0;");
            out.println("    struct {");
            out.println("        JNIEnv **env;");
            out.println("        operator JNIEnv**() { return env; } // Android JNI");
            out.println("        operator void**() { return (void**)env; } // standard JNI");
            out.println("    } env2 = { env };");
            out.println("    JavaVM *vm = JavaCPP_vm;");
            out.println("    if (vm == NULL) {");
            if (out2 != null)
            {
                out.println("#ifndef ANDROID");
                out.println("        int size = 1;");
                out.println("        if (JNI_GetCreatedJavaVMs(&vm, 1, &size) != 0 || size == 0) {");
                out.println("#endif");
            }
            out.println("            JavaCPP_log(\"Could not get any created JavaVM.\");");
            out.println("            return -1;");
            if (out2 != null)
            {
                out.println("#ifndef ANDROID");
                out.println("        }");
                out.println("#endif");
            }
            out.println("    }");
            out.println("    if (vm->GetEnv((void**)env, JNI_VERSION_1_6) != JNI_OK) {");
            out.println("        if (vm->AttachCurrentThread(env2, NULL) != 0) {");
            out.println("            JavaCPP_log(\"Could not attach the JavaVM to the current thread.\");");
            out.println("            return -1;");
            out.println("        }");
            out.println("        attached = 1;");
            out.println("    }");
            out.println("    if (JavaCPP_vm == NULL) {");
            out.println("        if (JNI_OnLoad(vm, NULL) < 0) {");
            out.println("            JavaCPP_detach(attached);");
            out.println("            return -1;");
            out.println("        }");
            out.println("    }");
            out.println("    return attached;");
            out.println("}");
            out.println();
        }
        String s5;
        for (iterator1 = functionDefinitions.iterator(); iterator1.hasNext(); out.println(s5))
        {
            s5 = (String)iterator1.next();
        }

        out.println();
        String s6;
        for (iterator1 = functionPointers.iterator(); iterator1.hasNext(); out.println(s6))
        {
            s6 = (String)iterator1.next();
        }

        out.println();
        for (iterator1 = deallocators.iterator(); iterator1.hasNext();)
        {
            Object obj1 = (Class)iterator1.next();
            String s9 = (new StringBuilder()).append("JavaCPP_").append(mangle(((Class) (obj1)).getName())).toString();
            out.print((new StringBuilder()).append("static void ").append(s9).append("_deallocate(").toString());
            if (com/googlecode/javacpp/FunctionPointer.isAssignableFrom(((Class) (obj1))))
            {
                obj1 = getFunctionClassName(((Class) (obj1)));
                out.println((new StringBuilder()).append(((String) (obj1))).append("* p) { JNIEnv *e; int a = JavaCPP_getEnv(&e); if (a >= 0) e->DeleteWeakGlobalRef(p->obj); delete p; JavaCPP_detach(a); }").toString());
            } else
            {
                String as[] = getCPPTypeName(((Class) (obj1)));
                out.println((new StringBuilder()).append(as[0]).append(" p").append(as[1]).append(") { delete p; }").toString());
            }
        }

        String s7;
        String as1[];
        for (iterator1 = arrayDeallocators.iterator(); iterator1.hasNext(); out.println((new StringBuilder()).append("static void ").append(s7).append("_deallocateArray(").append(as1[0]).append(" p").append(as1[1]).append(") { delete[] p; }").toString()))
        {
            Class class2 = (Class)iterator1.next();
            s7 = (new StringBuilder()).append("JavaCPP_").append(mangle(class2.getName())).toString();
            as1 = getCPPTypeName(class2);
        }

        out.println();
        out.println("extern \"C\" {");
        if (out2 != null)
        {
            out2.println();
            out2.println("#ifdef __cplusplus");
            out2.println("extern \"C\" {");
            out2.println("#endif");
            out2.println("JNIIMPORT int JavaCPP_init(int argc, const char *argv[]);");
            out.println();
            out.println("JNIEXPORT int JavaCPP_init(int argc, const char *argv[]) {");
            out.println("#ifdef ANDROID");
            out.println("    return JNI_OK;");
            out.println("#else");
            out.println("    JavaVM *vm;");
            out.println("    JNIEnv *env;");
            out.println("    int nOptions = 1 + (argc > 255 ? 255 : argc);");
            out.println("    JavaVMOption options[256] = { { NULL } };");
            out.println((new StringBuilder()).append("    options[0].optionString = (char*)\"-Djava.class.path=").append(s.replace('\\', '/')).append("\";").toString());
            out.println("    for (int i = 1; i < nOptions && argv != NULL; i++) {");
            out.println("        options[i].optionString = (char*)argv[i - 1];");
            out.println("    }");
            out.println("    JavaVMInitArgs vm_args = { JNI_VERSION_1_6, nOptions, options };");
            out.println("    return JNI_CreateJavaVM(&vm, (void **)&env, &vm_args);");
            out.println("#endif");
            out.println("}");
        }
        out.println();
        out.println("JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM* vm, void* reserved) {");
        out.println("    JNIEnv* env;");
        out.println("    if (vm->GetEnv((void**)&env, JNI_VERSION_1_6) != JNI_OK) {");
        out.println("        JavaCPP_log(\"Could not get JNIEnv for JNI_VERSION_1_6 inside JNI_OnLoad().\");");
        out.println("        return JNI_ERR;");
        out.println("    }");
        out.println("    if (JavaCPP_vm == vm) {");
        out.println("        return env->GetVersion();");
        out.println("    }");
        out.println("    JavaCPP_vm = vm;");
        out.println((new StringBuilder()).append("    const char* members[").append(jclasses.size()).append("][").append(j).append("] = {").toString());
        iterator1 = jclasses.iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            out.print("            { ");
            s = (LinkedList)members.get(iterator1.next());
            if (s == null)
            {
                s = null;
            } else
            {
                s = s.iterator();
            }
            do
            {
                if (s == null || !s.hasNext())
                {
                    break;
                }
                out.print((new StringBuilder()).append("\"").append((String)s.next()).append("\"").toString());
                if (s.hasNext())
                {
                    out.print(", ");
                }
            } while (true);
            out.print(" }");
            if (iterator1.hasNext())
            {
                out.println(",");
            }
        } while (true);
        out.println(" };");
        out.println((new StringBuilder()).append("    int offsets[").append(jclasses.size()).append("][").append(j).append("] = {").toString());
        Iterator iterator2 = jclasses.iterator();
        do
        {
            if (!iterator2.hasNext())
            {
                break;
            }
            out.print("            { ");
            Class class3 = (Class)iterator2.next();
            s = (LinkedList)members.get(class3);
            if (s == null)
            {
                s = null;
            } else
            {
                s = s.iterator();
            }
            do
            {
                if (s == null || !s.hasNext())
                {
                    break;
                }
                String s8 = getValueTypeName(getCPPTypeName(class3));
                String s2 = (String)s.next();
                if ("sizeof".equals(s2))
                {
                    s2 = s8;
                    if ("void".equals(s8))
                    {
                        s2 = "void*";
                    }
                    out.print((new StringBuilder()).append("sizeof(").append(s2).append(")").toString());
                } else
                {
                    out.print((new StringBuilder()).append("offsetof(").append(s8).append(",").append(s2).append(")").toString());
                }
                if (s.hasNext())
                {
                    out.print(", ");
                }
            } while (true);
            out.print(" }");
            if (iterator2.hasNext())
            {
                out.println(",");
            }
        } while (true);
        out.println(" };");
        out.print((new StringBuilder()).append("    int memberOffsetSizes[").append(jclasses.size()).append("] = { ").toString());
        s = jclasses.iterator();
        do
        {
            if (!s.hasNext())
            {
                break;
            }
            LinkedList linkedlist = (LinkedList)members.get(s.next());
            PrintWriter printwriter = out;
            if (linkedlist == null)
            {
                j = 0;
            } else
            {
                j = linkedlist.size();
            }
            printwriter.print(j);
            if (s.hasNext())
            {
                out.print(", ");
            }
        } while (true);
        out.println(" };");
        out.println((new StringBuilder()).append("    jmethodID putMemberOffsetMID = env->GetStaticMethodID(JavaCPP_getClass(env, ").append(jclasses.register(com/googlecode/javacpp/Loader)).append("), \"putMemberOffset\", \"(Ljava/lang/String;Ljava/lang/String;I)V\");").toString());
        out.println("    if (putMemberOffsetMID == NULL || env->ExceptionCheck()) {");
        out.println("        JavaCPP_log(\"Error getting method ID of Loader.putMemberOffset().\");");
        out.println("        return JNI_ERR;");
        out.println("    }");
        out.println((new StringBuilder()).append("    for (int i = 0; i < ").append(jclasses.size()).append(" && !env->ExceptionCheck(); i++) {").toString());
        out.println("        for (int j = 0; j < memberOffsetSizes[i] && !env->ExceptionCheck(); j++) {");
        out.println("            if (env->PushLocalFrame(2) == 0) {");
        out.println("                jvalue args[3];");
        out.println("                args[0].l = env->NewStringUTF(JavaCPP_classNames[i]);");
        out.println("                args[1].l = env->NewStringUTF(members[i][j]);");
        out.println("                args[2].i = offsets[i][j];");
        out.println((new StringBuilder()).append("                env->CallStaticVoidMethodA(JavaCPP_getClass(env, ").append(jclasses.register(com/googlecode/javacpp/Loader)).append("), putMemberOffsetMID, args);").toString());
        out.println("                env->PopLocalFrame(NULL);");
        out.println("            }");
        out.println("        }");
        out.println("    }");
        out.println((new StringBuilder()).append("    JavaCPP_initMID = env->GetMethodID(JavaCPP_getClass(env, ").append(jclasses.register(com/googlecode/javacpp/Pointer)).append("), \"init\", \"(JIJ)V\");").toString());
        out.println("    if (JavaCPP_initMID == NULL || env->ExceptionCheck()) {");
        out.println("        JavaCPP_log(\"Error getting method ID of Pointer.init().\");");
        out.println("        return JNI_ERR;");
        out.println("    }");
        out.println((new StringBuilder()).append("    JavaCPP_addressFID = env->GetFieldID(JavaCPP_getClass(env, ").append(jclasses.register(com/googlecode/javacpp/Pointer)).append("), \"address\", \"J\");").toString());
        out.println("    if (JavaCPP_addressFID == NULL || env->ExceptionCheck()) {");
        out.println("        JavaCPP_log(\"Error getting field ID of Pointer.address.\");");
        out.println("        return JNI_ERR;");
        out.println("    }");
        out.println((new StringBuilder()).append("    JavaCPP_positionFID = env->GetFieldID(JavaCPP_getClass(env, ").append(jclasses.register(com/googlecode/javacpp/Pointer)).append("), \"position\", \"I\");").toString());
        out.println("    if (JavaCPP_positionFID == NULL || env->ExceptionCheck()) {");
        out.println("        JavaCPP_log(\"Error getting field ID of Pointer.position.\");");
        out.println("        return JNI_ERR;");
        out.println("    }");
        out.println((new StringBuilder()).append("    JavaCPP_limitFID = env->GetFieldID(JavaCPP_getClass(env, ").append(jclasses.register(com/googlecode/javacpp/Pointer)).append("), \"limit\", \"I\");").toString());
        out.println("    if (JavaCPP_limitFID == NULL || env->ExceptionCheck()) {");
        out.println("        JavaCPP_log(\"Error getting field ID of Pointer.limit.\");");
        out.println("        return JNI_ERR;");
        out.println("    }");
        out.println((new StringBuilder()).append("    JavaCPP_capacityFID = env->GetFieldID(JavaCPP_getClass(env, ").append(jclasses.register(com/googlecode/javacpp/Pointer)).append("), \"capacity\", \"I\");").toString());
        out.println("    if (JavaCPP_capacityFID == NULL || env->ExceptionCheck()) {");
        out.println("        JavaCPP_log(\"Error getting field ID of Pointer.capacity.\");");
        out.println("        return JNI_ERR;");
        out.println("    }");
        s = jclassesInit.iterator();
        do
        {
            if (!s.hasNext())
            {
                break;
            }
            Class class1 = (Class)s.next();
            if (class1 != com/googlecode/javacpp/Pointer)
            {
                out.println((new StringBuilder()).append("    if (JavaCPP_getClass(env, ").append(jclasses.indexOf(class1)).append(") == NULL) {").toString());
                out.println("        return JNI_ERR;");
                out.println("    }");
            }
        } while (true);
        out.println("    return env->GetVersion();");
        out.println("}");
        out.println();
        if (out2 != null)
        {
            out2.println("JNIIMPORT int JavaCPP_uninit();");
            out2.println();
            out.println("JNIEXPORT int JavaCPP_uninit() {");
            out.println("#ifdef ANDROID");
            out.println("    return JNI_OK;");
            out.println("#else");
            out.println("    JavaVM *vm = JavaCPP_vm;");
            out.println("    JNI_OnUnload(JavaCPP_vm, NULL);");
            out.println("    return vm->DestroyJavaVM();");
            out.println("#endif");
            out.println("}");
        }
        out.println();
        out.println("JNIEXPORT void JNICALL JNI_OnUnload(JavaVM* vm, void* reserved) {");
        out.println("    JNIEnv* env;");
        out.println("    if (vm->GetEnv((void**)&env, JNI_VERSION_1_6) != JNI_OK) {");
        out.println("        JavaCPP_log(\"Could not get JNIEnv for JNI_VERSION_1_6 inside JNI_OnUnLoad().\");");
        out.println("        return;");
        out.println("    }");
        out.println((new StringBuilder()).append("    for (int i = 0; i < ").append(jclasses.size()).append("; i++) {").toString());
        out.println("        env->DeleteWeakGlobalRef(JavaCPP_classes[i]);");
        out.println("        JavaCPP_classes[i] = NULL;");
        out.println("    }");
        out.println("    JavaCPP_vm = NULL;");
        out.println("}");
        out.println();
        for (s = baseClasses.iterator(); s.hasNext(); doMethods((Class)s.next())) { }
        flag = false;
        k = aclass.length;
        j = 0;
_L2:
        if (j >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        s = aclass[j];
        flag1 = doMethods(s);
        flag |= flag1;
_L3:
        j++;
        if (true) goto _L2; else goto _L1
        NoClassDefFoundError noclassdeffounderror;
        noclassdeffounderror;
        logger.log(Level.WARNING, (new StringBuilder()).append("Could not generate code for class ").append(s.getCanonicalName()).append(": ").append(noclassdeffounderror).toString());
          goto _L3
_L1:
        out.println("}");
        out.println();
        if (out2 != null)
        {
            out2.println("#ifdef __cplusplus");
            out2.println("}");
            out2.println("#endif");
        }
        return flag;
    }

    private boolean doMethods(Class class1)
    {
        Object obj1;
        Method amethod[];
        boolean aflag[];
        Method method;
        int j;
        boolean flag2;
        boolean flag3;
        if (!checkPlatform(class1))
        {
            return false;
        }
        LinkedList linkedlist1 = (LinkedList)members.get(class1);
        obj1 = linkedlist1;
        if (!class1.isAnnotationPresent(com/googlecode/javacpp/annotation/Opaque))
        {
            obj1 = linkedlist1;
            if (!com/googlecode/javacpp/FunctionPointer.isAssignableFrom(class1))
            {
                LinkedList linkedlist = linkedlist1;
                if (linkedlist1 == null)
                {
                    obj1 = members;
                    linkedlist = new LinkedList();
                    ((HashMap) (obj1)).put(class1, linkedlist);
                }
                obj1 = linkedlist;
                if (!linkedlist.contains("sizeof"))
                {
                    linkedlist.add("sizeof");
                    obj1 = linkedlist;
                }
            }
        }
        flag3 = false;
        Class aclass[] = class1.getDeclaredClasses();
        for (int i = 0; i < aclass.length;)
        {
            boolean flag;
label0:
            {
                if (!com/googlecode/javacpp/Pointer.isAssignableFrom(aclass[i]))
                {
                    flag = flag3;
                    if (!com/googlecode/javacpp/Pointer$Deallocator.isAssignableFrom(aclass[i]))
                    {
                        break label0;
                    }
                }
                flag = flag3 | doMethods(aclass[i]);
            }
            i++;
            flag3 = flag;
        }

        amethod = class1.getDeclaredMethods();
        aflag = new boolean[amethod.length];
        method = getFunctionMethod(class1, aflag);
        if (method != null)
        {
            String as[] = getCPPTypeName(class1);
            String as1[] = as[0].split("\\(");
            as1[1] = getValueTypeName(new String[] {
                as1[1]
            });
            String s2 = as[1].substring(1);
            String s3 = getFunctionClassName(class1);
            functionDefinitions.register((new StringBuilder()).append("struct JavaCPP_hidden ").append(s3).append(" {\n").append("    ").append(s3).append("() : ptr(NULL), obj(NULL) { }\n").append("    ").append(as1[0]).append("operator()").append(s2).append(";\n").append("    ").append(as[0]).append("ptr").append(as[1]).append(";\n").append("    jobject obj; static jmethodID mid;\n").append("};\n").append("jmethodID ").append(s3).append("::mid = NULL;").toString());
        }
        flag2 = true;
        j = 0;
_L2:
        String s4;
        if (j >= amethod.length)
        {
            break MISSING_BLOCK_LABEL_1579;
        }
        s4 = (new StringBuilder()).append(mangle(class1.getName())).append("_").append(mangle(amethod[j].getName())).toString();
        if (checkPlatform((Platform)amethod[j].getAnnotation(com/googlecode/javacpp/annotation/Platform)))
        {
            break; /* Loop/switch isn't completed */
        }
_L3:
        j++;
        if (true) goto _L2; else goto _L1
_L1:
        MethodInformation methodinformation = getMethodInformation(amethod[j]);
        String s1 = (new StringBuilder()).append("JavaCPP_").append(s4).append("_callback").toString();
        if (aflag[j] && method == null)
        {
            logger.log(Level.WARNING, (new StringBuilder()).append("No callback method call() or apply() has been not declared in \"").append(class1.getCanonicalName()).append("\". No code will be generated for callback allocator.").toString());
        } else
        {
            String s;
            boolean flag1;
            boolean flag4;
label1:
            {
                if (!aflag[j])
                {
                    s = s1;
                    flag4 = flag3;
                    flag1 = flag2;
                    if (!amethod[j].equals(method))
                    {
                        break label1;
                    }
                    s = s1;
                    flag4 = flag3;
                    flag1 = flag2;
                    if (methodinformation != null)
                    {
                        break label1;
                    }
                }
                Name name = (Name)amethod[j].getAnnotation(com/googlecode/javacpp/annotation/Name);
                s = s1;
                if (name != null)
                {
                    s = s1;
                    if (name.value().length > 0)
                    {
                        s = s1;
                        if (name.value()[0].length() > 0)
                        {
                            s = name.value()[0];
                        }
                    }
                }
                doCallback(class1, method, s, flag2);
                flag1 = false;
                flag4 = true;
            }
            flag3 = flag4;
            flag2 = flag1;
            if (methodinformation != null)
            {
                if ((methodinformation.memberGetter || methodinformation.memberSetter) && !methodinformation.noOffset && obj1 != null && !Modifier.isStatic(methodinformation.modifiers) && !((LinkedList) (obj1)).contains(methodinformation.memberName[0]))
                {
                    ((LinkedList) (obj1)).add(methodinformation.memberName[0]);
                }
                flag3 = true;
                out.print((new StringBuilder()).append("JNIEXPORT ").append(getJNITypeName(methodinformation.returnType)).append(" JNICALL Java_").append(s4).toString());
                if (methodinformation.overloaded)
                {
                    out.print((new StringBuilder()).append("__").append(mangle(getSignature(methodinformation.parameterTypes))).toString());
                }
                int k;
                if (Modifier.isStatic(methodinformation.modifiers))
                {
                    out.print("(JNIEnv* env, jclass cls");
                } else
                {
                    out.print("(JNIEnv* env, jobject obj");
                }
                for (k = 0; k < methodinformation.parameterTypes.length; k++)
                {
                    out.print((new StringBuilder()).append(", ").append(getJNITypeName(methodinformation.parameterTypes[k])).append(" arg").append(k).toString());
                }

                out.println(") {");
                if (aflag[j])
                {
                    doCallbackAllocator(class1, s);
                    flag2 = flag1;
                } else
                {
                    if (!Modifier.isStatic(methodinformation.modifiers) && !methodinformation.allocator && !methodinformation.arrayAllocator && !methodinformation.deallocator)
                    {
                        Object obj = getCPPTypeName(class1);
                        PrintWriter printwriter;
                        StringBuilder stringbuilder;
                        if ("void*".equals(obj[0]))
                        {
                            obj[0] = "char*";
                        } else
                        if (com/googlecode/javacpp/FunctionPointer.isAssignableFrom(class1))
                        {
                            obj[0] = (new StringBuilder()).append(getFunctionClassName(class1)).append("*").toString();
                            obj[1] = "";
                        }
                        out.println((new StringBuilder()).append("    ").append(obj[0]).append(" ptr").append(obj[1]).append(" = (").append(obj[0]).append(obj[1]).append(")jlong_to_ptr(env->GetLongField(obj, JavaCPP_addressFID));").toString());
                        out.println("    if (ptr == NULL) {");
                        out.println((new StringBuilder()).append("        env->ThrowNew(JavaCPP_getClass(env, ").append(jclasses.register(java/lang/NullPointerException)).append("), \"This pointer address is NULL.\");").toString());
                        printwriter = out;
                        stringbuilder = (new StringBuilder()).append("        return");
                        if (methodinformation.returnType == Void.TYPE)
                        {
                            obj = ";";
                        } else
                        {
                            obj = " 0;";
                        }
                        printwriter.println(stringbuilder.append(((String) (obj))).toString());
                        out.println("    }");
                        if (com/googlecode/javacpp/FunctionPointer.isAssignableFrom(class1))
                        {
                            out.println("    if (ptr->ptr == NULL) {");
                            out.println((new StringBuilder()).append("        env->ThrowNew(JavaCPP_getClass(env, ").append(jclasses.register(java/lang/NullPointerException)).append("), \"This function pointer address is NULL.\");").toString());
                            PrintWriter printwriter1 = out;
                            StringBuilder stringbuilder1 = (new StringBuilder()).append("        return");
                            if (methodinformation.returnType == Void.TYPE)
                            {
                                obj = ";";
                            } else
                            {
                                obj = " 0;";
                            }
                            printwriter1.println(stringbuilder1.append(((String) (obj))).toString());
                            out.println("    }");
                        }
                        if (!class1.isAnnotationPresent(com/googlecode/javacpp/annotation/Opaque))
                        {
                            out.println("    jint position = env->GetIntField(obj, JavaCPP_positionFID);");
                            out.println("    ptr += position;");
                            if (methodinformation.bufferGetter)
                            {
                                out.println("    jint size = env->GetIntField(obj, JavaCPP_limitFID);");
                                out.println("    size -= position;");
                            }
                        }
                    }
                    doParametersBefore(methodinformation);
                    doCall(methodinformation, doReturnBefore(methodinformation));
                    doReturnAfter(methodinformation);
                    doParametersAfter(methodinformation);
                    if (methodinformation.throwsException != null)
                    {
                        out.println("    if (exc != NULL) {");
                        out.println("        env->Throw(exc);");
                        out.println("    }");
                    }
                    if (methodinformation.returnType != Void.TYPE)
                    {
                        out.println("    return rarg;");
                    }
                    out.println("}");
                    flag2 = flag1;
                }
            }
        }
          goto _L3
        out.println();
        return flag3;
          goto _L3
    }

    private void doParametersAfter(MethodInformation methodinformation)
    {
        if (methodinformation.throwsException != null)
        {
            mayThrowExceptions = true;
            out.println("    } catch (...) {");
            out.println((new StringBuilder()).append("        exc = JavaCPP_handleException(env, ").append(jclasses.register(methodinformation.throwsException)).append(");").toString());
            out.println("    }");
            out.println();
        }
        int i = 0;
        while (i < methodinformation.parameterTypes.length) 
        {
            if (!methodinformation.parameterRaw[i])
            {
                Object obj = getParameterBy(methodinformation, i);
                String s1 = getParameterCast(methodinformation, i);
                String as[] = getCastedCPPTypeName(methodinformation.parameterAnnotations[i], methodinformation.parameterTypes[i]);
                AdapterInformation adapterinformation = getParameterAdapterInformation(true, methodinformation, i);
                if ("void*".equals(as[0]))
                {
                    as[0] = "char*";
                }
                if (com/googlecode/javacpp/Pointer.isAssignableFrom(methodinformation.parameterTypes[i]))
                {
                    if (adapterinformation != null)
                    {
                        int j = 0;
                        while (j < adapterinformation.argc) 
                        {
                            out.println((new StringBuilder()).append("    ").append(as[0]).append(" rptr").append(i + j).append(as[1]).append(" = ").append(s1).append("adapter").append(i).append(";").toString());
                            PrintWriter printwriter = out;
                            StringBuilder stringbuilder = (new StringBuilder()).append("    jint rsize").append(i + j).append(" = (jint)adapter").append(i).append(".size");
                            if (j > 0)
                            {
                                obj = (new StringBuilder()).append(j + 1).append(";").toString();
                            } else
                            {
                                obj = ";";
                            }
                            printwriter.println(stringbuilder.append(((String) (obj))).toString());
                            out.println((new StringBuilder()).append("    if (rptr").append(i + j).append(" != ").append(s1).append("ptr").append(i + j).append(") {").toString());
                            out.println("        jvalue args[3];");
                            out.println((new StringBuilder()).append("        args[0].j = ptr_to_jlong(rptr").append(i + j).append(");").toString());
                            out.println((new StringBuilder()).append("        args[1].i = rsize").append(i + j).append(";").toString());
                            out.println((new StringBuilder()).append("        args[2].j = ptr_to_jlong(&(").append(adapterinformation.name).append("::deallocate));").toString());
                            out.println((new StringBuilder()).append("        env->CallNonvirtualVoidMethodA(arg").append(i).append(", JavaCPP_getClass(env, ").append(jclasses.register(com/googlecode/javacpp/Pointer)).append("), JavaCPP_initMID, args);").toString());
                            out.println("    } else {");
                            out.println((new StringBuilder()).append("        env->SetIntField(arg").append(i).append(", JavaCPP_limitFID, rsize").append(i + j).append(" + position").append(i + j).append(");").toString());
                            out.println("    }");
                            j++;
                        }
                    } else
                    if (((obj instanceof ByPtrPtr) || (obj instanceof ByPtrRef)) && !methodinformation.valueSetter && !methodinformation.memberSetter)
                    {
                        if (!methodinformation.parameterTypes[i].isAnnotationPresent(com/googlecode/javacpp/annotation/Opaque))
                        {
                            out.println((new StringBuilder()).append("    ptr").append(i).append(" -= position").append(i).append(";").toString());
                        }
                        out.println((new StringBuilder()).append("    if (arg").append(i).append(" != NULL) env->SetLongField(arg").append(i).append(", JavaCPP_addressFID, ptr_to_jlong(ptr").append(i).append("));").toString());
                    }
                } else
                if (methodinformation.parameterTypes[i] == java/lang/String)
                {
                    out.println((new StringBuilder()).append("    if (arg").append(i).append(" != NULL) env->ReleaseStringUTFChars(arg").append(i).append(", ptr").append(i).append(");").toString());
                } else
                if (methodinformation.parameterTypes[i].isArray() && methodinformation.parameterTypes[i].getComponentType().isPrimitive())
                {
                    out.print((new StringBuilder()).append("    if (arg").append(i).append(" != NULL) ").toString());
                    if (methodinformation.valueGetter || methodinformation.valueSetter || methodinformation.memberGetter || methodinformation.memberSetter)
                    {
                        out.println((new StringBuilder()).append("env->ReleasePrimitiveArrayCritical(arg").append(i).append(", ptr").append(i).append(", 0);").toString());
                    } else
                    {
                        String s = methodinformation.parameterTypes[i].getComponentType().getName();
                        String s2 = (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
                        out.println((new StringBuilder()).append("env->Release").append(s2).append("ArrayElements(arg").append(i).append(", (j").append(s).append("*)ptr").append(i).append(", 0);").toString());
                    }
                }
            }
            i++;
        }
    }

    private void doParametersBefore(MethodInformation methodinformation)
    {
        String s = "";
        Object obj = null;
        int i = 0;
        do
        {
            if (i < methodinformation.parameterTypes.length)
            {
                Object obj3 = s;
                Object obj2 = obj;
                if (!methodinformation.parameterTypes[i].isPrimitive())
                {
                    Annotation annotation = getParameterBy(methodinformation, i);
                    obj3 = getParameterCast(methodinformation, i);
                    Object obj4 = getCPPTypeName(methodinformation.parameterTypes[i]);
                    obj2 = getParameterAdapterInformation(false, methodinformation, i);
                    if (com/googlecode/javacpp/FunctionPointer.isAssignableFrom(methodinformation.parameterTypes[i]))
                    {
                        if (methodinformation.parameterTypes[i] == com/googlecode/javacpp/FunctionPointer)
                        {
                            logger.log(Level.WARNING, (new StringBuilder()).append("Method \"").append(methodinformation.method).append("\" has an abstract FunctionPointer parameter, ").append("but a concrete subclass is required. Compilation will most likely fail.").toString());
                        }
                        obj4[0] = (new StringBuilder()).append(getFunctionClassName(methodinformation.parameterTypes[i])).append("*").toString();
                        obj4[1] = "";
                    }
                    if (obj4[0].length() == 0 || methodinformation.parameterRaw[i])
                    {
                        methodinformation.parameterRaw[i] = true;
                        obj4[0] = getJNITypeName(methodinformation.parameterTypes[i]);
                        out.println((new StringBuilder()).append("    ").append(obj4[0]).append(" ptr").append(i).append(" = arg").append(i).append(";").toString());
                        obj2 = obj;
                        obj3 = s;
                    } else
                    {
                        if ("void*".equals(obj4[0]))
                        {
                            obj4[0] = "char*";
                        }
                        out.print((new StringBuilder()).append("    ").append(obj4[0]).append(" ptr").append(i).append(obj4[1]).append(" = ").toString());
                        if (com/googlecode/javacpp/Pointer.isAssignableFrom(methodinformation.parameterTypes[i]))
                        {
                            out.println((new StringBuilder()).append("arg").append(i).append(" == NULL ? NULL : (").append(obj4[0]).append(obj4[1]).append(")jlong_to_ptr(env->GetLongField(arg").append(i).append(", JavaCPP_addressFID));").toString());
                            if (i == 0 && com/googlecode/javacpp/FunctionPointer.isAssignableFrom(methodinformation.cls) && methodinformation.cls.isAnnotationPresent(com/googlecode/javacpp/annotation/Namespace) || (annotation instanceof ByVal) || (annotation instanceof ByRef))
                            {
                                out.println((new StringBuilder()).append("    if (ptr").append(i).append(" == NULL) {").toString());
                                out.println((new StringBuilder()).append("        env->ThrowNew(JavaCPP_getClass(env, ").append(jclasses.register(java/lang/NullPointerException)).append("), \"Pointer address of argument ").append(i).append(" is NULL.\");").toString());
                                obj4 = out;
                                StringBuilder stringbuilder = (new StringBuilder()).append("        return");
                                Object obj1;
                                int j;
                                if (methodinformation.returnType == Void.TYPE)
                                {
                                    obj1 = ";";
                                } else
                                {
                                    obj1 = " 0;";
                                }
                                ((PrintWriter) (obj4)).println(stringbuilder.append(((String) (obj1))).toString());
                                out.println("    }");
                            }
                            if (obj2 != null || obj != null)
                            {
                                out.println((new StringBuilder()).append("    jint size").append(i).append(" = arg").append(i).append(" == NULL ? 0 : env->GetIntField(arg").append(i).append(", JavaCPP_limitFID);").toString());
                            }
                            if (!methodinformation.parameterTypes[i].isAnnotationPresent(com/googlecode/javacpp/annotation/Opaque))
                            {
                                out.println((new StringBuilder()).append("    jint position").append(i).append(" = arg").append(i).append(" == NULL ? 0 : env->GetIntField(arg").append(i).append(", JavaCPP_positionFID);").toString());
                                out.println((new StringBuilder()).append("    ptr").append(i).append(" += position").append(i).append(";").toString());
                                if (obj2 != null || obj != null)
                                {
                                    out.println((new StringBuilder()).append("    size").append(i).append(" -= position").append(i).append(";").toString());
                                }
                            }
                        } else
                        if (methodinformation.parameterTypes[i] == java/lang/String)
                        {
                            out.println((new StringBuilder()).append("arg").append(i).append(" == NULL ? NULL : env->GetStringUTFChars(arg").append(i).append(", NULL);").toString());
                            if (obj2 != null || obj != null)
                            {
                                out.println((new StringBuilder()).append("    jint size").append(i).append(" = 0;").toString());
                            }
                        } else
                        if (methodinformation.parameterTypes[i].isArray() && methodinformation.parameterTypes[i].getComponentType().isPrimitive())
                        {
                            out.print((new StringBuilder()).append("arg").append(i).append(" == NULL ? NULL : ").toString());
                            String s1 = methodinformation.parameterTypes[i].getComponentType().getName();
                            if (methodinformation.valueGetter || methodinformation.valueSetter || methodinformation.memberGetter || methodinformation.memberSetter)
                            {
                                out.println((new StringBuilder()).append("(j").append(s1).append("*)env->GetPrimitiveArrayCritical(arg").append(i).append(", NULL);").toString());
                            } else
                            {
                                s1 = (new StringBuilder()).append(Character.toUpperCase(s1.charAt(0))).append(s1.substring(1)).toString();
                                out.println((new StringBuilder()).append("env->Get").append(s1).append("ArrayElements(arg").append(i).append(", NULL);").toString());
                            }
                            if (obj2 != null || obj != null)
                            {
                                out.println((new StringBuilder()).append("    jint size").append(i).append(" = arg").append(i).append(" == NULL ? 0 : env->GetArrayLength(arg").append(i).append(");").toString());
                            }
                        } else
                        if (java/nio/Buffer.isAssignableFrom(methodinformation.parameterTypes[i]))
                        {
                            out.println((new StringBuilder()).append("arg").append(i).append(" == NULL ? NULL : (").append(obj4[0]).append(obj4[1]).append(")env->GetDirectBufferAddress(arg").append(i).append(");").toString());
                            if (obj2 != null || obj != null)
                            {
                                out.println((new StringBuilder()).append("    jint size").append(i).append(" = arg").append(i).append(" == NULL ? 0 : env->GetDirectBufferCapacity(arg").append(i).append(");").toString());
                            }
                        } else
                        {
                            out.println((new StringBuilder()).append("arg").append(i).append(";").toString());
                            logger.log(Level.WARNING, (new StringBuilder()).append("Method \"").append(methodinformation.method).append("\" has an unsupported parameter of type \"").append(methodinformation.parameterTypes[i].getCanonicalName()).append("\". Compilation will most likely fail.").toString());
                        }
                        obj1 = obj;
                        if (obj2 != null)
                        {
                            usesAdapters = true;
                            s = (new StringBuilder()).append("    ").append(((AdapterInformation) (obj2)).name).append(" adapter").append(i).append("(").toString();
                            obj1 = obj2;
                        }
                        obj = s;
                        if (obj1 != null)
                        {
                            obj = s;
                            if (!com/googlecode/javacpp/FunctionPointer.isAssignableFrom(methodinformation.cls))
                            {
                                obj = (new StringBuilder()).append(s).append(((String) (obj3))).toString();
                            }
                            s = (new StringBuilder()).append(((String) (obj))).append("ptr").append(i).append(", size").append(i).toString();
                            j = ((AdapterInformation) (obj1)).argc - 1;
                            obj1.argc = j;
                            obj = s;
                            if (j > 0)
                            {
                                obj = (new StringBuilder()).append(s).append(", ").toString();
                            }
                        }
                        obj3 = obj;
                        obj2 = obj1;
                        if (obj1 != null)
                        {
                            obj3 = obj;
                            obj2 = obj1;
                            if (((AdapterInformation) (obj1)).argc <= 0)
                            {
                                out.println((new StringBuilder()).append(((String) (obj))).append(");").toString());
                                obj2 = null;
                                obj3 = obj;
                            }
                        }
                    }
                }
            } else
            {
                return;
            }
            i++;
            s = ((String) (obj3));
            obj = obj2;
        } while (true);
    }

    private void doReturnAfter(MethodInformation methodinformation)
    {
        Object obj;
        Object obj1;
        String s2;
        Object obj2;
        Annotation annotation;
        int i;
        String as[];
        boolean flag2;
        int k;
        if (methodinformation.throwsException != null)
        {
            s2 = "        ";
        } else
        {
            s2 = "    ";
        }
        as = getCastedCPPTypeName(methodinformation.annotations, methodinformation.returnType);
        annotation = getBy(methodinformation.annotations);
        obj2 = getAdapterInformation(false, getValueTypeName(as), methodinformation.annotations);
        if (methodinformation.deallocator)
        {
            obj1 = "";
        } else
        {
            obj1 = ";";
        }
        obj = obj1;
        if (!methodinformation.returnType.isPrimitive())
        {
            obj = obj1;
            if (obj2 != null)
            {
                obj = (new StringBuilder()).append(")").append(((String) (obj1))).toString();
            }
        }
        if (com/googlecode/javacpp/Pointer.isAssignableFrom(methodinformation.returnType)) goto _L2; else goto _L1
_L1:
        obj1 = obj;
        if (!methodinformation.returnType.isArray()) goto _L4; else goto _L3
_L3:
        obj1 = obj;
        if (!methodinformation.returnType.getComponentType().isPrimitive()) goto _L4; else goto _L2
_L2:
        if (!(annotation instanceof ByVal)) goto _L6; else goto _L5
_L5:
        obj1 = (new StringBuilder()).append(")").append(((String) (obj))).toString();
_L4:
        out.println(((String) (obj1)));
        if (methodinformation.returnType != Void.TYPE) goto _L8; else goto _L7
_L7:
        if (!methodinformation.allocator && !methodinformation.arrayAllocator) goto _L10; else goto _L9
_L9:
        obj1 = out;
        obj2 = (new StringBuilder()).append(s2).append("jint rcapacity = ");
        boolean flag;
        if (methodinformation.arrayAllocator)
        {
            obj = "arg0;";
        } else
        {
            obj = "1;";
        }
        ((PrintWriter) (obj1)).println(((StringBuilder) (obj2)).append(((String) (obj))).toString());
        if (methodinformation.cls == com/googlecode/javacpp/Pointer || methodinformation.cls.isAnnotationPresent(com/googlecode/javacpp/annotation/NoDeallocator))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj = methodinformation.annotations;
        k = obj.length;
        i = 0;
_L17:
        flag2 = flag;
        if (i >= k) goto _L12; else goto _L11
_L11:
        if (!(obj[i] instanceof NoDeallocator)) goto _L14; else goto _L13
_L13:
        flag2 = true;
_L12:
        if (flag2) goto _L16; else goto _L15
_L15:
        out.println((new StringBuilder()).append(s2).append("jvalue args[3];").toString());
        out.println((new StringBuilder()).append(s2).append("args[0].j = ptr_to_jlong(rptr);").toString());
        out.println((new StringBuilder()).append(s2).append("args[1].i = rcapacity;").toString());
        out.print((new StringBuilder()).append(s2).append("args[2].j = ptr_to_jlong(&JavaCPP_").append(mangle(methodinformation.cls.getName())).toString());
        if (methodinformation.arrayAllocator)
        {
            out.println("_deallocateArray);");
            arrayDeallocators.register(methodinformation.cls);
        } else
        {
            out.println("_deallocate);");
            deallocators.register(methodinformation.cls);
        }
        out.println((new StringBuilder()).append(s2).append("env->CallNonvirtualVoidMethodA(obj, JavaCPP_getClass(env, ").append(jclasses.register(com/googlecode/javacpp/Pointer)).append("), JavaCPP_initMID, args);").toString());
_L10:
        return;
_L6:
        obj1 = obj;
        if (annotation instanceof ByPtrPtr)
        {
            out.println(((String) (obj)));
            obj1 = "";
            out.println((new StringBuilder()).append(s2).append("if (rptrptr == NULL) {").toString());
            out.println((new StringBuilder()).append(s2).append("    env->ThrowNew(JavaCPP_getClass(env, ").append(jclasses.register(java/lang/NullPointerException)).append("), \"Return pointer address is NULL.\");").toString());
            out.println((new StringBuilder()).append(s2).append("} else {").toString());
            out.println((new StringBuilder()).append(s2).append("    rptr = *rptrptr;").toString());
            out.println((new StringBuilder()).append(s2).append("}").toString());
        }
        continue; /* Loop/switch isn't completed */
_L14:
        i++;
          goto _L17
_L16:
        out.println((new StringBuilder()).append(s2).append("env->SetLongField(obj, JavaCPP_addressFID, ptr_to_jlong(rptr));").toString());
        out.println((new StringBuilder()).append(s2).append("env->SetIntField(obj, JavaCPP_limitFID, rcapacity);").toString());
        out.println((new StringBuilder()).append(s2).append("env->SetIntField(obj, JavaCPP_capacityFID, rcapacity);").toString());
        return;
_L8:
        if (methodinformation.valueSetter || methodinformation.memberSetter || methodinformation.noReturnGetter) goto _L10; else goto _L18
_L18:
        if (methodinformation.returnType.isPrimitive())
        {
            out.println((new StringBuilder()).append(s2).append("rarg = (").append(getJNITypeName(methodinformation.returnType)).append(")rvalue;").toString());
            return;
        }
        if (methodinformation.returnRaw)
        {
            out.println((new StringBuilder()).append(s2).append("rarg = rptr;").toString());
            return;
        }
        boolean flag1 = false;
        if (obj2 != null)
        {
            out.println((new StringBuilder()).append(s2).append("rptr = radapter;").toString());
            if (methodinformation.returnType != java/lang/String)
            {
                out.println((new StringBuilder()).append(s2).append("jint rcapacity = (jint)radapter.size;").toString());
                PrintWriter printwriter = out;
                StringBuilder stringbuilder = (new StringBuilder()).append(s2).append("jlong deallocator = ");
                String s;
                int j;
                if (((AdapterInformation) (obj2)).constant)
                {
                    s = "0;";
                } else
                {
                    s = (new StringBuilder()).append("ptr_to_jlong(&(").append(((AdapterInformation) (obj2)).name).append("::deallocate));").toString();
                }
                printwriter.println(stringbuilder.append(s).toString());
            }
            flag1 = true;
        } else
        if ((annotation instanceof ByVal) || com/googlecode/javacpp/FunctionPointer.isAssignableFrom(methodinformation.returnType))
        {
            out.println((new StringBuilder()).append(s2).append("jint rcapacity = 1;").toString());
            out.println((new StringBuilder()).append(s2).append("jlong deallocator = ptr_to_jlong(&JavaCPP_").append(mangle(methodinformation.returnType.getName())).append("_deallocate);").toString());
            deallocators.register(methodinformation.returnType);
            flag1 = true;
        }
        if (com/googlecode/javacpp/Pointer.isAssignableFrom(methodinformation.returnType))
        {
            out.print(s2);
            if (!(annotation instanceof ByVal))
            {
                if (Modifier.isStatic(methodinformation.modifiers) && methodinformation.parameterTypes.length > 0)
                {
                    for (j = 0; j < methodinformation.parameterTypes.length; j++)
                    {
                        s = getParameterCast(methodinformation, j);
                        if (methodinformation.parameterTypes[j] == methodinformation.returnType)
                        {
                            out.println((new StringBuilder()).append("if (rptr == ").append(s).append("ptr").append(j).append(") {").toString());
                            out.println((new StringBuilder()).append(s2).append("    rarg = arg").append(j).append(";").toString());
                            out.print((new StringBuilder()).append(s2).append("} else ").toString());
                        }
                    }

                } else
                if (!Modifier.isStatic(methodinformation.modifiers) && methodinformation.cls == methodinformation.returnType)
                {
                    out.println("if (rptr == ptr) {");
                    out.println((new StringBuilder()).append(s2).append("    rarg = obj;").toString());
                    out.print((new StringBuilder()).append(s2).append("} else ").toString());
                }
            }
            out.println("if (rptr != NULL) {");
            out.println((new StringBuilder()).append(s2).append("    rarg = env->AllocObject(JavaCPP_getClass(env, ").append(jclasses.register(methodinformation.returnType)).append("));").toString());
            if (flag1)
            {
                out.println((new StringBuilder()).append(s2).append("    if (deallocator != 0) {").toString());
                out.println((new StringBuilder()).append(s2).append("        jvalue args[3];").toString());
                out.println((new StringBuilder()).append(s2).append("        args[0].j = ptr_to_jlong(rptr);").toString());
                out.println((new StringBuilder()).append(s2).append("        args[1].i = rcapacity;").toString());
                out.println((new StringBuilder()).append(s2).append("        args[2].j = deallocator;").toString());
                out.println((new StringBuilder()).append(s2).append("        env->CallNonvirtualVoidMethodA(rarg, JavaCPP_getClass(env, ").append(jclasses.register(com/googlecode/javacpp/Pointer)).append("), JavaCPP_initMID, args);").toString());
                out.println((new StringBuilder()).append(s2).append("    } else {").toString());
                out.println((new StringBuilder()).append(s2).append("        env->SetLongField(rarg, JavaCPP_addressFID, ptr_to_jlong(rptr));").toString());
                out.println((new StringBuilder()).append(s2).append("        env->SetIntField(rarg, JavaCPP_limitFID, rcapacity);").toString());
                out.println((new StringBuilder()).append(s2).append("        env->SetIntField(rarg, JavaCPP_capacityFID, rcapacity);").toString());
                out.println((new StringBuilder()).append(s2).append("    }").toString());
            } else
            {
                out.println((new StringBuilder()).append(s2).append("    env->SetLongField(rarg, JavaCPP_addressFID, ptr_to_jlong(rptr));").toString());
            }
            out.println((new StringBuilder()).append(s2).append("}").toString());
            return;
        }
        if (methodinformation.returnType == java/lang/String)
        {
            out.println((new StringBuilder()).append(s2).append("if (rptr != NULL) {").toString());
            out.println((new StringBuilder()).append(s2).append("    rarg = env->NewStringUTF(rptr);").toString());
            out.println((new StringBuilder()).append(s2).append("}").toString());
            return;
        }
        if (!methodinformation.returnType.isArray() || !methodinformation.returnType.getComponentType().isPrimitive())
        {
            continue; /* Loop/switch isn't completed */
        }
        if (obj2 == null)
        {
            out.println((new StringBuilder()).append(s2).append("jint rcapacity = rptr != NULL ? 1 : 0;").toString());
        }
        methodinformation = methodinformation.returnType.getComponentType().getName();
        String s1 = (new StringBuilder()).append(Character.toUpperCase(methodinformation.charAt(0))).append(methodinformation.substring(1)).toString();
        out.println((new StringBuilder()).append(s2).append("if (rptr != NULL) {").toString());
        out.println((new StringBuilder()).append(s2).append("    rarg = env->New").append(s1).append("Array(rcapacity);").toString());
        out.println((new StringBuilder()).append(s2).append("    env->Set").append(s1).append("ArrayRegion(rarg, 0, rcapacity, (j").append(methodinformation).append("*)rptr);").toString());
        out.println((new StringBuilder()).append(s2).append("}").toString());
        if (obj2 == null) goto _L10; else goto _L19
_L19:
        out.println((new StringBuilder()).append(s2).append("if (deallocator != 0 && rptr != NULL) {").toString());
        out.println((new StringBuilder()).append(s2).append("    (*(void(*)(void*))jlong_to_ptr(deallocator))((void*)rptr);").toString());
        out.println((new StringBuilder()).append(s2).append("}").toString());
        return;
        if (!java/nio/Buffer.isAssignableFrom(methodinformation.returnType)) goto _L10; else goto _L20
_L20:
        if (!methodinformation.bufferGetter) goto _L22; else goto _L21
_L21:
        out.println((new StringBuilder()).append(s2).append("jint rcapacity = size;").toString());
_L24:
        out.println((new StringBuilder()).append(s2).append("if (rptr != NULL) {").toString());
        out.println((new StringBuilder()).append(s2).append("    rarg = env->NewDirectByteBuffer(rptr, rcapacity);").toString());
        out.println((new StringBuilder()).append(s2).append("}").toString());
        return;
_L22:
        if (obj2 == null)
        {
            out.println((new StringBuilder()).append(s2).append("jint rcapacity = rptr != NULL ? 1 : 0;").toString());
        }
        if (true) goto _L24; else goto _L23
_L23:
        if (true) goto _L4; else goto _L25
_L25:
    }

    private String doReturnBefore(MethodInformation methodinformation)
    {
        Object obj1 = "";
        if (methodinformation.returnType != Void.TYPE) goto _L2; else goto _L1
_L1:
        if (methodinformation.allocator || methodinformation.arrayAllocator)
        {
            if (methodinformation.cls != com/googlecode/javacpp/Pointer)
            {
                out.println((new StringBuilder()).append("    if (!env->IsSameObject(env->GetObjectClass(obj), JavaCPP_getClass(env, ").append(jclasses.register(methodinformation.cls)).append("))) {").toString());
                out.println("        return;");
                out.println("    }");
            }
            String as[] = getCPPTypeName(methodinformation.cls);
            obj1 = (new StringBuilder()).append(as[0]).append(" rptr").append(as[1]).append(" = ").toString();
        }
_L4:
        if (methodinformation.throwsException != null)
        {
            out.println("    jthrowable exc = NULL;");
            out.println("    try {");
        }
        return ((String) (obj1));
_L2:
        Object obj;
        String s;
        Object obj2;
        String s1;
        s1 = getCast(methodinformation.annotations, methodinformation.returnType);
        obj2 = getCastedCPPTypeName(methodinformation.annotations, methodinformation.returnType);
        if (methodinformation.valueSetter || methodinformation.memberSetter || methodinformation.noReturnGetter)
        {
            out.println("    jobject rarg = obj;");
            continue; /* Loop/switch isn't completed */
        }
        if (methodinformation.returnType.isPrimitive())
        {
            out.println((new StringBuilder()).append("    ").append(getJNITypeName(methodinformation.returnType)).append(" rarg = 0;").toString());
            obj1 = (new StringBuilder()).append(obj2[0]).append(" rvalue").append(obj2[1]).append(" = ").append(s1).toString();
            continue; /* Loop/switch isn't completed */
        }
        obj1 = getBy(methodinformation.annotations);
        s = getValueTypeName(((String []) (obj2)));
        obj = (new StringBuilder()).append("rptr = ").append(s1).toString();
        if (obj2[0].length() != 0 && !methodinformation.returnRaw)
        {
            break; /* Loop/switch isn't completed */
        }
        methodinformation.returnRaw = true;
        obj2[0] = getJNITypeName(methodinformation.returnType);
        out.println((new StringBuilder()).append("    ").append(obj2[0]).append(" rarg = NULL;").toString());
        out.println((new StringBuilder()).append("    ").append(obj2[0]).append(" rptr;").toString());
        obj2 = s;
        obj1 = obj;
_L5:
        obj = getAdapterInformation(false, ((String) (obj2)), methodinformation.annotations);
        if (obj != null)
        {
            usesAdapters = true;
            obj1 = (new StringBuilder()).append(((AdapterInformation) (obj)).name).append(" radapter(").toString();
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (com/googlecode/javacpp/Pointer.isAssignableFrom(methodinformation.returnType) || java/nio/Buffer.isAssignableFrom(methodinformation.returnType) || methodinformation.returnType.isArray() && methodinformation.returnType.getComponentType().isPrimitive())
        {
            if (com/googlecode/javacpp/FunctionPointer.isAssignableFrom(methodinformation.returnType))
            {
                obj2[0] = (new StringBuilder()).append(getFunctionClassName(methodinformation.returnType)).append("*").toString();
                obj2[1] = "";
                s = getValueTypeName(((String []) (obj2)));
                obj = "if (rptr != NULL) rptr->ptr = ";
            }
            if (obj1 instanceof ByVal)
            {
                obj1 = (new StringBuilder()).append(((String) (obj)));
                if (getNoException(methodinformation.returnType, methodinformation.method))
                {
                    obj = "new (std::nothrow) ";
                } else
                {
                    obj = "new ";
                }
                obj = ((StringBuilder) (obj1)).append(((String) (obj))).append(s).append(obj2[1]).append("(").toString();
            } else
            if (obj1 instanceof ByRef)
            {
                obj = (new StringBuilder()).append(((String) (obj))).append("&").toString();
            } else
            if (obj1 instanceof ByPtrPtr)
            {
                if (s1.length() > 0)
                {
                    obj2[0] = obj2[0].substring(0, obj2[0].length() - 1);
                }
                obj = (new StringBuilder()).append("rptr = NULL; ").append(obj2[0]).append("* rptrptr").append(obj2[1]).append(" = ").append(s1).toString();
            }
            if (methodinformation.bufferGetter)
            {
                out.println("    jobject rarg = NULL;");
                out.println("    char* rptr;");
            } else
            {
                out.println((new StringBuilder()).append("    ").append(getJNITypeName(methodinformation.returnType)).append(" rarg = NULL;").toString());
                out.println((new StringBuilder()).append("    ").append(obj2[0]).append(" rptr").append(obj2[1]).append(";").toString());
            }
            obj1 = obj;
            obj2 = s;
            if (com/googlecode/javacpp/FunctionPointer.isAssignableFrom(methodinformation.returnType))
            {
                out.println((new StringBuilder()).append("    rptr = new (std::nothrow) ").append(s).append(";").toString());
                obj1 = obj;
                obj2 = s;
            }
        } else
        if (methodinformation.returnType == java/lang/String)
        {
            out.println("    jstring rarg = NULL;");
            out.println("    const char* rptr;");
            if (obj1 instanceof ByRef)
            {
                obj1 = "std::string rstr(";
                obj2 = s;
            } else
            {
                obj1 = (new StringBuilder()).append(((String) (obj))).append("(const char*)").toString();
                obj2 = s;
            }
        } else
        {
            logger.log(Level.WARNING, (new StringBuilder()).append("Method \"").append(methodinformation.method).append("\" has unsupported return type \"").append(methodinformation.returnType.getCanonicalName()).append("\". Compilation will most likely fail.").toString());
            obj1 = obj;
            obj2 = s;
        }
          goto _L5
        if (true) goto _L4; else goto _L6
_L6:
    }

    public static transient AdapterInformation getAdapterInformation(boolean flag, String s, Annotation aannotation[])
    {
        Object obj;
        Object obj1;
        int i;
        int j;
        boolean flag1;
        Object obj2 = null;
        flag1 = false;
        obj1 = "";
        j = aannotation.length;
        i = 0;
        obj = s;
        s = obj2;
_L6:
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        Annotation annotation;
        boolean flag2;
        boolean flag3;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_751;
        }
        annotation = aannotation[i];
        AdapterInformation adapterinformation;
        int k;
        if (annotation instanceof Adapter)
        {
            obj5 = (Adapter)annotation;
        } else
        {
            obj5 = (Adapter)annotation.annotationType().getAnnotation(com/googlecode/javacpp/annotation/Adapter);
        }
        if (obj5 == null)
        {
            break MISSING_BLOCK_LABEL_648;
        }
        adapterinformation = new AdapterInformation();
        adapterinformation.name = ((Adapter) (obj5)).value();
        adapterinformation.argc = ((Adapter) (obj5)).argc();
        obj4 = adapterinformation;
        obj3 = obj1;
        flag2 = flag1;
        obj6 = obj;
        if (annotation == obj5) goto _L2; else goto _L1
_L1:
        obj3 = obj1;
        flag2 = flag1;
        obj4 = obj;
        obj6 = annotation.annotationType();
        obj3 = obj1;
        flag2 = flag1;
        obj4 = obj;
        flag3 = ((Class) (obj6)).isAnnotationPresent(com/googlecode/javacpp/annotation/Const);
        if (flag3)
        {
            flag1 = true;
        }
        obj3 = obj1;
        flag2 = flag1;
        obj4 = obj;
        obj5 = ((Class) (obj6)).getDeclaredMethod("value", new Class[0]).invoke(annotation, new Object[0]).toString();
        s = ((String) (obj));
        if (obj5 == null)
        {
            break MISSING_BLOCK_LABEL_231;
        }
        obj3 = obj1;
        flag2 = flag1;
        obj4 = obj;
        k = ((String) (obj5)).length();
        s = ((String) (obj));
        if (k > 0)
        {
            s = ((String) (obj5));
        }
_L3:
        obj3 = obj1;
        flag2 = flag1;
        obj4 = s;
        obj6 = (Cast)((Class) (obj6)).getAnnotation(com/googlecode/javacpp/annotation/Cast);
        obj = obj1;
        flag3 = flag1;
        obj5 = s;
        if (obj6 == null)
        {
            break MISSING_BLOCK_LABEL_448;
        }
        obj = obj1;
        flag3 = flag1;
        obj5 = s;
        obj3 = obj1;
        flag2 = flag1;
        obj4 = s;
        if (((String) (obj1)).length() != 0)
        {
            break MISSING_BLOCK_LABEL_448;
        }
        obj3 = obj1;
        flag2 = flag1;
        obj4 = s;
        obj = ((Cast) (obj6)).value()[0];
        obj1 = obj;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_369;
        }
        obj3 = obj;
        flag2 = flag1;
        obj4 = s;
        obj1 = (new StringBuilder()).append(((String) (obj))).append("< ").append(s).append(" >").toString();
        obj = obj1;
        flag3 = flag1;
        obj5 = s;
        obj3 = obj1;
        flag2 = flag1;
        obj4 = s;
        if (((Cast) (obj6)).value().length <= 1)
        {
            break MISSING_BLOCK_LABEL_448;
        }
        obj3 = obj1;
        flag2 = flag1;
        obj4 = s;
        obj = (new StringBuilder()).append(((String) (obj1))).append(((Cast) (obj6)).value()[1]).toString();
        obj5 = s;
        flag3 = flag1;
_L4:
        obj4 = adapterinformation;
        obj3 = obj;
        flag2 = flag3;
        obj6 = obj5;
        if (obj5 != null)
        {
            obj4 = adapterinformation;
            obj3 = obj;
            flag2 = flag3;
            obj6 = obj5;
            if (((String) (obj5)).length() > 0)
            {
                adapterinformation.name = (new StringBuilder()).append(adapterinformation.name).append("< ").append(((String) (obj5))).append(" >").toString();
                obj6 = obj5;
                flag2 = flag3;
                obj3 = obj;
                obj4 = adapterinformation;
            }
        }
_L2:
        i++;
        s = ((String) (obj4));
        obj1 = obj3;
        flag1 = flag2;
        obj = obj6;
        continue; /* Loop/switch isn't completed */
        s;
        s = null;
          goto _L3
        s;
        logger.log(Level.WARNING, (new StringBuilder()).append("Could not invoke the value() method on annotation \"").append(annotation).append("\".").toString(), s);
        obj = obj3;
        flag3 = flag2;
        obj5 = obj4;
          goto _L4
        if (annotation instanceof Const)
        {
            flag2 = true;
            obj4 = s;
            obj3 = obj1;
            obj6 = obj;
        } else
        {
            obj4 = s;
            obj3 = obj1;
            flag2 = flag1;
            obj6 = obj;
            if (annotation instanceof Cast)
            {
                Cast cast = (Cast)annotation;
                obj4 = s;
                obj3 = obj1;
                flag2 = flag1;
                obj6 = obj;
                if (cast.value().length > 1)
                {
                    obj3 = cast.value()[1];
                    obj4 = s;
                    flag2 = flag1;
                    obj6 = obj;
                }
            }
        }
          goto _L2
        if (s != null)
        {
            s.cast = ((String) (obj1));
            s.constant = flag1;
        }
        aannotation = s;
        if (flag)
        {
            aannotation = s;
            if (flag1)
            {
                aannotation = null;
            }
        }
        return aannotation;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static String[] getAnnotatedCPPTypeName(Annotation aannotation[], Class class1)
    {
        String as[] = getCastedCPPTypeName(aannotation, class1);
        class1 = as[0];
        String s = as[1];
        boolean flag1 = false;
        int j = aannotation.length;
        int i = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i < j)
                {
                    Annotation annotation = aannotation[i];
                    if ((!(annotation instanceof Cast) || ((Cast)annotation).value()[0].length() <= 0) && !(annotation instanceof Const))
                    {
                        break label0;
                    }
                    flag = true;
                }
                Annotation annotation1 = getBy(aannotation);
                if (annotation1 instanceof ByVal)
                {
                    aannotation = getValueTypeName(as);
                } else
                if (annotation1 instanceof ByRef)
                {
                    aannotation = (new StringBuilder()).append(getValueTypeName(as)).append("&").toString();
                } else
                if ((annotation1 instanceof ByPtrPtr) && !flag)
                {
                    aannotation = (new StringBuilder()).append(class1).append("*").toString();
                } else
                {
                    aannotation = class1;
                    if (annotation1 instanceof ByPtrRef)
                    {
                        aannotation = (new StringBuilder()).append(class1).append("&").toString();
                    }
                }
                as[0] = aannotation;
                as[1] = s;
                return as;
            }
            i++;
        } while (true);
    }

    public static transient Annotation getBehavior(Annotation aannotation[])
    {
        Annotation annotation = null;
        int j = aannotation.length;
        int i = 0;
        while (i < j) 
        {
label0:
            {
                Annotation annotation2 = aannotation[i];
                Annotation annotation1;
                if (!(annotation2 instanceof Function) && !(annotation2 instanceof Allocator) && !(annotation2 instanceof ArrayAllocator) && !(annotation2 instanceof ValueSetter) && !(annotation2 instanceof ValueGetter) && !(annotation2 instanceof MemberGetter))
                {
                    annotation1 = annotation;
                    if (!(annotation2 instanceof MemberSetter))
                    {
                        break label0;
                    }
                }
                if (annotation != null)
                {
                    logger.log(Level.WARNING, (new StringBuilder()).append("Behavior annotation \"").append(annotation).append("\" already found. Ignoring superfluous annotation \"").append(annotation2).append("\".").toString());
                    annotation1 = annotation;
                } else
                {
                    annotation1 = annotation2;
                }
            }
            i++;
            annotation = annotation1;
        }
        return annotation;
    }

    public static transient Annotation getBy(Annotation aannotation[])
    {
        Annotation annotation = null;
        int j = aannotation.length;
        int i = 0;
        while (i < j) 
        {
label0:
            {
                Annotation annotation2 = aannotation[i];
                Annotation annotation1;
                if (!(annotation2 instanceof ByPtr) && !(annotation2 instanceof ByPtrPtr) && !(annotation2 instanceof ByPtrRef) && !(annotation2 instanceof ByRef))
                {
                    annotation1 = annotation;
                    if (!(annotation2 instanceof ByVal))
                    {
                        break label0;
                    }
                }
                if (annotation != null)
                {
                    logger.log(Level.WARNING, (new StringBuilder()).append("\"By\" annotation \"").append(annotation).append("\" already found. Ignoring superfluous annotation \"").append(annotation2).append("\".").toString());
                    annotation1 = annotation;
                } else
                {
                    annotation1 = annotation2;
                }
            }
            i++;
            annotation = annotation1;
        }
        return annotation;
    }

    public static String getCPPScopeName(MethodInformation methodinformation)
    {
        Object obj = getCPPScopeName(methodinformation.cls);
        Object obj1 = (Namespace)methodinformation.method.getAnnotation(com/googlecode/javacpp/annotation/Namespace);
        String s;
        if (obj1 == null)
        {
            s = "";
        } else
        {
            s = ((Namespace) (obj1)).value();
        }
        if (obj1 != null && ((Namespace) (obj1)).value().length() == 0 || s.startsWith("::"))
        {
            obj = "";
        }
        obj1 = obj;
        if (((String) (obj)).length() > 0)
        {
            obj1 = obj;
            if (!((String) (obj)).endsWith("::"))
            {
                obj1 = (new StringBuilder()).append(((String) (obj))).append("::").toString();
            }
        }
        obj1 = (new StringBuilder()).append(((String) (obj1))).append(s).toString();
        obj = obj1;
        if (s.length() > 0)
        {
            obj = obj1;
            if (!s.endsWith("::"))
            {
                obj = (new StringBuilder()).append(((String) (obj1))).append("::").toString();
            }
        }
        return (new StringBuilder()).append(((String) (obj))).append(methodinformation.memberName[0]).toString();
    }

    public static String getCPPScopeName(Class class1)
    {
        String s = "";
        Class class2 = class1;
        do
        {
label0:
            {
label1:
                {
                    Object obj = s;
                    if (class2 == null)
                    {
                        break label1;
                    }
                    Namespace namespace = (Namespace)class2.getAnnotation(com/googlecode/javacpp/annotation/Namespace);
                    if (namespace == null)
                    {
                        class1 = "";
                    } else
                    {
                        class1 = namespace.value();
                    }
                    obj = class1;
                    if (com/googlecode/javacpp/Pointer.isAssignableFrom(class2))
                    {
                        obj = class1;
                        if (class2 != com/googlecode/javacpp/Pointer)
                        {
                            obj = (Name)class2.getAnnotation(com/googlecode/javacpp/annotation/Name);
                            Object obj1;
                            if (obj == null)
                            {
                                obj = class2.getName();
                                int j = ((String) (obj)).lastIndexOf("$");
                                int i = j;
                                if (j < 0)
                                {
                                    i = ((String) (obj)).lastIndexOf(".");
                                }
                                obj = ((String) (obj)).substring(i + 1);
                            } else
                            {
                                obj = ((Name) (obj)).value()[0];
                            }
                            obj1 = class1;
                            if (class1.length() > 0)
                            {
                                obj1 = class1;
                                if (!class1.endsWith("::"))
                                {
                                    obj1 = (new StringBuilder()).append(class1).append("::").toString();
                                }
                            }
                            obj = (new StringBuilder()).append(((String) (obj1))).append(((String) (obj))).toString();
                        }
                    }
                    class1 = ((Class) (obj));
                    if (s.length() > 0)
                    {
                        class1 = ((Class) (obj));
                        if (!((String) (obj)).endsWith("::"))
                        {
                            class1 = (new StringBuilder()).append(((String) (obj))).append("::").toString();
                        }
                    }
                    s = (new StringBuilder()).append(class1).append(s).toString();
                    if (namespace != null)
                    {
                        obj = s;
                        if (namespace.value().length() == 0)
                        {
                            break label1;
                        }
                    }
                    if (!class1.startsWith("::"))
                    {
                        break label0;
                    }
                    obj = s;
                }
                return ((String) (obj));
            }
            class2 = class2.getDeclaringClass();
        } while (true);
    }

    public static String[] getCPPTypeName(Class class1)
    {
        Object obj;
        Object obj1;
        obj = "";
        obj1 = "";
        if (class1 != java/nio/Buffer && class1 != com/googlecode/javacpp/Pointer) goto _L2; else goto _L1
_L1:
        obj = "void*";
_L4:
        return (new String[] {
            obj, obj1
        });
_L2:
        if (class1 == [B || class1 == java/nio/ByteBuffer || class1 == com/googlecode/javacpp/BytePointer)
        {
            obj = "signed char*";
        } else
        if (class1 == [S || class1 == java/nio/ShortBuffer || class1 == com/googlecode/javacpp/ShortPointer)
        {
            obj = "short*";
        } else
        if (class1 == [I || class1 == java/nio/IntBuffer || class1 == com/googlecode/javacpp/IntPointer)
        {
            obj = "int*";
        } else
        if (class1 == [J || class1 == java/nio/LongBuffer || class1 == com/googlecode/javacpp/LongPointer)
        {
            obj = "jlong*";
        } else
        if (class1 == [F || class1 == java/nio/FloatBuffer || class1 == com/googlecode/javacpp/FloatPointer)
        {
            obj = "float*";
        } else
        if (class1 == [D || class1 == java/nio/DoubleBuffer || class1 == com/googlecode/javacpp/DoublePointer)
        {
            obj = "double*";
        } else
        if (class1 == [C || class1 == java/nio/CharBuffer || class1 == com/googlecode/javacpp/CharPointer)
        {
            obj = "unsigned short*";
        } else
        if (class1 == [Z)
        {
            obj = "unsigned char*";
        } else
        if (class1 == com/googlecode/javacpp/PointerPointer)
        {
            obj = "void**";
        } else
        if (class1 == java/lang/String)
        {
            obj = "const char*";
        } else
        if (class1 == Byte.TYPE)
        {
            obj = "signed char";
        } else
        if (class1 == Long.TYPE)
        {
            obj = "jlong";
        } else
        if (class1 == Character.TYPE)
        {
            obj = "unsigned short";
        } else
        if (class1 == Boolean.TYPE)
        {
            obj = "unsigned char";
        } else
        if (class1.isPrimitive())
        {
            obj = class1.getName();
        } else
        if (com/googlecode/javacpp/FunctionPointer.isAssignableFrom(class1))
        {
            Method method = getFunctionMethod(class1, null);
            if (method != null)
            {
                obj = (Convention)class1.getAnnotation(com/googlecode/javacpp/annotation/Convention);
                Object obj2;
                Class aclass[];
                Annotation aannotation[][];
                Object obj3;
                Class class2;
                String as[];
                int i;
                if (obj == null)
                {
                    obj1 = "";
                } else
                {
                    obj1 = (new StringBuilder()).append(((Convention) (obj)).value()).append(" ").toString();
                }
                obj3 = (Namespace)class1.getAnnotation(com/googlecode/javacpp/annotation/Namespace);
                if (obj3 == null)
                {
                    obj = "";
                } else
                {
                    obj = ((Namespace) (obj3)).value();
                }
                obj2 = obj;
                if (((String) (obj)).length() > 0)
                {
                    obj2 = obj;
                    if (!((String) (obj)).endsWith("::"))
                    {
                        obj2 = (new StringBuilder()).append(((String) (obj))).append("::").toString();
                    }
                }
                class2 = method.getReturnType();
                aclass = method.getParameterTypes();
                obj = method.getAnnotations();
                aannotation = method.getParameterAnnotations();
                as = getAnnotatedCPPTypeName(((Annotation []) (obj)), class2);
                obj = getAdapterInformation(false, getValueTypeName(as), ((Annotation []) (obj)));
                if (obj != null && ((AdapterInformation) (obj)).cast.length() > 0)
                {
                    obj = ((AdapterInformation) (obj)).cast;
                } else
                {
                    obj = (new StringBuilder()).append(as[0]).append(as[1]).toString();
                }
                obj2 = (new StringBuilder()).append(((String) (obj))).append(" (").append(((String) (obj1))).append(((String) (obj2))).append("*").toString();
                obj1 = ")(";
                if (obj3 != null && !com/googlecode/javacpp/Pointer.isAssignableFrom(aclass[0]))
                {
                    logger.log(Level.WARNING, (new StringBuilder()).append("First parameter of caller method call() or apply() for member function pointer ").append(class1.getCanonicalName()).append(" is not a Pointer. Compilation will most likely fail.").toString());
                }
                if (obj3 == null)
                {
                    i = 0;
                } else
                {
                    i = 1;
                }
                while (i < aclass.length) 
                {
                    obj = getAnnotatedCPPTypeName(aannotation[i], aclass[i]);
                    obj3 = getAdapterInformation(false, getValueTypeName(((String []) (obj))), aannotation[i]);
                    if (obj3 != null && ((AdapterInformation) (obj3)).cast.length() > 0)
                    {
                        obj = (new StringBuilder()).append(((String) (obj1))).append(((AdapterInformation) (obj3)).cast).append(" arg").append(i).toString();
                    } else
                    {
                        obj = (new StringBuilder()).append(((String) (obj1))).append(obj[0]).append(" arg").append(i).append(obj[1]).toString();
                    }
                    obj1 = obj;
                    if (i < aclass.length - 1)
                    {
                        obj1 = (new StringBuilder()).append(((String) (obj))).append(", ").toString();
                    }
                    i++;
                }
                String s1 = (new StringBuilder()).append(((String) (obj1))).append(")").toString();
                obj = obj2;
                obj1 = s1;
                if (class1.isAnnotationPresent(com/googlecode/javacpp/annotation/Const))
                {
                    obj1 = (new StringBuilder()).append(s1).append(" const").toString();
                    obj = obj2;
                }
            }
        } else
        {
            String s = getCPPScopeName(class1);
            if (s.length() > 0)
            {
                obj = (new StringBuilder()).append(s).append("*").toString();
            } else
            {
                logger.log(Level.WARNING, (new StringBuilder()).append("The class ").append(class1.getCanonicalName()).append(" does not map to any C++ type. Compilation will most likely fail.").toString());
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static String getCast(Annotation aannotation[], Class class1)
    {
        Object obj1 = null;
        int j = aannotation.length;
        int i = 0;
        do
        {
label0:
            {
                Object obj = obj1;
                if (i < j)
                {
                    obj = aannotation[i];
                    if ((!(obj instanceof Cast) || ((Cast)obj).value()[0].length() <= 0) && !(obj instanceof Const))
                    {
                        break label0;
                    }
                    obj = getCastedCPPTypeName(aannotation, class1);
                }
                if (obj != null && obj.length > 0)
                {
                    return (new StringBuilder()).append("(").append(obj[0]).append(obj[1]).append(")").toString();
                } else
                {
                    return "";
                }
            }
            i++;
        } while (true);
    }

    public static String[] getCastedCPPTypeName(Annotation aannotation[], Class class1)
    {
        String as[];
        int j;
        int k;
        boolean flag;
        int l;
        as = null;
        j = 0;
        flag = false;
        l = aannotation.length;
        k = 0;
_L2:
        Object obj;
        Object obj1;
        int i;
        boolean flag1;
        if (k >= l)
        {
            break MISSING_BLOCK_LABEL_376;
        }
        obj1 = aannotation[k];
        if (!(obj1 instanceof Cast))
        {
            break; /* Loop/switch isn't completed */
        }
        if (as != null)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        obj1 = ((Cast)obj1).value()[0];
        as = "";
        j = ((String) (obj1)).indexOf(')');
        obj = obj1;
        if (j > 0)
        {
            as = ((String) (obj1)).substring(j).trim();
            obj = ((String) (obj1)).substring(0, j).trim();
        }
        if (((String) (obj)).length() > 0)
        {
            obj1 = new String[2];
            obj1[0] = obj;
            obj1[1] = as;
            obj = obj1;
            flag1 = flag;
        } else
        {
            obj = null;
            flag1 = flag;
        }
_L3:
        k++;
        flag = flag1;
        as = ((String []) (obj));
        j = i;
        if (true) goto _L2; else goto _L1
_L1:
label0:
        {
            if (!(obj1 instanceof Const))
            {
                break label0;
            }
            if (as != null)
            {
                j = 1;
            } else
            {
                j = 0;
            }
            flag1 = flag;
            obj = as;
            i = j;
            if (j == 0)
            {
                as = getCPPTypeName(class1);
                if (((Const)obj1).value())
                {
                    as[0] = (new StringBuilder()).append(getValueTypeName(as)).append(" const *").toString();
                } else
                {
                    as[0] = (new StringBuilder()).append("const ").append(as[0]).toString();
                }
                flag1 = flag;
                obj = as;
                i = j;
                if (getBy(aannotation) instanceof ByPtrPtr)
                {
                    as[0] = (new StringBuilder()).append(as[0]).append("*").toString();
                    flag1 = flag;
                    obj = as;
                    i = j;
                }
            }
        }
          goto _L3
        if (obj1 instanceof Adapter) goto _L5; else goto _L4
_L4:
        flag1 = flag;
        obj = as;
        i = j;
        if (!((Annotation) (obj1)).annotationType().isAnnotationPresent(com/googlecode/javacpp/annotation/Adapter)) goto _L3; else goto _L5
_L5:
        flag1 = true;
        obj = as;
        i = j;
          goto _L3
        if (j != 0 && !flag)
        {
            logger.log(Level.WARNING, "Without \"Adapter\", \"Cast\" and \"Const\" annotations are mutually exclusive.");
        }
        aannotation = as;
        if (as == null)
        {
            aannotation = getCPPTypeName(class1);
        }
        return aannotation;
    }

    private String getFunctionClassName(Class class1)
    {
        Name name = (Name)class1.getAnnotation(com/googlecode/javacpp/annotation/Name);
        if (name != null)
        {
            return name.value()[0];
        } else
        {
            return (new StringBuilder()).append("JavaCPP_").append(mangle(class1.getName())).toString();
        }
    }

    private static Method getFunctionMethod(Class class1, boolean aflag[])
    {
        if (com/googlecode/javacpp/FunctionPointer.isAssignableFrom(class1)) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((Method) (obj));
_L2:
        Method amethod[] = class1.getDeclaredMethods();
        class1 = null;
        int i = 0;
        do
        {
            obj = class1;
            if (i >= amethod.length)
            {
                continue;
            }
            obj = amethod[i].getName();
            int j = amethod[i].getModifiers();
            Class aclass[] = amethod[i].getParameterTypes();
            Class class2 = amethod[i].getReturnType();
            if (!Modifier.isStatic(j))
            {
                if (aflag != null && ((String) (obj)).startsWith("allocate") && Modifier.isNative(j) && class2 == Void.TYPE && aclass.length == 0)
                {
                    aflag[i] = true;
                } else
                if (((String) (obj)).startsWith("call") || ((String) (obj)).startsWith("apply"))
                {
                    class1 = amethod[i];
                }
            }
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static String getJNITypeName(Class class1)
    {
        if (class1 == Byte.TYPE)
        {
            return "jbyte";
        }
        if (class1 == Short.TYPE)
        {
            return "jshort";
        }
        if (class1 == Integer.TYPE)
        {
            return "jint";
        }
        if (class1 == Long.TYPE)
        {
            return "jlong";
        }
        if (class1 == Float.TYPE)
        {
            return "jfloat";
        }
        if (class1 == Double.TYPE)
        {
            return "jdouble";
        }
        if (class1 == Character.TYPE)
        {
            return "jchar";
        }
        if (class1 == Boolean.TYPE)
        {
            return "jboolean";
        }
        if (class1 == [B)
        {
            return "jbyteArray";
        }
        if (class1 == [S)
        {
            return "jshortArray";
        }
        if (class1 == [I)
        {
            return "jintArray";
        }
        if (class1 == [J)
        {
            return "jlongArray";
        }
        if (class1 == [F)
        {
            return "jfloatArray";
        }
        if (class1 == [D)
        {
            return "jdoubleArray";
        }
        if (class1 == [C)
        {
            return "jcharArray";
        }
        if (class1 == [Z)
        {
            return "jbooleanArray";
        }
        if (class1.isArray())
        {
            return "jobjectArray";
        }
        if (class1 == java/lang/String)
        {
            return "jstring";
        }
        if (class1 == java/lang/Class)
        {
            return "jclass";
        }
        if (class1 == Void.TYPE)
        {
            return "void";
        } else
        {
            return "jobject";
        }
    }

    public static MethodInformation getMethodInformation(Method method)
    {
        if (Modifier.isNative(method.getModifiers())) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L10:
        return ((MethodInformation) (obj));
_L2:
        Method method1;
        Method method2;
        Class class1;
        MethodInformation methodinformation;
        Name name;
        Class aclass[];
        String s;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        boolean flag5;
        boolean flag6;
        boolean flag7;
        boolean flag8;
        boolean flag9;
        int i1;
        int j1;
        boolean flag10;
        boolean flag12;
        boolean flag13;
        boolean flag15;
        methodinformation = new MethodInformation();
        methodinformation.cls = method.getDeclaringClass();
        methodinformation.method = method;
        methodinformation.annotations = method.getAnnotations();
        methodinformation.modifiers = method.getModifiers();
        methodinformation.returnType = method.getReturnType();
        methodinformation.name = method.getName();
        name = (Name)method.getAnnotation(com/googlecode/javacpp/annotation/Name);
        int i;
        if (name != null)
        {
            obj = name.value();
        } else
        {
            obj = new String[1];
            obj[0] = methodinformation.name;
        }
        methodinformation.memberName = ((String []) (obj));
        obj = (Index)method.getAnnotation(com/googlecode/javacpp/annotation/Index);
        if (obj != null)
        {
            i = ((Index) (obj)).value();
        } else
        {
            i = 0;
        }
        methodinformation.dim = i;
        methodinformation.parameterTypes = method.getParameterTypes();
        methodinformation.parameterAnnotations = method.getParameterAnnotations();
        methodinformation.returnRaw = method.isAnnotationPresent(com/googlecode/javacpp/annotation/Raw);
        if (methodinformation.returnRaw)
        {
            flag13 = ((Raw)method.getAnnotation(com/googlecode/javacpp/annotation/Raw)).withEnv();
        } else
        {
            flag13 = false;
        }
        methodinformation.withEnv = flag13;
        methodinformation.parameterRaw = new boolean[methodinformation.parameterAnnotations.length];
        for (i = 0; i < methodinformation.parameterAnnotations.length; i++)
        {
            for (int j = 0; j < methodinformation.parameterAnnotations[i].length; j++)
            {
                if (methodinformation.parameterAnnotations[i][j] instanceof Raw)
                {
                    methodinformation.parameterRaw[i] = true;
                    flag13 = methodinformation.withEnv;
                    methodinformation.withEnv = ((Raw)methodinformation.parameterAnnotations[i][j]).withEnv() | flag13;
                }
            }

        }

        Method amethod[];
        int l;
        if (methodinformation.returnType != Void.TYPE || methodinformation.parameterTypes.length > 0 && methodinformation.parameterTypes[0].isArray() && methodinformation.parameterTypes[0].getComponentType().isPrimitive())
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if ((methodinformation.returnType == Void.TYPE || methodinformation.returnType == methodinformation.cls) && methodinformation.parameterTypes.length > 0)
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        if (!Modifier.isStatic(methodinformation.modifiers) && methodinformation.returnType == Void.TYPE)
        {
            flag4 = true;
        } else
        {
            flag4 = false;
        }
        if (flag4 && methodinformation.parameterTypes.length == 1 && (methodinformation.parameterTypes[0] == Integer.TYPE || methodinformation.parameterTypes[0] == Long.TYPE))
        {
            flag5 = true;
        } else
        {
            flag5 = false;
        }
        flag7 = false;
        flag6 = false;
        flag9 = false;
        flag8 = false;
        flag15 = false;
        method1 = null;
        amethod = methodinformation.cls.getDeclaredMethods();
        l = 0;
        if (l >= amethod.length)
        {
            break MISSING_BLOCK_LABEL_1289;
        }
        method2 = amethod[l];
        i = method2.getModifiers();
        class1 = method2.getReturnType();
        s = method2.getName();
        aclass = method2.getParameterTypes();
        i1 = ((flag9) ? 1 : 0);
        j1 = ((flag8) ? 1 : 0);
        flag13 = flag15;
        obj = method1;
        flag10 = flag7;
        flag12 = flag6;
        if (!method.equals(method2))
        {
            if (Modifier.isNative(i))
            {
                break; /* Loop/switch isn't completed */
            }
            flag12 = flag6;
            flag10 = flag7;
            obj = method1;
            flag13 = flag15;
            j1 = ((flag8) ? 1 : 0);
            i1 = ((flag9) ? 1 : 0);
        }
_L8:
        l++;
        flag9 = i1;
        flag8 = j1;
        flag15 = flag13;
        method1 = ((Method) (obj));
        flag7 = flag10;
        flag6 = flag12;
        if (true) goto _L4; else goto _L3
_L4:
        break MISSING_BLOCK_LABEL_533;
_L3:
        boolean flag;
        boolean flag1;
        boolean flag11;
        flag1 = false;
        flag = false;
        if (flag2 && "get".equals(methodinformation.name) && "put".equals(s))
        {
            flag1 = true;
        } else
        {
label0:
            {
                if (!flag3 || !"put".equals(methodinformation.name) || !"get".equals(s))
                {
                    break label0;
                }
                flag = true;
            }
        }
_L6:
        flag11 = true;
        for (i1 = 0; i1 < methodinformation.parameterTypes.length && i1 < aclass.length; i1++)
        {
            if (methodinformation.parameterTypes[i1] != aclass[i1])
            {
                flag11 = false;
            }
        }

        break MISSING_BLOCK_LABEL_858;
        i1 = ((flag9) ? 1 : 0);
        j1 = ((flag8) ? 1 : 0);
        flag13 = flag15;
        obj = method1;
        flag10 = flag7;
        flag12 = flag6;
        if (!s.equals(methodinformation.name))
        {
            continue; /* Loop/switch isn't completed */
        }
        methodinformation.overloaded = true;
        if (true) goto _L6; else goto _L5
_L5:
        i1 = ((flag9) ? 1 : 0);
        j1 = ((flag8) ? 1 : 0);
        flag13 = flag15;
        obj = method1;
        flag10 = flag7;
        flag12 = flag6;
        if (flag11)
        {
label1:
            {
                if (flag1 && methodinformation.parameterTypes.length > 0 && methodinformation.parameterTypes[0].isArray() && methodinformation.parameterTypes[0].getComponentType().isPrimitive())
                {
                    flag13 = true;
                } else
                {
                    flag13 = false;
                }
                if (flag && aclass.length > 0 && aclass[0].isArray() && aclass[0].getComponentType().isPrimitive())
                {
                    flag11 = true;
                } else
                {
                    flag11 = false;
                }
                if (!flag2)
                {
                    break label1;
                }
                j1 = aclass.length;
                if (flag13)
                {
                    i1 = 0;
                } else
                {
                    i1 = 1;
                }
                if (j1 - i1 != methodinformation.parameterTypes.length)
                {
                    break label1;
                }
                if (flag13)
                {
                    obj = methodinformation.parameterTypes[methodinformation.parameterTypes.length - 1];
                } else
                {
                    obj = methodinformation.returnType;
                }
                if (obj != aclass[aclass.length - 1] || class1 != Void.TYPE && class1 != methodinformation.cls)
                {
                    break label1;
                }
                obj = method2;
                flag10 = flag1;
                if (!flag1)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                i1 = ((flag) ? 1 : 0);
                j1 = ((flag8) ? 1 : 0);
                flag12 = flag6;
            }
        }
        continue; /* Loop/switch isn't completed */
        i1 = ((flag9) ? 1 : 0);
        j1 = ((flag8) ? 1 : 0);
        flag13 = flag15;
        obj = method1;
        flag10 = flag7;
        flag12 = flag6;
        if (flag3)
        {
            int k1 = methodinformation.parameterTypes.length;
            int k;
            if (flag11)
            {
                k = 0;
            } else
            {
                k = 1;
            }
            i1 = ((flag9) ? 1 : 0);
            j1 = ((flag8) ? 1 : 0);
            flag13 = flag15;
            obj = method1;
            flag10 = flag7;
            flag12 = flag6;
            if (k1 - k == aclass.length)
            {
                if (flag11)
                {
                    class1 = aclass[aclass.length - 1];
                }
                i1 = ((flag9) ? 1 : 0);
                j1 = ((flag8) ? 1 : 0);
                flag13 = flag15;
                obj = method1;
                flag10 = flag7;
                flag12 = flag6;
                if (class1 == methodinformation.parameterTypes[methodinformation.parameterTypes.length - 1])
                {
                    obj = method2;
                    flag12 = flag;
                    if (!flag)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    i1 = ((flag9) ? 1 : 0);
                    j1 = ((flag) ? 1 : 0);
                    flag13 = flag15;
                    flag10 = flag7;
                }
            }
        }
        if (true) goto _L8; else goto _L7
_L7:
        obj = getBehavior(methodinformation.annotations);
        boolean flag14;
        if (flag2 && (obj instanceof ValueGetter))
        {
            methodinformation.valueGetter = true;
            methodinformation.noReturnGetter = flag15;
        } else
        if (flag3 && (obj instanceof ValueSetter))
        {
            methodinformation.valueSetter = true;
        } else
        if (flag2 && (obj instanceof MemberGetter))
        {
            methodinformation.memberGetter = true;
            methodinformation.noReturnGetter = flag15;
        } else
        if (flag3 && (obj instanceof MemberSetter))
        {
            methodinformation.memberSetter = true;
        } else
        if (flag4 && (obj instanceof Allocator))
        {
            methodinformation.allocator = true;
        } else
        if (flag5 && (obj instanceof ArrayAllocator))
        {
            methodinformation.arrayAllocator = true;
            methodinformation.allocator = true;
        } else
        if (obj == null)
        {
            if (methodinformation.returnType == Void.TYPE && "deallocate".equals(methodinformation.name) && !Modifier.isStatic(methodinformation.modifiers) && methodinformation.parameterTypes.length == 2 && methodinformation.parameterTypes[0] == Long.TYPE && methodinformation.parameterTypes[1] == Long.TYPE)
            {
                methodinformation.deallocator = true;
            } else
            if (flag4 && "allocate".equals(methodinformation.name))
            {
                methodinformation.allocator = true;
            } else
            if (flag5 && "allocateArray".equals(methodinformation.name))
            {
                methodinformation.arrayAllocator = true;
                methodinformation.allocator = true;
            } else
            if (methodinformation.returnType.isAssignableFrom(java/nio/ByteBuffer) && "asDirectBuffer".equals(methodinformation.name) && !Modifier.isStatic(methodinformation.modifiers) && methodinformation.parameterTypes.length == 0)
            {
                methodinformation.bufferGetter = true;
            } else
            if (flag7)
            {
                methodinformation.valueGetter = true;
                methodinformation.noReturnGetter = flag15;
                methodinformation.pairedMethod = method1;
            } else
            if (flag6)
            {
                methodinformation.valueSetter = true;
                methodinformation.pairedMethod = method1;
            } else
            if (flag9)
            {
                methodinformation.memberGetter = true;
                methodinformation.noReturnGetter = flag15;
                methodinformation.pairedMethod = method1;
            } else
            if (flag8)
            {
                methodinformation.memberSetter = true;
                methodinformation.pairedMethod = method1;
            }
        } else
        {
            logger.log(Level.WARNING, (new StringBuilder()).append("Method \"").append(method).append("\" cannot behave like a \"").append(obj).append("\". No code will be generated.").toString());
            return null;
        }
        if (name == null && methodinformation.pairedMethod != null)
        {
            obj = (Name)methodinformation.pairedMethod.getAnnotation(com/googlecode/javacpp/annotation/Name);
            if (obj != null)
            {
                methodinformation.memberName = ((Name) (obj)).value();
            }
        }
        if (methodinformation.cls.isAnnotationPresent(com/googlecode/javacpp/annotation/NoOffset) || method.isAnnotationPresent(com/googlecode/javacpp/annotation/NoOffset) || method.isAnnotationPresent(com/googlecode/javacpp/annotation/Index))
        {
            flag14 = true;
        } else
        {
            flag14 = false;
        }
        methodinformation.noOffset = flag14;
        if (!methodinformation.noOffset && methodinformation.pairedMethod != null)
        {
            if (methodinformation.pairedMethod.isAnnotationPresent(com/googlecode/javacpp/annotation/NoOffset) || methodinformation.pairedMethod.isAnnotationPresent(com/googlecode/javacpp/annotation/Index))
            {
                flag14 = true;
            } else
            {
                flag14 = false;
            }
            methodinformation.noOffset = flag14;
        }
        if (methodinformation.parameterTypes.length == 0 || !methodinformation.parameterTypes[0].isArray())
        {
            if (methodinformation.valueGetter || methodinformation.memberGetter)
            {
                methodinformation.dim = methodinformation.parameterTypes.length;
            } else
            if (methodinformation.memberSetter || methodinformation.valueSetter)
            {
                methodinformation.dim = methodinformation.parameterTypes.length - 1;
            }
        }
        methodinformation.throwsException = null;
        obj = methodinformation;
        if (getNoException(methodinformation.cls, method)) goto _L10; else goto _L9
_L9:
        if ((getBy(methodinformation.annotations) instanceof ByVal) && !getNoException(methodinformation.returnType, method))
        {
            break; /* Loop/switch isn't completed */
        }
        obj = methodinformation;
        if (methodinformation.deallocator) goto _L10; else goto _L11
_L11:
        obj = methodinformation;
        if (methodinformation.valueGetter) goto _L10; else goto _L12
_L12:
        obj = methodinformation;
        if (methodinformation.valueSetter) goto _L10; else goto _L13
_L13:
        obj = methodinformation;
        if (methodinformation.memberGetter) goto _L10; else goto _L14
_L14:
        obj = methodinformation;
        if (methodinformation.memberSetter) goto _L10; else goto _L15
_L15:
        obj = methodinformation;
        if (methodinformation.bufferGetter) goto _L10; else goto _L16
_L16:
        method = method.getExceptionTypes();
        if (method.length > 0)
        {
            method = method[0];
        } else
        {
            method = java/lang/RuntimeException;
        }
        methodinformation.throwsException = method;
        return methodinformation;
    }

    public static boolean getNoException(Class class1, Method method)
    {
        boolean flag;
        if (baseClasses.contains(class1) || method.isAnnotationPresent(com/googlecode/javacpp/annotation/NoException))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        do
        {
label0:
            {
                boolean flag1 = flag;
                if (!flag)
                {
                    flag1 = flag;
                    if (class1 != null)
                    {
                        flag = class1.isAnnotationPresent(com/googlecode/javacpp/annotation/NoException);
                        if (!flag)
                        {
                            break label0;
                        }
                        flag1 = flag;
                    }
                }
                return flag1;
            }
            class1 = class1.getDeclaringClass();
        } while (true);
    }

    public static AdapterInformation getParameterAdapterInformation(boolean flag, MethodInformation methodinformation, int i)
    {
        if (!flag || methodinformation.parameterTypes[i] != java/lang/String && !methodinformation.valueSetter && !methodinformation.memberSetter) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((AdapterInformation) (obj));
_L2:
        Object obj1;
        String s;
label0:
        {
            obj1 = getParameterCast(methodinformation, i);
            obj = obj1;
            if (obj1 != null)
            {
                obj = obj1;
                if (((String) (obj1)).startsWith("("))
                {
                    obj = obj1;
                    if (((String) (obj1)).endsWith(")"))
                    {
                        obj = ((String) (obj1)).substring(1, ((String) (obj1)).length() - 1);
                    }
                }
            }
            if (obj != null)
            {
                obj1 = obj;
                if (((String) (obj)).length() != 0)
                {
                    break label0;
                }
            }
            obj1 = getCastedCPPTypeName(methodinformation.parameterAnnotations[i], methodinformation.parameterTypes[i])[0];
        }
        s = getValueTypeName(new String[] {
            obj1
        });
        obj1 = getAdapterInformation(flag, s, methodinformation.parameterAnnotations[i]);
        obj = obj1;
        if (obj1 != null) goto _L4; else goto _L3
_L3:
        obj = obj1;
        if (methodinformation.pairedMethod == null) goto _L4; else goto _L5
_L5:
        if (methodinformation.valueSetter)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = obj1;
        if (!methodinformation.memberSetter) goto _L4; else goto _L6
_L6:
        return getAdapterInformation(flag, s, methodinformation.pairedMethod.getAnnotations());
    }

    public static Annotation getParameterBy(MethodInformation methodinformation, int i)
    {
        Annotation annotation;
label0:
        {
            Annotation annotation1 = getBy(methodinformation.parameterAnnotations[i]);
            annotation = annotation1;
            if (annotation1 != null)
            {
                break label0;
            }
            annotation = annotation1;
            if (methodinformation.pairedMethod == null)
            {
                break label0;
            }
            if (!methodinformation.valueSetter)
            {
                annotation = annotation1;
                if (!methodinformation.memberSetter)
                {
                    break label0;
                }
            }
            annotation = getBy(methodinformation.pairedMethod.getAnnotations());
        }
        return annotation;
    }

    public static String getParameterCast(MethodInformation methodinformation, int i)
    {
        String s;
label0:
        {
            String s1 = getCast(methodinformation.parameterAnnotations[i], methodinformation.parameterTypes[i]);
            if (s1 != null)
            {
                s = s1;
                if (s1.length() != 0)
                {
                    break label0;
                }
            }
            s = s1;
            if (i != methodinformation.parameterTypes.length - 1)
            {
                break label0;
            }
            if (!methodinformation.valueSetter)
            {
                s = s1;
                if (!methodinformation.memberSetter)
                {
                    break label0;
                }
            }
            s = s1;
            if (methodinformation.pairedMethod != null)
            {
                s = getCast(methodinformation.pairedMethod.getAnnotations(), methodinformation.pairedMethod.getReturnType());
            }
        }
        return s;
    }

    public static String getSignature(Class class1)
    {
        if (class1 == Byte.TYPE)
        {
            return "B";
        }
        if (class1 == Short.TYPE)
        {
            return "S";
        }
        if (class1 == Integer.TYPE)
        {
            return "I";
        }
        if (class1 == Long.TYPE)
        {
            return "J";
        }
        if (class1 == Float.TYPE)
        {
            return "F";
        }
        if (class1 == Double.TYPE)
        {
            return "D";
        }
        if (class1 == Boolean.TYPE)
        {
            return "Z";
        }
        if (class1 == Character.TYPE)
        {
            return "C";
        }
        if (class1 == Void.TYPE)
        {
            return "V";
        }
        if (class1.isArray())
        {
            return class1.getName().replace(".", "/");
        } else
        {
            return (new StringBuilder()).append("L").append(class1.getName().replace(".", "/")).append(";").toString();
        }
    }

    public static transient String getSignature(Class aclass[])
    {
        StringBuilder stringbuilder = new StringBuilder(aclass.length * 2);
        for (int i = 0; i < aclass.length; i++)
        {
            stringbuilder.append(getSignature(aclass[i]));
        }

        return stringbuilder.toString();
    }

    public static transient String getValueTypeName(String as[])
    {
        String s = as[0];
        if (s.startsWith("const "))
        {
            as = s.substring(6, s.length() - 1);
        } else
        {
            as = s;
            if (s.length() != 0)
            {
                return s.substring(0, s.length() - 1);
            }
        }
        return as;
    }

    public static String mangle(String s)
    {
        StringBuilder stringbuilder;
        int i;
        stringbuilder = new StringBuilder(s.length());
        i = 0;
_L2:
        char c;
        if (i >= s.length())
        {
            break; /* Loop/switch isn't completed */
        }
        c = s.charAt(i);
        if (c >= '0' && c <= '9' || c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z')
        {
            stringbuilder.append(c);
        } else
        if (c == '_')
        {
            stringbuilder.append("_1");
        } else
        if (c == ';')
        {
            stringbuilder.append("_2");
        } else
        if (c == '[')
        {
            stringbuilder.append("_3");
        } else
        {
label0:
            {
                if (c != '.' && c != '/')
                {
                    break label0;
                }
                stringbuilder.append("_");
            }
        }
_L8:
        i++;
        if (true) goto _L2; else goto _L1
        String s1;
        s1 = Integer.toHexString(c);
        stringbuilder.append("_0");
        s1.length();
        JVM INSTR tableswitch 1 3: default 200
    //                   1 209
    //                   2 217
    //                   3 225;
           goto _L3 _L4 _L5 _L6
_L3:
        stringbuilder.append(s1);
        continue; /* Loop/switch isn't completed */
_L4:
        stringbuilder.append("0");
_L5:
        stringbuilder.append("0");
_L6:
        stringbuilder.append("0");
        if (true) goto _L3; else goto _L1
_L1:
        return stringbuilder.toString();
        if (true) goto _L8; else goto _L7
_L7:
    }

    public boolean checkPlatform(Platform platform)
    {
        if (platform != null) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        String as[][];
        String s = properties.getProperty("platform.name");
        as = new String[2][];
        as[0] = platform.value();
        as[1] = platform.not();
        platform = new boolean[2];
        platform;
        platform[0] = 0;
        platform[1] = 0;
        int i = 0;
        do
        {
            if (i >= as.length)
            {
                continue; /* Loop/switch isn't completed */
            }
            String as1[] = as[i];
            int k = as1.length;
            int j = 0;
            do
            {
label0:
                {
                    if (j < k)
                    {
                        if (!s.startsWith(as1[j]))
                        {
                            break label0;
                        }
                        platform[i] = 1;
                    }
                    i++;
                }
                if (true)
                {
                    break;
                }
                j++;
            } while (true);
        } while (true);
        if ((as[0].length == 0 || platform[0] != 0) && (as[1].length == 0 || platform[1] == 0)) goto _L1; else goto _L3
_L3:
        return false;
    }

    public boolean checkPlatform(Class class1)
    {
        Properties properties1 = (Properties)class1.getAnnotation(com/googlecode/javacpp/annotation/Properties);
        if (properties1 != null)
        {
            class1 = properties1.inherit();
            if (class1 != null)
            {
                int k = class1.length;
                for (int i = 0; i < k; i++)
                {
                    if (checkPlatform(class1[i]))
                    {
                        return true;
                    }
                }

            }
            class1 = properties1.value();
            if (class1 != null)
            {
                int l = class1.length;
                for (int j = 0; j < l; j++)
                {
                    if (checkPlatform(class1[j]))
                    {
                        return true;
                    }
                }

            }
        } else
        if (checkPlatform((Platform)class1.getAnnotation(com/googlecode/javacpp/annotation/Platform)))
        {
            return true;
        }
        return false;
    }

    public void close()
    {
        if (out != null)
        {
            out.close();
        }
        if (out2 != null)
        {
            out2.close();
        }
    }

    public transient boolean generate(String s, String s1, String s2, Class aclass[])
        throws FileNotFoundException
    {
        boolean flag = false;
        out = new PrintWriter(new Writer() {

            final Generator this$0;

            public void close()
            {
            }

            public void flush()
            {
            }

            public void write(char ac[], int i, int j)
            {
            }

            
            {
                this$0 = Generator.this;
                super();
            }
        });
        out2 = null;
        functionDefinitions = new LinkedListRegister();
        functionPointers = new LinkedListRegister();
        deallocators = new LinkedListRegister();
        arrayDeallocators = new LinkedListRegister();
        jclasses = new LinkedListRegister();
        jclassesInit = new LinkedListRegister();
        members = new HashMap();
        mayThrowExceptions = false;
        usesAdapters = false;
        if (doClasses(true, true, s2, aclass))
        {
            out = new PrintWriter(s);
            if (s1 != null)
            {
                out2 = new PrintWriter(s1);
            }
            flag = doClasses(mayThrowExceptions, usesAdapters, s2, aclass);
        }
        return flag;
    }

}
