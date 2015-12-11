// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

// Referenced classes of package com.bitstrips.imoji.ui:
//            AbstractFragment, AvatarChangeRegister, ImagesGridViewsWrapper

public class ImojiBrowserFragment extends AbstractFragment
{

    public static final String SUPERTAG = "supertag";
    AvatarChangeRegister avatarChangeRegister;
    private GridView gridView;
    ImagesGridViewsWrapper imagesGridViewsWrapper;
    private String supertag;

    public ImojiBrowserFragment()
    {
    }

    public static ImojiBrowserFragment newInstance(String s)
    {
        Bundle bundle = new Bundle();
        bundle.putString("supertag", s);
        s = new ImojiBrowserFragment();
        s.setArguments(bundle);
        return s;
    }

    protected int getLayout()
    {
        return 0x7f03003d;
    }

    protected void initArgs(Bundle bundle)
    {
        supertag = bundle.getString("supertag");
    }

    protected void initSubViews(View view)
    {
        gridView = (GridView)view.findViewById(0x7f0b00c9);
    }

    public void onDetach()
    {
        super.onDetach();
        avatarChangeRegister.unregister();
    }

    protected void populateContentView()
    {
        imagesGridViewsWrapper.init(getActivity(), gridView, supertag);
        avatarChangeRegister.registerAvatarIdChangeListener(getActivity(), new AvatarChangeRegister.AvatarChangeListener() {

            final ImojiBrowserFragment this$0;

            public void onChanged()
            {
                imagesGridViewsWrapper.notifyDataSetChanged();
            }

            
            {
                this$0 = ImojiBrowserFragment.this;
                super();
            }
        });
    }
}
