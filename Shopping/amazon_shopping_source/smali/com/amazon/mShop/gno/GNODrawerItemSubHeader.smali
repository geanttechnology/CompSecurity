.class public Lcom/amazon/mShop/gno/GNODrawerItemSubHeader;
.super Lcom/amazon/mShop/gno/GNODrawerItemSimple;
.source "GNODrawerItemSubHeader.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;
    }
.end annotation


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "id"    # Ljava/lang/String;

    .prologue
    .line 19
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 20
    return-void
.end method

.method public static builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "id"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/lang/String;",
            ")",
            "Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder",
            "<*>;"
        }
    .end annotation

    .prologue
    .line 41
    new-instance v0, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;

    invoke-direct {v0, p0, p1}, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    return-object v0
.end method


# virtual methods
.method public allowDividers()Z
    .locals 1

    .prologue
    .line 36
    const/4 v0, 0x0

    return v0
.end method

.method public getView(Landroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 4
    .param p1, "convertView"    # Landroid/view/View;
    .param p2, "root"    # Landroid/view/ViewGroup;

    .prologue
    .line 27
    invoke-super {p0, p1, p2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->getView(Landroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    .line 28
    .local v1, "view":Landroid/view/View;
    sget v2, Lcom/amazon/mShop/android/lib/R$id;->drawer_item_title:I

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 29
    .local v0, "titleView":Landroid/widget/TextView;
    invoke-virtual {v0}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mShop/platform/AppLocale;->getCurrentLocale()Ljava/util/Locale;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->toUpperCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 31
    return-object v1
.end method
