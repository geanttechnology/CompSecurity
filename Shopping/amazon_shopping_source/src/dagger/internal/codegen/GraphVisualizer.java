// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package dagger.internal.codegen;

import dagger.internal.Binding;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package dagger.internal.codegen:
//            GraphVizWriter

public final class GraphVisualizer
{
    private static class BindingComparator
        implements Comparator
    {

        private String getStringForBinding(Binding binding)
        {
            if (binding == null)
            {
                return "";
            } else
            {
                return binding.toString();
            }
        }

        public int compare(Binding binding, Binding binding1)
        {
            return getStringForBinding(binding).compareTo(getStringForBinding(binding1));
        }

        public volatile int compare(Object obj, Object obj1)
        {
            return compare((Binding)obj, (Binding)obj1);
        }

        private BindingComparator()
        {
        }

    }


    private static final Pattern KEY_PATTERN = Pattern.compile("(?:@(?:[\\w$]+\\.)*([\\w$]+)(?:\\(.*\\))?/)?(?:members/)?(?:[\\w$]+\\.)*([\\w$]+)(\\<[^/]+\\>)?((\\[\\])*)");

    public GraphVisualizer()
    {
    }

    private Map buildNamesIndex(Map map)
    {
        Object obj = new TreeMap();
        HashSet hashset = new HashSet();
        Iterator iterator = map.entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj3 = (java.util.Map.Entry)iterator.next();
            Object obj1 = (String)((java.util.Map.Entry) (obj3)).getKey();
            obj3 = (Binding)((java.util.Map.Entry) (obj3)).getValue();
            obj1 = (Binding)((Map) (obj)).put(shortName(((String) (obj1))), obj3);
            if (obj1 != null && obj1 != obj3)
            {
                hashset.add(obj3);
                hashset.add(obj1);
            }
        } while (true);
        map = map.entrySet().iterator();
        do
        {
            if (!map.hasNext())
            {
                break;
            }
            Object obj2 = (java.util.Map.Entry)map.next();
            Binding binding = (Binding)((java.util.Map.Entry) (obj2)).getValue();
            if (hashset.contains(binding))
            {
                obj2 = (String)((java.util.Map.Entry) (obj2)).getKey();
                ((Map) (obj)).remove(shortName(((String) (obj2))));
                ((Map) (obj)).put(obj2, binding);
            }
        } while (true);
        map = new LinkedHashMap();
        java.util.Map.Entry entry;
        for (obj = ((Map) (obj)).entrySet().iterator(); ((Iterator) (obj)).hasNext(); map.put(entry.getValue(), entry.getKey()))
        {
            entry = (java.util.Map.Entry)((Iterator) (obj)).next();
        }

        return map;
    }

    String shortName(String s)
    {
        Object obj = KEY_PATTERN.matcher(s);
        if (!((Matcher) (obj)).matches())
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Unexpected key: ").append(s).toString());
        }
        s = new StringBuilder();
        String s1 = ((Matcher) (obj)).group(1);
        if (s1 != null)
        {
            s.append('@').append(s1).append(' ');
        }
        s.append(((Matcher) (obj)).group(2));
        s1 = ((Matcher) (obj)).group(3);
        if (s1 != null)
        {
            s.append(s1);
        }
        obj = ((Matcher) (obj)).group(4);
        if (obj != null)
        {
            s.append(((String) (obj)));
        }
        return s.toString();
    }

    public void write(Map map, GraphVizWriter graphvizwriter)
        throws IOException
    {
        Map map1 = buildNamesIndex(map);
        graphvizwriter.beginGraph(new String[] {
            "concentrate", "true"
        });
        for (Iterator iterator = map1.entrySet().iterator(); iterator.hasNext();)
        {
            Object obj = (java.util.Map.Entry)iterator.next();
            map = (Binding)((java.util.Map.Entry) (obj)).getKey();
            String s1 = (String)((java.util.Map.Entry) (obj)).getValue();
            obj = new TreeSet(new BindingComparator());
            map.getDependencies(((Set) (obj)), ((Set) (obj)));
            Iterator iterator1 = ((Set) (obj)).iterator();
            while (iterator1.hasNext()) 
            {
                Binding binding = (Binding)iterator1.next();
                String s = (String)map1.get(binding);
                map = s;
                if (s == null)
                {
                    map = (new StringBuilder()).append("Unbound:").append(binding.provideKey).toString();
                }
                graphvizwriter.edge(s1, map, new String[0]);
            }
        }

        graphvizwriter.endGraph();
    }

}
