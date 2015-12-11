// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.models;

import java.lang.annotation.Annotation;

public class DrawerMenuItem
{
    public static interface MenuItemId
        extends Annotation
    {
    }

    public static interface MenuItemType
        extends Annotation
    {
    }


    public static final int MENU_ITEM_CATEGORIES = 6;
    public static final int MENU_ITEM_CLOSEST_PRODUCTS = 7;
    public static final int MENU_ITEM_CONTACT = 9;
    public static final int MENU_ITEM_CONVERSATIONS = 4;
    public static final int MENU_ITEM_EDIT_PROFILE = 5;
    public static final int MENU_ITEM_HELP = 8;
    public static final int MENU_ITEM_PROFILE = 3;
    public static final int MENU_ITEM_TYPE_CONVERSATIONS = 3;
    public static final int MENU_ITEM_TYPE_SIMPLE_ROW = 1;
    public static final int MENU_ITEM_TYPE_USER_GENERAL = 2;
    public static final int MENU_ITEM_TYPE_USER_INFO = 0;
    public static final int MENU_ITEM_USER = 2;
    private String firstText;
    private int iconResource;
    private int id;
    private String imageUrl;
    private String secondaryText;
    private int typeId;

    public DrawerMenuItem(int i, int j, String s, String s1, String s2, int k)
    {
        id = i;
        typeId = j;
        firstText = s;
        secondaryText = s1;
        imageUrl = s2;
        iconResource = k;
    }

    public boolean equals(Object obj)
    {
        boolean flag1;
        boolean flag2;
        flag1 = true;
        flag2 = false;
        if (this != obj) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        flag = flag2;
        if (obj == null) goto _L4; else goto _L3
_L3:
        flag = flag2;
        if (getClass() != obj.getClass()) goto _L4; else goto _L5
_L5:
        obj = (DrawerMenuItem)obj;
        if (firstText == null) goto _L7; else goto _L6
_L6:
        flag = flag2;
        if (!firstText.equals(((DrawerMenuItem) (obj)).firstText)) goto _L4; else goto _L8
_L8:
        if (secondaryText == null) goto _L10; else goto _L9
_L9:
        flag = flag2;
        if (!secondaryText.equals(((DrawerMenuItem) (obj)).secondaryText)) goto _L4; else goto _L11
_L11:
        if (imageUrl == null) goto _L13; else goto _L12
_L12:
        flag = flag1;
        if (imageUrl.equals(((DrawerMenuItem) (obj)).imageUrl)) goto _L15; else goto _L14
_L14:
        flag = false;
_L15:
        return flag;
_L7:
        if (((DrawerMenuItem) (obj)).firstText == null) goto _L8; else goto _L16
_L16:
        return false;
_L10:
        if (((DrawerMenuItem) (obj)).secondaryText == null) goto _L11; else goto _L17
_L17:
        return false;
_L13:
        if (((DrawerMenuItem) (obj)).imageUrl != null) goto _L14; else goto _L18
_L18:
        flag = flag1;
          goto _L15
    }

    public String getFirstText()
    {
        return firstText;
    }

    public int getIconResource()
    {
        return iconResource;
    }

    public int getId()
    {
        return id;
    }

    public String getSecondaryText()
    {
        return secondaryText;
    }

    public int getTypeId()
    {
        return typeId;
    }

    public String getUrlImage()
    {
        return imageUrl;
    }

    public int hashCode()
    {
        int k = 0;
        int i;
        int j;
        if (firstText != null)
        {
            i = firstText.hashCode();
        } else
        {
            i = 0;
        }
        if (secondaryText != null)
        {
            j = secondaryText.hashCode();
        } else
        {
            j = 0;
        }
        if (imageUrl != null)
        {
            k = imageUrl.hashCode();
        }
        return (j + i * 31) * 31 + k;
    }

    public void setFirstText(String s)
    {
        firstText = s;
    }

    public void setIconResource(int i)
    {
        iconResource = i;
    }

    public void setId(int i)
    {
        id = i;
    }

    public void setSecondaryText(String s)
    {
        secondaryText = s;
    }

    public void setTypeId(int i)
    {
        typeId = i;
    }

    public void setUrlImage(String s)
    {
        imageUrl = s;
    }

    public String toString()
    {
        return (new StringBuilder()).append("DrawerMenuItem{id=").append(id).append(", typeId=").append(typeId).append(", firstText='").append(firstText).append('\'').append(", secondaryText='").append(secondaryText).append('\'').append(", imageUrl='").append(imageUrl).append('\'').append('}').toString();
    }
}
