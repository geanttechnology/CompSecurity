// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.config;

import android.app.Activity;
import com.amazon.gallery.foundation.ui.layout.mosaic.ImageEater;
import com.amazon.gallery.foundation.ui.layout.mosaic.RootImageEater;
import com.amazon.gallery.foundation.ui.layout.mosaic.SplitDimension;
import com.amazon.gallery.framework.gallery.timeline.TimelineNavigator;
import java.util.ArrayList;
import java.util.List;

public abstract class GalleryViewConfig
{

    protected final Activity context;
    protected TimelineNavigator timelineNavigator;

    public GalleryViewConfig(Activity activity)
    {
        context = activity;
    }

    public static RootImageEater[] constructEaters(int i)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(ImageEater.rootEater(1, 1, ImageEater.fillEater()));
        arraylist.add(ImageEater.rootEater(17, 36, ImageEater.splitEater(SplitDimension.VERTICAL, new ImageEater[] {
            ImageEater.fillEater(2), ImageEater.fillEater()
        })));
        arraylist.add(ImageEater.rootEater(17, 36, ImageEater.splitEater(SplitDimension.VERTICAL, new ImageEater[] {
            ImageEater.fillEater(), ImageEater.fillEater(2)
        })));
        arraylist.add(ImageEater.rootEater(1, 3, ImageEater.splitEater(SplitDimension.VERTICAL, new ImageEater[] {
            ImageEater.fillEater(), ImageEater.fillEater()
        })));
        arraylist.add(ImageEater.rootEater(3, 4, ImageEater.splitEater(SplitDimension.VERTICAL, new ImageEater[] {
            ImageEater.fillEater(), ImageEater.fillEater()
        })));
        arraylist.add(ImageEater.rootEater(1, 2, ImageEater.splitEater(SplitDimension.VERTICAL, new ImageEater[] {
            ImageEater.fillEater(), ImageEater.fillEater(), ImageEater.fillEater()
        })));
        if (i >= 1600)
        {
            arraylist.add(ImageEater.rootEater(17, 48, ImageEater.splitEater(SplitDimension.VERTICAL, new ImageEater[] {
                ImageEater.fillEater(), ImageEater.fillEater(), ImageEater.fillEater(2)
            })));
            arraylist.add(ImageEater.rootEater(17, 48, ImageEater.splitEater(SplitDimension.VERTICAL, new ImageEater[] {
                ImageEater.fillEater(2), ImageEater.fillEater(), ImageEater.fillEater()
            })));
            arraylist.add(ImageEater.rootEater(17, 24, ImageEater.splitEater(SplitDimension.VERTICAL, new ImageEater[] {
                ImageEater.fillEater(), ImageEater.splitEater(SplitDimension.HORIZONTAL, new ImageEater[] {
                    ImageEater.fillEater(), ImageEater.fillEater()
                })
            })));
            arraylist.add(ImageEater.rootEater(17, 24, ImageEater.splitEater(SplitDimension.VERTICAL, new ImageEater[] {
                ImageEater.splitEater(SplitDimension.HORIZONTAL, new ImageEater[] {
                    ImageEater.fillEater(), ImageEater.fillEater()
                }), ImageEater.fillEater()
            })));
        } else
        {
            arraylist.add(ImageEater.rootEater(4, 9, ImageEater.splitEater(SplitDimension.VERTICAL, new ImageEater[] {
                ImageEater.fillEater(2), ImageEater.splitEater(SplitDimension.HORIZONTAL, new ImageEater[] {
                    ImageEater.fillEater(), ImageEater.fillEater()
                })
            })));
            arraylist.add(ImageEater.rootEater(4, 9, ImageEater.splitEater(SplitDimension.VERTICAL, new ImageEater[] {
                ImageEater.splitEater(SplitDimension.HORIZONTAL, new ImageEater[] {
                    ImageEater.fillEater(), ImageEater.fillEater()
                }), ImageEater.fillEater(2)
            })));
            arraylist.add(ImageEater.rootEater(1, 1, ImageEater.splitEater(SplitDimension.VERTICAL, new ImageEater[] {
                ImageEater.fillEater(2), ImageEater.splitEater(SplitDimension.HORIZONTAL, new ImageEater[] {
                    ImageEater.fillEater(), ImageEater.fillEater()
                })
            })));
            arraylist.add(ImageEater.rootEater(1, 1, ImageEater.splitEater(SplitDimension.VERTICAL, new ImageEater[] {
                ImageEater.splitEater(SplitDimension.HORIZONTAL, new ImageEater[] {
                    ImageEater.fillEater(), ImageEater.fillEater()
                }), ImageEater.fillEater(2)
            })));
        }
        return (RootImageEater[])arraylist.toArray(new RootImageEater[arraylist.size()]);
    }

    public void init()
    {
    }

    public void setTimelineNavigator(TimelineNavigator timelinenavigator)
    {
        timelineNavigator = timelinenavigator;
    }
}
