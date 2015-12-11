// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.meta_data;

import com.poshmark.data_model.models.MetaItem;
import java.util.ArrayList;
import java.util.List;

public class CategorySubCategorySelectionModel
{

    public List categoryFacetList;
    public MetaItem currentCategory;
    public List currentGlobalStyleTagsSelection;
    public List currentSubCategorySelection;
    public List globalStyleTags;
    public List scrubbedSubCategoryList;
    public List subCategoryFacetList;

    public CategorySubCategorySelectionModel()
    {
        scrubbedSubCategoryList = new ArrayList();
        currentSubCategorySelection = new ArrayList();
        globalStyleTags = new ArrayList();
    }

    public static CategorySubCategorySelectionModel clone(CategorySubCategorySelectionModel categorysubcategoryselectionmodel)
    {
        CategorySubCategorySelectionModel categorysubcategoryselectionmodel1 = new CategorySubCategorySelectionModel();
        categorysubcategoryselectionmodel1.scrubbedSubCategoryList.addAll(categorysubcategoryselectionmodel.scrubbedSubCategoryList);
        if (categorysubcategoryselectionmodel.currentSubCategorySelection != null)
        {
            categorysubcategoryselectionmodel1.currentSubCategorySelection = new ArrayList();
            categorysubcategoryselectionmodel1.currentSubCategorySelection.addAll(categorysubcategoryselectionmodel.currentSubCategorySelection);
        }
        categorysubcategoryselectionmodel1.categoryFacetList = new ArrayList();
        if (categorysubcategoryselectionmodel.categoryFacetList != null)
        {
            categorysubcategoryselectionmodel1.categoryFacetList.addAll(categorysubcategoryselectionmodel.categoryFacetList);
        }
        categorysubcategoryselectionmodel1.subCategoryFacetList = new ArrayList();
        if (categorysubcategoryselectionmodel.subCategoryFacetList != null)
        {
            categorysubcategoryselectionmodel1.subCategoryFacetList.addAll(categorysubcategoryselectionmodel.subCategoryFacetList);
        }
        categorysubcategoryselectionmodel1.currentCategory = categorysubcategoryselectionmodel.currentCategory;
        return categorysubcategoryselectionmodel1;
    }

    public void removeAllSelections()
    {
        if (currentSubCategorySelection != null)
        {
            currentSubCategorySelection.clear();
        }
        if (currentGlobalStyleTagsSelection != null)
        {
            currentGlobalStyleTagsSelection.clear();
        }
    }

    public boolean selectionsPresent()
    {
        boolean flag;
        boolean flag1;
        if (currentSubCategorySelection == null || currentSubCategorySelection.size() == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (currentGlobalStyleTagsSelection == null || currentGlobalStyleTagsSelection.size() == 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        return !flag || !flag1;
    }
}
