.class public Lco/vine/android/widget/FakeActionBar;
.super Ljava/lang/Object;
.source "FakeActionBar.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/widget/FakeActionBar$Theme;,
        Lco/vine/android/widget/FakeActionBar$MenuItemPack;
    }
.end annotation


# instance fields
.field private mActionBar:Landroid/widget/RelativeLayout;

.field private mActionBarContainer:Landroid/widget/RelativeLayout;

.field private mActionBarLeft:Landroid/widget/RelativeLayout;

.field private mActionBarRight:Landroid/widget/LinearLayout;

.field private final mActivity:Landroid/support/v7/app/ActionBarActivity;

.field private mBackIcon:Landroid/widget/ImageView;

.field private mContentView:Landroid/view/View;

.field private mDisplayHomeAsUp:Z

.field private mDisplayShowTitle:Ljava/lang/Boolean;

.field private mDistanceMarker:Landroid/view/View;

.field private mHomeButtonEnabled:Z

.field private mHomeIcon:Landroid/widget/ImageView;

.field private mMenu:Landroid/view/Menu;

.field private final mMenuItemPacks:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/widget/FakeActionBar$MenuItemPack;",
            ">;"
        }
    .end annotation
.end field

.field public mTheme:Lco/vine/android/widget/FakeActionBar$Theme;

.field private mTitle:Ljava/lang/String;

.field private mTitleView:Landroid/widget/TextView;


# direct methods
.method public constructor <init>(Landroid/support/v7/app/ActionBarActivity;)V
    .locals 1
    .param p1, "activity"    # Landroid/support/v7/app/ActionBarActivity;

    .prologue
    .line 92
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 48
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lco/vine/android/widget/FakeActionBar;->mMenuItemPacks:Ljava/util/ArrayList;

    .line 93
    iput-object p1, p0, Lco/vine/android/widget/FakeActionBar;->mActivity:Landroid/support/v7/app/ActionBarActivity;

    .line 94
    sget-object v0, Lco/vine/android/widget/FakeActionBar$Theme;->LIGHT:Lco/vine/android/widget/FakeActionBar$Theme;

    iput-object v0, p0, Lco/vine/android/widget/FakeActionBar;->mTheme:Lco/vine/android/widget/FakeActionBar$Theme;

    .line 95
    return-void
.end method

.method static synthetic access$000(Lco/vine/android/widget/FakeActionBar;)Landroid/support/v7/app/ActionBarActivity;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/widget/FakeActionBar;

    .prologue
    .line 28
    iget-object v0, p0, Lco/vine/android/widget/FakeActionBar;->mActivity:Landroid/support/v7/app/ActionBarActivity;

    return-object v0
.end method


# virtual methods
.method public getActionBar()Landroid/widget/RelativeLayout;
    .locals 1

    .prologue
    .line 186
    iget-object v0, p0, Lco/vine/android/widget/FakeActionBar;->mActionBar:Landroid/widget/RelativeLayout;

    return-object v0
.end method

.method public getActionBarLeft()Landroid/widget/RelativeLayout;
    .locals 1

    .prologue
    .line 80
    iget-object v0, p0, Lco/vine/android/widget/FakeActionBar;->mActionBarLeft:Landroid/widget/RelativeLayout;

    return-object v0
.end method

.method public getActionBarRight()Landroid/widget/LinearLayout;
    .locals 1

    .prologue
    .line 84
    iget-object v0, p0, Lco/vine/android/widget/FakeActionBar;->mActionBarRight:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method public getBackIcon()Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 115
    iget-object v0, p0, Lco/vine/android/widget/FakeActionBar;->mBackIcon:Landroid/widget/ImageView;

    return-object v0
.end method

.method public getDistanceMaker()Landroid/view/View;
    .locals 1

    .prologue
    .line 182
    iget-object v0, p0, Lco/vine/android/widget/FakeActionBar;->mDistanceMarker:Landroid/view/View;

    return-object v0
.end method

.method public getHomeIcon()Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 119
    iget-object v0, p0, Lco/vine/android/widget/FakeActionBar;->mHomeIcon:Landroid/widget/ImageView;

    return-object v0
.end method

.method public getMenuItemPack(I)Lco/vine/android/widget/FakeActionBar$MenuItemPack;
    .locals 3
    .param p1, "id"    # I

    .prologue
    .line 51
    iget-object v2, p0, Lco/vine/android/widget/FakeActionBar;->mMenuItemPacks:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/widget/FakeActionBar$MenuItemPack;

    .line 52
    .local v1, "pack":Lco/vine/android/widget/FakeActionBar$MenuItemPack;
    iget-object v2, v1, Lco/vine/android/widget/FakeActionBar$MenuItemPack;->item:Landroid/view/MenuItem;

    invoke-interface {v2}, Landroid/view/MenuItem;->getItemId()I

    move-result v2

    if-ne v2, p1, :cond_0

    .line 56
    .end local v1    # "pack":Lco/vine/android/widget/FakeActionBar$MenuItemPack;
    :goto_0
    return-object v1

    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getRoot()Landroid/widget/RelativeLayout;
    .locals 1

    .prologue
    .line 194
    iget-object v0, p0, Lco/vine/android/widget/FakeActionBar;->mActionBarContainer:Landroid/widget/RelativeLayout;

    return-object v0
.end method

.method public getTitleView()Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 190
    iget-object v0, p0, Lco/vine/android/widget/FakeActionBar;->mTitleView:Landroid/widget/TextView;

    return-object v0
.end method

.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 74
    iget-object v0, p0, Lco/vine/android/widget/FakeActionBar;->mBackIcon:Landroid/widget/ImageView;

    if-eq p1, v0, :cond_0

    iget-object v0, p0, Lco/vine/android/widget/FakeActionBar;->mHomeIcon:Landroid/widget/ImageView;

    if-ne p1, v0, :cond_1

    .line 75
    :cond_0
    iget-object v0, p0, Lco/vine/android/widget/FakeActionBar;->mActivity:Landroid/support/v7/app/ActionBarActivity;

    invoke-virtual {v0}, Landroid/support/v7/app/ActionBarActivity;->finish()V

    .line 77
    :cond_1
    return-void
.end method

.method public onCreate()V
    .locals 3

    .prologue
    .line 102
    iget-object v0, p0, Lco/vine/android/widget/FakeActionBar;->mActivity:Landroid/support/v7/app/ActionBarActivity;

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    const v1, 0x7f03003b

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lco/vine/android/widget/FakeActionBar;->mActionBarContainer:Landroid/widget/RelativeLayout;

    .line 103
    iget-object v0, p0, Lco/vine/android/widget/FakeActionBar;->mActionBarContainer:Landroid/widget/RelativeLayout;

    const v1, 0x7f0a00e7

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lco/vine/android/widget/FakeActionBar;->mActionBar:Landroid/widget/RelativeLayout;

    .line 104
    iget-object v0, p0, Lco/vine/android/widget/FakeActionBar;->mActivity:Landroid/support/v7/app/ActionBarActivity;

    iget-object v1, p0, Lco/vine/android/widget/FakeActionBar;->mActionBar:Landroid/widget/RelativeLayout;

    invoke-static {v0, v1}, Lco/vine/android/util/ViewUtil;->setActionBarHeight(Landroid/support/v7/app/ActionBarActivity;Landroid/view/View;)V

    .line 105
    iget-object v0, p0, Lco/vine/android/widget/FakeActionBar;->mActionBarContainer:Landroid/widget/RelativeLayout;

    const v1, 0x7f0a00e6

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/widget/FakeActionBar;->mDistanceMarker:Landroid/view/View;

    .line 106
    iget-object v0, p0, Lco/vine/android/widget/FakeActionBar;->mActivity:Landroid/support/v7/app/ActionBarActivity;

    iget-object v1, p0, Lco/vine/android/widget/FakeActionBar;->mDistanceMarker:Landroid/view/View;

    invoke-static {v0, v1}, Lco/vine/android/util/ViewUtil;->setActionBarHeight(Landroid/support/v7/app/ActionBarActivity;Landroid/view/View;)V

    .line 107
    iget-object v0, p0, Lco/vine/android/widget/FakeActionBar;->mActionBarContainer:Landroid/widget/RelativeLayout;

    const v1, 0x7f0a00e8

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lco/vine/android/widget/FakeActionBar;->mActionBarLeft:Landroid/widget/RelativeLayout;

    .line 108
    iget-object v0, p0, Lco/vine/android/widget/FakeActionBar;->mActionBarContainer:Landroid/widget/RelativeLayout;

    const v1, 0x7f0a00ec

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lco/vine/android/widget/FakeActionBar;->mActionBarRight:Landroid/widget/LinearLayout;

    .line 109
    iget-object v0, p0, Lco/vine/android/widget/FakeActionBar;->mActionBar:Landroid/widget/RelativeLayout;

    const v1, 0x7f0a00e9

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lco/vine/android/widget/FakeActionBar;->mBackIcon:Landroid/widget/ImageView;

    .line 110
    iget-object v0, p0, Lco/vine/android/widget/FakeActionBar;->mActionBar:Landroid/widget/RelativeLayout;

    const v1, 0x7f0a00ea

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lco/vine/android/widget/FakeActionBar;->mHomeIcon:Landroid/widget/ImageView;

    .line 111
    iget-object v0, p0, Lco/vine/android/widget/FakeActionBar;->mActionBar:Landroid/widget/RelativeLayout;

    const v1, 0x7f0a00eb

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lco/vine/android/widget/FakeActionBar;->mTitleView:Landroid/widget/TextView;

    .line 112
    return-void
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;Z)V
    .locals 11
    .param p1, "menu"    # Landroid/view/Menu;
    .param p2, "show"    # Z

    .prologue
    .line 218
    iput-object p1, p0, Lco/vine/android/widget/FakeActionBar;->mMenu:Landroid/view/Menu;

    .line 219
    iget-object v9, p0, Lco/vine/android/widget/FakeActionBar;->mMenuItemPacks:Ljava/util/ArrayList;

    invoke-virtual {v9}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lco/vine/android/widget/FakeActionBar$MenuItemPack;

    .line 220
    .local v5, "pack":Lco/vine/android/widget/FakeActionBar$MenuItemPack;
    iget-object v9, v5, Lco/vine/android/widget/FakeActionBar$MenuItemPack;->view:Landroid/view/View;

    if-eqz v9, :cond_0

    .line 221
    iget-object v9, p0, Lco/vine/android/widget/FakeActionBar;->mActionBarRight:Landroid/widget/LinearLayout;

    iget-object v10, v5, Lco/vine/android/widget/FakeActionBar$MenuItemPack;->view:Landroid/view/View;

    invoke-virtual {v9, v10}, Landroid/widget/LinearLayout;->removeView(Landroid/view/View;)V

    goto :goto_0

    .line 224
    .end local v5    # "pack":Lco/vine/android/widget/FakeActionBar$MenuItemPack;
    :cond_1
    if-nez p2, :cond_2

    .line 256
    :goto_1
    return-void

    .line 227
    :cond_2
    iget-object v9, p0, Lco/vine/android/widget/FakeActionBar;->mMenu:Landroid/view/Menu;

    invoke-interface {v9}, Landroid/view/Menu;->size()I

    move-result v6

    .line 228
    .local v6, "size":I
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 229
    .local v4, "newMenuItemIndexes":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/widget/FakeActionBar$MenuItemPack;>;"
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_2
    if-ge v0, v6, :cond_6

    .line 230
    iget-object v9, p0, Lco/vine/android/widget/FakeActionBar;->mMenu:Landroid/view/Menu;

    invoke-interface {v9, v0}, Landroid/view/Menu;->getItem(I)Landroid/view/MenuItem;

    move-result-object v3

    .line 231
    .local v3, "item":Landroid/view/MenuItem;
    invoke-interface {v3}, Landroid/view/MenuItem;->isVisible()Z

    move-result v9

    if-eqz v9, :cond_5

    .line 232
    const/4 v8, 0x0

    .line 233
    .local v8, "v":Landroid/view/View;
    invoke-interface {v3}, Landroid/view/MenuItem;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v2

    .line 234
    .local v2, "icon":Landroid/graphics/drawable/Drawable;
    invoke-interface {v3}, Landroid/view/MenuItem;->getTitle()Ljava/lang/CharSequence;

    move-result-object v7

    .line 235
    .local v7, "title":Ljava/lang/CharSequence;
    if-eqz v2, :cond_3

    .line 236
    new-instance v8, Landroid/widget/ImageView;

    .end local v8    # "v":Landroid/view/View;
    iget-object v9, p0, Lco/vine/android/widget/FakeActionBar;->mActivity:Landroid/support/v7/app/ActionBarActivity;

    invoke-direct {v8, v9}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V

    .restart local v8    # "v":Landroid/view/View;
    move-object v9, v8

    .line 237
    check-cast v9, Landroid/widget/ImageView;

    invoke-virtual {v9, v2}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 239
    :cond_3
    if-eqz v7, :cond_4

    .line 240
    new-instance v8, Landroid/widget/TextView;

    .end local v8    # "v":Landroid/view/View;
    iget-object v9, p0, Lco/vine/android/widget/FakeActionBar;->mActivity:Landroid/support/v7/app/ActionBarActivity;

    invoke-direct {v8, v9}, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V

    .restart local v8    # "v":Landroid/view/View;
    move-object v9, v8

    .line 241
    check-cast v9, Landroid/widget/TextView;

    invoke-virtual {v9, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 243
    :cond_4
    if-eqz v8, :cond_5

    .line 244
    new-instance v9, Lco/vine/android/widget/FakeActionBar$1;

    invoke-direct {v9, p0, v3}, Lco/vine/android/widget/FakeActionBar$1;-><init>(Lco/vine/android/widget/FakeActionBar;Landroid/view/MenuItem;)V

    invoke-virtual {v8, v9}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 250
    iget-object v9, p0, Lco/vine/android/widget/FakeActionBar;->mActionBarRight:Landroid/widget/LinearLayout;

    invoke-virtual {v9, v8}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 229
    .end local v2    # "icon":Landroid/graphics/drawable/Drawable;
    .end local v7    # "title":Ljava/lang/CharSequence;
    .end local v8    # "v":Landroid/view/View;
    :cond_5
    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    .line 254
    .end local v3    # "item":Landroid/view/MenuItem;
    :cond_6
    iget-object v9, p0, Lco/vine/android/widget/FakeActionBar;->mMenuItemPacks:Ljava/util/ArrayList;

    invoke-virtual {v9}, Ljava/util/ArrayList;->clear()V

    .line 255
    iget-object v9, p0, Lco/vine/android/widget/FakeActionBar;->mMenuItemPacks:Ljava/util/ArrayList;

    invoke-virtual {v9, v4}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    goto :goto_1
.end method

.method public onPostCreate(Landroid/os/Bundle;)V
    .locals 12
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/16 v11, 0x8

    const/4 v10, 0x1

    const/4 v9, 0x0

    .line 123
    iget-object v6, p0, Lco/vine/android/widget/FakeActionBar;->mContentView:Landroid/view/View;

    if-eqz v6, :cond_0

    iget-object v6, p0, Lco/vine/android/widget/FakeActionBar;->mActionBarContainer:Landroid/widget/RelativeLayout;

    if-nez v6, :cond_1

    .line 124
    :cond_0
    new-instance v6, Ljava/lang/IllegalStateException;

    const-string v7, "custom setContentView is not called."

    invoke-direct {v6, v7}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v6

    .line 126
    :cond_1
    iget-boolean v6, p0, Lco/vine/android/widget/FakeActionBar;->mDisplayHomeAsUp:Z

    if-nez v6, :cond_2

    iget-boolean v6, p0, Lco/vine/android/widget/FakeActionBar;->mHomeButtonEnabled:Z

    if-eqz v6, :cond_8

    .line 127
    :cond_2
    iget-boolean v6, p0, Lco/vine/android/widget/FakeActionBar;->mDisplayHomeAsUp:Z

    if-eqz v6, :cond_6

    .line 128
    iget-object v7, p0, Lco/vine/android/widget/FakeActionBar;->mBackIcon:Landroid/widget/ImageView;

    iget-object v6, p0, Lco/vine/android/widget/FakeActionBar;->mTheme:Lco/vine/android/widget/FakeActionBar$Theme;

    sget-object v8, Lco/vine/android/widget/FakeActionBar$Theme;->DARK:Lco/vine/android/widget/FakeActionBar$Theme;

    if-ne v6, v8, :cond_5

    const v6, 0x7f020012

    :goto_0
    invoke-virtual {v7, v6}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 130
    iget-object v6, p0, Lco/vine/android/widget/FakeActionBar;->mBackIcon:Landroid/widget/ImageView;

    invoke-virtual {v6, v10}, Landroid/widget/ImageView;->setClickable(Z)V

    .line 131
    iget-object v6, p0, Lco/vine/android/widget/FakeActionBar;->mBackIcon:Landroid/widget/ImageView;

    invoke-virtual {v6, v9}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 132
    iget-object v6, p0, Lco/vine/android/widget/FakeActionBar;->mBackIcon:Landroid/widget/ImageView;

    invoke-virtual {v6, p0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 136
    :goto_1
    const/4 v2, 0x0

    .line 137
    .local v2, "icon":Landroid/graphics/drawable/Drawable;
    iget-object v6, p0, Lco/vine/android/widget/FakeActionBar;->mActivity:Landroid/support/v7/app/ActionBarActivity;

    invoke-virtual {v6}, Landroid/support/v7/app/ActionBarActivity;->getTheme()Landroid/content/res/Resources$Theme;

    move-result-object v4

    .line 138
    .local v4, "theme":Landroid/content/res/Resources$Theme;
    if-eqz v4, :cond_3

    .line 139
    new-array v6, v10, [I

    const v7, 0x10102ce

    aput v7, v6, v9

    invoke-virtual {v4, v6}, Landroid/content/res/Resources$Theme;->obtainStyledAttributes([I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 140
    .local v0, "att":Landroid/content/res/TypedArray;
    new-instance v5, Landroid/util/TypedValue;

    invoke-direct {v5}, Landroid/util/TypedValue;-><init>()V

    .line 141
    .local v5, "typedValue":Landroid/util/TypedValue;
    invoke-virtual {v0, v9, v5}, Landroid/content/res/TypedArray;->getValue(ILandroid/util/TypedValue;)Z

    move-result v6

    if-eqz v6, :cond_3

    .line 142
    iget v6, v5, Landroid/util/TypedValue;->resourceId:I

    new-array v7, v10, [I

    const v8, 0x1010002

    aput v8, v7, v9

    invoke-virtual {v4, v6, v7}, Landroid/content/res/Resources$Theme;->obtainStyledAttributes(I[I)Landroid/content/res/TypedArray;

    move-result-object v1

    .line 143
    .local v1, "att2":Landroid/content/res/TypedArray;
    const/4 v6, -0x1

    invoke-virtual {v1, v9, v6}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v3

    .line 144
    .local v3, "iconRes":I
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 145
    invoke-virtual {v1}, Landroid/content/res/TypedArray;->recycle()V

    .line 146
    if-lez v3, :cond_3

    .line 147
    iget-object v6, p0, Lco/vine/android/widget/FakeActionBar;->mActivity:Landroid/support/v7/app/ActionBarActivity;

    invoke-virtual {v6}, Landroid/support/v7/app/ActionBarActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    invoke-virtual {v6, v3}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    .line 151
    .end local v0    # "att":Landroid/content/res/TypedArray;
    .end local v1    # "att2":Landroid/content/res/TypedArray;
    .end local v3    # "iconRes":I
    .end local v5    # "typedValue":Landroid/util/TypedValue;
    :cond_3
    if-nez v2, :cond_4

    .line 152
    iget-object v6, p0, Lco/vine/android/widget/FakeActionBar;->mActivity:Landroid/support/v7/app/ActionBarActivity;

    invoke-virtual {v6}, Landroid/support/v7/app/ActionBarActivity;->getApplicationInfo()Landroid/content/pm/ApplicationInfo;

    move-result-object v6

    iget-object v7, p0, Lco/vine/android/widget/FakeActionBar;->mActivity:Landroid/support/v7/app/ActionBarActivity;

    invoke-virtual {v7}, Landroid/support/v7/app/ActionBarActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v7

    invoke-virtual {v6, v7}, Landroid/content/pm/ApplicationInfo;->loadLogo(Landroid/content/pm/PackageManager;)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    .line 154
    :cond_4
    iget-boolean v6, p0, Lco/vine/android/widget/FakeActionBar;->mHomeButtonEnabled:Z

    if-eqz v6, :cond_7

    .line 155
    iget-object v6, p0, Lco/vine/android/widget/FakeActionBar;->mHomeIcon:Landroid/widget/ImageView;

    invoke-virtual {v6, v10}, Landroid/widget/ImageView;->setClickable(Z)V

    .line 156
    iget-object v6, p0, Lco/vine/android/widget/FakeActionBar;->mHomeIcon:Landroid/widget/ImageView;

    invoke-virtual {v6, p0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 157
    iget-object v6, p0, Lco/vine/android/widget/FakeActionBar;->mHomeIcon:Landroid/widget/ImageView;

    invoke-virtual {v6, v2}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 158
    iget-object v6, p0, Lco/vine/android/widget/FakeActionBar;->mHomeIcon:Landroid/widget/ImageView;

    invoke-virtual {v6, v9}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 165
    .end local v2    # "icon":Landroid/graphics/drawable/Drawable;
    .end local v4    # "theme":Landroid/content/res/Resources$Theme;
    :goto_2
    iget-object v6, p0, Lco/vine/android/widget/FakeActionBar;->mDisplayShowTitle:Ljava/lang/Boolean;

    invoke-virtual {v6}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v6

    if-eqz v6, :cond_9

    iget-object v6, p0, Lco/vine/android/widget/FakeActionBar;->mTitle:Ljava/lang/String;

    if-eqz v6, :cond_9

    .line 166
    iget-object v6, p0, Lco/vine/android/widget/FakeActionBar;->mTitleView:Landroid/widget/TextView;

    invoke-virtual {v6, v9}, Landroid/widget/TextView;->setVisibility(I)V

    .line 167
    iget-object v6, p0, Lco/vine/android/widget/FakeActionBar;->mTitleView:Landroid/widget/TextView;

    iget-object v7, p0, Lco/vine/android/widget/FakeActionBar;->mTitle:Ljava/lang/String;

    invoke-virtual {v6, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 171
    :goto_3
    return-void

    .line 128
    :cond_5
    const v6, 0x7f020013

    goto/16 :goto_0

    .line 134
    :cond_6
    iget-object v6, p0, Lco/vine/android/widget/FakeActionBar;->mBackIcon:Landroid/widget/ImageView;

    invoke-virtual {v6, v11}, Landroid/widget/ImageView;->setVisibility(I)V

    goto/16 :goto_1

    .line 160
    .restart local v2    # "icon":Landroid/graphics/drawable/Drawable;
    .restart local v4    # "theme":Landroid/content/res/Resources$Theme;
    :cond_7
    iget-object v6, p0, Lco/vine/android/widget/FakeActionBar;->mHomeIcon:Landroid/widget/ImageView;

    invoke-virtual {v6, v11}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_2

    .line 163
    .end local v2    # "icon":Landroid/graphics/drawable/Drawable;
    .end local v4    # "theme":Landroid/content/res/Resources$Theme;
    :cond_8
    iget-object v6, p0, Lco/vine/android/widget/FakeActionBar;->mHomeIcon:Landroid/widget/ImageView;

    invoke-virtual {v6, v11}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_2

    .line 169
    :cond_9
    iget-object v6, p0, Lco/vine/android/widget/FakeActionBar;->mTitleView:Landroid/widget/TextView;

    invoke-virtual {v6, v11}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_3
.end method

.method public onPrepareOptionsMenu(Landroid/view/Menu;Z)V
    .locals 0
    .param p1, "menu"    # Landroid/view/Menu;
    .param p2, "show"    # Z

    .prologue
    .line 259
    return-void
.end method

.method public setActionBarColor(I)V
    .locals 1
    .param p1, "color"    # I

    .prologue
    .line 65
    iget-object v0, p0, Lco/vine/android/widget/FakeActionBar;->mActionBar:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p1}, Landroid/widget/RelativeLayout;->setBackgroundColor(I)V

    .line 66
    return-void
.end method

.method public setActionBarTransition(Landroid/graphics/drawable/TransitionDrawable;)V
    .locals 1
    .param p1, "td"    # Landroid/graphics/drawable/TransitionDrawable;

    .prologue
    .line 69
    iget-object v0, p0, Lco/vine/android/widget/FakeActionBar;->mActionBar:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p1}, Landroid/widget/RelativeLayout;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 70
    return-void
.end method

.method public setContentView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;
    .param p2, "params"    # Landroid/view/ViewGroup$LayoutParams;

    .prologue
    .line 174
    iput-object p1, p0, Lco/vine/android/widget/FakeActionBar;->mContentView:Landroid/view/View;

    .line 175
    new-instance v0, Landroid/widget/RelativeLayout$LayoutParams;

    invoke-direct {v0, p2}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(Landroid/view/ViewGroup$LayoutParams;)V

    .line 176
    .local v0, "p":Landroid/widget/RelativeLayout$LayoutParams;
    invoke-virtual {p1, v0}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 177
    const/4 v1, 0x3

    iget-object v2, p0, Lco/vine/android/widget/FakeActionBar;->mDistanceMarker:Landroid/view/View;

    invoke-virtual {v2}, Landroid/view/View;->getId()I

    move-result v2

    invoke-virtual {v0, v1, v2}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(II)V

    .line 178
    iget-object v1, p0, Lco/vine/android/widget/FakeActionBar;->mActionBarContainer:Landroid/widget/RelativeLayout;

    iget-object v2, p0, Lco/vine/android/widget/FakeActionBar;->mContentView:Landroid/view/View;

    invoke-virtual {v1, v2}, Landroid/widget/RelativeLayout;->addView(Landroid/view/View;)V

    .line 179
    return-void
.end method

.method public setDisplayHomeAsUpEnabled(Ljava/lang/Boolean;)V
    .locals 1
    .param p1, "setDisplayHomeAsUpEnabled"    # Ljava/lang/Boolean;

    .prologue
    .line 206
    invoke-virtual {p1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    iput-boolean v0, p0, Lco/vine/android/widget/FakeActionBar;->mDisplayHomeAsUp:Z

    .line 207
    return-void
.end method

.method public setDisplayShowTitleEnabled(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "setDisplayShowTitleEnabled"    # Ljava/lang/Boolean;

    .prologue
    .line 202
    iput-object p1, p0, Lco/vine/android/widget/FakeActionBar;->mDisplayShowTitle:Ljava/lang/Boolean;

    .line 203
    return-void
.end method

.method public setHomeButtonEnabled(Ljava/lang/Boolean;)V
    .locals 1
    .param p1, "setHomeButtonEnabled"    # Ljava/lang/Boolean;

    .prologue
    .line 198
    invoke-virtual {p1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    iput-boolean v0, p0, Lco/vine/android/widget/FakeActionBar;->mHomeButtonEnabled:Z

    .line 199
    return-void
.end method

.method public setTheme(Lco/vine/android/widget/FakeActionBar$Theme;)V
    .locals 0
    .param p1, "theme"    # Lco/vine/android/widget/FakeActionBar$Theme;

    .prologue
    .line 98
    iput-object p1, p0, Lco/vine/android/widget/FakeActionBar;->mTheme:Lco/vine/android/widget/FakeActionBar$Theme;

    .line 99
    return-void
.end method

.method public setTitle(Ljava/lang/Integer;)V
    .locals 2
    .param p1, "titleRes"    # Ljava/lang/Integer;

    .prologue
    .line 214
    iget-object v0, p0, Lco/vine/android/widget/FakeActionBar;->mActivity:Landroid/support/v7/app/ActionBarActivity;

    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/support/v7/app/ActionBarActivity;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/widget/FakeActionBar;->mTitle:Ljava/lang/String;

    .line 215
    return-void
.end method

.method public setTitle(Ljava/lang/String;)V
    .locals 0
    .param p1, "title"    # Ljava/lang/String;

    .prologue
    .line 210
    iput-object p1, p0, Lco/vine/android/widget/FakeActionBar;->mTitle:Ljava/lang/String;

    .line 211
    return-void
.end method
