.class public Lcom/amazon/rio/j2me/client/services/mShop/InvoiceCategory;
.super Ljava/lang/Object;
.source "InvoiceCategory.java"


# instance fields
.field private categoryId:I

.field private categoryName:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public setCategoryId(I)V
    .locals 0
    .param p1, "value_"    # I

    .prologue
    .line 23
    iput p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/InvoiceCategory;->categoryId:I

    .line 24
    return-void
.end method

.method public setCategoryName(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 33
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/InvoiceCategory;->categoryName:Ljava/lang/String;

    .line 34
    return-void
.end method
