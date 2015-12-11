// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.i.c;

import com.google.a.a.e;
import com.target.mothership.common.product.a;
import com.target.mothership.common.product.f;
import com.target.mothership.common.product.n;
import com.target.mothership.model.product.interfaces.ProductCallout;
import com.target.mothership.model.product.interfaces.ProductCartWheel;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.mothership.model.product.interfaces.ProductEyeBrow;
import com.target.mothership.model.product.interfaces.ProductOnlineInfo;
import com.target.mothership.model.product.interfaces.ProductPrice;
import com.target.mothership.model.product.interfaces.ProductPriceInfo;
import com.target.mothership.model.product.interfaces.ProductPriceRange;
import com.target.mothership.model.product.interfaces.ProductStoreInfo;
import com.target.mothership.util.o;
import com.target.ui.common.b;
import com.target.ui.util.q;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

public class c
{
    public static final class a extends Enum
    {

        private static final a $VALUES[];
        public static final a REGULAR;
        public static final a SHORT;

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/ui/i/c/c$a, s);
        }

        public static a[] values()
        {
            return (a[])$VALUES.clone();
        }

        static 
        {
            REGULAR = new a("REGULAR", 0);
            SHORT = new a("SHORT", 1);
            $VALUES = (new a[] {
                REGULAR, SHORT
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }

    private static class b
    {

        private boolean isStorePrice;
        private String priceDisplayText;

        static String a(b b1, String s)
        {
            b1.priceDisplayText = s;
            return s;
        }

        public String a()
        {
            return priceDisplayText;
        }

        public void a(String s)
        {
            priceDisplayText = s;
        }

        public void a(boolean flag)
        {
            isStorePrice = flag;
        }

        public boolean b()
        {
            return isStorePrice;
        }

        b()
        {
            priceDisplayText = "";
            isStorePrice = true;
        }
    }


    private static final String CARTWHEEL = "cartwheel";
    private static final String LOW_PRICE_IN_CART = "low price in cart";
    private static final int MAX_EYE_BROW_COUNT = 2;
    private static final String PRICE_FORMAT = "$%s";
    private static final String PRICE_NOT_AVAILABLE = "price not available";
    private static final String PRICE_RANGE_FORMAT = "$%s-$%s";
    private static final String PRICE_RANGE_SHORT_FORMAT = "$%s and up";
    private static final String PRICE_VARY_BY_STORE = "prices vary by store";
    private static final String TAG = com/target/ui/i/c/c.getSimpleName();
    private static final String TEMP_PRICE_CUT = "temp price cut";

    public c()
    {
    }

    public static com.target.ui.common.b a(ProductDetails productdetails, boolean flag, a a1, String s)
    {
        com.target.ui.common.b b1 = new com.target.ui.common.b();
        if (productdetails == null)
        {
            b1.a("price not available");
            b1.a(true);
            return b1;
        }
        if (b(productdetails, flag))
        {
            b1.a("low price in cart");
            b1.a(true);
            return b1;
        }
        if (o.g(s))
        {
            b1.a(s);
            b1.a(true);
            b1.b(false);
        } else
        {
            a1 = a(productdetails, flag, a1);
            s = c(productdetails, flag);
            b1.a(a1.a());
            b1.a(o.g(a1.a()));
            b1.e(a1.b());
            b1.b(o.g(s.a()));
            b1.b(s.a());
        }
        a1 = a(productdetails);
        b1.d(o.g(a1));
        b1.d(a1);
        if (b(productdetails))
        {
            b1.c(true);
            b1.c(a(productdetails.x()));
            return b1;
        } else
        {
            productdetails = c(productdetails);
            b1.c(o.g(productdetails));
            b1.c(productdetails);
            return b1;
        }
    }

    private static b a(ProductDetails productdetails, boolean flag, a a1)
    {
        b b1;
        b1 = new b();
        if (productdetails == null)
        {
            return b1;
        }
        if (productdetails.i().equals(com.target.mothership.common.product.c.UNKNOWN))
        {
            com.target.ui.i.c.b.a(b1, "price not available");
            return b1;
        }
        if (a(productdetails, flag))
        {
            productdetails = productdetails.u();
            b1.a(true);
        } else
        {
            productdetails = productdetails.c();
            b1.a(false);
        }
        if (productdetails.i() == null)
        {
            q.a(TAG, "Price type is null -- could be bad data");
            com.target.ui.i.c.b.a(b1, "prices vary by store");
            return b1;
        }
        static class _cls1
        {

            static final int $SwitchMap$com$target$mothership$common$product$EyebrowType[];
            static final int $SwitchMap$com$target$mothership$common$product$PriceType[];
            static final int $SwitchMap$com$target$ui$rules$product$ProductPriceRules$PriceDisplayLength[];

            static 
            {
                $SwitchMap$com$target$mothership$common$product$EyebrowType = new int[f.values().length];
                try
                {
                    $SwitchMap$com$target$mothership$common$product$EyebrowType[f.TEMPORARY_PRICE_CUT.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$EyebrowType[f.PRICE_CUT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$EyebrowType[f.SALE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$EyebrowType[f.CLEARANCE.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                $SwitchMap$com$target$ui$rules$product$ProductPriceRules$PriceDisplayLength = new int[a.values().length];
                try
                {
                    $SwitchMap$com$target$ui$rules$product$ProductPriceRules$PriceDisplayLength[a.SHORT.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$target$ui$rules$product$ProductPriceRules$PriceDisplayLength[a.REGULAR.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                $SwitchMap$com$target$mothership$common$product$PriceType = new int[n.values().length];
                try
                {
                    $SwitchMap$com$target$mothership$common$product$PriceType[n.SINGLE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$PriceType[n.RANGE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$PriceType[n.UNKNOWN.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.target.mothership.common.product.PriceType[productdetails.i().ordinal()];
        JVM INSTR tableswitch 1 2: default 136
    //                   1 146
    //                   2 154;
           goto _L1 _L2 _L3
_L1:
        productdetails = "prices vary by store";
_L5:
        b1.a(productdetails);
        return b1;
_L2:
        productdetails = a(((ProductPriceInfo) (productdetails)));
        continue; /* Loop/switch isn't completed */
_L3:
        productdetails = a(((ProductPriceInfo) (productdetails)), a1);
        if (true) goto _L5; else goto _L4
_L4:
    }

    private static String a(ProductDetails productdetails)
    {
        StringBuilder stringbuilder = new StringBuilder("");
        productdetails = productdetails.n().iterator();
        do
        {
            if (!productdetails.hasNext())
            {
                break;
            }
            if (!((ProductCartWheel)productdetails.next()).a())
            {
                continue;
            }
            stringbuilder.append("cartwheel");
            break;
        } while (true);
        return stringbuilder.toString().trim();
    }

    private static String a(ProductPriceInfo productpriceinfo)
    {
        boolean flag;
        if (productpriceinfo.j().b() && ((ProductPrice)productpriceinfo.j().c()).b().b())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            return a(((BigDecimal)((ProductPrice)productpriceinfo.j().c()).b().c()).toString());
        } else
        {
            return "";
        }
    }

    private static String a(ProductPriceInfo productpriceinfo, a a1)
    {
        if (!productpriceinfo.k().b())
        {
            return "price not available";
        }
        BigDecimal bigdecimal;
        if (((ProductPriceRange)productpriceinfo.k().c()).b().b())
        {
            bigdecimal = (BigDecimal)((ProductPriceRange)productpriceinfo.k().c()).b().c();
        } else
        {
            bigdecimal = null;
        }
        if (((ProductPriceRange)productpriceinfo.k().c()).c().b())
        {
            productpriceinfo = (BigDecimal)((ProductPriceRange)productpriceinfo.k().c()).c().c();
        } else
        {
            productpriceinfo = null;
        }
        switch (_cls1..SwitchMap.com.target.ui.rules.product.ProductPriceRules.PriceDisplayLength[a1.ordinal()])
        {
        default:
            return "";

        case 1: // '\001'
            if (bigdecimal == null)
            {
                return "price not available";
            } else
            {
                return b(bigdecimal.toString());
            }

        case 2: // '\002'
            break;
        }
        if (bigdecimal == null || productpriceinfo == null)
        {
            return "price not available";
        } else
        {
            return a(bigdecimal.toString(), productpriceinfo.toString());
        }
    }

    private static String a(String s)
    {
        return String.format("$%s", new Object[] {
            s
        });
    }

    private static String a(String s, String s1)
    {
        return String.format("$%s-$%s", new Object[] {
            s, s1
        });
    }

    private static String a(List list)
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (list = list.iterator(); list.hasNext(); stringbuilder.append(" "))
        {
            stringbuilder.append(((ProductCallout)list.next()).b());
        }

        return stringbuilder.toString().trim();
    }

    private static boolean a(ProductDetails productdetails, boolean flag)
    {
        ProductOnlineInfo productonlineinfo = productdetails.c();
        boolean flag5 = productonlineinfo.a();
        boolean flag1;
        boolean flag2;
        if (flag5 && productonlineinfo.j().b() && ((ProductPrice)productonlineinfo.j().c()).b().b())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag5 && productonlineinfo.k().b() && ((ProductPriceRange)productonlineinfo.k().c()).b().b())
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (!flag && (flag1 || flag2))
        {
            return false;
        }
        if (productdetails.i().equals(com.target.mothership.common.product.c.ONLINE_ONLY))
        {
            return false;
        }
        productdetails = productdetails.u();
        flag = productdetails.a();
        boolean flag3;
        boolean flag4;
        if (flag && productdetails.j().b() && ((ProductPrice)productdetails.j().c()).b().b())
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        if (flag && productdetails.k().b() && ((ProductPriceRange)productdetails.k().c()).b().b())
        {
            flag4 = true;
        } else
        {
            flag4 = false;
        }
        return !flag1 && !flag2 || flag3 || flag4;
    }

    private static String b(ProductPriceInfo productpriceinfo)
    {
        boolean flag2 = productpriceinfo.k().b();
        boolean flag;
        boolean flag1;
        if (flag2 && ((ProductPriceRange)productpriceinfo.k().c()).b().b())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag2 && ((ProductPriceRange)productpriceinfo.k().c()).a().b())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag && flag1)
        {
            BigDecimal bigdecimal = (BigDecimal)((ProductPriceRange)productpriceinfo.k().c()).b().c();
            productpriceinfo = (BigDecimal)((ProductPriceRange)productpriceinfo.k().c()).a().c();
            if (!bigdecimal.equals(productpriceinfo))
            {
                return a(productpriceinfo.toString());
            }
        }
        return "";
    }

    private static String b(String s)
    {
        return String.format("$%s and up", new Object[] {
            s
        });
    }

    private static boolean b(ProductDetails productdetails)
    {
        productdetails = productdetails.x().iterator();
        boolean flag;
        for (flag = false; productdetails.hasNext(); flag = true)
        {
            ProductCallout productcallout = (ProductCallout)productdetails.next();
            if (productcallout.a().equals(com.target.mothership.common.product.a.ONLY_AT_TARGET) || productcallout.a().equals(com.target.mothership.common.product.a.NEW_AT_TARGET))
            {
                return false;
            }
        }

        return flag;
    }

    private static boolean b(ProductDetails productdetails, boolean flag)
    {
        if (flag && productdetails.i().equals(com.target.mothership.common.product.c.STORE_ONLY))
        {
            return false;
        } else
        {
            return productdetails.c().b();
        }
    }

    private static b c(ProductDetails productdetails, boolean flag)
    {
        Object obj;
        b b1;
        boolean flag1;
        flag1 = false;
        b1 = new b();
        if (a(productdetails, flag))
        {
            obj = productdetails.u();
            b1.a(true);
        } else
        {
            obj = productdetails.c();
            b1.a(false);
        }
        if (((ProductPriceInfo) (obj)).i() == null)
        {
            q.a(TAG, "Price type is null -- could be bad data");
            return b1;
        }
        _cls1..SwitchMap.com.target.mothership.common.product.PriceType[((ProductPriceInfo) (obj)).i().ordinal()];
        JVM INSTR tableswitch 1 2: default 100
    //                   1 115
    //                   2 200;
           goto _L1 _L2 _L3
_L1:
        boolean flag2 = false;
_L5:
        if (!flag2 || !flag1)
        {
            return b1;
        }
        break; /* Loop/switch isn't completed */
_L2:
        flag = ((ProductPriceInfo) (obj)).j().b();
        if (flag && ((ProductPrice)((ProductPriceInfo) (obj)).j().c()).a().b())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag && ((ProductPrice)((ProductPriceInfo) (obj)).j().c()).b().b())
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (true) goto _L5; else goto _L4
_L3:
        return b1;
_L4:
        if (((BigDecimal)((ProductPrice)((ProductPriceInfo) (obj)).j().c()).a().c()).equals(((ProductPrice)((ProductPriceInfo) (obj)).j().c()).b().c()))
        {
            return b1;
        }
        if (productdetails.I() || !productdetails.A().isEmpty())
        {
            return b1;
        }
        _cls1..SwitchMap.com.target.mothership.common.product.PriceType[((ProductPriceInfo) (obj)).i().ordinal()];
        JVM INSTR tableswitch 1 2: default 312
    //                   1 330
    //                   2 322;
           goto _L6 _L7 _L8
_L6:
        productdetails = "";
_L10:
        b1.a(productdetails);
        return b1;
_L8:
        productdetails = b(((ProductPriceInfo) (obj)));
        continue; /* Loop/switch isn't completed */
_L7:
        productdetails = c(((ProductPriceInfo) (obj)));
        if (true) goto _L10; else goto _L9
_L9:
    }

    private static String c(ProductDetails productdetails)
    {
        StringBuilder stringbuilder;
        int i;
        if (productdetails == null || !productdetails.c().a())
        {
            return "";
        }
        stringbuilder = new StringBuilder();
        productdetails = productdetails.c().g().iterator();
        i = 0;
_L2:
        ProductEyeBrow producteyebrow;
label0:
        {
            if (productdetails.hasNext())
            {
                producteyebrow = (ProductEyeBrow)productdetails.next();
                if (i <= 2)
                {
                    break label0;
                }
            }
            return stringbuilder.toString().trim();
        }
        switch (_cls1..SwitchMap.com.target.mothership.common.product.EyebrowType[producteyebrow.a().ordinal()])
        {
        default:
            break;

        case 1: // '\001'
            break; /* Loop/switch isn't completed */

        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
            break;
        }
        break MISSING_BLOCK_LABEL_149;
_L3:
        stringbuilder.append(" ");
        if (true) goto _L2; else goto _L1
_L1:
        i++;
        stringbuilder.append("temp price cut");
          goto _L3
        i++;
        stringbuilder.append(producteyebrow.b());
          goto _L3
    }

    private static String c(ProductPriceInfo productpriceinfo)
    {
        boolean flag;
        if (productpriceinfo.j().b() && ((ProductPrice)productpriceinfo.j().c()).a().b())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            return a(((BigDecimal)((ProductPrice)productpriceinfo.j().c()).a().c()).toString());
        } else
        {
            return "";
        }
    }

}
