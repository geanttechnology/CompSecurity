// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package dagger.internal.codegen;

import java.util.List;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.ArrayType;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.ErrorType;
import javax.lang.model.type.PrimitiveType;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVariable;
import javax.lang.model.util.SimpleTypeVisitor6;

// Referenced classes of package dagger.internal.codegen:
//            Util

static final class eVisitor6 extends SimpleTypeVisitor6
{

    final char val$innerClassSeparator;
    final StringBuilder val$result;
    final TypeMirror val$type;

    protected volatile Object defaultAction(TypeMirror typemirror, Object obj)
    {
        return defaultAction(typemirror, (Void)obj);
    }

    protected Void defaultAction(TypeMirror typemirror, Void void1)
    {
        throw new UnsupportedOperationException((new StringBuilder()).append("Unexpected TypeKind ").append(typemirror.getKind()).append(" for ").append(typemirror).toString());
    }

    public volatile Object visitArray(ArrayType arraytype, Object obj)
    {
        return visitArray(arraytype, (Void)obj);
    }

    public Void visitArray(ArrayType arraytype, Void void1)
    {
        void1 = arraytype.getComponentType();
        if (void1 instanceof PrimitiveType)
        {
            val$result.append(void1.toString());
        } else
        {
            Util.typeToString(arraytype.getComponentType(), val$result, val$innerClassSeparator);
        }
        val$result.append("[]");
        return null;
    }

    public volatile Object visitDeclared(DeclaredType declaredtype, Object obj)
    {
        return visitDeclared(declaredtype, (Void)obj);
    }

    public Void visitDeclared(DeclaredType declaredtype, Void void1)
    {
        void1 = (TypeElement)declaredtype.asElement();
        Util.rawTypeToString(val$result, void1, val$innerClassSeparator);
        declaredtype = declaredtype.getTypeArguments();
        if (!declaredtype.isEmpty())
        {
            val$result.append("<");
            for (int i = 0; i < declaredtype.size(); i++)
            {
                if (i != 0)
                {
                    val$result.append(", ");
                }
                Util.typeToString((TypeMirror)declaredtype.get(i), val$result, val$innerClassSeparator);
            }

            val$result.append(">");
        }
        return null;
    }

    public volatile Object visitError(ErrorType errortype, Object obj)
    {
        return visitError(errortype, (Void)obj);
    }

    public Void visitError(ErrorType errortype, Void void1)
    {
        if ("<any>".equals(errortype.toString()))
        {
            throw new deGenerationIncompleteException("Type reported as <any> is likely a not-yet generated parameterized type.");
        } else
        {
            val$result.append(errortype.toString());
            return null;
        }
    }

    public volatile Object visitPrimitive(PrimitiveType primitivetype, Object obj)
    {
        return visitPrimitive(primitivetype, (Void)obj);
    }

    public Void visitPrimitive(PrimitiveType primitivetype, Void void1)
    {
        val$result.append(Util.access$000((PrimitiveType)val$type).getName());
        return null;
    }

    public volatile Object visitTypeVariable(TypeVariable typevariable, Object obj)
    {
        return visitTypeVariable(typevariable, (Void)obj);
    }

    public Void visitTypeVariable(TypeVariable typevariable, Void void1)
    {
        val$result.append(typevariable.asElement().getSimpleName());
        return null;
    }

    r(StringBuilder stringbuilder, char c, TypeMirror typemirror)
    {
        val$result = stringbuilder;
        val$innerClassSeparator = c;
        val$type = typemirror;
        super();
    }
}
