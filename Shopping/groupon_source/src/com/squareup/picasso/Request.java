// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.picasso;

import android.net.Uri;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.squareup.picasso:
//            Transformation

public final class Request
{
    public static final class Builder
    {

        private boolean centerCrop;
        private boolean centerInside;
        private android.graphics.Bitmap.Config config;
        private boolean hasRotationPivot;
        private Picasso.Priority priority;
        private int resourceId;
        private float rotationDegrees;
        private float rotationPivotX;
        private float rotationPivotY;
        private String stableKey;
        private int targetHeight;
        private int targetWidth;
        private List transformations;
        private Uri uri;

        public Request build()
        {
            if (centerInside && centerCrop)
            {
                throw new IllegalStateException("Center crop and center inside can not be used together.");
            }
            if (centerCrop && (targetWidth == 0 || targetHeight == 0))
            {
                throw new IllegalStateException("Center crop requires calling resize with positive width and height.");
            }
            if (centerInside && (targetWidth == 0 || targetHeight == 0))
            {
                throw new IllegalStateException("Center inside requires calling resize with positive width and height.");
            }
            if (priority == null)
            {
                priority = Picasso.Priority.NORMAL;
            }
            return new Request(uri, resourceId, stableKey, transformations, targetWidth, targetHeight, centerCrop, centerInside, rotationDegrees, rotationPivotX, rotationPivotY, hasRotationPivot, config, priority);
        }

        public Builder centerCrop()
        {
            if (centerInside)
            {
                throw new IllegalStateException("Center crop can not be used after calling centerInside");
            } else
            {
                centerCrop = true;
                return this;
            }
        }

        public Builder centerInside()
        {
            if (centerCrop)
            {
                throw new IllegalStateException("Center inside can not be used after calling centerCrop");
            } else
            {
                centerInside = true;
                return this;
            }
        }

        public Builder config(android.graphics.Bitmap.Config config1)
        {
            config = config1;
            return this;
        }

        boolean hasImage()
        {
            return uri != null || resourceId != 0;
        }

        boolean hasPriority()
        {
            return priority != null;
        }

        boolean hasSize()
        {
            return targetWidth != 0 || targetHeight != 0;
        }

        public Builder priority(Picasso.Priority priority1)
        {
            if (priority1 == null)
            {
                throw new IllegalArgumentException("Priority invalid.");
            }
            if (priority != null)
            {
                throw new IllegalStateException("Priority already set.");
            } else
            {
                priority = priority1;
                return this;
            }
        }

        public Builder resize(int i, int j)
        {
            if (i < 0)
            {
                throw new IllegalArgumentException("Width must be positive number or 0.");
            }
            if (j < 0)
            {
                throw new IllegalArgumentException("Height must be positive number or 0.");
            }
            if (j == 0 && i == 0)
            {
                throw new IllegalArgumentException("At least one dimension has to be positive number.");
            } else
            {
                targetWidth = i;
                targetHeight = j;
                return this;
            }
        }

        public Builder transform(Transformation transformation)
        {
            if (transformation == null)
            {
                throw new IllegalArgumentException("Transformation must not be null.");
            }
            if (transformation.key() == null)
            {
                throw new IllegalArgumentException("Transformation key must not be null.");
            }
            if (transformations == null)
            {
                transformations = new ArrayList(2);
            }
            transformations.add(transformation);
            return this;
        }

        Builder(Uri uri1, int i)
        {
            uri = uri1;
            resourceId = i;
        }
    }


    private static final long TOO_LONG_LOG;
    public final boolean centerCrop;
    public final boolean centerInside;
    public final android.graphics.Bitmap.Config config;
    public final boolean hasRotationPivot;
    int id;
    boolean loadFromLocalCacheOnly;
    public final Picasso.Priority priority;
    public final int resourceId;
    public final float rotationDegrees;
    public final float rotationPivotX;
    public final float rotationPivotY;
    public final String stableKey;
    long started;
    public final int targetHeight;
    public final int targetWidth;
    public final List transformations;
    public final Uri uri;

    private Request(Uri uri1, int i, String s, List list, int j, int k, boolean flag, 
            boolean flag1, float f, float f1, float f2, boolean flag2, android.graphics.Bitmap.Config config1, Picasso.Priority priority1)
    {
        uri = uri1;
        resourceId = i;
        stableKey = s;
        if (list == null)
        {
            transformations = null;
        } else
        {
            transformations = Collections.unmodifiableList(list);
        }
        targetWidth = j;
        targetHeight = k;
        centerCrop = flag;
        centerInside = flag1;
        rotationDegrees = f;
        rotationPivotX = f1;
        rotationPivotY = f2;
        hasRotationPivot = flag2;
        config = config1;
        priority = priority1;
    }


    String getName()
    {
        if (uri != null)
        {
            return String.valueOf(uri.getPath());
        } else
        {
            return Integer.toHexString(resourceId);
        }
    }

    boolean hasCustomTransformations()
    {
        return transformations != null;
    }

    public boolean hasSize()
    {
        return targetWidth != 0 || targetHeight != 0;
    }

    String logId()
    {
        long l = System.nanoTime() - started;
        if (l > TOO_LONG_LOG)
        {
            return (new StringBuilder()).append(plainId()).append('+').append(TimeUnit.NANOSECONDS.toSeconds(l)).append('s').toString();
        } else
        {
            return (new StringBuilder()).append(plainId()).append('+').append(TimeUnit.NANOSECONDS.toMillis(l)).append("ms").toString();
        }
    }

    boolean needsMatrixTransform()
    {
        return hasSize() || rotationDegrees != 0.0F;
    }

    boolean needsTransformation()
    {
        return needsMatrixTransform() || hasCustomTransformations();
    }

    String plainId()
    {
        return (new StringBuilder()).append("[R").append(id).append(']').toString();
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("Request{");
        if (resourceId > 0)
        {
            stringbuilder.append(resourceId);
        } else
        {
            stringbuilder.append(uri);
        }
        if (transformations != null && !transformations.isEmpty())
        {
            Transformation transformation;
            for (Iterator iterator = transformations.iterator(); iterator.hasNext(); stringbuilder.append(' ').append(transformation.key()))
            {
                transformation = (Transformation)iterator.next();
            }

        }
        if (stableKey != null)
        {
            stringbuilder.append(" stableKey(").append(stableKey).append(')');
        }
        if (targetWidth > 0)
        {
            stringbuilder.append(" resize(").append(targetWidth).append(',').append(targetHeight).append(')');
        }
        if (centerCrop)
        {
            stringbuilder.append(" centerCrop");
        }
        if (centerInside)
        {
            stringbuilder.append(" centerInside");
        }
        if (rotationDegrees != 0.0F)
        {
            stringbuilder.append(" rotation(").append(rotationDegrees);
            if (hasRotationPivot)
            {
                stringbuilder.append(" @ ").append(rotationPivotX).append(',').append(rotationPivotY);
            }
            stringbuilder.append(')');
        }
        if (config != null)
        {
            stringbuilder.append(' ').append(config);
        }
        stringbuilder.append('}');
        return stringbuilder.toString();
    }

    static 
    {
        TOO_LONG_LOG = TimeUnit.SECONDS.toNanos(5L);
    }
}
