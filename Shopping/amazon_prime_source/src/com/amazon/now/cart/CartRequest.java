// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.cart;


public class CartRequest
{
    protected static final class CartAction extends Enum
    {

        private static final CartAction $VALUES[];
        public static final CartAction ADD;
        public static final CartAction GET;
        public static final CartAction REMOVE;
        public static final CartAction UPDATE;

        public static CartAction valueOf(String s)
        {
            return (CartAction)Enum.valueOf(com/amazon/now/cart/CartRequest$CartAction, s);
        }

        public static CartAction[] values()
        {
            return (CartAction[])$VALUES.clone();
        }

        static 
        {
            ADD = new CartAction("ADD", 0);
            REMOVE = new CartAction("REMOVE", 1);
            UPDATE = new CartAction("UPDATE", 2);
            GET = new CartAction("GET", 3);
            $VALUES = (new CartAction[] {
                ADD, REMOVE, UPDATE, GET
            });
        }

        private CartAction(String s, int i)
        {
            super(s, i);
        }
    }


    private final int mActionQuantity;
    private final String mAsin;
    private final CartAction mCartAction;
    private final String mItemId;
    private final String mMerchantId;
    private final String mOfferId;
    private final String mRequestUrl;

    public CartRequest(CartAction cartaction, String s)
    {
        this(cartaction, s, null, null, null, null, -1);
    }

    public CartRequest(CartAction cartaction, String s, String s1)
    {
        this(cartaction, s, null, null, null, s1, -1);
    }

    public CartRequest(CartAction cartaction, String s, String s1, int i)
    {
        this(cartaction, s, null, null, null, s1, i);
    }

    public CartRequest(CartAction cartaction, String s, String s1, String s2, String s3)
    {
        this(cartaction, s, s1, s2, s3, null, -1);
    }

    private CartRequest(CartAction cartaction, String s, String s1, String s2, String s3, String s4, int i)
    {
        mRequestUrl = s;
        mCartAction = cartaction;
        mAsin = s1;
        mOfferId = s2;
        mMerchantId = s3;
        mItemId = s4;
        mActionQuantity = i;
    }

    public int getActionQuantity()
    {
        return mActionQuantity;
    }

    public String getAsin()
    {
        return mAsin;
    }

    public CartAction getCartAction()
    {
        return mCartAction;
    }

    public String getItemId()
    {
        return mItemId;
    }

    public String getMerchantId()
    {
        return mMerchantId;
    }

    public String getOfferId()
    {
        return mOfferId;
    }

    public String getRequestUrl()
    {
        return mRequestUrl;
    }
}
