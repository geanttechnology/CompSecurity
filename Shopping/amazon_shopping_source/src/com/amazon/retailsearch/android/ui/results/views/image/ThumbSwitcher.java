// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.image;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amazon.ansel.fetch.AbstractResourceListener;
import com.amazon.ansel.fetch.ImageLoader;
import com.amazon.ansel.fetch.ImageRequest;
import com.amazon.ansel.fetch.ResourceProvider;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.j2me.client.util.RetailSearchAndroidPlatform;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views.image:
//            ThumbSwitcherState, ImageWrapper

public class ThumbSwitcher extends LinearLayout
{

    private static final int DELAY = 300;
    private static final int MAX_IMAGES = 5;
    private static final int MAX_LOAD_TIME = 60000;
    private static final HashMap STATES = new HashMap(2);
    private final Drawable activeDot;
    String asin;
    private final Context context;
    private final float density;
    private ImageRequest displayedImageResource;
    private final Drawable highDot;
    private List imageResources;
    private List imageSubscribers;
    private ImageWrapper imageWrapper;
    private final Drawable inactiveDot;
    private long loadStartTime;
    private boolean loadedImage;
    RetailSearchAndroidPlatform platform;
    private int position;
    private ThumbSwitcherState productState;
    private boolean progressEnabled;
    private boolean progressRunning;
    private ResourceProvider resourceProvider;

    public ThumbSwitcher(Context context1, AttributeSet attributeset)
    {
        super(context1, attributeset);
        imageSubscribers = new ArrayList(2);
        context = context1;
        activeDot = context1.getResources().getDrawable(com.amazon.retailsearch.R.drawable.active_dot);
        inactiveDot = context1.getResources().getDrawable(com.amazon.retailsearch.R.drawable.inactive_dot);
        highDot = context1.getResources().getDrawable(com.amazon.retailsearch.R.drawable.highlighted_dot);
        density = context1.getResources().getDisplayMetrics().density;
        RetailSearchDaggerGraphController.inject(this);
    }

    private void setPagerPosition(int i)
    {
        int l = getCount();
        int j = 0;
        while (j < getChildCount()) 
        {
            View view = getChildAt(j);
            byte byte0;
            if (j == 0)
            {
                byte0 = 4;
            } else
            {
                byte0 = 8;
            }
            view.setVisibility(byte0);
            j++;
        }
        if (l <= 1)
        {
            return;
        }
        int k = Math.min(l, 5);
        j = 0;
        while (j < k) 
        {
            ImageView imageview;
            Object obj;
            if (j < getChildCount())
            {
                imageview = (ImageView)getChildAt(j);
                imageview.setVisibility(0);
            } else
            {
                imageview = new ImageView(context);
                obj = new android.widget.LinearLayout.LayoutParams(-2, -2);
                obj.gravity = 16;
                if (j > 0)
                {
                    obj.leftMargin = (int)(2.0F * density + 0.5F);
                }
                addView(imageview, ((android.view.ViewGroup.LayoutParams) (obj)));
            }
            if (i == j)
            {
                obj = activeDot;
            } else
            {
                obj = inactiveDot;
            }
            imageview.setImageDrawable(((Drawable) (obj)));
            j++;
        }
        setVisibility(0);
    }

    private void showProgress()
    {
        if (progressRunning)
        {
            return;
        }
        if (!progressEnabled || getChildCount() == 0 || loadStartTime != 0L && System.currentTimeMillis() - loadStartTime > 60000L)
        {
            progressRunning = false;
            return;
        }
        if (productState == null || productState.getDisplayedImage() == productState.getRequestedImage() || productState.getRequestedImage() == -1)
        {
            progressRunning = false;
            return;
        }
        progressRunning = true;
        byte byte0 = -1;
        int i = 0;
        do
        {
label0:
            {
                int j = byte0;
                if (i < getChildCount())
                {
                    ImageView imageview = (ImageView)getChildAt(i);
                    if (imageview.getVisibility() != 0 || imageview.getDrawable() != highDot)
                    {
                        break label0;
                    }
                    j = i;
                }
                if (j >= 0)
                {
                    ((ImageView)getChildAt(j)).setImageDrawable(inactiveDot);
                }
                if (j + 1 < getChildCount())
                {
                    i = j + 1;
                } else
                {
                    i = 0;
                }
                ((ImageView)getChildAt(i)).setImageDrawable(highDot);
                platform.invokeLater(new Runnable() {

                    final ThumbSwitcher this$0;

                    public void run()
                    {
                        progressRunning = false;
                        showProgress();
                    }

            
            {
                this$0 = ThumbSwitcher.this;
                super();
            }
                }, 300L);
                return;
            }
            i++;
        } while (true);
    }

    public void buildView(String s, ImageWrapper imagewrapper, List list, ResourceProvider resourceprovider)
    {
        asin = s;
        imageWrapper = imagewrapper;
        imageResources = list;
        resourceProvider = resourceprovider;
        position = 0;
        loadedImage = false;
        imageSubscribers.clear();
        loadStartTime = 0L;
        progressEnabled = false;
        int j = 0;
        productState = (ThumbSwitcherState)STATES.get(s);
        int i = j;
        if (productState != null)
        {
            i = j;
            if (productState.getDisplayedImage() != -1)
            {
                i = productState.getDisplayedImage();
            }
        }
        j = getCount();
        if (i >= 0 && i < j)
        {
            s = (ImageRequest)list.get(i);
        } else
        {
            s = null;
        }
        if (s == null || !s.equals(displayedImageResource))
        {
            imagewrapper.hideImage();
        }
        if (s != null)
        {
            position = i;
            setPosition(i, true);
        }
        if (productState != null && productState.getDisplayedImage() != productState.getRequestedImage() && productState.getRequestedImage() != -1)
        {
            setPosition(productState.getRequestedImage());
        }
    }

    public int getCount()
    {
        if (imageResources != null)
        {
            return imageResources.size();
        } else
        {
            return 0;
        }
    }

    public int getPosition()
    {
        return position;
    }

    public int normalizePosition(int i)
    {
        int j = getCount();
        i %= j;
        if (i >= 0)
        {
            return i;
        } else
        {
            return i + j;
        }
    }

    public void setPosition(int i)
    {
        setPosition(i, false);
    }

    public void setPosition(final int pos, final boolean initialView)
    {
        if (getCount() == 0)
        {
            imageWrapper.hideImage();
        } else
        {
            loadStartTime = System.currentTimeMillis();
            if (!initialView && productState == null)
            {
                productState = new ThumbSwitcherState();
                STATES.put(asin, productState);
            }
            pos = normalizePosition(pos);
            if (!initialView)
            {
                productState.setRequestedImage(pos);
            }
            final ImageRequest imageResource = (ImageRequest)imageResources.get(pos);
            AbstractResourceListener abstractresourcelistener = new AbstractResourceListener() {

                final ThumbSwitcher this$0;
                final ImageRequest val$imageResource;
                final boolean val$initialView;
                final int val$pos;

                public void result(Bitmap bitmap)
                {
                    if (imageSubscribers.remove(this)) goto _L2; else goto _L1
_L1:
                    return;
_L2:
                    boolean flag1 = false;
                    if (!initialView) goto _L4; else goto _L3
_L3:
                    boolean flag;
                    if (!loadedImage)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
_L5:
                    if (flag)
                    {
                        loadedImage = true;
                        position = pos;
                        if (productState != null)
                        {
                            productState.setDisplayedImage(pos);
                        }
                        if (bitmap == null)
                        {
                            imageWrapper.hideImage();
                            displayedImageResource = null;
                        } else
                        {
                            imageWrapper.showImage(imageResource, bitmap);
                            displayedImageResource = imageResource;
                        }
                        setPagerPosition(pos);
                        if (!initialView)
                        {
                            progressEnabled = false;
                            return;
                        }
                    }
                    if (true) goto _L1; else goto _L4
_L4:
                    flag = flag1;
                    if (productState != null)
                    {
                        flag = flag1;
                        if (pos == productState.getRequestedImage())
                        {
                            flag = true;
                        }
                    }
                      goto _L5
                }

                public volatile void result(Object obj)
                {
                    result((Bitmap)obj);
                }

            
            {
                this$0 = ThumbSwitcher.this;
                initialView = flag;
                pos = i;
                imageResource = imagerequest;
                super();
            }
            };
            imageSubscribers.add(abstractresourcelistener);
            imageResource = new ImageLoader(resourceProvider.getContext(), abstractresourcelistener, System.currentTimeMillis(), imageResource);
            resourceProvider.execute(imageResource);
            if (!initialView && position != pos)
            {
                progressEnabled = true;
                showProgress();
                return;
            }
        }
    }





/*
    static boolean access$102(ThumbSwitcher thumbswitcher, boolean flag)
    {
        thumbswitcher.loadedImage = flag;
        return flag;
    }

*/



/*
    static int access$302(ThumbSwitcher thumbswitcher, int i)
    {
        thumbswitcher.position = i;
        return i;
    }

*/



/*
    static ImageRequest access$502(ThumbSwitcher thumbswitcher, ImageRequest imagerequest)
    {
        thumbswitcher.displayedImageResource = imagerequest;
        return imagerequest;
    }

*/



/*
    static boolean access$702(ThumbSwitcher thumbswitcher, boolean flag)
    {
        thumbswitcher.progressEnabled = flag;
        return flag;
    }

*/


/*
    static boolean access$802(ThumbSwitcher thumbswitcher, boolean flag)
    {
        thumbswitcher.progressRunning = flag;
        return flag;
    }

*/

}
