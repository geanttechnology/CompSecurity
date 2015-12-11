.class public Lcom/amazon/rio/j2me/client/services/mShop/ProductWarning;
.super Ljava/lang/Object;
.source "ProductWarning.java"


# instance fields
.field private header:Ljava/lang/String;

.field private headerColor:Ljava/lang/Integer;

.field private icon:[B

.field private imageUrl:Ljava/lang/String;

.field private message:Ljava/lang/String;

.field private prominent:Z

.field private url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public setHeader(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 31
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductWarning;->header:Ljava/lang/String;

    .line 32
    return-void
.end method

.method public setHeaderColor(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Integer;

    .prologue
    .line 44
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductWarning;->headerColor:Ljava/lang/Integer;

    .line 45
    return-void
.end method

.method public setIcon([B)V
    .locals 0
    .param p1, "value_"    # [B

    .prologue
    .line 106
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductWarning;->icon:[B

    .line 107
    return-void
.end method

.method public setImageUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 93
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductWarning;->imageUrl:Ljava/lang/String;

    .line 94
    return-void
.end method

.method public setMessage(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 57
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductWarning;->message:Ljava/lang/String;

    .line 58
    return-void
.end method

.method public setProminent(Z)V
    .locals 0
    .param p1, "value_"    # Z

    .prologue
    .line 67
    iput-boolean p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductWarning;->prominent:Z

    .line 68
    return-void
.end method

.method public setUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 80
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductWarning;->url:Ljava/lang/String;

    .line 81
    return-void
.end method
