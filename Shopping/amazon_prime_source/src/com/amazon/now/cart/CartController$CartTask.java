// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.cart;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.amazon.now.AmazonActivity;
import com.amazon.now.util.NetUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.nio.charset.Charset;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.now.cart:
//            CartController, CartRequest, CartResponse

private class mContext extends AsyncTask
{

    private ack mCallback;
    private Context mContext;
    final CartController this$0;

    private void displayProgressDialog(Context context)
    {
        if (context instanceof AmazonActivity)
        {
            ((AmazonActivity)context).showSpinner();
        }
    }

    protected transient CartResponse doInBackground(CartRequest acartrequest[])
    {
        CartRequest cartrequest;
        Object obj7;
        cartrequest = acartrequest[0];
        obj7 = cartrequest.getRequestUrl();
        if (!TextUtils.isEmpty(((CharSequence) (obj7)))) goto _L2; else goto _L1
_L1:
        acartrequest = null;
_L13:
        return acartrequest;
_L2:
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        Object obj4;
        JSONObject jsonobject;
        JSONArray jsonarray;
        Object obj5;
        Object obj6;
        obj5 = null;
        obj6 = null;
        acartrequest = null;
        jsonarray = null;
        obj2 = null;
        jsonobject = null;
        obj = acartrequest;
        obj1 = obj2;
        obj3 = obj5;
        obj4 = obj6;
        obj7 = NetUtil.getURLConnection(((String) (obj7)));
        obj = acartrequest;
        obj1 = obj2;
        obj3 = obj5;
        obj4 = obj6;
        ((URLConnection) (obj7)).setConnectTimeout(5000);
        obj = acartrequest;
        obj1 = obj2;
        obj3 = obj5;
        obj4 = obj6;
        acartrequest = ((URLConnection) (obj7)).getInputStream();
        obj = acartrequest;
        obj1 = obj2;
        obj3 = acartrequest;
        obj4 = acartrequest;
        obj2 = new BufferedReader(new InputStreamReader(acartrequest, Charset.forName("UTF-8")));
        obj = new StringBuilder();
_L5:
        obj1 = ((BufferedReader) (obj2)).readLine();
        if (obj1 == null) goto _L4; else goto _L3
_L3:
        ((StringBuilder) (obj)).append(((String) (obj1)).trim());
          goto _L5
        obj3;
_L26:
        obj = acartrequest;
        obj1 = obj2;
        Log.e(CartController.access$000(), ((IOException) (obj3)).toString(), ((Throwable) (obj3)));
        int i;
        boolean flag;
        if (acartrequest != null)
        {
            try
            {
                acartrequest.close();
            }
            // Misplaced declaration of an exception variable
            catch (CartRequest acartrequest[])
            {
                Log.e(CartController.access$000(), acartrequest.toString(), acartrequest);
            }
        }
        if (obj2 != null)
        {
            try
            {
                ((BufferedReader) (obj2)).close();
            }
            // Misplaced declaration of an exception variable
            catch (CartRequest acartrequest[])
            {
                Log.e(CartController.access$000(), acartrequest.toString(), acartrequest);
            }
        }
        return null;
_L4:
        jsonobject = new JSONObject(((StringBuilder) (obj)).toString());
        i = jsonobject.getJSONObject("cartSummary").getInt("totalQuantity");
        obj3 = new CartResponse();
        ((CartResponse) (obj3)).setCartAction(cartrequest.getCartAction());
        ((CartResponse) (obj3)).setCartCount(i);
        jsonarray = jsonobject.optJSONArray("activeItemList");
        CartController.access$202(CartController.this, jsonarray);
        obj4 = null;
        obj1 = null;
        flag = true;
        i = ((flag) ? 1 : 0);
        obj = obj4;
        if (jsonarray == null) goto _L7; else goto _L6
_L6:
        i = ((flag) ? 1 : 0);
        obj = obj4;
        if (jsonarray.length() <= 0) goto _L7; else goto _L8
_L8:
        if (TextUtils.isEmpty(cartrequest.getAsin()) || TextUtils.isEmpty(cartrequest.getMerchantId())) goto _L10; else goto _L9
_L9:
        obj = CartController.this;
        obj1 = cartrequest.getAsin();
        obj4 = cartrequest.getMerchantId();
        obj = CartController.access$300(((CartController) (obj)), jsonarray, new String[] {
            "ASIN", "merchantID"
        }, new String[] {
            obj1, obj4
        });
_L15:
        obj1 = obj;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_1037;
        }
        obj1 = obj;
        if (TextUtils.isEmpty(cartrequest.getAsin()))
        {
            break MISSING_BLOCK_LABEL_1037;
        }
        obj1 = obj;
        if (!TextUtils.isEmpty(cartrequest.getOfferId()))
        {
            obj = CartController.this;
            obj1 = cartrequest.getAsin();
            obj4 = cartrequest.getOfferId();
            obj1 = CartController.access$300(((CartController) (obj)), jsonarray, new String[] {
                "ASIN", "offerID"
            }, new String[] {
                obj1, obj4
            });
        }
        break MISSING_BLOCK_LABEL_1037;
_L7:
        obj1 = jsonobject.optJSONObject("cartErrors");
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_505;
        }
        obj1 = ((JSONObject) (obj1)).optString("actionErrorMessage");
        if (!TextUtils.isEmpty(((CharSequence) (obj1))))
        {
            ((CartResponse) (obj3)).setCartError(((String) (obj1)));
        }
        if (i != 0) goto _L12; else goto _L11
_L11:
        if (acartrequest != null)
        {
            try
            {
                acartrequest.close();
            }
            // Misplaced declaration of an exception variable
            catch (CartRequest acartrequest[])
            {
                Log.e(CartController.access$000(), acartrequest.toString(), acartrequest);
            }
        }
        acartrequest = ((CartRequest []) (obj3));
        if (obj2 != null)
        {
            try
            {
                ((BufferedReader) (obj2)).close();
            }
            // Misplaced declaration of an exception variable
            catch (CartRequest acartrequest[])
            {
                Log.e(CartController.access$000(), acartrequest.toString(), acartrequest);
                return ((CartResponse) (obj3));
            }
            return ((CartResponse) (obj3));
        }
          goto _L13
_L10:
        obj = obj1;
        if (TextUtils.isEmpty(cartrequest.getItemId())) goto _L15; else goto _L14
_L14:
        obj = CartController.this;
        obj1 = cartrequest.getItemId();
        obj = CartController.access$300(((CartController) (obj)), jsonarray, new String[] {
            "itemID"
        }, new String[] {
            obj1
        });
          goto _L15
_L12:
        if (cartrequest.getCartAction() != EMOVE && (cartrequest.getCartAction() != PDATE || cartrequest.getActionQuantity() != 0))
        {
            i = 0;
        } else
        {
            i = 1;
        }
        if (i == 0 || obj == null) goto _L17; else goto _L16
_L16:
        Log.e(CartController.access$000(), "Unexpected item found in the activeItemList.");
        ((CartResponse) (obj3)).setIsValid(false);
_L20:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_743;
        }
        obj1 = ((JSONObject) (obj)).optString("error");
        if (!TextUtils.isEmpty(((CharSequence) (obj1))))
        {
            ((CartResponse) (obj3)).setCartError(((String) (obj1)));
        }
        ((CartResponse) (obj3)).setItemId(((JSONObject) (obj)).optString("itemID"));
        ((CartResponse) (obj3)).setStockOnHand(((JSONObject) (obj)).optInt("stockOnHand", -1));
        i = ((JSONObject) (obj)).optInt("quantity", -1);
        if (i <= -1)
        {
            break MISSING_BLOCK_LABEL_743;
        }
        ((CartResponse) (obj3)).setItemCount(i);
        if (acartrequest != null)
        {
            try
            {
                acartrequest.close();
            }
            // Misplaced declaration of an exception variable
            catch (CartRequest acartrequest[])
            {
                Log.e(CartController.access$000(), acartrequest.toString(), acartrequest);
            }
        }
        acartrequest = ((CartRequest []) (obj3));
        if (obj2 == null) goto _L13; else goto _L18
_L18:
        try
        {
            ((BufferedReader) (obj2)).close();
        }
        // Misplaced declaration of an exception variable
        catch (CartRequest acartrequest[])
        {
            Log.e(CartController.access$000(), acartrequest.toString(), acartrequest);
            return ((CartResponse) (obj3));
        }
        return ((CartResponse) (obj3));
_L17:
        if (i != 0) goto _L20; else goto _L19
_L19:
        if (cartrequest.getCartAction() == ET || obj != null) goto _L20; else goto _L21
_L21:
        Log.e(CartController.access$000(), "Expected item not found in the activeItemList.");
        ((CartResponse) (obj3)).setIsValid(false);
          goto _L20
        obj4;
_L25:
        obj = acartrequest;
        obj1 = obj2;
        Log.e(CartController.access$000(), ((JSONException) (obj4)).toString(), ((Throwable) (obj4)));
        if (acartrequest != null)
        {
            try
            {
                acartrequest.close();
            }
            // Misplaced declaration of an exception variable
            catch (CartRequest acartrequest[])
            {
                Log.e(CartController.access$000(), acartrequest.toString(), acartrequest);
            }
        }
        if (obj2 != null)
        {
            try
            {
                ((BufferedReader) (obj2)).close();
            }
            // Misplaced declaration of an exception variable
            catch (CartRequest acartrequest[])
            {
                Log.e(CartController.access$000(), acartrequest.toString(), acartrequest);
            }
        }
        break MISSING_BLOCK_LABEL_203;
        acartrequest;
_L23:
        if (obj != null)
        {
            try
            {
                ((InputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                Log.e(CartController.access$000(), ((IOException) (obj)).toString(), ((Throwable) (obj)));
            }
        }
        if (obj1 != null)
        {
            try
            {
                ((BufferedReader) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                Log.e(CartController.access$000(), ((IOException) (obj)).toString(), ((Throwable) (obj)));
            }
        }
        throw acartrequest;
        obj3;
        obj1 = obj2;
        obj = acartrequest;
        acartrequest = ((CartRequest []) (obj3));
        if (true) goto _L23; else goto _L22
_L22:
        obj4;
        acartrequest = ((CartRequest []) (obj3));
        obj2 = jsonarray;
        if (true) goto _L25; else goto _L24
_L24:
        obj3;
        acartrequest = ((CartRequest []) (obj4));
        obj2 = jsonobject;
          goto _L26
        i = ((flag) ? 1 : 0);
        obj = obj1;
        if (obj1 == null)
        {
            i = 0;
            obj = obj1;
        }
          goto _L7
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((CartRequest[])aobj);
    }

    protected void onPostExecute(CartResponse cartresponse)
    {
        if (mContext instanceof AmazonActivity)
        {
            ((AmazonActivity)mContext).hideSpinner();
        }
        if (cartresponse != null) goto _L2; else goto _L1
_L1:
        if (mCallback != null)
        {
            mCallback.onFailure(null, null);
        }
_L4:
        return;
_L2:
        String s;
        int i;
        boolean flag;
        i = cartresponse.getCartCount();
        s = cartresponse.getError();
        if (i <= -1)
        {
            continue; /* Loop/switch isn't completed */
        }
        flag = cartresponse.isValid();
        switch (Map.com.amazon.now.cart.CartRequest.CartAction[cartresponse.getCartAction().rdinal()])
        {
        default:
            break;

        case 1: // '\001'
            break; /* Loop/switch isn't completed */

        case 2: // '\002'
            break;
        }
        break MISSING_BLOCK_LABEL_152;
_L5:
        if (!flag)
        {
            continue; /* Loop/switch isn't completed */
        }
        CartController.access$402(CartController.this, i);
        CartController.access$500(CartController.this);
        if (mCallback != null)
        {
            mCallback.onSuccess(cartresponse);
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (i <= CartController.access$400(CartController.this))
        {
            flag = false;
        }
          goto _L5
        if (i >= CartController.access$400(CartController.this))
        {
            flag = false;
        }
          goto _L5
        if (mCallback == null) goto _L4; else goto _L6
_L6:
        mCallback.onFailure(cartresponse, s);
        return;
        if (mCallback == null) goto _L4; else goto _L7
_L7:
        mCallback.onFailure(cartresponse, s);
        return;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((CartResponse)obj);
    }

    protected void onPreExecute()
    {
        displayProgressDialog(mContext);
    }

    public ack(ack ack, Context context)
    {
        this$0 = CartController.this;
        super();
        mCallback = ack;
        mContext = context;
    }
}
