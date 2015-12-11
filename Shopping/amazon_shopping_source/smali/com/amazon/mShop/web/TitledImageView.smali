.class public Lcom/amazon/mShop/web/TitledImageView;
.super Landroid/widget/ImageView;
.source "TitledImageView.java"

# interfaces
.implements Lcom/amazon/mShop/TitleProvider;


# instance fields
.field mTitle:Ljava/lang/CharSequence;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 13
    invoke-direct {p0, p1}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V

    .line 10
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/web/TitledImageView;->mTitle:Ljava/lang/CharSequence;

    .line 14
    return-void
.end method


# virtual methods
.method public getTitle()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 18
    iget-object v0, p0, Lcom/amazon/mShop/web/TitledImageView;->mTitle:Ljava/lang/CharSequence;

    return-object v0
.end method

.method public setTitle(Ljava/lang/CharSequence;)V
    .locals 0
    .param p1, "title"    # Ljava/lang/CharSequence;

    .prologue
    .line 22
    iput-object p1, p0, Lcom/amazon/mShop/web/TitledImageView;->mTitle:Ljava/lang/CharSequence;

    .line 23
    return-void
.end method
