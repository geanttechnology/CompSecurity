// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.registry;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.bbyobjects.BBYTextView;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Hashtable;
import kf;

public class ListIdModalFragment extends BBYBaseFragment
{

    Charset a;
    CharsetEncoder b;
    byte c[];
    private String g;
    private String h;
    private ImageView i;

    public ListIdModalFragment(String s, String s1, String s2)
    {
        a = Charset.forName("ISO-8859-1");
        b = a.newEncoder();
        c = null;
        g = s1;
        h = s;
    }

    private String a(String s, int j)
    {
        return (new StringBuilder()).append("04").append(String.format((new StringBuilder()).append("%1$-").append(j).append("s").toString(), new Object[] {
            s
        })).toString();
    }

    private void a(String s)
    {
        Object obj;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        try
        {
            c = b.encode(CharBuffer.wrap(s)).array();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            System.out.println(s.getMessage());
        }
        s = new String(c, "ISO-8859-1");
        obj = new MultiFormatWriter();
        Hashtable hashtable = new Hashtable(2);
        hashtable.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        s = ((Writer) (obj)).encode(s, BarcodeFormat.QR_CODE, 600, 600, hashtable);
_L2:
        i1 = s.getHeight();
        j1 = s.getWidth();
        obj = Bitmap.createBitmap(j1, i1, android.graphics.Bitmap.Config.RGB_565);
        j = 0;
        break MISSING_BLOCK_LABEL_178;
_L1:
        if (k >= i1)
        {
            break MISSING_BLOCK_LABEL_218;
        }
        if (s.get(j, k))
        {
            l = 0xff000000;
        } else
        {
            l = -1;
        }
        ((Bitmap) (obj)).setPixel(j, k, l);
        k++;
          goto _L1
        s;
        System.out.println(s.getMessage());
        s = null;
          goto _L2
_L3:
        while (j >= j1) 
        {
            try
            {
                i.setImageBitmap(((Bitmap) (obj)));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                System.out.println(s.getMessage());
            }
            return;
        }
        k = 0;
          goto _L1
        j++;
          goto _L3
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        d = (FragmentActivity)activity;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        layoutinflater = layoutinflater.inflate(0x7f030061, null);
        viewgroup = (BBYTextView)layoutinflater.findViewById(0x7f0c0059);
        bundle = (BBYTextView)layoutinflater.findViewById(0x7f0c015c);
        if (h.equalsIgnoreCase("weddingregistrylists"))
        {
            viewgroup.setText("Registry ID");
            bundle.setText(0x7f0801af);
        }
        i = (ImageView)layoutinflater.findViewById(0x7f0c015a);
        kf.c(getClass().getName(), (new StringBuilder()).append("The listType before is ").append(h).toString());
        if (h.endsWith("s"))
        {
            h = h.substring(0, h.length() - 1);
        }
        viewgroup = (new StringBuilder()).append(a(h, 30)).append(g).toString();
        kf.c(getClass().getName(), (new StringBuilder()).append("The code is ").append(viewgroup).toString());
        ((BBYTextView)layoutinflater.findViewById(0x7f0c015d)).setText(g);
        ((TextView)layoutinflater.findViewById(0x7f0c0158)).setText(Html.fromHtml(getString(0x7f0801aa)));
        ((ImageView)layoutinflater.findViewById(0x7f0c0153)).setOnClickListener(new android.view.View.OnClickListener() {

            final ListIdModalFragment a;

            public void onClick(View view)
            {
                a.getActivity().finish();
                a.getActivity().overridePendingTransition(0x7f040005, 0x7f040008);
            }

            
            {
                a = ListIdModalFragment.this;
                super();
            }
        });
        a(viewgroup);
        return layoutinflater;
    }

    public void onResume()
    {
        super.onResume();
    }
}
