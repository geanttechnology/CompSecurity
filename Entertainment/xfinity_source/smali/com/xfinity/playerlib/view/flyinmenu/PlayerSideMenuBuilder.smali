.class public Lcom/xfinity/playerlib/view/flyinmenu/PlayerSideMenuBuilder;
.super Ljava/lang/Object;
.source "PlayerSideMenuBuilder.java"

# interfaces
.implements Lcom/comcast/cim/android/sideribbon/SideMenuBuilder;


# instance fields
.field private adapters:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuAdapter;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 5
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 23
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    iput-object v2, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayerSideMenuBuilder;->adapters:Ljava/util/List;

    .line 25
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v2

    invoke-virtual {v2}, Lcom/comcast/cim/container/PlayerContainer;->getConfiguration()Lcom/xfinity/playerlib/config/PlayerConfiguration;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/config/PlayerConfiguration;->getFlyinMenuOptions()Ljava/util/List;

    move-result-object v0

    .line 26
    .local v0, "flyinMenuGroups":Ljava/util/List;, "Ljava/util/List<Ljava/util/List<Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;>;>;"
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 27
    .local v1, "menuGroup":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;>;"
    iget-object v3, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayerSideMenuBuilder;->adapters:Ljava/util/List;

    new-instance v4, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuAdapter;

    invoke-direct {v4, p1, v1}, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuAdapter;-><init>(Landroid/content/Context;Ljava/util/List;)V

    invoke-interface {v3, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 29
    .end local v1    # "menuGroup":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;>;"
    :cond_0
    return-void
.end method

.method private inflateMenuGroup(Landroid/app/Activity;Landroid/view/ViewGroup;Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuAdapter;Lcom/comcast/cim/android/sideribbon/SlideClosedRequestListener;)V
    .locals 9
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "adapter"    # Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuAdapter;
    .param p4, "slideClosedRequestListener"    # Lcom/comcast/cim/android/sideribbon/SlideClosedRequestListener;

    .prologue
    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 51
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    invoke-virtual {p3}, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuAdapter;->getCount()I

    move-result v5

    if-le v5, v1, :cond_2

    .line 53
    invoke-virtual {p3, v1}, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuAdapter;->getItem(I)Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

    move-result-object v2

    .line 55
    .local v2, "item":Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;
    const/4 v5, 0x0

    invoke-virtual {p3, v1, v5, p2}, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v4

    .local v4, "view":Landroid/view/View;
    move-object v5, v4

    .line 57
    check-cast v5, Landroid/view/ViewGroup;

    invoke-virtual {v5}, Landroid/view/ViewGroup;->getChildCount()I

    move-result v0

    .line 58
    .local v0, "count":I
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v5

    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;->getActivity()Ljava/lang/Class;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_0

    .line 59
    new-instance v5, Lcom/xfinity/playerlib/view/flyinmenu/PlayerSideMenuBuilder$1;

    invoke-direct {v5, p0, p4, v2, p1}, Lcom/xfinity/playerlib/view/flyinmenu/PlayerSideMenuBuilder$1;-><init>(Lcom/xfinity/playerlib/view/flyinmenu/PlayerSideMenuBuilder;Lcom/comcast/cim/android/sideribbon/SlideClosedRequestListener;Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;Landroid/app/Activity;)V

    invoke-virtual {v4, v5}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    move-object v5, v4

    .line 66
    check-cast v5, Landroid/widget/Checkable;

    invoke-interface {v5, v7}, Landroid/widget/Checkable;->setChecked(Z)V

    .line 67
    const/4 v3, 0x0

    .local v3, "j":I
    :goto_1
    if-ge v3, v0, :cond_1

    move-object v5, v4

    .line 68
    check-cast v5, Landroid/view/ViewGroup;

    invoke-virtual {v5, v3}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v5

    invoke-virtual {v5, v7}, Landroid/view/View;->setSelected(Z)V

    .line 67
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 71
    .end local v3    # "j":I
    :cond_0
    new-instance v5, Lcom/xfinity/playerlib/view/flyinmenu/PlayerSideMenuBuilder$2;

    invoke-direct {v5, p0, p4}, Lcom/xfinity/playerlib/view/flyinmenu/PlayerSideMenuBuilder$2;-><init>(Lcom/xfinity/playerlib/view/flyinmenu/PlayerSideMenuBuilder;Lcom/comcast/cim/android/sideribbon/SlideClosedRequestListener;)V

    invoke-virtual {v4, v5}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    move-object v5, v4

    .line 77
    check-cast v5, Landroid/widget/Checkable;

    invoke-interface {v5, v8}, Landroid/widget/Checkable;->setChecked(Z)V

    .line 78
    const/4 v3, 0x0

    .restart local v3    # "j":I
    :goto_2
    if-ge v3, v0, :cond_1

    move-object v5, v4

    .line 79
    check-cast v5, Landroid/view/ViewGroup;

    invoke-virtual {v5, v3}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v5

    invoke-virtual {v5, v8}, Landroid/view/View;->setSelected(Z)V

    .line 78
    add-int/lit8 v3, v3, 0x1

    goto :goto_2

    .line 83
    :cond_1
    invoke-virtual {p2, v4}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 51
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 85
    .end local v0    # "count":I
    .end local v2    # "item":Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;
    .end local v3    # "j":I
    .end local v4    # "view":Landroid/view/View;
    :cond_2
    return-void
.end method


# virtual methods
.method public build(Landroid/app/Activity;Landroid/view/ViewGroup;Lcom/comcast/cim/android/sideribbon/SlideClosedRequestListener;)Landroid/view/View;
    .locals 8
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "rootView"    # Landroid/view/ViewGroup;
    .param p3, "slideClosedRequestListener"    # Lcom/comcast/cim/android/sideribbon/SlideClosedRequestListener;

    .prologue
    .line 33
    invoke-virtual {p1}, Landroid/app/Activity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v4

    sget v5, Lcom/xfinity/playerlib/R$layout;->flyin_menu:I

    const/4 v6, 0x0

    invoke-virtual {v4, v5, p2, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/view/ViewGroup;

    .line 35
    .local v3, "layout":Landroid/view/ViewGroup;
    sget v4, Lcom/xfinity/playerlib/R$id;->flyin_menu_groups:I

    invoke-virtual {v3, v4}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    .line 37
    .local v1, "flyinMenuGroups":Landroid/widget/LinearLayout;
    iget-object v4, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayerSideMenuBuilder;->adapters:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuAdapter;

    .line 39
    .local v0, "adapter":Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuAdapter;
    new-instance v2, Landroid/widget/LinearLayout;

    invoke-direct {v2, p1}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 40
    .local v2, "groupContainer":Landroid/widget/LinearLayout;
    const/4 v5, 0x1

    invoke-virtual {v2, v5}, Landroid/widget/LinearLayout;->setOrientation(I)V

    .line 41
    new-instance v5, Landroid/widget/LinearLayout$LayoutParams;

    const/4 v6, -0x1

    const/4 v7, -0x2

    invoke-direct {v5, v6, v7}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    invoke-virtual {v2, v5}, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 42
    invoke-direct {p0, p1, v2, v0, p3}, Lcom/xfinity/playerlib/view/flyinmenu/PlayerSideMenuBuilder;->inflateMenuGroup(Landroid/app/Activity;Landroid/view/ViewGroup;Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuAdapter;Lcom/comcast/cim/android/sideribbon/SlideClosedRequestListener;)V

    .line 44
    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    goto :goto_0

    .line 47
    .end local v0    # "adapter":Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuAdapter;
    .end local v2    # "groupContainer":Landroid/widget/LinearLayout;
    :cond_0
    return-object v3
.end method
