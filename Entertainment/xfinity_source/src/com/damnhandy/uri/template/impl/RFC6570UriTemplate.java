// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.damnhandy.uri.template.impl;

import com.damnhandy.uri.template.UriTemplate;
import com.damnhandy.uri.template.UriUtil;
import com.damnhandy.uri.template.VarExploder;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.damnhandy.uri.template.impl:
//            VariableExpansionException, Operator, Modifier, VarSpec, 
//            ExpressionParseException, VarExploderFactory

public final class RFC6570UriTemplate extends UriTemplate
{

    private static final Pattern URI_TEMPLATE_REGEX = Pattern.compile("\\{[^{}]+\\}");
    static final Pattern VARNAME_REGEX = Pattern.compile("([\\w\\_\\.]|%[A-Fa-f0-9]{2})+");

    public RFC6570UriTemplate(String s)
    {
        setTemplate(s);
    }

    private List arrayToList(Object obj)
    {
        ArrayList arraylist = new ArrayList();
        int j = Array.getLength(obj);
        for (int i = 0; i < j; i++)
        {
            Object obj1 = Array.get(obj, i);
            if (obj1.getClass().isArray())
            {
                throw new VariableExpansionException("Multi-dimenesional arrays are not supported.");
            }
            arraylist.add(obj1);
        }

        return arraylist;
    }

    private String buildVarSpecs(String s)
    {
        Object obj = Operator.NUL;
        Object obj1 = s.substring(0, 1);
        String s1 = s;
        if (containsOperator(((String) (obj1))))
        {
            obj = Operator.fromOpCode(((String) (obj1)));
            s1 = s.substring(1, s.length());
        }
        String as[] = s1.split(",");
        obj1 = new ArrayList();
        int j = as.length;
        int i = 0;
        while (i < j) 
        {
            Object obj2 = as[i];
            int k = ((String) (obj2)).indexOf(Modifier.PREFIX.getValue());
            if (k > 0)
            {
                s = ((String) (obj2)).split(Modifier.PREFIX.getValue());
                try
                {
                    validateVarname(s[0]);
                    obj2 = Integer.valueOf(((String) (obj2)).substring(k + 1));
                    ((List) (obj1)).add(new VarSpec(s[0], Modifier.PREFIX, ((Integer) (obj2))));
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    throw new ExpressionParseException((new StringBuilder()).append("The prefix value for ").append(s[0]).append(" was not a number").toString(), ((Throwable) (obj)));
                }
            } else
            if (((String) (obj2)).lastIndexOf(Modifier.EXPLODE.getValue()) > 0)
            {
                validateVarname(((String) (obj2)).substring(0, ((String) (obj2)).length() - 1));
                ((List) (obj1)).add(new VarSpec(((String) (obj2)), Modifier.EXPLODE));
            } else
            {
                validateVarname(((String) (obj2)));
                ((List) (obj1)).add(new VarSpec(((String) (obj2)), Modifier.NONE));
            }
            i++;
        }
        return findExpressions(((Operator) (obj)), ((List) (obj1)));
    }

    private void checkValue(Object obj)
    {
        if ((obj instanceof Collection) || (obj instanceof Map) || obj.getClass().isArray())
        {
            throw new VariableExpansionException("Nested data structures are not supported.");
        } else
        {
            return;
        }
    }

    private String expandCollection(Operator operator, VarSpec varspec, Collection collection)
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = collection.iterator();
        collection = operator.getSeparator();
        if (varspec.getModifier() != Modifier.EXPLODE)
        {
            collection = operator.getListSeparator();
        }
        Object obj;
        for (; iterator.hasNext(); arraylist.add(expandStringValue(operator, varspec, obj.toString(), VarSpec.VarFormat.ARRAY)))
        {
            obj = iterator.next();
            checkValue(obj);
        }

        if (varspec.getModifier() != Modifier.EXPLODE && operator.useVarNameWhenExploded())
        {
            collection = joinParts(collection, arraylist);
            if (operator == Operator.QUERY && collection == null)
            {
                return (new StringBuilder()).append(varspec.getVariableName()).append("=").toString();
            } else
            {
                return (new StringBuilder()).append(varspec.getVariableName()).append("=").append(collection).toString();
            }
        } else
        {
            return joinParts(collection, arraylist);
        }
    }

    private String expandMap(Operator operator, VarSpec varspec, Map map)
    {
        ArrayList arraylist = new ArrayList();
        String s = "=";
        if (varspec.getModifier() != Modifier.EXPLODE)
        {
            s = ",";
        }
        String s1 = operator.getSeparator();
        if (varspec.getModifier() != Modifier.EXPLODE)
        {
            s1 = operator.getListSeparator();
        }
        java.util.Map.Entry entry;
        String s2;
        for (map = map.entrySet().iterator(); map.hasNext(); arraylist.add((new StringBuilder()).append(expandStringValue(operator, varspec, s2, VarSpec.VarFormat.PAIRS)).append(s).append(expandStringValue(operator, varspec, entry.getValue().toString(), VarSpec.VarFormat.PAIRS)).toString()))
        {
            entry = (java.util.Map.Entry)map.next();
            s2 = (String)entry.getKey();
            checkValue(entry.getValue());
        }

        if (varspec.getModifier() != Modifier.EXPLODE && (operator == Operator.MATRIX || operator == Operator.QUERY || operator == Operator.CONTINUATION))
        {
            map = joinParts(s1, arraylist);
            if (operator == Operator.QUERY && map == null)
            {
                return (new StringBuilder()).append(varspec.getVariableName()).append("=").toString();
            } else
            {
                return (new StringBuilder()).append(varspec.getVariableName()).append("=").append(map).toString();
            }
        } else
        {
            return joinParts(s1, arraylist);
        }
    }

    private String expandStringValue(Operator operator, VarSpec varspec, String s, VarSpec.VarFormat varformat)
    {
        String s1 = s;
        if (varspec.getModifier() == Modifier.PREFIX)
        {
            int i = varspec.getPosition().intValue();
            s1 = s;
            if (i < s.length())
            {
                s1 = s.substring(0, i);
            }
        }
        if (operator.getEncoding() == com.damnhandy.uri.template.UriTemplate.Encoding.UR)
        {
            s = UriUtil.encodeReserved(s1);
        } else
        if (operator.getEncoding() == com.damnhandy.uri.template.UriTemplate.Encoding.UF)
        {
            s = UriUtil.encodeFragment(s1);
        } else
        {
            s = UriUtil.encode(s1);
        }
        s1 = s;
        if (operator.isNamed())
        {
            if (s.isEmpty() && !operator.getSeparator().equals("&"))
            {
                s1 = varspec.getValue();
            } else
            {
                if (varformat == VarSpec.VarFormat.SINGLE)
                {
                    return (new StringBuilder()).append(varspec.getVariableName()).append("=").append(s).toString();
                }
                s1 = s;
                if (varspec.getModifier() == Modifier.EXPLODE)
                {
                    s1 = s;
                    if (operator.useVarNameWhenExploded())
                    {
                        s1 = s;
                        if (varformat != VarSpec.VarFormat.PAIRS)
                        {
                            return (new StringBuilder()).append(varspec.getVariableName()).append("=").append(s).toString();
                        }
                    }
                }
            }
        }
        return s1;
    }

    private List expandVariables(Operator operator, List list)
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = list.iterator();
        do
        {
            if (iterator.hasNext())
            {
                VarSpec varspec = (VarSpec)iterator.next();
                if (!values.containsKey(varspec.getVariableName()))
                {
                    continue;
                }
                Object obj = values.get(varspec.getVariableName());
                Object obj2 = null;
                list = ((List) (obj));
                boolean flag;
                if (obj != null)
                {
                    list = ((List) (obj));
                    if (obj.getClass().isArray())
                    {
                        if (obj instanceof char[][])
                        {
                            obj = (char[][])(char[][])obj;
                            list = new ArrayList();
                            int j = obj.length;
                            for (int i = 0; i < j; i++)
                            {
                                list.add(String.valueOf(obj[i]));
                            }

                        } else
                        if (obj instanceof char[])
                        {
                            list = String.valueOf((char[])(char[])obj);
                        } else
                        {
                            list = arrayToList(obj);
                        }
                    }
                }
                flag = isExplodable(list);
                if (flag && varspec.getModifier() == Modifier.PREFIX)
                {
                    throw new VariableExpansionException("Prefix modifiers are not applicable to variables that have composite values.");
                }
                obj = obj2;
                Object obj1;
                if (flag)
                {
                    if (list instanceof VarExploder)
                    {
                        obj1 = (VarExploder)list;
                    } else
                    {
                        obj1 = VarExploderFactory.getExploder(list, varspec);
                    }
                    if (varspec.getModifier() == Modifier.EXPLODE)
                    {
                        obj = expandMap(operator, varspec, ((VarExploder) (obj1)).getNameValuePairs());
                    } else
                    {
                        obj = obj2;
                        if (varspec.getModifier() != Modifier.EXPLODE)
                        {
                            obj = expandCollection(operator, varspec, ((VarExploder) (obj1)).getValues());
                        }
                    }
                }
                if (list instanceof Date)
                {
                    obj1 = defaultDateFormat.format((Date)list);
                } else
                {
                    obj1 = list;
                }
                if (obj1 instanceof Collection)
                {
                    list = expandCollection(operator, varspec, (Collection)obj1);
                } else
                if (obj1 instanceof Map)
                {
                    list = expandMap(operator, varspec, (Map)obj1);
                } else
                if (obj1 == null)
                {
                    list = null;
                } else
                {
                    list = ((List) (obj));
                    if (obj == null)
                    {
                        list = expandStringValue(operator, varspec, obj1.toString(), VarSpec.VarFormat.SINGLE);
                    }
                }
                if (list != null)
                {
                    arraylist.add(list);
                }
                continue;
            }
            return arraylist;
        } while (true);
    }

    private String findExpressions(Operator operator, List list)
    {
        list = expandVariables(operator, list);
        list = joinParts(operator.getSeparator(), list);
        if (list != null)
        {
            if (operator == Operator.RESERVED)
            {
                return list;
            } else
            {
                return (new StringBuilder()).append(operator.getPrefix()).append(list).toString();
            }
        } else
        {
            return "";
        }
    }

    private boolean isExplodable(Object obj)
    {
        if (obj != null)
        {
            if ((obj instanceof Collection) || (obj instanceof Map) || obj.getClass().isArray())
            {
                return true;
            }
            if (!isSimpleType(obj))
            {
                return true;
            }
        }
        return false;
    }

    private boolean isSimpleType(Object obj)
    {
        return obj.getClass().isPrimitive() || (obj instanceof Number) || (obj instanceof CharSequence) || (obj instanceof Date) || (obj instanceof Boolean);
    }

    private String joinParts(String s, List list)
    {
        if (list.size() == 0)
        {
            return null;
        }
        if (list.size() == 1)
        {
            return (String)list.get(0);
        }
        StringBuilder stringbuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++)
        {
            String s1 = (String)list.get(i);
            if (s1.isEmpty())
            {
                continue;
            }
            stringbuilder.append(s1);
            if (list.size() > 0 && i != list.size() - 1)
            {
                stringbuilder.append(s);
            }
        }

        return stringbuilder.toString();
    }

    private void validateVarname(String s)
    {
        if (!VARNAME_REGEX.matcher(s).matches())
        {
            throw new ExpressionParseException((new StringBuilder()).append("The variable name ").append(s).append(" contains invalid characters").toString());
        }
        if (s.contains(" "))
        {
            throw new ExpressionParseException((new StringBuilder()).append("The variable name ").append(s).append(" cannot contain spaces (leading or trailing)").toString());
        } else
        {
            return;
        }
    }

    public String expand()
    {
        Object obj = getTemplate();
        obj = URI_TEMPLATE_REGEX.matcher(((CharSequence) (obj)));
        StringBuffer stringbuffer = new StringBuffer();
        int i;
        for (i = 0; ((Matcher) (obj)).find(); i++)
        {
            String s = ((Matcher) (obj)).group();
            ((Matcher) (obj)).appendReplacement(stringbuffer, buildVarSpecs(s.substring(1, s.length() - 1)));
        }

        if (i == 0)
        {
            throw new ExpressionParseException("no variables found");
        } else
        {
            ((Matcher) (obj)).appendTail(stringbuffer);
            return stringbuffer.toString();
        }
    }

    public String expand(Map map)
    {
        values = map;
        return expand();
    }

}
