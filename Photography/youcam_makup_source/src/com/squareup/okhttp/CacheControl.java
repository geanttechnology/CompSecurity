// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import com.squareup.okhttp.internal.http.HeaderParser;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.squareup.okhttp:
//            Headers

public final class CacheControl
{

    public static final CacheControl FORCE_CACHE;
    public static final CacheControl FORCE_NETWORK = (new Builder()).noCache().build();
    private final boolean isPublic;
    private final int maxAgeSeconds;
    private final int maxStaleSeconds;
    private final int minFreshSeconds;
    private final boolean mustRevalidate;
    private final boolean noCache;
    private final boolean noStore;
    private final boolean noTransform;
    private final boolean onlyIfCached;
    private final int sMaxAgeSeconds;

    private CacheControl(Builder builder)
    {
        noCache = builder.noCache;
        noStore = builder.noStore;
        maxAgeSeconds = builder.maxAgeSeconds;
        sMaxAgeSeconds = -1;
        isPublic = false;
        mustRevalidate = false;
        maxStaleSeconds = builder.maxStaleSeconds;
        minFreshSeconds = builder.minFreshSeconds;
        onlyIfCached = builder.onlyIfCached;
        noTransform = builder.noTransform;
    }


    private CacheControl(boolean flag, boolean flag1, int i, int j, boolean flag2, boolean flag3, int k, 
            int l, boolean flag4, boolean flag5)
    {
        noCache = flag;
        noStore = flag1;
        maxAgeSeconds = i;
        sMaxAgeSeconds = j;
        isPublic = flag2;
        mustRevalidate = flag3;
        maxStaleSeconds = k;
        minFreshSeconds = l;
        onlyIfCached = flag4;
        noTransform = flag5;
    }

    public static CacheControl parse(Headers headers)
    {
        boolean flag5 = false;
        boolean flag2 = false;
        int i1 = -1;
        int l = -1;
        boolean flag4 = false;
        boolean flag3 = false;
        int k = -1;
        int j = -1;
        boolean flag1 = false;
        boolean flag = false;
        int j1 = 0;
        while (j1 < headers.size()) 
        {
            if (headers.name(j1).equalsIgnoreCase("Cache-Control") || headers.name(j1).equalsIgnoreCase("Pragma"))
            {
                String s1 = headers.value(j1);
                int k1 = 0;
                while (k1 < s1.length()) 
                {
                    int i = HeaderParser.skipUntil(s1, k1, "=,;");
                    String s2 = s1.substring(k1, i).trim();
                    String s;
                    if (i == s1.length() || s1.charAt(i) == ',' || s1.charAt(i) == ';')
                    {
                        i++;
                        s = null;
                    } else
                    {
                        k1 = HeaderParser.skipWhitespace(s1, i + 1);
                        if (k1 < s1.length() && s1.charAt(k1) == '"')
                        {
                            i = k1 + 1;
                            k1 = HeaderParser.skipUntil(s1, i, "\"");
                            s = s1.substring(i, k1);
                            i = k1 + 1;
                        } else
                        {
                            i = HeaderParser.skipUntil(s1, k1, ",;");
                            s = s1.substring(k1, i).trim();
                        }
                    }
                    if ("no-cache".equalsIgnoreCase(s2))
                    {
                        flag5 = true;
                        k1 = i;
                    } else
                    if ("no-store".equalsIgnoreCase(s2))
                    {
                        flag2 = true;
                        k1 = i;
                    } else
                    if ("max-age".equalsIgnoreCase(s2))
                    {
                        i1 = HeaderParser.parseSeconds(s, -1);
                        k1 = i;
                    } else
                    if ("s-maxage".equalsIgnoreCase(s2))
                    {
                        l = HeaderParser.parseSeconds(s, -1);
                        k1 = i;
                    } else
                    if ("public".equalsIgnoreCase(s2))
                    {
                        flag4 = true;
                        k1 = i;
                    } else
                    if ("must-revalidate".equalsIgnoreCase(s2))
                    {
                        flag3 = true;
                        k1 = i;
                    } else
                    if ("max-stale".equalsIgnoreCase(s2))
                    {
                        k = HeaderParser.parseSeconds(s, 0x7fffffff);
                        k1 = i;
                    } else
                    if ("min-fresh".equalsIgnoreCase(s2))
                    {
                        j = HeaderParser.parseSeconds(s, -1);
                        k1 = i;
                    } else
                    if ("only-if-cached".equalsIgnoreCase(s2))
                    {
                        flag1 = true;
                        k1 = i;
                    } else
                    {
                        k1 = i;
                        if ("no-transform".equalsIgnoreCase(s2))
                        {
                            flag = true;
                            k1 = i;
                        }
                    }
                }
            }
            j1++;
        }
        return new CacheControl(flag5, flag2, i1, l, flag4, flag3, k, j, flag1, flag);
    }

    public boolean isPublic()
    {
        return isPublic;
    }

    public int maxAgeSeconds()
    {
        return maxAgeSeconds;
    }

    public int maxStaleSeconds()
    {
        return maxStaleSeconds;
    }

    public int minFreshSeconds()
    {
        return minFreshSeconds;
    }

    public boolean mustRevalidate()
    {
        return mustRevalidate;
    }

    public boolean noCache()
    {
        return noCache;
    }

    public boolean noStore()
    {
        return noStore;
    }

    public boolean noTransform()
    {
        return noTransform;
    }

    public boolean onlyIfCached()
    {
        return onlyIfCached;
    }

    public int sMaxAgeSeconds()
    {
        return sMaxAgeSeconds;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (noCache)
        {
            stringbuilder.append("no-cache, ");
        }
        if (noStore)
        {
            stringbuilder.append("no-store, ");
        }
        if (maxAgeSeconds != -1)
        {
            stringbuilder.append("max-age=").append(maxAgeSeconds).append(", ");
        }
        if (sMaxAgeSeconds != -1)
        {
            stringbuilder.append("s-maxage=").append(sMaxAgeSeconds).append(", ");
        }
        if (isPublic)
        {
            stringbuilder.append("public, ");
        }
        if (mustRevalidate)
        {
            stringbuilder.append("must-revalidate, ");
        }
        if (maxStaleSeconds != -1)
        {
            stringbuilder.append("max-stale=").append(maxStaleSeconds).append(", ");
        }
        if (minFreshSeconds != -1)
        {
            stringbuilder.append("min-fresh=").append(minFreshSeconds).append(", ");
        }
        if (onlyIfCached)
        {
            stringbuilder.append("only-if-cached, ");
        }
        if (noTransform)
        {
            stringbuilder.append("no-transform, ");
        }
        if (stringbuilder.length() == 0)
        {
            return "";
        } else
        {
            stringbuilder.delete(stringbuilder.length() - 2, stringbuilder.length());
            return stringbuilder.toString();
        }
    }

    static 
    {
        FORCE_CACHE = (new Builder()).onlyIfCached().maxStale(0x7fffffff, TimeUnit.SECONDS).build();
    }

    private class Builder
    {

        int maxAgeSeconds;
        int maxStaleSeconds;
        int minFreshSeconds;
        boolean noCache;
        boolean noStore;
        boolean noTransform;
        boolean onlyIfCached;

        public CacheControl build()
        {
            return new CacheControl(this);
        }

        public Builder maxAge(int i, TimeUnit timeunit)
        {
            if (i < 0)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("maxAge < 0: ").append(i).toString());
            }
            long l = timeunit.toSeconds(i);
            if (l > 0x7fffffffL)
            {
                i = 0x7fffffff;
            } else
            {
                i = (int)l;
            }
            maxAgeSeconds = i;
            return this;
        }

        public Builder maxStale(int i, TimeUnit timeunit)
        {
            if (i < 0)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("maxStale < 0: ").append(i).toString());
            }
            long l = timeunit.toSeconds(i);
            if (l > 0x7fffffffL)
            {
                i = 0x7fffffff;
            } else
            {
                i = (int)l;
            }
            maxStaleSeconds = i;
            return this;
        }

        public Builder minFresh(int i, TimeUnit timeunit)
        {
            if (i < 0)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("minFresh < 0: ").append(i).toString());
            }
            long l = timeunit.toSeconds(i);
            if (l > 0x7fffffffL)
            {
                i = 0x7fffffff;
            } else
            {
                i = (int)l;
            }
            minFreshSeconds = i;
            return this;
        }

        public Builder noCache()
        {
            noCache = true;
            return this;
        }

        public Builder noStore()
        {
            noStore = true;
            return this;
        }

        public Builder noTransform()
        {
            noTransform = true;
            return this;
        }

        public Builder onlyIfCached()
        {
            onlyIfCached = true;
            return this;
        }

        public Builder()
        {
            maxAgeSeconds = -1;
            maxStaleSeconds = -1;
            minFreshSeconds = -1;
        }
    }

}
