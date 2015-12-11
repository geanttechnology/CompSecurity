.class public Lcom/poshmark/ui/customviews/PMTabButton;
.super Lcom/poshmark/ui/customviews/PMButton;
.source "PMTabButton.java"


# instance fields
.field private badge:I

.field private clickEventString:Ljava/lang/String;

.field context:Landroid/content/Context;

.field defaultTabListener:Lcom/poshmark/ui/customviews/PMTabBar$PMTabListener;

.field fragmentClass:Ljava/lang/Class;

.field fragmentData:Landroid/os/Bundle;

.field private icon:Landroid/graphics/drawable/Drawable;

.field private mFragment:Lcom/poshmark/ui/fragments/RootTabFragment;

.field private parentContainerBar:Lcom/poshmark/ui/customviews/PMTabBar;

.field private selectedIcon:Landroid/graphics/drawable/Drawable;

.field tabListener:Lcom/poshmark/ui/customviews/PMTabBar$PMTabListener;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 43
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/poshmark/ui/customviews/PMButton;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 37
    const/4 v0, -0x1

    iput v0, p0, Lcom/poshmark/ui/customviews/PMTabButton;->badge:I

    .line 127
    new-instance v0, Lcom/poshmark/ui/customviews/PMTabButton$1;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/customviews/PMTabButton$1;-><init>(Lcom/poshmark/ui/customviews/PMTabButton;)V

    iput-object v0, p0, Lcom/poshmark/ui/customviews/PMTabButton;->defaultTabListener:Lcom/poshmark/ui/customviews/PMTabBar$PMTabListener;

    .line 44
    iput-object p1, p0, Lcom/poshmark/ui/customviews/PMTabButton;->context:Landroid/content/Context;

    .line 45
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 7
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v6, 0x0

    .line 48
    invoke-direct {p0, p1, p2}, Lcom/poshmark/ui/customviews/PMButton;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 37
    const/4 v3, -0x1

    iput v3, p0, Lcom/poshmark/ui/customviews/PMTabButton;->badge:I

    .line 127
    new-instance v3, Lcom/poshmark/ui/customviews/PMTabButton$1;

    invoke-direct {v3, p0}, Lcom/poshmark/ui/customviews/PMTabButton$1;-><init>(Lcom/poshmark/ui/customviews/PMTabButton;)V

    iput-object v3, p0, Lcom/poshmark/ui/customviews/PMTabButton;->defaultTabListener:Lcom/poshmark/ui/customviews/PMTabBar$PMTabListener;

    .line 49
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMTabButton;->getContext()Landroid/content/Context;

    move-result-object v3

    sget-object v4, Lcom/poshmark/app/R$styleable;->PMTabButton:[I

    invoke-virtual {v3, p2, v4}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 50
    .local v0, "array":Landroid/content/res/TypedArray;
    const/4 v3, 0x1

    invoke-virtual {v0, v3}, Landroid/content/res/TypedArray;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 51
    .local v1, "iconStr":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 52
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const-string v4, "drawable"

    invoke-virtual {p1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v1, v4, v5}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v2

    .line 53
    .local v2, "id":I
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMTabButton;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-virtual {v3, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v3

    iput-object v3, p0, Lcom/poshmark/ui/customviews/PMTabButton;->icon:Landroid/graphics/drawable/Drawable;

    .line 56
    .end local v2    # "id":I
    :cond_0
    const/4 v3, 0x2

    invoke-virtual {v0, v3}, Landroid/content/res/TypedArray;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 57
    if-eqz v1, :cond_1

    .line 58
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const-string v4, "drawable"

    invoke-virtual {p1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v1, v4, v5}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v2

    .line 59
    .restart local v2    # "id":I
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMTabButton;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-virtual {v3, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v3

    iput-object v3, p0, Lcom/poshmark/ui/customviews/PMTabButton;->selectedIcon:Landroid/graphics/drawable/Drawable;

    .line 62
    .end local v2    # "id":I
    :cond_1
    const/4 v3, 0x3

    invoke-virtual {v0, v3}, Landroid/content/res/TypedArray;->getString(I)Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/poshmark/ui/customviews/PMTabButton;->clickEventString:Ljava/lang/String;

    .line 65
    iget-object v3, p0, Lcom/poshmark/ui/customviews/PMTabButton;->icon:Landroid/graphics/drawable/Drawable;

    invoke-virtual {p0, v6, v3, v6, v6}, Lcom/poshmark/ui/customviews/PMTabButton;->setCompoundDrawablesWithIntrinsicBounds(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    .line 67
    iget-object v3, p0, Lcom/poshmark/ui/customviews/PMTabButton;->defaultTabListener:Lcom/poshmark/ui/customviews/PMTabBar$PMTabListener;

    iput-object v3, p0, Lcom/poshmark/ui/customviews/PMTabButton;->tabListener:Lcom/poshmark/ui/customviews/PMTabBar$PMTabListener;

    .line 68
    return-void
.end method


# virtual methods
.method public clearBadge()V
    .locals 1

    .prologue
    .line 154
    const/4 v0, -0x1

    iput v0, p0, Lcom/poshmark/ui/customviews/PMTabButton;->badge:I

    .line 155
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMTabButton;->postInvalidate()V

    .line 156
    return-void
.end method

.method public collapseFragmentStack()V
    .locals 1

    .prologue
    .line 205
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMTabButton;->mFragment:Lcom/poshmark/ui/fragments/RootTabFragment;

    if-eqz v0, :cond_0

    .line 206
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMTabButton;->mFragment:Lcom/poshmark/ui/fragments/RootTabFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/RootTabFragment;->collapseAllSubfragments()V

    .line 208
    :cond_0
    return-void
.end method

.method public detachFragmentFromTabButton()V
    .locals 1

    .prologue
    .line 201
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/ui/customviews/PMTabButton;->mFragment:Lcom/poshmark/ui/fragments/RootTabFragment;

    .line 202
    return-void
.end method

.method public getClickEventString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 159
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMTabButton;->clickEventString:Ljava/lang/String;

    return-object v0
.end method

.method public getFragment()Lcom/poshmark/ui/fragments/RootTabFragment;
    .locals 1

    .prologue
    .line 124
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMTabButton;->mFragment:Lcom/poshmark/ui/fragments/RootTabFragment;

    return-object v0
.end method

.method public getTabListener()Lcom/poshmark/ui/customviews/PMTabBar$PMTabListener;
    .locals 1

    .prologue
    .line 81
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMTabButton;->tabListener:Lcom/poshmark/ui/customviews/PMTabBar$PMTabListener;

    return-object v0
.end method

.method public hideFragment(Lcom/poshmark/ui/PMActivity;)V
    .locals 3
    .param p1, "activity"    # Lcom/poshmark/ui/PMActivity;

    .prologue
    .line 108
    iget-object v2, p0, Lcom/poshmark/ui/customviews/PMTabButton;->mFragment:Lcom/poshmark/ui/fragments/RootTabFragment;

    if-eqz v2, :cond_0

    .line 109
    invoke-virtual {p1}, Lcom/poshmark/ui/PMActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    .line 110
    .local v0, "fm":Landroid/support/v4/app/FragmentManager;
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v1

    .line 112
    .local v1, "transaction":Landroid/support/v4/app/FragmentTransaction;
    iget-object v2, p0, Lcom/poshmark/ui/customviews/PMTabButton;->mFragment:Lcom/poshmark/ui/fragments/RootTabFragment;

    invoke-virtual {v1, v2}, Landroid/support/v4/app/FragmentTransaction;->detach(Landroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    .line 113
    iget-object v2, p0, Lcom/poshmark/ui/customviews/PMTabButton;->mFragment:Lcom/poshmark/ui/fragments/RootTabFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/RootTabFragment;->isStateSavingCompleted()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 114
    invoke-virtual {v1}, Landroid/support/v4/app/FragmentTransaction;->commitAllowingStateLoss()I

    .line 118
    :goto_0
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->executePendingTransactions()Z

    .line 121
    .end local v0    # "fm":Landroid/support/v4/app/FragmentManager;
    .end local v1    # "transaction":Landroid/support/v4/app/FragmentTransaction;
    :cond_0
    return-void

    .line 116
    .restart local v0    # "fm":Landroid/support/v4/app/FragmentManager;
    .restart local v1    # "transaction":Landroid/support/v4/app/FragmentTransaction;
    :cond_1
    invoke-virtual {v1}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    goto :goto_0
.end method

.method public launchFragment(Lcom/poshmark/ui/PMActivity;)V
    .locals 5
    .param p1, "activity"    # Lcom/poshmark/ui/PMActivity;

    .prologue
    .line 85
    invoke-virtual {p1}, Lcom/poshmark/ui/PMActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    .line 86
    .local v1, "fm":Landroid/support/v4/app/FragmentManager;
    invoke-virtual {v1}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v2

    .line 88
    .local v2, "transaction":Landroid/support/v4/app/FragmentTransaction;
    iget-object v3, p0, Lcom/poshmark/ui/customviews/PMTabButton;->mFragment:Lcom/poshmark/ui/fragments/RootTabFragment;

    if-nez v3, :cond_1

    .line 89
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 90
    .local v0, "b":Landroid/os/Bundle;
    const-string v3, "FRAGMENT_CLASS"

    iget-object v4, p0, Lcom/poshmark/ui/customviews/PMTabButton;->fragmentClass:Ljava/lang/Class;

    invoke-virtual {v4}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 91
    const-string v3, "FRAGMENT_DATA"

    iget-object v4, p0, Lcom/poshmark/ui/customviews/PMTabButton;->fragmentData:Landroid/os/Bundle;

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putBundle(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 92
    const-class v3, Lcom/poshmark/ui/fragments/RootTabFragment;

    invoke-virtual {v3}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-static {p1, v3, v0}, Landroid/support/v4/app/Fragment;->instantiate(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)Landroid/support/v4/app/Fragment;

    move-result-object v3

    check-cast v3, Lcom/poshmark/ui/fragments/RootTabFragment;

    iput-object v3, p0, Lcom/poshmark/ui/customviews/PMTabButton;->mFragment:Lcom/poshmark/ui/fragments/RootTabFragment;

    .line 93
    const v3, 0x7f0c0049

    iget-object v4, p0, Lcom/poshmark/ui/customviews/PMTabButton;->mFragment:Lcom/poshmark/ui/fragments/RootTabFragment;

    invoke-virtual {v2, v3, v4}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    .line 100
    .end local v0    # "b":Landroid/os/Bundle;
    :cond_0
    :goto_0
    invoke-virtual {v2}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 101
    invoke-virtual {v1}, Landroid/support/v4/app/FragmentManager;->executePendingTransactions()Z

    .line 104
    iget-object v3, p0, Lcom/poshmark/ui/customviews/PMTabButton;->mFragment:Lcom/poshmark/ui/fragments/RootTabFragment;

    invoke-virtual {v3, p0}, Lcom/poshmark/ui/fragments/RootTabFragment;->attachTabButton(Lcom/poshmark/ui/customviews/PMTabButton;)V

    .line 105
    return-void

    .line 97
    :cond_1
    iget-object v3, p0, Lcom/poshmark/ui/customviews/PMTabButton;->mFragment:Lcom/poshmark/ui/fragments/RootTabFragment;

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/RootTabFragment;->isAdded()Z

    move-result v3

    if-nez v3, :cond_0

    .line 98
    iget-object v3, p0, Lcom/poshmark/ui/customviews/PMTabButton;->mFragment:Lcom/poshmark/ui/fragments/RootTabFragment;

    invoke-virtual {v2, v3}, Landroid/support/v4/app/FragmentTransaction;->attach(Landroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    goto :goto_0
.end method

.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 12
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    const/4 v11, 0x0

    const/high16 v10, 0x40000000    # 2.0f

    const/4 v9, 0x1

    .line 163
    invoke-super {p0, p1}, Lcom/poshmark/ui/customviews/PMButton;->onDraw(Landroid/graphics/Canvas;)V

    .line 166
    iget v6, p0, Lcom/poshmark/ui/customviews/PMTabButton;->badge:I

    if-lez v6, :cond_2

    .line 167
    new-instance v2, Landroid/graphics/Paint;

    invoke-direct {v2}, Landroid/graphics/Paint;-><init>()V

    .line 168
    .local v2, "paint":Landroid/graphics/Paint;
    const-string v6, "%d"

    new-array v7, v9, [Ljava/lang/Object;

    iget v8, p0, Lcom/poshmark/ui/customviews/PMTabButton;->badge:I

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v7, v11

    invoke-static {v6, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 169
    .local v0, "badgeString":Ljava/lang/String;
    sget-object v6, Landroid/graphics/Paint$Align;->CENTER:Landroid/graphics/Paint$Align;

    invoke-virtual {v2, v6}, Landroid/graphics/Paint;->setTextAlign(Landroid/graphics/Paint$Align;)V

    .line 170
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMTabButton;->getContext()Landroid/content/Context;

    move-result-object v6

    const/high16 v7, 0x41600000    # 14.0f

    invoke-static {v6, v7}, Lcom/poshmark/utils/ViewUtils;->dipToPixels(Landroid/content/Context;F)F

    move-result v6

    float-to-int v6, v6

    int-to-float v6, v6

    invoke-virtual {v2, v6}, Landroid/graphics/Paint;->setTextSize(F)V

    .line 171
    iget v6, p0, Lcom/poshmark/ui/customviews/PMTabButton;->badge:I

    const/16 v7, 0x63

    if-le v6, v7, :cond_0

    .line 172
    const-string v0, "99+"

    .line 173
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMTabButton;->getContext()Landroid/content/Context;

    move-result-object v6

    const/high16 v7, 0x41400000    # 12.0f

    invoke-static {v6, v7}, Lcom/poshmark/utils/ViewUtils;->dipToPixels(Landroid/content/Context;F)F

    move-result v6

    float-to-int v6, v6

    int-to-float v6, v6

    invoke-virtual {v2, v6}, Landroid/graphics/Paint;->setTextSize(F)V

    .line 174
    const-string v6, "sans-serif"

    invoke-static {v6, v9}, Landroid/graphics/Typeface;->create(Ljava/lang/String;I)Landroid/graphics/Typeface;

    move-result-object v6

    invoke-virtual {v2, v6}, Landroid/graphics/Paint;->setTypeface(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;

    .line 180
    :cond_0
    new-instance v3, Landroid/graphics/Rect;

    invoke-direct {v3}, Landroid/graphics/Rect;-><init>()V

    .line 181
    .local v3, "size":Landroid/graphics/Rect;
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v6

    invoke-virtual {v2, v0, v11, v6, v3}, Landroid/graphics/Paint;->getTextBounds(Ljava/lang/String;IILandroid/graphics/Rect;)V

    .line 182
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMTabButton;->getContext()Landroid/content/Context;

    move-result-object v6

    const/high16 v7, 0x41b00000    # 22.0f

    invoke-static {v6, v7}, Lcom/poshmark/utils/ViewUtils;->dipToPixels(Landroid/content/Context;F)F

    move-result v1

    .line 183
    .local v1, "dimension":F
    invoke-virtual {v3}, Landroid/graphics/Rect;->width()I

    move-result v6

    int-to-float v6, v6

    cmpl-float v6, v6, v1

    if-lez v6, :cond_1

    .line 184
    invoke-virtual {v3}, Landroid/graphics/Rect;->width()I

    move-result v6

    add-int/lit8 v6, v6, 0xa

    int-to-float v1, v6

    .line 186
    :cond_1
    invoke-virtual {v2, v9}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    .line 187
    const/high16 v6, -0x10000

    invoke-virtual {v2, v6}, Landroid/graphics/Paint;->setColor(I)V

    .line 189
    div-float v6, v1, v10

    const/high16 v7, 0x40a00000    # 5.0f

    add-float v5, v6, v7

    .line 190
    .local v5, "yPos":F
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMTabButton;->getWidth()I

    move-result v6

    int-to-float v6, v6

    sub-float/2addr v6, v1

    div-float v7, v1, v10

    invoke-virtual {p1, v6, v5, v7, v2}, Landroid/graphics/Canvas;->drawCircle(FFFLandroid/graphics/Paint;)V

    .line 192
    const/4 v6, -0x1

    invoke-virtual {v2, v6}, Landroid/graphics/Paint;->setColor(I)V

    .line 194
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMTabButton;->getWidth()I

    move-result v6

    float-to-int v7, v1

    sub-int v4, v6, v7

    .line 195
    .local v4, "xPos":I
    invoke-virtual {v3}, Landroid/graphics/Rect;->height()I

    move-result v6

    div-int/lit8 v6, v6, 0x2

    int-to-float v6, v6

    add-float/2addr v5, v6

    .line 196
    int-to-float v6, v4

    invoke-virtual {p1, v0, v6, v5, v2}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 198
    .end local v0    # "badgeString":Ljava/lang/String;
    .end local v1    # "dimension":F
    .end local v2    # "paint":Landroid/graphics/Paint;
    .end local v3    # "size":Landroid/graphics/Rect;
    .end local v4    # "xPos":I
    .end local v5    # "yPos":F
    :cond_2
    return-void
.end method

.method public setBadge(I)V
    .locals 0
    .param p1, "badge"    # I

    .prologue
    .line 149
    iput p1, p0, Lcom/poshmark/ui/customviews/PMTabButton;->badge:I

    .line 150
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMTabButton;->postInvalidate()V

    .line 151
    return-void
.end method

.method public setFragmentToLaunch(Ljava/lang/Class;Landroid/os/Bundle;)V
    .locals 0
    .param p1, "fragmentClass"    # Ljava/lang/Class;
    .param p2, "bundle"    # Landroid/os/Bundle;

    .prologue
    .line 71
    iput-object p1, p0, Lcom/poshmark/ui/customviews/PMTabButton;->fragmentClass:Ljava/lang/Class;

    .line 72
    iput-object p2, p0, Lcom/poshmark/ui/customviews/PMTabButton;->fragmentData:Landroid/os/Bundle;

    .line 73
    return-void
.end method

.method public setParentTabBar(Lcom/poshmark/ui/customviews/PMTabBar;)V
    .locals 0
    .param p1, "pmTabBar"    # Lcom/poshmark/ui/customviews/PMTabBar;

    .prologue
    .line 211
    iput-object p1, p0, Lcom/poshmark/ui/customviews/PMTabButton;->parentContainerBar:Lcom/poshmark/ui/customviews/PMTabBar;

    .line 212
    return-void
.end method

.method public setSelected(Z)V
    .locals 3
    .param p1, "selected"    # Z

    .prologue
    const/4 v2, 0x0

    .line 138
    if-eqz p1, :cond_0

    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMTabButton;->selectedIcon:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_0

    .line 139
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMTabButton;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f090040

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/customviews/PMTabButton;->setTextColor(I)V

    .line 140
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMTabButton;->selectedIcon:Landroid/graphics/drawable/Drawable;

    invoke-virtual {p0, v2, v0, v2, v2}, Lcom/poshmark/ui/customviews/PMTabButton;->setCompoundDrawablesWithIntrinsicBounds(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    .line 146
    :goto_0
    return-void

    .line 143
    :cond_0
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMTabButton;->icon:Landroid/graphics/drawable/Drawable;

    invoke-virtual {p0, v2, v0, v2, v2}, Lcom/poshmark/ui/customviews/PMTabButton;->setCompoundDrawablesWithIntrinsicBounds(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    .line 144
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMTabButton;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f09003e

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/customviews/PMTabButton;->setTextColor(I)V

    goto :goto_0
.end method

.method public setTabListener(Lcom/poshmark/ui/customviews/PMTabBar$PMTabListener;)V
    .locals 0
    .param p1, "tabListener"    # Lcom/poshmark/ui/customviews/PMTabBar$PMTabListener;

    .prologue
    .line 77
    iput-object p1, p0, Lcom/poshmark/ui/customviews/PMTabButton;->tabListener:Lcom/poshmark/ui/customviews/PMTabBar$PMTabListener;

    .line 78
    return-void
.end method
