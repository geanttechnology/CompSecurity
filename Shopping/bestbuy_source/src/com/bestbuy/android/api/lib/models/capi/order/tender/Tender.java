// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.capi.order.tender;

import java.util.ArrayList;
import java.util.Iterator;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

// Referenced classes of package com.bestbuy.android.api.lib.models.capi.order.tender:
//            RewardZoneTender, PromoTender, GiftCardTender, CreditCardTender

public class Tender
{

    private static CreditCardTender cc;
    private static ArrayList giftCards;
    private static ArrayList promoCodes;
    private static ArrayList rzCerts;

    public Tender()
    {
    }

    public static CreditCardTender getCc()
    {
        return cc;
    }

    public static ArrayList getGiftCards()
    {
        return giftCards;
    }

    public static ArrayList getPromoCodes()
    {
        return promoCodes;
    }

    public static ArrayList getRzCerts()
    {
        return rzCerts;
    }

    public static String getXML(Tender tender)
    {
        Object obj;
        obj = "<tender>";
        if (rzCerts != null)
        {
            tender = (new StringBuilder()).append("<tender>").append("<rewardcerts>").toString();
            for (obj = rzCerts.iterator(); ((Iterator) (obj)).hasNext();)
            {
                RewardZoneTender rewardzonetender = (RewardZoneTender)((Iterator) (obj)).next();
                tender = (new StringBuilder()).append(tender).append(rewardzonetender.getXML()).toString();
            }

            obj = (new StringBuilder()).append(tender).append("</rewardcerts>").toString();
        }
        tender = ((Tender) (obj));
        if (promoCodes != null)
        {
            tender = (new StringBuilder()).append(((String) (obj))).append("<promotionalcodes>").toString();
            for (obj = promoCodes.iterator(); ((Iterator) (obj)).hasNext();)
            {
                PromoTender promotender = (PromoTender)((Iterator) (obj)).next();
                tender = (new StringBuilder()).append(tender).append(promotender.getXML()).toString();
            }

            tender = (new StringBuilder()).append(tender).append("</promotionalcodes>").toString();
        }
        obj = tender;
        if (giftCards != null)
        {
            tender = (new StringBuilder()).append(tender).append("<giftcards>").toString();
            for (obj = giftCards.iterator(); ((Iterator) (obj)).hasNext();)
            {
                GiftCardTender giftcardtender = (GiftCardTender)((Iterator) (obj)).next();
                tender = (new StringBuilder()).append(tender).append(giftcardtender.getXML()).toString();
            }

            obj = (new StringBuilder()).append(tender).append("</giftcards>").toString();
        }
        tender = ((Tender) (obj));
        if (cc == null) goto _L2; else goto _L1
_L1:
        if (cc.ccNumber == null) goto _L4; else goto _L3
_L3:
        tender = (new StringBuilder()).append(((String) (obj))).append("<cc-tender>").toString();
        tender = (new StringBuilder()).append(tender).append(cc.getXML()).toString();
        tender = (new StringBuilder()).append(tender).append("</cc-tender>").toString();
_L2:
        return (new StringBuilder()).append(tender).append("</tender>").toString();
_L4:
        tender = ((Tender) (obj));
        if (cc.getCid() != null)
        {
            tender = (new StringBuilder()).append(((String) (obj))).append(cc.getXML()).toString();
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public static Tender loadData(CreditCardTender creditcardtender)
    {
        Tender tender = new Tender();
        cc = creditcardtender;
        return tender;
    }

    public static Tender loadData(ArrayList arraylist, ArrayList arraylist1, ArrayList arraylist2, CreditCardTender creditcardtender)
    {
        Tender tender = new Tender();
        rzCerts = arraylist;
        promoCodes = arraylist1;
        giftCards = arraylist2;
        cc = creditcardtender;
        return tender;
    }

    public static Tender loadData(Node node)
    {
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag = false;
        Tender tender = new Tender();
        node = node.getChildNodes();
        int i = 0;
        do
        {
label0:
            {
                if (i < node.getLength())
                {
                    Node node1 = node.item(i);
                    if (node1.getNodeName().compareTo("rewardcerts") == 0)
                    {
                        rzCerts = new ArrayList();
                        node = node1.getChildNodes();
                        for (i = ((flag) ? 1 : 0); i < node.getLength(); i++)
                        {
                            node1 = node.item(i);
                            if (node1.getNodeName().compareTo("rwzcert") == 0)
                            {
                                rzCerts.add(RewardZoneTender.loadData(node1));
                            }
                        }

                    } else
                    if (node1.getNodeName().compareTo("promotionalcodes") == 0)
                    {
                        promoCodes = new ArrayList();
                        node = node1.getChildNodes();
                        for (i = ((flag1) ? 1 : 0); i < node.getLength(); i++)
                        {
                            node1 = node.item(i);
                            if (node1.getNodeName().compareTo("promotionalcode") == 0)
                            {
                                promoCodes.add(PromoTender.loadData(node1));
                            }
                        }

                    } else
                    if (node1.getNodeName().compareTo("giftcards") == 0)
                    {
                        giftCards = new ArrayList();
                        node = node1.getChildNodes();
                        for (i = ((flag2) ? 1 : 0); i < node.getLength(); i++)
                        {
                            node1 = node.item(i);
                            if (node1.getNodeName().compareTo("") == 0)
                            {
                                giftCards.add(GiftCardTender.loadData(node1));
                            }
                        }

                    } else
                    {
                        if (node1.getNodeName().compareTo("cc-tender") != 0)
                        {
                            break label0;
                        }
                        cc = CreditCardTender.loadData(node1);
                    }
                }
                return tender;
            }
            i++;
        } while (true);
    }
}
