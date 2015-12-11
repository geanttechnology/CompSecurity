.class public Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuAdapter;
.super Landroid/widget/BaseAdapter;
.source "FlyinMenuAdapter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuAdapter$Holder;
    }
.end annotation


# instance fields
.field private context:Landroid/content/Context;

.field private menuItems:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/util/List;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 23
    .local p2, "menuItems":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;>;"
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 24
    iput-object p1, p0, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuAdapter;->context:Landroid/content/Context;

    .line 25
    iput-object p2, p0, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuAdapter;->menuItems:Ljava/util/List;

    .line 26
    return-void
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuAdapter;->menuItems:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public getItem(I)Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;
    .locals 1
    .param p1, "i"    # I

    .prologue
    .line 60
    iget-object v0, p0, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuAdapter;->menuItems:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

    return-object v0
.end method

.method public bridge synthetic getItem(I)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 13
    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuAdapter;->getItem(I)Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "i"    # I

    .prologue
    .line 65
    int-to-long v0, p1

    return-wide v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 6
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    const/4 v5, 0x0

    .line 32
    if-nez p2, :cond_0

    .line 34
    iget-object v2, p0, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuAdapter;->context:Landroid/content/Context;

    const-string v3, "layout_inflater"

    invoke-virtual {v2, v3}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/view/LayoutInflater;

    .line 35
    .local v1, "layoutInflater":Landroid/view/LayoutInflater;
    sget v2, Lcom/xfinity/playerlib/R$layout;->flyin_menu_list_item:I

    invoke-virtual {v1, v2, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p2

    .line 37
    new-instance v0, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuAdapter$Holder;

    invoke-direct {v0, v5}, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuAdapter$Holder;-><init>(Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuAdapter$1;)V

    .line 38
    .local v0, "holder":Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuAdapter$Holder;
    sget v2, Lcom/xfinity/playerlib/R$id;->text1:I

    invoke-virtual {p2, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, v0, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuAdapter$Holder;->menuImageAndCaption:Landroid/widget/TextView;

    .line 39
    invoke-virtual {p2, v0}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 45
    .end local v1    # "layoutInflater":Landroid/view/LayoutInflater;
    :goto_0
    iget-object v3, v0, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuAdapter$Holder;->menuImageAndCaption:Landroid/widget/TextView;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuAdapter;->menuItems:Ljava/util/List;

    invoke-interface {v2, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

    iget-object v4, p0, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuAdapter;->context:Landroid/content/Context;

    invoke-virtual {v2, v4}, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;->getCaption(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v3, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 46
    iget-object v3, v0, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuAdapter$Holder;->menuImageAndCaption:Landroid/widget/TextView;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuAdapter;->menuItems:Ljava/util/List;

    .line 47
    invoke-interface {v2, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

    iget-object v4, p0, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuAdapter;->context:Landroid/content/Context;

    invoke-virtual {v2, v4}, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;->getDrawable(Landroid/content/Context;)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    .line 46
    invoke-virtual {v3, v2, v5, v5, v5}, Landroid/widget/TextView;->setCompoundDrawablesWithIntrinsicBounds(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    .line 49
    return-object p2

    .line 42
    .end local v0    # "holder":Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuAdapter$Holder;
    :cond_0
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuAdapter$Holder;

    .restart local v0    # "holder":Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuAdapter$Holder;
    goto :goto_0
.end method
