// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package RLSDK;


// Referenced classes of package RLSDK:
//            v

final class cv
{

    private static final Object a;
    private static final Object b[][];
    private static final Object c[][];
    private static final Object d[][];
    private static final Object e[][];

    private static String a(int i, int j, String s)
        throws v
    {
        if (s.length() < i)
        {
            throw v.a();
        }
        String s1 = s.substring(0, i);
        if (s.length() < i + j)
        {
            throw v.a();
        } else
        {
            String s2 = s.substring(i, i + j);
            s = s.substring(i + j);
            return (new StringBuilder("(")).append(s1).append(')').append(s2).append(a(s)).toString();
        }
    }

    static String a(String s)
        throws v
    {
        if (s.length() == 0)
        {
            return "";
        }
        if (s.length() < 2)
        {
            throw v.a();
        }
        String s1 = s.substring(0, 2);
        for (int i = 0; i < b.length; i++)
        {
            if (b[i][0].equals(s1))
            {
                if (b[i][1] == a)
                {
                    return b(2, ((Integer)b[i][2]).intValue(), s);
                } else
                {
                    return a(2, ((Integer)b[i][1]).intValue(), s);
                }
            }
        }

        if (s.length() < 3)
        {
            throw v.a();
        }
        s1 = s.substring(0, 3);
        for (int j = 0; j < c.length; j++)
        {
            if (c[j][0].equals(s1))
            {
                if (c[j][1] == a)
                {
                    return b(3, ((Integer)c[j][2]).intValue(), s);
                } else
                {
                    return a(3, ((Integer)c[j][1]).intValue(), s);
                }
            }
        }

        for (int k = 0; k < d.length; k++)
        {
            if (d[k][0].equals(s1))
            {
                if (d[k][1] == a)
                {
                    return b(4, ((Integer)d[k][2]).intValue(), s);
                } else
                {
                    return a(4, ((Integer)d[k][1]).intValue(), s);
                }
            }
        }

        if (s.length() < 4)
        {
            throw v.a();
        }
        s1 = s.substring(0, 4);
        for (int l = 0; l < e.length; l++)
        {
            if (e[l][0].equals(s1))
            {
                if (e[l][1] == a)
                {
                    return b(4, ((Integer)e[l][2]).intValue(), s);
                } else
                {
                    return a(4, ((Integer)e[l][1]).intValue(), s);
                }
            }
        }

        throw v.a();
    }

    private static String b(int i, int j, String s)
        throws v
    {
        String s1 = s.substring(0, i);
        String s2;
        if (s.length() < i + j)
        {
            j = s.length();
        } else
        {
            j = i + j;
        }
        s2 = s.substring(i, j);
        s = s.substring(j);
        return (new StringBuilder("(")).append(s1).append(')').append(s2).append(a(s)).toString();
    }

    static 
    {
        a = new Object();
        b = (new Object[][] {
            new Object[] {
                "00", new Integer(18)
            }, new Object[] {
                "01", new Integer(14)
            }, new Object[] {
                "02", new Integer(14)
            }, new Object[] {
                "10", a, new Integer(20)
            }, new Object[] {
                "11", new Integer(6)
            }, new Object[] {
                "12", new Integer(6)
            }, new Object[] {
                "13", new Integer(6)
            }, new Object[] {
                "15", new Integer(6)
            }, new Object[] {
                "17", new Integer(6)
            }, new Object[] {
                "20", new Integer(2)
            }, new Object[] {
                "21", a, new Integer(20)
            }, new Object[] {
                "22", a, new Integer(29)
            }, new Object[] {
                "30", a, new Integer(8)
            }, new Object[] {
                "37", a, new Integer(8)
            }, new Object[] {
                "90", a, new Integer(30)
            }, new Object[] {
                "91", a, new Integer(30)
            }, new Object[] {
                "92", a, new Integer(30)
            }, new Object[] {
                "93", a, new Integer(30)
            }, new Object[] {
                "94", a, new Integer(30)
            }, new Object[] {
                "95", a, new Integer(30)
            }, new Object[] {
                "96", a, new Integer(30)
            }, new Object[] {
                "97", a, new Integer(30)
            }, new Object[] {
                "98", a, new Integer(30)
            }, new Object[] {
                "99", a, new Integer(30)
            }
        });
        Object aobj[] = {
            "240", a, new Integer(30)
        };
        Object aobj1[] = {
            "241", a, new Integer(30)
        };
        Object aobj2[] = {
            "242", a, new Integer(6)
        };
        Object aobj3[] = {
            "250", a, new Integer(30)
        };
        Object aobj4[] = {
            "251", a, new Integer(30)
        };
        Object aobj5[] = {
            "253", a, new Integer(17)
        };
        Object aobj6[] = {
            "254", a, new Integer(20)
        };
        Object aobj7[] = {
            "400", a, new Integer(30)
        };
        Object aobj8[] = {
            "401", a, new Integer(30)
        };
        Object aobj9[] = {
            "402", new Integer(17)
        };
        Object aobj10[] = {
            "403", a, new Integer(30)
        };
        Object aobj11[] = {
            "410", new Integer(13)
        };
        Object aobj12[] = {
            "411", new Integer(13)
        };
        Object aobj13[] = {
            "412", new Integer(13)
        };
        Object aobj14[] = {
            "413", new Integer(13)
        };
        Object aobj15[] = {
            "414", new Integer(13)
        };
        Object aobj16[] = {
            "420", a, new Integer(20)
        };
        Object obj = a;
        Object obj1 = new Integer(15);
        Integer integer = new Integer(3);
        Object aobj17[] = {
            "423", a, new Integer(15)
        };
        Object aobj18[] = {
            "424", new Integer(3)
        };
        Integer integer1 = new Integer(3);
        Object aobj19[] = {
            "426", new Integer(3)
        };
        c = (new Object[][] {
            aobj, aobj1, aobj2, aobj3, aobj4, aobj5, aobj6, aobj7, aobj8, aobj9, 
            aobj10, aobj11, aobj12, aobj13, aobj14, aobj15, aobj16, new Object[] {
                "421", obj, obj1
            }, new Object[] {
                "422", integer
            }, aobj17, 
            aobj18, new Object[] {
                "425", integer1
            }, aobj19
        });
        d = (new Object[][] {
            new Object[] {
                "310", new Integer(6)
            }, new Object[] {
                "311", new Integer(6)
            }, new Object[] {
                "312", new Integer(6)
            }, new Object[] {
                "313", new Integer(6)
            }, new Object[] {
                "314", new Integer(6)
            }, new Object[] {
                "315", new Integer(6)
            }, new Object[] {
                "316", new Integer(6)
            }, new Object[] {
                "320", new Integer(6)
            }, new Object[] {
                "321", new Integer(6)
            }, new Object[] {
                "322", new Integer(6)
            }, new Object[] {
                "323", new Integer(6)
            }, new Object[] {
                "324", new Integer(6)
            }, new Object[] {
                "325", new Integer(6)
            }, new Object[] {
                "326", new Integer(6)
            }, new Object[] {
                "327", new Integer(6)
            }, new Object[] {
                "328", new Integer(6)
            }, new Object[] {
                "329", new Integer(6)
            }, new Object[] {
                "330", new Integer(6)
            }, new Object[] {
                "331", new Integer(6)
            }, new Object[] {
                "332", new Integer(6)
            }, new Object[] {
                "333", new Integer(6)
            }, new Object[] {
                "334", new Integer(6)
            }, new Object[] {
                "335", new Integer(6)
            }, new Object[] {
                "336", new Integer(6)
            }, new Object[] {
                "340", new Integer(6)
            }, new Object[] {
                "341", new Integer(6)
            }, new Object[] {
                "342", new Integer(6)
            }, new Object[] {
                "343", new Integer(6)
            }, new Object[] {
                "344", new Integer(6)
            }, new Object[] {
                "345", new Integer(6)
            }, new Object[] {
                "346", new Integer(6)
            }, new Object[] {
                "347", new Integer(6)
            }, new Object[] {
                "348", new Integer(6)
            }, new Object[] {
                "349", new Integer(6)
            }, new Object[] {
                "350", new Integer(6)
            }, new Object[] {
                "351", new Integer(6)
            }, new Object[] {
                "352", new Integer(6)
            }, new Object[] {
                "353", new Integer(6)
            }, new Object[] {
                "354", new Integer(6)
            }, new Object[] {
                "355", new Integer(6)
            }, new Object[] {
                "356", new Integer(6)
            }, new Object[] {
                "357", new Integer(6)
            }, new Object[] {
                "360", new Integer(6)
            }, new Object[] {
                "361", new Integer(6)
            }, new Object[] {
                "362", new Integer(6)
            }, new Object[] {
                "363", new Integer(6)
            }, new Object[] {
                "364", new Integer(6)
            }, new Object[] {
                "365", new Integer(6)
            }, new Object[] {
                "366", new Integer(6)
            }, new Object[] {
                "367", new Integer(6)
            }, new Object[] {
                "368", new Integer(6)
            }, new Object[] {
                "369", new Integer(6)
            }, new Object[] {
                "390", a, new Integer(15)
            }, new Object[] {
                "391", a, new Integer(18)
            }, new Object[] {
                "392", a, new Integer(15)
            }, new Object[] {
                "393", a, new Integer(18)
            }, new Object[] {
                "703", a, new Integer(30)
            }
        });
        obj = new Integer(13);
        obj1 = a;
        integer = new Integer(30);
        integer1 = new Integer(10);
        Integer integer2 = new Integer(14);
        Object obj2 = a;
        Integer integer3 = new Integer(20);
        aobj17 = (new Object[] {
            "8003", a, new Integer(30)
        });
        Object obj3 = a;
        Integer integer4 = new Integer(30);
        aobj18 = (new Object[] {
            "8005", new Integer(6)
        });
        aobj19 = (new Object[] {
            "8006", new Integer(18)
        });
        Object obj4 = a;
        Integer integer5 = new Integer(30);
        Object obj5 = a;
        Integer integer6 = new Integer(12);
        Integer integer7 = new Integer(18);
        Object obj6 = a;
        Integer integer8 = new Integer(25);
        Integer integer9 = new Integer(6);
        Integer integer10 = new Integer(10);
        Integer integer11 = new Integer(2);
        Object obj7 = a;
        Integer integer12 = new Integer(30);
        e = (new Object[][] {
            new Object[] {
                "7001", obj
            }, new Object[] {
                "7002", obj1, integer
            }, new Object[] {
                "7003", integer1
            }, new Object[] {
                "8001", integer2
            }, new Object[] {
                "8002", obj2, integer3
            }, aobj17, new Object[] {
                "8004", obj3, integer4
            }, aobj18, aobj19, new Object[] {
                "8007", obj4, integer5
            }, new Object[] {
                "8008", obj5, integer6
            }, new Object[] {
                "8018", integer7
            }, new Object[] {
                "8020", obj6, integer8
            }, new Object[] {
                "8100", integer9
            }, new Object[] {
                "8101", integer10
            }, new Object[] {
                "8102", integer11
            }, new Object[] {
                "8110", obj7, integer12
            }
        });
    }
}
