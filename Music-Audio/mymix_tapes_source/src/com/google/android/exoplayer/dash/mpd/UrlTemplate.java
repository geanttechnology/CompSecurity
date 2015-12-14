// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.dash.mpd;

import java.util.Locale;

public final class UrlTemplate
{

    private static final String BANDWIDTH = "Bandwidth";
    private static final int BANDWIDTH_ID = 3;
    private static final String DEFAULT_FORMAT_TAG = "%01d";
    private static final String ESCAPED_DOLLAR = "$$";
    private static final String NUMBER = "Number";
    private static final int NUMBER_ID = 2;
    private static final String REPRESENTATION = "RepresentationID";
    private static final int REPRESENTATION_ID = 1;
    private static final String TIME = "Time";
    private static final int TIME_ID = 4;
    private final int identifierCount;
    private final String identifierFormatTags[];
    private final int identifiers[];
    private final String urlPieces[];

    private UrlTemplate(String as[], int ai[], String as1[], int i)
    {
        urlPieces = as;
        identifiers = ai;
        identifierFormatTags = as1;
        identifierCount = i;
    }

    public static UrlTemplate compile(String s)
    {
        String as[] = new String[5];
        int ai[] = new int[4];
        String as1[] = new String[4];
        return new UrlTemplate(as, ai, as1, parseTemplate(s, as, ai, as1));
    }

    private static int parseTemplate(String s, String as[], int ai[], String as1[])
    {
        as[0] = "";
        int i = 0;
        int k = 0;
        do
        {
            while (i < s.length()) 
            {
                int l = s.indexOf("$", i);
                if (l == -1)
                {
                    as[k] = (new StringBuilder()).append(as[k]).append(s.substring(i)).toString();
                    i = s.length();
                } else
                if (l != i)
                {
                    as[k] = (new StringBuilder()).append(as[k]).append(s.substring(i, l)).toString();
                    i = l;
                } else
                if (s.startsWith("$$", i))
                {
                    as[k] = (new StringBuilder()).append(as[k]).append("$").toString();
                    i += 2;
                } else
                {
                    int i1 = s.indexOf("$", i + 1);
                    String s3 = s.substring(i + 1, i1);
                    if (s3.equals("RepresentationID"))
                    {
                        ai[k] = 1;
                    } else
                    {
                        int j = s3.indexOf("%0");
                        String s1 = "%01d";
                        String s2 = s3;
                        if (j != -1)
                        {
                            s2 = s3.substring(j);
                            s1 = s2;
                            if (!s2.endsWith("d"))
                            {
                                s1 = (new StringBuilder()).append(s2).append("d").toString();
                            }
                            s2 = s3.substring(0, j);
                        }
                        if (s2.equals("Number"))
                        {
                            ai[k] = 2;
                        } else
                        if (s2.equals("Bandwidth"))
                        {
                            ai[k] = 3;
                        } else
                        if (s2.equals("Time"))
                        {
                            ai[k] = 4;
                        } else
                        {
                            throw new IllegalArgumentException((new StringBuilder()).append("Invalid template: ").append(s).toString());
                        }
                        as1[k] = s1;
                    }
                    k++;
                    as[k] = "";
                    i = i1 + 1;
                }
            }
            return k;
        } while (true);
    }

    public String buildUri(String s, int i, int j, long l)
    {
        StringBuilder stringbuilder = new StringBuilder();
        int k = 0;
        while (k < identifierCount) 
        {
            stringbuilder.append(urlPieces[k]);
            if (identifiers[k] == 1)
            {
                stringbuilder.append(s);
            } else
            if (identifiers[k] == 2)
            {
                stringbuilder.append(String.format(Locale.US, identifierFormatTags[k], new Object[] {
                    Integer.valueOf(i)
                }));
            } else
            if (identifiers[k] == 3)
            {
                stringbuilder.append(String.format(Locale.US, identifierFormatTags[k], new Object[] {
                    Integer.valueOf(j)
                }));
            } else
            if (identifiers[k] == 4)
            {
                stringbuilder.append(String.format(Locale.US, identifierFormatTags[k], new Object[] {
                    Long.valueOf(l)
                }));
            }
            k++;
        }
        stringbuilder.append(urlPieces[identifierCount]);
        return stringbuilder.toString();
    }
}
