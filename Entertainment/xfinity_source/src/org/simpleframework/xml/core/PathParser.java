// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.Style;
import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

// Referenced classes of package org.simpleframework.xml.core:
//            Expression, PathException

class PathParser
    implements Expression
{
    private class PathSection
        implements Expression
    {

        private int begin;
        private List cache;
        private int end;
        private String path;
        private String section;
        final PathParser this$0;

        private String getCanonicalPath()
        {
            int i = 0;
            int j;
            for (j = 0; j < begin; j++)
            {
                i = location.indexOf('/', i + 1);
            }

            int l = i;
            int k = j;
            j = l;
            for (; k <= end; k++)
            {
                int i1 = location.indexOf('/', j + 1);
                j = i1;
                if (i1 == -1)
                {
                    j = location.length();
                }
            }

            return location.substring(i + 1, j);
        }

        private String getFragment()
        {
            int i = start;
            int i1 = 0;
            int j = 0;
            do
            {
label0:
                {
                    int k = i;
                    if (j <= end)
                    {
                        if (i < count)
                        {
                            break label0;
                        }
                        k = i + 1;
                    }
                    return new String(data, i1, k - 1 - i1);
                }
                char ac[] = data;
                int l = i + 1;
                int j1 = j;
                if (ac[i] == '/')
                {
                    j++;
                    j1 = j;
                    if (j == begin)
                    {
                        i1 = l;
                        i = l;
                        continue;
                    }
                }
                i = l;
                j = j1;
            } while (true);
        }

        public String getAttribute(String s)
        {
            String s2 = getPath();
            String s1 = s;
            if (s2 != null)
            {
                s1 = getAttributePath(s2, s);
            }
            return s1;
        }

        public String getElement(String s)
        {
            String s2 = getPath();
            String s1 = s;
            if (s2 != null)
            {
                s1 = getElementPath(s2, s);
            }
            return s1;
        }

        public String getFirst()
        {
            return (String)names.get(begin);
        }

        public int getIndex()
        {
            return ((Integer)indexes.get(begin)).intValue();
        }

        public String getLast()
        {
            return (String)names.get(end);
        }

        public String getPath()
        {
            if (section == null)
            {
                section = getCanonicalPath();
            }
            return section;
        }

        public Expression getPath(int i)
        {
            return getPath(i, 0);
        }

        public Expression getPath(int i, int j)
        {
            return new PathSection(begin + i, end - j);
        }

        public String getPrefix()
        {
            return (String)prefixes.get(begin);
        }

        public boolean isAttribute()
        {
            boolean flag1 = false;
            boolean flag = flag1;
            if (attribute)
            {
                flag = flag1;
                if (end >= names.size() - 1)
                {
                    flag = true;
                }
            }
            return flag;
        }

        public boolean isEmpty()
        {
            return begin == end;
        }

        public boolean isPath()
        {
            return end - begin >= 1;
        }

        public Iterator iterator()
        {
            if (cache.isEmpty())
            {
                for (int i = begin; i <= end; i++)
                {
                    String s = (String)names.get(i);
                    if (s != null)
                    {
                        cache.add(s);
                    }
                }

            }
            return cache.iterator();
        }

        public String toString()
        {
            if (path == null)
            {
                path = getFragment();
            }
            return path;
        }

        public PathSection(int i, int j)
        {
            this$0 = PathParser.this;
            super();
            cache = new ArrayList();
            begin = i;
            end = j;
        }
    }


    protected boolean attribute;
    protected Cache attributes;
    protected StringBuilder builder;
    protected String cache;
    protected int count;
    protected char data[];
    protected Cache elements;
    protected List indexes;
    protected String location;
    protected List names;
    protected int off;
    protected String path;
    protected List prefixes;
    protected int start;
    protected Style style;
    protected Type type;

    public PathParser(String s, Type type1, Format format)
        throws Exception
    {
        attributes = new ConcurrentCache();
        elements = new ConcurrentCache();
        indexes = new ArrayList();
        prefixes = new ArrayList();
        names = new ArrayList();
        builder = new StringBuilder();
        style = format.getStyle();
        type = type1;
        path = s;
        parse(s);
    }

    private void align()
        throws Exception
    {
        if (names.size() > indexes.size())
        {
            indexes.add(Integer.valueOf(1));
        }
    }

    private void attribute()
        throws Exception
    {
        int i = off + 1;
        for (off = i; off < count;)
        {
            char ac[] = data;
            int j = off;
            off = j + 1;
            char c = ac[j];
            if (!isValid(c))
            {
                throw new PathException("Illegal character '%s' in attribute for '%s' in %s", new Object[] {
                    Character.valueOf(c), path, type
                });
            }
        }

        if (off <= i)
        {
            throw new PathException("Attribute reference in '%s' for %s is empty", new Object[] {
                path, type
            });
        } else
        {
            attribute = true;
            attribute(i, off - i);
            return;
        }
    }

    private void attribute(int i, int j)
    {
        String s = new String(data, i, j);
        if (j > 0)
        {
            attribute(s);
        }
    }

    private void attribute(String s)
    {
        s = style.getAttribute(s);
        prefixes.add(null);
        names.add(s);
    }

    private void build()
    {
        int j = names.size();
        int i = 0;
        while (i < j) 
        {
            String s = (String)prefixes.get(i);
            String s1 = (String)names.get(i);
            int k = ((Integer)indexes.get(i)).intValue();
            if (i > 0)
            {
                builder.append('/');
            }
            if (attribute && i == j - 1)
            {
                builder.append('@');
                builder.append(s1);
            } else
            {
                if (s != null)
                {
                    builder.append(s);
                    builder.append(':');
                }
                builder.append(s1);
                builder.append('[');
                builder.append(k);
                builder.append(']');
            }
            i++;
        }
        location = builder.toString();
    }

    private void element()
        throws Exception
    {
        int i;
        int j;
        j = off;
        i = 0;
_L8:
        if (off >= count) goto _L2; else goto _L1
_L1:
        char c;
        char ac[] = data;
        int k = off;
        off = k + 1;
        c = ac[k];
        if (isValid(c))
        {
            break MISSING_BLOCK_LABEL_129;
        }
        if (c != '@') goto _L4; else goto _L3
_L3:
        off = off - 1;
_L2:
        element(j, i);
        return;
_L4:
        if (c != '[')
        {
            break; /* Loop/switch isn't completed */
        }
        index();
        if (true) goto _L2; else goto _L5
_L5:
        if (c == '/') goto _L2; else goto _L6
_L6:
        throw new PathException("Illegal character '%s' in element for '%s' in %s", new Object[] {
            Character.valueOf(c), path, type
        });
        i++;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private void element(int i, int j)
    {
        String s = new String(data, i, j);
        if (j > 0)
        {
            element(s);
        }
    }

    private void element(String s)
    {
        int i = s.indexOf(':');
        String s1 = null;
        String s2 = s;
        if (i > 0)
        {
            s1 = s.substring(0, i);
            s2 = s.substring(i + 1);
        }
        s = style.getElement(s2);
        prefixes.add(s1);
        names.add(s);
    }

    private void index()
        throws Exception
    {
        int i;
        int j;
        j = 0;
        i = 0;
        if (data[off - 1] != '[') goto _L2; else goto _L1
_L1:
        j = i;
        if (off >= count) goto _L2; else goto _L3
_L3:
        char c;
        char ac[] = data;
        j = off;
        off = j + 1;
        c = ac[j];
        if (isDigit(c)) goto _L5; else goto _L4
_L4:
        j = i;
_L2:
        char ac1[] = data;
        i = off;
        off = i + 1;
        if (ac1[i - 1] != ']')
        {
            throw new PathException("Invalid index for path '%s' in %s", new Object[] {
                path, type
            });
        } else
        {
            indexes.add(Integer.valueOf(j));
            return;
        }
_L5:
        i = (i * 10 + c) - 48;
        if (true) goto _L1; else goto _L6
_L6:
    }

    private boolean isDigit(char c)
    {
        return Character.isDigit(c);
    }

    private boolean isEmpty(String s)
    {
        return s == null || s.length() == 0;
    }

    private boolean isLetter(char c)
    {
        return Character.isLetterOrDigit(c);
    }

    private boolean isSpecial(char c)
    {
        return c == '_' || c == '-' || c == ':';
    }

    private boolean isValid(char c)
    {
        return isLetter(c) || isSpecial(c);
    }

    private void parse(String s)
        throws Exception
    {
        if (s != null)
        {
            count = s.length();
            data = new char[count];
            s.getChars(0, count, data, 0);
        }
        path();
    }

    private void path()
        throws Exception
    {
        if (data[off] == '/')
        {
            throw new PathException("Path '%s' in %s references document root", new Object[] {
                path, type
            });
        }
        if (data[off] == '.')
        {
            skip();
        }
        while (off < count) 
        {
            if (attribute)
            {
                throw new PathException("Path '%s' in %s references an invalid attribute", new Object[] {
                    path, type
                });
            }
            segment();
        }
        truncate();
        build();
    }

    private void segment()
        throws Exception
    {
        char c = data[off];
        if (c == '/')
        {
            throw new PathException("Invalid path expression '%s' in %s", new Object[] {
                path, type
            });
        }
        if (c == '@')
        {
            attribute();
        } else
        {
            element();
        }
        align();
    }

    private void skip()
        throws Exception
    {
        if (data.length > 1)
        {
            if (data[off + 1] != '/')
            {
                throw new PathException("Path '%s' in %s has an illegal syntax", new Object[] {
                    path, type
                });
            }
            off = off + 1;
        }
        int i = off + 1;
        off = i;
        start = i;
    }

    private void truncate()
        throws Exception
    {
        if (off - 1 >= data.length)
        {
            off = off - 1;
        } else
        if (data[off - 1] == '/')
        {
            off = off - 1;
            return;
        }
    }

    public String getAttribute(String s)
    {
        if (!isEmpty(location))
        {
            String s2 = (String)attributes.fetch(s);
            String s1 = s2;
            if (s2 == null)
            {
                String s3 = getAttributePath(location, s);
                s1 = s3;
                if (s3 != null)
                {
                    attributes.cache(s, s3);
                    s1 = s3;
                }
            }
            return s1;
        } else
        {
            return style.getAttribute(s);
        }
    }

    protected String getAttributePath(String s, String s1)
    {
        s1 = style.getAttribute(s1);
        if (isEmpty(s))
        {
            return s1;
        } else
        {
            return (new StringBuilder()).append(s).append("/@").append(s1).toString();
        }
    }

    public String getElement(String s)
    {
        if (!isEmpty(location))
        {
            String s2 = (String)elements.fetch(s);
            String s1 = s2;
            if (s2 == null)
            {
                String s3 = getElementPath(location, s);
                s1 = s3;
                if (s3 != null)
                {
                    elements.cache(s, s3);
                    s1 = s3;
                }
            }
            return s1;
        } else
        {
            return style.getElement(s);
        }
    }

    protected String getElementPath(String s, String s1)
    {
        s1 = style.getElement(s1);
        if (isEmpty(s1))
        {
            return s;
        }
        if (isEmpty(s))
        {
            return s1;
        } else
        {
            return (new StringBuilder()).append(s).append("/").append(s1).append("[1]").toString();
        }
    }

    public String getFirst()
    {
        return (String)names.get(0);
    }

    public int getIndex()
    {
        return ((Integer)indexes.get(0)).intValue();
    }

    public String getLast()
    {
        int i = names.size();
        return (String)names.get(i - 1);
    }

    public String getPath()
    {
        return location;
    }

    public Expression getPath(int i)
    {
        return getPath(i, 0);
    }

    public Expression getPath(int i, int j)
    {
        int k = names.size() - 1;
        if (k - j >= i)
        {
            return new PathSection(i, k - j);
        } else
        {
            return new PathSection(i, i);
        }
    }

    public String getPrefix()
    {
        return (String)prefixes.get(0);
    }

    public boolean isAttribute()
    {
        return attribute;
    }

    public boolean isEmpty()
    {
        return isEmpty(location);
    }

    public boolean isPath()
    {
        return names.size() > 1;
    }

    public Iterator iterator()
    {
        return names.iterator();
    }

    public String toString()
    {
        int i = off;
        int j = start;
        if (cache == null)
        {
            cache = new String(data, start, i - j);
        }
        return cache;
    }
}
