// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.mybby;

import android.content.Context;
import gs;
import gv;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Transaction
    implements Serializable
{

    private static final String TAG = com/bestbuy/android/api/lib/models/mybby/Transaction.getSimpleName();
    private String adjustmentCode;
    private String ccStatementDate;
    private String code;
    private Date date;
    private String description;
    private String eligibleRevenue;
    private boolean isVisible;
    private ArrayList lineItems;
    private String location;
    private String memberVisitNumber;
    private String name;
    private String offerCode;
    private boolean pending;
    private String points;
    private String sourceCode;
    private String sourceTranKey;
    private String storeID;
    private String storeLocation;
    private String subClubCode;
    private String totalRevenue;
    private String totalTax;
    private String tranNumber;
    private String transactionID;
    private String type;

    public Transaction()
    {
    }

    public static Transaction loadData(JSONObject jsonobject)
    {
        Transaction transaction;
        transaction = new Transaction();
        transaction.transactionID = jsonobject.optString("id");
        transaction.code = jsonobject.optString("code");
        transaction.type = jsonobject.optString("type");
        transaction.description = jsonobject.optString("description");
        transaction.memberVisitNumber = jsonobject.optString("memberVisitNumber");
        TransactionLineItem transactionlineitem;
        int i;
        try
        {
            transaction.date = gv.a.parse(jsonobject.getString("date"));
        }
        catch (Exception exception)
        {
            gs.e(TAG, (new StringBuilder()).append("Could not parse date(Skipping): ").append(exception.getLocalizedMessage()).toString());
        }
        transaction.location = jsonobject.optString("location");
        transaction.setStoreID(transaction.location);
        transaction.offerCode = jsonobject.optString("offerCode");
        transaction.points = jsonobject.optString("points");
        transaction.sourceTranKey = jsonobject.optString("sourceTranKey");
        transaction.adjustmentCode = jsonobject.optString("adjustmentCode");
        transaction.subClubCode = jsonobject.optString("subClubCode");
        transaction.eligibleRevenue = jsonobject.optString("eligibleRevenue");
        transaction.totalRevenue = jsonobject.optString("totalRevenue");
        transaction.totalTax = jsonobject.optString("totalTax");
        transaction.ccStatementDate = jsonobject.optString("ccStatementDate");
        transaction.tranNumber = jsonobject.optString("tranNumber");
        transaction.sourceCode = jsonobject.optString("sourceCode");
        transaction.isVisible = false;
        transaction.pending = jsonobject.optBoolean("pending");
        transaction.lineItems = new ArrayList();
        jsonobject = jsonobject.getJSONObject("details").getJSONArray("detail");
        i = 0;
_L1:
        if (i >= jsonobject.length())
        {
            break MISSING_BLOCK_LABEL_340;
        }
        transactionlineitem = TransactionLineItem.loadData(jsonobject.getJSONObject(i));
        if (transactionlineitem == null)
        {
            break MISSING_BLOCK_LABEL_272;
        }
        transaction.lineItems.add(transactionlineitem);
        i++;
          goto _L1
        jsonobject;
        gs.e(TAG, (new StringBuilder()).append("Cannot create JSONArray from transaction details (Skipping): ").append(jsonobject.getLocalizedMessage()).toString());
        return transaction;
    }

    public void clicked(Context context, String s)
    {
    }

    public String getAdjustmentCode()
    {
        return adjustmentCode;
    }

    public String getCcStatementDate()
    {
        return ccStatementDate;
    }

    public String getCode()
    {
        return code;
    }

    public Date getDate()
    {
        return date;
    }

    public String getDescription()
    {
        return description;
    }

    public String getEligibleRevenue()
    {
        return eligibleRevenue;
    }

    public ArrayList getLineItems()
    {
        return lineItems;
    }

    public String getLocation()
    {
        return location;
    }

    public String getMemberVisitNumber()
    {
        return memberVisitNumber;
    }

    public String getName()
    {
        return name;
    }

    public String getOfferCode()
    {
        return offerCode;
    }

    public String getPoints()
    {
        return points;
    }

    public ArrayList getSaleLineItems()
    {
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < lineItems.size(); i++)
        {
            if (!((TransactionLineItem)lineItems.get(i)).getProductSku().contains("RZ CARD"))
            {
                arraylist.add(lineItems.get(i));
            }
        }

        return arraylist;
    }

    public String getSourceCode()
    {
        return sourceCode;
    }

    public String getSourceTranKey()
    {
        return sourceTranKey;
    }

    public String getStoreID()
    {
        return storeID;
    }

    public String getStoreLocation()
    {
        return storeLocation;
    }

    public String getSubClubCode()
    {
        return subClubCode;
    }

    public String getTotalRevenue()
    {
        return totalRevenue;
    }

    public String getTotalTax()
    {
        return totalTax;
    }

    public String getTranNumber()
    {
        return tranNumber;
    }

    public String getTransactionID()
    {
        return transactionID;
    }

    public String getType()
    {
        return type;
    }

    public boolean isPending()
    {
        return pending;
    }

    public boolean isVisible()
    {
        return isVisible;
    }

    public void setName()
    {
        SimpleDateFormat simpledateformat = new SimpleDateFormat("MM/dd/yy", Locale.US);
        ArrayList arraylist = getSaleLineItems();
        name = (new StringBuilder()).append(simpledateformat.format(getDate())).append(" RECEIPT ").append(" - ").append(arraylist.size()).toString();
        if (arraylist.size() == 1)
        {
            name = (new StringBuilder()).append(name).append(" item").toString();
            return;
        }
        try
        {
            name = (new StringBuilder()).append(name).append(" items").toString();
            return;
        }
        catch (Exception exception)
        {
            gs.e(TAG, exception.getMessage());
        }
        return;
    }

    public void setStoreID(String s)
    {
        try
        {
            storeID = (new StringBuilder()).append(Integer.parseInt(s.substring(s.indexOf("STORE #") + 7, s.length() - 1))).append("").toString();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            gs.e(TAG, s.getMessage());
        }
    }


    private class TransactionLineItem
    {

        private String amount;
        private String description;
        private boolean eligible;
        private String lineNumber;
        private String prodCategory;
        private String prodThumbImgURL;
        private String productModelId;
        private String productSku;
        private String quantity;

        private static TransactionLineItem loadData(JSONObject jsonobject)
        {
            TransactionLineItem transactionlineitem = new TransactionLineItem();
            transactionlineitem.productSku = jsonobject.optString("productSku");
            transactionlineitem.amount = jsonobject.optString("amount");
            if (transactionlineitem.amount != null && !transactionlineitem.amount.equalsIgnoreCase("0"))
            {
                transactionlineitem.lineNumber = jsonobject.optString("lineNumber");
                transactionlineitem.description = jsonobject.optString("description");
                transactionlineitem.quantity = jsonobject.optString("quantity");
                transactionlineitem.prodCategory = "";
                transactionlineitem.prodThumbImgURL = "";
                transactionlineitem.eligible = jsonobject.optBoolean("eligible");
                return transactionlineitem;
            } else
            {
                return null;
            }
        }

        public String getAmount()
        {
            return amount;
        }

        public String getDescription()
        {
            return description;
        }

        public String getLineNumber()
        {
            return lineNumber;
        }

        public String getProdCategory()
        {
            return prodCategory;
        }

        public String getProdThumbImgURL()
        {
            return prodThumbImgURL;
        }

        public String getProductModelId()
        {
            return productModelId;
        }

        public String getProductSku()
        {
            return productSku;
        }

        public String getQuantity()
        {
            return quantity;
        }

        public boolean isEligible()
        {
            return eligible;
        }


        public TransactionLineItem()
        {
        }
    }

}
